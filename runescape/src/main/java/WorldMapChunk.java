import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vj")
public final class WorldMapChunk extends Node {

    @OriginalMember(owner = "client!vj", name = "u", descriptor = "I")
    public final int anInt10272;

    @OriginalMember(owner = "client!vj", name = "A", descriptor = "I")
    public final int minZ;

    @OriginalMember(owner = "client!vj", name = "k", descriptor = "I")
    public final int maxX;

    @OriginalMember(owner = "client!vj", name = "p", descriptor = "I")
    public final int anInt10277;

    @OriginalMember(owner = "client!vj", name = "m", descriptor = "I")
    public final int anInt10280;

    @OriginalMember(owner = "client!vj", name = "r", descriptor = "I")
    public final int anInt10271;

    @OriginalMember(owner = "client!vj", name = "G", descriptor = "I")
    public final int minX;

    @OriginalMember(owner = "client!vj", name = "C", descriptor = "I")
    public final int level;

    @OriginalMember(owner = "client!vj", name = "y", descriptor = "I")
    public final int maxZ;

    @OriginalMember(owner = "client!vj", name = "<init>", descriptor = "(IIIIIIIII)V")
    public WorldMapChunk(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        this.anInt10272 = arg3;
        this.minZ = arg6;
        this.maxX = arg7;
        this.anInt10277 = arg4;
        this.anInt10280 = arg1;
        this.anInt10271 = arg2;
        this.minX = arg5;
        this.level = arg0;
        this.maxZ = arg8;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "([IIII)V")
    public void project(@OriginalArg(0) int[] destination, @OriginalArg(2) int x, @OriginalArg(3) int z) {
        destination[0] = 0;
        destination[1] = x + this.minX - this.anInt10280;
        destination[2] = z + this.minZ - this.anInt10271;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(III)Z")
    public boolean contains(@OriginalArg(0) int z, @OriginalArg(1) int x) {
        return x >= this.minX && x <= this.maxX && z >= this.minZ && z <= this.maxZ;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBII)Z")
    public boolean method8912(@OriginalArg(0) int z, @OriginalArg(2) int level, @OriginalArg(3) int x) {
        return this.level == level && x >= this.anInt10280 && x <= this.anInt10272 && z >= this.anInt10271 && z <= this.anInt10277;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(I[III)V")
    public void method8913(@OriginalArg(0) int x, @OriginalArg(1) int[] coords, @OriginalArg(2) int y) {
        coords[2] = this.anInt10271 + y - this.minZ;
        coords[1] = this.anInt10280 + x - this.minX;
        coords[0] = this.level;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBI)Z")
    public boolean method8914(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return arg0 >= this.anInt10280 && arg0 <= this.anInt10272 && arg1 >= this.anInt10271 && arg1 <= this.anInt10277;
    }
}
