import com.jagex.game.runetek6.config.objtype.ObjType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static2 {

    @OriginalMember(owner = "client!aaa", name = "U", descriptor = "I")
    public static int anInt45;

    @OriginalMember(owner = "client!aaa", name = "I", descriptor = "I")
    public static int anInt53;

    @OriginalMember(owner = "client!aaa", name = "L", descriptor = "Lclient!taa;")
    public static MapRegion aMapRegion;

    @OriginalMember(owner = "client!aaa", name = "T", descriptor = "Lclient!tka;")
    public static Class355 aClass355_1;

    @OriginalMember(owner = "client!aaa", name = "d", descriptor = "(III)V")
    public static void method62(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        @Pc(9) DoublyLinkedNode_Sub2__ local9 = Static440.method5963(6, (long) arg1);
        local9.method202();
        local9.primaryData = arg0;
    }

    @OriginalMember(owner = "client!aaa", name = "a", descriptor = "(IBIILclient!cv;)V")
    public static void sortAllObjs(@OriginalArg(0) int z, @OriginalArg(2) int level, @OriginalArg(3) int x, @OriginalArg(4) ObjStackEntry entry) {
        @Pc(16) long key = (level << 14) | (z << 28) | x;
        @Pc(22) ObjStack stack = (ObjStack) Static497.stacks.get(key);
        if (stack == null) {
            stack = new ObjStack();
            Static497.stacks.put(key, stack);
            stack.objs.addLast(entry);
            return;
        }
        @Pc(45) ObjType type = Static419.objTypeList.list(entry.id);
        @Pc(48) int totalCost = type.cost;
        if (type.stackable == 1) {
            totalCost *= entry.count + 1;
        }
        for (@Pc(65) ObjStackEntry other = (ObjStackEntry) stack.objs.first(); other != null; other = (ObjStackEntry) stack.objs.next()) {
            type = Static419.objTypeList.list(other.id);
            @Pc(78) int otherTotalCost = type.cost;
            if (type.stackable == 1) {
                otherTotalCost *= other.count + 1;
            }
            if (totalCost > otherTotalCost) {
                Static201.addBefore(other, entry);
                return;
            }
        }
        stack.objs.addLast(entry);
    }

    @OriginalMember(owner = "client!aaa", name = "b", descriptor = "(II)V")
    public static void method65(@OriginalArg(1) int arg0) {
        if (arg0 == 37) {
            Static30.aFloat106 = 3.0F;
        } else if (arg0 == 50) {
            Static30.aFloat106 = 4.0F;
        } else if (arg0 == 75) {
            Static30.aFloat106 = 6.0F;
        } else if (arg0 == 100) {
            Static30.aFloat106 = 8.0F;
        } else if (arg0 == 200) {
            Static30.aFloat106 = 16.0F;
        }
        Static558.anInt3181 = -1;
        Static558.anInt3181 = -1;
    }

    @OriginalMember(owner = "client!aaa", name = "c", descriptor = "(III)Z")
    public static boolean method66(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (arg1 & 0x37) != 0;
    }
}
