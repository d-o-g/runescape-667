import com.jagex.collect.HashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fca")
public final class Class123 {

    @OriginalMember(owner = "client!fca", name = "k", descriptor = "Lclient!av;")
    public final HashTable aHashTable_15 = new HashTable(256);

    @OriginalMember(owner = "client!fca", name = "c", descriptor = "Lclient!av;")
    public final HashTable aHashTable_16 = new HashTable(256);

    @OriginalMember(owner = "client!fca", name = "d", descriptor = "Lclient!sb;")
    public final js5 aJs5_31;

    @OriginalMember(owner = "client!fca", name = "i", descriptor = "Lclient!sb;")
    public final js5 aJs5_32;

    @OriginalMember(owner = "client!fca", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;)V")
    public Class123(@OriginalArg(0) js5 arg0, @OriginalArg(1) js5 arg1) {
        this.aJs5_31 = arg1;
        this.aJs5_32 = arg0;
    }

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "(III[I)Lclient!sq;")
    public Node_Sub49_Sub1 method2612(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int[] arg2) {
        @Pc(15) int local15 = arg0 ^ (arg1 >>> 12 | (arg1 & 0x10000FFF) << 4);
        @Pc(27) int local27 = local15 | arg1 << 16;
        @Pc(30) long local30 = (long) local27;
        @Pc(37) Node_Sub49_Sub1 local37 = (Node_Sub49_Sub1) this.aHashTable_16.get(local30);
        if (local37 != null) {
            return local37;
        } else if (arg2 == null || arg2[0] > 0) {
            @Pc(62) Class89 local62 = Static729.method2245(this.aJs5_32, arg1, arg0);
            if (local62 == null) {
                return null;
            }
            local37 = local62.method2247();
            this.aHashTable_16.put(local30, local37);
            if (arg2 != null) {
                arg2[0] -= local37.aByteArray98.length;
            }
            return local37;
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "([IIIB)Lclient!sq;")
    public Node_Sub49_Sub1 method2613(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(15) int local15 = (arg1 >>> 12 | (arg1 & 0xB0000FFF) << 4) ^ arg2;
        @Pc(21) int local21 = local15 | arg1 << 16;
        @Pc(26) long local26 = (long) local21 ^ 0x100000000L;
        @Pc(33) Node_Sub49_Sub1 local33 = (Node_Sub49_Sub1) this.aHashTable_16.get(local26);
        if (local33 != null) {
            return local33;
        } else if (arg0 == null || arg0[0] > 0) {
            @Pc(59) Node_Sub53 local59 = (Node_Sub53) this.aHashTable_15.get(local26);
            if (local59 == null) {
                local59 = Static650.method8506(this.aJs5_31, arg1, arg2);
                if (local59 == null) {
                    return null;
                }
                this.aHashTable_15.put(local26, local59);
            }
            local33 = local59.method8502(arg0);
            if (local33 == null) {
                return null;
            } else {
                local59.remove();
                this.aHashTable_16.put(local26, local33);
                return local33;
            }
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "(Z[II)Lclient!sq;")
    public Node_Sub49_Sub1 method2614(@OriginalArg(1) int[] arg0, @OriginalArg(2) int arg1) {
        if (this.aJs5_32.groupSize() == 1) {
            return this.method2612(arg1, 0, arg0);
        } else if (this.aJs5_32.fileLimit(arg1) == 1) {
            return this.method2612(0, arg1, arg0);
        } else {
            throw new RuntimeException();
        }
    }

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "([IBI)Lclient!sq;")
    public Node_Sub49_Sub1 method2615(@OriginalArg(0) int[] arg0, @OriginalArg(2) int arg1) {
        if (this.aJs5_31.groupSize() == 1) {
            return this.method2613(arg0, 0, arg1);
        } else if (this.aJs5_31.fileLimit(arg1) == 1) {
            return this.method2613(arg0, arg1, 0);
        } else {
            throw new RuntimeException();
        }
    }
}
