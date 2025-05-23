package com.jagex.game.runetek6.config.iftype;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!aha")
public final class SubInterface extends Node {

    @OriginalMember(owner = "client!aha", name = "o", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!aha", name = "n", descriptor = "I")
    public int id;
}
