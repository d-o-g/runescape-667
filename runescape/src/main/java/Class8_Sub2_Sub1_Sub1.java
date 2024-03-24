import com.jagex.ParticleList;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.graphics.BoundingCylinder;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.particles.ModelParticleEmitter;
import com.jagex.graphics.particles.ModelParticleEffector;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!b")
public final class Class8_Sub2_Sub1_Sub1 extends PositionEntity {

    @OriginalMember(owner = "client!b", name = "ab", descriptor = "D")
    public double aDouble1;

    @OriginalMember(owner = "client!b", name = "qb", descriptor = "D")
    public double aDouble2;

    @OriginalMember(owner = "client!b", name = "ib", descriptor = "D")
    public double aDouble3;

    @OriginalMember(owner = "client!b", name = "Q", descriptor = "I")
    public int rotateY;

    @OriginalMember(owner = "client!b", name = "M", descriptor = "D")
    public double translateZ;

    @OriginalMember(owner = "client!b", name = "L", descriptor = "D")
    public double translateY;

    @OriginalMember(owner = "client!b", name = "vb", descriptor = "D")
    public double aDouble6;

    @OriginalMember(owner = "client!b", name = "kb", descriptor = "I")
    public int rotateX;

    @OriginalMember(owner = "client!b", name = "Gb", descriptor = "D")
    public double aDouble7;

    @OriginalMember(owner = "client!b", name = "Ib", descriptor = "Lclient!hv;")
    public ParticleSystem system;

    @OriginalMember(owner = "client!b", name = "wb", descriptor = "D")
    public double translateX;

    @OriginalMember(owner = "client!b", name = "Y", descriptor = "I")
    public int sphereRadius = 0;

    @OriginalMember(owner = "client!b", name = "ub", descriptor = "Z")
    public boolean aBoolean58 = false;

    @OriginalMember(owner = "client!b", name = "P", descriptor = "I")
    public int minY = 0;

    @OriginalMember(owner = "client!b", name = "R", descriptor = "Z")
    public boolean aBoolean59 = false;

    @OriginalMember(owner = "client!b", name = "tb", descriptor = "I")
    public final int anInt721;

    @OriginalMember(owner = "client!b", name = "Cb", descriptor = "I")
    public final int anInt715;

    @OriginalMember(owner = "client!b", name = "W", descriptor = "I")
    public final int anInt722;

    @OriginalMember(owner = "client!b", name = "nb", descriptor = "I")
    public int anInt695;

    @OriginalMember(owner = "client!b", name = "rb", descriptor = "Z")
    public boolean aBoolean57;

    @OriginalMember(owner = "client!b", name = "eb", descriptor = "I")
    public final int anInt711;

    @OriginalMember(owner = "client!b", name = "hb", descriptor = "I")
    public final int anInt697;

    @OriginalMember(owner = "client!b", name = "lb", descriptor = "I")
    public final int lb;

    @OriginalMember(owner = "client!b", name = "xb", descriptor = "I")
    public final int anInt706;

    @OriginalMember(owner = "client!b", name = "S", descriptor = "I")
    public final int anInt705;

    @OriginalMember(owner = "client!b", name = "Db", descriptor = "I")
    public final int anInt709;

    @OriginalMember(owner = "client!b", name = "N", descriptor = "Lclient!gu;")
    public final Animator animator;

