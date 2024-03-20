package com.jagex.graphics;

import com.jagex.graphics.Model;
import com.jagex.graphics.Shadow;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!od")
public final class ModelAndShadow {

    @OriginalMember(owner = "client!od", name = "j", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!od", name = "m", descriptor = "Lclient!r;")
    public Shadow shadow;
}
