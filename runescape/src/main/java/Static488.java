import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static488 {

    @OriginalMember(owner = "client!pga", name = "l", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_33 = new Class155(51);

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(Lclient!fba;I)I")
    public static int method6521(@OriginalArg(0) Class121 arg0) {
        if (arg0 == Static185.aClass121_3) {
            return 7681;
        } else if (arg0 == Static209.aClass121_4) {
            return 8448;
        } else if (arg0 == Static725.aClass121_6) {
            return 34165;
        } else if (arg0 == Static438.aClass121_5) {
            return 260;
        } else if (Static329.aClass121_2 == arg0) {
            return 34023;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/Class;")
    public static Class method6524(@OriginalArg(0) String arg0) throws ClassNotFoundException {
        if (arg0.equals("B")) {
            return Byte.TYPE;
        } else if (arg0.equals("I")) {
            return Integer.TYPE;
        } else if (arg0.equals("S")) {
            return Short.TYPE;
        } else if (arg0.equals("J")) {
            return Long.TYPE;
        } else if (arg0.equals("Z")) {
            return Boolean.TYPE;
        } else if (arg0.equals("F")) {
            return Float.TYPE;
        } else if (arg0.equals("D")) {
            return Double.TYPE;
        } else if (arg0.equals("C")) {
            return Character.TYPE;
        } else {
            return Class.forName(arg0);
        }
    }
}
