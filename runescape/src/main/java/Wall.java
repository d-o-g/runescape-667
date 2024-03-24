import com.jagex.graphics.PointLight;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kp")
public abstract class Wall extends Entity {

    @OriginalMember(owner = "client!kp", name = "D", descriptor = "S")
    public short aShort58;

    @OriginalMember(owner = "client!kp", name = "<init>", descriptor = "(IIIIII)V")
    protected Wall(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int level, @OriginalArg(4) int virtualLevel, @OriginalArg(5) int arg5) {
        this.aShort58 = (short) arg5;
        super.y = y;
        super.level = (byte) level;
        super.z = z;
        super.x = x;
        super.virtualLevel = (byte) virtualLevel;
    }

    @OriginalMember(owner = "client!kp", name = "a", descriptor = "(BLclient!ha;)Z")
    @Override
    public final boolean method9284(@OriginalArg(0) byte arg0, @OriginalArg(1) Toolkit arg1) {
        if (arg0 != 59) {
            this.aShort58 = -17;
        }
        return Static73.method9308(super.x >> Static52.anInt1066, super.z >> Static52.anInt1066, this, super.virtualLevel);
    }

    @OriginalMember(owner = "client!kp", name = "a", descriptor = "([Lclient!lca;I)I")
    @Override
    public final int method9288(@OriginalArg(0) PointLight[] arg0) {
        @Pc(10) int localX = super.x >> Static52.anInt1066;
        @Pc(21) int localZ = super.z >> Static52.anInt1066;
        @Pc(23) int local23 = 0;
        if (Static403.anInt6246 == localX) {
            local23++;
        } else if (Static403.anInt6246 < localX) {
            local23 += 2;
        }
        if (localZ == Static550.anInt8271) {
            local23 += 3;
        } else if (Static550.anInt8271 > localZ) {
            local23 += 6;
        }
        @Pc(71) int local71 = Static4.anIntArray15[local23];
        if ((this.aShort58 & local71) != 0) {
            return this.findLightsAt(arg0, localZ, localX);
        } else if (this.aShort58 == 1 && localX > 0) {
            return this.findLightsAt(arg0, localZ, localX - 1);
        } else if (this.aShort58 == 4 && Static619.tileMaxX >= localX) {
            return this.findLightsAt(arg0, localZ, localX + 1);
        } else if (this.aShort58 == 8 && localZ > 0) {
            return this.findLightsAt(arg0, localZ - 1, localX);
        } else if (this.aShort58 == 2 && Static662.tileMaxZ >= localZ) {
            return this.findLightsAt(arg0, localZ + 1, localX);
        } else if (this.aShort58 == 16 && localX > 0 && localZ <= Static662.tileMaxZ) {
            return this.findLightsAt(arg0, localZ + 1, localX + -1);
        } else if (this.aShort58 == 32 && localX <= Static619.tileMaxX && Static662.tileMaxZ >= localZ) {
            return this.findLightsAt(arg0, localZ + 1, localX + 1);
        } else if (this.aShort58 == 128 && localX > 0 && localZ > 0) {
            return this.findLightsAt(arg0, localZ - 1, localX + -1);
        } else if (this.aShort58 == 64 && Static619.tileMaxX >= localX && localZ > 0) {
            return this.findLightsAt(arg0, localZ - 1, localX + 1);
        } else {
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!kp", name = "g", descriptor = "(I)Z")
    @Override
    public final boolean method9275() {
        return Static258.aBooleanArrayArray3[(super.x >> Static52.anInt1066) + Static35.anInt813 - Static403.anInt6246][Static35.anInt813 + (super.z >> Static52.anInt1066) - Static550.anInt8271];
    }
}
