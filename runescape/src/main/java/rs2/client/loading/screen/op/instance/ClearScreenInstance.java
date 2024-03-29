package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!gi")
public final class ClearScreenInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!uka", name = "a", descriptor = "(Lclient!ge;I)Lclient!gi;")
    public static ClearScreenInstance decode(@OriginalArg(0) Packet packet) {
        @Pc(16) int colour = packet.g4();
        return new ClearScreenInstance(colour);
    }

    @OriginalMember(owner = "client!gi", name = "b", descriptor = "I")
    public final int colour;

    @OriginalMember(owner = "client!gi", name = "<init>", descriptor = "(I)V")
    public ClearScreenInstance(@OriginalArg(0) int colour) {
        this.colour = colour;
    }

    @OriginalMember(owner = "client!gi", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.CLEAR_SCREEN;
    }
}
