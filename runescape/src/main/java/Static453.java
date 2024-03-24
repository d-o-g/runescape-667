import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static453 {

    @OriginalMember(owner = "client!of", name = "a", descriptor = "(Lclient!eo;III)V")
    public static void shareLight(@OriginalArg(0) Entity entity, @OriginalArg(1) int level, @OriginalArg(2) int x, @OriginalArg(3) int y) {
        @Pc(12) Tile tile;
        if (x < Static619.tileMaxX) {
            tile = Static334.activeTiles[level][x + 1][y];
            if (tile != null && tile.groundDecor != null && tile.groundDecor.method9290(0)) {
                entity.shareLight(0, true, Static665.aToolkit_15, 0, (byte) 108, Static340.anInt5586, tile.groundDecor);
            }
        }
        if (y < Static619.tileMaxX) {
            tile = Static334.activeTiles[level][x][y + 1];
            if (tile != null && tile.groundDecor != null && tile.groundDecor.method9290(0)) {
                entity.shareLight(0, true, Static665.aToolkit_15, Static340.anInt5586, (byte) 118, 0, tile.groundDecor);
            }
        }
        if (x < Static619.tileMaxX && y < Static662.tileMaxZ) {
            tile = Static334.activeTiles[level][x + 1][y + 1];
            if (tile != null && tile.groundDecor != null && tile.groundDecor.method9290(0)) {
                entity.shareLight(0, true, Static665.aToolkit_15, Static340.anInt5586, (byte) 122, Static340.anInt5586, tile.groundDecor);
            }
        }
        if (x < Static619.tileMaxX && y > 0) {
            tile = Static334.activeTiles[level][x + 1][y - 1];
            if (tile != null && tile.groundDecor != null && tile.groundDecor.method9290(0)) {
                entity.shareLight(0, true, Static665.aToolkit_15, -Static340.anInt5586, (byte) 121, Static340.anInt5586, tile.groundDecor);
            }
        }
    }
}
