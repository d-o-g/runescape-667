import com.jagex.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.File;

public final class Static93 {

    @OriginalMember(owner = "client!cu", name = "Y", descriptor = "Lclient!vq;")
    public static SignLink nativeLink;

    // $FF: synthetic field
    @OriginalMember(owner = "client!cu", name = "Q", descriptor = "Ljava/lang/Class;")
    public static Class aClass6;

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(Ljava/lang/Class;ZLjava/lang/String;)Z")
    public static boolean method1833(@OriginalArg(0) Class arg0, @OriginalArg(2) String arg1) {
        @Pc(15) Class local15 = (Class) Static137.aHashtable2.get(arg1);
        if (local15 != null) {
            return local15.getClassLoader() == arg0.getClassLoader();
        }
        @Pc(31) File local31 = null;
        if (local31 == null) {
            local31 = (File) Static154.loadedLibraries.get(arg1);
        }
        if (local31 != null) {
            try {
				/*local31 = new File(local31.getCanonicalPath());
				@Pc(51) Class local51 = Class.forName("java.lang.Runtime");
				@Pc(56) Class local56 = Class.forName("java.lang.reflect.AccessibleObject");
				@Pc(68) Method local68 = local56.getDeclaredMethod("setAccessible", Boolean.TYPE);
				@Pc(90) Method local90 = local51.getDeclaredMethod("load0", Class.forName("java.lang.Class"), Class.forName("java.lang.String"));
				local68.invoke(local90, Boolean.TRUE);
				local90.invoke(Runtime.getRuntime(), arg0, local31.getPath());
				local68.invoke(local90, Boolean.FALSE);
				Static137.aHashtable2.put(arg1, arg0);
				return true;
			} catch (@Pc(133) NoSuchMethodException local133) {*/
                System.load(local31.getPath());
                Static137.aHashtable2.put(arg1, aClass6 == null ? (aClass6 = getClass("rs2.client.loading.Class332")) : aClass6);
                return true;
            } catch (@Pc(154) Throwable local154) {
            }
        }
        return false;
    }

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
