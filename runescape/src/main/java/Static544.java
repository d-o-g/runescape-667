import com.jagex.ChangeLocationRequest;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static544 {

    @OriginalMember(owner = "client!rc", name = "a", descriptor = "(Lclient!hma;ZI)V")
    public static void method7214(@OriginalArg(0) ChangeLocationRequest arg0, @OriginalArg(1) boolean arg1) {
        if (arg0.pendingRemoval) {
            if (arg0.originalId < 0 || Static235.loadedModels(arg0.originalId, arg0.originalShape)) {
                if (arg1) {
                    Static706.method9220(arg0.layer, null, arg0.z, arg0.level, arg0.x);
                } else {
                    Static235.setLocChange(arg0.x, arg0.z, arg0.level, arg0.originalId, arg0.originalShape, arg0.originalRotation, -1, arg0.layer);
                }
                arg0.unlink();
            }
        } else if (arg0.aBoolean310 && arg0.x >= 1 && arg0.z >= 1 && Static720.mapWidth - 2 >= arg0.x && Static501.mapLength - 2 >= arg0.z && (arg0.id < 0 || Static235.loadedModels(arg0.id, arg0.shape))) {
            if (arg1) {
                Static706.method9220(arg0.layer, arg0.customisation, arg0.z, arg0.level, arg0.x);
            } else {
                Static235.setLocChange(arg0.x, arg0.z, arg0.level, arg0.id, arg0.shape, arg0.rotation, -1, arg0.layer);
            }
            arg0.aBoolean310 = false;
            if (!arg1 && arg0.originalId == arg0.id && arg0.originalId == -1) {
                arg0.unlink();
            } else if (!arg1 && arg0.originalId == arg0.id && arg0.rotation == arg0.originalRotation && arg0.shape == arg0.originalShape) {
                arg0.unlink();
            }
        }
    }
}
