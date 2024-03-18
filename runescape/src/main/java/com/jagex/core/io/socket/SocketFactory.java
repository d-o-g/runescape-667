package com.jagex.core.io.socket;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;

@OriginalClass("client!cca")
public abstract class SocketFactory {

    @OriginalMember(owner = "client!cca", name = "a", descriptor = "I")
    public int port;

    @OriginalMember(owner = "client!cca", name = "b", descriptor = "Ljava/lang/String;")
    public String host;

    @OriginalMember(owner = "client!kg", name = "a", descriptor = "(BLjava/lang/String;I)Lclient!cca;")
    public static SocketFactory create(@OriginalArg(1) String host, @OriginalArg(2) int port) {
        @Pc(10) SocketFactory factory;
        try {
            factory = (SocketFactory) Class.forName("com.jagex.core.io.socket.ProxySocketFactory").getDeclaredConstructor().newInstance();
        } catch (@Pc(12) Throwable local12) {
            factory = new DefaultSocketFactory();
        }
        factory.port = port;
        factory.host = host;
        return factory;
    }

    @OriginalMember(owner = "client!cca", name = "a", descriptor = "(Z)Ljava/net/Socket;")
    protected final Socket create() throws IOException {
        return new Socket(this.host, this.port);
    }

    @OriginalMember(owner = "client!cca", name = "b", descriptor = "(I)Ljava/net/Socket;")
    public abstract Socket open() throws IOException;
}
