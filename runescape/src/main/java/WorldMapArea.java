import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ip")
public final class WorldMapArea extends Node2 {

    @OriginalMember(owner = "client!ip", name = "J", descriptor = "I")
    public int maxX = 0;

    @OriginalMember(owner = "client!ip", name = "L", descriptor = "I")
    public int minY = 12800;

    @OriginalMember(owner = "client!ip", name = "u", descriptor = "I")
    public int minX = 12800;

    @OriginalMember(owner = "client!ip", name = "B", descriptor = "Z")
    public boolean aBoolean354 = true;

    @OriginalMember(owner = "client!ip", name = "I", descriptor = "I")
    public int maxY = 0;

    @OriginalMember(owner = "client!ip", name = "N", descriptor = "I")
    public int anInt4561 = -1;

    @OriginalMember(owner = "client!ip", name = "w", descriptor = "I")
    public int zoom = -1;

    @OriginalMember(owner = "client!ip", name = "H", descriptor = "Ljava/lang/String;")
    public final String file;

    @OriginalMember(owner = "client!ip", name = "C", descriptor = "I")
    public final int origin;

    @OriginalMember(owner = "client!ip", name = "A", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!ip", name = "F", descriptor = "Ljava/lang/String;")
    public final String aString49;

    @OriginalMember(owner = "client!ip", name = "t", descriptor = "Lclient!sia;")
    public final Deque aDeque_26;

    @OriginalMember(owner = "client!ip", name = "<init>", descriptor = "(ILjava/lang/String;Ljava/lang/String;IIZII)V")
    public WorldMapArea(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        this.file = arg1;
        this.anInt4561 = arg4;
        this.origin = arg3;
        this.zoom = arg6;
        this.id = arg0;
        this.aBoolean354 = arg5;
        this.aString49 = arg2;
        if (this.zoom == 255) {
            this.zoom = 0;
        }
        this.aDeque_26 = new Deque();
    }

    @OriginalMember(owner = "client!qea", name = "a", descriptor = "(Lclient!sb;III)Lclient!ip;")
    public static WorldMapArea decode(@OriginalArg(0) js5 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(14) Packet local14 = new Packet(arg0.getfile(arg2, arg1));
        @Pc(50) WorldMapArea local50 = new WorldMapArea(arg2, local14.gjstr(), local14.gjstr(), local14.g4(), local14.g4(), local14.g1() == 1, local14.g1(), local14.g1());
        @Pc(54) int local54 = local14.g1();
        for (@Pc(56) int local56 = 0; local56 < local54; local56++) {
            local50.aDeque_26.addLast(new Node_Sub56(local14.g1(), local14.g2(), local14.g2(), local14.g2(), local14.g2(), local14.g2(), local14.g2(), local14.g2(), local14.g2()));
        }
        local50.method4090();
        return local50;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(III[I)Z")
    public boolean method4085(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int[] arg2) {
        for (@Pc(23) Node_Sub56 local23 = (Node_Sub56) this.aDeque_26.first(); local23 != null; local23 = (Node_Sub56) this.aDeque_26.next()) {
            if (local23.method8914(arg0, arg1)) {
                local23.method8907(arg2, arg0, arg1);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(BII)Z")
    public boolean method4086(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        for (@Pc(17) Node_Sub56 local17 = (Node_Sub56) this.aDeque_26.first(); local17 != null; local17 = (Node_Sub56) this.aDeque_26.next()) {
            if (local17.method8914(arg0, arg1)) {
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(I[IIII)Z")
    public boolean method4088(@OriginalArg(1) int[] destination, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        for (@Pc(15) Node_Sub56 local15 = (Node_Sub56) this.aDeque_26.first(); local15 != null; local15 = (Node_Sub56) this.aDeque_26.next()) {
            if (local15.method8912(arg1, arg2, arg3)) {
                local15.method8907(destination, arg3, arg1);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(I)V")
    public void method4090() {
        this.maxY = 0;
        this.minX = 12800;
        this.minY = 12800;
        this.maxX = 0;
        for (@Pc(28) Node_Sub56 local28 = (Node_Sub56) this.aDeque_26.first(); local28 != null; local28 = (Node_Sub56) this.aDeque_26.next()) {
            if (local28.anInt10275 < this.minY) {
                this.minY = local28.anInt10275;
            }
            if (this.maxX < local28.anInt10270) {
                this.maxX = local28.anInt10270;
            }
            if (this.maxY < local28.anInt10265) {
                this.maxY = local28.anInt10265;
            }
            if (this.minX > local28.anInt10266) {
                this.minX = local28.anInt10266;
            }
        }
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(IBI[I)Z")
    public boolean method4091(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int[] arg2) {
        for (@Pc(9) Node_Sub56 local9 = (Node_Sub56) this.aDeque_26.first(); local9 != null; local9 = (Node_Sub56) this.aDeque_26.next()) {
            if (local9.method8910(arg0, arg1)) {
                local9.method8913(arg1, arg2, arg0);
                return true;
            }
        }
        return false;
    }
}
