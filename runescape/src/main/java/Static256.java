import com.jagex.game.MoveSpeed;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.graphics.ClippingMask;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static256 {

    @OriginalMember(owner = "client!hu", name = "n", descriptor = "[S")
    public static short[] aShortArray63;

    @OriginalMember(owner = "client!hu", name = "a", descriptor = "(ZLclient!cg;Z)V")
    public static void movementTick(@OriginalArg(1) PathingEntity entity, @OriginalArg(2) boolean cutscene) {
        @Pc(9) BASType basType = entity.getBASType();
        if (entity.pathPointer == 0) {
            entity.delayedWalkingTicks = 0;
            Static524.entityMoveFlags = 0;
            Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
            return;
        }

        if (entity.actionAnimator.isAnimating() && !entity.actionAnimator.isDelayed()) {
            @Pc(41) SeqType local41 = entity.actionAnimator.getAnimation();
            if (entity.animationPathPointer > 0 && local41.animatingPrecedence == 0) {
                Static524.entityMoveFlags = 0;
                Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
                entity.delayedWalkingTicks++;
                return;
            }
            if (entity.animationPathPointer <= 0 && local41.walkingPrecedence == 0) {
                Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
                entity.delayedWalkingTicks++;
                Static524.entityMoveFlags = 0;
                return;
            }
        }
        for (@Pc(86) int local86 = 0; local86 < entity.spotAnims.length; local86++) {
            if (entity.spotAnims[local86].id != -1 && entity.spotAnims[local86].animator.isDelayed()) {
                @Pc(117) SpotAnimationType local117 = SpotAnimationTypeList.instance.list(entity.spotAnims[local86].id);
                if (local117.loopSeq && local117.seq != -1) {
                    @Pc(133) SeqType local133 = SeqTypeList.instance.list(local117.seq);
                    if (entity.animationPathPointer > 0 && local133.animatingPrecedence == 0) {
                        Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
                        entity.delayedWalkingTicks++;
                        Static524.entityMoveFlags = 0;
                        return;
                    }
                    if (entity.animationPathPointer <= 0 && local133.walkingPrecedence == 0) {
                        Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
                        entity.delayedWalkingTicks++;
                        Static524.entityMoveFlags = 0;
                        return;
                    }
                }
            }
        }
        @Pc(186) int local186 = entity.x;
        @Pc(189) int local189 = entity.z;
        @Pc(206) int local206 = entity.pathX[entity.pathPointer - 1] * 512 + entity.getSize() * 256;
        @Pc(222) int local222 = entity.pathZ[entity.pathPointer - 1] * 512 + entity.getSize() * 256;
        if (local186 < local206) {
            if (local189 < local222) {
                entity.turn(10240);
            } else if (local222 < local189) {
                entity.turn(14336);
            } else {
                entity.turn(12288);
            }
        } else if (local206 >= local186) {
            if (local189 < local222) {
                entity.turn(8192);
            } else if (local222 < local189) {
                entity.turn(0);
            }
        } else if (local222 > local189) {
            entity.turn(6144);
        } else if (local222 < local189) {
            entity.turn(2048);
        } else {
            entity.turn(4096);
        }
        @Pc(348) byte moveSpeed = entity.pathSpeed[entity.pathPointer - 1];
        if (!cutscene && (local206 - local186 > 1024 || local206 - local186 < -1024 || local222 - local189 > 1024 || local222 - local189 < -1024)) {
            entity.z = local222;
            entity.x = local206;
            entity.turn(entity.yawTarget, false);
            Static524.entityMoveFlags = 0;
            if (entity.animationPathPointer > 0) {
                entity.animationPathPointer--;
            }
            Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
            entity.pathPointer--;
            return;
        }
        @Pc(422) int local422 = 16;
        @Pc(424) boolean local424 = true;
        if (entity instanceof NPCEntity) {
            local424 = ((NPCEntity) entity).type.crawl;
        }
        @Pc(468) int local468;
        if (local424) {
            local468 = entity.yawTarget - entity.yaw.value;
            if (local468 != 0 && entity.target == -1 && entity.yawSpeed != 0) {
                local422 = 8;
            }
            if (!cutscene && entity.pathPointer > 2) {
                local422 = 24;
            }
            if (!cutscene && entity.pathPointer > 3) {
                local422 = 32;
            }
        } else {
            if (!cutscene && entity.pathPointer > 1) {
                local422 = 24;
            }
            if (!cutscene && entity.pathPointer > 2) {
                local422 = 32;
            }
        }
        if (entity.delayedWalkingTicks > 0 && entity.pathPointer > 1) {
            entity.delayedWalkingTicks--;
            local422 = 32;
        }
        if (moveSpeed == 2) {
            local422 <<= 0x1;
        } else if (moveSpeed == 0) {
            local422 >>= 0x1;
        }
        if (basType.movementAcceleration != -1) {
            local422 <<= 0x9;
            if (entity.pathPointer == 1) {
                local468 = entity.anInt10765 * entity.anInt10765;
                @Pc(642) int local642 = (local206 >= entity.x ? local206 - entity.x : entity.x - local206) << 9;
                @Pc(661) int local661 = (entity.z <= local222 ? local222 - entity.z : entity.z + -local222) << 9;
                @Pc(673) int local673 = local642 > local661 ? local642 : local661;
                @Pc(680) int local680 = local673 * basType.movementAcceleration * 2;
                if (local680 < local468) {
                    entity.anInt10765 /= 2;
                } else if (local468 / 2 > local673) {
                    entity.anInt10765 -= basType.movementAcceleration;
                    if (entity.anInt10765 < 0) {
                        entity.anInt10765 = 0;
                    }
                } else if (local422 > entity.anInt10765) {
                    entity.anInt10765 += basType.movementAcceleration;
                    if (entity.anInt10765 > local422) {
                        entity.anInt10765 = local422;
                    }
                }
            } else if (local422 > entity.anInt10765) {
                entity.anInt10765 += basType.movementAcceleration;
                if (local422 < entity.anInt10765) {
                    entity.anInt10765 = local422;
                }
            } else if (entity.anInt10765 > 0) {
                entity.anInt10765 -= basType.movementAcceleration;
                if (entity.anInt10765 < 0) {
                    entity.anInt10765 = 0;
                }
            }
            local422 = entity.anInt10765 >> 9;
            if (local422 < 1) {
                local422 = 1;
            }
        }
        Static524.entityMoveFlags = 0;
        if (local206 == local186 && local189 == local222) {
            Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
        } else {
            if (local206 > local186) {
                entity.x += local422;
                Static524.entityMoveFlags |= 0x4;
                if (entity.x > local206) {
                    entity.x = local206;
                }
            } else if (local206 < local186) {
                entity.x -= local422;
                Static524.entityMoveFlags |= 0x8;
                if (local206 > entity.x) {
                    entity.x = local206;
                }
            }
            if (local422 >= 32) {
                Static521.entityMoveSpeed = MoveSpeed.RUN;
            } else {
                Static521.entityMoveSpeed = moveSpeed;
            }
            if (local222 > local189) {
                Static524.entityMoveFlags |= 0x1;
                entity.z += local422;
                if (local222 < entity.z) {
                    entity.z = local222;
                }
            } else if (local222 < local189) {
                entity.z -= local422;
                Static524.entityMoveFlags |= 0x2;
                if (local222 > entity.z) {
                    entity.z = local222;
                }
            }
        }
        if (entity.x != local206 || local222 != entity.z) {
            return;
        }
        entity.pathPointer--;
        if (entity.animationPathPointer > 0) {
            entity.animationPathPointer--;
            return;
        }
    }

    @OriginalMember(owner = "client!hu", name = "a", descriptor = "(Lclient!da;Ljava/lang/String;Lclient!ve;IIIZLclient!hda;Lclient!aa;III)V")
    public static void method3639(@OriginalArg(0) Font font, @OriginalArg(1) String text, @OriginalArg(2) FontMetrics metrics, @OriginalArg(3) int offsetX, @OriginalArg(4) int colour, @OriginalArg(5) int height, @OriginalArg(7) Component component, @OriginalArg(8) ClippingMask arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int offsetY, @OriginalArg(11) int arg10) {
        @Pc(11) int yaw;
        if (Camera.mode == CameraMode.MODE_FOUR) {
            yaw = (int) Camera.playerCameraYaw & 0x3FFF;
        } else {
            yaw = (int) Camera.playerCameraYaw + Camera.yawOffset & 0x3FFF;
        }

        @Pc(33) int local33 = Math.max(component.width / 2, component.height / 2) + 10;
        @Pc(59) int local59 = (arg8 * arg8) + (arg10 * arg10);
        if ((local33 * local33) < local59) {
            return;
        }

        @Pc(74) int local74 = Trig1.SIN[yaw];
        @Pc(78) int local78 = Trig1.COS[yaw];
        if (Camera.mode != CameraMode.MODE_FOUR) {
            local74 = (local74 * 256) / (Camera.scaleOffset + 256);
            local78 = (local78 * 256) / (Camera.scaleOffset + 256);
        }

        @Pc(107) int local107 = ((local78 * arg10) + (arg8 * local74)) >> 14;
        @Pc(118) int local118 = ((local78 * arg8) - (arg10 * local74)) >> 14;
        @Pc(125) int paraWidth = metrics.paraWidth(null, text, 100);
        @Pc(131) int centerX = local107 - paraWidth / 2;
        @Pc(139) int textHeight = metrics.stringHeight(100, 0, text, null);
        if (centerX >= -component.width && component.width >= centerX && local118 >= -component.height && component.height >= local118) {
            font.renderLines(offsetY, null, colour, text, arg7, null, ((component.height / 2) + offsetY) - local118 - height - textHeight, 0, offsetX, 1, (component.width / 2) + centerX + offsetX, 0, 0, paraWidth, 50);
        }
    }
}
