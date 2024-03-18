import com.jagex.collect.Node;
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
    public final ReferenceCache aReferenceCache_58 = new ReferenceCache(50);

    @OriginalMember(owner = "client!es", name = "f", descriptor = "Lclient!aka;")
    public final Class16 aClass16_1 = new Class16(250);

    @OriginalMember(owner = "client!es", name = "j", descriptor = "Lclient!rla;")
    public final Class324 aClass324_1 = new Class324();

    @OriginalMember(owner = "client!es", name = "m", descriptor = "I")
    public final int languageId;

    @OriginalMember(owner = "client!es", name = "w", descriptor = "Lclient!ul;")
    public final ModeGame aModeGame_1;

    @OriginalMember(owner = "client!es", name = "l", descriptor = "Lclient!sb;")
    public final js5 meshes;

    @OriginalMember(owner = "client!es", name = "q", descriptor = "Lclient!bo;")
    public final Class49 aClass49_1;

    @OriginalMember(owner = "client!es", name = "x", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!es", name = "i", descriptor = "Z")
    public boolean aBoolean222;

    @OriginalMember(owner = "client!es", name = "n", descriptor = "I")
    public final int anInt2670;

    @OriginalMember(owner = "client!es", name = "g", descriptor = "[Ljava/lang/String;")
    public final String[] aStringArray11;

    @OriginalMember(owner = "client!es", name = "y", descriptor = "[Ljava/lang/String;")
    public final String[] aStringArray10;

    @OriginalMember(owner = "client!es", name = "<init>", descriptor = "(Lclient!ul;IZLclient!bo;Lclient!sb;Lclient!sb;)V")
    public ObjTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Class49 arg3, @OriginalArg(4) js5 arg4, @OriginalArg(5) js5 arg5) {
        this.languageId = arg1;
        this.aModeGame_1 = arg0;
        this.meshes = arg5;
        this.aClass49_1 = arg3;
        this.configClient = arg4;
        this.aBoolean222 = arg2;
        if (this.configClient == null) {
            this.anInt2670 = 0;
        } else {
            @Pc(54) int local54 = this.configClient.method7597() - 1;
            this.anInt2670 = this.configClient.method7608(local54) + local54 * 256;
        }
        if (this.aModeGame_1 == ModeGame.RUNESCAPE) {
            this.aStringArray11 = new String[]{null, null, Static32.A_LOCALISED_TEXT___8.localise(this.languageId), null, null, Static32.A_LOCALISED_TEXT___22.localise(this.languageId)};
        } else {
            this.aStringArray11 = new String[]{null, null, Static32.A_LOCALISED_TEXT___8.localise(this.languageId), null, null, null};
        }
        this.aStringArray10 = new String[]{null, null, null, null, Static32.A_LOCALISED_TEXT___9.localise(this.languageId)};
    }

    @OriginalMember(owner = "client!gu", name = "b", descriptor = "(ZI)I")
    public static int method9100(@OriginalArg(1) int arg0) {
        return arg0 & 0xFF;
    }

    @OriginalMember(owner = "client!sm", name = "a", descriptor = "(II)I")
    public static int method7781(@OriginalArg(1) int arg0) {
        return arg0 >>> 8;
    }

    @OriginalMember(owner = "client!es", name = "b", descriptor = "(B)V")
    public void method2476() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local6 = this.aReferenceCache_58;
        synchronized (this.aReferenceCache_58) {
            this.aReferenceCache_58.reset();
        }
        @Pc(44) Class16 local44 = this.aClass16_1;
        synchronized (this.aClass16_1) {
            this.aClass16_1.method252();
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
            @Pc(136) Class324 local136 = new Class324();
            local136.anInt8435 = arg8;
            local136.aBoolean641 = arg3 != null;
            local136.anInt8432 = arg2.index;
            local136.anInt8430 = arg6;
            local136.anInt8434 = arg0;
            local136.anInt8433 = arg10;
            local136.anInt8436 = arg5;
            this.aClass16_1.method261(local119, local136);
        }
        return local119;
    }

    @OriginalMember(owner = "client!es", name = "c", descriptor = "(II)V")
    public void method2479() {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(5);
        }
        local14 = this.aReferenceCache_58;
        synchronized (this.aReferenceCache_58) {
            this.aReferenceCache_58.clean(5);
        }
        @Pc(48) Class16 local48 = this.aClass16_1;
        synchronized (this.aClass16_1) {
            this.aClass16_1.method255();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(B)V")
    public void method2480() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local6 = this.aReferenceCache_58;
        synchronized (this.aReferenceCache_58) {
            this.aReferenceCache_58.removeSoftReferences();
        }
        @Pc(44) Class16 local44 = this.aClass16_1;
        synchronized (this.aClass16_1) {
            this.aClass16_1.method253();
        }
    }

    @OriginalMember(owner = "client!es", name = "b", descriptor = "(II)V")
    public void setFeatureMask(@OriginalArg(0) int arg0) {
        this.anInt2673 = arg0;
        @Pc(17) ReferenceCache local17 = this.aReferenceCache_58;
        synchronized (this.aReferenceCache_58) {
            this.aReferenceCache_58.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(I)V")
    public void method2482() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_58;
        synchronized (this.aReferenceCache_58) {
            this.aReferenceCache_58.reset();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(Lclient!ju;BLclient!ha;IIIII)Lclient!st;")
    public Sprite method2483(@OriginalArg(0) PlayerModel arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        this.aClass324_1.anInt8430 = arg5;
        this.aClass324_1.anInt8432 = arg1.index;
        this.aClass324_1.anInt8435 = arg2;
        this.aClass324_1.anInt8436 = arg6;
        this.aClass324_1.aBoolean641 = arg0 != null;
        this.aClass324_1.anInt8434 = arg4;
        this.aClass324_1.anInt8433 = arg3;
        return (Sprite) this.aClass16_1.method260(this.aClass324_1);
    }

    @OriginalMember(owner = "client!es", name = "c", descriptor = "(I)V")
    public void method2484() {
        @Pc(6) Class16 local6 = this.aClass16_1;
        synchronized (this.aClass16_1) {
            this.aClass16_1.method252();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(BZ)V")
    public void method2485(@OriginalArg(1) boolean arg0) {
        if (this.aBoolean222 != arg0) {
            this.aBoolean222 = arg0;
            this.method2476();
        }
    }

    @OriginalMember(owner = "client!es", name = "a", descriptor = "(II)Lclient!vfa;")
    public ObjType list(@OriginalArg(0) int arg0) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        @Pc(26) ObjType type;

        synchronized (this.recentUse) {
            type = (ObjType) this.recentUse.get((long) arg0);
        }
        if (type != null) {
            return type;
        }

        @Pc(40) js5 local40 = this.configClient;
        @Pc(53) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(method9100(arg0), method7781(arg0));
        }

        type = new ObjType();
        type.anInt10134 = arg0;
        type.myList = this;
        type.op = (String[]) this.aStringArray11.clone();
        type.iop = (String[]) this.aStringArray10.clone();
        if (data != null) {
            type.method8791(new Packet(data));
        }
        type.method8807();
        if (type.certtemplate != -1) {
            type.method8793(this.list(type.certtemplate), this.list(type.certlink));
        }
        if (type.lenttemplate != -1) {
            type.method8792(this.list(type.lentlink), this.list(type.lenttemplate));
        }
        if (type.boughttemplate != -1) {
            type.method8809(this.list(type.boughttemplate), this.list(type.boughtlink));
        }
        if (!this.aBoolean222 && type.members) {
            type.name = Static32.A_LOCALISED_TEXT___5.localise(this.languageId);
            type.op = this.aStringArray11;
            type.iop = this.aStringArray10;
            type.quests = null;
            type.team = 0;
            type.stockmarket = false;
            if (type.params != null) {
                @Pc(195) boolean local195 = false;
                for (@Pc(200) Node local200 = type.params.first(); local200 != null; local200 = type.params.next()) {
                    @Pc(209) Class296 local209 = this.aClass49_1.method1161((int) local200.key);
                    if (local209.aBoolean570) {
                        local200.remove();
                    } else {
                        local195 = true;
                    }
                }
                if (!local195) {
                    type.params = null;
                }
            }
        }
        @Pc(238) ReferenceCache local238 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, (long) arg0);
            return type;
        }
    }
}
