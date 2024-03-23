import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.FileOnDisk;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.lang.reflect.Field;

@OriginalClass("client!kv")
public final class ClientOptions extends Node {

    // $FF: synthetic field
    @OriginalMember(owner = "client!kv", name = "y", descriptor = "Ljava/lang/Class;")
    public static Class optionsClass;

    // $FF: synthetic field
    @OriginalMember(owner = "client!lka", name = "i", descriptor = "Ljava/lang/Class;")
    public static Class aClass15;

    // $FF: synthetic field
    @OriginalMember(owner = "client!lka", name = "h", descriptor = "Ljava/lang/Class;")
    public static Class aClass14;

    @OriginalMember(owner = "client!mk", name = "d", descriptor = "Lclient!kv;")
    public static ClientOptions instance;

    @OriginalMember(owner = "client!lla", name = "a", descriptor = "I")
    public static int maxmemory = 64;

    @OriginalMember(owner = "client!pk", name = "m", descriptor = "I")
    public static int cpucount = 1;

    @OriginalMember(owner = "client!kv", name = "S", descriptor = "Lclient!hr;")
    public LoadingSequenceOption loadingSequence;

    @OriginalMember(owner = "client!kv", name = "U", descriptor = "Lclient!rba;")
    public VolumeOption backgroundSoundVolume;

    @OriginalMember(owner = "client!kv", name = "gb", descriptor = "Lclient!sga;")
    public IdleAnimationsOption idleAnimations;

    @OriginalMember(owner = "client!kv", name = "H", descriptor = "Lclient!fia;")
    public GroundDecorOption groundDecor;

    @OriginalMember(owner = "client!kv", name = "fb", descriptor = "Lclient!lo;")
    public CustomCursors customCursors;

    @OriginalMember(owner = "client!kv", name = "ib", descriptor = "Lclient!ro;")
    public WaterDetailOption waterDetail;

    @OriginalMember(owner = "client!kv", name = "B", descriptor = "Lclient!dc;")
    public SkyboxesOption skydetail;

    @OriginalMember(owner = "client!kv", name = "eb", descriptor = "Lclient!ls;")
    public GraphicsQuality graphicsQuality;

    @OriginalMember(owner = "client!kv", name = "z", descriptor = "Lclient!rba;")
    public VolumeOption musicVolume;

    @OriginalMember(owner = "client!kv", name = "w", descriptor = "Lclient!tv;")
    public TextureQuality textures;

    @OriginalMember(owner = "client!kv", name = "lb", descriptor = "Lclient!rba;")
    public VolumeOption speechVolume;

    @OriginalMember(owner = "client!kv", name = "t", descriptor = "Lclient!nt;")
    public AnimateBackgroundOption animateBackgroundDefault;

    @OriginalMember(owner = "client!kv", name = "o", descriptor = "Lclient!gma;")
    public FlickeringEffectsOption flickeringEffects;

    @OriginalMember(owner = "client!kv", name = "K", descriptor = "Lclient!jh;")
    public HardShadowsOption hardShadows;

    @OriginalMember(owner = "client!kv", name = "db", descriptor = "Lclient!jha;")
    public AntialiasingMode antialiasingQuality;

    @OriginalMember(owner = "client!kv", name = "v", descriptor = "Lclient!jha;")
    public AntialiasingMode antialiasingMode;

    @OriginalMember(owner = "client!kv", name = "k", descriptor = "Lclient!cc;")
    public ScreenSizeOption screenSizeDefault;

    @OriginalMember(owner = "client!kv", name = "m", descriptor = "Lclient!qia;")
    public GroundBlendingOption groundBlending;

    @OriginalMember(owner = "client!kv", name = "M", descriptor = "Lclient!tba;")
    public ToolkitOption toolkitDefault;

    @OriginalMember(owner = "client!kv", name = "u", descriptor = "Lclient!oq;")
    public CpuUsageOption cpuUsage;

    @OriginalMember(owner = "client!kv", name = "D", descriptor = "Lclient!rba;")
    public VolumeOption soundVolume;

    @OriginalMember(owner = "client!kv", name = "x", descriptor = "Lclient!dma;")
    public BuildAreaOption buildArea;

