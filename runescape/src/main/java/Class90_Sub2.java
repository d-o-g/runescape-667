import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gr")
public class Class90_Sub2 extends Class90 {

    @OriginalMember(owner = "client!gr", name = "x", descriptor = "Lclient!st;")
    public Sprite aSprite_35;

    @OriginalMember(owner = "client!gr", name = "s", descriptor = "Lclient!st;")
    public Sprite aSprite_36;

    @OriginalMember(owner = "client!gr", name = "z", descriptor = "Lclient!st;")
    public Sprite aSprite_37;

    @OriginalMember(owner = "client!gr", name = "q", descriptor = "Lclient!st;")
    public Sprite aSprite_38;

    @OriginalMember(owner = "client!gr", name = "r", descriptor = "Lclient!st;")
    public Sprite aSprite_39;

    @OriginalMember(owner = "client!gr", name = "y", descriptor = "Lclient!st;")
    protected Sprite aSprite_40;

    @OriginalMember(owner = "client!gr", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!rk;)V")
    public Class90_Sub2(@OriginalArg(0) js5 arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) Class138_Sub1 arg2) {
        super(arg0, arg1, arg2);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(ZIBI)V")
    @Override
    protected final void method7751(@OriginalArg(1) int arg0, @OriginalArg(3) int arg1) {
        @Pc(8) int[] local8 = new int[4];
        Toolkit.active.K(local8);
        Toolkit.active.KA(arg0, arg1, arg0 + super.aClass138_5.anInt4418, super.aClass138_5.anInt4413 + arg1);
        @Pc(30) int local30 = this.aSprite_36.scaleWidth();
        @Pc(34) int local34 = this.aSprite_36.scaleHeight();
        @Pc(38) int local38 = this.aSprite_35.scaleWidth();
        @Pc(42) int local42 = this.aSprite_35.scaleHeight();
        this.aSprite_36.render(arg0, (super.aClass138_5.anInt4413 - local34) / 2 + arg1);
        this.aSprite_35.render(super.aClass138_5.anInt4418 + arg0 - local38, (-local42 + super.aClass138_5.anInt4413) / 2 + arg1);
        Toolkit.active.KA(arg0, arg1, super.aClass138_5.anInt4418 + arg0, this.aSprite_37.scaleHeight() + arg1);
        this.aSprite_37.method8198(local30 + arg0, arg1, super.aClass138_5.anInt4418 - local38 - local30, super.aClass138_5.anInt4413);
        @Pc(112) int local112 = this.aSprite_38.scaleHeight();
        Toolkit.active.KA(arg0, super.aClass138_5.anInt4413 + arg1 - local112, arg0 + super.aClass138_5.anInt4418, arg1 + super.aClass138_5.anInt4413);
        this.aSprite_38.method8198(local30 + arg0, super.aClass138_5.anInt4413 + arg1 + -local112, super.aClass138_5.anInt4418 - local30 - local38, super.aClass138_5.anInt4413);
        Toolkit.active.KA(local8[0], local8[1], local8[2], local8[3]);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(IIZI)V")
    @Override
    protected final void method7753(@OriginalArg(0) int arg0, @OriginalArg(3) int arg1) {
        @Pc(9) int local9 = arg0 + this.aSprite_36.scaleWidth();
        @Pc(27) int local27 = arg0 + super.aClass138_5.anInt4418 - this.aSprite_35.scaleWidth();
        @Pc(33) int local33 = this.aSprite_37.scaleHeight() + arg1;
        @Pc(45) int local45 = arg1 + super.aClass138_5.anInt4413 - this.aSprite_38.scaleHeight();
        @Pc(50) int local50 = local27 - local9;
        @Pc(55) int local55 = local45 - local33;
        @Pc(63) int local63 = this.method7752() * local50 / 10000;
        @Pc(66) int[] local66 = new int[4];
        Toolkit.active.K(local66);
        Toolkit.active.KA(local9, local33, local63 + local9, local45);
        this.method7756(local33, local9, local50, local55);
        Toolkit.active.KA(local63 + local9, local33, local27, local45);
        this.aSprite_39.method8198(local9, local33, local50, local55);
        Toolkit.active.KA(local66[0], local66[1], local66[2], local66[3]);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(IIIII)V")
    protected void method7756(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        this.aSprite_40.method8198(arg1, arg0, arg2, arg3);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(I)V")
    @Override
    public final void init() {
        super.init();
        @Pc(10) Class138_Sub1 local10 = (Class138_Sub1) super.aClass138_5;
        this.aSprite_40 = Loading.sprite(local10.anInt3188, super.aJs5_109);
        this.aSprite_39 = Loading.sprite(local10.anInt3190, super.aJs5_109);
        this.aSprite_36 = Loading.sprite(local10.anInt3189, super.aJs5_109);
        this.aSprite_35 = Loading.sprite(local10.anInt3185, super.aJs5_109);
        this.aSprite_37 = Loading.sprite(local10.anInt3183, super.aJs5_109);
        this.aSprite_38 = Loading.sprite(local10.anInt3182, super.aJs5_109);
    }

    @OriginalMember(owner = "client!gr", name = "b", descriptor = "(I)Z")
    @Override
    public final boolean ready() {
        if (!super.ready()) {
            return false;
        }
        @Pc(14) Class138_Sub1 local14 = (Class138_Sub1) super.aClass138_5;
        if (!super.aJs5_109.fileready(local14.anInt3188)) {
            return false;
        } else if (!super.aJs5_109.fileready(local14.anInt3190)) {
            return false;
        } else if (!super.aJs5_109.fileready(local14.anInt3189)) {
            return false;
        } else if (!super.aJs5_109.fileready(local14.anInt3185)) {
            return false;
        } else if (super.aJs5_109.fileready(local14.anInt3183)) {
            return super.aJs5_109.fileready(local14.anInt3182);
        } else {
            return false;
        }
    }
}
