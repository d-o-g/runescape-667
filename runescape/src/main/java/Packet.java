import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.math.BigInteger;

@OriginalClass("client!ge")
public class Packet extends Node {

    public static final int CRC32_POLYNOMIAL = 0xEDB88320;

    @OriginalMember(owner = "client!vl", name = "i", descriptor = "[I")
    public static final int[] crctable = new int[256];

    static {
        for (@Pc(43) int i = 0; i < 256; i++) {
            @Pc(46) int j = i;
            for (@Pc(48) int k = 0; k < 8; k++) {
                if ((j & 0x1) == 1) {
                    j = j >>> 1 ^ CRC32_POLYNOMIAL;
                } else {
                    j >>>= 0x1;
                }
            }
            crctable[i] = j;
        }
    }

    @OriginalMember(owner = "client!ah", name = "a", descriptor = "(BII[B)I")
    public static int getcrc(@OriginalArg(1) int len, @OriginalArg(2) int off, @OriginalArg(3) byte[] src) {
        @Pc(11) int crc = -1;
        for (@Pc(13) int i = off; i < len; i++) {
            crc = crc >>> 8 ^ crctable[(crc ^ src[i]) & 0xFF];
        }
        return ~crc;
    }

    @OriginalMember(owner = "client!sl", name = "a", descriptor = "(IZ[B)I")
    public static int getcrc(@OriginalArg(0) int len, @OriginalArg(2) byte[] src) {
        return getcrc(len, 0, src);
    }

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "[[B")
    public static final byte[][] smallCache = new byte[50][];

    @OriginalMember(owner = "client!qg", name = "V", descriptor = "[[B")
    public static final byte[][] mediumCache = new byte[250][];

    @OriginalMember(owner = "client!ifa", name = "c", descriptor = "[[B")
    public static final byte[][] largeCache = new byte[1000][];

    @OriginalMember(owner = "client!bba", name = "I", descriptor = "I")
    public static int smallPos = 0;

    @OriginalMember(owner = "client!vp", name = "F", descriptor = "I")
    public static int mediumPos = 0;

    @OriginalMember(owner = "client!wb", name = "ab", descriptor = "I")
    public static int largePos = 0;

    @OriginalMember(owner = "client!gf", name = "h", descriptor = "[[[B")
    public static byte[][][] aByteArrayArrayArray2;

    @OriginalMember(owner = "client!ab", name = "t", descriptor = "[I")
    public static int[] anIntArray13;

    @OriginalMember(owner = "client!hj", name = "l", descriptor = "[I")
    public static int[] anIntArray311;

    @OriginalMember(owner = "client!gda", name = "a", descriptor = "(ZI)[B")
    private static synchronized byte[] allocate(@OriginalArg(1) int size) {
        @Pc(18) byte[] data;
        if (size == 100 && largePos > 0) {
            data = largeCache[--largePos];
            largeCache[largePos] = null;
            return data;
        } else if (size == 5000 && mediumPos > 0) {
            data = mediumCache[--mediumPos];
            mediumCache[mediumPos] = null;
            return data;
        } else if (size == 30000 && smallPos > 0) {
            data = smallCache[--smallPos];
            smallCache[smallPos] = null;
            return data;
        } else {
            if (aByteArrayArrayArray2 != null) {
                for (@Pc(82) int i = 0; i < anIntArray13.length; i++) {
                    if (size == anIntArray13[i] && anIntArray311[i] > 0) {
                        @Pc(111) byte[] data2 = aByteArrayArrayArray2[i][--anIntArray311[i]];
                        aByteArrayArrayArray2[i][anIntArray311[i]] = null;
                        return data2;
                    }
                }
            }
            return new byte[size];
        }
    }

    @OriginalMember(owner = "client!gda", name = "a", descriptor = "([BI)V")
    public static synchronized void cache(@OriginalArg(0) byte[] data) {
        if (data.length == 100 && largePos < 1000) {
            largeCache[largePos++] = data;
        } else if (data.length == 5000 && mediumPos < 250) {
            mediumCache[mediumPos++] = data;
        } else if (data.length == 30000 && smallPos < 50) {
            smallCache[smallPos++] = data;
        } else if (aByteArrayArrayArray2 != null) {
            for (@Pc(77) int i = 0; i < anIntArray13.length; i++) {
                if (anIntArray13[i] == data.length && aByteArrayArrayArray2[i].length > anIntArray311[i]) {
                    aByteArrayArrayArray2[i][anIntArray311[i]++] = data;
                    return;
                }
            }
        }
    }

    @OriginalMember(owner = "client!ge", name = "Y", descriptor = "I")
    public int pos;

    @OriginalMember(owner = "client!ge", name = "ib", descriptor = "[B")
    public byte[] data;

    @OriginalMember(owner = "client!ge", name = "<init>", descriptor = "(I)V")
    public Packet(@OriginalArg(0) int size) {
        this.pos = 0;
        this.data = allocate(size);
    }

    @OriginalMember(owner = "client!ge", name = "<init>", descriptor = "([B)V")
    public Packet(@OriginalArg(0) byte[] data) {
        this.data = data;
        this.pos = 0;
    }

    @OriginalMember(owner = "client!ge", name = "g", descriptor = "(B)I")
    public final int method7339() {
        this.pos += 4;

        return (this.data[this.pos - 4] & 0xFF)
            + ((this.data[this.pos - 2] & 0xFF) << 16)
            + ((this.data[this.pos - 1] & 0xFF) << 24)
            + ((this.data[this.pos - 3] & 0xFF) << 8);
    }

    @OriginalMember(owner = "client!ge", name = "n", descriptor = "(I)I")
    public final int method7340() {
        this.pos += 4;

        return ((this.data[this.pos - 1] & 0xFF) << 16)
            + ((this.data[this.pos - 2] & 0xFF) << 24)
            + ((this.data[this.pos - 4] & 0xFF) << 8)
            + (this.data[this.pos - 3] & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(IZ)V")
    public final void p1_alt2(@OriginalArg(0) int value) {
        this.data[this.pos++] = (byte) -value;
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(BI)V")
    public final void p4(@OriginalArg(1) int value) {
        this.data[this.pos++] = (byte) (value >> 24);
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    @OriginalMember(owner = "client!ge", name = "h", descriptor = "(B)Ljava/lang/String;")
    public final String gjstr2() {
        @Pc(14) byte version = this.data[this.pos++];

        if (version != 0) {
            throw new IllegalStateException("Bad version number in gjstr2");
        } else {
            @Pc(27) int start = this.pos;

            while (this.data[this.pos++] != 0) {
                /* empty */
            }

            @Pc(55) int length = this.pos - start - 1;

            if (length == 0) {
                return "";
            } else {
                return Static350.cp1252Decode(start, this.data, length);
            }
        }
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(II[BI)V")
    public final void gdata(@OriginalArg(0) int off, @OriginalArg(1) int len, @OriginalArg(2) byte[] dest) {
        for (@Pc(1) int i = off; i < len + off; i++) {
            dest[i] = this.data[this.pos++];
        }
    }

    @OriginalMember(owner = "client!ge", name = "d", descriptor = "(Z)I")
    public final int method7345() {
        @Pc(5) int local5 = 0;
        @Pc(9) int local9;
        for (local9 = this.gsmart(); local9 == Short.MAX_VALUE; local9 = this.gsmart()) {
            local5 += Short.MAX_VALUE;
        }
        return local5 + local9;
    }

    @OriginalMember(owner = "client!ge", name = "f", descriptor = "(Z)I")
    public final int method7346() {
        if (this.data[this.pos] < 0) {
            return this.method7349() & Integer.MAX_VALUE;
        } else {
            @Pc(26) int value = this.g2();

            if (value == Short.MAX_VALUE){
                return -1;
            } else {
                return value;
            }
        }
    }

    @OriginalMember(owner = "client!ge", name = "d", descriptor = "(IB)V")
    public final void method7347(@OriginalArg(0) int arg0) {
        this.data[this.pos++] = (byte) (arg0 >> 16);
        this.data[this.pos++] = (byte) (arg0 >> 24);
        this.data[this.pos++] = (byte) arg0;
        this.data[this.pos++] = (byte) (arg0 >> 8);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(Z)B")
    public final byte g1b_alt3() {
        return (byte) ((Byte.MAX_VALUE + 1) - this.data[this.pos++]);
    }

    @OriginalMember(owner = "client!ge", name = "j", descriptor = "(I)I")
    public final int method7349() {
        this.pos += 4;

        return ((this.data[this.pos - 4] & 0xFF) << 24)
            + ((this.data[this.pos - 3] & 0xFF) << 16)
            + ((this.data[this.pos - 2] & 0xFF) << 8)
            + (this.data[this.pos - 1] & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(ZI)V")
    public final void method7350(@OriginalArg(1) int arg0) {
        this.data[this.pos++] = (byte) (arg0 >> 8);
        this.data[this.pos++] = (byte) arg0;
        this.data[this.pos++] = (byte) (arg0 >> 24);
        this.data[this.pos++] = (byte) (arg0 >> 16);
    }

    @OriginalMember(owner = "client!ge", name = "h", descriptor = "(I)I")
    public final int method7351() {
        this.pos += 4;
        return (this.data[this.pos - 4] & 0xFF) + (((this.data[this.pos - 1] & 0xFF) << 24) + ((this.data[this.pos - 2] & 0xFF) << 16) + ((this.data[this.pos + -3] & 0xFF) << 8));
    }

    @OriginalMember(owner = "client!ge", name = "j", descriptor = "(II)V")
    public final void psmarts(@OriginalArg(0) int value) {
        if (value >= 0 && value <= Byte.MAX_VALUE) {
            this.p1(value);
        } else if (value >= 0 && value <= Short.MAX_VALUE) {
            this.p2(value + (Short.MAX_VALUE + 1));
        } else {
            throw new IllegalArgumentException("psmarts out of range - val:" + value);
        }
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(IZ)I")
    public final int addcrc(@OriginalArg(0) int off) {
        @Pc(18) int crc = getcrc(this.pos, off, this.data);
        this.p4(crc);
        return crc;
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(II)V")
    public final void method7354(@OriginalArg(1) int value) {
        this.data[this.pos++] = (byte) value;
        this.data[this.pos++] = (byte) (value >> 8);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "([II)V")
    public final void xteaDecrypt(@OriginalArg(0) int[] key) {
        @Pc(17) int blocks = this.pos / 8;
        this.pos = 0;
        for (@Pc(22) int i = 0; i < blocks; i++) {
            @Pc(28) int v0 = this.method7349();
            @Pc(32) int v1 = this.method7349();
            @Pc(34) int sum = -957401312;
            @Pc(38) int rounds = 32;
            while (rounds-- > 0) {
                v1 -= (v0 >>> 5 ^ v0 << 4) + v0 ^ sum + key[sum >>> 11 & 0x3];
                sum -= -1640531527;
                v0 -= sum + key[sum & 0x3] ^ v1 + (v1 << 4 ^ v1 >>> 5);
            }
            this.pos -= 8;
            this.p4(v0);
            this.p4(v1);
        }
    }

    @OriginalMember(owner = "client!ge", name = "q", descriptor = "(I)I")
    public final int method7356() {
        this.pos += 2;

        @Pc(42) int value = (this.data[this.pos - 1] & 0xFF)
            + ((this.data[this.pos - 2] & 0xFF) << 8);

        if (value > Short.MAX_VALUE) {
            value -= 65536;
        }
        return value;
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(II)V")
    public final void method7357(@OriginalArg(0) int value) {
        this.data[this.pos - value - 2] = (byte) (value >> 8);
        this.data[this.pos - value - 1] = (byte) value;
    }

    @OriginalMember(owner = "client!ge", name = "o", descriptor = "(I)Ljava/lang/String;")
    public final String gjstr() {
        @Pc(6) int off = this.pos;

        while (this.data[this.pos++] != 0) {
            /* empty */
        }

        @Pc(29) int length = this.pos - off - 1;

        if (length == 0) {
            return "";
        } else {
            return Static350.cp1252Decode(off, this.data, length);
        }
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(B)J")
    public final long method7359() {
        @Pc(16) long local16 = (long) this.method7351() & 0xFFFFFFFFL;
        @Pc(23) long local23 = (long) this.method7351() & 0xFFFFFFFFL;
        return local16 + (local23 << 32);
    }

    @OriginalMember(owner = "client!ge", name = "k", descriptor = "(I)I")
    public final int gsmarts() {
        @Pc(11) int value = this.data[this.pos] & 0xFF;
        if (value <= Byte.MAX_VALUE) {
            return this.g1() - 64;
        } else {
            return this.g2() - 49152;
        }
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(Ljava/lang/String;I)V")
    public final void pjstr2(@OriginalArg(0) String arg0) {
        @Pc(15) int local15 = arg0.indexOf(0);
        if (local15 >= 0) {
            throw new IllegalArgumentException("NUL character at " + local15 + " - cannot pjstr2");
        }
        this.data[this.pos++] = 0;
        this.pos += Static331.cp1252Encode(arg0, arg0.length(), this.data, this.pos);
        this.data[this.pos++] = 0;
    }

    @OriginalMember(owner = "client!ge", name = "h", descriptor = "(II)V")
    public final void ip2(@OriginalArg(0) int value) {
        this.data[this.pos++] = (byte) value;
        this.data[this.pos++] = (byte) (value >> 8);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(JI)V")
    public final void p8(@OriginalArg(0) long arg0) {
        this.data[this.pos++] = (byte) (int) (arg0 >> 56);
        this.data[this.pos++] = (byte) (int) (arg0 >> 48);
        this.data[this.pos++] = (byte) (int) (arg0 >> 40);
        this.data[this.pos++] = (byte) (int) (arg0 >> 32);
        this.data[this.pos++] = (byte) (int) (arg0 >> 24);
        this.data[this.pos++] = (byte) (int) (arg0 >> 16);
        this.data[this.pos++] = (byte) (int) (arg0 >> 8);
        this.data[this.pos++] = (byte) (int) arg0;
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(Z)I")
    public final int method7364() {
        if (this.data[this.pos] >= 0) {
            return this.g2();
        } else {
            return this.method7349() & Integer.MAX_VALUE;
        }
    }

    @OriginalMember(owner = "client!ge", name = "v", descriptor = "(I)V")
    public final void cache() {
        if (this.data != null) {
            cache(this.data);
        }
        this.data = null;
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "([IIZI)V")
    public final void method7366(@OriginalArg(0) int[] key, @OriginalArg(1) int start, @OriginalArg(3) int end) {
        @Pc(6) int oldPos = this.pos;
        this.pos = start;
        @Pc(15) int blocks = (end - start) / 8;
        for (@Pc(17) int i = 0; i < blocks; i++) {
            @Pc(22) int v0 = this.method7349();
            @Pc(26) int v1 = this.method7349();
            @Pc(28) int sum = 0;
            @Pc(32) int rounds = 32;
            while (rounds-- > 0) {
                v0 += v1 + (v1 << 4 ^ v1 >>> 5) ^ sum + key[sum & 0x3];
                sum -= 1640531527;
                v1 += (v0 >>> 5 ^ v0 << 4) + v0 ^ sum + key[sum >>> 11 & 0xE8C00003];
            }
            this.pos -= 8;
            this.p4(v0);
            this.p4(v1);
        }
        this.pos = oldPos;
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(IB)V")
    public final void method7367(@OriginalArg(0) int value) {
        this.data[this.pos - value - 4] = (byte) (value >> 24);
        this.data[this.pos - value - 3] = (byte) (value >> 16);
        this.data[this.pos - value - 2] = (byte) (value >> 8);
        this.data[this.pos - value - 1] = (byte) value;
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(BIJ)V")
    public final void pVarLong(@OriginalArg(1) int bytes, @OriginalArg(2) long value) {
        @Pc(0) int size = bytes - 1;
        if (size >= 0 && size < Byte.SIZE) {
            for (@Pc(30) int bits = size * Byte.SIZE; bits >= 0; bits -= Byte.SIZE) {
                this.data[this.pos++] = (byte) (int) (value >> bits);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!ge", name = "d", descriptor = "(II)V")
    public final void method7370(@OriginalArg(1) int arg0) {
        this.data[this.pos++] = (byte) (arg0 + (Byte.MAX_VALUE + 1));
        this.data[this.pos++] = (byte) (arg0 >> 8);
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(Z)I")
    public final int method7371() {
        this.pos += 4;

        return ((this.data[this.pos - 4] & 0xFF) << 16)
            + (((this.data[this.pos - 3] & 0xFF) << 24)
            + ((this.data[this.pos - 1] & 0xFF) << 8))
            + (this.data[this.pos - 2] & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "e", descriptor = "(B)I")
    public final int method7372() {
        this.pos += 2;

        return ((this.data[this.pos - 1] & 0xFF) << 8)
            + (this.data[this.pos - 2] & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "k", descriptor = "(II)V")
    public final void p2(@OriginalArg(0) int arg0) {
        this.data[this.pos++] = (byte) (arg0 >> 8);
        this.data[this.pos++] = (byte) arg0;
    }

    @OriginalMember(owner = "client!ge", name = "t", descriptor = "(I)I")
    public final int g1_alt1() {
        return (this.data[this.pos++] - (Byte.MAX_VALUE + 1)) & 0xFF;
    }

    @OriginalMember(owner = "client!ge", name = "u", descriptor = "(I)I")
    public final int method7375() {
        this.pos += 2;
        @Pc(33) int value = ((this.data[this.pos - 1] & 0xFF) << 8) + ((this.data[this.pos - 2] - (Byte.MAX_VALUE + 1)) & 0xFF);
        if (value > Short.MAX_VALUE) {
            value -= 65536;
        }
        return value;
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(B)I")
    public final int g1_alt3() {
        return ((Byte.MAX_VALUE + 1) - this.data[this.pos++]) & 0xFF;
    }

    @OriginalMember(owner = "client!ge", name = "j", descriptor = "(B)B")
    public final byte g1b() {
        return this.data[this.pos++];
    }

    @OriginalMember(owner = "client!ge", name = "g", descriptor = "(II)V")
    public final void p4_alt1(@OriginalArg(1) int value) {
        this.data[this.pos++] = (byte) value;
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 24);
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(I)Z")
    public final boolean checkcrc() {
        this.pos -= 4;
        @Pc(17) int actual = getcrc(this.pos, 0, this.data);
        @Pc(21) int expected = this.method7349();
        return actual == expected;
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(IB)V")
    public final void method7380(@OriginalArg(0) int value) {
        this.data[this.pos - value - 1] = (byte) value;
    }

    @OriginalMember(owner = "client!ge", name = "b", descriptor = "(I)I")
    public final int g2s() {
        this.pos += 2;
        @Pc(39) int value = (this.data[this.pos - 2] & 0xFF) + ((this.data[this.pos - 1] & 0xFF) << 8);
        if (value > Short.MAX_VALUE) {
            value -= 65536;
        }
        return value;
    }

    @OriginalMember(owner = "client!ge", name = "g", descriptor = "(I)I")
    public final int g2() {
        this.pos += 2;

        return (this.data[this.pos - 1] & 0xFF)
            + ((this.data[this.pos - 2] & 0xFF) << 8);
    }

    @OriginalMember(owner = "client!ge", name = "m", descriptor = "(I)I")
    public final int method7383() {
        this.pos += 3;

        return ((this.data[this.pos - 2] & 0xFF) << 8)
            + ((this.data[this.pos - 3] & 0xFF) << 16)
            + (this.data[this.pos - 1] & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(IB)V")
    public final void p1_alt1(@OriginalArg(0) int value) {
        this.data[this.pos++] = (byte) (value + (Byte.MAX_VALUE + 1));
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(ILjava/math/BigInteger;Ljava/math/BigInteger;)V")
    public final void rsaenc(@OriginalArg(1) BigInteger modulus, @OriginalArg(2) BigInteger exponent) {
        @Pc(6) int len = this.pos;
        this.pos = 0;
        @Pc(12) byte[] inBytes = new byte[len];
        this.gdata(0, len, inBytes);
        @Pc(23) BigInteger in = new BigInteger(inBytes);
        @Pc(28) BigInteger out = in.modPow(exponent, modulus);
        @Pc(31) byte[] outBytes = out.toByteArray();
        this.pos = 0;
        this.p2(outBytes.length);
        this.pdata(outBytes.length, outBytes, 0);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(IB[BI)V")
    public final void pdata(@OriginalArg(0) int len, @OriginalArg(2) byte[] data, @OriginalArg(3) int off) {
        for (@Pc(6) int i = off; i < len + off; i++) {
            this.data[this.pos++] = data[i];
        }
    }

    @OriginalMember(owner = "client!ge", name = "s", descriptor = "(I)I")
    public final int method7387() {
        this.pos += 2;

        return ((this.data[this.pos - 2] & 0xFF) << 8)
            + ((this.data[this.pos - 1] - (Byte.MAX_VALUE + 1)) & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(BI)V")
    public final void p3(@OriginalArg(1) int value) {
        this.data[this.pos++] = (byte) (value >> 16);
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) value;
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(IZ)V")
    public final void p1(@OriginalArg(0) int arg0) {
        this.data[this.pos++] = (byte) arg0;
    }

    @OriginalMember(owner = "client!ge", name = "i", descriptor = "(Z)I")
    public final int gsmart() {
        @Pc(20) int value = this.data[this.pos] & 0xFF;

        if (value <= Byte.MAX_VALUE) {
            return this.g1();
        } else {
            return this.g2() - (Short.MAX_VALUE + 1);
        }
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public final void pjstr(@OriginalArg(0) String string) {
        @Pc(7) int nul = string.indexOf(0);
        if (nul >= 0) {
            throw new IllegalArgumentException("NUL character at " + nul + " - cannot pjstr");
        }
        this.pos += Static331.cp1252Encode(string, string.length(), this.data, this.pos);
        this.data[this.pos++] = 0;
    }

    @OriginalMember(owner = "client!ge", name = "f", descriptor = "(B)I")
    public final int g3s() {
        this.pos += 3;

        @Pc(43) int value = (this.data[this.pos - 1] & 0xFF)
            + ((this.data[this.pos - 3] & 0xFF) << 16)
            + ((this.data[this.pos + -2] & 0xFF) << 8);

        if (value > 8388607) {
            value -= 16777216;
        }

        return value;
    }

    @OriginalMember(owner = "client!ge", name = "c", descriptor = "(II)V")
    public final void p2_alt2(@OriginalArg(0) int value) {
        this.data[this.pos++] = (byte) (value >> 8);
        this.data[this.pos++] = (byte) (value + (Byte.MAX_VALUE + 1));
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(I[III)V")
    public final void xteaEncrypt(@OriginalArg(1) int[] key, @OriginalArg(2) int end) {
        @Pc(6) int oldPos = this.pos;
        this.pos = 5;
        @Pc(16) int blokcs = (end - 5) / 8;
        for (@Pc(27) int i = 0; i < blokcs; i++) {
            @Pc(34) int v0 = this.method7349();
            @Pc(38) int v1 = this.method7349();
            @Pc(40) int sum = -957401312;
            @Pc(44) int rounds = 32;
            while (rounds-- > 0) {
                v1 -= (v0 << 4 ^ v0 >>> 5) + v0 ^ key[sum >>> 11 & 0x3] + sum;
                sum -= -1640531527;
                v0 -= v1 + (v1 >>> 5 ^ v1 << 4) ^ sum - -key[sum & 0x3];
            }
            this.pos -= 8;
            this.p4(v0);
            this.p4(v1);
        }
        this.pos = oldPos;
    }

    @OriginalMember(owner = "client!ge", name = "e", descriptor = "(II)V")
    public final void method7395(@OriginalArg(1) int arg0) {
        if ((arg0 & 0xFFFFFF80) != 0) {
            if ((arg0 & 0xFFFFC000) != 0) {
                if ((arg0 & 0xFFE00000) != 0) {
                    if ((arg0 & 0xF0000000) != 0) {
                        this.p1(arg0 >>> 28 | 0x80);
                    }
                    this.p1(arg0 >>> 21 | 0x80);
                }
                this.p1(arg0 >>> 14 | 0x80);
            }
            this.p1(arg0 >>> 7 | 0x80);
        }
        this.p1(arg0 & 0x7F);
    }

    @OriginalMember(owner = "client!ge", name = "r", descriptor = "(I)I")
    public final int g1() {
        return this.data[this.pos++] & 0xFF;
    }

    @OriginalMember(owner = "client!ge", name = "l", descriptor = "(I)J")
    public final long method7398() {
        @Pc(10) long local10 = (long) this.method7349() & 0xFFFFFFFFL;
        @Pc(19) long local19 = (long) this.method7349() & 0xFFFFFFFFL;
        return local19 + (local10 << 32);
    }

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(I)B")
    public final byte g1b_alt2() {
        return (byte) -this.data[this.pos++];
    }

    @OriginalMember(owner = "client!ge", name = "i", descriptor = "(II)V")
    public final void method7400(@OriginalArg(1) int arg0) {
        this.data[this.pos++] = (byte) arg0;
        this.data[this.pos++] = (byte) (arg0 >> 8);
        this.data[this.pos++] = (byte) (arg0 >> 16);
        this.data[this.pos++] = (byte) (arg0 >> 24);
    }

    @OriginalMember(owner = "client!ge", name = "h", descriptor = "(Z)I")
    public final int g1_alt2() {
        return -this.data[this.pos++] & 0xFF;
    }

    @OriginalMember(owner = "client!ge", name = "d", descriptor = "(I)I")
    public final int gVarInt() {
        @Pc(14) byte v = this.data[this.pos++];
        @Pc(16) int value = 0;
        while (v < 0) {
            value = (value | v & 0x7F) << 7;
            v = this.data[this.pos++];
        }
        return v | value;
    }

    @OriginalMember(owner = "client!ge", name = "i", descriptor = "(B)Ljava/lang/String;")
    public final String fastgstr() {
        if (this.data[this.pos] == 0) {
            this.pos++;
            return null;
        } else {
            return this.gjstr();
        }
    }

    @OriginalMember(owner = "client!ge", name = "p", descriptor = "(I)J")
    public final long method7404() {
        @Pc(16) long local16 = (long) this.g1() & 0xFFFFFFFFL;
        @Pc(23) long local23 = (long) this.method7349() & 0xFFFFFFFFL;
        return local23 + (local16 << 32);
    }

    @OriginalMember(owner = "client!ge", name = "d", descriptor = "(B)B")
    public final byte g1b_alt1() {
        return (byte) (this.data[this.pos++] - (Byte.MAX_VALUE + 1));
    }

    @OriginalMember(owner = "client!ge", name = "g", descriptor = "(Z)I")
    public final int method7406() {
        this.pos += 2;

        return ((this.data[this.pos - 1] & 0xFF) << 8)
            + ((this.data[this.pos - 2] - (Byte.MAX_VALUE + 1)) & 0xFF);
    }

    @OriginalMember(owner = "client!ge", name = "f", descriptor = "(II)J")
    public final long gVarLong(@OriginalArg(0) int bytes) {
        @Pc(6) int size = bytes - 1;

        if (size >= 0 && size < Byte.SIZE) {
            @Pc(25) int bits = size * Byte.SIZE;
            @Pc(27) long value = 0L;
            while (bits >= 0) {
                value |= ((long) this.data[this.pos++] & 0xFFL) << bits;
                bits -= 8;
            }
            return value;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!ge", name = "l", descriptor = "(II)V")
    public final void p1_alt3(@OriginalArg(1) int value) {
        this.data[this.pos++] = (byte) ((Byte.MAX_VALUE + 1) - value);
    }

    @OriginalMember(owner = "client!ge", name = "i", descriptor = "(I)I")
    public final int method7409() {
        this.pos += 3;

        return ((this.data[this.pos - 3] & 0xFF) << 16)
            + ((this.data[this.pos - 1] & 0xFF) << 8)
            + (this.data[this.pos - 2] & 0xFF);
    }
}
