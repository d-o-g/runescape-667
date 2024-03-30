import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vj")
public final class WorldMapChunk extends Node {

    @OriginalMember(owner = "client!vj", name = "u", descriptor = "I")
    public final int x2;

    @OriginalMember(owner = "client!vj", name = "A", descriptor = "I")
    public final int floorZ1;

    @OriginalMember(owner = "client!vj", name = "k", descriptor = "I")
    public final int floorX2;

    @OriginalMember(owner = "client!vj", name = "p", descriptor = "I")
    public final int z2;

    @OriginalMember(owner = "client!vj", name = "m", descriptor = "I")
    public final int x1;

    @OriginalMember(owner = "client!vj", name = "r", descriptor = "I")
    public final int z1;

    @OriginalMember(owner = "client!vj", name = "G", descriptor = "I")
    public final int floorX1;

    @OriginalMember(owner = "client!vj", name = "C", descriptor = "I")
    public final int level;

    @OriginalMember(owner = "client!vj", name = "y", descriptor = "I")
    public final int floorZ2;

    @OriginalMember(owner = "client!vj", name = "<init>", descriptor = "(IIIIIIIII)V")
    public WorldMapChunk(@OriginalArg(0) int level, @OriginalArg(1) int x1, @OriginalArg(2) int z1, @OriginalArg(3) int x2, @OriginalArg(4) int z2, @OriginalArg(5) int floorX1, @OriginalArg(6) int floorZ1, @OriginalArg(7) int floorX2, @OriginalArg(8) int floorZ2) {
        this.x2 = x2;
        this.floorZ1 = floorZ1;
        this.floorX2 = floorX2;
        this.z2 = z2;
        this.x1 = x1;
        this.z1 = z1;
        this.floorX1 = floorX1;
        this.level = level;
        this.floorZ2 = floorZ2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "([IIII)V")
    public void projectFloor(@OriginalArg(0) int[] destination, @OriginalArg(2) int x, @OriginalArg(3) int z) {
        destination[0] = 0;
        destination[1] = x + this.floorX1 - this.x1;
        destination[2] = z + this.floorZ1 - this.z1;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(I[III)V")
    public void project(@OriginalArg(1) int[] coords, @OriginalArg(0) int x, @OriginalArg(2) int z) {
        coords[0] = this.level;
        coords[1] = x + this.x1 - this.floorX1;
        coords[2] = z + this.z1 - this.floorZ1;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(III)Z")
    public boolean floorContains(@OriginalArg(1) int x, @OriginalArg(0) int z) {
        return x >= this.floorX1 && x <= this.floorX2 && z >= this.floorZ1 && z <= this.floorZ2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBI)Z")
    public boolean contains(@OriginalArg(0) int x, @OriginalArg(2) int y) {
        return x >= this.x1 && x <= this.x2 && y >= this.z1 && y <= this.z2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBII)Z")
    public boolean contains(@OriginalArg(2) int level, @OriginalArg(3) int x, @OriginalArg(0) int z) {
        return this.level == level && x >= this.x1 && x <= this.x2 && z >= this.z1 && z <= this.z2;
    }
}
