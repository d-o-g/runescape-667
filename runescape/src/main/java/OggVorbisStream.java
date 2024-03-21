import com.jagex.game.runetek6.sound.OggStream;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import jagtheora.vorbis.DSPState;
import jagtheora.vorbis.VorbisBlock;
import jagtheora.vorbis.VorbisComment;
import jagtheora.vorbis.VorbisInfo;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ik")
public final class OggVorbisStream extends OggStream {

    @OriginalMember(owner = "client!ik", name = "C", descriptor = "Lclient!wc;")
    public Node_Sub6_Sub5 aClass2_Sub6_Sub5_1;

    @OriginalMember(owner = "client!ik", name = "O", descriptor = "Lclient!jagtheora/vorbis/DSPState;")
    public DSPState aDSPState1;

    @OriginalMember(owner = "client!ik", name = "B", descriptor = "I")
    public int anInt4396;

    @OriginalMember(owner = "client!ik", name = "Q", descriptor = "Lclient!lg;")
    public Class224 aClass224_1;

    @OriginalMember(owner = "client!ik", name = "N", descriptor = "D")
    public double aDouble14;

    @OriginalMember(owner = "client!ik", name = "K", descriptor = "Lclient!jagtheora/vorbis/VorbisBlock;")
    public VorbisBlock aVorbisBlock1;

    @OriginalMember(owner = "client!ik", name = "v", descriptor = "Lclient!jagtheora/vorbis/VorbisInfo;")
    public final VorbisInfo aVorbisInfo1 = new VorbisInfo();

    @OriginalMember(owner = "client!ik", name = "E", descriptor = "Lclient!jagtheora/vorbis/VorbisComment;")
    public final VorbisComment aVorbisComment1 = new VorbisComment();

    @OriginalMember(owner = "client!ik", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggVorbisStream(@OriginalArg(0) OggStreamState arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!ik", name = "b", descriptor = "(I)V")
    @Override
    public void stop() {
        if (this.aVorbisBlock1 != null) {
            this.aVorbisBlock1.cleanUp();
        }
        if (this.aDSPState1 != null) {
            this.aDSPState1.cleanUp();
        }
        this.aVorbisComment1.cleanUp();
        this.aVorbisInfo1.cleanUp();
        if (this.aClass2_Sub6_Sub5_1 != null) {
            this.aClass2_Sub6_Sub5_1.method9141();
        }
    }

    @OriginalMember(owner = "client!ik", name = "c", descriptor = "(I)Lclient!wc;")
    public Node_Sub6_Sub5 method3960() {
        return this.aClass2_Sub6_Sub5_1;
    }

    @OriginalMember(owner = "client!ik", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    @Override
    protected void decode(@OriginalArg(1) OggPacket packet) {
        if (super.packetNumber < 3) {
            @Pc(137) int local137 = this.aVorbisInfo1.headerIn(this.aVorbisComment1, packet);
            if (local137 < 0) {
                throw new IllegalStateException(String.valueOf(local137));
            }
            if (super.packetNumber == 2) {
                if (this.aVorbisInfo1.channels > 2 || this.aVorbisInfo1.channels < 1) {
                    throw new RuntimeException(String.valueOf(this.aVorbisInfo1.channels));
                }
                this.aDSPState1 = new DSPState(this.aVorbisInfo1);
                this.aVorbisBlock1 = new VorbisBlock(this.aDSPState1);
                this.aClass224_1 = new Class224(this.aVorbisInfo1.rate, Static686.anInt8944);
                this.aClass2_Sub6_Sub5_1 = new Node_Sub6_Sub5(this.aVorbisInfo1.channels);
            }
            return;
        }
        if (this.aVorbisBlock1.synthesis(packet) == 0) {
            this.aDSPState1.blockIn(this.aVorbisBlock1);
        }
        @Pc(35) float[][] local35 = this.aDSPState1.pcmOut(this.aVorbisInfo1.channels);
        this.aDouble14 = this.aDSPState1.granuleTime();
        if (this.aDouble14 == -1.0D) {
            this.aDouble14 = (double) ((float) this.anInt4396 / (float) this.aVorbisInfo1.rate);
        }
        this.aDSPState1.read(local35[0].length);
        this.anInt4396 += local35[0].length;
        @Pc(85) DoublyLinkedNode_Sub2_Sub8 local85 = this.aClass2_Sub6_Sub5_1.method9142(local35[0].length, this.aDouble14);
        Static373.method5300(local35, local85.aShortArrayArray3);
        for (@Pc(93) int local93 = 0; local93 < this.aVorbisInfo1.channels; local93++) {
            local85.aShortArrayArray3[local93] = this.aClass224_1.method5237(local85.aShortArrayArray3[local93]);
        }
        this.aClass2_Sub6_Sub5_1.method9143(local85);
    }

    @OriginalMember(owner = "client!ik", name = "b", descriptor = "(B)D")
    public double getTime() {
        @Pc(13) double local13 = this.aDouble14;
        if (this.aClass2_Sub6_Sub5_1 != null) {
            local13 = this.aClass2_Sub6_Sub5_1.method9137(false);
            if (local13 < 0.0D) {
                local13 = this.aDouble14;
            }
        }
        return (double) -(256.0F / (float) Static686.anInt8944) + local13;
    }

    @OriginalMember(owner = "client!ik", name = "h", descriptor = "(I)I")
    public int method3965() {
        return this.aClass2_Sub6_Sub5_1 == null ? 0 : this.aClass2_Sub6_Sub5_1.method9140();
    }
}
