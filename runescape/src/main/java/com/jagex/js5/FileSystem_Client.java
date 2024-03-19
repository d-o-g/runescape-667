package com.jagex.js5;

import com.jagex.core.io.BufferedFile;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.EOFException;
import java.io.IOException;

@OriginalClass("client!af")
public final class FileSystem_Client {

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "[B")
    public static final byte[] buffer = new byte[520];

    @OriginalMember(owner = "client!af", name = "c", descriptor = "Lclient!mj;")
    public BufferedFile datFile = null;

    @OriginalMember(owner = "client!af", name = "i", descriptor = "Lclient!mj;")
    public BufferedFile indexFile = null;

    @OriginalMember(owner = "client!af", name = "h", descriptor = "I")
    public int maxlen = 65000;

    @OriginalMember(owner = "client!af", name = "l", descriptor = "I")
    public final int fsid;

    @OriginalMember(owner = "client!af", name = "<init>", descriptor = "(ILclient!mj;Lclient!mj;I)V")
    public FileSystem_Client(@OriginalArg(0) int fsid, @OriginalArg(1) BufferedFile datFile, @OriginalArg(2) BufferedFile indexFile, @OriginalArg(3) int maxlen) {
        this.indexFile = indexFile;
        this.fsid = fsid;
        this.maxlen = maxlen;
        this.datFile = datFile;
    }

    @OriginalMember(owner = "client!af", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        return "Cache:" + this.fsid;
    }

    @OriginalMember(owner = "client!af", name = "a", descriptor = "(I[BIZ)Z")
    public boolean save(@OriginalArg(0) int arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2) {
        @Pc(6) BufferedFile local6 = this.datFile;
        synchronized (this.datFile) {
            if (arg0 < 0 || arg0 > this.maxlen) {
                throw new IllegalArgumentException();
            }
            @Pc(30) boolean local30 = this.method128(arg1, arg2, arg0, true);
            if (!local30) {
                local30 = this.method128(arg1, arg2, arg0, false);
            }
            return local30;
        }
    }

    @OriginalMember(owner = "client!af", name = "a", descriptor = "(II)[B")
    public byte[] read(@OriginalArg(0) int file) {
        @Pc(6) BufferedFile local6 = this.datFile;
        synchronized (this.datFile) {
            try {
                if (this.indexFile.length() < (long) (file * 6 + 6)) {
                    return null;
                }

                this.indexFile.seek(file * 6);
                this.indexFile.read(6, buffer, 0);
                @Pc(67) int size = ((buffer[0] & 0xFF) << 16) + ((buffer[1] & 0xFF) << 8) + (buffer[2] & 0xFF);
                @Pc(89) int block = ((buffer[3] & 0xFF) << 16) + ((buffer[4] & 0xFF) << 8) + (buffer[5] & 0xFF);

                if (size < 0 || size > this.maxlen) {
                    return null;
                }

                if (block <= 0 || this.datFile.length() / 520L < (long) block) {
                    return null;
                }

                @Pc(129) byte[] data = new byte[size];
                @Pc(131) int read = 0;
                @Pc(140) int part = 0;
                while (read < size) {
                    if (block == 0) {
                        return null;
                    }

                    this.datFile.seek((long) (block * 520));

                    @Pc(161) int remaining = size - read;
                    if (remaining > 512) {
                        remaining = 512;
                    }

                    this.datFile.read(remaining + 8, buffer, 0);

                    @Pc(191) int f = ((buffer[0] & 0xFF) << 8) + (buffer[1] & 0xFF);
                    @Pc(205) int p = ((buffer[2] & 0xFF) << 8) + (buffer[3] & 0xFF);
                    @Pc(227) int nextBlock = (buffer[4] << 16 & 0xFF0000) + ((buffer[5] & 0xFF) << 8) + (buffer[6] & 0xFF);
                    @Pc(233) int t = buffer[7] & 0xFF;

                    if (file != f || part != p || t != this.fsid) {
                        return null;
                    }

                    if (nextBlock < 0 || (long) nextBlock > this.datFile.length() / 520L) {
                        return null;
                    }

                    part++;

                    for (@Pc(291) int i = 0; i < remaining; i++) {
                        data[read++] = buffer[i + 8];
                    }

                    block = nextBlock;
                }

                return data;
            } catch (@Pc(321) IOException ignored) {
                return null;
            }
        }
    }

    @OriginalMember(owner = "client!af", name = "a", descriptor = "([BIIIZ)Z")
    public boolean method128(@OriginalArg(0) byte[] arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) boolean arg3) {
        @Pc(8) BufferedFile local8 = this.datFile;
        synchronized (this.datFile) {
            try {
                @Pc(84) int local84;
                if (arg3) {
                    if (this.indexFile.length() < (long) (arg1 * 6 + 6)) {
                        return false;
                    }
                    this.indexFile.seek((long) (arg1 * 6));
                    this.indexFile.read(6, buffer, 0);
                    local84 = (buffer[5] & 0xFF) + (((buffer[3] & 0xFF) << 16) + ((buffer[4] & 0xFF) << 8));
                    if (local84 <= 0 || this.datFile.length() / 520L < (long) local84) {
                        return false;
                    }
                } else {
                    local84 = (int) ((this.datFile.length() + 519L) / 520L);
                    if (local84 == 0) {
                        local84 = 1;
                    }
                }
                buffer[3] = (byte) (local84 >> 16);
                buffer[2] = (byte) arg2;
                buffer[0] = (byte) (arg2 >> 16);
                buffer[1] = (byte) (arg2 >> 8);
                buffer[5] = (byte) local84;
                buffer[4] = (byte) (local84 >> 8);
                this.indexFile.seek((long) (arg1 * 6));
                this.indexFile.write(0, 6, buffer);
                @Pc(173) int local173 = 0;
                @Pc(175) int local175 = 0;
                while (true) {
                    if (local173 < arg2) {
                        label102:
                        {
                            @Pc(181) int local181 = 0;
                            @Pc(217) int local217;
                            if (arg3) {
                                this.datFile.seek((long) (local84 * 520));
                                try {
                                    this.datFile.read(8, buffer, 0);
                                } catch (@Pc(201) EOFException local201) {
                                    break label102;
                                }
                                local217 = (buffer[1] & 0xFF) + ((buffer[0] & 0xFF) << 8);
                                @Pc(231) int local231 = (buffer[3] & 0xFF) + ((buffer[2] & 0xFF) << 8);
                                local181 = (buffer[6] & 0xFF) + (((buffer[4] & 0xFF) << 16) + ((buffer[5] & 0xFF) << 8));
                                @Pc(260) int local260 = buffer[7] & 0xFF;
                                if (arg1 != local217 || local175 != local231 || local260 != this.fsid) {
                                    return false;
                                }
                                if (local181 < 0 || this.datFile.length() / 520L < (long) local181) {
                                    return false;
                                }
                            }
                            if (local181 == 0) {
                                arg3 = false;
                                local181 = (int) ((this.datFile.length() + 519L) / 520L);
                                if (local181 == 0) {
                                    local181++;
                                }
                                if (local181 == local84) {
                                    local181++;
                                }
                            }
                            if (arg2 - local173 <= 512) {
                                local181 = 0;
                            }
                            buffer[3] = (byte) local175;
                            buffer[2] = (byte) (local175 >> 8);
                            buffer[1] = (byte) arg1;
                            buffer[0] = (byte) (arg1 >> 8);
                            buffer[4] = (byte) (local181 >> 16);
                            buffer[5] = (byte) (local181 >> 8);
                            buffer[6] = (byte) local181;
                            buffer[7] = (byte) this.fsid;
                            this.datFile.seek((long) (local84 * 520));
                            this.datFile.write(0, 8, buffer);
                            local217 = arg2 - local173;
                            if (local217 > 512) {
                                local217 = 512;
                            }
                            this.datFile.write(local173, local217, arg0);
                            local84 = local181;
                            local173 += local217;
                            local175++;
                            continue;
                        }
                    }
                    @Pc(463) boolean local463 = true;
                    return true;
                }
            } catch (@Pc(468) IOException local468) {
                return false;
            }
        }
    }
}
