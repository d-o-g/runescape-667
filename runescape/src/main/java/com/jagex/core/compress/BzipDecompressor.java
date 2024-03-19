package com.jagex.core.compress;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ni")
public final class BzipDecompressor {

    @OriginalMember(owner = "client!f", name = "a", descriptor = "Lclient!ni;")
    public static final BzipDecompressor INSTANCE = new BzipDecompressor();

    @OriginalMember(owner = "client!de", name = "b", descriptor = "[I")
    public static int[] tt;

    @OriginalMember(owner = "client!f", name = "a", descriptor = "([BI[BII)I")
    public static int bunzip(@OriginalArg(0) byte[] output, @OriginalArg(1) int outputLength, @OriginalArg(2) byte[] input, @OriginalArg(3) int inLength) {
        @Pc(1) BzipDecompressor local1 = INSTANCE;
        synchronized (INSTANCE) {
            INSTANCE.input = input;
            INSTANCE.anInt6470 = 9;
            INSTANCE.output = output;
            INSTANCE.anInt6466 = 0;
            INSTANCE.availableOut = outputLength;
            INSTANCE.anInt6482 = 0;
            INSTANCE.anInt6468 = 0;
            INSTANCE.anInt6472 = 0;
            INSTANCE.anInt6474 = 0;
            decompress(INSTANCE);
            @Pc(37) int size = outputLength - INSTANCE.availableOut;
            INSTANCE.input = null;
            INSTANCE.output = null;
            return size;
        }
    }

