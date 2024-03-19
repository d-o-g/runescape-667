import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MeshEmitterTypeList {

    @OriginalMember(owner = "client!jba", name = "d", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(BI)Lclient!vaa;")
    public static MeshEmitterType get(@OriginalArg(1) int id) {
        @Pc(10) MeshEmitterType type = (MeshEmitterType) recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(21) byte[] data = js5.EMITTERS.getfile(id, 0);
        type = new MeshEmitterType();
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        recentUse.put(type, id);
        return type;
    }

    @OriginalMember(owner = "client!rla", name = "b", descriptor = "(I)V")
    public static void cacheReset() {
        recentUse.reset();
    }

    private MeshEmitterTypeList() {
        /* empty */
    }
}
