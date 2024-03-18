import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ts")
public final class Class361 {

    @OriginalMember(owner = "client!ts", name = "j", descriptor = "Lclient!cm;")
    public DoublyLinkedNode aClass2_Sub2_57 = new DoublyLinkedNode();

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "Lclient!jga;")
    public final Queue aQueue_15 = new Queue();

    @OriginalMember(owner = "client!ts", name = "h", descriptor = "I")
    public int anInt9483;

    @OriginalMember(owner = "client!ts", name = "g", descriptor = "I")
    public final int anInt9484;

    @OriginalMember(owner = "client!ts", name = "c", descriptor = "Lclient!av;")
    public final HashTable aHashTable_42;

    @OriginalMember(owner = "client!ts", name = "<init>", descriptor = "(I)V")
    public Class361(@OriginalArg(0) int arg0) {
        this.anInt9483 = arg0;
        this.anInt9484 = arg0;
        @Pc(19) int local19;
        for (local19 = 1; local19 + local19 < arg0; local19 += local19) {
        }
        this.aHashTable_42 = new HashTable(local19);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(BLclient!cm;J)V")
    public void method8341(@OriginalArg(1) DoublyLinkedNode arg0, @OriginalArg(2) long arg1) {
        if (this.anInt9483 == 0) {
            @Pc(19) DoublyLinkedNode local19 = this.aQueue_15.removeFirst();
            local19.remove();
            local19.remove2();
            if (this.aClass2_Sub2_57 == local19) {
                local19 = this.aQueue_15.removeFirst();
                local19.remove();
                local19.remove2();
            }
        } else {
            this.anInt9483--;
        }
        this.aHashTable_42.put(arg1, arg0);
        this.aQueue_15.add(arg0);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(JZ)Lclient!cm;")
    public DoublyLinkedNode method8342(@OriginalArg(0) long arg0) {
        @Pc(16) DoublyLinkedNode local16 = (DoublyLinkedNode) this.aHashTable_42.get(arg0);
        if (local16 != null) {
            this.aQueue_15.add(local16);
        }
        return local16;
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(IJ)V")
    public void method8344(@OriginalArg(1) long arg0) {
        @Pc(18) DoublyLinkedNode local18 = (DoublyLinkedNode) this.aHashTable_42.get(arg0);
        if (local18 != null) {
            local18.remove();
            local18.remove2();
            this.anInt9483++;
        }
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(B)V")
    public void method8345() {
        this.aQueue_15.clear();
        this.aHashTable_42.clear();
        this.aClass2_Sub2_57 = new DoublyLinkedNode();
        this.anInt9483 = this.anInt9484;
    }
}
