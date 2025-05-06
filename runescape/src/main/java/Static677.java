import com.jagex.core.datastruct.key.Deque;
import com.jagex.graphics.TextureSource;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.mouse.MouseLog;

public final class Static677 {

    @OriginalMember(owner = "client!vi", name = "L", descriptor = "Lclient!d;")
    public static TextureSource anTextureSource_11;

    @OriginalMember(owner = "client!vi", name = "J", descriptor = "Lclient!sia;")
    public static final Deque<MouseLog> mouseMovements = new Deque();
}
