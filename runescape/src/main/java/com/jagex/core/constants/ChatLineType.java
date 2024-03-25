package com.jagex.core.constants;

public final class ChatLineType {
    public static final int SCRIPT = 0;
    public static final int PUBLIC_RANK = 1;
    public static final int PUBLIC = 2;
    public static final int PRIVATE = 3;
    public static final int PRIVATE_ERROR = 4;
    public static final int PRIVATE_ECHO = 6;
    public static final int PRIVATE_RANK = 7;
    public static final int FRIENDCHANNEL = 9;
    public static final int QUICKCHAT_PUBLIC = 17;
    public static final int QUICKCHAT_PRIVATE = 18;
    public static final int QUICKCHAT_PRIVATE_ECHO = 19;
    public static final int QUICKCHAT_FRIENDCHAT = 20;
    public static final int PLAYER_GROUP = 24;
    public static final int QUICKCHAT_PLAYER_GROUP = 25;
    public static final int CLANCHANNEL_AFFINED = 41;
    public static final int QUICKCHAT_CLANCHANNEL_AFFINED = 42;
    public static final int CLANCHANNEL_UNAFFINED = 44;
    public static final int QUICKCHAT_CLANCHANNEL_UNAFFINED = 45;
    public static final int CONSOLE_SET = 98;
    public static final int CONSOLE_PRINT = 99;

    private ChatLineType() {
        /* empty */
    }
}
