import com.jagex.core.util.SystemTimer;
import rs2.client.loading.LoadState;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static709 {

    @OriginalMember(owner = "client!wh", name = "F", descriptor = "I")
    public static int anInt10669 = 1;

    @OriginalMember(owner = "client!wh", name = "a", descriptor = "(IZIILclient!qha;)Lclient!gb;")
    public static Class93_Sub2_Sub1 method9251(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Toolkit_Sub3 arg3) {
        if (arg3.aBoolean597 || Static700.method9150(arg1) && Static700.method9150(arg0)) {
            return new Class93_Sub2_Sub1(arg3, 3553, arg2, arg1, arg0);
        } else if (arg3.aBoolean595) {
            return new Class93_Sub2_Sub1(arg3, 34037, arg2, arg1, arg0);
        } else {
            return new Class93_Sub2_Sub1(arg3, arg2, arg1, arg0, IntMath.nextPow2(arg1), IntMath.nextPow2(arg0));
        }
    }

    @OriginalMember(owner = "client!wh", name = "g", descriptor = "(I)V")
    public static void method9252() {
        if (Static655.aLoadStateArray1 == null) {
            Static655.aLoadStateArray1 = LoadState.method2955();
            Static473.aLoadState_22 = Static655.aLoadStateArray1[0];
            Static72.aLong52 = SystemTimer.safetime();
        }
        if (Static449.aClass364_1 == null) {
            Static229.method3368();
        }
        @Pc(27) LoadState local27 = Static473.aLoadState_22;
        @Pc(35) int local35 = Static523.method3448();
        if (Static473.aLoadState_22 == local27) {
            Static579.aString106 = Static473.aLoadState_22.stalledText.localise(client.language);
            if (Static473.aLoadState_22.updatePercentage) {
                Static376.anInt5919 = Static473.aLoadState_22.startPercentage + local35 * (Static473.aLoadState_22.endPercentage - Static473.aLoadState_22.startPercentage) / 100;
            }
            if (Static473.aLoadState_22.displayPercentage) {
                Static579.aString106 = Static579.aString106 + Static376.anInt5919 + "%";
            }
        } else if (LoadState.COMPLETE == Static473.aLoadState_22) {
            Static449.aClass364_1 = null;
            MainLogicManager.setStep(3);
        } else {
            Static579.aString106 = local27.changedText.localise(client.language);
            if (Static473.aLoadState_22.displayPercentage) {
                Static579.aString106 = Static579.aString106 + local27.endPercentage + "%";
            }
            Static376.anInt5919 = local27.endPercentage;
            if (Static473.aLoadState_22.updatePercentage || local27.updatePercentage) {
                Static72.aLong52 = SystemTimer.safetime();
            }
        }
        if (Static449.aClass364_1 == null) {
            return;
        }
        Static449.aClass364_1.method8374(Static376.anInt5919, Static579.aString106, Static473.aLoadState_22, Static72.aLong52);
        if (Static234.anInterface22Array1 == null) {
            return;
        }
        for (@Pc(157) int local157 = Static214.anInt3500 + 1; local157 < Static234.anInterface22Array1.length; local157++) {
            if (Static234.anInterface22Array1[local157].method8460() >= 100 && Static214.anInt3500 == local157 - 1 && MainLogicManager.step >= 1 && Static449.aClass364_1.method8376()) {
                try {
                    Static234.anInterface22Array1[local157].method8464();
                } catch (@Pc(197) Exception local197) {
                    Static234.anInterface22Array1 = null;
                    return;
                }
                Static449.aClass364_1.method8373(Static234.anInterface22Array1[local157]);
                Static214.anInt3500++;
                if (Static214.anInt3500 >= Static234.anInterface22Array1.length - 1 && Static234.anInterface22Array1.length > 1) {
                    Static214.anInt3500 = Static333.aClass279_1.method6276() ? 0 : -1;
                }
            }
        }
        return;
    }

}
