package com.jagex.core.io.socket;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.IOException;

@OriginalClass("client!qla")
public final class ProxyAuthenticationException extends IOException {

    @OriginalMember(owner = "client!qla", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public ProxyAuthenticationException(@OriginalArg(0) String message) {
        super(message);
    }
}
