import com.jagex.ChangeLocationRequest;
import com.jagex.core.constants.AreaMode;
import com.jagex.game.LocalisedText;
import com.jagex.game.camera.CameraMode;
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
    public static void updateMapArea(@OriginalArg(0) boolean force, @OriginalArg(1) int centerX, @OriginalArg(2) int mainLogicStep, @OriginalArg(3) int centerZ) {
        if (CutsceneManager.state == 4) {
            CutsceneManager.state = 0;
            CutsceneManager.cutsceneId = -1;
        }

        if (!force && Static62.areaCenterX == centerX && Static525.areaCenterZ == centerZ && (Static164.areaLevel == Camera.renderingLevel || ClientOptions.instance.animateBackground.getValue() == 1)) {
            return;
        }

        Static525.areaCenterZ = centerZ;
        Static62.areaCenterX = centerX;
        Static164.areaLevel = Camera.renderingLevel;
        if (ClientOptions.instance.animateBackground.getValue() == 1) {
            Static164.areaLevel = 0;
        }

        MainLogicManager.setStep(mainLogicStep);
        Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(client.language), true, Fonts.p12Metrics, Fonts.p12);

        @Pc(74) int baseX = WorldMap.areaBaseX;
        WorldMap.areaBaseX = (Static62.areaCenterX - (Static720.mapWidth >> 4)) * 8;

        @Pc(85) int baseZ = WorldMap.areaBaseZ;
        WorldMap.areaBaseZ = (Static525.areaCenterZ - (Static501.mapHeight >> 4)) * 8;

        Static162.aClass2_Sub2_Sub13_2 = WorldMap.method5078(Static62.areaCenterX * 8, Static525.areaCenterZ * 8);
        Static42.aMapElementList_2 = null;

        @Pc(109) int deltaX = WorldMap.areaBaseX - baseX;
        @Pc(113) int deltaZ = WorldMap.areaBaseZ - baseZ;

        if (mainLogicStep == 12) {
            for (@Pc(308) int i = 0; i < NPCList.newNpcCount; i++) {
                @Pc(313) NPCEntityNode node = NPCList.localNpcs[i];

                if (node != null) {
                    @Pc(318) NPCEntity npc = node.npc;
                    for (@Pc(136) int local136 = 0; local136 < npc.pathX.length; local136++) {
                        npc.pathX[local136] -= deltaX;
                        npc.pathZ[local136] -= deltaZ;
                    }

                    npc.x -= deltaX * 512;
                    npc.z -= deltaZ * 512;
                }
            }
        } else {
            NPCList.localNpcCount = 0;

            @Pc(120) boolean removed = false;
            @Pc(128) int maxX = (Static720.mapWidth - 1) * 512;
            @Pc(134) int maxZ = (Static501.mapHeight * 512) - 512;

            for (@Pc(136) int i = 0; i < NPCList.newNpcCount; i++) {
                @Pc(141) NPCEntityNode node = NPCList.localNpcs[i];
                if (node == null) {
                    continue;
                }

                @Pc(146) NPCEntity npc = node.npc;
                npc.z -= deltaZ * 512;
                npc.x -= deltaX * 512;

                if (npc.x >= 0 && npc.x <= maxX && npc.z >= 0 && npc.z <= maxZ) {
                    @Pc(191) boolean inBounds = true;

                    for (@Pc(193) int j = 0; j < npc.pathX.length; j++) {
                        npc.pathX[j] -= deltaX;
                        npc.pathZ[j] -= deltaZ;

                        if (npc.pathX[j] < 0 || npc.pathX[j] >= Static720.mapWidth || npc.pathZ[j] < 0 || Static501.mapHeight <= npc.pathZ[j]) {
                            inBounds = false;
                        }
                    }

                    if (inBounds) {
                        NPCList.localNpcIndices[NPCList.localNpcCount++] = npc.id;
                    } else {
                        npc.setupNewNPCType(null);
                        removed = true;
                        node.unlink();
                    }
                } else {
                    npc.setupNewNPCType(null);
                    removed = true;
                    node.unlink();
                }
            }

            if (removed) {
                NPCList.newNpcCount = NPCList.local.size();
                NPCList.local.copyTo(NPCList.localNpcs);
            }
        }

        for (@Pc(308) int i = 0; i < PlayerList.MAX_PLAYER_COUNT; i++) {
            @Pc(389) PlayerEntity player = PlayerList.highResolutionPlayers[i];

            if (player != null) {
                for (@Pc(134) int j = 0; j < player.pathX.length; j++) {
                    player.pathX[j] -= deltaX;
                    player.pathZ[j] -= deltaZ;
                }

                player.z -= deltaZ * 512;
                player.x -= deltaX * 512;
            }
        }

        @Pc(446) HintArrow[] hintArrows = Static527.hintArrows;
        for (@Pc(134) int i = 0; i < hintArrows.length; i++) {
            @Pc(453) HintArrow hintArrow = hintArrows[i];
            if (hintArrow != null) {
                hintArrow.z -= deltaZ * 512;
                hintArrow.x -= deltaX * 512;
            }
        }

        for (@Pc(485) ChangeLocationRequest request = (ChangeLocationRequest) Static159.changes.first(); request != null; request = (ChangeLocationRequest) Static159.changes.next()) {
            request.x -= deltaX;
            request.z -= deltaZ;

            boolean outOfBounds = request.x < 0 || request.z < 0 || request.x >= Static720.mapWidth || request.z >= Static501.mapHeight;
            if (Static117.areaMode != AreaMode.RETAIN_OUT_OF_BOUNDS && outOfBounds) {
                request.unlink();
            }
        }

        for (@Pc(485) ChangeLocationRequest request = (ChangeLocationRequest) Static227.customisations.first(); request != null; request = (ChangeLocationRequest) Static227.customisations.next()) {
            request.z -= deltaZ;
            request.x -= deltaX;

            boolean outOfBounds = request.x < 0 || request.z < 0 || request.x >= Static720.mapWidth || request.z >= Static501.mapHeight;
            if (Static117.areaMode != AreaMode.RETAIN_OUT_OF_BOUNDS && outOfBounds) {
                request.unlink();
            }
        }

        if (Static117.areaMode != AreaMode.RETAIN_OUT_OF_BOUNDS) {
            for (@Pc(608) ObjStack stack = (ObjStack) Static497.stacks.first(); stack != null; stack = (ObjStack) Static497.stacks.next()) {
                @Pc(615) int absX = (int) (stack.key & 0x3FFFL);
                @Pc(619) int x = absX - WorldMap.areaBaseX;
                @Pc(193) int absZ = (int) (stack.key >> 14 & 0x3FFFL);
                @Pc(632) int z = absZ - WorldMap.areaBaseZ;

                if (x < 0 || z < 0 || x >= Static720.mapWidth || z >= Static501.mapHeight) {
                    stack.unlink();
                }
            }
        }

        if (Minimap.flagX != 0) {
            Minimap.flagY -= deltaZ;
            Minimap.flagX -= deltaX;
        }

        SoundManager.reset();

        if (mainLogicStep != 12) {
            Camera.lookX -= deltaX;
            Camera.moveToX -= deltaX;
            Camera.moveToZ -= deltaZ;
            Camera.z -= deltaZ * 512;
            Camera.x -= deltaX * 512;
            Camera.lookZ -= deltaZ;
            if (Math.abs(deltaX) > Static720.mapWidth || Math.abs(deltaZ) > Static501.mapHeight) {
                InterfaceManager.loginOpened();
            }
        } else if (Camera.mode == CameraMode.MODE_FOUR) {
            Camera.anInt6262 -= deltaX * 512;
            Static38.anInt920 -= deltaZ * 512;
            Camera.anInt4018 -= deltaZ * 512;
            Static494.anInt7409 -= deltaX * 512;
        } else {
            Camera.anInt10383 = -1;
            Camera.anInt10376 = -1;
            Camera.mode = CameraMode.MODE_DEFAULT;
        }
        Static533.method7119();
        Minimap.reset();
        Static346.A_HASH_TABLE___29.clear();
        Static505.projectiles.clear();
        Static422.textCoords.clear();
        ParticleManager.method2044();
    }
}
