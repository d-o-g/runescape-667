import com.jagex.graphics.Toolkit;
import com.jagex.math.ColourUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ColourChooser {

    @OriginalMember(owner = "client!gka", name = "a", descriptor = "(Lclient!hda;IBILclient!ha;)V")
    public static void drawHue(@OriginalArg(0) Component component, @OriginalArg(1) int x, @OriginalArg(3) int y, @OriginalArg(4) Toolkit toolkit) {
        for (@Pc(16) int row = 63; row >= 0; row--) {
            ColourUtils.init(true, false);
            @Pc(42) int hsl = ((row & 0x3F) << 10) | 0x3F | 0x380;
            @Pc(46) int rgb = ColourUtils.HSL_TO_RGB[hsl];
            ColourUtils.destroy(false, true);
            toolkit.aa(x, y + (((63 - row) * component.height) >> 6), component.width, (component.height >> 6) + 1, rgb, 0);
        }
    }

    @OriginalMember(owner = "client!mfa", name = "a", descriptor = "(Lclient!ha;IBLclient!hda;II)V")
    public static void drawSaturationValue(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int hue, @OriginalArg(3) Component component, @OriginalArg(4) int x, @OriginalArg(5) int y) {
        for (@Pc(10) int saturation = 7; saturation >= 0; saturation--) {
            for (@Pc(16) int lightness = 127; lightness >= 0; lightness--) {
                ColourUtils.init(true, false);
                @Pc(40) int hsl = (hue & 0x3F) << 10 | (saturation & 0x7) << 7 | lightness & 0x7F;
                @Pc(44) int rgb = ColourUtils.HSL_TO_RGB[hsl];
                ColourUtils.destroy(false, true);
                toolkit.aa(x + (component.width * lightness >> 7), y + ((-saturation + 7) * component.height >> 3), (component.width >> 7) + 1, (component.height >> 3) + 1, rgb, 0);
            }
        }
    }

    private ColourChooser() {
        /* empty */
    }
}
