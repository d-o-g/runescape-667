import com.jagex.core.io.Packet;
import com.jagex.graphics.EnvironmentLight;
import com.jagex.graphics.MonochromeImageCache;
import com.jagex.graphics.texture.TextureOp;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vba")
public final class Node_Sub1_Sub31 extends TextureOp {

    @OriginalMember(owner = "client!vba", name = "<init>", descriptor = "()V")
    public Node_Sub1_Sub31() {
        super(1, false);
    }

    @OriginalMember(owner = "client!vba", name = "a", descriptor = "(ZLclient!ge;I)V")
    @Override
    public void method9416(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
        if (arg2 == 0) {
            super.monochrome = arg1.g1() == 1;
        }
        if (arg0) {
            Component.interfacesJs5 = null;
        }
    }

    @OriginalMember(owner = "client!vba", name = "a", descriptor = "(IIB)V")
    public void method8691(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(9) int local9 = EnvironmentLight.anIntArray92[arg0];
        @Pc(13) int local13 = MonochromeImageCache.anIntArray341[arg1];
        @Pc(24) float local24 = (float) Math.atan2(local9 - 2048, local13 - 2048);
        if ((double) local24 >= -3.141592653589793D && (double) local24 <= -2.356194490192345D) {
            Static187.anInt3093 = arg1;
            Static37.anInt916 = arg0;
        } else if ((double) local24 <= -1.5707963267948966D && (double) local24 >= -2.356194490192345D) {
            Static187.anInt3093 = arg0;
            Static37.anInt916 = arg1;
        } else if ((double) local24 <= -0.7853981633974483D && (double) local24 >= -1.5707963267948966D) {
            Static37.anInt916 = EnvironmentLight.anInt9289 - arg1;
            Static187.anInt3093 = arg0;
        } else if (local24 <= 0.0F && (double) local24 >= -0.7853981633974483D) {
            Static37.anInt916 = arg0;
            Static187.anInt3093 = EnvironmentLight.anInt53 - arg1;
        } else if (local24 >= 0.0F && (double) local24 <= 0.7853981633974483D) {
            Static187.anInt3093 = EnvironmentLight.anInt53 - arg1;
            Static37.anInt916 = EnvironmentLight.anInt9289 - arg0;
        } else if ((double) local24 >= 0.7853981633974483D && (double) local24 <= 1.5707963267948966D) {
            Static187.anInt3093 = EnvironmentLight.anInt53 - arg0;
            Static37.anInt916 = EnvironmentLight.anInt9289 - arg1;
        } else if ((double) local24 >= 1.5707963267948966D && (double) local24 <= 2.356194490192345D) {
            Static37.anInt916 = arg1;
            Static187.anInt3093 = EnvironmentLight.anInt53 - arg0;
        } else if ((double) local24 >= 2.356194490192345D && (double) local24 <= 3.141592653589793D) {
            Static187.anInt3093 = arg1;
            Static37.anInt916 = EnvironmentLight.anInt9289 - arg0;
        }
        Static187.anInt3093 &= EnvironmentLight.anInt7343;
        Static37.anInt916 &= EnvironmentLight.anInt8580;
    }

    @OriginalMember(owner = "client!vba", name = "a", descriptor = "(IZ)[[I")
    @Override
    public int[][] method9414(@OriginalArg(0) int arg0) {
        @Pc(21) int[][] local21 = super.colourCache.get(arg0);
        if (super.colourCache.dirty) {
            @Pc(29) int[] local29 = local21[0];
            @Pc(33) int[] local33 = local21[1];
            @Pc(37) int[] local37 = local21[2];
            for (@Pc(39) int local39 = 0; local39 < EnvironmentLight.anInt9289; local39++) {
                this.method8691(local39, arg0);
                @Pc(52) int[][] local52 = this.method9413(0, Static187.anInt3093);
                local29[local39] = local52[0][Static37.anInt916];
                local33[local39] = local52[1][Static37.anInt916];
                local37[local39] = local52[2][Static37.anInt916];
            }
        }
        return local21;
    }

    @OriginalMember(owner = "client!vba", name = "a", descriptor = "(II)[I")
    @Override
    public int[] monochromeOutput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (arg0 <= 107) {
            ClientOptions.save();
        }
        @Pc(18) int[] local18 = super.monochromeCache.get(arg1);
        if (super.monochromeCache.dirty) {
            for (@Pc(24) int local24 = 0; local24 < EnvironmentLight.anInt9289; local24++) {
                this.method8691(local24, arg1);
                @Pc(37) int[] local37 = this.method9422(Static187.anInt3093, 0);
                local18[local24] = local37[Static37.anInt916];
            }
        }
        return local18;
    }
}
