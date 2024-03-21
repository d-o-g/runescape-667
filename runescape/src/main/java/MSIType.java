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
    public MSITypeList typeList;

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "I")
    public int anInt4165;

    @OriginalMember(owner = "client!ia", name = "d", descriptor = "I")
    public int image;

    @OriginalMember(owner = "client!ia", name = "e", descriptor = "Z")
    public boolean enlarge = false;

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(ILclient!ha;ZI)Lclient!st;")
    public Sprite sprite(@OriginalArg(0) int count, @OriginalArg(1) Toolkit toolkit, @OriginalArg(2) boolean flipHorizontal) {
        @Pc(23) long key = (long) (toolkit.index << 19 | (flipHorizontal ? 0x40000 : 0) | count << 16 | this.image);
        @Pc(31) Sprite sprite = (Sprite) this.typeList.spriteCache.get(key);
        if (sprite != null) {
            return sprite;
        }

        if (!this.typeList.sprites.fileready(this.image)) {
            return null;
        }

        @Pc(55) IndexedImage image = IndexedImage.loadFirst(this.typeList.sprites, this.image, 0);
        if (image != null) {
            image.offY2 = image.offX1 = image.offX2 = image.offY1 = 0;
            if (flipHorizontal) {
                image.flipHorizontally();
            }
            for (@Pc(79) int i = 0; i < count; i++) {
                image.method9386();
            }
        }

        sprite = toolkit.createSprite(image, true);
        if (sprite != null) {
            this.typeList.spriteCache.put(sprite, key);
        }
        return sprite;
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(B)Z")
    public boolean ready() {
        return this.typeList.sprites.fileready(this.image);
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(IILclient!ge;)V")
    public void decode(@OriginalArg(1) int code, @OriginalArg(2) Packet packet) {
        if (code == 1) {
            this.image = packet.g2();
        } else if (code == 2) {
            this.anInt4165 = packet.g3();
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
