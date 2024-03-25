import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.ClanSettings;

@OriginalClass("client!pt")
public final class Node_Sub14_Sub10 extends Node_Sub14 {

    @OriginalMember(owner = "client!pt", name = "u", descriptor = "I")
    public int anInt7588;

    @OriginalMember(owner = "client!pt", name = "t", descriptor = "I")
    public int anInt7590;

    @OriginalMember(owner = "client!pt", name = "l", descriptor = "I")
    public int anInt7591;

    @OriginalMember(owner = "client!pt", name = "n", descriptor = "I")
    public int anInt7589 = -1;

    @OriginalMember(owner = "client!pt", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void method8617(@OriginalArg(0) ClanSettings arg0) {
        arg0.doSetMemberExtraInfo(this.anInt7588, this.anInt7589, this.anInt7590, this.anInt7591);
    }

    @OriginalMember(owner = "client!pt", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void method8615(@OriginalArg(1) Packet arg0) {
        this.anInt7589 = arg0.g2();
        this.anInt7588 = arg0.g4();
        this.anInt7591 = arg0.g1();
        this.anInt7590 = arg0.g1();
    }
}
