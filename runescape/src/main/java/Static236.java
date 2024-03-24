import com.jagex.SignedResource;
import com.jagex.core.util.JagException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static236 {

    @OriginalMember(owner = "client!hfa", name = "s", descriptor = "I")
    public static int anInt3893;

    @OriginalMember(owner = "client!hfa", name = "w", descriptor = "Lclient!oba;")
    public static SignedResource aSignedResource_2;

    @OriginalMember(owner = "client!hfa", name = "r", descriptor = "Z")
    public static boolean aBoolean304 = false;

    @OriginalMember(owner = "client!hfa", name = "u", descriptor = "Z")
    public static boolean aBoolean305 = false;

    @OriginalMember(owner = "client!hfa", name = "a", descriptor = "(Lclient!gw;I)Z")
    public static boolean readPacket(@OriginalArg(0) ServerConnection connection) {
        try {
            return Protocol.readServerMessage(connection);
        } catch (@Pc(15) IOException local15) {
            if (MainLogicManager.step == 9) {
                connection.connection = null;
                return false;
            } else {
                ConnectionManager.disconnect();
                return true;
            }
        } catch (@Pc(29) Exception local29) {
            @Pc(106) String local106 = "T2 - " + (connection.currentProt == null ? -1 : connection.currentProt.getOpcode()) + "," + (connection.penultimateProt == null ? -1 : connection.penultimateProt.getOpcode()) + "," + (connection.antepenultimateProt == null ? -1 : connection.antepenultimateProt.getOpcode()) + " - " + connection.currentPacketSize + "," + (WorldMap.areaBaseX + PlayerEntity.self.pathX[0]) + "," + (WorldMap.areaBaseZ + PlayerEntity.self.pathZ[0]) + " - ";
            for (@Pc(108) int local108 = 0; connection.currentPacketSize > local108 && local108 < 50; local108++) {
                local106 = local106 + connection.buffer.data[local108] + ",";
            }
            JagException.sendTrace(local29, local106);
            Login.logout(false);
            return true;
        }
    }

}
