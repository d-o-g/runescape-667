import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vfa")
public final class ObjType {

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
    public int stackable = 0;

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
        this.iop = new String[5];
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
        this.iop[4] = Static32.aClass32_6.method877(this.myList.anInt2662);
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
    public int[] method8795(@OriginalArg(1) int arg0, @OriginalArg(2) int[] arg1) {
        @Pc(8) int[] local8 = new int[1152];
        @Pc(10) int local10 = 0;
        for (@Pc(12) int local12 = 0; local12 < 32; local12++) {
            for (@Pc(18) int local18 = 0; local18 < 36; local18++) {
                @Pc(24) int local24 = arg1[local10];
                if (local24 == 0) {
                    if (local18 > 0 && arg1[local10 - 1] != 0) {
                        local24 = arg0;
                    } else if (local12 > 0 && arg1[local10 - 36] != 0) {
                        local24 = arg0;
                    } else if (local18 < 35 && arg1[local10 + 1] != 0) {
                        local24 = arg0;
                    } else if (local12 < 31 && arg1[local10 + 36] != 0) {
                        local24 = arg0;
                    }
                }
                local8[local10++] = local24;
            }
        }
        if (-1 != -1) {
            this.recol_s = null;
        }
        return local8;
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
        } else {
            @Pc(202) int len;
            @Pc(212) int i;
            if (code == 40) {
                len = packet.g1();
                this.recol_s = new short[len];
                this.recol_d = new short[len];
                for (i = 0; i < len; i++) {
                    this.recol_s[i] = (short) packet.g2();
                    this.recol_d[i] = (short) packet.g2();
                }
            } else if (code == 41) {
                len = packet.g1();
                this.retex_s = new short[len];
                this.retex_d = new short[len];
                for (i = 0; i < len; i++) {
                    this.retex_s[i] = (short) packet.g2();
                    this.retex_d[i] = (short) packet.g2();
                }
            } else if (code == 42) {
                len = packet.g1();
                this.recol_d_palette = new byte[len];
                for (i = 0; i < len; i++) {
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
                len = packet.g1();
                this.quests = new int[len];
                for (i = 0; i < len; i++) {
                    this.quests[i] = packet.g2();
                }
            } else if (code == 134) {
                this.picksizeshift = packet.g1();
            } else if (code == 139) {
                this.boughtlink = packet.g2();
            } else if (code == 140) {
                this.boughttemplate = packet.g2();
            } else if (code == 249) {
                len = packet.g1();
                if (this.params == null) {
                    i = IntMath.nextPow2(len);
                    this.params = new HashTable(i);
                }
                for (i = 0; i < len; i++) {
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
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(ILclient!ha;IBIZLclient!ju;Lclient!ha;Lclient!da;I)[I")
    public int[] method8798(@OriginalArg(0) int objNumMode, @OriginalArg(1) Class19 arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) boolean arg4, @OriginalArg(6) Class201 appearance, @OriginalArg(7) Class19 scratchToolkit, @OriginalArg(8) Class14 arg7, @OriginalArg(9) int arg8) {
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
                for (@Pc(138) int local138 = 0; local138 < Static76.bodycol_s[i].length; local138++) {
                    if (appearance.bodycol_d_palette[i] < Static339.bodycol_d[i][local138].length) {
                        mesh.recolour(Static76.bodycol_s[i][local138], Static339.bodycol_d[i][local138][appearance.bodycol_d_palette[i]]);
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
        @Pc(272) Class23 local272 = null;
        if (this.certtemplate != -1) {
            local272 = this.myList.method2478(1, scratchToolkit, arg1, appearance, true, 0, 10, true, 0, arg7, this.certlink);
            if (local272 == null) {
                return null;
            }
        } else if (this.lenttemplate != -1) {
            local272 = this.myList.method2478(arg8, scratchToolkit, arg1, appearance, true, arg3, arg2, false, 0, arg7, this.lentlink);
            if (local272 == null) {
                return null;
            }
        } else if (this.boughttemplate != -1) {
            local272 = this.myList.method2478(arg8, scratchToolkit, arg1, appearance, true, arg3, arg2, false, 0, arg7, this.boughtlink);
            if (local272 == null) {
                return null;
            }
        }
        @Pc(363) int local363;
        if (arg4) {
            local363 = (int) ((double) this.zoom2d * 1.5D) << 2;
        } else if (arg8 == 2) {
            local363 = (int) ((double) this.zoom2d * 1.04D) << 2;
        } else {
            local363 = this.zoom2d << 2;
        }
        scratchToolkit.DA(16, 16, 512, 512);
        @Pc(395) Matrix local395 = scratchToolkit.method7953();
        local395.method7133();
        scratchToolkit.method8000(local395);
        scratchToolkit.xa(1.0F);
        scratchToolkit.ZA(16777215, 1.0F, 1.0F, -50.0F, -10.0F, -50.0F);
        @Pc(414) Matrix local414 = scratchToolkit.method7985();
        local414.method7132(-this.zan2d << 3);
        local414.method7127(this.yan2d << 3);
        local414.method7134(this.xof2d << 2, (Class361.anIntArray741[this.xan2d << 3] * local363 >> 14) + (this.yof2d << 2) - (model.fa() / 2), (Class361.anIntArray740[this.xan2d << 3] * local363 >> 14) - -(this.yof2d << 2));
        local414.method7130(this.xan2d << 3);
        @Pc(480) int local480 = scratchToolkit.i();
        @Pc(483) int local483 = scratchToolkit.XA();
        scratchToolkit.f(50, Integer.MAX_VALUE);
        scratchToolkit.ya();
        scratchToolkit.la();
        scratchToolkit.aa(0, 0, 36, 32, 0, 0);
        model.method7473(local414, (Class8_Sub6) null, 1);
        scratchToolkit.f(local480, local483);
        @Pc(515) int[] local515 = scratchToolkit.na(0, 0, 36, 32);
        if (arg8 >= 1) {
            local515 = this.method8795(-16777214, local515);
            if (arg8 >= 2) {
                local515 = this.method8795(-1, local515);
            }
        }
        if (arg3 != 0) {
            this.method8804(arg3, local515);
        }
        scratchToolkit.method7946(36, 36, 32, local515).method8202(0, 0);
        if (this.certtemplate != -1) {
            local272.method8202(0, 0);
        } else if (this.lenttemplate != -1) {
            local272.method8202(0, 0);
        } else if (this.boughttemplate != -1) {
            local272.method8202(0, 0);
        }
        if (objNumMode == 1 || objNumMode == 2 && (this.stackable == 1 || arg2 != 1) && arg2 != -1) {
            arg7.method8829(0, 9, this.method8803(arg2), -16777215, -256);
        }
        local515 = scratchToolkit.na(0, 0, 36, 32);
        for (@Pc(652) int local652 = 0; local652 < local515.length; local652++) {
            if ((local515[local652] & 0xFFFFFF) == 0) {
                local515[local652] = 0;
            } else {
                local515[local652] |= 0xFF000000;
            }
        }
        return local515;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(Lclient!bs;ZI)Lclient!dv;")
    public Mesh method8799(@OriginalArg(0) Class52 arg0, @OriginalArg(1) boolean arg1) {
        @Pc(19) int local19;
        @Pc(24) int local24;
        @Pc(29) int local29;
        if (arg1) {
            if (arg0 == null || arg0.anIntArray99 == null) {
                local19 = this.manwear2;
                local24 = this.womanwear2;
                local29 = this.womanwear3;
            } else {
                local29 = arg0.anIntArray99[2];
                local19 = arg0.anIntArray99[0];
                local24 = arg0.anIntArray99[1];
            }
        } else if (arg0 == null || arg0.anIntArray97 == null) {
            local29 = this.manwear3;
            local19 = this.manwear;
            local24 = this.womanwear;
        } else {
            local19 = arg0.anIntArray97[0];
            local24 = arg0.anIntArray97[1];
            local29 = arg0.anIntArray97[2];
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
            local86.method2233(this.manwearxoff, this.manwearyoff, this.manwearzoff);
        }
        if (arg1 && (this.womanwearxoff != 0 || this.womanwearyoff != 0 || this.womanwearzoff != 0)) {
            local86.method2233(this.womanwearxoff, this.womanwearyoff, this.womanwearzoff);
        }
        @Pc(269) short[] local269;
        @Pc(275) int local275;
        if (this.recol_s != null) {
            if (arg0 == null || arg0.aShortArray11 == null) {
                local269 = this.recol_d;
            } else {
                local269 = arg0.aShortArray11;
            }
            for (local275 = 0; local275 < this.recol_s.length; local275++) {
                local86.recolour(this.recol_s[local275], local269[local275]);
            }
        }
        if (this.retex_s != null) {
            if (arg0 == null || arg0.aShortArray10 == null) {
                local269 = this.retex_d;
            } else {
                local269 = arg0.aShortArray10;
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
    public Mesh method8801(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class52 arg1) {
        @Pc(21) int local21;
        @Pc(26) int local26;
        if (arg0) {
            if (arg1 == null || arg1.anIntArray100 == null) {
                local21 = this.womanhead;
                local26 = this.womanhead2;
            } else {
                local26 = arg1.anIntArray100[1];
                local21 = arg1.anIntArray100[0];
            }
        } else if (arg1 == null || arg1.anIntArray98 == null) {
            local26 = this.manhead2;
            local21 = this.manhead;
        } else {
            local21 = arg1.anIntArray98[0];
            local26 = arg1.anIntArray98[1];
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
            if (arg1 == null || arg1.aShortArray11 == null) {
                local149 = this.recol_d;
            } else {
                local149 = arg1.aShortArray11;
            }
            for (local156 = 0; local156 < this.recol_s.length; local156++) {
                local84.recolour(this.recol_s[local156], local149[local156]);
            }
        }
        if (this.retex_s != null) {
            if (arg1 == null || arg1.aShortArray10 == null) {
                local149 = this.retex_d;
            } else {
                local149 = arg1.aShortArray10;
            }
            for (local156 = 0; local156 < this.retex_s.length; local156++) {
                local84.retexture(this.retex_s[local156], local149[local156]);
            }
        }
        return local84;
    }

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(ZLclient!bs;I)Z")
    public boolean method8802(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class52 arg1) {
        @Pc(17) int local17;
        @Pc(23) int local23;
        @Pc(20) int local20;
        if (arg0) {
            if (arg1 == null || arg1.anIntArray99 == null) {
                local17 = this.manwear2;
                local20 = this.womanwear3;
                local23 = this.womanwear2;
            } else {
                local17 = arg1.anIntArray99[0];
                local23 = arg1.anIntArray99[1];
                local20 = arg1.anIntArray99[2];
            }
        } else if (arg1 == null || arg1.anIntArray97 == null) {
            local20 = this.manwear3;
            local17 = this.manwear;
            local23 = this.womanwear;
        } else {
            local23 = arg1.anIntArray97[1];
            local20 = arg1.anIntArray97[2];
            local17 = arg1.anIntArray97[0];
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
    public String method8803(@OriginalArg(1) int arg0) {
        if (arg0 < 100000) {
            return "<col=ffff00>" + arg0 + "</col>";
        } else if (arg0 < 10000000) {
            return "<col=ffffff>" + arg0 / 1000 + Static32.aClass32_36.method877(this.myList.anInt2662) + "</col>";
        } else {
            return "<col=00ff80>" + arg0 / 1000000 + Static32.aClass32_34.method877(this.myList.anInt2662) + "</col>";
        }
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(I[II)V")
    public void method8804(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1) {
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
    public Model method8805(@OriginalArg(0) Class152 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class201 arg2, @OriginalArg(3) int arg3, @OriginalArg(4) Class19 arg4) {
        @Pc(17) int local17;
        if (this.countobj != null && arg3 > 1) {
            local17 = -1;
            for (@Pc(19) int local19 = 0; local19 < 10; local19++) {
                if (arg3 >= this.countco[local19] && this.countco[local19] != 0) {
                    local17 = this.countobj[local19];
                }
            }
            if (local17 != -1) {
                return this.myList.list(local17).method8805(arg0, arg1, arg2, 1, arg4);
            }
        }
        local17 = arg1;
        if (arg0 != null) {
            local17 = arg1 | arg0.method9101();
        }
        @Pc(87) Class82 local87 = this.myList.aClass82_58;
        @Pc(104) Model local104;
        synchronized (this.myList.aClass82_58) {
            local104 = (Model) this.myList.aClass82_58.method2156((long) (this.anInt10134 | arg4.anInt8962 << 29));
        }
        if (local104 == null || arg4.method7960(local104.ua(), local17) != 0) {
            if (local104 != null) {
                local17 = arg4.method8013(local17, local104.ua());
            }
            @Pc(141) int local141 = local17;
            if (this.retex_s != null) {
                local141 = local17 | 0x8000;
            }
            if (this.recol_s != null || arg2 != null) {
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
            local104 = arg4.createModel(local196, local141, this.myList.anInt2673, this.ambient + 64, 850 - -this.contrast);
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
            if (arg2 != null) {
                for (local265 = 0; local265 < 10; local265++) {
                    for (@Pc(360) int local360 = 0; local360 < Static76.bodycol_s[local265].length; local360++) {
                        if (Static339.bodycol_d[local265][local360].length > arg2.bodycol_d_palette[local265]) {
                            local104.ia(Static76.bodycol_s[local265][local360], Static339.bodycol_d[local265][local360][arg2.bodycol_d_palette[local265]]);
                        }
                    }
                }
            }
            local104.s(local17);
            @Pc(426) Class82 local426 = this.myList.aClass82_58;
            synchronized (this.myList.aClass82_58) {
                this.myList.aClass82_58.method2150(local104, (long) (this.anInt10134 | arg4.anInt8962 << 29));
            }
        }
        if (arg0 != null) {
            local104 = local104.copy((byte) 1, local17, true);
            arg0.method9089(local104, 0);
        }
        local104.s(arg1);
        return local104;
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(B)V")
    public void method8807() {
    }

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(ILclient!bs;Z)Z")
    public boolean method8808(@OriginalArg(1) Class52 arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) int local19;
        @Pc(22) int local22;
        if (arg1) {
            if (arg0 == null || arg0.anIntArray100 == null) {
                local19 = this.womanhead;
                local22 = this.womanhead2;
            } else {
                local19 = arg0.anIntArray100[0];
                local22 = arg0.anIntArray100[1];
            }
        } else if (arg0 == null || arg0.anIntArray98 == null) {
            local22 = this.manhead2;
            local19 = this.manhead;
        } else {
            local22 = arg0.anIntArray98[1];
            local19 = arg0.anIntArray98[0];
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
    public void method8809(@OriginalArg(0) ObjType arg0, @OriginalArg(2) ObjType arg1) {
        this.cost = 0;
        this.manwear3 = arg1.manwear3;
        this.stackable = arg1.stackable;
        this.members = arg1.members;
        this.recol_d_palette = arg1.recol_d_palette;
        this.yof2d = arg0.yof2d;
        this.team = arg1.team;
        this.womanwear = arg1.womanwear;
        this.iop = new String[5];
        this.op = arg1.op;
        this.manwearyoff = arg1.manwearyoff;
        this.manhead = arg1.manhead;
        this.womanwearyoff = arg1.womanwearyoff;
        this.name = arg1.name;
        this.zoom2d = arg0.zoom2d;
        this.recol_s = arg1.recol_s;
        this.womanhead2 = arg1.womanhead2;
        this.params = arg1.params;
        this.manwear2 = arg1.manwear2;
        this.xan2d = arg0.xan2d;
        this.yan2d = arg0.yan2d;
        this.womanwearxoff = arg1.womanwearxoff;
        this.manhead2 = arg1.manhead2;
        this.womanwear3 = arg1.womanwear3;
        this.retex_d = arg1.retex_d;
        this.manwearxoff = arg1.manwearxoff;
        this.womanhead = arg1.womanhead;
        this.mesh = arg0.mesh;
        this.recol_d = arg1.recol_d;
        this.womanwear2 = arg1.womanwear2;
        this.xof2d = arg0.xof2d;
        this.zan2d = arg0.zan2d;
        this.manwear = arg1.manwear;
        this.womanwearzoff = arg1.womanwearzoff;
        this.manwearzoff = arg1.manwearzoff;
        this.retex_s = arg1.retex_s;
        if (arg1.iop != null) {
            for (@Pc(161) int local161 = 0; local161 < 4; local161++) {
                this.iop[local161] = arg1.iop[local161];
            }
        }
        this.iop[4] = Static32.aClass32_7.method877(this.myList.anInt2662);
    }
}
