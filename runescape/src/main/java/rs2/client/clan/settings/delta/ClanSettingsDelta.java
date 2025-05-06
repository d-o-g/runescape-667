package rs2.client.clan.settings.delta;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base37;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!ama")
public final class ClanSettingsDelta {

    @OriginalMember(owner = "client!ama", name = "b", descriptor = "J")
    public long owner;

    @OriginalMember(owner = "client!ama", name = "e", descriptor = "I")
    public int updateNum = -1;

    @OriginalMember(owner = "client!ama", name = "g", descriptor = "Lclient!sia;")
    public final Deque<DeltaEntry> entries = new Deque<DeltaEntry>();

    @OriginalMember(owner = "client!ama", name = "<init>", descriptor = "(Lclient!ge;)V")
    public ClanSettingsDelta(@OriginalArg(0) Packet arg0) {
        this.method585(arg0);
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(Lclient!ge;B)V")
    public void method585(@OriginalArg(0) Packet packet) {
        this.owner = packet.g8();
        this.updateNum = packet.g4();

        for (@Pc(28) int type = packet.g1(); type != 0; type = packet.g1()) {
            if (ClanSettings.debug) {
                System.out.println("t:" + type);
            }

            @Pc(61) DeltaEntry entry;
            if (type == 3) {
                entry = new AddBanned();
            } else if (type == 1) {
                entry = new AddMemberV1();
            } else if (type == 13) {
                entry = new AddMemberV2();
            } else if (type == 4) {
                entry = new UpdateBaseSettings();
            } else if (type == 6) {
                entry = new DeleteBanned();
            } else if (type == 5) {
                entry = new DeleteMember();
            } else if (type == 2) {
                entry = new SetMemberRank();
            } else if (type == 7) {
                entry = new SetMemberExtraInfo();
            } else if (type == 8) {
                entry = new SetExtraSettingInt();
            } else if (type == 9) {
                entry = new SetExtraSettingLong();
            } else if (type == 10) {
                entry = new SetExtraSettingString();
            } else if (type == 11) {
                entry = new SetExtraSettingVarbit();
            } else if (type == 12) {
                entry = new SetClanName();
            } else {
                throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
            }

            entry.decode(packet);
            this.entries.addLast(entry);
        }
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(ILclient!hi;)V")
    public void applyToClanSettings(@OriginalArg(1) ClanSettings settings) {
        if (this.owner != settings.owner || this.updateNum != settings.updateNum) {
            throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Base37.decode(settings.owner) + " updateNum:" + settings.updateNum + " delta.owner:" + Base37.decode(this.owner) + " updateNum:" + this.updateNum);
        }

        for (@Pc(82) DeltaEntry entry = this.entries.first(); entry != null; entry = this.entries.next()) {
            entry.applyTo(settings);
        }

        settings.updateNum++;
    }
}
