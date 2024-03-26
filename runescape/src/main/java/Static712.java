import com.jagex.Client;
import com.jagex.core.constants.ModeWhere;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Container;
import java.awt.Insets;

public final class Static712 {

    @OriginalMember(owner = "client!wj", name = "Lc", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_11;

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "()V")
    public static void method9323() {
        for (@Pc(1) int local1 = 0; local1 < Static125.anInt2352; local1++) {
            @Pc(6) PositionEntity local6 = Static679.aPositionEntity[local1];
            Static549.method8293(local6, true);
            Static679.aPositionEntity[local1] = null;
        }
        Static125.anInt2352 = 0;
    }

    @OriginalMember(owner = "client!wj", name = "k", descriptor = "(B)V")
    public static void method9329(@OriginalArg(0) byte arg0) {
        @Pc(7) client local7 = client.aClient1;
        synchronized (client.aClient1) {
            if (GameShell.fsframe != null) {
                return;
            }
            @Pc(22) Container local22;
            if (GameShell.frame != null) {
                local22 = GameShell.frame;
            } else if (GameShell.loaderApplet == null) {
                local22 = GameShell.instance;
            } else {
                local22 = GameShell.loaderApplet;
            }
            Client.frameWid = local22.getSize().width;
            Client.frameHei = local22.getSize().height;
            @Pc(44) Insets local44;
            if (local22 == GameShell.frame) {
                local44 = GameShell.frame.getInsets();
                Client.frameHei -= local44.top + local44.bottom;
                Client.frameWid -= local44.right + local44.left;
            }
            if (InterfaceManager.getWindowMode() == 1) {
                GameShell.topMargin = 0;
                GameShell.canvasHei = Client.loadingScreenHeight;
                GameShell.leftMargin = (Client.frameWid - Client.loadingScreenWidth) / 2;
                GameShell.canvasWid = Client.loadingScreenWidth;
            } else {
                Static323.method4625();
            }
            if (Client.modeWhere != ModeWhere.LIVE) {
                @Pc(101) boolean local101;
                if (GameShell.canvasWid < 1024 && GameShell.canvasHei < 768) {
                    local101 = true;
                } else {
                    local101 = false;
                }
            }
            GameShell.canvas.setSize(GameShell.canvasWid, GameShell.canvasHei);
            if (Toolkit.active != null) {
                if (InterfaceManager.aBoolean210) {
                    Static575.method7606(GameShell.canvas);
                } else {
                    Toolkit.active.method7935(GameShell.canvas, GameShell.canvasWid, GameShell.canvasHei);
                }
            }
            if (local22 == GameShell.frame) {
                local44 = GameShell.frame.getInsets();
                GameShell.canvas.setLocation(local44.left + GameShell.leftMargin, local44.top + GameShell.topMargin);
            } else {
                GameShell.canvas.setLocation(GameShell.leftMargin, GameShell.topMargin);
            }
            if (InterfaceManager.topLevelInterface != -1) {
                InterfaceManager.refreshTopLevelInterface(true);
            }
            Static288.repaintMargins();
        }
        if (arg0 != 11) {
            aMatrix_11 = null;
        }
    }
}
