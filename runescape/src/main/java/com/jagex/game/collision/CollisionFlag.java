package com.jagex.game.collision;

public final class CollisionFlag {
    public static final int WALL_NORTH_WEST = 0x1;

    public static final int WALL_NORTH = 0x2;

    public static final int WALL_NORTH_EAST = 0x4;

    public static final int WALL_EAST = 0x8;

    public static final int WALL_NORTH_AND_EAST = WALL_NORTH | WALL_EAST;

    public static final int WALL_SOUTH_EAST = 0x10;

    public static final int WALL_SOUTH = 0x20;

    public static final int WALL_SOUTH_AND_EAST = WALL_SOUTH | WALL_EAST;

    public static final int WALL_SOUTH_WEST = 0x40;

    public static final int WALL_WEST = 0x80;

    public static final int WALL_SOUTH_AND_WEST = WALL_SOUTH | WALL_WEST;

    public static final int WALL_NORTH_AND_WEST = WALL_NORTH | WALL_WEST;

    public static final int DIRECTION_EAST = 0x2;

    public static final int DIRECTION_WEST = 0x8;

    public static final int DIRECTION_NORTH = 0x1;

    public static final int DIRECTION_SOUTH = 0x4;

    public static final int LOCATION = 0x100;

    public static final int WALL_NORTH_WEST_BLOCK_RANGED = 0x200;

    public static final int WALL_NORTH_BLOCK_RANGED = 0x400;

    public static final int WALL_NORTH_EAST_BLOCK_RANGED = 0x800;

    public static final int WALL_EAST_BLOCK_RANGED = 0x1000;

    public static final int WALL_NORTH_AND_EAST_BLOCK_RANGED = WALL_NORTH_BLOCK_RANGED | WALL_EAST_BLOCK_RANGED;

    public static final int WALL_SOUTH_EAST_BLOCK_RANGED = 0x2000;

    public static final int WALL_SOUTH_BLOCK_RANGED = 0x4000;

    public static final int WALL_SOUTH_AND_EAST_BLOCK_RANGED = WALL_SOUTH_BLOCK_RANGED | WALL_EAST_BLOCK_RANGED;

    public static final int WALL_SOUTH_WEST_BLOCK_RANGED = 0x8000;

    public static final int WALL_WEST_BLOCK_RANGED = 0x10000;

    public static final int WALL_SOUTH_AND_WEST_BLOCK_RANGED = WALL_SOUTH_BLOCK_RANGED | WALL_WEST_BLOCK_RANGED;

    public static final int WALL_NORTH_AND_WEST_BLOCK_RANGED = WALL_NORTH_BLOCK_RANGED | WALL_WEST_BLOCK_RANGED;

    public static final int LOCATION_BLOCK_RANGED = 0x20000;

    public static final int GROUND_DECOR = 0x40000;

    public static final int UNKNOWN = 0x80000;

    public static final int BLOCK_WALK = 0x200000;

    public static final int WALL = BLOCK_WALK | UNKNOWN | GROUND_DECOR | LOCATION;

    public static final int WALL_NORTH_WEST_BLOCK_ROUTE = 0x400000;

    public static final int WALL_NORTH_BLOCK_ROUTE = 0x800000;

    public static final int WALL_NORTH_EAST_BLOCK_ROUTE = 0x1000000;

    public static final int WALL_EAST_BLOCK_ROUTE = 0x2000000;

    public static final int WALL_NORTH_AND_EAST_BLOCK_ROUTE = WALL_NORTH_BLOCK_ROUTE | WALL_EAST_BLOCK_ROUTE;

    public static final int WALL_SOUTH_EAST_BLOCK_ROUTE = 0x4000000;

    public static final int WALL_SOUTH_BLOCK_ROUTE = 0x8000000;

    public static final int WALL_SOUTH_AND_EAST_BLOCK_ROUTE = WALL_SOUTH_BLOCK_ROUTE | WALL_EAST_BLOCK_ROUTE;

    public static final int WALL_SOUTH_WEST_BLOCK_ROUTE = 0x10000000;

    public static final int WALL_WEST_BLOCK_ROUTE = 0x20000000;

    public static final int WALL_SOUTH_AND_WEST_BLOCK_ROUTE = WALL_SOUTH_BLOCK_ROUTE | WALL_WEST_BLOCK_ROUTE;

    public static final int WALL_NORTH_AND_WEST_BLOCK_ROUTE = WALL_NORTH_BLOCK_ROUTE | WALL_WEST_BLOCK_ROUTE;

    public static final int LOCATION_BLOCK_ROUTE = 0x40000000;
}
