package com.jagex.game.runetek6.config.enumtype;

import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.StringNode;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bt")
public final class EnumType {

    @OriginalMember(owner = "client!bt", name = "k", descriptor = "Lclient!av;")
    public IterableHashTable reversed;

    @OriginalMember(owner = "client!bt", name = "m", descriptor = "I")
    public int defaultInt;

    @OriginalMember(owner = "client!bt", name = "i", descriptor = "I")
    public int outputCount;

    @OriginalMember(owner = "client!bt", name = "f", descriptor = "C")
    public char valType;

    @OriginalMember(owner = "client!bt", name = "g", descriptor = "Ljava/lang/Object;")
    public Object output;

    @OriginalMember(owner = "client!bt", name = "r", descriptor = "C")
    public char keyType;

    @OriginalMember(owner = "client!bt", name = "t", descriptor = "Ljava/lang/String;")
    public String defaultStr = "null";

    @OriginalMember(owner = "client!bt", name = "b", descriptor = "(Ljava/lang/String;B)Z")
    public boolean hasOutputString(@OriginalArg(0) String value) {
        if (this.output == null) {
            return false;
        }
        if (this.reversed == null) {
            this.buildOptionsReverse();
        }

        for (@Pc(30) EnumMappingFrequency frequency = (EnumMappingFrequency) this.reversed.get(StringTools.longHash(value)); frequency != null; frequency = (EnumMappingFrequency) this.reversed.nextWithSameKey()) {
            if (frequency.value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(12) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(II)Lclient!nw;")
    public EnumMapping getReversed(@OriginalArg(1) int key) {
        if (this.output == null) {
            return null;
        } else {
            if (this.reversed == null) {
                this.method1236();
            }
            return (EnumMapping) this.reversed.get(key);
        }
    }

    @OriginalMember(owner = "client!bt", name = "b", descriptor = "(I)V")
    public void buildOptionsReverse() {
        if (this.output instanceof IterableHashTable) {
            @Pc(203) IterableHashTable table = (IterableHashTable) this.output;
            this.reversed = new IterableHashTable(table.getBucketCount());
            @Pc(218) IterableHashTable frequencies = new IterableHashTable(table.getBucketCount());

            for (@Pc(223) StringNode node = (StringNode) table.first(); node != null; node = (StringNode) table.next()) {
                @Pc(229) long key = StringTools.longHash(node.value);

                @Pc(235) EnumMappingFrequency frequency;
                for (frequency = (EnumMappingFrequency) frequencies.get(key); frequency != null && !frequency.value.equals(node.value); frequency = (EnumMappingFrequency) frequencies.nextWithSameKey()) {
                }

                if (frequency == null) {
                    frequency = new EnumMappingFrequency(node.value, 0);
                    frequencies.put(key, frequency);
                }

                frequency.frequency++;
            }

            for (@Pc(283) StringNode node = (StringNode) table.first(); node != null; node = (StringNode) table.next()) {
                @Pc(289) long key = StringTools.longHash(node.value);

                @Pc(296) EnumStringMapping mapping;
                for (mapping = (EnumStringMapping) this.reversed.get(key); mapping != null && !mapping.value.equals(node.value); mapping = (EnumStringMapping) this.reversed.nextWithSameKey()) {
                }

                @Pc(58) EnumMappingFrequency frequency;
                for (frequency = (EnumMappingFrequency) frequencies.get(key); frequency != null && !frequency.value.equals(node.value); frequency = (EnumMappingFrequency) frequencies.nextWithSameKey()) {
                }

                @Pc(339) int decrementedFrequency = frequency.frequency--;
                if (mapping == null) {
                    mapping = new EnumStringMapping(node.value, decrementedFrequency);
                    this.reversed.put(key, mapping);
                }

                mapping.index[mapping.index.length - decrementedFrequency] = (int) node.key;
            }
        } else {
            @Pc(21) String[] output = (String[]) this.output;
            @Pc(26) int bucketCount = IntMath.nextPow2(output.length);
            this.reversed = new IterableHashTable(bucketCount);
            @Pc(37) IterableHashTable frequencies = new IterableHashTable(bucketCount);

            for (@Pc(39) int i = 0; i < output.length; i++) {
                if (output[i] == null) {
                    continue;
                }

                @Pc(48) String value = output[i];
                @Pc(52) long key = StringTools.longHash(value);

                @Pc(58) EnumMappingFrequency frequency;
                for (frequency = (EnumMappingFrequency) frequencies.get(key); frequency != null && !frequency.value.equals(value); frequency = (EnumMappingFrequency) frequencies.nextWithSameKey()) {
                }

                if (frequency == null) {
                    frequency = new EnumMappingFrequency(value, 0);
                    frequencies.put(key, frequency);
                }

                frequency.frequency++;
            }

            for (@Pc(103) int i = 0; i < output.length; i++) {
                if (output[i] == null) {
                    continue;
                }

                @Pc(112) String value = output[i];
                @Pc(116) long key = StringTools.longHash(value);

                @Pc(123) EnumStringMapping mapping;
                for (mapping = (EnumStringMapping) this.reversed.get(key); mapping != null; mapping = (EnumStringMapping) this.reversed.nextWithSameKey()) {
                    if (mapping.value.equals(value)) {
                        break;
                    }
                }

                @Pc(143) EnumMappingFrequency frequency;
                for (frequency = (EnumMappingFrequency) frequencies.get(key); frequency != null; frequency = (EnumMappingFrequency) frequencies.nextWithSameKey()) {
                    if (frequency.value.equals(value)) {
                        break;
                    }
                }

                @Pc(164) int decrementedFrequency = frequency.frequency--;
                if (mapping == null) {
                    mapping = new EnumStringMapping(value, decrementedFrequency);
                    this.reversed.put(key, mapping);
                }

                mapping.index[mapping.index.length - decrementedFrequency] = i;
            }
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(IB)I")
    public int getInt(@OriginalArg(0) int key) {
        if (this.output == null) {
            return this.defaultInt;
        } else if (this.output instanceof IterableHashTable) {
            @Pc(30) IntNode node = (IntNode) ((IterableHashTable) this.output).get(key);
            return node != null ? node.value : this.defaultInt;
        } else {
            @Pc(43) Integer[] integers = (Integer[]) this.output;
            if (key >= 0 && key < integers.length) {
                @Pc(66) Integer integer = integers[key];
                return integer != null ? integer : this.defaultInt;
            } else {
                return this.defaultInt;
            }
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(I)I")
    public int getOutputCount() {
        return this.outputCount;
    }

    @OriginalMember(owner = "client!bt", name = "c", descriptor = "(II)Ljava/lang/String;")
    public String getString(@OriginalArg(1) int key) {
        if (this.output == null) {
            return this.defaultStr;
        } else if (this.output instanceof IterableHashTable) {
            @Pc(31) StringNode local31 = (StringNode) ((IterableHashTable) this.output).get(key);
            return local31 == null ? this.defaultStr : local31.value;
        } else {
            @Pc(44) String[] strings = (String[]) this.output;
            if (key >= 0 && key < strings.length) {
                @Pc(64) String string = strings[key];
                return string != null ? string : this.defaultStr;
            } else {
                return this.defaultStr;
            }
        }
    }

    @OriginalMember(owner = "client!bt", name = "b", descriptor = "(II)Z")
    public boolean hasOutput(@OriginalArg(1) int key) {
        if (this.output == null) {
            return false;
        } else {
            if (this.reversed == null) {
                this.method1236();
            }
            return this.reversed.get(key) != null;
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(IILclient!ge;)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(2) Packet packet) {
        if (code == 1) {
            this.keyType = Cp1252.decode(packet.g1b());
        } else if (code == 2) {
            this.valType = Cp1252.decode(packet.g1b());
        } else if (code == 3) {
            this.defaultStr = packet.gjstr();
        } else if (code == 4) {
            this.defaultInt = packet.g4();
        } else if (code == 5 || code == 6) {
            this.outputCount = packet.g2();

            @Pc(62) IterableHashTable output = new IterableHashTable(IntMath.nextPow2(this.outputCount));
            for (@Pc(64) int i = 0; i < this.outputCount; i++) {
                @Pc(69) int key = packet.g4();

                @Pc(79) Node value;
                if (code == 5) {
                    value = new StringNode(packet.gjstr());
                } else {
                    value = new IntNode(packet.g4());
                }

                output.put(key, value);
            }

            this.output = output;
        } else if (code == 7) {
            @Pc(114) int count = packet.g2();
            this.outputCount = packet.g2();

            @Pc(124) String[] output = new String[count];
            for (@Pc(69) int i = 0; i < this.outputCount; i++) {
                @Pc(131) int index = packet.g2();
                output[index] = packet.gjstr();
            }

            this.output = output;
        } else if (code == 8) {
            @Pc(114) int count = packet.g2();
            this.outputCount = packet.g2();

            @Pc(164) Integer[] output = new Integer[count];
            for (@Pc(69) int i = 0; i < this.outputCount; i++) {
                @Pc(131) int index = packet.g2();
                output[index] = Integer.valueOf(packet.g4());
            }

            this.output = output;
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(Z)V")
    public void method1236() {
        if (this.output instanceof IterableHashTable) {
            @Pc(16) IterableHashTable output = (IterableHashTable) this.output;
            this.reversed = new IterableHashTable(output.getBucketCount());
            @Pc(31) IterableHashTable local31 = new IterableHashTable(output.getBucketCount());

            for (@Pc(36) IntNode node = (IntNode) output.first(); node != null; node = (IntNode) output.next()) {
                @Pc(45) IntNode local45 = (IntNode) local31.get(node.value);
                if (local45 == null) {
                    local45 = new IntNode(0);
                    local31.put(node.value, local45);
                }

                local45.value++;
            }

            for ( @Pc(45) IntNode node = (IntNode) output.first(); node != null; node = (IntNode) output.next()) {
                @Pc(87) EnumMapping mapping = (EnumMapping) this.reversed.get(node.value);
                @Pc(101) int length = ((IntNode) local31.get(node.value)).value--;

                if (mapping == null) {
                    mapping = new EnumMapping(length);
                    this.reversed.put(node.value, mapping);
                }

                mapping.index[mapping.index.length - length] = (int) node.key;
            }
        } else {
            @Pc(140) Integer[] output = (Integer[]) this.output;
            @Pc(145) int bucketCount = IntMath.nextPow2(output.length);
            this.reversed = new IterableHashTable(bucketCount);
            @Pc(156) IterableHashTable local156 = new IterableHashTable(bucketCount);

            for (@Pc(158) int i = 0; i < output.length; i++) {
                if (output[i] != null) {
                    @Pc(168) int local168 = output[i];
                    @Pc(175) IntNode local175 = (IntNode) local156.get(local168);
                    if (local175 == null) {
                        local175 = new IntNode(0);
                        local156.put(local168, local175);
                    }

                    local175.value++;
                }
            }

            for (@Pc(168) int i = 0; i < output.length; i++) {
                if (output[i] != null) {
                    @Pc(101) int local101 = output[i];
                    @Pc(223) EnumMapping mapping = (EnumMapping) this.reversed.get(local101);
                    @Pc(236) int length = ((IntNode) local156.get(local101)).value--;
                    if (mapping == null) {
                        mapping = new EnumMapping(length);
                        this.reversed.put(local101, mapping);
                    }

                    mapping.index[mapping.index.length - length] = i;
                }
            }
        }
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(Ljava/lang/String;B)Lclient!hu;")
    public EnumStringMapping getReversed(@OriginalArg(0) String value) {
        if (this.output == null) {
            return null;
        }
        if (this.reversed == null) {
            this.buildOptionsReverse();
        }
        @Pc(26) EnumStringMapping mapping;
        for (mapping = (EnumStringMapping) this.reversed.get(StringTools.longHash(value)); mapping != null && !mapping.value.equals(value); mapping = (EnumStringMapping) this.reversed.nextWithSameKey()) {
        }
        return mapping;
    }
}
