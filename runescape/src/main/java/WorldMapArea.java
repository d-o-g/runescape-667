import com.jagex.core.datastruct.key.DoublyLinkedNode;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ip")
public final class WorldMapArea extends DoublyLinkedNode {

    @OriginalMember(owner = "client!qea", name = "a", descriptor = "(Lclient!sb;III)Lclient!ip;")
    public static WorldMapArea decode(@OriginalArg(0) js5 data, @OriginalArg(1) int group, @OriginalArg(2) int file) {
        @Pc(14) Packet packet = new Packet(data.getfile(file, group));
        @Pc(50) WorldMapArea area = new WorldMapArea(file, packet.gjstr(), packet.gjstr(), packet.g4(), packet.g4(), packet.g1() == 1, packet.g1(), packet.g1());

        @Pc(54) int chunkCount = packet.g1();
        for (@Pc(56) int i = 0; i < chunkCount; i++) {
            area.chunks.addLast(new WorldMapChunk(packet.g1(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2(), packet.g2()));
        }

        area.resize();
        return area;
    }

    @OriginalMember(owner = "client!ip", name = "J", descriptor = "I")
    public int chunkMaxX = 0;

    @OriginalMember(owner = "client!ip", name = "L", descriptor = "I")
    public int chunkMinZ = 12800;

    @OriginalMember(owner = "client!ip", name = "u", descriptor = "I")
    public int chunkMinX = 12800;

    @OriginalMember(owner = "client!ip", name = "B", descriptor = "Z")
    public boolean aBoolean354 = true;

    @OriginalMember(owner = "client!ip", name = "I", descriptor = "I")
    public int chunkMaxZ = 0;

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
    public final String name;

    @OriginalMember(owner = "client!ip", name = "t", descriptor = "Lclient!sia;")
    public final Deque chunks;

    @OriginalMember(owner = "client!ip", name = "<init>", descriptor = "(ILjava/lang/String;Ljava/lang/String;IIZII)V")
    public WorldMapArea(@OriginalArg(0) int id, @OriginalArg(1) String file, @OriginalArg(2) String name, @OriginalArg(3) int origin, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int zoom, @OriginalArg(7) int arg7) {
        this.file = file;
        this.anInt4561 = arg4;
        this.origin = origin;
        this.zoom = zoom;
        this.id = id;
        this.aBoolean354 = arg5;
        this.name = name;
        if (this.zoom == 255) {
            this.zoom = 0;
        }
        this.chunks = new Deque();
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(BII)Z")
    public boolean sourceContains(@OriginalArg(1) int x, @OriginalArg(2) int z) {
        for (@Pc(17) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.sourceContains(x, z)) {
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(IBI[I)Z")
    public boolean projectSource(@OriginalArg(3) int[] coords, @OriginalArg(2) int x, @OriginalArg(0) int z) {
        for (@Pc(9) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.displayContains(x, z)) {
                chunk.projectSource(coords, x, z);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(III[I)Z")
    public boolean projectDisplay(@OriginalArg(3) int[] destination, @OriginalArg(1) int x, @OriginalArg(2) int z) {
        for (@Pc(23) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.sourceContains(x, z)) {
                chunk.projectDisplay(destination, x, z);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(I[IIII)Z")
    public boolean projectDisplay(@OriginalArg(1) int[] destination, @OriginalArg(3) int level, @OriginalArg(4) int x, @OriginalArg(2) int z) {
        for (@Pc(15) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.sourceContains(level, x, z)) {
                chunk.projectDisplay(destination, x, z);
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ip", name = "a", descriptor = "(I)V")
    public void resize() {
        this.chunkMaxZ = 0;
        this.chunkMinX = 12800;
        this.chunkMinZ = 12800;
        this.chunkMaxX = 0;

        for (@Pc(28) WorldMapChunk chunk = (WorldMapChunk) this.chunks.first(); chunk != null; chunk = (WorldMapChunk) this.chunks.next()) {
            if (chunk.displayZ1 < this.chunkMinZ) {
                this.chunkMinZ = chunk.displayZ1;
            }
            if (chunk.displayX2 > this.chunkMaxX) {
                this.chunkMaxX = chunk.displayX2;
            }
            if (chunk.displayZ2 > this.chunkMaxZ) {
                this.chunkMaxZ = chunk.displayZ2;
            }
            if (chunk.displayX1 < this.chunkMinX) {
                this.chunkMinX = chunk.displayX1;
            }
        }
    }
}
