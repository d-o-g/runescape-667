package com.jagex.game.collision;

import com.jagex.core.constants.LocShapes;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import static com.jagex.game.collision.CollisionFlag.BLOCK_WALK;
import static com.jagex.game.collision.CollisionFlag.DIRECTION_EAST;
import static com.jagex.game.collision.CollisionFlag.DIRECTION_NORTH;
import static com.jagex.game.collision.CollisionFlag.DIRECTION_SOUTH;
import static com.jagex.game.collision.CollisionFlag.DIRECTION_WEST;
import static com.jagex.game.collision.CollisionFlag.GROUND_DECOR;
import static com.jagex.game.collision.CollisionFlag.LOCATION;
import static com.jagex.game.collision.CollisionFlag.LOCATION_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.LOCATION_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL;
import static com.jagex.game.collision.CollisionFlag.WALL_EAST;
import static com.jagex.game.collision.CollisionFlag.WALL_EAST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_EAST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_EAST;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_EAST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_EAST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_WEST;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_WEST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_AND_WEST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_EAST;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_EAST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_EAST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_WEST;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_WEST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_NORTH_WEST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_EAST;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_EAST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_EAST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_WEST;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_WEST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_AND_WEST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_EAST;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_EAST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_EAST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_WEST;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_WEST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_SOUTH_WEST_BLOCK_ROUTE;
import static com.jagex.game.collision.CollisionFlag.WALL_WEST;
import static com.jagex.game.collision.CollisionFlag.WALL_WEST_BLOCK_RANGED;
import static com.jagex.game.collision.CollisionFlag.WALL_WEST_BLOCK_ROUTE;

@OriginalClass("client!eq")
public final class CollisionMap {

    @OriginalMember(owner = "client!eq", name = "p", descriptor = "I")
    public int width;

    @OriginalMember(owner = "client!eq", name = "n", descriptor = "I")
    public int z;

    @OriginalMember(owner = "client!eq", name = "e", descriptor = "[[I")
    public int[][] flags;

    @OriginalMember(owner = "client!eq", name = "u", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!eq", name = "i", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!dt", name = "a", descriptor = "(IIB)Lclient!eq;")
    public static CollisionMap create(@OriginalArg(0) int width, @OriginalArg(1) int height) {
        @Pc(7) CollisionMap map = new CollisionMap();
        map.x = -1;
        map.z = -1;
        map.width = width + 6;
        map.height = height + 5 + 1;
        map.flags = new int[map.width][map.height];
        map.reset();
        return map;
    }

