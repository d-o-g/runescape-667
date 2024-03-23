import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pb")
public final class Class285 {

    @OriginalMember(owner = "client!pb", name = "b", descriptor = "Lclient!ld;")
    public HitmarkTypeList myList;

    @OriginalMember(owner = "client!pb", name = "d", descriptor = "I")
    public int anInt7179 = -1;

    @OriginalMember(owner = "client!pb", name = "r", descriptor = "Ljava/lang/String;")
    public String aString82 = "";

    @OriginalMember(owner = "client!pb", name = "f", descriptor = "I")
    public int anInt7183 = -1;

    @OriginalMember(owner = "client!pb", name = "h", descriptor = "I")
    public int anInt7184 = 0;

    @OriginalMember(owner = "client!pb", name = "m", descriptor = "I")
    public int anInt7187 = -1;

    @OriginalMember(owner = "client!pb", name = "w", descriptor = "I")
    public int anInt7180 = -1;

    @OriginalMember(owner = "client!pb", name = "k", descriptor = "I")
    public int anInt7191 = 0;

    @OriginalMember(owner = "client!pb", name = "o", descriptor = "I")
    public int anInt7190 = 16777215;

    @OriginalMember(owner = "client!pb", name = "j", descriptor = "I")
    public int anInt7192 = 70;

    @OriginalMember(owner = "client!pb", name = "t", descriptor = "I")
    public int anInt7178 = 0;

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "I")
    public int anInt7181 = -1;

    @OriginalMember(owner = "client!pb", name = "g", descriptor = "I")
    public int anInt7196 = -1;

    @OriginalMember(owner = "client!pb", name = "n", descriptor = "I")
    public int anInt7195 = -1;

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!ha;I)Lclient!st;")
    public Sprite method6451(@OriginalArg(0) Toolkit arg0) {
        if (this.anInt7181 < 0) {
            return null;
        }
        @Pc(22) Sprite local22 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7181);
        if (local22 == null) {
            this.method6455(arg0);
            local22 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7181);
        }
        return local22;
    }

    @OriginalMember(owner = "client!pb", name = "c", descriptor = "(ILclient!ha;)Lclient!st;")
    public Sprite method6452(@OriginalArg(1) Toolkit arg0) {
        if (this.anInt7180 < 0) {
            return null;
        }
        @Pc(29) Sprite local29 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7180);
        if (local29 == null) {
            this.method6455(arg0);
            local29 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7180);
        }
        return local29;
    }

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!ha;B)Lclient!st;")
    public Sprite method6453(@OriginalArg(0) Toolkit arg0) {
        if (this.anInt7187 < 0) {
            return null;
        }
        @Pc(27) Sprite local27 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7187);
        if (local27 == null) {
            this.method6455(arg0);
            local27 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7187);
        }
        return local27;
    }

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(ILclient!ha;)Lclient!st;")
    public Sprite method6454(@OriginalArg(1) Toolkit arg0) {
        if (this.anInt7183 < 0) {
            return null;
        }
        @Pc(20) Sprite local20 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7183);
        if (local20 == null) {
            this.method6455(arg0);
            local20 = (Sprite) this.myList.aReferenceCache_121.get(this.anInt7183);
        }
        return local20;
    }

    @OriginalMember(owner = "client!pb", name = "b", descriptor = "(ILclient!ha;)V")
    public void method6455(@OriginalArg(1) Toolkit arg0) {
        @Pc(7) js5 local7 = this.myList.aJs5_76;
        @Pc(34) IndexedImage local34;
        if (this.anInt7183 >= 0 && this.myList.aReferenceCache_121.get(this.anInt7183) == null && local7.fileready(this.anInt7183)) {
            local34 = IndexedImage.loadFirst(local7, this.anInt7183);
            this.myList.aReferenceCache_121.put(arg0.createSprite(local34, true), this.anInt7183);
        }
        if (this.anInt7181 >= 0 && this.myList.aReferenceCache_121.get(this.anInt7181) == null && local7.fileready(this.anInt7181)) {
            local34 = IndexedImage.loadFirst(local7, this.anInt7181);
            this.myList.aReferenceCache_121.put(arg0.createSprite(local34, true), this.anInt7181);
        }
        if (this.anInt7180 >= 0 && this.myList.aReferenceCache_121.get(this.anInt7180) == null && local7.fileready(this.anInt7180)) {
            local34 = IndexedImage.loadFirst(local7, this.anInt7180);
            this.myList.aReferenceCache_121.put(arg0.createSprite(local34, true), this.anInt7180);
        }
        if (this.anInt7187 >= 0 && this.myList.aReferenceCache_121.get(this.anInt7187) == null && local7.fileready(this.anInt7187)) {
            local34 = IndexedImage.loadFirst(local7, this.anInt7187);
            this.myList.aReferenceCache_121.put(arg0.createSprite(local34, true), this.anInt7187);
        }
    }

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!ge;BI)V")
    public void method6456(@OriginalArg(0) Packet arg0, @OriginalArg(2) int arg1) {
        if (arg1 == 1) {
            this.anInt7196 = arg0.g2();
        } else if (arg1 == 2) {
            this.anInt7190 = arg0.g3();
        } else if (arg1 == 3) {
            this.anInt7183 = arg0.g2();
        } else if (arg1 == 4) {
            this.anInt7180 = arg0.g2();
        } else if (arg1 == 5) {
            this.anInt7181 = arg0.g2();
        } else if (arg1 == 6) {
            this.anInt7187 = arg0.g2();
        } else if (arg1 == 7) {
            this.anInt7184 = arg0.g2s();
        } else if (arg1 == 8) {
            this.aString82 = arg0.gjstr2();
        } else if (arg1 == 9) {
            this.anInt7192 = arg0.g2();
        } else if (arg1 == 10) {
            this.anInt7191 = arg0.g2s();
        } else if (arg1 == 11) {
            this.anInt7179 = 0;
        } else if (arg1 == 12) {
            this.anInt7195 = arg0.g1();
        } else if (arg1 == 13) {
            this.anInt7178 = arg0.g2s();
        } else if (arg1 == 14) {
            this.anInt7179 = arg0.g2();
        }
    }

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(IZ)Ljava/lang/String;")
    public String method6457(@OriginalArg(0) int arg0) {
        @Pc(8) String local8 = this.aString82;
        while (true) {
            @Pc(14) int local14 = local8.indexOf("%1");
            if (local14 < 0) {
                return local8;
            }
            local8 = local8.substring(0, local14) + StringTools.decimalWithSign(false, arg0) + local8.substring(local14 + 2);
        }
    }

    @OriginalMember(owner = "client!pb", name = "a", descriptor = "(ZLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet arg0) {
        while (true) {
            @Pc(3) int local3 = arg0.g1();
            if (local3 == 0) {
                return;
            }
            this.method6456(arg0, local3);
        }
    }
}
