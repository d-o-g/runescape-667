import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.defaults.DefaultsGroup;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!aba")
public final class GraphicsDefaults {

    private static final int DEFAULT_MAXHITMARKS = 4;

    @OriginalMember(owner = "client!cba", name = "E", descriptor = "Lclient!aba;")
    public static GraphicsDefaults instance;

    @OriginalMember(owner = "client!aba", name = "l", descriptor = "[[S")
    public short[][] recol_s;

    @OriginalMember(owner = "client!aba", name = "n", descriptor = "I")
    public int lobby_interface;

    @OriginalMember(owner = "client!aba", name = "o", descriptor = "[[[S")
    public short[][][] recol_d;

    @OriginalMember(owner = "client!aba", name = "g", descriptor = "I")
    public int login_interface;

    @OriginalMember(owner = "client!aba", name = "k", descriptor = "Z")
    public boolean npcShouldDisplayChat = true;

    @OriginalMember(owner = "client!aba", name = "h", descriptor = "[I")
    public int[] hitmarkpos_y = null;

    @OriginalMember(owner = "client!aba", name = "a", descriptor = "I")
    public int profilingModel = -1;

    @OriginalMember(owner = "client!aba", name = "p", descriptor = "I")
    public int maxhitmarks = DEFAULT_MAXHITMARKS;

    @OriginalMember(owner = "client!aba", name = "i", descriptor = "Z")
    public boolean playerShouldDisplayChat = true;

    @OriginalMember(owner = "client!aba", name = "m", descriptor = "I")
    public int npcChatTimeout = 2;

    @OriginalMember(owner = "client!aba", name = "e", descriptor = "[I")
    public int[] hitmarkpos_x = null;

    @OriginalMember(owner = "client!aba", name = "d", descriptor = "I")
    public int playerChatTimeout = 3;

    @OriginalMember(owner = "client!aba", name = "<init>", descriptor = "(Lclient!sb;)V")
    public GraphicsDefaults(@OriginalArg(0) js5 js5) {
        @Pc(30) byte[] data = js5.getfile(DefaultsGroup.GRAPHICS);
        this.decode(new Packet(data));
    }

    @OriginalMember(owner = "client!aba", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        @Pc(7) boolean setHitsplatPositions = false;

        while (true) {
            int code = packet.g1();

            if (code == 0) {
                if (!setHitsplatPositions) {
                    if (this.hitmarkpos_x == null) {
                        this.hitmarkpos_y = new int[4];
                        this.hitmarkpos_x = new int[4];
                        this.maxhitmarks = 4;
                    }

                    for (int i = 0; i < this.hitmarkpos_x.length; i++) {
                        this.hitmarkpos_x[i] = 0;
                        this.hitmarkpos_y[i] = i * 20;
                    }
                }
                return;
            }

            if (code == 1) {
                if (this.hitmarkpos_x == null) {
                    this.hitmarkpos_x = new int[4];
                    this.hitmarkpos_y = new int[4];
                    this.maxhitmarks = 4;
                }

                setHitsplatPositions = true;

                for (int i = 0; i < this.hitmarkpos_x.length; i++) {
                    this.hitmarkpos_x[i] = packet.g2s();
                    this.hitmarkpos_y[i] = packet.g2s();
                }
            } else if (code == 2) {
                this.profilingModel = packet.g2();
            } else if (code == 3) {
                this.maxhitmarks = packet.g1();
                this.hitmarkpos_y = new int[this.maxhitmarks];
                this.hitmarkpos_x = new int[this.maxhitmarks];
            } else if (code == 4) {
                /* empty */
            }else if (code == 5) {
                this.login_interface = packet.g3();
            } else if (code == 6) {
                this.lobby_interface = packet.g3();
            } else if (code == 7) {
                this.recol_d = new short[10][4][];
                this.recol_s = new short[10][4];

                for (int i = 0; i < 10; i++) {
                    for (@Pc(97) int j = 0; j < 4; j++) {
                        @Pc(103) int dflt = packet.g2();
                        if (dflt == 65535) {
                            dflt = -1;
                        }
                        this.recol_s[i][j] = (short) dflt;

                        @Pc(122) int count = packet.g2();
                        this.recol_d[i][j] = new short[count];
                        for (@Pc(132) int local132 = 0; local132 < count; local132++) {
                            @Pc(140) int colour = packet.g2();
                            if (colour == 65535) {
                                colour = -1;
                            }
                            this.recol_d[i][j][local132] = (short) colour;
                        }
                    }
                }
            } else if (code == 8) {
                this.npcShouldDisplayChat = false;
            } else if (code == 9) {
                this.npcChatTimeout = packet.g1();
            } else if (code == 10) {
                this.playerShouldDisplayChat = false;
            } else if (code == 11) {
                this.playerChatTimeout = packet.g1();
            }
        }
    }
}
