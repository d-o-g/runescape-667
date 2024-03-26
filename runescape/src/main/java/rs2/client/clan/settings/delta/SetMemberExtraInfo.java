package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!pt")
public final class SetMemberExtraInfo extends DeltaEntry {

    @OriginalMember(owner = "client!pt", name = "u", descriptor = "I")
    public int value;

    @OriginalMember(owner = "client!pt", name = "t", descriptor = "I")
    public int endBit;

    @OriginalMember(owner = "client!pt", name = "l", descriptor = "I")
    public int startBit;

    @OriginalMember(owner = "client!pt", name = "n", descriptor = "I")
    public int member = -1;

    @OriginalMember(owner = "client!pt", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doSetMemberExtraInfo(this.value, this.member, this.endBit, this.startBit);
    }

    @OriginalMember(owner = "client!pt", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.member = packet.g2();
        this.value = packet.g4();
        this.startBit = packet.g1();
        this.endBit = packet.g1();
    }
}
