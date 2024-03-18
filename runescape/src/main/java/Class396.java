import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wca")
public final class Class396 {

    @OriginalMember(owner = "client!wca", name = "b", descriptor = "[Ljava/lang/String;")
    public String[] aStringArray48 = new String[0];

    @OriginalMember(owner = "client!wca", name = "i", descriptor = "I")
    public int anInt10544 = -1;

    @OriginalMember(owner = "client!wca", name = "o", descriptor = "Z")
    public boolean aBoolean796 = false;

    @OriginalMember(owner = "client!wca", name = "m", descriptor = "I")
    public final int anInt10542;

    @OriginalMember(owner = "client!wca", name = "<init>", descriptor = "(IZ)V")
    public Class396(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        this.anInt10542 = arg0;
        this.aBoolean796 = arg1;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(Ljava/lang/String;B)V")
    public void method9149(@OriginalArg(0) String arg0) {
        this.method9157(this.anInt10544 + 1, arg0);
    }

    @OriginalMember(owner = "client!wca", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        @Pc(9) StringBuffer local9 = new StringBuffer();
        local9.append("[");
        for (@Pc(15) int local15 = 0; local15 < this.anInt10544; local15++) {
            if (local15 != 0) {
                local9.append(", ");
            }
            local9.append(this.aStringArray48[local15]);
        }
        local9.append("]");
        return local9.toString();
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(I)[Ljava/lang/String;")
    public String[] method9151() {
        @Pc(16) String[] local16 = new String[this.anInt10544 + 1];
        Arrays.copy(this.aStringArray48, 0, local16, 0, this.anInt10544 + 1);
        return local16;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(II)I")
    public int method9154(@OriginalArg(0) int arg0) {
        @Pc(16) int local16 = this.aStringArray48.length;
        while (local16 <= arg0) {
            if (!this.aBoolean796) {
                local16 += this.anInt10542;
            } else if (local16 == 0) {
                local16 = 1;
            } else {
                local16 *= this.anInt10542;
            }
        }
        return local16;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(IB)V")
    public void method9156(@OriginalArg(0) int arg0) {
        @Pc(9) String[] local9 = new String[this.method9154(arg0)];
        Arrays.copy(this.aStringArray48, 0, local9, 0, this.aStringArray48.length);
        this.aStringArray48 = local9;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(BILjava/lang/String;)V")
    public void method9157(@OriginalArg(1) int arg0, @OriginalArg(2) String arg1) {
        if (this.anInt10544 < arg0) {
            this.anInt10544 = arg0;
        }
        if (arg0 >= this.aStringArray48.length) {
            this.method9156(arg0);
        }
        this.aStringArray48[arg0] = arg1;
    }
}
