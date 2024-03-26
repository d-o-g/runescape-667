import com.jagex.core.constants.LocShapes;
import com.jagex.core.stringtools.general.Base37;
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

@OriginalClass("client!jn")
public final class StaticWall extends Wall implements Location {

    @OriginalMember(owner = "client!ga", name = "k", descriptor = "[I")
    public static final int[] anIntArray771 = new int[]{16, 32, 64, 128};

    @OriginalMember(owner = "client!gn", name = "i", descriptor = "[I")
    public static final int[] anIntArray285 = new int[]{1, 2, 4, 8};

    @OriginalMember(owner = "client!pha", name = "a", descriptor = "(ZII)I")
    public static int method6553(@OriginalArg(1) int rotation, @OriginalArg(2) int shape) {
        if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
            return anIntArray771[rotation & 0x3];
        } else {
            return anIntArray285[rotation & 0x3];
        }
    }

    @OriginalMember(owner = "client!jn", name = "T", descriptor = "Lclient!ke;")
    public BoundingCylinder cylinder;

    @OriginalMember(owner = "client!jn", name = "ib", descriptor = "Z")
    public final boolean interactive;

    @OriginalMember(owner = "client!jn", name = "cb", descriptor = "S")
    public final short id;

    @OriginalMember(owner = "client!jn", name = "U", descriptor = "B")
    public byte shape;

    @OriginalMember(owner = "client!jn", name = "L", descriptor = "Z")
    public final boolean underwater;

    @OriginalMember(owner = "client!jn", name = "H", descriptor = "Z")
    public boolean copyNormals;

    @OriginalMember(owner = "client!jn", name = "O", descriptor = "B")
    public byte rotation;

    @OriginalMember(owner = "client!jn", name = "hb", descriptor = "Z")
    public final boolean hardShadow;

    @OriginalMember(owner = "client!jn", name = "X", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!jn", name = "eb", descriptor = "Lclient!r;")
    public Shadow shadow;

    @OriginalMember(owner = "client!jn", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIZ)V")
    public StaticWall(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) LocType type, @OriginalArg(2) int level, @OriginalArg(3) int virtualLevel, @OriginalArg(4) int x, @OriginalArg(5) int y, @OriginalArg(6) int z, @OriginalArg(7) boolean underwater, @OriginalArg(8) int shape, @OriginalArg(9) int rotation, @OriginalArg(10) boolean copyNormals) {
        super(x, y, z, level, virtualLevel, method6553(rotation, shape));
        super.x = x;
        super.z = z;
        this.interactive = type.active != LocInteractivity.NONINTERACTIVE && !underwater;
        this.id = (short) type.id;
        this.shape = (byte) shape;
        this.underwater = underwater;
        this.copyNormals = copyNormals;
        this.rotation = (byte) rotation;
        this.hardShadow = toolkit.hardShadow() && type.hardshadow && !this.underwater && ClientOptions.instance.hardShadows.getValue() != 0;

        @Pc(77) int functionMask = 0x800;
        if (this.copyNormals) {
            functionMask |= 0x10000;
        }

        @Pc(92) ModelAndShadow modelAndShadow = this.modelAndShadow(toolkit, functionMask, this.hardShadow);
        if (modelAndShadow != null) {
            this.model = modelAndShadow.model;
            this.shadow = modelAndShadow.shadow;

            if (this.copyNormals) {
                this.model = this.model.copy((byte) 0, functionMask, false);
            }
        }
    }

    @OriginalMember(owner = "client!jn", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.isStationary();
        }
        return this.copyNormals;
    }

    @OriginalMember(owner = "client!jn", name = "h", descriptor = "(I)Z")
    @Override
    public boolean isTransparent(@OriginalArg(0) int arg0) {
        if (arg0 == 0) {
            return this.model == null ? false : this.model.F();
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(21) Shadow local21;
        if (this.shadow == null && this.hardShadow) {
            @Pc(32) ModelAndShadow local32 = this.modelAndShadow(toolkit, 262144, true);
            local21 = local32 == null ? null : local32.shadow;
        } else {
            local21 = this.shadow;
            this.shadow = null;
        }
        if (local21 != null) {
            Static630.method8357(local21, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void shareLight(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Entity arg6) {
        if (arg6 instanceof StaticWall) {
            @Pc(34) StaticWall local34 = (StaticWall) arg6;
            if (this.model != null && local34.model != null) {
                this.model.method7481(local34.model, arg5, arg0, arg3, arg1);
            }
        } else if (arg6 instanceof StaticLocation) {
            @Pc(10) StaticLocation local10 = (StaticLocation) arg6;
            if (this.model != null && local10.model != null) {
                this.model.method7481(local10.model, arg5, arg0, arg3, arg1);
            }
        }
        if (arg4 < 101) {
            this.isTransparent(1);
        }
    }

    @OriginalMember(owner = "client!jn", name = "e", descriptor = "(I)Z")
    @Override
    public boolean hardShadow() {
        return this.hardShadow;
    }

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(B)Z")
    @Override
    public boolean isStationary() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!jn", name = "k", descriptor = "(I)I")
    @Override
    public int getMinY(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            Base37.encode(null);
        }
        return this.model == null ? 0 : this.model.fa();
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public BoundingCylinder getCylinder(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1) {
        if (this.cylinder == null) {
            this.cylinder = BoundingCylinder.create(super.y, super.x, this.method4474(toolkit, 0), super.z);
        }
        if (arg1 >= -93) {
            this.cylinder = null;
        }
        return this.cylinder;
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;BI)Lclient!ka;")
    public Model method4474(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) int arg1) {
        if (this.model != null && arg0.compareFunctionMasks(this.model.ua(), arg1) == 0) {
            return this.model;
        } else {
            @Pc(37) ModelAndShadow local37 = this.modelAndShadow(arg0, arg1, false);
            return local37 == null ? null : local37.model;
        }
    }

    @OriginalMember(owner = "client!jn", name = "j", descriptor = "(I)V")
    @Override
    public void stopSharingLight(@OriginalArg(0) int arg0) {
        this.copyNormals = false;
        if (this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
        if (arg0 != 27811) {
            this.shape = -28;
        }
    }

    @OriginalMember(owner = "client!jn", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(24) Shadow local24;
        if (this.shadow == null && this.hardShadow) {
            @Pc(35) ModelAndShadow local35 = this.modelAndShadow(toolkit, 262144, true);
            local24 = local35 == null ? null : local35.shadow;
        } else {
            local24 = this.shadow;
            this.shadow = null;
        }
        if (local24 != null) {
            Static292.method4618(local24, super.virtualLevel, super.x, super.z, null);
        }
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(B)I")
    @Override
    public int getSphereRadius(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return 49;
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;ZIZ)Lclient!od;")
    public ModelAndShadow modelAndShadow(@OriginalArg(0) Toolkit toolkit, @OriginalArg(2) int functionMask, @OriginalArg(3) boolean addShadow) {
        @Pc(11) LocType type = LocTypeList.instance.list(this.id & 0xFFFF);
        @Pc(27) Ground floor;
        @Pc(38) Ground ceiling;

        if (this.underwater) {
            floor = Static693.underwaterGround[super.virtualLevel];
            ceiling = Static706.floor[0];
        } else {
            floor = Static706.floor[super.virtualLevel];
            if (super.virtualLevel < 3) {
                ceiling = Static706.floor[super.virtualLevel + 1];
            } else {
                ceiling = null;
            }
        }

        return type.modelAndShadow(this.rotation, super.z, super.x, floor, addShadow, super.y, this.shape, toolkit, null, functionMask, ceiling);
    }

    @OriginalMember(owner = "client!jn", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            this.copyNormals = true;
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean picked(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit toolkit) {
        @Pc(9) Model local9 = this.method4474(toolkit, 131072);
        if (local9 == null) {
            if (arg2) {
                this.cylinder = null;
            }
            return false;
        } else {
            @Pc(14) Matrix local14 = toolkit.scratchMatrix();
            local14.applyTranslation(super.x, super.y, super.z);
            return Static504.renderOrtho ? local9.pickedOrtho(y, x, local14, false, 0, Static582.orthoAngle) : local9.picked(y, x, local14, false, 0);
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.id & 0xFFFF;
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
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

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return this.shape;
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.rotation;
    }
}
