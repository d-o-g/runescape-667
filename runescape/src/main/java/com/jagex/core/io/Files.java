package com.jagex.core.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class Files {

    @OriginalMember(owner = "client!sv", name = "a", descriptor = "(BLjava/io/File;I)[B")
    public static byte[] read(@OriginalArg(1) File file, @OriginalArg(2) int len) {
        try {
            @Pc(6) byte[] data = new byte[len];
            read(file, data, len);
            return data;
        } catch (@Pc(21) IOException ignored) {
            return null;
        }
    }

    @OriginalMember(owner = "client!is", name = "a", descriptor = "(Ljava/io/File;I[BI)V")
    public static void read(@OriginalArg(0) File file, @OriginalArg(2) byte[] data, @OriginalArg(3) int len) throws IOException {
        @Pc(14) DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            input.readFully(data, 0, len);
        } catch (@Pc(21) EOFException ignored) {
            /* empty */
        }
        input.close();
    }

    @OriginalMember(owner = "client!tu", name = "a", descriptor = "(BLjava/io/File;)[B")
    public static byte[] read(@OriginalArg(1) File file) {
        return read(file, (int) file.length());
    }

    private Files() {
        /* empty */
    }
}
