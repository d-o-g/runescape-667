import com.jagex.core.datastruct.LinkedList;
import com.jagex.graphics.PickingCylinder;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static642 {

    @OriginalMember(owner = "client!uea", name = "a", descriptor = "(ZBI)Lclient!pea;")
    public static PickableEntity method8441(@OriginalArg(0) boolean arg0, @OriginalArg(2) int arg1) {
        @Pc(7) LinkedList[] local7 = Class43.A_ENTITY_LIST_ARRAY_1;
        synchronized (Class43.A_ENTITY_LIST_ARRAY_1) {
            @Pc(37) PickableEntity local37;
            if (Class43.A_ENTITY_LIST_ARRAY_1.length <= arg1 || Class43.A_ENTITY_LIST_ARRAY_1[arg1].isEmpty()) {
                local37 = new PickableEntity();
                local37.aPickingCylinderArray1 = new PickingCylinder[arg1];
                for (@Pc(43) int local43 = 0; local43 < arg1; local43++) {
                    local37.aPickingCylinderArray1[local43] = new PickingCylinder();
                }
            } else {
                local37 = (PickableEntity) Class43.A_ENTITY_LIST_ARRAY_1[arg1].last();
                local37.unlink();
                @Pc(78) int local78 = Static159.anIntArray245[arg1]--;
            }
            local37.aBoolean548 = arg0;
            return local37;
        }
    }
}
