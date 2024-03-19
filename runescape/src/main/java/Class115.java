import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ev")
public final class Class115 implements Interface15 {

    @OriginalMember(owner = "client!ev", name = "h", descriptor = "Ljava/lang/String;")
    public final String aString29;

    @OriginalMember(owner = "client!ev", name = "c", descriptor = "Lclient!sb;")
    public final js5 aJs5_30;

    @OriginalMember(owner = "client!ev", name = "<init>", descriptor = "(Lclient!sb;Ljava/lang/String;)V")
    public Class115(@OriginalArg(0) js5 arg0, @OriginalArg(1) String arg1) {
        this.aString29 = arg1;
        this.aJs5_30 = arg0;
    }

    @OriginalMember(owner = "client!ev", name = "a", descriptor = "(I)I")
    @Override
    public int method6465() {
        return this.aJs5_30.method7598(this.aString29) ? 100 : this.aJs5_30.completePercentage(this.aString29);
    }

    @OriginalMember(owner = "client!ev", name = "a", descriptor = "(B)Lclient!kf;")
    @Override
    public Class206 method6464() {
        return Static326.aClass206_3;
    }
}
