package com.jagex.core.crypto;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iv")
public final class Isaac {

    private static final int GOLDEN_RATIO = 0x9E3779B9;

    private static final int SIZE_LOG = 8;

    private static final int SIZE = 1 << SIZE_LOG;

    private static final int STEP = 8;

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
    public Isaac() {
    }

    @OriginalMember(owner = "client!iv", name = "<init>", descriptor = "([I)V")
    public Isaac(@OriginalArg(0) int[] seed) {
        this.results = new int[SIZE];
        this.memory = new int[SIZE];
        for (@Pc(13) int i = 0; i < seed.length; i++) {
            this.results[i] = seed[i];
        }
        this.init();
    }

    @OriginalMember(owner = "client!iv", name = "b", descriptor = "(I)V")
    public void init() {
        @Pc(19) int a = GOLDEN_RATIO;
        @Pc(18) int b = GOLDEN_RATIO;
        @Pc(16) int c = GOLDEN_RATIO;
        @Pc(14) int d = GOLDEN_RATIO;
        @Pc(12) int e = GOLDEN_RATIO;
        @Pc(10) int f = GOLDEN_RATIO;
        @Pc(8) int g = GOLDEN_RATIO;
        @Pc(6) int h = GOLDEN_RATIO;

        for (@Pc(21) int i = 0; i < 4; i++) {
            a ^= b << 11;
            b += c;
            d += a;

            b ^= c >>> 2;
            c += d;
            e += b;

            c ^= d << 8;
            f += c;
            d += e;

            d ^= e >>> 16;
            e += f;
            g += d;

            e ^= f << 10;
            h += e;
            f += g;

            f ^= g >>> 4;
            a += f;
            g += h;

            g ^= h << 8;
            h += a;
            b += g;

            h ^= a >>> 9;
            c += h;
            a += b;
        }

        for (@Pc(21) int i = 0; i < SIZE; i += STEP) {
            a += this.results[i + 0];
            b += this.results[i + 1];
            c += this.results[i + 2];
            d += this.results[i + 3];
            e += this.results[i + 4];
            f += this.results[i + 5];
            g += this.results[i + 6];
            h += this.results[i + 7];

            a ^= b << 11;
            d += a;
            b += c;

            b ^= c >>> 2;
            e += b;
            c += d;

            c ^= d << 8;
            f += c;
            d += e;

            d ^= e >>> 16;
            g += d;
            e += f;

            e ^= f << 10;
            h += e;
            f += g;

            f ^= g >>> 4;
            a += f;
            g += h;

            g ^= h << 8;
            b += g;
            h += a;

            h ^= a >>> 9;
            a += b;
            c += h;

            this.memory[i + 0] = a;
            this.memory[i + 1] = b;
            this.memory[i + 2] = c;
            this.memory[i + 3] = d;
            this.memory[i + 4] = e;
            this.memory[i + 5] = f;
            this.memory[i + 6] = g;
            this.memory[i + 7] = h;
        }

        for (@Pc(21) int i = 0; i < SIZE; i += STEP) {
            a += this.memory[i + 0];
            b += this.memory[i + 1];
            c += this.memory[i + 2];
            d += this.memory[i + 3];
            e += this.memory[i + 4];
            f += this.memory[i + 5];
            g += this.memory[i + 6];
            h += this.memory[i + 7];

            a ^= b << 11;
            d += a;
            b += c;

            b ^= c >>> 2;
            c += d;
            e += b;

            c ^= d << 8;
            d += e;
            f += c;

            d ^= e >>> 16;
            e += f;
            g += d;

            e ^= f << 10;
            h += e;
            f += g;

            f ^= g >>> 4;
            g += h;
            a += f;

            g ^= h << 8;
            h += a;
            b += g;

            h ^= a >>> 9;
            c += h;
            a += b;

            this.memory[i + 0] = a;
            this.memory[i + 1] = b;
            this.memory[i + 2] = c;
            this.memory[i + 3] = d;
            this.memory[i + 4] = e;
            this.memory[i + 5] = f;
            this.memory[i + 6] = g;
            this.memory[i + 7] = h;
        }

        this.isaac();
        this.count = SIZE;
    }

    @OriginalMember(owner = "client!iv", name = "b", descriptor = "(B)I")
    public int next() {
        if (this.count == 0) {
            this.isaac();
            this.count = SIZE;
        }

        return this.results[--this.count];
    }

    @OriginalMember(owner = "client!iv", name = "c", descriptor = "(I)V")
    public void isaac() {
        this.last += ++this.counter;

        for (@Pc(25) int i = 0; i < SIZE; i++) {
            @Pc(31) int x = this.memory[i];

            if ((i & 0x2) == 0) {
                if ((i & 0x1) == 0) {
                    this.accumulator ^= this.accumulator << 13;
                } else {
                    this.accumulator ^= this.accumulator >>> 6;
                }
            } else {
                if ((i & 0x1) == 0) {
                    this.accumulator ^= this.accumulator << 2;
                } else {
                    this.accumulator ^= this.accumulator >>> 16;
                }
            }

            this.accumulator += this.memory[(i + 128) & 0xFF];
            @Pc(122) int y = this.memory[i] = this.memory[(x >> 2) & 0xFF] + this.last + this.accumulator;
            this.results[i] = this.last = this.memory[(y >> 8 >> 2) & 0xFF] + x;
        }
    }

    @OriginalMember(owner = "client!iv", name = "a", descriptor = "(B)I")
    public int peek() {
        if (this.count == 0) {
            this.isaac();
            this.count = SIZE;
        }

        return this.results[this.count - 1];
    }
}