    @OriginalMember(owner = "client!b", name = "<init>", descriptor = "(IIIIIIIIIIIIIZI)V")
    public Class8_Sub2_Sub1_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) boolean arg13, @OriginalArg(14) int arg14) {
        super(arg1, arg2, arg3, Static102.averageHeight(arg1, -29754, arg4, arg3) - arg5, arg4, arg3 >> 9, arg3 >> 9, arg4 >> 9, arg4 >> 9, false, (byte) 0);
        this.anInt721 = arg5;
        this.anInt715 = arg0;
        this.anInt722 = arg6;
        this.anInt695 = arg14;
        this.aBoolean57 = arg13;
        this.anInt711 = arg11;
        this.aBoolean59 = false;
        this.anInt697 = arg7;
        this.lb = arg12;
        this.anInt706 = arg10;
        this.anInt705 = arg8;
        this.anInt709 = arg9;
        @Pc(82) int local82 = SpotAnimationTypeList.instance.list(this.anInt715).seq;
        this.animator = new EntityAnimator(this, false);
        this.animator.update(true, local82);
    }

    @OriginalMember(owner = "client!b", name = "k", descriptor = "(I)I")
    @Override
    public int getMinY(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.aBoolean57 = false;
        }
        return this.minY;
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(IZIII)V")
    public void method813(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        @Pc(9) double local9;
        if (!this.aBoolean59) {
            local9 = arg3 - super.x;
            @Pc(16) double local16 = arg2 - super.z;
            @Pc(25) double local25 = Math.sqrt(local16 * local16 + local9 * local9);
            this.translateZ = (double) this.anInt709 * local16 / local25 + (double) super.z;
            this.translateX = (double) super.x + local9 * (double) this.anInt709 / local25;
            if (this.aBoolean57) {
                this.translateY = Static102.averageHeight(super.level, -29754, (int) this.translateZ, (int) this.translateX) - this.anInt721;
            } else {
                this.translateY = super.y;
            }
        }
        local9 = this.anInt697 + 1 - arg1;
        this.aDouble2 = ((double) arg2 - this.translateZ) / local9;
        this.aDouble7 = ((double) arg3 - this.translateX) / local9;
        this.aDouble6 = Math.sqrt(this.aDouble7 * this.aDouble7 + this.aDouble2 * this.aDouble2);
        if (this.anInt705 == -1) {
            this.aDouble1 = ((double) arg0 - this.translateY) / local9;
        } else {
            if (!this.aBoolean59) {
                this.aDouble1 = -this.aDouble6 * Math.tan((double) this.anInt705 * 0.02454369D);
            }
            this.aDouble3 = ((double) arg0 - local9 * this.aDouble1 - this.translateY) * 2.0D / (local9 * local9);
        }
    }

    @OriginalMember(owner = "client!b", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public BoundingCylinder getCylinder(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (arg1 >= -93) {
            this.translateX = 1.3103535335051488D;
        }
        return null;
    }

    @OriginalMember(owner = "client!b", name = "l", descriptor = "(I)V")
    @Override
    public void updateBounds() {
        super.x1 = super.x2 = (short) (int) (this.translateX / 512.0D);
        super.z1 = super.z2 = (short) (int) (this.translateZ / 512.0D);
    }

    @OriginalMember(owner = "client!b", name = "j", descriptor = "(I)V")
    @Override
    public void stopSharingLight(@OriginalArg(0) int arg0) {
        if (arg0 != 27811) {
            this.anInt695 = -9;
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void shareLight(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6) {
        if (arg4 >= 101) {
            throw new IllegalStateException();
        }
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(ILclient!ha;I)Lclient!ka;")
    public Model method814(@OriginalArg(0) int arg0, @OriginalArg(1) Toolkit arg1, @OriginalArg(2) int arg2) {
        @Pc(17) SpotAnimationType type = SpotAnimationTypeList.instance.list(this.anInt715);
        return type.model(this.animator, (byte) 2, arg0, arg1);
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(I)V")
    public void method815() {
        if (this.system != null) {
            this.system.run();
        }
    }

    @OriginalMember(owner = "client!b", name = "h", descriptor = "(I)Z")
    @Override
    public boolean isTransparent(@OriginalArg(0) int arg0) {
        return arg0 == 0 ? this.aBoolean58 : true;
    }

    @OriginalMember(owner = "client!b", name = "c", descriptor = "(Z)V")
    public void method816() {
        if (this.aBoolean59 || this.anInt706 == 0) {
            return;
        }
        @Pc(21) PathingEntity local21 = null;
        if (CutsceneManager.state == 3) {
            local21 = Static219.aClass236Array1[this.anInt706 - 1].method5363();
        } else {
            @Pc(35) int local35;
            if (this.anInt706 < 0) {
                local35 = -this.anInt706 - 1;
                if (PlayerList.activePlayerSlot == local35) {
                    local21 = PlayerEntity.self;
                } else {
                    local21 = PlayerList.highResolutionPlayers[local35];
                }
            } else {
                local35 = this.anInt706 - 1;
                @Pc(58) NPCEntityNode local58 = (NPCEntityNode) NPCList.local.get(local35);
                if (local58 != null) {
                    local21 = local58.npc;
                }
            }
        }
        if (local21 == null) {
            return;
        }
        super.z = local21.z;
        super.x = local21.x;
        super.y = Static102.averageHeight(super.level, -29754, local21.z, local21.x) - this.anInt721;
        if (this.anInt695 < 0) {
            return;
        }
        @Pc(105) BASType local105 = local21.getBASType();
        @Pc(107) int local107 = 0;
        @Pc(109) int local109 = 0;
        if (local105.wornTransformations != null && local105.wornTransformations[this.anInt695] != null) {
            local109 = local105.wornTransformations[this.anInt695][2];
            local107 = local105.wornTransformations[this.anInt695][0];
        }
        if (local105.graphicOffsets != null && local105.graphicOffsets[this.anInt695] != null) {
            local109 += local105.graphicOffsets[this.anInt695][2];
            local107 += local105.graphicOffsets[this.anInt695][0];
        }
        if (local107 != 0 || local109 != 0) {
            @Pc(185) int local185 = local21.yaw.getValue(16383);
            @Pc(187) int local187 = local185;
            if (local21.anIntArray877 != null && local21.anIntArray877[this.anInt695] != -1) {
                local187 = local21.anIntArray877[this.anInt695];
            }
            @Pc(213) int local213 = local187 - local185 & 0x3FFF;
            @Pc(217) int local217 = Trig1.SIN[local213];
            @Pc(221) int local221 = Trig1.COS[local213];
            @Pc(232) int local232 = local217 * local109 + local221 * local107 >> 14;
            local109 = local109 * local221 - local217 * local107 >> 14;
            super.z += local109;
            super.x += local232;
        }
        return;
    }

    @OriginalMember(owner = "client!b", name = "b", descriptor = "(B)Z")
    @Override
    public boolean isStationary() {
        return false;
    }

    @OriginalMember(owner = "client!b", name = "c", descriptor = "(B)I")
    @Override
    public int getSphereRadius(@OriginalArg(0) byte arg0) {
        return arg0 == -21 ? this.sphereRadius : 39;
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(BLclient!ha;Lclient!tt;Lclient!ka;)V")
    public void update(@OriginalArg(1) Toolkit toolkit, @OriginalArg(2) Matrix matrix, @OriginalArg(3) Model model) {
        model.apply(matrix);

        @Pc(9) ModelParticleEmitter[] emitters = model.particleEmitters();
        @Pc(12) ModelParticleEffector[] effectors = model.particleEffectors();

        if ((this.system == null || this.system.removed) && (emitters != null || effectors != null)) {
            this.system = ParticleSystem.create(TimeUtils.clock, true);
        }

        if (this.system != null) {
            this.system.update(toolkit, TimeUtils.clock, emitters, effectors);
            this.system.updateBounds(super.level, super.x1, super.x2, super.z1, super.z2);
        }
    }

    @OriginalMember(owner = "client!b", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        return arg0 != 0;
    }

    @OriginalMember(owner = "client!b", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            Static29.aClass131_1 = null;
        }

        @Pc(18) Model model = this.method814(0, toolkit, arg1 + 75);
        if (model == null) {
            return;
        }

        @Pc(25) Matrix matrix = toolkit.scratchMatrix();
        matrix.makeRotationX(this.rotateX);
        matrix.rotateAxisY(this.rotateY);
        matrix.translate((int) this.translateX, (int) this.translateY, (int) this.translateZ);
        this.minY = model.fa();
        this.sphereRadius = model.ma();
        this.update(toolkit, matrix, model);
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public PickableEntity render(@OriginalArg(1) Toolkit arg0) {
        @Pc(19) Model local19 = this.method814(2048, arg0, 46);
        if (local19 == null) {
            return null;
        }
        @Pc(27) Matrix local27 = arg0.scratchMatrix();
        local27.makeRotationX(this.rotateX);
        local27.rotateAxisY(this.rotateY);
        local27.translate((int) this.translateX, (int) this.translateY, (int) this.translateZ);
        this.update(arg0, local27, local19);
        @Pc(57) PickableEntity local57 = Static642.method8441(false, 1);
        if (Static504.renderOrtho) {
            local19.renderOrtho(local27, local57.pickingCylinders[0], Static582.orthoAngle, 0);
        } else {
            local19.render(local27, local57.pickingCylinders[0], 0);
        }
        if (this.system != null) {
            @Pc(89) ParticleList local89 = this.system.getList();
            if (Static504.renderOrtho) {
                arg0.renderOrtho(local89, Static582.orthoAngle);
            } else {
                arg0.render(local89);
            }
        }
        this.aBoolean58 = local19.F();
        this.minY = local19.fa();
        this.sphereRadius = local19.ma();
        return local57;
    }

    @OriginalMember(owner = "client!b", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        if (this.system != null) {
            this.system.run();
        }
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean picked(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit toolkit) {
        if (arg2) {
            this.translateY = -0.10988590233715705D;
        }
        return false;
    }

    @OriginalMember(owner = "client!b", name = "a", descriptor = "(BI)V")
    public void method819(@OriginalArg(1) int arg0) {
        this.translateX += (double) arg0 * this.aDouble7;
        this.aBoolean59 = true;
        this.translateZ += (double) arg0 * this.aDouble2;
        if (this.aBoolean57) {
            this.translateY = Static102.averageHeight(super.level, -29754, (int) this.translateZ, (int) this.translateX) - this.anInt721;
        } else if (this.anInt705 == -1) {
            this.translateY += this.aDouble1 * (double) arg0;
        } else {
            this.translateY += (double) arg0 * this.aDouble1 + this.aDouble3 * 0.5D * (double) arg0 * (double) arg0;
            this.aDouble1 += (double) arg0 * this.aDouble3;
        }
        this.rotateY = (int) (Math.atan2(this.aDouble7, this.aDouble2) * 2607.5945876176133D) + 8192 & 0x3FFF;
        this.rotateX = (int) (Math.atan2(this.aDouble1, this.aDouble6) * 2607.5945876176133D) & 0x3FFF;
        if (this.animator.tick(1) && this.animator.isFinished()) {
            this.animator.resetImmediately();
        }
    }
}
