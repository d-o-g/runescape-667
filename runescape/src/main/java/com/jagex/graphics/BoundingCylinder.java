package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ke")
public final class BoundingCylinder {

    @OriginalMember(owner = "client!kaa", name = "a", descriptor = "(IIILclient!ka;I)Lclient!ke;")
    public static BoundingCylinder create(@OriginalArg(1) int y, @OriginalArg(2) int x, @OriginalArg(3) Model model, @OriginalArg(4) int z) {
        if (model != null) {
            return new BoundingCylinder(x, y, z, model.na(), model.V(), model.RA(), model.fa(), model.EA(), model.HA(), model.G());
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!gu", name = "a", descriptor = "(Lclient!ka;IIILclient!ke;I)V")
    public static void update(@OriginalArg(0) Model model, @OriginalArg(1) int z, @OriginalArg(2) int y, @OriginalArg(3) int x, @OriginalArg(4) BoundingCylinder cylinder) {
        if (model != null) {
            cylinder.update(model.fa(), model.HA(), y, x, model.G(), model.na(), z, model.EA(), model.V(), model.RA());
        }
    }

    @OriginalMember(owner = "client!ke", name = "h", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!ke", name = "g", descriptor = "I")
    public int z;

    @OriginalMember(owner = "client!ke", name = "o", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!ke", name = "j", descriptor = "I")
    public int anInt5132;

    @OriginalMember(owner = "client!ke", name = "d", descriptor = "I")
    public int x1;

    @OriginalMember(owner = "client!ke", name = "b", descriptor = "I")
    public int x2;

    @OriginalMember(owner = "client!ke", name = "p", descriptor = "I")
    public int z1;

    @OriginalMember(owner = "client!ke", name = "i", descriptor = "I")
    public int z2;

    @OriginalMember(owner = "client!ke", name = "f", descriptor = "I")
    public int y2;

    @OriginalMember(owner = "client!ke", name = "a", descriptor = "I")
    public int y1;

    @OriginalMember(owner = "client!ke", name = "<init>", descriptor = "(IIIIIIIIII)V")
    public BoundingCylinder(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int arg3, @OriginalArg(4) int minX, @OriginalArg(5) int maxX, @OriginalArg(6) int minY, @OriginalArg(7) int maxY, @OriginalArg(8) int minZ, @OriginalArg(9) int maxZ) {
        this.x = x;
        this.z = z;
        this.y = y;
        this.anInt5132 = arg3 * arg3;
        this.x1 = this.x + minX;
        this.x2 = this.x + maxX;
        this.z1 = this.z + minZ;
        this.z2 = this.z + maxZ;
        this.y2 = this.y + maxY;
        this.y1 = this.y + minY;
    }

    @OriginalMember(owner = "client!ke", name = "a", descriptor = "(IIIIIIIIIII)V")
    public void update(@OriginalArg(0) int minY, @OriginalArg(1) int minZ, @OriginalArg(2) int y, @OriginalArg(3) int x, @OriginalArg(4) int maxZ, @OriginalArg(6) int arg5, @OriginalArg(7) int z, @OriginalArg(8) int maxY, @OriginalArg(9) int minX, @OriginalArg(10) int maxX) {
        this.z = z;
        this.y = y;
        this.anInt5132 = arg5 * arg5;
        this.x = x;
        this.y1 = this.y + minY;
        this.z1 = this.z + minZ;
        this.y2 = this.y + maxY;
        this.x2 = this.x + maxX;
        this.x1 = this.x + minX;
        this.z2 = this.z + maxZ;
    }

    @OriginalMember(owner = "client!ke", name = "a", descriptor = "(IBII)Z")
    public boolean method4631(@OriginalArg(0) int y, @OriginalArg(2) int z, @OriginalArg(3) int x) {
        if (x < this.x1 || x > this.x2) {
            return false;
        } else if (y < this.y1 || y > this.y2) {
            return false;
        } else if (z < this.z1 || z > this.z2) {
            return false;
        } else {
            @Pc(74) int deltaX = x - this.x;
            @Pc(79) int deltaY = z - this.z;
            return ((deltaY * deltaY) + (deltaX * deltaX)) < this.anInt5132;
        }
    }
}
