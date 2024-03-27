package com.jagex.core.constants;

public final class LoginResponseCode {
    public static final int CONNECTION_TIMED_OUT = -5;
    public static final int ERROR_CONNECTING_TO_SERVER = -4;
    public static final int LOGGING_IN = -3;
    public static final int DEFAULT = -2;
    public static final int VIDEO_ADVERTISEMENT = 1;
    public static final int EXCHANGE_KEYS = 0;
    public static final int OK = 2;
    public static final int INVALID_USERNAME_OR_PASSWORD = 3;
    public static final int RECONNECT_OK = 15;
    public static final int HOP_BLOCKED = 21;
    public static final int LOGIN_SERVER_NO_REPLY = 23;
    public static final int DISALLOWED_BY_SCRIPT = 29;
    public static final int INVALID_SINGLE_SIGNON = 35;
    public static final int IN_QUEUE = 42;
    public static final int CANNOT_ENTER_INSTANCE = 45;

    private LoginResponseCode() {
        /* empty */
    }
}
