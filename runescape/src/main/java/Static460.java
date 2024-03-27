import com.jagex.graphics.Matrix;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.Js5GroupLoader;
import rs2.client.loading.Js5Loader;

public final class Static460 {

    @OriginalMember(owner = "client!oj", name = "l", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_10;

    @OriginalMember(owner = "client!oj", name = "s", descriptor = "I")
    public static int anInt6970;

    @OriginalMember(owner = "client!rr", name = "j", descriptor = "I")
    public static int anInt8472 = 0;

    @OriginalMember(owner = "client!oj", name = "f", descriptor = "(I)I")
    public static int method6266() {
        if (Static213.anInt3470 == 0) {
            LoadingRequirement.NL_JACLIB.setLoader(new LibraryLoader("jaclib"));
            if (LoadingRequirement.NL_JACLIB.getLoader().completePercentage() != 100) {
                return 1;
            }
            if (!((LibraryLoader) LoadingRequirement.NL_JACLIB.getLoader()).isDone()) {
                client.aClient1.load_jaclib();
            }
            Static213.anInt3470 = 1;
        }
        @Pc(270) int local270;
        @Pc(292) int local292;
        @Pc(308) int local308;
        @Pc(314) int local314;
        if (Static213.anInt3470 == 1) {
            Static522.aLoadingRequirementArray1 = LoadingRequirement.values();
            LoadingRequirement.JS5_DEFAULTS.setLoader(new Js5Loader(js5.DEFAULTS));
            LoadingRequirement.NL_JAGGL.setLoader(new LibraryLoader("jaggl"));
            LoadingRequirement.NL_JAGDX.setLoader(new LibraryLoader("jagdx"));
            LoadingRequirement.NL_JAGMISC.setLoader(new LibraryLoader("jagmisc"));
            LoadingRequirement.NL_SW3D.setLoader(new LibraryLoader("sw3d"));
            LoadingRequirement.NL_HW3D.setLoader(new LibraryLoader("hw3d"));
            LoadingRequirement.NL_JAGTHEORA.setLoader(new LibraryLoader("jagtheora"));
            LoadingRequirement.JS5_SHADERS.setLoader(new Js5Loader(js5.SHADERS));
            LoadingRequirement.JS5_MATERIALS.setLoader(new Js5Loader(js5.MATERIALS));
            LoadingRequirement.JS5_CONFIG.setLoader(new Js5Loader(js5.CONFIG));
            LoadingRequirement.JS5_CONFIG_LOC.setLoader(new Js5Loader(js5.CONFIG_LOC));
            LoadingRequirement.JS5_CONFIG_ENUM.setLoader(new Js5Loader(js5.CONFIG_ENUM));
            LoadingRequirement.JS5_CONFIG_NPC.setLoader(new Js5Loader(js5.CONFIG_NPC));
            LoadingRequirement.JS5_CONFIG_OBJ.setLoader(new Js5Loader(js5.CONFIG_OBJ));
            LoadingRequirement.JS5_CONFIG_SEQ.setLoader(new Js5Loader(js5.CONFIG_SEQ));
            LoadingRequirement.JS5_CONFIG_SPOT.setLoader(new Js5Loader(js5.CONFIG_SPOT));
            LoadingRequirement.JS5_CONFIG_STRUCT.setLoader(new Js5Loader(js5.CONFIG_STRUCT));
            LoadingRequirement.JS5_QUICKCHAT.setLoader(new Js5Loader(js5.QUICKCHAT));
            LoadingRequirement.JS5_QUICKCHAT_GLOBAL.setLoader(new Js5Loader(js5.QUICKCHAT_GLOBAL));
            LoadingRequirement.JS5_CONFIG_PARTICLE.setLoader(new Js5Loader(js5.CONFIG_PARTICLE));
            LoadingRequirement.JS5_CONFIG_BILLBOARD.setLoader(new Js5Loader(js5.CONFIG_BILLBOARD));
            LoadingRequirement.JS5FILE_HUFFMAN.setLoader(new Js5FileLoader(js5.BINARY, "huffman"));
            LoadingRequirement.JS5_INTERFACES.setLoader(new Js5Loader(js5.INTERFACES));
            LoadingRequirement.JS5_CLIENTSCRIPTS.setLoader(new Js5Loader(js5.CLIENTSCRIPTS));
            LoadingRequirement.JS5_FONTMETRICS.setLoader(new Js5Loader(js5.FONTMETRICS));
            LoadingRequirement.JS5GROUP_WORLDMAPDATA.setLoader(new Js5GroupLoader(js5.WORLDMAPDATA, "details"));
            for (local270 = 0; local270 < Static522.aLoadingRequirementArray1.length; local270++) {
                if (Static522.aLoadingRequirementArray1[local270].getLoader() == null) {
                    throw new RuntimeException();
                }
            }
            local292 = 0;
            @Pc(294) LoadingRequirement[] local294 = Static522.aLoadingRequirementArray1;
            for (@Pc(296) int local296 = 0; local296 < local294.length; local296++) {
                @Pc(304) LoadingRequirement local304 = local294[local296];
                local308 = local304.getSize();
                local314 = local304.getLoader().completePercentage();
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
            local314 = local358.getSize();
            @Pc(370) int local370 = local358.getLoader().completePercentage();
            local292 += local314 * local370 / 100;
            if (local370 < 100) {
                local348 = false;
            }
            local270 += local314;
        }
        if (local348) {
            if (!((LibraryLoader) LoadingRequirement.NL_JAGMISC.getLoader()).isDone()) {
                client.aClient1.load_jagmisc();
            }
            if (!((LibraryLoader) LoadingRequirement.NL_JAGTHEORA.getLoader()).isDone()) {
                VideoTypeList.loadedJagtheora = client.aClient1.load_jagtheora();
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
