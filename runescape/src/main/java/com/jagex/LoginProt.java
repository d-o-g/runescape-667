package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hja")
public final class LoginProt {

    @OriginalMember(owner = "client!s", name = "g", descriptor = "Lclient!hja;")
    public static final LoginProt INIT_GAME_CONNECTION = new LoginProt(14, 0);

    @OriginalMember(owner = "client!s", name = "y", descriptor = "Lclient!hja;")
    public static final LoginProt INIT_JS5REMOTE_CONNECTION = new LoginProt(15, 4);

    @OriginalMember(owner = "client!s", name = "u", descriptor = "Lclient!hja;")
    public static final LoginProt GAMELOGIN = new LoginProt(16, -2);

    @OriginalMember(owner = "client!s", name = "z", descriptor = "Lclient!hja;")
    public static final LoginProt GAMELOGIN_RECONNECT = new LoginProt(17, 0);

    @OriginalMember(owner = "client!s", name = "r", descriptor = "Lclient!hja;")
    public static final LoginProt LOBBYLOGIN = new LoginProt(19, -2);

    @OriginalMember(owner = "client!s", name = "q", descriptor = "Lclient!hja;")
    public static final LoginProt CREATE_ACCOUNT_CONNECT = new LoginProt(22, -2);

    @OriginalMember(owner = "client!s", name = "v", descriptor = "Lclient!hja;")
    public static final LoginProt REQUEST_WORLDLIST = new LoginProt(23, 4);

    @OriginalMember(owner = "client!s", name = "p", descriptor = "Lclient!hja;")
    public static final LoginProt CHECK_WORLD_SUITABILITY = new LoginProt(24, -1);

    @OriginalMember(owner = "client!s", name = "h", descriptor = "Lclient!hja;")
    public static final LoginProt GAMELOGIN_CONTINUE = new LoginProt(26, 0);

    @OriginalMember(owner = "client!s", name = "m", descriptor = "Lclient!hja;")
    public static final LoginProt SSL_WEBCONNECTION = new LoginProt(27, 0);

    @OriginalMember(owner = "client!s", name = "f", descriptor = "Lclient!hja;")
    public static final LoginProt CHECK_EMAIL = new LoginProt(28, -2);

    @OriginalMember(owner = "client!s", name = "l", descriptor = "Lclient!hja;")
    public static final LoginProt INIT_SOCIAL_NETWORK_CONNECTION = new LoginProt(29, -2);

    @OriginalMember(owner = "client!s", name = "j", descriptor = "Lclient!hja;")
    public static final LoginProt SOCIAL_NETWORK_LOGIN = new LoginProt(30, -2);

    @OriginalMember(owner = "client!s", name = "w", descriptor = "[Lclient!hja;")
    public static final LoginProt[] VALUES_BY_OPCODE = new LoginProt[32];

    static {
        @Pc(140) LoginProt[] values = values();

        for (@Pc(142) int i = 0; i < values.length; i++) {
            VALUES_BY_OPCODE[values[i].opcode] = values[i];
        }
    }

    @OriginalMember(owner = "client!hr", name = "d", descriptor = "(I)[Lclient!hja;")
    public static LoginProt[] values() {
        return new LoginProt[]{
            INIT_GAME_CONNECTION,
            INIT_JS5REMOTE_CONNECTION,
            GAMELOGIN,
            GAMELOGIN_RECONNECT,
            LOBBYLOGIN,
            CREATE_ACCOUNT_CONNECT,
            REQUEST_WORLDLIST,
            CHECK_WORLD_SUITABILITY,
            GAMELOGIN_CONTINUE,
            SSL_WEBCONNECTION,
            CHECK_EMAIL,
            INIT_SOCIAL_NETWORK_CONNECTION,
            SOCIAL_NETWORK_LOGIN,
        };
    }

    @OriginalMember(owner = "client!hja", name = "a", descriptor = "I")
    public final int opcode;

    @OriginalMember(owner = "client!hja", name = "<init>", descriptor = "(II)V")
    public LoginProt(@OriginalArg(0) int opcode, @OriginalArg(1) int length) {
        this.opcode = opcode;
    }

    @OriginalMember(owner = "client!hja", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
