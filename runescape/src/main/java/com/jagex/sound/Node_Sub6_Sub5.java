package com.jagex.sound;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.LruCache;
import com.jagex.game.runetek6.sound.Audio;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wc")
public final class Node_Sub6_Sub5 extends Node_Sub6 {

    @OriginalMember(owner = "client!ko", name = "H", descriptor = "Lclient!ts;")
    public static final LruCache recentUse = new LruCache(64);

    @OriginalMember(owner = "client!ka", name = "f", descriptor = "Z")
    public static boolean aBoolean644;

    @OriginalMember(owner = "client!wc", name = "o", descriptor = "Z")
    public boolean aBoolean794;

    @OriginalMember(owner = "client!wc", name = "J", descriptor = "I")
    public int anInt10536;

    @OriginalMember(owner = "client!wc", name = "L", descriptor = "Z")
    public boolean aBoolean795;

    @OriginalMember(owner = "client!wc", name = "M", descriptor = "Lclient!sia;")
    public final Deque aDeque_80 = new Deque();

    @OriginalMember(owner = "client!wc", name = "E", descriptor = "I")
    public int anInt10535 = 0;

    @OriginalMember(owner = "client!wc", name = "u", descriptor = "I")
    public int anInt10537 = 256;

    @OriginalMember(owner = "client!wc", name = "K", descriptor = "I")
    public int anInt10534 = 256;

    @OriginalMember(owner = "client!wc", name = "C", descriptor = "I")
    public final int anInt10521;

    @OriginalMember(owner = "client!wc", name = "<init>", descriptor = "(I)V")
    public Node_Sub6_Sub5(@OriginalArg(0) int arg0) {
        this.anInt10521 = arg0;
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(Z)D")
    public synchronized double method9137(@OriginalArg(0) boolean arg0) {
        if (this.anInt10535 < 1) {
            return -1.0D;
        }
        @Pc(16) DoublyLinkedNode_Sub2_Sub8 local16 = (DoublyLinkedNode_Sub2_Sub8) this.aDeque_80.first();
        if (local16 == null) {
            return -1.0D;
        } else {
            if (arg0) {
                this.method9130(87);
            }
            return local16.aDouble10 - (double) ((float) local16.aShortArrayArray3[0].length / (float) Audio.sampleRate);
        }
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "()Lclient!dea;")
    @Override
    public Node_Sub6 method9135() {
        return null;
    }

    @OriginalMember(owner = "client!wc", name = "d", descriptor = "(I)I")
    public synchronized int method9140() {
        return this.anInt10535;
    }

    @OriginalMember(owner = "client!wc", name = "b", descriptor = "(Z)V")
    public synchronized void method9141() {
        this.aBoolean795 = true;
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(I)V")
    @Override
    public synchronized void method9130(@OriginalArg(0) int arg0) {
        if (this.aBoolean794) {
            return;
        }
        while (true) {
            @Pc(14) DoublyLinkedNode_Sub2_Sub8 local14 = this.method9145();
            if (local14 == null) {
                if (this.aBoolean795) {
                    this.unlink();
                    recentUse.clear();
                }
                return;
            }
            if (local14.aShortArrayArray3[0].length - this.anInt10536 > arg0) {
                this.anInt10536 += arg0;
                return;
            }
            arg0 -= local14.aShortArrayArray3[0].length - this.anInt10536;
            this.method9144();
        }
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(IDI)Lclient!dk;")
    public DoublyLinkedNode_Sub2_Sub8 method9142(@OriginalArg(0) int arg0, @OriginalArg(1) double arg1) {
        @Pc(11) long local11 = arg0 | this.anInt10521 << 0;
        @Pc(17) DoublyLinkedNode_Sub2_Sub8 local17 = (DoublyLinkedNode_Sub2_Sub8) recentUse.get(local11);
        if (local17 == null) {
            local17 = new DoublyLinkedNode_Sub2_Sub8(new short[this.anInt10521][arg0], arg1);
        } else {
            local17.aDouble10 = arg1;
            recentUse.remove(local11);
        }
        return local17;
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(Lclient!dk;B)V")
    public synchronized void method9143(@OriginalArg(0) DoublyLinkedNode_Sub2_Sub8 arg0) {
        while (this.anInt10535 >= 100) {
            this.aDeque_80.removeFirst();
            this.anInt10535--;
        }
        this.aDeque_80.addLast(arg0);
        if (-73 != -73) {
            this.method9137(true);
        }
        this.anInt10535++;
    }

    @OriginalMember(owner = "client!wc", name = "b", descriptor = "(B)V")
    public synchronized void method9144() {
        @Pc(7) DoublyLinkedNode_Sub2_Sub8 local7 = this.method9145();
        if (local7 != null) {
            local7.unlink();
            this.anInt10535--;
            this.anInt10536 = 0;
            recentUse.put(local7, local7.method2133());
        }
    }

    @OriginalMember(owner = "client!wc", name = "b", descriptor = "()I")
    @Override
    public int method9132() {
        return 1;
    }

    @OriginalMember(owner = "client!wc", name = "c", descriptor = "()Lclient!dea;")
    @Override
    public Node_Sub6 method9133() {
        return null;
    }

    @OriginalMember(owner = "client!wc", name = "c", descriptor = "(B)Lclient!dk;")
    public synchronized DoublyLinkedNode_Sub2_Sub8 method9145() {
        return (DoublyLinkedNode_Sub2_Sub8) this.aDeque_80.first();
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(IZ)V")
    public synchronized void method9146(@OriginalArg(1) boolean arg0) {
        this.aBoolean794 = arg0;
    }

    @OriginalMember(owner = "client!wc", name = "a", descriptor = "(IB)V")
    public void method9147(@OriginalArg(0) int arg0) {
        this.anInt10537 = arg0;
        this.anInt10534 = arg0;
    }

    @OriginalMember(owner = "client!wc", name = "b", descriptor = "([III)V")
    @Override
    public synchronized void method9131(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        if (this.aBoolean794) {
            return;
        }
        if (this.method9145() != null) {
            @Pc(32) int local32 = arg2 + arg1;
            if (aBoolean644) {
                local32 <<= 0x1;
            }
            @Pc(42) byte local42 = 0;
            if (this.anInt10521 == 2) {
                local42 = 1;
            }
            while (arg1 < local32) {
                @Pc(56) DoublyLinkedNode_Sub2_Sub8 local56 = this.method9145();
                if (local56 == null) {
                    return;
                }
                @Pc(62) short[][] local62 = local56.aShortArrayArray3;
                while (local32 > arg1 && this.anInt10536 < local62[0].length) {
                    if (aBoolean644) {
                        arg0[arg1++] = local62[0][this.anInt10536] * this.anInt10534;
                        arg0[arg1++] = this.anInt10537 * local62[local42][this.anInt10536];
                    } else {
                        @Pc(70) int local70 = arg1++;
                        arg0[local70] += this.anInt10537 * local62[local42][this.anInt10536] + local62[0][this.anInt10536] * this.anInt10534;
                    }
                    this.anInt10536++;
                }
                if (this.anInt10536 >= local62[0].length) {
                    this.method9144();
                }
            }
        } else if (this.aBoolean795) {
            this.unlink();
            recentUse.clear();
        }
    }
}
