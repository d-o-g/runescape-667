import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wk")
public final class horizontalAlignment {

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(III)I")
    public int align(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        @Pc(15) int local15 = GameShell.canvasWid > arg0 ? GameShell.canvasWid : arg0;
        if (Static555.A_HORIZONTAL_ALIGNMENT___14 == this) {
            return 0;
        } else if (Static169.A_HORIZONTAL_ALIGNMENT___1 == this) {
            return local15 - arg1;
        } else if (Static710.A_HORIZONTAL_ALIGNMENT___13 == this) {
            return (local15 - arg1) / 2;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!wk", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
