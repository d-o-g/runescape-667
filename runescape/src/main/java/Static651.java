import com.jagex.core.constants.ModeGame;
import com.jagex.game.Animator;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.seqtype.SeqReplayMode;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.graphics.Interface9;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static651 {

    @OriginalMember(owner = "client!uja", name = "j", descriptor = "Lclient!rt;")
    public static Class327 aClass327_8;

    @OriginalMember(owner = "client!uja", name = "p", descriptor = "[Lclient!gaa;")
    public static Interface9[] anInterface9Array1;

    @OriginalMember(owner = "client!uja", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___235 = new ServerProt(43, -2);

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(IIIILclient!cg;)V")
    public static void method8513(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) Class8_Sub2_Sub1_Sub2 arg3) {
        @Pc(9) BASType local9 = arg3.method9317();
        @Pc(19) Animator local19 = arg3.animator;
        @Pc(29) int local29 = arg3.anInt10756 - arg3.aClass126_7.anInt2889 & 0x3FFF;
        if (arg0 == -1) {
            if (local29 == 0 && arg3.anInt10749 <= 25) {
                if (!arg3.ready || !local9.isReady(local19.getAnimationId())) {
                    local19.update(true, local9.ready());
                    arg3.ready = local19.isAnimating();
                }
            } else if (arg1 < 0 && local9.readyTurnCcw != -1) {
                local19.update(true, local9.readyTurnCcw);
                arg3.ready = false;
            } else if (arg1 > 0 && local9.readyTurnCw != -1) {
                local19.update(true, local9.readyTurnCw);
                arg3.ready = false;
            } else if (!arg3.ready || !local9.isReady(local19.getAnimationId())) {
                local19.update(true, local9.ready());
                arg3.ready = arg3.animator.isAnimating();
            }
        } else if (arg3.anInt10722 != -1 && (local29 >= 10240 || local29 <= 2048)) {
            @Pc(172) int local172 = Static464.anIntArray561[arg2] - arg3.aClass126_7.anInt2889 & 0x3FFF;
            if (arg0 == 2 && local9.run != -1) {
                if (local172 > 2048 && local172 <= 6144 && local9.runFollowTurnCw != -1) {
                    local19.update(true, local9.runFollowTurnCw);
                } else if (local172 >= 10240 && local172 < 14336 && local9.runFollowTurnCcw != -1) {
                    local19.update(true, local9.runFollowTurnCcw);
                } else if (local172 <= 6144 || local172 >= 10240 || local9.runFollowTurn180 == -1) {
                    local19.update(true, local9.run);
                } else {
                    local19.update(true, local9.runFollowTurn180);
                }
            } else if (arg0 == 0 && local9.crawl != -1) {
                if (local172 > 2048 && local172 <= 6144 && local9.crawlFollowTurnCw != -1) {
                    local19.update(true, local9.crawlFollowTurnCw);
                } else if (local172 >= 10240 && local172 < 14336 && local9.crawlFollowTurnCcw != -1) {
                    local19.update(true, local9.crawlFollowTurnCcw);
                } else if (local172 <= 6144 || local172 >= 10240 || local9.crawlFollowTurn180 == -1) {
                    local19.update(true, local9.crawl);
                } else {
                    local19.update(true, local9.crawlFollowTurn180);
                }
            } else if (local172 > 2048 && local172 <= 6144 && local9.walkFollowTurnCw != -1) {
                local19.update(true, local9.walkFollowTurnCw);
            } else if (local172 >= 10240 && local172 < 14336 && local9.walkFollowTurnCcw != -1) {
                local19.update(true, local9.walkFollowTurnCcw);
            } else if (local172 <= 6144 || local172 >= 10240 || local9.walkFollowTurn180 == -1) {
                local19.update(true, local9.walk);
            } else {
                local19.update(true, local9.walkFollowTurn180);
            }
            arg3.ready = false;
        } else if (local29 == 0 && arg3.anInt10749 <= 25) {
            if (arg0 == 2 && local9.run != -1) {
                local19.update(true, local9.run);
            } else if (arg0 == 0 && local9.crawl != -1) {
                local19.update(true, local9.crawl);
            } else {
                local19.update(true, local9.walk);
            }
            arg3.ready = false;
        } else {
            if (arg0 == 2 && local9.run != -1) {
                if (arg1 < 0 && local9.runTurnCcw != -1) {
                    local19.update(true, local9.runTurnCcw);
                } else if (arg1 <= 0 || local9.runTurnCw == -1) {
                    local19.update(true, local9.run);
                } else {
                    local19.update(true, local9.runTurnCw);
                }
            } else if (arg0 == 0 && local9.crawl != -1) {
                if (arg1 < 0 && local9.crawlTurnCcw != -1) {
                    local19.update(true, local9.crawlTurnCcw);
                } else if (arg1 <= 0 || local9.crawlTurnCw == -1) {
                    local19.update(true, local9.crawl);
                } else {
                    local19.update(true, local9.crawlTurnCw);
                }
            } else if (arg1 < 0 && local9.walkTurnCcw != -1) {
                local19.update(true, local9.walkTurnCcw);
            } else if (arg1 <= 0 || local9.walkTurnCw == -1) {
                local19.update(true, local9.walk);
            } else {
                local19.update(true, local9.walkTurnCw);
            }
            arg3.ready = false;
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "([IIZLclient!cg;I)V")
    public static void method8515(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Class8_Sub2_Sub1_Sub2 arg3) {
        @Pc(8) boolean local8;
        @Pc(10) int local10;
        if (arg3.anIntArray869 != null) {
            local8 = true;
            for (local10 = 0; local10 < arg3.anIntArray869.length; local10++) {
                if (arg0[local10] != arg3.anIntArray869[local10]) {
                    local8 = false;
                    break;
                }
            }
            @Pc(31) Animator local31 = arg3.aAnimator_11;
            if (local8 && local31.isAnimating()) {
                @Pc(44) SeqType local44 = arg3.aAnimator_11.getAnimation();
                @Pc(47) int replayMode = local44.replayMode;
                if (replayMode == SeqReplayMode.RESET) {
                    local31.reset(arg1);
                }
                if (replayMode == SeqReplayMode.RESTART_LOOP) {
                    local31.restartLoop();
                }
            }
        }
        local8 = true;
        for (local10 = 0; local10 < arg0.length; local10++) {
            if (arg0[local10] != -1) {
                local8 = false;
            }
            if (arg3.anIntArray869 == null || arg3.anIntArray869[local10] == -1 || Static25.seqTypeList.list(arg0[local10]).priority >= Static25.seqTypeList.list(arg3.anIntArray869[local10]).priority) {
                arg3.anIntArray869 = arg0;
                arg3.aAnimator_11.method9091(arg1);
                if (arg2) {
                    arg3.anInt10762 = arg3.anInt10764;
                }
            }
        }
        if (!local8) {
            return;
        }
        arg3.anIntArray869 = arg0;
        arg3.aAnimator_11.method9091(arg1);
        if (arg2) {
            arg3.anInt10762 = arg3.anInt10764;
            return;
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(I)Z")
    public static boolean method8516() {
        return Static14.loadNativeLibrary("jaclib") ? Static14.loadNativeLibrary("hw3d") : false;
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(IZLclient!wj;)V")
    public static void method8517(@OriginalArg(1) boolean arg0, @OriginalArg(2) NPCEntity arg1) {
        if (MiniMenu.optionCount >= 400) {
            return;
        }
        @Pc(21) NPCType local21 = arg1.type;
        @Pc(24) String local24 = arg1.aString128;
        if (local21.multinpcs != null) {
            local21 = local21.getMultiNPC(TimedVarDomain.instance);
            if (local21 == null) {
                return;
            }
            local24 = local21.name;
        }
        if (!local21.interactive) {
            return;
        }
        if (arg1.anInt10791 != 0) {
            @Pc(67) String local67 = ModeGame.STELLAR_DAWN == client.modeGame ? LocalisedText.RATING.localise(Static51.language) : LocalisedText.LEVEL.localise(Static51.language);
            local24 = local24 + Static693.method9009(PlayerEntity.self.anInt1444, arg1.anInt10791) + " (" + local67 + arg1.anInt10791 + ")";
        }
        if (InterfaceManager.isTargeting && !arg0) {
            @Pc(113) ParamType local113 = Static610.anInt9329 == -1 ? null : Static523.instance.list(Static610.anInt9329);
            if ((InterfaceManager.targetMask & 0x2) != 0 && (local113 == null || local21.param(Static610.anInt9329, local113.defaultint) != local113.defaultint)) {
                MiniMenu.addEntry(false, -1, (long) arg1.anInt10740, 0, 0, InterfaceManager.targetVerb, 23, true, Cursor.targetEnter, InterfaceManager.targetedVerb + " -> <col=ffff00>" + local24, (long) arg1.anInt10740, false);
            }
        }
        if (arg0) {
            return;
        }
        @Pc(176) String[] local176 = local21.op;
        if (Static187.aBoolean255) {
            local176 = Static246.method3522(local176);
        }
        if (local176 == null) {
            return;
        }
        for (@Pc(189) int local189 = local176.length - 1; local189 >= 0; local189--) {
            if (local176[local189] != null && (local21.aByte107 == 0 || !local176[local189].equalsIgnoreCase(LocalisedText.ATTACK.localise(Static51.language)) && !local176[local189].equalsIgnoreCase(LocalisedText.EXAMINE.localise(Static51.language)))) {
                @Pc(226) short local226 = 0;
                @Pc(228) int local228 = Cursor.interaction;
                if (local189 == 0) {
                    local226 = 49;
                }
                if (local189 == 1) {
                    local226 = 59;
                }
                if (local189 == 2) {
                    local226 = 47;
                }
                if (local189 == 3) {
                    local226 = 57;
                }
                if (local189 == 4) {
                    local226 = 3;
                }
                if (local189 == 5) {
                    local226 = 1011;
                }
                if (local189 == local21.cursor1Op) {
                    local228 = local21.cursor1;
                }
                if (local21.cursor2Op == local189) {
                    local228 = local21.cursor2;
                }
                MiniMenu.addEntry(false, -1, (long) arg1.anInt10740, 0, 0, local176[local189], local226, true, local176[local189].equalsIgnoreCase(LocalisedText.ATTACK.localise(Static51.language)) ? local21.attackCursor : local228, "<col=ffff00>" + local24, (long) arg1.anInt10740, false);
            }
        }
        if (local21.aByte107 != 1) {
            return;
        }
        for (@Pc(341) int local341 = 0; local341 < local176.length; local341++) {
            if (local176[local341] != null && (local176[local341].equalsIgnoreCase(LocalisedText.ATTACK.localise(Static51.language)) || local176[local341].equalsIgnoreCase(LocalisedText.EXAMINE.localise(Static51.language)))) {
                @Pc(372) short local372 = 0;
                if (arg1.anInt10791 > PlayerEntity.self.anInt1444) {
                    local372 = 2000;
                }
                @Pc(385) short local385 = 0;
                @Pc(387) int local387 = Cursor.interaction;
                if (local341 == 0) {
                    local385 = 49;
                }
                if (local341 == 1) {
                    local385 = 59;
                }
                if (local341 == 2) {
                    local385 = 47;
                }
                if (local341 == 3) {
                    local385 = 57;
                }
                if (local341 == 4) {
                    local385 = 3;
                }
                if (local341 == 5) {
                    local385 = 1011;
                }
                if (local21.cursor1Op == local341) {
                    local387 = local21.cursor1;
                }
                if (local385 != 0) {
                    local385 += local372;
                }
                if (local21.cursor2Op == local341) {
                    local387 = local21.cursor2;
                }
                MiniMenu.addEntry(false, -1, (long) arg1.anInt10740, 0, 0, local176[local341], local385, true, local176[local341].equalsIgnoreCase(LocalisedText.ATTACK.localise(Static51.language)) ? local21.attackCursor : local387, "<col=ffff00>" + local24, (long) arg1.anInt10740, false);
            }
        }
        return;
    }
}