    @OriginalMember(owner = "client!f", name = "e", descriptor = "(Lclient!ni;)V")
    public static void decompress(@OriginalArg(0) BzipDecompressor decompressor) {
        decompressor.blockSize100k = 1;
        if (tt == null) {
            tt = new int[decompressor.blockSize100k * 100000];
        }

        @Pc(56) boolean gotoBzXBlkhdr1 = true;
        while (true) {
            while (gotoBzXBlkhdr1) {
                @Pc(60) byte uc = getUchar(decompressor);
                if (uc == 23) {
                    return;
                }

                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getUchar(decompressor);
                uc = getBit(decompressor);

                decompressor.origPtr = 0;
                uc = getUchar(decompressor);
                decompressor.origPtr = decompressor.origPtr << 8 | uc & 0xFF;
                uc = getUchar(decompressor);
                decompressor.origPtr = decompressor.origPtr << 8 | uc & 0xFF;
                uc = getUchar(decompressor);
                decompressor.origPtr = decompressor.origPtr << 8 | uc & 0xFF;

                for (@Pc(138) int i = 0; i < 16; i++) {
                    uc = getBit(decompressor);
                    if (uc == 1) {
                        decompressor.inUse16[i] = true;
                    } else {
                        decompressor.inUse16[i] = false;
                    }
                }

                for (@Pc(138) int i = 0; i < 256; i++) {
                    decompressor.inUse[i] = false;
                }

                for (@Pc(138) int i = 0; i < 16; i++) {
                    if (decompressor.inUse16[i]) {
                        for (@Pc(182) int j = 0; j < 16; j++) {
                            uc = getBit(decompressor);

                            if (uc == 1) {
                                decompressor.inUse[(i * 16) + j] = true;
                            }
                        }
                    }
                }

                makeMapsD(decompressor);

                @Pc(213) int alphaSize = decompressor.nInUse + 2;
                @Pc(217) int nGroups = getBits(3, decompressor);
                @Pc(221) int nSelectors = getBits(15, decompressor);

                for (@Pc(138) int i = 0; i < nSelectors; i++) {
                    @Pc(182) int j = 0;

                    while (true) {
                        uc = getBit(decompressor);

                        if (uc == 0) {
                            decompressor.selectorMtf[i] = (byte) j;
                            break;
                        }

                        j++;
                    }
                }

                @Pc(246) byte[] pos = new byte[6];
                for (@Pc(248) byte i = 0; i < nGroups; i++) {
                    pos[i] = i;
                }

                for (@Pc(138) int i = 0; i < nSelectors; i++) {
                    @Pc(248) byte v = decompressor.selectorMtf[i];
                    @Pc(273) byte tmp = pos[v];
                    while (v > 0) {
                        pos[v] = pos[v - 1];
                        v--;
                    }
                    pos[0] = tmp;
                    decompressor.selector[i] = tmp;
                }

                for (@Pc(304) int i = 0; i < nGroups; i++) {
                    @Pc(309) int curr = getBits(5, decompressor);

                    for (@Pc(138) int j = 0; j < alphaSize; j++) {
                        while (true) {
                            uc = getBit(decompressor);
                            if (uc == 0) {
                                decompressor.len[i][j] = (byte) curr;
                                break;
                            }

                            uc = getBit(decompressor);

                            if (uc == 0) {
                                curr++;
                            } else {
                                curr--;
                            }
                        }
                    }
                }

                for (@Pc(304) int t = 0; t < nGroups; t++) {
                    @Pc(347) byte minLen = 32;
                    @Pc(349) byte maxLen = 0;
                    for (@Pc(138) int i = 0; i < alphaSize; i++) {
                        if (decompressor.len[t][i] > maxLen) {
                            maxLen = decompressor.len[t][i];
                        }

                        if (decompressor.len[t][i] < minLen) {
                            minLen = decompressor.len[t][i];
                        }
                    }

                    hbCreateDecodeTables(decompressor.limit[t], decompressor.base[t], decompressor.perm[t], decompressor.len[t], minLen, maxLen, alphaSize);
                    decompressor.anIntArray514[t] = minLen;
                }

                @Pc(420) int eob = decompressor.nInUse + 1;
                @Pc(422) byte groupNo = -1;
                for (@Pc(138) int i = 0; i <= 255; i++) {
                    decompressor.unzftab[i] = 0;
                }

                @Pc(438) int kk = 4095;
                for (@Pc(440) int i = 15; i >= 0; i--) {
                    for (@Pc(443) int j = 15; j >= 0; j--) {
                        decompressor.mtfa[kk] = (byte) ((i * 16) + j);
                        kk--;
                    }

                    decompressor.mtfbase[i] = kk + 1;
                }

                @Pc(470) int local470 = 0;
                @Pc(473) int local473 = groupNo + 1;
                @Pc(475) byte local475 = 50;
                @Pc(480) byte local480 = decompressor.selector[0];
                @Pc(485) int local485 = decompressor.anIntArray514[local480];
                @Pc(490) int[] gLimit = decompressor.limit[local480];
                @Pc(495) int[] gPerm = decompressor.perm[local480];
                @Pc(500) int[] gBase = decompressor.base[local480];
                @Pc(501) int groupPos = local475 - 1;
                @Pc(503) int zn = local485;
                @Pc(507) int zj;
                @Pc(516) byte zvec;
                for (zj = getBits(local485, decompressor); zj > gLimit[zn]; zj = zj << 1 | zvec) {
                    zn++;
                    zvec = getBit(decompressor);
                }

                @Pc(531) int nextSym = gPerm[zj - gBase[zn]];
                while (true) {
                    while (nextSym != eob) {
                        if (nextSym == 0 || nextSym == 1) {
                            @Pc(541) int nn = -1;
                            @Pc(543) int pp = 1;

                            do {
                                if (nextSym == 0) {
                                    nn += pp;
                                } else if (nextSym == 1) {
                                    nn += pp * 2;
                                }

                                pp *= 2;

                                if (groupPos == 0) {
                                    local473++;
                                    groupPos = 50;
                                    local480 = decompressor.selector[local473];
                                    local485 = decompressor.anIntArray514[local480];
                                    gLimit = decompressor.limit[local480];
                                    gPerm = decompressor.perm[local480];
                                    gBase = decompressor.base[local480];
                                }

                                groupPos--;
                                zn = local485;
                                for (zj = getBits(local485, decompressor); zj > gLimit[zn]; zj = zj << 1 | zvec) {
                                    zn++;
                                    zvec = getBit(decompressor);
                                }

                                nextSym = gPerm[zj - gBase[zn]];
                            } while (nextSym == 0 || nextSym == 1);

                            nn++;
                            uc = decompressor.aByteArray76[decompressor.mtfa[decompressor.mtfbase[0]] & 0xFF];
                            decompressor.unzftab[uc & 0xFF] += nn;

                            while (nn > 0) {
                                tt[local470] = uc & 0xFF;
                                local470++;
                                nn--;
                            }
                        } else {
                            @Pc(669) int local669 = nextSym - 1;
                            @Pc(677) int local677;

                            if (local669 < 16) {
                                local677 = decompressor.mtfbase[0];
                                uc = decompressor.mtfa[local677 + local669];

                                while (local669 > 3) {
                                    @Pc(689) int local689 = local677 + local669;
                                    decompressor.mtfa[local689] = decompressor.mtfa[local689 - 1];
                                    decompressor.mtfa[local689 - 1] = decompressor.mtfa[local689 - 2];
                                    decompressor.mtfa[local689 - 2] = decompressor.mtfa[local689 - 3];
                                    decompressor.mtfa[local689 - 3] = decompressor.mtfa[local689 - 4];
                                    local669 -= 4;
                                }

                                while (local669 > 0) {
                                    decompressor.mtfa[local677 + local669] = decompressor.mtfa[local677 + local669 - 1];
                                    local669--;
                                }

                                decompressor.mtfa[local677] = uc;
                            } else {
                                @Pc(767) int local767 = local669 / 16;
                                @Pc(771) int local771 = local669 % 16;
                                local677 = decompressor.mtfbase[local767] + local771;
                                uc = decompressor.mtfa[local677];

                                while (local677 > decompressor.mtfbase[local767]) {
                                    decompressor.mtfa[local677] = decompressor.mtfa[local677 - 1];
                                    local677--;
                                }

                                @Pc(806) int local806 = decompressor.mtfbase[local767]++;
                                while (local767 > 0) {
                                    local806 = decompressor.mtfbase[local767]--;
                                    decompressor.mtfa[decompressor.mtfbase[local767]] = decompressor.mtfa[decompressor.mtfbase[local767 - 1] + 16 - 1];
                                    local767--;
                                }

                                local806 = decompressor.mtfbase[0]--;
                                decompressor.mtfa[decompressor.mtfbase[0]] = uc;
                                if (decompressor.mtfbase[0] == 0) {
                                    @Pc(864) int local864 = 4095;
                                    for (@Pc(866) int local866 = 15; local866 >= 0; local866--) {
                                        for (@Pc(869) int local869 = 15; local869 >= 0; local869--) {
                                            decompressor.mtfa[local864] = decompressor.mtfa[decompressor.mtfbase[local866] + local869];
                                            local864--;
                                        }
                                        decompressor.mtfbase[local866] = local864 + 1;
                                    }
                                }
                            }

                            decompressor.unzftab[decompressor.aByteArray76[uc & 0xFF] & 0xFF]++;
                            tt[local470] = decompressor.aByteArray76[uc & 0xFF] & 0xFF;
                            local470++;

                            if (groupPos == 0) {
                                local473++;
                                groupPos = 50;
                                local480 = decompressor.selector[local473];
                                local485 = decompressor.anIntArray514[local480];
                                gLimit = decompressor.limit[local480];
                                gPerm = decompressor.perm[local480];
                                gBase = decompressor.base[local480];
                            }

                            groupPos--;
                            zn = local485;

                            for (zj = getBits(local485, decompressor); zj > gLimit[zn]; zj = zj << 1 | zvec) {
                                zn++;
                                zvec = getBit(decompressor);
                            }

                            nextSym = gPerm[zj - gBase[zn]];
                        }
                    }

                    decompressor.anInt6469 = 0;
                    decompressor.aByte102 = 0;
                    decompressor.anIntArray516[0] = 0;

                    for (@Pc(138) int local138 = 1; local138 <= 256; local138++) {
                        decompressor.anIntArray516[local138] = decompressor.unzftab[local138 - 1];
                    }

                    for (@Pc(138) int local138 = 1; local138 <= 256; local138++) {
                        decompressor.anIntArray516[local138] += decompressor.anIntArray516[local138 - 1];
                    }

                    for (@Pc(138) int local138 = 0; local138 < local470; local138++) {
                        uc = (byte) (tt[local138] & 0xFF);
                        tt[decompressor.anIntArray516[uc & 0xFF]] |= local138 << 8;
                        decompressor.anIntArray516[uc & 0xFF]++;
                    }

                    decompressor.anInt6476 = tt[decompressor.origPtr] >> 8;
                    decompressor.anInt6477 = 0;
                    decompressor.anInt6476 = tt[decompressor.anInt6476];
                    decompressor.anInt6473 = (byte) (decompressor.anInt6476 & 0xFF);
                    decompressor.anInt6476 >>= 0x8;
                    decompressor.anInt6477++;
                    decompressor.anInt6471 = local470;
                    method2579(decompressor);
                    if (decompressor.anInt6477 == decompressor.anInt6471 + 1 && decompressor.anInt6469 == 0) {
                        gotoBzXBlkhdr1 = true;
                        break;
                    }
                    gotoBzXBlkhdr1 = false;
                    break;
                }
            }
            return;
        }
    }