    @OriginalMember(owner = "client!kv", name = "p", descriptor = "Lclient!dja;")
    public OrthographicOption orthographic;

    @OriginalMember(owner = "client!kv", name = "bb", descriptor = "Lclient!qb;")
    public BrightnessOption brightness;

    @OriginalMember(owner = "client!kv", name = "W", descriptor = "Lclient!hl;")
    public SafeModeOption safeMode;

    @OriginalMember(owner = "client!kv", name = "A", descriptor = "Lclient!nt;")
    public AnimateBackgroundOption animateBackground;

    @OriginalMember(owner = "client!kv", name = "P", descriptor = "Lclient!dl;")
    public RemoveRoofsOption removeRoofs;

    @OriginalMember(owner = "client!kv", name = "V", descriptor = "Lclient!nf;")
    public MaxScreenSizeOption maxScreenSize;

    @OriginalMember(owner = "client!kv", name = "I", descriptor = "Lclient!dl;")
    public RemoveRoofsOption removeRoofsOverride;

    @OriginalMember(owner = "client!kv", name = "Q", descriptor = "Lclient!su;")
    public ParticlesOption particles;

    @OriginalMember(owner = "client!kv", name = "l", descriptor = "Lclient!oc;")
    public BloomOption bloom;

    @OriginalMember(owner = "client!kv", name = "L", descriptor = "Lclient!g;")
    public SpotShadowsOption spotShadows;

    @OriginalMember(owner = "client!kv", name = "G", descriptor = "Lclient!rba;")
    public VolumeOption loginVolume;

    @OriginalMember(owner = "client!kv", name = "N", descriptor = "Lclient!mv;")
    public StereoSoundOption stereoSound;

    @OriginalMember(owner = "client!kv", name = "X", descriptor = "Lclient!cc;")
    public ScreenSizeOption screenSize;

    @OriginalMember(owner = "client!kv", name = "hb", descriptor = "Lclient!gq;")
    public SmallTexturesOption smallTextures;

    @OriginalMember(owner = "client!kv", name = "T", descriptor = "Lclient!mea;")
    public FogOption fog;

    @OriginalMember(owner = "client!kv", name = "R", descriptor = "Lclient!qka;")
    public LightDetailOption lightDetail;

    @OriginalMember(owner = "client!kv", name = "n", descriptor = "Lclient!ul;")
    public final ModeGame game;

    @OriginalMember(owner = "client!kv", name = "F", descriptor = "Lclient!le;")
    public final EnvironmentContext environment;

    @OriginalMember(owner = "client!kv", name = "Z", descriptor = "Lclient!tba;")
    public ToolkitOption toolkit;

    @OriginalMember(owner = "client!kv", name = "<init>", descriptor = "(Lclient!ul;I)V")
    public ClientOptions(@OriginalArg(0) ModeGame game, @OriginalArg(1) int toolkit) {
        this.game = game;
        this.environment = new EnvironmentContext(SignLink.instance.signed, maxmemory, cpucount, SignLink.osArchRaw.toLowerCase().indexOf("arm") != -1);
        this.toolkit = new ToolkitOption(toolkit, this);
        this.loadDefaults(true);
    }

    @OriginalMember(owner = "client!kv", name = "<init>", descriptor = "(Lclient!ge;Lclient!ul;I)V")
    public ClientOptions(@OriginalArg(0) Packet packet, @OriginalArg(1) ModeGame game, @OriginalArg(2) int toolkit) {
        this.game = game;
        this.environment = new EnvironmentContext(SignLink.instance.signed, maxmemory, cpucount, SignLink.osArchRaw.indexOf("arm") != -1);
        this.toolkit = new ToolkitOption(toolkit, this);
        this.decode(packet);
    }

