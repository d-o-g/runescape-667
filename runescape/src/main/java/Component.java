import com.jagex.IndexedImage;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.StringNode;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.Animator;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.graphics.Font;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.particles.ModelParticleEmitter;
import com.jagex.graphics.particles.ModelParticleEffector;
import com.jagex.graphics.Model;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.skybox.SkyBox;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hda")
public final class Component {

    static final int OBJ_TYPE_NONE = 0;
    static final int OBJ_TYPE_MODEL = 1;
    static final int OBJ_TYPE_NPCHEAD = 2;
    static final int OBJ_TYPE_PLAYERHEAD = 3;
    static final int OBJ_TYPE_OBJMODEL = 4;
    static final int OBJ_TYPE_PLAYERMODEL = 5;
    static final int OBJ_TYPE_NPCMODEL = 6;
    static final int OBJ_TYPE_PLAYERHEAD_IGNOREWORN = 7;
    static final int OBJ_TYPE_INVENTORY_MALE = 8;
    static final int OBJ_TYPE_INVENTORY_FEMALE = 9;

    static final int TYPE_LAYER = 0;
    static final int TYPE_INVENTORY = 2;
    static final int TYPE_RECTANGLE = 3;
    static final int TYPE_TEXT = 4;
    static final int TYPE_GRAPHIC = 5;
    static final int TYPE_MODEL = 6;
    static final int TYPE_LINE = 9;

    @OriginalMember(owner = "client!rc", name = "o", descriptor = "Z")
    public static boolean redrawAll = false;

    @OriginalMember(owner = "client!dga", name = "n", descriptor = "I")
    public static int featureMask;

