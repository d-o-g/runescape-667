package com.jagex.core.constants;

public final class LoginStep {

    public static final int DELAY = 0;

    public static final int CONNECT = 1;

    public static final int WAIT_FOR_CONNECTION_ACK = 2;

    public static final int SEND_LOGIN_REQUEST = 3;

    public static final int WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH = 4;

    public static final int WAIT_FOR_SOCIAL_NETWORK_TOKEN = 5;

    public static final int WAIT_FOR_SSO_KEY_RESPONSE = 6;

    public static final int WAIT_FOR_SSO_KEY = 7;

    public static final int SEND_LOGIN_PACKET = 8;

    public static final int WAIT_FOR_LOGIN_RESPONSE = 9;

    public static final int WAIT_FOR_HOP_BLOCK_DURATION = 12;

    public static final int WAIT_FOR_SCRIPT_DISALLOW_REASON = 18;

    public static final int WAIT_FOR_VIDEO_ADVERTISEMENT = 10;

    public static final int VIDEO_ADVERTISEMENT_FINISHED = 11;

    public static final int WAIT_FOR_LOGIN_OK_LENGTH = 13;

    public static final int WAIT_FOR_LOGIN_DETAILS = 14;

    public static final int WAIT_FOR_PLAYER_PACKET = 15;

    public static final int WAIT_FOR_PLAYER_PACKET_LENGTH1 = 16;

    public static final int WAIT_FOR_PLAYER_PACKET_LENGTH2 = 17;

    public static final int WAIT_FOR_LOGIN_RECONNECT = 19;

    public static final int WAIT_FOR_QUEUE_POSITION = 20;

    private LoginStep() {
        /* empty */
    }
}
