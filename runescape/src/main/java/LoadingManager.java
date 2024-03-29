import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.loader.Js5FileLoader;
import rs2.client.loading.loader.Js5GroupLoader;
import rs2.client.loading.loader.Js5Loader;
import rs2.client.loading.loader.LibraryLoader;

public final class LoadingManager {

    @OriginalMember(owner = "client!gl", name = "h", descriptor = "I")
    public static int step = 0;

    @OriginalMember(owner = "client!qha", name = "jd", descriptor = "[Lclient!rr;")
    public static LoadingRequirement[] loadingRequirements;

    @OriginalMember(owner = "client!mf", name = "b", descriptor = "I")
    public static int preloadSize = 0;

    @OriginalMember(owner = "client!oj", name = "f", descriptor = "(I)I")
    public static int changeMainState() {
        if (step == 0) {
            LoadingRequirement.NL_JACLIB.setLoader(new LibraryLoader("jaclib"));
            if (LoadingRequirement.NL_JACLIB.getLoader().completePercentage() != 100) {
                return 1;
            }

            if (!((LibraryLoader) LoadingRequirement.NL_JACLIB.getLoader()).isDone()) {
                client.aClient1.load_jaclib();
            }

            step = 1;
        }

        if (step == 1) {
            loadingRequirements = LoadingRequirement.values();
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

            for (@Pc(270) int i = 0; i < loadingRequirements.length; i++) {
                if (loadingRequirements[i].getLoader() == null) {
                    throw new RuntimeException();
                }
            }

            @Pc(292) int loadedSize = 0;
            @Pc(294) LoadingRequirement[] requirements = loadingRequirements;
            for (@Pc(296) int i = 0; i < requirements.length; i++) {
                @Pc(304) LoadingRequirement requirement = requirements[i];
                @Pc(308) int size = requirement.getSize();
                @Pc(314) int percentage = requirement.getLoader().completePercentage();
                loadedSize += (percentage * size) / 100;
            }
            preloadSize = loadedSize;
            step = 2;
        }

        if (loadingRequirements == null) {
            return 100;
        }

        @Pc(270) int totalSize = 0;
        @Pc(292) int loadedSize = 0;
        @Pc(348) boolean done = true;
        @Pc(350) LoadingRequirement[] requirements = loadingRequirements;
        for (@Pc(352) int i = 0; i < requirements.length; i++) {
            @Pc(358) LoadingRequirement requirement = requirements[i];
            @Pc(314) int size = requirement.getSize();
            @Pc(370) int percentage = requirement.getLoader().completePercentage();
            loadedSize += size * percentage / 100;
            if (percentage < 100) {
                done = false;
            }
            totalSize += size;
        }

        if (done) {
            if (!((LibraryLoader) LoadingRequirement.NL_JAGMISC.getLoader()).isDone()) {
                client.aClient1.load_jagmisc();
            }
            if (!((LibraryLoader) LoadingRequirement.NL_JAGTHEORA.getLoader()).isDone()) {
                VideoTypeList.loadedJagtheora = client.aClient1.load_jagtheora();
            }
            loadingRequirements = null;
        }

        loadedSize -= preloadSize;
        totalSize -= preloadSize;
        @Pc(308) int percentage = totalSize > 0 ? loadedSize * 100 / totalSize : 100;
        if (!done && percentage > 99) {
            percentage = 99;
        }
        return percentage;
    }
}
