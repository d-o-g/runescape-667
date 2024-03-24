import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static112 {

    @OriginalMember(owner = "client!dj", name = "n", descriptor = "Z")
    public static boolean aBoolean197 = false;

    @OriginalMember(owner = "client!dj", name = "a", descriptor = "(ILclient!cg;)I")
    public static int method2104(@OriginalArg(1) Class8_Sub2_Sub1_Sub2 arg0) {
        if (arg0.anInt10757 == 0) {
            return 0;
        }
        @Pc(74) int local74;
        @Pc(67) int local67;
        if (arg0.anInt10722 != -1) {
            @Pc(24) Class8_Sub2_Sub1_Sub2 local24 = null;
            if (arg0.anInt10722 < 32768) {
                @Pc(54) NPCEntityNode local54 = (NPCEntityNode) NPCList.local.get(arg0.anInt10722);
                if (local54 != null) {
                    local24 = local54.npc;
                }
            } else if (arg0.anInt10722 >= 32768) {
                local24 = PlayerList.highResolutionPlayers[arg0.anInt10722 - 32768];
            }
            if (local24 != null) {
                local67 = arg0.x - local24.x;
                local74 = arg0.z - local24.z;
                if (local67 != 0 || local74 != 0) {
                    arg0.method9305((int) (Math.atan2(local67, local74) * 2607.5945876176133D) & 0x3FFF);
                }
            }
        }
        if (arg0 instanceof PlayerEntity) {
            @Pc(104) PlayerEntity local104 = (PlayerEntity) arg0;
            if (local104.anInt1467 != -1 && (local104.anInt10764 == 0 || local104.anInt10763 > 0)) {
                local104.method9305(local104.anInt1467);
                local104.anInt1467 = -1;
            }
        } else if (arg0 instanceof NPCEntity) {
            @Pc(138) NPCEntity local138 = (NPCEntity) arg0;
            if (local138.anInt10774 != -1 && (local138.anInt10764 == 0 || local138.anInt10763 > 0)) {
                local67 = local138.x - (local138.anInt10774 - WorldMap.areaBaseX - WorldMap.areaBaseX) * 256;
                local74 = local138.z - (local138.anInt10767 - WorldMap.areaBaseZ - WorldMap.areaBaseZ) * 256;
                if (local67 != 0 || local74 != 0) {
                    local138.method9305((int) (Math.atan2(local67, local74) * 2607.5945876176133D) & 0x3FFF);
                }
                local138.anInt10774 = -1;
            }
        }
        return arg0.method9303();
    }

    @OriginalMember(owner = "client!dj", name = "a", descriptor = "(BLclient!ge;)Lclient!jt;")
    public static Class200 method2106(@OriginalArg(1) Packet arg0) {
        @Pc(7) int local7 = arg0.g2();
        return new Class200(local7);
    }

    @OriginalMember(owner = "client!dj", name = "e", descriptor = "(I)V")
    public static void method2109() {
        if (Static158.aToolkit_5 != null) {
            Static158.aToolkit_5.free();
            Fonts.aFont_11 = null;
            Static158.aToolkit_5 = null;
        }
    }
}
