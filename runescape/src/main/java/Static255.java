import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.awt.Dimension;

public final class Static255 {

    @OriginalMember(owner = "client!hs", name = "a", descriptor = "(Lclient!sb;BLclient!d;ILjava/awt/Canvas;I)Lclient!ha;")
    public static Toolkit create(@OriginalArg(3) int type, @OriginalArg(0) js5 shaders, @OriginalArg(4) Canvas canvas, @OriginalArg(2) TextureSource textureSource, @OriginalArg(5) int antialiasing) {
        @Pc(13) int width = 0;
        @Pc(15) int height = 0;

        if (canvas != null) {
            @Pc(20) Dimension dimension = canvas.getSize();
            width = dimension.width;
            height = dimension.height;
        }

        return Static226.create(type, shaders, canvas, textureSource, width, height, antialiasing);
    }
}
