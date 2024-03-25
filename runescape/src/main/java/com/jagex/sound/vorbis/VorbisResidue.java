package com.jagex.sound.vorbis;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!l")
public final class VorbisResidue {

    @OriginalMember(owner = "client!l", name = "f", descriptor = "I")
    public final int type;

    @OriginalMember(owner = "client!l", name = "g", descriptor = "I")
    public final int start;

    @OriginalMember(owner = "client!l", name = "b", descriptor = "I")
    public final int end;

    @OriginalMember(owner = "client!l", name = "a", descriptor = "I")
    public final int partitionSize;

    @OriginalMember(owner = "client!l", name = "e", descriptor = "I")
    public final int classifications;

    @OriginalMember(owner = "client!l", name = "c", descriptor = "I")
    public final int classbook;

    @OriginalMember(owner = "client!l", name = "d", descriptor = "[I")
    public final int[] books;

    @OriginalMember(owner = "client!l", name = "<init>", descriptor = "()V")
    public VorbisResidue() {
        this.type = VorbisSound.gbit(16);
        this.start = VorbisSound.gbit(24);
        this.end = VorbisSound.gbit(24);
        this.partitionSize = VorbisSound.gbit(24) + 1;
        this.classifications = VorbisSound.gbit(6) + 1;
        this.classbook = VorbisSound.gbit(8);

        @Pc(33) int[] cascade = new int[this.classifications];

        for (@Pc(35) int i = 0; i < this.classifications; i++) {
            @Pc(38) int highBits = 0;
            @Pc(41) int lowBits = VorbisSound.gbit(3);
            @Pc(47) boolean bitflag = VorbisSound.g1() != 0;

            if (bitflag) {
                highBits = VorbisSound.gbit(5);
            }

            cascade[i] = highBits << 3 | lowBits;
        }

        this.books = new int[this.classifications * 8];
        for (@Pc(38) int i = 0; i < this.classifications * 8; i++) {
            this.books[i] = (cascade[i >> 3] & 0x1 << (i & 0x7)) == 0 ? -1 : VorbisSound.gbit(8);
        }
    }

    @OriginalMember(owner = "client!l", name = "a", descriptor = "([FIZ)V")
    public void decode(@OriginalArg(0) float[] v, @OriginalArg(1) int arg1, @OriginalArg(2) boolean decode) {
        for (@Pc(1) int i = 0; i < arg1; i++) {
            v[i] = 0.0F;
        }
        if (decode) {
            return;
        }

        @Pc(19) int classbooksPerCodeword = VorbisSound.codebooks[this.classbook].dimensions;
        @Pc(25) int delta = this.end - this.start;
        @Pc(30) int totalCount = delta / this.partitionSize;
        @Pc(33) int[] partitions = new int[totalCount];

        for (@Pc(35) int pass = 0; pass < 8; pass++) {
            @Pc(38) int readCount = 0;

            while (readCount < totalCount) {
                if (pass == 0) {
                    @Pc(47) int temp = VorbisSound.codebooks[this.classbook].decode();

                    for (@Pc(51) int j = classbooksPerCodeword - 1; j >= 0; j--) {
                        if (readCount + j < totalCount) {
                            partitions[readCount + j] = temp % this.classifications;
                        }

                        temp /= this.classifications;
                    }
                }

                for (@Pc(47) int book = 0; book < classbooksPerCodeword; book++) {
                    @Pc(51) int vqClass = partitions[readCount];
                    @Pc(90) int vqBook = this.books[(vqClass * 8) + pass];

                    if (vqBook >= 0) {
                        @Pc(100) int off = this.start + readCount * this.partitionSize;
                        @Pc(104) VorbisCodebook codebook = VorbisSound.codebooks[vqBook];

                        if (this.type == 0) {
                            @Pc(113) int step = this.partitionSize / codebook.dimensions;

                            for (@Pc(115) int i = 0; i < step; i++) {
                                @Pc(119) float[] entryTemp = codebook.decodeValue();

                                for (@Pc(121) int j = 0; j < codebook.dimensions; j++) {
                                    v[off + i + (j * step)] += entryTemp[j];
                                }
                            }
                        } else {
                            @Pc(113) int i = 0;

                            while (i < this.partitionSize) {
                                @Pc(153) float[] entryTemp = codebook.decodeValue();

                                for (@Pc(155) int j = 0; j < codebook.dimensions; j++) {
                                    v[off + i] += entryTemp[j];
                                    i++;
                                }
                            }
                        }
                    }

                    readCount++;

                    if (readCount >= totalCount) {
                        break;
                    }
                }
            }
        }
    }
}
