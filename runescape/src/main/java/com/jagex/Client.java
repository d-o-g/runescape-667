package com.jagex;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.constants.ModeWhat;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.io.BufferedFile;
import com.jagex.core.io.BufferedSocket;
import com.jagex.game.collision.CollisionMap;
import com.jagex.js5.FileSystem_Client;
import com.jagex.js5.Js5ResourceProvider;
import com.jagex.js5.Js5WorkerThread;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Color;

public final class Client {
    public static final int BUILD = 667;

    @OriginalMember(owner = "client!gha", name = "t", descriptor = "[Lclient!mj;")
    public static final BufferedFile[] cacheIndexFiles = new BufferedFile[37];

    @OriginalMember(owner = "client!ha", name = "l", descriptor = "[Lclient!pm;")
    public static final Js5ResourceProvider[] js5ResourceProviders = new Js5ResourceProvider[37];

    @OriginalMember(owner = "client!kla", name = "kb", descriptor = "[Ljava/awt/Color;")
    public static final Color[] OUTLINE_COLOURS = {
        new Color(0x8C1111),
        new Color(0xFFFFFF),
        new Color(0xFF3905),
        new Color(0xFF3905)
    };

    @OriginalMember(owner = "client!wo", name = "y", descriptor = "[Ljava/awt/Color;")
    public static final Color[] FILL_COLOURS = new Color[]{
        new Color(0x8C1111),
        new Color(0x323232),
        new Color(0x323232),
        new Color(0x323232)
    };

    @OriginalMember(owner = "client!sca", name = "d", descriptor = "[Lclient!eq;")
    public static final CollisionMap[] collisionMaps = new CollisionMap[4];

    @OriginalMember(owner = "client!maa", name = "r", descriptor = "[Ljava/lang/String;")
    public static final String[] LANGUAGE_CODES = {"en", "de", "fr", "pt", "nl"};

    @OriginalMember(owner = "client!po", name = "h", descriptor = "Lclient!pla;")
    public static Js5WorkerThread js5WorkerThread;

    @OriginalMember(owner = "client!lm", name = "r", descriptor = "I")
    public static int netWorkerDelay = 0;

    @OriginalMember(owner = "client!qha", name = "Kf", descriptor = "I")
    public static int js5Errors = 0;

    @OriginalMember(owner = "client!cs", name = "r", descriptor = "I")
    public static int js5State = 0;

    @OriginalMember(owner = "client!qca", name = "z", descriptor = "Lclient!oba;")
    public static SignedResource js5Socket;

    @OriginalMember(owner = "client!lr", name = "c", descriptor = "Ljava/lang/String;")
    public static String netProxyError = null;

    @OriginalMember(owner = "client!vea", name = "J", descriptor = "Lclient!nk;")
    public static BufferedSocket js5BufferedSocket;

    @OriginalMember(owner = "client!via", name = "O", descriptor = "J")
    public static long js5HandshakeTime;

    @OriginalMember(owner = "client!ffa", name = "e", descriptor = "Lclient!mj;")
    public static BufferedFile cacheDat;

    @OriginalMember(owner = "client!aca", name = "c", descriptor = "Lclient!mj;")
    public static BufferedFile metaFile;

    @OriginalMember(owner = "client!ila", name = "i", descriptor = "Lclient!af;")
    public static FileSystem_Client metaCache;

    @OriginalMember(owner = "client!uc", name = "n", descriptor = "[S")
    public static short[] clientpalette;

    @OriginalMember(owner = "client!mf", name = "c", descriptor = "Lclient!ul;")
    public static ModeGame modeGame = null;

    @OriginalMember(owner = "client!km", name = "c", descriptor = "I")
    public static int colourId = 0;

    @OriginalMember(owner = "client!aaa", name = "T", descriptor = "Lclient!tka;")
    public static ModeWhere modeWhere;

    @OriginalMember(owner = "client!ss", name = "h", descriptor = "Lclient!hh;")
    public static ModeWhat modeWhat;

