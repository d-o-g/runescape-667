import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pa")
public final class ChatLine {

    @OriginalMember(owner = "client!be", name = "I", descriptor = "I")
    public static int nextUid = 0;

    @OriginalMember(owner = "client!nj", name = "d", descriptor = "(I)I")
    public static int nextUid() {
        return nextUid++;
    }

    @OriginalMember(owner = "client!pa", name = "f", descriptor = "I")
    public int uid = nextUid();

    @OriginalMember(owner = "client!pa", name = "j", descriptor = "I")
    public int flags;

    @OriginalMember(owner = "client!pa", name = "m", descriptor = "I")
    public int quickChatId;

    @OriginalMember(owner = "client!pa", name = "k", descriptor = "Ljava/lang/String;")
    public String clan;

    @OriginalMember(owner = "client!pa", name = "l", descriptor = "Ljava/lang/String;")
    public String nameUnfiltered;

    @OriginalMember(owner = "client!pa", name = "d", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!pa", name = "c", descriptor = "I")
    public int clock;

    @OriginalMember(owner = "client!pa", name = "h", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!pa", name = "i", descriptor = "Ljava/lang/String;")
    public String displayName;

    @OriginalMember(owner = "client!pa", name = "e", descriptor = "Ljava/lang/String;")
    public String message;

    @OriginalMember(owner = "client!pa", name = "<init>", descriptor = "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V")
    public ChatLine(@OriginalArg(0) int type, @OriginalArg(1) int flags, @OriginalArg(2) String name, @OriginalArg(3) String nameUnfiltered, @OriginalArg(4) String displayName, @OriginalArg(5) String clan, @OriginalArg(6) int quickChatId, @OriginalArg(7) String message) {
        this.flags = flags;
        this.quickChatId = quickChatId;
        this.clan = clan;
        this.nameUnfiltered = nameUnfiltered;
        this.name = name;
        this.clock = TimeUtils.clock;
        this.type = type;
        this.displayName = displayName;
        this.message = message;
    }

    @OriginalMember(owner = "client!pa", name = "a", descriptor = "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V")
    public void update(@OriginalArg(4) int type, @OriginalArg(1) int flags, @OriginalArg(2) String name, @OriginalArg(5) String nameUnfiltered, @OriginalArg(8) String displayName, @OriginalArg(7) String channel, @OriginalArg(0) int quickChatId, @OriginalArg(3) String message) {
        this.uid = nextUid();
        this.name = name;
        this.clan = channel;
        this.clock = TimeUtils.clock;
        this.message = message;
        this.nameUnfiltered = nameUnfiltered;
        this.displayName = displayName;
        this.type = type;
        this.quickChatId = quickChatId;
        this.flags = flags;
    }
}
