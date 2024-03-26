package com.jagex.graphics.sw;

import com.jagex.core.datastruct.key.Node;
import com.jagex.graphics.sw.SoftwareObject;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!to")
public final class SoftwareObjectNode extends Node {

    @OriginalMember(owner = "client!to", name = "k", descriptor = "Lclient!e;")
    public SoftwareObject object;
}