    @OriginalMember(owner = "client!bma", name = "c", descriptor = "I")
    public static int language = 0;

    @OriginalMember(owner = "client!ol", name = "I", descriptor = "Z")
    public static boolean objectTag = false;

    @OriginalMember(owner = "client!db", name = "W", descriptor = "Z")
    public static boolean js = false;

    @OriginalMember(owner = "client!jm", name = "h", descriptor = "Z")
    public static boolean advert = false;

    @OriginalMember(owner = "client!kda", name = "j", descriptor = "I")
    public static int affid = 0;

    @OriginalMember(owner = "client!lg", name = "h", descriptor = "Ljava/lang/String;")
    public static String quitUrl;

    @OriginalMember(owner = "client!en", name = "f", descriptor = "Ljava/lang/String;")
    public static String settings = null;

    @OriginalMember(owner = "client!pb", name = "l", descriptor = "Z")
    public static boolean under13 = false;

    @OriginalMember(owner = "client!sga", name = "i", descriptor = "I")
    public static int country;

    @OriginalMember(owner = "client!b", name = "K", descriptor = "Z")
    public static boolean fromBilling = false;

    @OriginalMember(owner = "client!ov", name = "b", descriptor = "Z")
    public static boolean force64mb = false;

    @OriginalMember(owner = "client!wla", name = "k", descriptor = "I")
    public static int worldFlags = 0;

    @OriginalMember(owner = "client!iea", name = "i", descriptor = "[B")
    public static byte[] ssKey = null;

    @OriginalMember(owner = "client!nca", name = "q", descriptor = "J")
    public static long userFlow = 0L;

    @OriginalMember(owner = "client!md", name = "G", descriptor = "Ljava/lang/String;")
    public static String addtionalInfo = null;

    @OriginalMember(owner = "client!nca", name = "k", descriptor = "Z")
    public static boolean hc = false;

    @OriginalMember(owner = "client!jk", name = "J", descriptor = "I")
    public static int loadingScreenWidth = 765;

    @OriginalMember(owner = "client!pc", name = "b", descriptor = "I")
    public static int loadingScreenHeight = 503;

    @OriginalMember(owner = "client!df", name = "l", descriptor = "Z")
    public static boolean displayFps = false;

    @OriginalMember(owner = "client!vba", name = "H", descriptor = "Z")
    public static boolean cleanCaches = false;

    @OriginalMember(owner = "client!q", name = "j", descriptor = "Z")
    public static boolean sitesettingsMember = false;

    @OriginalMember(owner = "client!du", name = "d", descriptor = "Z")
    public static boolean isMember = false;

    @OriginalMember(owner = "client!gp", name = "i", descriptor = "I")
    public static int mouseButtons = 0;

    @OriginalMember(owner = "client!br", name = "z", descriptor = "I")
    public static int disableChatEffects = 0;

    @OriginalMember(owner = "client!qda", name = "q", descriptor = "Ljava/lang/String;")
    public static String playerDisplayName;

    @OriginalMember(owner = "client!jea", name = "t", descriptor = "J")
    public static long playerDisplayNameEncoded;

    @OriginalMember(owner = "client!td", name = "n", descriptor = "I")
    public static int staffModLevel = 0;

    @OriginalMember(owner = "client!fa", name = "b", descriptor = "[[[J")
    public static long[][][] tileLightFlags;

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "(BLjava/lang/String;)V")
    public static void error(@OriginalArg(1) String arg0) {
        System.exit(1);
    }

    @OriginalMember(owner = "client!ra", name = "a", descriptor = "(Ljava/lang/String;Z)I")
    public static int languageIndex(@OriginalArg(0) String language) {
        for (@Pc(7) int i = 0; i < LANGUAGE_CODES.length; i++) {
            if (LANGUAGE_CODES[i].equalsIgnoreCase(language)) {
                return i;
            }
        }
        return -1;
    }
}
