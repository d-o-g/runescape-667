import com.jagex.Client;
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
    public Class37_Sub1(@OriginalArg(0) js5 arg0, @OriginalArg(1) RotatingImageInstance arg1) {
        super(arg0, arg1);
    }

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(17) int local17 = super.instance.aHorizontalAlignment_9.align(Client.loadingScreenWidth, super.sprite.scaleWidth()) + super.instance.anInt3850;
        @Pc(32) int local32 = super.instance.aVerticalAlignment_9.align(Client.loadingScreenHeight, super.sprite.scaleHeight()) + super.instance.anInt3845;
        super.sprite.method8186((float) (super.sprite.scaleWidth() / 2 + local17), (float) (super.sprite.scaleHeight() / 2 + local32), 4096, this.anInt946);
        this.anInt946 += ((RotatingImageInstance) super.instance).anInt3853;
    }
}
