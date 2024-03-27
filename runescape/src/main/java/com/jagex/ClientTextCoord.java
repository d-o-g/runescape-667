package com.jagex;

import com.jagex.core.datastruct.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bfa")
public final class ClientTextCoord extends Node {

    @OriginalMember(owner = "client!bfa", name = "m", descriptor = "I")
    public int end;

    @OriginalMember(owner = "client!bfa", name = "g", descriptor = "I")
    public int z;

    @OriginalMember(owner = "client!bfa", name = "k", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!bfa", name = "q", descriptor = "I")
    public int colour;

    @OriginalMember(owner = "client!bfa", name = "f", descriptor = "Ljava/lang/String;")
    public String text;

    @OriginalMember(owner = "client!bfa", name = "i", descriptor = "I")
    public int level;

    @OriginalMember(owner = "client!bfa", name = "h", descriptor = "I")
    public int x;
}
