package com.jagex.collect.ref;

import com.jagex.collect.LinkedHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vw")
public abstract class ReferenceNode extends LinkedHashTable.Node {

    @OriginalMember(owner = "client!vw", name = "w", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!vw", name = "<init>", descriptor = "(I)V")
    protected ReferenceNode(@OriginalArg(0) int size) {
        this.size = size;
    }

    @OriginalMember(owner = "client!vw", name = "c", descriptor = "(B)Ljava/lang/Object;")
    public abstract Object get();

    @OriginalMember(owner = "client!vw", name = "d", descriptor = "(I)Z")
    public abstract boolean isSoft();
}
