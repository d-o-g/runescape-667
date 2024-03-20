package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class LocShapes {

	public static int[] WALLDECOR_DIAGONAL_ZOFFSET = { -1, -1, +1, +1 };
	public static int[] WALLDECOR_DIAGONAL_XOFFSET = { +1, -1, -1, +1 };
	public static int[] WALLDECOR_STRAIGHT_ZOFFSET = { +0, -1, +0, +1 };
	public static int[] WALLDECOR_STRAIGHT_XOFFSET = { +1, +0, -1, +0 };

	public static int[] LAYERS_BY_SHAPE = {
		/* 00 */ LocLayer.WALL,
		/* 01 */ LocLayer.WALL,
		/* 02 */ LocLayer.WALL,
		/* 03 */ LocLayer.WALL,
		/* 04 */ LocLayer.WALLDECOR,
		/* 05 */ LocLayer.WALLDECOR,
		/* 06 */ LocLayer.WALLDECOR,
		/* 07 */ LocLayer.WALLDECOR,
		/* 08 */ LocLayer.WALLDECOR,
		/* 09 */ LocLayer.GROUND,
		/* 10 */ LocLayer.GROUND,
		/* 11 */ LocLayer.GROUND,
		/* 12 */ LocLayer.GROUND,
		/* 13 */ LocLayer.GROUND,
		/* 14 */ LocLayer.GROUND,
		/* 15 */ LocLayer.GROUND,
		/* 16 */ LocLayer.GROUND,
		/* 17 */ LocLayer.GROUND,
		/* 18 */ LocLayer.GROUND,
		/* 19 */ LocLayer.GROUND,
		/* 20 */ LocLayer.GROUND,
		/* 21 */ LocLayer.GROUND,
		/* 22 */ LocLayer.GROUNDDECOR
	};

	public static final int WALL_STRAIGHT = 0;
	public static final int WALL_DIAGONALCORNER = 1;
	public static final int WALL_L = 2;
	public static final int WALL_SQUARECORNER = 3;
	public static final int WALL_DIAGONAL = 9;

	public static final int WALLDECOR_STRAIGHT_NOOFFSET = 4;
	public static final int WALLDECOR_STRAIGHT_OFFSET = 5;
	public static final int WALLDECOR_DIAGONAL_OFFSET = 6;
	public static final int WALLDECOR_DIAGONAL_NOOFFSET = 7;
	public static final int WALLDECOR_DIAGONAL_BOTH = 8;

	public static final int ROOF_STRAIGHT = 12;
	public static final int ROOF_DIAGONAL_WITH_ROOFEDGE = 13;
	public static final int ROOF_DIAGONAL = 14;
	public static final int ROOF_L_CONCAVE = 15;
	public static final int ROOF_L_CONVEX = 16;
	public static final int ROOF_FLAT = 17;

	public static final int ROOFEDGE_STRAIGHT = 18;
	public static final int ROOFEDGE_DIAGONALCORNER = 19;
	public static final int ROOFEDGE_L = 20;
	public static final int ROOFEDGE_SQUARECORNER = 21;

	public static final int CENTREPIECE_STRAIGHT = 10;
	public static final int CENTREPIECE_DIAGONAL = 11;

	public static final int GROUNDDECOR = 22;

    @OriginalMember(owner = "client!r", name = "b", descriptor = "(II)Z")
    public static boolean isWall(@OriginalArg(0) int shape) {
        return shape >= WALL_STRAIGHT && shape <= WALL_SQUARECORNER || shape == WALL_DIAGONAL;
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(IB)Z")
    public static boolean isWallDecor(@OriginalArg(0) int shape) {
        return shape >= WALLDECOR_STRAIGHT_NOOFFSET && shape <= WALLDECOR_DIAGONAL_BOTH;
    }

    @OriginalMember(owner = "client!md", name = "b", descriptor = "(IZ)Z")
    public static boolean isRoof(@OriginalArg(0) int shape) {
        return shape >= ROOF_STRAIGHT && shape <= ROOF_FLAT;
    }

	private LocShapes() {
		/* empty */
	}
}
