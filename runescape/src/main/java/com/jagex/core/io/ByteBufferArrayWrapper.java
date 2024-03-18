package com.jagex.core.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.nio.ByteBuffer;

@OriginalClass("client!id")
public final class ByteBufferArrayWrapper extends ByteArrayWrapper {

    @OriginalMember(owner = "client!id", name = "g", descriptor = "Ljava/nio/ByteBuffer;")
    public ByteBuffer buffer;

    @OriginalMember(owner = "client!id", name = "<init>", descriptor = "()V")
    public ByteBufferArrayWrapper() {
    }

    @OriginalMember(owner = "client!id", name = "a", descriptor = "([BI)V")
    @Override
    public void wrap(@OriginalArg(0) byte[] data, @OriginalArg(1) int off) {
        this.buffer = ByteBuffer.allocateDirect(data.length);
        this.buffer.position(off);
        this.buffer.put(data);
    }

    @OriginalMember(owner = "client!id", name = "a", descriptor = "(BII)[B")
    @Override
    public byte[] get(@OriginalArg(1) int len, @OriginalArg(2) int off) {
        @Pc(2) byte[] data = new byte[len];
        this.buffer.position(off);
        this.buffer.get(data, 0, len);
        return data;
    }

    @OriginalMember(owner = "client!id", name = "a", descriptor = "(B)[B")
    @Override
    public byte[] get() {
        @Pc(4) byte[] local4 = new byte[this.buffer.capacity()];
        this.buffer.position(0);
        this.buffer.get(local4);
        return local4;
    }
}
