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
    public final int begin;

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

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1110008.6.1">header decode</a>
     */
    @OriginalMember(owner = "client!l", name = "<init>", descriptor = "()V")
    public VorbisResidue() {
        this.type = VorbisSound.gbit(16);
        this.begin = VorbisSound.gbit(24);
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
            if ((cascade[i >> 3] & 0x1 << (i & 0x7)) != 0) {
                this.books[i] = VorbisSound.gbit(8);
            } else {
                this.books[i] = -1;
            }
        }
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#xx1-1120008.6.2">packet decode</a>
     */
    @OriginalMember(owner = "client!l", name = "a", descriptor = "([FIZ)V")
    public void decode(@OriginalArg(0) float[] v, @OriginalArg(1) int arg1, @OriginalArg(2) boolean decode) {
        for (@Pc(1) int i = 0; i < arg1; i++) {
            v[i] = 0.0F;
        }
        if (decode) {
            return;
        }

        @Pc(19) int classwordsPerCodeword = VorbisSound.codebooks[this.classbook].dimensions;
        @Pc(25) int nToRead = this.end - this.begin;
        @Pc(30) int partitionsToRead = nToRead / this.partitionSize;

        @Pc(33) int[] partitions = new int[partitionsToRead];

        for (@Pc(35) int pass = 0; pass < 8; pass++) {
            @Pc(38) int partitionCount = 0;

            while (partitionCount < partitionsToRead) {
                if (pass == 0) {
                    @Pc(47) int temp = VorbisSound.codebooks[this.classbook].decode();

                    for (@Pc(51) int i = classwordsPerCodeword - 1; i >= 0; i--) {
                        if (partitionCount + i < partitionsToRead) {
                            partitions[partitionCount + i] = temp % this.classifications;
                        }

                        temp /= this.classifications;
                    }
                }

                for (@Pc(47) int book = 0; book < classwordsPerCodeword && partitionCount < partitionsToRead; book++) {
                    @Pc(51) int vqClass = partitions[partitionCount];
                    @Pc(90) int vqBook = this.books[(vqClass * 8) + pass];

                    if (vqBook >= 0) {
                        @Pc(100) int off = this.begin + partitionCount * this.partitionSize;
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

                    partitionCount++;
                }
            }
        }
    }
}
