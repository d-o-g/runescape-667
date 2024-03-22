import com.jagex.core.datastruct.key.Class191;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static444 {

    @OriginalMember(owner = "client!o", name = "rb", descriptor = "I")
    public static int anInt6751;

    @OriginalMember(owner = "client!o", name = "jb", descriptor = "Lclient!jg;")
    public static final Class191 aClass191_1 = new Class191();

    @OriginalMember(owner = "client!o", name = "O", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___169 = new ServerProt(42, -1);

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(B)V")
    public static void resetMapFLag() {
        @Pc(13) DoublyLinkedNode_Sub2__ local13 = Static440.method5963(15, 0L);
        local13.method205();
    }

}
