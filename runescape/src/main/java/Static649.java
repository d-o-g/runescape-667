import com.jagex.FileCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static649 {

    @OriginalMember(owner = "client!uia", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void iniailize(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
        FileCache.storeId = arg0;
        FileCache.game = arg1;
        try {
            FileCache.homeDir = System.getProperty("user.home");
            if (FileCache.homeDir != null) {
                FileCache.homeDir = FileCache.homeDir + "/";
            }
        } catch (@Pc(26) Exception local26) {
        }
        if (FileCache.homeDir == null) {
            FileCache.homeDir = "~/";
        }
        FileCache.initialized = true;
    }
}
