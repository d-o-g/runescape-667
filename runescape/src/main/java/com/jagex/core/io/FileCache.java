package com.jagex.core.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Hashtable;

public final class FileCache {

    @OriginalMember(owner = "client!uia", name = "a", descriptor = "Z")
    public static boolean initialized = false;

    @OriginalMember(owner = "client!uia", name = "b", descriptor = "Ljava/util/Hashtable;")
    public static final Hashtable files = new Hashtable(16);

    @OriginalMember(owner = "client!uia", name = "d", descriptor = "Ljava/lang/String;")
    public static String game;

    @OriginalMember(owner = "client!uia", name = "e", descriptor = "I")
    public static int cacheId;

    @OriginalMember(owner = "client!uia", name = "c", descriptor = "Ljava/lang/String;")
    public static String homeDir;

    @OriginalMember(owner = "client!uia", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/io/File;")
    public static File get(@OriginalArg(0) String name) {
        return get(game, cacheId, name);
    }

    @OriginalMember(owner = "client!uia", name = "a", descriptor = "(BLjava/lang/String;ILjava/lang/String;)Ljava/io/File;")
    public static File get(@OriginalArg(1) String game, @OriginalArg(2) int cacheId, @OriginalArg(3) String name) {
        if (!initialized) {
            throw new RuntimeException("");
        }

        @Pc(12) File file = (File) files.get(name);
        if (file != null) {
            return file;
        }

        @Pc(64) String[] cacheLocations = {
            "c:/rscache/",
            "/rscache/",
            "c:/windows/",
            "c:/winnt/",
            "c:/",
            homeDir,
            "/tmp/",
            ""
        };

        @Pc(91) String[] cacheDirectories = {
            ".jagex_cache_" + cacheId,
            ".file_store_" + cacheId
        };

        for (@Pc(99) int i = 0; i < 2; i++) {
            for (@Pc(102) int j = 0; j < cacheDirectories.length; j++) {
                for (@Pc(105) int k = 0; k < cacheLocations.length; k++) {
                    @Pc(137) String path = cacheLocations[k] + cacheDirectories[j] + "/" + (game == null ? "" : game + "/") + name;
                    @Pc(139) RandomAccessFile raf = null;
                    try {
                        @Pc(144) File f = new File(path);

                        if (i != 0 || f.exists()) {
                            @Pc(155) String rootDir = cacheLocations[k];
                            if (i != 1 || rootDir.length() <= 0 || (new File(rootDir)).exists()) {
                                (new File(cacheLocations[k] + cacheDirectories[j])).mkdir();

                                if (game != null) {
                                    (new File(cacheLocations[k] + cacheDirectories[j] + "/" + game)).mkdir();
                                }

                                raf = new RandomAccessFile(f, "rw");
                                @Pc(224) int v = raf.read();
                                raf.seek(0L);
                                raf.write(v);
                                raf.seek(0L);
                                raf.close();
                                files.put(name, f);
                                return f;
                            }
                        }
                    } catch (@Pc(243) Exception local243) {
                        try {
                            if (raf != null) {
                                raf.close();
                            }
                        } catch (@Pc(251) Exception ignored) {
                            /* empty */
                        }
                    }
                }
            }
        }

        throw new RuntimeException();
    }

    @OriginalMember(owner = "client!uia", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void initialize(@OriginalArg(0) int cacheId, @OriginalArg(1) String game) {
        FileCache.cacheId = cacheId;
        FileCache.game = game;

        try {
            homeDir = System.getProperty("user.home");

            if (homeDir != null) {
                homeDir = homeDir + "/";
            }
        } catch (@Pc(26) Exception ignored) {
            /* empty */
        }

        if (homeDir == null) {
            homeDir = "~/";
        }

        initialized = true;
    }

    private FileCache() {
        /* empty */
    }
}
