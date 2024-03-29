import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static545 {

    @OriginalMember(owner = "client!rca", name = "a", descriptor = "([IB[I)V")
    public static void method7241(@OriginalArg(0) int[] arg0, @OriginalArg(2) int[] arg1) {
        if (arg0 == null || arg1 == null) {
            Packet.anIntArray13 = null;
            Packet.aByteArrayArrayArray2 = null;
            Packet.anIntArray311 = null;
            return;
        }
        Packet.anIntArray13 = arg0;
        Packet.anIntArray311 = new int[arg0.length];
        Packet.aByteArrayArrayArray2 = new byte[arg0.length][][];
        for (@Pc(39) int local39 = 0; local39 < Packet.anIntArray13.length; local39++) {
            Packet.aByteArrayArrayArray2[local39] = new byte[arg1[local39]][];
        }
    }

}
