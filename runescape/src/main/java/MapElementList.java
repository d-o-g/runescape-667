import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nc")
public final class MapElementList {

    @OriginalMember(owner = "client!nc", name = "d", descriptor = "I")
    public int anInt6373;

    @OriginalMember(owner = "client!nc", name = "e", descriptor = "[I")
    public final int[] anIntArray495;

    @OriginalMember(owner = "client!nc", name = "b", descriptor = "[I")
    public final int[] anIntArray496;

    @OriginalMember(owner = "client!nc", name = "<init>", descriptor = "(I)V")
    public MapElementList(@OriginalArg(0) int arg0) {
        this.anInt6373 = arg0;
        this.anIntArray495 = new int[this.anInt6373];
        this.anIntArray496 = new int[this.anInt6373];
    }

    @OriginalMember(owner = "client!iu", name = "a", descriptor = "(ZILclient!sb;Ljava/lang/String;)Lclient!nc;")
    public static MapElementList load(@OriginalArg(0) boolean arg0, @OriginalArg(2) js5 arg1, @OriginalArg(3) String arg2) {
        @Pc(8) int local8 = arg1.getgroupid(arg2);
        if (local8 == -1) {
            return new MapElementList(0);
        }
        @Pc(24) int[] local24 = arg1.fileIds(local8);
        @Pc(30) MapElementList local30 = new MapElementList(local24.length);
        @Pc(32) int local32 = 0;
        @Pc(34) int local34 = 0;
        while (true) {
            while (local30.anInt6373 > local32) {
                @Pc(47) Packet local47 = new Packet(arg1.getfile(local24[local34++], local8));
                @Pc(51) int local51 = local47.g4();
                @Pc(57) int local57 = local47.g2();
                @Pc(61) int local61 = local47.g1();
                if (!arg0 && local61 == 1) {
                    local30.anInt6373--;
                } else {
                    local30.anIntArray495[local32] = local51;
                    local30.anIntArray496[local32] = local57;
                    local32++;
                }
            }
            return local30;
        }
    }
}
