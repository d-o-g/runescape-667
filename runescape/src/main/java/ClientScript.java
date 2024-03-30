import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.io.Packet;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fj")
public final class ClientScript extends Node2 {

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "([BZ)Lclient!fj;")
    public static ClientScript decode(@OriginalArg(0) byte[] arg0) {
        @Pc(7) ClientScript local7 = new ClientScript();
        @Pc(12) Packet local12 = new Packet(arg0);
        local12.pos = local12.data.length - 2;
        @Pc(23) int local23 = local12.g2();
        @Pc(34) int local34 = local12.data.length - local23 - 2 - 16;
        local12.pos = local34;
        @Pc(50) int local50 = local12.g4();
        local7.intVarCount = local12.g2();
        local7.stringVarCount = local12.g2();
        local7.longVarCount = local12.g2();
        local7.intArgCount = local12.g2();
        local7.stringArgCount = local12.g2();
        local7.longArgCount = local12.g2();
        @Pc(84) int local84 = local12.g1();
        @Pc(95) int local95;
        @Pc(100) int local100;
        if (local84 > 0) {
            local7.switchTables = new IterableHashTable[local84];
            for (local95 = 0; local95 < local84; local95++) {
                local100 = local12.g2();
                @Pc(107) IterableHashTable local107 = new IterableHashTable(IntMath.nextPow2(local100));
                local7.switchTables[local95] = local107;
                while (local100-- > 0) {
                    @Pc(117) int local117 = local12.g4();
                    @Pc(121) int local121 = local12.g4();
                    local107.put(local117, new IntNode(local121));
                }
            }
        }
        local12.pos = 0;
        local7.name = local12.fastgstr();
        local7.opcodes = new int[local50];
        local95 = 0;
        while (local12.pos < local34) {
            local100 = local12.g2();
            if (local100 == 3) {
                if (local7.stringOperands == null) {
                    local7.stringOperands = new String[local50];
                }
                local7.stringOperands[local95] = local12.gjstr().intern();
            } else if (local100 == 54) {
                if (local7.longOperands == null) {
                    local7.longOperands = new long[local50];
                }
                local7.longOperands[local95] = local12.g8();
            } else {
                if (local7.intOperands == null) {
                    local7.intOperands = new int[local50];
                }
                if (local100 >= 150 || local100 == 21 || local100 == 38 || local100 == 39) {
                    local7.intOperands[local95] = local12.g1();
                } else {
                    local7.intOperands[local95] = local12.g4();
                }
            }
            local7.opcodes[local95++] = local100;
        }
        return local7;
    }

    @OriginalMember(owner = "client!fj", name = "w", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!fj", name = "y", descriptor = "I")
    public int intVarCount;

    @OriginalMember(owner = "client!fj", name = "v", descriptor = "[I")
    public int[] opcodes;

    @OriginalMember(owner = "client!fj", name = "J", descriptor = "[J")
    public long[] longOperands;

    @OriginalMember(owner = "client!fj", name = "A", descriptor = "I")
    public int longVarCount;

    @OriginalMember(owner = "client!fj", name = "B", descriptor = "[Lclient!av;")
    public IterableHashTable[] switchTables;

    @OriginalMember(owner = "client!fj", name = "E", descriptor = "[Ljava/lang/String;")
    public String[] stringOperands;

    @OriginalMember(owner = "client!fj", name = "x", descriptor = "Lclient!mia;")
    public ClientTriggerType triggerType;

    @OriginalMember(owner = "client!fj", name = "F", descriptor = "I")
    public int stringVarCount;

    @OriginalMember(owner = "client!fj", name = "K", descriptor = "I")
    public int intArgCount;

    @OriginalMember(owner = "client!fj", name = "G", descriptor = "[I")
    public int[] intOperands;

    @OriginalMember(owner = "client!fj", name = "I", descriptor = "I")
    public int stringArgCount;

    @OriginalMember(owner = "client!fj", name = "D", descriptor = "I")
    public int longArgCount;
}
