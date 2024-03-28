package com.jagex.game;

import com.jagex.core.constants.LocShapes;
import com.jagex.core.constants.PathDestination;
import com.jagex.game.collision.CollisionMap;
import com.jagex.game.collision.DirectionFlag;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class PathFinder {

    private static final int GRID_SIZE = 128;

    private static final int GRID_CENTER = GRID_SIZE >> 1;

    private static final int COST_START = 0;

    private static final int COST_INFINITY = 99999999;

    private static final int PARENT_NULL = 0;

    private static final int PARENT_START = 99;

    private static final int QUEUE_SIZE = 4096;

    private static final int MASK_QUEUE_SIZE = QUEUE_SIZE - 1;

    private static final int APPROXIMATE_RADIUS = 10;

    private static final int APPROXIMATE_MAX_COST = 100;

    @OriginalMember(owner = "client!lc", name = "u", descriptor = "[[I")
    private static final int[][] parent = new int[GRID_SIZE][GRID_SIZE];

    @OriginalMember(owner = "client!vca", name = "x", descriptor = "[[I")
    private static final int[][] cost = new int[GRID_SIZE][GRID_SIZE];

    @OriginalMember(owner = "client!pw", name = "q", descriptor = "[I")
    private static final int[] queueX = new int[QUEUE_SIZE];

    @OriginalMember(owner = "client!nia", name = "e", descriptor = "[I")
    private static final int[] queueZ = new int[QUEUE_SIZE];

    @OriginalMember(owner = "client!sn", name = "f", descriptor = "I")
    private static int pathEndX;

    @OriginalMember(owner = "client!mr", name = "d", descriptor = "I")
    private static int pathEndZ;

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(IIZIII[IBIIILclient!eq;[III)I")
    public static int findPath(@OriginalArg(11) CollisionMap map, @OriginalArg(6) int[] pathX, @OriginalArg(12) int[] pathZ, @OriginalArg(4) int startX, @OriginalArg(9) int startZ, @OriginalArg(1) int size, @OriginalArg(13) int destX, @OriginalArg(0) int destZ, @OriginalArg(8) int destWidth, @OriginalArg(5) int destLength, @OriginalArg(10) int destination, @OriginalArg(14) int rotation, @OriginalArg(3) int direction, @OriginalArg(2) boolean approximate) {
        for (@Pc(5) int x = 0; x < GRID_SIZE; x++) {
            for (@Pc(8) int z = 0; z < GRID_SIZE; z++) {
                parent[x][z] = PARENT_NULL;
                cost[x][z] = COST_INFINITY;
            }
        }

        @Pc(51) boolean found;
        if (size == 1) {
            found = findPath1(map, startX, startZ, destX, destZ, destWidth, destLength, destination, rotation, direction);
        } else if (size == 2) {
            found = findPath2(map, startX, startZ, destX, destZ, destWidth, destLength, destination, rotation, direction);
        } else {
            found = findPathN(map, startX, startZ, size, destX, destZ, destWidth, destLength, destination, rotation, direction);
        }

        @Pc(87) int offsetX = startX - GRID_CENTER;
        @Pc(91) int offsetZ = startZ - GRID_CENTER;

        @Pc(93) int endX = pathEndX;
        @Pc(95) int endZ = pathEndZ;

        if (!found) {
            if (!approximate) {
                return -1;
            }

            @Pc(106) int bestDistance = Integer.MAX_VALUE;
            @Pc(108) int bestCost = Integer.MAX_VALUE;

            for (@Pc(114) int x = destX - APPROXIMATE_RADIUS; x <= destX + APPROXIMATE_RADIUS; x++) {
                for (@Pc(120) int z = destZ - APPROXIMATE_RADIUS; z <= destZ + APPROXIMATE_RADIUS; z++) {
                    @Pc(126) int curX = x - offsetX;
                    @Pc(131) int curZ = z - offsetZ;

                    if (curX >= 0 && curZ >= 0 && curX < GRID_SIZE && curZ < GRID_SIZE && cost[curX][curZ] < APPROXIMATE_MAX_COST) {
                        @Pc(163) int deltaX = 0;
                        if (x < destX) {
                            deltaX = destX - x;
                        } else if (x > destX + destWidth - 1) {
                            deltaX = x + 1 - destX - destWidth;
                        }

                        @Pc(198) int deltaZ = 0;
                        if (z < destZ) {
                            deltaZ = destZ - z;
                        } else if (z > destZ + destLength - 1) {
                            deltaZ = z + 1 - destZ - destLength;
                        }

                        @Pc(235) int distance = (deltaX * deltaX) + (deltaZ * deltaZ);
                        if ((distance < bestDistance) || (distance == bestDistance && bestCost > cost[curX][curZ])) {
                            endZ = z;
                            endX = x;
                            bestDistance = distance;
                            bestCost = cost[curX][curZ];
                        }
                    }
                }
            }

            if (bestDistance == Integer.MAX_VALUE) {
                return -1;
            }
        }

        if (startX == endX && startZ == endZ) {
            return 0;
        }

        @Pc(106) int pathLength = 0;
        @Pc(340) int lastDirection;
        @Pc(108) int currentDirection = lastDirection = parent[endX - offsetX][endZ - offsetZ];

        queueX[pathLength] = endX;
        queueZ[pathLength++] = endZ;

        while (endX != startX || startZ != endZ) {
            if (currentDirection != lastDirection) {
                lastDirection = currentDirection;
                queueX[pathLength] = endX;
                queueZ[pathLength++] = endZ;
            }

            if ((currentDirection & DirectionFlag.EAST) != 0) {
                endX++;
            } else if ((currentDirection & DirectionFlag.WEST) != 0) {
                endX--;
            }

            if ((currentDirection & DirectionFlag.NORTH) != 0) {
                endZ++;
            } else if ((currentDirection & DirectionFlag.SOUTH) != 0) {
                endZ--;
            }

            currentDirection = parent[endX - offsetX][endZ - offsetZ];
        }

        @Pc(114) int pointer = 0;
        while (pathLength-- > 0) {
            pathZ[pointer] = queueX[pathLength];
            pathX[pointer++] = queueZ[pathLength];

            if (pointer >= pathZ.length) {
                break;
            }
        }

        return pointer;
    }

    @OriginalMember(owner = "client!fq", name = "a", descriptor = "(IIILclient!eq;IIIIIII)Z")
    public static boolean findPath1(@OriginalArg(3) CollisionMap map, @OriginalArg(4) int startX, @OriginalArg(6) int startZ, @OriginalArg(7) int destX, @OriginalArg(8) int destZ, @OriginalArg(0) int destWidth, @OriginalArg(1) int destLength, @OriginalArg(2) int destination, @OriginalArg(9) int rotation, @OriginalArg(10) int direction) {
        @Pc(5) int x = startX;
        @Pc(7) int z = startZ;
        @Pc(16) int offsetX = startX - GRID_CENTER;
        @Pc(33) int offsetZ = startZ - GRID_CENTER;
        @Pc(41) byte local41 = 0;
        @Pc(43) int queueReadPointer = 0;
        @Pc(50) int queueWritePointer = local41 + 1;

        parent[64][64] = PARENT_START;
        cost[64][64] = COST_START;

        queueX[0] = startX;
        queueZ[0] = startZ;

        @Pc(55) int[][] flags = map.flags;
        while (queueReadPointer != queueWritePointer) {
            z = queueZ[queueReadPointer];
            x = queueX[queueReadPointer];

            @Pc(70) int mapZ = z - map.z;
            @Pc(76) int mapX = x - map.x;

            queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;

            @Pc(86) int curZ = z - offsetZ;
            @Pc(91) int curX = x - offsetX;

            if (destination == PathDestination.ON) {
                if (destX == x && z == destZ) {
                    pathEndX = x;
                    pathEndZ = z;
                    return true;
                }
            } else if (destination == PathDestination.INSIDE) {
                if (CollisionMap.isInsideRect(x, z, 1, 1, destX, destZ, destWidth, destLength)) {
                    pathEndX = x;
                    pathEndZ = z;
                    return true;
                }
            } else if (destination == PathDestination.OUTSIDE) {
                if (map.isOutsideRect(x, z, 1, 1, destX, destZ, destWidth, destLength, direction)) {
                    pathEndZ = z;
                    pathEndX = x;
                    return true;
                }
            } else if (destination == PathDestination.INSIDE_OR_OUTSIDE) {
                if (map.isInsideOrOutsideRect(x, z, 1, destX, destZ, destWidth, destLength, direction)) {
                    pathEndZ = z;
                    pathEndX = x;
                    return true;
                }
            } else if (destination == LocShapes.WALL_STRAIGHT || destination == LocShapes.WALL_DIAGONALCORNER || destination == LocShapes.WALL_L || destination == LocShapes.WALL_SQUARECORNER || destination == LocShapes.WALL_DIAGONAL) {
                if (map.isAtWall(x, destZ, 1, destX, z, destination, rotation)) {
                    pathEndX = x;
                    pathEndZ = z;
                    return true;
                }
            } else if (map.isAtDiagonalWallDecor(x, z, 1, destX, destZ, destination, rotation)) {
                pathEndZ = z;
                pathEndX = x;
                return true;
            }

            @Pc(273) int adjacentCost = cost[curX][curZ] + 1;

            if (curX > 0 && parent[curX - 1][curZ] == 0 && (flags[mapX - 1][mapZ] & 0x42240000) == 0) {
                queueX[queueWritePointer] = x - 1;
                queueZ[queueWritePointer] = z;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                parent[curX - 1][curZ] = 2;
                cost[curX - 1][curZ] = adjacentCost;
            }

            if (curX < GRID_SIZE - 1 && parent[curX + 1][curZ] == 0 && (flags[mapX + 1][mapZ] & 0x60240000) == 0) {
                queueX[queueWritePointer] = x + 1;
                queueZ[queueWritePointer] = z;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                parent[curX + 1][curZ] = 8;
                cost[curX + 1][curZ] = adjacentCost;
            }

            if (curZ > 0 && parent[curX][curZ - 1] == 0 && (flags[mapX][mapZ - 1] & 0x40A40000) == 0) {
                queueX[queueWritePointer] = x;
                queueZ[queueWritePointer] = z - 1;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                parent[curX][curZ - 1] = 1;
                cost[curX][curZ - 1] = adjacentCost;
            }

            if (curZ < GRID_SIZE - 1 && parent[curX][curZ + 1] == 0 && (flags[mapX][mapZ + 1] & 0x48240000) == 0) {
                queueX[queueWritePointer] = x;
                queueZ[queueWritePointer] = z + 1;
                parent[curX][curZ + 1] = 4;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                cost[curX][curZ + 1] = adjacentCost;
            }

            if (curX > 0 && curZ > 0 && parent[curX - 1][curZ - 1] == 0 && (flags[mapX - 1][mapZ - 1] & 0x43A40000) == 0 && (flags[mapX - 1][mapZ] & 0x42240000) == 0 && (flags[mapX][mapZ - 1] & 0x40A40000) == 0) {
                queueX[queueWritePointer] = x - 1;
                queueZ[queueWritePointer] = z - 1;
                parent[curX - 1][curZ - 1] = 3;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                cost[curX - 1][curZ - 1] = adjacentCost;
            }

            if (curX < GRID_SIZE - 1 && curZ > 0 && parent[curX + 1][curZ - 1] == 0 && (flags[mapX + 1][mapZ - 1] & 0x60E40000) == 0 && (flags[mapX + 1][mapZ] & 0x60240000) == 0 && (flags[mapX][mapZ - 1] & 0x40A40000) == 0) {
                queueX[queueWritePointer] = x + 1;
                queueZ[queueWritePointer] = z - 1;
                parent[curX + 1][curZ - 1] = 9;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                cost[curX + 1][curZ - 1] = adjacentCost;
            }

            if (curX > 0 && curZ < GRID_SIZE - 1 && parent[curX - 1][curZ + 1] == 0 && (flags[mapX - 1][mapZ + 1] & 0x4E240000) == 0 && (flags[mapX - 1][mapZ] & 0x42240000) == 0 && (flags[mapX][mapZ + 1] & 0x48240000) == 0) {
                queueX[queueWritePointer] = x - 1;
                queueZ[queueWritePointer] = z + 1;
                parent[curX - 1][curZ + 1] = 6;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                cost[curX - 1][curZ + 1] = adjacentCost;
            }

            if (curX < GRID_SIZE - 1 && curZ < GRID_SIZE - 1 && parent[curX + 1][curZ + 1] == 0 && (flags[mapX + 1][mapZ + 1] & 0x78240000) == 0 && (flags[mapX + 1][mapZ] & 0x60240000) == 0 && (flags[mapX][mapZ + 1] & 0x48240000) == 0) {
                queueX[queueWritePointer] = x + 1;
                queueZ[queueWritePointer] = z + 1;
                parent[curX + 1][curZ + 1] = 12;
                queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;
                cost[curX + 1][curZ + 1] = adjacentCost;
            }
        }

        pathEndZ = z;
        pathEndX = x;
        return false;
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(IIIIIIIIZILclient!eq;)Z")
    public static boolean findPath2(@OriginalArg(10) CollisionMap map, @OriginalArg(1) int startX, @OriginalArg(9) int startZ, @OriginalArg(3) int destX, @OriginalArg(7) int destZ, @OriginalArg(6) int destWidth, @OriginalArg(2) int destLength, @OriginalArg(5) int destination, @OriginalArg(4) int rotation, @OriginalArg(0) int direction) {
        @Pc(5) int x = startX;
        @Pc(7) int z = startZ;
        @Pc(16) int offsetX = startX - GRID_CENTER;
        @Pc(21) int offsetZ = startZ - GRID_CENTER;
        @Pc(35) byte local35 = 0;
        @Pc(41) int queueWritePointer = 0;
        @Pc(52) int queueReadPointer = local35 + 1;
        @Pc(57) int[][] flags = map.flags;

        parent[64][64] = PARENT_START;
        cost[64][64] = COST_START;

        queueX[0] = startX;
        queueZ[0] = startZ;

        while (queueReadPointer != queueWritePointer) {
            z = queueZ[queueWritePointer];
            x = queueX[queueWritePointer];

            @Pc(70) int curZ = z - offsetZ;
            @Pc(75) int curX = x - offsetX;

            queueWritePointer = queueWritePointer + 1 & MASK_QUEUE_SIZE;

            @Pc(87) int mapX = x - map.x;
            @Pc(93) int mapZ = z - map.z;

            if (destination == PathDestination.ON) {
                if (x == destX && z == destZ) {
                    pathEndX = x;
                    pathEndZ = z;
                    return true;
                }
            } else if (destination == PathDestination.INSIDE) {
                if (CollisionMap.isInsideRect(x, z, 2, 2, destX, destZ, destWidth, destLength)) {
                    pathEndZ = z;
                    pathEndX = x;
                    return true;
                }
            } else if (destination == PathDestination.OUTSIDE) {
                if (map.isOutsideRect(x, z, 2, 2, destX, destZ, destWidth, destLength, direction)) {
                    pathEndZ = z;
                    pathEndX = x;
                    return true;
                }
            } else if (destination == PathDestination.INSIDE_OR_OUTSIDE) {
                if (map.isInsideOrOutsideRect(x, z, 2, destX, destZ, destWidth, destLength, direction)) {
                    pathEndZ = z;
                    pathEndX = x;
                    return true;
                }
            } else if (destination == LocShapes.WALL_STRAIGHT || destination == LocShapes.WALL_DIAGONALCORNER || destination == LocShapes.WALL_L || destination == LocShapes.WALL_SQUARECORNER || destination == LocShapes.WALL_DIAGONAL) {
                if (map.isAtWall(x, destZ, 2, destX, z, destination, rotation)) {
                    pathEndX = x;
                    pathEndZ = z;
                    return true;
                }
            } else if (map.isAtDiagonalWallDecor(x, z, 2, destX, destZ, destination, rotation)) {
                pathEndZ = z;
                pathEndX = x;
                return true;
            }

            @Pc(270) int adjacentCost = cost[curX][curZ] + 1;

            if (curX > 0 && parent[curX - 1][curZ] == 0 && (flags[mapX - 1][mapZ] & 0x43A40000) == 0 && (flags[mapX - 1][mapZ + 1] & 0x4E240000) == 0) {
                queueX[queueReadPointer] = x - 1;
                queueZ[queueReadPointer] = z;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                parent[curX - 1][curZ] = 2;
                cost[curX - 1][curZ] = adjacentCost;
            }

            if (curX < GRID_SIZE - 2 && parent[curX + 1][curZ] == 0 && (flags[mapX + 2][mapZ] & 0x60E40000) == 0 && (flags[mapX + 2][mapZ + 1] & 0x78240000) == 0) {
                queueX[queueReadPointer] = x + 1;
                queueZ[queueReadPointer] = z;
                parent[curX + 1][curZ] = 8;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                cost[curX + 1][curZ] = adjacentCost;
            }

            if (curZ > 0 && parent[curX][curZ - 1] == 0 && (flags[mapX][mapZ - 1] & 0x43A40000) == 0 && (flags[mapX + 1][mapZ - 1] & 0x60E40000) == 0) {
                queueX[queueReadPointer] = x;
                queueZ[queueReadPointer] = z - 1;
                parent[curX][curZ - 1] = 1;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                cost[curX][curZ - 1] = adjacentCost;
            }

            if (curZ < GRID_SIZE - 2 && parent[curX][curZ + 1] == 0 && (flags[mapX][mapZ + 2] & 0x4E240000) == 0 && (flags[mapX + 1][mapZ + 2] & 0x78240000) == 0) {
                queueX[queueReadPointer] = x;
                queueZ[queueReadPointer] = z + 1;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                parent[curX][curZ + 1] = 4;
                cost[curX][curZ + 1] = adjacentCost;
            }

            if (curX > 0 && curZ > 0 && parent[curX - 1][curZ - 1] == 0 && (flags[mapX - 1][mapZ] & 0x4FA40000) == 0 && (flags[mapX - 1][mapZ - 1] & 0x43A40000) == 0 && (flags[mapX][mapZ - 1] & 0x63E40000) == 0) {
                queueX[queueReadPointer] = x - 1;
                queueZ[queueReadPointer] = z - 1;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                parent[curX - 1][curZ - 1] = 3;
                cost[curX - 1][curZ - 1] = adjacentCost;
            }

            if (curX < GRID_SIZE - 2 && curZ > 0 && parent[curX + 1][curZ - 1] == 0 && (flags[mapX + 1][mapZ - 1] & 0x63E40000) == 0 && (flags[mapX + 2][mapZ - 1] & 0x60E40000) == 0 && (flags[mapX + 2][mapZ] & 0x78E40000) == 0) {
                queueX[queueReadPointer] = x + 1;
                queueZ[queueReadPointer] = z - 1;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                parent[curX + 1][curZ - 1] = 9;
                cost[curX + 1][curZ - 1] = adjacentCost;
            }

            if (curX > 0 && curZ < GRID_SIZE - 2 && parent[curX - 1][curZ + 1] == 0 && (flags[mapX - 1][mapZ + 1] & 0x4FA40000) == 0 && (flags[mapX - 1][mapZ + 2] & 0x4E240000) == 0 && (flags[mapX][mapZ + 2] & 0x7E240000) == 0) {
                queueX[queueReadPointer] = x - 1;
                queueZ[queueReadPointer] = z + 1;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                parent[curX - 1][curZ + 1] = 6;
                cost[curX - 1][curZ + 1] = adjacentCost;
            }

            if (curX < GRID_SIZE - 2 && curZ < GRID_SIZE - 2 && parent[curX + 1][curZ + 1] == 0 && (flags[mapX + 1][mapZ + 2] & 0x7E240000) == 0 && (flags[mapX + 2][mapZ + 2] & 0x78240000) == 0 && (flags[mapX + 2][mapZ + 1] & 0x78E40000) == 0) {
                queueX[queueReadPointer] = x + 1;
                queueZ[queueReadPointer] = z + 1;
                parent[curX + 1][curZ + 1] = 12;
                queueReadPointer = queueReadPointer + 1 & MASK_QUEUE_SIZE;
                cost[curX + 1][curZ + 1] = adjacentCost;
            }
        }

        pathEndZ = z;
        pathEndX = x;
        return false;
    }

    @OriginalMember(owner = "client!nla", name = "a", descriptor = "(ILclient!eq;IIIIIIIIII)Z")
    public static boolean findPathN(@OriginalArg(1) CollisionMap arg1, @OriginalArg(2) int startX, @OriginalArg(5) int startZ, @OriginalArg(9) int size, @OriginalArg(7) int destX, @OriginalArg(8) int destZ, @OriginalArg(3) int destWidth, @OriginalArg(11) int destLength, @OriginalArg(4) int destination, @OriginalArg(0) int rotation, @OriginalArg(6) int direction) {
        @Pc(5) int local5 = startX;
        @Pc(7) int local7 = startZ;
        @Pc(16) int local16 = startX - GRID_CENTER;
        parent[64][64] = 99;
        @Pc(27) int local27 = startZ - GRID_CENTER;
        cost[64][64] = 0;
        @Pc(35) byte local35 = 0;
        queueX[0] = startX;
        @Pc(41) int local41 = 0;
        @Pc(44) int local44 = local35 + 1;
        queueZ[0] = startZ;
        @Pc(49) int[][] local49 = arg1.flags;
        while (true) {
            label282:
            while (true) {
                @Pc(74) int local74;
                @Pc(69) int local69;
                @Pc(79) int local79;
                @Pc(85) int local85;
                @Pc(264) int local264;
                @Pc(318) int local318;
                do {
                    do {
                        do {
                            label259:
                            do {
                                if (local44 == local41) {
                                    pathEndZ = local7;
                                    pathEndX = local5;
                                    return false;
                                }
                                local7 = queueZ[local41];
                                local5 = queueX[local41];
                                local41 = local41 + 1 & MASK_QUEUE_SIZE;
                                local69 = local7 - local27;
                                local74 = local5 - local16;
                                local79 = local5 - arg1.x;
                                local85 = local7 - arg1.z;
                                if (destination == PathDestination.ON) {
                                    if (local5 == destX && destZ == local7) {
                                        pathEndZ = local7;
                                        pathEndX = local5;
                                        return true;
                                    }
                                } else if (destination == PathDestination.INSIDE) {
                                    if (CollisionMap.isInsideRect(local5, local7, size, size, destX, destZ, destWidth, destLength)) {
                                        pathEndZ = local7;
                                        pathEndX = local5;
                                        return true;
                                    }
                                } else if (destination == PathDestination.OUTSIDE) {
                                    if (arg1.isOutsideRect(local5, local7, size, size, destX, destZ, destWidth, destLength, direction)) {
                                        pathEndZ = local7;
                                        pathEndX = local5;
                                        return true;
                                    }
                                } else if (destination == PathDestination.INSIDE_OR_OUTSIDE) {
                                    if (arg1.isInsideOrOutsideRect(local5, local7, size, destX, destZ, destWidth, destLength, direction)) {
                                        pathEndZ = local7;
                                        pathEndX = local5;
                                        return true;
                                    }
                                } else if (destination == LocShapes.WALL_STRAIGHT || destination == LocShapes.WALL_DIAGONALCORNER || destination == LocShapes.WALL_L || destination == LocShapes.WALL_SQUARECORNER || destination == LocShapes.WALL_DIAGONAL) {
                                    if (arg1.isAtWall(local5, destZ, size, destX, local7, destination, rotation)) {
                                        pathEndZ = local7;
                                        pathEndX = local5;
                                        return true;
                                    }
                                } else if (arg1.isAtDiagonalWallDecor(local5, local7, size, destX, destZ, destination, rotation)) {
                                    pathEndZ = local7;
                                    pathEndX = local5;
                                    return true;
                                }
                                local264 = cost[local74][local69] + 1;
                                if (local74 > 0 && parent[local74 - 1][local69] == 0 && (local49[local79 - 1][local85] & 0x43A40000) == 0 && (local49[local79 - 1][size + local85 - 1] & 0x4E240000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (local318 >= size - 1) {
                                            queueX[local44] = local5 - 1;
                                            queueZ[local44] = local7;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            parent[local74 - 1][local69] = 2;
                                            cost[local74 - 1][local69] = local264;
                                            break;
                                        }
                                        if ((local49[local79 - 1][local85 + local318] & 0x4FA40000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (GRID_SIZE - size > local74 && parent[local74 + 1][local69] == 0 && (local49[local79 + size][local85] & 0x60E40000) == 0 && (local49[local79 + size][local85 + size - 1] & 0x78240000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (size - 1 <= local318) {
                                            queueX[local44] = local5 + 1;
                                            queueZ[local44] = local7;
                                            parent[local74 + 1][local69] = 8;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            cost[local74 + 1][local69] = local264;
                                            break;
                                        }
                                        if ((local49[size + local79][local318 + local85] & 0x78E40000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (local69 > 0 && parent[local74][local69 - 1] == 0 && (local49[local79][local85 - 1] & 0x43A40000) == 0 && (local49[local79 + size - 1][local85 - 1] & 0x60E40000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (size - 1 <= local318) {
                                            queueX[local44] = local5;
                                            queueZ[local44] = local7 - 1;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            parent[local74][local69 - 1] = 1;
                                            cost[local74][local69 - 1] = local264;
                                            break;
                                        }
                                        if ((local49[local318 + local79][local85 - 1] & 0x63E40000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (GRID_SIZE - size > local69 && parent[local74][local69 + 1] == 0 && (local49[local79][local85 + size] & 0x4E240000) == 0 && (local49[local79 + size - 1][size + local85] & 0x78240000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (size - 1 <= local318) {
                                            queueX[local44] = local5;
                                            queueZ[local44] = local7 + 1;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            parent[local74][local69 + 1] = 4;
                                            cost[local74][local69 + 1] = local264;
                                            break;
                                        }
                                        if ((local49[local318 + local79][size + local85] & 0x7E240000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (local74 > 0 && local69 > 0 && parent[local74 - 1][local69 - 1] == 0 && (local49[local79 - 1][local85 - 1] & 0x43A40000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (local318 >= size) {
                                            queueX[local44] = local5 - 1;
                                            queueZ[local44] = local7 - 1;
                                            parent[local74 - 1][local69 - 1] = 3;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            cost[local74 - 1][local69 - 1] = local264;
                                            break;
                                        }
                                        if ((local49[local79 - 1][local318 + local85 - 1] & 0x4FA40000) != 0 || (local49[local79 + local318 - 1][local85 - 1] & 0x63E40000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (GRID_SIZE - size > local74 && local69 > 0 && parent[local74 + 1][local69 - 1] == 0 && (local49[local79 + size][local85 - 1] & 0x60E40000) == 0) {
                                    local318 = 1;
                                    while (true) {
                                        if (local318 >= size) {
                                            queueX[local44] = local5 + 1;
                                            queueZ[local44] = local7 - 1;
                                            parent[local74 + 1][local69 - 1] = 9;
                                            local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                            cost[local74 + 1][local69 - 1] = local264;
                                            break;
                                        }
                                        if ((local49[local79 + size][local318 + local85 - 1] & 0x78E40000) != 0 || (local49[local318 + local79][local85 - 1] & 0x63E40000) != 0) {
                                            break;
                                        }
                                        local318++;
                                    }
                                }
                                if (local74 > 0 && local69 < GRID_SIZE - size && parent[local74 - 1][local69 + 1] == 0 && (local49[local79 - 1][size + local85] & 0x4E240000) == 0) {
                                    for (local318 = 1; local318 < size; local318++) {
                                        if ((local49[local79 - 1][local85 + local318] & 0x4FA40000) != 0 || (local49[local318 + local79 - 1][size + local85] & 0x7E240000) != 0) {
                                            continue label259;
                                        }
                                    }
                                    queueX[local44] = local5 - 1;
                                    queueZ[local44] = local7 + 1;
                                    parent[local74 - 1][local69 + 1] = 6;
                                    local44 = local44 + 1 & MASK_QUEUE_SIZE;
                                    cost[local74 - 1][local69 + 1] = local264;
                                }
                            } while (local74 >= GRID_SIZE - size);
                        } while (local69 >= GRID_SIZE - size);
                    } while (parent[local74 + 1][local69 + 1] != 0);
                } while ((local49[size + local79][size + local85] & 0x78240000) != 0);
                for (local318 = 1; local318 < size; local318++) {
                    if ((local49[local318 + local79][local85 + size] & 0x7E240000) != 0 || (local49[local79 + size][local85 + local318] & 0x78E40000) != 0) {
                        continue label282;
                    }
                }
                queueX[local44] = local5 + 1;
                queueZ[local44] = local7 + 1;
                parent[local74 + 1][local69 + 1] = 12;
                local44 = local44 + 1 & MASK_QUEUE_SIZE;
                cost[local74 + 1][local69 + 1] = local264;
            }
        }
    }

    private PathFinder() {
        /* empty */
    }
}
