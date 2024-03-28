import com.jagex.game.Location;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static561 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!rla", name = "o", descriptor = "Ljava/lang/Class;")
    public static Class locClass;

    @OriginalMember(owner = "client!rla", name = "a", descriptor = "(IIII)Z")
    public static boolean hasMsi(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(5) boolean found = true;
        @Pc(11) Location loc = (Location) Static302.getWall(arg2, arg0, arg1);
        if (loc != null) {
            found = Static449.hasMsi(loc) & true;
        }
        loc = (Location) Static578.getEntity(arg2, arg0, arg1, locClass == null ? (locClass = getClass("com.jagex.game.Location")) : locClass);
        if (loc != null) {
            found &= Static449.hasMsi(loc);
        }
        loc = (Location) Static687.getGroundDecor(arg2, arg0, arg1);
        if (loc != null) {
            found &= Static449.hasMsi(loc);
        }
        return found;
    }

    static Class getClass(String name) {
        Class instance;
        try {
            instance = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw (NoClassDefFoundError) new NoClassDefFoundError().initCause(ex);
        }
        return instance;
    }

    @OriginalMember(owner = "client!rla", name = "a", descriptor = "(IIIIII)V")
    public static void method7437(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        for (@Pc(15) int local15 = arg0; local15 <= arg3; local15++) {
            Static696.method9037(arg4, arg1, arg2, Static723.anIntArrayArray266[local15]);
        }
    }
}
