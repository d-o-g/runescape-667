package com.jagex;

import com.jagex.core.datastruct.Queue;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lk")
public final class ParticleList {

    @OriginalMember(owner = "client!lk", name = "d", descriptor = "Lclient!et;")
    public final Queue particles = new Queue();
}
