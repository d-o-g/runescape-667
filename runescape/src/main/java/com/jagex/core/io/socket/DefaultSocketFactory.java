package com.jagex.core.io.socket;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.IOException;
import java.net.Socket;

@OriginalClass("client!gk")
public final class DefaultSocketFactory extends SocketFactory {

    @OriginalMember(owner = "client!gk", name = "b", descriptor = "(I)Ljava/net/Socket;")
    @Override
    public Socket open() throws IOException {
        return this.create();
    }
}
