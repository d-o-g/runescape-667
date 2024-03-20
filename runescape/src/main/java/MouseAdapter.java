import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

@OriginalClass("client!me")
public final class MouseAdapter {

    @OriginalMember(owner = "client!me", name = "b", descriptor = "Ljava/awt/Component;")
    public Component component;

    @OriginalMember(owner = "client!me", name = "a", descriptor = "Ljava/awt/Robot;")
    public final Robot robot = new Robot();

    @OriginalMember(owner = "client!me", name = "<init>", descriptor = "()V")
    public MouseAdapter() throws Exception {
    }

    @OriginalMember(owner = "client!me", name = "showcursor", descriptor = "(Ljava/awt/Component;Z)V")
    public void showcursor(@OriginalArg(0) Component component, @OriginalArg(1) boolean delete) {
        if (delete) {
            component = null;
        } else if (component == null) {
            throw new NullPointerException();
        }

        if (this.component == component) {
            return;
        }

        if (this.component != null) {
            this.component.setCursor(null);
            this.component = null;
        }

        if (component != null) {
            component.setCursor(component.getToolkit().createCustomCursor(new BufferedImage(1, 1, TYPE_INT_ARGB), new Point(0, 0), null));
            this.component = component;
        }
    }

    @OriginalMember(owner = "client!me", name = "movemouse", descriptor = "(II)V")
    public void movemouse(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.robot.mouseMove(arg0, arg1);
    }

    @OriginalMember(owner = "client!me", name = "setcustomcursor", descriptor = "(Ljava/awt/Component;[IIILjava/awt/Point;)V")
    public void setcustomcursor(@OriginalArg(0) Component component, @OriginalArg(1) int[] rgb, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) Point hotSpot) {
        if (rgb == null) {
            component.setCursor(null);
        } else {
            @Pc(8) BufferedImage image = new BufferedImage(width, height, TYPE_INT_ARGB);
            image.setRGB(0, 0, width, height, rgb, 0, width);
            component.setCursor(component.getToolkit().createCustomCursor(image, hotSpot, null));
        }
    }
}
