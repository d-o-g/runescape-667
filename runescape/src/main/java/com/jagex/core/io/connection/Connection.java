package com.jagex.core.io.connection;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.IOException;
import java.net.Socket;

@OriginalClass("client!vn")
public abstract class Connection {

    @OriginalMember(owner = "client!dba", name = "a", descriptor = "(Ljava/net/Socket;IB)Lclient!vn;")
    public static Connection create(@OriginalArg(0) Socket socket) throws IOException {
        return new AsyncDuplexConnection(socket, 15000);
    }

    @OriginalMember(owner = "client!vn", name = "<init>", descriptor = "()V")
    protected Connection() {
    }

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "(I)V")
    public abstract void close();

    @OriginalMember(owner = "client!vn", name = "b", descriptor = "(I)V")
    public abstract void breakConnection();

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "(B[BII)I")
    public abstract int read(@OriginalArg(1) byte[] buf, @OriginalArg(2) int len, @OriginalArg(3) int off) throws IOException;

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "([BIBI)V")
    public abstract void write(@OriginalArg(0) byte[] buf, @OriginalArg(1) int len, @OriginalArg(3) int off) throws IOException;

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "(II)Z")
    public abstract boolean hasAvailable(@OriginalArg(0) int arg0) throws IOException;
}
