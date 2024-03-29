package com.jagex.game.runetek6.config.iftype;

import org.openrs2.deob.annotation.OriginalMember;

public final class DragRenderBehaviour {

    @OriginalMember(owner = "client!laa", name = "n", descriptor = "I")
    public static final int OFFSET_TRANSPARENT = 0;

    @OriginalMember(owner = "client!ef", name = "n", descriptor = "I")
    public static final int FIXED = 1;

    @OriginalMember(owner = "client!hga", name = "q", descriptor = "I")
    public static final int OFFSET = 2;

    private DragRenderBehaviour() {
        /* empty */
    }
}
