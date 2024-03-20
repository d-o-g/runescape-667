package com.jagex.js5;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vp")
public final class Js5ResourceRequest extends ResourceRequest {

    public static final int TYPE_READ_URGENT = 1;
    public static final int TYPE_WRITE = 2;
    public static final int TYPE_VERIFY = 3;

    @OriginalMember(owner = "client!vp", name = "H", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!vp", name = "J", descriptor = "Lclient!af;")
    public FileSystem_Client fileSystem;

    @OriginalMember(owner = "client!vp", name = "z", descriptor = "[B")
    public byte[] data;

    @OriginalMember(owner = "client!vp", name = "c", descriptor = "(B)I")
    @Override
    public int completePercentage() {
        return super.incomplete ? 0 : 100;
    }

    @OriginalMember(owner = "client!vp", name = "a", descriptor = "(I)[B")
    @Override
    public byte[] getData() {
        if (super.incomplete) {
            throw new RuntimeException();
        } else {
            return this.data;
        }
    }
}
