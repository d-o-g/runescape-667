import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qca")
public final class Node_Sub30_Sub3 extends Node_Sub30 {

    @OriginalMember(owner = "client!qca", name = "t", descriptor = "I")
    public int anInt7679 = -1;

    @OriginalMember(owner = "client!qca", name = "a", descriptor = "(Lclient!ge;I)V")
    @Override
    public void method7647(@OriginalArg(0) Packet arg0) {
        this.anInt7679 = arg0.g2();
        arg0.g1();
        if (arg0.g1() != 255) {
            arg0.pos--;
            arg0.method7398();
        }
    }

    @OriginalMember(owner = "client!qca", name = "a", descriptor = "(Lclient!rfa;I)V")
    @Override
    public void method7642(@OriginalArg(0) Node_Sub47 arg0) {
        arg0.method7277(this.anInt7679);
    }
}
