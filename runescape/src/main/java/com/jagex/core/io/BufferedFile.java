package com.jagex.core.io;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

@OriginalClass("client!mj")
public final class BufferedFile {

    @OriginalMember(owner = "client!mj", name = "j", descriptor = "J")
    public long physicalPosition;

    @OriginalMember(owner = "client!mj", name = "x", descriptor = "I")
    public int readCount;

    @OriginalMember(owner = "client!mj", name = "w", descriptor = "I")
    public int writeCount = 0;

    @OriginalMember(owner = "client!mj", name = "b", descriptor = "J")
    public long readPosition = -1L;

    @OriginalMember(owner = "client!mj", name = "l", descriptor = "J")
    public long writePosition = -1L;

    @OriginalMember(owner = "client!mj", name = "g", descriptor = "Lclient!dm;")
    public final FileOnDisk file;

    @OriginalMember(owner = "client!mj", name = "t", descriptor = "J")
    public long physicalLength;

    @OriginalMember(owner = "client!mj", name = "k", descriptor = "J")
    public long length;

    @OriginalMember(owner = "client!mj", name = "c", descriptor = "J")
    public long virtualPosition;

    @OriginalMember(owner = "client!mj", name = "v", descriptor = "[B")
    public final byte[] readBuffer;

    @OriginalMember(owner = "client!mj", name = "h", descriptor = "[B")
    public final byte[] writeBuffer;

    @OriginalMember(owner = "client!mj", name = "<init>", descriptor = "(Lclient!dm;II)V")
    public BufferedFile(@OriginalArg(0) FileOnDisk file, @OriginalArg(1) int readSize, @OriginalArg(2) int writeSize) throws IOException {
        this.file = file;
        this.length = this.physicalLength = file.length();
        this.virtualPosition = 0L;
        this.readBuffer = new byte[readSize];
        this.writeBuffer = new byte[writeSize];
    }

