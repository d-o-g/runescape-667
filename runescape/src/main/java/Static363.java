import com.jagex.Client;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Dimension;

public final class Static363 {

    @OriginalMember(owner = "client!li", name = "h", descriptor = "[[B")
    public static byte[][] aByteArrayArray22;

    @OriginalMember(owner = "client!li", name = "c", descriptor = "Lclient!nga;")
    public static final Class259 aClass259_14 = new Class259();

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(I[Ljava/lang/String;)V")
    public static void method6234(@OriginalArg(1) String[] arg0) {
        if (arg0.length <= 1) {
            debugconsole.currententry = debugconsole.currententry + arg0[0];
            debugconsole.currententryLength += arg0[0].length();
            return;
        }
        for (@Pc(41) int local41 = 0; local41 < arg0.length; local41++) {
            if (arg0[local41].startsWith("pause")) {
                @Pc(61) int local61 = 5;
                try {
                    local61 = Integer.parseInt(arg0[local41].substring(6));
                } catch (@Pc(70) Exception local70) {
                }
                debugconsole.addline("Pausing for " + local61 + " seconds...");
                Static144.aStringArray7 = arg0;
                Static523.anInt3885 = local41 + 1;
                Static305.aLong157 = (long) (local61 * 1000) + SystemTimer.safetime();
                return;
            }
            debugconsole.currententry = arg0[local41];
            Static270.method3920(false);
        }
    }

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(III)I")
    public static int method6235(@OriginalArg(0) int arg0, @OriginalArg(1) int toolkit) {
        if (GraphicsDefaults.instance.profilingModel == -1) {
            return 1;
        }

        if (toolkit != ClientOptions.instance.toolkit.getValue()) {
            Static667.setToolkit(true, LocalisedText.PROFILING.localise(Client.language), toolkit);

            if (toolkit != ClientOptions.instance.toolkit.getValue()) {
                return -1;
            }
        }

        try {
            @Pc(43) Dimension local43 = GameShell.canvas.getSize();
            Static694.drawLoadingText(Toolkit.active, LocalisedText.PROFILING.localise(Client.language), true, Fonts.p12Metrics, Fonts.p12);
            @Pc(67) Mesh local67 = Mesh.load(GraphicsDefaults.instance.profilingModel, js5.MODELS);
            @Pc(70) long local70 = SystemTimer.safetime();
            Toolkit.active.la();
            Static460.aMatrix_10.applyTranslation(0, Static247.anInt3993, 0);
            Toolkit.active.setCamera(Static460.aMatrix_10);
            Toolkit.active.DA(local43.width / 2, local43.height / 2, 512, 512);
            Toolkit.active.xa(1.0F);
            Toolkit.active.ZA(16777215, 0.5F, 0.5F, 20.0F, -50.0F, 30.0F);
            @Pc(111) Model local111 = Toolkit.active.createModel(local67, 2048, 64, 64, 768);
            @Pc(113) int local113 = 0;
            label41:
            for (@Pc(115) int local115 = 0; local115 < 500; local115++) {
                Toolkit.active.GA(0);
                Toolkit.active.ya();
                for (@Pc(123) int local123 = 15; local123 >= 0; local123--) {
                    for (@Pc(126) int local126 = 0; local126 <= local123; local126++) {
                        Static59.aMatrix_5.applyTranslation((int) ((float) Static340.anInt5586 * (-((float) local123 / 2.0F) + (float) local126)), 0, (local123 + 1) * Static340.anInt5586);
                        local111.render(Static59.aMatrix_5, null, 0);
                        local113++;
                        if ((long) arg0 <= SystemTimer.safetime() - local70) {
                            break label41;
                        }
                    }
                }
            }
            Toolkit.active.method7950();
            @Pc(195) long local195 = (long) (local113 * 1000) / (SystemTimer.safetime() - local70);
            Toolkit.active.GA(0);
            Toolkit.active.ya();
            return (int) local195;
        } catch (@Pc(204) Throwable local204) {
            local204.printStackTrace();
            return -1;
        }
    }

}
