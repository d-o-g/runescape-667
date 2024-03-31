import com.jagex.FullscreenMode;
import com.jagex.core.constants.MaxScreenSize;
import com.jagex.core.util.Arrays;
import com.jagex.core.algorithms.Quicksort;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.sign.SignLink;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Fullscreen {

    @OriginalMember(owner = "client!vj", name = "H", descriptor = "[Lclient!oga;")
    public static FullscreenMode[] modes;

    @OriginalMember(owner = "client!sia", name = "g", descriptor = "(I)[Lclient!oga;")
    public static FullscreenMode[] getModes() {
        if (modes != null) {
            return modes;
        }

        @Pc(20) FullscreenMode[] modes = SignLink.fullscreenModes(GameShell.signLink);
        @Pc(24) FullscreenMode[] result = new FullscreenMode[modes.length];
        @Pc(26) int count = 0;
        @Pc(31) int maxScreenSize = ClientOptions.instance.maxScreenSize.getValue();

        label69:
        for (@Pc(33) int i = 0; i < modes.length; i++) {
            @Pc(38) FullscreenMode mode = modes[i];

            if ((mode.bits <= 0 || mode.bits >= 24) && mode.width >= 800 && mode.height >= 600 && (maxScreenSize != MaxScreenSize._800x600 || mode.width <= 800 && mode.height <= 600) && (maxScreenSize != MaxScreenSize._1024x768 || mode.width <= 1024 && mode.height <= 768)) {
                for (@Pc(112) int j = 0; j < count; j++) {
                    @Pc(117) FullscreenMode otherMode = result[j];

                    if (mode.width == otherMode.width && mode.height == otherMode.height) {
                        if (otherMode.bits < mode.bits) {
                            result[j] = mode;
                        }

                        continue label69;
                    }
                }

                result[count] = mode;
                count++;
            }
        }

        Fullscreen.modes = new FullscreenMode[count];
        Arrays.copy(result, 0, Fullscreen.modes, 0, count);

        @Pc(175) int[] sizes = new int[Fullscreen.modes.length];
        for (@Pc(112) int i = 0; i < Fullscreen.modes.length; i++) {
            @Pc(117) FullscreenMode mode = Fullscreen.modes[i];
            sizes[i] = mode.height * mode.width;
        }

        Quicksort.sort(sizes, Fullscreen.modes);
        return Fullscreen.modes;
    }

    private Fullscreen() {
        /* empty */
    }
}
