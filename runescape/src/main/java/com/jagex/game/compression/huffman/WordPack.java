package com.jagex.game.compression.huffman;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class WordPack {

    @OriginalMember(owner = "client!uba", name = "a", descriptor = "Lclient!jm;")
    public static Huffman huffman;

    @OriginalMember(owner = "client!kp", name = "a", descriptor = "(ILclient!jm;)V")
    public static void setHuffman(@OriginalArg(1) Huffman huffman) {
        WordPack.huffman = huffman;
    }

    @OriginalMember(owner = "client!qi", name = "a", descriptor = "(ILclient!ge;Ljava/lang/String;)I")
    public static int encode(@OriginalArg(1) Packet packet, @OriginalArg(2) String word) {
        @Pc(12) int local12 = packet.pos;
        @Pc(16) byte[] local16 = Cp1252.encode(word);
        packet.psmarts(local16.length);
        packet.pos += huffman.compress(packet.pos, 0, local16.length, packet.data, local16);
        return packet.pos - local12;
    }

    @OriginalMember(owner = "client!aia", name = "a", descriptor = "(BLclient!ge;)Ljava/lang/String;")
    public static String decode(@OriginalArg(1) Packet packet) {
        return decode(packet, 32767);
    }

    @OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!ge;II)Ljava/lang/String;")
    public static String decode(@OriginalArg(0) Packet packet, @OriginalArg(1) int maxLength) {
        try {
            @Pc(7) int length = packet.gsmart();
            if (length > maxLength) {
                length = maxLength;
            }

            @Pc(19) byte[] dest = new byte[length];
            packet.pos += huffman.decompress(dest, packet.data, length, packet.pos, 0);
            return Cp1252.decode(0, dest, length);
        } catch (@Pc(53) Exception local53) {
            return "Cabbage";
        }
    }

    private WordPack() {
        /* empty */
    }
}
