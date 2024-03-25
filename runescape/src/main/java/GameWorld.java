import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pq")
public final class GameWorld extends Class297 {

    @OriginalMember(owner = "client!pq", name = "q", descriptor = "Ljava/lang/String;")
    public String address;

    @OriginalMember(owner = "client!pq", name = "n", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!pq", name = "y", descriptor = "Ljava/lang/String;")
    public String activity;

    @OriginalMember(owner = "client!pq", name = "r", descriptor = "I")
    public int ping = -1;

    @OriginalMember(owner = "client!pq", name = "a", descriptor = "(B)Lclient!ci;")
    public Country method6717() {
        return WorldList.countries[super.country];
    }
}
