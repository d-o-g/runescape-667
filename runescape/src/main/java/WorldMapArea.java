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

    @OriginalMember(owner = "client!qea", name = "a", descriptor = "(Lclient!sb;III)Lclient!ip;")
    public static WorldMapArea decode(@OriginalArg(0) js5 data, @OriginalArg(1) int group, @OriginalArg(2) int file) {
        @Pc(14) Packet packet = new Packet(data.getfile(file, group));
        @Pc(50) WorldMapArea area = new WorldMapArea(file, packet.gjstr(), packet.gjstr(), packet.g4(), packet.g4(), packet.g1() == 1, packet.g1(), packet.g1());

        @Pc(54) int chunkCount = packet.g1();
        for (@Pc(56) int i = 0; i < chunkCount; i++) {
            area.chunks.addLast(new WorldMapChunk(packet.g1(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2()));
        }

        area.method4090();
        return area;
    }

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
    public final Deque chunks;

    @OriginalMember(owner = "client!ip", name = "<init>", descriptor = "(ILjava/lang/String;Ljava/lang/String;IIZII)V")
    public WorldMapArea(@OriginalArg(0) int id, @OriginalArg(1) String file, @OriginalArg(2) String arg2, @OriginalArg(3) int origin, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int zoom, @OriginalArg(7) int arg7) {
        this.file = file;
        this.anInt4561 = arg4;
        this.origin = origin;
        this.zoom = zoom;
        this.id = id;
        this.aBoolean354 = arg5;
        this.aString49 = arg2;
        if (this.zoom == 255) {
            this.zoom = 0;
        }
        this.chunks = new Deque();
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(III[I)Z")
    public boolean method4085(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int[] arg2) {
        for (@Pc(23) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.method8914(arg0, arg1)) {
                chunk.project(arg2, arg0, arg1);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(BII)Z")
    public boolean contains(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        for (@Pc(17) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.method8914(arg0, arg1)) {
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(I[IIII)Z")
    public boolean method4088(@OriginalArg(1) int[] destination, @OriginalArg(2) int z, @OriginalArg(3) int level, @OriginalArg(4) int x) {
        for (@Pc(15) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.method8912(z, level, x)) {
                chunk.project(destination, x, z);
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

        for (@Pc(28) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.minZ < this.minY) {
                this.minY = chunk.minZ;
            }
            if (chunk.maxX > this.maxX) {
                this.maxX = chunk.maxX;
            }
            if (chunk.maxZ > this.maxY) {
                this.maxY = chunk.maxZ;
            }
            if (chunk.minX < this.minX) {
                this.minX = chunk.minX;
            }
        }
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(IBI[I)Z")
    public boolean method4091(@OriginalArg(0) int y, @OriginalArg(2) int x, @OriginalArg(3) int[] coords) {
        for (@Pc(9) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.contains(y, x)) {
                chunk.method8913(x, coords, y);
                return true;
            }
        }
        return false;
    }
}
