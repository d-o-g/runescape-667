import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pba")
public final class Class286 {

    @OriginalMember(owner = "client!pba", name = "a", descriptor = "Lclient!pba;")
    public Class286 aClass286_1;

    @OriginalMember(owner = "client!pba", name = "e", descriptor = "Lclient!qf;")
    public PositionEntity aPositionEntity;

    @OriginalMember(owner = "client!pba", name = "a", descriptor = "(I)V")
    public void method6459() {
        if (Static181.anInt3006 < 500) {
            this.aClass286_1 = Static620.aClass286_3;
            this.aPositionEntity = null;
            Static620.aClass286_3 = this;
            Static181.anInt3006++;
        }
    }
}
