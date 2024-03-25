package com.jagex.sound.vorbis;

import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!oca")
public final class VorbisCodebook {

    @OriginalMember(owner = "client!oca", name = "a", descriptor = "(II)I")
    public static int valuesLookup1(@OriginalArg(0) int entries, @OriginalArg(1) int dimensions) {
        @Pc(10) int values;
        for (values = (int) Math.pow(entries, 1.0D / (double) dimensions) + 1; IntMath.ipow(dimensions, values) > entries; values--) {
        }
        return values;
    }

    @OriginalMember(owner = "client!oca", name = "b", descriptor = "[I")
    public int[] tree;

    @OriginalMember(owner = "client!oca", name = "e", descriptor = "I")
    public final int dimensions;

    @OriginalMember(owner = "client!oca", name = "a", descriptor = "I")
    public final int entries;

    @OriginalMember(owner = "client!oca", name = "d", descriptor = "[I")
    public final int[] codewordLengths;

    @OriginalMember(owner = "client!oca", name = "f", descriptor = "[I")
    public int[] multiplicands;

    @OriginalMember(owner = "client!oca", name = "c", descriptor = "[[F")
    public float[][] valueVector;

    @OriginalMember(owner = "client!oca", name = "<init>", descriptor = "()V")
    public VorbisCodebook() {
        VorbisSound.gbit(24); // sync pattern
        this.dimensions = VorbisSound.gbit(16);
        this.entries = VorbisSound.gbit(24);
        this.codewordLengths = new int[this.entries];

        @Pc(23) boolean ordered = VorbisSound.g1() != 0;
        if (ordered) {
            @Pc(27) int currentEntry = 0;
            @Pc(32) int currentCount = VorbisSound.gbit(5) + 1;

            while (currentEntry < this.entries) {
                @Pc(41) int count = VorbisSound.gbit(IntMath.countBits(this.entries - currentEntry));

                for (@Pc(43) int i = 0; i < count; i++) {
                    this.codewordLengths[currentEntry++] = currentCount;
                }

                currentCount++;
            }
        } else {
            @Pc(66) boolean sparse = VorbisSound.g1() != 0;

            for (@Pc(32) int i = 0; i < this.entries; i++) {
                if (sparse && VorbisSound.g1() == 0) {
                    this.codewordLengths[i] = 0;
                } else {
                    this.codewordLengths[i] = VorbisSound.gbit(5) + 1;
                }
            }
        }

        this.buildTree();

        @Pc(27) int lookupType = VorbisSound.gbit(4);
        if (lookupType > 0) {
            @Pc(103) float minimumValue = VorbisSound.unpackFloat32(VorbisSound.gbit(32));
            @Pc(107) float deltaValue = VorbisSound.unpackFloat32(VorbisSound.gbit(32));
            @Pc(43) int valueBits = VorbisSound.gbit(4) + 1;
            @Pc(118) boolean sequenceP = VorbisSound.g1() != 0;

            @Pc(127) int values;
            if (lookupType == 1) {
                values = valuesLookup1(this.entries, this.dimensions);
            } else {
                values = this.entries * this.dimensions;
            }

            this.multiplicands = new int[values];
            for (@Pc(140) int i = 0; i < values; i++) {
                this.multiplicands[i] = VorbisSound.gbit(valueBits);
            }

            this.valueVector = new float[this.entries][this.dimensions];

            if (lookupType == 1) {
                for (@Pc(163) int i = 0; i < this.entries; i++) {
                    @Pc(166) float last = 0.0F;
                    @Pc(168) int indexDivisor = 1;
                    for (@Pc(170) int j = 0; j < this.dimensions; j++) {
                        @Pc(177) int multiplicandOffset = (i / indexDivisor) % values;
                        @Pc(189) float value = (float) this.multiplicands[multiplicandOffset] * deltaValue + minimumValue + last;

                        this.valueVector[i][j] = value;

                        if (sequenceP) {
                            last = value;
                        }

                        indexDivisor *= values;
                    }
                }
            } else {
                for (@Pc(163) int i = 0; i < this.entries; i++) {
                    @Pc(166) float last = 0.0F;
                    @Pc(168) int indexDivisor = i * this.dimensions;

                    for (@Pc(170) int j = 0; j < this.dimensions; j++) {
                        @Pc(240) float value = ((float) this.multiplicands[indexDivisor] * deltaValue) + minimumValue + last;

                        this.valueVector[i][j] = value;

                        if (sequenceP) {
                            last = value;
                        }

                        indexDivisor++;
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!oca", name = "b", descriptor = "()V")
    public void buildTree() {
        @Pc(3) int[] codes = new int[this.entries];
        @Pc(6) int[] nextCodes = new int[33];

        for (@Pc(8) int i = 0; i < this.entries; i++) {
            @Pc(14) int codeCount = this.codewordLengths[i];
            if (codeCount == 0) {
                continue;
            }

            @Pc(22) int lengthBit = 0x1 << (32 - codeCount);
            @Pc(26) int currentCode = nextCodes[codeCount];

            codes[i] = currentCode;

            @Pc(40) int nextCode;
            if ((currentCode & lengthBit) != 0) {
                nextCode = nextCodes[codeCount - 1];
            } else {
                nextCode = currentCode | lengthBit;

                for (@Pc(49) int j = codeCount - 1; j >= 1; j--) {
                    @Pc(54) int code = nextCodes[j];
                    if (code != currentCode) {
                        break;
                    }

                    @Pc(63) int bit = 0x1 << (32 - j);
                    if ((code & bit) != 0) {
                        nextCodes[j] = nextCodes[j - 1];
                        break;
                    }

                    nextCodes[j] = code | bit;
                }
            }

            nextCodes[codeCount] = nextCode;

            for (@Pc(49) int j = codeCount + 1; j <= 32; j++) {
                @Pc(54) int code = nextCodes[j];

                if (code == currentCode) {
                    nextCodes[j] = nextCode;
                }
            }
        }

        this.tree = new int[8];

        @Pc(14) int treeSize = 0;
        for (@Pc(22) int i = 0; i < this.entries; i++) {
            @Pc(26) int codeCount = this.codewordLengths[i];
            if (codeCount == 0) {
                continue;
            }

            @Pc(40) int code = codes[i];
            @Pc(49) int treePos = 0;
            for (@Pc(54) int j = 0; j < codeCount; j++) {
                @Pc(63) int bit = Integer.MIN_VALUE >>> j;

                if ((code & bit) == 0) {
                    treePos++;
                } else {
                    if (this.tree[treePos] == 0) {
                        this.tree[treePos] = treeSize;
                    }

                    treePos = this.tree[treePos];
                }

                if (treePos >= this.tree.length) {
                    @Pc(178) int[] newTree = new int[this.tree.length * 2];
                    for (@Pc(180) int k = 0; k < this.tree.length; k++) {
                        newTree[k] = this.tree[k];
                    }
                    this.tree = newTree;
                }

                bit >>>= 1;
            }

            this.tree[treePos] = ~i;

            if (treePos >= treeSize) {
                treeSize = treePos + 1;
            }
        }
    }

    @OriginalMember(owner = "client!oca", name = "a", descriptor = "()I")
    public int decode() {
        @Pc(1) int i;
        for (i = 0; this.tree[i] >= 0; i = VorbisSound.g1() == 0 ? i + 1 : this.tree[i]) {
        }
        return ~this.tree[i];
    }

    @OriginalMember(owner = "client!oca", name = "c", descriptor = "()[F")
    public float[] decodeValue() {
        return this.valueVector[this.decode()];
    }
}
