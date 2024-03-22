import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nv")
public final class Class267 {

    @OriginalMember(owner = "client!nv", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!nv", name = "g", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_143 = new ReferenceCache(2);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_88;

    @OriginalMember(owner = "client!nv", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!nv", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class267(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 arg3) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.aJs5_88 = arg3;
        this.num = this.configClient.fileLimit(33);
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(11) ReferenceCache local11 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local11 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(9) ReferenceCache local9 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local9 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(II)Lclient!vla;")
    public Class389 list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(18) Class389 type;
        synchronized (this.recentUse) {
            type = (Class389) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(32) js5 local32 = this.configClient;
        @Pc(41) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 33);
        }

        type = new Class389();
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(70) ReferenceCache local70 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(7) ReferenceCache local7 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local7 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.reset();
        }
    }
}
