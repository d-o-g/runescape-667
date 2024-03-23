import com.jagex.core.datastruct.key.Class191;
import com.jagex.core.datastruct.key.Class299;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

public final class Static320 {

    @OriginalMember(owner = "client!kc", name = "e", descriptor = "I")
    public static int minHeight;

    @OriginalMember(owner = "client!kc", name = "f", descriptor = "I")
    public static int anInt5084;

    @OriginalMember(owner = "client!kc", name = "b", descriptor = "I")
    public static int anInt5085;

    @OriginalMember(owner = "client!kc", name = "a", descriptor = "Lclient!hw;")
    public static final Class172 aClass172_2 = new Class172();

    @OriginalMember(owner = "client!kc", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___135 = new ServerProt(85, -2);

    @OriginalMember(owner = "client!kc", name = "a", descriptor = "(Z)V")
    public static void method4598() {
        if (!MiniMenu.open) {
            Static236.aBoolean304 = Static143.anInt4059 != -1 && Static143.anInt4059 <= MiniMenu.entryCount || MiniMenu.entryCount * 16 + (Static60.aBoolean87 ? 26 : 22) > GameShell.canvasHei;
        }
        Static204.A_DEQUE___16.clear();
        Static239.A_DEQUE___19.clear();
        @Pc(64) int local64;
        for (@Pc(57) MiniMenuEntry local57 = (MiniMenuEntry) MiniMenu.entry.first(); local57 != null; local57 = (MiniMenuEntry) MiniMenu.entry.next()) {
            local64 = local57.action;
            if (local64 < 1000) {
                local57.unlink();
                if (local64 == 21 || local64 == 60 || local64 == 23 || local64 == 17 || local64 == 44 || local64 == 4 || local64 == 18) {
                    Static239.A_DEQUE___19.addLast(local57);
                } else {
                    Static204.A_DEQUE___16.addLast(local57);
                }
            }
        }
        Static204.A_DEQUE___16.appendTo(MiniMenu.entry);
        Static239.A_DEQUE___19.appendTo(MiniMenu.entry);
        if (MiniMenu.entryCount <= 1) {
            Static470.aClass2_Sub2_Sub16_10 = null;
            Static96.aClass2_Sub2_Sub16_13 = null;
        } else {
            if (Static209.aBoolean269 && KeyMonitor.instance.isPressed(81) && MiniMenu.entryCount > 2) {
                Static470.aClass2_Sub2_Sub16_10 = (MiniMenuEntry) MiniMenu.entry.sentinel.prev.prev;
            } else {
                Static470.aClass2_Sub2_Sub16_10 = (MiniMenuEntry) MiniMenu.entry.sentinel.prev;
            }
            Static96.aClass2_Sub2_Sub16_13 = (MiniMenuEntry) MiniMenu.entry.sentinel.prev;
        }
        local64 = -1;
        @Pc(204) MouseLog local204 = (MouseLog) Static226.mouseLogs.first();
        if (local204 != null) {
            local64 = local204.getType();
        }
        if (!MiniMenu.open) {
            if (local64 == 0 && (Static219.mouseButtons == 1 && MiniMenu.entryCount > 2 || MiniMenu.topEntryIsIfButtonX1())) {
                local64 = 2;
            }
            if (local64 == 2 && MiniMenu.entryCount > 0 && local204 != null) {
                if (InterfaceManager.dragSource == null && Static460.anInt6964 == 0) {
                    Static572.method7876(local204.getY(), local204.getX());
                } else {
                    Static536.anInt8149 = 2;
                }
            }
            if (local64 == 0) {
                if (Static470.aClass2_Sub2_Sub16_10 != null) {
                    Static407.method5628();
                } else if (InterfaceManager.targeting) {
                    InterfaceManager.endTargetMode();
                }
            }
            if (InterfaceManager.dragSource == null && Static460.anInt6964 == 0) {
                Static75.aClass2_Sub2_Sub16_9 = null;
                Static536.anInt8149 = 0;
            }
            return;
        }
        @Pc(317) int local317;
        @Pc(321) int local321;
        @Pc(426) int local426;
        @Pc(428) int local428;
        if (local64 == -1) {
            local317 = MouseMonitor.instance.getRecordedX();
            local321 = MouseMonitor.instance.getRecordedY();
            @Pc(323) boolean local323 = false;
            if (Static139.aClass2_Sub2_Sub4_1 != null) {
                if (local317 >= Static692.anInt10375 - 10 && local317 <= Static692.anInt10375 + Static85.anInt10675 + 10 && Static493.anInt7364 - 10 <= local321 && local321 <= Static493.anInt7364 + Static25.anInt598 + 10) {
                    local323 = true;
                } else {
                    Static329.method1636();
                }
            }
            if (!local323) {
                if (Static71.anInt1576 - 10 > local317 || Static71.anInt1576 + Static682.anInt10295 + 10 < local317 || Static84.anInt1775 - 10 > local321 || local321 > Static407.anInt6288 + Static84.anInt1775 + 10) {
                    Static488.method6522();
                } else if (Static236.aBoolean304) {
                    local426 = -1;
                    local428 = -1;
                    @Pc(444) int local444;
                    for (@Pc(430) int local430 = 0; local430 < MiniMenu.innerCount; local430++) {
                        if (Static60.aBoolean87) {
                            local444 = local430 * 16 + Static84.anInt1775 + 33;
                            if (local321 > local444 - 13 && local444 + 4 > local321) {
                                local426 = local430;
                                local428 = local444 - 13;
                                break;
                            }
                        } else {
                            local444 = local430 * 16 + Static84.anInt1775 + 31;
                            if (local444 - 13 < local321 && local321 < local444 + 3) {
                                local428 = local444 - 13;
                                local426 = local430;
                                break;
                            }
                        }
                    }
                    if (local426 != -1) {
                        local444 = 0;
                        @Pc(525) Class299 local525 = new Class299(MiniMenu.innerEntries);
                        for (@Pc(530) MiniMenuEntryInner local530 = (MiniMenuEntryInner) local525.first(); local530 != null; local530 = (MiniMenuEntryInner) local525.next()) {
                            if (local444 == local426) {
                                if (local530.size > 1) {
                                    Static609.method8214(local428, local321, local530);
                                }
                                break;
                            }
                            local444++;
                        }
                    }
                }
            }
        }
        if (local64 != 0) {
            return;
        }
        local317 = local204.getX();
        local321 = local204.getY();
        @Pc(661) int local661;
        @Pc(886) Class299 local886;
        @Pc(762) MiniMenuEntry local762;
        if (Static139.aClass2_Sub2_Sub4_1 != null && Static692.anInt10375 <= local317 && Static85.anInt10675 + Static692.anInt10375 >= local317 && local321 >= Static493.anInt7364 && Static493.anInt7364 + Static25.anInt598 >= local321) {
            local661 = -1;
            for (local426 = 0; local426 < Static139.aClass2_Sub2_Sub4_1.size; local426++) {
                if (Static60.aBoolean87) {
                    local428 = local426 * 16 + Static493.anInt7364 + 33;
                    if (local321 > local428 - 13 && local428 + 4 > local321) {
                        local661 = local426;
                    }
                } else {
                    local428 = local426 * 16 + Static493.anInt7364 + 31;
                    if (local321 > local428 - 13 && local321 < local428 + 3) {
                        local661 = local426;
                    }
                }
            }
            if (local661 != -1) {
                local428 = 0;
                local886 = new Class299(Static139.aClass2_Sub2_Sub4_1.entries);
                for (local762 = (MiniMenuEntry) local886.first(); local762 != null; local762 = (MiniMenuEntry) local886.next()) {
                    if (local661 == local428) {
                        Static55.method1217(local321, local762, local317);
                        break;
                    }
                    local428++;
                }
            }
            Static488.method6522();
            return;
        }
        if (Static71.anInt1576 > local317 || Static71.anInt1576 + Static682.anInt10295 < local317 || Static84.anInt1775 > local321 || local321 > Static407.anInt6288 + Static84.anInt1775) {
            return;
        }
        if (!Static236.aBoolean304) {
            local661 = -1;
            for (local426 = 0; local426 < MiniMenu.entryCount; local426++) {
                if (Static60.aBoolean87) {
                    local428 = (MiniMenu.entryCount - local426 - 1) * 16 + Static84.anInt1775 + 33;
                    if (local321 > local428 - 13 && local321 < local428 + 4) {
                        local661 = local426;
                    }
                } else {
                    local428 = Static84.anInt1775 + (-local426 + MiniMenu.entryCount + -1) * 16 + 31;
                    if (local321 > local428 - 13 && local428 + 3 > local321) {
                        local661 = local426;
                    }
                }
            }
            if (local661 != -1) {
                local428 = 0;
                @Pc(757) Class191 local757 = new Class191(MiniMenu.entry);
                for (local762 = (MiniMenuEntry) local757.first(); local762 != null; local762 = (MiniMenuEntry) local757.next()) {
                    if (local661 == local428) {
                        Static55.method1217(local321, local762, local317);
                        break;
                    }
                    local428++;
                }
            }
            Static488.method6522();
            return;
        }
        local661 = -1;
        for (local426 = 0; local426 < MiniMenu.innerCount; local426++) {
            if (Static60.aBoolean87) {
                local428 = local426 * 16 + Static84.anInt1775 + 33;
                if (local428 - 13 < local321 && local321 < local428 + 4) {
                    local661 = local426;
                    break;
                }
            } else {
                local428 = Static84.anInt1775 + local426 * 16 + 31;
                if (local321 > local428 - 13 && local321 < local428 + 3) {
                    local661 = local426;
                    break;
                }
            }
        }
        if (local661 == -1) {
            return;
        }
        local428 = 0;
        local886 = new Class299(MiniMenu.innerEntries);
        for (@Pc(891) MiniMenuEntryInner local891 = (MiniMenuEntryInner) local886.first(); local891 != null; local891 = (MiniMenuEntryInner) local886.next()) {
            if (local428 == local661) {
                Static55.method1217(local321, (MiniMenuEntry) local891.entries.sentinel.next2, local317);
                Static488.method6522();
                return;
            }
            local428++;
        }
        return;
    }
}