    @OriginalMember(owner = "client!f", name = "a", descriptor = "([I[I[I[BIII)V")
    public static void hbCreateDecodeTables(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) byte[] arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
        @Pc(1) int local1 = 0;
        @Pc(3) int local3;
        for (local3 = arg4; local3 <= arg5; local3++) {
            for (@Pc(6) int local6 = 0; local6 < arg6; local6++) {
                if (arg3[local6] == local3) {
                    arg2[local1] = local6;
                    local1++;
                }
            }
        }
        for (local3 = 0; local3 < 23; local3++) {
            arg1[local3] = 0;
        }
        for (local3 = 0; local3 < arg6; local3++) {
            arg1[arg3[local3] + 1]++;
        }
        for (local3 = 1; local3 < 23; local3++) {
            arg1[local3] += arg1[local3 - 1];
        }
        for (local3 = 0; local3 < 23; local3++) {
            arg0[local3] = 0;
        }
        @Pc(85) int local85 = 0;
        for (local3 = arg4; local3 <= arg5; local3++) {
            local85 += arg1[local3 + 1] - arg1[local3];
            arg0[local3] = local85 - 1;
            local85 <<= 0x1;
        }
        for (local3 = arg4 + 1; local3 <= arg5; local3++) {
            arg1[local3] = (arg0[local3 - 1] + 1 << 1) - arg1[local3];
        }
    }

    @OriginalMember(owner = "client!f", name = "b", descriptor = "(Lclient!ni;)V")
    public static void method2579(@OriginalArg(0) BzipDecompressor arg0) {
        @Pc(2) byte local2 = arg0.aByte102;
        @Pc(5) int local5 = arg0.anInt6469;
        @Pc(8) int local8 = arg0.anInt6477;
        @Pc(11) int local11 = arg0.anInt6473;
        @Pc(13) int[] local13 = tt;
        @Pc(16) int local16 = arg0.anInt6476;
        @Pc(19) byte[] local19 = arg0.output;
        @Pc(22) int local22 = arg0.anInt6466;
        @Pc(25) int local25 = arg0.availableOut;
        @Pc(27) int local27 = local25;
        @Pc(32) int local32 = arg0.anInt6471 + 1;
        label57:
        while (true) {
            if (local5 > 0) {
                while (true) {
                    if (local25 == 0) {
                        break label57;
                    }
                    if (local5 == 1) {
                        if (local25 == 0) {
                            local5 = 1;
                            break label57;
                        }
                        local19[local22] = local2;
                        local22++;
                        local25--;
                        break;
                    }
                    local19[local22] = local2;
                    local5--;
                    local22++;
                    local25--;
                }
            }
            while (local8 != local32) {
                local2 = (byte) local11;
                local16 = local13[local16];
                @Pc(74) byte local74 = (byte) local16;
                local16 >>= 0x8;
                local8++;
                if (local74 == local11) {
                    if (local8 != local32) {
                        local5 = 2;
                        local16 = local13[local16];
                        local74 = (byte) local16;
                        local16 >>= 0x8;
                        local8++;
                        if (local8 != local32) {
                            if (local74 == local11) {
                                local5 = 3;
                                local16 = local13[local16];
                                local74 = (byte) local16;
                                local16 >>= 0x8;
                                local8++;
                                if (local8 != local32) {
                                    if (local74 == local11) {
                                        local16 = local13[local16];
                                        local74 = (byte) local16;
                                        local16 >>= 0x8;
                                        local8++;
                                        local5 = (local74 & 0xFF) + 4;
                                        local16 = local13[local16];
                                        local11 = (byte) local16;
                                        local16 >>= 0x8;
                                        local8++;
                                    } else {
                                        local11 = local74;
                                    }
                                }
                            } else {
                                local11 = local74;
                            }
                        }
                        continue label57;
                    }
                    if (local25 == 0) {
                        local5 = 1;
                        break label57;
                    }
                    local19[local22] = local2;
                    local22++;
                    local25--;
                } else {
                    local11 = local74;
                    if (local25 == 0) {
                        local5 = 1;
                        break label57;
                    }
                    local19[local22] = local2;
                    local22++;
                    local25--;
                }
            }
            local5 = 0;
            break;
        }
        @Pc(191) int local191 = arg0.anInt6474;
        arg0.anInt6474 += local27 - local25;
        arg0.aByte102 = local2;
        arg0.anInt6469 = local5;
        arg0.anInt6477 = local8;
        arg0.anInt6473 = local11;
        tt = local13;
        arg0.anInt6476 = local16;
        arg0.output = local19;
        arg0.anInt6466 = local22;
        arg0.availableOut = local25;
    }

    @OriginalMember(owner = "client!f", name = "a", descriptor = "(ILclient!ni;)I")
    public static int getBits(@OriginalArg(0) int arg0, @OriginalArg(1) BzipDecompressor decompressor) {
        while (decompressor.anInt6482 < arg0) {
            decompressor.anInt6468 = decompressor.anInt6468 << 8 | decompressor.input[decompressor.anInt6470] & 0xFF;
            decompressor.anInt6482 += 8;
            decompressor.anInt6470++;
            decompressor.anInt6472++;
        }
        @Pc(17) int local17 = decompressor.anInt6468 >> decompressor.anInt6482 - arg0 & (0x1 << arg0) - 1;
        decompressor.anInt6482 -= arg0;
        return local17;
    }

    @OriginalMember(owner = "client!f", name = "d", descriptor = "(Lclient!ni;)V")
    public static void makeMapsD(@OriginalArg(0) BzipDecompressor arg0) {
        arg0.nInUse = 0;
        for (@Pc(4) int i = 0; i < 256; i++) {
            if (arg0.inUse[i]) {
                arg0.aByteArray76[arg0.nInUse] = (byte) i;
                arg0.nInUse++;
            }
        }
    }

    @OriginalMember(owner = "client!f", name = "c", descriptor = "(Lclient!ni;)B")
    public static byte getBit(@OriginalArg(0) BzipDecompressor arg0) {
        return (byte) getBits(1, arg0);
    }

    @OriginalMember(owner = "client!f", name = "a", descriptor = "(Lclient!ni;)B")
    public static byte getUchar(@OriginalArg(0) BzipDecompressor arg0) {
        return (byte) getBits(8, arg0);
    }

    @OriginalMember(owner = "client!ni", name = "b", descriptor = "B")
    public byte aByte102;

    @OriginalMember(owner = "client!ni", name = "d", descriptor = "I")
    public int origPtr;

    @OriginalMember(owner = "client!ni", name = "s", descriptor = "I")
    public int anInt6468;

    @OriginalMember(owner = "client!ni", name = "z", descriptor = "I")
    public int anInt6469;

    @OriginalMember(owner = "client!ni", name = "f", descriptor = "[B")
    public byte[] input;

    @OriginalMember(owner = "client!ni", name = "A", descriptor = "I")
    public int anInt6471;

    @OriginalMember(owner = "client!ni", name = "C", descriptor = "I")
    public int anInt6472;

    @OriginalMember(owner = "client!ni", name = "m", descriptor = "I")
    public int anInt6473;

    @OriginalMember(owner = "client!ni", name = "x", descriptor = "[B")
    public byte[] output;

    @OriginalMember(owner = "client!ni", name = "D", descriptor = "I")
    public int anInt6474;

    @OriginalMember(owner = "client!ni", name = "j", descriptor = "I")
    public int nInUse;

    @OriginalMember(owner = "client!ni", name = "q", descriptor = "I")
    public int anInt6476;

    @OriginalMember(owner = "client!ni", name = "G", descriptor = "I")
    public int anInt6477;

    @OriginalMember(owner = "client!ni", name = "E", descriptor = "I")
    public int availableOut;

    @OriginalMember(owner = "client!ni", name = "H", descriptor = "I")
    public int blockSize100k;

    @OriginalMember(owner = "client!ni", name = "u", descriptor = "I")
    public int anInt6482;

    @OriginalMember(owner = "client!ni", name = "h", descriptor = "I")
    public int anInt6466 = 0;

    @OriginalMember(owner = "client!ni", name = "r", descriptor = "[I")
    public final int[] anIntArray514 = new int[6];

    @OriginalMember(owner = "client!ni", name = "n", descriptor = "[B")
    public final byte[] selectorMtf = new byte[18002];

    @OriginalMember(owner = "client!ni", name = "c", descriptor = "I")
    public int anInt6470 = 0;

    @OriginalMember(owner = "client!ni", name = "t", descriptor = "[I")
    public final int[] mtfbase = new int[16];

    @OriginalMember(owner = "client!ni", name = "g", descriptor = "[[B")
    public final byte[][] len = new byte[6][258];

    @OriginalMember(owner = "client!ni", name = "F", descriptor = "[I")
    public final int[] unzftab = new int[256];

    @OriginalMember(owner = "client!ni", name = "w", descriptor = "[Z")
    public final boolean[] inUse16 = new boolean[16];

    @OriginalMember(owner = "client!ni", name = "i", descriptor = "[Z")
    public final boolean[] inUse = new boolean[256];

    @OriginalMember(owner = "client!ni", name = "p", descriptor = "[[I")
    public final int[][] limit = new int[6][258];

    @OriginalMember(owner = "client!ni", name = "y", descriptor = "[B")
    public final byte[] selector = new byte[18002];

    @OriginalMember(owner = "client!ni", name = "B", descriptor = "[[I")
    public final int[][] base = new int[6][258];

    @OriginalMember(owner = "client!ni", name = "o", descriptor = "[B")
    public final byte[] mtfa = new byte[4096];

    @OriginalMember(owner = "client!ni", name = "l", descriptor = "[I")
    public final int[] anIntArray516 = new int[257];

    @OriginalMember(owner = "client!ni", name = "I", descriptor = "[B")
    public final byte[] aByteArray76 = new byte[256];

    @OriginalMember(owner = "client!ni", name = "v", descriptor = "[[I")
    public final int[][] perm = new int[6][258];
}
