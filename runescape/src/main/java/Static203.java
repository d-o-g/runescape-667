import com.jagex.graphics.Fonts;
import com.jagex.graphics.Matrix;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static203 {

    @OriginalMember(owner = "client!gf", name = "l", descriptor = "F")
    public static float aFloat69;

    @OriginalMember(owner = "client!gf", name = "j", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_4;

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(B)V")
    public static void resetStaticSprites() {
        Sprites.headiconsPk = null;
        Sprites.hintMapedge = null;
        Sprites.hintMapmarkers = null;
        Fonts.p11 = null;
        Fonts.p12 = null;
        Sprites.compass = null;
        Sprites.hitbarDefault = null;
        Sprites.scrollbar = null;
        Sprites.mapdots = null;
        Sprites.timerbarDefault = null;
        Sprites.otherlevel = null;
        Sprites.cross = null;
        Fonts.b12 = null;
        Sprites.nameIcons = null;
        Sprites.mapflag = null;
        Sprites.hintHeadicons = null;
        Sprites.headiconsPrayer = null;
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(I)Z")
    public static boolean method3070() {
        return SongManager.anInt10171 != 0;
    }

}
