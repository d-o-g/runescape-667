import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ug")
public final class ColourImageCache {

    @OriginalMember(owner = "client!ug", name = "j", descriptor = "I")
    public int anInt9613 = -1;

    @OriginalMember(owner = "client!ug", name = "c", descriptor = "I")
    public int anInt9615 = 0;

    @OriginalMember(owner = "client!ug", name = "f", descriptor = "Lclient!sia;")
    public Deque aDeque_69 = new Deque();

    @OriginalMember(owner = "client!ug", name = "k", descriptor = "Z")
    public boolean aBoolean737 = false;

    @OriginalMember(owner = "client!ug", name = "b", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!ug", name = "h", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!ug", name = "g", descriptor = "[Lclient!iia;")
    public Node_Sub27[] aClass2_Sub27Array1;

    @OriginalMember(owner = "client!ug", name = "l", descriptor = "[[[I")
    public int[][][] anIntArrayArrayArray20;

    @OriginalMember(owner = "client!ug", name = "<init>", descriptor = "(III)V")
    public ColourImageCache(@OriginalArg(0) int size, @OriginalArg(1) int height, @OriginalArg(2) int width) {
        this.size = size;
        this.height = height;
        this.aClass2_Sub27Array1 = new Node_Sub27[this.height];
        this.anIntArrayArrayArray20 = new int[this.size][3][width];
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(Z)V")
    public void reset() {
        for (@Pc(15) int local15 = 0; local15 < this.size; local15++) {
            this.anIntArrayArrayArray20[local15][0] = null;
            this.anIntArrayArrayArray20[local15][1] = null;
            this.anIntArrayArrayArray20[local15][2] = null;
            this.anIntArrayArrayArray20[local15] = null;
        }
        this.anIntArrayArrayArray20 = null;
        this.aClass2_Sub27Array1 = null;
        this.aDeque_69.clear();
        this.aDeque_69 = null;
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(II)[[I")
    public int[][] method8450(@OriginalArg(0) int arg0) {
        if (this.size == this.height) {
            this.aBoolean737 = this.aClass2_Sub27Array1[arg0] == null;
            this.aClass2_Sub27Array1[arg0] = Static528.aClass2_Sub27_1;
            return this.anIntArrayArrayArray20[arg0];
        } else if (this.size == 1) {
            this.aBoolean737 = this.anInt9613 != arg0;
            this.anInt9613 = arg0;
            return this.anIntArrayArrayArray20[0];
        } else {
            @Pc(78) Node_Sub27 local78 = this.aClass2_Sub27Array1[arg0];
            if (local78 == null) {
                this.aBoolean737 = true;
                if (this.anInt9615 < this.size) {
                    local78 = new Node_Sub27(arg0, this.anInt9615);
                    this.anInt9615++;
                } else {
                    @Pc(111) Node_Sub27 local111 = (Node_Sub27) this.aDeque_69.last();
                    local78 = new Node_Sub27(arg0, local111.anInt4352);
                    this.aClass2_Sub27Array1[local111.anInt4356] = null;
                    local111.unlink();
                }
                this.aClass2_Sub27Array1[arg0] = local78;
            } else {
                this.aBoolean737 = false;
            }
            this.aDeque_69.addFirst(local78);
            return this.anIntArrayArrayArray20[local78.anInt4352];
        }
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(I)[[[I")
    public int[][][] method8451() {
        if (this.height != this.size) {
            throw new RuntimeException("Can only retrieve a full image cache");
        }
        for (@Pc(20) int local20 = 0; local20 < this.size; local20++) {
            this.aClass2_Sub27Array1[local20] = Static528.aClass2_Sub27_1;
        }
        return this.anIntArrayArrayArray20;
    }
}
