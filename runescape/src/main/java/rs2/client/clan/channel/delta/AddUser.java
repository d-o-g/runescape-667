package rs2.client.clan.channel.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.ClanChannelUser;

@OriginalClass("client!jb")
public final class AddUser extends DeltaEntry {

    @OriginalMember(owner = "client!jb", name = "s", descriptor = "B")
    public byte rank;

    @OriginalMember(owner = "client!jb", name = "A", descriptor = "I")
    public int world;

    @OriginalMember(owner = "client!jb", name = "u", descriptor = "Ljava/lang/String;")
    public String name = null;

    @OriginalMember(owner = "client!jb", name = "D", descriptor = "J")
    public long hash = -1L;

    @OriginalMember(owner = "client!jb", name = "a", descriptor = "(Lclient!rfa;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanChannel channel) {
        @Pc(7) ClanChannelUser user = new ClanChannelUser();
        user.world = this.world;
        user.rank = this.rank;
        user.displayName = this.name;
        channel.addUser(user);
    }

    @OriginalMember(owner = "client!jb", name = "a", descriptor = "(Lclient!ge;I)V")
    @Override
    public void decode(@OriginalArg(0) Packet packet) {
        if (packet.g1() != 255) {
            packet.pos--;
            this.hash = packet.g8();
        }

        this.name = packet.fastgstr();
        this.world = packet.g2();
        this.rank = packet.g1b();
        packet.g8();

        if (ClanChannel.debug) {
            System.out.println("memberhash:" + this.hash + " membername:" + this.name);
        }
    }
}
