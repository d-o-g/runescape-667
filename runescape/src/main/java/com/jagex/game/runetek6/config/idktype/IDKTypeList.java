package com.jagex.game.runetek6.config.idktype;

import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.idktype.IDKType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kr")
public final class IDKTypeList {

    @OriginalMember(owner = "client!kr", name = "n", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_115 = new ReferenceCache(64);

    @OriginalMember(owner = "client!kr", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_72;

    @OriginalMember(owner = "client!kr", name = "k", descriptor = "Lclient!sb;")
    public final js5 aJs5_71;

    @OriginalMember(owner = "client!kr", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public IDKTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_72 = arg3;
        this.aJs5_71 = arg2;
        this.aJs5_71.fileLimit(3);
    }

    @OriginalMember(owner = "client!kr", name = "d", descriptor = "(I)V")
    public void method5041() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_115;
        synchronized (this.aReferenceCache_115) {
            this.aReferenceCache_115.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(IB)Lclient!pka;")
    public IDKType list(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_115;
        @Pc(24) IDKType local24;
        synchronized (this.aReferenceCache_115) {
            local24 = (IDKType) this.aReferenceCache_115.get((long) arg0);
        }
        if (local24 != null) {
            return local24;
        }
        @Pc(38) js5 local38 = this.aJs5_71;
        @Pc(47) byte[] local47;
        synchronized (this.aJs5_71) {
            local47 = this.aJs5_71.getfile(arg0, 3);
        }
        local24 = new IDKType();
        local24.aIDKTypeList_4 = this;
        if (local47 != null) {
            local24.method6613(new Packet(local47));
        }
        @Pc(74) ReferenceCache local74 = this.aReferenceCache_115;
        synchronized (this.aReferenceCache_115) {
            this.aReferenceCache_115.put(local24, (long) arg0);
            return local24;
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(I)V")
    public void method5044() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_115;
        synchronized (this.aReferenceCache_115) {
            this.aReferenceCache_115.reset();
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(II)V")
    public void method5045() {
        @Pc(7) ReferenceCache local7 = this.aReferenceCache_115;
        synchronized (this.aReferenceCache_115) {
            this.aReferenceCache_115.clean(5);
        }
    }
}
