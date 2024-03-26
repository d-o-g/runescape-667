import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static362 {

    @OriginalMember(owner = "client!lha", name = "b", descriptor = "I")
    public static int anInt5828;

    @OriginalMember(owner = "client!lha", name = "f", descriptor = "Lclient!mia;")
    public static final ClientTriggerType A_CLIENT_TRIGGER_TYPE___10 = new ClientTriggerType("", 19);

    @OriginalMember(owner = "client!lha", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean method5241(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
        if (arg1 == null) {
            return false;
        }
        for (@Pc(10) int local10 = arg0; local10 < FriendsList.count; local10++) {
            if (arg1.equalsIgnoreCase(FriendsList.names[local10])) {
                return true;
            }
        }
        return arg1.equalsIgnoreCase(PlayerEntity.self.accountName);
    }
}
