import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static89 {

    @OriginalMember(owner = "client!cp", name = "n", descriptor = "[I")
    public static int[] zoneIds;

    @OriginalMember(owner = "client!cp", name = "h", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___9 = new CutsceneActionType(2);

    @OriginalMember(owner = "client!cp", name = "a", descriptor = "(ILclient!ca;IILclient!wj;Lclient!c;BI)V")
    public static void method1714(@OriginalArg(0) int level, @OriginalArg(1) PlayerEntity player, @OriginalArg(2) int x, @OriginalArg(3) int z, @OriginalArg(4) NPCEntity npc, @OriginalArg(5) LocType locType, @OriginalArg(7) int rotation) {
        @Pc(7) PositionedSound sound = new PositionedSound();
        sound.level = level;
        sound.x1 = x << 9;
        sound.z1 = z << 9;

        if (locType != null) {
            sound.locType = locType;
            @Pc(173) int width = locType.width;
            @Pc(176) int length = locType.length;
            if (rotation == 1 || rotation == 3) {
                length = locType.width;
                width = locType.length;
            }

            sound.volume = locType.soundVolume;
            sound.rangeMax = locType.soundRange << 9;
            sound.id = locType.sound;
            sound.delayMax = locType.soundDelayMax;
            sound.z2 = z + length << 9;
            sound.rateMax = locType.soundRateMax;
            sound.vorbis = locType.vorbis;
            sound.random = locType.randomsound;
            sound.minRange = locType.soundSize << 9;
            sound.delayMin = locType.soundDelayMin;
            sound.rateMin = locType.soundRateMin;
            sound.randomIds = locType.randomSoundIds;
            sound.x2 = x + width << 9;
            if (locType.multiloc != null) {
                sound.multi = true;
                sound.update();
            }
            if (sound.randomIds != null) {
                sound.randomDelay = (int) ((double) (sound.delayMax - sound.delayMin) * Math.random()) + sound.delayMin;
            }
            SoundManager.locSounds.addLast(sound);
        } else if (npc != null) {
            sound.npc = npc;
            @Pc(37) NPCType local37 = npc.type;
            if (local37.multinpcs != null) {
                sound.multi = true;
                local37 = local37.getMultiNPC(TimedVarDomain.instance);
            }
            if (local37 != null) {
                sound.x2 = local37.size + x << 9;
                sound.z2 = z + local37.size << 9;
                sound.id = NPCEntity.currentSound(npc);
                sound.minRange = local37.soundRangeMin << 9;
                sound.volume = local37.soundVolume;
                sound.rateMin = local37.soundRateMin;
                sound.vorbis = local37.vorbis;
                sound.rangeMax = local37.soundRangeMax << 9;
                sound.rateMax = local37.soundRateMax;
            }
            SoundManager.npcSounds.addLast(sound);
        } else if (player != null) {
            sound.player = player;
            sound.x2 = x + player.getSize() << 9;
            sound.z2 = player.getSize() + z << 9;
            sound.id = PlayerEntity.sound(player);
            sound.rangeMax = player.soundRange << 9;
            sound.rateMax = 256;
            sound.rateMin = 256;
            sound.volume = player.soundVolume;
            sound.minRange = 0;
            sound.vorbis = player.vorbis;
            SoundManager.playerSounds.put(player.id, sound);
        }
    }

}
