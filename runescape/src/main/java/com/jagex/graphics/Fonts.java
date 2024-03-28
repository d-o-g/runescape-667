package com.jagex.graphics;

import com.jagex.game.runetek6.config.fonttype.FontType;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Fonts {

    @OriginalMember(owner = "client!v", name = "k", descriptor = "I")
    public static int p11FullGroup;

    @OriginalMember(owner = "client!qw", name = "a", descriptor = "I")
    public static int p12FullGroup;

    @OriginalMember(owner = "client!uaa", name = "d", descriptor = "I")
    public static int b12FullGroup;

    @OriginalMember(owner = "client!tu", name = "i", descriptor = "Lclient!da;")
    public static Font objSpriteFont;

    @OriginalMember(owner = "client!vb", name = "y", descriptor = "Lclient!da;")
    public static Font p11;

    @OriginalMember(owner = "client!er", name = "a", descriptor = "Lclient!ve;")
    public static FontMetrics p11Metrics;

    @OriginalMember(owner = "client!np", name = "D", descriptor = "Lclient!da;")
    public static Font p12;

    @OriginalMember(owner = "client!vv", name = "y", descriptor = "Lclient!ve;")
    public static FontMetrics p12Metrics;

    @OriginalMember(owner = "client!fka", name = "l", descriptor = "Lclient!da;")
    public static Font b12;

    @OriginalMember(owner = "client!bh", name = "q", descriptor = "Lclient!ve;")
    public static FontMetrics b12Metrics;

    @OriginalMember(owner = "client!hj", name = "k", descriptor = "Lclient!da;")
    public static Font debug;

    @OriginalMember(owner = "client!tia", name = "a", descriptor = "(BLclient!sb;)V")
    public static void load(@OriginalArg(1) js5 sprites) {
        p11FullGroup = sprites.getgroupid("p11_full");
        p12FullGroup = sprites.getgroupid("p12_full");
        b12FullGroup = sprites.getgroupid("b12_full");
    }

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "(B)[I")
    public static int[] groups() {
        return new int[]{
            p11FullGroup,
            p12FullGroup,
            b12FullGroup,
        };
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(ZLclient!ha;)V")
    public static void init(@OriginalArg(1) Toolkit toolkit) {
        p11 = font(true, true, p11FullGroup, toolkit);
        p11Metrics = metrics(p11FullGroup, toolkit);

        p12 = font(true, true, p12FullGroup, toolkit);
        p12Metrics = metrics(p12FullGroup, toolkit);

        b12 = font(true, true, b12FullGroup, toolkit);
        b12Metrics = metrics(b12FullGroup, toolkit);
    }

    @OriginalMember(owner = "client!ke", name = "a", descriptor = "(ZZIILclient!ha;)Lclient!da;")
    public static Font font(@OriginalArg(0) boolean monospaced, @OriginalArg(1) boolean loadMetrics, @OriginalArg(2) int group, @OriginalArg(4) Toolkit toolkit) {
        @Pc(17) FontType type = FontTypeList.list(monospaced, toolkit, loadMetrics, group);
        return type == null ? null : type.font;
    }

    @OriginalMember(owner = "client!il", name = "a", descriptor = "(BILclient!ha;)Lclient!ve;")
    public static FontMetrics metrics(@OriginalArg(1) int group, @OriginalArg(2) Toolkit toolkit) {
        @Pc(18) FontType type = FontTypeList.list(true, toolkit, true, group);
        return type == null ? null : type.metrics;
    }

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!da;)V")
    public static void setDebugFont(@OriginalArg(0) Font font) {
        debug = font;
    }

    private Fonts() {
        /* empty */
    }
}
