import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nc")
public final class MapElementList {

    @OriginalMember(owner = "client!iu", name = "a", descriptor = "(ZILclient!sb;Ljava/lang/String;)Lclient!nc;")
    public static MapElementList load(@OriginalArg(0) boolean mapMembers, @OriginalArg(2) js5 worldmapdata, @OriginalArg(3) String fileName) {
        @Pc(8) int groupId = worldmapdata.getgroupid(fileName);
        if (groupId == -1) {
            return new MapElementList(0);
        }

        @Pc(24) int[] fileIds = worldmapdata.fileIds(groupId);
        @Pc(30) MapElementList list = new MapElementList(fileIds.length);

        @Pc(32) int i = 0;
        @Pc(34) int count = 0;
        while (i < list.size) {
            @Pc(47) Packet packet = new Packet(worldmapdata.getfile(fileIds[count++], groupId));
            @Pc(51) int coord = packet.g4();
            @Pc(57) int function = packet.g2();
            @Pc(61) int members = packet.g1();

            if (!mapMembers && members == 1) {
                list.size--;
            } else {
                list.coords[i] = coord;
                list.elements[i] = function;
                i++;
            }
        }

        return list;
    }

    @OriginalMember(owner = "client!nc", name = "d", descriptor = "I")
    public int size;

    @OriginalMember(owner = "client!nc", name = "e", descriptor = "[I")
    public final int[] coords;

    @OriginalMember(owner = "client!nc", name = "b", descriptor = "[I")
    public final int[] elements;

    @OriginalMember(owner = "client!nc", name = "<init>", descriptor = "(I)V")
    public MapElementList(@OriginalArg(0) int size) {
        this.size = size;
        this.coords = new int[this.size];
        this.elements = new int[this.size];
    }
}
