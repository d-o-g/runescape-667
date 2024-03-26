import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base37;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.settings.ClanSettings;
import rs2.client.clan.settings.delta.AddBanned;
import rs2.client.clan.settings.delta.AddMemberV1;
import rs2.client.clan.settings.delta.AddMemberV2;
import rs2.client.clan.settings.delta.DeleteBanned;
import rs2.client.clan.settings.delta.DeleteMember;
import rs2.client.clan.settings.delta.DeltaEntry;
import rs2.client.clan.settings.delta.SetClanName;
import rs2.client.clan.settings.delta.SetExtraSettingInt;
import rs2.client.clan.settings.delta.SetExtraSettingLong;
import rs2.client.clan.settings.delta.SetExtraSettingString;
import rs2.client.clan.settings.delta.SetExtraSettingVarbit;
import rs2.client.clan.settings.delta.SetMemberExtraInfo;
import rs2.client.clan.settings.delta.SetMemberRank;
import rs2.client.clan.settings.delta.UpdateBaseSettings;

@OriginalClass("client!ama")
public final class Class20 {

    @OriginalMember(owner = "client!ama", name = "b", descriptor = "J")
    public long aLong15;

    @OriginalMember(owner = "client!ama", name = "e", descriptor = "I")
    public int anInt519 = -1;

    @OriginalMember(owner = "client!ama", name = "g", descriptor = "Lclient!sia;")
    public final Deque aDeque_4 = new Deque();

    @OriginalMember(owner = "client!ama", name = "<init>", descriptor = "(Lclient!ge;)V")
    public Class20(@OriginalArg(0) Packet arg0) {
        this.method585(arg0);
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(Lclient!ge;B)V")
    public void method585(@OriginalArg(0) Packet arg0) {
        this.aLong15 = arg0.g8();
        this.anInt519 = arg0.g4();
        for (@Pc(28) int local28 = arg0.g1(); local28 != 0; local28 = arg0.g1()) {
            if (ClanSettings.debug) {
                System.out.println("t:" + local28);
            }
            @Pc(61) DeltaEntry local61;
            if (local28 == 3) {
                local61 = new AddBanned();
            } else if (local28 == 1) {
                local61 = new AddMemberV1();
            } else if (local28 == 13) {
                local61 = new AddMemberV2();
            } else if (local28 == 4) {
                local61 = new UpdateBaseSettings();
            } else if (local28 == 6) {
                local61 = new DeleteBanned();
            } else if (local28 == 5) {
                local61 = new DeleteMember();
            } else if (local28 == 2) {
                local61 = new SetMemberRank();
            } else if (local28 == 7) {
                local61 = new SetMemberExtraInfo();
            } else if (local28 == 8) {
                local61 = new SetExtraSettingInt();
            } else if (local28 == 9) {
                local61 = new SetExtraSettingLong();
            } else if (local28 == 10) {
                local61 = new SetExtraSettingString();
            } else if (local28 == 11) {
                local61 = new SetExtraSettingVarbit();
            } else if (local28 == 12) {
                local61 = new SetClanName();
            } else {
                throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
            }
            local61.decode(arg0);
            this.aDeque_4.addLast(local61);
        }
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(ILclient!hi;)V")
    public void method587(@OriginalArg(1) ClanSettings arg0) {
        if (this.aLong15 != arg0.aLong125 || this.anInt519 != arg0.updateNum) {
            throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Base37.decode(arg0.aLong125) + " updateNum:" + arg0.updateNum + " delta.owner:" + Base37.decode(this.aLong15) + " updateNum:" + this.anInt519);
        }
        for (@Pc(82) DeltaEntry local82 = (DeltaEntry) this.aDeque_4.first(); local82 != null; local82 = (DeltaEntry) this.aDeque_4.next()) {
            local82.applyTo(arg0);
        }
        arg0.updateNum++;
    }
}
