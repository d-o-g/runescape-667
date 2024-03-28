import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;

public final class Static288 {

    @OriginalMember(owner = "client!jb", name = "w", descriptor = "Z")
    public static boolean aBoolean356 = false;

    @OriginalMember(owner = "client!jb", name = "E", descriptor = "I")
    public static int anInt4620 = 100;

    @OriginalMember(owner = "client!jb", name = "z", descriptor = "I")
    public static int anInt4621 = 0;

    @OriginalMember(owner = "client!jb", name = "a", descriptor = "(I)V")
    public static void repaintMargins() {
        if (GameShell.fsframe != null) {
            return;
        }

        @Pc(17) int leftMargin = GameShell.leftMargin;
        @Pc(19) int topMargin = GameShell.topMargin;
        @Pc(27) int rightMargin = GameShell.frameWid - leftMargin - GameShell.canvasWid;
        @Pc(34) int bottomMargin = GameShell.frameHei - topMargin - GameShell.canvasHei;
        if (leftMargin <= 0 && rightMargin <= 0 && topMargin <= 0 && bottomMargin <= 0) {
            return;
        }

        try {
            @Pc(59) Container topContainer;
            if (GameShell.frame != null) {
                topContainer = GameShell.frame;
            } else if (GameShell.loaderApplet == null) {
                topContainer = GameShell.instance;
            } else {
                topContainer = GameShell.loaderApplet;
            }

            @Pc(67) int left = 0;
            @Pc(69) int top = 0;
            if (topContainer == GameShell.frame) {
                @Pc(75) Insets local75 = GameShell.frame.getInsets();
                left = local75.left;
                top = local75.top;
            }

            @Pc(84) Graphics graphics = topContainer.getGraphics();
            graphics.setColor(Color.black);

            if (leftMargin > 0) {
                graphics.fillRect(left, top, leftMargin, GameShell.frameHei);
            }
            if (topMargin > 0) {
                graphics.fillRect(left, top, GameShell.frameWid, topMargin);
            }
            if (rightMargin > 0) {
                graphics.fillRect(GameShell.frameWid + left - rightMargin, top, rightMargin, GameShell.frameHei);
            }
            if (bottomMargin > 0) {
                graphics.fillRect(left, top + GameShell.frameHei - bottomMargin, GameShell.frameWid, bottomMargin);
            }
        } catch (@Pc(144) Exception ignored) {
            /* empty */
        }
    }
}
