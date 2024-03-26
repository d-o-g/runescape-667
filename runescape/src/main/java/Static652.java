import com.jagex.IndexedImage;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static652 {

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "(III)Z")
    public static boolean method8532(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x800) != 0;
    }

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "(BILclient!sb;)Lclient!st;")
    public static Sprite method8533(@OriginalArg(1) int arg0, @OriginalArg(2) js5 arg1) {
        @Pc(16) Sprite local16 = (Sprite) Static594.A_WEIGHTED_CACHE___193.get(arg0);
        if (local16 == null) {
            if (Static297.loadingSpritesRaw) {
                local16 = Toolkit.active.createSprite(IndexedImage.loadFirst(arg1, arg0), true);
            } else {
                local16 = Static168.method2634(arg1.getfile(arg0));
            }
            Static594.A_WEIGHTED_CACHE___193.put(local16, arg0);
        }
        return local16;
    }
}
