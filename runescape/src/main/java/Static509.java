import com.jagex.game.runetek6.config.meltype.MapElementType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static509 {

    @OriginalMember(owner = "client!qa", name = "n", descriptor = "I")
    public static final int anInt7634 = 4;

    @OriginalMember(owner = "client!qa", name = "a", descriptor = "(BII)V")
    public static void method6759(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        if (WorldMap.targetZoom > WorldMap.currentZoom) {
            WorldMap.currentZoom = (float) ((double) WorldMap.currentZoom + (double) WorldMap.currentZoom / 30.0D);
            if (WorldMap.targetZoom < WorldMap.currentZoom) {
                WorldMap.currentZoom = WorldMap.targetZoom;
            }
            WorldMap.method5440();
            WorldMap.tileSize = (int) WorldMap.currentZoom >> 1;
            WorldMap.tileShapes = Static640.method8437(WorldMap.tileSize);
        } else if (WorldMap.currentZoom > WorldMap.targetZoom) {
            WorldMap.currentZoom = (float) ((double) WorldMap.currentZoom - (double) WorldMap.currentZoom / 30.0D);
            if (WorldMap.targetZoom > WorldMap.currentZoom) {
                WorldMap.currentZoom = WorldMap.targetZoom;
            }
            WorldMap.method5440();
            WorldMap.tileSize = (int) WorldMap.currentZoom >> 1;
            WorldMap.tileShapes = Static640.method8437(WorldMap.tileSize);
        }
        if (WorldMap.jumpX != -1 && WorldMap.jumpZ != -1) {
            @Pc(101) int local101 = WorldMap.jumpX - WorldMap.anInt2809;
            if (local101 < 2 || local101 > 2) {
                local101 /= 8;
            }
            @Pc(120) int local120 = WorldMap.jumpZ - WorldMap.anInt9389;
            WorldMap.anInt2809 += local101;
            if (local120 < 2 || local120 > 2) {
                local120 /= 8;
            }
            if (local101 == 0 && local120 == 0) {
                WorldMap.jumpZ = -1;
                WorldMap.jumpX = -1;
            }
            WorldMap.anInt9389 -= -local120;
            WorldMap.method5440();
        }
        if (Static320.anInt5084 > 0) {
            Static212.anInt3467--;
            if (Static212.anInt3467 == 0) {
                Static320.anInt5084--;
                Static212.anInt3467 = 100;
            }
        } else {
            Static475.anInt7168 = -1;
            Static409.anInt6318 = -1;
        }
        if (!WorldMap.hovered || WorldMap.aDeque_54 == null) {
            return;
        }
        for (@Pc(197) Node_Sub37 local197 = (Node_Sub37) WorldMap.aDeque_54.first(); local197 != null; local197 = (Node_Sub37) WorldMap.aDeque_54.next()) {
            @Pc(206) MapElementType local206 = WorldMap.mapElementTypeList.list(local197.aClass2_Sub20_1.id);
            if (local197.method5553(arg0, arg1)) {
                if (local206.ops != null) {
                    if (local206.ops[4] != null) {
                        MiniMenu.addEntryInner(false, -1, local197.aClass2_Sub20_1.id, local206.category, 0, local206.ops[4], 1004, true, -1, local206.opBase, local197.aClass2_Sub20_1.id, false);
                    }
                    if (local206.ops[3] != null) {
                        MiniMenu.addEntryInner(false, -1, local197.aClass2_Sub20_1.id, local206.category, 0, local206.ops[3], 1009, true, -1, local206.opBase, local197.aClass2_Sub20_1.id, false);
                    }
                    if (local206.ops[2] != null) {
                        MiniMenu.addEntryInner(false, -1, local197.aClass2_Sub20_1.id, local206.category, 0, local206.ops[2], 1006, true, -1, local206.opBase, local197.aClass2_Sub20_1.id, false);
                    }
                    if (local206.ops[1] != null) {
                        MiniMenu.addEntryInner(false, -1, local197.aClass2_Sub20_1.id, local206.category, 0, local206.ops[1], 1001, true, -1, local206.opBase, local197.aClass2_Sub20_1.id, false);
                    }
                    if (local206.ops[0] != null) {
                        MiniMenu.addEntryInner(false, -1, local197.aClass2_Sub20_1.id, local206.category, 0, local206.ops[0], 1003, true, -1, local206.opBase, local197.aClass2_Sub20_1.id, false);
                    }
                }
                if (!local197.aClass2_Sub20_1.aBoolean256) {
                    local197.aClass2_Sub20_1.aBoolean256 = true;
                    ScriptRunner.executeTrigger(Static5.A_CLIENT_TRIGGER_TYPE___1, local197.aClass2_Sub20_1.id, local206.category);
                }
                if (local197.aClass2_Sub20_1.aBoolean256) {
                    ScriptRunner.executeTrigger(ClientTriggerType.MAP_ELEMENT_MOUSEREPEAT, local197.aClass2_Sub20_1.id, local206.category);
                }
            } else if (local197.aClass2_Sub20_1.aBoolean256) {
                local197.aClass2_Sub20_1.aBoolean256 = false;
                ScriptRunner.executeTrigger(Static280.A_CLIENT_TRIGGER_TYPE___7, local197.aClass2_Sub20_1.id, local206.category);
            }
        }
    }
}
