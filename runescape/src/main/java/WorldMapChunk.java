import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vj")
public final class WorldMapChunk extends Node {

    @OriginalMember(owner = "client!vj", name = "u", descriptor = "I")
    public final int sourceX2;

    @OriginalMember(owner = "client!vj", name = "A", descriptor = "I")
    public final int displayZ1;

    @OriginalMember(owner = "client!vj", name = "k", descriptor = "I")
    public final int displayX2;

    @OriginalMember(owner = "client!vj", name = "p", descriptor = "I")
    public final int sourceZ2;

    @OriginalMember(owner = "client!vj", name = "m", descriptor = "I")
    public final int sourceX1;

    @OriginalMember(owner = "client!vj", name = "r", descriptor = "I")
    public final int sourceZ1;

    @OriginalMember(owner = "client!vj", name = "G", descriptor = "I")
    public final int displayX1;

    @OriginalMember(owner = "client!vj", name = "C", descriptor = "I")
    public final int level;

    @OriginalMember(owner = "client!vj", name = "y", descriptor = "I")
    public final int displayZ2;

    @OriginalMember(owner = "client!vj", name = "<init>", descriptor = "(IIIIIIIII)V")
    public WorldMapChunk(@OriginalArg(0) int level, @OriginalArg(1) int sourceX1, @OriginalArg(2) int sourceZ1, @OriginalArg(3) int sourceX2, @OriginalArg(4) int sourceZ2, @OriginalArg(5) int displayX1, @OriginalArg(6) int displayZ1, @OriginalArg(7) int displayX2, @OriginalArg(8) int displayZ2) {
        this.sourceX2 = sourceX2;
        this.displayZ1 = displayZ1;
        this.displayX2 = displayX2;
        this.sourceZ2 = sourceZ2;
        this.sourceX1 = sourceX1;
        this.sourceZ1 = sourceZ1;
        this.displayX1 = displayX1;
        this.level = level;
        this.displayZ2 = displayZ2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(I[III)V")
    public void projectSource(@OriginalArg(1) int[] coords, @OriginalArg(0) int x, @OriginalArg(2) int z) {
        coords[0] = this.level;
        coords[1] = x + this.sourceX1 - this.displayX1;
        coords[2] = z + this.sourceZ1 - this.displayZ1;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "([IIII)V")
    public void projectDisplay(@OriginalArg(0) int[] destination, @OriginalArg(2) int x, @OriginalArg(3) int z) {
        destination[0] = 0;
        destination[1] = x + this.displayX1 - this.sourceX1;
        destination[2] = z + this.displayZ1 - this.sourceZ1;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBI)Z")
    public boolean sourceContains(@OriginalArg(0) int x, @OriginalArg(2) int z) {
        return x >= this.sourceX1 && x <= this.sourceX2 && z >= this.sourceZ1 && z <= this.sourceZ2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(IBII)Z")
    public boolean sourceContains(@OriginalArg(2) int level, @OriginalArg(3) int x, @OriginalArg(0) int z) {
        return this.level == level && x >= this.sourceX1 && x <= this.sourceX2 && z >= this.sourceZ1 && z <= this.sourceZ2;
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(III)Z")
    public boolean displayContains(@OriginalArg(1) int x, @OriginalArg(0) int z) {
        return x >= this.displayX1 && x <= this.displayX2 && z >= this.displayZ1 && z <= this.displayZ2;
    }
}
