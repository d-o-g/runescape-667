import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.InputStream;

@OriginalClass("client!saa")
public final class InputStream_Sub2 extends InputStream {

    @OriginalMember(owner = "client!saa", name = "read", descriptor = "()I")
    @Override
    public int read() {
        Static638.sleep(30000L);
        return -1;
    }
}
