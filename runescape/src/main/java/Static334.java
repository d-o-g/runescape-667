import com.jagex.graphics.Fonts;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static334 {

    @OriginalMember(owner = "client!kja", name = "e", descriptor = "[[[Lclient!pha;")
    public static Tile[][][] activeTiles;

    @OriginalMember(owner = "client!kja", name = "a", descriptor = "I")
    public static int anInt5456 = 0;

    @OriginalMember(owner = "client!kja", name = "a", descriptor = "()V")
    public static void w2debug() {
        if (Static684.w2debug == 0 || Fonts.debug == null) {
            return;
        }

        Static665.aToolkit_15.K(Static238.anIntArray307);

        for (@Pc(14) int local14 = 0; local14 < Static537.anIntArray633.length; local14++) {
            Static665.aToolkit_15.verticalLine(Static537.anIntArray633[local14] + Static621.anIntArray766[local14], Static238.anIntArray307[1], Static238.anIntArray307[3] - Static238.anIntArray307[1], -256);
        }

        for (@Pc(43) int local43 = 0; local43 < Static469.activeOccluderCount; local43++) {
            @Pc(48) LocOccluder occluder = Static560.aLocOccluderArray3[local43];
            Static665.aToolkit_15.H(occluder.anIntArray185[0], occluder.anIntArray186[0], occluder.anIntArray188[0], Static625.anIntArray737);
            Static665.aToolkit_15.H(occluder.anIntArray185[1], occluder.anIntArray186[1], occluder.anIntArray188[1], Static9.anIntArray19);
            Static665.aToolkit_15.H(occluder.anIntArray185[2], occluder.anIntArray186[2], occluder.anIntArray188[2], Static574.anIntArray683);
            Static665.aToolkit_15.H(occluder.anIntArray185[3], occluder.anIntArray186[3], occluder.anIntArray188[3], Static300.anIntArray368);

            if (Static625.anIntArray737[2] != -1 && Static9.anIntArray19[2] != -1 && Static574.anIntArray683[2] != -1 && Static300.anIntArray368[2] != -1) {
                @Pc(136) int colour = 0xFFFF0000;
                if (occluder.aByte43 == 4) {
                    colour = 0xFF0000FF;
                }

                Static665.aToolkit_15.line(Static9.anIntArray19[1], Static625.anIntArray737[1], Static9.anIntArray19[0], colour, Static625.anIntArray737[0]);
                Static665.aToolkit_15.line(Static574.anIntArray683[1], Static9.anIntArray19[1], Static574.anIntArray683[0], colour, Static9.anIntArray19[0]);
                Static665.aToolkit_15.line(Static300.anIntArray368[1], Static574.anIntArray683[1], Static300.anIntArray368[0], colour, Static574.anIntArray683[0]);
                Static665.aToolkit_15.line(Static625.anIntArray737[1], Static300.anIntArray368[1], Static625.anIntArray737[0], colour, Static300.anIntArray368[0]);
                Static665.aToolkit_15.line(Static574.anIntArray683[1], Static625.anIntArray737[1], Static574.anIntArray683[0], colour, Static625.anIntArray737[0]);
            }
        }

        Fonts.debug.render("Dynamic: " + Static125.dynamicEntityCount + "/" + 5000, 10, 75, 0xFF000000, 0xFFFFFF00);
        Fonts.debug.render("Total Opaque Onscreen: " + Static546.onscreenOpaqueEntityCount + "/" + 10000, 10, 90, 0xFF000000, 0xFFFFFF00);
        Fonts.debug.render("Total Trans Onscreen: " + Static645.onscreenTransparentEntityCount + "/" + 5000, 10, 105, 0xFF000000, 0xFFFFFF00);
        Fonts.debug.render("Occluders: " + (Static317.anInt5046 + Static444.anInt6751) + " Active: " + Static469.activeOccluderCount, 10, 120, 0xFF000000, 0xFFFFFF00);
        Fonts.debug.render("Occluded: Ground:" + Static298.occludedGroundCount + " Walls: " + Static679.occludedWallCount + " CPs: " + Static356.anInt5773 + " Pixels: " + Static432.occludedPixelCount, 10, 135, 0xFF000000, 0xFFFFFF00);
        Fonts.debug.render("Occlude Calc Took: " + Static666.occludeCalcElapsedMs / 1000L + "us", 10, 150, 0xFF000000, 0xFFFFFF00);

        if (Static684.w2debug == 2 && Static485.anIntArray886 != null) {
            for (@Pc(389) int local389 = 0; local389 < Static485.anIntArray886.length; local389++) {
                @Pc(395) float local395 = (float) Static485.anIntArray886[local389];
                local395 /= 4194304.0F;
                if (local395 > 1.0F) {
                    local395 = 1.0F;
                }
                local395 *= 255.0F;
                local395 = 255.0F - local395;
                @Pc(416) int local416 = (int) local395;
                Static485.anIntArray886[local389] = local416 | local416 << 8 | local416 << 16 | 0xFF000000;
            }
            @Pc(444) Sprite local444 = Static665.aToolkit_15.createSprite(Static228.anInt3709, Static228.anInt3709, Static624.anInt9461, Static485.anIntArray886);
            local444.render(10, 170, 1, 0, 0);
        }
    }
}
