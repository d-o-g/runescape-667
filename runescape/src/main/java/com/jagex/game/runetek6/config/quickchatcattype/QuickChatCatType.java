package com.jagex.game.runetek6.config.quickchatcattype;

import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bq")
public final class QuickChatCatType extends Node2 {

    @OriginalMember(owner = "client!bq", name = "x", descriptor = "Ljava/lang/String;")
    public String desc;

    @OriginalMember(owner = "client!bq", name = "w", descriptor = "[C")
    public char[] subcategoryShortcuts;

    @OriginalMember(owner = "client!bq", name = "v", descriptor = "[I")
    public int[] subcategories;

    @OriginalMember(owner = "client!bq", name = "y", descriptor = "[I")
    public int[] phrases;

    @OriginalMember(owner = "client!bq", name = "B", descriptor = "[C")
    public char[] phraseShortcuts;

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(Lclient!ge;Z)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(3) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.packet(packet, code);
        }
    }

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(ILclient!ge;I)V")
    public void packet(@OriginalArg(1) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.desc = packet.gjstr();
        } else if (code == 2) {
            @Pc(22) int count = packet.g1();
            this.subcategories = new int[count];
            this.subcategoryShortcuts = new char[count];

            for (@Pc(32) int i = 0; i < count; i++) {
                this.subcategories[i] = packet.g2();

                @Pc(44) byte shortcut = packet.g1b();
                this.subcategoryShortcuts[i] = shortcut == 0 ? 0 : Cp1252.decode(shortcut);
            }
        } else if (code == 3) {
            @Pc(22) int count = packet.g1();
            this.phraseShortcuts = new char[count];
            this.phrases = new int[count];

            for (@Pc(32) int i = 0; i < count; i++) {
                this.phrases[i] = packet.g2();

                @Pc(44) byte shortcut = packet.g1b();
                this.phraseShortcuts[i] = shortcut == 0 ? 0 : Cp1252.decode(shortcut);
            }
        }
    }

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(CI)I")
    public int findPhraseByShortcut(@OriginalArg(0) char shortcut) {
        if (this.phrases == null) {
            return -1;
        }
        for (@Pc(11) int i = 0; i < this.phrases.length; i++) {
            if (this.phraseShortcuts[i] == shortcut) {
                return this.phrases[i];
            }
        }
        return -1;
    }

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(BC)I")
    public int findSubcategoryByShortcut(@OriginalArg(1) char shortcut) {
        if (this.subcategories == null) {
            return -1;
        }
        for (@Pc(11) int i = 0; i < this.subcategories.length; i++) {
            if (this.subcategoryShortcuts[i] == shortcut) {
                return this.subcategories[i];
            }
        }
        return -1;
    }

    @OriginalMember(owner = "client!bq", name = "c", descriptor = "(B)V")
    public void postDecode() {
        if (this.phrases != null) {
            for (@Pc(8) int i = 0; i < this.phrases.length; i++) {
                this.phrases[i] |= 0x8000;
            }
        }
        if (this.subcategories != null) {
            for (@Pc(8) int i = 0; i < this.subcategories.length; i++) {
                this.subcategories[i] |= 0x8000;
            }
        }
    }
}
