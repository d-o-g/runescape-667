import com.jagex.core.constants.ChatLineType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ChatHistory {

    @OriginalMember(owner = "client!ph", name = "D", descriptor = "[Lclient!pa;")
    public static final ChatLine[] lines = new ChatLine[100];

    @OriginalMember(owner = "client!wm", name = "e", descriptor = "I")
    public static int lastTransmit = 0;

    @OriginalMember(owner = "client!eaa", name = "x", descriptor = "I")
    public static int length;

    @OriginalMember(owner = "client!aea", name = "a", descriptor = "(II)Lclient!pa;")
    public static ChatLine get(@OriginalArg(0) int index) {
        return index >= 0 && index < 100 ? lines[index] : null;
    }

    @OriginalMember(owner = "client!cca", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void addPrivateError(@OriginalArg(1) String message) {
        add(message, "", 0, "", "", ChatLineType.PRIVATE_ERROR);
    }

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public static void addScript(@OriginalArg(0) String message) {
        add(message, "", 0, "", "", ChatLineType.SCRIPT);
    }

    @OriginalMember(owner = "client!bia", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)V")
    public static void add(@OriginalArg(0) String message, @OriginalArg(1) String name, @OriginalArg(3) int arg2, @OriginalArg(4) String displayName, @OriginalArg(5) String accountName, @OriginalArg(6) int type) {
        add(accountName, name, -1, message, null, arg2, displayName, type);
    }

    @OriginalMember(owner = "client!v", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V")
    public static void add(@OriginalArg(0) String accountName, @OriginalArg(1) String name, @OriginalArg(2) int quickchatId, @OriginalArg(3) String message, @OriginalArg(4) String channel, @OriginalArg(6) int flags, @OriginalArg(7) String displayName, @OriginalArg(8) int type) {
        @Pc(7) ChatLine line = lines[99];
        for (@Pc(9) int i = 99; i > 0; i--) {
            lines[i] = lines[i - 1];
        }

        if (line == null) {
            line = new ChatLine(type, flags, name, accountName, displayName, channel, quickchatId, message);
        } else {
            line.update(quickchatId, flags, name, message, type, accountName, channel, displayName);
        }

        lines[0] = line;
        lastTransmit = World.tick;
        length++;
    }

    private ChatHistory() {
        /* empty */
    }
}
