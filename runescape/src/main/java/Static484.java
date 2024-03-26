import org.openrs2.deob.annotation.OriginalMember;

public final class Static484 {

    @OriginalMember(owner = "client!pea", name = "l", descriptor = "Lclient!rt;")
    public static Class327 aClass327_6;

    // $FF: synthetic field
    @OriginalMember(owner = "client!pea", name = "n", descriptor = "Ljava/lang/Class;")
    public static Class aClass19;

    @OriginalMember(owner = "client!pea", name = "i", descriptor = "Ljava/lang/String;")
    public static String aString85 = null;

    static Class getClass(String name) {
        Class instance;
        try {
            instance = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw (NoClassDefFoundError) new NoClassDefFoundError().initCause(ex);
        }
        return instance;
    }
}
