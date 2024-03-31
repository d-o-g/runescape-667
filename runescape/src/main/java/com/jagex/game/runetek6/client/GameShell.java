package com.jagex.game.runetek6.client;

import com.jagex.Canvas_Sub1;
import com.jagex.core.util.TickScheduler;
import rs2.client.loading.library.LibraryManager;
import com.jagex.sign.SignLink;
import com.jagex.sign.SignedResource;
import com.jagex.sign.SignedResourceStatus;
import com.jagex.Static14;
import com.jagex.core.io.BufferedFile;
import com.jagex.core.io.Packet;
import com.jagex.core.util.JagException;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.graphics.sw.SoftwareMemoryManager;
import jagex3.jagmisc.jagmisc;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

@OriginalClass("client!kh")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

    private static final long UPDATE_FPS_INTERVAL = 1000000000L;

    @OriginalMember(owner = "client!gr", name = "v", descriptor = "[J")
    public static final long[] tickTimes = new long[32];

    @OriginalMember(owner = "client!pa", name = "b", descriptor = "[J")
    public static final long[] drawTimes = new long[32];

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "Ljava/applet/Applet;")
    public static Applet loaderApplet;

    @OriginalMember(owner = "client!ka", name = "i", descriptor = "Ljava/awt/Frame;")
    public static Frame fsframe;

    @OriginalMember(owner = "client!lv", name = "b", descriptor = "I")
    public static int canvasHei;

    @OriginalMember(owner = "client!vja", name = "h", descriptor = "I")
    public static int canvasWid;

    @OriginalMember(owner = "client!hia", name = "d", descriptor = "I")
    public static int topMargin = 0;

    @OriginalMember(owner = "client!eda", name = "g", descriptor = "I")
    public static int leftMargin = 0;

    @OriginalMember(owner = "client!ema", name = "j", descriptor = "Lclient!kh;")
    public static GameShell instance = null;

    @OriginalMember(owner = "client!cr", name = "k", descriptor = "Z")
    public static boolean focus;

    @OriginalMember(owner = "client!gga", name = "i", descriptor = "Z")
    public static volatile boolean focus_in = true;

    @OriginalMember(owner = "client!mf", name = "d", descriptor = "I")
    public static int tickTimeIndex;

    @OriginalMember(owner = "client!nla", name = "T", descriptor = "Ljava/awt/Canvas;")
    public static Canvas canvas;

    @OriginalMember(owner = "client!vaa", name = "gb", descriptor = "Z")
    public static volatile boolean fullredraw = true;

    @OriginalMember(owner = "client!wu", name = "B", descriptor = "Z")
    public static volatile boolean canvasReplaceRecommended = false;

    @OriginalMember(owner = "client!ema", name = "f", descriptor = "J")
    public static volatile long lastCanvasReplace = 0L;

    @OriginalMember(owner = "client!lca", name = "n", descriptor = "Ljava/awt/Frame;")
    public static Frame frame;

    @OriginalMember(owner = "client!hn", name = "b", descriptor = "Z")
    public static boolean shutdown = false;

    @OriginalMember(owner = "client!ke", name = "e", descriptor = "J")
    public static long logicUpdateInterval = 20000000L;

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "I")
    public static int maxmemory = 64;

    @OriginalMember(owner = "client!tb", name = "c", descriptor = "J")
    public static long killtime = 0L;

    @OriginalMember(owner = "client!wga", name = "b", descriptor = "I")
    public static int drawTimeIndex;

    @OriginalMember(owner = "client!uka", name = "o", descriptor = "I")
    public static int currentFps = 0;

    @OriginalMember(owner = "client!fe", name = "h", descriptor = "I")
    public static int drawCount = 500;

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "I")
    public static int anInt941 = 0;

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "Z")
    public static boolean java5OrLater = false;

    @OriginalMember(owner = "client!pk", name = "m", descriptor = "I")
    public static int cpucount = 1;

    @OriginalMember(owner = "client!sv", name = "hb", descriptor = "Lclient!nl;")
    public static TickScheduler tickScheduler;

    @OriginalMember(owner = "client!bba", name = "Z", descriptor = "I")
    public static int scheduledTicks;

    // $FF: synthetic field
    @OriginalMember(owner = "client!nda", name = "J", descriptor = "Ljava/lang/Class;")
    public static Class aClass21;

    // $FF: synthetic field
    @OriginalMember(owner = "client!el", name = "Z", descriptor = "Ljava/lang/Class;")
    public static Class aClass7;

    @OriginalMember(owner = "client!bo", name = "g", descriptor = "I")
    public static int frameWid;

    @OriginalMember(owner = "client!bq", name = "C", descriptor = "I")
    public static int frameHei;

    @OriginalMember(owner = "client!tw", name = "w", descriptor = "Ljava/applet/Applet;")
    public static Applet sourceApplet;

    @OriginalMember(owner = "client!lo", name = "e", descriptor = "I")
    public static int clientBuild;

    @OriginalMember(owner = "client!vq", name = "D", descriptor = "Ljava/lang/String;")
    public static String javaVendor;

    @OriginalMember(owner = "client!vq", name = "q", descriptor = "Ljava/lang/String;")
    public static String javaVersion;

    @OriginalMember(owner = "client!vq", name = "v", descriptor = "Ljava/lang/reflect/Method;")
    public static Method setFocusCycleRoot;

    @OriginalMember(owner = "client!oaa", name = "b", descriptor = "Lclient!vq;")
    public static SignLink signLink;

    @OriginalMember(owner = "client!kga", name = "M", descriptor = "I")
    public static int lastFullscreenWidth;

    @OriginalMember(owner = "client!dha", name = "s", descriptor = "I")
    public static int lastFullscreenHeight;

    @OriginalMember(owner = "client!pea", name = "i", descriptor = "Ljava/lang/String;")
    public static String loadingTitle = null;

    @OriginalMember(owner = "client!vr", name = "d", descriptor = "Lclient!mj;")
    public static BufferedFile uidDat;

    @OriginalMember(owner = "client!kh", name = "z", descriptor = "Z")
    public boolean jagmiscRunning = false;

    @OriginalMember(owner = "client!kh", name = "h", descriptor = "Z")
    public boolean alreadyerrored = false;

    @OriginalMember(owner = "client!kh", name = "provideLoaderApplet", descriptor = "(Ljava/applet/Applet;)V")
    public static void provideLoaderApplet(@OriginalArg(0) Applet arg0) {
        loaderApplet = arg0;
    }

    @OriginalMember(owner = "client!wv", name = "a", descriptor = "(II)V")
    public static void setspeed(@OriginalArg(0) int logicRate) {
        logicUpdateInterval = UPDATE_FPS_INTERVAL / (long) logicRate;
    }

    @OriginalMember(owner = "client!pt", name = "c", descriptor = "(B)I")
    public static int speed() {
        return (int) (UPDATE_FPS_INTERVAL / logicUpdateInterval);
    }

    @OriginalMember(owner = "client!pq", name = "d", descriptor = "(I)Z")
    public static boolean unloadNatives() {
        @Pc(7) Hashtable local7 = new Hashtable();
        @Pc(10) Enumeration local10 = LibraryManager.nativeLibraries.keys();
        while (local10.hasMoreElements()) {
            @Pc(14) Object local14 = local10.nextElement();
            local7.put(local14, LibraryManager.nativeLibraries.get(local14));
        }
        try {
            @Pc(35) Class local35 = Class.forName("java.lang.reflect.AccessibleObject");
            @Pc(40) Class local40 = Class.forName("java.lang.ClassLoader");
            @Pc(46) Field local46 = local40.getDeclaredField("nativeLibraries");
            @Pc(58) Method local58 = local35.getDeclaredMethod("setAccessible", Boolean.TYPE);
            local58.invoke(local46, Boolean.TRUE);
            try {
                local10 = LibraryManager.nativeLibraries.keys();
                while (local10.hasMoreElements()) {
                    @Pc(76) String local76 = (String) local10.nextElement();
                    try {
                        @Pc(81) File local81 = (File) LibraryManager.libraries.get(local76);
                        @Pc(86) Class local86 = (Class) LibraryManager.nativeLibraries.get(local76);
                        @Pc(92) Vector local92 = (Vector) local46.get(local86.getClassLoader());
                        for (@Pc(94) int local94 = 0; local92.size() > local94; local94++) {
                            try {
                                @Pc(99) Object local99 = local92.elementAt(local94);
                                @Pc(106) Field local106 = local99.getClass().getDeclaredField("name");
                                local58.invoke(local106, Boolean.TRUE);
                                try {
                                    @Pc(121) String local121 = (String) local106.get(local99);
                                    if (local121 != null && local121.equalsIgnoreCase(local81.getCanonicalPath())) {
                                        @Pc(137) Field local137 = local99.getClass().getDeclaredField("handle");
                                        @Pc(146) Method local146 = local99.getClass().getDeclaredMethod("finalize");
                                        local58.invoke(local137, Boolean.TRUE);
                                        local58.invoke(local146, Boolean.TRUE);
                                        try {
                                            local146.invoke(local99);
                                            local137.set(local99, Integer.valueOf(0));
                                            local7.remove(local76);
                                        } catch (@Pc(185) Throwable local185) {
                                        }
                                        local58.invoke(local146, Boolean.FALSE);
                                        local58.invoke(local137, Boolean.FALSE);
                                    }
                                } catch (@Pc(207) Throwable local207) {
                                }
                                local58.invoke(local106, Boolean.FALSE);
                            } catch (@Pc(219) Throwable local219) {
                            }
                        }
                    } catch (@Pc(227) Throwable local227) {
                    }
                }
            } catch (@Pc(233) Throwable local233) {
            }
            local58.invoke(local46, Boolean.FALSE);
        } catch (@Pc(245) Throwable local245) {
        }
        LibraryManager.nativeLibraries = local7;
        return LibraryManager.nativeLibraries.isEmpty();
    }

    @OriginalMember(owner = "client!nda", name = "e", descriptor = "(B)V")
    public static void method7859() {
        if (signLink.microsoftjava) {
            maxmemory = 96;
            return;
        }
        try {
            @Pc(34) Method local34 = (aClass21 == null ? (aClass21 = Class.forName("java.lang.Runtime")) : aClass21).getMethod("maxMemory");
            if (local34 != null) {
                try {
                    @Pc(38) Runtime local38 = Runtime.getRuntime();
                    @Pc(44) Long local44 = (Long) local34.invoke(local38, (Object[]) null);
                    maxmemory = (int) (local44 / 1048576L) + 1;
                } catch (@Pc(54) Throwable local54) {
                }
            }
        } catch (@Pc(56) Exception local56) {
        }
    }

    @OriginalMember(owner = "client!el", name = "a", descriptor = "(Z)V")
    public static void method2429() {
        try {
            @Pc(26) Method local26 = (aClass7 == null ? (aClass7 = Class.forName("java.lang.Runtime")) : aClass7).getMethod("availableProcessors");
            if (local26 != null) {
                try {
                    @Pc(30) Runtime local30 = Runtime.getRuntime();
                    @Pc(36) Integer local36 = (Integer) local26.invoke(local30, (Object[]) null);
                    cpucount = local36;
                } catch (@Pc(41) Throwable local41) {
                }
            }
        } catch (@Pc(43) Exception local43) {
        }
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!vq;Ljava/lang/Object;B)V")
    public static void waitForEvents(@OriginalArg(0) SignLink signLink, @OriginalArg(1) Object source) {
        if (signLink.eventQueue == null) {
            return;
        }

        for (@Pc(19) int i = 0; i < 50 && signLink.eventQueue.peekEvent() != null; i++) {
            TimeUtils.sleep(1L);
        }

        try {
            if (source != null) {
                signLink.eventQueue.postEvent(new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "dummy"));
            }
        } catch (@Pc(50) Exception ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!fi", name = "a", descriptor = "(ILclient!ge;)V")
    public static void pushUID192(@OriginalArg(1) Packet packet) {
        @Pc(6) byte[] data = new byte[24];

        if (uidDat != null) {
            try {
                uidDat.seek(0L);
                uidDat.read(data);

                @Pc(18) int local18;
                for (local18 = 0; local18 < 24 && data[local18] == 0; local18++) {
                }

                if (local18 >= 24) {
                    throw new IOException();
                }
            } catch (@Pc(44) Exception local44) {
                for (@Pc(18) int local18 = 0; local18 < 24; local18++) {
                    data[local18] = -1;
                }
            }
        }

        packet.pdata(24, data, 0);
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(IZ)V")
    public void shutdown(@OriginalArg(1) boolean clean) {
        synchronized (this) {
            if (shutdown) {
                return;
            }

            shutdown = true;
        }

        System.out.println("Shutdown start - clean:" + clean);

        if (loaderApplet != null) {
            loaderApplet.destroy();
        }

        try {
            this.mainquit();
        } catch (@Pc(42) Exception ignored) {
            /* empty */
        }

        if (this.jagmiscRunning) {
            try {
                jagmisc.quit();
            } catch (@Pc(48) Throwable ignored) {
                /* empty */
            }

            this.jagmiscRunning = false;
        }

        SoftwareMemoryManager.shutdown();
        unloadNatives();

        if (canvas != null) {
            try {
                canvas.removeFocusListener(this);
                canvas.getParent().remove(canvas);
            } catch (@Pc(68) Exception ignored) {
                /* empty */
            }
        }

        if (signLink != null) {
            try {
                signLink.stop();
            } catch (@Pc(76) Exception ignored) {
                /* empty */
            }
        }

        this.cleanup();

        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
            frame = null;
        }

        System.out.println("Shutdown complete - clean:" + clean);
    }

    @OriginalMember(owner = "client!kh", name = "j", descriptor = "(I)V")
    protected abstract void mainquit();

    @OriginalMember(owner = "client!kh", name = "b", descriptor = "(I)Z")
    public final boolean load_jagmisc() {
        return Static14.loadNativeLibrary("jagmisc");
    }

    @OriginalMember(owner = "client!kh", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowIconified(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(IBIIIZLjava/lang/String;I)V")
    public final void method1635(@OriginalArg(3) int arg0, @OriginalArg(6) String arg1) {
        try {
            sourceApplet = null;
            clientBuild = 667;

            canvasWid = 1024;
            frameWid = 1024;
            topMargin = 0;
            leftMargin = 0;
            canvasHei = 768;
            frameHei = 768;

            instance = this;

            frame = new Frame();
            frame.setTitle("Jagex");
            frame.setResizable(true);
            frame.addWindowListener(this);
            frame.setVisible(true);
            frame.toFront();
            @Pc(54) Insets insets = frame.getInsets();
            frame.setSize(frameWid + insets.left + insets.right, insets.bottom + insets.top + frameHei);

            SignLink.instance = signLink = new SignLink(arg0, arg1, 37, true);

            @Pc(88) SignedResource resource = signLink.startThread(this, 1);
            while (resource.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(10L);
            }
        } catch (@Pc(103) Exception local103) {
            JagException.sendTrace(local103, null);
        }
    }

    @OriginalMember(owner = "client!kh", name = "getCodeBase", descriptor = "()Ljava/net/URL;")
    @Override
    public final URL getCodeBase() {
        if (frame == null) {
            return loaderApplet == null || loaderApplet == this ? super.getCodeBase() : loaderApplet.getCodeBase();
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!kh", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
    @Override
    public final void focusGained(@OriginalArg(0) FocusEvent arg0) {
        focus_in = true;
        fullredraw = true;
    }

    @OriginalMember(owner = "client!kh", name = "e", descriptor = "(B)V")
    protected abstract void cleanup();

    @OriginalMember(owner = "client!kh", name = "start", descriptor = "()V")
    @Override
    public final void start() {
        if (instance == this && !shutdown) {
            killtime = 0L;
        }
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(Ljava/lang/String;B)V")
    protected final void error(@OriginalArg(0) String arg0) {
        if (this.alreadyerrored) {
            return;
        }

        this.alreadyerrored = true;
        System.out.println("error_game_" + arg0);
        try {
            JavaScript.call("loggedout", loaderApplet);
        } catch (@Pc(31) Throwable ignored) {
            /* empty */
        }

        try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + arg0 + ".ws"), "_top");
        } catch (@Pc(62) Exception ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!kh", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "e", descriptor = "(I)V")
    public void draw0() {
        @Pc(6) long time = SystemTimer.safetime();
        @Pc(17) long lastDrawTime = drawTimes[drawTimeIndex];
        drawTimes[drawTimeIndex] = time;

        if (lastDrawTime != 0L && lastDrawTime < time) {
            @Pc(40) int local40 = (int) (time - lastDrawTime);
            currentFps = ((local40 >> 1) + 32000) / local40;
        }

        drawTimeIndex = drawTimeIndex + 1 & 0x1F;

        if (drawCount++ > 50) {
            fullredraw = true;
            drawCount -= 50;

            canvas.setSize(canvasWid, canvasHei);
            canvas.setVisible(true);

            if (frame != null && fsframe == null) {
                @Pc(86) Insets insets = frame.getInsets();
                canvas.setLocation(insets.left + leftMargin, topMargin + insets.top);
            } else {
                canvas.setLocation(leftMargin, topMargin);
            }
        }

        this.draw();
    }

    @OriginalMember(owner = "client!kh", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowActivated(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(IIIILjava/lang/String;II)V")
    protected final void startApplet(@OriginalArg(1) int build, @OriginalArg(2) int loadingScreenWidth, @OriginalArg(3) int cacheId, @OriginalArg(4) String game, @OriginalArg(5) int archiveCount, @OriginalArg(6) int loadingScreenHeight) {
        try {
            if (instance == null) {
                sourceApplet = loaderApplet;
                canvasWid = loadingScreenWidth;
                frameWid = loadingScreenWidth;
                clientBuild = build;
                leftMargin = 0;
                canvasHei = loadingScreenHeight;
                frameHei = loadingScreenHeight;
                topMargin = 0;
                instance = this;
                SignLink.instance = signLink = new SignLink(cacheId, game, archiveCount, loaderApplet != null);

                @Pc(80) SignedResource resource = signLink.startThread(this, 1);
                while (resource.status == SignedResourceStatus.IDLE) {
                    TimeUtils.sleep(10L);
                }
            } else {
                anInt941++;
                if (anInt941 >= 3) {
                    this.error("alreadyloaded");
                } else {
                    this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
                }
            }
        } catch (@Pc(92) Throwable local92) {
            JagException.sendTrace(local92, null);
            this.error("crash");
        }
    }

    @OriginalMember(owner = "client!kh", name = "run", descriptor = "()V")
    @Override
    public final void run() {
        try {
            // logger.debug("run_inner");
            if (javaVendor != null) {
                @Pc(10) String local10 = javaVendor.toLowerCase();
                if (local10.indexOf("sun") != -1 || local10.indexOf("apple") != -1) {
                    @Pc(29) String local29 = javaVersion;
                    if (local29.equals("1.1") || local29.startsWith("1.1.") || local29.equals("1.2") || local29.startsWith("1.2.")) {
                        this.error("wrongjava");
                        return;
                    }
                } else if (local10.indexOf("ibm") != -1 && (javaVersion == null || javaVersion.equals("1.4.2"))) {
                    this.error("wrongjava");
                    return;
                }
            }

            if (javaVersion != null && javaVersion.startsWith("1.")) {
                @Pc(114) int i = 2;
                @Pc(116) int version = 0;

                while (i < javaVersion.length()) {
                    @Pc(124) char c = javaVersion.charAt(i);
                    if (c < '0' || c > '9') {
                        break;
                    }

                    i++;
                    version = (c + (version * 10)) - '0';
                }

                if (version >= 5) {
                    java5OrLater = true;
                }
            }

            @Pc(168) Applet local168 = instance;
            if (loaderApplet != null) {
                local168 = loaderApplet;
            }

            @Pc(174) Method local174 = setFocusCycleRoot;
            if (local174 != null) {
                try {
                    local174.invoke(local168, Boolean.TRUE);
                } catch (@Pc(188) Throwable local188) {
                }
            }

            // z.g("GameShell.run_inner()");
            method7859();
            method2429();
            this.addcanvas();
            // logger.debug("maininit");
            this.maininit();
            tickScheduler = TickScheduler.create();

            while (killtime == 0L || SystemTimer.safetime() < killtime) {
                scheduledTicks = tickScheduler.scheduleDelayed(logicUpdateInterval);

                for (@Pc(213) int tick = 0; tick < scheduledTicks; tick++) {
                    this.tick0();
                }

                this.draw0();
                waitForEvents(signLink, canvas);
            }
        } catch (@Pc(254) ThreadDeath death) {
            throw death;
        } catch (@Pc(257) Throwable cause) {
            JagException.sendTrace(cause, this.getErrorTrace());
            this.error("crash");
        } finally {
            @Pc(275) Object local275 = null;
            this.shutdown(true);
        }
    }

    @OriginalMember(owner = "client!kh", name = "getAppletContext", descriptor = "()Ljava/applet/AppletContext;")
    @Override
    public final AppletContext getAppletContext() {
        if (frame == null) {
            return loaderApplet == null || loaderApplet == this ? super.getAppletContext() : loaderApplet.getAppletContext();
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!kh", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
    @Override
    public final synchronized void paint(@OriginalArg(0) Graphics graphics) {
        if (instance != this || shutdown) {
            return;
        }

        fullredraw = true;

        if (java5OrLater && SystemTimer.safetime() - lastCanvasReplace > 1000L) {
            @Pc(28) Rectangle clipBounds = graphics.getClipBounds();

            if (clipBounds == null || clipBounds.width >= frameWid && clipBounds.height >= frameHei) {
                canvasReplaceRecommended = true;
            }
        }
    }

    @OriginalMember(owner = "client!kh", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowClosed(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowClosing(@OriginalArg(0) WindowEvent arg0) {
        this.destroy();
    }

    @OriginalMember(owner = "client!kh", name = "stop", descriptor = "()V")
    @Override
    public final void stop() {
        if (instance == this && !shutdown) {
            killtime = SystemTimer.safetime() + 4000L;
        }
    }

    @OriginalMember(owner = "client!kh", name = "init", descriptor = "()V")
    public abstract void init();

    @OriginalMember(owner = "client!kh", name = "i", descriptor = "(I)V")
    public synchronized void addcanvas() {
        if (canvas != null) {
            canvas.removeFocusListener(this);
            canvas.getParent().setBackground(Color.black);
            canvas.getParent().remove(canvas);
        }

        @Pc(30) Container topContainer;
        if (fsframe != null) {
            topContainer = fsframe;
        } else if (frame != null) {
            topContainer = frame;
        } else if (loaderApplet == null) {
            topContainer = instance;
        } else {
            topContainer = loaderApplet;
        }

        topContainer.setLayout(null);
        canvas = new Canvas_Sub1(this);
        topContainer.add(canvas);
        canvas.setSize(canvasWid, canvasHei);
        canvas.setVisible(true);

        if (topContainer == frame) {
            @Pc(74) Insets insets = frame.getInsets();
            canvas.setLocation(insets.left + leftMargin, insets.top + topMargin);
        } else {
            canvas.setLocation(leftMargin, topMargin);
        }

        canvas.addFocusListener(this);
        canvas.requestFocus();
        focus = true;
        focus_in = true;
        fullredraw = true;
        canvasReplaceRecommended = false;
        lastCanvasReplace = SystemTimer.safetime();
    }

    @OriginalMember(owner = "client!kh", name = "d", descriptor = "(B)Z")
    protected final boolean checkhost() {
        @Pc(16) String host = this.getDocumentBase().getHost().toLowerCase();

        if (host.equals("jagex.com") || host.endsWith(".jagex.com")) {
            return true;
        } else if (host.equals("runescape.com") || host.endsWith(".runescape.com")) {
            return true;
        } else if (host.equals("stellardawn.com") || host.endsWith(".stellardawn.com")) {
            return true;
        } else if (host.endsWith("127.0.0.1")) {
            return true;
        } else {
            while (host.length() > 0 && host.charAt(host.length() - 1) >= '0' && host.charAt(host.length() - 1) <= '9') {
                host = host.substring(0, host.length() - 1);
            }

            if (host.endsWith("192.168.1.")) {
                return true;
            } else {
                this.error("invalidhost");
                return false;
            }
        }
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(B)Z")
    public final boolean load_jaclib() {
        return Static14.loadNativeLibrary("jaclib");
    }

    @OriginalMember(owner = "client!kh", name = "k", descriptor = "(I)V")
    protected abstract void mainloop();

    @OriginalMember(owner = "client!kh", name = "f", descriptor = "(I)V")
    public void tick0() {
        @Pc(6) long time = SystemTimer.safetime();
        @Pc(10) long lastTickTime = tickTimes[tickTimeIndex];

        tickTimes[tickTimeIndex] = time;
        @Pc(31) boolean local31;
        if (lastTickTime == 0L || lastTickTime >= time) {
            local31 = false;
        } else {
            local31 = true;
        }
        tickTimeIndex = (tickTimeIndex + 1) & 0x1F;

        synchronized (this) {
            focus = focus_in;
        }

        this.mainloop();
    }

    @OriginalMember(owner = "client!kh", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
    @Override
    public final void focusLost(@OriginalArg(0) FocusEvent arg0) {
        focus_in = false;
    }

    @OriginalMember(owner = "client!kh", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
    @Override
    public final String getParameter(@OriginalArg(0) String arg0) {
        if (frame == null) {
            return loaderApplet == null || loaderApplet == this ? super.getParameter(arg0) : loaderApplet.getParameter(arg0);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!kh", name = "h", descriptor = "(I)V")
    protected abstract void maininit();

    @OriginalMember(owner = "client!kh", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "destroy", descriptor = "()V")
    @Override
    public final void destroy() {
        if (instance == this && !shutdown) {
            killtime = SystemTimer.safetime();
            TimeUtils.sleep(5000L);
            SignLink.instance = null;
            this.shutdown(false);
        }
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(I)Ljava/lang/String;")
    public String getErrorTrace() {
        return null;
    }

    @OriginalMember(owner = "client!kh", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
    @Override
    public final void update(@OriginalArg(0) Graphics graphics) {
        this.paint(graphics);
    }

    @OriginalMember(owner = "client!kh", name = "c", descriptor = "(I)V")
    protected abstract void draw();

    @OriginalMember(owner = "client!kh", name = "getDocumentBase", descriptor = "()Ljava/net/URL;")
    @Override
    public final URL getDocumentBase() {
        if (frame == null) {
            return loaderApplet == null || loaderApplet == this ? super.getDocumentBase() : loaderApplet.getDocumentBase();
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!kh", name = "d", descriptor = "(I)Z")
    public final boolean load_jagtheora() {
        return Static14.loadNativeLibrary("jagtheora");
    }

    @OriginalMember(owner = "client!kh", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowOpened(@OriginalArg(0) WindowEvent arg0) {
    }
}
