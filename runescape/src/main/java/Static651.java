import com.jagex.game.Animator;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.seqtype.SeqReplayMode;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
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
    public static void method8513(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) PathingEntity arg3) {
        @Pc(9) BASType local9 = arg3.getBASType();
        @Pc(19) Animator local19 = arg3.animator;
        @Pc(29) int local29 = arg3.turnYaw - arg3.yaw.value & 0x3FFF;
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
        } else if (arg3.target != -1 && (local29 >= 10240 || local29 <= 2048)) {
            @Pc(172) int local172 = Static464.anIntArray561[arg2] - arg3.yaw.value & 0x3FFF;
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
    public static void animate(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) PathingEntity arg3) {
        @Pc(8) boolean local8;
        @Pc(10) int local10;
        if (arg3.actionAnimations != null) {
            local8 = true;
            for (local10 = 0; local10 < arg3.actionAnimations.length; local10++) {
                if (arg0[local10] != arg3.actionAnimations[local10]) {
                    local8 = false;
                    break;
                }
            }
            @Pc(31) Animator local31 = arg3.actionAnimator;
            if (local8 && local31.isAnimating()) {
                @Pc(44) SeqType local44 = arg3.actionAnimator.getAnimation();
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
            if (arg3.actionAnimations == null || arg3.actionAnimations[local10] == -1 || SeqTypeList.instance.list(arg0[local10]).priority >= SeqTypeList.instance.list(arg3.actionAnimations[local10]).priority) {
                arg3.actionAnimations = arg0;
                arg3.actionAnimator.method9091(arg1);
                if (arg2) {
                    arg3.animationPathPointer = arg3.pathPointer;
                }
            }
        }
        if (!local8) {
            return;
        }
        arg3.actionAnimations = arg0;
        arg3.actionAnimator.method9091(arg1);
        if (arg2) {
            arg3.animationPathPointer = arg3.pathPointer;
            return;
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(I)Z")
    public static boolean method8516() {
        return Static14.loadNativeLibrary("jaclib") ? Static14.loadNativeLibrary("hw3d") : false;
    }

}
