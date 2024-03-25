import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nba")
public final class HintArrow {

    @OriginalMember(owner = "client!nba", name = "e", descriptor = "I")
    public int flashRate;

    @OriginalMember(owner = "client!nba", name = "o", descriptor = "I")
    public int z;

    @OriginalMember(owner = "client!nba", name = "n", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!nba", name = "a", descriptor = "I")
    public int drawDistance;

    @OriginalMember(owner = "client!nba", name = "p", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!nba", name = "j", descriptor = "I")
    public int entity;

    @OriginalMember(owner = "client!nba", name = "f", descriptor = "I")
    public int sprite;

    @OriginalMember(owner = "client!nba", name = "m", descriptor = "I")
    public int level;

    @OriginalMember(owner = "client!nba", name = "g", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!nba", name = "k", descriptor = "I")
    public int model = -1;
}
