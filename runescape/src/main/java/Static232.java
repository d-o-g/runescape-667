import com.jagex.ServerProt;
import com.jagex.core.datastruct.key.IterableHashTable;
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
    public static final ClientTriggerType A_CLIENT_TRIGGER_TYPE___6 = new ClientTriggerType("", 21);

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
