import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!om")
public final class Class280 {

    @OriginalMember(owner = "client!om", name = "g", descriptor = "I")
    public final int anInt7039;

    @OriginalMember(owner = "client!om", name = "<init>", descriptor = "(I)V")
    public Class280(@OriginalArg(0) int arg0) {
        this.anInt7039 = arg0;
    }

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(IB)Lclient!om;")
    public static Class280 method2864(@OriginalArg(0) int arg0) {
        @Pc(6) Class280[] local6 = Static400.method7112();
        for (@Pc(8) int local8 = 0; local8 < local6.length; local8++) {
            @Pc(19) Class280 local19 = local6[local8];
            if (arg0 == local19.anInt7039) {
                return local19;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!om", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
