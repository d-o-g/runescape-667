import com.jagex.collect.key.Deque;
import com.jagex.graphics.Matrix;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static460 {

    @OriginalMember(owner = "client!oj", name = "l", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_10;

    @OriginalMember(owner = "client!oj", name = "j", descriptor = "[I")
    public static int[] anIntArray554;

    @OriginalMember(owner = "client!oj", name = "s", descriptor = "I")
    public static int anInt6970;

    @OriginalMember(owner = "client!oj", name = "t", descriptor = "I")
    public static int anInt6964 = 0;

    @OriginalMember(owner = "client!oj", name = "n", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___40 = new Deque();

    @OriginalMember(owner = "client!oj", name = "f", descriptor = "(I)I")
    public static int method6266() {
        if (Static213.anInt3470 == 0) {
            Static566.A_LOADING_REQUIREMENT___2.method7470(new Class64("jaclib"));
            if (Static566.A_LOADING_REQUIREMENT___2.method7469().method6465() != 100) {
                return 1;
            }
            if (!((Class64) Static566.A_LOADING_REQUIREMENT___2.method7469()).method1554()) {
                client.aClient1.method1644();
            }
            Static213.anInt3470 = 1;
        }
        @Pc(270) int local270;
        @Pc(292) int local292;
        @Pc(308) int local308;
        @Pc(314) int local314;
        if (Static213.anInt3470 == 1) {
            Static522.aLoadingRequirementArray1 = Static566.method7467();
            Static566.A_LOADING_REQUIREMENT___1.method7470(new Class137(js5.DEFAULTS));
            Static566.A_LOADING_REQUIREMENT___3.method7470(new Class64("jaggl"));
            Static566.A_LOADING_REQUIREMENT___4.method7470(new Class64("jagdx"));
            Static566.A_LOADING_REQUIREMENT___5.method7470(new Class64("jagmisc"));
            Static566.A_LOADING_REQUIREMENT___6.method7470(new Class64("sw3d"));
            Static566.A_LOADING_REQUIREMENT___7.method7470(new Class64("hw3d"));
            Static566.A_LOADING_REQUIREMENT___8.method7470(new Class64("jagtheora"));
            Static566.A_LOADING_REQUIREMENT___9.method7470(new Class137(Static124.aJs5_20));
            Static566.A_LOADING_REQUIREMENT___10.method7470(new Class137(Static199.aJs5_42));
            Static566.A_LOADING_REQUIREMENT___11.method7470(new Class137(Static6.aJs5_1));
            Static566.A_LOADING_REQUIREMENT___12.method7470(new Class137(Static459.aJs5_91));
            Static566.A_LOADING_REQUIREMENT___13.method7470(new Class137(Static20.aJs5_3));
            Static566.A_LOADING_REQUIREMENT___14.method7470(new Class137(Static333.aJs5_66));
            Static566.A_LOADING_REQUIREMENT___15.method7470(new Class137(Static380.aJs5_79));
            Static566.A_LOADING_REQUIREMENT___16.method7470(new Class137(Static668.aJs5_119));
            Static566.A_LOADING_REQUIREMENT___17.method7470(new Class137(Static271.aJs5_59));
            Static566.A_LOADING_REQUIREMENT___18.method7470(new Class137(Static233.aJs5_52));
            Static566.A_LOADING_REQUIREMENT___19.method7470(new Class137(Static58.aJs5_12));
            Static566.A_LOADING_REQUIREMENT___20.method7470(new Class137(Static244.aJs5_55));
            Static566.A_LOADING_REQUIREMENT___21.method7470(new Class137(js5.CONFIG_PARTICLE));
            Static566.A_LOADING_REQUIREMENT___22.method7470(new Class137(Static140.aJs5_24));
            Static566.A_LOADING_REQUIREMENT___23.method7470(new Class288(Static463.aJs5_93, "huffman"));
            Static566.A_LOADING_REQUIREMENT___24.method7470(new Class137(Static554.aJs5_105));
            Static566.A_LOADING_REQUIREMENT___25.method7470(new Class137(Static31.aJs5_6));
            Static566.A_LOADING_REQUIREMENT___26.method7470(new Class137(Static697.aJs5_123));
            Static566.A_LOADING_REQUIREMENT___27.method7470(new Class115(Static120.aJs5_19, "details"));
            for (local270 = 0; local270 < Static522.aLoadingRequirementArray1.length; local270++) {
                if (Static522.aLoadingRequirementArray1[local270].method7469() == null) {
                    throw new RuntimeException();
                }
            }
            local292 = 0;
            @Pc(294) LoadingRequirement[] local294 = Static522.aLoadingRequirementArray1;
            for (@Pc(296) int local296 = 0; local296 < local294.length; local296++) {
                @Pc(304) LoadingRequirement local304 = local294[local296];
                local308 = local304.method7471();
                local314 = local304.method7469().method6465();
                local292 += local314 * local308 / 100;
            }
            Static392.anInt6144 = local292;
            Static213.anInt3470 = 2;
        }
        if (Static522.aLoadingRequirementArray1 == null) {
            return 100;
        }
        local270 = 0;
        local292 = 0;
        @Pc(348) boolean local348 = true;
        @Pc(350) LoadingRequirement[] local350 = Static522.aLoadingRequirementArray1;
        for (@Pc(352) int local352 = 0; local352 < local350.length; local352++) {
            @Pc(358) LoadingRequirement local358 = local350[local352];
            local314 = local358.method7471();
            @Pc(370) int local370 = local358.method7469().method6465();
            local292 += local314 * local370 / 100;
            if (local370 < 100) {
                local348 = false;
            }
            local270 += local314;
        }
        if (local348) {
            if (!((Class64) Static566.A_LOADING_REQUIREMENT___5.method7469()).method1554()) {
                client.aClient1.method1634();
            }
            if (!((Class64) Static566.A_LOADING_REQUIREMENT___8.method7469()).method1554()) {
                Static234.aBoolean303 = client.aClient1.method1651();
            }
            Static522.aLoadingRequirementArray1 = null;
        }
        local292 -= Static392.anInt6144;
        local270 -= Static392.anInt6144;
        local308 = local270 > 0 ? local292 * 100 / local270 : 100;
        if (!local348 && local308 > 99) {
            local308 = 99;
        }
        return local308;
    }
}
