import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.QuickChatDynamicCommand;
import com.jagex.game.QuickChatFillerDecoder;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gba")
public final class QuickChatPhraseTypeList {

    @OriginalMember(owner = "client!jb", name = "C", descriptor = "Lclient!gba;")
    public static QuickChatPhraseTypeList instance;

    @OriginalMember(owner = "client!gba", name = "j", descriptor = "I")
    public int anInt3261 = 0;

    @OriginalMember(owner = "client!gba", name = "d", descriptor = "I")
    public int anInt3264 = 0;

    @OriginalMember(owner = "client!gba", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_70 = new ReferenceCache(64);

    @OriginalMember(owner = "client!gba", name = "f", descriptor = "Lclient!raa;")
    public QuickChatFillerDecoder anQuickChatFillerDecoder_1 = null;

    @OriginalMember(owner = "client!gba", name = "i", descriptor = "Lclient!sb;")
    public final js5 aJs5_40;

    @OriginalMember(owner = "client!gba", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_41;

    @OriginalMember(owner = "client!gba", name = "<init>", descriptor = "(ILclient!sb;Lclient!sb;Lclient!raa;)V")
    public QuickChatPhraseTypeList(@OriginalArg(0) int arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) QuickChatFillerDecoder arg3) {
        this.anQuickChatFillerDecoder_1 = arg3;
        this.aJs5_40 = arg1;
        this.aJs5_41 = arg2;
        if (this.aJs5_40 != null) {
            this.anInt3264 = this.aJs5_40.fileLimit(1);
        }
        if (this.aJs5_41 != null) {
            this.anInt3261 = this.aJs5_41.fileLimit(1);
        }
    }

    @OriginalMember(owner = "client!gba", name = "a", descriptor = "(Lclient!it;J[II)Ljava/lang/String;")
    public String method2948(@OriginalArg(0) QuickChatDynamicCommand arg0, @OriginalArg(1) long arg1, @OriginalArg(2) int[] arg2) {
        if (this.anQuickChatFillerDecoder_1 != null) {
            @Pc(22) String local22 = this.anQuickChatFillerDecoder_1.decode(arg1, arg0, arg2);
            if (local22 != null) {
                return local22;
            }
        }
        return Long.toString(arg1);
    }

    @OriginalMember(owner = "client!gba", name = "a", descriptor = "(IZ)Lclient!ih;")
    public DoublyLinkedNode_Sub2_Sub12 method2950(@OriginalArg(0) int arg0) {
        @Pc(11) DoublyLinkedNode_Sub2_Sub12 local11 = (DoublyLinkedNode_Sub2_Sub12) this.aReferenceCache_70.get(arg0);
        if (local11 != null) {
            return local11;
        }
        @Pc(28) byte[] local28;
        if (arg0 >= 32768) {
            local28 = this.aJs5_41.getfile(arg0 & 0x7FFF, 1);
        } else {
            local28 = this.aJs5_40.getfile(arg0, 1);
        }
        local11 = new DoublyLinkedNode_Sub2_Sub12();
        local11.aClass139_1 = this;
        if (local28 != null) {
            local11.method3899(new Packet(local28));
        }
        if (arg0 >= 32768) {
            local11.method3902();
        }
        this.aReferenceCache_70.put(local11, arg0);
        return local11;
    }
}
