import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public final class Static168 {

    @OriginalMember(owner = "client!fda", name = "f", descriptor = "I")
    public static int anInt2842;

    @OriginalMember(owner = "client!fda", name = "c", descriptor = "Lclient!fla;")
    public static final EntityList A_ENTITY_LIST___5 = new EntityList();

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(Lclient!rka;I)V")
    public static void method2633(@OriginalArg(0) Node_Sub21_Sub2 arg0) {
        arg0.method7417();
        @Pc(10) int local10 = Static312.anInt5000;
        @Pc(20) Class8_Sub2_Sub1_Sub2_Sub1 local20 = Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2 = Static621.aClass8_Sub2_Sub1_Sub2_Sub1Array3[local10] = new Class8_Sub2_Sub1_Sub2_Sub1();
        local20.anInt10740 = local10;
        @Pc(28) int local28 = arg0.method7412(30);
        @Pc(33) byte local33 = (byte) (local28 >> 28);
        @Pc(39) int local39 = local28 >> 14 & 0x3FFF;
        local20.anIntArray879[0] = local39 - Static691.anInt10367;
        @Pc(51) int local51 = local28 & 0x3FFF;
        local20.anInt10690 = (local20.anIntArray879[0] << 9) + (local20.method9302((byte) 53) << 8);
        local20.anIntArray878[0] = local51 - Static116.anInt2270;
        local20.anInt10694 = (local20.anIntArray878[0] << 9) + (local20.method9302((byte) 65) << 8);
        Static394.anInt6176 = local20.aByte144 = local20.aByte143 = local33;
        if (Static441.method5968(local20.anIntArray878[0], local20.anIntArray879[0])) {
            local20.aByte143++;
        }
        if (Static462.aClass2_Sub21Array1[local10] != null) {
            local20.method1420(Static462.aClass2_Sub21Array1[local10]);
        }
        Static338.anInt5564 = 0;
        Static210.anIntArray280[Static338.anInt5564++] = local10;
        Static402.aByteArray68[local10] = 0;
        Static51.anInt1053 = 0;
        for (@Pc(151) int local151 = 1; local151 < 2048; local151++) {
            if (local10 != local151) {
                @Pc(163) int local163 = arg0.method7412(18);
                @Pc(167) int local167 = local163 >> 16;
                @Pc(173) int local173 = local163 >> 8 & 0xFF;
                @Pc(177) int local177 = local163 & 0xFF;
                @Pc(185) Class350 local185 = Static246.aClass350Array1[local151] = new Class350();
                local185.aBoolean711 = false;
                local185.anInt9322 = -1;
                local185.anInt9324 = local177 + (local173 << 14) + (local167 << 28);
                local185.anInt9326 = 0;
                local185.aBoolean712 = false;
                Static409.anIntArray494[Static51.anInt1053++] = local151;
                Static402.aByteArray68[local151] = 0;
            }
        }
        arg0.method7411();
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(I[B)Lclient!st;")
    public static Sprite method2634(@OriginalArg(1) byte[] data) {
        if (data == null) {
            throw new RuntimeException("");
        }

        while (true) {
            try {
                @Pc(22) Image image = Toolkit.getDefaultToolkit().createImage(data);
                @Pc(27) MediaTracker tracker = new MediaTracker(client.aClient1);
                tracker.addImage(image, 0);
                tracker.waitForAll();
                @Pc(37) int width = image.getWidth(client.aClient1);
                @Pc(41) int height = image.getHeight(client.aClient1);
                if (!tracker.isErrorAny() && width >= 0 && height >= 0) {
                    @Pc(66) int[] pixels = new int[height * width];
                    @Pc(78) PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
                    grabber.grabPixels();
                    return Static163.activeToolkit.createSprite(width, width, height, pixels);
                }
                throw new RuntimeException("");
            } catch (@Pc(91) InterruptedException local91) {
            }
        }
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(BIIZIZI)V")
    public static void method2636(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) boolean arg2, @OriginalArg(4) int arg3, @OriginalArg(5) boolean arg4, @OriginalArg(6) int arg5) {
        if (arg0 <= arg1) {
            return;
        }
        @Pc(13) int local13 = (arg1 + arg0) / 2;
        @Pc(15) int local15 = arg1;
        @Pc(19) Class297_Sub1 local19 = Static343.aClass297_Sub1Array2[local13];
        Static343.aClass297_Sub1Array2[local13] = Static343.aClass297_Sub1Array2[arg0];
        Static343.aClass297_Sub1Array2[arg0] = local19;
        for (@Pc(31) int local31 = arg1; local31 < arg0; local31++) {
            if (Static639.method8418(local19, arg3, arg5, arg4, 70, Static343.aClass297_Sub1Array2[local31], arg2) <= 0) {
                @Pc(47) Class297_Sub1 local47 = Static343.aClass297_Sub1Array2[local31];
                Static343.aClass297_Sub1Array2[local31] = Static343.aClass297_Sub1Array2[local15];
                Static343.aClass297_Sub1Array2[local15++] = local47;
            }
        }
        Static343.aClass297_Sub1Array2[arg0] = Static343.aClass297_Sub1Array2[local15];
        Static343.aClass297_Sub1Array2[local15] = local19;
        method2636(local15 - 1, arg1, arg2, arg3, arg4, arg5);
        method2636(arg0, local15 + 1, arg2, arg3, arg4, arg5);
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(IBIIIII)V")
    public static void method2637(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        if (Static180.anInt2995 <= arg5 && Static111.anInt2219 >= arg3 && Static724.anInt10930 <= arg4 && Static273.anInt4395 >= arg0) {
            if (arg2 == 1) {
                Static175.method2701(arg0, arg4, arg1, arg3, arg5);
            } else {
                Static548.method7253(arg1, arg5, arg3, arg0, arg2, arg4);
            }
        } else if (arg2 == 1) {
            Static385.method5420(arg0, arg5, arg1, arg3, arg4);
        } else {
            Static249.method3535(arg2, arg4, arg3, arg0, arg5, arg1);
        }
    }
}
