package com.jagex.sound.vorbis;

import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bk")
public final class VorbisFloor {

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-12700010.1">floor1_inverse_dB_table</a>
     */
    @OriginalMember(owner = "client!bk", name = "c", descriptor = "[F")
    private static final float[] INVERSE_DECIBEL_TABLE = {
        // @formatter:off
        1.0649863E-7F,  1.1341951E-7F,  1.2079015E-7F,  1.2863978E-7F,
        1.369995E-7F,   1.459025E-7F,   1.5538409E-7F,  1.6548181E-7F,
        1.7623574E-7F,  1.8768856E-7F,  1.998856E-7F,   2.128753E-7F,
        2.2670913E-7F,  2.4144197E-7F,  2.5713223E-7F,  2.7384212E-7F,
        2.9163792E-7F,  3.1059022E-7F,  3.307741E-7F,   3.5226967E-7F,
        3.7516213E-7F,  3.995423E-7F,   4.255068E-7F,   4.5315863E-7F,
        4.8260745E-7F,  5.1397E-7F,     5.4737063E-7F,  5.829419E-7F,
        6.208247E-7F,   6.611694E-7F,   7.041359E-7F,   7.4989464E-7F,
        7.98627E-7F,    8.505263E-7F,   9.057983E-7F,   9.646621E-7F,
        1.0273513E-6F,  1.0941144E-6F,  1.1652161E-6F,  1.2409384E-6F,
        1.3215816E-6F,  1.4074654E-6F,  1.4989305E-6F,  1.5963394E-6F,
        1.7000785E-6F,  1.8105592E-6F,  1.9282195E-6F,  2.053526E-6F,
        2.1869757E-6F,  2.3290977E-6F,  2.4804558E-6F,  2.6416496E-6F,
        2.813319E-6F,   2.9961443E-6F,  3.1908505E-6F,  3.39821E-6F,
        3.619045E-6F,   3.8542307E-6F,  4.1047006E-6F,  4.371447E-6F,
        4.6555283E-6F,  4.958071E-6F,   5.280274E-6F,   5.623416E-6F,
        5.988857E-6F,   6.3780467E-6F,  6.7925284E-6F,  7.2339453E-6F,
        7.704048E-6F,   8.2047E-6F,     8.737888E-6F,   9.305725E-6F,
        9.910464E-6F,   1.0554501E-5F,  1.1240392E-5F,  1.1970856E-5F,
        1.2748789E-5F,  1.3577278E-5F,  1.4459606E-5F,  1.5399271E-5F,
        1.6400005E-5F,  1.7465769E-5F,  1.8600793E-5F,  1.9809577E-5F,
        2.1096914E-5F,  2.2467912E-5F,  2.3928002E-5F,  2.5482977E-5F,
        2.7139005E-5F,  2.890265E-5F,   3.078091E-5F,   3.2781227E-5F,
        3.4911533E-5F,  3.718028E-5F,   3.9596467E-5F,  4.2169668E-5F,
        4.491009E-5F,   4.7828602E-5F,  5.0936775E-5F,  5.424693E-5F,
        5.7772202E-5F,  6.152657E-5F,   6.552491E-5F,   6.9783084E-5F,
        7.4317984E-5F,  7.914758E-5F,   8.429104E-5F,   8.976875E-5F,
        9.560242E-5F,   1.0181521E-4F,  1.0843174E-4F,  1.1547824E-4F,
        1.2298267E-4F,  1.3097477E-4F,  1.3948625E-4F,  1.4855085E-4F,
        1.5820454E-4F,  1.6848555E-4F,  1.7943469E-4F,  1.9109536E-4F,
        2.0351382E-4F,  2.167393E-4F,   2.3082423E-4F,  2.4582449E-4F,
        2.6179955E-4F,  2.7881275E-4F,  2.9693157E-4F,  3.1622787E-4F,
        3.3677815E-4F,  3.5866388E-4F,  3.8197188E-4F,  4.0679457E-4F,
        4.3323037E-4F,  4.613841E-4F,   4.913675E-4F,   5.2329927E-4F,
        5.573062E-4F,   5.935231E-4F,   6.320936E-4F,   6.731706E-4F,
        7.16917E-4F,    7.635063E-4F,   8.1312325E-4F,  8.6596457E-4F,
        9.2223985E-4F,  9.821722E-4F,   0.0010459992F,  0.0011139743F,
        0.0011863665F,  0.0012634633F,  0.0013455702F,  0.0014330129F,
        0.0015261382F,  0.0016253153F,  0.0017309374F,  0.0018434235F,
        0.0019632196F,  0.0020908006F,  0.0022266726F,  0.0023713743F,
        0.0025254795F,  0.0026895993F,  0.0028643848F,  0.0030505287F,
        0.003248769F,   0.0034598925F,  0.0036847359F,  0.0039241905F,
        0.0041792067F,  0.004450795F,   0.004740033F,   0.005048067F,
        0.0053761187F,  0.005725489F,   0.0060975635F,  0.0064938175F,
        0.0069158226F,  0.0073652514F,  0.007843887F,   0.008353627F,
        0.008896492F,   0.009474637F,   0.010090352F,   0.01074608F,
        0.011444421F,   0.012188144F,   0.012980198F,   0.013823725F,
        0.014722068F,   0.015678791F,   0.016697686F,   0.017782796F,
        0.018938422F,   0.020169148F,   0.021479854F,   0.022875736F,
        0.02436233F,    0.025945531F,   0.027631618F,   0.029427277F,
        0.031339627F,   0.03337625F,    0.035545226F,   0.037855156F,
        0.0403152F,     0.042935107F,   0.045725275F,   0.048696756F,
        0.05186135F,    0.05523159F,    0.05882085F,    0.062643364F,
        0.06671428F,    0.07104975F,    0.075666964F,   0.08058423F,
        0.08582105F,    0.09139818F,    0.097337745F,   0.1036633F,
        0.11039993F,    0.11757434F,    0.12521498F,    0.13335215F,
        0.14201812F,    0.15124726F,    0.16107617F,    0.1715438F,
        0.18269168F,    0.19456401F,    0.20720787F,    0.22067343F,
        0.23501402F,    0.25028655F,    0.26655158F,    0.28387362F,
        0.3023213F,     0.32196787F,    0.34289113F,    0.36517414F,
        0.3889052F,     0.41417846F,    0.44109413F,    0.4697589F,
        0.50028646F,    0.53279793F,    0.5674221F,     0.6042964F,
        0.64356697F,    0.6853896F,     0.72993004F,    0.777365F,
        0.8278826F,     0.88168305F,    0.9389798F,     1.0F
        // @formatter:on
    };

