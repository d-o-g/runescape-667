import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static249 {

    @OriginalMember(owner = "client!hma", name = "B", descriptor = "I")
    public static int anInt4008 = 0;

    @OriginalMember(owner = "client!hma", name = "k", descriptor = "I")
    public static int anInt4018 = 0;

    @OriginalMember(owner = "client!hma", name = "a", descriptor = "(IBIIIII)V")
    public static void method3535(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        @Pc(11) int local11 = Static670.method8732(Static724.anInt10930, Static273.anInt4395, arg1);
        @Pc(17) int local17 = Static670.method8732(Static724.anInt10930, Static273.anInt4395, arg3);
        @Pc(23) int local23 = Static670.method8732(Static180.anInt2995, Static111.anInt2219, arg4);
        @Pc(29) int local29 = Static670.method8732(Static180.anInt2995, Static111.anInt2219, arg2);
        @Pc(38) int local38 = Static670.method8732(Static724.anInt10930, Static273.anInt4395, arg1 + arg0);
        @Pc(47) int local47 = Static670.method8732(Static724.anInt10930, Static273.anInt4395, arg3 - arg0);
        for (@Pc(49) int local49 = local11; local49 < local38; local49++) {
            Static696.method9037(local29, arg5, local23, Static723.anIntArrayArray266[local49]);
        }
        for (@Pc(78) int local78 = local17; local78 > local47; local78--) {
            Static696.method9037(local29, arg5, local23, Static723.anIntArrayArray266[local78]);
        }
        @Pc(104) int local104 = Static670.method8732(Static180.anInt2995, Static111.anInt2219, arg4 + arg0);
        @Pc(113) int local113 = Static670.method8732(Static180.anInt2995, Static111.anInt2219, arg2 - arg0);
        for (@Pc(115) int local115 = local38; local115 <= local47; local115++) {
            @Pc(123) int[] local123 = Static723.anIntArrayArray266[local115];
            Static696.method9037(local104, arg5, local23, local123);
            Static696.method9037(local29, arg5, local113, local123);
        }
    }

    @OriginalMember(owner = "client!hma", name = "a", descriptor = "(BLclient!pg;)I")
    public static int method3536(@OriginalArg(1) DoublyLinkedNode_Sub2_Sub16 arg0) {
        @Pc(15) String local15 = Static518.method9293(arg0);
        @Pc(17) int[] local17 = null;
        if (Static245.method8635(arg0.anInt7314)) {
            local17 = ObjTypeList.instance.list((int) arg0.aLong233).quests;
        } else if (arg0.anInt7317 != -1) {
            local17 = ObjTypeList.instance.list(arg0.anInt7317).quests;
        } else if (Static598.method7825(arg0.anInt7314)) {
            @Pc(51) Node_Sub45 local51 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((int) arg0.aLong233);
            if (local51 != null) {
                @Pc(56) NPCEntity local56 = local51.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                @Pc(59) NPCType local59 = local56.type;
                if (local59.multinpcs != null) {
                    local59 = local59.getMultiNPC(TimedVarDomain.instance);
                }
                if (local59 != null) {
                    local17 = local59.quests;
                }
            }
        } else if (Static523.method3444(arg0.anInt7314)) {
            @Pc(89) LocType local89 = LocTypeList.instance.list((int) (arg0.aLong233 >>> 32 & 0x7FFFFFFFL));
            if (local89.multiLocs != null) {
                local89 = local89.getMultiLoc(TimedVarDomain.instance);
            }
            if (local89 != null) {
                local17 = local89.quests;
            }
        }
        if (local17 != null) {
            local15 = local15 + Static72.method1527(local17);
        }
        @Pc(130) int local130 = Fonts.b12Metrics.stringWidth(Static186.aSpriteArray5, local15);
        if (arg0.aBoolean553) {
            local130 += Static517.aSprite_32.getWidth() + 4;
        }
        return local130;
    }

    @OriginalMember(owner = "client!hma", name = "a", descriptor = "(BZ)Z")
    public static boolean method3537(@OriginalArg(1) boolean arg0) {
        @Pc(13) boolean local13 = Toolkit.active.method8014();
        if (local13 == arg0) {
            return true;
        }
        if (!arg0) {
            Toolkit.active.method7980();
        } else if (!Toolkit.active.method7970()) {
            arg0 = false;
        }
        if (arg0 == local13) {
            return false;
        } else {
            ClientOptions.instance.update(arg0 ? 1 : 0, ClientOptions.instance.bloom);
            ClientOptions.save();
            return true;
        }
    }

    @OriginalMember(owner = "client!hma", name = "a", descriptor = "(Z)V")
    public static void method3538() {
        Static408.method5632();
    }
}
