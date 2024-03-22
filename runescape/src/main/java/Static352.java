import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import com.jagex.game.runetek6.config.effectortype.ParticleEffectorTypeList;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static352 {

    @OriginalMember(owner = "client!lc", name = "B", descriptor = "I")
    public static final int anInt5752 = 50;

    @OriginalMember(owner = "client!lc", name = "E", descriptor = "[Lclient!dj;")
    public static final Class80[] aClass80Array1 = new Class80[anInt5752];

    @OriginalMember(owner = "client!lc", name = "A", descriptor = "I")
    public static int anInt5754 = 0;

    @OriginalMember(owner = "client!lc", name = "u", descriptor = "[[I")
    public static final int[][] anIntArrayArray141 = new int[128][128];

    @OriginalMember(owner = "client!lc", name = "z", descriptor = "[I")
    public static final int[] anIntArray444 = new int[anInt5752];

    @OriginalMember(owner = "client!lc", name = "v", descriptor = "[I")
    public static final int[] anIntArray445 = new int[anInt5752];

    @OriginalMember(owner = "client!lc", name = "w", descriptor = "[I")
    public static final int[] anIntArray446 = new int[anInt5752];

    @OriginalMember(owner = "client!lc", name = "c", descriptor = "(B)V")
    public static void method5180() {
        Static467.aClass96_3.method2349();
        Static540.aClass79_6.method2067();
        Static68.idkTypeList.cacheReset();
        Static354.aLocTypeList_4.cacheReset();
        Static690.aNPCTypeList_2.cacheReset();
        Static419.objTypeList.cacheReset();
        Static25.seqTypeList.cacheReset();
        Static23.aClass128_1.method2699();
        Static529.aClass161_1.method3429();
        Static36.aClass260_1.method5784();
        Static628.aClass342_5.method7783();
        Static648.aClass17_1.method269();
        Static574.basTypeList.cacheReset();
        Static720.aMSITypeList_4.cacheReset();
        Static577.aClass246_4.method5586();
        Static272.aClass45_1.method1098();
        Static523.instance.cacheReset();
        Static324.skyBoxTypeList.cacheReset();
        Static99.skyBoxSphereTypeList.cacheReset();
        Static48.aClass384_1.method8812();
        Static354.aClass267_1.method5974();
        Static652.aClass214_1.method5035();
        Static561.aClass220_2.method5182();
        PlayerModel.cacheReset();
        Component.cacheReset();
        FontTypeList.cacheReset();
        Static327.method4895();
        if (Static2.aClass355_1 != Static446.aClass355_5) {
            for (@Pc(92) int local92 = 0; local92 < Static163.aByteArrayArray36.length; local92++) {
                Static163.aByteArrayArray36[local92] = null;
            }
            Static107.anInt2161 = 0;
        }
        Static157.method2560();
        Static584.method7666();
        Static367.method5267();
        ParticleEmitterTypeList.cacheReset();
        ParticleEffectorTypeList.cacheReset();
        Static472.A_WEIGHTED_CACHE___156.reset();
        Static163.activeToolkit.method8012();
        Static269.method3909();
        Static112.method2109();
        js5.ANIMS.discardUnpacked();
        js5.BASES.discardUnpacked();
        js5.CONFIG.discardUnpacked();
        js5.INTERFACES.discardUnpacked();
        js5.SYNTH_SOUNDS.discardUnpacked();
        js5.MAPS.discardUnpacked();
        js5.MIDI_SONGS.discardUnpacked();
        js5.MODELS.discardUnpacked();
        js5.SPRITES.discardUnpacked();
        js5.TEXTURES.discardUnpacked();
        js5.BINARY.discardUnpacked();
        js5.MIDI_JINGLES.discardUnpacked();
        js5.CLIENTSCRIPTS.discardUnpacked();
        js5.FONTMETRICS.discardUnpacked();
        js5.VORBIS.discardUnpacked();
        js5.js5_15.discardUnpacked();
        js5.CONFIG_LOC.discardUnpacked();
        js5.CONFIG_ENUM.discardUnpacked();
        js5.CONFIG_NPC.discardUnpacked();
        js5.CONFIG_OBJ.discardUnpacked();
        js5.CONFIG_SEQ.discardUnpacked();
        js5.CONFIG_SPOT.discardUnpacked();
        js5.CONFIG_STRUCT.discardUnpacked();
        js5.WORLDMAPDATA.discardUnpacked();
        js5.QUICKCHAT.discardUnpacked();
        js5.QUICKCHAT_GLOBAL.discardUnpacked();
        js5.MATERIALS.discardUnpacked();
        js5.CONFIG_PARTICLE.discardUnpacked();
        js5.DEFAULTS.discardUnpacked();
        js5.CUTSCENES.discardUnpacked();
        js5.CONFIG_BILLBOARD.discardUnpacked();
        js5.DLLS.discardUnpacked();
        js5.SHADERS.discardUnpacked();
        js5.js5_36.discardUnpacked();
        Static230.A_WEIGHTED_CACHE___81.reset();
        Static669.A_WEIGHTED_CACHE___215.reset();
        Static541.A_WEIGHTED_CACHE___174.reset();
        Static452.A_WEIGHTED_CACHE___149.reset();
    }
}
