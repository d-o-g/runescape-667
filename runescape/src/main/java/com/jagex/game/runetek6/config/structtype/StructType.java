package com.jagex.game.runetek6.config.structtype;

import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.StringNode;
import com.jagex.core.io.Packet;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ab")
public final class StructType extends Node2 {

    @OriginalMember(owner = "client!ab", name = "A", descriptor = "Lclient!av;")
    public IterableHashTable params;

    @OriginalMember(owner = "client!ab", name = "a", descriptor = "(ILclient!ge;I)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(1) Packet packet) {
        if (code == 249) {
            @Pc(6) int count = packet.g1();

            if (this.params == null) {
                @Pc(13) int bucketCount = IntMath.nextPow2(count);
                this.params = new IterableHashTable(bucketCount);
            }

            for (@Pc(13) int i = 0; i < count; i++) {
                @Pc(32) boolean string = packet.g1() == 1;
                @Pc(36) int id = packet.g3();

                @Pc(45) Node param;
                if (string) {
                    param = new StringNode(packet.gjstr());
                } else {
                    param = new IntNode(packet.g4());
                }

                this.params.put(id, param);
            }
        }
    }

    @OriginalMember(owner = "client!ab", name = "a", descriptor = "(III)I")
    public int param(@OriginalArg(0) int dflt, @OriginalArg(2) int id) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(17) IntNode param = (IntNode) this.params.get(id);
            return param != null ? param.value : dflt;
        }
    }

    @OriginalMember(owner = "client!ab", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(7) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }

    @OriginalMember(owner = "client!ab", name = "a", descriptor = "(ILjava/lang/String;I)Ljava/lang/String;")
    public String param(@OriginalArg(0) int id, @OriginalArg(1) String dflt) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(23) StringNode param = (StringNode) this.params.get(id);
            return param != null ? param.value : dflt;
        }
    }
}
