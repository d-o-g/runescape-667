import com.jagex.core.io.BitPacket;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static466 {

    @OriginalMember(owner = "client!om", name = "b", descriptor = "(Z)V")
    public static void rebuildRegion() {
        @Pc(8) BitPacket bitPacket = ServerConnection.GAME.bitPacket;
        @Pc(12) int zoneZ = bitPacket.g2();
        @Pc(16) int buildArea = bitPacket.g1();
        @Pc(28) boolean forceUpdate = bitPacket.g1_alt3() == 1;
        Static117.areaMode = bitPacket.g1_alt3();
        @Pc(36) int zoneX = bitPacket.ig2();
        Static165.updateLastAreaMode();
        Static342.setBuildArea(buildArea);
        bitPacket.enterBitMode();
        @Pc(50) int local50;
        @Pc(54) int local54;
        @Pc(61) int local61;
        for (@Pc(46) int local46 = 0; local46 < 4; local46++) {
            for (local50 = 0; local50 < Static720.mapWidth >> 3; local50++) {
                for (local54 = 0; local54 < Static501.mapLength >> 3; local54++) {
                    local61 = bitPacket.gbit(1);
                    if (local61 == 1) {
                        Static623.zonePointers[local46][local50][local54] = bitPacket.gbit(26);
                    } else {
                        Static623.zonePointers[local46][local50][local54] = -1;
                    }
                }
            }
        }
        bitPacket.exitBitMode();
        local50 = (ServerConnection.GAME.currentPacketSize - bitPacket.pos) / 16;
        Static22.anIntArrayArray11 = new int[local50][4];
        for (local54 = 0; local54 < local50; local54++) {
            for (local61 = 0; local61 < 4; local61++) {
                Static22.anIntArrayArray11[local54][local61] = bitPacket.g4();
            }
        }
        Static118.aByteArrayArray3 = new byte[local50][];
        Static177.aByteArrayArray5 = new byte[local50][];
        Static266.locationGroups = new int[local50];
        Static376.npcGroups = null;
        Static89.zoneIds = new int[local50];
        Static298.underwaterLocationGroups = new int[local50];
        Static421.aByteArrayArray19 = new byte[local50][];
        Static267.mapGroups = new int[local50];
        Static319.aByteArrayArray16 = new byte[local50][];
        Static363.aByteArrayArray22 = null;
        Static68.underwaterMapGroups = new int[local50];
        local50 = 0;
        for (local61 = 0; local61 < 4; local61++) {
            for (@Pc(221) int local221 = 0; local221 < Static720.mapWidth >> 3; local221++) {
                for (@Pc(225) int local225 = 0; local225 < Static501.mapLength >> 3; local225++) {
                    @Pc(235) int local235 = Static623.zonePointers[local61][local221][local225];
                    if (local235 != -1) {
                        @Pc(245) int local245 = local235 >> 14 & 0x3FF;
                        @Pc(251) int local251 = local235 >> 3 & 0x7FF;
                        @Pc(261) int local261 = local251 / 8 + (local245 / 8 << 8);
                        for (@Pc(263) int local263 = 0; local263 < local50; local263++) {
                            if (Static89.zoneIds[local263] == local261) {
                                local261 = -1;
                                break;
                            }
                        }
                        if (local261 != -1) {
                            Static89.zoneIds[local50] = local261;
                            @Pc(299) int local299 = local261 >> 8 & 0xFF;
                            @Pc(303) int local303 = local261 & 0xFF;
                            Static267.mapGroups[local50] = js5.MAPS.getgroupid("m" + local299 + "_" + local303);
                            Static266.locationGroups[local50] = js5.MAPS.getgroupid("l" + local299 + "_" + local303);
                            Static68.underwaterMapGroups[local50] = js5.MAPS.getgroupid("um" + local299 + "_" + local303);
                            Static298.underwaterLocationGroups[local50] = js5.MAPS.getgroupid("ul" + local299 + "_" + local303);
                            local50++;
                        }
                    }
                }
            }
        }
        Static684.updateMapArea(forceUpdate, zoneX, 12, zoneZ);
    }

}
