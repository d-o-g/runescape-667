import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static192 {

    @OriginalMember(owner = "client!fu", name = "a", descriptor = "(Lclient!cba;B)Ljava/lang/String;")
    public static String method2874(@OriginalArg(0) DoublyLinkedNode_Sub2_Sub4 arg0) {
        return arg0.aString10 + " <col=ffffff>>";
    }

    @OriginalMember(owner = "client!fu", name = "a", descriptor = "(Lclient!cba;I)I")
    public static int method2875(@OriginalArg(0) DoublyLinkedNode_Sub2_Sub4 arg0) {
        @Pc(14) String local14 = method2874(arg0);
        return Fonts.b12Metrics.stringWidth(Static186.aSpriteArray5, local14);
    }

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

    @OriginalMember(owner = "client!fu", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;I)V")
    public static void method2877(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
        Static524.aServerConnection_3 = ConnectionManager.GAME;
        Static299.anInt4825 = 2;
        Static470.anInt7113 = arg1;
        Static238.method3471(false, arg2, false, arg0);
    }
}
