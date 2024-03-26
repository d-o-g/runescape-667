package com.jagex.core.io;

import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.SignedResourceStatus;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@OriginalClass("client!nk")
public final class BufferedSocket implements Runnable {

    @OriginalMember(owner = "client!nk", name = "j", descriptor = "Lclient!oba;")
    public SignedResource threadReference;

    @OriginalMember(owner = "client!nk", name = "f", descriptor = "[B")
    public byte[] writeBuffer;

    @OriginalMember(owner = "client!nk", name = "n", descriptor = "Z")
    public boolean closed = false;

    @OriginalMember(owner = "client!nk", name = "k", descriptor = "I")
    public int bufPos = 0;

    @OriginalMember(owner = "client!nk", name = "g", descriptor = "I")
    public int writePos = 0;

    @OriginalMember(owner = "client!nk", name = "p", descriptor = "Z")
    public boolean error = false;

    @OriginalMember(owner = "client!nk", name = "u", descriptor = "Lclient!vq;")
    public final SignLink signLink;

    @OriginalMember(owner = "client!nk", name = "w", descriptor = "Ljava/net/Socket;")
    public final Socket socket;

    @OriginalMember(owner = "client!nk", name = "t", descriptor = "Ljava/io/InputStream;")
    public InputStream inputStream;

    @OriginalMember(owner = "client!nk", name = "c", descriptor = "Ljava/io/OutputStream;")
    public OutputStream outputStream;

    @OriginalMember(owner = "client!nk", name = "d", descriptor = "I")
    public final int bufSize;

    @OriginalMember(owner = "client!nk", name = "<init>", descriptor = "(Ljava/net/Socket;Lclient!vq;I)V")
    public BufferedSocket(@OriginalArg(0) Socket socket, @OriginalArg(1) SignLink signLink, @OriginalArg(2) int bufSize) throws IOException {
        this.signLink = signLink;
        this.socket = socket;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        this.inputStream = this.socket.getInputStream();
        this.outputStream = this.socket.getOutputStream();
        this.bufSize = bufSize;
    }

    @OriginalMember(owner = "client!nk", name = "a", descriptor = "(I)V")
    public void sanityCheck() throws IOException {
        if (!this.closed && this.error) {
            this.error = false;
            throw new IOException();
        }
    }

    @OriginalMember(owner = "client!nk", name = "d", descriptor = "(I)I")
    public int read() throws IOException {
        return this.closed ? 0 : this.inputStream.read();
    }

    @OriginalMember(owner = "client!nk", name = "run", descriptor = "()V")
    @Override
    public void run() {
        try {
            while (true) {
                label80:
                {
                    @Pc(38) int len;
                    @Pc(26) int off;

                    synchronized (this) {
                        if (this.writePos == this.bufPos) {
                            if (this.closed) {
                                break label80;
                            }

                            try {
                                this.wait();
                            } catch (@Pc(22) InterruptedException ignored) {
                                /* empty */
                            }
                        }

                        off = this.writePos;

                        if (this.bufPos >= this.writePos) {
                            len = this.bufPos - this.writePos;
                        } else {
                            len = this.bufSize - this.writePos;
                        }
                    }

                    if (len > 0) {
                        try {
                            this.outputStream.write(this.writeBuffer, off, len);
                        } catch (@Pc(66) IOException local66) {
                            this.error = true;
                        }

                        this.writePos = (this.writePos + len) % this.bufSize;
                        try {
                            if (this.bufPos == this.writePos) {
                                this.outputStream.flush();
                            }
                        } catch (@Pc(89) IOException local89) {
                            this.error = true;
                        }
                    }

                    continue;
                }

                try {
                    if (this.inputStream != null) {
                        this.inputStream.close();
                    }

                    if (this.outputStream != null) {
                        this.outputStream.close();
                    }

                    if (this.socket != null) {
                        this.socket.close();
                    }
                } catch (@Pc(117) IOException ignored) {
                    /* empty */
                }

                this.writeBuffer = null;
                break;
            }
        } catch (@Pc(122) Exception cause) {
            JagException.sendTrace(cause, null);
        }
    }

    @OriginalMember(owner = "client!nk", name = "a", descriptor = "(IBI[B)V")
    public void read(@OriginalArg(0) int len, @OriginalArg(2) int off, @OriginalArg(3) byte[] data) throws IOException {
        if (this.closed) {
            return;
        }

        while (len > 0) {
            @Pc(22) int read = this.inputStream.read(data, off, len);
            if (read <= 0) {
                throw new EOFException();
            }
            off += read;
            len -= read;
        }
    }

    @OriginalMember(owner = "client!nk", name = "a", descriptor = "(B)V")
    public void breakConnection() {
        if (!this.closed) {
            this.inputStream = new DummyInputStream();
            this.outputStream = new DummyOutputStream();
        }
    }

    @OriginalMember(owner = "client!nk", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        this.close();
    }

    @OriginalMember(owner = "client!nk", name = "c", descriptor = "(I)I")
    public int available() throws IOException {
        return this.closed ? 0 : this.inputStream.available();
    }

    @OriginalMember(owner = "client!nk", name = "a", descriptor = "(II[BB)V")
    public void write(@OriginalArg(1) int arg0, @OriginalArg(2) byte[] arg1) throws IOException {
        if (this.closed) {
            return;
        }

        if (this.error) {
            this.error = false;
            throw new IOException();
        }

        if (this.writeBuffer == null) {
            this.writeBuffer = new byte[this.bufSize];
        }

        synchronized (this) {
            for (@Pc(40) int i = 0; i < arg0; i++) {
                this.writeBuffer[this.bufPos] = arg1[i];
                this.bufPos = (this.bufPos + 1) % this.bufSize;
                if ((this.bufSize + this.writePos - 100) % this.bufSize == this.bufPos) {
                    throw new IOException();
                }
            }

            if (this.threadReference == null) {
                this.threadReference = this.signLink.startThread(this, 3);
            }

            this.notifyAll();
        }
    }

    @OriginalMember(owner = "client!nk", name = "e", descriptor = "(I)V")
    public void close() {
        if (this.closed) {
            return;
        }

        synchronized (this) {
            this.closed = true;
            this.notifyAll();
        }

        if (this.threadReference != null) {
            while (this.threadReference.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(1L);
            }

            if (this.threadReference.status == SignedResourceStatus.SUCCESS) {
                try {
                    ((Thread) this.threadReference.result).join();
                } catch (@Pc(60) InterruptedException ignored) {
                    /* empty */
                }
            }
        }

        this.threadReference = null;
    }
}
