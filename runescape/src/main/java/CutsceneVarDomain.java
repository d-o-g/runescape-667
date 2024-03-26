import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gl")
public final class CutsceneVarDomain implements VarDomain {

    @OriginalMember(owner = "client!ji", name = "z", descriptor = "Lclient!uk;")
    public static final VarDomain instance = new CutsceneVarDomain();

    @OriginalMember(owner = "client!as", name = "c", descriptor = "Lclient!av;")
    public static final IterableHashTable cache = new IterableHashTable(32);

    @OriginalMember(owner = "client!gl", name = "a", descriptor = "(II)I")
    @Override
    public int getVarValueInt(@OriginalArg(0) int arg0) {
        @Pc(18) IntNode local18 = (IntNode) cache.get(arg0);
        return local18 == null ? TimedVarDomain.instance.getVarValueInt(arg0) : local18.value;
    }

    @OriginalMember(owner = "client!gl", name = "a", descriptor = "(IB)I")
    @Override
    public int getVarBitValue(@OriginalArg(0) int arg0) {
        @Pc(14) IntNode local14 = (IntNode) cache.get((long) arg0 | 0x100000000L);
        return local14 == null ? TimedVarDomain.instance.getVarBitValue(arg0) : local14.value;
    }
}
