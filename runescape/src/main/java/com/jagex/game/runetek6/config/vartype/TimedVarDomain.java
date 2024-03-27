package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.LongNode;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qga")
public final class TimedVarDomain implements VarDomain {

    @OriginalMember(owner = "client!bca", name = "e", descriptor = "Lclient!qga;")
    public static TimedVarDomain instance;

    @OriginalMember(owner = "client!qga", name = "b", descriptor = "Lclient!av;")
    public IterableHashTable updates = new IterableHashTable(128);

    @OriginalMember(owner = "client!qga", name = "k", descriptor = "[I")
    public final int[] updatedVarValues = new int[VarPlayerTypeListClient.instance.num];

    @OriginalMember(owner = "client!qga", name = "j", descriptor = "[I")
    public final int[] varValues = new int[VarPlayerTypeListClient.instance.num];

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(III)V")
    public void setVarValueInt(@OriginalArg(1) int id, @OriginalArg(2) int value) {
        // g.trace("Setting varp from client: {}", (Object)Integer.valueOf(var1.id));
        this.varValues[id] = value;

        @Pc(24) LongNode node = (LongNode) this.updates.get(id);
        if (node == null) {
            node = new LongNode(SystemTimer.safetime() + 500L);
            this.updates.put(id, node);
        } else {
            node.value = SystemTimer.safetime() + 500L;
        }
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(IB)I")
    @Override
    public int getVarBitValue(@OriginalArg(0) int id) {
        @Pc(8) VarBitType type = VarBitTypeListClient.instance.list(id);
        @Pc(11) int baseVar = type.baseVar;
        @Pc(22) int startBit = type.startBit;
        @Pc(25) int endBit = type.endBit;
        @Pc(32) int mask = VarBitType.masklookup[endBit - startBit];
        return (this.varValues[baseVar] >> startBit) & mask;
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(B)V")
    public void reset() {
        for (@Pc(5) int i = 0; i < VarPlayerTypeListClient.instance.num; i++) {
            @Pc(11) VarPlayerType type = VarPlayerTypeListClient.instance.list(i);
            if (type != null && type.clientCode == 0) {
                this.varValues[i] = 0;
                this.updatedVarValues[i] = 0;
            }
        }

        this.updates = new IterableHashTable(128);
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(BII)V")
    public void setVarBitValue(@OriginalArg(1) int value, @OriginalArg(2) int id) {
        // g.trace("Setting varbit from client: {}", (Object)Integer.valueOf(var1.id));
        @Pc(13) VarBitType type = VarBitTypeListClient.instance.list(id);
        @Pc(16) int baseVar = type.baseVar;
        @Pc(19) int startBit = type.startBit;
        @Pc(22) int endBit = type.endBit;
        @Pc(29) int mask = VarBitType.masklookup[endBit - startBit];
        if (value < 0 || mask < value) {
            value = 0;
        }
        mask <<= startBit;
        this.setVarValueInt(baseVar, (~mask & this.varValues[baseVar]) | (mask & (value << startBit)));
    }

    @OriginalMember(owner = "client!qga", name = "b", descriptor = "(III)V")
    public void updateVarBitValue(@OriginalArg(1) int id, @OriginalArg(0) int value) {
        // g.trace("Incoming varbit from server: {}", (Object)Integer.valueOf(var1.id));
        @Pc(8) VarBitType type = VarBitTypeListClient.instance.list(id);
        @Pc(11) int baseVar = type.baseVar;
        @Pc(14) int startBit = type.startBit;
        @Pc(17) int endBit = type.endBit;
        @Pc(31) int mask = VarBitType.masklookup[endBit - startBit];
        if (value < 0 || value > mask) {
            value = 0;
        }
        mask <<= startBit;
        this.updateVarp(baseVar, value << startBit & mask | this.updatedVarValues[baseVar] & ~mask);
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(II)I")
    @Override
    public int getVarValueInt(@OriginalArg(0) int id) {
        return this.varValues[id];
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(IZ)I")
    public int removeNext(@OriginalArg(1) boolean first) {
        @Pc(8) long time = SystemTimer.safetime();

        for (@Pc(23) LongNode node = first ? (LongNode) this.updates.first() : (LongNode) this.updates.next(); node != null; node = (LongNode) this.updates.next()) {
            if ((node.value & 0x3FFFFFFFFFFFFFFFL) < time) {
                if ((node.value & 0x4000000000000000L) != 0L) {
                    // g.trace("Copying server variable {}", (Object)Long.valueOf(var5.bq));
                    @Pc(55) int key = (int) node.key;
                    this.varValues[key] = this.updatedVarValues[key];
                    node.unlink();
                    return key;
                }

                node.unlink();
            }
        }

        return -1;
    }

    @OriginalMember(owner = "client!qga", name = "b", descriptor = "(BII)V")
    public void updateVarp(@OriginalArg(1) int id, @OriginalArg(2) int value) {
        // g.trace("Incoming varp from server: {}", (Object)Integer.valueOf(var1.id));
        this.updatedVarValues[id] = value;

        @Pc(24) LongNode node = (LongNode) this.updates.get(id);
        if (node != null) {
            if (node.value != 0x4000000000000001L) {
                node.value = SystemTimer.safetime() + 500L | 0x4000000000000000L;
            }
        } else {
            node = new LongNode(0x4000000000000001L);
            this.updates.put(id, node);
        }
    }
}
