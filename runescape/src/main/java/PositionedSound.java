import com.jagex.core.datastruct.key.Node;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.sound.SoundStream;
import com.jagex.sound.VariableRateSoundPacket;
import com.jagex.sound.vorbis.VorbisSound;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tg")
public final class PositionedSound extends Node {

    @OriginalMember(owner = "client!tg", name = "y", descriptor = "Lclient!haa;")
    public SoundStream randomStream;

    @OriginalMember(owner = "client!tg", name = "F", descriptor = "I")
    public int z2;

    @OriginalMember(owner = "client!tg", name = "p", descriptor = "I")
    public int level;

    @OriginalMember(owner = "client!tg", name = "x", descriptor = "I")
    public int randomDelay;

    @OriginalMember(owner = "client!tg", name = "G", descriptor = "Lclient!c;")
    public LocType locType;

    @OriginalMember(owner = "client!tg", name = "C", descriptor = "I")
    public int z1;

    @OriginalMember(owner = "client!tg", name = "k", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!tg", name = "E", descriptor = "I")
    public int delayMax;

    @OriginalMember(owner = "client!tg", name = "I", descriptor = "I")
    public int minRange;

    @OriginalMember(owner = "client!tg", name = "z", descriptor = "I")
    public int rangeMax;

    @OriginalMember(owner = "client!tg", name = "M", descriptor = "Lclient!haa;")
    public SoundStream stream;

    @OriginalMember(owner = "client!tg", name = "N", descriptor = "I")
    public int x1;

    @OriginalMember(owner = "client!tg", name = "H", descriptor = "I")
    public int volume;

    @OriginalMember(owner = "client!tg", name = "O", descriptor = "I")
    public int rateMin;

    @OriginalMember(owner = "client!tg", name = "J", descriptor = "I")
    public int rateMax;

    @OriginalMember(owner = "client!tg", name = "P", descriptor = "Lclient!ca;")
    public PlayerEntity player;

    @OriginalMember(owner = "client!tg", name = "l", descriptor = "Z")
    public boolean multi;

    @OriginalMember(owner = "client!tg", name = "K", descriptor = "Lclient!sq;")
    public VariableRateSoundPacket randomPacket;

    @OriginalMember(owner = "client!tg", name = "q", descriptor = "Lclient!sq;")
    public VariableRateSoundPacket packet;

    @OriginalMember(owner = "client!tg", name = "s", descriptor = "Lclient!uj;")
    public VorbisSound randomVorbisSound;

    @OriginalMember(owner = "client!tg", name = "o", descriptor = "[I")
    public int[] randomIds;

    @OriginalMember(owner = "client!tg", name = "v", descriptor = "Z")
    public boolean vorbis;

    @OriginalMember(owner = "client!tg", name = "r", descriptor = "Lclient!uj;")
    public VorbisSound vorbisSound;

    @OriginalMember(owner = "client!tg", name = "t", descriptor = "I")
    public int x2;

    @OriginalMember(owner = "client!tg", name = "L", descriptor = "Lclient!wj;")
    public NPCEntity npc;

    @OriginalMember(owner = "client!tg", name = "A", descriptor = "Z")
    public boolean random;

    @OriginalMember(owner = "client!tg", name = "w", descriptor = "I")
    public int delayMin;

    @OriginalMember(owner = "client!tg", name = "B", descriptor = "I")
    public int movementSpeed = 0;

    @OriginalMember(owner = "client!tg", name = "b", descriptor = "(I)V")
    public void update() {
        @Pc(11) int sound = this.id;
        @Pc(14) boolean vorbis = this.vorbis;

        if (this.locType != null) {
            @Pc(148) LocType locType = this.locType.getMultiLoc(CutsceneManager.state == 3 ? CutsceneVarDomain.instance : TimedVarDomain.instance);

            if (locType == null) {
                this.randomIds = null;
                this.id = -1;
                this.vorbis = false;
                this.volume = 0;
                this.rateMin = 256;
                this.delayMax = 0;
                this.minRange = 0;
                this.random = false;
                this.rateMax = 256;
                this.delayMin = 0;
                this.rangeMax = 0;
            } else {
                this.vorbis = locType.vorbis;
                this.rateMax = locType.soundRateMax;
                this.rateMin = locType.soundRateMin;
                this.rangeMax = locType.soundRange << 9;
                this.volume = locType.soundVolume;
                this.delayMax = locType.soundDelayMax;
                this.id = locType.sound;
                this.randomIds = locType.randomSoundIds;
                this.random = locType.randomsound;
                this.delayMin = locType.soundDelayMin;
            }
        } else if (this.npc != null) {
            @Pc(27) int npcSound = NPCEntity.currentSound(this.npc);

            if (npcSound != sound) {
                this.id = npcSound;

                @Pc(37) NPCType npcType = this.npc.type;
                if (npcType.multinpcs != null) {
                    npcType = npcType.getMultiNPC(TimedVarDomain.instance);
                }

                if (npcType == null) {
                    this.vorbis = this.npc.type.vorbis;
                    this.rateMin = 256;
                    this.rateMax = 256;
                    this.volume = this.rangeMax = this.minRange = 0;
                } else {
                    this.rateMax = npcType.soundRateMax;
                    this.volume = npcType.soundVolume;
                    this.rangeMax = npcType.soundRangeMax << 9;
                    this.rateMin = npcType.soundRateMin;
                    this.vorbis = npcType.vorbis;
                    this.minRange = npcType.soundRangeMin << 9;
                }
            }
        } else if (this.player != null) {
            this.id = PlayerEntity.currentSound(this.player);
            this.volume = this.player.soundVolume;
            this.minRange = 0;
            this.rateMin = 256;
            this.rangeMax = this.player.soundRange << 9;
            this.vorbis = this.player.vorbis;
            this.rateMax = 256;
        }

        if (this.id != sound || this.vorbis != vorbis) {
            if (this.stream != null) {
                SoundManager.activeStreams.remove(this.stream);
                this.stream = null;
                this.packet = null;
                this.vorbisSound = null;
            }
        }
    }
}
