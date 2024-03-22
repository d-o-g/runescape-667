import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ss")
public final class ClientProt {

    @OriginalMember(owner = "client!rd", name = "r", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___97 = new ClientProt(66, 3);

    @OriginalMember(owner = "client!rd", name = "q", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON1 = new ClientProt(61, 8);

    @OriginalMember(owner = "client!kda", name = "i", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON2 = new ClientProt(64, 8);

    @OriginalMember(owner = "client!hs", name = "n", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON3 = new ClientProt(4, 8);

    @OriginalMember(owner = "client!wha", name = "e", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON4 = new ClientProt(52, 8);

    @OriginalMember(owner = "client!vu", name = "h", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON5 = new ClientProt(81, 8);

    @OriginalMember(owner = "client!du", name = "m", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON6 = new ClientProt(91, 8);

    @OriginalMember(owner = "client!lf", name = "g", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON7 = new ClientProt(18, 8);

    @OriginalMember(owner = "client!wca", name = "g", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON8 = new ClientProt(10, 8);

    @OriginalMember(owner = "client!ln", name = "m", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON9 = new ClientProt(20, 8);

    @OriginalMember(owner = "client!wk", name = "b", descriptor = "Lclient!ss;")
    public static final ClientProt IF_BUTTON10 = new ClientProt(25, 8);

    @OriginalMember(owner = "client!nc", name = "c", descriptor = "Lclient!ss;")
    public static final ClientProt NO_TIMEOUT = new ClientProt(16, 0);

    @OriginalMember(owner = "client!ss", name = "g", descriptor = "I")
    public final int anInt8829;

    @OriginalMember(owner = "client!ss", name = "a", descriptor = "I")
    public final int anInt8827;

    @OriginalMember(owner = "client!ss", name = "<init>", descriptor = "(II)V")
    public ClientProt(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.anInt8829 = arg0;
        this.anInt8827 = arg1;
    }

    @OriginalMember(owner = "client!ss", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!ss", name = "a", descriptor = "(I)I")
    public int method7826() {
        return this.anInt8829;
    }
}
