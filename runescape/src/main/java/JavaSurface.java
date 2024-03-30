import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.awt.Graphics;

@OriginalClass("client!cda")
public abstract class JavaSurface extends Node {

    @OriginalMember(owner = "client!qv", name = "a", descriptor = "(ILjava/awt/Canvas;II)Lclient!cda;")
    public static JavaSurface create(@OriginalArg(1) Canvas canvas, @OriginalArg(3) int width, @OriginalArg(0) int height) {
        try {
            @Pc(13) Class clazz = Class.forName("JavaDefaultSurface");
            @Pc(17) JavaSurface surface = (JavaSurface) clazz.getDeclaredConstructor().newInstance();
            surface.initialize(canvas, width, height);
            return surface;
        } catch (@Pc(26) Throwable local26) {
            @Pc(30) JavaFallbackSurface surface = new JavaFallbackSurface();
            surface.initialize(canvas, width, height);
            return surface;
        }
    }

    @OriginalMember(owner = "client!cda", name = "p", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!cda", name = "n", descriptor = "[I")
    public int[] raster;

    @OriginalMember(owner = "client!cda", name = "o", descriptor = "I")
    public int width;

    @OriginalMember(owner = "client!cda", name = "a", descriptor = "(ZIILjava/awt/Canvas;)V")
    public abstract void initialize(@OriginalArg(3) Canvas canvas, @OriginalArg(1) int width, @OriginalArg(2) int height);

    @OriginalMember(owner = "client!cda", name = "a", descriptor = "(IIIZLjava/awt/Graphics;III)V")
    public abstract void clip(@OriginalArg(2) int centerX, @OriginalArg(6) int centerY, @OriginalArg(1) int x, @OriginalArg(7) int y, @OriginalArg(0) int width, @OriginalArg(5) int height, @OriginalArg(4) Graphics graphics);
}
