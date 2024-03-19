import com.jagex.collect.Node;
import com.jagex.collect.hash.HashableCache;
import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!es")
public final class ObjTypeList {

    @OriginalMember(owner = "client!es", name = "p", descriptor = "I")
    public int anInt2673;

    @OriginalMember(owner = "client!es", name = "o", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!es", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache modelCache = new ReferenceCache(50);

    @OriginalMember(owner = "client!es", name = "f", descriptor = "Lclient!aka;")
    public final HashableCache appearanceSpriteCache = new HashableCache(250);

    @OriginalMember(owner = "client!es", name = "j", descriptor = "Lclient!rla;")
    public final HashableObjSprite aObjSpriteCacheKey_1 = new HashableObjSprite();

    @OriginalMember(owner = "client!es", name = "m", descriptor = "I")
    public final int languageId;

    @OriginalMember(owner = "client!es", name = "w", descriptor = "Lclient!ul;")
    public final ModeGame game;

    @OriginalMember(owner = "client!es", name = "l", descriptor = "Lclient!sb;")
    public final js5 meshes;

    @OriginalMember(owner = "client!es", name = "q", descriptor = "Lclient!bo;")
    public final Class49 paramsTL;

    @OriginalMember(owner = "client!es", name = "x", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!es", name = "i", descriptor = "Z")
    public boolean allowMembers;

    @OriginalMember(owner = "client!es", name = "n", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!es", name = "g", descriptor = "[Ljava/lang/String;")
    public final String[] defaultOps;

    @OriginalMember(owner = "client!es", name = "y", descriptor = "[Ljava/lang/String;")
    public final String[] defaultIops;

    @OriginalMember(owner = "client!es", name = "<init>", descriptor = "(Lclient!ul;IZLclient!bo;Lclient!sb;Lclient!sb;)V")
    public ObjTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) boolean allowMembers, @OriginalArg(3) Class49 paramsTL, @OriginalArg(4) js5 configClient, @OriginalArg(5) js5 meshes) {
        this.languageId = languageId;
        this.game = game;
        this.meshes = meshes;
        this.paramsTL = paramsTL;
        this.configClient = configClient;
        this.allowMembers = allowMembers;

        if (this.configClient == null) {
            this.num = 0;
        } else {
            @Pc(54) int lastGroup = this.configClient.groupSize() - 1;
            this.num = this.configClient.fileLimit(lastGroup) + (lastGroup * 256);
        }

        if (this.game == ModeGame.RUNESCAPE) {
            this.defaultOps = new String[]{
                /* 0 */ null,
                /* 1 */ null,
                /* 2 */ LocalisedText.TAKE.localise(this.languageId),
                /* 3 */ null,
                /* 4 */ null,
                /* 5 */ Static32.EXAMINE.localise(this.languageId)
            };
        } else {
            this.defaultOps = new String[]{
                /* 0 */ null,
                /* 1 */ null,
                /* 2 */ LocalisedText.TAKE.localise(this.languageId),
                /* 3 */ null,
                /* 4 */ null,
                /* 5 */ null
            };
        }

        this.defaultIops = new String[]{
            null,
            null,
            null,
            null,
            LocalisedText.DROP.localise(this.languageId)
        };
    }

    @OriginalMember(owner = "client!gu", name = "b", descriptor = "(ZI)I")
    public static int and(@OriginalArg(1) int arg0) {
        return arg0 & 0xFF;
    }

    @OriginalMember(owner = "client!sm", name = "a", descriptor = "(II)I")
    public static int shr8(@OriginalArg(1) int arg0) {
        return arg0 >>> 8;
    }

    @OriginalMember(owner = "client!es", name = "b", descriptor = "(B)V")
    public void method2476() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }

        local6 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.reset();
        }