    @OriginalMember(owner = "client!il", name = "a", descriptor = "(IIIIIIIII)Z")
    public static boolean isInsideRect(@OriginalArg(0) int destX, @OriginalArg(1) int width, @OriginalArg(2) int x, @OriginalArg(4) int destWidth, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7) {
        if (x < destX + destWidth && x + width > destX) {
            return arg5 < arg6 + arg4 && arg6 < arg7 + arg5;
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!eq", name = "b", descriptor = "(IIIIIIII)Z")
    public boolean isAtDiagonalWallDecor(@OriginalArg(0) int x, @OriginalArg(2) int shape, @OriginalArg(3) int destX, @OriginalArg(4) int destZ, @OriginalArg(5) int rotation, @OriginalArg(6) int z, @OriginalArg(7) int size) {
        if (size == 1) {
            if (x == destX && z == destZ) {
                return true;
            }
        } else {
            if (x <= destX && (x + size - 1) >= destX && (destZ <= destZ) && (destZ + size - 1) >= destZ) {
                return true;
            }
        }

        @Pc(59) int destZ1 = destZ - this.z;
        @Pc(64) int z1 = z - this.z;
        @Pc(69) int x1 = x - this.x;
        @Pc(74) int destX1 = destX - this.x;

        if (size == 1) {
            if (shape == LocShapes.WALLDECOR_DIAGONAL_OFFSET || shape == LocShapes.WALLDECOR_DIAGONAL_NOOFFSET) {
                if (shape == 7) {
                    rotation = rotation + 2 & 0x3;
                }

                if (rotation == 0) {
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_WEST) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & WALL_NORTH) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_EAST) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & WALL_NORTH) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_EAST) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & WALL_SOUTH) == 0) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_WEST) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & WALL_SOUTH) == 0) {
                        return true;
                    }
                }
            }

            if (shape == LocShapes.WALLDECOR_DIAGONAL_BOTH) {
                if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & WALL_SOUTH) == 0) {
                    return true;
                }
                if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & WALL_NORTH) == 0) {
                    return true;
                }
                if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_EAST) == 0) {
                    return true;
                }
                if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_WEST) == 0) {
                    return true;
                }
            }
        } else {
            @Pc(512) int x2 = x1 + size - 1;
            @Pc(518) int z2 = z1 + size - 1;

            if (shape == LocShapes.WALLDECOR_DIAGONAL_OFFSET || shape == LocShapes.WALLDECOR_DIAGONAL_NOOFFSET) {
                if (shape == LocShapes.WALLDECOR_DIAGONAL_NOOFFSET) {
                    rotation = rotation + 2 & 0x3;
                }

                if (rotation == 0) {
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & WALL_WEST) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & WALL_NORTH) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & WALL_EAST) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & WALL_NORTH) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & WALL_EAST) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & WALL_SOUTH) == 0) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & WALL_WEST) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && destX1 <= x2 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & WALL_SOUTH) == 0) {
                        return true;
                    }
                }
            }

            if (shape == LocShapes.WALLDECOR_DIAGONAL_BOTH) {
                if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & WALL_SOUTH) == 0) {
                    return true;
                }
                if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & WALL_NORTH) == 0) {
                    return true;
                }
                if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & WALL_EAST) == 0) {
                    return true;
                }
                if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & WALL_WEST) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIIZ)V")
    public void unflag(@OriginalArg(2) int x, @OriginalArg(0) int z, @OriginalArg(1) int flags) {
        this.flags[x][z] &= ~flags;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIBIIIIIII)Z")
    public boolean isOutsideRect(@OriginalArg(4) int x1, @OriginalArg(8) int z1, @OriginalArg(0) int width, @OriginalArg(3) int height, @OriginalArg(5) int destX1, @OriginalArg(1) int destZ1, @OriginalArg(9) int destWidth, @OriginalArg(7) int destHeight, @OriginalArg(6) int direction) {
        @Pc(7) int x2 = x1 + width;
        @Pc(11) int z2 = z1 + height;
        @Pc(23) int destX2 = destX1 + destWidth;
        @Pc(27) int destZ2 = destZ1 + destHeight;

        if (x1 == destX2 && (direction & DIRECTION_EAST) == 0) {
            @Pc(75) int fromZ = z1 > destZ1 ? z1 : destZ1;
            @Pc(83) int toZ = z2 >= destZ2 ? destZ2 : z2;

            while (fromZ < toZ) {
                if ((this.flags[destX2 - this.x - 1][fromZ - this.z] & WALL_EAST) == 0) {
                    return true;
                }
                fromZ++;
            }
        } else if (x2 == destX1 && (direction & DIRECTION_WEST) == 0) {
            @Pc(75) int fromZ = z1 <= destZ1 ? destZ1 : z1;
            @Pc(83) int toZ = z2 >= destZ2 ? destZ2 : z2;

            while (fromZ < toZ) {
                if ((this.flags[destX1 - this.x][fromZ - this.z] & WALL_WEST) == 0) {
                    return true;
                }
                fromZ++;
            }
        } else if (z1 == destZ2 && (direction & DIRECTION_NORTH) == 0) {
            @Pc(75) int fromX = x1 <= destX1 ? destX1 : x1;
            @Pc(83) int toX = x2 >= destX2 ? destX2 : x2;

            while (fromX < toX) {
                if ((this.flags[fromX - this.x][destZ2 - this.z - 1] & WALL_NORTH) == 0) {
                    return true;
                }
                fromX++;
            }
        } else if (z2 == destZ1 && (direction & DIRECTION_SOUTH) == 0) {
            @Pc(75) int fromX = x1 > destX1 ? x1 : destX1;
            @Pc(83) int toX = x2 >= destX2 ? destX2 : x2;

            while (toX > fromX) {
                if ((this.flags[fromX - this.x][destZ1 - this.z] & WALL_SOUTH) == 0) {
                    return true;
                }
                fromX++;
            }
        }

        return false;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IZZIIII)V")
    public void flagWall(@OriginalArg(1) boolean blockRanged, @OriginalArg(2) boolean blockRoute, @OriginalArg(3) int z, @OriginalArg(4) int rotation, @OriginalArg(5) int shape, @OriginalArg(6) int x) {
        @Pc(8) int z1 = z - this.z;
        @Pc(13) int x1 = x - this.x;

        if (shape == LocShapes.WALL_STRAIGHT) {
            if (rotation == 0) {
                this.flag(x1, z1, WALL_WEST);
                this.flag(x1 - 1, z1, WALL_EAST);
            }
            if (rotation == 1) {
                this.flag(x1, z1, WALL_NORTH);
                this.flag(x1, z1 + 1, WALL_SOUTH);
            }
            if (rotation == 2) {
                this.flag(x1, z1, WALL_EAST);
                this.flag(x1 + 1, z1, WALL_WEST);
            }
            if (rotation == 3) {
                this.flag(x1, z1, WALL_SOUTH);
                this.flag(x1, z1 - 1, WALL_NORTH);
            }
        }
        if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
            if (rotation == 0) {
                this.flag(x1, z1, WALL_NORTH_WEST);
                this.flag(x1 - 1, z1 - -1, WALL_SOUTH_EAST);
            }
            if (rotation == 1) {
                this.flag(x1, z1, WALL_NORTH_EAST);
                this.flag(x1 + 1, z1 + 1, WALL_SOUTH_WEST);
            }
            if (rotation == 2) {
                this.flag(x1, z1, WALL_SOUTH_EAST);
                this.flag(x1 + 1, z1 + -1, WALL_NORTH_WEST);
            }
            if (rotation == 3) {
                this.flag(x1, z1, WALL_SOUTH_WEST);
                this.flag(x1 - 1, z1 + -1, WALL_NORTH_EAST);
            }
        }
        if (shape == LocShapes.WALL_L) {
            if (rotation == 0) {
                this.flag(x1, z1, WALL_NORTH_AND_WEST);
                this.flag(x1 - 1, z1, WALL_EAST);
                this.flag(x1, z1 + 1, WALL_SOUTH);
            }
            if (rotation == 1) {
                this.flag(x1, z1, WALL_NORTH_AND_EAST);
                this.flag(x1, z1 + 1, WALL_SOUTH);
                this.flag(x1 + 1, z1, WALL_WEST);
            }
            if (rotation == 2) {
                this.flag(x1, z1, WALL_SOUTH_AND_EAST);
                this.flag(x1 + 1, z1, WALL_WEST);
                this.flag(x1, z1 - 1, WALL_NORTH);
            }
            if (rotation == 3) {
                this.flag(x1, z1, WALL_SOUTH_AND_WEST);
                this.flag(x1, z1 - 1, WALL_NORTH);
                this.flag(x1 - 1, z1, WALL_EAST);
            }
        }

        if (blockRanged) {
            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_WEST_BLOCK_RANGED);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_BLOCK_RANGED);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_EAST_BLOCK_RANGED);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_BLOCK_RANGED);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                }
            }
            if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_NORTH_WEST_BLOCK_RANGED);
                    this.flag(x1 - 1, z1 + 1, WALL_SOUTH_EAST_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_EAST_BLOCK_RANGED);
                    this.flag(x1 + 1, z1 + 1, WALL_SOUTH_WEST_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_SOUTH_EAST_BLOCK_RANGED);
                    this.flag(x1 + 1, z1 + -1, WALL_NORTH_WEST_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_WEST_BLOCK_RANGED);
                    this.flag(x1 - 1, z1 + -1, WALL_NORTH_EAST_BLOCK_RANGED);
                }
            }
            if (shape == LocShapes.WALL_L) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_NORTH_AND_WEST_BLOCK_RANGED);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_AND_EAST_BLOCK_RANGED);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_SOUTH_AND_EAST_BLOCK_RANGED);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_AND_WEST_BLOCK_RANGED);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                }
            }
        }

        if (blockRoute) {
            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_WEST_BLOCK_ROUTE);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_BLOCK_ROUTE);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_EAST_BLOCK_ROUTE);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_BLOCK_ROUTE);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                }
            }
            if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_NORTH_WEST_BLOCK_ROUTE);
                    this.flag(x1 - 1, z1 + 1, WALL_SOUTH_EAST_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_EAST_BLOCK_ROUTE);
                    this.flag(x1 + 1, z1 - -1, WALL_SOUTH_WEST_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_SOUTH_EAST_BLOCK_ROUTE);
                    this.flag(x1 + 1, z1 + -1, WALL_NORTH_WEST_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_WEST_BLOCK_ROUTE);
                    this.flag(x1 - 1, z1 + -1, WALL_NORTH_EAST_BLOCK_ROUTE);
                }
            }
            if (shape == LocShapes.WALL_L) {
                if (rotation == 0) {
                    this.flag(x1, z1, WALL_NORTH_AND_WEST_BLOCK_ROUTE);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_ROUTE);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.flag(x1, z1, WALL_NORTH_AND_EAST_BLOCK_ROUTE);
                    this.flag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.flag(x1, z1, WALL_SOUTH_AND_EAST_BLOCK_ROUTE);
                    this.flag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.flag(x1, z1, WALL_SOUTH_AND_WEST_BLOCK_ROUTE);
                    this.flag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                    this.flag(x1 - 1, z1, WALL_EAST_BLOCK_ROUTE);
                }
            }
        }
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIIBZIZ)V")
    public void unflagWall(@OriginalArg(0) int z, @OriginalArg(1) int rotation, @OriginalArg(2) int shape, @OriginalArg(4) boolean blockRoute, @OriginalArg(5) int x, @OriginalArg(6) boolean blockRanged) {
        @Pc(4) int x1 = x - this.x;
        @Pc(17) int z1 = z - this.z;

        if (shape == LocShapes.WALL_STRAIGHT) {
            if (rotation == 0) {
                this.unflag(x1, z1, WALL_WEST);
                this.unflag(x1 - 1, z1, WALL_EAST);
            }
            if (rotation == 1) {
                this.unflag(x1, z1, WALL_NORTH);
                this.unflag(x1, z1 + 1, WALL_SOUTH);
            }
            if (rotation == 2) {
                this.unflag(x1, z1, WALL_EAST);
                this.unflag(x1 + 1, z1, WALL_WEST);
            }
            if (rotation == 3) {
                this.unflag(x1, z1, WALL_SOUTH);
                this.unflag(x1, z1 - 1, WALL_NORTH);
            }
        }
        if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
            if (rotation == 0) {
                this.unflag(x1, z1, WALL_NORTH_WEST);
                this.unflag(x1 - 1, z1 + 1, WALL_SOUTH_EAST);
            }
            if (rotation == 1) {
                this.unflag(x1, z1, WALL_NORTH_EAST);
                this.unflag(x1 + 1, z1 + 1, WALL_SOUTH_WEST);
            }
            if (rotation == 2) {
                this.unflag(x1, z1, WALL_SOUTH_EAST);
                this.unflag(x1 + 1, z1 - 1, WALL_NORTH_WEST);
            }
            if (rotation == 3) {
                this.unflag(x1, z1, WALL_SOUTH_WEST);
                this.unflag(x1 - 1, z1 - 1, WALL_NORTH_EAST);
            }
        }
        if (shape == LocShapes.WALL_L) {
            if (rotation == 0) {
                this.unflag(x1, z1, WALL_NORTH_AND_WEST);
                this.unflag(x1 - 1, z1, WALL_EAST);
                this.unflag(x1, z1 + 1, WALL_SOUTH);
            }
            if (rotation == 1) {
                this.unflag(x1, z1, WALL_NORTH_AND_EAST);
                this.unflag(x1, z1 + 1, WALL_SOUTH);
                this.unflag(x1 + 1, z1, WALL_WEST);
            }
            if (rotation == 2) {
                this.unflag(x1, z1, WALL_SOUTH_AND_EAST);
                this.unflag(x1 + 1, z1, WALL_WEST);
                this.unflag(x1, z1 - 1, WALL_NORTH);
            }
            if (rotation == 3) {
                this.unflag(x1, z1, WALL_SOUTH_AND_WEST);
                this.unflag(x1, z1 - 1, WALL_NORTH);
                this.unflag(x1 - 1, z1, WALL_EAST);
            }
        }

        if (blockRanged) {
            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_WEST_BLOCK_RANGED);
                    this.unflag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_BLOCK_RANGED);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_EAST_BLOCK_RANGED);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_BLOCK_RANGED);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                }
            }
            if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_NORTH_WEST_BLOCK_RANGED);
                    this.unflag(x1 - 1, z1 + 1, WALL_SOUTH_EAST_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_EAST_BLOCK_RANGED);
                    this.unflag(x1 + 1, z1 + 1, WALL_SOUTH_WEST_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_SOUTH_EAST_BLOCK_RANGED);
                    this.unflag(x1 + 1, z1 - 1, WALL_NORTH_WEST_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_WEST_BLOCK_RANGED);
                    this.unflag(x1 - 1, z1 - 1, WALL_NORTH_EAST_BLOCK_RANGED);
                }
            }
            if (shape == LocShapes.WALL_L) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_NORTH_AND_WEST_BLOCK_RANGED);
                    this.unflag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_AND_EAST_BLOCK_RANGED);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_RANGED);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_SOUTH_AND_EAST_BLOCK_RANGED);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_RANGED);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_AND_WEST_BLOCK_RANGED);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_RANGED);
                    this.unflag(x1 - 1, z1, WALL_EAST_BLOCK_RANGED);
                }
            }
        }

        if (blockRoute) {
            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_WEST_BLOCK_ROUTE);
                    this.unflag(x1 - 1, z1, WALL_EAST_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_BLOCK_ROUTE);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_EAST_BLOCK_ROUTE);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_BLOCK_ROUTE);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                }
            }
            if (shape == LocShapes.WALL_DIAGONALCORNER || shape == LocShapes.WALL_SQUARECORNER) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_NORTH_WEST_BLOCK_ROUTE);
                    this.unflag(x1 - 1, z1 + 1, WALL_SOUTH_EAST_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_EAST_BLOCK_ROUTE);
                    this.unflag(x1 + 1, z1 + 1, WALL_SOUTH_WEST_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_SOUTH_EAST_BLOCK_ROUTE);
                    this.unflag(x1 + 1, z1 - 1, WALL_NORTH_WEST_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_WEST_BLOCK_ROUTE);
                    this.unflag(x1 - 1, z1 - 1, WALL_NORTH_EAST_BLOCK_ROUTE);
                }
            }
            if (shape == 2) {
                if (rotation == 0) {
                    this.unflag(x1, z1, WALL_NORTH_AND_WEST_BLOCK_ROUTE);
                    this.unflag(x1 - 1, z1, WALL_NORTH_EAST_BLOCK_ROUTE);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                }
                if (rotation == 1) {
                    this.unflag(x1, z1, WALL_NORTH_AND_EAST_BLOCK_ROUTE);
                    this.unflag(x1, z1 + 1, WALL_SOUTH_BLOCK_ROUTE);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                }
                if (rotation == 2) {
                    this.unflag(x1, z1, WALL_SOUTH_AND_EAST_BLOCK_ROUTE);
                    this.unflag(x1 + 1, z1, WALL_WEST_BLOCK_ROUTE);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                }
                if (rotation == 3) {
                    this.unflag(x1, z1, WALL_SOUTH_AND_WEST_BLOCK_ROUTE);
                    this.unflag(x1, z1 - 1, WALL_NORTH_BLOCK_ROUTE);
                    this.unflag(x1 - 1, z1, WALL_EAST_BLOCK_ROUTE);
                }
            }
        }
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIIIIIIII)Z")
    public boolean isInsideOrOutsideRect(@OriginalArg(4) int x1, @OriginalArg(8) int z1, @OriginalArg(5) int size, @OriginalArg(3) int destX1, @OriginalArg(0) int destZ1, @OriginalArg(7) int destWidth, @OriginalArg(6) int destHeight, @OriginalArg(2) int direction) {
        if (size > 1) {
            if (isInsideRect(destX1, size, x1, destWidth, destHeight, z1, destZ1, size)) {
                return true;
            } else {
                return this.isOutsideRect(x1, z1, size, size, destX1, destZ1, destWidth, destHeight, direction);
            }
        }

        @Pc(53) int destX2 = destX1 + destWidth - 1;
        @Pc(59) int destZ2 = destZ1 + destHeight - 1;

        if (x1 >= destX1 && x1 <= destX2 && z1 >= destZ1 && z1 <= destZ2) {
            return true;
        } else if (x1 == destX1 - 1 && z1 >= destZ1 && z1 <= destZ2 && (this.flags[x1 - this.x][z1 - this.z] & WALL_EAST) == 0 && (direction & DIRECTION_WEST) == 0) {
            return true;
        } else if (x1 == destX2 + 1 && z1 >= destZ1 && z1 <= destZ2 && (this.flags[x1 - this.x][z1 - this.z] & WALL_WEST) == 0 && (direction & DIRECTION_EAST) == 0) {
            return true;
        } else if (z1 == destZ1 - 1 && x1 >= destX1 && x1 <= destX2 && (this.flags[x1 - this.x][z1 - this.z] & WALL_NORTH) == 0 && (direction & DIRECTION_SOUTH) == 0) {
            return true;
        } else if (z1 == destZ2 + 1 && x1 >= destX1 && x1 <= destX2 && (this.flags[x1 - this.x][z1 - this.z] & WALL_SOUTH) == 0 && (direction & DIRECTION_NORTH) == 0) {
            return true;
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIIIIIII)Z")
    public boolean isAtWall(@OriginalArg(4) int x, @OriginalArg(2) int destZ, @OriginalArg(0) int size, @OriginalArg(5) int destX, @OriginalArg(3) int z, @OriginalArg(1) int shape, @OriginalArg(6) int rotation) {
        if (size == 1) {
            if (x == destX && z == destZ) {
                return true;
            }
        } else if (x <= destX && x + size - 1 >= destX && destZ <= destZ && destZ <= destZ + size - 1) {
            return true;
        }

        @Pc(68) int x1 = x - this.x;
        @Pc(73) int destZ1 = destZ - this.z;
        @Pc(78) int destX1 = destX - this.x;
        @Pc(83) int z1 = z - this.z;

        if (size == 1) {
            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    if (x1 == destX1 - 1 && z1 == destZ1) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 == destX1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 + 1 && z1 == destZ1) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 == destX1 && z1 == destZ1 - 1) {
                        return true;
                    }
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                }
            }
            if (shape == LocShapes.WALL_L) {
                if (rotation == 0) {
                    if (x1 == destX1 - 1 && z1 == destZ1) {
                        return true;
                    }
                    if (destX1 == x1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 == destX1 - 1 && z1 == destZ1) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 && z1 == destZ1 - 1) {
                        return true;
                    }
                }
            }
            if (shape == LocShapes.WALL_DIAGONAL) {
                if (x1 == destX1 && z1 == destZ1 + 1 && (this.flags[x1][z1] & WALL_SOUTH) == 0) {
                    return true;
                }
                if (x1 == destX1 && z1 == destZ1 - 1 && (this.flags[x1][z1] & WALL_NORTH) == 0) {
                    return true;
                }
                if (x1 == destX1 - 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_EAST) == 0) {
                    return true;
                }
                if (x1 == destX1 + 1 && z1 == destZ1 && (this.flags[x1][z1] & WALL_WEST) == 0) {
                    return true;
                }
            }
        } else {
            @Pc(100) int x2 = x1 + size - 1;
            @Pc(106) int z2 = z1 + size - 1;

            if (shape == LocShapes.WALL_STRAIGHT) {
                if (rotation == 0) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size) {
                        return true;
                    }
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                }
            }
            if (shape == LocShapes.WALL_L) {
                if (rotation == 0) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 1) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & (WALL | WALL_NORTH)) == 0) {
                        return true;
                    }
                } else if (rotation == 2) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & (WALL | WALL_EAST)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size) {
                        return true;
                    }
                } else if (rotation == 3) {
                    if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & (WALL | WALL_SOUTH)) == 0) {
                        return true;
                    }
                    if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & (WALL | WALL_WEST)) == 0) {
                        return true;
                    }
                    if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size) {
                        return true;
                    }
                }
            }
            if (shape == LocShapes.WALL_DIAGONAL) {
                if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 + 1 && (this.flags[destX1][z1] & (WALL | WALL_SOUTH)) == 0) {
                    return true;
                }
                if (x1 <= destX1 && x2 >= destX1 && z1 == destZ1 - size && (this.flags[destX1][z2] & (WALL | WALL_NORTH)) == 0) {
                    return true;
                }
                if (x1 == destX1 - size && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x2][destZ1] & (WALL | WALL_EAST)) == 0) {
                    return true;
                }
                if (x1 == destX1 + 1 && z1 <= destZ1 && z2 >= destZ1 && (this.flags[x1][destZ1] & (WALL | WALL_WEST)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(III)V")
    public void flagBlocked(@OriginalArg(0) int z, @OriginalArg(1) int x) {
        @Pc(15) int x1 = x - this.x;
        @Pc(20) int z1 = z - this.z;
        this.flags[x1][z1] |= BLOCK_WALK;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(I)V")
    public void reset() {
        for (@Pc(5) int x = 0; x < this.width; x++) {
            for (@Pc(8) int z = 0; z < this.height; z++) {
                if (x != 0 && z != 0 && x < this.width - 5 && z < this.height - 5) {
                    this.flags[x][z] = BLOCK_WALK;
                } else {
                    this.flags[x][z] = -1;
                }
            }
        }
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(ZZBIIIII)V")
    public void unflagLoc(@OriginalArg(3) int x, @OriginalArg(7) int z, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int rotation, @OriginalArg(0) boolean blockRanged, @OriginalArg(1) boolean blockRoute) {
        @Pc(7) int flags = LOCATION;
        if (blockRanged) {
            flags |= LOCATION_BLOCK_RANGED;
        }
        if (blockRoute) {
            flags |= LOCATION_BLOCK_ROUTE;
        }

        @Pc(18) int z1 = z - this.z;
        @Pc(23) int x1 = x - this.x;
        if (rotation == 1 || rotation == 3) {
            @Pc(35) int temp = width;
            width = height;
            height = temp;
        }

        for (@Pc(35) int currX = x1; currX < width + x1; currX++) {
            if (currX >= 0 && currX < this.width) {
                for (@Pc(69) int currZ = z1; currZ < z1 + height; currZ++) {
                    if (currZ >= 0 && currZ < this.height) {
                        this.unflag(currX, currZ, flags);
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!eq", name = "c", descriptor = "(III)V")
    public void unflagBlocked(@OriginalArg(1) int x, @OriginalArg(0) int z) {
        @Pc(11) int z1 = z - this.z;
        @Pc(20) int x1 = x - this.x;
        this.flags[x1][z1] &= ~BLOCK_WALK;
    }

    @OriginalMember(owner = "client!eq", name = "b", descriptor = "(III)V")
    public void flagGroundDecor(@OriginalArg(1) int x, @OriginalArg(0) int z) {
        @Pc(8) int x1 = x - this.x;
        @Pc(13) int z1 = z - this.z;
        this.flags[x1][z1] |= GROUND_DECOR;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIII)V")
    public void flag(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(2) int flags) {
        this.flags[x][z] |= flags;
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IIIIZIZ)V")
    public void flagLoc(@OriginalArg(0) int x, @OriginalArg(3) int z, @OriginalArg(5) int width, @OriginalArg(1) int height, @OriginalArg(6) boolean blockRanged, @OriginalArg(4) boolean blockRoute) {
        @Pc(5) int flags = LOCATION;
        if (blockRanged) {
            flags |= LOCATION_BLOCK_RANGED;
        }
        if (blockRoute) {
            flags |= LOCATION_BLOCK_ROUTE;
        }

        @Pc(22) int z1 = z - this.z;
        @Pc(32) int x1 = x - this.x;
        for (@Pc(34) int currX = x1; currX < x1 + width; currX++) {
            if (currX >= 0 && currX < this.width) {
                for (@Pc(52) int currZ = z1; currZ < z1 + height; currZ++) {
                    if (currZ >= 0 && currZ < this.height) {
                        this.flag(currX, currZ, flags);
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "(IZI)V")
    public void unflagGroundDecor(@OriginalArg(2) int x, @OriginalArg(0) int z) {
        @Pc(20) int z1 = z - this.z;
        @Pc(25) int x1 = x - this.x;
        this.flags[x1][z1] &= ~GROUND_DECOR;
    }
}
