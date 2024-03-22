import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fu")
public final class MapElementListEntry extends Node {

    @OriginalMember(owner = "client!fu", name = "u", descriptor = "I")
    public int anInt3122;

    @OriginalMember(owner = "client!fu", name = "v", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!fu", name = "l", descriptor = "I")
    public int level;

    @OriginalMember(owner = "client!fu", name = "o", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!fu", name = "t", descriptor = "I")
    public int anInt3130;

    @OriginalMember(owner = "client!fu", name = "n", descriptor = "Z")
    public boolean aBoolean256 = false;

    @OriginalMember(owner = "client!fu", name = "m", descriptor = "I")
    public int id = -1;

    @OriginalMember(owner = "client!fu", name = "<init>", descriptor = "(I)V")
    public MapElementListEntry(@OriginalArg(0) int arg0) {
        this.id = arg0;
    }
}
