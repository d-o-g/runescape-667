import com.jagex.ClientProt;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class VerifyId {

    @OriginalMember(owner = "client!hp", name = "O", descriptor = "Z")
    private static boolean transmitRequested = false;

    public static boolean isTransmitRequested() {
        return transmitRequested;
    }

    public static void cancelTransmitRequest() {
        transmitRequested = false;
    }

    @OriginalMember(owner = "client!kja", name = "a", descriptor = "I")
    private static int value = 0;

    public static void reset() {
        value = 0;
    }

    public static int getValue() {
        return value;
    }

    @OriginalMember(owner = "client!saa", name = "a", descriptor = "(I)Z")
    public static boolean incrementAndTransmit() {
        value++;
        transmitRequested = true;
        return true;
    }

    @OriginalMember(owner = "client!eia", name = "f", descriptor = "(B)V")
    public static void transmit() {
        @Pc(20) ClientMessage message = ClientMessage.create(ClientProt.TRANSMITVAR_VERIFYID, ServerConnection.GAME.isaac);
        message.bitPacket.p4(value);
        ServerConnection.GAME.send(message);
    }

    private VerifyId() {
        /* empty */
    }
}
