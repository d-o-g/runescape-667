import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dj")
public final class ChatMessage {

    @OriginalMember(owner = "client!dj", name = "e", descriptor = "I")
    public int colour;

    @OriginalMember(owner = "client!dj", name = "i", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!dj", name = "k", descriptor = "I")
    public int duration;

    @OriginalMember(owner = "client!dj", name = "h", descriptor = "I")
    public int effect;

    @OriginalMember(owner = "client!dj", name = "m", descriptor = "Ljava/lang/String;")
    public String text;

    @OriginalMember(owner = "client!dj", name = "b", descriptor = "(I)I")
    public int getDuration() {
        return this.duration;
    }

    @OriginalMember(owner = "client!dj", name = "c", descriptor = "(I)Ljava/lang/String;")
    public String getText() {
        return this.text;
    }

    @OriginalMember(owner = "client!dj", name = "a", descriptor = "(I)I")
    public int getColour() {
        return this.colour;
    }

    @OriginalMember(owner = "client!dj", name = "d", descriptor = "(I)I")
    public int getEffect() {
        return this.effect;
    }

    @OriginalMember(owner = "client!dj", name = "a", descriptor = "(B)I")
    public int getRemaining() {
        return this.remaining;
    }
}
