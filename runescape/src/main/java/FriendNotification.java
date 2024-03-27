import com.jagex.core.datastruct.Node2;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ne")
public final class FriendNotification extends Node2 {

    @OriginalMember(owner = "client!ne", name = "q", descriptor = "I")
    public final int arrivalTime = (int) (SystemTimer.safetime() / 1000L);

    @OriginalMember(owner = "client!ne", name = "s", descriptor = "Ljava/lang/String;")
    public final String name;

    @OriginalMember(owner = "client!ne", name = "r", descriptor = "S")
    public final short world;

    @OriginalMember(owner = "client!ne", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public FriendNotification(@OriginalArg(0) String name, @OriginalArg(1) int world) {
        this.name = name;
        this.world = (short) world;
    }
}
