import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kka")
public final class VarcTypeList {

    @OriginalMember(owner = "client!vs", name = "t", descriptor = "Lclient!kka;")
    public static VarcTypeList instance;

    @OriginalMember(owner = "client!kka", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!kka", name = "a", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!kka", name = "f", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!kka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarcTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(19);
    }

    @OriginalMember(owner = "client!kka", name = "a", descriptor = "(II)Lclient!paa;")
    public Class284 list(@OriginalArg(0) int id) {
        @Pc(12) ReferenceCache local12 = this.recentUse;
        @Pc(22) Class284 type;
        synchronized (this.recentUse) {
            type = (Class284) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(36) js5 local36 = this.configClient;
        @Pc(45) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 19);
        }

        type = new Class284();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(69) ReferenceCache local69 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }
}
