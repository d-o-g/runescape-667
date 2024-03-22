import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static157 {

    @OriginalMember(owner = "client!eu", name = "bb", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___61 = new ServerProt(46, 3);

    @OriginalMember(owner = "client!eu", name = "f", descriptor = "(I)V")
    public static void method2560() {
        Static264.A_WEIGHTED_CACHE___235.reset();
        Static123.A_WEIGHTED_CACHE___53.reset();
    }

    @OriginalMember(owner = "client!eu", name = "a", descriptor = "(IIIILclient!nda;)V")
    public static void method2564(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) Class8_Sub2_Sub5 arg4) {
        @Pc(4) Class291 local4 = Static347.method5095(arg0, arg1, arg2);
        if (local4 == null) {
            return;
        }
        arg4.anInt10690 = (arg1 << Static52.anInt1066) + Static247.anInt3993;
        arg4.anInt10691 = arg3;
        arg4.anInt10694 = (arg2 << Static52.anInt1066) + Static247.anInt3993;
        local4.aClass8_Sub2_Sub5_1 = arg4;
        @Pc(36) int local36 = Static246.activeGround == Static693.aGroundArray2 ? 1 : 0;
        if (arg4.method9283()) {
            if (arg4.method9282(0)) {
                arg4.aRenderable_25 = Static398.aRenderableArray7[local36];
                Static398.aRenderableArray7[local36] = arg4;
                return;
            }
            arg4.aRenderable_25 = Static576.aRenderableArray9[local36];
            Static576.aRenderableArray9[local36] = arg4;
            Static75.aBoolean521 = true;
            return;
        }
        arg4.aRenderable_25 = Static468.aRenderableArray10[local36];
        Static468.aRenderableArray10[local36] = arg4;
    }
}
