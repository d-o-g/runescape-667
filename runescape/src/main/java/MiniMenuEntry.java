import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pg")
public final class MiniMenuEntry extends Node2 {

    @OriginalMember(owner = "client!pg", name = "C", descriptor = "Ljava/lang/String;")
    public String aString88;

    @OriginalMember(owner = "client!pg", name = "v", descriptor = "J")
    public final long aLong233;

    @OriginalMember(owner = "client!pg", name = "t", descriptor = "Z")
    public final boolean aBoolean552;

    @OriginalMember(owner = "client!pg", name = "D", descriptor = "I")
    public final int anInt7318;

    @OriginalMember(owner = "client!pg", name = "x", descriptor = "I")
    public final int anInt7317;

    @OriginalMember(owner = "client!pg", name = "G", descriptor = "I")
    public final int anInt7313;

    @OriginalMember(owner = "client!pg", name = "z", descriptor = "I")
    public int action;

    @OriginalMember(owner = "client!pg", name = "u", descriptor = "Ljava/lang/String;")
    public final String aString87;

    @OriginalMember(owner = "client!pg", name = "B", descriptor = "J")
    public final long entryKey;

    @OriginalMember(owner = "client!pg", name = "w", descriptor = "Ljava/lang/String;")
    public final String opBase;

    @OriginalMember(owner = "client!pg", name = "F", descriptor = "I")
    public final int anInt7316;

    @OriginalMember(owner = "client!pg", name = "E", descriptor = "Z")
    public final boolean aBoolean553;

    @OriginalMember(owner = "client!pg", name = "H", descriptor = "Z")
    public final boolean independent;

    @OriginalMember(owner = "client!pg", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIJIIZZJZ)V")
    public MiniMenuEntry(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) long arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) boolean arg8, @OriginalArg(9) boolean arg9, @OriginalArg(10) long arg10, @OriginalArg(11) boolean arg11) {
        this.aLong233 = arg5;
        this.aBoolean552 = arg8;
        this.anInt7318 = arg2;
        this.anInt7317 = arg4;
        this.anInt7313 = arg7;
        this.action = arg3;
        this.aString87 = arg0;
        this.entryKey = arg10;
        this.opBase = arg1;
        this.anInt7316 = arg6;
        this.aBoolean553 = arg9;
        this.independent = arg11;
    }
}
