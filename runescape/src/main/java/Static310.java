import com.jagex.game.runetek6.config.seqtype.SeqReplayMode;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static310 {


    @OriginalMember(owner = "client!jr", name = "a", descriptor = "([II[I[ILclient!cg;)V")
    public static void animateWorn(@OriginalArg(0) int[] slots, @OriginalArg(2) int[] animations, @OriginalArg(3) int[] delays, @OriginalArg(4) PathingEntity entity) {
        for (@Pc(14) int i = 0; i < animations.length; i++) {
            @Pc(20) int animation = animations[i];
            @Pc(24) int slot = slots[i];
            @Pc(28) int delay = delays[i];

            @Pc(30) int j = 0;
            while (slot != 0 && entity.wornAnimators.length > j) {
                if ((slot & 0x1) != 0) {
                    if (animation == -1) {
                        entity.wornAnimators[j] = null;
                    } else {
                        @Pc(60) SeqType seq = SeqTypeList.instance.list(animation);
                        @Pc(63) int replayMode = seq.replayMode;
                        @Pc(68) DelayedEntityAnimator animator = entity.wornAnimators[j];

                        if (animator != null && animator.isAnimating()) {
                            if (animation == animator.getAnimationId()) {
                                if (replayMode == SeqReplayMode.STOP) {
                                    animator = entity.wornAnimators[j] = null;
                                } else if (replayMode == SeqReplayMode.RESET) {
                                    animator.resetImmediately();
                                    animator.entityDelay = delay;
                                } else if (replayMode == SeqReplayMode.RESTART_LOOP) {
                                    animator.restartLoop();
                                }
                            } else if (seq.priority >= animator.getAnimation().priority) {
                                animator = entity.wornAnimators[j] = null;
                            }
                        }

                        if (animator == null || !animator.isAnimating()) {
                            animator = entity.wornAnimators[j] = new DelayedEntityAnimator(entity);
                            animator.update(true, animation);
                            animator.entityDelay = delay;
                        }
                    }
                }

                j++;
                slot >>>= 0x1;
            }
        }
    }
}
