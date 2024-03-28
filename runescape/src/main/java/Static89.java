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

    @OriginalMember(owner = "client!cp", name = "a", descriptor = "([FFIII[FFIIIII)V")
    public static void method1715(@OriginalArg(0) float[] arg0, @OriginalArg(1) float arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) float[] arg5, @OriginalArg(6) float arg6, @OriginalArg(7) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) int arg10) {
        @Pc(5) int local5 = arg3 - arg10;
        @Pc(9) int local9 = arg9 - arg2;
        @Pc(20) int local20 = arg8 - arg7;
        @Pc(45) float local45 = (float) local9 * arg0[2] + arg0[1] * (float) local20 + (float) local5 * arg0[0];
        @Pc(66) float local66 = (float) local9 * arg0[5] + (float) local20 * arg0[4] + arg0[3] * (float) local5;
        @Pc(87) float local87 = arg0[6] * (float) local5 + (float) local20 * arg0[7] + arg0[8] * (float) local9;
        @Pc(98) float local98 = (float) Math.atan2(local45, local87) / 6.2831855F + 0.5F;
        if (arg6 != 1.0F) {
            local98 *= arg6;
        }
        @Pc(112) float local112 = arg1 + local66 + 0.5F;
        @Pc(131) float local131;
        if (arg4 == 1) {
            local131 = local98;
            local98 = -local112;
            local112 = local131;
        } else if (arg4 == 2) {
            local112 = -local112;
            local98 = -local98;
        } else if (arg4 == 3) {
            local131 = local98;
            local98 = local112;
            local112 = -local131;
        }
        arg5[1] = local112;
        arg5[0] = local98;
    }
}
