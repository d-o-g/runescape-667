import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ija")
public final class MonochromeImageCache {

    @OriginalMember(owner = "client!ija", name = "h", descriptor = "I")
    public int anInt4368 = -1;

    @OriginalMember(owner = "client!ija", name = "t", descriptor = "I")
    public int anInt4369 = 0;

    @OriginalMember(owner = "client!ija", name = "c", descriptor = "Lclient!sia;")
    public Deque aDeque_25 = new Deque();

    @OriginalMember(owner = "client!ija", name = "o", descriptor = "Z")
    public boolean aBoolean338 = false;

    @OriginalMember(owner = "client!ija", name = "f", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!ija", name = "p", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "[Lclient!v;")
    public Node_Sub54[] aClass2_Sub54Array1;

    @OriginalMember(owner = "client!ija", name = "b", descriptor = "[[I")
    public int[][] anIntArrayArray104;

    @OriginalMember(owner = "client!ija", name = "<init>", descriptor = "(III)V")
    public MonochromeImageCache(@OriginalArg(0) int size, @OriginalArg(1) int height, @OriginalArg(2) int width) {
        this.size = size;
        this.height = height;
        this.aClass2_Sub54Array1 = new Node_Sub54[this.height];
        this.anIntArrayArray104 = new int[this.size][width];
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(B)[[I")
    public int[][] method3932() {
        if (this.size != this.height) {
            throw new RuntimeException("Can only retrieve a full image cache");
        }
        for (@Pc(32) int local32 = 0; local32 < this.size; local32++) {
            this.aClass2_Sub54Array1[local32] = Static405.aClass2_Sub54_1;
        }
        return this.anIntArrayArray104;
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(I)V")
    public void reset() {
        for (@Pc(3) int local3 = 0; local3 < this.size; local3++) {
            this.anIntArrayArray104[local3] = null;
        }
        if (-113 < -119) {
            this.method3932();
        }
        this.aClass2_Sub54Array1 = null;
        this.anIntArrayArray104 = null;
        this.aDeque_25.clear();
        this.aDeque_25 = null;
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(II)[I")
    public int[] method3935(@OriginalArg(1) int arg0) {
        if (this.size == this.height) {
            this.aBoolean338 = this.aClass2_Sub54Array1[arg0] == null;
            this.aClass2_Sub54Array1[arg0] = Static405.aClass2_Sub54_1;
            return this.anIntArrayArray104[arg0];
        } else if (this.size == 1) {
            this.aBoolean338 = this.anInt4368 != arg0;
            this.anInt4368 = arg0;
            return this.anIntArrayArray104[0];
        } else {
            @Pc(34) Node_Sub54 local34 = this.aClass2_Sub54Array1[arg0];
            if (local34 == null) {
                this.aBoolean338 = true;
                if (this.anInt4369 >= this.size) {
                    @Pc(59) Node_Sub54 local59 = (Node_Sub54) this.aDeque_25.last();
                    local34 = new Node_Sub54(arg0, local59.anInt9846);
                    this.aClass2_Sub54Array1[local59.anInt9844] = null;
                    local59.unlink();
                } else {
                    local34 = new Node_Sub54(arg0, this.anInt4369);
                    this.anInt4369++;
                }
                this.aClass2_Sub54Array1[arg0] = local34;
            } else {
                this.aBoolean338 = false;
            }
            this.aDeque_25.addFirst(local34);
            return this.anIntArrayArray104[local34.anInt9846];
        }
    }
}
