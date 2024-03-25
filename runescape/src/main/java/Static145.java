import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static145 {

    @OriginalMember(owner = "client!eja", name = "g", descriptor = "I")
    public static int anInt2561 = 0;

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(I)V")
    public static void method2409() {
        for (@Pc(10) int local10 = 0; local10 < 5; local10++) {
            Static572.aBooleanArray29[local10] = false;
        }
        Static70.anInt1569 = Camera.x;
        Static411.anInt6329 = Camera.z;
        Static225.anInt3641 = Camera.yaw;
        Static197.anInt3260 = -1;
        Static340.anInt5584 = Camera.pitch;
        Static693.anInt10383 = -1;
        Static692.anInt10376 = -1;
        Camera.lookSpline = -1;
        Static212.anInt3468 = TimeUtils.clock;
        Static179.anInt2991 = 0;
        Static314.anInt5035 = 0;
        Camera.mode = 5;
        Static302.anInt4854 = Camera.y;
    }

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(Lclient!cg;Z)V")
    public static void method2410(@OriginalArg(0) PathingEntity arg0) {
        if (arg0.wornTargets == null && arg0.wornRotation == null) {
            return;
        }
        @Pc(17) boolean local17 = true;
        for (@Pc(19) int local19 = 0; local19 < arg0.wornTargets.length; local19++) {
            @Pc(25) int local25 = -1;
            if (arg0.wornTargets != null) {
                local25 = arg0.wornTargets[local19];
            }
            if (local25 != -1) {
                local17 = false;
                @Pc(102) int local102;
                @Pc(95) int local95;
                @Pc(72) int local72;
                if ((local25 & -1073741824) == -1073741824) {
                    local72 = local25 & 0xFFFFFFF;
                    @Pc(148) int local148 = local72 >> 14;
                    local102 = arg0.x - (local148 - WorldMap.areaBaseX) * 512 - 256;
                    @Pc(164) int local164 = local72 & 0x3FFF;
                    local95 = arg0.z - (local164 - WorldMap.areaBaseZ) * 512 - 256;
                } else if ((local25 & 0x8000) == 0) {
                    @Pc(111) NPCEntityNode local111 = (NPCEntityNode) NPCList.local.get(local25);
                    if (local111 == null) {
                        arg0.method9307(local19, -1);
                        continue;
                    }
                    @Pc(116) NPCEntity local116 = local111.npc;
                    local95 = arg0.z - local116.z;
                    local102 = arg0.x - local116.x;
                } else {
                    local72 = local25 & 0x7FFF;
                    @Pc(76) PlayerEntity local76 = PlayerList.highResolutionPlayers[local72];
                    if (local76 == null) {
                        arg0.method9307(local19, -1);
                        continue;
                    }
                    local95 = arg0.z - local76.z;
                    local102 = arg0.x - local76.x;
                }
                if (local102 != 0 || local95 != 0) {
                    arg0.method9307(local19, (int) (Math.atan2(local102, local95) * 2607.5945876176133D) & 0x3FFF);
                }
            } else if (!arg0.method9307(local19, -1)) {
                local17 = false;
            }
        }
        if (local17) {
            arg0.wornTargets = null;
            arg0.wornRotation = null;
        }
    }

}
