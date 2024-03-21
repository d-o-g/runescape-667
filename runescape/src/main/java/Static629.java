import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.File;

public final class Static629 {

    @OriginalMember(owner = "client!tu", name = "j", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_228 = new Class225(94, -1);

    @OriginalMember(owner = "client!tu", name = "a", descriptor = "(BLjava/io/File;)[B")
    public static byte[] method8348(@OriginalArg(1) File arg0) {
        return Static600.method7864(arg0, (int) arg0.length());
    }
}