    @OriginalMember(owner = "client!mj", name = "b", descriptor = "(I)Ljava/io/File;")
    public File source() {
        return this.file.source();
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(II[BI)V")
    public void read(@OriginalArg(1) int len, @OriginalArg(2) byte[] data, @OriginalArg(3) int off) throws IOException {
        try {
            if (off + len > data.length) {
                throw new ArrayIndexOutOfBoundsException(off + len - data.length);
            }

            if (this.writePosition != -1L && this.virtualPosition >= this.writePosition && (long) len + this.virtualPosition <= (long) this.writeCount + this.writePosition) {
                Arrays.copy(this.writeBuffer, (int) (this.virtualPosition - this.writePosition), data, off, len);
                this.virtualPosition += len;
                return;
            }

            @Pc(92) long startPos = this.virtualPosition;
            @Pc(96) int startLen = len;
            if (this.virtualPosition >= this.readPosition && this.virtualPosition < this.readPosition + (long) this.readCount) {
                @Pc(132) int copyLen = (int) ((long) this.readCount + this.readPosition - this.virtualPosition);
                if (len < copyLen) {
                    copyLen = len;
                }

                Arrays.copy(this.readBuffer, (int) (this.virtualPosition - this.readPosition), data, off, copyLen);
                this.virtualPosition += copyLen;
                off = copyLen;
                len -= copyLen;
            }

            if (this.readBuffer.length < len) {
                this.file.seek(this.virtualPosition);
                this.physicalPosition = this.virtualPosition;

                while (len > 0) {
                    @Pc(132) int read = this.file.read(len, data, off);
                    if (read == -1) {
                        break;
                    }

                    this.virtualPosition += read;
                    len -= read;
                    off += read;
                    this.physicalPosition += read;
                }
            } else if (len > 0) {
                this.fill();

                @Pc(132) int read = len;
                if (this.readCount < len) {
                    read = this.readCount;
                }

                Arrays.copy(this.readBuffer, 0, data, off, read);
                off += read;
                this.virtualPosition += read;
                len -= read;
            }

            if (this.writePosition != -1L) {
                if (this.writePosition > this.virtualPosition && len > 0) {
                    @Pc(132) int end = (int) (this.writePosition - this.virtualPosition) + off;
                    if (end > off + len) {
                        end = off + len;
                    }

                    while (off < end) {
                        len--;
                        data[off++] = 0;
                        this.virtualPosition++;
                    }
                }

                @Pc(323) long start = -1L;
                if (startPos <= this.writePosition && this.writePosition < startPos + (long) startLen) {
                    start = this.writePosition;
                } else if (this.writePosition <= startPos && this.writePosition + (long) this.writeCount > startPos) {
                    start = startPos;
                }

                @Pc(373) long end = -1L;
                if (startPos < this.writePosition + (long) this.writeCount && (long) startLen + startPos >= this.writePosition + (long) this.writeCount) {
                    end = (long) this.writeCount + this.writePosition;
                } else if (this.writePosition < startPos + (long) startLen && (long) this.writeCount + this.writePosition >= startPos - -((long) startLen)) {
                    end = (long) startLen + startPos;
                }

                if (start > -1L && end > start) {
                    @Pc(462) int copyLen = (int) (end - start);
                    Arrays.copy(this.writeBuffer, (int) (start - this.writePosition), data, (int) (start - startPos) + off, copyLen);

                    if (end > this.virtualPosition) {
                        len = (int) ((long) len + this.virtualPosition - end);
                        this.virtualPosition = end;
                    }
                }
            }
        } catch (@Pc(500) IOException exception) {
            this.physicalPosition = -1L;
            throw exception;
        }

        if (len > 0) {
            throw new EOFException();
        }
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(III[B)V")
    public void write(@OriginalArg(1) int off, @OriginalArg(2) int len, @OriginalArg(3) byte[] data) throws IOException {
        try {
            if (this.length < (long) len + this.virtualPosition) {
                this.length = (long) len + this.virtualPosition;
            }

            if (this.writePosition != -1L && (this.writePosition > this.virtualPosition || (long) this.writeCount + this.writePosition < this.virtualPosition)) {
                this.flush();
            }

            if (this.writePosition != -1L && this.writePosition + (long) this.writeBuffer.length < this.virtualPosition + (long) len) {
                @Pc(95) int size = (int) (this.writePosition + (long) this.writeBuffer.length - this.virtualPosition);

                Arrays.copy(data, off, this.writeBuffer, (int) (this.virtualPosition - this.writePosition), size);

                off += size;
                len -= size;

                this.virtualPosition += size;
                this.writeCount = this.writeBuffer.length;
                this.flush();
            }

            if (len > this.writeBuffer.length) {
                if (this.physicalPosition != this.virtualPosition) {
                    this.file.seek(this.virtualPosition);
                    this.physicalPosition = this.virtualPosition;
                }

                this.file.write(data, off, len);

                this.physicalPosition += len;
                if (this.physicalPosition > this.physicalLength) {
                    this.physicalLength = this.physicalPosition;
                }

                @Pc(188) long start = -1L;
                if (this.readPosition <= this.virtualPosition && this.virtualPosition < (long) this.readCount + this.readPosition) {
                    start = this.virtualPosition;
                } else if (this.virtualPosition <= this.readPosition && (long) len + this.virtualPosition > this.readPosition) {
                    start = this.readPosition;
                }

                @Pc(239) long end = -1L;
                if (this.readPosition < (long) len + this.virtualPosition && this.readPosition + (long) this.readCount >= this.virtualPosition - -((long) len)) {
                    end = (long) len + this.virtualPosition;
                } else if (this.virtualPosition < (long) this.readCount + this.readPosition && this.virtualPosition + (long) len >= (long) this.readCount + this.readPosition) {
                    end = this.readPosition + (long) this.readCount;
                }

                if (start > -1L && start < end) {
                    @Pc(324) int copyLen = (int) (end - start);
                    Arrays.copy(data, (int) (start + (long) off - this.virtualPosition), this.readBuffer, (int) (start - this.readPosition), copyLen);
                }

                this.virtualPosition += len;
            } else if (len > 0) {
                if (this.writePosition == -1L) {
                    this.writePosition = this.virtualPosition;
                }

                Arrays.copy(data, off, this.writeBuffer, (int) (this.virtualPosition - this.writePosition), len);
                this.virtualPosition += len;

                if ((long) this.writeCount < this.virtualPosition - this.writePosition) {
                    this.writeCount = (int) (this.virtualPosition - this.writePosition);
                }
            }
        } catch (@Pc(414) IOException exception) {
            this.physicalPosition = -1L;
            throw exception;
        }
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(B)V")
    public void fill() throws IOException {
        this.readCount = 0;

        if (this.virtualPosition != this.physicalPosition) {
            this.file.seek(this.virtualPosition);
            this.physicalPosition = this.virtualPosition;
        }

        this.readPosition = this.virtualPosition;

        while (this.readCount < this.readBuffer.length) {
            @Pc(44) int len = this.readBuffer.length - this.readCount;
            if (len > 200000000) {
                len = 200000000;
            }

            @Pc(61) int read = this.file.read(len, this.readBuffer, this.readCount);
            if (read == -1) {
                break;
            }

            this.readCount += read;
            this.physicalPosition += read;
        }
    }

    @OriginalMember(owner = "client!mj", name = "c", descriptor = "(I)J")
    public long length() {
        return this.length;
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "([BB)V")
    public void read(@OriginalArg(0) byte[] data) throws IOException {
        this.read(data.length, data, 0);
    }

    @OriginalMember(owner = "client!mj", name = "d", descriptor = "(I)V")
    public void close() throws IOException {
        this.flush();
        this.file.close();
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(Z)V")
    public void flush() throws IOException {
        if (this.writePosition == -1L) {
            return;
        }

        if (this.writePosition != this.physicalPosition) {
            this.file.seek(this.writePosition);
            this.physicalPosition = this.writePosition;
        }

        this.file.write(this.writeBuffer, 0, this.writeCount);

        this.physicalPosition += this.writeCount;
        if (this.physicalPosition > this.physicalLength) {
            this.physicalLength = this.physicalPosition;
        }

        @Pc(71) long start = -1L;
        if (this.readPosition <= this.writePosition && this.writePosition < this.readPosition + (long) this.readCount) {
            start = this.writePosition;
        } else if (this.readPosition >= this.writePosition && (long) this.writeCount + this.writePosition > this.readPosition) {
            start = this.readPosition;
        }

        @Pc(73) long end = -1L;
        if (this.readPosition < this.writePosition + (long) this.writeCount && (long) this.readCount + this.readPosition >= this.writePosition - -((long) this.writeCount)) {
            end = this.writePosition + (long) this.writeCount;
        } else if (this.writePosition < this.readPosition + (long) this.readCount && (long) this.writeCount + this.writePosition >= this.readPosition - -((long) this.readCount)) {
            end = (long) this.readCount + this.readPosition;
        }

        if (start > -1L && end > start) {
            @Pc(228) int copyLen = (int) (end - start);
            Arrays.copy(this.writeBuffer, (int) (start - this.writePosition), this.readBuffer, (int) (start - this.readPosition), copyLen);
        }

        this.writeCount = 0;
        this.writePosition = -1L;
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(JZ)V")
    public void seek(@OriginalArg(0) long position) throws IOException {
        if (position < 0L) {
            throw new IOException("Invalid seek to " + position + " in file " + this.source());
        }

        this.virtualPosition = position;
    }
}