    @OriginalMember(owner = "client!vba", name = "h", descriptor = "(I)V")
    public static void save() {
        @Pc(5) FileOnDisk file = null;
        try {
            @Pc(18) SignedResource resource = SignLink.instance.openPrefs("", true);
            while (resource.status == 0) {
                TimeUtils.sleep(1L);
            }

            if (resource.status == 1) {
                file = (FileOnDisk) resource.result;
                @Pc(41) Packet packet = instance.encode();
                file.write(packet.data, 0, packet.pos);
            }
        } catch (@Pc(51) Exception ignored) {
            /* empty */
        }

        try {
            if (file != null) {
                file.close();
            }
        } catch (@Pc(58) Exception ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!lka", name = "a", descriptor = "(B)I")
    public static int optionCount() {
        @Pc(5) int count = 0;
        @Pc(26) Field[] fields = (aClass14 == null ? (aClass14 = getClass("ClientOptions")) : aClass14).getDeclaredFields();
        for (@Pc(30) int i = 0; i < fields.length; i++) {
            @Pc(35) Field field = fields[i];
            if ((aClass15 == null ? (aClass15 = getClass("Option")) : aClass15).isAssignableFrom(field.getType())) {
                count++;
            }
        }
        return count + 1;
    }

    @OriginalMember(owner = "client!kv", name = "a", descriptor = "(Lclient!ge;Z)V")
    public void decode(@OriginalArg(0) Packet packet) {
        if (packet == null || packet.data == null) {
            this.loadDefaults(true);
        } else {
            @Pc(24) int version = packet.g1();

            if (version < 23) {
                try {
                    this.decodeLegacy(version, packet);
                } catch (@Pc(34) Exception ignored) {
                    this.loadDefaults(true);
                }

                this.loadDefaults(false);
            } else if (version <= 25) {
                this.antialiasingMode = new AntialiasingMode(packet.g1(), this);
                this.antialiasingQuality = new AntialiasingMode(this.antialiasingMode.getValue(), this);
                this.bloom = new BloomOption(packet.g1(), this);
                this.brightness = new BrightnessOption(packet.g1(), this);
                this.buildArea = new BuildAreaOption(packet.g1(), this);
                this.flickeringEffects = new FlickeringEffectsOption(packet.g1(), this);
                this.fog = new FogOption(packet.g1(), this);
                this.groundBlending = new GroundBlendingOption(packet.g1(), this);
                this.groundDecor = new GroundDecorOption(packet.g1(), this);
                this.idleAnimations = new IdleAnimationsOption(packet.g1(), this);
                this.lightDetail = new LightDetailOption(packet.g1(), this);
                this.hardShadows = new HardShadowsOption(packet.g1(), this);
                if (version >= 24) {
                    this.orthographic = new OrthographicOption(packet.g1(), this);
                }
                this.particles = new ParticlesOption(packet.g1(), this);
                this.removeRoofs = new RemoveRoofsOption(packet.g1(), this);
                this.removeRoofsOverride = new RemoveRoofsOption(this.removeRoofs.getValue(), this);
                this.maxScreenSize = new MaxScreenSizeOption(packet.g1(), this);
                if (version >= 25) {
                    this.skydetail = new SkyboxesOption(packet.g1(), this);
                }
                this.spotShadows = new SpotShadowsOption(packet.g1(), this);
                this.smallTextures = new SmallTexturesOption(packet.g1(), this);
                this.textures = new TextureQuality(packet.g1(), this);
                this.toolkitDefault = new ToolkitOption(packet.g1(), this);
                this.toolkit = new ToolkitOption(this.toolkitDefault.getValue(), this);
                this.animateBackgroundDefault = new AnimateBackgroundOption(packet.g1(), this);
                this.animateBackground = new AnimateBackgroundOption(this.animateBackgroundDefault.getValue(), this);
                this.waterDetail = new WaterDetailOption(packet.g1(), this);
                this.screenSizeDefault = new ScreenSizeOption(packet.g1(), this);
                this.screenSize = new ScreenSizeOption(this.screenSizeDefault.getValue(), this);
                this.customCursors = new CustomCursors(packet.g1(), this);
                this.graphicsQuality = new GraphicsQuality(packet.g1(), this);
                this.cpuUsage = new CpuUsageOption(packet.g1(), this);
                this.loadingSequence = new LoadingSequenceOption(packet.g1(), this);
                this.safeMode = new SafeModeOption(packet.g1(), this);
                this.soundVolume = new VolumeOption(packet.g1(), this);
                this.backgroundSoundVolume = new VolumeOption(packet.g1(), this);
                this.speechVolume = new VolumeOption(packet.g1(), this);
                this.musicVolume = new VolumeOption(packet.g1(), this);
                this.loginVolume = new VolumeOption(packet.g1(), this);
                this.stereoSound = new StereoSoundOption(packet.g1(), this);
                this.loadDefaults(false);
            } else {
                this.loadDefaults(true);
            }
        }

        this.validate();
    }

    @OriginalMember(owner = "client!kv", name = "a", descriptor = "(ZB)V")
    public void loadDefaults(@OriginalArg(0) boolean all) {
        if (all || this.antialiasingMode == null) {
            this.antialiasingMode = new AntialiasingMode(this);
        }
        if (all || this.antialiasingQuality == null) {
            this.antialiasingQuality = new AntialiasingMode(this.antialiasingMode.getValue(), this);
        }
        if (all || this.bloom == null) {
            this.bloom = new BloomOption(this);
        }
        if (all || this.brightness == null) {
            this.brightness = new BrightnessOption(this);
        }
        if (all || this.buildArea == null) {
            this.buildArea = new BuildAreaOption(this);
        }
        if (all || this.flickeringEffects == null) {
            this.flickeringEffects = new FlickeringEffectsOption(this);
        }
        if (all || this.fog == null) {
            this.fog = new FogOption(this);
        }
        if (all || this.groundBlending == null) {
            this.groundBlending = new GroundBlendingOption(this);
        }
        if (all || this.groundDecor == null) {
            this.groundDecor = new GroundDecorOption(this);
        }
        if (all || this.idleAnimations == null) {
            this.idleAnimations = new IdleAnimationsOption(this);
        }
        if (all || this.lightDetail == null) {
            this.lightDetail = new LightDetailOption(this);
        }
        if (all || this.hardShadows == null) {
            this.hardShadows = new HardShadowsOption(this);
        }
        if (all || this.orthographic == null) {
            this.orthographic = new OrthographicOption(this);
        }
        if (all || this.particles == null) {
            this.particles = new ParticlesOption(this);
        }
        if (all || this.removeRoofs == null) {
            this.removeRoofs = new RemoveRoofsOption(this);
        }
        if (all || this.removeRoofsOverride == null) {
            this.removeRoofsOverride = new RemoveRoofsOption(this.removeRoofs.getValue(), this);
        }
        if (all || this.maxScreenSize == null) {
            this.maxScreenSize = new MaxScreenSizeOption(this);
        }
        if (all || this.skydetail == null) {
            this.skydetail = new SkyboxesOption(this);
        }
        if (all || this.spotShadows == null) {
            this.spotShadows = new SpotShadowsOption(this);
        }
        if (all || this.smallTextures == null) {
            this.smallTextures = new SmallTexturesOption(this);
        }
        if (all || this.textures == null) {
            this.textures = new TextureQuality(this);
        }
        if (all || this.toolkitDefault == null) {
            this.toolkitDefault = new ToolkitOption(this);
        }
        if (all || this.toolkit == null) {
            this.toolkit = new ToolkitOption(this.toolkitDefault.getValue(), this);
        }
        if (all || this.animateBackgroundDefault == null) {
            this.animateBackgroundDefault = new AnimateBackgroundOption(this);
        }
        if (all || this.animateBackground == null) {
            this.animateBackground = new AnimateBackgroundOption(this.animateBackgroundDefault.getValue(), this);
        }
        if (all || this.waterDetail == null) {
            this.waterDetail = new WaterDetailOption(this);
        }
        if (all || this.screenSizeDefault == null) {
            this.screenSizeDefault = new ScreenSizeOption(this);
        }
        if (all || this.screenSize == null) {
            this.screenSize = new ScreenSizeOption(this.screenSizeDefault.getValue(), this);
        }
        if (all || this.customCursors == null) {
            this.customCursors = new CustomCursors(this);
        }
        if (all || this.graphicsQuality == null) {
            this.graphicsQuality = new GraphicsQuality(this);
        }
        if (all || this.cpuUsage == null) {
            this.cpuUsage = new CpuUsageOption(this);
        }
        if (all || this.loadingSequence == null) {
            this.loadingSequence = new LoadingSequenceOption(this);
        }
        if (all || this.safeMode == null) {
            this.safeMode = new SafeModeOption(this);
        }
        if (all || this.soundVolume == null) {
            this.soundVolume = new VolumeOption(this);
        }
        if (all || this.backgroundSoundVolume == null) {
            this.backgroundSoundVolume = new VolumeOption(this);
        }
        if (all || this.speechVolume == null) {
            this.speechVolume = new VolumeOption(this);
        }
        if (all || this.musicVolume == null) {
            this.musicVolume = new VolumeOption(this);
        }
        if (all || this.loginVolume == null) {
            this.loginVolume = new VolumeOption(this);
        }
        if (all || this.stereoSound == null) {
            this.stereoSound = new StereoSoundOption(this);
        }
    }

    @OriginalMember(owner = "client!kv", name = "a", descriptor = "(IILclient!ta;)V")
    public void update(@OriginalArg(1) int value, @OriginalArg(2) Option option) {
        option.setSafeValue(value);
        this.validate();
    }

    @OriginalMember(owner = "client!kv", name = "h", descriptor = "(I)Lclient!ul;")
    public ModeGame getModeGame() {
        return this.game;
    }

    @OriginalMember(owner = "client!kv", name = "b", descriptor = "(I)Lclient!le;")
    public EnvironmentContext getEnvironment() {
        return this.environment;
    }

    @OriginalMember(owner = "client!kv", name = "g", descriptor = "(I)V")
    public void validate() {
        try {
            @Pc(7) Field[] fields = this.getClass().getDeclaredFields();
            for (@Pc(11) int i = 0; i < fields.length; i++) {
                @Pc(16) Field field = fields[i];
                if ((optionsClass == null ? (optionsClass = getClass("Option")) : optionsClass).isAssignableFrom(field.getType())) {
                    @Pc(36) Option option = (Option) field.get(this);
                    option.validate();
                }
            }
        } catch (@Pc(58) IllegalAccessException ignored) {
            /* empty */
        }
    }

    static Class getClass(String name) {
        Class instance;
        try {
            instance = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw (NoClassDefFoundError) new NoClassDefFoundError().initCause(ex);
        }
        return instance;
    }

    @OriginalMember(owner = "client!kv", name = "d", descriptor = "(I)Lclient!ge;")
    public Packet encode() {
        @Pc(9) Packet local9 = new Packet(optionCount());
        local9.p1(25);
        local9.p1(this.antialiasingMode.getValue());
        local9.p1(this.bloom.getValue());
        local9.p1(this.brightness.getValue());
        local9.p1(this.buildArea.getValue());
        local9.p1(this.flickeringEffects.getValue());
        local9.p1(this.fog.getValue());
        local9.p1(this.groundBlending.getValue());
        local9.p1(this.groundDecor.getValue());
        local9.p1(this.idleAnimations.getValue());
        local9.p1(this.lightDetail.getValue());
        local9.p1(this.hardShadows.getValue());
        local9.p1(this.orthographic.method2120());
        local9.p1(this.particles.getValue());
        local9.p1(this.removeRoofs.getValue());
        local9.p1(this.maxScreenSize.getValue());
        local9.p1(this.skydetail.getValue());
        local9.p1(this.spotShadows.getValue());
        local9.p1(this.smallTextures.getValue());
        local9.p1(this.textures.getvalue());
        local9.p1(this.toolkitDefault.getValue());
        local9.p1(this.animateBackgroundDefault.getValue());
        local9.p1(this.waterDetail.getValue());
        local9.p1(this.screenSizeDefault.getValue());
        local9.p1(this.customCursors.getValue());
        local9.p1(this.graphicsQuality.getValue());
        local9.p1(this.cpuUsage.value());
        local9.p1(this.loadingSequence.getValue());
        local9.p1(this.safeMode.getValue());
        local9.p1(this.soundVolume.getValue());
        local9.p1(this.backgroundSoundVolume.getValue());
        local9.p1(this.speechVolume.getValue());
        local9.p1(this.musicVolume.getValue());
        local9.p1(this.loginVolume.getValue());
        local9.p1(this.stereoSound.getValue());
        return local9;
    }

    @OriginalMember(owner = "client!kv", name = "a", descriptor = "(I)Z")
    public boolean isLowDetail() {
        return this.toolkit.isActive() && this.toolkit.getValue() == 0 && this.environment.getHeapSize() < 96;
    }

    @OriginalMember(owner = "client!kv", name = "a", descriptor = "(ZILclient!ge;)V")
    public void decodeLegacy(@OriginalArg(1) int version, @OriginalArg(2) Packet packet) {
        this.brightness = new BrightnessOption(packet.g1(), this);
        this.animateBackgroundDefault = new AnimateBackgroundOption(packet.g1(), this);
        this.removeRoofs = new RemoveRoofsOption(packet.g1() + 1, this);
        this.groundDecor = new GroundDecorOption(packet.g1(), this);
        this.smallTextures = new SmallTexturesOption(packet.g1(), this);
        this.idleAnimations = new IdleAnimationsOption(packet.g1(), this);
        this.flickeringEffects = new FlickeringEffectsOption(packet.g1(), this);
        packet.g1();
        this.spotShadows = new SpotShadowsOption(packet.g1(), this);
        @Pc(87) int local87 = packet.g1();
        @Pc(89) int local89 = 0;
        if (version >= 17) {
            local89 = packet.g1();
        }
        this.hardShadows = new HardShadowsOption(local89 >= local87 ? local89 : local87, this);
        @Pc(113) boolean local113 = true;
        @Pc(130) boolean local130;
        if (version < 2) {
            local130 = packet.g1() == 1;
            packet.g1();
        } else {
            local130 = packet.g1() == 1;
            if (version >= 17) {
                local113 = packet.g1() == 1;
            }
        }
        this.lightDetail = new LightDetailOption(local113 | local130 ? 1 : 0, this);
        this.waterDetail = new WaterDetailOption(packet.g1(), this);
        this.fog = new FogOption(packet.g1(), this);
        this.antialiasingMode = new AntialiasingMode(packet.g1(), this);
        this.stereoSound = new StereoSoundOption(packet.g1(), this);
        this.soundVolume = new VolumeOption(packet.g1(), this);
        if (version >= 20) {
            this.speechVolume = new VolumeOption(packet.g1(), this);
        } else {
            this.speechVolume = new VolumeOption(this.soundVolume.getValue(), this);
        }
        this.musicVolume = new VolumeOption(packet.g1(), this);
        this.backgroundSoundVolume = new VolumeOption(packet.g1(), this);
        if (version >= 21) {
            this.loginVolume = new VolumeOption(packet.g1(), this);
        } else {
            this.loginVolume = new VolumeOption(this.musicVolume.getValue(), this);
        }
        if (version >= 1) {
            packet.g2();
            packet.g2();
        }
        if (version >= 3 && version < 6) {
            packet.g1();
        }
        if (version >= 4) {
            this.particles = new ParticlesOption(packet.g1(), this);
        }
        packet.g4();
        if (version >= 6) {
            this.screenSizeDefault = new ScreenSizeOption(packet.g1(), this);
        }
        if (version >= 7) {
            this.safeMode = new SafeModeOption(packet.g1(), this);
        }
        if (version >= 8) {
            packet.g1();
        }
        if (version >= 9) {
            this.buildArea = new BuildAreaOption(packet.g1(), this);
        }
        if (version >= 10) {
            this.bloom = new BloomOption(packet.g1(), this);
        }
        if (version >= 11) {
            this.customCursors = new CustomCursors(packet.g1(), this);
        }
        if (version >= 12) {
            this.idleAnimations = new IdleAnimationsOption(packet.g1(), this);
        }
        if (version >= 13) {
            this.groundBlending = new GroundBlendingOption(packet.g1(), this);
        }
        if (version >= 14) {
            this.toolkitDefault = new ToolkitOption(packet.g1(), this);
        }
        if (version >= 15) {
            this.cpuUsage = new CpuUsageOption(packet.g1(), this);
        }
        if (version >= 16) {
            this.textures = new TextureQuality(packet.g1(), this);
        }
        if (version >= 18) {
            this.graphicsQuality = new GraphicsQuality(packet.g1(), this);
        }
        if (version >= 19) {
            this.maxScreenSize = new MaxScreenSizeOption(packet.g1(), this);
        }
        if (version >= 22) {
            this.loadingSequence = new LoadingSequenceOption(packet.g1(), this);
        }
    }
}
