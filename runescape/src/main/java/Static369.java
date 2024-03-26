import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.graphics.FontMetrics;
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
                    if (Static89.anIntArray169[local13] == Static119.anIntArray199[local22]) {
                        local20 = local22;
                        break;
                    }
                }
                if (local20 == -1) {
                    Static119.anIntArray199[Static183.anInt3024] = Static89.anIntArray169[local13];
                    local20 = Static183.anInt3024++;
                }
                @Pc(66) Packet local66 = new Packet(Static363.aByteArrayArray22[local13]);
                @Pc(68) int local68 = 0;
                while (Static363.aByteArrayArray22[local13].length > local66.pos && local68 < 511 && NPCList.localNpcCount < 1023) {
                    @Pc(88) int local88 = local20 | local68++ << 6;
                    @Pc(94) int local94 = local66.g2();
                    @Pc(98) int local98 = local94 >> 14;
                    @Pc(104) int local104 = local94 >> 7 & 0x3F;
                    @Pc(108) int local108 = local94 & 0x3F;
                    @Pc(121) int local121 = local104 + (Static89.anIntArray169[local13] >> 8) * 64 - WorldMap.areaBaseX;
                    @Pc(135) int local135 = (Static89.anIntArray169[local13] & 0xFF) * 64 + local108 - WorldMap.areaBaseZ;
                    @Pc(142) NPCType local142 = NPCTypeList.instance.list(local66.g2());
                    @Pc(149) NPCEntityNode local149 = (NPCEntityNode) NPCList.local.get(local88);
                    if (local149 == null && (local142.movementCapabilities & 0x1) > 0 && local98 == Static164.areaLevel && local121 >= 0 && local142.size + local121 < Static720.mapWidth && local135 >= 0 && local135 + local142.size < Static501.mapLength) {
                        @Pc(197) NPCEntity local197 = new NPCEntity();
                        local197.id = local88;
                        @Pc(205) NPCEntityNode local205 = new NPCEntityNode(local197);
                        NPCList.local.put(local88, local205);
                        NPCList.localNpcs[NPCList.newNpcCount++] = local205;
                        NPCList.localNpcIndices[NPCList.localNpcCount++] = local88;
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
    public static void method3851(@OriginalArg(0) Toolkit arg0) {
        if (Static133.A_DEQUE___13.size() == 0) {
            return;
        }
        @Pc(31) Node_Sub36 local31;
        if (ClientOptions.instance.toolkit.getValue() == ToolkitType.JAVA) {
            for (local31 = (Node_Sub36) Static133.A_DEQUE___13.first(); local31 != null; local31 = (Node_Sub36) Static133.A_DEQUE___13.next()) {
                ObjTypeList.instance.sprite(local31.anInt5893, arg0, arg0, local31.aBoolean451 ? PlayerEntity.self.playerModel : null, false, local31.anInt5891, local31.anInt5888, false, local31.anInt5890, Fonts.p11, local31.anInt5895);
                local31.unlink();
            }
            InterfaceManager.redrawAll();
            return;
        }
        if (Static158.aToolkit_5 == null) {
            @Pc(85) Canvas local85 = new Canvas();
            local85.setSize(36, 32);
            Static158.aToolkit_5 = Static255.create(ToolkitType.JAVA, js5.SHADERS, local85, Js5TextureSource.instance, 0);
            Fonts.aFont_11 = Static158.aToolkit_5.createFont(FontMetrics.loadGroup(Fonts.p11FullGroup, js5.FONTMETRICS), IndexedImage.load(js5.SPRITES, Fonts.p11FullGroup, 0), true);
        }
        for (local31 = (Node_Sub36) Static133.A_DEQUE___13.first(); local31 != null; local31 = (Node_Sub36) Static133.A_DEQUE___13.next()) {
            ObjTypeList.instance.sprite(local31.anInt5893, Static158.aToolkit_5, arg0, local31.aBoolean451 ? PlayerEntity.self.playerModel : null, false, local31.anInt5891, local31.anInt5888, false, local31.anInt5890, Fonts.aFont_11, local31.anInt5895);
            local31.unlink();
        }
    }

    @OriginalMember(owner = "client!lla", name = "b", descriptor = "(B)V")
    public static void method3852() {
        if (Client.ssKey != null) {
            Static292.method4615();
        } else if (Static129.anInt2409 == -1) {
            Static616.method8283(Static59.aString63, Static449.aString75);
        } else {
            Static695.method9266();
        }
    }
}
