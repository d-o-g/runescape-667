import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!paa")
public final class Class284 {

    @OriginalMember(owner = "client!paa", name = "g", descriptor = "C")
    public char aChar5;

    @OriginalMember(owner = "client!paa", name = "f", descriptor = "I")
    public int temporary = 1;

    @OriginalMember(owner = "client!paa", name = "a", descriptor = "(ILclient!ge;B)V")
    public void method6447(@OriginalArg(0) int arg0, @OriginalArg(1) Packet arg1) {
        if (arg0 == 1) {
            this.aChar5 = Cp1252.decodeChar(arg1.g1b());
        } else if (arg0 == 2) {
            this.temporary = 0;
        }
    }

    @OriginalMember(owner = "client!paa", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet arg0) {
        while (true) {
            @Pc(13) int local13 = arg0.g1();
            if (local13 == 0) {
                return;
            }
            this.method6447(local13, arg0);
        }
    }
}
