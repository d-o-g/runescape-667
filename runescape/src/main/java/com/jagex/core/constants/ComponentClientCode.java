package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalMember;

public final class ComponentClientCode {

    @OriginalMember(owner = "client!lr", name = "i", descriptor = "I")
    public static final int SPINNING_PLAYER = 328;

    @OriginalMember(owner = "client!fq", name = "j", descriptor = "I")
    public static final int SCENE = 1337;

    @OriginalMember(owner = "client!pka", name = "b", descriptor = "I")
    public static final int MINIMAP = 1338;

    @OriginalMember(owner = "client!gga", name = "e", descriptor = "I")
    public static final int COMPASS = 1339;

    @OriginalMember(owner = "client!bu", name = "H", descriptor = "I")
    public static final int WORLD_MAP = 1400;

    @OriginalMember(owner = "client!ek", name = "a", descriptor = "I")
    public static final int WORLD_MAP_OVERVIEW = 1401;

    @OriginalMember(owner = "client!fs", name = "a", descriptor = "I")
    public static final int LOGIN_SCENE = 1403;

    @OriginalMember(owner = "client!wb", name = "X", descriptor = "I")
    public static final int DEBUG_OVERLAY = 1405;

    @OriginalMember(owner = "client!tp", name = "d", descriptor = "I")
    public static final int WORLD_MAP_OPTIONS = 1406;

    @OriginalMember(owner = "client!lha", name = "j", descriptor = "I")
    public static final int DEBUG_OVERLAY_LAYER = 1407;

    @OriginalMember(owner = "client!ema", name = "i", descriptor = "I")
    public static final int COLOUR_CHOOSER_HUE = 1408;

    @OriginalMember(owner = "client!kq", name = "g", descriptor = "I")
    public static final int COLOUR_CHOOSER_SATURATION_VALUE = 1409;

    private ComponentClientCode() {
        /* empty */
    }
}
