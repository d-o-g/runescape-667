import com.jagex.collect.HashTable;
import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MeshMagnetTypeList {

    @OriginalMember(owner = "client!lk", name = "a", descriptor = "[Lclient!ok;")
    public static final MeshMagnetType[] types = new MeshMagnetType[16];

    @OriginalMember(owner = "client!ps", name = "i", descriptor = "Lclient!av;")
    public static final HashTable table = new HashTable(16);

    @OriginalMember(owner = "client!wk", name = "h", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!lm", name = "k", descriptor = "I")
    private static int ptr = 0;

    @OriginalMember(owner = "client!cc", name = "b", descriptor = "(II)Lclient!ok;")
    public static MeshMagnetType get(@OriginalArg(1) int id) {
        @Pc(10) MeshMagnetType type = (MeshMagnetType) recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(21) byte[] data = js5.MAGNETS.getfile(id, 1);
        type = new MeshMagnetType();
        type.id = id;
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        if (type.visibility == 2 && table.get(id) == null) {
            table.put(id, new IntNode(ptr));
            types[ptr++] = type;
        }

        recentUse.put(type, id);
        return type;
    }

    @OriginalMember(owner = "client!nfa", name = "a", descriptor = "(I)V")
    public static void cacheReset() {
        recentUse.reset();
    }

    private MeshMagnetTypeList() {
        /* empty */
    }
}
