package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class MainLogicStep {

    public static final int STEP_LOADING = 0;

    public static final int STEP_LOADING_1 = 1;

    public static final int STEP_LOADING_2 = 2;

    public static final int STEP_LOGIN_SCREEN = 3;

    public static final int STEP_LOGIN_SCREEN_MAP_BUILD = 4;

    public static final int STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_LOBBY = 5;

    public static final int STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_GAME = 6;

    public static final int STEP_LOBBY_SCREEN = 7;

    public static final int STEP_LOBBY_SCREEN_MAP_BUILD = 8;

    public static final int STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME = 9;

    public static final int STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME_MAP_BUILD = 10;

    public static final int STEP_GAME_SCREEN = 11;

    public static final int STEP_GAME_SCREEN_MAP_BUILD = 12;

    public static final int STEP_LOGGING_IN_FROM_GAMESCREEN_TO_LOBBY = 13;

    public static final int STEP_RECONNECTING = 14;

    public static final int STEP_SWITCH_WORLD = 15;

    public static final int STEP_ERROR = 16;

    @OriginalMember(owner = "client!fl", name = "a", descriptor = "(II)Z")
    public static boolean isLoading(@OriginalArg(0) int step) {
        return step == STEP_LOADING
            || step == STEP_LOADING_1
            || step == STEP_LOADING_2;
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(II)Z")
    public static boolean isAtLoadingScreen(@OriginalArg(0) int step) {
        return step == STEP_LOGIN_SCREEN
            || step == STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_LOBBY
            || step == STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_GAME;
    }

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "(BI)Z")
    public static boolean isAtLobbyScreen(@OriginalArg(1) int step) {
        return step == STEP_LOBBY_SCREEN
            || step == STEP_LOBBY_SCREEN_MAP_BUILD
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME_MAP_BUILD;
    }

    @OriginalMember(owner = "client!dh", name = "b", descriptor = "(II)Z")
    public static boolean isAtGameScreen(@OriginalArg(0) int step) {
        return step == STEP_GAME_SCREEN
            || step == STEP_GAME_SCREEN_MAP_BUILD
            || step == STEP_LOGGING_IN_FROM_GAMESCREEN_TO_LOBBY;
    }

    @OriginalMember(owner = "client!bg", name = "a", descriptor = "(II)Z")
    public static boolean isLoggedOut(@OriginalArg(0) int step) {
        return step == STEP_LOGIN_SCREEN
            || step == STEP_LOGIN_SCREEN_MAP_BUILD
            || step == STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_LOBBY
            || step == STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_GAME;
    }

    @OriginalMember(owner = "client!maa", name = "a", descriptor = "(IB)Z")
    public static boolean method5393(@OriginalArg(0) int step) {
        return step == STEP_LOBBY_SCREEN
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME;
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(II)Z")
    public static boolean isBuildingMap(@OriginalArg(0) int step) {
        return step == STEP_LOGIN_SCREEN_MAP_BUILD
            || step == STEP_LOBBY_SCREEN_MAP_BUILD
            || step == STEP_GAME_SCREEN_MAP_BUILD
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME_MAP_BUILD;
    }

    private MainLogicStep() {
        /* empty */
    }
}
