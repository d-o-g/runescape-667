import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mia")
public final class ClientTriggerType implements TriggerType {

    @OriginalMember(owner = "client!oi", name = "r", descriptor = "Lclient!mia;")
    public static final ClientTriggerType VIDEO_END = new ClientTriggerType("", 18);

    @OriginalMember(owner = "client!mia", name = "a", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!mia", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public ClientTriggerType(@OriginalArg(0) String arg0, @OriginalArg(1) int id) {
        this.id = id;
    }

    @OriginalMember(owner = "client!mia", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
