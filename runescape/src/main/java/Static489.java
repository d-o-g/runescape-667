import com.jagex.DisplayProperties;
import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Frame;

public final class Static489 {

    @OriginalMember(owner = "client!ph", name = "K", descriptor = "I")
    public static int anInt7343;

    @OriginalMember(owner = "client!ph", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___185 = new ServerProt(8, 6);

    @OriginalMember(owner = "client!ph", name = "a", descriptor = "(ILclient!vq;IIII)Ljava/awt/Frame;")
    public static Frame createFullscreenFrame(@OriginalArg(1) SignLink signlink, @OriginalArg(4) int width, @OriginalArg(3) int height, @OriginalArg(0) int oldWidth, @OriginalArg(2) int oldHeight) {
        if (!signlink.supportsFullscreen()) {
            return null;
        }

        @Pc(18) DisplayProperties[] properties = SignLink.getDisplayProperties(signlink, true);
        if (properties == null) {
            return null;
        }

        @Pc(25) boolean found = false;
        for (@Pc(27) int i = 0; i < properties.length; i++) {
            if (properties[i].width == width && properties[i].height == height && (oldHeight == 0 || oldHeight == properties[i].oldHeight) && (!found || properties[i].oldWidth > oldWidth)) {
                found = true;
                oldWidth = properties[i].oldWidth;
            }
        }

        if (!found) {
            return null;
        }

        @Pc(101) SignedResource resource = signlink.enterFullscreen(width, height, oldWidth, oldHeight);
        while (resource.status == 0) {
            TimeUtils.sleep(10L);
        }

        @Pc(112) Frame local112 = (Frame) resource.result;
        if (local112 == null) {
            return null;
        } else if (resource.status == 2) {
            Static655.method8562(signlink, local112);
            return null;
        } else {
            return local112;
        }
    }

    @OriginalMember(owner = "client!ph", name = "a", descriptor = "(ZBLclient!cg;)V")
    public static void method6547(@OriginalArg(0) boolean arg0, @OriginalArg(2) PathingEntity arg1) {
        @Pc(7) int local7 = -1;
        @Pc(16) int local16 = 0;
        if (arg1.exactMoveT1 > TimeUtils.clock) {
            Static441.method5967(arg1);
        } else if (TimeUtils.clock > arg1.exactMoveT2) {
            Static256.method3638(arg1, arg0);
            local7 = Static521.anInt7756;
            local16 = Static524.anInt8042;
        } else {
            Static354.method5181(arg1);
        }
        @Pc(107) int local107;
        if (arg1.x < 512 || arg1.z < 512 || Static720.mapWidth * 512 - 512 <= arg1.x || arg1.z >= Static501.mapHeight * 512 - 512) {
            arg1.actionAnimator.update(true, -1);
            for (local107 = 0; local107 < arg1.spotAnims.length; local107++) {
                arg1.spotAnims[local107].id = -1;
                arg1.spotAnims[local107].animator.update(true, -1);
            }
            arg1.exactMoveT1 = 0;
            local7 = -1;
            arg1.exactMoveT2 = 0;
            arg1.actionAnimations = null;
            local16 = 0;
            arg1.x = arg1.pathX[0] * 512 + arg1.getSize() * 256;
            arg1.z = arg1.pathZ[0] * 512 + arg1.getSize() * 256;
            arg1.method9316();
        }
        if (arg1 == PlayerEntity.self && (arg1.x < 6144 || arg1.z < 6144 || arg1.x >= Static720.mapWidth * 512 - 6144 || Static501.mapHeight * 512 - 6144 <= arg1.z)) {
            arg1.actionAnimator.update(true, -1);
            for (local107 = 0; local107 < arg1.spotAnims.length; local107++) {
                arg1.spotAnims[local107].id = -1;
                arg1.spotAnims[local107].animator.update(true, -1);
            }
            arg1.exactMoveT1 = 0;
            arg1.exactMoveT2 = 0;
            arg1.actionAnimations = null;
            local16 = 0;
            local7 = -1;
            arg1.x = arg1.pathX[0] * 512 + arg1.getSize() * 256;
            arg1.z = arg1.pathZ[0] * 512 + arg1.getSize() * 256;
            arg1.method9316();
        }
        local107 = Static112.method2104(arg1);
        Static145.method2410(arg1);
        Static651.method8513(local7, local107, local16, arg1);
        Static702.method9166(arg1, local7);
        Static50.method6638(arg1);
    }

    @OriginalMember(owner = "client!ph", name = "d", descriptor = "(I)V")
    public static void method6548() {
        Static314.noTimeout(false);
        Static593.anInt8763 = 0;
        @Pc(10) boolean local10 = true;
        for (@Pc(12) int local12 = 0; local12 < Static319.aByteArrayArray16.length; local12++) {
            if (Static267.anIntArray329[local12] != -1 && Static319.aByteArrayArray16[local12] == null) {
                Static319.aByteArrayArray16[local12] = js5.MAPS.getfile(0, Static267.anIntArray329[local12]);
                if (Static319.aByteArrayArray16[local12] == null) {
                    Static593.anInt8763++;
                    local10 = false;
                }
            }
            if (Static266.anIntArray615[local12] != -1 && Static118.aByteArrayArray3[local12] == null) {
                Static118.aByteArrayArray3[local12] = js5.MAPS.getfile(Static22.anIntArrayArray11[local12], 0, Static266.anIntArray615[local12]);
                if (Static118.aByteArrayArray3[local12] == null) {
                    local10 = false;
                    Static593.anInt8763++;
                }
            }
            if (Static68.anIntArray316[local12] != -1 && Static177.aByteArrayArray5[local12] == null) {
                Static177.aByteArrayArray5[local12] = js5.MAPS.getfile(0, Static68.anIntArray316[local12]);
                if (Static177.aByteArrayArray5[local12] == null) {
                    Static593.anInt8763++;
                    local10 = false;
                }
            }
            if (Static298.anIntArray367[local12] != -1 && Static421.aByteArrayArray19[local12] == null) {
                Static421.aByteArrayArray19[local12] = js5.MAPS.getfile(0, Static298.anIntArray367[local12]);
                if (Static421.aByteArrayArray19[local12] == null) {
                    Static593.anInt8763++;
                    local10 = false;
                }
            }
            if (Static376.anIntArray458 != null && Static363.aByteArrayArray22[local12] == null && Static376.anIntArray458[local12] != -1) {
                Static363.aByteArrayArray22[local12] = js5.MAPS.getfile(Static22.anIntArrayArray11[local12], 0, Static376.anIntArray458[local12]);
                if (Static363.aByteArrayArray22[local12] == null) {
                    Static593.anInt8763++;
                    local10 = false;
                }
            }
        }
        if (Static42.aMapElementList_2 == null) {
            if (Static162.aClass2_Sub2_Sub13_2 == null || !js5.WORLDMAPDATA.groupExists(Static162.aClass2_Sub2_Sub13_2.file + "_staticelements")) {
                Static42.aMapElementList_2 = new MapElementList(0);
            } else if (js5.WORLDMAPDATA.requestgroupdownload(Static162.aClass2_Sub2_Sub13_2.file + "_staticelements")) {
                Static42.aMapElementList_2 = MapElementList.load(Static174.mapMembers, js5.WORLDMAPDATA, Static162.aClass2_Sub2_Sub13_2.file + "_staticelements");
            } else {
                local10 = false;
                Static593.anInt8763++;
            }
        }
        if (!local10) {
            Static213.anInt3472 = 1;
            return;
        }
        local10 = true;
        Static13.anInt150 = 0;
        @Pc(310) int local310;
        for (@Pc(282) int local282 = 0; local282 < Static319.aByteArrayArray16.length; local282++) {
            @Pc(287) byte[] local287 = Static118.aByteArrayArray3[local282];
            @Pc(299) int local299;
            if (local287 != null) {
                local299 = (Static89.anIntArray169[local282] >> 8) * 64 - WorldMap.areaBaseX;
                local310 = (Static89.anIntArray169[local282] & 0xFF) * 64 - WorldMap.areaBaseZ;
                if (Static117.anInt2282 != 0) {
                    local299 = 10;
                    local310 = 10;
                }
                local10 &= Static213.method3141(local287, local299, Static720.mapWidth, local310, Static501.mapHeight);
            }
            local287 = Static421.aByteArrayArray19[local282];
            if (local287 != null) {
                local299 = (Static89.anIntArray169[local282] >> 8) * 64 - WorldMap.areaBaseX;
                local310 = (Static89.anIntArray169[local282] & 0xFF) * 64 - WorldMap.areaBaseZ;
                if (Static117.anInt2282 != 0) {
                    local310 = 10;
                    local299 = 10;
                }
                local10 &= Static213.method3141(local287, local299, Static720.mapWidth, local310, Static501.mapHeight);
            }
        }
        if (!local10) {
            Static213.anInt3472 = 2;
            return;
        }
        if (Static213.anInt3472 != 0) {
            Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(client.language) + "<br>(100%)", true, Fonts.p12Metrics, Fonts.p12);
        }
        Static557.method7331();
        Static352.cacheReset();
        VideoManager.stop();
        @Pc(430) boolean local430 = false;
        if (Toolkit.active.method7990() && ClientOptions.instance.waterDetail.getValue() == 2) {
            for (local310 = 0; local310 < Static319.aByteArrayArray16.length; local310++) {
                if (Static421.aByteArrayArray19[local310] != null || Static177.aByteArrayArray5[local310] != null) {
                    local430 = true;
                    break;
                }
            }
        }
        if (ClientOptions.instance.fog.getValue() == 1) {
            local310 = Static571.anIntArray682[Static537.anInt8170];
        } else {
            local310 = Static506.anIntArray728[Static537.anInt8170];
        }
        if (Toolkit.active.method7968()) {
            local310++;
        }
        Static21.method8043(Toolkit.active, Static455.anInt6915, Static720.mapWidth, Static501.mapHeight, local310, local430, Toolkit.active.getMaxLights() > 0);
        Static483.method6490(Static699.w2Debug);
        if (Static699.w2Debug == 0) {
            Static110.method2082(null);
        } else {
            Static110.method2082(Fonts.p11);
        }
        for (@Pc(519) int local519 = 0; local519 < 4; local519++) {
            Static577.A_COLLISION_MAP_ARRAY_1[local519].method2467();
        }
        Static305.method4441();
        Static609.method8213(false);
        Static508.method6750();
        Static112.aBoolean197 = false;
        Static557.method7331();
        System.gc();
        Static314.noTimeout(true);
        Static699.method9139();
        Static439.anInt6674 = ClientOptions.instance.hardShadows.getValue();
        Static428.aBoolean487 = GameShell.maxmemory >= 96;
        Static50.aBoolean566 = ClientOptions.instance.waterDetail.getValue() == 2;
        Static305.aBoolean371 = ClientOptions.instance.lightDetail.getValue() == 1;
        Static478.anInt7198 = ClientOptions.instance.animateBackground.getValue() == 1 ? -1 : Static164.areaLevel;
        Static718.aBoolean822 = ClientOptions.instance.groundBlending.getValue() == 1;
        Static196.aBoolean262 = ClientOptions.instance.textures.getValue() == 1;
        Static2.aMapRegion = new MapRegion(4, Static720.mapWidth, Static501.mapHeight, false);
        if (Static117.anInt2282 == 0) {
            Static73.method9312(Static319.aByteArrayArray16, Static2.aMapRegion);
        } else {
            Static693.method9010(Static319.aByteArrayArray16, Static2.aMapRegion);
        }
        Static92.method1757(Static720.mapWidth >> 4, Static501.mapHeight >> 4);
        Static159.method2575();
        if (local430) {
            Static379.method5355(true);
            Static134.aMapRegion_3 = new MapRegion(1, Static720.mapWidth, Static501.mapHeight, true);
            if (Static117.anInt2282 == 0) {
                Static73.method9312(Static177.aByteArrayArray5, Static134.aMapRegion_3);
                Static314.noTimeout(true);
            } else {
                Static693.method9010(Static177.aByteArrayArray5, Static134.aMapRegion_3);
                Static314.noTimeout(true);
            }
            Static134.aMapRegion_3.method7885(Static2.aMapRegion.tileHeights[0]);
            Static134.aMapRegion_3.method7881(null, Toolkit.active, null);
            Static379.method5355(false);
        }
        Static2.aMapRegion.method7881(local430 ? Static134.aMapRegion_3.tileHeights : null, Toolkit.active, Static577.A_COLLISION_MAP_ARRAY_1);
        if (Static117.anInt2282 == 0) {
            Static314.noTimeout(true);
            Static338.method4994(Static118.aByteArrayArray3, Static2.aMapRegion);
            if (Static363.aByteArrayArray22 != null) {
                Static369.method3847();
            }
        } else {
            Static314.noTimeout(true);
            Static101.method2001(Static118.aByteArrayArray3, Static2.aMapRegion);
        }
        Static352.cacheReset();
        if (GameShell.maxmemory < 96) {
            Static358.method9191();
        }
        Static314.noTimeout(true);
        Static2.aMapRegion.method7888(Toolkit.active, local430 ? Static693.underwaterGround[0] : null, null);
        Static2.aMapRegion.method7898(false, Toolkit.active);
        Static314.noTimeout(true);
        if (local430) {
            Static379.method5355(true);
            Static314.noTimeout(true);
            if (Static117.anInt2282 == 0) {
                Static338.method4994(Static421.aByteArrayArray19, Static134.aMapRegion_3);
            } else {
                Static101.method2001(Static421.aByteArrayArray19, Static134.aMapRegion_3);
            }
            Static352.cacheReset();
            Static314.noTimeout(true);
            Static134.aMapRegion_3.method7888(Toolkit.active, null, Static706.floor[0]);
            Static134.aMapRegion_3.method7898(true, Toolkit.active);
            Static314.noTimeout(true);
            Static379.method5355(false);
        }
        Static207.method4432();
        @Pc(825) int local825 = Static2.aMapRegion.maxLevel;
        if (local825 > Camera.renderingLevel) {
            local825 = Camera.renderingLevel;
        }
        if (Camera.renderingLevel - 1 > local825) {
            local825 = Camera.renderingLevel - 1;
        }
        if (ClientOptions.instance.animateBackground.getValue() == 0) {
            Static3.method87(local825);
        } else {
            Static3.method87(0);
        }
        @Pc(855) int local855;
        @Pc(858) int local858;
        for (@Pc(852) int local852 = 0; local852 < 4; local852++) {
            for (local855 = 0; local855 < Static720.mapWidth; local855++) {
                for (local858 = 0; local858 < Static501.mapHeight; local858++) {
                    Static468.updateObjCount(local852, local858, local855);
                }
            }
        }
        Static77.method1561();
        Static557.method7331();
        Static197.method2949();
        Static352.cacheReset();
        Static442.method5969();
        @Pc(920) ClientMessage local920;
        if (GameShell.frame != null && ConnectionManager.GAME.connection != null && MainLogicManager.step == 12) {
            local920 = ClientMessage.create(Static694.A_CLIENT_PROT___122, ConnectionManager.GAME.cipher);
            local920.buffer.p4(1057001181);
            ConnectionManager.GAME.send(local920);
        }
        if (Static117.anInt2282 == 0) {
            local855 = (Static62.anInt1465 - (Static720.mapWidth >> 4)) / 8;
            local858 = (Static62.anInt1465 + (Static720.mapWidth >> 4)) / 8;
            @Pc(961) int local961 = (Static525.anInt8907 - (Static501.mapHeight >> 4)) / 8;
            @Pc(969) int local969 = ((Static501.mapHeight >> 4) + Static525.anInt8907) / 8;
            for (@Pc(973) int local973 = local855 - 1; local973 <= local858 + 1; local973++) {
                for (@Pc(978) int local978 = local961 - 1; local978 <= local969 + 1; local978++) {
                    if (local973 < local855 || local973 > local858 || local978 < local961 || local969 < local978) {
                        js5.MAPS.requestGroup("m" + local973 + "_" + local978);
                        js5.MAPS.requestGroup("l" + local973 + "_" + local978);
                    }
                }
            }
        }
        if (MainLogicManager.step == 4) {
            MainLogicManager.setStep(3);
        } else if (MainLogicManager.step == 8) {
            MainLogicManager.setStep(7);
        } else if (MainLogicManager.step == 10) {
            MainLogicManager.setStep(9);
        } else {
            MainLogicManager.setStep(11);
            if (ConnectionManager.GAME.connection != null) {
                local920 = ClientMessage.create(Static161.A_CLIENT_PROT___29, ConnectionManager.GAME.cipher);
                ConnectionManager.GAME.send(local920);
            }
        }
        Static606.method7934();
        Static557.method7331();
        Static199.doneslowupdate();
        Static75.hasOpaqueStationaryEntities = true;
        if (Static28.aBoolean43) {
            debugconsole.addline("Took: " + (SystemTimer.safetime() - Static690.aLong318) + "ms");
            Static28.aBoolean43 = false;
        }
    }
}
