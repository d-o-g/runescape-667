import com.jagex.Entity;
import com.jagex.PickableEntity;
import com.jagex.core.constants.LocShapes;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.graphics.BoundingCylinder;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.ModelAndShadow;
import com.jagex.graphics.Shadow;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jda")
public final class StaticLocation extends PositionEntity implements Location {

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(IBI)B")
    public static byte method2904(@OriginalArg(0) int shape, @OriginalArg(2) int rotation) {
        if (shape == LocShapes.WALL_DIAGONAL) {
            return (byte) ((rotation & 0x1) == 0 ? 1 : 2);
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!jda", name = "U", descriptor = "Lclient!ke;")
    public BoundingCylinder cylinder;

    @OriginalMember(owner = "client!jda", name = "nb", descriptor = "Z")
    public final boolean interactive;

    @OriginalMember(owner = "client!jda", name = "Q", descriptor = "Z")
    public final boolean underwater;

    @OriginalMember(owner = "client!jda", name = "cb", descriptor = "B")
    public final byte rotation;

    @OriginalMember(owner = "client!jda", name = "db", descriptor = "S")
    public final short id;

    @OriginalMember(owner = "client!jda", name = "Y", descriptor = "B")
    public final byte shape;

    @OriginalMember(owner = "client!jda", name = "pb", descriptor = "Z")
    public boolean copyNormals;

    @OriginalMember(owner = "client!jda", name = "ib", descriptor = "Z")
    public final boolean castsShadow;

    @OriginalMember(owner = "client!jda", name = "gb", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!jda", name = "eb", descriptor = "Lclient!r;")
    public Shadow shadow;

    @OriginalMember(owner = "client!jda", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIIIIIZ)V")
    public StaticLocation(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) LocType type, @OriginalArg(2) int level, @OriginalArg(3) int virtualLevel, @OriginalArg(4) int x, @OriginalArg(5) int y, @OriginalArg(6) int z, @OriginalArg(7) boolean underwater, @OriginalArg(8) int x1, @OriginalArg(9) int x2, @OriginalArg(10) int z1, @OriginalArg(11) int z2, @OriginalArg(12) int shape, @OriginalArg(13) int rotation, @OriginalArg(14) boolean copyNormals) {
        super(level, virtualLevel, x, y, z, x1, x2, z1, z2, type.raiseobject == 1, method2904(shape, rotation));
        this.interactive = type.active != LocInteractivity.NONINTERACTIVE && !underwater;
        this.underwater = underwater;
        this.rotation = (byte) rotation;
        this.id = (short) type.id;
        this.shape = (byte) shape;
        super.virtualLevel = (byte) virtualLevel;
        this.copyNormals = copyNormals;
        this.castsShadow = toolkit.hardShadow() && type.hardshadow && !this.underwater && ClientOptions.instance.hardShadows.getValue() != 0;

        @Pc(83) int functionMask = 0x800;
        if (this.copyNormals) {
            functionMask |= 0x10000;
        }

        @Pc(98) ModelAndShadow modelAndShadow = this.method4223(toolkit, this.castsShadow, functionMask);
        if (modelAndShadow != null) {
            this.model = modelAndShadow.model;
            this.shadow = modelAndShadow.shadow;

            if (this.copyNormals) {
                this.model = this.model.copy((byte) 0, functionMask, false);
            }
        }
    }

    @OriginalMember(owner = "client!jda", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(16) Shadow local16;
        if (this.shadow == null && this.castsShadow) {
            @Pc(27) ModelAndShadow local27 = this.method4223(toolkit, true, 262144);
            local16 = local27 == null ? null : local27.shadow;
        } else {
            local16 = this.shadow;
            this.shadow = null;
        }
        if (local16 != null) {
            Static292.method4618(local16, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!jda", name = "e", descriptor = "(I)Z")
    @Override
    public boolean hardShadow() {
        return this.castsShadow;
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(B)Z")
    @Override
    public boolean isStationary() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!jda", name = "k", descriptor = "(I)I")
    @Override
    public int getMinY(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.isStationary();
        }
        return this.model == null ? 0 : this.model.fa();
    }

    @OriginalMember(owner = "client!jda", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.stopSharingLight(61);
        }
        return this.copyNormals;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(BLclient!ha;I)Lclient!ka;")
    public Model method4221(@OriginalArg(1) Toolkit arg0, @OriginalArg(2) int arg1) {
        if (this.model != null && arg0.compareFunctionMasks(this.model.ua(), arg1) == 0) {
            return this.model;
        } else {
            @Pc(34) ModelAndShadow local34 = this.method4223(arg0, false, arg1);
            return local34 == null ? null : local34.model;
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.id & 0xFFFF;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean picked(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit toolkit) {
        @Pc(9) Model local9 = this.method4221(toolkit, 131072);
        if (local9 == null) {
            return arg2 ? false : false;
        } else {
            @Pc(14) Matrix local14 = toolkit.scratchMatrix();
            local14.applyTranslation(super.x, super.y, super.z);
            return Static504.renderOrtho ? local9.pickedOrtho(y, x, local14, false, 0, Static582.orthoAngle) : local9.picked(y, x, local14, false, 0);
        }
    }

    @OriginalMember(owner = "client!jda", name = "j", descriptor = "(I)V")
    @Override
    public void stopSharingLight(@OriginalArg(0) int arg0) {
        this.copyNormals = false;
        if (arg0 != 27811) {
            this.cylinder = null;
        }
        if (this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return this.shape;
    }

    @OriginalMember(owner = "client!jda", name = "m", descriptor = "(I)I")
    public int method4222() {
        return this.model == null ? 15 : this.model.na() / 4;
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public BoundingCylinder getCylinder(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (arg1 > -93) {
            return null;
        } else {
            if (this.cylinder == null) {
                this.cylinder = BoundingCylinder.create(super.y, super.x, this.method4221(toolkit, 0), super.z);
            }
            return this.cylinder;
        }
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(21) Shadow shadow;
        if (this.shadow == null && this.castsShadow) {
            @Pc(32) ModelAndShadow modelAndShadow = this.method4223(toolkit, true, 262144);
            shadow = modelAndShadow == null ? null : modelAndShadow.shadow;
        } else {
            shadow = this.shadow;
            this.shadow = null;
        }
        if (shadow != null) {
            Static630.method8357(shadow, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(B)I")
    @Override
    public int getSphereRadius(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return -59;
        }
    }

    @OriginalMember(owner = "client!jda", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 == -5) {
            ;
        }
    }

    @OriginalMember(owner = "client!jda", name = "h", descriptor = "(I)Z")
    @Override
    public boolean isTransparent(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.shadow = null;
        }
        return this.model == null ? false : this.model.F();
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public PickableEntity render(@OriginalArg(1) Toolkit arg0) {
        if (this.model == null) {
            return null;
        }
        @Pc(20) Matrix local20 = arg0.scratchMatrix();
        local20.applyTranslation(super.x, super.y, super.z);
        @Pc(34) PickableEntity local34 = Static642.method8441(this.interactive, 1);
        if (Static504.renderOrtho) {
            this.model.renderOrtho(local20, local34.pickingCylinders[0], Static582.orthoAngle, 0);
        } else {
            this.model.render(local20, local34.pickingCylinders[0], 0);
        }
        return local34;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void shareLight(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6) {
        if (arg6 instanceof StaticWall) {
            @Pc(38) StaticWall local38 = (StaticWall) arg6;
            if (this.model != null && local38.model != null) {
                this.model.method7481(local38.model, arg5, arg0, arg3, arg1);
            }
        } else if (arg6 instanceof StaticLocation) {
            @Pc(14) StaticLocation local14 = (StaticLocation) arg6;
            if (this.model != null && local14.model != null) {
                this.model.method7481(local14.model, arg5, arg0, arg3, arg1);
            }
        }
        if (arg4 <= 101) {
            this.getCylinder(null, -1);
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(Lclient!ha;BZI)Lclient!od;")
    public ModelAndShadow method4223(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2) {
        @Pc(11) LocType local11 = LocTypeList.instance.list(this.id & 0xFFFF);
        @Pc(27) Ground local27;
        @Pc(33) Ground local33;
        if (this.underwater) {
            local27 = Static693.underwaterGround[super.virtualLevel];
            local33 = Static706.floor[0];
        } else {
            local27 = Static706.floor[super.virtualLevel];
            if (super.virtualLevel >= 3) {
                local33 = null;
            } else {
                local33 = Static706.floor[super.virtualLevel + 1];
            }
        }
        return local11.modelAndShadow(this.shape == 11 ? this.rotation + 4 : this.rotation, super.z, super.x, local27, arg1, super.y, this.shape == 11 ? 10 : this.shape, arg0, null, arg2, local33);
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.rotation;
    }
}
