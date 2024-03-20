package com.jagex;

import com.jagex.collect.Deque;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hma")
public final class ChangeLocationRequest extends Deque.Node {

    @OriginalMember(owner = "client!hma", name = "u", descriptor = "I")
    public int originalId;

    @OriginalMember(owner = "client!hma", name = "D", descriptor = "Lclient!gp;")
    public LocTypeCustomisation customisation;

    @OriginalMember(owner = "client!hma", name = "t", descriptor = "I")
    public int anInt4006;

    @OriginalMember(owner = "client!hma", name = "s", descriptor = "I")
    public int originalShape;

    @OriginalMember(owner = "client!hma", name = "o", descriptor = "I")
    public int anInt4010;

    @OriginalMember(owner = "client!hma", name = "z", descriptor = "I")
    public int layer;

    @OriginalMember(owner = "client!hma", name = "w", descriptor = "I")
    public int anInt4012;

    @OriginalMember(owner = "client!hma", name = "p", descriptor = "I")
    public int anInt4013;

    @OriginalMember(owner = "client!hma", name = "q", descriptor = "I")
    public int anInt4014;

    @OriginalMember(owner = "client!hma", name = "y", descriptor = "I")
    public int originalRotation;

    @OriginalMember(owner = "client!hma", name = "m", descriptor = "I")
    public int anInt4016;

    @OriginalMember(owner = "client!hma", name = "r", descriptor = "Z")
    public boolean aBoolean309 = false;

    @OriginalMember(owner = "client!hma", name = "C", descriptor = "Z")
    public boolean aBoolean310 = true;
}