    @OriginalMember(owner = "client!ov", name = "c", descriptor = "Lclient!dla;")
    public static final ReferenceCache sprites = new ReferenceCache(3000000, 200);

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "Lclient!dla;")
    public static final ReferenceCache models = new ReferenceCache(50);

    @OriginalMember(owner = "client!od", name = "l", descriptor = "Lclient!dla;")
    public static final ReferenceCache graphics = new ReferenceCache(8);

    @OriginalMember(owner = "client!o", name = "x", descriptor = "Lclient!dla;")
    public static final ReferenceCache skyBoxes = new ReferenceCache(4);

    @OriginalMember(owner = "client!ica", name = "m", descriptor = "Lclient!sb;")
    public static js5 spritesJs5;

    @OriginalMember(owner = "client!tca", name = "Fi", descriptor = "Lclient!sb;")
    public static js5 modelsJs5;

    @OriginalMember(owner = "client!vba", name = "M", descriptor = "Lclient!sb;")
    public static js5 interfacesJs5;

    @OriginalMember(owner = "client!kk", name = "a", descriptor = "(II)V")
    public static void setFeatureMask(@OriginalArg(1) int featureMask) {
        Component.featureMask = featureMask;
        models.reset();
    }

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "(IB)V")
    public static void cacheClean(@OriginalArg(0) int maxAge) {
        sprites.clean(maxAge);
        models.clean(maxAge);
        graphics.clean(maxAge);
        skyBoxes.clean(maxAge);
    }

    @OriginalMember(owner = "client!vga", name = "c", descriptor = "(I)V")
    public static void cacheReset() {
        sprites.reset();
        models.reset();
        graphics.reset();
        skyBoxes.reset();
    }

    @OriginalMember(owner = "client!rv", name = "a", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        sprites.removeSoftReferences();
        models.removeSoftReferences();
        graphics.removeSoftReferences();
        skyBoxes.removeSoftReferences();
    }

    @OriginalMember(owner = "client!hda", name = "M", descriptor = "[Ljava/lang/Object;")
    public Object[] onRelease;

    @OriginalMember(owner = "client!hda", name = "Jc", descriptor = "[Ljava/lang/String;")
    public String[] ops;

    @OriginalMember(owner = "client!hda", name = "Ub", descriptor = "[Ljava/lang/Object;")
    public Object[] onVarcTransmit;

    @OriginalMember(owner = "client!hda", name = "ed", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!hda", name = "jd", descriptor = "[Ljava/lang/Object;")
    public Object[] onTimer;

    @OriginalMember(owner = "client!hda", name = "ud", descriptor = "[I")
    public int[] opKeyRates;

    @OriginalMember(owner = "client!hda", name = "Zb", descriptor = "[Ljava/lang/Object;")
    public Object[] onMouseOver;

    @OriginalMember(owner = "client!hda", name = "c", descriptor = "[Ljava/lang/Object;")
    public Object[] onDragComplete;

    @OriginalMember(owner = "client!hda", name = "eb", descriptor = "[Ljava/lang/Object;")
    public Object[] onSubChange;

    @OriginalMember(owner = "client!hda", name = "rb", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!hda", name = "Qc", descriptor = "I")
    public int skyBoxSphereOffsetX;

    @OriginalMember(owner = "client!hda", name = "mc", descriptor = "Lclient!hv;")
    public ParticleSystem particleSystem;

    @OriginalMember(owner = "client!hda", name = "bc", descriptor = "Z")
    public boolean flipHorizontal;

    @OriginalMember(owner = "client!hda", name = "Eb", descriptor = "[B")
    public byte[] opChars;

    @OriginalMember(owner = "client!hda", name = "mb", descriptor = "[Ljava/lang/Object;")
    public Object[] onChatTransmit;

    @OriginalMember(owner = "client!hda", name = "gc", descriptor = "[Ljava/lang/Object;")
    public Object[] onInvTransmit;

    @OriginalMember(owner = "client!hda", name = "ic", descriptor = "Z")
    public boolean flipVertical;

    @OriginalMember(owner = "client!hda", name = "wc", descriptor = "[Ljava/lang/Object;")
    public Object[] onStockTransmit;

    @OriginalMember(owner = "client!hda", name = "zc", descriptor = "I")
    public int serverTriggers;

    @OriginalMember(owner = "client!hda", name = "K", descriptor = "[Ljava/lang/Object;")
    public Object[] onOpT;

    @OriginalMember(owner = "client!hda", name = "m", descriptor = "[Ljava/lang/Object;")
    public Object[] onScrollWheel;

    @OriginalMember(owner = "client!hda", name = "s", descriptor = "Lclient!gu;")
    public Animator animator;

    @OriginalMember(owner = "client!hda", name = "hd", descriptor = "[Ljava/lang/Object;")
    public Object[] onClanChannelTransmit;

    @OriginalMember(owner = "client!hda", name = "ec", descriptor = "[Ljava/lang/Object;")
    public Object[] onLoad;

    @OriginalMember(owner = "client!hda", name = "Gc", descriptor = "I")
    public int skyBoxSphereOffsetZ;

    @OriginalMember(owner = "client!hda", name = "hb", descriptor = "I")
    public int anInt3786;

    @OriginalMember(owner = "client!hda", name = "Jb", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!hda", name = "Hc", descriptor = "[Ljava/lang/Object;")
    public Object[] onTargetEnter;

    @OriginalMember(owner = "client!hda", name = "W", descriptor = "[Ljava/lang/Object;")
    public Object[] onOp;

    @OriginalMember(owner = "client!hda", name = "o", descriptor = "[Ljava/lang/Object;")
    public Object[] onTargetLeave;

    @OriginalMember(owner = "client!hda", name = "Nb", descriptor = "[I")
    public int[] opKeysIgnoreHeld;

    @OriginalMember(owner = "client!hda", name = "bd", descriptor = "[Ljava/lang/Object;")
    public Object[] onClick;

    @OriginalMember(owner = "client!hda", name = "Rb", descriptor = "[Ljava/lang/Object;")
    public Object[] onVarcstrTransmit;

    @OriginalMember(owner = "client!hda", name = "od", descriptor = "[Ljava/lang/Object;")
    public Object[] onResize;

    @OriginalMember(owner = "client!hda", name = "B", descriptor = "[Ljava/lang/Object;")
    public Object[] onDialogAbort;

    @OriginalMember(owner = "client!hda", name = "H", descriptor = "Ljava/lang/String;")
    public String pauseText;

    @OriginalMember(owner = "client!hda", name = "rd", descriptor = "[S")
    public short[] recol_s;

    @OriginalMember(owner = "client!hda", name = "Yc", descriptor = "[Ljava/lang/Object;")
    public Object[] onStatTransmit;

    @OriginalMember(owner = "client!hda", name = "D", descriptor = "[I")
    public int[] statTriggers;

    @OriginalMember(owner = "client!hda", name = "Oc", descriptor = "[Lclient!hda;")
    public Component[] dynamicComponents;

    @OriginalMember(owner = "client!hda", name = "xd", descriptor = "I")
    public int skyBoxSphereOffsetY;

    @OriginalMember(owner = "client!hda", name = "fd", descriptor = "[Ljava/lang/Object;")
    public Object[] onKey;

    @OriginalMember(owner = "client!hda", name = "sb", descriptor = "[Ljava/lang/Object;")
    public Object[] onClanSettingsTransmit;

    @OriginalMember(owner = "client!hda", name = "v", descriptor = "[Ljava/lang/Object;")
    public Object[] onClickRepeat;

    @OriginalMember(owner = "client!hda", name = "Qb", descriptor = "[Lclient!hda;")
    public Component[] staticComponents;

    @OriginalMember(owner = "client!hda", name = "r", descriptor = "[I")
    public int[] varcstrTriggers;

    @OriginalMember(owner = "client!hda", name = "db", descriptor = "[B")
    public byte[] opKeys;

    @OriginalMember(owner = "client!hda", name = "Xc", descriptor = "[Ljava/lang/Object;")
    public Object[] onVarTransmit;

    @OriginalMember(owner = "client!hda", name = "V", descriptor = "[I")
    public int[] varclanTriggers;

    @OriginalMember(owner = "client!hda", name = "Bb", descriptor = "[Ljava/lang/Object;")
    public Object[] onMouseLeave;

    @OriginalMember(owner = "client!hda", name = "qd", descriptor = "Lclient!av;")
    public IterableHashTable params;

    @OriginalMember(owner = "client!hda", name = "tc", descriptor = "I")
    public int anInt3815;

    @OriginalMember(owner = "client!hda", name = "ac", descriptor = "[Ljava/lang/Object;")
    public Object[] onClanTransmit;

    @OriginalMember(owner = "client!hda", name = "Pb", descriptor = "[I")
    public int[] varcTriggers;

    @OriginalMember(owner = "client!hda", name = "z", descriptor = "[I")
    public int[] inventoryTriggers;

    @OriginalMember(owner = "client!hda", name = "yb", descriptor = "[Ljava/lang/Object;")
    public Object[] onMouseRepeat;

    @OriginalMember(owner = "client!hda", name = "ib", descriptor = "[S")
    public short[] retex_s;

    @OriginalMember(owner = "client!hda", name = "Ab", descriptor = "[I")
    public int[] varpTriggers;

    @OriginalMember(owner = "client!hda", name = "P", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!hda", name = "Dc", descriptor = "[Ljava/lang/Object;")
    public Object[] onFriendTransmit;

    @OriginalMember(owner = "client!hda", name = "x", descriptor = "[Ljava/lang/Object;")
    public Object[] onDrag;

    @OriginalMember(owner = "client!hda", name = "Fb", descriptor = "[Ljava/lang/Object;")
    public Object[] onCamFinished;

    @OriginalMember(owner = "client!hda", name = "Q", descriptor = "[Ljava/lang/Object;")
    public Object[] onHold;

    @OriginalMember(owner = "client!hda", name = "cc", descriptor = "[Ljava/lang/Object;")
    public Object[] onVarclanTransmit;

    @OriginalMember(owner = "client!hda", name = "wd", descriptor = "[Ljava/lang/Object;")
    public Object[] onMiscTransmit;

    @OriginalMember(owner = "client!hda", name = "Z", descriptor = "[I")
    public int[] opCursors;

    @OriginalMember(owner = "client!hda", name = "Mb", descriptor = "I")
    public int obj;

    @OriginalMember(owner = "client!hda", name = "L", descriptor = "Z")
    public boolean orthoView;

    @OriginalMember(owner = "client!hda", name = "nc", descriptor = "I")
    public int video = -1;

    @OriginalMember(owner = "client!hda", name = "U", descriptor = "I")
    public int modelOriginX = 0;

    @OriginalMember(owner = "client!hda", name = "Ob", descriptor = "I")
    public int targetEnterCursor = -1;

    @OriginalMember(owner = "client!hda", name = "Nc", descriptor = "Z")
    public boolean clicked = false;

    @OriginalMember(owner = "client!hda", name = "xb", descriptor = "I")
    public int lastInvUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "ad", descriptor = "Z")
    public boolean modelOrtho = false;

    @OriginalMember(owner = "client!hda", name = "Hb", descriptor = "I")
    public int modelAngleZ = 0;

    @OriginalMember(owner = "client!hda", name = "e", descriptor = "I")
    public int lineWidth = 1;

    @OriginalMember(owner = "client!hda", name = "vd", descriptor = "I")
    public int angle2d = 0;

    @OriginalMember(owner = "client!hda", name = "Wb", descriptor = "I")
    public int fontGraphic = -1;

    @OriginalMember(owner = "client!hda", name = "hc", descriptor = "Z")
    public boolean disableZBuffer = false;

    @OriginalMember(owner = "client!hda", name = "yd", descriptor = "Z")
    public boolean filled = false;

    @OriginalMember(owner = "client!hda", name = "Yb", descriptor = "I")
    public int baseWidth = 0;

    @OriginalMember(owner = "client!hda", name = "J", descriptor = "I")
    public int maxLines = 0;

    @OriginalMember(owner = "client!hda", name = "cb", descriptor = "B")
    public byte sizeTypeHorizontal = 0;

    @OriginalMember(owner = "client!hda", name = "n", descriptor = "I")
    public int positionX = 0;

    @OriginalMember(owner = "client!hda", name = "t", descriptor = "I")
    public int mouseOverCursor = -1;

    @OriginalMember(owner = "client!hda", name = "Lb", descriptor = "Ljava/lang/String;")
    public String opBase = "";

    @OriginalMember(owner = "client!hda", name = "Ed", descriptor = "B")
    public byte sizeTypeVertical = 0;

    @OriginalMember(owner = "client!hda", name = "Mc", descriptor = "I")
    public int lastVarclanUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "sc", descriptor = "Z")
    public boolean clickMask = true;

    @OriginalMember(owner = "client!hda", name = "nd", descriptor = "I")
    public int transparency = 0;

    @OriginalMember(owner = "client!hda", name = "l", descriptor = "I")
    public int colour = 0;

    @OriginalMember(owner = "client!hda", name = "bb", descriptor = "I")
    public int id = -1;

    @OriginalMember(owner = "client!hda", name = "lb", descriptor = "I")
    public int lastScriptTransmit = -1;

    @OriginalMember(owner = "client!hda", name = "yc", descriptor = "I")
    public int modelAnimation = -1;

    @OriginalMember(owner = "client!hda", name = "Ib", descriptor = "I")
    public int dragDeadTime = 0;

    @OriginalMember(owner = "client!hda", name = "Tb", descriptor = "I")
    public int shadow = 0;

    @OriginalMember(owner = "client!hda", name = "Fc", descriptor = "I")
    public int anInt3736 = 0;

    @OriginalMember(owner = "client!hda", name = "gb", descriptor = "I")
    public int objNumMode = 2;

    @OriginalMember(owner = "client!hda", name = "I", descriptor = "Z")
    public boolean hasOpKey = false;

    @OriginalMember(owner = "client!hda", name = "zd", descriptor = "Z")
    public boolean hasHook = false;

    @OriginalMember(owner = "client!hda", name = "Sb", descriptor = "I")
    public int outline = 0;

    @OriginalMember(owner = "client!hda", name = "td", descriptor = "Ljava/lang/String;")
    public String targetVerb = "";

    @OriginalMember(owner = "client!hda", name = "S", descriptor = "I")
    public int aspectRatioWidth = 1;

    @OriginalMember(owner = "client!hda", name = "gd", descriptor = "I")
    public int lineHeight = 0;

    @OriginalMember(owner = "client!hda", name = "pb", descriptor = "Z")
    public boolean hovered = false;

    @OriginalMember(owner = "client!hda", name = "vb", descriptor = "I")
    public int slot = -1;

    @OriginalMember(owner = "client!hda", name = "Cb", descriptor = "I")
    public int modelAngleY = 0;

    @OriginalMember(owner = "client!hda", name = "Ac", descriptor = "I")
    public int modelAngleX = 0;

    @OriginalMember(owner = "client!hda", name = "b", descriptor = "I")
    public int invObject = -1;

    @OriginalMember(owner = "client!hda", name = "oc", descriptor = "I")
    public int graphic = -1;

    @OriginalMember(owner = "client!hda", name = "Lc", descriptor = "Z")
    public boolean lineDirection = false;

    @OriginalMember(owner = "client!hda", name = "dd", descriptor = "B")
    public byte posTypeHorizontal = 0;

    @OriginalMember(owner = "client!hda", name = "Uc", descriptor = "I")
    public int scrollX = 0;

    @OriginalMember(owner = "client!hda", name = "vc", descriptor = "I")
    public int dragDeadZone = 0;

    @OriginalMember(owner = "client!hda", name = "qb", descriptor = "I")
    public int lastStatUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "wb", descriptor = "I")
    public int modelZoom = 100;

    @OriginalMember(owner = "client!hda", name = "qc", descriptor = "Z")
    public boolean transparent = false;

    @OriginalMember(owner = "client!hda", name = "ld", descriptor = "I")
    public int scrollHeight = 0;

    @OriginalMember(owner = "client!hda", name = "O", descriptor = "Z")
    public boolean textShadow = false;

    @OriginalMember(owner = "client!hda", name = "Cd", descriptor = "I")
    public int verticalAlignment = 0;

    @OriginalMember(owner = "client!hda", name = "Db", descriptor = "I")
    public int lastVarpUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "h", descriptor = "I")
    public int scrollY = 0;

    @OriginalMember(owner = "client!hda", name = "f", descriptor = "Ljava/lang/String;")
    public String text = "";

    @OriginalMember(owner = "client!hda", name = "Vb", descriptor = "Z")
    public boolean fontMonospaced = true;

    @OriginalMember(owner = "client!hda", name = "ab", descriptor = "I")
    public int positionY = 0;

    @OriginalMember(owner = "client!hda", name = "g", descriptor = "I")
    public int aspectRatioHeight = 1;

    @OriginalMember(owner = "client!hda", name = "Kc", descriptor = "I")
    public int scrollWidth = 0;

    @OriginalMember(owner = "client!hda", name = "ub", descriptor = "I")
    public int invCount = 0;

    @OriginalMember(owner = "client!hda", name = "jc", descriptor = "I")
    public int anInt3800 = 0;

    @OriginalMember(owner = "client!hda", name = "md", descriptor = "I")
    public int targetOpCursor = -1;

    @OriginalMember(owner = "client!hda", name = "A", descriptor = "I")
    public int width = 0;

    @OriginalMember(owner = "client!hda", name = "Cc", descriptor = "I")
    public int horizontalAlignment = 0;

    @OriginalMember(owner = "client!hda", name = "Vc", descriptor = "I")
    public int height = 0;

    @OriginalMember(owner = "client!hda", name = "y", descriptor = "I")
    public int lastVarcUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "jb", descriptor = "I")
    public int objType = OBJ_TYPE_MODEL;

    @OriginalMember(owner = "client!hda", name = "w", descriptor = "Lclient!ofa;")
    public ServerActiveProperties serverActiveProperties = ServerActiveProperties.DEFAULT;

    @OriginalMember(owner = "client!hda", name = "Ec", descriptor = "I")
    public int clientcode = 0;

    @OriginalMember(owner = "client!hda", name = "Rc", descriptor = "I")
    public int anInt3804 = 0;

    @OriginalMember(owner = "client!hda", name = "Pc", descriptor = "I")
    public int baseHeight = 0;

    @OriginalMember(owner = "client!hda", name = "nb", descriptor = "I")
    public int anInt3825 = 0;

    @OriginalMember(owner = "client!hda", name = "E", descriptor = "I")
    public int objData = -1;

    @OriginalMember(owner = "client!hda", name = "zb", descriptor = "I")
    public int layer = -1;

    @OriginalMember(owner = "client!hda", name = "R", descriptor = "I")
    public int lastVarcstrUpdate = 0;

    @OriginalMember(owner = "client!hda", name = "Kb", descriptor = "I")
    public int lastUpdate = -1;

    @OriginalMember(owner = "client!hda", name = "Ad", descriptor = "Lclient!hda;")
    public Component aComponent_6 = null;

    @OriginalMember(owner = "client!hda", name = "d", descriptor = "I")
    public int rectangle = -1;

    @OriginalMember(owner = "client!hda", name = "lc", descriptor = "Z")
    public boolean noClickThrough = false;

    @OriginalMember(owner = "client!hda", name = "fc", descriptor = "Z")
    public boolean hidden = false;

    @OriginalMember(owner = "client!hda", name = "xc", descriptor = "I")
    public int basePosX = 0;

    @OriginalMember(owner = "client!hda", name = "kb", descriptor = "Z")
    public boolean tiled = false;

    @OriginalMember(owner = "client!hda", name = "Xb", descriptor = "I")
    public int skyBox = -1;

    @OriginalMember(owner = "client!hda", name = "G", descriptor = "I")
    public int modelOriginY = 0;

    @OriginalMember(owner = "client!hda", name = "Wc", descriptor = "I")
    public int dragRenderBehaviour = DragRender.OFFSET_TRANSPARENT;

    @OriginalMember(owner = "client!hda", name = "N", descriptor = "Z")
    public boolean objWearCol = false;

    @OriginalMember(owner = "client!hda", name = "cd", descriptor = "B")
    public byte postTypeVertical = 0;

    @OriginalMember(owner = "client!hda", name = "Gb", descriptor = "I")
    public int basePosY = 0;

    @OriginalMember(owner = "client!hda", name = "kc", descriptor = "I")
    public int modelOriginZ = 0;

    @OriginalMember(owner = "client!hda", name = "T", descriptor = "I")
    public int targetEndCursor = -1;

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(ZLclient!ha;)Lclient!st;")
    public Sprite sprite(@OriginalArg(1) Toolkit toolkit) {
        redrawAll = false;

        @Pc(54) long key = ((long) this.graphic)
            + ((this.transparent ? 1L : 0L) << 35)
            + ((long) this.outline << 36)
            + ((this.flipHorizontal ? 1L : 0L) << 38)
            + ((this.flipVertical ? 1L : 0L) << 39)
            + ((long) this.shadow << 40);

        @Pc(60) Sprite sprite = (Sprite) sprites.get(key);
        if (sprite != null) {
            return sprite;
        }

        @Pc(71) IndexedImage image = IndexedImage.loadFirst(spritesJs5, this.graphic, 0);
        if (image == null) {
            redrawAll = true;
            return null;
        }

        if (this.flipHorizontal) {
            image.flipHorizontally();
        }

        if (this.flipVertical) {
            image.flipVertically();
        }

        if (this.outline > 0) {
            image.scale(this.outline);
        } else if (this.shadow != 0) {
            image.scale(1);
        }

        if (this.outline >= 1) {
            image.setOutlineColour(0x1);
        }
        if (this.outline >= 2) {
            image.setOutlineColour(0xFFFFFF);
        }
        if (this.shadow != 0) {
            image.setShadowColour(this.shadow | 0xFF000000);
        }

        sprite = toolkit.createSprite(image, true);
        sprites.put(key, sprite, sprite.getWidth() * sprite.getHeight() * 4);
        return sprite;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Lclient!ha;Lclient!ka;ILclient!tt;I)V")
    public void method3384(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) Model model, @OriginalArg(3) Matrix matrix, @OriginalArg(4) int arg3) {
        model.apply(matrix);
        @Pc(9) ModelParticleEmitter[] emitters = model.particleEmitters();
        @Pc(22) ModelParticleEffector[] effectors = model.particleEffectors();
        if ((this.particleSystem == null || this.particleSystem.removed) && (emitters != null || effectors != null)) {
            this.particleSystem = ParticleSystem.create(arg3, false);
        }
        if (this.particleSystem != null) {
            this.particleSystem.update(toolkit, arg3, emitters, effectors);
        }
    }

    @OriginalMember(owner = "client!hda", name = "b", descriptor = "(III)V")
    public void setParam(@OriginalArg(0) int id, @OriginalArg(2) int value) {
        if (this.params == null) {
            this.params = new IterableHashTable(16);
            this.params.put(id, new IntNode(value));
            return;
        }

        @Pc(34) IntNode param = (IntNode) this.params.get(id);
        if (param == null) {
            this.params.put(id, new IntNode(value));
        } else {
            param.value = value;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(ZLclient!ge;)[Ljava/lang/Object;")
    public Object[] decodeComponentHook(@OriginalArg(1) Packet packet) {
        @Pc(7) int count = packet.g1();
        if (count == 0) {
            return null;
        }

        @Pc(18) Object[] args = new Object[count];
        for (@Pc(20) int i = 0; i < count; i++) {
            @Pc(25) int type = packet.g1();

            if (type == 0) {
                args[i] = Integer.valueOf(packet.g4());
            } else if (type == 1) {
                args[i] = packet.gjstr();
            }
        }

        this.hasHook = true;
        return args;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(SIIS)V")
    public void setRetex(@OriginalArg(0) short source, @OriginalArg(2) int index, @OriginalArg(3) short destination) {
        if (index >= 5) {
            return;
        }

        if (this.retex_s == null) {
            this.retex_d = new short[5];
            this.retex_s = new short[5];
        }

        this.retex_s[index] = source;
        this.retex_d[index] = destination;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Ljava/lang/String;II)Ljava/lang/String;")
    public String param(@OriginalArg(0) String dflt, @OriginalArg(1) int id) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(17) StringNode param = (StringNode) this.params.get(id);
            return param == null ? dflt : param.value;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Lclient!ge;B)V")
    public void decode(@OriginalArg(0) Packet packet) {
        @Pc(7) int version = packet.g1();
        if (version == 255) {
            version = -1;
        }

        /* common */

        this.type = packet.g1();
        if ((this.type & 0x80) != 0) {
            this.type &= 0x7F;
            this.name = packet.gjstr();
        }

        this.clientcode = packet.g2();
        this.basePosX = packet.g2s();
        this.basePosY = packet.g2s();
        this.baseWidth = packet.g2();
        this.baseHeight = packet.g2();
        this.sizeTypeHorizontal = packet.g1b();
        this.sizeTypeVertical = packet.g1b();
        this.posTypeHorizontal = packet.g1b();
        this.postTypeVertical = packet.g1b();

        this.layer = packet.g2();
        if (this.layer == 65535) {
            this.layer = -1;
        } else {
            this.layer += this.slot & 0xFFFF0000;
        }

        @Pc(110) int flags = packet.g1();
        this.hidden = (flags & 0x1) != 0;
        if (version >= 0) {
            this.noClickThrough = (flags & 0x2) != 0;
        }

        /* specific */

        if (this.type == TYPE_LAYER) {
            this.scrollWidth = packet.g2();
            this.scrollHeight = packet.g2();

            if (version < 0) {
                this.noClickThrough = packet.g1() == 1;
            }
        }

        if (this.type == TYPE_GRAPHIC) {
            this.graphic = packet.g4();
            this.angle2d = packet.g2();
            @Pc(191) int spriteFlags = packet.g1();
            this.tiled = (spriteFlags & 0x1) != 0;
            this.transparent = (spriteFlags & 0x2) != 0;
            this.transparency = packet.g1();
            this.outline = packet.g1();
            this.shadow = packet.g4();
            this.flipHorizontal = packet.g1() == 1;
            this.flipVertical = packet.g1() == 1;
            this.colour = packet.g4();

            if (version >= 3) {
                this.clickMask = packet.g1() == 1;
            }
        }

        if (this.type == TYPE_MODEL) {
            this.objType = OBJ_TYPE_MODEL;
            this.obj = packet.g2();
            if (this.obj == 65535) {
                this.obj = -1;
            }

            @Pc(191) int modelFlags = packet.g1();
            this.modelOrtho = (modelFlags & 0x4) == 4;
            @Pc(326) boolean ortho2d = (modelFlags & 0x1) == 1;
            this.orthoView = (modelFlags & 0x2) == 2;
            this.disableZBuffer = (modelFlags & 0x8) == 8;

            if (ortho2d) {
                this.modelOriginX = packet.g2s();
                this.modelOriginY = packet.g2s();
                this.modelAngleX = packet.g2();
                this.modelAngleY = packet.g2();
                this.modelAngleZ = packet.g2();
                this.modelZoom = packet.g2();
            } else if (this.orthoView) {
                this.modelOriginX = packet.g2s();
                this.modelOriginY = packet.g2s();
                this.modelOriginZ = packet.g2s();
                this.modelAngleX = packet.g2();
                this.modelAngleY = packet.g2();
                this.modelAngleZ = packet.g2();
                this.modelZoom = packet.g2s();
            }

            this.modelAnimation = packet.g2();
            if (this.modelAnimation == 65535) {
                this.modelAnimation = -1;
            }

            if (this.sizeTypeHorizontal != 0) {
                this.anInt3800 = packet.g2();
            }

            if (this.sizeTypeVertical != 0) {
                this.anInt3825 = packet.g2();
            }
        }

        if (this.type == TYPE_TEXT) {
            this.fontGraphic = packet.g2();
            if (this.fontGraphic == 65535) {
                this.fontGraphic = -1;
            }

            if (version >= 2) {
                this.fontMonospaced = packet.g1() == 1;
            }

            this.text = packet.gjstr();
            this.lineHeight = packet.g1();
            this.horizontalAlignment = packet.g1();
            this.verticalAlignment = packet.g1();
            this.textShadow = packet.g1() == 1;
            this.colour = packet.g4();
            this.transparency = packet.g1();

            if (version >= 0) {
                this.maxLines = packet.g1();
            }
        }

        if (this.type == TYPE_RECTANGLE) {
            this.colour = packet.g4();
            this.filled = packet.g1() == 1;
            this.transparency = packet.g1();
        }

        if (this.type == TYPE_LINE) {
            this.lineWidth = packet.g1();
            this.colour = packet.g4();
            this.lineDirection = packet.g1() == 1;
        }

        /* active properties */

        @Pc(191) int events = packet.g3();

        @Pc(628) int opkeyRate = packet.g1();
        if (opkeyRate != 0) {
            this.opKeys = new byte[11];
            this.opChars = new byte[11];
            this.opKeyRates = new int[11];
            while (opkeyRate != 0) {
                @Pc(653) int index = (opkeyRate >> 4) - 1;
                opkeyRate = packet.g1() | opkeyRate << 8;
                opkeyRate &= 0xFFF;
                if (opkeyRate == 4095) {
                    opkeyRate = -1;
                }
                @Pc(674) byte opKey = packet.g1b();
                if (opKey != 0) {
                    this.hasOpKey = true;
                }
                @Pc(688) byte opChar = packet.g1b();
                this.opKeyRates[index] = opkeyRate;
                this.opKeys[index] = opKey;
                this.opChars[index] = opChar;
                opkeyRate = packet.g1();
            }
        }

        this.opBase = packet.gjstr();

        @Pc(653) int opFlags = packet.g1();
        @Pc(722) int opCount = opFlags & 0xF;
        if (opCount > 0) {
            this.ops = new String[opCount];

            for (@Pc(730) int i = 0; i < opCount; i++) {
                this.ops[i] = packet.gjstr();
            }
        }

        @Pc(750) int cursorCount = opFlags >> 4;
        if (cursorCount > 0) {
            @Pc(730) int count = packet.g1();

            this.opCursors = new int[count + 1];
            for (@Pc(767) int i = 0; i < this.opCursors.length; i++) {
                this.opCursors[i] = -1;
            }

            this.opCursors[count] = packet.g2();
        }

        if (cursorCount > 1) {
            @Pc(730) int i = packet.g1();
            this.opCursors[i] = packet.g2();
        }

        this.pauseText = packet.gjstr();
        if (this.pauseText.equals("")) {
            this.pauseText = null;
        }

        this.dragDeadZone = packet.g1();
        this.dragDeadTime = packet.g1();
        this.dragRenderBehaviour = packet.g1();

        this.targetVerb = packet.gjstr();

        @Pc(730) int targetParam = -1;
        if (ServerActiveProperties.targetMaskFrom(events) != 0) {
            targetParam = packet.g2();
            if (targetParam == 65535) {
                targetParam = -1;
            }

            this.targetEnterCursor = packet.g2();
            if (this.targetEnterCursor == 65535) {
                this.targetEnterCursor = -1;
            }

            this.targetEndCursor = packet.g2();
            if (this.targetEndCursor == 65535) {
                this.targetEndCursor = -1;
            }
        }

        if (version >= 0) {
            this.mouseOverCursor = packet.g2();
            if (this.mouseOverCursor == 65535) {
                this.mouseOverCursor = -1;
            }
        }

        this.serverActiveProperties = new ServerActiveProperties(events, targetParam);

        if (version >= 0) {
            @Pc(767) int intParamCount = packet.g1();
            for (@Pc(924) int i = 0; i < intParamCount; i++) {
                @Pc(929) int id = packet.g3();
                @Pc(933) int value = packet.g4();
                this.params.put(id, new IntNode(value));
            }

            @Pc(929) int stringParamCount = packet.g1();
            for (@Pc(933) int i = 0; i < stringParamCount; i++) {
                @Pc(958) int id = packet.g3();
                @Pc(962) String value = packet.gjstr2();
                this.params.put(id, new StringNode(value));
            }
        }

        this.onLoad = this.decodeComponentHook(packet);
        this.onMouseOver = this.decodeComponentHook(packet);
        this.onMouseLeave = this.decodeComponentHook(packet);
        this.onTargetLeave = this.decodeComponentHook(packet);
        this.onTargetEnter = this.decodeComponentHook(packet);
        this.onVarTransmit = this.decodeComponentHook(packet);
        this.onInvTransmit = this.decodeComponentHook(packet);
        this.onStatTransmit = this.decodeComponentHook(packet);
        this.onTimer = this.decodeComponentHook(packet);
        this.onOp = this.decodeComponentHook(packet);
        if (version >= 0) {
            this.onOpT = this.decodeComponentHook(packet);
        }
        this.onMouseRepeat = this.decodeComponentHook(packet);
        this.onClick = this.decodeComponentHook(packet);
        this.onClickRepeat = this.decodeComponentHook(packet);
        this.onRelease = this.decodeComponentHook(packet);
        this.onHold = this.decodeComponentHook(packet);
        this.onDrag = this.decodeComponentHook(packet);
        this.onDragComplete = this.decodeComponentHook(packet);
        this.onScrollWheel = this.decodeComponentHook(packet);
        this.onVarcTransmit = this.decodeComponentHook(packet);
        this.onVarcstrTransmit = this.decodeComponentHook(packet);
        this.varpTriggers = this.decodeTransmitList(packet);
        this.inventoryTriggers = this.decodeTransmitList(packet);
        this.statTriggers = this.decodeTransmitList(packet);
        this.varcTriggers = this.decodeTransmitList(packet);
        this.varcstrTriggers = this.decodeTransmitList(packet);
    }

    @OriginalMember(owner = "client!hda", name = "c", descriptor = "(Ljava/lang/String;II)V")
    public void setOpText(@OriginalArg(0) String text, @OriginalArg(1) int op) {
        if (this.ops == null || op >= this.ops.length) {
            @Pc(14) String[] ops = new String[op + 1];

            if (this.ops != null) {
                for (@Pc(19) int i = 0; i < this.ops.length; i++) {
                    ops[i] = this.ops[i];
                }
            }

            this.ops = ops;
        }

        this.ops[op] = text;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Lclient!ha;I)Lclient!he;")
    public Graphic graphic(@OriginalArg(0) Toolkit toolkit) {
        @Pc(15) long key = ((long) this.id & 0xFFFFFFFFL) | ((long) this.slot << 32);

        @Pc(21) Graphic graphic = (Graphic) graphics.get(key);
        if (graphic != null) {
            if (graphic.id != this.graphic) {
                graphic = null;
                graphics.remove(key);
            }
            if (graphic != null) {
                return graphic;
            }
        }

        @Pc(53) IndexedImage image = IndexedImage.loadFirst(spritesJs5, this.graphic, 0);
        if (image == null) {
            return null;
        }

        @Pc(77) int newWidth = image.offX1 + image.width + image.offX2;
        @Pc(86) int newHeight = image.height + image.offY1 + image.offY2;
        @Pc(89) int[] offsets = new int[newHeight];
        @Pc(92) int[] widths = new int[newHeight];

        for (@Pc(94) int y = 0; y < image.height; y++) {
            @Pc(97) int start = 0;
            for (@Pc(99) int x = 0; x < image.width; x++) {
                if (image.raster[x + (image.width * y)] != 0) {
                    start = x;
                    break;
                }
            }

            @Pc(121) int end = image.width;
            for (@Pc(126) int x = image.width - 1; x >= start; x--) {
                if (image.raster[x + (image.width * y)] != 0) {
                    end = x + 1;
                    break;
                }
            }

            offsets[image.offY1 + y] = image.offX1 + start;
            widths[image.offY1 + y] = end - start;
        }

        @Pc(180) ClippingMask mask = toolkit.createMask(newWidth, newHeight, offsets, widths);
        if (mask == null) {
            return null;
        }

        graphic = new Graphic(newWidth, newHeight, widths, offsets, mask, this.graphic);
        graphics.put(graphic, key);
        return graphic;
    }

    @OriginalMember(owner = "client!hda", name = "b", descriptor = "(Ljava/lang/String;II)V")
    public void setParam(@OriginalArg(0) String value, @OriginalArg(1) int id) {
        if (this.params == null) {
            this.params = new IterableHashTable(16);
            this.params.put(id, new StringNode(value));
            return;
        }

        @Pc(32) StringNode param = (StringNode) this.params.get(id);
        if (param == null) {
            this.params.put(id, new StringNode(value));
        } else {
            param.value = value;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(IIZ)V")
    public void setOpCursor(@OriginalArg(0) int op, @OriginalArg(1) int cursor) {
        if (this.opCursors == null || op >= this.opCursors.length) {
            @Pc(32) int[] opCursors = new int[op + 1];

            if (this.opCursors != null) {
                for (@Pc(37) int i = 0; i < this.opCursors.length; i++) {
                    opCursors[i] = this.opCursors[i];
                }
                for (@Pc(55) int i = this.opCursors.length; i < op; i++) {
                    opCursors[i] = -1;
                }
            }

            this.opCursors = opCursors;
        }

        this.opCursors[op] = cursor;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(BLclient!ge;)[I")
    public int[] decodeTransmitList(@OriginalArg(1) Packet packet) {
        @Pc(7) int count = packet.g1();
        if (count == 0) {
            return null;
        }

        @Pc(15) int[] triggers = new int[count];
        for (@Pc(23) int local23 = 0; local23 < count; local23++) {
            triggers[local23] = packet.g4();
        }

        return triggers;
    }

    @OriginalMember(owner = "client!hda", name = "b", descriptor = "(I)V")
    public void clearScriptHooks() {
        this.onOpT = null;
        this.onDialogAbort = null;
        this.onDragComplete = null;
        this.onRelease = null;
        this.inventoryTriggers = null;
        this.onTargetEnter = null;
        this.varcTriggers = null;
        this.onClick = null;
        this.varpTriggers = null;
        this.onVarcTransmit = null;
        this.onDrag = null;
        this.onResize = null;
        this.onScrollWheel = null;
        this.varcstrTriggers = null;
        this.onOp = null;
        this.onTargetLeave = null;
        this.onClanSettingsTransmit = null;
        this.onClanTransmit = null;
        this.onInvTransmit = null;
        this.onCamFinished = null;
        this.onHold = null;
        this.onMouseLeave = null;
        this.onMouseOver = null;
        this.onVarTransmit = null;
        this.statTriggers = null;
        this.onLoad = null;
        this.onStockTransmit = null;
        this.onKey = null;
        this.onSubChange = null;
        this.onFriendTransmit = null;
        this.onClickRepeat = null;
        this.onTimer = null;
        this.onChatTransmit = null;
        this.onStatTransmit = null;
        this.onMiscTransmit = null;
        this.onVarcstrTransmit = null;
        this.onMouseRepeat = null;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Lclient!ha;Lclient!gu;Lclient!qp;Lclient!kr;BLclient!bp;Lclient!ju;Lclient!uk;Lclient!ql;Lclient!es;ILclient!vk;)Lclient!ka;")
    public Model model(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) Animator animator, @OriginalArg(2) BASTypeList arg2, @OriginalArg(3) IDKTypeList idkTypeList, @OriginalArg(5) SeqTypeList seqTypeList, @OriginalArg(6) PlayerModel playerModel, @OriginalArg(7) VarDomain varDomain, @OriginalArg(8) NPCTypeList npcTypeList, @OriginalArg(9) ObjTypeList objTypeList, @OriginalArg(10) int functionMask, @OriginalArg(11) NPCTypeCustomisation npcTypeCustomisation) {
        redrawAll = false;

        if (this.objType == OBJ_TYPE_NONE) {
            return null;
        } else if (this.objType == OBJ_TYPE_MODEL && this.obj == -1) {
            return null;
        } else if (this.objType == OBJ_TYPE_MODEL) {
            int functionMaskBefore = functionMask;
            if (animator != null) {
                functionMask = animator.functionMask() | 0x800;
            }

            @Pc(53) long crc = -1L;
            @Pc(55) long[] crctable = Packet.crc64table;

            if (this.recol_s != null) {
                for (@Pc(60) int i = 0; i < this.recol_s.length; i++) {
                    crc = crc >>> 8 ^ crctable[(int) (((long) (this.recol_s[i] >> 8) ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) this.recol_s[i] ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) (this.recol_d[i] >> 8) ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) this.recol_d[i] ^ crc) & 0xFFL)];
                }
                functionMask |= 0x4000;
            }

            if (this.retex_s != null) {
                for (@Pc(60) int i = 0; i < this.retex_s.length; i++) {
                    crc = crc >>> 8 ^ crctable[(int) (((long) (this.retex_s[i] >> 8) ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) this.retex_s[i] ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) (this.retex_d[i] >> 8) ^ crc) & 0xFFL)];
                    crc = crc >>> 8 ^ crctable[(int) (((long) this.retex_d[i] ^ crc) & 0xFFL)];
                }
                functionMask |= 0x8000;
            }

            @Pc(271) long key = crc & 0x3FFFFFFFFFL | (long) this.obj << 38 | (long) this.objType << 54 | (long) toolkit.index << 59;
            @Pc(277) Model model = (Model) models.get(key);

            if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
                if (model != null) {
                    functionMask = toolkit.combineFunctionMasks(functionMask, model.ua());
                }

                @Pc(307) Mesh base = Mesh.load(this.obj, modelsJs5);
                if (base == null) {
                    redrawAll = true;
                    return null;
                }
                if (base.version < 13) {
                    base.upscale();
                }

                model = toolkit.createModel(base, functionMask, featureMask, 64, 768);

                if (this.recol_s != null) {
                    for (@Pc(339) int i = 0; i < this.recol_s.length; i++) {
                        model.ia(this.recol_s[i], this.recol_d[i]);
                    }
                }

                if (this.retex_s != null) {
                    for (@Pc(339) int i = 0; i < this.retex_s.length; i++) {
                        model.aa(this.retex_s[i], this.retex_d[i]);
                    }
                }

                models.put(model, key);
            }

            if (animator != null) {
                model = model.copy((byte) 1, functionMask, true);
                animator.animate(model, 0);
            }

            model.s(functionMaskBefore);
            return model;
        } else if (this.objType == OBJ_TYPE_NPCHEAD) {
            @Pc(438) Model model = npcTypeList.list(this.obj).headModel(functionMask, animator, npcTypeCustomisation, toolkit, varDomain);

            if (model == null) {
                redrawAll = true;
                return null;
            } else {
                return model;
            }
        } else if (this.objType == OBJ_TYPE_PLAYERHEAD) {
            if (playerModel == null) {
                return null;
            }

            @Pc(438) Model model = playerModel.wornHeadModel(idkTypeList, seqTypeList, varDomain, animator, objTypeList, npcTypeList, toolkit, functionMask);

            if (model == null) {
                redrawAll = true;
                return null;
            } else {
                return model;
            }
        } else if (this.objType == OBJ_TYPE_OBJMODEL) {
            @Pc(489) ObjType objType = objTypeList.list(this.obj);
            @Pc(498) Model model = objType.model(animator, functionMask, playerModel, 10, toolkit);

            if (model == null) {
                redrawAll = true;
                return null;
            } else {
                return model;
            }
        } else if (this.objType == OBJ_TYPE_NPCMODEL) {
            @Pc(438) Model model = npcTypeList.list(this.obj).getModel(varDomain, toolkit, arg2, animator, 0, null, npcTypeCustomisation, null, 2048, null);

            if (model == null) {
                redrawAll = true;
                return null;
            } else {
                return model;
            }
        } else if (this.objType == OBJ_TYPE_PLAYERHEAD_IGNOREWORN) {
            if (playerModel == null) {
                return null;
            }

            @Pc(558) int kit1 = this.obj >>> 16;
            @Pc(563) int kit2 = this.obj & 0xFFFF;
            @Pc(566) int kit3 = this.objData;
            @Pc(578) Model model = playerModel.headModel(animator, kit1, kit3, seqTypeList, toolkit, idkTypeList, kit2);

            if (model == null) {
                redrawAll = true;
                return null;
            } else {
                return model;
            }
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(II)V")
    public void removeParam(@OriginalArg(0) int id) {
        if (this.params != null) {
            @Pc(14) Node param = this.params.get(id);

            if (param != null) {
                param.unlink();
            }
        }
    }

    @OriginalMember(owner = "client!hda", name = "b", descriptor = "(ZLclient!ha;)Lclient!da;")
    public Font font(@OriginalArg(1) Toolkit toolkit) {
        @Pc(18) Font font = Fonts.font(this.fontMonospaced, false, this.fontGraphic, toolkit);
        redrawAll = font == null;
        return font;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(III)I")
    public int param(@OriginalArg(0) int dflt, @OriginalArg(2) int id) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(17) IntNode param = (IntNode) this.params.get(id);
            return param == null ? dflt : param.value;
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(ILclient!dg;Lclient!qk;)Lclient!gm;")
    public SkyBox skyBox(@OriginalArg(1) SkyBoxSphereTypeList sphereTypeList, @OriginalArg(2) SkyBoxTypeList typeList) {
        if (this.skyBox == -1) {
            return null;
        }
        @Pc(48) long key = (long) this.skyBox & 0xFFFFL | ((long) this.skyBoxSphereOffsetZ & 0xFFFFL) << 16 | ((long) this.skyBoxSphereOffsetX & 0xFFFFL) << 48 | 0xFFFFL << 32 & (long) this.skyBoxSphereOffsetY << 32;
        @Pc(54) SkyBox skyBox = (SkyBox) skyBoxes.get(key);
        if (skyBox == null) {
            skyBox = typeList.skyBox(sphereTypeList, this.skyBoxSphereOffsetZ, this.skyBox, this.skyBoxSphereOffsetY, this.skyBoxSphereOffsetX);
            skyBoxes.put(skyBox, key);
        }
        return skyBox;
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(ISIS)V")
    public void setRecol(@OriginalArg(1) short destination, @OriginalArg(2) int index, @OriginalArg(3) short source) {
        if (index >= 5) {
            return;
        }

        if (this.recol_s == null) {
            this.recol_d = new short[5];
            this.recol_s = new short[5];
        }

        this.recol_s[index] = source;
        this.recol_d[index] = destination;
    }
}
