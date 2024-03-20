package com.jagex.game.runetek6.config.npctype;

import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.LocalisedText;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ql")
public final class NPCTypeList {

    @OriginalMember(owner = "client!tg", name = "a", descriptor = "(ZI)I")
    public static int fileId(@OriginalArg(1) int arg0) {
        return arg0 & 0x7F;
    }

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(IB)I")
    public static int groupId(@OriginalArg(0) int arg0) {
        return arg0 >>> 7;
    }

    @OriginalMember(owner = "client!ql", name = "q", descriptor = "I")
    public int anInt8088;

    @OriginalMember(owner = "client!ql", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_169 = new ReferenceCache(64);

    @OriginalMember(owner = "client!ql", name = "i", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_170 = new ReferenceCache(50);

    @OriginalMember(owner = "client!ql", name = "r", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_171 = new ReferenceCache(5);

    @OriginalMember(owner = "client!ql", name = "g", descriptor = "Lclient!sb;")
    public final js5 aJs5_102;

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "Lclient!sb;")
    public final js5 aJs5_101;

    @OriginalMember(owner = "client!ql", name = "k", descriptor = "Z")
    public boolean aBoolean621;

    @OriginalMember(owner = "client!ql", name = "t", descriptor = "I")
    public final int anInt8086;

    @OriginalMember(owner = "client!ql", name = "o", descriptor = "Lclient!ul;")
    public final ModeGame aModeGame_6;

    @OriginalMember(owner = "client!ql", name = "s", descriptor = "[Ljava/lang/String;")
    public final String[] aStringArray39;

    @OriginalMember(owner = "client!ql", name = "<init>", descriptor = "(Lclient!ul;IZLclient!sb;Lclient!sb;)V")
    public NPCTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) js5 arg3, @OriginalArg(4) js5 arg4) {
        this.aJs5_102 = arg4;
        this.aJs5_101 = arg3;
        this.aBoolean621 = arg2;
        this.anInt8086 = arg1;
        this.aModeGame_6 = arg0;
        if (this.aJs5_101 != null) {
            @Pc(44) int local44 = this.aJs5_101.groupSize() - 1;
            this.aJs5_101.fileLimit(local44);
        }
        if (ModeGame.RUNESCAPE == this.aModeGame_6) {
            this.aStringArray39 = new String[]{null, null, null, null, null, LocalisedText.EXAMINE.localise(this.anInt8086)};
        } else {
            this.aStringArray39 = new String[]{null, null, null, null, null, null};
        }
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(II)V")
    public void method7085() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_169;
        synchronized (this.aReferenceCache_169) {
            this.aReferenceCache_169.clean(5);
        }
        local2 = this.aReferenceCache_170;
        synchronized (this.aReferenceCache_170) {
            this.aReferenceCache_170.clean(5);
        }
        local2 = this.aReferenceCache_171;
        synchronized (this.aReferenceCache_171) {
            this.aReferenceCache_171.clean(5);
        }
    }

    @OriginalMember(owner = "client!ql", name = "b", descriptor = "(B)V")
    public void method7086() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_169;
        synchronized (this.aReferenceCache_169) {
            this.aReferenceCache_169.reset();
        }
        local2 = this.aReferenceCache_170;
        synchronized (this.aReferenceCache_170) {
            this.aReferenceCache_170.reset();
        }
        local2 = this.aReferenceCache_171;
        synchronized (this.aReferenceCache_171) {
            this.aReferenceCache_171.reset();
        }
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(B)V")
    public void method7089() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_169;
        synchronized (this.aReferenceCache_169) {
            this.aReferenceCache_169.removeSoftReferences();
        }
        local2 = this.aReferenceCache_170;
        synchronized (this.aReferenceCache_170) {
            this.aReferenceCache_170.removeSoftReferences();
        }
        local2 = this.aReferenceCache_171;
        synchronized (this.aReferenceCache_171) {
            this.aReferenceCache_171.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(BZ)V")
    public void method7090(@OriginalArg(1) boolean arg0) {
        if (arg0 != this.aBoolean621) {
            this.aBoolean621 = arg0;
            this.method7086();
        }
    }

    @OriginalMember(owner = "client!ql", name = "c", descriptor = "(B)V")
    public void method7091() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_170;
        synchronized (this.aReferenceCache_170) {
            this.aReferenceCache_170.reset();
        }
        local2 = this.aReferenceCache_171;
        synchronized (this.aReferenceCache_171) {
            this.aReferenceCache_171.reset();
        }
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(IB)Lclient!o;")
    public NPCType list(@OriginalArg(0) int id) {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_169;
        @Pc(24) NPCType local24;
        synchronized (this.aReferenceCache_169) {
            local24 = (NPCType) this.aReferenceCache_169.get((long) id);
        }
        if (local24 != null) {
            return local24;
        }
        @Pc(38) js5 local38 = this.aJs5_101;
        @Pc(51) byte[] local51;
        synchronized (this.aJs5_101) {
            local51 = this.aJs5_101.getfile(fileId(id), groupId(id));
        }
        local24 = new NPCType();
        local24.aNPCTypeList_1 = this;
        local24.anInt6744 = id;
        local24.aStringArray34 = (String[]) this.aStringArray39.clone();
        if (local51 != null) {
            local24.method5986(new Packet(local51));
        }
        local24.method5983();
        @Pc(90) ReferenceCache local90 = this.aReferenceCache_169;
        synchronized (this.aReferenceCache_169) {
            this.aReferenceCache_169.put(local24, (long) id);
            return local24;
        }
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(ZI)V")
    public void setFeatureMask(@OriginalArg(1) int arg0) {
        this.anInt8088 = arg0;
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_170;
        synchronized (this.aReferenceCache_170) {
            this.aReferenceCache_170.reset();
        }
        local9 = this.aReferenceCache_171;
        synchronized (this.aReferenceCache_171) {
            this.aReferenceCache_171.reset();
        }
    }
}
