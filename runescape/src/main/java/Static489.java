import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.core.constants.AreaMode;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static489 {

    @OriginalMember(owner = "client!ph", name = "a", descriptor = "(ZBLclient!cg;)V")
    public static void tick(@OriginalArg(0) boolean cutscene, @OriginalArg(2) PathingEntity entity) {
        @Pc(7) int local7 = -1;
        @Pc(16) int local16 = 0;

        if (entity.exactMoveT1 > TimeUtils.clock) {
            Static441.exactMoveTick1(entity);
        } else if (entity.exactMoveT2 >= TimeUtils.clock) {
            Static354.exactMoveTick2(entity);
        } else {
            Static256.movementTick(entity, cutscene);
            local7 = Static521.anInt7756;
            local16 = Static524.anInt8042;
        }

        if ((entity.x < 512) || (entity.z < 512) || (entity.x >= ((Static720.mapWidth * 512) - 512)) || (entity.z >= ((Static501.mapLength * 512) - 512))) {
            entity.actionAnimator.update(true, -1);
            for (@Pc(107) int local107 = 0; local107 < entity.spotAnims.length; local107++) {
                entity.spotAnims[local107].id = -1;
                entity.spotAnims[local107].animator.update(true, -1);
            }

            entity.exactMoveT1 = 0;
            local7 = -1;
            entity.exactMoveT2 = 0;
            entity.actionAnimations = null;
            local16 = 0;
            entity.x = entity.pathX[0] * 512 + entity.getSize() * 256;
            entity.z = entity.pathZ[0] * 512 + entity.getSize() * 256;
            entity.stopMoving();
        }

        if ((entity == PlayerEntity.self) && ((entity.x < 6144) || (entity.z < 6144) || (entity.x >= ((Static720.mapWidth * 512) - 6144)) || (((Static501.mapLength * 512) - 6144) <= entity.z))) {
            entity.actionAnimator.update(true, -1);
            for (@Pc(107) int local107 = 0; local107 < entity.spotAnims.length; local107++) {
                entity.spotAnims[local107].id = -1;
                entity.spotAnims[local107].animator.update(true, -1);
            }
            entity.exactMoveT1 = 0;
            entity.exactMoveT2 = 0;
            entity.actionAnimations = null;
            local16 = 0;
            local7 = -1;
            entity.x = entity.pathX[0] * 512 + entity.getSize() * 256;
            entity.z = entity.pathZ[0] * 512 + entity.getSize() * 256;
            entity.stopMoving();
        }

        @Pc(107) int deltaYaw = Static112.turnTick(entity);
        Static145.wornTargetTick(entity);
        Static651.basTick(local7, deltaYaw, local16, entity);
        Static702.updateActionAnimator(entity, local7);
        Static50.animationTick(entity);
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

        if (Minimap.elements == null) {
            if (Static162.aClass2_Sub2_Sub13_2 == null || !js5.WORLDMAPDATA.groupExists(Static162.aClass2_Sub2_Sub13_2.file + "_staticelements")) {
                Minimap.elements = new MapElementList(0);
            } else if (js5.WORLDMAPDATA.requestgroupdownload(Static162.aClass2_Sub2_Sub13_2.file + "_staticelements")) {
                Minimap.elements = MapElementList.load(Static174.mapMembers, js5.WORLDMAPDATA, Static162.aClass2_Sub2_Sub13_2.file + "_staticelements");
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
        for (@Pc(282) int local282 = 0; local282 < Static319.aByteArrayArray16.length; local282++) {
            @Pc(287) byte[] local287 = Static118.aByteArrayArray3[local282];
            @Pc(299) int local299;

            if (local287 != null) {
                local299 = (Static89.zoneIds[local282] >> 8) * 64 - WorldMap.areaBaseX;
                @Pc(310) int local310 = (Static89.zoneIds[local282] & 0xFF) * 64 - WorldMap.areaBaseZ;

                if (Static117.areaMode != AreaMode.STATIC_AREA) {
                    local299 = 10;
                    local310 = 10;
                }

                local10 &= Static213.method3141(local287, local299, Static720.mapWidth, local310, Static501.mapLength);
            }

            local287 = Static421.aByteArrayArray19[local282];
            if (local287 != null) {
                local299 = (Static89.zoneIds[local282] >> 8) * 64 - WorldMap.areaBaseX;
                @Pc(310) int local310 = (Static89.zoneIds[local282] & 0xFF) * 64 - WorldMap.areaBaseZ;

                if (Static117.areaMode != AreaMode.STATIC_AREA) {
                    local310 = 10;
                    local299 = 10;
                }

                local10 &= Static213.method3141(local287, local299, Static720.mapWidth, local310, Static501.mapLength);
            }
        }

        if (!local10) {
            Static213.anInt3472 = 2;
            return;
        }

        if (Static213.anInt3472 != 0) {
            Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(Client.language) + "<br>(100%)", true, Fonts.p12Metrics, Fonts.p12);
        }

        Static557.method7331();
        client.cacheReset();
        VideoManager.stop();

        @Pc(430) boolean local430 = false;
        if (Toolkit.active.method7990() && ClientOptions.instance.waterDetail.getValue() == 2) {
            for (@Pc(310) int local310 = 0; local310 < Static319.aByteArrayArray16.length; local310++) {
                if (Static421.aByteArrayArray19[local310] != null || Static177.aByteArrayArray5[local310] != null) {
                    local430 = true;
                    break;
                }
            }
        }

        @Pc(310) int renderDistance;
        if (ClientOptions.instance.fog.getValue() == 1) {
            renderDistance = Static571.FOG_RENDER_DISTANCE[Static537.buildArea];
        } else {
            renderDistance = Static506.RENDER_DISTANCE[Static537.buildArea];
        }
        if (Toolkit.active.increaseRenderDistance()) {
            renderDistance++;
        }

        Static21.method8043(Toolkit.active, Static455.anInt6915, Static720.mapWidth, Static501.mapLength, renderDistance, local430, Toolkit.active.getMaxLights() > 0);
        Static483.method6490(Static699.w2Debug);
        if (Static699.w2Debug != 0) {
            Fonts.setDebugFont(Fonts.p11);
        } else {
            Fonts.setDebugFont(null);
        }

        for (@Pc(519) int level = 0; level < 4; level++) {
            Client.collisionMaps[level].reset();
        }

        Static305.resetTileFlags();
        SoundManager.removeActiveStreams(false);
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
        MapRegion.active = new MapRegion(4, Static720.mapWidth, Static501.mapLength, false);
        if (Static117.areaMode == AreaMode.STATIC_AREA) {
            Static73.decodeStaticArea(Static319.aByteArrayArray16, MapRegion.active);
        } else {
            Static693.decodeDynamicArea(Static319.aByteArrayArray16, MapRegion.active);
        }
        Static92.method1757(Static720.mapWidth >> 4, Static501.mapLength >> 4);
        Static159.method2575();

        if (local430) {
            Static379.method5355(true);
            Static134.aMapRegion_3 = new MapRegion(1, Static720.mapWidth, Static501.mapLength, true);
            if (Static117.areaMode == AreaMode.STATIC_AREA) {
                Static73.decodeStaticArea(Static177.aByteArrayArray5, Static134.aMapRegion_3);
                Static314.noTimeout(true);
            } else {
                Static693.decodeDynamicArea(Static177.aByteArrayArray5, Static134.aMapRegion_3);
                Static314.noTimeout(true);
            }
            Static134.aMapRegion_3.method7885(MapRegion.active.tileHeights[0]);
            Static134.aMapRegion_3.method7881(null, Toolkit.active, null);
            Static379.method5355(false);
        }

        MapRegion.active.method7881(local430 ? Static134.aMapRegion_3.tileHeights : null, Toolkit.active, Client.collisionMaps);
        if (Static117.areaMode == AreaMode.STATIC_AREA) {
            Static314.noTimeout(true);
            Static338.method4994(Static118.aByteArrayArray3, MapRegion.active);
            if (Static363.aByteArrayArray22 != null) {
                Static369.method3847();
            }
        } else {
            Static314.noTimeout(true);
            Static101.method2001(Static118.aByteArrayArray3, MapRegion.active);
        }
        client.cacheReset();
        if (GameShell.maxmemory < 96) {
            Static358.method9191();
        }
        Static314.noTimeout(true);
        MapRegion.active.method7888(Toolkit.active, local430 ? Static693.underwaterGround[0] : null, null);
        MapRegion.active.method7898(false, Toolkit.active);
        Static314.noTimeout(true);
        if (local430) {
            Static379.method5355(true);
            Static314.noTimeout(true);
            if (Static117.areaMode == AreaMode.STATIC_AREA) {
                Static338.method4994(Static421.aByteArrayArray19, Static134.aMapRegion_3);
            } else {
                Static101.method2001(Static421.aByteArrayArray19, Static134.aMapRegion_3);
            }
            client.cacheReset();
            Static314.noTimeout(true);
            Static134.aMapRegion_3.method7888(Toolkit.active, null, Static706.floor[0]);
            Static134.aMapRegion_3.method7898(true, Toolkit.active);
            Static314.noTimeout(true);
            Static379.method5355(false);
        }
        Static207.method4432();
        @Pc(825) int local825 = MapRegion.active.maxLevel;
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
                for (local858 = 0; local858 < Static501.mapLength; local858++) {
                    Static468.updateObjCount(local852, local855, local858);
                }
            }
        }
        Static77.method1561();
        Static557.method7331();
        Static197.method2949();
        client.cacheReset();
        Static442.method5969();
        @Pc(920) ClientMessage local920;
        if (GameShell.frame != null && ServerConnection.GAME.connection != null && MainLogicManager.step == 12) {
            local920 = ClientMessage.create(ClientProt.DETECT_MODIFIED_CLIENT, ServerConnection.GAME.cipher);
            local920.bitPacket.p4(1057001181);
            ServerConnection.GAME.send(local920);
        }

        if (Static117.areaMode == AreaMode.STATIC_AREA) {
            local855 = (Static62.areaCenterX - (Static720.mapWidth >> 4)) / 8;
            local858 = (Static62.areaCenterX + (Static720.mapWidth >> 4)) / 8;
            @Pc(961) int local961 = (Static525.areaCenterZ - (Static501.mapLength >> 4)) / 8;
            @Pc(969) int local969 = ((Static501.mapLength >> 4) + Static525.areaCenterZ) / 8;
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
            if (ServerConnection.GAME.connection != null) {
                local920 = ClientMessage.create(ClientProt.MAP_BUILD_COMPLETE, ServerConnection.GAME.cipher);
                ServerConnection.GAME.send(local920);
            }
        }
        WorldMap.method7934();
        Static557.method7331();
        Static199.doneslowupdate();
        Static75.hasOpaqueStationaryEntities = true;
        if (Static28.aBoolean43) {
            debugconsole.addline("Took: " + (SystemTimer.safetime() - Static690.aLong318) + "ms");
            Static28.aBoolean43 = false;
        }
    }
}
