package com.jagex.sound;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nn")
public final class Node_Sub6_Sub3 extends AudioBuss {

    @OriginalMember(owner = "client!nn", name = "p", descriptor = "Lclient!sia;")
    public final Deque<AudioBuss> aDeque_35 = new Deque<AudioBuss>();

    @OriginalMember(owner = "client!nn", name = "o", descriptor = "Lclient!sia;")
    public final Deque<? extends Node_Sub3> aDeque_36 = new Deque<>();

    @OriginalMember(owner = "client!nn", name = "q", descriptor = "I")
    public int anInt6603 = 0;

    @OriginalMember(owner = "client!nn", name = "r", descriptor = "I")
    public int anInt6604 = -1;

    @OriginalMember(owner = "client!nn", name = "b", descriptor = "()I")
    @Override
    public int method9132() {
        return 0;
    }

    @OriginalMember(owner = "client!nn", name = "b", descriptor = "([III)V")
    @Override
    public synchronized void method9131(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        do {
            if (this.anInt6604 < 0) {
                this.method5885(arg0, arg1, arg2);
                return;
            }
            if (this.anInt6603 + arg2 < this.anInt6604) {
                this.anInt6603 += arg2;
                this.method5885(arg0, arg1, arg2);
                return;
            }
            @Pc(33) int local33 = this.anInt6604 - this.anInt6603;
            this.method5885(arg0, arg1, local33);
            arg1 += local33;
            arg2 -= local33;
            this.anInt6603 += local33;
            this.method5887();
            @Pc(60) Node_Sub3 local60 = this.aDeque_36.first();
            synchronized (local60) {
                @Pc(68) int local68 = local60.method114(this);
                if (local68 < 0) {
                    local60.anInt101 = 0;
                    this.method5888(local60);
                } else {
                    local60.anInt101 = local68;
                    this.method5886(local60.next, local60);
                }
            }
        } while (arg2 != 0);
    }

    @OriginalMember(owner = "client!nn", name = "e", descriptor = "()I")
    public synchronized int count() {
        return this.aDeque_35.size();
    }

    @OriginalMember(owner = "client!nn", name = "a", descriptor = "(Lclient!dea;)V")
    public synchronized void addFirst(@OriginalArg(0) AudioBuss arg0) {
        this.aDeque_35.addFirst(arg0);
    }

    @OriginalMember(owner = "client!nn", name = "b", descriptor = "(Lclient!dea;)V")
    public synchronized void remove(@OriginalArg(0) AudioBuss arg0) {
        arg0.unlink();
    }

    @OriginalMember(owner = "client!nn", name = "b", descriptor = "(I)V")
    public void method5884(@OriginalArg(0) int arg0) {
        for (@Pc(5) AudioBuss local5 = this.aDeque_35.first(); local5 != null; local5 = this.aDeque_35.next()) {
            local5.method9130(arg0);
        }
    }

    @OriginalMember(owner = "client!nn", name = "c", descriptor = "([III)V")
    public void method5885(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        for (@Pc(5) AudioBuss local5 = this.aDeque_35.first(); local5 != null; local5 = this.aDeque_35.next()) {
            local5.method9134(arg0, arg1, arg2);
        }
    }

    @OriginalMember(owner = "client!nn", name = "a", descriptor = "()Lclient!dea;")
    @Override
    public AudioBuss method9135() {
        return this.aDeque_35.next();
    }

    @OriginalMember(owner = "client!nn", name = "a", descriptor = "(Lclient!ie;Lclient!ada;)V")
    public void method5886(@OriginalArg(0) Node arg0, @OriginalArg(1) Node_Sub3 arg1) {
        while (arg0 != this.aDeque_36.sentinel && ((Node_Sub3) arg0).anInt101 <= arg1.anInt101) {
            arg0 = arg0.next;
        }
        Node.addBefore(arg0, arg1);
        this.anInt6604 = ((Node_Sub3) this.aDeque_36.sentinel.next).anInt101;
    }

    @OriginalMember(owner = "client!nn", name = "c", descriptor = "()Lclient!dea;")
    @Override
    public AudioBuss method9133() {
        return this.aDeque_35.first();
    }

    @OriginalMember(owner = "client!nn", name = "a", descriptor = "(I)V")
    @Override
    public synchronized void method9130(@OriginalArg(0) int arg0) {
        do {
            if (this.anInt6604 < 0) {
                this.method5884(arg0);
                return;
            }
            if (this.anInt6603 + arg0 < this.anInt6604) {
                this.anInt6603 += arg0;
                this.method5884(arg0);
                return;
            }
            @Pc(29) int local29 = this.anInt6604 - this.anInt6603;
            this.method5884(local29);
            arg0 -= local29;
            this.anInt6603 += local29;
            this.method5887();
            @Pc(50) Node_Sub3 local50 = this.aDeque_36.first();
            synchronized (local50) {
                @Pc(58) int local58 = local50.method114(this);
                if (local58 < 0) {
                    local50.anInt101 = 0;
                    this.method5888(local50);
                } else {
                    local50.anInt101 = local58;
                    this.method5886(local50.next, local50);
                }
            }
        } while (arg0 != 0);
    }

    @OriginalMember(owner = "client!nn", name = "f", descriptor = "()V")
    public void method5887() {
        if (this.anInt6603 <= 0) {
            return;
        }
        for (@Pc(8) Node_Sub3 local8 = this.aDeque_36.first(); local8 != null; local8 = this.aDeque_36.next()) {
            local8.anInt101 -= this.anInt6603;
        }
        this.anInt6604 -= this.anInt6603;
        this.anInt6603 = 0;
    }

    @OriginalMember(owner = "client!nn", name = "a", descriptor = "(Lclient!ada;)V")
    public void method5888(@OriginalArg(0) Node_Sub3 arg0) {
        arg0.unlink();
        arg0.method113();
        @Pc(9) Node local9 = this.aDeque_36.sentinel.next;
        if (local9 == this.aDeque_36.sentinel) {
            this.anInt6604 = -1;
        } else {
            this.anInt6604 = ((Node_Sub3) local9).anInt101;
        }
    }
}
