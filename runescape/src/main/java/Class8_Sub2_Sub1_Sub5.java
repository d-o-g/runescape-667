import com.jagex.ParticleList;
import com.jagex.game.Animator;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.particles.ModelParticleEmitter;
import com.jagex.graphics.particles.ModelParticleEffector;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pja")
public final class Class8_Sub2_Sub1_Sub5 extends PositionEntity {

    @OriginalMember(owner = "client!pja", name = "qb", descriptor = "Lclient!hv;")
    public ParticleSystem aParticleSystem;

    @OriginalMember(owner = "client!pja", name = "O", descriptor = "I")
    public int anInt7400 = 0;

    @OriginalMember(owner = "client!pja", name = "jb", descriptor = "I")
    public int anInt7393 = 0;

    @OriginalMember(owner = "client!pja", name = "gb", descriptor = "Z")
    public boolean aBoolean562 = true;

    @OriginalMember(owner = "client!pja", name = "Q", descriptor = "I")
    public int anInt7412 = 0;

    @OriginalMember(owner = "client!pja", name = "R", descriptor = "I")
    public final int anInt7402;

    @OriginalMember(owner = "client!pja", name = "V", descriptor = "Lclient!gu;")
    public Animator aAnimator_8;

    @OriginalMember(owner = "client!pja", name = "<init>", descriptor = "(IIIIIIIIIIIIZ)V")
    public Class8_Sub2_Sub1_Sub5(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) boolean arg12) {
        super(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, false, (byte) 0);
        this.anInt7402 = arg0;
        this.anInt7400 = arg11;
        @Pc(36) Class227 local36 = Static23.aClass128_1.method2694(this.anInt7402);
        @Pc(39) int local39 = local36.anInt5842;
        if (local39 != -1) {
            this.aAnimator_8 = new Animator_Sub2(this, false);
            @Pc(59) int local59 = local36.aBoolean448 ? 0 : 2;
            if (arg12) {
                local59 = 1;
            }
            this.aAnimator_8.update(local39, arg1, local59, false);
        }
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(Lclient!tt;Lclient!ka;ILclient!ha;)V")
    public void method6593(@OriginalArg(0) Matrix arg0, @OriginalArg(1) Model arg1, @OriginalArg(3) Toolkit arg2) {
        arg1.method7476(arg0);
        @Pc(9) ModelParticleEmitter[] local9 = arg1.particleEmitters();
        @Pc(19) ModelParticleEffector[] local19 = arg1.particleEffectors();
        if ((this.aParticleSystem == null || this.aParticleSystem.aBoolean324) && (local9 != null || local19 != null)) {
            this.aParticleSystem = Static257.method3654(Static333.anInt5455, true);
        }
        if (this.aParticleSystem != null) {
            this.aParticleSystem.method3643(arg2, (long) Static333.anInt5455, local9, local19);
            this.aParticleSystem.method3658(super.aByte144, super.aShort131, super.aShort134, super.aShort132, super.aShort133);
        }
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(IILclient!ha;I)Lclient!ka;")
    public Model method6594(@OriginalArg(1) int arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int arg2) {
        @Pc(8) Class227 local8 = Static23.aClass128_1.method2694(arg0);
        @Pc(22) Ground local22 = Static706.aGroundArray3[super.aByte144];
        @Pc(36) Ground local36 = super.aByte143 < 3 ? Static706.aGroundArray3[super.aByte143 + 1] : null;
        return this.aAnimator_8 == null || this.aAnimator_8.isFinished() ? local8.method5249((byte) 2, true, super.anInt10694, (Animator) null, local36, super.anInt10690, local22, arg2, super.anInt10691, arg1) : local8.method5249((byte) 2, true, super.anInt10694, this.aAnimator_8, local36, super.anInt10690, local22, arg2, super.anInt10691, arg1);
    }

    @OriginalMember(owner = "client!pja", name = "finalize", descriptor = "()V")
    @Override
    public void finalize() {
        if (this.aParticleSystem != null) {
            this.aParticleSystem.method3644();
        }
    }

    @OriginalMember(owner = "client!pja", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            this.method9289((Toolkit) null, 72);
        }
        @Pc(20) Model local20 = this.method6594(this.anInt7402, arg0, 0);
        if (local20 != null) {
            @Pc(25) Matrix local25 = arg0.scratchMatrix();
            local25.method7125(super.anInt10690, super.anInt10691, super.anInt10694);
            this.method6593(local25, local20, arg0);
        }
    }

    @OriginalMember(owner = "client!pja", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            Static494.anInt7409 = 119;
        }
        return false;
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(I)Z")
    public boolean method6595() {
        return this.aAnimator_8 != null && !this.aAnimator_8.isDelayed();
    }

    @OriginalMember(owner = "client!pja", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        if (arg0 == 27811) {
            throw new IllegalStateException();
        }
    }

    @OriginalMember(owner = "client!pja", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.method9282(113);
        }
        return this.anInt7412;
    }

    @OriginalMember(owner = "client!pja", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 != -21) {
            this.finalize();
        }
        return this.anInt7393;
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(II)V")
    public void method6598() {
        if (this.aAnimator_8 != null && !this.aAnimator_8.isFinished()) {
            this.aAnimator_8.tick(1);
        }
    }

    @OriginalMember(owner = "client!pja", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        return arg0 == 0 ? this.aBoolean562 : false;
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (arg2) {
            this.method9286(-24);
        }
        return false;
    }

    @OriginalMember(owner = "client!pja", name = "c", descriptor = "(I)V")
    public void method6600() {
        if (this.aParticleSystem != null) {
            this.aParticleSystem.method3644();
        }
    }

    @OriginalMember(owner = "client!pja", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -93) {
            this.method9279(-78, 64, true, (Toolkit) null);
        }
        return null;
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg4 < 101) {
            this.method9276((Toolkit) null);
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!pja", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        @Pc(24) Model local24 = this.method6594(this.anInt7402, arg0, (this.anInt7400 == 0 ? 0 : 5) | 0x800);
        if (local24 == null) {
            return null;
        }
        if (this.anInt7400 != 0) {
            local24.a(this.anInt7400 * 2048);
        }
        @Pc(43) Matrix local43 = arg0.scratchMatrix();
        local43.method7125(super.anInt10690, super.anInt10691, super.anInt10694);
        this.method6593(local43, local24, arg0);
        @Pc(62) Class8_Sub7 local62 = Static642.method8441(false, 1);
        if (Static504.aBoolean579) {
            local24.renderOrtho(local43, local62.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            local24.render(local43, local62.aPickingCylinderArray1[0], 0);
        }
        if (this.aParticleSystem != null) {
            @Pc(102) ParticleList local102 = this.aParticleSystem.method3645();
            if (Static504.aBoolean579) {
                arg0.method7967(local102, Static582.anInt8627);
            } else {
                arg0.method8021(local102);
            }
        }
        this.aBoolean562 = local24.F();
        this.anInt7412 = local24.fa();
        this.anInt7393 = local24.ma();
        return local62;
    }

    @OriginalMember(owner = "client!pja", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        return false;
    }

    @OriginalMember(owner = "client!pja", name = "d", descriptor = "(I)Z")
    public boolean method6603() {
        return this.aAnimator_8 == null || this.aAnimator_8.isFinished();
    }
}
