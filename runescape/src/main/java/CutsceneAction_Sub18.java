import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ra")
public final class CutsceneAction_Sub18 extends CutsceneAction {

    @OriginalMember(owner = "client!ra", name = "i", descriptor = "I")
    public final int anInt8181;

    @OriginalMember(owner = "client!ra", name = "l", descriptor = "I")
    public final int anInt8183;

    @OriginalMember(owner = "client!ra", name = "n", descriptor = "I")
    public final int anInt8180;

    @OriginalMember(owner = "client!ra", name = "j", descriptor = "I")
    public final int anInt8182;

    @OriginalMember(owner = "client!ra", name = "m", descriptor = "I")
    public final int anInt8178;

    @OriginalMember(owner = "client!ra", name = "o", descriptor = "I")
    public final int anInt8184;

    @OriginalMember(owner = "client!ra", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub18(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt8181 = arg0.g2();
        this.anInt8183 = arg0.g2();
        this.anInt8180 = arg0.g2();
        this.anInt8182 = arg0.g2();
        this.anInt8178 = arg0.g2();
        this.anInt8184 = arg0.g2();
    }

    @OriginalMember(owner = "client!ra", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        Static75.aClass357Array2[this.anInt8181].method8328(0);
        Static75.aClass357Array2[this.anInt8183].method8328(1);
        Camera.splineStart = this.anInt8178;
        Static197.anInt3260 = 0;
        Camera.lookSpline = 1;
        Camera.mode = 3;
        Camera.splineRate = 0;
        Camera.splineLookOffset = this.anInt8182;
        Static303.anInt4868 = this.anInt8180;
        Camera.splineEnd = this.anInt8184;
        Camera.splineTick();
        Static421.aBoolean480 = true;
    }
}
