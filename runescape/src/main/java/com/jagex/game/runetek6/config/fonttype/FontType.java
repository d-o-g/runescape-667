package com.jagex.game.runetek6.config.fonttype;

import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cl")
public final class FontType {

    @OriginalMember(owner = "client!cl", name = "b", descriptor = "Lclient!da;")
    public Font font = null;

    @OriginalMember(owner = "client!cl", name = "d", descriptor = "Lclient!ve;")
    public FontMetrics metrics = null;

    @OriginalMember(owner = "client!cl", name = "<init>", descriptor = "(Lclient!da;)V")
    public FontType(@OriginalArg(0) Font font) {
        this.font = font;
    }

    @OriginalMember(owner = "client!cl", name = "<init>", descriptor = "(Lclient!da;Lclient!ve;)V")
    public FontType(@OriginalArg(0) Font font, @OriginalArg(1) FontMetrics metrics) {
        this.font = font;
        this.metrics = metrics;
    }
}
