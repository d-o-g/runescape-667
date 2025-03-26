import com.jagex.EntityMoveFlag;
import com.jagex.game.MoveSpeed;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.effecttype.EffectType;
import com.jagex.game.runetek6.config.effecttype.EffectTypeList;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static256 {

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

        for (@Pc(86) int i = 0; i < entity.effects.length; i++) {
            if (entity.effects[i].id == -1 || !entity.effects[i].animator.isDelayed()) {
                continue;
            }

            @Pc(117) EffectType type = EffectTypeList.instance.list(entity.effects[i].id);

            if (type.loopSeq && type.seq != -1) {
                @Pc(133) SeqType local133 = SeqTypeList.instance.list(type.seq);
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

        @Pc(186) int x = entity.x;
        @Pc(189) int z = entity.z;
        @Pc(206) int pathX = (entity.pathX[entity.pathPointer - 1] * 512) + (entity.getSize() * 256);
        @Pc(222) int pathZ = (entity.pathZ[entity.pathPointer - 1] * 512) + (entity.getSize() * 256);

        if (x < pathX) {
            if (z < pathZ) {
                entity.turn(10240);
            } else if (pathZ < z) {
                entity.turn(14336);
            } else {
                entity.turn(12288);
            }
        } else if (pathX >= x) {
            if (z < pathZ) {
                entity.turn(8192);
            } else if (pathZ < z) {
                entity.turn(0);
            }
        } else if (pathZ > z) {
            entity.turn(6144);
        } else if (pathZ < z) {
            entity.turn(2048);
        } else {
            entity.turn(4096);
        }

        @Pc(348) byte moveSpeed = entity.pathSpeed[entity.pathPointer - 1];
        if (!cutscene && (pathX - x > 1024 || pathX - x < -1024 || pathZ - z > 1024 || pathZ - z < -1024)) {
            entity.z = pathZ;
            entity.x = pathX;
            entity.turn(entity.yawTarget, false);

            Static524.entityMoveFlags = 0;
            if (entity.animationPathPointer > 0) {
                entity.animationPathPointer--;
            }

            Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
            entity.pathPointer--;
            return;
        }

        @Pc(422) int acceleration = 16;
        @Pc(424) boolean crawl = true;
        if (entity instanceof NPCEntity) {
            crawl = ((NPCEntity) entity).type.crawl;
        }

        if (crawl) {
            @Pc(468) int yawDelta = entity.yawTarget - entity.yaw.value;
            if (yawDelta != 0 && entity.target == -1 && entity.yawSpeed != 0) {
                acceleration = 8;
            }
            if (!cutscene && entity.pathPointer > 2) {
                acceleration = 24;
            }
            if (!cutscene && entity.pathPointer > 3) {
                acceleration = 32;
            }
        } else {
            if (!cutscene && entity.pathPointer > 1) {
                acceleration = 24;
            }
            if (!cutscene && entity.pathPointer > 2) {
                acceleration = 32;
            }
        }

        if (entity.delayedWalkingTicks > 0 && entity.pathPointer > 1) {
            entity.delayedWalkingTicks--;
            acceleration = 32;
        }

        if (moveSpeed == MoveSpeed.RUN) {
            acceleration <<= 0x1;
        } else if (moveSpeed == MoveSpeed.CRAWL) {
            acceleration >>= 0x1;
        }

        if (basType.movementAcceleration != -1) {
            acceleration <<= 0x9;

            if (entity.pathPointer == 1) {
                @Pc(468) int accelerationSquared = entity.movementAcceleration * entity.movementAcceleration;
                @Pc(642) int relativeX = (pathX >= entity.x ? pathX - entity.x : entity.x - pathX) << 9;
                @Pc(661) int relativeZ = (pathZ >= entity.z ? pathZ - entity.z : entity.z - pathZ) << 9;
                @Pc(673) int max = relativeX > relativeZ ? relativeX : relativeZ;
                @Pc(680) int maxAcceleration = max * basType.movementAcceleration * 2;

                if (accelerationSquared > maxAcceleration) {
                    entity.movementAcceleration /= 2;
                } else if ((accelerationSquared / 2) > max) {
                    entity.movementAcceleration -= basType.movementAcceleration;

                    if (entity.movementAcceleration < 0) {
                        entity.movementAcceleration = 0;
                    }
                } else if (acceleration > entity.movementAcceleration) {
                    entity.movementAcceleration += basType.movementAcceleration;

                    if (entity.movementAcceleration > acceleration) {
                        entity.movementAcceleration = acceleration;
                    }
                }
            } else if (acceleration > entity.movementAcceleration) {
                entity.movementAcceleration += basType.movementAcceleration;

                if (acceleration < entity.movementAcceleration) {
                    entity.movementAcceleration = acceleration;
                }
            } else if (entity.movementAcceleration > 0) {
                entity.movementAcceleration -= basType.movementAcceleration;

                if (entity.movementAcceleration < 0) {
                    entity.movementAcceleration = 0;
                }
            }

            acceleration = entity.movementAcceleration >> 9;

            if (acceleration < 1) {
                acceleration = 1;
            }
        }

        Static524.entityMoveFlags = 0;

        if (x == pathX && z == pathZ) {
            Static521.entityMoveSpeed = MoveSpeed.STATIONARY;
        } else {
            if (x < pathX) {
                entity.x += acceleration;
                Static524.entityMoveFlags |= EntityMoveFlag.EAST;

                if (entity.x > pathX) {
                    entity.x = pathX;
                }
            } else if (x > pathX) {
                entity.x -= acceleration;
                Static524.entityMoveFlags |= EntityMoveFlag.WEST;

                if (pathX > entity.x) {
                    entity.x = pathX;
                }
            }

            if (acceleration >= 32) {
                Static521.entityMoveSpeed = MoveSpeed.RUN;
            } else {
                Static521.entityMoveSpeed = moveSpeed;
            }

            if (z < pathZ) {
                Static524.entityMoveFlags |= EntityMoveFlag.NORTH;
                entity.z += acceleration;

                if (pathZ < entity.z) {
                    entity.z = pathZ;
                }
            } else if (z > pathZ) {
                entity.z -= acceleration;
                Static524.entityMoveFlags |= EntityMoveFlag.SOUTH;

                if (pathZ > entity.z) {
                    entity.z = pathZ;
                }
            }
        }

        if (entity.x != pathX || pathZ != entity.z) {
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
        if (Camera.mode == CameraMode.MODE_FOLLOWCOORD) {
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
        if (Camera.mode != CameraMode.MODE_FOLLOWCOORD) {
            local74 = (local74 * 256) / (Camera.scaleOffset + 256);
            local78 = (local78 * 256) / (Camera.scaleOffset + 256);
        }

        @Pc(107) int local107 = ((local78 * arg10) + (arg8 * local74)) >> 14;
        @Pc(118) int local118 = ((local78 * arg8) - (arg10 * local74)) >> 14;
        @Pc(125) int paraWidth = metrics.paraWidth(null, text, 100);
        @Pc(131) int centerX = local107 - paraWidth / 2;
        @Pc(139) int textHeight = metrics.stringHeight(100, 0, text, null);
        if (centerX >= -component.width && component.width >= centerX && local118 >= -component.height && component.height >= local118) {
            font.renderLines(text, (component.width / 2) + centerX + offsetX, ((component.height / 2) + offsetY) - local118 - height - textHeight, offsetX, offsetY, paraWidth, 50, 1, 0, 0, colour, 0, arg7, null, null);
        }
    }
}
