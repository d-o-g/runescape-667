import com.jagex.Entity;
import com.jagex.PickableEntity;
import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.datastruct.Node;
import com.jagex.graphics.PickingCylinder;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kn")
public final class Class213 {

    @OriginalMember(owner = "client!kn", name = "a", descriptor = "Lclient!fla;")
    public final LinkedList aLinkedList_8 = new LinkedList();

    @OriginalMember(owner = "client!kn", name = "f", descriptor = "Z")
    public boolean aBoolean426 = false;

    @OriginalMember(owner = "client!kn", name = "<init>", descriptor = "(Z)V")
    public Class213(@OriginalArg(0) boolean arg0) {
        this.aBoolean426 = arg0;
    }

    @OriginalMember(owner = "client!kn", name = "a", descriptor = "(ILclient!pea;)V")
    public void method5008(@OriginalArg(1) PickableEntity arg0) {
        @Pc(6) Entity local6 = arg0.aEntity_18;
        @Pc(8) boolean local8 = true;
        @Pc(11) PickingCylinder[] local11 = arg0.pickingCylinders;
        for (@Pc(13) int local13 = 0; local13 < local11.length; local13++) {
            if (local11[local13].aBoolean352) {
                local8 = false;
                break;
            }
        }
        if (local8) {
            return;
        }
        @Pc(42) PickableEntity local42;
        if (this.aBoolean426) {
            for (local42 = (PickableEntity) this.aLinkedList_8.first(); local42 != null; local42 = (PickableEntity) this.aLinkedList_8.next()) {
                if (local42.aEntity_18 == local6) {
                    local42.unlink();
                    Static281.method4092(local42);
                }
            }
        }
        for (local42 = (PickableEntity) this.aLinkedList_8.first(); local42 != null; local42 = (PickableEntity) this.aLinkedList_8.next()) {
            if (local6.anInt10697 >= local42.aEntity_18.anInt10697) {
                Node.addBefore(local42, arg0);
                return;
            }
        }
        this.aLinkedList_8.add(arg0);
    }

    @OriginalMember(owner = "client!kn", name = "a", descriptor = "(B)V")
    public void method5010() {
        while (true) {
            @Pc(5) PickableEntity entity = (PickableEntity) this.aLinkedList_8.removeFirst();
            if (entity == null) {
                return;
            }
            entity.unlink();
            Static281.method4092(entity);
        }
    }
}
