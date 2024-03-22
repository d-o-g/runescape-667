import com.jagex.IndexedImage;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static72 {

    @OriginalMember(owner = "client!cf", name = "c", descriptor = "J")
    public static long aLong52;

    @OriginalMember(owner = "client!cf", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___35 = new ServerProt(125, 2);

    @OriginalMember(owner = "client!cf", name = "a", descriptor = "(I[I)Ljava/lang/String;")
    public static String method1527(@OriginalArg(1) int[] arg0) {
        @Pc(7) StringBuffer local7 = new StringBuffer();
        @Pc(9) int local9 = Static331.anInt5440;
        for (@Pc(11) int local11 = 0; local11 < arg0.length; local11++) {
            @Pc(19) Class218 local19 = Static272.aClass45_1.list(arg0[local11]);
            if (local19.anInt5704 != -1) {
                @Pc(34) Sprite local34 = (Sprite) Static452.A_WEIGHTED_CACHE___149.get((long) local19.anInt5704);
                if (local34 == null) {
                    @Pc(42) IndexedImage local42 = IndexedImage.loadFirst(js5.SPRITES, local19.anInt5704, 0);
                    if (local42 != null) {
                        local34 = Toolkit.active.createSprite(local42, true);
                        Static452.A_WEIGHTED_CACHE___149.put(local34, (long) local19.anInt5704);
                    }
                }
                if (local34 != null) {
                    Static186.aSpriteArray5[local9] = local34;
                    local7.append(" <img=").append(local9).append(">");
                    local9++;
                }
            }
        }
        return local7.toString();
    }
}
