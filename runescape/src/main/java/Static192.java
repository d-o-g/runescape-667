import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static192 {

    @OriginalMember(owner = "client!fu", name = "a", descriptor = "(I)Lclient!aea;")
    public static Class8_Sub1 method2876() {
        @Pc(14) Class8_Sub1 local14 = (Class8_Sub1) Static129.A_ENTITY_LIST___3.removeFirst();
        if (local14 == null) {
            return new Class8_Sub1();
        } else {
            Static6.anInt94--;
            return local14;
        }
    }

}
