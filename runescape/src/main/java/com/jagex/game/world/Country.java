package com.jagex.game.world;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ci")
public final class Country {

    @OriginalMember(owner = "client!qb", name = "i", descriptor = "[Lclient!ci;")
    public static Country[] countries;

    @OriginalMember(owner = "client!ci", name = "e", descriptor = "I")
    public int flag;

    @OriginalMember(owner = "client!ci", name = "j", descriptor = "Ljava/lang/String;")
    public String name;
}
