import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fh")
public final class Class128 {

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "I")
    public int anInt2921;

    @OriginalMember(owner = "client!fh", name = "i", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!fh", name = "k", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_62 = new ReferenceCache(60);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!fh", name = "f", descriptor = "Lclient!sb;")
    public final js5 aJs5_34;

    @OriginalMember(owner = "client!fh", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!fh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class128(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 arg3) {
        this.game = game;
        this.languageId = languageId;
        this.aJs5_34 = arg3;
        this.configClient = configClient;

        @Pc(26) int local26 = this.configClient.groupSize() - 1;
        this.num = this.configClient.fileLimit(local26);
    }

    @OriginalMember(owner = "client!rl", name = "a", descriptor = "(II)I")
    public static int fileId(@OriginalArg(1) int arg0) {
        return arg0 & 0xFF;
    }

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "(II)I")
    public static int groupId(@OriginalArg(0) int arg0) {
        return arg0 >>> 8;
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(II)Lclient!lia;")
    public Class227 list(@OriginalArg(1) int id) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        @Pc(24) Class227 type;
        synchronized (this.recentUse) {
            type = (Class227) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(38) js5 local38 = this.configClient;
        @Pc(51) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(fileId(id), groupId(id));
        }

        type = new Class227();
        type.id = id;
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(81) ReferenceCache local81 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(BI)V")
    public void setFeatureMask(@OriginalArg(1) int arg0) {
        this.anInt2921 = arg0;
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.reset();
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(Z)V")
    public void cacheRemoveSoftReferences() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local6 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        @Pc(30) ReferenceCache local30 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local6 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.reset();
        }
    }
}
