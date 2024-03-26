import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ek")
public final class VerticalAlignment {

    @OriginalMember(owner = "client!qg", name = "X", descriptor = "Lclient!ek;")
    public static final VerticalAlignment TOP = new VerticalAlignment();

    @OriginalMember(owner = "client!eb", name = "c", descriptor = "Lclient!ek;")
    public static final VerticalAlignment CENTER = new VerticalAlignment();

    @OriginalMember(owner = "client!pga", name = "b", descriptor = "Lclient!ek;")
    public static final VerticalAlignment BOTTOM = new VerticalAlignment();

    @OriginalMember(owner = "client!ju", name = "b", descriptor = "(I)[Lclient!ek;")
    public static VerticalAlignment[] values() {
        return new VerticalAlignment[]{
            TOP,
            CENTER,
            BOTTOM,
        };
    }

    @OriginalMember(owner = "client!ek", name = "a", descriptor = "(IZI)I")
    public int align(@OriginalArg(0) int arg0, @OriginalArg(2) int height) {
        @Pc(26) int maxHeight = GameShell.canvasHei > arg0 ? GameShell.canvasHei : arg0;
        if (TOP == this) {
            return 0;
        } else if (BOTTOM == this) {
            return maxHeight - height;
        } else if (CENTER == this) {
            return (maxHeight - height) / 2;
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
