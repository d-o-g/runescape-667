import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.Loader;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!rr")
public final class LoadingRequirement {

    @OriginalMember(owner = "client!rr", name = "C", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_DEFAULTS = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "q", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_JACLIB = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "s", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_JAGGL = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "y", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_JAGDX = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "u", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_JAGMISC = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "b", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_SW3D = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "p", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_HW3D = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "Lclient!rr;")
    public static final LoadingRequirement NL_JAGTHEORA = new LoadingRequirement(LoadingRequirementType.NATIVE_LIBRARY);

    @OriginalMember(owner = "client!rr", name = "t", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_SHADERS = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "w", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_MATERIALS = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "H", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "g", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_LOC = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "n", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_ENUM = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "E", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_NPC = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "i", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_OBJ = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "z", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_SEQ = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "M", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_SPOT = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "c", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_STRUCT = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "K", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_QUICKCHAT = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "o", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_QUICKCHAT_GLOBAL = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "h", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_PARTICLE = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "e", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CONFIG_BILLBOARD = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "I", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5FILE_HUFFMAN = new LoadingRequirement(LoadingRequirementType.JS5_FILE);

    @OriginalMember(owner = "client!rr", name = "J", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_INTERFACES = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "k", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_CLIENTSCRIPTS = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "l", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5_FONTMETRICS = new LoadingRequirement(LoadingRequirementType.JS5);

    @OriginalMember(owner = "client!rr", name = "L", descriptor = "Lclient!rr;")
    public static final LoadingRequirement JS5GROUP_WORLDMAPDATA = new LoadingRequirement(LoadingRequirementType.JS5_GROUP);

    @OriginalMember(owner = "client!rr", name = "c", descriptor = "(I)[Lclient!rr;")
    public static LoadingRequirement[] values() {
        return new LoadingRequirement[]{
            JS5_DEFAULTS,
            NL_JACLIB,
            NL_JAGGL,
            NL_JAGDX,
            NL_JAGMISC,
            NL_SW3D,
            NL_HW3D,
            NL_JAGTHEORA,
            JS5_SHADERS,
            JS5_MATERIALS,
            JS5_CONFIG,
            JS5_CONFIG_LOC,
            JS5_CONFIG_ENUM,
            JS5_CONFIG_NPC,
            JS5_CONFIG_OBJ,
            JS5_CONFIG_SEQ,
            JS5_CONFIG_SPOT,
            JS5_CONFIG_STRUCT,
            JS5_QUICKCHAT,
            JS5_QUICKCHAT_GLOBAL,
            JS5_CONFIG_PARTICLE,
            JS5_CONFIG_BILLBOARD,
            JS5FILE_HUFFMAN,
            JS5_INTERFACES,
            JS5_CLIENTSCRIPTS,
            JS5_FONTMETRICS,
            JS5GROUP_WORLDMAPDATA
        };
    }

    @OriginalMember(owner = "client!rr", name = "f", descriptor = "Lclient!jma;")
    public Loader loader;

    @OriginalMember(owner = "client!rr", name = "r", descriptor = "Lclient!kf;")
    public final LoadingRequirementType type;

    @OriginalMember(owner = "client!rr", name = "B", descriptor = "I")
    public int size;

    @OriginalMember(owner = "client!rr", name = "<init>", descriptor = "(Lclient!kf;)V")
    public LoadingRequirement(@OriginalArg(0) LoadingRequirementType type) {
        this.type = type;
        this.size = 1;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(BI)V")
    public void setSize(@OriginalArg(1) int size) {
        this.size = size;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(B)Lclient!jma;")
    public Loader getLoader() {
        return this.loader;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(Lclient!jma;I)V")
    public void setLoader(@OriginalArg(0) Loader loader) {
        if (loader.type() != this.type) {
            throw new IllegalArgumentException();
        }
        this.loader = loader;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(I)I")
    public int getSize() {
        return this.size;
    }

    @OriginalMember(owner = "client!rr", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
