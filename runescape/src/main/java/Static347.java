import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static347 {

    @OriginalMember(owner = "client!ku", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___146 = new ServerProt(47, 4);

    @OriginalMember(owner = "client!ku", name = "a", descriptor = "(III)Lclient!pha;")
    public static Tile getTile(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        if (Static334.activeTiles[arg0][arg1][arg2] == null) {
            @Pc(33) boolean local33 = Static334.activeTiles[0][arg1][arg2] != null && Static334.activeTiles[0][arg1][arg2].tile != null;
            if (local33 && arg0 >= Static299.tileMaxLevel - 1) {
                return null;
            }
            Static527.method7084(arg0, arg1, arg2);
        }
        return Static334.activeTiles[arg0][arg1][arg2];
    }
}
