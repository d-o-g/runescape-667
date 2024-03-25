import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bf")
public final class Class37_Sub1 extends Class37 {

    @OriginalMember(owner = "client!bf", name = "t", descriptor = "I")
    public int anInt946 = 0;

    @OriginalMember(owner = "client!bf", name = "<init>", descriptor = "(Lclient!sb;Lclient!hea;)V")
    public Class37_Sub1(@OriginalArg(0) js5 arg0, @OriginalArg(1) Class160_Sub1 arg1) {
        super(arg0, arg1);
    }

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(ZI)V")
    @Override
    public void method7749() {
        @Pc(17) int local17 = super.aClass160_2.aHorizontalAlignment_9.align(client.loadingScreenWidth, super.aSprite_7.scaleWidth()) + super.aClass160_2.anInt3850;
        @Pc(32) int local32 = super.aClass160_2.aVerticalAlignment_9.align(client.loadingScreenHeight, super.aSprite_7.scaleHeight()) + super.aClass160_2.anInt3845;
        super.aSprite_7.method8186((float) (super.aSprite_7.scaleWidth() / 2 + local17), (float) (super.aSprite_7.scaleHeight() / 2 + local32), 4096, this.anInt946);
        this.anInt946 += ((Class160_Sub1) super.aClass160_2).anInt3853;
    }
}
