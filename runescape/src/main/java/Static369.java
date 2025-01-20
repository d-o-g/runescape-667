import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Fonts;
import com.jagex.graphics.JavaObjSprite;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static369 {

    @OriginalMember(owner = "client!lla", name = "e", descriptor = "[B")
    public static byte[] aByteArray43;

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "(I)V")
    public static void method3847() {
        @Pc(11) int local11 = Static363.aByteArrayArray22.length;
        for (@Pc(13) int local13 = 0; local13 < local11; local13++) {
            if (Static363.aByteArrayArray22[local13] != null) {
                @Pc(20) int local20 = -1;
                for (@Pc(22) int local22 = 0; local22 < Static183.anInt3024; local22++) {
                    if (Static89.zoneIds[local13] == Static119.anIntArray199[local22]) {
                        local20 = local22;
                        break;
                    }
                }
                if (local20 == -1) {
                    Static119.anIntArray199[Static183.anInt3024] = Static89.zoneIds[local13];
                    local20 = Static183.anInt3024++;
                }
                @Pc(66) Packet local66 = new Packet(Static363.aByteArrayArray22[local13]);
                @Pc(68) int local68 = 0;
                while (Static363.aByteArrayArray22[local13].length > local66.pos && local68 < 511 && NPCList.size < 1023) {
                    @Pc(88) int local88 = local20 | local68++ << 6;
                    @Pc(94) int local94 = local66.g2();
                    @Pc(98) int local98 = local94 >> 14;
                    @Pc(104) int local104 = local94 >> 7 & 0x3F;
                    @Pc(108) int local108 = local94 & 0x3F;
                    @Pc(121) int local121 = local104 + (Static89.zoneIds[local13] >> 8) * 64 - WorldMap.areaBaseX;
                    @Pc(135) int local135 = (Static89.zoneIds[local13] & 0xFF) * 64 + local108 - WorldMap.areaBaseZ;
                    @Pc(142) NPCType local142 = NPCTypeList.instance.list(local66.g2());
                    @Pc(149) NPCEntityNode local149 = (NPCEntityNode) NPCList.local.get(local88);
                    if (local149 == null && (local142.movementCapabilities & 0x1) > 0 && local98 == Static164.areaLevel && local121 >= 0 && local142.size + local121 < Static720.mapWidth && local135 >= 0 && local135 + local142.size < Static501.mapLength) {
                        @Pc(197) NPCEntity local197 = new NPCEntity();
                        local197.slot = local88;
                        @Pc(205) NPCEntityNode local205 = new NPCEntityNode(local197);
                        NPCList.local.put(local88, local205);
                        NPCList.entities[NPCList.newSize++] = local205;
                        NPCList.slots[NPCList.size++] = local88;
                        local197.cutsceneClock = TimeUtils.clock;
                        local197.setupNewNPCType(local142);
                        local197.setSize(local197.type.size);
                        local197.yawSpeed = local197.type.yawSpeed << 3;
                        local197.turn((local197.type.spawnDirection + 4 & 0x80600007) << 11, true);
                        local197.clearPath(true, local135, local121, local98, local197.getSize());
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "(Lclient!ha;I)V")
    public static void updateObjSprites(@OriginalArg(0) Toolkit toolkit) {
        if (JavaToolkit.objSprites.size() == 0) {
            return;
        }

        if (ClientOptions.instance.toolkit.getValue() == ToolkitType.JAVA) {
            for (@Pc(31) JavaObjSprite sprite = (JavaObjSprite) JavaToolkit.objSprites.first(); sprite != null; sprite = (JavaObjSprite) JavaToolkit.objSprites.next()) {
                ObjTypeList.instance.sprite(sprite.outline, toolkit, toolkit, sprite.objWearCol ? PlayerEntity.self.playerModel : null, false, sprite.graphicShadow, sprite.invCount, false, sprite.objNumMode, Fonts.p11, sprite.objId);
                sprite.unlink();
            }

            InterfaceManager.redrawAll();
            return;
        }

        if (Static158.objSpriteToolkit == null) {
            @Pc(85) Canvas canvas = new Canvas();
            canvas.setSize(36, 32);
            Static158.objSpriteToolkit = Static255.create(ToolkitType.JAVA, js5.SHADERS, canvas, Js5TextureSource.instance, 0);
            Fonts.objSpriteFont = Static158.objSpriteToolkit.createFont(FontMetrics.loadGroup(js5.FONTMETRICS, Fonts.p11FullGroup), IndexedImage.load(js5.SPRITES, Fonts.p11FullGroup, 0), true);
        }

        for (@Pc(31) JavaObjSprite sprite = (JavaObjSprite) JavaToolkit.objSprites.first(); sprite != null; sprite = (JavaObjSprite) JavaToolkit.objSprites.next()) {
            ObjTypeList.instance.sprite(sprite.outline, Static158.objSpriteToolkit, toolkit, sprite.objWearCol ? PlayerEntity.self.playerModel : null, false, sprite.graphicShadow, sprite.invCount, false, sprite.objNumMode, Fonts.objSpriteFont, sprite.objId);
            sprite.unlink();
        }
    }

    @OriginalMember(owner = "client!lla", name = "b", descriptor = "(B)V")
    public static void method3852() {
        if (Client.ssKey != null) {
            LoginManager.checkLobbySession();
        } else if (LoginManager.socialNetworkId == -1) {
            LoginManager.doLobbyLogin(LoginManager.password, LoginManager.username);
        } else {
            LoginManager.doLobbySnLogin();
        }
    }
}
