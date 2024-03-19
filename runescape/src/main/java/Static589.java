import com.jagex.core.compress.GzipDecompressor;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Font;

public final class Static589 {

    @OriginalMember(owner = "client!sk", name = "l", descriptor = "Ljava/awt/Font;")
    public static Font aFont1;

    @OriginalMember(owner = "client!sk", name = "b", descriptor = "(I)Z")
    public static boolean method7721() {
        try {
            @Pc(7) GzipDecompressor local7 = new GzipDecompressor();
            @Pc(12) byte[] local12 = local7.decompress(GzipDecompressor.aByteArray1);
            Static168.method2634(local12);
            return true;
        } catch (@Pc(28) Exception local28) {
            return false;
        }
    }
}
