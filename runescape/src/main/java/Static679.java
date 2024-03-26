import com.jagex.DisplayProperties;
import com.jagex.ServerProt;
import com.jagex.core.datastruct.key.DequeIterator;
import com.jagex.core.datastruct.key.QueueIterator;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

public final class Static679 {

    @OriginalMember(owner = "client!vj", name = "x", descriptor = "I")
    public static int anInt10273;

    @OriginalMember(owner = "client!vj", name = "E", descriptor = "[Lclient!qf;")
    public static PositionEntity[] aPositionEntity;

    @OriginalMember(owner = "client!vj", name = "t", descriptor = "I")
    public static int anInt10278;

    @OriginalMember(owner = "client!vj", name = "H", descriptor = "[Lclient!oga;")
    public static DisplayProperties[] aDisplayPropertiesArray1;

    @OriginalMember(owner = "client!vj", name = "s", descriptor = "Lclient!eba;")
    public static final Class92 aClass92_15 = new Class92(1);

    @OriginalMember(owner = "client!vj", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___247 = new ServerProt(63, 5);

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(Z)I")
    public static int method8909() {
        if (InterfaceManager.dragSource != null) {
            return -1;
        }

        if (!MiniMenu.open && MiniMenu.leftClickEntry != null) {
            return MiniMenu.leftClickEntry.cursor;
        }

        @Pc(28) int recordedX = MouseMonitor.instance.getRecordedX();
        @Pc(37) int recordedY = MouseMonitor.instance.getRecordedY();
        @Pc(53) int local53;
        @Pc(55) int local55;
        @Pc(71) int local71;

        @Pc(134) MiniMenuEntry local134;
        if (Static236.aBoolean304) {
            @Pc(262) QueueIterator local262;
            if (MiniMenu.x < recordedX && MiniMenu.x + MiniMenu.width > recordedX) {
                local53 = -1;
                for (local55 = 0; local55 < MiniMenu.innerCount; local55++) {
                    if (Static60.aBoolean87) {
                        local71 = MiniMenu.y + local55 * 16 + 33;
                        if (recordedY > local71 - 13 && recordedY <= local71 + 3) {
                            local53 = local55;
                        }
                    } else {
                        local71 = MiniMenu.y + local55 * 16 + 31;
                        if (recordedY > local71 - 13 && local71 + 3 >= recordedY) {
                            local53 = local55;
                        }
                    }
                }

                if (local53 != -1) {
                    local71 = 0;
                    local262 = new QueueIterator(MiniMenu.innerEntries);
                    for (@Pc(368) MiniMenuEntryInner local368 = (MiniMenuEntryInner) local262.first(); local368 != null; local368 = (MiniMenuEntryInner) local262.next()) {
                        if (local71++ == local53) {
                            return ((MiniMenuEntry) local368.entries.sentinel.next2).cursor;
                        }
                    }
                }
            } else if (MiniMenu.openedInner != null && MiniMenu.openedInnerX < recordedX && recordedX < MiniMenu.openedInnerWidth + MiniMenu.openedInnerX) {
                local53 = -1;
                for (local55 = 0; local55 < MiniMenu.openedInner.size; local55++) {
                    if (Static60.aBoolean87) {
                        local71 = local55 * 16 + MiniMenu.openedInnerY + 33;
                        if (local71 - 13 < recordedY && local71 + 3 >= recordedY) {
                            local53 = local55;
                        }
                    } else {
                        local71 = MiniMenu.openedInnerY + local55 * 16 + 31;
                        if (recordedY > local71 - 13 && recordedY <= local71 + 3) {
                            local53 = local55;
                        }
                    }
                }
                if (local53 != -1) {
                    local71 = 0;
                    local262 = new QueueIterator(MiniMenu.openedInner.entries);
                    for (local134 = (MiniMenuEntry) local262.first(); local134 != null; local134 = (MiniMenuEntry) local262.next()) {
                        if (local71++ == local53) {
                            return local134.cursor;
                        }
                    }
                }
            }
        } else if (recordedX > MiniMenu.x && MiniMenu.x + MiniMenu.width > recordedX) {
            local53 = -1;
            for (local55 = 0; local55 < MiniMenu.entryCount; local55++) {
                if (Static60.aBoolean87) {
                    local71 = (MiniMenu.entryCount - local55 - 1) * 16 + MiniMenu.y + 33;
                    if (recordedY > local71 - 13 && local71 + 3 >= recordedY) {
                        local53 = local55;
                    }
                } else {
                    local71 = MiniMenu.y + (-local55 + MiniMenu.entryCount + -1) * 16 + 31;
                    if (recordedY > local71 - 13 && local71 + 3 >= recordedY) {
                        local53 = local55;
                    }
                }
            }
            if (local53 != -1) {
                local71 = 0;
                @Pc(129) DequeIterator local129 = new DequeIterator(MiniMenu.entries);
                for (local134 = (MiniMenuEntry) local129.first(); local134 != null; local134 = (MiniMenuEntry) local129.next()) {
                    if (local53 == local71++) {
                        return local134.cursor;
                    }
                }
            }
        }
        return -1;
    }

}
