import com.jagex.ChangeLocationRequest;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static684 {

    @OriginalMember(owner = "client!vla", name = "k", descriptor = "Z")
    public static boolean aBoolean775;

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "[Lclient!qe;")
    public static Class302[] aClass302Array1;

    @OriginalMember(owner = "client!vla", name = "i", descriptor = "I")
    public static int anInt10304 = 0;

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(ZIIIB)V")
    public static void method8931(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int mainLogicStep, @OriginalArg(3) int arg3) {
        if (CutsceneManager.state == 4) {
            CutsceneManager.state = 0;
            Static717.anInt10817 = -1;
        }
        if (!arg0 && Static62.anInt1465 == arg1 && Static525.anInt8907 == arg3 && (Static164.areaLevel == Static394.anInt6176 || Static400.instance.animatingBackground.value() == 1)) {
            return;
        }
        Static525.anInt8907 = arg3;
        Static62.anInt1465 = arg1;
        Static164.areaLevel = Static394.anInt6176;
        if (Static400.instance.animatingBackground.value() == 1) {
            Static164.areaLevel = 0;
        }
        MainLogicManager.setStep(mainLogicStep);
        Static694.method9028(Toolkit.active, LocalisedText.LOADING.localise(Static51.language), true, Fonts.p12Metrics, Fonts.p12);
        @Pc(74) int local74 = Static691.areaBaseX;
        Static691.areaBaseX = (Static62.anInt1465 - (Static720.mapWidth >> 4)) * 8;
        @Pc(85) int local85 = Static116.areaBaseY;
        Static116.areaBaseY = (Static525.anInt8907 - (Static501.mapHeight >> 4)) * 8;
        Static162.aClass2_Sub2_Sub13_2 = Static30.method5078(Static62.anInt1465 * 8, Static525.anInt8907 * 8);
        Static42.aClass255_2 = null;
        @Pc(109) int deltaX = Static691.areaBaseX - local74;
        @Pc(113) int deltaY = Static116.areaBaseY - local85;
        @Pc(134) int local134;
        @Pc(136) int local136;
        @Pc(193) int local193;
        @Pc(308) int local308;
        if (mainLogicStep == 12) {
            for (local308 = 0; local308 < Static416.anInt6378; local308++) {
                @Pc(313) Node_Sub45 local313 = Static592.aClass2_Sub45Array1[local308];
                if (local313 != null) {
                    @Pc(318) NPCEntity local318 = local313.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                    for (local136 = 0; local136 < local318.pathX.length; local136++) {
                        local318.pathX[local136] -= deltaX;
                        local318.pathY[local136] -= deltaY;
                    }
                    local318.anInt10690 -= deltaX * 512;
                    local318.anInt10694 -= deltaY * 512;
                }
            }
        } else {
            @Pc(120) boolean local120 = false;
            Static390.anInt6126 = 0;
            @Pc(128) int local128 = (Static720.mapWidth - 1) * 512;
            local134 = Static501.mapHeight * 512 - 512;
            for (local136 = 0; local136 < Static416.anInt6378; local136++) {
                @Pc(141) Node_Sub45 local141 = Static592.aClass2_Sub45Array1[local136];
                if (local141 != null) {
                    @Pc(146) NPCEntity local146 = local141.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                    local146.anInt10694 -= deltaY * 512;
                    local146.anInt10690 -= deltaX * 512;
                    if (local146.anInt10690 >= 0 && local128 >= local146.anInt10690 && local146.anInt10694 >= 0 && local134 >= local146.anInt10694) {
                        @Pc(191) boolean local191 = true;
                        for (local193 = 0; local193 < local146.pathX.length; local193++) {
                            local146.pathX[local193] -= deltaX;
                            local146.pathY[local193] -= deltaY;
                            if (local146.pathX[local193] < 0 || local146.pathX[local193] >= Static720.mapWidth || local146.pathY[local193] < 0 || Static501.mapHeight <= local146.pathY[local193]) {
                                local191 = false;
                            }
                        }
                        if (local191) {
                            Static103.anIntArray187[Static390.anInt6126++] = local146.anInt10740;
                        } else {
                            local146.method9328((NPCType) null);
                            local120 = true;
                            local141.unlink();
                        }
                    } else {
                        local146.method9328((NPCType) null);
                        local120 = true;
                        local141.unlink();
                    }
                }
            }
            if (local120) {
                Static416.anInt6378 = Static18.A_HASH_TABLE___2.size();
                Static18.A_HASH_TABLE___2.copyTo(Static592.aClass2_Sub45Array1);
            }
        }
        for (local308 = 0; local308 < 2048; local308++) {
            @Pc(389) PlayerEntity local389 = PlayerList.highResolutionPlayers[local308];
            if (local389 != null) {
                for (local134 = 0; local134 < local389.pathX.length; local134++) {
                    local389.pathX[local134] -= deltaX;
                    local389.pathY[local134] -= deltaY;
                }
                local389.anInt10694 -= deltaY * 512;
                local389.anInt10690 -= deltaX * 512;
            }
        }
        @Pc(446) Class254[] local446 = Static527.aClass254Array1;
        for (local134 = 0; local134 < local446.length; local134++) {
            @Pc(453) Class254 local453 = local446[local134];
            if (local453 != null) {
                local453.anInt6362 -= deltaY * 512;
                local453.anInt6369 -= deltaX * 512;
            }
        }
        @Pc(485) ChangeLocationRequest local485;
        for (local485 = (ChangeLocationRequest) Static159.aDeque_15.first(); local485 != null; local485 = (ChangeLocationRequest) Static159.aDeque_15.next()) {
            local485.anInt4016 -= deltaX;
            local485.anInt4006 -= deltaY;
            if (Static117.anInt2282 != 4 && (local485.anInt4016 < 0 || local485.anInt4006 < 0 || local485.anInt4016 >= Static720.mapWidth || local485.anInt4006 >= Static501.mapHeight)) {
                local485.unlink();
            }
        }
        for (local485 = (ChangeLocationRequest) Static227.aDeque_18.first(); local485 != null; local485 = (ChangeLocationRequest) Static227.aDeque_18.next()) {
            local485.anInt4006 -= deltaY;
            local485.anInt4016 -= deltaX;
            if (Static117.anInt2282 != 4 && (local485.anInt4016 < 0 || local485.anInt4006 < 0 || local485.anInt4016 >= Static720.mapWidth || local485.anInt4006 >= Static501.mapHeight)) {
                local485.unlink();
            }
        }
        if (Static117.anInt2282 != 4) {
            for (@Pc(608) ObjStack local608 = (ObjStack) Static497.stacks.first(); local608 != null; local608 = (ObjStack) Static497.stacks.next()) {
                @Pc(615) int local615 = (int) (local608.key & 0x3FFFL);
                @Pc(619) int local619 = local615 - Static691.areaBaseX;
                local193 = (int) (local608.key >> 14 & 0x3FFFL);
                @Pc(632) int local632 = local193 - Static116.areaBaseY;
                if (local619 < 0 || local632 < 0 || local619 >= Static720.mapWidth || local632 >= Static501.mapHeight) {
                    local608.unlink();
                }
            }
        }

        if (Minimap.flagX != 0) {
            Minimap.flagY -= deltaY;
            Minimap.flagX -= deltaX;
        }

        Static368.method5273();

        if (mainLogicStep != 12) {
            Static441.anInt6689 -= deltaX;
            Static121.anInt2333 -= deltaX;
            Static709.anInt10667 -= deltaY;
            Static110.anInt2186 -= deltaY * 512;
            Static170.anInt2864 -= deltaX * 512;
            Static12.anInt5741 -= deltaY;
            if (Math.abs(deltaX) > Static720.mapWidth || Math.abs(deltaY) > Static501.mapHeight) {
                Static218.method3187();
            }
        } else if (Static511.anInt7645 == 4) {
            Static433.anInt6262 -= deltaX * 512;
            Static38.anInt920 -= deltaY * 512;
            Static249.anInt4018 -= deltaY * 512;
            Static494.anInt7409 -= deltaX * 512;
        } else {
            Static693.anInt10383 = -1;
            Static692.anInt10376 = -1;
            Static511.anInt7645 = 1;
        }
        Static533.method7119();
        Static244.method3512();
        Static346.A_HASH_TABLE___29.clear();
        Static505.A_DEQUE___77.clear();
        Static422.A_ENTITY_LIST___9.clear();
        Static105.method2044();
    }
}
