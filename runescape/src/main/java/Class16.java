import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!aka")
public final class Class16 {

    @OriginalMember(owner = "client!aka", name = "c", descriptor = "Lclient!jga;")
    public final Class192 aClass192_1 = new Class192();

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "I")
    public final int anInt246;

    @OriginalMember(owner = "client!aka", name = "i", descriptor = "I")
    public int anInt250;

    @OriginalMember(owner = "client!aka", name = "b", descriptor = "Lclient!av;")
    public final HashTable aHashTable_3;

    @OriginalMember(owner = "client!aka", name = "<init>", descriptor = "(I)V")
    public Class16(@OriginalArg(0) int arg0) {
        this.anInt246 = arg0;
        this.anInt250 = arg0;
        @Pc(16) int local16;
        for (local16 = 1; arg0 > local16 + local16; local16 += local16) {
        }
        this.aHashTable_3 = new HashTable(local16);
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ILclient!uq;)V")
    public void method251(@OriginalArg(1) Interface24 arg0) {
        @Pc(9) long local9 = arg0.method7433();
        for (@Pc(22) Node_Sub2_Sub11 local22 = (Node_Sub2_Sub11) this.aHashTable_3.get(local9); local22 != null; local22 = (Node_Sub2_Sub11) this.aHashTable_3.nextWithSameKey()) {
            if (local22.anInterface24_3.method7432(arg0)) {
                this.method254(local22);
                return;
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Z)V")
    public void method252() {
        this.aClass192_1.method4351();
        this.aHashTable_3.clear();
        this.anInt250 = this.anInt246;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(B)V")
    public void method253() {
        for (@Pc(5) Node_Sub2_Sub11 local5 = (Node_Sub2_Sub11) this.aClass192_1.method4352(); local5 != null; local5 = (Node_Sub2_Sub11) this.aClass192_1.method4350()) {
            if (local5.method8314()) {
                local5.remove();
                local5.method9260();
                this.anInt250 += local5.anInt9445;
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZLclient!pv;)V")
    public void method254(@OriginalArg(1) Node_Sub2_Sub11 arg0) {
        if (arg0 != null) {
            arg0.remove();
            arg0.method9260();
            this.anInt250 += arg0.anInt9445;
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZI)V")
    public void method255() {
        if (Static515.aClass22_1 == null) {
            return;
        }
        for (@Pc(11) Node_Sub2_Sub11 local11 = (Node_Sub2_Sub11) this.aClass192_1.method4352(); local11 != null; local11 = (Node_Sub2_Sub11) this.aClass192_1.method4350()) {
            if (local11.method8314()) {
                if (local11.method8311() == null) {
                    local11.remove();
                    local11.method9260();
                    this.anInt250 += local11.anInt9445;
                }
            } else if (++local11.aLong325 > (long) 5) {
                @Pc(38) Node_Sub2_Sub11 local38 = Static515.aClass22_1.method593(local11);
                this.aHashTable_3.put(local11.key, local38);
                Static409.method5654(local11, local38);
                local11.remove();
                local11.method9260();
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "b", descriptor = "(I)I")
    public int method256() {
        return this.anInt246;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(I)I")
    public int method257() {
        return this.anInt250;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZILjava/lang/Object;Lclient!uq;)V")
    public void method259(@OriginalArg(2) Object arg0, @OriginalArg(3) Interface24 arg1) {
        if (this.anInt246 < 1) {
            throw new IllegalStateException("s>cs");
        }
        this.method251(arg1);
        this.anInt250--;
        while (this.anInt250 < 0) {
            @Pc(42) Node_Sub2_Sub11 local42 = (Node_Sub2_Sub11) this.aClass192_1.method4346();
            this.method254(local42);
        }
        @Pc(59) Node_Sub2_Sub11_Sub2 local59 = new Node_Sub2_Sub11_Sub2(arg1, arg0, 1);
        this.aHashTable_3.put(arg1.method7433(), local59);
        this.aClass192_1.method4348(local59);
        local59.aLong325 = 0L;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Lclient!uq;B)Ljava/lang/Object;")
    public Object method260(@OriginalArg(0) Interface24 arg0) {
        @Pc(18) long local18 = arg0.method7433();
        for (@Pc(25) Node_Sub2_Sub11 local25 = (Node_Sub2_Sub11) this.aHashTable_3.get(local18); local25 != null; local25 = (Node_Sub2_Sub11) this.aHashTable_3.nextWithSameKey()) {
            if (local25.anInterface24_3.method7432(arg0)) {
                @Pc(39) Object local39 = local25.method8311();
                if (local39 != null) {
                    if (local25.method8314()) {
                        @Pc(84) Node_Sub2_Sub11_Sub2 local84 = new Node_Sub2_Sub11_Sub2(arg0, local39, local25.anInt9445);
                        this.aHashTable_3.put(local25.key, local84);
                        this.aClass192_1.method4348(local84);
                        local84.aLong325 = 0L;
                        local25.remove();
                        local25.method9260();
                    } else {
                        this.aClass192_1.method4348(local25);
                        local25.aLong325 = 0L;
                    }
                    return local39;
                }
                local25.remove();
                local25.method9260();
                this.anInt250 += local25.anInt9445;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Ljava/lang/Object;ILclient!uq;)V")
    public void method261(@OriginalArg(0) Object arg0, @OriginalArg(2) Interface24 arg1) {
        this.method259(arg0, arg1);
    }
}
