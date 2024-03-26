import com.jagex.Client;
import com.jagex.core.constants.ModeWhere;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import com.jagex.game.runetek6.config.effectortype.ParticleEffectorTypeList;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import com.jagex.game.runetek6.config.hitmarktype.HitmarkTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.lighttype.LightTypeList;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.questtype.QuestTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.structtype.StructTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.game.runetek6.config.vartype.clan.VarClanTypeList;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static352 {

    @OriginalMember(owner = "client!lc", name = "A", descriptor = "I")
    public static int lastClanTransmit = 0;

    @OriginalMember(owner = "client!lc", name = "c", descriptor = "(B)V")
    public static void cacheReset() {
        FloorOverlayTypeList.instance.cacheReset();
        FloorUnderlayTypeList.instance.cacheReset();
        IDKTypeList.instance.cacheReset();
        LocTypeList.instance.cacheReset();
        NPCTypeList.instance.cacheReset();
        ObjTypeList.instance.cacheReset();
        SeqTypeList.instance.cacheReset();
        SpotAnimationTypeList.instance.cacheReset();
        VarBitTypeListClient.instance.cacheReset();
        VarPlayerTypeListClient.instance.cacheReset();
        VarClanSettingTypeList.instance.cacheReset();
        VarClanTypeList.instance.cacheReset();
        BASTypeList.instance.cacheReset();
        MSITypeList.instance.cacheReset();
        MapElementTypeList.instance.cacheReset();
        QuestTypeList.instance.cacheReset();
        ParamTypeList.instance.cacheReset();
        SkyBoxTypeList.instance.cacheReset();
        SkyBoxSphereTypeList.instance.cacheReset();
        LightTypeList.instance.cacheReset();
        CursorTypeList.instance.cacheReset();
        StructTypeList.instance.cacheReset();
        HitmarkTypeList.instance.cacheReset();
        PlayerModel.cacheReset();
        Component.cacheReset();
        FontTypeList.cacheReset();
        ClientInventory.cacheReset();
        if (Client.modeWhere != ModeWhere.LIVE) {
            for (@Pc(92) int local92 = 0; local92 < Static163.aByteArrayArray36.length; local92++) {
                Static163.aByteArrayArray36[local92] = null;
            }
            Static107.anInt2161 = 0;
        }
        Environment.cacheReset();
        PlayerEntity.cacheReset();
        ShadowList.cacheReset();
        ParticleEmitterTypeList.cacheReset();
        ParticleEffectorTypeList.cacheReset();
        ScriptRunner.A_WEIGHTED_CACHE___156.reset();
        Toolkit.active.cacheReset();
        ClientScriptList.cacheReset();
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
        js5.VIDEOS.discardUnpacked();
        Sprites.hitbarCache.reset();
        Sprites.timerbarCache.reset();
        Sprites.mobilisingArmiesCache.reset();
        MiniMenu.questCache.reset();
    }
}
