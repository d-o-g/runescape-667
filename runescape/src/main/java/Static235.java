import com.jagex.Client;
import com.jagex.core.constants.LocShapes;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static235 {

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(IIIIIIIII)V")
    public static void setLocChange(@OriginalArg(3) int x, @OriginalArg(0) int z, @OriginalArg(6) int level, @OriginalArg(8) int id, @OriginalArg(1) int shape, @OriginalArg(2) int rotation, @OriginalArg(4) int animation, @OriginalArg(5) int layer) {
        if (x < 1 || z < 1 || Static720.mapWidth - 2 < x || Static501.mapLength - 2 < z) {
            return;
        }

        @Pc(39) int virtualLevel = level;
        if (level < 3 && Static441.isBridgeAt(z, x)) {
            virtualLevel = level + 1;
        }

        if (ClientOptions.instance.animateBackground.getValue() == 0 && !Static696.isTileVisibleFrom(z, Static164.areaLevel, x, virtualLevel)) {
            return;
        }

        if (Static334.activeTiles == null) {
            return;
        }

        MapRegion.active.removeLoc(level, x, z, layer, Client.collisionMaps[level], Toolkit.active);

        if (id >= 0) {
            @Pc(93) int valueBefore = ClientOptions.instance.groundDecor.getValue();
            ClientOptions.instance.update(1, ClientOptions.instance.groundDecor);
            MapRegion.active.loadLocation(x, z, level, virtualLevel, id, shape, rotation, animation, Client.collisionMaps[level], Toolkit.active);
            ClientOptions.instance.update(valueBefore, ClientOptions.instance.groundDecor);
        }
    }

    @OriginalMember(owner = "client!hf", name = "b", descriptor = "(III)Z")
    public static boolean loadedModels(@OriginalArg(0) int id, @OriginalArg(2) int shape) {
        if (shape == LocShapes.CENTREPIECE_DIAGONAL) {
            shape = LocShapes.CENTREPIECE_STRAIGHT;
        }
        @Pc(19) LocType locType = LocTypeList.instance.list(id);
        if (shape >= LocShapes.WALLDECOR_STRAIGHT_OFFSET && shape <= LocShapes.WALLDECOR_DIAGONAL_BOTH) {
            shape = LocShapes.WALLDECOR_STRAIGHT_NOOFFSET;
        }
        return locType.loadedModels(shape);
    }

}
