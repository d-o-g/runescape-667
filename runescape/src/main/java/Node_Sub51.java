import com.jagex.core.datastruct.key.Node;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tg")
public final class Node_Sub51 extends Node {

    @OriginalMember(owner = "client!tg", name = "y", descriptor = "Lclient!haa;")
    public Node_Sub6_Sub2 aClass2_Sub6_Sub2_3;

    @OriginalMember(owner = "client!tg", name = "F", descriptor = "I")
    public int anInt9349;

    @OriginalMember(owner = "client!tg", name = "p", descriptor = "I")
    public int anInt9350;

    @OriginalMember(owner = "client!tg", name = "x", descriptor = "I")
    public int anInt9351;

    @OriginalMember(owner = "client!tg", name = "G", descriptor = "Lclient!c;")
    public LocType aLocType_1;

    @OriginalMember(owner = "client!tg", name = "C", descriptor = "I")
    public int anInt9352;

    @OriginalMember(owner = "client!tg", name = "k", descriptor = "I")
    public int sound;

    @OriginalMember(owner = "client!tg", name = "E", descriptor = "I")
    public int anInt9354;

    @OriginalMember(owner = "client!tg", name = "I", descriptor = "I")
    public int anInt9355;

    @OriginalMember(owner = "client!tg", name = "z", descriptor = "I")
    public int anInt9356;

    @OriginalMember(owner = "client!tg", name = "M", descriptor = "Lclient!haa;")
    public Node_Sub6_Sub2 aClass2_Sub6_Sub2_4;

    @OriginalMember(owner = "client!tg", name = "N", descriptor = "I")
    public int anInt9357;

    @OriginalMember(owner = "client!tg", name = "H", descriptor = "I")
    public int soundVolume;

    @OriginalMember(owner = "client!tg", name = "O", descriptor = "I")
    public int anInt9359;

    @OriginalMember(owner = "client!tg", name = "J", descriptor = "I")
    public int anInt9360;

    @OriginalMember(owner = "client!tg", name = "P", descriptor = "Lclient!ca;")
    public PlayerEntity player;

    @OriginalMember(owner = "client!tg", name = "l", descriptor = "Z")
    public boolean aBoolean713;

    @OriginalMember(owner = "client!tg", name = "K", descriptor = "Lclient!sq;")
    public Node_Sub49_Sub1 aClass2_Sub49_Sub1_3;

    @OriginalMember(owner = "client!tg", name = "q", descriptor = "Lclient!sq;")
    public Node_Sub49_Sub1 aClass2_Sub49_Sub1_4;

    @OriginalMember(owner = "client!tg", name = "s", descriptor = "Lclient!uj;")
    public Node_Sub53 aClass2_Sub53_2;

    @OriginalMember(owner = "client!tg", name = "o", descriptor = "[I")
    public int[] anIntArray718;

    @OriginalMember(owner = "client!tg", name = "v", descriptor = "Z")
    public boolean vorbis;

    @OriginalMember(owner = "client!tg", name = "r", descriptor = "Lclient!uj;")
    public Node_Sub53 aClass2_Sub53_3;

    @OriginalMember(owner = "client!tg", name = "t", descriptor = "I")
    public int anInt9362;

    @OriginalMember(owner = "client!tg", name = "L", descriptor = "Lclient!wj;")
    public NPCEntity npc;

    @OriginalMember(owner = "client!tg", name = "A", descriptor = "Z")
    public boolean aBoolean715;

    @OriginalMember(owner = "client!tg", name = "w", descriptor = "I")
    public int anInt9365;

    @OriginalMember(owner = "client!tg", name = "B", descriptor = "I")
    public int movementSpeed = 0;

    @OriginalMember(owner = "client!tg", name = "b", descriptor = "(I)V")
    public void method8236() {
        @Pc(11) int local11 = this.sound;
        @Pc(14) boolean local14 = this.vorbis;
        if (this.aLocType_1 != null) {
            @Pc(148) LocType local148 = this.aLocType_1.getMultiLoc(CutsceneManager.state == 3 ? Static298.AN_VAR_DOMAIN___2 : TimedVarDomain.instance);
            if (local148 == null) {
                this.anIntArray718 = null;
                this.sound = -1;
                this.vorbis = false;
                this.soundVolume = 0;
                this.anInt9359 = 256;
                this.anInt9354 = 0;
                this.anInt9355 = 0;
                this.aBoolean715 = false;
                this.anInt9360 = 256;
                this.anInt9365 = 0;
                this.anInt9356 = 0;
            } else {
                this.vorbis = local148.aBoolean88;
                this.anInt9360 = local148.anInt1249;
                this.anInt9359 = local148.anInt1268;
                this.anInt9356 = local148.soundDistance << 9;
                this.soundVolume = local148.ambientSoundVolume;
                this.anInt9354 = local148.anInt1219;
                this.sound = local148.sound;
                this.anIntArray718 = local148.anIntArray116;
                this.aBoolean715 = local148.aBoolean92;
                this.anInt9365 = local148.anInt1231;
            }
        } else if (this.npc != null) {
            @Pc(27) int local27 = NPCEntity.currentSound(this.npc);
            if (local27 != local11) {
                this.sound = local27;
                @Pc(37) NPCType local37 = this.npc.type;
                if (local37.multinpcs != null) {
                    local37 = local37.getMultiNPC(TimedVarDomain.instance);
                }
                if (local37 == null) {
                    this.vorbis = this.npc.type.vorbisSound;
                    this.anInt9359 = 256;
                    this.anInt9360 = 256;
                    this.soundVolume = this.anInt9356 = this.anInt9355 = 0;
                } else {
                    this.anInt9360 = local37.anInt6736;
                    this.soundVolume = local37.soundVolume;
                    this.anInt9356 = local37.soundDistance << 9;
                    this.anInt9359 = local37.anInt6729;
                    this.vorbis = local37.vorbisSound;
                    this.anInt9355 = local37.soundStartDistance << 9;
                }
            }
        } else if (this.player != null) {
            this.sound = PlayerEntity.method4870(this.player);
            this.soundVolume = this.player.soundVolume;
            this.anInt9355 = 0;
            this.anInt9359 = 256;
            this.anInt9356 = this.player.anInt1452 << 9;
            this.vorbis = this.player.vorbis;
            this.anInt9360 = 256;
        }
        if (this.sound == local11 && this.vorbis == local14) {
            return;
        }
        if (this.aClass2_Sub6_Sub2_4 == null) {
            return;
        }
        Static336.aClass2_Sub6_Sub3_1.method5883(this.aClass2_Sub6_Sub2_4);
        this.aClass2_Sub6_Sub2_4 = null;
        this.aClass2_Sub49_Sub1_4 = null;
        this.aClass2_Sub53_3 = null;
    }
}
