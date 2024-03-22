import com.jagex.ParticleList;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!oe")
public final class DynamicLocation extends PositionEntity implements Location {

    @OriginalMember(owner = "client!oe", name = "P", descriptor = "Lclient!ke;")
    public Class205 aClass205_7;

    @OriginalMember(owner = "client!oe", name = "X", descriptor = "Z")
    public boolean aBoolean518 = true;

    @OriginalMember(owner = "client!oe", name = "hb", descriptor = "Lclient!sh;")
    public Class337 aClass337_3;

    @OriginalMember(owner = "client!oe", name = "S", descriptor = "Z")
    public boolean aBoolean517;

    @OriginalMember(owner = "client!oe", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIIIIII)V")
    public DynamicLocation(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) LocType arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13, @OriginalArg(14) int arg14) {
        super(arg2, arg3, arg4, arg5, arg6, arg8, arg9, arg10, arg11, arg1.lb == 1, Static609.method8215(arg12, arg13));
        this.aClass337_3 = new Class337(arg0, arg1, arg12, arg13, super.level, arg3, this, arg7, arg14);
        this.aBoolean517 = arg1.interactivity != LocInteractivity.NONINTERACTIVE && !arg7;
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg4 < 101) {
            Static451.aServerProt_171 = null;
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        @Pc(12) Model local12 = this.aClass337_3.method7678(arg3, false, true, arg2, 131072);
        if (local12 == null) {
            return false;
        } else {
            @Pc(20) Matrix local20 = arg3.scratchMatrix();
            local20.method7125(super.x, super.anInt10691, super.z);
            return Static504.aBoolean579 ? local12.pickedOrtho(arg1, arg0, local20, false, 0, Static582.anInt8627) : local12.picked(arg1, arg0, local20, false, 0);
        }
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        @Pc(14) Model local14 = this.aClass337_3.method7678(arg0, false, true, true, 2048);
        if (local14 == null) {
            return null;
        }
        @Pc(30) Matrix local30 = arg0.scratchMatrix();
        local30.method7125(super.x, super.anInt10691, super.z);
        @Pc(44) Class8_Sub7 local44 = Static642.method8441(this.aBoolean517, 1);
        this.aClass337_3.method7681(super.aShort133, local14, true, -9827, arg0, super.aShort134, super.aShort131, super.aShort132, local30);
        if (Static504.aBoolean579) {
            local14.renderOrtho(local30, local44.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            local14.render(local30, local44.aPickingCylinderArray1[0], 0);
        }
        if (this.aClass337_3.aParticleSystem_7 != null) {
            @Pc(94) ParticleList local94 = this.aClass337_3.aParticleSystem_7.method3645();
            if (Static504.aBoolean579) {
                arg0.method7967(local94, Static582.anInt8627);
            } else {
                arg0.method8021(local94);
            }
        }
        this.aBoolean518 = local14.F() || this.aClass337_3.aParticleSystem_7 != null;
        if (this.aClass205_7 == null) {
            this.aClass205_7 = Static317.method4583(super.anInt10691, super.x, local14, super.z);
        } else {
            Static223.method9103(local14, super.z, super.anInt10691, super.x, this.aClass205_7);
        }
        return local44;
    }

    @OriginalMember(owner = "client!oe", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.aClass205_7 = null;
        }
        return this.aBoolean518;
    }

    @OriginalMember(owner = "client!oe", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.aClass337_3.anInt8663;
    }

    @OriginalMember(owner = "client!oe", name = "e", descriptor = "(I)Z")
    @Override
    public boolean castsShadow() {
        return this.aClass337_3.method7675();
    }

    @OriginalMember(owner = "client!oe", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        return arg0 == 0 ? false : false;
    }

    @OriginalMember(owner = "client!oe", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        @Pc(12) Model local12 = this.aClass337_3.method7678(arg0, true, true, true, 262144);
        if (arg1 == -5 && local12 != null) {
            @Pc(22) Matrix local22 = arg0.scratchMatrix();
            local22.method7125(super.x, super.anInt10691, super.z);
            this.aClass337_3.method7681(super.aShort133, local12, false, -9827, arg0, super.aShort134, super.aShort131, super.aShort132, local22);
        }
    }

    @OriginalMember(owner = "client!oe", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return this.aClass337_3.anInt8645;
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.aClass337_3.anInt8649;
    }

    @OriginalMember(owner = "client!oe", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -93) {
            this.aClass337_3 = null;
        }
        return this.aClass205_7;
    }

    @OriginalMember(owner = "client!oe", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        if (arg0 != 27811) {
            this.aBoolean517 = false;
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(ILclient!gp;)V")
    public void method6160(@OriginalArg(1) LocTypeCustomisation arg0) {
        this.aClass337_3.method7679(arg0);
    }

    @OriginalMember(owner = "client!oe", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        return false;
    }

    @OriginalMember(owner = "client!oe", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -42) {
            this.method9285(72, true, (Toolkit) null, -2, (byte) 37, -105, (Renderable) null);
        }
        this.aClass337_3.method7669(arg0);
    }

    @OriginalMember(owner = "client!oe", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 != -21) {
            this.aBoolean517 = true;
        }
        return this.aClass337_3.method7673(true);
    }

    @OriginalMember(owner = "client!oe", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        this.aClass337_3.method7668(toolkit);
    }

    @OriginalMember(owner = "client!oe", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
    }

    @OriginalMember(owner = "client!oe", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.aClass205_7 = null;
        }
        return this.aClass337_3.method7671();
    }
}
