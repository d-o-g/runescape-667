import com.jagex.IndexedImage;
import com.jagex.collect.key.Deque;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static239 {

    @OriginalMember(owner = "client!hha", name = "b", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___19 = new Deque();

    @OriginalMember(owner = "client!hha", name = "a", descriptor = "(BLclient!sb;Lclient!ha;)V")
    public static void method3472(@OriginalArg(1) js5 arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(8) IndexedImage[] local8 = IndexedImage.load(arg0, Static159.anInt2787, 0);
        Static119.aSpriteArray3 = new Sprite[local8.length];
        for (@Pc(14) int local14 = 0; local14 < local8.length; local14++) {
            Static119.aSpriteArray3[local14] = arg1.method7948(local8[local14], true);
        }
        local8 = IndexedImage.load(arg0, Static434.anInt6579, 0);
        Static34.aSpriteArray2 = new Sprite[local8.length];
        for (@Pc(44) int local44 = 0; local44 < local8.length; local44++) {
            Static34.aSpriteArray2[local44] = arg1.method7948(local8[local44], true);
        }
        local8 = IndexedImage.load(arg0, Static67.anInt6784, 0);
        Static441.aSpriteArray10 = new Sprite[local8.length];
        for (@Pc(74) int local74 = 0; local74 < local8.length; local74++) {
            Static441.aSpriteArray10[local74] = arg1.method7948(local8[local74], true);
        }
        local8 = IndexedImage.load(arg0, Static304.anInt4876, 0);
        Static493.aSpriteArray12 = new Sprite[local8.length];
        for (@Pc(112) int local112 = 0; local112 < local8.length; local112++) {
            Static493.aSpriteArray12[local112] = arg1.method7948(local8[local112], true);
        }
        local8 = IndexedImage.load(arg0, Static644.anInt9607, 0);
        Static28.aSpriteArray1 = new Sprite[local8.length];
        for (@Pc(138) int local138 = 0; local138 < local8.length; local138++) {
            Static28.aSpriteArray1[local138] = arg1.method7948(local8[local138], true);
        }
        local8 = IndexedImage.load(arg0, Static699.anInt10540, 0);
        Static174.aSpriteArray4 = new Sprite[local8.length];
        for (@Pc(168) int local168 = 0; local168 < local8.length; local168++) {
            Static174.aSpriteArray4[local168] = arg1.method7948(local8[local168], true);
        }
        local8 = IndexedImage.load(arg0, Static132.anInt2451, 0);
        Static691.aSpriteArray15 = new Sprite[local8.length];
        for (@Pc(198) int local198 = 0; local198 < local8.length; local198++) {
            Static691.aSpriteArray15[local198] = arg1.method7948(local8[local198], true);
        }
        local8 = IndexedImage.load(arg0, Static270.anInt4355, 0);
        Static355.aSpriteArray9 = new Sprite[local8.length];
        for (@Pc(228) int local228 = 0; local228 < local8.length; local228++) {
            Static355.aSpriteArray9[local228] = arg1.method7948(local8[local228], true);
        }
        local8 = IndexedImage.load(arg0, Static598.anInt8828, 0);
        Static471.aSpriteArray11 = new Sprite[local8.length];
        for (@Pc(258) int local258 = 0; local258 < local8.length; local258++) {
            Static471.aSpriteArray11[local258] = arg1.method7948(local8[local258], true);
        }
        local8 = IndexedImage.load(arg0, Static305.anInt4883, 0);
        Static291.aSpriteArray8 = new Sprite[local8.length];
        for (@Pc(284) int local284 = 0; local284 < local8.length; local284++) {
            Static291.aSpriteArray8[local284] = arg1.method7948(local8[local284], true);
        }
        local8 = IndexedImage.load(arg0, Static548.anInt8259, 0);
        Static679.aSpriteArray14 = new Sprite[local8.length];
        for (@Pc(310) int local310 = 0; local310 < local8.length; local310++) {
            Static679.aSpriteArray14[local310] = arg1.method7948(local8[local310], true);
        }
        Static12.aSprite_27 = arg1.method7948(IndexedImage.loadFirst(arg0, Static670.anInt10024, 0), true);
        Static517.aSprite_32 = arg1.method7948(IndexedImage.loadFirst(arg0, Static286.anInt4592, 0), true);
        local8 = IndexedImage.load(arg0, Static665.anInt9943, 0);
        Static558.aSpriteArray7 = new Sprite[local8.length];
        for (@Pc(352) int local352 = 0; local352 < local8.length; local352++) {
            Static558.aSpriteArray7[local352] = arg1.method7948(local8[local352], true);
        }
    }

    @OriginalMember(owner = "client!hha", name = "a", descriptor = "(II)I")
    public static int method3474(@OriginalArg(1) int arg0) {
        @Pc(7) int local7 = arg0 & 0x3F;
        @Pc(13) int local13 = arg0 >> 6 & 0x3;
        if (local7 == 18) {
            if (local13 == 0) {
                return 1;
            }
            if (local13 == 1) {
                return 2;
            }
            if (local13 == 2) {
                return 4;
            }
            if (local13 == 3) {
                return 8;
            }
        } else if (local7 == 19 || local7 == 21) {
            if (local13 == 0) {
                return 16;
            }
            if (local13 == 1) {
                return 32;
            }
            if (local13 == 2) {
                return 64;
            }
            if (local13 == 3) {
                return 128;
            }
        }
        return 0;
    }
}
