import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class TextureMapping {

    @OriginalMember(owner = "client!mia", name = "a", descriptor = "(III[FIF[FIIII)V")
    public static void sphereMap(@OriginalArg(8) int x, @OriginalArg(2) int y, @OriginalArg(1) int z, @OriginalArg(0) int originX, @OriginalArg(10) int originY, @OriginalArg(4) int originZ, @OriginalArg(6) float[] matrix, @OriginalArg(5) float offset, @OriginalArg(7) int direction, @OriginalArg(3) float[] uv) {
        @Pc(3) int relativeZ = z - originZ;
        @Pc(11) int relativeY = y - originY;
        @Pc(15) int relativeX = x - originX;

        @Pc(36) float mapX = (matrix[0] * (float) relativeX) + (matrix[1] * (float) relativeY) + (matrix[2] * (float) relativeZ);
        @Pc(57) float mapY = (matrix[3] * (float) relativeX) + (matrix[4] * (float) relativeY) + (matrix[5] * (float) relativeZ);
        @Pc(78) float mapZ = (matrix[6] * (float) relativeX) + (matrix[7] * (float) relativeY) + (matrix[8] * (float) relativeZ);

        @Pc(93) float r = (float) Math.sqrt((mapX * mapX) + (mapY * mapY) + (mapZ * mapZ));
        @Pc(111) float u = ((float) Math.atan2(mapX, mapZ) / 6.2831855F) + 0.5F;
        @Pc(124) float v = ((float) Math.asin(mapY / r) / 3.1415927F) + 0.5F + offset;

        if (direction == 1) {
            @Pc(146) float temp = u;
            u = -v;
            v = temp;
        } else if (direction == 2) {
            u = -u;
            v = -v;
        } else if (direction == 3) {
            @Pc(146) float temp = u;
            u = v;
            v = -temp;
        }

        uv[0] = u;
        uv[1] = v;
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(FIIFI[FIIIIIF[FI)V")
    public static void cubeMap(@OriginalArg(2) int x, @OriginalArg(6) int y, @OriginalArg(8) int z, @OriginalArg(9) int originX, @OriginalArg(4) int originY, @OriginalArg(10) int originZ, @OriginalArg(12) float[] matrix, @OriginalArg(0) float offsetX, @OriginalArg(3) float offsetY, @OriginalArg(11) float offsetZ, @OriginalArg(1) int face, @OriginalArg(13) int direction, @OriginalArg(5) float[] uv) {
        @Pc(5) int relativeY = y - originY;
        @Pc(13) int relativeX = x - originX;
        @Pc(17) int relativeZ = z - originZ;

        @Pc(38) float mapX = (matrix[0] * (float) relativeX) + (matrix[1] * (float) relativeY) + (matrix[2] * (float) relativeZ);
        @Pc(59) float mapY = (matrix[3] * (float) relativeX) + (matrix[4] * (float) relativeY) + (matrix[5] * (float) relativeZ);
        @Pc(93) float mapZ = (matrix[6] * (float) relativeX) + (matrix[7] * (float) relativeY) + (matrix[8] * (float) relativeZ);

        @Pc(133) float u;
        @Pc(126) float v;
        if (face == 0) {
            u = offsetX + 0.5F + mapX;
            v = offsetZ + 0.5F - mapZ;
        } else if (face == 1) {
            v = offsetZ + 0.5F + mapZ;
            u = offsetX + 0.5F + mapX;
        } else if (face == 2) {
            u = offsetX + 0.5F - mapX;
            v = offsetY + 0.5F - mapY;
        } else if (face == 3) {
            u = offsetX + 0.5F + mapX;
            v = offsetY + 0.5F - mapY;
        } else if (face == 4) {
            u = offsetZ + 0.5F + mapZ;
            v = offsetY + 0.5F - mapY;
        } else {
            v = offsetY + 0.5F - mapY;
            u = offsetZ + 0.5F - mapZ;
        }

        if (direction == 1) {
            @Pc(227) float temp = u;
            u = -v;
            v = temp;
        } else if (direction == 2) {
            v = -v;
            u = -u;
        } else if (direction == 3) {
            @Pc(227) float temp = u;
            u = v;
            v = -temp;
        }

        uv[1] = v;
        uv[0] = u;
    }

    @OriginalMember(owner = "client!fa", name = "a", descriptor = "(IFFF)I")
    public static int cubeFace(@OriginalArg(2) float x, @OriginalArg(3) float y, @OriginalArg(1) float z) {
        @Pc(20) float absX = x < 0.0F ? -x : x;
        @Pc(30) float absY = y < 0.0F ? -y : y;
        @Pc(40) float absZ = z < 0.0F ? -z : z;

        if (absY > absX && absZ < absY) {
            return y > 0.0F ? 0 : 1;
        } else if (absX < absZ && absY < absZ) {
            return z > 0.0F ? 2 : 3;
        } else {
            return x > 0.0F ? 4 : 5;
        }
    }

    @OriginalMember(owner = "client!cp", name = "a", descriptor = "([FFIII[FFIIIII)V")
    public static void cylinderMap(@OriginalArg(3) int x, @OriginalArg(9) int y, @OriginalArg(10) int z, @OriginalArg(11) int originX, @OriginalArg(7) int originY, @OriginalArg(2) int originZ, @OriginalArg(0) float[] matrix, @OriginalArg(6) float scale, @OriginalArg(1) float offset, @OriginalArg(4) int direction, @OriginalArg(5) float[] uv) {
        @Pc(5) int relativeX = x - originX;
        @Pc(9) int relativeZ = z - originZ;
        @Pc(20) int relativeY = y - originY;

        @Pc(45) float mapX = (matrix[0] * (float) relativeX) + (matrix[1] * (float) relativeY) + (matrix[2] * (float) relativeZ);
        @Pc(66) float mapY = (matrix[3] * (float) relativeX) + (matrix[4] * (float) relativeY) + (matrix[5] * (float) relativeZ);
        @Pc(87) float mapZ = (matrix[6] * (float) relativeX) + (matrix[7] * (float) relativeY) + (matrix[8] * (float) relativeZ);

        @Pc(98) float u = (float) Math.atan2(mapX, mapZ) / 6.2831855F + 0.5F;
        if (scale != 1.0F) {
            u *= scale;
        }

        @Pc(112) float v = offset + mapY + 0.5F;

        if (direction == 1) {
            @Pc(131) float temp = u;
            u = -v;
            v = temp;
        } else if (direction == 2) {
            v = -v;
            u = -u;
        } else if (direction == 3) {
            @Pc(131) float temp = u;
            u = v;
            v = -temp;
        }

        uv[1] = v;
        uv[0] = u;
    }

    private TextureMapping() {
        /* empty */
    }
}
