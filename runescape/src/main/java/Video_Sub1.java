import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

@OriginalClass("client!wea")
public final class Video_Sub1 extends Video {

    @OriginalMember(owner = "client!wea", name = "I", descriptor = "[I")
    public int[] anIntArray834;

    @OriginalMember(owner = "client!wea", name = "J", descriptor = "I")
    public int anInt10596;

    @OriginalMember(owner = "client!wea", name = "N", descriptor = "[[B")
    public byte[][] aByteArrayArray37 = new byte[10][];

    @OriginalMember(owner = "client!wea", name = "S", descriptor = "Lclient!ge;")
    public final Packet aClass2_Sub21_16 = new Packet((byte[]) null);

    @OriginalMember(owner = "client!wea", name = "O", descriptor = "Lclient!ge;")
    public final Packet aClass2_Sub21_17 = new Packet((byte[]) null);

    @OriginalMember(owner = "client!wea", name = "L", descriptor = "Lclient!sb;")
    public final js5 aJs5_126;

    @OriginalMember(owner = "client!wea", name = "K", descriptor = "I")
    public final int anInt10594;

    @OriginalMember(owner = "client!wea", name = "<init>", descriptor = "(ILclient!sb;I)V")
    public Video_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) int arg2) {
        super(arg0);
        this.aJs5_126 = arg1;
        this.anInt10594 = arg2;
    }

    @OriginalMember(owner = "client!wea", name = "i", descriptor = "(I)V")
    public void method9193(@OriginalArg(0) int arg0) {
        if (this.anIntArray834 == null) {
            return;
        }
        for (@Pc(12) int local12 = 0; local12 < 10 && local12 + this.anInt10596 < this.anIntArray834.length; local12++) {
            if (this.aByteArrayArray37[local12] == null && this.aJs5_126.requestdownload(0, this.anIntArray834[this.anInt10596 + local12])) {
                this.aByteArrayArray37[local12] = this.aJs5_126.getfile(0, this.anIntArray834[this.anInt10596 + local12]);
            }
        }
        if (arg0 < 93) {
            this.aByteArrayArray37 = null;
        }
    }

    @OriginalMember(owner = "client!wea", name = "a", descriptor = "([BI)I")
    @Override
    protected int readPage(@OriginalArg(0) byte[] data) throws IOException {
        @Pc(50) int local50;
        @Pc(56) int local56;
        if (this.anIntArray834 == null) {
            if (!this.aJs5_126.requestdownload(0, this.anInt10594)) {
                return 0;
            }
            @Pc(29) byte[] local29 = this.aJs5_126.getfile(0, this.anInt10594);
            if (local29 == null) {
                throw new IllegalStateException("");
            }
            this.aClass2_Sub21_17.data = local29;
            this.aClass2_Sub21_17.pos = 0;
            local50 = local29.length >> 1;
            this.anIntArray834 = new int[local50];
            for (local56 = 0; local56 < local50; local56++) {
                this.anIntArray834[local56] = this.aClass2_Sub21_17.g2();
            }
        }
        if (this.anInt10596 >= this.anIntArray834.length) {
            return -1;
        }
        this.method9193(103);
        this.aClass2_Sub21_17.data = data;
        this.aClass2_Sub21_17.pos = 0;
        do {
            if (this.aClass2_Sub21_17.pos >= this.aClass2_Sub21_17.data.length) {
                this.aClass2_Sub21_17.data = null;
                return data.length;
            }
            if (this.aClass2_Sub21_16.data == null) {
                if (this.aByteArrayArray37[0] == null) {
                    this.aClass2_Sub21_17.data = null;
                    return this.aClass2_Sub21_17.pos;
                }
                this.aClass2_Sub21_16.data = this.aByteArrayArray37[0];
            }
            @Pc(143) int local143 = this.aClass2_Sub21_17.data.length - this.aClass2_Sub21_17.pos;
            local50 = this.aClass2_Sub21_16.data.length - this.aClass2_Sub21_16.pos;
            if (local50 > local143) {
                this.aClass2_Sub21_16.gdata(this.aClass2_Sub21_17.pos, local143, this.aClass2_Sub21_17.data);
                this.aClass2_Sub21_17.data = null;
                return data.length;
            }
            this.aClass2_Sub21_17.pdata(local50, this.aClass2_Sub21_16.data, this.aClass2_Sub21_16.pos);
            this.aClass2_Sub21_16.pos = 0;
            this.anInt10596++;
            this.aClass2_Sub21_16.data = null;
            for (local56 = 0; local56 < 9; local56++) {
                this.aByteArrayArray37[local56] = this.aByteArrayArray37[local56 + 1];
            }
            this.aByteArrayArray37[9] = null;
        } while (this.anIntArray834.length > this.anInt10596);
        this.aClass2_Sub21_17.data = null;
        return this.aClass2_Sub21_17.pos;
    }
}
