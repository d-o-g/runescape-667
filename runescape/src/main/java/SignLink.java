import com.jagex.FileCache;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

@OriginalClass("client!vq")
public final class SignLink implements Runnable {

    private static final int TYPE_SOCKET = 1;
    private static final int TYPE_START_THREAD = 2;
    private static final int TYPE_HOSTNAME = 3;
    private static final int TYPE_OPEN_STREAM = 4;
    private static final int TYPE_DISPLAY_PROPERTIES = 5;
    private static final int TYPE_ENTER_FULLSCREEN = 6;
    private static final int TYPE_EXIT_FULLSCREEN = 7;
    private static final int TYPE_METHOD = 8;
    private static final int TYPE_FIELD = 9;
    private static final int TYPE_PREFERENCES_SPECIFIC_GAME = 12;
    private static final int TYPE_PREFERENCES = 13;
    private static final int TYPE_MOVE_MOUSE = 14;
    private static final int TYPE_UPDATE_MOUSE_COMPONENT = 15;
    private static final int TYPE_OPEN_PAGE = 16;
    private static final int TYPE_UPDATE_MOUSE_CURSOR = 17;
    private static final int TYPE_GET_CLIPBOARD_CONTENTS = 18;
    private static final int TYPE_SET_CLIPBOARD_CONTENTS = 19;
    private static final int TYPE_ADDRESS = 21;
    private static final int TYPE_SOCKET_PROXY = 22;

    public static final int STORE_RC = 33;
    public static final int STORE_WIP = 34;

    private static final String UIDFileName = "random.dat";
    private static final String cacheDatFilename = "main_file_cache.dat2";
    private static final String cacheMasterIndexFilename = "main_file_cache.idx255";
    private static final String cacheIndexFilename = "main_file_cache.idx";

    @OriginalMember(owner = "client!vq", name = "D", descriptor = "Ljava/lang/String;")
    public static String javaVendor;

    @OriginalMember(owner = "client!vq", name = "q", descriptor = "Ljava/lang/String;")
    public static String javaVersion;

    @OriginalMember(owner = "client!vq", name = "f", descriptor = "Ljava/lang/String;")
    public static String game;
    @OriginalMember(owner = "client!vq", name = "z", descriptor = "Ljava/lang/String;")
    public static String osNameRaw;
    @OriginalMember(owner = "client!vq", name = "y", descriptor = "Ljava/lang/String;")
    public static String osNameLower;
    @OriginalMember(owner = "client!vq", name = "c", descriptor = "Ljava/lang/String;")
    public static String osArchRaw;
    @OriginalMember(owner = "client!vq", name = "C", descriptor = "Ljava/lang/String;")
    public static String osVersionRaw;
    @OriginalMember(owner = "client!vq", name = "B", descriptor = "Ljava/lang/String;")
    public static String homeDir;
    @OriginalMember(owner = "client!vq", name = "A", descriptor = "Ljava/lang/reflect/Method;")
    public static Method setFocusTraversalKeysEnabled;
    @OriginalMember(owner = "client!vq", name = "v", descriptor = "Ljava/lang/reflect/Method;")
    public static Method setFocusCycleRoot;
    @OriginalMember(owner = "client!vq", name = "w", descriptor = "I")
    public static int storeId;

    @OriginalMember(owner = "client!vq", name = "m", descriptor = "Lclient!dm;")
    public FileOnDisk cacheDat = null;

    @OriginalMember(owner = "client!vq", name = "l", descriptor = "Lclient!oba;")
    public SignedResource current = null;

    @OriginalMember(owner = "client!vq", name = "F", descriptor = "Z")
    public boolean stopped = false;

    @OriginalMember(owner = "client!vq", name = "h", descriptor = "Lclient!oba;")
    public SignedResource last = null;

    @OriginalMember(owner = "client!vq", name = "i", descriptor = "Lclient!dm;")
    public FileOnDisk uidFile = null;

    @OriginalMember(owner = "client!vq", name = "b", descriptor = "Lclient!dm;")
    public FileOnDisk masterIndex = null;

    @OriginalMember(owner = "client!vq", name = "j", descriptor = "Z")
    public boolean microsoftjava = false;

    @OriginalMember(owner = "client!vq", name = "u", descriptor = "Z")
    public boolean signed = false;

    @OriginalMember(owner = "client!vq", name = "x", descriptor = "Ljava/awt/EventQueue;")
    public EventQueue eventQueue;

    @OriginalMember(owner = "client!vq", name = "e", descriptor = "[Lclient!dm;")
    public FileOnDisk[] cacheIndex;

