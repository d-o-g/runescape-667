package com.jagex;

import com.jagex.core.constants.FileStore;
import com.jagex.core.constants.SignedResourceType;
import com.jagex.core.io.FileCache;
import com.jagex.core.io.FileOnDisk;
import com.jagex.core.io.socket.ProxyAuthenticationException;
import com.jagex.core.io.socket.SocketFactory;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.client.GameShell;
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

    private static final String UIDFileName = "random.dat";

    private static final String cacheDatFilename = "main_file_cache.dat2";

    private static final String cacheMasterIndexFilename = "main_file_cache.idx255";

    private static final String cacheIndexFilename = "main_file_cache.idx";

    private static final long MAX_CACHEINDEX_SIZE = 1048576L;

    private static final String FILE_ACCESS_PERMISSIONS = "rw";

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "s", descriptor = "Ljava/lang/Class;")
    public static Class frameClass;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "p", descriptor = "Ljava/lang/Class;")
    public static Class componentClass;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "g", descriptor = "Ljava/lang/Class;")
    public static Class intArrayClass;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "d", descriptor = "Ljava/lang/Class;")
    public static Class pointClass;

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

    @OriginalMember(owner = "client!vq", name = "w", descriptor = "I")
    public static int cacheId;

    @OriginalMember(owner = "client!vq", name = "t", descriptor = "J")
    public static volatile long timeout = 0L;

    @OriginalMember(owner = "client!iu", name = "h", descriptor = "Lclient!vq;")
    public static SignLink instance;

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
    public SignLink(@OriginalArg(0) int cacheId, @OriginalArg(1) String game, @OriginalArg(2) int archiveCount, @OriginalArg(3) boolean signed) throws Exception {
        SignLink.game = game;
        GameShell.javaVersion = "1.1";
        GameShell.javaVendor = "Unknown";

        this.signed = signed;
        SignLink.cacheId = cacheId;

        try {
            GameShell.javaVendor = System.getProperty("java.vendor");
            GameShell.javaVersion = System.getProperty("java.version");
        } catch (@Pc(52) Exception ignored) {
            /* empty */
        }

        if (GameShell.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
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
                GameShell.setFocusCycleRoot = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
            } catch (@Pc(168) Exception ignored) {
                /* empty */
            }
        }

        FileCache.initialize(SignLink.cacheId, SignLink.game);

        if (this.signed) {
            this.uidFile = new FileOnDisk(FileCache.get(null, SignLink.cacheId, UIDFileName), FILE_ACCESS_PERMISSIONS, 25L);
            this.cacheDat = new FileOnDisk(FileCache.get(cacheDatFilename), FILE_ACCESS_PERMISSIONS, 314572800L);
            this.masterIndex = new FileOnDisk(FileCache.get(cacheMasterIndexFilename), FILE_ACCESS_PERMISSIONS, MAX_CACHEINDEX_SIZE);
            this.cacheIndex = new FileOnDisk[archiveCount];

            for (@Pc(226) int i = 0; i < archiveCount; i++) {
                this.cacheIndex[i] = new FileOnDisk(FileCache.get(cacheIndexFilename + i), FILE_ACCESS_PERMISSIONS, MAX_CACHEINDEX_SIZE);
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

    @OriginalMember(owner = "client!vf", name = "a", descriptor = "(Lclient!vq;Z)[Lclient!oga;")
    public static DisplayProperties[] getDisplayProperties(@OriginalArg(0) SignLink signlink, @OriginalArg(1) boolean arg1) {
        if (!signlink.supportsFullscreen()) {
            return new DisplayProperties[0];
        }

        @Pc(15) SignedResource resource = signlink.getDisplayProperties();
        while (resource.status == 0) {
            TimeUtils.sleep(10L);
        }

        if (resource.status == 2) {
            return new DisplayProperties[0];
        }

        @Pc(38) int[] result = (int[]) resource.result;
        @Pc(44) DisplayProperties[] properties = new DisplayProperties[result.length >> 2];
        for (@Pc(46) int i = 0; i < properties.length; i++) {
            @Pc(51) DisplayProperties current = new DisplayProperties();
            properties[i] = current;
            current.width = result[i << 2];
            current.height = result[(i << 2) + 1];
            current.oldWidth = result[(i << 2) + 2];
            current.oldHeight = result[(i << 2) + 3];
        }

        if (arg1) {
            return properties;
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(ILjava/lang/String;)Lclient!dm;")
    public static FileOnDisk openPrefs(@OriginalArg(1) String name) {
        return openPrefs(game, cacheId, name);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;I)Lclient!dm;")
    public static FileOnDisk openPrefs(@OriginalArg(0) String game, @OriginalArg(1) int storeId, @OriginalArg(2) String name) {
        @Pc(29) String path;
        if (storeId == FileStore.RC) {
            path = "jagex_" + game + "_preferences" + name + "_rc.dat";
        } else if (storeId == FileStore.WIP) {
            path = "jagex_" + game + "_preferences" + name + "_wip.dat";
        } else {
            path = "jagex_" + game + "_preferences" + name + ".dat";
        }

        @Pc(121) String[] cacheLocations = {
            "c:/rscache/",
            "/rscache/",
            homeDir,
            "c:/windows/",
            "c:/winnt/",
            "c:/",
            "/tmp/",
            ""
        };

        for (@Pc(123) int i = 0; i < cacheLocations.length; i++) {
            @Pc(128) String dir = cacheLocations[i];

            if (dir.length() <= 0 || (new File(dir)).exists()) {
                try {
                    return new FileOnDisk(new File(dir, path), FILE_ACCESS_PERMISSIONS, 10000L);
                } catch (@Pc(158) Exception ignored) {
                    /* empty */
                }
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!vq", name = "c", descriptor = "(B)Ljava/lang/Object;")
    public Object method8976() {
        return this.anObject21;
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IIIII)Lclient!oba;")
    public SignedResource enterFullscreen(@OriginalArg(3) int width, @OriginalArg(1) int height, @OriginalArg(0) int oldWidth, @OriginalArg(2) int oldHeight) {
        return this.request(SignedResourceType.ENTER_FULLSCREEN, null, (width << 16) + height, (oldWidth << 16) + oldHeight);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/String;I)Lclient!oba;")
    public SignedResource getField(@OriginalArg(0) Class owner, @OriginalArg(1) String name) {
        return this.request(SignedResourceType.FIELD, new Object[]{owner, name}, 0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/String;ZZI)Lclient!oba;")
    public SignedResource openSocket(@OriginalArg(0) String host, @OriginalArg(3) int port, @OriginalArg(2) boolean proxy) {
        return this.request(proxy ? SignedResourceType.SOCKET_PROXY : SignedResourceType.SOCKET, host, port, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(ZLjava/lang/String;B)Lclient!oba;")
    public SignedResource openPrefs(@OriginalArg(1) String string, boolean specific) {
        if (specific) {
            return this.request(SignedResourceType.PREFERENCES_SPECIFIC_GAME, string, 0, 0);
        } else {
            return this.request(SignedResourceType.PREFERENCES, string, 0, 0);
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BI)Lclient!oba;")
    public SignedResource lookupHostname(@OriginalArg(1) int ip) {
        return this.request(SignedResourceType.HOSTNAME, null, ip, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(B)Lclient!oba;")
    public SignedResource getDisplayProperties() {
        return this.request(SignedResourceType.DISPLAY_PROPERTIES, null, 0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "b", descriptor = "(I)V")
    public void stop() {
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
    public SignedResource openPage(@OriginalArg(0) String string) {
        return this.request(SignedResourceType.OPEN_PAGE, string, 0, 0);
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
    public SignedResource getMethod(@OriginalArg(0) Class owner, @OriginalArg(2) String name, @OriginalArg(1) Class[] parameters) {
        return this.request(SignedResourceType.METHOD, new Object[]{owner, name, parameters}, 0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/awt/Frame;I)Lclient!oba;")
    public SignedResource exitFullscreen(@OriginalArg(0) Frame frame) {
        return this.request(SignedResourceType.EXIT_FULLSCREEN, frame, 0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(I)Z")
    public boolean supportsFullscreen() {
        if (!this.signed) {
            return false;
        } else if (this.microsoftjava) {
            return this.aClass15_1 != null;
        } else {
            return this.fullscreenAdapter != null;
        }
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BLjava/lang/Runnable;I)Lclient!oba;")
    public SignedResource startThread(@OriginalArg(1) Runnable runnable, @OriginalArg(2) int priority) {
        return this.request(SignedResourceType.START_THREAD, runnable, priority, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(BLjava/net/URL;)Lclient!oba;")
    public SignedResource openStream(@OriginalArg(1) URL url) {
        return this.request(SignedResourceType.OPEN_STREAM, url, 0, 0);
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IILjava/lang/Object;II)Lclient!oba;")
    public SignedResource request(@OriginalArg(1) int type, @OriginalArg(2) Object objectData, @OriginalArg(4) int intData1, @OriginalArg(0) int intData2) {
        @Pc(3) SignedResource resource = new SignedResource();
        resource.objectData = objectData;
        resource.intData1 = intData1;
        resource.type = type;
        resource.intData2 = intData2;
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
    public void timeout() {
        timeout = SystemTimer.safetime() + 5000L;
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(IB[ILjava/awt/Component;Ljava/awt/Point;I)Lclient!oba;")
    public SignedResource method8995(@OriginalArg(3) Component component, @OriginalArg(2) int[] arg1, @OriginalArg(4) Point point, @OriginalArg(5) int arg4, @OriginalArg(0) int arg0) {
        return this.request(SignedResourceType.UPDATE_MOUSE_CURSOR, new Object[]{component, arg1, point}, arg4, arg0);
    }

    @OriginalMember(owner = "client!vq", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (true) {
            @Pc(15) SignedResource request;
            synchronized (this) {
                while (true) {
                    if (this.stopped) {
                        return;
                    }
                    if (this.current != null) {
                        request = this.current;
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
                @Pc(42) int type = request.type;
                if (type == SignedResourceType.SOCKET) {
                    if (SystemTimer.safetime() < timeout) {
                        throw new IOException();
                    }

                    request.result = new Socket(InetAddress.getByName((String) request.objectData), request.intData1);
                } else if (type == SignedResourceType.SOCKET_PROXY) {
                    if (timeout > SystemTimer.safetime()) {
                        throw new IOException();
                    }

                    try {
                        request.result = SocketFactory.create((String) request.objectData, request.intData1).open();
                    } catch (@Pc(947) ProxyAuthenticationException exception) {
                        request.result = exception.getMessage();
                        throw exception;
                    }
                } else if (type == SignedResourceType.START_THREAD) {
                    @Pc(911) Thread thread = new Thread((Runnable) request.objectData);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(request.intData1);
                    request.result = thread;
                } else if (type == SignedResourceType.OPEN_STREAM) {
                    if (SystemTimer.safetime() < timeout) {
                        throw new IOException();
                    }

                    request.result = new DataInputStream(((URL) request.objectData).openStream());
                } else if (type == SignedResourceType.METHOD) {
                    @Pc(102) Object[] objectData = (Object[]) request.objectData;
                    if (this.signed && ((Class) objectData[0]).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    request.result = ((Class) objectData[0]).getDeclaredMethod((String) objectData[1], (Class[]) objectData[2]);
                } else if (type == SignedResourceType.FIELD) {
                    @Pc(102) Object[] objectData = (Object[]) request.objectData;
                    if (this.signed && ((Class) objectData[0]).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    request.result = ((Class) objectData[0]).getDeclaredField((String) objectData[1]);
                } else if (type == SignedResourceType.GET_CLIPBOARD_CONTENTS) {
                    @Pc(136) Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    request.result = clipboard.getContents(null);
                } else if (type == SignedResourceType.SET_CLIPBOARD_CONTENTS) {
                    @Pc(149) Transferable transferable = (Transferable) request.objectData;
                    @Pc(152) Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(transferable, null);
                } else if (this.signed) {
                    if (type == SignedResourceType.HOSTNAME) {
                        if (SystemTimer.safetime() < timeout) {
                            throw new IOException();
                        }

                        @Pc(220) String ip = ((request.intData1 >> 24) & 0xFF)
                            + "." + ((request.intData1 >> 16) & 0xFF)
                            + "." + ((request.intData1 >> 8) & 0xFF)
                            + "." + (request.intData1 & 0xFF);

                        request.result = InetAddress.getByName(ip).getHostName();
                    } else if (type == SignedResourceType.ADDRESS) {
                        if (SystemTimer.safetime() < timeout) {
                            throw new IOException();
                        }

                        request.result = InetAddress.getByName((String) request.objectData).getAddress();
                    } else if (type == SignedResourceType.DISPLAY_PROPERTIES) {
                        if (this.microsoftjava) {
                            request.result = this.aClass15_1.method250();
                        } else {
                            request.result = Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("listmodes").invoke(this.fullscreenAdapter);
                        }
                    } else if (type == SignedResourceType.ENTER_FULLSCREEN) {
                        @Pc(268) Frame frame = new Frame("Jagex Full Screen");
                        request.result = frame;
                        frame.setResizable(false);

                        if (this.microsoftjava) {
                            this.aClass15_1.method248(frame, request.intData2 >> 16, request.intData2 & 0xFFFF, request.intData1 & 0xFFFF, request.intData1 >>> 16);
                        } else {
                            Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("enter", frameClass == null ? (frameClass = Class.forName("java.awt.Frame")) : frameClass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(this.fullscreenAdapter, frame, Integer.valueOf(request.intData1 >>> 16), new Integer(request.intData1 & 0xFFFF), Integer.valueOf(request.intData2 >> 16), new Integer(request.intData2 & 0xFFFF));
                        }
                    } else if (type == SignedResourceType.EXIT_FULLSCREEN) {
                        if (this.microsoftjava) {
                            this.aClass15_1.method249((Frame) request.objectData);
                        } else {
                            Class.forName("com.jagex.graphics.FullscreenAdapter").getMethod("exit").invoke(this.fullscreenAdapter);
                        }
                    } else if (type == SignedResourceType.PREFERENCES_SPECIFIC_GAME) {
                        @Pc(438) FileOnDisk file = openPrefs(game, cacheId, (String) request.objectData);
                        request.result = file;
                    } else if (type == SignedResourceType.PREFERENCES) {
                        @Pc(438) FileOnDisk file = openPrefs("", cacheId, (String) request.objectData);
                        request.result = file;
                    } else if (this.signed && type == SignedResourceType.MOVE_MOUSE) {
                        @Pc(460) int x = request.intData1;
                        @Pc(463) int y = request.intData2;

                        if (this.microsoftjava) {
                            this.mouseCallback.movemouse(x, y);
                        } else {
                            Class.forName("MouseAdapter").getDeclaredMethod("movemouse", Integer.TYPE, Integer.TYPE).invoke(this.mouseAdapter, Integer.valueOf(x), new Integer(y));
                        }
                    } else if (this.signed && type == SignedResourceType.UPDATE_MOUSE_COMPONENT) {
                        @Pc(534) boolean delete = request.intData1 != 0;
                        @Pc(538) Component component = (Component) request.objectData;

                        if (this.microsoftjava) {
                            this.mouseCallback.showcursor(delete, component);
                        } else {
                            Class.forName("MouseAdapter").getDeclaredMethod("showcursor", componentClass == null ? (componentClass = Class.forName("java.awt.Component")) : componentClass, Boolean.TYPE).invoke(this.mouseAdapter, component, Boolean.valueOf(delete));
                        }
                    } else if (!this.microsoftjava && type == SignedResourceType.UPDATE_MOUSE_CURSOR) {
                        @Pc(102) Object[] objectData = (Object[]) request.objectData;
                        Class.forName("MouseAdapter").getDeclaredMethod("setcustomcursor", componentClass == null ? (componentClass = Class.forName("java.awt.Component")) : componentClass, intArrayClass == null ? (intArrayClass = Class.forName("[I")) : intArrayClass, Integer.TYPE, Integer.TYPE, pointClass == null ? (pointClass = Class.forName("java.awt.Point")) : pointClass).invoke(this.mouseAdapter, objectData[0], objectData[1], Integer.valueOf(request.intData1), new Integer(request.intData2), objectData[2]);
                    } else if (type == SignedResourceType.OPEN_PAGE) {
                        try {
                            if (!osNameLower.startsWith("win")) {
                                throw new Exception();
                            }

                            @Pc(220) String url = (String) request.objectData;
                            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                                throw new Exception();
                            }

                            @Pc(754) String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";
                            for (@Pc(756) int i = 0; url.length() > i; i++) {
                                if (validChars.indexOf(url.charAt(i)) == -1) {
                                    throw new Exception();
                                }
                            }

                            Runtime.getRuntime().exec("cmd /c start \"j\" \"" + url + "\"");
                            request.result = null;
                        } catch (@Pc(793) Exception local793) {
                            request.result = local793;
                            throw local793;
                        }
                    } else {
                        throw new Exception("");
                    }
                } else {
                    throw new Exception("");
                }

                request.status = 1;
            } catch (@Pc(958) ThreadDeath death) {
                throw death;
            } catch (@Pc(961) Throwable local961) {
                request.status = 2;
            }

            synchronized (request) {
                request.notify();
            }
        }
    }
}
