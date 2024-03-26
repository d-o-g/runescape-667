import com.jagex.Client;
import com.jagex.Constants;
import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.util.JagException;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.URL;

@OriginalClass("client!kh")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

    @OriginalMember(owner = "client!kh", name = "N", descriptor = "[F")
    public static final float[] aFloatArray15 = new float[16384];

    @OriginalMember(owner = "client!kh", name = "f", descriptor = "[F")
    public static final float[] aFloatArray14 = new float[16384];

    @OriginalMember(owner = "client!gr", name = "v", descriptor = "[J")
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
    public static int drawTimeIndex;

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

    @OriginalMember(owner = "client!kh", name = "z", descriptor = "Z")
    public boolean aBoolean157 = false;

    @OriginalMember(owner = "client!kh", name = "h", descriptor = "Z")
    public boolean errored = false;

    static {
        @Pc(433) double local433 = 3.834951969714103E-4D;
        for (@Pc(435) int local435 = 0; local435 < 16384; local435++) {
            aFloatArray15[local435] = (float) Math.sin(local433 * (double) local435);
            aFloatArray14[local435] = (float) Math.cos((double) local435 * local433);
        }
    }

    @OriginalMember(owner = "client!kh", name = "provideLoaderApplet", descriptor = "(Ljava/applet/Applet;)V")
    public static void provideLoaderApplet(@OriginalArg(0) Applet arg0) {
        loaderApplet = arg0;
    }

    @OriginalMember(owner = "client!wv", name = "a", descriptor = "(II)V")
    public static void setspeed(@OriginalArg(0) int logicRate) {
        logicUpdateInterval = 1000000000L / (long) logicRate;
    }

    @OriginalMember(owner = "client!pt", name = "c", descriptor = "(B)I")
    public static int speed() {
        return (int) (1000000000L / logicUpdateInterval);
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(IZ)V")
    public void method1632(@OriginalArg(1) boolean clean) {
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
        } catch (@Pc(42) Exception local42) {
        }

        if (this.aBoolean157) {
            try {
                jagmisc.quit();
            } catch (@Pc(48) Throwable local48) {
            }
            this.aBoolean157 = false;
        }

        Static307.method4480();
        Static501.method6714();

        if (canvas != null) {
            try {
                canvas.removeFocusListener(this);
                canvas.getParent().remove(canvas);
            } catch (@Pc(68) Exception local68) {
            }
        }

        if (SignLink.instance != null) {
            try {
                SignLink.instance.stop();
            } catch (@Pc(76) Exception local76) {
            }
        }

        this.method1637();

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
    public final boolean method1634() {
        return Static14.loadNativeLibrary("jagmisc");
    }

    @OriginalMember(owner = "client!kh", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowIconified(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(IBIIIZLjava/lang/String;I)V")
    protected final void method1635(@OriginalArg(3) int arg0, @OriginalArg(6) String arg1) {
        try {
            Constants.sourceApplet = null;
            Constants.clientBuild = 667;

            canvasWid = 1024;
            Client.frameWid = 1024;
            topMargin = 0;
            leftMargin = 0;
            canvasHei = 768;
            Client.frameHei = 768;

            instance = this;

            frame = new Frame();
            frame.setTitle("Jagex");
            frame.setResizable(true);
            frame.addWindowListener(this);
            frame.setVisible(true);
            frame.toFront();
            @Pc(54) Insets insets = frame.getInsets();
            frame.setSize(Client.frameWid + insets.left + insets.right, insets.bottom + insets.top + Client.frameHei);

            SignLink.aSignLink_4 = SignLink.instance = new SignLink(arg0, arg1, 37, true);
            @Pc(88) SignedResource resource = SignLink.instance.startThread(this, 1);
            while (resource.status == 0) {
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
    protected abstract void method1637();

    @OriginalMember(owner = "client!kh", name = "start", descriptor = "()V")
    @Override
    public final void start() {
        if (instance == this && !shutdown) {
            Static604.aLong278 = 0L;
        }
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(Ljava/lang/String;B)V")
    protected final void error(@OriginalArg(0) String arg0) {
        if (this.errored) {
            return;
        }

        this.errored = true;
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
    public void method1639() {
        @Pc(6) long local6 = SystemTimer.safetime();
        @Pc(17) long local17 = Static475.drawTimes[Static708.anInt10644];
        Static475.drawTimes[Static708.anInt10644] = local6;
        if (local17 != 0L && local17 < local6) {
            @Pc(40) int local40 = (int) (local6 - local17);
            Static652.currentFps = ((local40 >> 1) + 32000) / local40;
        }
        Static708.anInt10644 = Static708.anInt10644 + 1 & 0x1F;
        if (Static169.anInt2850++ > 50) {
            fullredraw = true;
            Static169.anInt2850 -= 50;
            canvas.setSize(canvasWid, canvasHei);
            canvas.setVisible(true);
            if (frame != null && fsframe == null) {
                @Pc(86) Insets local86 = frame.getInsets();
                canvas.setLocation(local86.left + leftMargin, topMargin + local86.top);
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
                Constants.sourceApplet = loaderApplet;
                canvasWid = loadingScreenWidth;
                Client.frameWid = loadingScreenWidth;
                Constants.clientBuild = build;
                leftMargin = 0;
                canvasHei = loadingScreenHeight;
                Client.frameHei = loadingScreenHeight;
                topMargin = 0;
                instance = this;
                SignLink.aSignLink_4 = SignLink.instance = new SignLink(cacheId, game, archiveCount, loaderApplet != null);
                @Pc(80) SignedResource local80 = SignLink.instance.startThread(this, 1);
                while (local80.status == 0) {
                    TimeUtils.sleep(10L);
                }
            } else {
                Static426.anInt941++;
                if (Static426.anInt941 >= 3) {
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
            if (SignLink.javaVendor != null) {
                @Pc(10) String local10 = SignLink.javaVendor.toLowerCase();
                if (local10.indexOf("sun") != -1 || local10.indexOf("apple") != -1) {
                    @Pc(29) String local29 = SignLink.javaVersion;
                    if (local29.equals("1.1") || local29.startsWith("1.1.") || local29.equals("1.2") || local29.startsWith("1.2.")) {
                        this.error("wrongjava");
                        return;
                    }
                } else if (local10.indexOf("ibm") != -1 && (SignLink.javaVersion == null || SignLink.javaVersion.equals("1.4.2"))) {
                    this.error("wrongjava");
                    return;
                }
            }
            if (SignLink.javaVersion != null && SignLink.javaVersion.startsWith("1.")) {
                @Pc(114) int local114 = 2;
                @Pc(116) int local116 = 0;
                while (local114 < SignLink.javaVersion.length()) {
                    @Pc(124) char local124 = SignLink.javaVersion.charAt(local114);
                    if (local124 < '0' || local124 > '9') {
                        break;
                    }
                    local114++;
                    local116 = local124 + local116 * 10 - 48;
                }
                if (local116 >= 5) {
                    Static463.aBoolean531 = true;
                }
            }
            @Pc(168) Applet local168 = instance;
            if (loaderApplet != null) {
                local168 = loaderApplet;
            }
            @Pc(174) Method local174 = SignLink.setFocusCycleRoot;
            if (local174 != null) {
                try {
                    local174.invoke(local168, Boolean.TRUE);
                } catch (@Pc(188) Throwable local188) {
                }
            }
            Static418.method7859();
            Static148.method2429();
            this.addcanvas();
            this.method1647();
            Static600.aClass27_1 = Static570.method7550();
            while (Static604.aLong278 == 0L || SystemTimer.safetime() < Static604.aLong278) {
                Static32.scheduledTicks = Static600.aClass27_1.method5598(logicUpdateInterval);
                for (@Pc(213) int local213 = 0; local213 < Static32.scheduledTicks; local213++) {
                    this.tick0();
                }
                this.method1639();
                Static61.method1312(SignLink.instance, canvas);
            }
        } catch (@Pc(254) ThreadDeath local254) {
            throw local254;
        } catch (@Pc(257) Throwable local257) {
            JagException.sendTrace(local257, this.getErrorTrace());
            this.error("crash");
        } finally {
            @Pc(275) Object local275 = null;
            this.method1632(true);
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
    public final synchronized void paint(@OriginalArg(0) Graphics arg0) {
        if (instance != this || shutdown) {
            return;
        }
        fullredraw = true;
        if (Static463.aBoolean531 && SystemTimer.safetime() - lastCanvasReplace > 1000L) {
            @Pc(28) Rectangle local28 = arg0.getClipBounds();
            if (local28 == null || Client.frameWid <= local28.width && local28.height >= Client.frameHei) {
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
            Static604.aLong278 = SystemTimer.safetime() + 4000L;
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
            canvas.setLocation(leftMargin + insets.left, insets.top + topMargin);
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
    public final boolean loadJaclib() {
        return Static14.loadNativeLibrary("jaclib");
    }

    @OriginalMember(owner = "client!kh", name = "k", descriptor = "(I)V")
    protected abstract void mainloop();

    @OriginalMember(owner = "client!kh", name = "f", descriptor = "(I)V")
    public void tick0() {
        @Pc(6) long time = SystemTimer.safetime();
        @Pc(10) long lastDrawTime = drawTimes[drawTimeIndex];

        drawTimes[drawTimeIndex] = time;
        @Pc(31) boolean local31;
        if (lastDrawTime == 0L || lastDrawTime >= time) {
            local31 = false;
        } else {
            local31 = true;
        }
        drawTimeIndex = (drawTimeIndex + 1) & 0x1F;

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
    protected abstract void method1647();

    @OriginalMember(owner = "client!kh", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
    }

    @OriginalMember(owner = "client!kh", name = "destroy", descriptor = "()V")
    @Override
    public final void destroy() {
        if (instance == this && !shutdown) {
            Static604.aLong278 = SystemTimer.safetime();
            TimeUtils.sleep(5000L);
            SignLink.aSignLink_4 = null;
            this.method1632(false);
        }
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(I)Ljava/lang/String;")
    public String getErrorTrace() {
        return null;
    }

    @OriginalMember(owner = "client!kh", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
    @Override
    public final void update(@OriginalArg(0) Graphics arg0) {
        this.paint(arg0);
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
    public final boolean method1651() {
        return Static14.loadNativeLibrary("jagtheora");
    }

    @OriginalMember(owner = "client!kh", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
    @Override
    public final void windowOpened(@OriginalArg(0) WindowEvent arg0) {
    }
}
