import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base37;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ama")
public final class Class20 {

    @OriginalMember(owner = "client!ama", name = "b", descriptor = "J")
    public long aLong15;

    @OriginalMember(owner = "client!ama", name = "e", descriptor = "I")
    public int anInt519 = -1;

    @OriginalMember(owner = "client!ama", name = "g", descriptor = "Lclient!sia;")
    public final Deque aDeque_4 = new Deque();

    @OriginalMember(owner = "client!ama", name = "<init>", descriptor = "(Lclient!ge;)V")
    public Class20(@OriginalArg(0) Packet arg0) {
        this.method585(arg0);
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(Lclient!ge;B)V")
    public void method585(@OriginalArg(0) Packet arg0) {
        this.aLong15 = arg0.g8();
        this.anInt519 = arg0.g4();
        for (@Pc(28) int local28 = arg0.g1(); local28 != 0; local28 = arg0.g1()) {
            if (Static148.aBoolean215) {
                System.out.println("t:" + local28);
            }
            @Pc(61) Node_Sub14 local61;
            if (local28 == 3) {
                local61 = new Node_Sub14_Sub4();
            } else if (local28 == 1) {
                local61 = new Node_Sub14_Sub2();
            } else if (local28 == 13) {
                local61 = new Node_Sub14_Sub7();
            } else if (local28 == 4) {
                local61 = new Node_Sub14_Sub6();
            } else if (local28 == 6) {
                local61 = new Node_Sub14_Sub13();
            } else if (local28 == 5) {
                local61 = new Node_Sub14_Sub8();
            } else if (local28 == 2) {
                local61 = new Node_Sub14_Sub5();
            } else if (local28 == 7) {
                local61 = new Node_Sub14_Sub10();
            } else if (local28 == 8) {
                local61 = new Node_Sub14_Sub11();
            } else if (local28 == 9) {
                local61 = new Node_Sub14_Sub1();
            } else if (local28 == 10) {
                local61 = new Node_Sub14_Sub12();
            } else if (local28 == 11) {
                local61 = new Node_Sub14_Sub9();
            } else if (local28 == 12) {
                local61 = new Node_Sub14_Sub3();
            } else {
                throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
            }
            local61.method8615(arg0);
            this.aDeque_4.addLast(local61);
        }
    }

    @OriginalMember(owner = "client!ama", name = "a", descriptor = "(ILclient!hi;)V")
    public void method587(@OriginalArg(1) Class164 arg0) {
        if (this.aLong15 != arg0.aLong125 || this.anInt519 != arg0.anInt3950) {
            throw new RuntimeException("ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:" + Base37.decode(arg0.aLong125) + " updateNum:" + arg0.anInt3950 + " delta.owner:" + Base37.decode(this.aLong15) + " updateNum:" + this.anInt519);
        }
        for (@Pc(82) Node_Sub14 local82 = (Node_Sub14) this.aDeque_4.first(); local82 != null; local82 = (Node_Sub14) this.aDeque_4.next()) {
            local82.method8617(arg0);
        }
        arg0.anInt3950++;
    }
}
