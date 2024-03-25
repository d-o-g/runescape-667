import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.ClanSettings;

@OriginalClass("client!oda")
public final class Node_Sub14_Sub9 extends Node_Sub14 {

    @OriginalMember(owner = "client!oda", name = "l", descriptor = "I")
    public int anInt6815;

    @OriginalMember(owner = "client!oda", name = "q", descriptor = "I")
    public int anInt6816;

    @OriginalMember(owner = "client!oda", name = "m", descriptor = "I")
    public int anInt6818;

    @OriginalMember(owner = "client!oda", name = "o", descriptor = "I")
    public int anInt6820;

    @OriginalMember(owner = "client!oda", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void method8617(@OriginalArg(0) ClanSettings arg0) {
        arg0.doSetExtraSettingVarbit(this.anInt6818, this.anInt6820, this.anInt6816, this.anInt6815);
    }

    @OriginalMember(owner = "client!oda", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void method8615(@OriginalArg(1) Packet arg0) {
        this.anInt6815 = arg0.g4();
        this.anInt6816 = arg0.g4();
        this.anInt6820 = arg0.g1();
        this.anInt6818 = arg0.g1();
    }
}
