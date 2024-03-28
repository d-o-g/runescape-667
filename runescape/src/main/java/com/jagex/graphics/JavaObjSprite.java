package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ln")
public final class JavaObjSprite extends Node {

    @OriginalMember(owner = "client!ln", name = "k", descriptor = "I")
    public final int objNumMode;

    @OriginalMember(owner = "client!ln", name = "p", descriptor = "I")
    public final int invCount;

    @OriginalMember(owner = "client!ln", name = "s", descriptor = "Z")
    public final boolean objWearCol;

    @OriginalMember(owner = "client!ln", name = "r", descriptor = "I")
    public final int graphicShadow;

    @OriginalMember(owner = "client!ln", name = "v", descriptor = "I")
    public final int objId;

    @OriginalMember(owner = "client!ln", name = "u", descriptor = "I")
    public final int outline;

    @OriginalMember(owner = "client!ln", name = "<init>", descriptor = "(IIIIIZ)V")
    public JavaObjSprite(@OriginalArg(0) int objId, @OriginalArg(1) int invCount, @OriginalArg(2) int outline, @OriginalArg(3) int graphicShadow, @OriginalArg(4) int objNumMode, @OriginalArg(5) boolean objWearCol) {
        this.objNumMode = objNumMode;
        this.invCount = invCount;
        this.objWearCol = objWearCol;
        this.graphicShadow = graphicShadow;
        this.objId = objId;
        this.outline = outline;
    }
}
