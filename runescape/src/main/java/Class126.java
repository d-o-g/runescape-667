import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ffa")
public final class Class126 {

    @OriginalMember(owner = "client!ffa", name = "n", descriptor = "I")
    public int value;

    @OriginalMember(owner = "client!ffa", name = "f", descriptor = "I")
    public int anInt2891;

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(Z)V")
    public void normalizeValue() {
        this.value &= 0x3FFF;
    }

    @OriginalMember(owner = "client!ffa", name = "b", descriptor = "(I)I")
    public int getValue(@OriginalArg(0) int arg0) {
        if (arg0 != 16383) {
            this.method2676(27, -51, 39, -81);
        }
        return this.value & 0x3FFF;
    }

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(BI)V")
    public void setValue(@OriginalArg(1) int value) {
        this.value = value;
        this.anInt2891 = 0;
    }

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(IIII)Z")
    public boolean method2676(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        @Pc(6) int local6 = this.anInt2891;
        if (arg0 == this.value && this.anInt2891 == 0) {
            return false;
        }
        @Pc(73) boolean local73;
        @Pc(97) int local97;
        if (this.anInt2891 == 0) {
            if (arg0 > this.value && arg0 <= arg3 + this.value || this.value > arg0 && this.value - arg3 <= arg0) {
                this.value = arg0;
                return false;
            }
            local73 = true;
        } else {
            @Pc(102) int local102;
            if (this.anInt2891 > 0 && this.value < arg0) {
                local97 = this.anInt2891 * this.anInt2891 / (arg3 * 2);
                local102 = local97 + this.value;
                if (arg0 > local102 && local102 >= this.value) {
                    local73 = true;
                } else {
                    local73 = false;
                }
            } else if (this.anInt2891 < 0 && arg0 < this.value) {
                local97 = this.anInt2891 * this.anInt2891 / (arg3 * 2);
                local102 = this.value - local97;
                if (arg0 < local102 && local102 <= this.value) {
                    local73 = true;
                } else {
                    local73 = false;
                }
            } else {
                local73 = false;
            }
        }
        if (arg2 != -21712) {
            this.setValue(-89);
        }
        if (local73) {
            if (arg0 > this.value) {
                this.anInt2891 += arg3;
                if (arg1 != 0 && arg1 < this.anInt2891) {
                    this.anInt2891 = arg1;
                }
            } else {
                this.anInt2891 -= arg3;
                if (arg1 != 0 && -arg1 > this.anInt2891) {
                    this.anInt2891 = -arg1;
                }
            }
            if (this.anInt2891 != local6) {
                local97 = this.anInt2891 * this.anInt2891 / (arg3 * 2);
                if (arg0 <= this.value) {
                    if (this.value > arg0 && this.value - local97 < arg0) {
                        this.anInt2891 = local6;
                    }
                } else if (local97 + this.value > arg0) {
                    this.anInt2891 = local6;
                }
            }
        } else if (this.anInt2891 > 0) {
            this.anInt2891 -= arg3;
            if (this.anInt2891 < 0) {
                this.anInt2891 = 0;
            }
        } else {
            this.anInt2891 += arg3;
            if (this.anInt2891 > 0) {
                this.anInt2891 = 0;
            }
        }
        this.value += this.anInt2891 + local6 >> 1;
        return local73;
    }
}
