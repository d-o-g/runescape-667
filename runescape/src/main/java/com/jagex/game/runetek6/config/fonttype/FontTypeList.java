package com.jagex.game.runetek6.config.fonttype;

import com.jagex.IndexedImage;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class FontTypeList {

    private static final int DEFAULT_CACHE_SIZE = 20;

    @OriginalMember(owner = "client!ts", name = "k", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "[I")
    private static int[] groups = null;

    @OriginalMember(owner = "client!hga", name = "v", descriptor = "Lclient!sb;")
    private static js5 metricsJs5;

    @OriginalMember(owner = "client!ria", name = "c", descriptor = "Lclient!sb;")
    private static js5 spritesJs5;

    @OriginalMember(owner = "client!lt", name = "z", descriptor = "[Lclient!cl;")
    private static FontType[] aFontTypeArray1 = null;

    @OriginalMember(owner = "client!cl", name = "a", descriptor = "(BLclient!sb;Lclient!sb;[I)V")
    public static void init(@OriginalArg(1) js5 metricsJs5, @OriginalArg(2) js5 spritesJs5, @OriginalArg(3) int[] groups) {
        FontTypeList.spritesJs5 = spritesJs5;
        FontTypeList.metricsJs5 = metricsJs5;

        if (groups != null) {
            FontTypeList.groups = groups;
        }
    }

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(ZBLclient!ha;ZI)Lclient!cl;")
    public static FontType list(@OriginalArg(0) boolean monospaced, @OriginalArg(2) Toolkit toolkit, @OriginalArg(3) boolean loadMetrics, @OriginalArg(4) int group) {
        if (group == -1) {
            return null;
        }

        if (groups != null) {
            for (@Pc(14) int i = 0; i < groups.length; i++) {
                if (groups[i] == group) {
                    return aFontTypeArray1[i];
                }
            }
        }

        @Pc(54) FontType type = (FontType) recentUse.get((monospaced ? 1 : 0) | group << 1);
        if (type != null) {
            if (loadMetrics && type.metrics == null) {
                @Pc(70) FontMetrics metrics = FontMetrics.loadFile(group, metricsJs5);
                if (metrics == null) {
                    return null;
                }

                type.metrics = metrics;
            }

            return type;
        }

        @Pc(84) IndexedImage[] images = IndexedImage.load(spritesJs5, group);
        if (images == null) {
            return null;
        }

        @Pc(94) FontMetrics metrics = FontMetrics.loadFile(group, metricsJs5);
        if (metrics == null) {
            return null;
        }

        if (loadMetrics) {
            type = new FontType(toolkit.createFont(metrics, images, monospaced), metrics);
        } else {
            type = new FontType(toolkit.createFont(metrics, images, monospaced));
        }

        recentUse.put(type, group << 1 | (monospaced ? 1 : 0));
        return type;
    }

    @OriginalMember(owner = "client!ds", name = "a", descriptor = "(B)V")
    public static void cacheReset() {
        recentUse.reset();
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(II)V")
    public static void cacheClean(@OriginalArg(0) int maxAge) {
        recentUse.clean(maxAge);
    }

    @OriginalMember(owner = "client!rga", name = "c", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        recentUse.removeSoftReferences();
    }

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "(I)I")
    public static int readyCount() {
        return readyCount(false);
    }

    @OriginalMember(owner = "client!ln", name = "a", descriptor = "(ZZ)I")
    public static int readyCount(@OriginalArg(0) boolean arg0) {
        if (groups == null) {
            return 0;
        } else if (arg0 || aFontTypeArray1 == null) {
            @Pc(29) int count = 0;

            for (@Pc(31) int i = 0; i < groups.length; i++) {
                @Pc(36) int group = groups[i];

                if (spritesJs5.fileready(group)) {
                    count++;
                }

                if (metricsJs5.fileready(group)) {
                    count++;
                }
            }

            return count;
        } else {
            return groups.length * 2;
        }
    }

    @OriginalMember(owner = "client!wl", name = "c", descriptor = "(I)I")
    public static int totalCount() {
        return groups == null ? 0 : groups.length * 2;
    }

    @OriginalMember(owner = "client!rv", name = "a", descriptor = "(BLclient!ha;)V")
    public static void method7549(@OriginalArg(1) Toolkit toolkit) {
        aFontTypeArray1 = new FontType[groups.length];
        for (@Pc(14) int i = 0; i < groups.length; i++) {
            @Pc(19) int group = groups[i];
            @Pc(24) FontMetrics metrics = FontMetrics.loadFile(group, metricsJs5);
            @Pc(32) Font font = toolkit.createFont(metrics, IndexedImage.load(spritesJs5, group), true);
            aFontTypeArray1[i] = new FontType(font, metrics);
        }
    }

    @OriginalMember(owner = "client!ev", name = "b", descriptor = "(I)V")
    public static void method2569() {
        aFontTypeArray1 = null;
    }

    private FontTypeList() {
        /* empty */
    }
}
