import com.jagex.Entity;
import com.jagex.core.constants.MaxScreenSize;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static468 {

    @OriginalMember(owner = "client!op", name = "l", descriptor = "[Lclient!eo;")
    public static Entity[] dynamicEntities;

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(ZIII)V")
    public static void updateObjCount(@OriginalArg(1) int level, @OriginalArg(3) int zoneX, @OriginalArg(2) int zoneZ) {
        @Pc(8) int x = zoneX + WorldMap.areaBaseX;
        @Pc(12) int z = zoneZ + WorldMap.areaBaseZ;

        if (Static334.activeTiles == null || zoneX < 0 || zoneZ < 0 || zoneX >= Static720.mapWidth || Static501.mapLength <= zoneZ || ClientOptions.instance.animateBackground.getValue() == 0 && level != PlayerEntity.self.level) {
            return;
        }

        @Pc(67) long key = (level << 28) | (z << 14) | x;
        @Pc(73) ObjStack stack = (ObjStack) Static497.objStacks.get(key);
        if (stack == null) {
            Static638.method8398(level, zoneX, zoneZ);
            return;
        }

        @Pc(88) ObjStackEntry firstEntry = (ObjStackEntry) stack.objs.first();
        if (firstEntry == null) {
            Static638.method8398(level, zoneX, zoneZ);
            return;
        }

        @Pc(103) ObjStackEntity entity = (ObjStackEntity) Static638.method8398(level, zoneX, zoneZ);
        if (entity == null) {
            entity = new ObjStackEntity(zoneX << 9, Static246.ground[level].getHeight(zoneX, zoneZ), zoneZ << 9, level, level);
        } else {
            entity.secondId = entity.thirdId = -1;
        }

        entity.firstCount = firstEntry.count;
        entity.firstId = firstEntry.id;

        label56:
        while (true) {
            @Pc(146) ObjStackEntry secondEntry = (ObjStackEntry) stack.objs.next();
            if (secondEntry == null) {
                break;
            }

            if (secondEntry.id != entity.firstId) {
                entity.secondCount = secondEntry.count;
                entity.secondId = secondEntry.id;

                while (true) {
                    @Pc(171) ObjStackEntry thirdEntry = (ObjStackEntry) stack.objs.next();
                    if (thirdEntry == null) {
                        break label56;
                    }

                    if (entity.firstId != thirdEntry.id && thirdEntry.id != entity.secondId) {
                        entity.thirdCount = thirdEntry.count;
                        entity.thirdId = thirdEntry.id;
                    }
                }
            }
        }

        @Pc(209) int averageHeight = Static102.averageHeight(level, (zoneX << 9) - -256, (zoneZ << 9) + 256);
        entity.level = (byte) level;
        entity.y = averageHeight;
        entity.virtualLevel = (byte) level;
        entity.z = zoneZ << 9;
        entity.anInt8885 = 0;
        entity.x = zoneX << 9;

        if (Static441.isBridgeAt(zoneZ, zoneX)) {
            entity.virtualLevel++;
        }

        Static157.method2564(level, zoneX, zoneZ, averageHeight, entity);
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
        ClientOptions.instance.update(MaxScreenSize._800x600, ClientOptions.instance.maxScreenSize);
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
