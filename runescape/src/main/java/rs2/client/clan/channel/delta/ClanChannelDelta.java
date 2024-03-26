package rs2.client.clan.channel.delta;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.delta.AddUser;
import rs2.client.clan.channel.delta.DeleteUser;
import rs2.client.clan.channel.delta.DeltaEntry;
import rs2.client.clan.channel.delta.UpdateBaseSettings;
import rs2.client.clan.channel.delta.UpdateUserDetails;

@OriginalClass("client!ck")
public final class ClanChannelDelta {

    @OriginalMember(owner = "client!ck", name = "f", descriptor = "J")
    public long clanHash;

    @OriginalMember(owner = "client!ck", name = "d", descriptor = "J")
    public long updateNum = -1L;

    @OriginalMember(owner = "client!ck", name = "h", descriptor = "Lclient!sia;")
    public final Deque entries = new Deque();

    @OriginalMember(owner = "client!ck", name = "<init>", descriptor = "(Lclient!ge;)V")
    public ClanChannelDelta(@OriginalArg(0) Packet packet) {
        this.decode(packet);
    }

    @OriginalMember(owner = "client!ck", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        this.clanHash = packet.g8();
        this.updateNum = packet.g8();

        for (@Pc(21) int type = packet.g1(); type != 0; type = packet.g1()) {
            @Pc(44) DeltaEntry entry;
            if (type == 1) {
                entry = new AddUser();
            } else if (type == 4) {
                entry = new UpdateBaseSettings();
            } else if (type == 3) {
                entry = new DeleteUser();
            } else if (type == 2) {
                entry = new UpdateUserDetails();
            } else {
                throw new RuntimeException("Unrecognised ClanChannelDelta type in decode()");
            }

            entry.decode(packet);
            this.entries.addLast(entry);
        }
    }

    @OriginalMember(owner = "client!ck", name = "a", descriptor = "(Lclient!rfa;Z)V")
    public void applyToClanChannel(@OriginalArg(0) ClanChannel channel) {
        if (channel.key != this.clanHash || this.updateNum != channel.updateNum) {
            throw new RuntimeException("ClanChannelDelta.applyToClanChannel(): Credentials do not match! cc.clanHash:" + channel.key + " updateNum:" + channel.updateNum + " delta.clanHash:" + this.clanHash + " updateNum:" + this.updateNum);
        }
        for (@Pc(69) DeltaEntry entry = (DeltaEntry) this.entries.first(); entry != null; entry = (DeltaEntry) this.entries.next()) {
            entry.applyTo(channel);
        }
        channel.updateNum++;
    }
}
