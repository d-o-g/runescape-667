import com.jagex.IndexedImage;
import com.jagex.graphics.FontMetrics;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static71 {

    @OriginalMember(owner = "client!cea", name = "w", descriptor = "Ljava/lang/Object;")
    public static Object anObject4;

    @OriginalMember(owner = "client!cea", name = "b", descriptor = "(I)Z")
    public static boolean method1525() {
        @Pc(5) boolean local5 = true;
        if (Static414.aIndexedImage_2 == null) {
            if (js5.SPRITES.fileready(Static456.anInt6929)) {
                Static414.aIndexedImage_2 = IndexedImage.loadFirst(js5.SPRITES, Static456.anInt6929);
            } else {
                local5 = false;
            }
        }
        if (Static535.aIndexedImage_3 == null) {
            if (js5.SPRITES.fileready(Static362.anInt5828)) {
                Static535.aIndexedImage_3 = IndexedImage.loadFirst(js5.SPRITES, Static362.anInt5828);
            } else {
                local5 = false;
            }
        }
        if (Static74.aIndexedImage_1 == null) {
            if (js5.SPRITES.fileready(Static11.anInt136)) {
                Static74.aIndexedImage_1 = IndexedImage.loadFirst(js5.SPRITES, Static11.anInt136);
            } else {
                local5 = false;
            }
        }
        if (Static16.loadingTextMetrics == null) {
            if (js5.FONTMETRICS.fileready(Static723.anInt10929)) {
                Static16.loadingTextMetrics = FontMetrics.loadFile(Static723.anInt10929, js5.FONTMETRICS);
            } else {
                local5 = false;
            }
        }
        if (Static627.loadingTextImages == null) {
            if (js5.SPRITES.fileready(Static723.anInt10929)) {
                Static627.loadingTextImages = IndexedImage.load(js5.SPRITES, Static723.anInt10929);
            } else {
                local5 = false;
            }
        }
        return local5;
    }
}
