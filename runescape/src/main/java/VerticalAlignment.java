import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ek")
public final class VerticalAlignment {

    @OriginalMember(owner = "client!ek", name = "a", descriptor = "(IZI)I")
    public int align(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(26) int local26 = GameShell.canvasHei > arg0 ? GameShell.canvasHei : arg0;
        if (Static520.A_VERTICAL_ALIGNMENT___13 == this) {
            return 0;
        } else if (Static488.A_VERTICAL_ALIGNMENT___12 == this) {
            return local26 - arg1;
        } else if (Static130.A_VERTICAL_ALIGNMENT___2 == this) {
            return (local26 - arg1) / 2;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!ek", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
