import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;

public final class Static288 {

    @OriginalMember(owner = "client!jb", name = "C", descriptor = "Lclient!gba;")
    public static Class139 aClass139_2;

    @OriginalMember(owner = "client!jb", name = "w", descriptor = "Z")
    public static boolean aBoolean356 = false;

    @OriginalMember(owner = "client!jb", name = "y", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___58 = new ClientProt(54, 6);

    @OriginalMember(owner = "client!jb", name = "t", descriptor = "F")
    public static float aFloat83 = 0.0F;

    @OriginalMember(owner = "client!jb", name = "E", descriptor = "I")
    public static int anInt4620 = 100;

    @OriginalMember(owner = "client!jb", name = "z", descriptor = "I")
    public static int anInt4621 = 0;

    @OriginalMember(owner = "client!jb", name = "a", descriptor = "(I)V")
    public static void method4182() {
        if (GameShell.fsframe != null) {
            return;
        }
        @Pc(17) int local17 = GameShell.leftMargin;
        @Pc(19) int local19 = GameShell.topMargin;
        @Pc(27) int local27 = GameShell.frameWid - local17 - GameShell.canvasWid;
        @Pc(34) int local34 = GameShell.frameHei - local19 - GameShell.canvasHei;
        if (local17 <= 0 && local27 <= 0 && local19 <= 0 && local34 <= 0) {
            return;
        }
        try {
            @Pc(59) Container local59;
            if (GameShell.frame != null) {
                local59 = GameShell.frame;
            } else if (GameShell.loaderApplet == null) {
                local59 = GameShell.instance;
            } else {
                local59 = GameShell.loaderApplet;
            }
            @Pc(67) int local67 = 0;
            @Pc(69) int local69 = 0;
            if (local59 == GameShell.frame) {
                @Pc(75) Insets local75 = GameShell.frame.getInsets();
                local67 = local75.left;
                local69 = local75.top;
            }
            @Pc(84) Graphics local84 = local59.getGraphics();
            local84.setColor(Color.black);
            if (local17 > 0) {
                local84.fillRect(local67, local69, local17, GameShell.frameHei);
            }
            if (local19 > 0) {
                local84.fillRect(local67, local69, GameShell.frameWid, local19);
            }
            if (local27 > 0) {
                local84.fillRect(GameShell.frameWid + local67 - local27, local69, local27, GameShell.frameHei);
            }
            if (local34 > 0) {
                local84.fillRect(local67, local69 + GameShell.frameHei - local34, GameShell.frameWid, local34);
                return;
            }
        } catch (@Pc(144) Exception local144) {
            return;
        }
    }
}
