import com.jagex.core.datastruct.key.Node;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static2 {

    @OriginalMember(owner = "client!aaa", name = "a", descriptor = "(IBIILclient!cv;)V")
    public static void sortAllObjs(@OriginalArg(0) int level, @OriginalArg(3) int x, @OriginalArg(2) int z, @OriginalArg(4) ObjStackEntry entry) {
        @Pc(16) long key = (level << 28) | (z << 14) | x;
        @Pc(22) ObjStack stack = Static497.objStacks.get(key);
        if (stack == null) {
            stack = new ObjStack();
            Static497.objStacks.put(key, stack);
            stack.objs.addLast(entry);
            return;
        }
        @Pc(45) ObjType type = ObjTypeList.instance.list(entry.id);
        @Pc(48) int totalCost = type.cost;
        if (type.stackable == 1) {
            totalCost *= entry.count + 1;
        }
        for (@Pc(65) ObjStackEntry other = (ObjStackEntry) stack.objs.first(); other != null; other = (ObjStackEntry) stack.objs.next()) {
            type = ObjTypeList.instance.list(other.id);
            @Pc(78) int otherTotalCost = type.cost;
            if (type.stackable == 1) {
                otherTotalCost *= other.count + 1;
            }
            if (totalCost > otherTotalCost) {
                Node.addBefore(other, entry);
                return;
            }
        }
        stack.objs.addLast(entry);
    }

    @OriginalMember(owner = "client!aaa", name = "c", descriptor = "(III)Z")
    public static boolean method66(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (arg1 & 0x37) != 0;
    }
}
