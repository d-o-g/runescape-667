import com.jagex.collect.ref.key.CacheKey;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rla")
public final class SpriteCacheKey implements CacheKey {

    @OriginalMember(owner = "client!rla", name = "n", descriptor = "I")
    public int invCount;

    @OriginalMember(owner = "client!rla", name = "a", descriptor = "I")
    public int toolkitIndex;

    @OriginalMember(owner = "client!rla", name = "j", descriptor = "I")
    public int objId;

    @OriginalMember(owner = "client!rla", name = "b", descriptor = "I")
    public int outline;

    @OriginalMember(owner = "client!rla", name = "g", descriptor = "I")
    public int objNumMode;

    @OriginalMember(owner = "client!rla", name = "p", descriptor = "I")
    public int graphicShadow;

    @OriginalMember(owner = "client!rla", name = "l", descriptor = "Z")
    public boolean useAppearance;

    @OriginalMember(owner = "client!rla", name = "a", descriptor = "(I)J")
    @Override
    public long toLong() {
        // @formatter:off
        @Pc(5)   long[] crc64 = Packet.crc64table;
        @Pc(7)   long hash01 = -1L;
        @Pc(22)  long hash02 = (hash01 >>> 8) ^ crc64[(int) ((hash01 ^ (long) (this.toolkitIndex)) & 0xFFL)];
        @Pc(39)  long hash03 = (hash02 >>> 8) ^ crc64[(int) ((hash02 ^ (long) (this.objId >> 8)) & 0xFFL)];
        @Pc(61)  long hash04 = (hash03 >>> 8) ^ crc64[(int) ((hash03 ^ (long) (this.objId)) & 0xFFL)];
        @Pc(78)  long hash05 = (hash04 >>> 8) ^ crc64[(int) ((hash04 ^ (long) (this.invCount >> 24)) & 0xFFL)];
        @Pc(95)  long hash06 = (hash05 >>> 8) ^ crc64[(int) ((hash05 ^ (long) (this.invCount >> 16)) & 0xFFL)];
        @Pc(112) long hash07 = (hash06 >>> 8) ^ crc64[(int) ((hash06 ^ (long) (this.invCount >> 8)) & 0xFFL)];
        @Pc(127) long hash08 = (hash07 >>> 8) ^ crc64[(int) ((hash07 ^ (long) (this.invCount)) & 0xFFL)];
        @Pc(142) long hash09 = (hash08 >>> 8) ^ crc64[(int) ((hash08 ^ (long) (this.outline)) & 0xFFL)];
        @Pc(159) long hash10 = (hash09 >>> 8) ^ crc64[(int) ((hash09 ^ (long) (this.graphicShadow >> 24)) & 0xFFL)];
        @Pc(176) long hash11 = (hash10 >>> 8) ^ crc64[(int) ((hash10 ^ (long) (this.graphicShadow >> 16)) & 0xFFL)];
        @Pc(193) long hash12 = (hash11 >>> 8) ^ crc64[(int) ((hash11 ^ (long) (this.graphicShadow >> 8)) & 0xFFL)];
        @Pc(208) long hash13 = (hash12 >>> 8) ^ crc64[(int) ((hash12 ^ (long) this.graphicShadow) & 0xFFL)];
        @Pc(223) long hash14 = (hash13 >>> 8) ^ crc64[(int) ((hash13 ^ (long) (this.objNumMode)) & 0xFFL)];
                 long hash15 = (hash14 >>> 8) ^ crc64[(int) ((hash14 ^ (long) (this.useAppearance ? 1 : 0)) & 0xFFL)];
        // @formatter:on
        return hash15;
    }

    @OriginalMember(owner = "client!rla", name = "a", descriptor = "(ILclient!uq;)Z")
    @Override
    public boolean matches(@OriginalArg(1) CacheKey other) {
        if (!(other instanceof SpriteCacheKey)) {
            return false;
        }

        @Pc(12) SpriteCacheKey data = (SpriteCacheKey) other;
        if (this.toolkitIndex != data.toolkitIndex) {
            return false;
        } else if (data.objId != this.objId) {
            return false;
        } else if (this.invCount != data.invCount) {
            return false;
        } else if (data.outline != this.outline) {
            return false;
        } else if (this.graphicShadow != data.graphicShadow) {
            return false;
        } else if (this.objNumMode != data.objNumMode) {
            return false;
        } else if (data.useAppearance != this.useAppearance) {
            return false;
        } else {
            return true;
        }
    }
}