    @OriginalMember(owner = "client!vq", name = "G", descriptor = "Ljava/lang/Object;")
    public Object anObject21;

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "Lclient!ak;")
    public Class15 aClass15_1;

    @OriginalMember(owner = "client!vq", name = "r", descriptor = "Ljava/lang/Object;")
    public Object fullscreenAdapter;

    @OriginalMember(owner = "client!vq", name = "k", descriptor = "Lclient!ow;")
    public MicrosoftJavaMouseCallback mouseCallback;

    @OriginalMember(owner = "client!vq", name = "n", descriptor = "Ljava/lang/Object;")
    public Object mouseAdapter;

    @OriginalMember(owner = "client!vq", name = "o", descriptor = "Ljava/lang/Thread;")
    public final Thread thread;

    @OriginalMember(owner = "client!vq", name = "<init>", descriptor = "(ILjava/lang/String;IZ)V")
    public SignLink(@OriginalArg(0) int storeId, @OriginalArg(1) String game, @OriginalArg(2) int archiveCount, @OriginalArg(3) boolean signed) throws Exception {
        SignLink.game = game;
        SignLink.javaVersion = "1.1";
        SignLink.javaVendor = "Unknown";

        this.signed = signed;
        SignLink.storeId = storeId;

        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        } catch (@Pc(52) Exception ignored) {
            /* empty */
        }

        if (javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            this.microsoftjava = true;
        }

        try {
            osNameRaw = System.getProperty("os.name");
        } catch (@Pc(72) Exception ignored) {
            osNameRaw = "Unknown";
        }

        osNameLower = osNameRaw.toLowerCase();

        try {
            osArchRaw = System.getProperty("os.arch").toLowerCase();
        } catch (@Pc(87) Exception ignored) {
            osArchRaw = "";
        }

        try {
            osVersionRaw = System.getProperty("os.version").toLowerCase();
        } catch (@Pc(97) Exception ignored) {
            osVersionRaw = "";
        }

        try {
            homeDir = System.getProperty("user.home");

            if (homeDir != null) {
                homeDir = homeDir + "/";
            }
        } catch (@Pc(117) Exception ignored) {
            /* empty */
        }

        if (homeDir == null) {
            homeDir = "~/";
        }

        try {
            this.eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        } catch (@Pc(131) Throwable ignored) {
            /* empty */
        }

        if (!this.microsoftjava) {
            try {
                setFocusTraversalKeysEnabled = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            } catch (@Pc(151) Exception ignored) {
                /* empty */
            }

            try {
                setFocusCycleRoot = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
            } catch (@Pc(168) Exception ignored) {
                /* empty */
            }
        }

        FileCache.initialize(SignLink.storeId, SignLink.game);

        if (this.signed) {
            this.uidFile = new FileOnDisk(FileCache.get(null, SignLink.storeId, UIDFileName), "rw", 25L);
            this.cacheDat = new FileOnDisk(FileCache.get(cacheDatFilename), "rw", 314572800L);
            this.masterIndex = new FileOnDisk(FileCache.get(cacheMasterIndexFilename), "rw", 1048576L);
            this.cacheIndex = new FileOnDisk[archiveCount];

            for (@Pc(226) int i = 0; i < archiveCount; i++) {
                this.cacheIndex[i] = new FileOnDisk(FileCache.get(cacheIndexFilename + i), "rw", 1048576L);
            }

            if (this.microsoftjava) {
                try {
                    this.anObject21 = Class.forName("Class183").getDeclaredConstructor().newInstance();
                } catch (@Pc(267) Throwable ignored) {
                    /* empty */
                }
            }

            try {
                if (this.microsoftjava) {
                    this.aClass15_1 = new Class15();
                } else {
                    this.fullscreenAdapter = Class.forName("com.jagex.graphics.FullscreenAdapter").getDeclaredConstructor().newInstance();
                }
            } catch (@Pc(287) Throwable ignored) {
                /* empty */
            }

            try {
                if (this.microsoftjava) {
                    this.mouseCallback = new MicrosoftJavaMouseCallback();
                } else {
                    this.mouseAdapter = Class.forName("MouseAdapter").getDeclaredConstructor().newInstance();
                }
            } catch (@Pc(306) Throwable ignored) {
                /* empty */
            }
        }

        if (this.signed && !this.microsoftjava) {
            @Pc(318) ThreadGroup group = Thread.currentThread().getThreadGroup();
            for (@Pc(321) ThreadGroup parent = group.getParent(); parent != null; parent = parent.getParent()) {
                group = parent;
            }

            @Pc(332) Thread[] threads = new Thread[1000];
            group.enumerate(threads);
            for (@Pc(338) int i = 0; i < threads.length; i++) {
                if (threads[i] != null && threads[i].getName().startsWith("AWT")) {
                    threads[i].setPriority(1);
                }
            }
        }

        this.stopped = false;
        this.thread = new Thread(this);
        this.thread.setPriority(10);
        this.thread.setDaemon(true);
        this.thread.start();
    }

    @OriginalMember(owner = "client!vq", name = "c", descriptor = "(B)Ljava/lang/Object;")
    public Object method8976() {
        return this.anObject21;
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IIIII)Lclient!oba;")
    public SignedResource method8977(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
        return this.request(arg0 << 16, 6, (Object) null, (arg2 << 16) + arg1);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/String;I)Lclient!oba;")
    public SignedResource method8978(@OriginalArg(0) Class arg0, @OriginalArg(1) String arg1) {
        return this.request(0, 9, new Object[]{arg0, arg1}, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/String;ZZI)Lclient!oba;")
    public SignedResource method8979(@OriginalArg(0) String arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2) {
        return this.request(0, arg1 ? 22 : 1, arg0, arg2);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(ZLjava/lang/String;B)Lclient!oba;")
    public SignedResource method8981(@OriginalArg(1) String arg0) {
        return this.request(0, 12, arg0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BI)Lclient!oba;")
    public SignedResource method8982(@OriginalArg(1) int arg0) {
        return this.request(0, 3, (Object) null, arg0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(B)Lclient!oba;")
    public SignedResource method8984() {
        return this.request(0, 5, (Object) null, 0);
    }

    @OriginalMember(owner = "client!vq", name = "b", descriptor = "(I)V")
    public void stopb() {
        synchronized (this) {
            this.stopped = true;
            this.notifyAll();
        }

        try {
            this.thread.join();
        } catch (@Pc(25) InterruptedException ignored) {
            /* empty */
        }

        if (this.cacheDat != null) {
            try {
                this.cacheDat.close();
            } catch (@Pc(35) IOException ignored) {
                /* empty */
            }
        }

        if (this.masterIndex != null) {
            try {
                this.masterIndex.close();
            } catch (@Pc(46) IOException ignored) {
                /* empty */
            }
        }

        if (this.cacheIndex != null) {
            for (@Pc(52) int i = 0; i < this.cacheIndex.length; i++) {
                if (this.cacheIndex[i] != null) {
                    try {
                        this.cacheIndex[i].close();
                    } catch (@Pc(67) IOException ignored) {
                        /* empty */
                    }
                }
            }
        }

        if (this.uidFile != null) {
            try {
                this.uidFile.close();
            } catch (@Pc(90) IOException ignored) {
                /* empty */
            }
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/String;B)Lclient!oba;")
    public SignedResource method8986(@OriginalArg(0) String arg0) {
        return this.request(0, 16, arg0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/io/File;I[B)Z")
    public boolean writeFile(@OriginalArg(0) File arg0, @OriginalArg(2) byte[] data) {
        try {
            @Pc(4) FileOutputStream out = new FileOutputStream(arg0);
            out.write(data, 0, data.length);
            out.close();
            return true;
        } catch (@Pc(15) IOException local15) {
            throw new RuntimeException();
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/Class;[Ljava/lang/Class;Ljava/lang/String;Z)Lclient!oba;")
    public SignedResource method8988(@OriginalArg(0) Class arg0, @OriginalArg(1) Class[] arg1, @OriginalArg(2) String arg2) {
        return this.request(0, 8, new Object[]{arg0, arg2, arg1}, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/awt/Frame;I)Lclient!oba;")
    public SignedResource method8989(@OriginalArg(0) Frame arg0) {
        return this.request(0, 7, arg0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(I)Z")
    public boolean method8990() {
        if (!this.signed) {
            return false;
        } else if (this.microsoftjava) {
            return this.aClass15_1 != null;
        } else {
            return this.fullscreenAdapter != null;
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BLjava/lang/Runnable;I)Lclient!oba;")
    public SignedResource method8991(@OriginalArg(1) Runnable arg0, @OriginalArg(2) int arg1) {
        return this.request(0, 2, arg0, arg1);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BLjava/net/URL;)Lclient!oba;")
    public SignedResource openStream(@OriginalArg(1) URL arg0) {
        return this.request(0, 4, arg0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IILjava/lang/Object;II)Lclient!oba;")
    public SignedResource request(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Object arg2, @OriginalArg(4) int arg3) {
        @Pc(3) SignedResource resource = new SignedResource();
        resource.objectData = arg2;
        resource.anInt6788 = arg3;
        resource.anInt6790 = arg1;
        resource.anInt6787 = arg0;
        synchronized (this) {
            if (this.last == null) {
                this.last = this.current = resource;
            } else {
                this.last.next = resource;
                this.last = resource;
            }
            this.notify();
            return resource;
        }
    }

    @OriginalMember(owner = "client!vq", name = "b", descriptor = "(B)V")
    public void method8994() {
        Static689.aLong317 = SystemTimer.safetime() + 5000L;
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IB[ILjava/awt/Component;Ljava/awt/Point;I)Lclient!oba;")
    public SignedResource method8995(@OriginalArg(0) int arg0, @OriginalArg(2) int[] arg1, @OriginalArg(3) Component arg2, @OriginalArg(4) Point arg3, @OriginalArg(5) int arg4) {
        return this.request(arg0, 17, new Object[]{arg2, arg1, arg3}, arg4);
    }

    @OriginalMember(owner = "client!vq", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (true) {
            @Pc(15) SignedResource local15;
            synchronized (this) {
                while (true) {
                    if (this.stopped) {
                        return;
                    }
                    if (this.current != null) {
                        local15 = this.current;
                        this.current = this.current.next;
                        if (this.current == null) {
                            this.last = null;
                        }
                        break;
                    }
                    try {
                        this.wait();
                    } catch (@Pc(32) InterruptedException local32) {
                    }
                }
            }
            try {
                @Pc(42) int local42 = local15.anInt6790;
                if (local42 == 1) {
                    if (SystemTimer.safetime() < Static689.aLong317) {
                        throw new IOException();
                    }
                    local15.result = new Socket(InetAddress.getByName((String) local15.objectData), local15.anInt6788);
                } else if (local42 == 22) {
                    if (Static689.aLong317 > SystemTimer.safetime()) {
                        throw new IOException();
                    }
                    try {
                        local15.result = Static327.method4894((String) local15.objectData, local15.anInt6788).method6097();
                    } catch (@Pc(947) IOException_Sub1 local947) {
                        local15.result = local947.getMessage();
                        throw local947;
                    }
                } else if (local42 == 2) {
                    @Pc(911) Thread local911 = new Thread((Runnable) local15.objectData);
                    local911.setDaemon(true);
                    local911.start();
                    local911.setPriority(local15.anInt6788);
                    local15.result = local911;
                } else if (local42 == 4) {
                    if (SystemTimer.safetime() < Static689.aLong317) {
                        throw new IOException();
                    }
                    local15.result = new DataInputStream(((URL) local15.objectData).openStream());
                } else {
                    @Pc(102) Object[] local102;
                    if (local42 == 8) {
                        local102 = (Object[]) local15.objectData;
                        if (this.signed && ((Class) local102[0]).getClassLoader() == null) {
                            throw new SecurityException();
                        }
                        local15.result = ((Class) local102[0]).getDeclaredMethod((String) local102[1], (Class[]) local102[2]);
                    } else if (local42 == 9) {
                        local102 = (Object[]) local15.objectData;
                        if (this.signed && ((Class) local102[0]).getClassLoader() == null) {
                            throw new SecurityException();
                        }
                        local15.result = ((Class) local102[0]).getDeclaredField((String) local102[1]);
                    } else if (local42 == 18) {
                        @Pc(136) Clipboard local136 = Toolkit.getDefaultToolkit().getSystemClipboard();
                        local15.result = local136.getContents((Object) null);
                    } else if (local42 == 19) {
                        @Pc(149) Transferable local149 = (Transferable) local15.objectData;
                        @Pc(152) Clipboard local152 = Toolkit.getDefaultToolkit().getSystemClipboard();
                        local152.setContents(local149, (ClipboardOwner) null);
                    } else if (this.signed) {
                        @Pc(220) String local220;
                        if (local42 == 3) {
                            if (SystemTimer.safetime() < Static689.aLong317) {
                                throw new IOException();
                            }
                            local220 = (local15.anInt6788 >> 24 & 0xFF) + "." + (local15.anInt6788 >> 16 & 0xFF) + "." + (local15.anInt6788 >> 8 & 0xFF) + "." + (local15.anInt6788 & 0xFF);
                            local15.result = InetAddress.getByName(local220).getHostName();
                        } else if (local42 == 21) {
                            if (SystemTimer.safetime() < Static689.aLong317) {
                                throw new IOException();
                            }
                            local15.result = InetAddress.getByName((String) local15.objectData).getAddress();
                        } else if (local42 == 5) {
                            if (this.microsoftjava) {
                                local15.result = this.aClass15_1.method250();
                            } else {
                                local15.result = Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("listmodes").invoke(this.fullscreenAdapter);
                            }
                        } else if (local42 == 6) {
                            @Pc(268) Frame local268 = new Frame("Jagex Full Screen");
                            local15.result = local268;
                            local268.setResizable(false);
                            if (this.microsoftjava) {
                                this.aClass15_1.method248(local268, local15.anInt6787 >> 16, local15.anInt6787 & 0xFFFF, local15.anInt6788 & 0xFFFF, local15.anInt6788 >>> 16);
                            } else {
                                Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("enter", Static689.aClass24 == null ? (Static689.aClass24 = Class.forName("java.awt.Frame")) : Static689.aClass24, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(this.fullscreenAdapter, local268, Integer.valueOf(local15.anInt6788 >>> 16), new Integer(local15.anInt6788 & 0xFFFF), Integer.valueOf(local15.anInt6787 >> 16), new Integer(local15.anInt6787 & 0xFFFF));
                            }
                        } else if (local42 != 7) {
                            @Pc(438) FileOnDisk local438;
                            if (local42 == 12) {
                                local438 = Static689.method8980(game, storeId, (String) local15.objectData);
                                local15.result = local438;
                            } else if (local42 == 13) {
                                local438 = Static689.method8980("", storeId, (String) local15.objectData);
                                local15.result = local438;
                            } else if (this.signed && local42 == 14) {
                                @Pc(460) int local460 = local15.anInt6788;
                                @Pc(463) int local463 = local15.anInt6787;
                                if (this.microsoftjava) {
                                    this.mouseCallback.movemouse(local460, local463);
                                } else {
                                    Class.forName("MouseAdapter").getDeclaredMethod("movemouse", Integer.TYPE, Integer.TYPE).invoke(this.mouseAdapter, Integer.valueOf(local460), new Integer(local463));
                                }
                            } else if (this.signed && local42 == 15) {
                                @Pc(534) boolean local534 = local15.anInt6788 != 0;
                                @Pc(538) Component local538 = (Component) local15.objectData;
                                if (this.microsoftjava) {
                                    this.mouseCallback.showcursor(local534, local538);
                                } else {
                                    Class.forName("MouseAdapter").getDeclaredMethod("showcursor", Static689.aClass25 == null ? (Static689.aClass25 = Class.forName("java.awt.Component")) : Static689.aClass25, Boolean.TYPE).invoke(this.mouseAdapter, local538, Boolean.valueOf(local534));
                                }
                            } else if (!this.microsoftjava && local42 == 17) {
                                local102 = (Object[]) local15.objectData;
                                Class.forName("MouseAdapter").getDeclaredMethod("setcustomcursor", Static689.aClass25 == null ? (Static689.aClass25 = Class.forName("java.awt.Component")) : Static689.aClass25, Static689.aClass26 == null ? (Static689.aClass26 = Class.forName("[I")) : Static689.aClass26, Integer.TYPE, Integer.TYPE, Static689.aClass27 == null ? (Static689.aClass27 = Class.forName("java.awt.Point")) : Static689.aClass27).invoke(this.mouseAdapter, (Component) local102[0], (int[]) local102[1], Integer.valueOf(local15.anInt6788), new Integer(local15.anInt6787), (Point) local102[2]);
                            } else if (local42 == 16) {
                                try {
                                    if (!osNameLower.startsWith("win")) {
                                        throw new Exception();
                                    }
                                    local220 = (String) local15.objectData;
                                    if (!local220.startsWith("http://") && !local220.startsWith("https://")) {
                                        throw new Exception();
                                    }
                                    @Pc(754) String local754 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
                                    for (@Pc(756) int local756 = 0; local220.length() > local756; local756++) {
                                        if (local754.indexOf(local220.charAt(local756)) == -1) {
                                            throw new Exception();
                                        }
                                    }
                                    Runtime.getRuntime().exec("cmd /c start \"j\" \"" + local220 + "\"");
                                    local15.result = null;
                                } catch (@Pc(793) Exception local793) {
                                    local15.result = local793;
                                    throw local793;
                                }
                            } else {
                                throw new Exception("");
                            }
                        } else if (this.microsoftjava) {
                            this.aClass15_1.method249((Frame) local15.objectData);
                        } else {
                            Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("exit").invoke(this.fullscreenAdapter);
                        }
                    } else {
                        throw new Exception("");
                    }
                }
                local15.status = 1;
            } catch (@Pc(958) ThreadDeath local958) {
                throw local958;
            } catch (@Pc(961) Throwable local961) {
                local15.status = 2;
            }
            synchronized (local15) {
                local15.notify();
            }
        }
    }
}
