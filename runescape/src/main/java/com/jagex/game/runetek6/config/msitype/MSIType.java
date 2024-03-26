package com.jagex.game.runetek6.config.msitype;

import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ia")
public final class MSIType {

    @OriginalMember(owner = "client!ia", name = "b", descriptor = "Lclient!u;")
    public MSITypeList myList;

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "I")
    public int colour;

    @OriginalMember(owner = "client!ia", name = "d", descriptor = "I")
    public int image;

    @OriginalMember(owner = "client!ia", name = "e", descriptor = "Z")
    public boolean enlarge = false;

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(ILclient!ha;ZI)Lclient!st;")
    public Sprite sprite(@OriginalArg(0) int rotations, @OriginalArg(1) Toolkit toolkit, @OriginalArg(2) boolean flipHorizontal) {
        @Pc(23) long key = toolkit.index << 19 | (flipHorizontal ? 0x40000 : 0) | rotations << 16 | this.image;
        @Pc(31) Sprite sprite = (Sprite) this.myList.spriteCache.get(key);
        if (sprite != null) {
            return sprite;
        }

        if (!this.myList.sprites.fileready(this.image)) {
            return null;
        }

        @Pc(55) IndexedImage image = IndexedImage.loadFirst(this.myList.sprites, this.image, 0);
        if (image != null) {
            image.offY2 = image.offX1 = image.offX2 = image.offY1 = 0;
            if (flipHorizontal) {
                image.flipHorizontally();
            }

            for (@Pc(79) int i = 0; i < rotations; i++) {
                image.rotate();
            }
        }

        sprite = toolkit.createSprite(image, true);
        if (sprite != null) {
            this.myList.spriteCache.put(sprite, key);
        }
        return sprite;
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(B)Z")
    public boolean ready() {
        return this.myList.sprites.fileready(this.image);
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(IILclient!ge;)V")
    public void decode(@OriginalArg(1) int code, @OriginalArg(2) Packet packet) {
        if (code == 1) {
            this.image = packet.g2();
        } else if (code == 2) {
            this.colour = packet.g3();
        } else if (code == 3) {
            this.enlarge = true;
        } else if (code == 4) {
            this.image = -1;
        }
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(7) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }
}
