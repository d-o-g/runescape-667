package com.jagex.core.io.connection;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

@OriginalClass("client!je")
public final class ClientStreamReader implements Runnable {

    @OriginalMember(owner = "client!je", name = "n", descriptor = "Ljava/io/IOException;")
    public IOException error;

    @OriginalMember(owner = "client!je", name = "m", descriptor = "I")
    public int readPointer = 0;

    @OriginalMember(owner = "client!je", name = "a", descriptor = "I")
    public int bufferPointer = 0;

    @OriginalMember(owner = "client!je", name = "i", descriptor = "Ljava/io/InputStream;")
    public InputStream input;

    @OriginalMember(owner = "client!je", name = "j", descriptor = "I")
    public final int bufferSize;

    @OriginalMember(owner = "client!je", name = "o", descriptor = "[B")
    public final byte[] buffer;

    @OriginalMember(owner = "client!je", name = "l", descriptor = "Ljava/lang/Thread;")
    public final Thread thread;

    @OriginalMember(owner = "client!je", name = "<init>", descriptor = "(Ljava/io/InputStream;I)V")
    public ClientStreamReader(@OriginalArg(0) InputStream input, @OriginalArg(1) int size) {
        this.input = input;
        this.bufferSize = size + 1;
        this.buffer = new byte[this.bufferSize];
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.setName("ClientStreamReader");
        this.thread.start();
    }

    @OriginalMember(owner = "client!je", name = "a", descriptor = "(II)Z")
    public boolean hasAvailable(@OriginalArg(1) int n) throws IOException {
        if (n <= 0 || n >= this.bufferSize) {
            throw new IOException();
        }
        synchronized (this) {
            @Pc(48) int available;
            if (this.readPointer > this.bufferPointer) {
                available = this.bufferSize + this.bufferPointer - this.readPointer;
            } else {
                available = this.bufferPointer - this.readPointer;
            }

            if (n <= available) {
                return true;
            } else if (this.error == null) {
                this.notifyAll();
                return false;
            } else {
                throw new IOException(this.error.toString());
            }
        }
    }

    @OriginalMember(owner = "client!je", name = "a", descriptor = "(Z)V")
    public void reset() {
        this.input = new InputStream_Sub1();
    }

    @OriginalMember(owner = "client!je", name = "a", descriptor = "(B)V")
    public void stop() {
        synchronized (this) {
            if (this.error == null) {
                this.error = new IOException("Closed");
            }

            this.notifyAll();
        }

        try {
            this.thread.join();
        } catch (@Pc(37) InterruptedException ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!je", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (true) {
            @Pc(33) int buffered;

            synchronized (this) {
                while (true) {
                    if (this.error != null) {
                        return;
                    }

                    if (this.readPointer == 0) {
                        buffered = this.bufferSize - this.bufferPointer - 1;
                    } else if (this.bufferPointer >= this.readPointer) {
                        buffered = this.bufferSize - this.bufferPointer;
                    } else {
                        buffered = this.readPointer - this.bufferPointer - 1;
                    }

                    if (buffered > 0) {
                        break;
                    }

                    try {
                        this.wait();
                    } catch (@Pc(71) InterruptedException ignored) {
                        /* empty */
                    }
                }
            }

            @Pc(88) int read;
            try {
                read = this.input.read(this.buffer, this.bufferPointer, buffered);

                if (read == -1) {
                    throw new EOFException();
                }
            } catch (@Pc(97) IOException exception) {
                @Pc(97) IOException error = exception;
                synchronized (this) {
                    this.error = error;
                    return;
                }
            }

            synchronized (this) {
                this.bufferPointer = (read + this.bufferPointer) % this.bufferSize;
            }
        }
    }

    @OriginalMember(owner = "client!je", name = "a", descriptor = "(III[B)I")
    public int read(@OriginalArg(1) int len, @OriginalArg(2) int off, @OriginalArg(3) byte[] buf) throws IOException {
        if (len < 0 || off < 0 || buf.length < len + off) {
            throw new IOException();
        }

        synchronized (this) {
            @Pc(49) int available;
            if (this.bufferPointer >= this.readPointer) {
                available = this.bufferPointer - this.readPointer;
            } else {
                available = this.bufferPointer + this.bufferSize - this.readPointer;
            }

            if (available < len) {
                len = available;
            }

            if (len == 0 && this.error != null) {
                throw new IOException(this.error.toString());
            }

            if (this.bufferSize >= this.readPointer + len) {
                Arrays.copy(this.buffer, this.readPointer, buf, off, len);
            } else {
                @Pc(117) int local117 = this.bufferSize - this.readPointer;
                Arrays.copy(this.buffer, this.readPointer, buf, off, local117);
                Arrays.copy(this.buffer, 0, buf, local117 + off, len + -local117);
            }

            this.readPointer = (len + this.readPointer) % this.bufferSize;
            this.notifyAll();
            return len;
        }
    }
}
