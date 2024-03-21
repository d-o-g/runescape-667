package com.jagex.core.io.connection;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;

@OriginalClass("client!tc")
public final class AsyncDuplexConnection extends Connection {

    @OriginalMember(owner = "client!tc", name = "p", descriptor = "Ljava/net/Socket;")
    public final Socket socket;

    @OriginalMember(owner = "client!tc", name = "e", descriptor = "Lclient!je;")
    public final ClientStreamReader reader;

    @OriginalMember(owner = "client!tc", name = "i", descriptor = "Lclient!vja;")
    public final ClientStreamWriter writer;

    @OriginalMember(owner = "client!tc", name = "<init>", descriptor = "(Ljava/net/Socket;I)V")
    public AsyncDuplexConnection(@OriginalArg(0) Socket socket, @OriginalArg(1) int size) throws IOException {
        this.socket = socket;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.reader = new ClientStreamReader(this.socket.getInputStream(), size);
        this.writer = new ClientStreamWriter(this.socket.getOutputStream(), size);
    }

    @OriginalMember(owner = "client!tc", name = "a", descriptor = "([BIBI)V")
    @Override
    public void write(@OriginalArg(0) byte[] buf, @OriginalArg(1) int len, @OriginalArg(3) int off) throws IOException {
        this.writer.write(buf, len, off);
    }

    @OriginalMember(owner = "client!tc", name = "a", descriptor = "(B[BII)I")
    @Override
    public int read(@OriginalArg(1) byte[] buf, @OriginalArg(2) int len, @OriginalArg(3) int off) throws IOException {
        return this.reader.read(len, off, buf);
    }

    @OriginalMember(owner = "client!tc", name = "a", descriptor = "(II)Z")
    @Override
    public boolean hasAvailable(@OriginalArg(0) int n) throws IOException {
        return this.reader.hasAvailable(n);
    }

    @OriginalMember(owner = "client!tc", name = "a", descriptor = "(I)V")
    @Override
    public void close() {
        try {
            this.socket.close();
        } catch (@Pc(11) IOException ignored) {
            /* empty */
        }

        this.reader.stop();
        this.writer.stop();
    }

    @OriginalMember(owner = "client!tc", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        this.close();
    }

    @OriginalMember(owner = "client!tc", name = "b", descriptor = "(I)V")
    @Override
    public void breakConnection() {
        this.reader.reset();
        this.writer.reset();
    }
}
