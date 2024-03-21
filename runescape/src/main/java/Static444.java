import com.jagex.core.datastruct.key.Class191;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static444 {

    @OriginalMember(owner = "client!o", name = "rb", descriptor = "I")
    public static int anInt6751;

    @OriginalMember(owner = "client!o", name = "x", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___145 = new ReferenceCache(4);

    @OriginalMember(owner = "client!o", name = "jb", descriptor = "Lclient!jg;")
    public static final Class191 aClass191_1 = new Class191();

    @OriginalMember(owner = "client!o", name = "O", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_169 = new Class225(42, -1);

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(Lclient!sb;Lclient!sb;Lclient!sb;BLclient!sb;)V")
    public static void method5987(@OriginalArg(0) js5 arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) js5 arg2, @OriginalArg(4) js5 arg3) {
        Static262.aJs5_56 = arg2;
        Static666.aJs5_118 = arg0;
        Static607.aJs5_113 = arg3;
        Static453.aClass158ArrayArray2 = new Class158[Static666.aJs5_118.groupSize()][];
        Static132.aBooleanArray5 = new boolean[Static666.aJs5_118.groupSize()];
    }

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(B)V")
    public static void method5988() {
        @Pc(13) DoublyLinkedNode_Sub2__ local13 = Static440.method5963(15, 0L);
        local13.method205();
    }

}
