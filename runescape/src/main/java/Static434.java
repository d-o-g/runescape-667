import com.jagex.core.constants.AreaMode;
import com.jagex.core.io.BitPacket;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static434 {

    @OriginalMember(owner = "client!nla", name = "g", descriptor = "(I)V")
    public static void rebuildNormal() {
        Static117.areaMode = AreaMode.STATIC_AREA;
        @Pc(8) BitPacket bitPacket = ServerConnection.GAME.bitPacket;
        @Pc(12) int local12 = bitPacket.g1_alt2();
        @Pc(24) boolean local24 = bitPacket.g1() == 1;
        @Pc(28) int local28 = bitPacket.ig2();
        @Pc(32) int local32 = bitPacket.g2();
        Static165.updateLastAreaMode();
        Static342.setBuildArea(local12);
        @Pc(46) int local46 = (ServerConnection.GAME.currentPacketSize - bitPacket.pos) / 16;
        Static22.anIntArrayArray11 = new int[local46][4];
        @Pc(55) int local55;
        for (@Pc(52) int local52 = 0; local52 < local46; local52++) {
            for (local55 = 0; local55 < 4; local55++) {
                Static22.anIntArrayArray11[local52][local55] = bitPacket.g4();
            }
        }
        Static363.aByteArrayArray22 = null;
        Static319.aByteArrayArray16 = new byte[local46][];
        Static118.aByteArrayArray3 = new byte[local46][];
        Static266.locationGroups = new int[local46];
        Static177.aByteArrayArray5 = new byte[local46][];
        Static267.mapGroups = new int[local46];
        Static68.underwaterMapGroups = new int[local46];
        Static298.underwaterLocationGroups = new int[local46];
        Static376.npcGroups = null;
        Static89.zoneIds = new int[local46];
        Static421.aByteArrayArray19 = new byte[local46][];
        local46 = 0;
        for (local55 = (local28 - (Static720.mapWidth >> 4)) / 8; local55 <= ((Static720.mapWidth >> 4) + local28) / 8; local55++) {
            for (@Pc(137) int local137 = (local32 - (Static501.mapLength >> 4)) / 8; local137 <= (local32 + (Static501.mapLength >> 4)) / 8; local137++) {
                Static89.zoneIds[local46] = (local55 << 8) + local137;
                Static267.mapGroups[local46] = js5.MAPS.getgroupid("m" + local55 + "_" + local137);
                Static266.locationGroups[local46] = js5.MAPS.getgroupid("l" + local55 + "_" + local137);
                Static68.underwaterMapGroups[local46] = js5.MAPS.getgroupid("um" + local55 + "_" + local137);
                Static298.underwaterLocationGroups[local46] = js5.MAPS.getgroupid("ul" + local55 + "_" + local137);
                local46++;
            }
        }
        Static684.updateMapArea(local24, local28, 12, local32);
    }
}
