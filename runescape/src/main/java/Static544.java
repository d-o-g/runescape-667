import com.jagex.ChangeLocationRequest;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static544 {

    @OriginalMember(owner = "client!rc", name = "a", descriptor = "(Lclient!hma;ZI)V")
    public static void method7214(@OriginalArg(0) ChangeLocationRequest arg0, @OriginalArg(1) boolean arg1) {
        if (arg0.aBoolean309) {
            if (arg0.originalId < 0 || Static235.method3424(arg0.originalId, arg0.originalShape)) {
                if (arg1) {
                    Static706.method9220(arg0.layer, null, arg0.z, arg0.anInt4010, arg0.x);
                } else {
                    Static235.method3421(arg0.z, arg0.originalShape, arg0.originalRotation, arg0.x, -1, arg0.layer, arg0.anInt4010, arg0.originalId);
                }
                arg0.unlink();
            }
        } else if (arg0.aBoolean310 && arg0.x >= 1 && arg0.z >= 1 && Static720.mapWidth - 2 >= arg0.x && Static501.mapHeight - 2 >= arg0.z && (arg0.anInt4014 < 0 || Static235.method3424(arg0.anInt4014, arg0.anInt4013))) {
            if (arg1) {
                Static706.method9220(arg0.layer, arg0.customisation, arg0.z, arg0.anInt4010, arg0.x);
            } else {
                Static235.method3421(arg0.z, arg0.anInt4013, arg0.anInt4012, arg0.x, -1, arg0.layer, arg0.anInt4010, arg0.anInt4014);
            }
            arg0.aBoolean310 = false;
            if (!arg1 && arg0.originalId == arg0.anInt4014 && arg0.originalId == -1) {
                arg0.unlink();
            } else if (!arg1 && arg0.originalId == arg0.anInt4014 && arg0.anInt4012 == arg0.originalRotation && arg0.anInt4013 == arg0.originalShape) {
                arg0.unlink();
            }
        }
    }
}
