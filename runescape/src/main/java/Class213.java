import com.jagex.collect.LinkedList;
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
    public void method5008(@OriginalArg(1) Class8_Sub7 arg0) {
        @Pc(6) Renderable local6 = arg0.aRenderable_18;
        @Pc(8) boolean local8 = true;
        @Pc(11) PickingCylinder[] local11 = arg0.aPickingCylinderArray1;
        for (@Pc(13) int local13 = 0; local13 < local11.length; local13++) {
            if (local11[local13].aBoolean352) {
                local8 = false;
                break;
            }
        }
        if (local8) {
            return;
        }
        @Pc(42) Class8_Sub7 local42;
        if (this.aBoolean426) {
            for (local42 = (Class8_Sub7) this.aLinkedList_8.first(); local42 != null; local42 = (Class8_Sub7) this.aLinkedList_8.next()) {
                if (local42.aRenderable_18 == local6) {
                    local42.unlink();
                    Static281.method4092(local42);
                }
            }
        }
        for (local42 = (Class8_Sub7) this.aLinkedList_8.first(); local42 != null; local42 = (Class8_Sub7) this.aLinkedList_8.next()) {
            if (local6.anInt10697 >= local42.aRenderable_18.anInt10697) {
                Static370.method5282(arg0, local42);
                return;
            }
        }
        this.aLinkedList_8.remove(arg0);
    }

    @OriginalMember(owner = "client!kn", name = "a", descriptor = "(B)V")
    public void method5010() {
        while (true) {
            @Pc(5) Class8_Sub7 local5 = (Class8_Sub7) this.aLinkedList_8.removeFirst();
            if (local5 == null) {
                return;
            }
            local5.unlink();
            Static281.method4092(local5);
        }
    }
}
