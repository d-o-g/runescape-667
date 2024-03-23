package com.jagex.game.compression.huffman;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jm")
public final class Huffman {

    @OriginalMember(owner = "client!jm", name = "o", descriptor = "[I")
    public final int[] anIntArray374;

    @OriginalMember(owner = "client!jm", name = "l", descriptor = "[B")
    public final byte[] codewords;

    @OriginalMember(owner = "client!jm", name = "j", descriptor = "[I")
    public int[] anIntArray373;

    @OriginalMember(owner = "client!jm", name = "<init>", descriptor = "([B)V")
    public Huffman(@OriginalArg(0) byte[] codewords) {
        @Pc(6) int length = codewords.length;
        this.anIntArray374 = new int[length];
        this.codewords = codewords;
        this.anIntArray373 = new int[8];

        @Pc(20) int[] local20 = new int[33];
        @Pc(22) int local22 = 0;
        for (@Pc(24) int local24 = 0; local24 < length; local24++) {
            @Pc(30) byte local30 = codewords[local24];
            if (local30 != 0) {
                @Pc(42) int local42 = 0x1 << 32 - local30;
                @Pc(46) int local46 = local20[local30];
                this.anIntArray374[local24] = local46;
                @Pc(62) int local62;
                @Pc(66) int local66;
                @Pc(72) int local72;
                @Pc(86) int local86;
                if ((local42 & local46) == 0) {
                    local62 = local42 | local46;
                    for (local66 = local30 - 1; local66 >= 1; local66--) {
                        local72 = local20[local66];
                        if (local46 != local72) {
                            break;
                        }
                        local86 = 0x1 << 32 - local66;
                        if ((local72 & local86) != 0) {
                            local20[local66] = local20[local66 - 1];
                            break;
                        }
                        local20[local66] = local72 | local86;
                    }
                } else {
                    local62 = local20[local30 - 1];
                }
                local20[local30] = local62;
                for (local66 = local30 + 1; local66 <= 32; local66++) {
                    if (local20[local66] == local46) {
                        local20[local66] = local62;
                    }
                }
                local72 = 0;
                for (local86 = 0; local86 < local30; local86++) {
                    @Pc(178) int local178 = Integer.MIN_VALUE >>> local86;
                    if ((local178 & local46) == 0) {
                        local72++;
                    } else {
                        if (this.anIntArray373[local72] == 0) {
                            this.anIntArray373[local72] = local22;
                        }
                        local72 = this.anIntArray373[local72];
                    }
                    if (this.anIntArray373.length <= local72) {
                        @Pc(226) int[] local226 = new int[this.anIntArray373.length * 2];
                        for (@Pc(228) int local228 = 0; local228 < this.anIntArray373.length; local228++) {
                            local226[local228] = this.anIntArray373[local228];
                        }
                        this.anIntArray373 = local226;
                    }
                }
                this.anIntArray373[local72] = ~local24;
                if (local22 <= local72) {
                    local22 = local72 + 1;
                }
            }
        }
    }

    @OriginalMember(owner = "client!jm", name = "a", descriptor = "([BI[BIII)I")
    public int decompress(@OriginalArg(0) byte[] dest, @OriginalArg(2) byte[] src, @OriginalArg(3) int length, @OriginalArg(4) int pos, @OriginalArg(5) int off) {
        if (length == 0) {
            return 0;
        }

        @Pc(17) int local17 = length;
        @Pc(19) int local19 = 0;
        @Pc(21) int currPos = pos;
        while (true) {
            @Pc(25) byte c = src[currPos];
            if (c >= 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(45) int local45;
            if ((local45 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local45;
                if (off >= local17) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x40) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(87) int local87;
            if ((local87 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local87;
                if (off >= local17) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x20) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(130) int local130;
            if ((local130 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local130;
                if (local17 <= off) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x10) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(172) int local172;
            if ((local172 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local172;
                if (local17 <= off) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x8) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(208) int local208;
            if ((local208 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local208;
                if (off >= local17) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x4) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(247) int local247;
            if ((local247 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local247;
                if (off >= local17) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x2) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(289) int local289;
            if ((local289 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local289;
                if (off >= local17) {
                    break;
                }
                local19 = 0;
            }
            if ((c & 0x1) == 0) {
                local19++;
            } else {
                local19 = this.anIntArray373[local19];
            }
            @Pc(325) int local325;
            if ((local325 = this.anIntArray373[local19]) < 0) {
                dest[off++] = (byte) ~local325;
                if (local17 <= off) {
                    break;
                }
                local19 = 0;
            }
            currPos++;
        }
        return currPos + 1 - pos;
    }

    @OriginalMember(owner = "client!jm", name = "a", descriptor = "(IIII[B[B)I")
    public int compress(@OriginalArg(0) int pos, @OriginalArg(1) int off, @OriginalArg(2) int length, @OriginalArg(4) byte[] dest, @OriginalArg(5) byte[] src) {
        @Pc(19) int local19 = 0;
        @Pc(23) int local23 = length;
        @Pc(27) int local27 = pos << 3;
        while (local23 > off) {
            @Pc(34) int value = src[off] & 0xFF;
            @Pc(39) int local39 = this.anIntArray374[value];

            @Pc(44) byte code = this.codewords[value];
            if (code == 0) {
                throw new RuntimeException("No codeword for data value " + value);
            }

            @Pc(64) int local64 = local27 >> 3;
            @Pc(68) int local68 = local27 & 0x7;
            local19 &= -local68 >> 31;
            @Pc(85) int local85 = local64 + (local68 + code - 1 >> 3);
            local27 += code;
            @Pc(90) int local90 = local68 + 24;
            dest[local64] = (byte) (local19 |= local39 >>> local90);
            if (local64 < local85) {
                local68 = local90 - 8;
                local64++;
                dest[local64] = (byte) (local19 = local39 >>> local68);
                if (local64 < local85) {
                    local64++;
                    local68 -= 8;
                    dest[local64] = (byte) (local19 = local39 >>> local68);
                    if (local85 > local64) {
                        local68 -= 8;
                        local64++;
                        dest[local64] = (byte) (local19 = local39 >>> local68);
                        if (local85 > local64) {
                            local64++;
                            local68 -= 8;
                            dest[local64] = (byte) (local19 = local39 << -local68);
                        }
                    }
                }
            }
            off++;
        }
        return (local27 + 7 >> 3) - pos;
    }
}
