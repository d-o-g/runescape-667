import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static468 {

    @OriginalMember(owner = "client!op", name = "l", descriptor = "[Lclient!eo;")
    public static Class8_Sub2[] aClass8_Sub2Array10;

    @OriginalMember(owner = "client!op", name = "r", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_212 = new Class225(77, -2);

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(ZIII)V")
    public static void method7641(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(8) int local8 = arg2 + Static691.anInt10367;
        @Pc(12) int local12 = Static116.anInt2270 + arg1;
        if (Static334.aClass291ArrayArrayArray1 == null || arg2 < 0 || arg1 < 0 || arg2 >= Static720.mapWidth || Static501.mapHeight <= arg1 || Static400.instance.aClass57_Sub19_2.method5960() == 0 && arg0 != Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aByte144) {
            return;
        }
        @Pc(67) long local67 = (long) (local12 << 14 | arg0 << 28 | local8);
        @Pc(73) ObjStack local73 = (ObjStack) Static497.stacks.get(local67);
        if (local73 == null) {
            Static638.method8398(arg0, arg2, arg1);
            return;
        }
        @Pc(88) ObjStackEntry local88 = (ObjStackEntry) local73.objs.first();
        if (local88 == null) {
            Static638.method8398(arg0, arg2, arg1);
            return;
        }
        @Pc(103) Class8_Sub2_Sub5_Sub1 local103 = (Class8_Sub2_Sub5_Sub1) Static638.method8398(arg0, arg2, arg1);
        if (local103 == null) {
            local103 = new Class8_Sub2_Sub5_Sub1(arg2 << 9, Static246.aGroundArray1[arg0].method7869(arg1, arg2), arg1 << 9, arg0, arg0);
        } else {
            local103.anInt8878 = local103.anInt8876 = -1;
        }
        local103.anInt8873 = local88.count;
        local103.anInt8867 = local88.id;
        label56:
        while (true) {
            @Pc(146) ObjStackEntry local146 = (ObjStackEntry) local73.objs.next();
            if (local146 == null) {
                break;
            }
            if (local146.id != local103.anInt8867) {
                local103.anInt8874 = local146.count;
                local103.anInt8878 = local146.id;
                while (true) {
                    @Pc(171) ObjStackEntry local171 = (ObjStackEntry) local73.objs.next();
                    if (local171 == null) {
                        break label56;
                    }
                    if (local103.anInt8867 != local171.id && local171.id != local103.anInt8878) {
                        local103.anInt8872 = local171.count;
                        local103.anInt8876 = local171.id;
                    }
                }
            }
        }
        @Pc(209) int local209 = Static102.method2025(arg0, -29754, (arg1 << 9) + 256, (arg2 << 9) - -256);
        local103.aByte144 = (byte) arg0;
        local103.anInt10691 = local209;
        local103.aByte143 = (byte) arg0;
        local103.anInt10694 = arg1 << 9;
        local103.anInt8885 = 0;
        local103.anInt10690 = arg2 << 9;
        if (Static441.method5968(arg1, arg2)) {
            local103.aByte143++;
        }
        Static157.method2564(arg0, arg2, arg1, local209, local103);
    }

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(ZZ)V")
    public static void method7643() {
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub19_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub19_2);
        Static400.instance.method5104(1, Static400.instance.aClass57_Sub4_1);
        Static400.instance.method5104(1, Static400.instance.aClass57_Sub4_2);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub6_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub16_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub23_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub27_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub8_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub7_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub12_1);
        Static400.instance.method5104(0, Static400.instance.textures);
        Static400.instance.method5104(0, Static400.instance.lightDetail);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub26_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub13_2);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub13_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub28_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub5_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub20_1);
        Static400.instance.method5104(0, Static400.instance.aClass57_Sub2_1);
        Static376.method5313();
        Static400.instance.method5104(2, Static400.instance.aClass57_Sub18_1);
        Static400.instance.method5104(1, Static400.instance.aClass57_Sub15_1);
        Static296.updateFeatureMask();
        Static218.method3187();
        Static284.aBoolean355 = true;
    }

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(BLclient!eba;)I")
    public static int method7644(@OriginalArg(1) Class92 arg0) {
        if (arg0 == Static685.aClass92_16) {
            return 6407;
        } else if (arg0 == Static172.aClass92_8) {
            return 6408;
        } else if (arg0 == Static679.aClass92_15) {
            return 6406;
        } else if (arg0 == Static661.aClass92_10) {
            return 6409;
        } else if (arg0 == Static482.aClass92_13) {
            return 6410;
        } else if (arg0 == Static42.aClass92_3) {
            return 6145;
        } else {
            throw new IllegalStateException();
        }
    }

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(IIB)I")
    public static int method7648(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        arg1 = (arg0 & 0x7F) * arg1 >> 7;
        if (arg1 < 2) {
            arg1 = 2;
        } else if (arg1 > 126) {
            arg1 = 126;
        }
        return (arg0 & 0xFF80) + arg1;
    }
}
