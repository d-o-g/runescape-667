import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import com.jagex.math.Trig1;
import jaggl.OpenGL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static256 {

    @OriginalMember(owner = "client!hu", name = "n", descriptor = "[S")
    public static short[] aShortArray63;

    @OriginalMember(owner = "client!hu", name = "a", descriptor = "(IILclient!sb;Lclient!d;Ljava/awt/Canvas;)Lclient!ha;")
    public static Toolkit method3637(@OriginalArg(0) int arg0, @OriginalArg(2) js5 arg1, @OriginalArg(3) TextureSource arg2, @OriginalArg(4) Canvas arg3) {
        if (!Static651.method8516()) {
            throw new RuntimeException("");
        } else if (Static14.loadNativeLibrary("jaggl")) {
            @Pc(28) OpenGL local28 = new OpenGL();
            @Pc(38) long local38 = local28.init(arg3, 8, 8, 8, 24, 0, arg0);
            if (local38 == 0L) {
                throw new RuntimeException("");
            }
            @Pc(58) Toolkit_Sub1_Sub2 local58 = new Toolkit_Sub1_Sub2(local28, arg3, local38, arg2, arg1, arg0);
            local58.method8134();
            return local58;
        } else {
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!hu", name = "a", descriptor = "(ZLclient!cg;Z)V")
    public static void method3638(@OriginalArg(1) PathingEntity arg0, @OriginalArg(2) boolean arg1) {
        @Pc(9) BASType local9 = arg0.getBASType();
        if (arg0.pathPointer == 0) {
            arg0.delayedWalkingTicks = 0;
            Static524.anInt8042 = 0;
            Static521.anInt7756 = -1;
            return;
        }
        if (arg0.actionAnimator.isAnimating() && !arg0.actionAnimator.isDelayed()) {
            @Pc(41) SeqType local41 = arg0.actionAnimator.getAnimation();
            if (arg0.animationPathPointer > 0 && local41.animatingPrecedence == 0) {
                Static524.anInt8042 = 0;
                Static521.anInt7756 = -1;
                arg0.delayedWalkingTicks++;
                return;
            }
            if (arg0.animationPathPointer <= 0 && local41.walkingPrecedence == 0) {
                Static521.anInt7756 = -1;
                arg0.delayedWalkingTicks++;
                Static524.anInt8042 = 0;
                return;
            }
        }
        for (@Pc(86) int local86 = 0; local86 < arg0.spotAnims.length; local86++) {
            if (arg0.spotAnims[local86].id != -1 && arg0.spotAnims[local86].animator.isDelayed()) {
                @Pc(117) SpotAnimationType local117 = SpotAnimationTypeList.instance.list(arg0.spotAnims[local86].id);
                if (local117.loopSeq && local117.seq != -1) {
                    @Pc(133) SeqType local133 = SeqTypeList.instance.list(local117.seq);
                    if (arg0.animationPathPointer > 0 && local133.animatingPrecedence == 0) {
                        Static521.anInt7756 = -1;
                        arg0.delayedWalkingTicks++;
                        Static524.anInt8042 = 0;
                        return;
                    }
                    if (arg0.animationPathPointer <= 0 && local133.walkingPrecedence == 0) {
                        Static521.anInt7756 = -1;
                        arg0.delayedWalkingTicks++;
                        Static524.anInt8042 = 0;
                        return;
                    }
                }
            }
        }
        @Pc(186) int local186 = arg0.x;
        @Pc(189) int local189 = arg0.z;
        @Pc(206) int local206 = arg0.pathX[arg0.pathPointer - 1] * 512 + arg0.getSize() * 256;
        @Pc(222) int local222 = arg0.pathZ[arg0.pathPointer - 1] * 512 + arg0.getSize() * 256;
        if (local186 < local206) {
            if (local189 < local222) {
                arg0.turn(10240);
            } else if (local222 < local189) {
                arg0.turn(14336);
            } else {
                arg0.turn(12288);
            }
        } else if (local206 >= local186) {
            if (local189 < local222) {
                arg0.turn(8192);
            } else if (local222 < local189) {
                arg0.turn(0);
            }
        } else if (local222 > local189) {
            arg0.turn(6144);
        } else if (local222 < local189) {
            arg0.turn(2048);
        } else {
            arg0.turn(4096);
        }
        @Pc(348) byte local348 = arg0.pathSpeed[arg0.pathPointer - 1];
        if (!arg1 && (local206 - local186 > 1024 || local206 - local186 < -1024 || local222 - local189 > 1024 || local222 - local189 < -1024)) {
            arg0.z = local222;
            arg0.x = local206;
            arg0.turn(arg0.turnYaw, false);
            Static524.anInt8042 = 0;
            if (arg0.animationPathPointer > 0) {
                arg0.animationPathPointer--;
            }
            Static521.anInt7756 = -1;
            arg0.pathPointer--;
            return;
        }
        @Pc(422) int local422 = 16;
        @Pc(424) boolean local424 = true;
        if (arg0 instanceof NPCEntity) {
            local424 = ((NPCEntity) arg0).type.crawl;
        }
        @Pc(468) int local468;
        if (local424) {
            local468 = arg0.turnYaw - arg0.yaw.value;
            if (local468 != 0 && arg0.target == -1 && arg0.yawSpeed != 0) {
                local422 = 8;
            }
            if (!arg1 && arg0.pathPointer > 2) {
                local422 = 24;
            }
            if (!arg1 && arg0.pathPointer > 3) {
                local422 = 32;
            }
        } else {
            if (!arg1 && arg0.pathPointer > 1) {
                local422 = 24;
            }
            if (!arg1 && arg0.pathPointer > 2) {
                local422 = 32;
            }
        }
        if (arg0.delayedWalkingTicks > 0 && arg0.pathPointer > 1) {
            arg0.delayedWalkingTicks--;
            local422 = 32;
        }
        if (local348 == 2) {
            local422 <<= 0x1;
        } else if (local348 == 0) {
            local422 >>= 0x1;
        }
        if (local9.movementAcceleration != -1) {
            local422 <<= 0x9;
            if (arg0.pathPointer == 1) {
                local468 = arg0.anInt10765 * arg0.anInt10765;
                @Pc(642) int local642 = (local206 >= arg0.x ? local206 - arg0.x : arg0.x - local206) << 9;
                @Pc(661) int local661 = (arg0.z <= local222 ? local222 - arg0.z : arg0.z + -local222) << 9;
                @Pc(673) int local673 = local642 > local661 ? local642 : local661;
                @Pc(680) int local680 = local673 * local9.movementAcceleration * 2;
                if (local680 < local468) {
                    arg0.anInt10765 /= 2;
                } else if (local468 / 2 > local673) {
                    arg0.anInt10765 -= local9.movementAcceleration;
                    if (arg0.anInt10765 < 0) {
                        arg0.anInt10765 = 0;
                    }
                } else if (local422 > arg0.anInt10765) {
                    arg0.anInt10765 += local9.movementAcceleration;
                    if (arg0.anInt10765 > local422) {
                        arg0.anInt10765 = local422;
                    }
                }
            } else if (local422 > arg0.anInt10765) {
                arg0.anInt10765 += local9.movementAcceleration;
                if (local422 < arg0.anInt10765) {
                    arg0.anInt10765 = local422;
                }
            } else if (arg0.anInt10765 > 0) {
                arg0.anInt10765 -= local9.movementAcceleration;
                if (arg0.anInt10765 < 0) {
                    arg0.anInt10765 = 0;
                }
            }
            local422 = arg0.anInt10765 >> 9;
            if (local422 < 1) {
                local422 = 1;
            }
        }
        Static524.anInt8042 = 0;
        if (local206 == local186 && local189 == local222) {
            Static521.anInt7756 = -1;
        } else {
            if (local206 > local186) {
                arg0.x += local422;
                Static524.anInt8042 |= 0x4;
                if (arg0.x > local206) {
                    arg0.x = local206;
                }
            } else if (local206 < local186) {
                arg0.x -= local422;
                Static524.anInt8042 |= 0x8;
                if (local206 > arg0.x) {
                    arg0.x = local206;
                }
            }
            if (local422 >= 32) {
                Static521.anInt7756 = 2;
            } else {
                Static521.anInt7756 = local348;
            }
            if (local222 > local189) {
                Static524.anInt8042 |= 0x1;
                arg0.z += local422;
                if (local222 < arg0.z) {
                    arg0.z = local222;
                }
            } else if (local222 < local189) {
                arg0.z -= local422;
                Static524.anInt8042 |= 0x2;
                if (local222 > arg0.z) {
                    arg0.z = local222;
                }
            }
        }
        if (arg0.x != local206 || local222 != arg0.z) {
            return;
        }
        arg0.pathPointer--;
        if (arg0.animationPathPointer > 0) {
            arg0.animationPathPointer--;
            return;
        }
    }

    @OriginalMember(owner = "client!hu", name = "a", descriptor = "(Lclient!da;Ljava/lang/String;Lclient!ve;IIIZLclient!hda;Lclient!aa;III)V")
    public static void method3639(@OriginalArg(0) Font arg0, @OriginalArg(1) String arg1, @OriginalArg(2) FontMetrics arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(7) Component arg6, @OriginalArg(8) ClippingMask arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) int arg10) {
        @Pc(11) int local11;
        if (Camera.mode == 4) {
            local11 = (int) Camera.playerCameraYaw & 0x3FFF;
        } else {
            local11 = (int) Camera.playerCameraYaw + Camera.yawOffset & 0x3FFF;
        }
        @Pc(33) int local33 = Math.max(arg6.width / 2, arg6.height / 2) + 10;
        @Pc(59) int local59 = arg8 * arg8 + arg10 * arg10;
        if (local33 * local33 < local59) {
            return;
        }
        @Pc(74) int local74 = Trig1.SIN[local11];
        @Pc(78) int local78 = Trig1.COS[local11];
        if (Camera.mode != 4) {
            local74 = local74 * 256 / (Camera.scaleOffset + 256);
            local78 = local78 * 256 / (Camera.scaleOffset + 256);
        }
        @Pc(107) int local107 = local78 * arg10 + arg8 * local74 >> 14;
        @Pc(118) int local118 = arg8 * local78 - arg10 * local74 >> 14;
        @Pc(125) int local125 = arg2.paraWidth(null, arg1, 100);
        @Pc(131) int local131 = local107 - local125 / 2;
        @Pc(139) int local139 = arg2.stringHeight(100, 0, arg1, null);
        if (local131 >= -arg6.width && arg6.width >= local131 && local118 >= -arg6.height && arg6.height >= local118) {
            arg0.renderLines(arg9, null, arg4, arg1, arg7, null, arg6.height / 2 + arg9 - local118 - arg5 - local139, 0, arg3, 1, arg6.width / 2 + local131 + arg3, 0, 0, local125, 50);
        }
    }
}
