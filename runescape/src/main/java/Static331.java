import com.jagex.core.util.Arrays;
import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static331 {

    @OriginalMember(owner = "client!ki", name = "k", descriptor = "Ljava/lang/String;")
    public static String aString52;

    @OriginalMember(owner = "client!ki", name = "c", descriptor = "I")
    public static int anInt5440;

    @OriginalMember(owner = "client!ki", name = "h", descriptor = "Lclient!sb;")
    public static js5 aJs5_65;

    @OriginalMember(owner = "client!ki", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___138 = new ServerProt(36, 4);

    @OriginalMember(owner = "client!ki", name = "i", descriptor = "I")
    public static int anInt5439 = -1;

    @OriginalMember(owner = "client!ki", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___139 = new ServerProt(118, -2);

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "I")
    public static int anInt5441 = -50;

    @OriginalMember(owner = "client!ki", name = "d", descriptor = "[I")
    public static final int[] anIntArray403 = new int[5];

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(ZLjava/lang/String;B)V")
    public static void method4924(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1) {
        Static263.method3855(arg0, -1, -1, arg1);
    }

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(B[Lclient!st;)V")
    public static void method4925(@OriginalArg(1) Sprite[] arg0) {
        anInt5440 = arg0.length;
        Static186.aSpriteArray5 = new Sprite[anInt5440 + 10];
        Static460.anIntArray554 = new int[anInt5440 + 10];
        Arrays.copy(arg0, 0, Static186.aSpriteArray5, 0, anInt5440);
        for (@Pc(32) int local32 = 0; local32 < anInt5440; local32++) {
            Static460.anIntArray554[local32] = Static186.aSpriteArray5[local32].scaleHeight();
        }
        for (@Pc(50) int local50 = anInt5440; local50 < Static186.aSpriteArray5.length; local50++) {
            Static460.anIntArray554[local50] = 12;
        }
    }

}
