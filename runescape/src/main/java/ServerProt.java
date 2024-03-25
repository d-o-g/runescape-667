import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lga")
public final class ServerProt {

    @OriginalMember(owner = "client!dc", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___43 = new ServerProt(37, -2);

    @OriginalMember(owner = "client!dh", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___45 = new ServerProt(33, -2);

    @OriginalMember(owner = "client!dma", name = "k", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___47 = new ServerProt(137, 8);

    @OriginalMember(owner = "client!ah", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___147 = new ServerProt(51, 0);

    @OriginalMember(owner = "client!dp", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___49 = new ServerProt(5, 7);

    @OriginalMember(owner = "client!dt", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___52 = new ServerProt(60, 7);

    @OriginalMember(owner = "client!dt", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___53 = new ServerProt(75, 3);

    @OriginalMember(owner = "client!ec", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___54 = new ServerProt(91, -1);

    @OriginalMember(owner = "client!gg", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_LARGE = new ServerProt(84, 6);

    @OriginalMember(owner = "client!fi", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_SMALL = new ServerProt(14, 3);

    @OriginalMember(owner = "client!bfa", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___16 = new ServerProt(74, 11);

    @OriginalMember(owner = "client!bfa", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_LARGE = new ServerProt(39, 6);

    @OriginalMember(owner = "client!bfa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___18 = new ServerProt(132, -2);

    @OriginalMember(owner = "client!bfa", name = "o", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___19 = new ServerProt(15, 0);

    @OriginalMember(owner = "client!bja", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_SMALL = new ServerProt(101, 3);

//  by default the client incorrectly allocates 6 bytes here, the decoder attempts to read 8
//    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
//    public static final ServerProt SOUND_AREA = new ServerProt(65,  6);

    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt SOUND_AREA = new ServerProt(65, 8);

    @OriginalMember(owner = "client!uu", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___239 = new ServerProt(117, 5);

    @OriginalMember(owner = "client!gla", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___85 = new ServerProt(144, 5);

    @OriginalMember(owner = "client!jha", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___125 = new ServerProt(66, 10);

    @OriginalMember(owner = "client!jm", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___129 = new ServerProt(134, 1);

    @OriginalMember(owner = "client!cm", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___257 = new ServerProt(76, 9);

    @OriginalMember(owner = "client!vt", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___251 = new ServerProt(139, -2);

    @OriginalMember(owner = "client!as", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___11 = new ServerProt(52, 6);

    @OriginalMember(owner = "client!ss", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___219 = new ServerProt(119, 6);

    @OriginalMember(owner = "client!op", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___212 = new ServerProt(77, -2);

    @OriginalMember(owner = "client!oia", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___175 = new ServerProt(110, -1);

    @OriginalMember(owner = "client!wc", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___252 = new ServerProt(0, 6);

    @OriginalMember(owner = "client!lga", name = "e", descriptor = "I")
    public final int opcode;

    @OriginalMember(owner = "client!lga", name = "b", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!lga", name = "<init>", descriptor = "(II)V")
    public ServerProt(@OriginalArg(0) int opcode, @OriginalArg(1) int size) {
        this.opcode = opcode;
        this.size = size;
    }

    @OriginalMember(owner = "client!lga", name = "b", descriptor = "(I)I")
    public int getOpcode() {
        return this.opcode;
    }

    @OriginalMember(owner = "client!lga", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
