package com.jagex.graphics.sw;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!e")
public interface SoftwareObject {

    /**
     * free
     */
    @OriginalMember(owner = "client!e", name = "w", descriptor = "(Z)V")
    void w(@OriginalArg(0) boolean arg0);
}
