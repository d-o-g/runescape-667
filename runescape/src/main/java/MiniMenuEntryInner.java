import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pg")
public final class MiniMenuEntryInner extends Node2 {

    @OriginalMember(owner = "client!pg", name = "C", descriptor = "Ljava/lang/String;")
    public String second;

    @OriginalMember(owner = "client!pg", name = "v", descriptor = "J")
    public final long v1;

    @OriginalMember(owner = "client!pg", name = "t", descriptor = "Z")
    public final boolean aBoolean552;

    @OriginalMember(owner = "client!pg", name = "D", descriptor = "I")
    public final int cursor;

    @OriginalMember(owner = "client!pg", name = "x", descriptor = "I")
    public final int objId;

    @OriginalMember(owner = "client!pg", name = "G", descriptor = "I")
    public final int v3;

    @OriginalMember(owner = "client!pg", name = "z", descriptor = "I")
    public int action;

    @OriginalMember(owner = "client!pg", name = "u", descriptor = "Ljava/lang/String;")
    public final String op;

    @OriginalMember(owner = "client!pg", name = "B", descriptor = "J")
    public final long entryKey;

    @OriginalMember(owner = "client!pg", name = "w", descriptor = "Ljava/lang/String;")
    public final String opBase;

    @OriginalMember(owner = "client!pg", name = "F", descriptor = "I")
    public final int v2;

    @OriginalMember(owner = "client!pg", name = "E", descriptor = "Z")
    public final boolean differentLevel;

    @OriginalMember(owner = "client!pg", name = "H", descriptor = "Z")
    public final boolean independent;

    @OriginalMember(owner = "client!pg", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIJIIZZJZ)V")
    public MiniMenuEntryInner(@OriginalArg(0) String op, @OriginalArg(1) String opBase, @OriginalArg(2) int cursor, @OriginalArg(3) int action, @OriginalArg(4) int objId, @OriginalArg(5) long v1, @OriginalArg(6) int v2, @OriginalArg(7) int v3, @OriginalArg(8) boolean arg8, @OriginalArg(9) boolean differentLevel, @OriginalArg(10) long key, @OriginalArg(11) boolean independent) {
        this.v1 = v1;
        this.aBoolean552 = arg8;
        this.cursor = cursor;
        this.objId = objId;
        this.v3 = v3;
        this.action = action;
        this.op = op;
        this.entryKey = key;
        this.opBase = opBase;
        this.v2 = v2;
        this.differentLevel = differentLevel;
        this.independent = independent;
    }
}
