package com.jagex.core.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@OriginalClass("client!dm")
public final class FileOnDisk {

    @OriginalMember(owner = "client!dm", name = "o", descriptor = "Ljava/io/RandomAccessFile;")
    public RandomAccessFile file;

    @OriginalMember(owner = "client!dm", name = "r", descriptor = "J")
    public long position;

    @OriginalMember(owner = "client!dm", name = "k", descriptor = "Ljava/io/File;")
    public final File source;

    @OriginalMember(owner = "client!dm", name = "l", descriptor = "J")
    public final long length;

    @OriginalMember(owner = "client!dm", name = "<init>", descriptor = "(Ljava/io/File;Ljava/lang/String;J)V")
    public FileOnDisk(@OriginalArg(0) File source, @OriginalArg(1) String arg1, @OriginalArg(2) long maxlen) throws IOException {
        if (maxlen == -1L) {
            maxlen = Long.MAX_VALUE;
        }

        if (source.length() > maxlen) {
            System.out.println("Deleting: " + source + " as length exceeds maxlen - filelen:" + source.length() + " maxlen:" + maxlen);
            source.delete();
        }

        this.file = new RandomAccessFile(source, arg1);
        this.position = 0L;
        this.source = source;
        this.length = maxlen;

        @Pc(39) int v = this.file.read();
        if (v != -1 && !arg1.equals("r")) {
            this.file.seek(0L);
            this.file.write(v);
        }

        this.file.seek(0L);
    }

    @OriginalMember(owner = "client!dm", name = "a", descriptor = "(Z)V")
    public void close() throws IOException {
        if (this.file != null) {
            this.file.close();
            this.file = null;
        }
    }

    @OriginalMember(owner = "client!dm", name = "a", descriptor = "(ZJ)V")
    public void seek(@OriginalArg(1) long arg0) throws IOException {
        this.file.seek(arg0);
        this.position = arg0;
    }

    @OriginalMember(owner = "client!dm", name = "a", descriptor = "(I)J")
    public long length() throws IOException {
        return this.file.length();
    }

    @OriginalMember(owner = "client!dm", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() throws Throwable {
        if (this.file != null) {
            System.out.println("Warning! fileondisk " + this.source + " not closed correctly using close(). Auto-closing instead. ");
            this.close();
        }
    }

    @OriginalMember(owner = "client!dm", name = "a", descriptor = "(B[BII)V")
    public void write(@OriginalArg(1) byte[] data, @OriginalArg(2) int off, @OriginalArg(3) int len) throws IOException {
        if (this.position + (long) len > this.length) {
            this.file.seek(this.length);
            this.file.write(1);
            throw new EOFException();
        } else {
            this.file.write(data, off, len);
            this.position += len;
        }
    }

    @OriginalMember(owner = "client!dm", name = "a", descriptor = "(BI[BI)I")
    public int read(@OriginalArg(1) int len, @OriginalArg(2) byte[] data, @OriginalArg(3) int off) throws IOException {
        @Pc(19) int result = this.file.read(data, off, len);
        if (result > 0) {
            this.position += (long) result;
        }
        return result;
    }

    @OriginalMember(owner = "client!dm", name = "b", descriptor = "(Z)Ljava/io/File;")
    public File source() {
        return this.source;
    }
}
