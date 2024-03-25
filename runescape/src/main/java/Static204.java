import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static204 {

    @OriginalMember(owner = "client!gfa", name = "l", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_14 = new Class155(22);

    @OriginalMember(owner = "client!gfa", name = "u", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___16 = new Deque();

    @OriginalMember(owner = "client!kb", name = "n", descriptor = "[B")
    public static final byte[] aByteArray103;

    static {
        @Pc(46) int local46 = 0;
        aByteArray103 = new byte[32896];
        for (@Pc(51) int local51 = 0; local51 < 256; local51++) {
            for (@Pc(54) int local54 = 0; local54 <= local51; local54++) {
                aByteArray103[local46++] = (byte) (int) (255.0D / Math.sqrt((float) (local51 * local51 + local54 * local54 + 65535) / 65535.0F));
            }
        }
    }

}
