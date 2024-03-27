import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!an")
public final class QuickChatPhrase {

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(Lclient!ge;Z)Lclient!an;")
    public static QuickChatPhrase decode(@OriginalArg(0) Packet packet) {
        @Pc(14) QuickChatPhrase phrase = new QuickChatPhrase();
        phrase.id = packet.g2();
        phrase.type = QuickChatPhraseTypeList.instance.get(phrase.id);
        return phrase;
    }

    @OriginalMember(owner = "client!an", name = "d", descriptor = "Lclient!ih;")
    public QuickChatPhraseType type;

    @OriginalMember(owner = "client!an", name = "a", descriptor = "[I")
    public int[] fillerValues;

    @OriginalMember(owner = "client!an", name = "c", descriptor = "I")
    public int id;
}
