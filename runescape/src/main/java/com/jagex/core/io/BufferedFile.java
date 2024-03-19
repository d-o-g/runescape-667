package com.jagex.core.io;

import com.jagex.core.io.FileOnDisk;
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
    public long aLong197;

    @OriginalMember(owner = "client!mj", name = "x", descriptor = "I")
    public int anInt6212;

    @OriginalMember(owner = "client!mj", name = "w", descriptor = "I")
    public int writeCount = 0;

    @OriginalMember(owner = "client!mj", name = "b", descriptor = "J")
    public long aLong199 = -1L;

    @OriginalMember(owner = "client!mj", name = "l", descriptor = "J")
    public long writePosition = -1L;

    @OriginalMember(owner = "client!mj", name = "g", descriptor = "Lclient!dm;")
    public final FileOnDisk file;

    @OriginalMember(owner = "client!mj", name = "t", descriptor = "J")
    public long aLong196;

    @OriginalMember(owner = "client!mj", name = "k", descriptor = "J")
    public long length;

    @OriginalMember(owner = "client!mj", name = "c", descriptor = "J")
    public long virtualPosition;

    @OriginalMember(owner = "client!mj", name = "v", descriptor = "[B")
    public final byte[] aByteArray66;

    @OriginalMember(owner = "client!mj", name = "h", descriptor = "[B")
    public final byte[] aByteArray67;

    @OriginalMember(owner = "client!mj", name = "<init>", descriptor = "(Lclient!dm;II)V")
    public BufferedFile(@OriginalArg(0) FileOnDisk file, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) throws IOException {
        this.file = file;
        this.length = this.aLong196 = file.length();
        this.virtualPosition = 0L;
        this.aByteArray66 = new byte[arg1];
        this.aByteArray67 = new byte[arg2];
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
                Arrays.copy(this.aByteArray67, (int) (this.virtualPosition - this.writePosition), data, off, len);
                this.virtualPosition += (long) len;
                return;
            }

            @Pc(92) long startPos = this.virtualPosition;
            @Pc(96) int startLen = len;
            if (this.virtualPosition >= this.aLong199 && this.virtualPosition < this.aLong199 + (long) this.anInt6212) {
                @Pc(132) int local132 = (int) ((long) this.anInt6212 + this.aLong199 - this.virtualPosition);
                if (len < local132) {
                    local132 = len;
                }

                Arrays.copy(this.aByteArray66, (int) (this.virtualPosition - this.aLong199), data, off, local132);
                this.virtualPosition += (long) local132;
                off = local132;
                len -= local132;
            }

            if (this.aByteArray66.length < len) {
                this.file.seek(this.virtualPosition);
                this.aLong197 = this.virtualPosition;

                while (len > 0) {
                    @Pc(132) int local132 = this.file.read(len, data, off);
                    if (local132 == -1) {
                        break;
                    }

                    this.virtualPosition += (long) local132;
                    len -= local132;
                    off += local132;
                    this.aLong197 += (long) local132;
                }
            } else if (len > 0) {
                this.fill();
                @Pc(132) int local132 = len;
                if (this.anInt6212 < len) {
                    local132 = this.anInt6212;
                }
                Arrays.copy(this.aByteArray66, 0, data, off, local132);
                off += local132;
                this.virtualPosition += (long) local132;
                len -= local132;
            }

            if (this.writePosition != -1L) {
                if (this.writePosition > this.virtualPosition && len > 0) {
                    @Pc(132) int local132 = (int) (this.writePosition - this.virtualPosition) + off;
                    if (local132 > off + len) {
                        local132 = off + len;
                    }

                    while (off < local132) {
                        len--;
                        data[off++] = 0;
                        this.virtualPosition++;
                    }
                }

                @Pc(323) long local323 = -1L;
                if (startPos <= this.writePosition && this.writePosition < startPos + (long) startLen) {
                    local323 = this.writePosition;
                } else if (this.writePosition <= startPos && this.writePosition + (long) this.writeCount > startPos) {
                    local323 = startPos;
                }

                @Pc(373) long local373 = -1L;
                if (startPos < this.writePosition + (long) this.writeCount && (long) startLen + startPos >= this.writePosition + (long) this.writeCount) {
                    local373 = (long) this.writeCount + this.writePosition;
                } else if (this.writePosition < startPos + (long) startLen && (long) this.writeCount + this.writePosition >= startPos - -((long) startLen)) {
                    local373 = (long) startLen + startPos;
                }

                if (local323 > -1L && local373 > local323) {
                    @Pc(462) int local462 = (int) (local373 - local323);
                    Arrays.copy(this.aByteArray67, (int) (local323 - this.writePosition), data, (int) (local323 - startPos) + off, local462);
                    if (local373 > this.virtualPosition) {
                        len = (int) ((long) len + this.virtualPosition - local373);
                        this.virtualPosition = local373;
                    }
                }
            }
        } catch (@Pc(500) IOException exception) {
            this.aLong197 = -1L;
            throw exception;
        }

        if (len > 0) {
            throw new EOFException();
        }
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(III[B)V")
    public void write(@OriginalArg(1) int off, @OriginalArg(2) int len, @OriginalArg(3) byte[] arg2) throws IOException {
        try {
            if (this.length < (long) len + this.virtualPosition) {
                this.length = (long) len + this.virtualPosition;
            }

            if (this.writePosition != -1L && (this.writePosition > this.virtualPosition || (long) this.writeCount + this.writePosition < this.virtualPosition)) {
                this.flush();
            }

            if (this.writePosition != -1L && this.writePosition + (long) this.aByteArray67.length < this.virtualPosition + (long) len) {
                @Pc(95) int local95 = (int) (this.writePosition + (long) this.aByteArray67.length - this.virtualPosition);
                Arrays.copy(arg2, off, this.aByteArray67, (int) (this.virtualPosition - this.writePosition), local95);
                off += local95;
                len -= local95;
                this.virtualPosition += (long) local95;
                this.writeCount = this.aByteArray67.length;
                this.flush();
            }

            if (len > this.aByteArray67.length) {
                if (this.aLong197 != this.virtualPosition) {
                    this.file.seek(this.virtualPosition);
                    this.aLong197 = this.virtualPosition;
                }

                this.file.write(arg2, off, len);

                this.aLong197 += (long) len;
                if (this.aLong197 > this.aLong196) {
                    this.aLong196 = this.aLong197;
                }

                @Pc(188) long local188 = -1L;
                if (this.aLong199 <= this.virtualPosition && this.virtualPosition < (long) this.anInt6212 + this.aLong199) {
                    local188 = this.virtualPosition;
                } else if (this.virtualPosition <= this.aLong199 && (long) len + this.virtualPosition > this.aLong199) {
                    local188 = this.aLong199;
                }

                @Pc(239) long local239 = -1L;
                if (this.aLong199 < (long) len + this.virtualPosition && this.aLong199 + (long) this.anInt6212 >= this.virtualPosition - -((long) len)) {
                    local239 = (long) len + this.virtualPosition;
                } else if (this.virtualPosition < (long) this.anInt6212 + this.aLong199 && this.virtualPosition + (long) len >= (long) this.anInt6212 + this.aLong199) {
                    local239 = this.aLong199 + (long) this.anInt6212;
                }

                if (local188 > -1L && local188 < local239) {
                    @Pc(324) int local324 = (int) (local239 - local188);
                    Arrays.copy(arg2, (int) (local188 + (long) off - this.virtualPosition), this.aByteArray66, (int) (local188 - this.aLong199), local324);
                }

                this.virtualPosition += (long) len;
            } else if (len > 0) {
                if (this.writePosition == -1L) {
                    this.writePosition = this.virtualPosition;
                }

                Arrays.copy(arg2, off, this.aByteArray67, (int) (this.virtualPosition - this.writePosition), len);
                this.virtualPosition += (long) len;

                if ((long) this.writeCount < this.virtualPosition - this.writePosition) {
                    this.writeCount = (int) (this.virtualPosition - this.writePosition);
                }
            }
        } catch (@Pc(414) IOException local414) {
            this.aLong197 = -1L;
            throw local414;
        }
    }

    @OriginalMember(owner = "client!mj", name = "a", descriptor = "(B)V")
    public void fill() throws IOException {
        this.anInt6212 = 0;

        if (this.virtualPosition != this.aLong197) {
            this.file.seek(this.virtualPosition);
            this.aLong197 = this.virtualPosition;
        }

        this.aLong199 = this.virtualPosition;

        while (this.anInt6212 < this.aByteArray66.length) {
            @Pc(44) int local44 = this.aByteArray66.length - this.anInt6212;
            if (local44 > 200000000) {
                local44 = 200000000;
            }

            @Pc(61) int local61 = this.file.read(local44, this.aByteArray66, this.anInt6212);
            if (local61 == -1) {
                break;
            }

            this.anInt6212 += local61;
            this.aLong197 += (long) local61;
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

        if (this.writePosition != this.aLong197) {
            this.file.seek(this.writePosition);
            this.aLong197 = this.writePosition;
        }

        this.file.write(this.aByteArray67, 0, this.writeCount);

        this.aLong197 += (long) this.writeCount;
        if (this.aLong197 > this.aLong196) {
            this.aLong196 = this.aLong197;
        }

        @Pc(71) long local71 = -1L;
        @Pc(73) long local73 = -1L;
        if (this.aLong199 <= this.writePosition && this.writePosition < this.aLong199 + (long) this.anInt6212) {
            local71 = this.writePosition;
        } else if (this.aLong199 >= this.writePosition && (long) this.writeCount + this.writePosition > this.aLong199) {
            local71 = this.aLong199;
        }

        if (this.aLong199 < this.writePosition + (long) this.writeCount && (long) this.anInt6212 + this.aLong199 >= this.writePosition - -((long) this.writeCount)) {
            local73 = this.writePosition + (long) this.writeCount;
        } else if (this.writePosition < this.aLong199 + (long) this.anInt6212 && (long) this.writeCount + this.writePosition >= this.aLong199 - -((long) this.anInt6212)) {
            local73 = (long) this.anInt6212 + this.aLong199;
        }

        if (local71 > -1L && local73 > local71) {
            @Pc(228) int local228 = (int) (local73 - local71);
            Arrays.copy(this.aByteArray67, (int) (local71 - this.writePosition), this.aByteArray66, (int) (local71 - this.aLong199), local228);
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
