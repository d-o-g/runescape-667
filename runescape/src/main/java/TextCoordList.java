import com.jagex.ClientTextCoord;
import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class TextCoordList {

    @OriginalMember(owner = "client!nfa", name = "b", descriptor = "Lclient!fla;")
    public static final LinkedList textCoords = new LinkedList();

    @OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILjava/lang/String;IIII)V")
    public static void add(@OriginalArg(1) int level, @OriginalArg(6) int x, @OriginalArg(5) int y, @OriginalArg(7) int z, @OriginalArg(3) String text, @OriginalArg(4) int colour, @OriginalArg(2) int duration) {
        @Pc(7) ClientTextCoord textCoord = new ClientTextCoord();
        textCoord.level = level;
        textCoord.z = z;
        textCoord.colour = colour;
        textCoord.text = text;
        textCoord.x = x;
        textCoord.end = TimeUtils.clock + duration;
        textCoord.y = y;
        textCoords.add(textCoord);
    }
}
