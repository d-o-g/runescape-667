package com.jagex.core.io.connection;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.io.OutputStream;

@OriginalClass("client!vja")
public final class ClientStreamWriter implements Runnable {

    @OriginalMember(owner = "client!vja", name = "i", descriptor = "Ljava/io/IOException;")
    public IOException error;

    @OriginalMember(owner = "client!vja", name = "g", descriptor = "I")
    public int bufferPointer = 0;

    @OriginalMember(owner = "client!vja", name = "b", descriptor = "I")
    public int writePointer = 0;

    @OriginalMember(owner = "client!vja", name = "j", descriptor = "Ljava/io/OutputStream;")
    public OutputStream output;

    @OriginalMember(owner = "client!vja", name = "a", descriptor = "I")
    public final int bufferSize;

    @OriginalMember(owner = "client!vja", name = "e", descriptor = "[B")
    public final byte[] buffer;

    @OriginalMember(owner = "client!vja", name = "m", descriptor = "Ljava/lang/Thread;")
    public final Thread thread;

    @OriginalMember(owner = "client!vja", name = "<init>", descriptor = "(Ljava/io/OutputStream;I)V")
    public ClientStreamWriter(@OriginalArg(0) OutputStream output, @OriginalArg(1) int size) {
        this.output = output;
        this.bufferSize = size + 1;
        this.buffer = new byte[this.bufferSize];
        this.thread = new Thread(this);
        this.thread.setDaemon(true);
        this.thread.setName("ClientStreamWriter");
        this.thread.start();
    }

    @OriginalMember(owner = "client!vja", name = "a", descriptor = "(I)V")
    public void stop() {
        synchronized (this) {
            if (this.error == null) {
                this.error = new IOException("");
            }

            this.notifyAll();
        }

        try {
            this.thread.join();
        } catch (@Pc(29) InterruptedException ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!vja", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (true) {
            @Pc(34) int buffered;

            synchronized (this) {
                while (true) {
                    if (this.error != null) {
                        return;
                    }

                    if (this.writePointer < this.bufferPointer) {
                        buffered = this.writePointer + this.bufferSize - this.bufferPointer;
                    } else {
                        buffered = this.writePointer - this.bufferPointer;
                    }

                    if (buffered > 0) {
                        break;
                    }

                    try {
                        this.output.flush();
                    } catch (@Pc(54) IOException error) {
                        this.error = error;
                        return;
                    }

                    try {
                        this.wait();
                    } catch (@Pc(64) InterruptedException ignored) {
                        /* empty */
                    }
                }
            }

            try {
                if (this.bufferSize < this.bufferPointer + buffered) {
                    @Pc(90) int length = this.bufferSize - this.bufferPointer;
                    this.output.write(this.buffer, this.bufferPointer, length);
                    this.output.write(this.buffer, 0, buffered - length);
                } else {
                    this.output.write(this.buffer, this.bufferPointer, buffered);
                }
            } catch (@Pc(119) IOException exception) {
                @Pc(119) IOException error = exception;
                synchronized (this) {
                    this.error = error;
                    return;
                }
            }

            synchronized (this) {
                this.bufferPointer = (this.bufferPointer + buffered) % this.bufferSize;
            }
        }
    }

    @OriginalMember(owner = "client!vja", name = "a", descriptor = "([BIII)V")
    public void write(@OriginalArg(0) byte[] buf, @OriginalArg(1) int len, @OriginalArg(3) int off) throws IOException {
        if (len < 0 || off < 0 || buf.length < len + off) {
            throw new IOException();
        }

        synchronized (this) {
            if (this.error != null) {
                throw new IOException(this.error.toString());
            }

            @Pc(60) int available;
            if (this.writePointer < this.bufferPointer) {
                available = this.bufferPointer - this.writePointer - 1;
            } else {
                available = this.bufferPointer + this.bufferSize - this.writePointer - 1;
            }

            if (len > available) {
                throw new IOException("Buffer overflow " + len + " " + available);
            }

            if (len + this.writePointer > this.bufferSize) {
                @Pc(101) int wrap = this.bufferSize - this.writePointer;
                Arrays.copy(buf, off, this.buffer, this.writePointer, wrap);
                Arrays.copy(buf, off + wrap, this.buffer, 0, len - wrap);
            } else {
                Arrays.copy(buf, off, this.buffer, this.writePointer, len);
            }

            this.writePointer = (len + this.writePointer) % this.bufferSize;
            this.notifyAll();
        }
    }

    @OriginalMember(owner = "client!vja", name = "b", descriptor = "(I)V")
    public void reset() {
        this.output = new OutputStream_Sub1();
    }
}
