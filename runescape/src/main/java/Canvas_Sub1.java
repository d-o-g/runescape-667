import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.awt.*;

@OriginalClass("client!mja")
public final class Canvas_Sub1 extends Canvas {

    @OriginalMember(owner = "client!mja", name = "a", descriptor = "Ljava/awt/Component;")
    public final Component aComponent3;

    @OriginalMember(owner = "client!mja", name = "<init>", descriptor = "(Ljava/awt/Component;)V")
    public Canvas_Sub1(@OriginalArg(0) Component arg0) {
        this.aComponent3 = arg0;
    }

    @OriginalMember(owner = "client!mja", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
    @Override
    public void update(@OriginalArg(0) Graphics arg0) {
        this.aComponent3.update(arg0);
    }

    @OriginalMember(owner = "client!mja", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
    @Override
    public void paint(@OriginalArg(0) Graphics arg0) {
        this.aComponent3.paint(arg0);
    }
}
