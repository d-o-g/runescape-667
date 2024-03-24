import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bh")
public final class CutsceneAction_Sub1_Sub1 extends CutsceneAction_Sub1 {

    @OriginalMember(owner = "client!bh", name = "n", descriptor = "I")
    public final int anInt987;

    @OriginalMember(owner = "client!bh", name = "s", descriptor = "I")
    public final int anInt983;

    @OriginalMember(owner = "client!bh", name = "t", descriptor = "I")
    public final int anInt986;

    @OriginalMember(owner = "client!bh", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub1_Sub1(@OriginalArg(0) Packet arg0) {
        super(arg0);
        @Pc(6) int local6 = arg0.g4();
        this.anInt987 = local6 & 0xFFFF;
        this.anInt983 = local6 >>> 16;
        this.anInt986 = arg0.g1();
    }

    @OriginalMember(owner = "client!bh", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        @Pc(10) int local10 = this.anInt983 * 512 + 256;
        @Pc(17) int local17 = this.anInt987 * 512 + 256;
        @Pc(30) int local30 = this.anInt986;
        if (local30 < 3 && Static441.isBridgeAt(this.anInt987, this.anInt983)) {
            local30++;
        }
        @Pc(79) SpotAnimation local79 = new SpotAnimation(super.anInt10558, 0, this.anInt986, local30, local10, Static102.averageHeight(this.anInt986, -29754, local17, local10) - super.anInt10560, local17, this.anInt983, this.anInt983, this.anInt987, this.anInt987, super.anInt10556, false);
        Static346.A_HASH_TABLE___29.put(this.anInt983 << 16 | this.anInt987, new SpotAnimationNode(local79));
    }
}
