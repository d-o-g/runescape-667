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

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(Lclient!ha;I)V")
    public static void method2449(@OriginalArg(0) Toolkit arg0) {
        @Pc(5) int local5 = 0;
        @Pc(7) int local7 = 0;
        if (InterfaceManager.aBoolean210) {
            local5 = Static130.method2283();
            local7 = Static422.method5771();
        }
        @Pc(19) int local19 = MiniMenu.x + local5;
        @Pc(23) int local23 = local7 + MiniMenu.y;
        @Pc(25) int local25 = MiniMenu.width;
        @Pc(29) int local29 = MiniMenu.height - 3;
        Static87.method1693(MiniMenu.width, MiniMenu.height, LocalisedText.CHOOSEOPTION.localise(client.language), arg0, local7 + MiniMenu.y, MiniMenu.x - -local5);
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
                if (local55 > local5 + MiniMenu.x && local55 < local5 + MiniMenu.x + MiniMenu.width && local66 > local89 - 13 && local66 < local89 + 4 && (local77.size > 1 || ((MiniMenuEntry) local77.entries.sentinel.next2).aBoolean552)) {
                    arg0.aa(local5 + MiniMenu.x, local89 + -12, MiniMenu.width, 16, 255 - Static405.anInt6255 << 24 | Static183.anInt3022, 1);
                }
                local70++;
            }
            if (MiniMenu.openedInner != null) {
                Static87.method1693(MiniMenu.openedInnerWidth, MiniMenu.openedInnerHeight, MiniMenu.openedInner.title, arg0, MiniMenu.openedInnerY, MiniMenu.openedInnerX);
                local70 = 0;
                for (local190 = (MiniMenuEntry) MiniMenu.openedInner.entries.first(); local190 != null; local190 = (MiniMenuEntry) MiniMenu.openedInner.entries.next()) {
                    local202 = MiniMenu.openedInnerY + local70 * 16 + 13 + 20;
                    if (MiniMenu.openedInnerX < local55 && MiniMenu.openedInnerX + MiniMenu.openedInnerWidth > local55 && local66 > local202 - 13 && local66 < local202 + 4 && local190.aBoolean552) {
                        arg0.aa(MiniMenu.openedInnerX, local202 - 12, MiniMenu.openedInnerWidth, 16, 255 - Static405.anInt6255 << 24 | Static183.anInt3022, 1);
                    }
                    local70++;
                }
                Static292.method4604(MiniMenu.openedInnerY, arg0, MiniMenu.openedInnerX, MiniMenu.openedInnerWidth, MiniMenu.openedInnerHeight);
            }
        } else {
            local70 = 0;
            for (local281 = (MiniMenuEntry) MiniMenu.entries.first(); local281 != null; local281 = (MiniMenuEntry) MiniMenu.entries.next()) {
                local89 = (MiniMenu.entryCount - local70 - 1) * 16 + local23 + 33;
                local70++;
                if (local5 + MiniMenu.x < local55 && local5 + MiniMenu.x + MiniMenu.width > local55 && local66 > local89 - 13 && local89 + 4 > local66 && local281.aBoolean552) {
                    arg0.aa(local5 + MiniMenu.x, local89 + -12, MiniMenu.width, 16, Static183.anInt3022 | 255 - Static405.anInt6255 << 24, 1);
                }
            }
        }
        Static292.method4604(local7 + MiniMenu.y, arg0, MiniMenu.x + local5, MiniMenu.width, MiniMenu.height);
        if (Static236.aBoolean304) {
            local70 = 0;
            for (local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local77 != null; local77 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
                local89 = local70 * 16 + local7 + MiniMenu.y + 33;
                if (local77.size == 1) {
                    MiniMenu.method3387(arg0, MiniMenu.width, MiniMenu.height, MiniMenu.y + local7, local89, Static634.anInt9510 | 0xFF000000, (MiniMenuEntry) local77.entries.sentinel.next2, Static563.anInt8455 | 0xFF000000, local66, MiniMenu.x + local5, local55);
                } else {
                    Static515.method6799(local66, MiniMenu.width, local89, Static634.anInt9510 | 0xFF000000, arg0, local55, Static563.anInt8455 | 0xFF000000, local7 + MiniMenu.y, local5 + MiniMenu.x, MiniMenu.height, local77);
                }
                local70++;
            }
            if (MiniMenu.openedInner != null) {
                local70 = 0;
                for (local190 = (MiniMenuEntry) MiniMenu.openedInner.entries.first(); local190 != null; local190 = (MiniMenuEntry) MiniMenu.openedInner.entries.next()) {
                    local202 = MiniMenu.openedInnerY + local70 * 16 + 20 + 13;
                    MiniMenu.method3387(arg0, MiniMenu.openedInnerWidth, MiniMenu.openedInnerHeight, MiniMenu.openedInnerY, local202, Static634.anInt9510 | 0xFF000000, local190, Static563.anInt8455 | 0xFF000000, local66, MiniMenu.openedInnerX, local55);
                    local70++;
                }
                Static422.method5773(MiniMenu.openedInnerX, MiniMenu.openedInnerY, MiniMenu.openedInnerWidth, MiniMenu.openedInnerHeight);
            }
        } else {
            local70 = 0;
            for (local281 = (MiniMenuEntry) MiniMenu.entries.first(); local281 != null; local281 = (MiniMenuEntry) MiniMenu.entries.next()) {
                local89 = local23 + (-local70 + -1 + MiniMenu.entryCount) * 16 + 13 + 20;
                local70++;
                MiniMenu.method3387(arg0, local25, local29, local23, local89, Static634.anInt9510 | 0xFF000000, local281, Static563.anInt8455 | 0xFF000000, local66, local19, local55);
            }
        }
        Static422.method5773(MiniMenu.x + local5, MiniMenu.y - -local7, MiniMenu.width, MiniMenu.height);
    }

}
