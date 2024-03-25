import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!via")
public final class Node_Sub1_Sub36 extends TextureOp {

    @OriginalMember(owner = "client!via", name = "K", descriptor = "I")
    public int anInt10255 = 1365;

    @OriginalMember(owner = "client!via", name = "I", descriptor = "I")
    public int anInt10254 = 20;

    @OriginalMember(owner = "client!via", name = "G", descriptor = "I")
    public int anInt10256 = 0;

    @OriginalMember(owner = "client!via", name = "L", descriptor = "I")
    public int anInt10258 = 0;

    @OriginalMember(owner = "client!via", name = "<init>", descriptor = "()V")
    public Node_Sub1_Sub36() {
        super(0, true);
    }

    @OriginalMember(owner = "client!via", name = "a", descriptor = "(ZLclient!ge;I)V")
    @Override
    public void method9416(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
        if (arg2 == 0) {
            this.anInt10255 = arg1.g2();
        } else if (arg2 == 1) {
            this.anInt10254 = arg1.g2();
        } else if (arg2 == 2) {
            this.anInt10256 = arg1.g2();
        } else if (arg2 == 3) {
            this.anInt10258 = arg1.g2();
        }
        if (arg0) {
            WorldList.decodePopulations(null);
        }
    }

    @OriginalMember(owner = "client!via", name = "a", descriptor = "(II)[I")
    @Override
    public int[] monochromeOutput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(11) int[] local11 = super.monochromeCache.method3935(arg1);
        if (super.monochromeCache.aBoolean338) {
            for (@Pc(17) int local17 = 0; local17 < Static608.anInt9289; local17++) {
                @Pc(31) int local31 = this.anInt10256 + (Static54.anIntArray92[local17] << 12) / this.anInt10255;
                @Pc(43) int local43 = (Static273.anIntArray341[arg1] << 12) / this.anInt10255 + this.anInt10258;
                @Pc(49) int local49 = local31;
                @Pc(51) int local51 = local43;
                @Pc(57) int local57 = local31 * local31 >> 12;
                @Pc(63) int local63 = local43 * local43 >> 12;
                @Pc(65) int local65 = 0;
                while (local57 + local63 < 16384 && this.anInt10254 > local65) {
                    local51 = local43 + (local51 * local49 >> 12) * 2;
                    local49 = local31 + local57 - local63;
                    local65++;
                    local57 = local49 * local49 >> 12;
                    local63 = local51 * local51 >> 12;
                }
                local11[local17] = local65 >= this.anInt10254 - 1 ? 0 : (local65 << 12) / this.anInt10254;
            }
        }
        if (arg0 < 107) {
            WorldList.decodePopulations(null);
        }
        return local11;
    }
}
