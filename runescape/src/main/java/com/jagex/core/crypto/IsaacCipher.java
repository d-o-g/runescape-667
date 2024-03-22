package com.jagex.core.crypto;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iv")
public final class IsaacCipher {

    @OriginalMember(owner = "client!iv", name = "a", descriptor = "I")
    public int last;

    @OriginalMember(owner = "client!iv", name = "l", descriptor = "I")
    public int count;

    @OriginalMember(owner = "client!iv", name = "c", descriptor = "[I")
    public int[] results;

    @OriginalMember(owner = "client!iv", name = "j", descriptor = "[I")
    public int[] memory;

    @OriginalMember(owner = "client!iv", name = "h", descriptor = "I")
    public int accumulator;

    @OriginalMember(owner = "client!iv", name = "f", descriptor = "I")
    public int counter;

    @OriginalMember(owner = "client!iv", name = "<init>", descriptor = "()V")
    public IsaacCipher() {
    }

    @OriginalMember(owner = "client!iv", name = "<init>", descriptor = "([I)V")
    public IsaacCipher(@OriginalArg(0) int[] seed) {
        this.results = new int[256];
        this.memory = new int[256];
        for (@Pc(13) int i = 0; i < seed.length; i++) {
            this.results[i] = seed[i];
        }
        this.init();
    }

    @OriginalMember(owner = "client!iv", name = "b", descriptor = "(I)V")
    public void init() {
        @Pc(6) int local6 = -1640531527;
        @Pc(8) int local8 = -1640531527;
        @Pc(10) int local10 = -1640531527;
        @Pc(12) int local12 = -1640531527;
        @Pc(14) int local14 = -1640531527;
        @Pc(16) int local16 = -1640531527;
        @Pc(18) int local18 = -1640531527;
        @Pc(19) int local19 = -1640531527;
        @Pc(21) int local21;
        for (local21 = 0; local21 < 4; local21++) {
            local19 ^= local18 << 11;
            local18 += local16;
            local14 += local19;
            local18 ^= local16 >>> 2;
            local16 += local14;
            local12 += local18;
            local16 ^= local14 << 8;
            local10 += local16;
            local14 += local12;
            local14 ^= local12 >>> 16;
            local12 += local10;
            local8 += local14;
            local12 ^= local10 << 10;
            local6 += local12;
            local10 += local8;
            local10 ^= local8 >>> 4;
            local19 += local10;
            local8 += local6;
            local8 ^= local6 << 8;
            local6 += local19;
            local18 += local8;
            local6 ^= local19 >>> 9;
            local16 += local6;
            local19 += local18;
        }
        for (local21 = 0; local21 < 256; local21 += 8) {
            local8 += this.results[local21 + 6];
            local10 += this.results[local21 + 5];
            local19 += this.results[local21];
            local14 += this.results[local21 + 3];
            local12 += this.results[local21 + 4];
            local6 += this.results[local21 + 7];
            local18 += this.results[local21 + 1];
            local16 += this.results[local21 + 2];
            local19 ^= local18 << 11;
            local14 += local19;
            local18 += local16;
            local18 ^= local16 >>> 2;
            local12 += local18;
            local16 += local14;
            local16 ^= local14 << 8;
            local10 += local16;
            local14 += local12;
            local14 ^= local12 >>> 16;
            local8 += local14;
            local12 += local10;
            local12 ^= local10 << 10;
            local6 += local12;
            local10 += local8;
            local10 ^= local8 >>> 4;
            local19 += local10;
            local8 += local6;
            local8 ^= local6 << 8;
            local18 += local8;
            local6 += local19;
            local6 ^= local19 >>> 9;
            local19 += local18;
            local16 += local6;
            this.memory[local21] = local19;
            this.memory[local21 + 1] = local18;
            this.memory[local21 + 2] = local16;
            this.memory[local21 + 3] = local14;
            this.memory[local21 + 4] = local12;
            this.memory[local21 + 5] = local10;
            this.memory[local21 + 6] = local8;
            this.memory[local21 + 7] = local6;
        }
        for (local21 = 0; local21 < 256; local21 += 8) {
            local6 += this.memory[local21 + 7];
            local18 += this.memory[local21 + 1];
            local12 += this.memory[local21 + 4];
            local14 += this.memory[local21 + 3];
            local16 += this.memory[local21 + 2];
            local8 += this.memory[local21 + 6];
            local10 += this.memory[local21 + 5];
            local19 += this.memory[local21];
            local19 ^= local18 << 11;
            local14 += local19;
            local18 += local16;
            local18 ^= local16 >>> 2;
            local16 += local14;
            local12 += local18;
            local16 ^= local14 << 8;
            local14 += local12;
            local10 += local16;
            local14 ^= local12 >>> 16;
            local12 += local10;
            local8 += local14;
            local12 ^= local10 << 10;
            local6 += local12;
            local10 += local8;
            local10 ^= local8 >>> 4;
            local8 += local6;
            local19 += local10;
            local8 ^= local6 << 8;
            local6 += local19;
            local18 += local8;
            local6 ^= local19 >>> 9;
            local16 += local6;
            local19 += local18;
            this.memory[local21] = local19;
            this.memory[local21 + 1] = local18;
            this.memory[local21 + 2] = local16;
            this.memory[local21 + 3] = local14;
            this.memory[local21 + 4] = local12;
            this.memory[local21 + 5] = local10;
            this.memory[local21 + 6] = local8;
            this.memory[local21 + 7] = local6;
        }
        this.isaac();
        this.count = 256;
    }

    @OriginalMember(owner = "client!iv", name = "b", descriptor = "(B)I")
    public int peek() {
        if (this.count == 0) {
            this.isaac();
            this.count = 256;
        }
        return this.results[--this.count];
    }

    @OriginalMember(owner = "client!iv", name = "c", descriptor = "(I)V")
    public void isaac() {
        this.last += ++this.counter;
        for (@Pc(25) int flag2 = 0; flag2 < 256; flag2++) {
            @Pc(31) int local31 = this.memory[flag2];
            if ((flag2 & 0x2) != 0) {
                if ((flag2 & 0x1) != 0) {
                    this.accumulator ^= this.accumulator >>> 16;
                } else {
                    this.accumulator ^= this.accumulator << 2;
                }
            } else {
                if ((flag2 & 0x1) != 0) {
                    this.accumulator ^= this.accumulator >>> 6;
                } else {
                    this.accumulator ^= this.accumulator << 13;
                }
            }
            this.accumulator += this.memory[flag2 + 128 & 0xFF];
            @Pc(122) int local122;
            this.memory[flag2] = local122 = this.last + this.memory[local31 >> 2 & 0xFF] + this.accumulator;
            this.results[flag2] = this.last = this.memory[local122 >> 8 >> 2 & 0xFF] + local31;
        }
    }

    @OriginalMember(owner = "client!iv", name = "a", descriptor = "(B)I")
    public int method4108() {
        if (this.count == 0) {
            this.isaac();
            this.count = 256;
        }
        return this.results[this.count - 1];
    }
}
