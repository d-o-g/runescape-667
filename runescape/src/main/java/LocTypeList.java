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
    public int anInt3390;

    @OriginalMember(owner = "client!gea", name = "c", descriptor = "Z")
    public boolean aBoolean266 = false;

    @OriginalMember(owner = "client!gea", name = "l", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_73 = new ReferenceCache(64);

    @OriginalMember(owner = "client!gea", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_74 = new ReferenceCache(500);

    @OriginalMember(owner = "client!gea", name = "k", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_75 = new ReferenceCache(30);

    @OriginalMember(owner = "client!gea", name = "q", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_76 = new ReferenceCache(50);

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_44;

    @OriginalMember(owner = "client!gea", name = "j", descriptor = "Lclient!ul;")
    public final ModeGame aModeGame_2;

    @OriginalMember(owner = "client!gea", name = "h", descriptor = "I")
    public final int anInt3383;

    @OriginalMember(owner = "client!gea", name = "p", descriptor = "Lclient!sb;")
    public final js5 aJs5_43;

    @OriginalMember(owner = "client!gea", name = "d", descriptor = "Z")
    public boolean aBoolean267;

    @OriginalMember(owner = "client!gea", name = "i", descriptor = "[Ljava/lang/String;")
    public final String[] aStringArray15;

    @OriginalMember(owner = "client!gea", name = "<init>", descriptor = "(Lclient!ul;IZLclient!sb;Lclient!sb;)V")
    public LocTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) js5 arg3, @OriginalArg(4) js5 arg4) {
        this.aJs5_44 = arg4;
        this.aModeGame_2 = arg0;
        this.anInt3383 = arg1;
        this.aJs5_43 = arg3;
        this.aBoolean267 = arg2;
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
        local2 = this.aReferenceCache_74;
        synchronized (this.aReferenceCache_74) {
            this.aReferenceCache_74.removeSoftReferences();
        }
        local2 = this.aReferenceCache_75;
        synchronized (this.aReferenceCache_75) {
            this.aReferenceCache_75.removeSoftReferences();
        }
        local2 = this.aReferenceCache_76;
        synchronized (this.aReferenceCache_76) {
            this.aReferenceCache_76.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(ZI)V")
    public void method3059(@OriginalArg(0) boolean arg0) {
        if (arg0 != this.aBoolean267) {
            this.aBoolean267 = arg0;
            this.method3060();
        }
    }

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "(I)V")
    public void method3060() {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_73;
        synchronized (this.aReferenceCache_73) {
            this.aReferenceCache_73.reset();
        }
        local14 = this.aReferenceCache_74;
        synchronized (this.aReferenceCache_74) {
            this.aReferenceCache_74.reset();
        }
        local14 = this.aReferenceCache_75;
        synchronized (this.aReferenceCache_75) {
            this.aReferenceCache_75.reset();
        }
        local14 = this.aReferenceCache_76;
        synchronized (this.aReferenceCache_76) {
            this.aReferenceCache_76.reset();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(IZ)V")
    public void method3061(@OriginalArg(1) boolean arg0) {
        if (arg0 != this.aBoolean266) {
            this.aBoolean266 = arg0;
            this.method3060();
        }
    }

    @OriginalMember(owner = "client!gea", name = "a", descriptor = "(II)V")
    public void method3062(@OriginalArg(1) int arg0) {
        this.aReferenceCache_73 = new ReferenceCache(arg0);
    }

    @OriginalMember(owner = "client!gea", name = "d", descriptor = "(II)Lclient!c;")
    public LocType list(@OriginalArg(0) int id, @OriginalArg(1) int arg1) {
        if (arg1 <= 29) {
            return null;
        }
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
        local22.anInt1256 = id;
        local22.aLocTypeList_2 = this;
        local22.aStringArray6 = (String[]) this.aStringArray15.clone();
        if (local49 != null) {
            local22.method1305(new Packet(local49));
        }
        local22.method1306();
        if (local22.aBoolean97) {
            local22.anInt1242 = 0;
            local22.aBoolean99 = false;
        }
        if (!this.aBoolean267 && local22.aBoolean95) {
            local22.aStringArray6 = null;
            local22.anIntArray112 = null;
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
        local11 = this.aReferenceCache_74;
        synchronized (this.aReferenceCache_74) {
            this.aReferenceCache_74.clean(5);
        }
        local11 = this.aReferenceCache_75;
        synchronized (this.aReferenceCache_75) {
            this.aReferenceCache_75.clean(5);
        }
        local11 = this.aReferenceCache_76;
        synchronized (this.aReferenceCache_76) {
            this.aReferenceCache_76.clean(5);
        }
    }

    @OriginalMember(owner = "client!gea", name = "b", descriptor = "(II)V")
    public void setFeatureMask(@OriginalArg(0) int arg0) {
        this.anInt3390 = arg0;
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_74;
        synchronized (this.aReferenceCache_74) {
            this.aReferenceCache_74.reset();
        }
        local9 = this.aReferenceCache_75;
        synchronized (this.aReferenceCache_75) {
            this.aReferenceCache_75.reset();
        }
        local9 = this.aReferenceCache_76;
        synchronized (this.aReferenceCache_76) {
            this.aReferenceCache_76.reset();
        }
    }
}
