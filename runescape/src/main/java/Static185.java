import org.openrs2.deob.annotation.OriginalMember;

public final class Static185 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!fn", name = "n", descriptor = "Ljava/lang/Class;")
    public static Class locClass;

    @OriginalMember(owner = "client!fn", name = "t", descriptor = "Lclient!fba;")
    public static final Class121 aClass121_3 = new Class121();

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
