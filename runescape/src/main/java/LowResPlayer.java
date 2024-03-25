import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tea")
public final class LowResPlayer {

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "I")
    public int target;

    @OriginalMember(owner = "client!tea", name = "e", descriptor = "Z")
    public boolean aBoolean711;

    @OriginalMember(owner = "client!tea", name = "h", descriptor = "I")
    public int coord;

    @OriginalMember(owner = "client!tea", name = "d", descriptor = "I")
    public int direcion;

    @OriginalMember(owner = "client!tea", name = "k", descriptor = "Z")
    public boolean clanmate;
}
