import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vla")
public final class Class389 {

    @OriginalMember(owner = "client!vla", name = "c", descriptor = "I")
    public int anInt10303;

    @OriginalMember(owner = "client!vla", name = "f", descriptor = "I")
    public int anInt10305;

    @OriginalMember(owner = "client!vla", name = "b", descriptor = "Lclient!nv;")
    public Class267 myList;

    @OriginalMember(owner = "client!vla", name = "d", descriptor = "I")
    public int anInt10308;

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(Lclient!ge;II)V")
    public void method8933(@OriginalArg(0) Packet arg0, @OriginalArg(2) int arg1) {
        if (arg1 == 1) {
            this.anInt10305 = arg0.g2();
        } else if (arg1 == 2) {
            this.anInt10303 = arg0.g1();
            this.anInt10308 = arg0.g1();
        }
    }

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(B)Lclient!wp;")
    public synchronized IndexedImage method8934() {
        @Pc(13) IndexedImage local13 = (IndexedImage) this.myList.aReferenceCache_143.get(this.anInt10305);
        if (local13 != null) {
            return local13;
        }
        local13 = IndexedImage.loadFirst(this.myList.aJs5_88, this.anInt10305, 0);
        if (local13 != null) {
            this.myList.aReferenceCache_143.put(local13, this.anInt10305);
        }
        return local13;
    }

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet arg0) {
        while (true) {
            @Pc(16) int local16 = arg0.g1();
            if (local16 == 0) {
                return;
            }
            this.method8933(arg0, local16);
        }
    }
}
