import com.jagex.core.datastruct.LinkedList;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

public final class Static149 {

    @OriginalMember(owner = "client!ema", name = "k", descriptor = "I")
    public static int anInt2623;

    @OriginalMember(owner = "client!ema", name = "c", descriptor = "Lclient!fla;")
    public static final LinkedList A_ENTITY_LIST___4 = new LinkedList();

    @OriginalMember(owner = "client!ema", name = "o", descriptor = "Z")
    public static boolean aBoolean221 = false;

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(Lclient!ha;I)V")
    public static void method2449(@OriginalArg(0) Toolkit arg0) {
        @Pc(5) int local5 = 0;
        @Pc(7) int local7 = 0;
        if (InterfaceManager.aBoolean210) {
            local5 = Static130.method2283();
            local7 = Static422.method5771();
        }
        @Pc(19) int local19 = Static71.anInt1576 + local5;
        @Pc(23) int local23 = local7 + Static84.anInt1775;
        @Pc(25) int local25 = Static682.anInt10295;
        @Pc(29) int local29 = Static407.anInt6288 - 3;
        Static87.method1693(Static682.anInt10295, Static407.anInt6288, LocalisedText.CHOOSEOPTION.localise(client.language), arg0, local7 + Static84.anInt1775, Static71.anInt1576 - -local5);
        @Pc(55) int local55 = MouseMonitor.instance.getRecordedX() + local5;
        @Pc(66) int local66 = local7 + MouseMonitor.instance.getRecordedY();
        @Pc(70) int local70;
        @Pc(77) MiniMenuEntryInner local77;
        @Pc(89) int local89;
        @Pc(202) int local202;
        @Pc(281) MiniMenuEntry local281;
        @Pc(190) MiniMenuEntry local190;
        if (Static236.aBoolean304) {
            local70 = 0;
            for (local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local77 != null; local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
                local89 = local23 + local70 * 16 + 13 + 20;
                if (local55 > local5 + Static71.anInt1576 && local55 < local5 + Static71.anInt1576 + Static682.anInt10295 && local66 > local89 - 13 && local66 < local89 + 4 && (local77.size > 1 || ((MiniMenuEntry) local77.entries.sentinel.next2).aBoolean552)) {
                    arg0.aa(local5 + Static71.anInt1576, local89 + -12, Static682.anInt10295, 16, 255 - Static405.anInt6255 << 24 | Static183.anInt3022, 1);
                }
                local70++;
            }
            if (Static139.aClass2_Sub2_Sub4_1 != null) {
                Static87.method1693(Static85.anInt10675, Static25.anInt598, Static139.aClass2_Sub2_Sub4_1.title, arg0, Static493.anInt7364, Static692.anInt10375);
                local70 = 0;
                for (local190 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.first(); local190 != null; local190 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.next()) {
                    local202 = Static493.anInt7364 + local70 * 16 + 13 + 20;
                    if (Static692.anInt10375 < local55 && Static692.anInt10375 + Static85.anInt10675 > local55 && local66 > local202 - 13 && local66 < local202 + 4 && local190.aBoolean552) {
                        arg0.aa(Static692.anInt10375, local202 - 12, Static85.anInt10675, 16, 255 - Static405.anInt6255 << 24 | Static183.anInt3022, 1);
                    }
                    local70++;
                }
                Static292.method4604(Static493.anInt7364, arg0, Static692.anInt10375, Static85.anInt10675, Static25.anInt598);
            }
        } else {
            local70 = 0;
            for (local281 = (MiniMenuEntry) MiniMenu.entry.first(); local281 != null; local281 = (MiniMenuEntry) MiniMenu.entry.next()) {
                local89 = (MiniMenu.entryCount - local70 - 1) * 16 + local23 + 33;
                local70++;
                if (local5 + Static71.anInt1576 < local55 && local5 + Static71.anInt1576 + Static682.anInt10295 > local55 && local66 > local89 - 13 && local89 + 4 > local66 && local281.aBoolean552) {
                    arg0.aa(local5 + Static71.anInt1576, local89 + -12, Static682.anInt10295, 16, Static183.anInt3022 | 255 - Static405.anInt6255 << 24, 1);
                }
            }
        }
        Static292.method4604(local7 + Static84.anInt1775, arg0, Static71.anInt1576 + local5, Static682.anInt10295, Static407.anInt6288);
        if (Static236.aBoolean304) {
            local70 = 0;
            for (local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local77 != null; local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
                local89 = local70 * 16 + local7 + Static84.anInt1775 + 33;
                if (local77.size == 1) {
                    MiniMenu.method3387(arg0, Static682.anInt10295, Static407.anInt6288, Static84.anInt1775 + local7, local89, Static634.anInt9510 | 0xFF000000, (MiniMenuEntry) local77.entries.sentinel.next2, Static563.anInt8455 | 0xFF000000, local66, Static71.anInt1576 + local5, local55);
                } else {
                    Static515.method6799(local66, Static682.anInt10295, local89, Static634.anInt9510 | 0xFF000000, arg0, local55, Static563.anInt8455 | 0xFF000000, local7 + Static84.anInt1775, local5 + Static71.anInt1576, Static407.anInt6288, local77);
                }
                local70++;
            }
            if (Static139.aClass2_Sub2_Sub4_1 != null) {
                local70 = 0;
                for (local190 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.first(); local190 != null; local190 = (MiniMenuEntry) Static139.aClass2_Sub2_Sub4_1.entries.next()) {
                    local202 = Static493.anInt7364 + local70 * 16 + 20 + 13;
                    MiniMenu.method3387(arg0, Static85.anInt10675, Static25.anInt598, Static493.anInt7364, local202, Static634.anInt9510 | 0xFF000000, local190, Static563.anInt8455 | 0xFF000000, local66, Static692.anInt10375, local55);
                    local70++;
                }
                Static422.method5773(Static692.anInt10375, Static493.anInt7364, Static85.anInt10675, Static25.anInt598);
            }
        } else {
            local70 = 0;
            for (local281 = (MiniMenuEntry) MiniMenu.entry.first(); local281 != null; local281 = (MiniMenuEntry) MiniMenu.entry.next()) {
                local89 = local23 + (-local70 + -1 + MiniMenu.entryCount) * 16 + 13 + 20;
                local70++;
                MiniMenu.method3387(arg0, local25, local29, local23, local89, Static634.anInt9510 | 0xFF000000, local281, Static563.anInt8455 | 0xFF000000, local66, local19, local55);
            }
        }
        Static422.method5773(Static71.anInt1576 + local5, Static84.anInt1775 - -local7, Static682.anInt10295, Static407.anInt6288);
    }

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(I)V")
    public static void method2450() {
        Static186.A_WEIGHTED_CACHE___67.removeSoftReferences();
    }
}
