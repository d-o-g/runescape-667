package com.jagex.sound;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.game.runetek6.sound.Audio;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!uka")
public final class Node_Sub6_Sub4 extends AudioBuss {

    @OriginalMember(owner = "client!uka", name = "t", descriptor = "Lclient!sia;")
    public final Deque aDeque_72 = new Deque();

    @OriginalMember(owner = "client!uka", name = "A", descriptor = "Lclient!nn;")
    public final Node_Sub6_Sub3 aClass2_Sub6_Sub3_2 = new Node_Sub6_Sub3();

    @OriginalMember(owner = "client!uka", name = "D", descriptor = "Lclient!bd;")
    public final MixBuss aClass2_Sub6_Sub1_4;

    @OriginalMember(owner = "client!uka", name = "<init>", descriptor = "(Lclient!bd;)V")
    public Node_Sub6_Sub4(@OriginalArg(0) MixBuss arg0) {
        this.aClass2_Sub6_Sub1_4 = arg0;
    }

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "(I)V")
    @Override
    public void method9130(@OriginalArg(0) int arg0) {
        this.aClass2_Sub6_Sub3_2.method9130(arg0);
        for (@Pc(15) Node_Sub16 local15 = (Node_Sub16) this.aDeque_72.first(); local15 != null; local15 = (Node_Sub16) this.aDeque_72.next()) {
            if (!this.aClass2_Sub6_Sub1_4.method921(local15)) {
                @Pc(27) int local27 = arg0;
                do {
                    if (local27 <= local15.anInt2184) {
                        this.method8530(local15, local27);
                        local15.anInt2184 -= local27;
                        break;
                    }
                    this.method8530(local15, local15.anInt2184);
                    local27 -= local15.anInt2184;
                } while (!this.aClass2_Sub6_Sub1_4.method945(local15, null, 0, local27));
            }
        }
    }

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "(Lclient!dha;II)V")
    public void method8530(@OriginalArg(0) Node_Sub16 arg0, @OriginalArg(2) int arg1) {
        if ((this.aClass2_Sub6_Sub1_4.anIntArray56[arg0.anInt2187] & 0x4) != 0 && arg0.anInt2202 < 0) {
            @Pc(28) int local28 = this.aClass2_Sub6_Sub1_4.anIntArray57[arg0.anInt2187] / Audio.sampleRate;
            @Pc(37) int local37 = (local28 + 1048575 - arg0.anInt2183) / local28;
            arg0.anInt2183 = arg0.anInt2183 + local28 * arg1 & 0xFFFFF;
            if (local37 <= arg1) {
                if (this.aClass2_Sub6_Sub1_4.anIntArray49[arg0.anInt2187] == 0) {
                    arg0.aClass2_Sub6_Sub2_1 = SoundStream.create(arg0.aClass2_Sub49_Sub1_1, arg0.aClass2_Sub6_Sub2_1.method3340(), arg0.aClass2_Sub6_Sub2_1.getVolume(), arg0.aClass2_Sub6_Sub2_1.getRange());
                } else {
                    arg0.aClass2_Sub6_Sub2_1 = SoundStream.create(arg0.aClass2_Sub49_Sub1_1, arg0.aClass2_Sub6_Sub2_1.method3340(), 0, arg0.aClass2_Sub6_Sub2_1.getRange());
                    this.aClass2_Sub6_Sub1_4.method943(arg0.aClass2_Sub11_1.aShortArray16[arg0.anInt2196] < 0, arg0);
                }
                if (arg0.aClass2_Sub11_1.aShortArray16[arg0.anInt2196] < 0) {
                    arg0.aClass2_Sub6_Sub2_1.setLoops(-1);
                }
                arg1 = arg0.anInt2183 / local28;
            }
        }
        arg0.aClass2_Sub6_Sub2_1.method9130(arg1);
    }

    @OriginalMember(owner = "client!uka", name = "b", descriptor = "()I")
    @Override
    public int method9132() {
        return 0;
    }

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "()Lclient!dea;")
    @Override
    public AudioBuss method9135() {
        @Pc(11) Node_Sub16 local11;
        do {
            local11 = (Node_Sub16) this.aDeque_72.next();
            if (local11 == null) {
                return null;
            }
        } while (local11.aClass2_Sub6_Sub2_1 == null);
        return local11.aClass2_Sub6_Sub2_1;
    }

    @OriginalMember(owner = "client!uka", name = "c", descriptor = "()Lclient!dea;")
    @Override
    public AudioBuss method9133() {
        @Pc(9) Node_Sub16 local9 = (Node_Sub16) this.aDeque_72.first();
        if (local9 == null) {
            return null;
        } else if (local9.aClass2_Sub6_Sub2_1 == null) {
            return this.method9135();
        } else {
            return local9.aClass2_Sub6_Sub2_1;
        }
    }

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "([ILclient!dha;IIII)V")
    public void method8535(@OriginalArg(0) int[] arg0, @OriginalArg(1) Node_Sub16 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        if ((this.aClass2_Sub6_Sub1_4.anIntArray56[arg1.anInt2187] & 0x4) != 0 && arg1.anInt2202 < 0) {
            @Pc(34) int local34 = this.aClass2_Sub6_Sub1_4.anIntArray57[arg1.anInt2187] / Audio.sampleRate;
            while (true) {
                @Pc(44) int local44 = (local34 + 1048575 - arg1.anInt2183) / local34;
                if (local44 > arg3) {
                    arg1.anInt2183 += arg3 * local34;
                    break;
                }
                arg1.aClass2_Sub6_Sub2_1.method9131(arg0, arg4, local44);
                arg1.anInt2183 += local34 * local44 - 1048576;
                arg3 -= local44;
                arg4 += local44;
                @Pc(75) int local75 = Audio.sampleRate / 100;
                @Pc(79) int local79 = 262144 / local34;
                if (local79 < local75) {
                    local75 = local79;
                }
                @Pc(91) SoundStream local91 = arg1.aClass2_Sub6_Sub2_1;
                if (this.aClass2_Sub6_Sub1_4.anIntArray49[arg1.anInt2187] == 0) {
                    arg1.aClass2_Sub6_Sub2_1 = SoundStream.create(arg1.aClass2_Sub49_Sub1_1, local91.method3340(), local91.getVolume(), local91.getRange());
                } else {
                    arg1.aClass2_Sub6_Sub2_1 = SoundStream.create(arg1.aClass2_Sub49_Sub1_1, local91.method3340(), 0, local91.getRange());
                    this.aClass2_Sub6_Sub1_4.method943(arg1.aClass2_Sub11_1.aShortArray16[arg1.anInt2196] < 0, arg1);
                    arg1.aClass2_Sub6_Sub2_1.method3315(local75, local91.getVolume());
                }
                if (arg1.aClass2_Sub11_1.aShortArray16[arg1.anInt2196] < 0) {
                    arg1.aClass2_Sub6_Sub2_1.setLoops(-1);
                }
                local91.method3320(local75);
                local91.method9131(arg0, arg4, arg2 - arg4);
                if (local91.method3336()) {
                    this.aClass2_Sub6_Sub3_2.addFirst(local91);
                }
            }
        }
        arg1.aClass2_Sub6_Sub2_1.method9131(arg0, arg4, arg3);
    }

    @OriginalMember(owner = "client!uka", name = "b", descriptor = "([III)V")
    @Override
    public void method9131(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        this.aClass2_Sub6_Sub3_2.method9131(arg0, arg1, arg2);
        for (@Pc(17) Node_Sub16 local17 = (Node_Sub16) this.aDeque_72.first(); local17 != null; local17 = (Node_Sub16) this.aDeque_72.next()) {
            if (!this.aClass2_Sub6_Sub1_4.method921(local17)) {
                @Pc(29) int local29 = arg1;
                @Pc(31) int local31 = arg2;
                do {
                    if (local17.anInt2184 >= local31) {
                        this.method8535(arg0, local17, local29 + local31, local31, local29);
                        local17.anInt2184 -= local31;
                        break;
                    }
                    this.method8535(arg0, local17, local31 + local29, local17.anInt2184, local29);
                    local29 += local17.anInt2184;
                    local31 -= local17.anInt2184;
                } while (!this.aClass2_Sub6_Sub1_4.method945(local17, arg0, local29, local31));
            }
        }
    }
}
