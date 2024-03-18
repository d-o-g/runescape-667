import com.jagex.collect.HashTable;
import com.jagex.collect.Node;
import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ObjStackability;
import com.jagex.core.io.Packet;
import com.jagex.math.IntMath;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vfa")
public final class ObjType {

    public static final int SHOWCOUNT_NEVER = 0;
    public static final int SHOWCOUNT_ALWAYS = 1;
    public static final int SHOWCOUNT_IFNOT1 = 2;

    private static final int MAX_OP_COUNT = 6;
    private static final int MAX_IOP_COUNT = 5;

    @OriginalMember(owner = "client!hh", name = "b", descriptor = "[S")
    public static short[] clientpalette = new short[256];

    @OriginalMember(owner = "client!vfa", name = "Cb", descriptor = "[S")
    public short[] retex_s;

    @OriginalMember(owner = "client!vfa", name = "t", descriptor = "[S")
    public short[] recol_s;

    @OriginalMember(owner = "client!vfa", name = "I", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!vfa", name = "j", descriptor = "Lclient!es;")
    public ObjTypeList myList;

    @OriginalMember(owner = "client!vfa", name = "Hb", descriptor = "[I")
    public int[] countco;

    @OriginalMember(owner = "client!vfa", name = "nb", descriptor = "Lclient!av;")
    public HashTable params;

    @OriginalMember(owner = "client!vfa", name = "n", descriptor = "[B")
    public byte[] recol_d_palette;

    @OriginalMember(owner = "client!vfa", name = "f", descriptor = "I")
    public int mesh;

    @OriginalMember(owner = "client!vfa", name = "ib", descriptor = "[Ljava/lang/String;")
    public String[] iop;

    @OriginalMember(owner = "client!vfa", name = "vb", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!vfa", name = "O", descriptor = "I")
    public int anInt10134;

    @OriginalMember(owner = "client!vfa", name = "db", descriptor = "[I")
    public int[] countobj;

    @OriginalMember(owner = "client!vfa", name = "G", descriptor = "[Ljava/lang/String;")
    public String[] op;

    @OriginalMember(owner = "client!vfa", name = "H", descriptor = "[I")
    public int[] quests;

    @OriginalMember(owner = "client!vfa", name = "v", descriptor = "I")
    public int cursor2 = -1;

    @OriginalMember(owner = "client!vfa", name = "cb", descriptor = "I")
    public int cursor2op = -1;

    @OriginalMember(owner = "client!vfa", name = "W", descriptor = "I")
    public int manwear = -1;

    @OriginalMember(owner = "client!vfa", name = "J", descriptor = "I")
    public int cursor2iop = -1;

    @OriginalMember(owner = "client!vfa", name = "wb", descriptor = "I")
    public int womanwear = -1;

    @OriginalMember(owner = "client!vfa", name = "U", descriptor = "I")
    public int zan2d = 0;

    @OriginalMember(owner = "client!vfa", name = "N", descriptor = "I")
    public int lenttemplate = -1;

    @OriginalMember(owner = "client!vfa", name = "ob", descriptor = "I")
    public int icursor2 = -1;

    @OriginalMember(owner = "client!vfa", name = "Q", descriptor = "I")
    public int boughtlink = -1;

    @OriginalMember(owner = "client!vfa", name = "y", descriptor = "I")
    public int manwear3 = -1;

    @OriginalMember(owner = "client!vfa", name = "M", descriptor = "I")
    public int ambient = 0;

    @OriginalMember(owner = "client!vfa", name = "Ab", descriptor = "I")
    public int contrast = 0;

    @OriginalMember(owner = "client!vfa", name = "w", descriptor = "I")
    public int womanhead = -1;

    @OriginalMember(owner = "client!vfa", name = "F", descriptor = "I")
    public int zoom2d = 2000;

    @OriginalMember(owner = "client!vfa", name = "A", descriptor = "I")
    public int multistacksize = -1;

    @OriginalMember(owner = "client!vfa", name = "D", descriptor = "I")
    public int team = 0;

    @OriginalMember(owner = "client!vfa", name = "z", descriptor = "Z")
    public boolean members = false;

    @OriginalMember(owner = "client!vfa", name = "Db", descriptor = "I")
    public int resizey = 128;

    @OriginalMember(owner = "client!vfa", name = "yb", descriptor = "I")
    public int xof2d = 0;

    @OriginalMember(owner = "client!vfa", name = "xb", descriptor = "Ljava/lang/String;")
    public String name = "null";

    @OriginalMember(owner = "client!vfa", name = "ub", descriptor = "I")
    public int icursor1 = -1;

    @OriginalMember(owner = "client!vfa", name = "Z", descriptor = "I")
    public int resizex = 128;

    @OriginalMember(owner = "client!vfa", name = "Y", descriptor = "I")
    public int manhead2 = -1;

    @OriginalMember(owner = "client!vfa", name = "jb", descriptor = "I")
    public int womanhead2 = -1;

    @OriginalMember(owner = "client!vfa", name = "x", descriptor = "I")
    public int cursor1op = -1;

    @OriginalMember(owner = "client!vfa", name = "s", descriptor = "I")
    public int yan2d = 0;

    @OriginalMember(owner = "client!vfa", name = "mb", descriptor = "I")
    public int manwearzoff = 0;

    @OriginalMember(owner = "client!vfa", name = "R", descriptor = "I")
    public int cursor1 = -1;

    @OriginalMember(owner = "client!vfa", name = "k", descriptor = "I")
    public int cursor1iop = -1;

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "I")
    public int womanwearyoff = 0;

    @OriginalMember(owner = "client!vfa", name = "Eb", descriptor = "I")
    public int womanwear2 = -1;

    @OriginalMember(owner = "client!vfa", name = "P", descriptor = "I")
    public int yof2d = 0;

    @OriginalMember(owner = "client!vfa", name = "zb", descriptor = "I")
    public int womanwearxoff = 0;

    @OriginalMember(owner = "client!vfa", name = "tb", descriptor = "I")
    public int manhead = -1;

    @OriginalMember(owner = "client!vfa", name = "fb", descriptor = "I")
    public int picksizeshift = 0;

    @OriginalMember(owner = "client!vfa", name = "T", descriptor = "I")
    public int stackable = ObjStackability.SOMETIMES;

    @OriginalMember(owner = "client!vfa", name = "lb", descriptor = "I")
    public int resizez = 128;

    @OriginalMember(owner = "client!vfa", name = "pb", descriptor = "I")
    public int womanwear3 = -1;

    @OriginalMember(owner = "client!vfa", name = "K", descriptor = "I")
    public int certtemplate = -1;

    @OriginalMember(owner = "client!vfa", name = "rb", descriptor = "I")
    public int certlink = -1;

    @OriginalMember(owner = "client!vfa", name = "r", descriptor = "I")
    public int cost = 1;

    @OriginalMember(owner = "client!vfa", name = "p", descriptor = "I")
    public int dummyitem = 0;

    @OriginalMember(owner = "client!vfa", name = "l", descriptor = "I")
    public int boughttemplate = -1;

    @OriginalMember(owner = "client!vfa", name = "qb", descriptor = "I")
    public int xan2d = 0;

    @OriginalMember(owner = "client!vfa", name = "Bb", descriptor = "I")
    public int lentlink = -1;

    @OriginalMember(owner = "client!vfa", name = "S", descriptor = "I")
    public int manwear2 = -1;

    @OriginalMember(owner = "client!vfa", name = "q", descriptor = "I")
    public int manwearyoff = 0;

    @OriginalMember(owner = "client!vfa", name = "eb", descriptor = "I")
    public int womanwearzoff = 0;

    @OriginalMember(owner = "client!vfa", name = "gb", descriptor = "I")
    public int manwearxoff = 0;

    @OriginalMember(owner = "client!vfa", name = "L", descriptor = "Z")
    public boolean stockmarket = false;

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(II)Lclient!vfa;")
    public ObjType getStacked(@OriginalArg(0) int count) {
        if (this.countobj != null && count > 1) {
            @Pc(23) int id = -1;
            for (@Pc(25) int i = 0; i < 10; i++) {
                if (this.countco[i] <= count && this.countco[i] != 0) {
                    id = this.countobj[i];
                }
            }
            if (id != -1) {
                return this.myList.list(id);
            }
        }
        return this;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!ge;B)V")
    public void method8791(@OriginalArg(0) Packet arg0) {
        while (true) {
            @Pc(15) int local15 = arg0.g1();
            if (local15 == 0) {
                return;
            }
            this.decode(arg0, local15);
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(BLclient!vfa;Lclient!vfa;)V")
    public void method8792(@OriginalArg(1) ObjType arg0, @OriginalArg(2) ObjType arg1) {
        this.recol_d = arg0.recol_d;
        this.manhead = arg0.manhead;
        this.manhead2 = arg0.manhead2;
        this.manwear3 = arg0.manwear3;
        this.team = arg0.team;
        this.params = arg0.params;
        this.members = arg0.members;
        this.retex_d = arg0.retex_d;
        this.manwearyoff = arg0.manwearyoff;
        this.womanwear2 = arg0.womanwear2;
        this.zan2d = arg1.zan2d;
        this.op = arg0.op;
        this.womanhead2 = arg0.womanhead2;
        this.recol_d_palette = arg0.recol_d_palette;
        this.womanwearyoff = arg0.womanwearyoff;
        this.xan2d = arg1.xan2d;
        this.manwear2 = arg0.manwear2;
        this.mesh = arg1.mesh;
        this.iop = new String[MAX_IOP_COUNT];
        this.yan2d = arg1.yan2d;
        this.yof2d = arg1.yof2d;
        this.retex_s = arg0.retex_s;
        this.womanwearxoff = arg0.womanwearxoff;
        this.womanwear = arg0.womanwear;
        this.cost = 0;
        this.manwearzoff = arg0.manwearzoff;
        this.recol_s = arg0.recol_s;
        this.xof2d = arg1.xof2d;
        this.womanwearzoff = arg0.womanwearzoff;
        this.womanhead = arg0.womanhead;
        this.zoom2d = arg1.zoom2d;
        this.name = arg0.name;
        this.womanwear3 = arg0.womanwear3;
        this.manwear = arg0.manwear;
        this.manwearxoff = arg0.manwearxoff;
        if (arg0.iop != null) {
            for (@Pc(155) int local155 = 0; local155 < 4; local155++) {
                this.iop[local155] = arg0.iop[local155];
            }
        }
        this.iop[4] = Static32.A_LOCALISED_TEXT___6.localise(this.myList.languageId);
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!vfa;ILclient!vfa;)V")
    public void method8793(@OriginalArg(0) ObjType arg0, @OriginalArg(2) ObjType arg1) {
        this.yof2d = arg0.yof2d;
        this.recol_s = arg0.recol_s;
        this.cost = arg1.cost;
        this.name = arg1.name;
        this.retex_d = arg0.retex_d;
        this.yan2d = arg0.yan2d;
        this.zan2d = arg0.zan2d;
        this.retex_s = arg0.retex_s;
        this.mesh = arg0.mesh;
        this.zoom2d = arg0.zoom2d;
        this.recol_d_palette = arg0.recol_d_palette;
        this.stackable = 1;
        this.xan2d = arg0.xan2d;
        this.xof2d = arg0.xof2d;
        this.members = arg1.members;
        this.recol_d = arg0.recol_d;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(III)I")
    public int method8794(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (this.params == null) {
            return arg1;
        } else {
            @Pc(19) IntNode local19 = (IntNode) this.params.get((long) arg0);
            return local19 == null ? arg1 : local19.anInt6379;
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(II[I)[I")
    public int[] colourBorder(@OriginalArg(1) int c, @OriginalArg(2) int[] p) {
        @Pc(8) int[] out = new int[1152];
        @Pc(10) int pos = 0;

        for (@Pc(12) int y = 0; y < 32; y++) {
            for (@Pc(18) int x = 0; x < 36; x++) {
                @Pc(24) int colour = p[pos];
                if (colour == 0) {
                    if (x > 0 && p[pos - 1] != 0) {
                        colour = c;
                    } else if (y > 0 && p[pos - 36] != 0) {
                        colour = c;
                    } else if (x < 35 && p[pos + 1] != 0) {
                        colour = c;
                    } else if (y < 31 && p[pos + 36] != 0) {
                        colour = c;
                    }
                }
                out[pos++] = colour;
            }
        }
        return out;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!ge;ZI)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.mesh = packet.g2();
        } else if (code == 2) {
            this.name = packet.gjstr();
        } else if (code == 4) {
            this.zoom2d = packet.g2();
        } else if (code == 5) {
            this.xan2d = packet.g2();
        } else if (code == 6) {
            this.yan2d = packet.g2();
        } else if (code == 7) {
            this.xof2d = packet.g2();
            if (this.xof2d > Short.MAX_VALUE) {
                this.xof2d -= 65536;
            }
        } else if (code == 8) {
            this.yof2d = packet.g2();
            if (this.yof2d > Short.MAX_VALUE) {
                this.yof2d -= 65536;
            }
        } else if (code == 11) {
            this.stackable = 1;
        } else if (code == 12) {
            this.cost = packet.g4();
        } else if (code == 16) {
            this.members = true;
        } else if (code == 18) {
            this.multistacksize = packet.g2();
        } else if (code == 23) {
            this.manwear = packet.g2();
        } else if (code == 24) {
            this.womanwear = packet.g2();
        } else if (code == 25) {
            this.manwear2 = packet.g2();
        } else if (code == 26) {
            this.womanwear2 = packet.g2();
        } else if (code >= 30 && code < 35) {
            this.op[code - 30] = packet.gjstr();
        } else if (code >= 35 && code < 40) {
            this.iop[code - 35] = packet.gjstr();
        } else if (code == 40) {
            @Pc(202) int len = packet.g1();
            this.recol_s = new short[len];
            this.recol_d = new short[len];
            for (@Pc(212) int i = 0; i < len; i++) {
                this.recol_s[i] = (short) packet.g2();
                this.recol_d[i] = (short) packet.g2();
            }
        } else if (code == 41) {
            @Pc(202) int len = packet.g1();
            this.retex_s = new short[len];
            this.retex_d = new short[len];
            for (@Pc(212) int i = 0; i < len; i++) {
                this.retex_s[i] = (short) packet.g2();
                this.retex_d[i] = (short) packet.g2();
            }
        } else if (code == 42) {
            @Pc(202) int len = packet.g1();
            this.recol_d_palette = new byte[len];
            for (@Pc(212) int i = 0; i < len; i++) {
                this.recol_d_palette[i] = packet.g1b();
            }
        } else if (code == 65) {
            this.stockmarket = true;
        } else if (code == 78) {
            this.manwear3 = packet.g2();
        } else if (code == 79) {
            this.womanwear3 = packet.g2();
        } else if (code == 90) {
            this.manhead = packet.g2();
        } else if (code == 91) {
            this.womanhead = packet.g2();
        } else if (code == 92) {
            this.manhead2 = packet.g2();
        } else if (code == 93) {
            this.womanhead2 = packet.g2();
        } else if (code == 95) {
            this.zan2d = packet.g2();
        } else if (code == 96) {
            this.dummyitem = packet.g1();
        } else if (code == 97) {
            this.certlink = packet.g2();
        } else if (code == 98) {
            this.certtemplate = packet.g2();
        } else if (code >= 100 && code < 110) {
            if (this.countobj == null) {
                this.countco = new int[10];
                this.countobj = new int[10];
            }
            this.countobj[code - 100] = packet.g2();
            this.countco[code - 100] = packet.g2();
        } else if (code == 110) {
            this.resizex = packet.g2();
        } else if (code == 111) {
            this.resizey = packet.g2();
        } else if (code == 112) {
            this.resizez = packet.g2();
        } else if (code == 113) {
            this.ambient = packet.g1b();
        } else if (code == 114) {
            this.contrast = packet.g1b() * 5;
        } else if (code == 115) {
            this.team = packet.g1();
        } else if (code == 121) {
            this.lentlink = packet.g2();
        } else if (code == 122) {
            this.lenttemplate = packet.g2();
        } else if (code == 125) {
            this.manwearxoff = packet.g1b() << 2;
            this.manwearyoff = packet.g1b() << 2;
            this.manwearzoff = packet.g1b() << 2;
        } else if (code == 126) {
            this.womanwearxoff = packet.g1b() << 2;
            this.womanwearyoff = packet.g1b() << 2;
            this.womanwearzoff = packet.g1b() << 2;
        } else if (code == 127) {
            this.cursor1op = packet.g1();
            this.cursor1 = packet.g2();
        } else if (code == 128) {
            this.cursor2op = packet.g1();
            this.cursor2 = packet.g2();
        } else if (code == 129) {
            this.cursor1iop = packet.g1();
            this.icursor1 = packet.g2();
        } else if (code == 130) {
            this.cursor2iop = packet.g1();
            this.icursor2 = packet.g2();
        } else if (code == 132) {
            @Pc(202) int len = packet.g1();
            this.quests = new int[len];
            for (@Pc(212) int i = 0; i < len; i++) {
                this.quests[i] = packet.g2();
            }
        } else if (code == 134) {
            this.picksizeshift = packet.g1();
        } else if (code == 139) {
            this.boughtlink = packet.g2();
        } else if (code == 140) {
            this.boughttemplate = packet.g2();
        } else if (code == 249) {
            @Pc(202) int len = packet.g1();
            if (this.params == null) {
                @Pc(212) int count = IntMath.nextPow2(len);
                this.params = new HashTable(count);
            }
            for (@Pc(212) int i = 0; i < len; i++) {
                @Pc(554) boolean string = packet.g1() == 1;
                @Pc(558) int id = packet.g3();
                @Pc(567) Node node;
                if (string) {
                    node = new StringNode(packet.gjstr());
                } else {
                    node = new IntNode(packet.g4());
                }
                this.params.put((long) id, node);
            }
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(ILclient!ha;IBIZLclient!ju;Lclient!ha;Lclient!da;I)[I")
    public int[] sprite(@OriginalArg(0) int objNumMode, @OriginalArg(1) Toolkit toolkit, @OriginalArg(2) int invCount, @OriginalArg(4) int graphicShadow, @OriginalArg(5) boolean arg4, @OriginalArg(6) PlayerModel appearance, @OriginalArg(7) Toolkit scratchToolkit, @OriginalArg(8) Class14 font, @OriginalArg(9) int outline) {
        @Pc(14) Mesh mesh = Static121.method2201(this.mesh, this.myList.meshes);
        if (mesh == null) {
            return null;
        }

        if (mesh.version < 13) {
            mesh.upscale();
        }

        @Pc(36) int i;
        if (this.recol_s != null) {
            for (i = 0; i < this.recol_s.length; i++) {
                if (this.recol_d_palette == null || i >= this.recol_d_palette.length) {
                    mesh.recolour(this.recol_s[i], this.recol_d[i]);
                } else {
                    mesh.recolour(this.recol_s[i], clientpalette[this.recol_d_palette[i] & 0xFF]);
                }
            }
        }

        if (this.retex_s != null) {
            for (i = 0; i < this.retex_s.length; i++) {
                mesh.retexture(this.retex_s[i], this.retex_d[i]);
            }
        }

        if (appearance != null) {
            for (i = 0; i < 10; i++) {
                for (@Pc(138) int local138 = 0; local138 < PlayerModel.bodycol_s[i].length; local138++) {
                    if (appearance.bodycol_d_palette[i] < PlayerModel.bodycol_d[i][local138].length) {
                        mesh.recolour(PlayerModel.bodycol_s[i][local138], PlayerModel.bodycol_d[i][local138][appearance.bodycol_d_palette[i]]);
                    }
                }
            }
        }

        @Pc(198) short functionMask = 2048;
        @Pc(200) boolean scaled = false;
        if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
            scaled = true;
            functionMask = 2055;
        }

        @Pc(244) Model model = scratchToolkit.createModel(mesh, functionMask, 64, this.ambient + 64, this.contrast + 768);
        if (!model.loadedTextures()) {
            return null;
        }

        if (scaled) {
            model.O(this.resizex, this.resizey, this.resizez);
        }

        @Pc(272) Sprite sprite = null;
        if (this.certtemplate != -1) {
            sprite = this.myList.sprite(1, scratchToolkit, toolkit, appearance, true, 0, 10, true, SHOWCOUNT_NEVER, font, this.certlink);
            if (sprite == null) {
                return null;
            }
        } else if (this.lenttemplate != -1) {
            sprite = this.myList.sprite(outline, scratchToolkit, toolkit, appearance, true, graphicShadow, invCount, false, SHOWCOUNT_NEVER, font, this.lentlink);
            if (sprite == null) {
                return null;
            }
        } else if (this.boughttemplate != -1) {
            sprite = this.myList.sprite(outline, scratchToolkit, toolkit, appearance, true, graphicShadow, invCount, false, SHOWCOUNT_NEVER, font, this.boughtlink);
            if (sprite == null) {
                return null;
            }
        }

        @Pc(363) int zoom;
        if (arg4) {
            zoom = (int) ((double) this.zoom2d * 1.5D) << 2;
        } else if (outline == 2) {
            zoom = (int) ((double) this.zoom2d * 1.04D) << 2;
        } else {
            zoom = this.zoom2d << 2;
        }

        scratchToolkit.DA(16, 16, 512, 512);

        @Pc(395) Matrix matrix = scratchToolkit.createMatrix();
        matrix.makeIdentity();
        scratchToolkit.setCamera(matrix);
        scratchToolkit.xa(1.0F);
        scratchToolkit.ZA(16777215, 1.0F, 1.0F, -50.0F, -10.0F, -50.0F);

        @Pc(414) Matrix scratch = scratchToolkit.scratchMatrix();
        scratch.makeRotationZ(-this.zan2d << 3);
        scratch.rotateAxisY(this.yan2d << 3);
        scratch.translate(this.xof2d << 2, (Trig1.SIN[this.xan2d << 3] * zoom >> 14) + (this.yof2d << 2) - (model.fa() / 2), (Trig1.COS[this.xan2d << 3] * zoom >> 14) - -(this.yof2d << 2));
        scratch.rotateAxisX(this.xan2d << 3);

        @Pc(480) int zNear = scratchToolkit.i();
        @Pc(483) int zFar = scratchToolkit.XA();
        scratchToolkit.f(50, Integer.MAX_VALUE);
        scratchToolkit.ya();
        scratchToolkit.la();
        scratchToolkit.aa(0, 0, 36, 32, 0, 0);
        model.render(scratch, null, 1);
        scratchToolkit.f(zNear, zFar);

        @Pc(515) int[] image = scratchToolkit.na(0, 0, 36, 32);
        if (outline >= 1) {
            image = this.colourBorder(0xff000002, image);
            if (outline >= 2) {
                image = this.colourBorder(-1, image);
            }
        }

        if (graphicShadow != 0) {
            this.applyShadow(graphicShadow, image);
        }

        scratchToolkit.createSprite(36, 36, 32, image).render(0, 0);

        if (this.certtemplate != -1) {
            sprite.render(0, 0);
        } else if (this.lenttemplate != -1) {
            sprite.render(0, 0);
        } else if (this.boughttemplate != -1) {
            sprite.render(0, 0);
        }

        if (objNumMode == SHOWCOUNT_ALWAYS || objNumMode == SHOWCOUNT_IFNOT1 && (this.stackable == ObjStackability.ALWAYS || invCount != 1) && invCount != -1) {
            font.method8829(0, 9, this.formatAmount(invCount), 0xFF000001, 0xFFFFFF00);
        }

        image = scratchToolkit.na(0, 0, 36, 32);

        for (@Pc(652) int j = 0; j < image.length; j++) {
            if ((image[j] & 0xFFFFFF) == 0) {
                image[j] = 0;
            } else {
                image[j] |= 0xFF000000;
            }
        }

        return image;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!bs;ZI)Lclient!dv;")
    public Mesh model(@OriginalArg(0) ObjTypeCustomisation arg0, @OriginalArg(1) boolean arg1) {
        @Pc(19) int local19;
        @Pc(24) int local24;
        @Pc(29) int local29;
        if (arg1) {
            if (arg0 == null || arg0.womanwear == null) {
                local19 = this.manwear2;
                local24 = this.womanwear2;
                local29 = this.womanwear3;
            } else {
                local29 = arg0.womanwear[2];
                local19 = arg0.womanwear[0];
                local24 = arg0.womanwear[1];
            }
        } else if (arg0 == null || arg0.manwear == null) {
            local29 = this.manwear3;
            local19 = this.manwear;
            local24 = this.womanwear;
        } else {
            local19 = arg0.manwear[0];
            local24 = arg0.manwear[1];
            local29 = arg0.manwear[2];
        }
        if (local19 == -1) {
            return null;
        }
        @Pc(86) Mesh local86 = Static121.method2201(local19, this.myList.meshes);
        if (local86 == null) {
            return null;
        }
        if (local86.version < 13) {
            local86.upscale();
        }
        if (local24 != -1) {
            @Pc(113) Mesh local113 = Static121.method2201(local24, this.myList.meshes);
            if (local113.version < 13) {
                local113.upscale();
            }
            if (local29 == -1) {
                @Pc(180) Mesh[] local180 = new Mesh[]{local86, local113};
                local86 = new Mesh(local180, 2);
            } else {
                @Pc(137) Mesh local137 = Static121.method2201(local29, this.myList.meshes);
                if (local137.version < 13) {
                    local137.upscale();
                }
                @Pc(162) Mesh[] local162 = new Mesh[]{local86, local113, local137};
                local86 = new Mesh(local162, 3);
            }
        }
        if (!arg1 && (this.manwearxoff != 0 || this.manwearyoff != 0 || this.manwearzoff != 0)) {
            local86.translate(this.manwearxoff, this.manwearyoff, this.manwearzoff);
        }
        if (arg1 && (this.womanwearxoff != 0 || this.womanwearyoff != 0 || this.womanwearzoff != 0)) {
            local86.translate(this.womanwearxoff, this.womanwearyoff, this.womanwearzoff);
        }
        @Pc(269) short[] local269;
        @Pc(275) int local275;
        if (this.recol_s != null) {
            if (arg0 == null || arg0.recol_d == null) {
                local269 = this.recol_d;
            } else {
                local269 = arg0.recol_d;
            }
            for (local275 = 0; local275 < this.recol_s.length; local275++) {
                local86.recolour(this.recol_s[local275], local269[local275]);
            }
        }
        if (this.retex_s != null) {
            if (arg0 == null || arg0.retex_d == null) {
                local269 = this.retex_d;
            } else {
                local269 = arg0.retex_d;
            }
            for (local275 = 0; local275 < this.retex_s.length; local275++) {
                local86.retexture(this.retex_s[local275], local269[local275]);
            }
        }
        return local86;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Ljava/lang/String;II)Ljava/lang/String;")
    public String method8800(@OriginalArg(0) String arg0, @OriginalArg(2) int arg1) {
        if (this.params == null) {
            return arg0;
        } else {
            @Pc(17) StringNode local17 = (StringNode) this.params.get((long) arg1);
            return local17 == null ? arg0 : local17.aString46;
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(ZLclient!bs;I)Lclient!dv;")
    public Mesh headModel(@OriginalArg(0) boolean arg0, @OriginalArg(1) ObjTypeCustomisation arg1) {
        @Pc(21) int local21;
        @Pc(26) int local26;
        if (arg0) {
            if (arg1 == null || arg1.womanhead == null) {
                local21 = this.womanhead;
                local26 = this.womanhead2;
            } else {
                local26 = arg1.womanhead[1];
                local21 = arg1.womanhead[0];
            }
        } else if (arg1 == null || arg1.manhead == null) {
            local26 = this.manhead2;
            local21 = this.manhead;
        } else {
            local21 = arg1.manhead[0];
            local26 = arg1.manhead[1];
        }
        if (local21 == -1) {
            return null;
        }
        @Pc(84) Mesh local84 = Static121.method2201(local21, this.myList.meshes);
        if (local84.version < 13) {
            local84.upscale();
        }
        if (local26 != -1) {
            @Pc(105) Mesh local105 = Static121.method2201(local26, this.myList.meshes);
            if (local105.version < 13) {
                local105.upscale();
            }
            @Pc(128) Mesh[] local128 = new Mesh[]{local84, local105};
            local84 = new Mesh(local128, 2);
        }
        @Pc(149) short[] local149;
        @Pc(156) int local156;
        if (this.recol_s != null) {
            if (arg1 == null || arg1.recol_d == null) {
                local149 = this.recol_d;
            } else {
                local149 = arg1.recol_d;
            }
            for (local156 = 0; local156 < this.recol_s.length; local156++) {
                local84.recolour(this.recol_s[local156], local149[local156]);
            }
        }
        if (this.retex_s != null) {
            if (arg1 == null || arg1.retex_d == null) {
                local149 = this.retex_d;
            } else {
                local149 = arg1.retex_d;
            }
            for (local156 = 0; local156 < this.retex_s.length; local156++) {
                local84.retexture(this.retex_s[local156], local149[local156]);
            }
        }
        return local84;
    }

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(ZLclient!bs;I)Z")
    public boolean loadedModels(@OriginalArg(0) boolean arg0, @OriginalArg(1) ObjTypeCustomisation arg1) {
        @Pc(17) int local17;
        @Pc(23) int local23;
        @Pc(20) int local20;
        if (arg0) {
            if (arg1 == null || arg1.womanwear == null) {
                local17 = this.manwear2;
                local20 = this.womanwear3;
                local23 = this.womanwear2;
            } else {
                local17 = arg1.womanwear[0];
                local23 = arg1.womanwear[1];
                local20 = arg1.womanwear[2];
            }
        } else if (arg1 == null || arg1.manwear == null) {
            local20 = this.manwear3;
            local17 = this.manwear;
            local23 = this.womanwear;
        } else {
            local23 = arg1.manwear[1];
            local20 = arg1.manwear[2];
            local17 = arg1.manwear[0];
        }
        if (local17 == -1) {
            return true;
        }
        @Pc(88) boolean local88 = true;
        if (!this.myList.meshes.method7586(0, local17)) {
            local88 = false;
        }
        if (local23 != -1 && !this.myList.meshes.method7586(0, local23)) {
            local88 = false;
        }
        if (local20 != -1 && !this.myList.meshes.method7586(0, local20)) {
            local88 = false;
        }
        return local88;
    }

    @OriginalMember(owner = "client!vfa", name = "c", descriptor = "(II)Ljava/lang/String;")
    public String formatAmount(@OriginalArg(1) int arg0) {
        if (arg0 < 100000) {
            return "<col=ffff00>" + arg0 + "</col>";
        } else if (arg0 < 10000000) {
            return "<col=ffffff>" + arg0 / 1000 + Static32.A_LOCALISED_TEXT___36.localise(this.myList.languageId) + "</col>";
        } else {
            return "<col=00ff80>" + arg0 / 1000000 + Static32.A_LOCALISED_TEXT___34.localise(this.myList.languageId) + "</col>";
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(I[II)V")
    public void applyShadow(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1) {
        for (@Pc(11) int local11 = 31; local11 > 0; local11--) {
            @Pc(19) int local19 = local11 * 36;
            for (@Pc(21) int local21 = 35; local21 > 0; local21--) {
                if (arg1[local21 + local19] == 0 && arg1[local19 + local21 - 1 - 36] != 0) {
                    arg1[local21 + local19] = arg0;
                }
            }
        }
        Static674.anInt10128++;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!gu;ILclient!ju;ILclient!ha;I)Lclient!ka;")
    public Model model(@OriginalArg(0) Animator animator, @OriginalArg(1) int initialFunctionMask, @OriginalArg(2) PlayerModel playerModel, @OriginalArg(3) int arg3, @OriginalArg(4) Toolkit toolkit) {
        @Pc(17) int i;
        if (this.countobj != null && arg3 > 1) {
            i = -1;
            for (@Pc(19) int local19 = 0; local19 < 10; local19++) {
                if (arg3 >= this.countco[local19] && this.countco[local19] != 0) {
                    i = this.countobj[local19];
                }
            }
            if (i != -1) {
                return this.myList.list(i).model(animator, initialFunctionMask, playerModel, 1, toolkit);
            }
        }
        i = initialFunctionMask;
        if (animator != null) {
            i = initialFunctionMask | animator.functionMask();
        }
        @Pc(87) ReferenceCache local87 = this.myList.aReferenceCache_58;
        @Pc(104) Model local104;
        synchronized (this.myList.aReferenceCache_58) {
            local104 = (Model) this.myList.aReferenceCache_58.get((long) (this.anInt10134 | toolkit.index << 29));
        }
        if (local104 == null || toolkit.compareFunctionMasks(local104.ua(), i) != 0) {
            if (local104 != null) {
                i = toolkit.combineFunctionMasks(i, local104.ua());
            }
            @Pc(141) int local141 = i;
            if (this.retex_s != null) {
                local141 = i | 0x8000;
            }
            if (this.recol_s != null || playerModel != null) {
                local141 |= 0x4000;
            }
            if (this.resizex != 128) {
                local141 |= 0x1;
            }
            if (this.resizex != 128) {
                local141 |= 0x2;
            }
            if (this.resizex != 128) {
                local141 |= 0x4;
            }
            @Pc(196) Mesh local196 = Static121.method2201(this.mesh, this.myList.meshes);
            if (local196 == null) {
                return null;
            }
            if (local196.version < 13) {
                local196.upscale();
            }
            local104 = toolkit.createModel(local196, local141, this.myList.anInt2673, this.ambient + 64, 850 - -this.contrast);
            if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
                local104.O(this.resizex, this.resizey, this.resizez);
            }
            @Pc(265) int local265;
            if (this.recol_s != null) {
                for (local265 = 0; local265 < this.recol_s.length; local265++) {
                    if (this.recol_d_palette == null || this.recol_d_palette.length <= local265) {
                        local104.ia(this.recol_s[local265], this.recol_d[local265]);
                    } else {
                        local104.ia(this.recol_s[local265], clientpalette[this.recol_d_palette[local265] & 0xFF]);
                    }
                }
            }
            if (this.retex_s != null) {
                for (local265 = 0; local265 < this.retex_s.length; local265++) {
                    local104.aa(this.retex_s[local265], this.retex_d[local265]);
                }
            }
            if (playerModel != null) {
                for (local265 = 0; local265 < 10; local265++) {
                    for (@Pc(360) int local360 = 0; local360 < PlayerModel.bodycol_s[local265].length; local360++) {
                        if (PlayerModel.bodycol_d[local265][local360].length > playerModel.bodycol_d_palette[local265]) {
                            local104.ia(PlayerModel.bodycol_s[local265][local360], PlayerModel.bodycol_d[local265][local360][playerModel.bodycol_d_palette[local265]]);
                        }
                    }
                }
            }
            local104.s(i);
            @Pc(426) ReferenceCache local426 = this.myList.aReferenceCache_58;
            synchronized (this.myList.aReferenceCache_58) {
                this.myList.aReferenceCache_58.put(local104, (long) (this.anInt10134 | toolkit.index << 29));
            }
        }
        if (animator != null) {
            local104 = local104.copy((byte) 1, i, true);
            animator.animate(local104, 0);
        }
        local104.s(initialFunctionMask);
        return local104;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(B)V")
    public void method8807() {
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(ILclient!bs;Z)Z")
    public boolean loadedHeadModels(@OriginalArg(1) ObjTypeCustomisation arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) int local19;
        @Pc(22) int local22;
        if (arg1) {
            if (arg0 == null || arg0.womanhead == null) {
                local19 = this.womanhead;
                local22 = this.womanhead2;
            } else {
                local19 = arg0.womanhead[0];
                local22 = arg0.womanhead[1];
            }
        } else if (arg0 == null || arg0.manhead == null) {
            local22 = this.manhead2;
            local19 = this.manhead;
        } else {
            local22 = arg0.manhead[1];
            local19 = arg0.manhead[0];
        }
        if (local19 == -1) {
            return true;
        }
        @Pc(71) boolean local71 = true;
        if (!this.myList.meshes.method7586(0, local19)) {
            local71 = false;
        }
        if (local22 != -1 && !this.myList.meshes.method7586(0, local22)) {
            local71 = false;
        }
        return local71;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!vfa;BLclient!vfa;)V")
    public void method8809(@OriginalArg(0) ObjType template, @OriginalArg(2) ObjType original) {
        this.cost = 0;
        this.manwear3 = original.manwear3;
        this.stackable = original.stackable;
        this.members = original.members;
        this.recol_d_palette = original.recol_d_palette;
        this.yof2d = template.yof2d;
        this.team = original.team;
        this.womanwear = original.womanwear;
        this.iop = new String[MAX_IOP_COUNT];
        this.op = original.op;
        this.manwearyoff = original.manwearyoff;
        this.manhead = original.manhead;
        this.womanwearyoff = original.womanwearyoff;
        this.name = original.name;
        this.zoom2d = template.zoom2d;
        this.recol_s = original.recol_s;
        this.womanhead2 = original.womanhead2;
        this.params = original.params;
        this.manwear2 = original.manwear2;
        this.xan2d = template.xan2d;
        this.yan2d = template.yan2d;
        this.womanwearxoff = original.womanwearxoff;
        this.manhead2 = original.manhead2;
        this.womanwear3 = original.womanwear3;
        this.retex_d = original.retex_d;
        this.manwearxoff = original.manwearxoff;
        this.womanhead = original.womanhead;
        this.mesh = template.mesh;
        this.recol_d = original.recol_d;
        this.womanwear2 = original.womanwear2;
        this.xof2d = template.xof2d;
        this.zan2d = template.zan2d;
        this.manwear = original.manwear;
        this.womanwearzoff = original.womanwearzoff;
        this.manwearzoff = original.manwearzoff;
        this.retex_s = original.retex_s;

        if (original.iop != null) {
            for (@Pc(161) int i = 0; i < 4; i++) {
                this.iop[i] = original.iop[i];
            }
        }

        this.iop[4] = Static32.LENT_ITEM_RETURN.localise(this.myList.languageId);
    }
}
