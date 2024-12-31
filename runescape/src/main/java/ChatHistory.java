import com.jagex.core.constants.ChatLineType;
import com.jagex.game.world.World;
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
    public static ChatLine getLine(@OriginalArg(0) int index) {
        return index >= 0 && index < 100 ? lines[index] : null;
    }

    @OriginalMember(owner = "client!cca", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void addPrivateError(@OriginalArg(1) String message) {
        add(ChatLineType.PRIVATE_ERROR, 0, "", "", "", message);
    }

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public static void addScript(@OriginalArg(0) String message) {
        add(ChatLineType.SCRIPT, 0, "", "", "", message);
    }

    @OriginalMember(owner = "client!bia", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)V")
    public static void add(@OriginalArg(6) int type, @OriginalArg(3) int flags, @OriginalArg(1) String name, @OriginalArg(5) String nameUnfiltered, @OriginalArg(4) String displayName, @OriginalArg(0) String message) {
        add(type, flags, name, nameUnfiltered, displayName, null, -1, message);
    }

    @OriginalMember(owner = "client!v", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V")
    public static void add(@OriginalArg(8) int type, @OriginalArg(6) int flags, @OriginalArg(1) String name, @OriginalArg(0) String nameUnfiltered, @OriginalArg(7) String displayName, @OriginalArg(4) String channel, @OriginalArg(2) int quickChatId, @OriginalArg(3) String message) {
        @Pc(7) ChatLine line = lines[99];
        for (@Pc(9) int i = 99; i > 0; i--) {
            lines[i] = lines[i - 1];
        }

        if (line == null) {
            line = new ChatLine(type, flags, name, nameUnfiltered, displayName, channel, quickChatId, message);
        } else {
            line.update(type, flags, name, nameUnfiltered, displayName, channel, quickChatId, message);
        }

        lines[0] = line;
        lastTransmit = World.tick;
        length++;
    }

    private ChatHistory() {
        /* empty */
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(B)I")
    public static int length() {
        return length;
    }
}