        @Pc(44) HashableCache local44 = this.appearanceSpriteCache;
        synchronized (this.appearanceSpriteCache) {
            this.appearanceSpriteCache.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(ILclient!ha;Lclient!ha;Lclient!ju;ZIIZILclient!da;II)Lclient!st;")
    public Sprite sprite(@OriginalArg(0) int arg0, @OriginalArg(1) Toolkit arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) PlayerModel arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) Class14 arg9, @OriginalArg(10) int arg10) {
        @Pc(24) Sprite local24 = this.method2483(arg3, arg2, arg8, arg10, arg0, arg6, arg5);
        if (local24 != null) {
            return local24;
        }
        @Pc(34) ObjType local34 = this.list(arg10);
        if (arg6 > 1 && local34.countobj != null) {
            @Pc(44) int local44 = -1;
            for (@Pc(46) int local46 = 0; local46 < 10; local46++) {
                if (local34.countco[local46] <= arg6 && local34.countco[local46] != 0) {
                    local44 = local34.countobj[local46];
                }
            }
            if (local44 != -1) {
                local34 = this.list(local44);
            }
        }
        @Pc(101) int[] local101 = local34.sprite(arg8, arg2, arg6, arg5, arg7, arg3, arg1, arg9, arg0);
        if (local101 == null) {
            return null;
        }
        @Pc(119) Sprite local119;
        if (arg4) {
            local119 = arg1.createSprite(36, 36, 32, local101);
        } else {
            local119 = arg2.createSprite(36, 36, 32, local101);
        }
        if (!arg4) {
            @Pc(136) HashableObjSprite local136 = new HashableObjSprite();
            local136.objNumMode = arg8;
            local136.useAppearance = arg3 != null;
            local136.toolkitIndex = arg2.index;
            local136.invCount = arg6;
            local136.outline = arg0;
            local136.objId = arg10;
            local136.graphicShadow = arg5;
            this.appearanceSpriteCache.put(local119, local136);
        }
        return local119;
    }

    @OriginalMember(owner = "client!es", name = "c", descriptor = "(II)V")
    public void method2479(int maxAge) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local14 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.clean(maxAge);
        }
        @Pc(48) HashableCache local48 = this.appearanceSpriteCache;
        synchronized (this.appearanceSpriteCache) {
            this.appearanceSpriteCache.clearSoft(maxAge);
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(B)V")
    public void method2480() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local6 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.removeSoftReferences();
        }
        @Pc(44) HashableCache local44 = this.appearanceSpriteCache;
        synchronized (this.appearanceSpriteCache) {
            this.appearanceSpriteCache.method253();
        }
    }

    @OriginalMember(owner = "client!es", name = "b", descriptor = "(II)V")
    public void setFeatureMask(@OriginalArg(0) int arg0) {
        this.anInt2673 = arg0;
        @Pc(17) ReferenceCache local17 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(I)V")
    public void method2482() {
        @Pc(2) ReferenceCache local2 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(Lclient!ju;BLclient!ha;IIIII)Lclient!st;")
    public Sprite method2483(@OriginalArg(0) PlayerModel arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        this.aObjSpriteCacheKey_1.invCount = arg5;
        this.aObjSpriteCacheKey_1.toolkitIndex = arg1.index;
        this.aObjSpriteCacheKey_1.objNumMode = arg2;
        this.aObjSpriteCacheKey_1.graphicShadow = arg6;
        this.aObjSpriteCacheKey_1.useAppearance = arg0 != null;
        this.aObjSpriteCacheKey_1.outline = arg4;
        this.aObjSpriteCacheKey_1.objId = arg3;
        return (Sprite) this.appearanceSpriteCache.method260(this.aObjSpriteCacheKey_1);
    }

    @OriginalMember(owner = "client!es", name = "c", descriptor = "(I)V")
    public void method2484() {
        @Pc(6) HashableCache local6 = this.appearanceSpriteCache;
        synchronized (this.appearanceSpriteCache) {
            this.appearanceSpriteCache.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(BZ)V")
    public void setAllowMembers(@OriginalArg(1) boolean arg0) {
        if (this.allowMembers != arg0) {
            this.allowMembers = arg0;
            this.method2476();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(II)Lclient!vfa;")
    public ObjType list(@OriginalArg(0) int id) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        @Pc(26) ObjType type;

        synchronized (this.recentUse) {
            type = (ObjType) this.recentUse.get((long) id);
        }
        if (type != null) {
            return type;
        }

        @Pc(40) js5 local40 = this.configClient;
        @Pc(53) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(and(id), shr8(id));
        }

        type = new ObjType();
        type.anInt10134 = id;
        type.myList = this;
        type.op = this.defaultOps.clone();
        type.iop = this.defaultIops.clone();
        if (data != null) {
            type.decode(new Packet(data));
        }

        type.postDecode();

        if (type.certtemplate != -1) {
            type.genCert(this.list(type.certtemplate), this.list(type.certlink));
        }

        if (type.lenttemplate != -1) {
            type.genLent(this.list(type.lentlink), this.list(type.lenttemplate));
        }

        if (type.boughttemplate != -1) {
            type.genBought(this.list(type.boughttemplate), this.list(type.boughtlink));
        }


        if (!this.allowMembers && type.members) {
            type.name = LocalisedText.MEMBERS_OBJECT.localise(this.languageId);
            type.op = this.defaultOps;
            type.iop = this.defaultIops;
            type.quests = null;
            type.team = 0;
            type.stockmarket = false;

            if (type.params != null) {
                @Pc(195) boolean disable = false;

                for (@Pc(200) Node node = type.params.first(); node != null; node = type.params.next()) {
                    @Pc(209) ParamType param = this.paramsTL.list((int) node.key);

                    if (param.autodisable) {
                        node.remove();
                    } else {
                        disable = true;
                    }
                }

                if (!disable) {
                    type.params = null;
                }
            }
        }

        @Pc(238) ReferenceCache local238 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, (long) id);
            return type;
        }
    }
}
