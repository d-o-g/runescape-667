import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ld")
public final class HitmarkTypeList {

    @OriginalMember(owner = "client!rla", name = "e", descriptor = "Lclient!ld;")
    public static HitmarkTypeList instance;

    @OriginalMember(owner = "client!ld", name = "n", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_121 = new ReferenceCache(20);

    @OriginalMember(owner = "client!ld", name = "d", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!ld", name = "l", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!ld", name = "g", descriptor = "Lclient!sb;")
    public final js5 aJs5_76;

    private final int num;

    @OriginalMember(owner = "client!ld", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public HitmarkTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 arg3) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.aJs5_76 = arg3;
        this.num = this.configClient.fileLimit(46);
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local2 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.reset();
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local2 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(5);
        }
        local6 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.clean(5);
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(II)Lclient!pb;")
    public Class285 list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) Class285 type;
        synchronized (this.recentUse) {
            type = (Class285) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 46);
        }

        type = new Class285();
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(66) ReferenceCache local66 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }
}
