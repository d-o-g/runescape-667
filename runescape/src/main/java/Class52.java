import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bs")
public final class Class52 {

    @OriginalMember(owner = "client!bs", name = "h", descriptor = "[I")
    public final int[] anIntArray100 = new int[2];

    @OriginalMember(owner = "client!bs", name = "b", descriptor = "[I")
    public final int[] anIntArray98 = new int[2];

    @OriginalMember(owner = "client!bs", name = "c", descriptor = "[I")
    public final int[] anIntArray97 = new int[3];

    @OriginalMember(owner = "client!bs", name = "f", descriptor = "[I")
    public final int[] anIntArray99 = new int[3];

    @OriginalMember(owner = "client!bs", name = "d", descriptor = "[S")
    public short[] aShortArray11;

    @OriginalMember(owner = "client!bs", name = "g", descriptor = "[S")
    public short[] aShortArray10;

    @OriginalMember(owner = "client!bs", name = "<init>", descriptor = "(Lclient!vfa;)V")
    public Class52(@OriginalArg(0) ObjType arg0) {
        this.anIntArray97[0] = arg0.manwear;
        this.anIntArray97[1] = arg0.womanwear;
        this.anIntArray97[2] = arg0.manwear3;
        this.anIntArray99[0] = arg0.manwear2;
        this.anIntArray99[1] = arg0.womanwear2;
        this.anIntArray99[2] = arg0.womanwear3;
        this.anIntArray98[0] = arg0.manhead;
        this.anIntArray98[1] = arg0.manhead2;
        this.anIntArray100[0] = arg0.womanhead;
        this.anIntArray100[1] = arg0.womanhead2;
        if (arg0.recol_d != null) {
            this.aShortArray11 = new short[arg0.recol_d.length];
            Static734.method7692(arg0.recol_d, 0, this.aShortArray11, 0, this.aShortArray11.length);
        }
        if (arg0.retex_d != null) {
            this.aShortArray10 = new short[arg0.retex_d.length];
            Static734.method7692(arg0.retex_d, 0, this.aShortArray10, 0, this.aShortArray10.length);
        }
    }
}
