import com.jagex.core.datastruct.key.Deque;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

public final class Static159 {

    @OriginalMember(owner = "client!ew", name = "c", descriptor = "I")
    public static int anInt2787;

    @OriginalMember(owner = "client!ew", name = "a", descriptor = "[I")
    public static final int[] anIntArray245 = new int[5];

    @OriginalMember(owner = "client!ew", name = "g", descriptor = "I")
    public static int anInt2788 = 0;

    @OriginalMember(owner = "client!ew", name = "d", descriptor = "Lclient!sia;")
    public static Deque aDeque_15 = new Deque();

    @OriginalMember(owner = "client!ew", name = "a", descriptor = "(III)I")
    public static int method2572(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(17) double local17 = Math.log(arg1) / Math.log(2.0D);
        @Pc(24) double local24 = Math.log(arg0) / Math.log(2.0D);
        @Pc(33) double local33 = local24 + Math.random() * (local17 - local24);
        return (int) (Math.pow(2.0D, local33) + 0.5D);
    }

    @OriginalMember(owner = "client!ew", name = "a", descriptor = "(Lclient!ha;B)V")
    public static void method2574(@OriginalArg(0) Toolkit arg0) {
        @Pc(7) int local7 = 0;
        @Pc(9) int local9 = 0;
        if (InterfaceManager.aBoolean210) {
            local7 = Static130.method2283();
            local9 = Static422.method5771();
        }
        Static97.method1905(Static84.anInt1775 + local9, Static71.anInt1576 - -local7, Static407.anInt6288, arg0, Static682.anInt10295);
        Fonts.b12.render(Static71.anInt1576 + local7 + 3, Static84.anInt1775 - (-local9 + -14), LocalisedText.CHOOSEOPTION.localise(client.language), -1, -10660793);
        @Pc(69) int local69 = MouseMonitor.instance.getRecordedX() + local7;
        @Pc(76) int local76 = MouseMonitor.instance.getRecordedY() + local9;
        @Pc(80) int local80;
        @Pc(101) int local101;
        if (Static236.aBoolean304) {
            local80 = 0;
            for (@Pc(137) MiniMenuEntryInner local137 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local137 != null; local137 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
                local101 = local9 + Static84.anInt1775 + local80 * 16 + 31;
                if (local137.size == 1) {
                    Static232.method3387(arg0, Static682.anInt10295, Static407.anInt6288, Static84.anInt1775 + local9, local101, -256, (MiniMenuEntry) local137.entries.sentinel.next2, -1, local76, local7 + Static71.anInt1576, local69);
                } else {
                    Static515.method6799(local76, Static682.anInt10295, local101, -256, arg0, local69, -1, Static84.anInt1775 + local9, local7 + Static71.anInt1576, Static407.anInt6288, local137);
                }
                local80++;
            }
            if (Static139.aClass2_Sub2_Sub4_1 != null) {
                Static97.method1905(Static493.anInt7364, Static692.anInt10375, Static25.anInt598, arg0, Static85.anInt10675);
                local80 = 0;
                Fonts.b12.render(Static692.anInt10375 + 3, Static493.anInt7364 + 14, Static139.aClass2_Sub2_Sub4_1.title, -1, -10660793);
                for (@Pc(239) MiniMenuEntry local239 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.first(); local239 != null; local239 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.next()) {
                    @Pc(251) int local251 = local80 * 16 + Static493.anInt7364 + 31;
                    local80++;
                    Static232.method3387(arg0, Static85.anInt10675, Static25.anInt598, Static493.anInt7364, local251, -256, local239, -1, local76, Static692.anInt10375, local69);
                }
                Static422.method5773(Static692.anInt10375, Static493.anInt7364, Static85.anInt10675, Static25.anInt598);
            }
        } else {
            local80 = 0;
            for (@Pc(85) MiniMenuEntry local85 = (MiniMenuEntry) MiniMenu.entry.first(); local85 != null; local85 = (MiniMenuEntry) MiniMenu.entry.next()) {
                local101 = (MiniMenu.entryCount - local80 - 1) * 16 + local9 + Static84.anInt1775 + 31;
                local80++;
                Static232.method3387(arg0, Static682.anInt10295, Static407.anInt6288, Static84.anInt1775 + local9, local101, -256, local85, -1, local76, local7 + Static71.anInt1576, local69);
            }
        }
        Static422.method5773(local7 + Static71.anInt1576, local9 + Static84.anInt1775, Static682.anInt10295, Static407.anInt6288);
    }

    @OriginalMember(owner = "client!ew", name = "a", descriptor = "(Z)V")
    public static void method2575() {
        if (Static41.method1027(MainLogicManager.step) || MainLogicManager.isAtLobbyScreen(MainLogicManager.step)) {
            Static127.method2243(Static412.anInt6358, Camera.positionX >> 12, Camera.positionZ >> 12);
        } else {
            @Pc(20) int local20 = PlayerEntity.self.pathX[0] >> 3;
            @Pc(27) int local27 = PlayerEntity.self.pathY[0] >> 3;
            if (local20 >= 0 && Static720.mapWidth >> 3 > local20 && local27 >= 0 && Static501.mapHeight >> 3 > local27) {
                Static127.method2243(Static412.anInt6358, local20, local27);
            } else {
                Static127.method2243(0, Static720.mapWidth >> 4, Static501.mapHeight >> 4);
            }
        }
        Static506.method8313();
        Static588.method7713();
        Static683.method8928();
        Static442.method5969();
    }
}
