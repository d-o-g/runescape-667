import com.jagex.core.io.BitPacket;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static169 {

    @OriginalMember(owner = "client!fe", name = "p", descriptor = "I")
    public static int anInt2855 = -2;

    @OriginalMember(owner = "client!fe", name = "a", descriptor = "(ILclient!rka;)V")
    public static void method2647(@OriginalArg(1) BitPacket bitPacket) {
        bitPacket.p4(js5.ANIMS.indexCrc());
        bitPacket.p4(js5.BASES.indexCrc());
        bitPacket.p4(js5.CONFIG.indexCrc());
        bitPacket.p4(js5.INTERFACES.indexCrc());
        bitPacket.p4(js5.SYNTH_SOUNDS.indexCrc());
        bitPacket.p4(js5.MAPS.indexCrc());
        bitPacket.p4(js5.MIDI_SONGS.indexCrc());
        bitPacket.p4(js5.MODELS.indexCrc());
        bitPacket.p4(js5.SPRITES.indexCrc());
        bitPacket.p4(js5.TEXTURES.indexCrc());
        bitPacket.p4(js5.BINARY.indexCrc());
        bitPacket.p4(js5.MIDI_JINGLES.indexCrc());
        bitPacket.p4(js5.CLIENTSCRIPTS.indexCrc());
        bitPacket.p4(js5.FONTMETRICS.indexCrc());
        bitPacket.p4(js5.VORBIS.indexCrc());
        bitPacket.p4(js5.js5_15.indexCrc());
        bitPacket.p4(js5.CONFIG_LOC.indexCrc());
        bitPacket.p4(js5.CONFIG_ENUM.indexCrc());
        bitPacket.p4(js5.CONFIG_NPC.indexCrc());
        bitPacket.p4(js5.CONFIG_OBJ.indexCrc());
        bitPacket.p4(js5.CONFIG_SEQ.indexCrc());
        bitPacket.p4(js5.CONFIG_SPOT.indexCrc());
        bitPacket.p4(js5.CONFIG_STRUCT.indexCrc());
        bitPacket.p4(js5.WORLDMAPDATA.indexCrc());
        bitPacket.p4(js5.QUICKCHAT.indexCrc());
        bitPacket.p4(js5.QUICKCHAT_GLOBAL.indexCrc());
        bitPacket.p4(js5.MATERIALS.indexCrc());
        bitPacket.p4(js5.CONFIG_PARTICLE.indexCrc());
        bitPacket.p4(js5.DEFAULTS.indexCrc());
        bitPacket.p4(js5.CONFIG_BILLBOARD.indexCrc());
        bitPacket.p4(js5.DLLS.indexCrc());
        bitPacket.p4(js5.SHADERS.indexCrc());
        bitPacket.p4(js5.CUTSCENES.indexCrc());
        bitPacket.p4(Static190.method2865());
        bitPacket.p4(Static140.method2366());
        bitPacket.p4(js5.VIDEOS.indexCrc());
    }
}
