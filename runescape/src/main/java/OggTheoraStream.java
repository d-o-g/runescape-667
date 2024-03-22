import com.jagex.core.util.SystemTimer;
import com.jagex.game.runetek6.sound.OggStream;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import jagtheora.theora.DecoderContext;
import jagtheora.theora.Frame;
import jagtheora.theora.GranulePos;
import jagtheora.theora.SetupInfo;
import jagtheora.theora.TheoraComment;
import jagtheora.theora.TheoraInfo;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!mda")
public final class OggTheoraStream extends OggStream {

    @OriginalMember(owner = "client!mda", name = "X", descriptor = "Lclient!jagtheora/theora/DecoderContext;")
    public DecoderContext aDecoderContext1;

    @OriginalMember(owner = "client!mda", name = "G", descriptor = "I")
    public int anInt6115;

    @OriginalMember(owner = "client!mda", name = "V", descriptor = "Z")
    public boolean aBoolean460;

    @OriginalMember(owner = "client!mda", name = "D", descriptor = "Lclient!st;")
    public Sprite aSprite_29;

    @OriginalMember(owner = "client!mda", name = "J", descriptor = "Z")
    public boolean aBoolean461;

    @OriginalMember(owner = "client!mda", name = "A", descriptor = "J")
    public long aLong188;

    @OriginalMember(owner = "client!mda", name = "L", descriptor = "Z")
    public boolean aBoolean462;

    @OriginalMember(owner = "client!mda", name = "w", descriptor = "I")
    public int anInt6119;

    @OriginalMember(owner = "client!mda", name = "S", descriptor = "D")
    public double aDouble19;

    @OriginalMember(owner = "client!mda", name = "T", descriptor = "Lclient!jagtheora/theora/Frame;")
    public Frame aFrame7;

    @OriginalMember(owner = "client!mda", name = "I", descriptor = "Lclient!jagtheora/theora/GranulePos;")
    public GranulePos aGranulePos1;

    @OriginalMember(owner = "client!mda", name = "Q", descriptor = "Z")
    public boolean aBoolean463;

    @OriginalMember(owner = "client!mda", name = "N", descriptor = "Lclient!jagtheora/theora/SetupInfo;")
    public final SetupInfo aSetupInfo1 = new SetupInfo();

    @OriginalMember(owner = "client!mda", name = "R", descriptor = "Lclient!jagtheora/theora/TheoraInfo;")
    public final TheoraInfo aTheoraInfo1 = new TheoraInfo();

    @OriginalMember(owner = "client!mda", name = "y", descriptor = "Lclient!jagtheora/theora/TheoraComment;")
    public final TheoraComment aTheoraComment1 = new TheoraComment();

    @OriginalMember(owner = "client!mda", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggTheoraStream(@OriginalArg(0) OggStreamState arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!mda", name = "g", descriptor = "(I)F")
    public float frameRate() {
        return this.aBoolean463 && !this.aTheoraInfo1.b() ? (float) this.aTheoraInfo1.fpsNumerator / (float) this.aTheoraInfo1.fpsDenominator : 0.0F;
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(BI)V")
    public void method5490(@OriginalArg(1) int arg0) {
        this.anInt6119 = arg0;
        if (!this.aBoolean463) {
            return;
        }
        if (this.anInt6119 > this.anInt6115) {
            this.anInt6119 = this.anInt6115;
        }
        if (this.anInt6119 < 0) {
            this.anInt6119 = 0;
        }
        this.aDecoderContext1.setPostProcessingLevel(this.anInt6119);
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(Lclient!ha;I)Lclient!st;")
    public Sprite sprite(@OriginalArg(0) Toolkit toolkit) {
        if (this.aFrame7 == null) {
            return null;
        } else if (this.aBoolean462 || this.aSprite_29 == null) {
            this.aSprite_29 = toolkit.method7958(this.aFrame7.pixels, this.aFrame7.b, this.aFrame7.b, this.aFrame7.a, false);
            this.aBoolean462 = false;
            return this.aSprite_29;
        } else {
            return this.aSprite_29;
        }
    }

    @OriginalMember(owner = "client!mda", name = "b", descriptor = "(I)V")
    @Override
    public void stop() {
        if (this.aFrame7 != null) {
            this.aFrame7.cleanUp();
        }
        if (this.aDecoderContext1 != null) {
            this.aDecoderContext1.cleanUp();
            this.aDecoderContext1 = null;
        }
        if (this.aGranulePos1 != null) {
            this.aGranulePos1.cleanUp();
            this.aGranulePos1 = null;
        }
        this.aTheoraInfo1.cleanUp();
        this.aTheoraComment1.cleanUp();
        this.aSetupInfo1.cleanUp();
    }

    @OriginalMember(owner = "client!mda", name = "d", descriptor = "(I)J")
    public long getLastDecodeTime() {
        return this.aLong188;
    }

    @OriginalMember(owner = "client!mda", name = "c", descriptor = "(I)D")
    public double getTime() {
        return this.aDouble19;
    }

    @OriginalMember(owner = "client!mda", name = "b", descriptor = "(B)Z")
    public boolean isSetup() {
        return this.aBoolean463;
    }

    @OriginalMember(owner = "client!mda", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    @Override
    protected void decode(@OriginalArg(1) OggPacket packet) {
        @Pc(19) int local19;
        if (!this.aBoolean463) {
            local19 = this.aSetupInfo1.decodeHeader(this.aTheoraInfo1, this.aTheoraComment1, packet);
            if (local19 == 0) {
                this.aBoolean463 = true;
                if (this.aTheoraInfo1.frameWidth > 2048 || this.aTheoraInfo1.frameHeight > 1024) {
                    throw new IllegalStateException();
                }
                this.aDecoderContext1 = new DecoderContext(this.aTheoraInfo1, this.aSetupInfo1);
                this.aGranulePos1 = new GranulePos();
                this.aFrame7 = new Frame(this.aTheoraInfo1.frameWidth, this.aTheoraInfo1.frameHeight);
                this.anInt6115 = this.aDecoderContext1.getMaxPostProcessingLevel();
                this.method5490(this.anInt6119);
            } else if (local19 < 0) {
                throw new IllegalStateException(String.valueOf(local19));
            }
            return;
        }
        this.aLong188 = SystemTimer.safetime();
        local19 = this.aDecoderContext1.decodePacketIn(packet, this.aGranulePos1);
        if (local19 < 0) {
            throw new IllegalStateException(String.valueOf(local19));
        }
        this.aDecoderContext1.granuleFrame(this.aGranulePos1);
        this.aDouble19 = this.aDecoderContext1.granuleTime(this.aGranulePos1);
        if (this.aBoolean460) {
            @Pc(60) boolean local60 = packet.isKeyFrame() == 1;
            if (!local60) {
                return;
            }
            this.aBoolean460 = false;
        }
        if (!this.aBoolean461 || packet.isKeyFrame() == 1) {
            if (this.aDecoderContext1.decodeFrame(this.aFrame7) != 0) {
                throw new IllegalStateException(String.valueOf(local19));
            }
            this.aBoolean462 = true;
        }
    }
}
