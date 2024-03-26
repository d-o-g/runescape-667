import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static145 {

    @OriginalMember(owner = "client!eja", name = "g", descriptor = "I")
    public static int anInt2561 = 0;

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(Lclient!cg;Z)V")
    public static void wornTargetTick(@OriginalArg(0) PathingEntity entity) {
        if (entity.wornTargets == null && entity.wornRotation == null) {
            return;
        }
        @Pc(17) boolean local17 = true;
        for (@Pc(19) int local19 = 0; local19 < entity.wornTargets.length; local19++) {
            @Pc(25) int local25 = -1;
            if (entity.wornTargets != null) {
                local25 = entity.wornTargets[local19];
            }
            if (local25 != -1) {
                local17 = false;
                @Pc(102) int local102;
                @Pc(95) int local95;
                @Pc(72) int local72;
                if ((local25 & -1073741824) == -1073741824) {
                    local72 = local25 & 0xFFFFFFF;
                    @Pc(148) int local148 = local72 >> 14;
                    local102 = entity.x - (local148 - WorldMap.areaBaseX) * 512 - 256;
                    @Pc(164) int local164 = local72 & 0x3FFF;
                    local95 = entity.z - (local164 - WorldMap.areaBaseZ) * 512 - 256;
                } else if ((local25 & 0x8000) == 0) {
                    @Pc(111) NPCEntityNode local111 = (NPCEntityNode) NPCList.local.get(local25);
                    if (local111 == null) {
                        entity.method9307(local19, -1);
                        continue;
                    }
                    @Pc(116) NPCEntity local116 = local111.npc;
                    local95 = entity.z - local116.z;
                    local102 = entity.x - local116.x;
                } else {
                    local72 = local25 & 0x7FFF;
                    @Pc(76) PlayerEntity local76 = PlayerList.highResolutionPlayers[local72];
                    if (local76 == null) {
                        entity.method9307(local19, -1);
                        continue;
                    }
                    local95 = entity.z - local76.z;
                    local102 = entity.x - local76.x;
                }
                if (local102 != 0 || local95 != 0) {
                    entity.method9307(local19, (int) (Math.atan2(local102, local95) * 2607.5945876176133D) & 0x3FFF);
                }
            } else if (!entity.method9307(local19, -1)) {
                local17 = false;
            }
        }
        if (local17) {
            entity.wornTargets = null;
            entity.wornRotation = null;
        }
    }

}
