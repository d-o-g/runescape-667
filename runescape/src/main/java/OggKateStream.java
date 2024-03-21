import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.sound.OggStream;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!un")
public final class OggKateStream extends OggStream {

    @OriginalMember(owner = "client!un", name = "J", descriptor = "Ljava/lang/String;")
    public String subtitle;

    @OriginalMember(owner = "client!un", name = "D", descriptor = "Ljava/lang/String;")
    public String aString116;

    @OriginalMember(owner = "client!un", name = "w", descriptor = "I")
    public int anInt9757;

    @OriginalMember(owner = "client!un", name = "x", descriptor = "F")
    public float endTime;

    @OriginalMember(owner = "client!un", name = "s", descriptor = "Ljava/lang/String;")
    public String aString117;

    @OriginalMember(owner = "client!un", name = "F", descriptor = "F")
    public float startTime;

    @OriginalMember(owner = "client!un", name = "r", descriptor = "I")
    public int anInt9764;

    @OriginalMember(owner = "client!un", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggKateStream(@OriginalArg(0) OggStreamState arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!un", name = "i", descriptor = "(I)F")
    public float getStartTime() {
        return this.startTime;
    }

    @OriginalMember(owner = "client!un", name = "c", descriptor = "(I)Ljava/lang/String;")
    public String method8563() {
        return this.aString116;
    }

    @OriginalMember(owner = "client!un", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    @Override
    protected void decode(@OriginalArg(1) OggPacket packet) {
        if (super.packetNumber > 0 && !"SUB".equals(this.aString117)) {
            return;
        }
        @Pc(31) Packet local31 = new Packet(packet.getData());
        @Pc(35) int local35 = local31.g1();
        if (super.packetNumber > 8) {
            if (local35 == 0) {
                @Pc(47) long local47 = local31.ig8();
                @Pc(51) long local51 = local31.ig8();
                @Pc(55) long local55 = local31.ig8();
                if (local47 < 0L || local51 < 0L || local55 < 0L || local47 < local55) {
                    throw new IllegalStateException();
                }
                this.endTime = (float) ((long) this.anInt9757 * (local47 + local51)) / (float) this.anInt9764;
                this.startTime = (float) ((long) this.anInt9757 * local47) / (float) this.anInt9764;
                @Pc(121) int local121 = local31.ig4();
                if (local121 < 0 || local31.data.length - local31.pos < local121) {
                    throw new IllegalStateException();
                }
                this.subtitle = Static366.method5264(local121, local31.data, local31.pos);
            }
            if ((local35 | 0x80) != 0) {
                return;
            }
            return;
        }
        if ((local35 | 0x80) == 0) {
            throw new IllegalStateException();
        }
        if (super.packetNumber != 0) {
            return;
        }
        local31.pos += 23;
        this.anInt9764 = local31.ig4();
        this.anInt9757 = local31.ig4();
        if (this.anInt9764 == 0 || this.anInt9757 == 0) {
            throw new IllegalStateException();
        }
        @Pc(211) Packet local211 = new Packet(16);
        local31.gdata(0, 16, local211.data);
        this.aString116 = local211.gjstr();
        local211.pos = 0;
        local31.gdata(0, 16, local211.data);
        this.aString117 = local211.gjstr();
    }

    @OriginalMember(owner = "client!un", name = "g", descriptor = "(I)Ljava/lang/String;")
    public String getSubtitle() {
        return this.subtitle;
    }

    @OriginalMember(owner = "client!un", name = "d", descriptor = "(I)F")
    public float getEndTime() {
        return this.endTime;
    }

    @OriginalMember(owner = "client!un", name = "b", descriptor = "(I)V")
    @Override
    public void stop() {
    }
}
