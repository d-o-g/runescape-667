import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bs")
public final class ObjTypeCustomisation {

    @OriginalMember(owner = "client!bs", name = "h", descriptor = "[I")
    public final int[] womanhead = new int[2];

    @OriginalMember(owner = "client!bs", name = "b", descriptor = "[I")
    public final int[] manhead = new int[2];

    @OriginalMember(owner = "client!bs", name = "c", descriptor = "[I")
    public final int[] manwear = new int[3];

    @OriginalMember(owner = "client!bs", name = "f", descriptor = "[I")
    public final int[] womanwear = new int[3];

    @OriginalMember(owner = "client!bs", name = "d", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!bs", name = "g", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!bs", name = "<init>", descriptor = "(Lclient!vfa;)V")
    public ObjTypeCustomisation(@OriginalArg(0) ObjType arg0) {
        this.manwear[0] = arg0.manwear;
        this.manwear[1] = arg0.womanwear;
        this.manwear[2] = arg0.manwear3;
        this.womanwear[0] = arg0.manwear2;
        this.womanwear[1] = arg0.womanwear2;
        this.womanwear[2] = arg0.womanwear3;
        this.manhead[0] = arg0.manhead;
        this.manhead[1] = arg0.manhead2;
        this.womanhead[0] = arg0.womanhead;
        this.womanhead[1] = arg0.womanhead2;
        if (arg0.recol_d != null) {
            this.recol_d = new short[arg0.recol_d.length];
            Arrays.copy(arg0.recol_d, 0, this.recol_d, 0, this.recol_d.length);
        }
        if (arg0.retex_d != null) {
            this.retex_d = new short[arg0.retex_d.length];
            Arrays.copy(arg0.retex_d, 0, this.retex_d, 0, this.retex_d.length);
        }
    }
}
