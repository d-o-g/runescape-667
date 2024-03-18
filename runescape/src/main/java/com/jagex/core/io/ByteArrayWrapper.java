package com.jagex.core.io;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lla")
public abstract class ByteArrayWrapper {

    @OriginalMember(owner = "client!ec", name = "H", descriptor = "Z")
    private static boolean errored = false;

    @OriginalMember(owner = "client!ls", name = "a", descriptor = "(BZLjava/lang/Object;)[B")
    public static byte[] unwrap(@OriginalArg(1) boolean copy, @OriginalArg(2) Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof byte[]) {
            @Pc(14) byte[] data = (byte[]) object;
            return copy ? Arrays.copy(data) : data;
        } else if (object instanceof ByteArrayWrapper) {
            @Pc(29) ByteArrayWrapper wrapper = (ByteArrayWrapper) object;
            return wrapper.get();
        } else {
            throw new IllegalArgumentException("Not a ByteBuffer!");
        }
    }

    @OriginalMember(owner = "client!bw", name = "a", descriptor = "(ILjava/lang/Object;II)[B")
    public static byte[] unwrap(@OriginalArg(0) int len, @OriginalArg(1) Object data, @OriginalArg(3) int off) {
        if (data == null) {
            return null;
        } else if (data instanceof byte[]) {
            @Pc(14) byte[] copy = (byte[]) data;
            return Arrays.copy(off, len, copy);
        } else if (data instanceof ByteArrayWrapper) {
            @Pc(32) ByteArrayWrapper wrapper = (ByteArrayWrapper) data;
            return wrapper.get(len, off);
        } else {
            throw new IllegalArgumentException("Not a ByteBuffer!");
        }
    }

    @OriginalMember(owner = "client!hla", name = "a", descriptor = "([BIZ)Ljava/lang/Object;")
    public static Object wrap(@OriginalArg(0) byte[] data) {
        if (data == null) {
            return null;
        }

        if (data.length > 136 && !errored) {
            try {
                @Pc(25) ByteArrayWrapper wrapper = (ByteArrayWrapper) Class.forName("com.jagex.core.io.ByteBufferArrayWrapper").getDeclaredConstructor().newInstance();
                wrapper.wrap(data, 0);
                return wrapper;
            } catch (@Pc(32) Throwable ignored) {
                errored = true;
            }
        }

        return data;
    }

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "(BII)[B")
    public abstract byte[] get(int len, @OriginalArg(2) int off);

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "([BI)V")
    public abstract void wrap(@OriginalArg(0) byte[] data, int off);

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "(B)[B")
    public abstract byte[] get();
}
