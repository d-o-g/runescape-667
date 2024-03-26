import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static527 {

    @OriginalMember(owner = "client!qka", name = "i", descriptor = "[Lclient!nba;")
    public static final HintArrow[] hintArrows = new HintArrow[8];

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(IBIII)V")
    public static void method7081(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        Static232.anInt3829 = arg1;
        Static240.anInt3955 = arg2;
        Static275.anInt4424 = arg0;
        Static168.anInt2842 = arg3;
    }

    @OriginalMember(owner = "client!qka", name = "c", descriptor = "(I)V")
    public static void method7083() {
        for (@Pc(15) ProjectileAnimationNode local15 = (ProjectileAnimationNode) Static505.projectiles.first(); local15 != null; local15 = (ProjectileAnimationNode) Static505.projectiles.next()) {
            @Pc(20) ProjectileAnimation local20 = local15.projectileAnimation;
            if (TimeUtils.clock > local20.t2) {
                local15.unlink();
                local20.method815();
            } else if (TimeUtils.clock >= local20.t1) {
                local20.method816();
                if (local20.anInt711 > 0) {
                    if (CutsceneManager.state == 3) {
                        @Pc(61) PathingEntity local61 = CutsceneManager.actors[local20.anInt711 - 1].entity();
                        if (local61 != null && local61.x >= 0 && local61.x < Static720.mapWidth * 512 && local61.z >= 0 && local61.z < Static501.mapLength * 512) {
                            local20.target(Static102.averageHeight(local20.level, local61.z, local61.x) - local20.lb, TimeUtils.clock, local61.z, local61.x);
                        }
                    } else {
                        @Pc(130) NPCEntityNode local130 = (NPCEntityNode) NPCList.local.get(local20.anInt711 - 1);
                        if (local130 != null) {
                            @Pc(135) NPCEntity local135 = local130.npc;
                            if (local135.x >= 0 && local135.x < Static720.mapWidth * 512 && local135.z >= 0 && local135.z < Static501.mapLength * 512) {
                                local20.target(Static102.averageHeight(local20.level, local135.z, local135.x) - local20.lb, TimeUtils.clock, local135.z, local135.x);
                            }
                        }
                    }
                }
                if (local20.anInt711 < 0) {
                    @Pc(193) int local193 = -local20.anInt711 - 1;
                    @Pc(198) PlayerEntity local198;
                    if (local193 == PlayerList.activePlayerSlot) {
                        local198 = PlayerEntity.self;
                    } else {
                        local198 = PlayerList.highResolutionPlayers[local193];
                    }
                    if (local198 != null && local198.x >= 0 && Static720.mapWidth * 512 > local198.x && local198.z >= 0 && Static501.mapLength * 512 > local198.z) {
                        local20.target(Static102.averageHeight(local20.level, local198.z, local198.x) - local20.lb, TimeUtils.clock, local198.z, local198.x);
                    }
                }
                local20.tick(Static35.currentTick);
                Static102.method2026(local20, true);
            }
        }
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(III)V")
    public static void method7084(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(23) boolean local23 = Static334.activeTiles[0][arg1][arg2] != null && Static334.activeTiles[0][arg1][arg2].tile != null;
        for (@Pc(25) int local25 = arg0; local25 >= 0; local25--) {
            if (Static334.activeTiles[local25][arg1][arg2] == null) {
                @Pc(47) Tile local47 = Static334.activeTiles[local25][arg1][arg2] = new Tile(local25);
                if (local23) {
                    local47.level++;
                }
            }
        }
    }
}
