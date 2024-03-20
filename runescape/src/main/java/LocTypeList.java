import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.LocalisedText;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gea")
public final class LocTypeList {

    @OriginalMember(owner = "client!gea", name = "r", descriptor = "I")
    public int featureMask;

    @OriginalMember(owner = "client!gea", name = "c", descriptor = "Z")
    public boolean animateBackground = false;

    @OriginalMember(owner = "client!gea", name = "l", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_73 = new ReferenceCache(64);

    @OriginalMember(owner = "client!gea", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache models = new ReferenceCache(500);

    @OriginalMember(owner = "client!gea", name = "k", descriptor = "Lclient!dla;")
    public final ReferenceCache modelAndShadows = new ReferenceCache(30);

    @OriginalMember(owner = "client!gea", name = "q", descriptor = "Lclient!dla;")
    public final ReferenceCache wallModels = new ReferenceCache(50);

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "Lclient!sb;")
    public final js5 meshes;

    @OriginalMember(owner = "client!gea", name = "j", descriptor = "Lclient!ul;")
    public final ModeGame aModeGame_2;

    @OriginalMember(owner = "client!gea", name = "h", descriptor = "I")
    public final int anInt3383;

    @OriginalMember(owner = "client!gea", name = "p", descriptor = "Lclient!sb;")
    public final js5 aJs5_43;

    @OriginalMember(owner = "client!gea", name = "d", descriptor = "Z")
    public boolean allowMembers;

    @OriginalMember(owner = "client!gea", name = "i", descriptor = "[Ljava/lang/String;")
    public final String[] aStringArray15;

    @OriginalMember(owner = "client!gea", name = "<init>", descriptor = "(Lclient!ul;IZLclient!sb;Lclient!sb;)V")
    public LocTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) js5 arg3, @OriginalArg(4) js5 arg4) {
        this.meshes = arg4;
        this.aModeGame_2 = arg0;
        this.anInt3383 = arg1;
        this.aJs5_43 = arg3;
        this.allowMembers = arg2;
        if (this.aJs5_43 != null) {
            @Pc(53) int local53 = this.aJs5_43.groupSize() - 1;
            this.aJs5_43.fileLimit(local53);
        }
        if (ModeGame.RUNESCAPE == this.aModeGame_2) {
            this.aStringArray15 = new String[]{null, null, null, null, null, LocalisedText.EXAMINE.localise(this.anInt3383)};
        } else {
            this.aStringArray15 = new String[]{null, null, null, null, null, null};
        }
    }

    @OriginalMember(owner = "client!rv", name = "a", descriptor = "(IB)I")
    public static int fileId(@OriginalArg(0) int arg0) {
        return arg0 & 0xFF;
    }

    @OriginalMember(owner = "client!wf", name = "a", descriptor = "(II)I")
    public static int groupId(@OriginalArg(1) int arg0) {
        return arg0 >>> 8;
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(I)V")
    public void method3058() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_73;
        synchronized (this.aReferenceCache_73) {
            this.aReferenceCache_73.removeSoftReferences();
        }
        local2 = this.models;
        synchronized (this.models) {
            this.models.removeSoftReferences();
        }
        local2 = this.modelAndShadows;
        synchronized (this.modelAndShadows) {
            this.modelAndShadows.removeSoftReferences();
        }
        local2 = this.wallModels;
        synchronized (this.wallModels) {
            this.wallModels.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(ZI)V")
    public void method3059(@OriginalArg(0) boolean arg0) {
        if (arg0 != this.allowMembers) {
            this.allowMembers = arg0;
            this.method3060();
        }
    }

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "(I)V")
    public void method3060() {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_73;
        synchronized (this.aReferenceCache_73) {
            this.aReferenceCache_73.reset();
        }
        local14 = this.models;
        synchronized (this.models) {
            this.models.reset();
        }
        local14 = this.modelAndShadows;
        synchronized (this.modelAndShadows) {
            this.modelAndShadows.reset();
        }
        local14 = this.wallModels;
        synchronized (this.wallModels) {
            this.wallModels.reset();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(IZ)V")
    public void method3061(@OriginalArg(1) boolean arg0) {
        if (arg0 != this.animateBackground) {
            this.animateBackground = arg0;
            this.method3060();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(II)V")
    public void method3062(@OriginalArg(1) int arg0) {
        this.aReferenceCache_73 = new ReferenceCache(arg0);
    }

    @OriginalMember(owner = "client!gea", name = "d", descriptor = "(II)Lclient!c;")
    public LocType list(@OriginalArg(0) int id) {
        @Pc(12) ReferenceCache local12 = this.aReferenceCache_73;
        @Pc(22) LocType local22;
        synchronized (this.aReferenceCache_73) {
            local22 = (LocType) this.aReferenceCache_73.get((long) id);
        }
        if (local22 != null) {
            return local22;
        }
        @Pc(36) js5 local36 = this.aJs5_43;
        @Pc(49) byte[] local49;
        synchronized (this.aJs5_43) {
            local49 = this.aJs5_43.getfile(fileId(id), groupId(id));
        }
        local22 = new LocType();
        local22.id = id;
        local22.typeList = this;
        local22.ops = (String[]) this.aStringArray15.clone();
        if (local49 != null) {
            local22.decode(new Packet(local49));
        }
        local22.postDecode();
        if (local22.routingHint) {
            local22.movementPolicy = 0;
            local22.blockRanged = false;
        }
        if (!this.allowMembers && local22.members) {
            local22.ops = null;
            local22.quests = null;
        }
        @Pc(115) ReferenceCache local115 = this.aReferenceCache_73;
        synchronized (this.aReferenceCache_73) {
            this.aReferenceCache_73.put(local22, (long) id);
            return local22;
        }
    }

    @OriginalMember(owner = "client!gea", name = "c", descriptor = "(II)V")
    public void method3064() {
        @Pc(11) ReferenceCache local11 = this.aReferenceCache_73;
        synchronized (this.aReferenceCache_73) {
            this.aReferenceCache_73.clean(5);
        }
        local11 = this.models;
        synchronized (this.models) {
            this.models.clean(5);
        }
        local11 = this.modelAndShadows;
        synchronized (this.modelAndShadows) {
            this.modelAndShadows.clean(5);
        }
        local11 = this.wallModels;
        synchronized (this.wallModels) {
            this.wallModels.clean(5);
        }
    }

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "(II)V")
    public void setFeatureMask(@OriginalArg(0) int arg0) {
        this.featureMask = arg0;
        @Pc(9) ReferenceCache local9 = this.models;
        synchronized (this.models) {
            this.models.reset();
        }
        local9 = this.modelAndShadows;
        synchronized (this.modelAndShadows) {
            this.modelAndShadows.reset();
        }
        local9 = this.wallModels;
        synchronized (this.wallModels) {
            this.wallModels.reset();
        }
    }
}
