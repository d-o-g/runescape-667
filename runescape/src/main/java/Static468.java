import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static468 {

    @OriginalMember(owner = "client!op", name = "l", descriptor = "[Lclient!eo;")
    public static Entity[] aEntityArray10;

    @OriginalMember(owner = "client!op", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___212 = new ServerProt(77, -2);

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(ZIII)V")
    public static void method7641(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(8) int local8 = arg2 + WorldMap.areaBaseX;
        @Pc(12) int local12 = WorldMap.areaBaseZ + arg1;
        if (Static334.activeTiles == null || arg2 < 0 || arg1 < 0 || arg2 >= Static720.mapWidth || Static501.mapHeight <= arg1 || ClientOptions.instance.animateBackground.getValue() == 0 && arg0 != PlayerEntity.self.level) {
            return;
        }
        @Pc(67) long local67 = local12 << 14 | arg0 << 28 | local8;
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
            local103 = new Class8_Sub2_Sub5_Sub1(arg2 << 9, Static246.activeGround[arg0].getHeight(arg1, arg2), arg1 << 9, arg0, arg0);
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
        local103.level = (byte) arg0;
        local103.anInt10691 = local209;
        local103.virtualLevel = (byte) arg0;
        local103.z = arg1 << 9;
        local103.anInt8885 = 0;
        local103.x = arg2 << 9;
        if (Static441.isBridgeAt(arg1, arg2)) {
            local103.virtualLevel++;
        }
        Static157.method2564(arg0, arg2, arg1, local209, local103);
    }

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(ZZ)V")
    public static void method7643() {
        ClientOptions.instance.update(0, ClientOptions.instance.animateBackgroundDefault);
        ClientOptions.instance.update(0, ClientOptions.instance.animateBackground);
        ClientOptions.instance.update(1, ClientOptions.instance.removeRoofs);
        ClientOptions.instance.update(1, ClientOptions.instance.removeRoofsOverride);
        ClientOptions.instance.update(0, ClientOptions.instance.groundDecor);
        ClientOptions.instance.update(0, ClientOptions.instance.fog);
        ClientOptions.instance.update(0, ClientOptions.instance.groundBlending);
        ClientOptions.instance.update(0, ClientOptions.instance.idleAnimations);
        ClientOptions.instance.update(0, ClientOptions.instance.flickeringEffects);
        ClientOptions.instance.update(0, ClientOptions.instance.spotShadows);
        ClientOptions.instance.update(0, ClientOptions.instance.hardShadows);
        ClientOptions.instance.update(0, ClientOptions.instance.textures);
        ClientOptions.instance.update(0, ClientOptions.instance.lightDetail);
        ClientOptions.instance.update(0, ClientOptions.instance.waterDetail);
        ClientOptions.instance.update(0, ClientOptions.instance.antialiasingMode);
        ClientOptions.instance.update(0, ClientOptions.instance.antialiasingQuality);
        ClientOptions.instance.update(0, ClientOptions.instance.particles);
        ClientOptions.instance.update(0, ClientOptions.instance.buildArea);
        ClientOptions.instance.update(0, ClientOptions.instance.bloom);
        ClientOptions.instance.update(0, ClientOptions.instance.skydetail);
        Static376.method5313();
        ClientOptions.instance.update(2, ClientOptions.instance.maxScreenSize);
        ClientOptions.instance.update(1, ClientOptions.instance.graphicsQuality);
        Static296.updateFeatureMask();
        InterfaceManager.loginOpened();
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
