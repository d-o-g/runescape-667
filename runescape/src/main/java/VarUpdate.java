import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rga")
public final class VarUpdate extends CutsceneAction {

    @OriginalMember(owner = "client!rga", name = "h", descriptor = "J")
    public final long key;

    @OriginalMember(owner = "client!rga", name = "i", descriptor = "I")
    public final int value;

    @OriginalMember(owner = "client!rga", name = "<init>", descriptor = "(Lclient!ge;Z)V")
    public VarUpdate(@OriginalArg(0) Packet packet, @OriginalArg(1) boolean bit) {
        super(packet);
        @Pc(6) int key = packet.g2();
        if (bit) {
            this.key = (long) key | 0x100000000L;
        } else {
            this.key = key;
        }
        this.value = packet.g4();
    }

    @OriginalMember(owner = "client!rga", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        @Pc(10) IntNode node = (IntNode) CutsceneVarDomain.cache.get(this.key);
        if (node == null) {
            CutsceneVarDomain.cache.put(this.key, new IntNode(this.value));
        } else {
            node.value = this.value;
        }
    }
}
