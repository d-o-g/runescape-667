package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!oda")
public final class SetExtraSettingVarbit extends DeltaEntry {

    @OriginalMember(owner = "client!oda", name = "l", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!oda", name = "q", descriptor = "I")
    public int value;

    @OriginalMember(owner = "client!oda", name = "m", descriptor = "I")
    public int endBit;

    @OriginalMember(owner = "client!oda", name = "o", descriptor = "I")
    public int startBit;

    @OriginalMember(owner = "client!oda", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doSetExtraSettingVarbit(this.id, this.value, this.startBit, this.endBit);
    }

    @OriginalMember(owner = "client!oda", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.id = packet.g4();
        this.value = packet.g4();
        this.startBit = packet.g1();
        this.endBit = packet.g1();
    }
}
