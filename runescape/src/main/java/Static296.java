import com.jagex.ChangeLocationRequest;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static296 {

    @OriginalMember(owner = "client!jh", name = "n", descriptor = "Lclient!sb;")
    public static js5 aJs5_61;

    @OriginalMember(owner = "client!jh", name = "e", descriptor = "Lclient!om;")
    public static final Class280 aClass280_5 = new Class280(2);

    @OriginalMember(owner = "client!jh", name = "k", descriptor = "I")
    public static int anInt4792 = 0;

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(Lclient!gp;BIIII)V")
    public static void method4361(@OriginalArg(0) LocTypeCustomisation arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        @Pc(15) ChangeLocationRequest local15 = null;
        for (@Pc(20) ChangeLocationRequest local20 = (ChangeLocationRequest) Static227.aDeque_18.first(); local20 != null; local20 = (ChangeLocationRequest) Static227.aDeque_18.next()) {
            if (local20.anInt4010 == arg1 && local20.anInt4016 == arg3 && local20.anInt4006 == arg4 && arg2 == local20.layer) {
                local15 = local20;
                break;
            }
        }
        if (local15 == null) {
            local15 = new ChangeLocationRequest();
            local15.anInt4010 = arg1;
            local15.anInt4016 = arg3;
            local15.anInt4006 = arg4;
            local15.layer = arg2;
            Static227.aDeque_18.addLast(local15);
        }
        local15.aBoolean309 = false;
        local15.customisation = arg0;
        local15.aBoolean310 = true;
    }

    @OriginalMember(owner = "client!jh", name = "b", descriptor = "(I)V")
    public static void updateFeatureMask() {
        @Pc(5) int featureMask = 0;
        if (Static400.instance.lightDetail.getValue() == 1) {
            featureMask |= 0x1;
            featureMask |= 0x10;
            featureMask |= 0x20;
            featureMask |= 0x2;
            featureMask |= 0x4;
        }
        if (Static400.instance.textures.value() == 0) {
            featureMask |= 0x40;
        }
        Static335.setFeatureMask(featureMask);
        Static354.aLocTypeList_4.setFeatureMask(featureMask);
        Static419.aObjTypeList_1.setFeatureMask(featureMask);
        Static690.aNPCTypeList_2.setFeatureMask(featureMask);
        Static23.aClass128_1.setFeatureMask(featureMask);
        Static41.setFeatureMask(featureMask);
        Static298.setFeatureMask(featureMask);
        PlayerModel.setFeatureMask(featureMask);
        Static170.setFeatureMask(featureMask);
        Static449.mapBuild();
    }
}