    @OriginalMember(owner = "client!bk", name = "k", descriptor = "[I")
    private static final int[] RANGES = {256, 128, 86, 64};

    @OriginalMember(owner = "client!bk", name = "h", descriptor = "[Z")
    private static boolean[] STEP2_FLAG;

    @OriginalMember(owner = "client!bk", name = "g", descriptor = "[I")
    private static int[] X_LIST;

    @OriginalMember(owner = "client!bk", name = "a", descriptor = "[I")
    private static int[] Y;

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1220009.2.4">low_neighbor</a>
     */
    @OriginalMember(owner = "client!bk", name = "b", descriptor = "([II)I")
    private static int lowNeighbour(@OriginalArg(0) int[] v, @OriginalArg(1) int x) {
        @Pc(3) int vx = v[x];
        @Pc(5) int low = -1;
        @Pc(7) int value = Integer.MIN_VALUE;

        for (@Pc(9) int i = 0; i < x; i++) {
            @Pc(14) int vi = v[i];

            if (vi < vx && vi > value) {
                low = i;
                value = vi;
            }
        }

        return low;
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1230009.2.5">high_neighbor</a>
     */
    @OriginalMember(owner = "client!bk", name = "a", descriptor = "([II)I")
    private static int highNeighbour(@OriginalArg(0) int[] v, @OriginalArg(1) int x) {
        @Pc(3) int vx = v[x];
        @Pc(5) int high = -1;
        @Pc(7) int value = Integer.MAX_VALUE;

        for (@Pc(9) int i = 0; i < x; i++) {
            @Pc(14) int vi = v[i];

            if (vi > vx && vi < value) {
                high = i;
                value = vi;
            }
        }

        return high;
    }

    @OriginalMember(owner = "client!bk", name = "b", descriptor = "[I")
    public final int[] partitionClasses;

    @OriginalMember(owner = "client!bk", name = "e", descriptor = "[I")
    public final int[] classDimensions;

    @OriginalMember(owner = "client!bk", name = "j", descriptor = "[I")
    public final int[] classSubclasses;

    @OriginalMember(owner = "client!bk", name = "i", descriptor = "[I")
    public final int[] classMasterbooks;

    @OriginalMember(owner = "client!bk", name = "d", descriptor = "[[I")
    public final int[][] subclassBooks;

    @OriginalMember(owner = "client!bk", name = "f", descriptor = "I")
    public final int multiplier;

    @OriginalMember(owner = "client!bk", name = "l", descriptor = "[I")
    public final int[] xList;

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1010007.2.2">header decode</a>
     */
    @OriginalMember(owner = "client!bk", name = "<init>", descriptor = "()V")
    public VorbisFloor() {
        @Pc(4) int type = VorbisSound.gbit(16);
        if (type != 1) {
            throw new RuntimeException();
        }

        @Pc(15) int partitionCount = VorbisSound.gbit(5);
        @Pc(17) int maxClass = 0;

        this.partitionClasses = new int[partitionCount];

        for (@Pc(23) int i = 0; i < partitionCount; i++) {
            @Pc(27) int partitionClass = VorbisSound.gbit(4);

            this.partitionClasses[i] = partitionClass;

            if (partitionClass >= maxClass) {
                maxClass = partitionClass + 1;
            }
        }

        this.classDimensions = new int[maxClass];
        this.classSubclasses = new int[maxClass];
        this.classMasterbooks = new int[maxClass];
        this.subclassBooks = new int[maxClass][];

        for (@Pc(27) int i = 0; i < maxClass; i++) {
            this.classDimensions[i] = VorbisSound.gbit(3) + 1;

            @Pc(78) int subclasses = this.classSubclasses[i] = VorbisSound.gbit(2);
            if (subclasses != 0) {
                this.classMasterbooks[i] = VorbisSound.gbit(8);
            }

            subclasses = 0x1 << subclasses;

            @Pc(95) int[] books = new int[subclasses];
            this.subclassBooks[i] = books;

            for (@Pc(102) int j = 0; j < subclasses; j++) {
                books[j] = VorbisSound.gbit(8) - 1;
            }
        }

        this.multiplier = VorbisSound.gbit(2) + 1;

        @Pc(78) int rangebits = VorbisSound.gbit(4);

        @Pc(131) int values = 2;
        for (@Pc(102) int i = 0; i < partitionCount; i++) {
            values += this.classDimensions[this.partitionClasses[i]];
        }

        this.xList = new int[values];
        this.xList[0] = 0;
        this.xList[1] = 0x1 << rangebits;

        values = 2;

        for (@Pc(168) int i = 0; i < partitionCount; i++) {
            @Pc(174) int partitionClass = this.partitionClasses[i];

            for (@Pc(176) int j = 0; j < this.classDimensions[partitionClass]; j++) {
                this.xList[values++] = VorbisSound.gbit(rangebits);
            }
        }

        if (X_LIST == null || X_LIST.length < values) {
            X_LIST = new int[values];
            Y = new int[values];
            STEP2_FLAG = new boolean[values];
        }
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1030007.2.4">curve computation</a>
     **/
    @OriginalMember(owner = "client!bk", name = "a", descriptor = "([FI)V")
    public void computeCurve(@OriginalArg(0) float[] v, @OriginalArg(1) int n) {

        /* step 1: amplitude value synthesis */

        @Pc(3) int values = this.xList.length;
        @Pc(10) int range = RANGES[this.multiplier - 1];

        STEP2_FLAG[0] = STEP2_FLAG[1] = true;

        for (@Pc(20) int i = 2; i < values; i++) {
            @Pc(25) int lowNeighbourOff = lowNeighbour(X_LIST, i);
            @Pc(29) int highNeighbourOff = highNeighbour(X_LIST, i);

            @Pc(47) int predicted = this.renderPoint(X_LIST[lowNeighbourOff], Y[lowNeighbourOff], X_LIST[highNeighbourOff], Y[highNeighbourOff], X_LIST[i]);
            @Pc(51) int val = Y[i];

            @Pc(55) int highroom = range - predicted;
            int lowroom = predicted;

            @Pc(67) int room;
            if (highroom < lowroom) {
                room = highroom << 1;
            } else {
                room = lowroom << 1;
            }

            if (val != 0) {
                STEP2_FLAG[lowNeighbourOff] = STEP2_FLAG[highNeighbourOff] = true;
                STEP2_FLAG[i] = true;

                if (val >= room) {
                    if (highroom > lowroom) {
                        Y[i] = val - lowroom + predicted;
                    } else {
                        Y[i] = predicted - val + highroom - 1;
                    }
                } else {
                    int even = val & 0x1;

                    if (even != 0) {
                        Y[i] = predicted - (val + 1) / 2;
                    } else {
                        Y[i] = predicted + val / 2;
                    }
                }
            } else {
                STEP2_FLAG[i] = false;
                Y[i] = predicted;
            }
        }

        this.quicksort(0, values - 1);

        /* step 2: curve synthesis */

        @Pc(25) int lx = 0;
        @Pc(29) int ly = Y[0] * this.multiplier;
        for (@Pc(47) int i = 1; i < values; i++) {
            if (STEP2_FLAG[i]) {
                @Pc(51) int hx = X_LIST[i];
                @Pc(55) int hy = Y[i] * this.multiplier;

                this.renderLine(lx, ly, hx, hy, v, n);

                if (hx >= n) {
                    return;
                }

                lx = hx;
                ly = hy;
            }
        }

        @Pc(201) float scale = INVERSE_DECIBEL_TABLE[ly];
        for (@Pc(55) int i = lx; i < n; i++) {
            v[i] *= scale;
        }
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1240009.2.6">render_point</a>
     */
    @OriginalMember(owner = "client!bk", name = "a", descriptor = "(IIIII)I")
    private int renderPoint(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2, @OriginalArg(4) int x) {
        @Pc(3) int deltaY = y2 - y1;
        @Pc(7) int deltaX = x2 - x1;
        @Pc(15) int absDeltaY = deltaY < 0 ? -deltaY : deltaY;
        @Pc(21) int err = absDeltaY * (x - x1);
        @Pc(25) int off = err / deltaX;
        return deltaY < 0 ? y1 - off : y1 + off;
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1020007.2.3">packet decode</a>
     */
    @OriginalMember(owner = "client!bk", name = "b", descriptor = "()Z")
    public boolean decode() {
        @Pc(6) boolean nonzero = VorbisSound.g1() != 0;
        if (!nonzero) {
            return false;
        }

        @Pc(15) int values = this.xList.length;
        for (@Pc(17) int i = 0; i < values; i++) {
            X_LIST[i] = this.xList[i];
        }

        @Pc(36) int range = RANGES[this.multiplier - 1];
        @Pc(42) int rangeBits = IntMath.countBits(range - 1);

        Y[0] = VorbisSound.gbit(rangeBits);
        Y[1] = VorbisSound.gbit(rangeBits);

        @Pc(54) int off = 2;
        for (@Pc(56) int i = 0; i < this.partitionClasses.length; i++) {
            @Pc(62) int partitionClass = this.partitionClasses[i];
            @Pc(67) int partitionDimensions = this.classDimensions[partitionClass];
            @Pc(72) int partitionSubclass = this.classSubclasses[partitionClass];
            @Pc(78) int mask = (0x1 << partitionSubclass) - 1;

            @Pc(80) int codebook = 0;
            if (partitionSubclass > 0) {
                codebook = VorbisSound.codebooks[this.classMasterbooks[partitionClass]].decode();
            }

            for (@Pc(92) int j = 0; j < partitionDimensions; j++) {
                @Pc(102) int book = this.subclassBooks[partitionClass][codebook & mask];
                codebook >>>= partitionSubclass;
                Y[off++] = book >= 0 ? VorbisSound.codebooks[book].decode() : 0;
            }
        }

        return true;
    }

    /**
     * @see <a href="https://xiph.org/vorbis/doc/Vorbis_I_spec.html#x1-1250009.2.7">render_line</a>
     */
    @OriginalMember(owner = "client!bk", name = "a", descriptor = "(IIII[FI)V")
    private void renderLine(@OriginalArg(0) int x0, @OriginalArg(1) int y0, @OriginalArg(2) int x1, @OriginalArg(3) int y1, @OriginalArg(4) float[] v, @OriginalArg(5) int n) {
        @Pc(3) int dy = y1 - y0;
        @Pc(7) int adx = x1 - x0;
        @Pc(15) int ady = dy < 0 ? -dy : dy;
        @Pc(19) int base = dy / adx;
        @Pc(21) int y = y0;
        @Pc(23) int err = 0;

        @Pc(34) int sy;
        if (dy < 0) {
            sy = base - 1;
        } else {
            sy = base + 1;
        }

        @Pc(46) int ady2 = ady - (base < 0 ? -base : base) * adx;

        v[x0] *= INVERSE_DECIBEL_TABLE[y0];

        if (x1 > n) {
            x1 = n;
        }

        for (@Pc(64) int x = x0 + 1; x < x1; x++) {
            err += ady2;

            if (err >= adx) {
                err -= adx;
                y += sy;
            } else {
                y += base;
            }

            v[x] *= INVERSE_DECIBEL_TABLE[y];
        }
    }

    @OriginalMember(owner = "client!bk", name = "a", descriptor = "(II)V")
    private void quicksort(@OriginalArg(0) int start, @OriginalArg(1) int end) {
        if (start >= end) {
            return;
        }

        @Pc(6) int pivot = start;
        @Pc(10) int pivotX = X_LIST[start];
        @Pc(14) int pivotY = Y[start];
        @Pc(18) boolean pivotStep = STEP2_FLAG[start];

        for (@Pc(22) int i = start + 1; i <= end; i++) {
            @Pc(27) int xValue = X_LIST[i];

            if (xValue < pivotX) {
                X_LIST[pivot] = xValue;
                Y[pivot] = Y[i];
                STEP2_FLAG[pivot] = STEP2_FLAG[i];

                pivot++;
                X_LIST[i] = X_LIST[pivot];
                Y[i] = Y[pivot];
                STEP2_FLAG[i] = STEP2_FLAG[pivot];
            }
        }

        X_LIST[pivot] = pivotX;
        Y[pivot] = pivotY;
        STEP2_FLAG[pivot] = pivotStep;

        this.quicksort(start, pivot - 1);
        this.quicksort(pivot + 1, end);
    }
}
