import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static232 {

    @OriginalMember(owner = "client!hda", name = "Tc", descriptor = "Lclient!faa;")
    public static Class119 aClass119_1;

    @OriginalMember(owner = "client!hda", name = "id", descriptor = "I")
    public static int anInt3829;

    @OriginalMember(owner = "client!hda", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___103 = new ServerProt(38, 0);

    @OriginalMember(owner = "client!hda", name = "sd", descriptor = "I")
    public static int anInt3764 = 0;

    @OriginalMember(owner = "client!hda", name = "ob", descriptor = "Lclient!av;")
    public static final IterableHashTable A_HASH_TABLE___18 = new IterableHashTable(8);

    @OriginalMember(owner = "client!hda", name = "u", descriptor = "Lclient!mia;")
    public static final Class242 aClass242_6 = new Class242("", 21);

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Lclient!ha;IIIIILclient!pg;IIIII)V")
    public static void method3387(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) DoublyLinkedNode_Sub2_Sub16 arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
        if (arg9 < arg10 && arg1 + arg9 > arg10 && arg8 > arg4 - 13 && arg4 + 3 > arg8 && arg6.aBoolean552) {
            arg7 = arg5;
        }
        @Pc(49) int[] local49 = null;
        if (Static245.method8635(arg6.anInt7314)) {
            local49 = Static419.objTypeList.list((int) arg6.aLong233).quests;
        } else if (arg6.anInt7317 != -1) {
            local49 = Static419.objTypeList.list(arg6.anInt7317).quests;
        } else if (Static598.method7825(arg6.anInt7314)) {
            @Pc(110) Node_Sub45 local110 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) (int) arg6.aLong233);
            if (local110 != null) {
                @Pc(115) NPCEntity local115 = local110.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                @Pc(118) NPCType local118 = local115.type;
                if (local118.multinpcs != null) {
                    local118 = local118.getMultiNPC(TimedVarDomain.instance);
                }
                if (local118 != null) {
                    local49 = local118.quests;
                }
            }
        } else if (Static523.method3444(arg6.anInt7314)) {
            @Pc(87) LocType local87 = Static354.aLocTypeList_4.list((int) (arg6.aLong233 >>> 32 & 0x7FFFFFFFL));
            if (local87.multiLocs != null) {
                local87 = local87.getMultiLoc(TimedVarDomain.instance);
            }
            if (local87 != null) {
                local49 = local87.quests;
            }
        }
        @Pc(154) String local154 = Static518.method9293(arg6);
        if (local49 != null) {
            local154 = local154 + Static72.method1527(local49);
        }
        Fonts.b12.render(arg7, 0, arg4, local154, arg9 + 3, Static186.aSpriteArray5, Static460.anIntArray554);
        if (arg6.aBoolean553) {
            Static517.aSprite_32.render(arg9 + Fonts.b12Metrics.stringWidth(local154) + 5, arg4 + -12);
        }
    }

    @OriginalMember(owner = "client!hda", name = "c", descriptor = "(I)V")
    public static void method3392() {
        try {
            @Pc(14) int local14;
            if (Static96.anInt10171 == 1) {
                local14 = Static581.aClass2_Sub6_Sub1_3.method948();
                if (local14 > 0 && Static581.aClass2_Sub6_Sub1_3.method922()) {
                    local14 -= Static190.anInt3112;
                    if (local14 < 0) {
                        local14 = 0;
                    }
                    Static581.aClass2_Sub6_Sub1_3.method916(local14);
                    return;
                }
                Static581.aClass2_Sub6_Sub1_3.method912();
                Static581.aClass2_Sub6_Sub1_3.method927();
                Static12.aClass123_4 = null;
                Static62.aClass2_Sub8_3 = null;
                if (Static676.aJs5_121 == null) {
                    Static96.anInt10171 = 0;
                } else {
                    Static96.anInt10171 = 2;
                }
            }
            if (Static96.anInt10171 == 3) {
                local14 = Static581.aClass2_Sub6_Sub1_3.method948();
                if (local14 < Static24.anInt595 && Static581.aClass2_Sub6_Sub1_3.method922()) {
                    local14 += Static611.anInt9335;
                    if (local14 > Static24.anInt595) {
                        local14 = Static24.anInt595;
                    }
                    Static581.aClass2_Sub6_Sub1_3.method916(local14);
                } else {
                    Static611.anInt9335 = 0;
                    Static96.anInt10171 = 0;
                }
            }
        } catch (@Pc(103) Exception local103) {
            local103.printStackTrace();
            Static581.aClass2_Sub6_Sub1_3.method912();
            Static117.aClass2_Sub6_Sub1_2 = null;
            Static62.aClass2_Sub8_3 = null;
            Static96.anInt10171 = 0;
            Static676.aJs5_121 = null;
            Static12.aClass123_4 = null;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(I)Z")
    public static boolean method3400() {
        @Pc(10) Node_Sub57 local10 = (Node_Sub57) Static631.aDeque_78.first();
        if (local10 == null) {
            return false;
        }
        for (@Pc(23) int local23 = 0; local23 < local10.anInt10364; local23++) {
            if (local10.aSignedResourceArray1[local23] != null && local10.aSignedResourceArray1[local23].status == 0) {
                return false;
            }
            if (local10.aSignedResourceArray2[local23] != null && local10.aSignedResourceArray2[local23].status == 0) {
                return false;
            }
        }
        return true;
    }
}
