import com.jagex.core.util.Arrays;
import com.jagex.graphics.MonochromeImageCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qu")
public final class Node_Sub1_Sub25 extends TextureOp {

    @OriginalMember(owner = "client!qu", name = "<init>", descriptor = "()V")
    public Node_Sub1_Sub25() {
        super(0, true);
    }

    @OriginalMember(owner = "client!qu", name = "a", descriptor = "(II)[I")
    @Override
    public int[] monochromeOutput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(9) int[] local9 = super.monochromeCache.get(arg1);
        if (arg0 <= 107) {
            Static537.anIntArray633 = null;
        }
        if (super.monochromeCache.dirty) {
            Arrays.set(local9, 0, Static608.anInt9289, MonochromeImageCache.anIntArray341[arg1]);
        }
        return local9;
    }
}
