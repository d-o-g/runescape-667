import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!u")
public final class MSITypeList {

    @OriginalMember(owner = "client!u", name = "d", descriptor = "Lclient!dla;")
    public ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!u", name = "n", descriptor = "Lclient!dla;")
    public ReferenceCache spriteCache = new ReferenceCache(64);

    @OriginalMember(owner = "client!u", name = "q", descriptor = "Lclient!sb;")
    public final js5 sprites;

    @OriginalMember(owner = "client!u", name = "c", descriptor = "Lclient!sb;")
    public final js5 configClient;

    public final ModeGame game;
    public final int languageId;
    public final int num;

    @OriginalMember(owner = "client!u", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public MSITypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 sprites) {
        this.game = game;
        this.languageId = languageId;
        this.sprites = sprites;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.MSITYPE);
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local2 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!u", name = "b", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(10) ReferenceCache local10 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local10 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.reset();
        }
    }

    @OriginalMember(owner = "client!u", name = "b", descriptor = "(II)Lclient!ia;")
    public MSIType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) MSIType type;
        synchronized (this.recentUse) {
            type = (MSIType) this.recentUse.get((long) id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 34);
        }

        type = new MSIType();
        type.typeList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(68) ReferenceCache local68 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(III)V")
    public void setCache(@OriginalArg(0) int spriteSize, @OriginalArg(2) int recentUseSize) {
        this.recentUse = new ReferenceCache(recentUseSize);
        this.spriteCache = new ReferenceCache(spriteSize);
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local6 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.clean(maxAge);
        }
    }
}
