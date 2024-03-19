package com.jagex;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!oba")
public final class SignedResource {

    @OriginalMember(owner = "client!oba", name = "a", descriptor = "I")
    public int intData2;

    @OriginalMember(owner = "client!oba", name = "b", descriptor = "I")
    public int intData1;

    @OriginalMember(owner = "client!oba", name = "e", descriptor = "Ljava/lang/Object;")
    public Object objectData;

    @OriginalMember(owner = "client!oba", name = "c", descriptor = "Lclient!oba;")
    public SignedResource next;

    @OriginalMember(owner = "client!oba", name = "f", descriptor = "Ljava/lang/Object;")
    public volatile Object result;

    @OriginalMember(owner = "client!oba", name = "d", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!oba", name = "g", descriptor = "I")
    public volatile int status = 0;
}
