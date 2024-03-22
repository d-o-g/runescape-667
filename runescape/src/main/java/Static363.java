import com.jagex.SignLink;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.PickingCylinder;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

public final class Static363 {

    @OriginalMember(owner = "client!li", name = "e", descriptor = "I")
    public static int anInt6934;

    @OriginalMember(owner = "client!li", name = "h", descriptor = "[[B")
    public static byte[][] aByteArrayArray22;

    @OriginalMember(owner = "client!li", name = "g", descriptor = "J")
    public static long aLong219;

    @OriginalMember(owner = "client!li", name = "a", descriptor = "Lclient!it;")
    public static final Class184 aClass184_13 = new Class184(9, 0, 4, 1);

    @OriginalMember(owner = "client!li", name = "c", descriptor = "Lclient!nga;")
    public static final Class259 aClass259_14 = new Class259();

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(I[Ljava/lang/String;)V")
    public static void method6234(@OriginalArg(1) String[] arg0) {
        if (arg0.length <= 1) {
            Static110.aString19 = Static110.aString19 + arg0[0];
            Static594.anInt8776 += arg0[0].length();
            return;
        }
        for (@Pc(41) int local41 = 0; local41 < arg0.length; local41++) {
            if (arg0[local41].startsWith("pause")) {
                @Pc(61) int local61 = 5;
                try {
                    local61 = Integer.parseInt(arg0[local41].substring(6));
                } catch (@Pc(70) Exception local70) {
                }
                Static79.method1579("Pausing for " + local61 + " seconds...");
                Static144.aStringArray7 = arg0;
                Static523.anInt3885 = local41 + 1;
                Static305.aLong157 = (long) (local61 * 1000) + SystemTimer.safetime();
                return;
            }
            Static110.aString19 = arg0[local41];
            Static270.method3920(false);
        }
    }

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(III)I")
    public static int method6235(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (Static523.graphicsDefaults.profilingModel == -1) {
            return 1;
        }
        if (arg1 != ClientOptions.instance.aClass57_Sub29_1.method7915()) {
            Static667.method8695(true, LocalisedText.PROFILING.localise(Static51.language), arg1);
            if (arg1 != ClientOptions.instance.aClass57_Sub29_1.method7915()) {
                return -1;
            }
        }
        try {
            @Pc(43) Dimension local43 = Static434.canvas.getSize();
            Static694.method9028(Toolkit.active, LocalisedText.PROFILING.localise(Static51.language), true, Fonts.p12Metrics, Fonts.p12);
            @Pc(67) Mesh local67 = Mesh.load(Static523.graphicsDefaults.profilingModel, js5.MODELS);
            @Pc(70) long local70 = SystemTimer.safetime();
            Toolkit.active.la();
            Static460.aMatrix_10.method7125(0, Static247.anInt3993, 0);
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
                        Static59.aMatrix_5.method7125((int) ((float) Static340.anInt5586 * (-((float) local123 / 2.0F) + (float) local126)), 0, (local123 + 1) * Static340.anInt5586);
                        local111.render(Static59.aMatrix_5, (PickingCylinder) null, 0);
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

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(IIIIIZ)V")
    public static void windowModeChanged(@OriginalArg(0) int oldMode, @OriginalArg(1) int height, @OriginalArg(2) int newMode, @OriginalArg(4) int width, @OriginalArg(5) boolean modeChanged) {
        if (GameShell.fsframe != null && (newMode != 3 || width != Static328.fullscreenWidth || Static110.fullscreenHeight != height)) {
            Static655.method8562(SignLink.instance, GameShell.fsframe);
            GameShell.fsframe = null;
        }
        if (newMode == 3 && GameShell.fsframe == null) {
            GameShell.fsframe = Static489.createFullscreenFrame(SignLink.instance, width, height, 0, 0);
            if (GameShell.fsframe != null) {
                Static328.fullscreenWidth = width;
                Static110.fullscreenHeight = height;
                Static666.method8693(1);
            }
        }
        if (newMode == 3 && GameShell.fsframe == null) {
            windowModeChanged(oldMode, -1, ClientOptions.instance.screenSize.getValue(), -1, true);
            return;
        }
        @Pc(95) Container local95;
        @Pc(110) Insets local110;
        if (GameShell.fsframe != null) {
            GameShell.frameHei = height;
            GameShell.frameWid = width;
            local95 = GameShell.fsframe;
        } else if (GameShell.frame == null) {
            if (GameShell.loaderApplet == null) {
                local95 = GameShell.instance;
            } else {
                local95 = GameShell.loaderApplet;
            }
            GameShell.frameWid = local95.getSize().width;
            GameShell.frameHei = local95.getSize().height;
        } else {
            local110 = GameShell.frame.getInsets();
            GameShell.frameWid = GameShell.frame.getSize().width - local110.right - local110.left;
            @Pc(126) int local126 = -local110.top;
            GameShell.frameHei = GameShell.frame.getSize().height + local126 - local110.bottom;
            local95 = GameShell.frame;
        }
        if (newMode == 1) {
            GameShell.topMargin = 0;
            GameShell.leftMargin = (GameShell.frameWid - Static302.anInt4851) / 2;
            GameShell.canvasHei = Static479.anInt7201;
            GameShell.canvasWid = Static302.anInt4851;
        } else {
            Static323.method4625();
        }
        if (Static2.aClass355_1 != Static446.aClass355_5) {
            @Pc(178) boolean local178;
            if (GameShell.canvasWid < 1024 && GameShell.canvasHei < 768) {
                local178 = true;
            } else {
                local178 = false;
            }
        }
        if (modeChanged) {
            Static574.method7572();
        } else {
            Static434.canvas.setSize(GameShell.canvasWid, GameShell.canvasHei);
            if (InterfaceManager.aBoolean210) {
                Static575.method7606(Static434.canvas);
            } else {
                Toolkit.active.method7935(Static434.canvas, GameShell.canvasWid, GameShell.canvasHei);
            }
            if (local95 == GameShell.frame) {
                local110 = GameShell.frame.getInsets();
                Static434.canvas.setLocation(GameShell.leftMargin + local110.left, GameShell.topMargin + local110.top);
            } else {
                Static434.canvas.setLocation(GameShell.leftMargin, GameShell.topMargin);
            }
        }
        if (newMode >= 2) {
            InterfaceManager.resizableScreen = true;
        } else {
            InterfaceManager.resizableScreen = false;
        }
        if (InterfaceManager.topLevelInterface != -1) {
            Static640.method8435(true);
        }
        if (ConnectionManager.GAME.connection != null && MainLogicManager.isAtGameScreen(MainLogicManager.step)) {
            Static371.method5284();
        }
        for (@Pc(258) int local258 = 0; local258 < 100; local258++) {
            InterfaceManager.dirtyRectangles[local258] = true;
        }
        Static664.aBoolean759 = true;
    }
}
