import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sl")
public final class Class90_Sub2_Sub1 extends Class90_Sub2 {

    @OriginalMember(owner = "client!sl", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!fw;)V")
    public Class90_Sub2_Sub1(@OriginalArg(0) js5 arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) Class138_Sub1_Sub1 arg2) {
        super(arg0, arg1, arg2);
    }

    @OriginalMember(owner = "client!sl", name = "a", descriptor = "(IIIII)V")
    @Override
    protected void method7756(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        @Pc(14) int local14 = super.aSprite_40.scaleWidth();
        @Pc(26) int local26 = ((Class138_Sub1_Sub1) super.aClass138_5).anInt3192 * Static556.method7302() / 10 % local14;
        super.aSprite_40.method8198(arg1 + local26 - local14, arg0, arg2 + local14 - local26, arg3);
    }
}
