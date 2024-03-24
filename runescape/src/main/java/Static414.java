import com.jagex.IndexedImage;
import com.jagex.core.constants.ModeGame;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static414 {

    @OriginalMember(owner = "client!nba", name = "i", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_2;

    @OriginalMember(owner = "client!nba", name = "b", descriptor = "[F")
    public static final float[] aFloatArray43 = new float[2];

    @OriginalMember(owner = "client!nba", name = "a", descriptor = "(ZLclient!ca;I)V")
    public static void method5696(@OriginalArg(0) boolean arg0, @OriginalArg(1) PlayerEntity arg1) {
        if (MiniMenu.entryCount >= 400) {
            return;
        }
        if (arg1 != PlayerEntity.self) {
            @Pc(177) String local177;
            if (arg1.anInt1436 == 0) {
                @Pc(63) boolean local63 = true;
                if (PlayerEntity.self.anInt1471 != -1 && arg1.anInt1471 != -1) {
                    @Pc(91) int local91 = PlayerEntity.self.anInt1471 < arg1.anInt1471 ? PlayerEntity.self.anInt1471 : arg1.anInt1471;
                    @Pc(98) int local98 = PlayerEntity.self.combatLevel - arg1.combatLevel;
                    if (local98 < 0) {
                        local98 = -local98;
                    }
                    if (local98 > local91) {
                        local63 = false;
                    }
                }
                @Pc(129) String local129 = ModeGame.STELLAR_DAWN == client.modeGame ? LocalisedText.RATING.localise(client.language) : LocalisedText.LEVEL.localise(client.language);
                if (arg1.combatLevel >= arg1.anInt1437) {
                    local177 = arg1.method1424(false) + (local63 ? MiniMenu.colourCode(PlayerEntity.self.combatLevel, arg1.combatLevel) : "<col=ffffff>") + " (" + local129 + arg1.combatLevel + ")";
                } else {
                    local177 = arg1.method1424(false) + (local63 ? MiniMenu.colourCode(PlayerEntity.self.combatLevel, arg1.combatLevel) : "<col=ffffff>") + " (" + local129 + arg1.combatLevel + "+" + (arg1.anInt1437 - arg1.combatLevel) + ")";
                }
            } else if (arg1.anInt1436 == -1) {
                local177 = arg1.method1424(false);
            } else {
                local177 = arg1.method1424(false) + " (" + LocalisedText.SKILL.localise(client.language) + arg1.anInt1436 + ")";
            }
            if (InterfaceManager.targeting && !arg0 && (InterfaceManager.targetMask & 0x8) != 0) {
                MiniMenu.addEntry(false, -1, arg1.id, 0, 0, InterfaceManager.targetVerb, 44, true, InterfaceManager.targetEnterCursor, InterfaceManager.targetedVerb + " -> <col=ffffff>" + local177, arg1.id, false);
            }
            if (arg0) {
                MiniMenu.addEntry(true, 0, 0L, 0, 0, "<col=cccccc>" + local177, -1, false, -1, "", arg1.id, false);
            } else {
                for (@Pc(318) int local318 = 7; local318 >= 0; local318--) {
                    if (Static297.aStringArray24[local318] != null) {
                        @Pc(325) short local325 = 0;
                        if (client.modeGame == ModeGame.RUNESCAPE && Static297.aStringArray24[local318].equalsIgnoreCase(LocalisedText.ATTACK.localise(client.language))) {
                            if (Static324.aBoolean388 && PlayerEntity.self.combatLevel < arg1.combatLevel) {
                                local325 = 2000;
                            }
                            if (PlayerEntity.self.anInt1433 == 0 || arg1.anInt1433 == 0) {
                                if (arg1.aBoolean125) {
                                    local325 = 2000;
                                }
                            } else if (arg1.anInt1433 == PlayerEntity.self.anInt1433) {
                                local325 = 2000;
                            } else {
                                local325 = 0;
                            }
                        } else if (Static601.aBooleanArray28[local318]) {
                            local325 = 2000;
                        }
                        @Pc(403) short local403 = (short) (local325 + Static187.aShortArray52[local318]);
                        @Pc(416) int local416 = Static147.anIntArray227[local318] == -1 ? Cursor.interaction : Static147.anIntArray227[local318];
                        MiniMenu.addEntry(false, -1, arg1.id, 0, 0, Static297.aStringArray24[local318], local403, true, local416, "<col=ffffff>" + local177, arg1.id, false);
                    }
                }
            }
            if (!arg0) {
                for (@Pc(484) MiniMenuEntry local484 = (MiniMenuEntry) MiniMenu.entry.first(); local484 != null; local484 = (MiniMenuEntry) MiniMenu.entry.next()) {
                    if (local484.action == 58) {
                        local484.aString88 = "<col=ffffff>" + local177;
                        return;
                    }
                }
            }
        } else if (InterfaceManager.targeting && (InterfaceManager.targetMask & 0x10) != 0) {
            MiniMenu.addEntry(false, -1, 0L, 0, 0, InterfaceManager.targetVerb, 4, true, InterfaceManager.targetEnterCursor, InterfaceManager.targetedVerb + " -> <col=ffffff>" + LocalisedText.SELF.localise(client.language), arg1.id, false);
        }
    }

    @OriginalMember(owner = "client!nba", name = "a", descriptor = "(III)V")
    public static void method5697(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        if (client.modeGame == ModeGame.STELLAR_DAWN) {
            if (!Static147.method2419(0, arg0, 1, false, arg1, 0, -2, 1)) {
                Static147.method2419(0, arg0, 1, false, arg1, 0, -3, 1);
            }
        } else if (!Static147.method2419(0, arg0, 1, false, arg1, 0, -3, 1)) {
            Static147.method2419(0, arg0, 1, false, arg1, 0, -2, 1);
        }
    }
}
