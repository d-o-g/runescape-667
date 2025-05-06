import com.jagex.Class67;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.mouse.MouseLog;

import java.awt.Canvas;

public final class Static226 {

    @OriginalMember(owner = "client!ha", name = "i", descriptor = "Lclient!pu;")
    public static Class67 aClass67_9;

    @OriginalMember(owner = "client!ha", name = "t", descriptor = "[Lclient!bl;")
    public static Class46[] aClass46Array7;

    @OriginalMember(owner = "client!ha", name = "q", descriptor = "Lclient!sia;")
    public static final Deque<MouseLog> mouseLogs = new Deque<>();

    @OriginalMember(owner = "client!ha", name = "a", descriptor = "(ILjava/awt/Canvas;IILclient!d;ILclient!sb;I)Lclient!ha;")
    public static synchronized Toolkit create(@OriginalArg(5) int type, @OriginalArg(6) js5 shaders, @OriginalArg(1) Canvas canvas, @OriginalArg(4) TextureSource textureSource, @OriginalArg(7) int width, @OriginalArg(2) int height, @OriginalArg(3) int antialiasing) {
        if (type == ToolkitType.JAVA) {
            return JavaToolkit.create(canvas, textureSource, width, height);
        } else if (type == ToolkitType.SSE) {
            return oa.create(canvas, textureSource, width, height);
        } else if (type == ToolkitType.GL) {
            return GlToolkit.create(canvas, textureSource, antialiasing);
        } else if (type == ToolkitType.GLX) {
            return GlxToolkit.create(shaders, canvas, textureSource, antialiasing);
        } else if (type == ToolkitType.D3D) {
            return D3DToolkit.create(shaders, canvas, textureSource, antialiasing);
        } else {
            throw new IllegalArgumentException("UM");
        }
    }

    @OriginalMember(owner = "client!ha", name = "a", descriptor = "(FIFF)F")
    public static float method7999(@OriginalArg(0) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) float arg2) {
        return arg1 + (arg0 - arg1) * arg2;
    }
}
