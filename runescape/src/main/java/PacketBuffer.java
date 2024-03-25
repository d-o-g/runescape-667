import com.jagex.core.crypto.Isaac;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rka")
public final class PacketBuffer extends Packet {

    @OriginalMember(owner = "client!ut", name = "L", descriptor = "[I")
    public static final int[] BIT_MASKS = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535,
        131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431,
        67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647, -1
    };

    @OriginalMember(owner = "client!rka", name = "Sb", descriptor = "Lclient!iv;")
    public Isaac cipher;

    @OriginalMember(owner = "client!rka", name = "Rb", descriptor = "I")
    public int bitIndex;

    @OriginalMember(owner = "client!rka", name = "<init>", descriptor = "(I)V")
    public PacketBuffer(@OriginalArg(0) int size) {
        super(size);
    }

    @OriginalMember(owner = "client!rka", name = "y", descriptor = "(I)V")
    public void exitBitMode() {
        super.pos = (this.bitIndex + 7) / 8;
    }

    @OriginalMember(owner = "client!rka", name = "c", descriptor = "(BI)I")
    public int readBits(@OriginalArg(1) int n) {
        @Pc(10) int index = this.bitIndex >> 3;
        @Pc(18) int interest = 8 - (this.bitIndex & 0x7);
        @Pc(20) int v = 0;

        this.bitIndex += n;

        while (interest < n) {
            v += (BIT_MASKS[interest] & super.data[index++]) << n - interest;
            n -= interest;
            interest = 8;
        }

        if (n == interest) {
            v += super.data[index] & BIT_MASKS[interest];
        } else {
            v += super.data[index] >> interest - n & BIT_MASKS[n];
        }

        return v;
    }

    @OriginalMember(owner = "client!rka", name = "j", descriptor = "(Z)Z")
    public boolean largeOpcode() {
        @Pc(22) int local22 = super.data[super.pos] - this.cipher.peek() & 0xFF;
        return local22 >= 128;
    }

    @OriginalMember(owner = "client!rka", name = "a", descriptor = "([IB)V")
    public void method7415(@OriginalArg(0) int[] arg0) {
        this.cipher = new Isaac(arg0);
    }

    @OriginalMember(owner = "client!rka", name = "a", descriptor = "([BIIZ)V")
    public void method7416(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1) {
        for (@Pc(7) int local7 = 0; local7 < arg1; local7++) {
            arg0[local7] = (byte) (super.data[super.pos++] - this.cipher.next());
        }
    }

    @OriginalMember(owner = "client!rka", name = "w", descriptor = "(I)V")
    public void enterBitMode() {
        this.bitIndex = super.pos * 8;
    }

    @OriginalMember(owner = "client!rka", name = "n", descriptor = "(II)V")
    public void method7418(@OriginalArg(1) int arg0) {
        super.data[super.pos++] = (byte) (arg0 + this.cipher.next());
    }

    @OriginalMember(owner = "client!rka", name = "m", descriptor = "(II)I")
    public int bitsRemaining(@OriginalArg(0) int arg0) {
        return arg0 * 8 - this.bitIndex;
    }

    @OriginalMember(owner = "client!rka", name = "x", descriptor = "(I)I")
    public int method7421() {
        @Pc(30) int local30 = super.data[super.pos++] - this.cipher.next() & 0xFF;
        return local30 < 128 ? local30 : (super.data[super.pos++] - this.cipher.next() & 0xFF) + (local30 - 128 << 8);
    }

    @OriginalMember(owner = "client!rka", name = "a", descriptor = "(Lclient!iv;I)V")
    public void method7422(@OriginalArg(0) Isaac arg0) {
        this.cipher = arg0;
    }
}
