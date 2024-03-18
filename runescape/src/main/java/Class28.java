import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!av")
public final class Class28 {

    @OriginalMember(owner = "client!av", name = "m", descriptor = "[I")
    public static final int[] anIntArray34 = new int[120];

    @OriginalMember(owner = "client!av", name = "c", descriptor = "Lclient!ie;")
    public Node aNode_21;

    @OriginalMember(owner = "client!av", name = "a", descriptor = "J")
    public long aLong21;

    @OriginalMember(owner = "client!av", name = "d", descriptor = "Lclient!ie;")
    public Node aNode_22;

    @OriginalMember(owner = "client!av", name = "h", descriptor = "I")
    public int anInt641 = 0;

    @OriginalMember(owner = "client!av", name = "q", descriptor = "I")
    public final int anInt638;

    @OriginalMember(owner = "client!av", name = "e", descriptor = "[Lclient!ie;")
    public final Node[] aNodeArray1;

    static {
        @Pc(85) int local85 = 0;
        for (@Pc(87) int local87 = 0; local87 < 120; local87++) {
            @Pc(92) int local92 = local87 + 1;
            @Pc(105) int local105 = (int) (Math.pow(2.0D, (double) local92 / 7.0D) * 300.0D + (double) local92);
            local85 += local105;
            anIntArray34[local87] = local85 / 4;
        }
    }

    @OriginalMember(owner = "client!av", name = "<init>", descriptor = "(I)V")
    public Class28(@OriginalArg(0) int arg0) {
        this.anInt638 = arg0;
        this.aNodeArray1 = new Node[arg0];
        for (@Pc(13) int local13 = 0; local13 < arg0; local13++) {
            @Pc(23) Node local23 = this.aNodeArray1[local13] = new Node();
            local23.aNode_346 = local23;
            local23.aNode_345 = local23;
        }
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(JLclient!ie;I)V")
    public void method735(@OriginalArg(0) long arg0, @OriginalArg(1) Node arg1) {
        if (arg1.aNode_345 != null) {
            arg1.method9457();
        }
        @Pc(28) Node local28 = this.aNodeArray1[(int) (arg0 & (long) (this.anInt638 - 1))];
        arg1.aNode_346 = local28;
        arg1.aNode_345 = local28.aNode_345;
        arg1.aNode_345.aNode_346 = arg1;
        arg1.aNode_346.aNode_345 = arg1;
        arg1.aLong328 = arg0;
    }

    @OriginalMember(owner = "client!av", name = "b", descriptor = "(Z)Lclient!ie;")
    public Node method736() {
        this.anInt641 = 0;
        return this.method740();
    }

    @OriginalMember(owner = "client!av", name = "c", descriptor = "(Z)V")
    public void method737() {
        for (@Pc(6) int local6 = 0; local6 < this.anInt638; local6++) {
            @Pc(12) Node local12 = this.aNodeArray1[local6];
            while (true) {
                @Pc(15) Node local15 = local12.aNode_346;
                if (local15 == local12) {
                    break;
                }
                local15.method9457();
            }
        }
        this.aNode_21 = null;
        this.aNode_22 = null;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(IJ)Lclient!ie;")
    public Node method738(@OriginalArg(1) long arg0) {
        this.aLong21 = arg0;
        @Pc(25) Node local25 = this.aNodeArray1[(int) (arg0 & (long) (this.anInt638 - 1))];
        for (this.aNode_21 = local25.aNode_346; this.aNode_21 != local25; this.aNode_21 = this.aNode_21.aNode_346) {
            if (arg0 == this.aNode_21.aLong328) {
                @Pc(43) Node local43 = this.aNode_21;
                this.aNode_21 = this.aNode_21.aNode_346;
                return local43;
            }
        }
        this.aNode_21 = null;
        return null;
    }

    @OriginalMember(owner = "client!av", name = "c", descriptor = "(B)I")
    public int method739() {
        @Pc(5) int local5 = 0;
        for (@Pc(13) int local13 = 0; local13 < this.anInt638; local13++) {
            @Pc(19) Node local19 = this.aNodeArray1[local13];
            @Pc(22) Node local22 = local19.aNode_346;
            while (local22 != local19) {
                local22 = local22.aNode_346;
                local5++;
            }
        }
        return local5;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(I)Lclient!ie;")
    public Node method740() {
        @Pc(32) Node local32;
        if (this.anInt641 > 0 && this.aNode_22 != this.aNodeArray1[this.anInt641 - 1]) {
            local32 = this.aNode_22;
            this.aNode_22 = local32.aNode_346;
            return local32;
        }
        while (this.anInt638 > this.anInt641) {
            local32 = this.aNodeArray1[this.anInt641++].aNode_346;
            if (this.aNodeArray1[this.anInt641 - 1] != local32) {
                this.aNode_22 = local32.aNode_346;
                return local32;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(Z)I")
    public int method742() {
        return this.anInt638;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(B[Lclient!ie;)I")
    public int method743(@OriginalArg(1) Node[] arg0) {
        @Pc(5) int local5 = 0;
        for (@Pc(16) int local16 = 0; local16 < this.anInt638; local16++) {
            @Pc(22) Node local22 = this.aNodeArray1[local16];
            for (@Pc(25) Node local25 = local22.aNode_346; local25 != local22; local25 = local25.aNode_346) {
                arg0[local5++] = local25;
            }
        }
        return local5;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(B)Lclient!ie;")
    public Node method744() {
        if (this.aNode_21 == null) {
            return null;
        }
        @Pc(28) Node local28 = this.aNodeArray1[(int) ((long) (this.anInt638 - 1) & this.aLong21)];
        while (this.aNode_21 != local28) {
            if (this.aNode_21.aLong328 == this.aLong21) {
                @Pc(43) Node local43 = this.aNode_21;
                this.aNode_21 = this.aNode_21.aNode_346;
                return local43;
            }
            this.aNode_21 = this.aNode_21.aNode_346;
        }
        this.aNode_21 = null;
        return null;
    }
}
