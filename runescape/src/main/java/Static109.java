import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static109 {

    @OriginalMember(owner = "client!dh", name = "e", descriptor = "I")
    public static int anInt2178;

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(Lclient!eo;)V")
    public static void hide(@OriginalArg(0) Entity entity) {
        if (entity == null) {
            return;
        }

        for (@Pc(5) int ground = 0; ground < 2; ground++) {
            @Pc(8) Entity other = null;

            for (@Pc(12) Entity opaque = Static576.opaqueStationaryEntities[ground]; opaque != null; opaque = opaque.nextEntity) {
                if (opaque == entity) {
                    if (other == null) {
                        Static576.opaqueStationaryEntities[ground] = opaque.nextEntity;
                    } else {
                        other.nextEntity = opaque.nextEntity;
                    }

                    Static75.hasOpaqueStationaryEntities = true;
                    return;
                }

                other = opaque;
            }

            other = null;

            for (@Pc(47) Entity transparent = Static398.transparentStationaryEntities[ground]; transparent != null; transparent = transparent.nextEntity) {
                if (transparent == entity) {
                    if (other == null) {
                        Static398.transparentStationaryEntities[ground] = transparent.nextEntity;
                    } else {
                        other.nextEntity = transparent.nextEntity;
                    }

                    Static75.hasOpaqueStationaryEntities = true;
                    return;
                }

                other = transparent;
            }

            other = null;

            for (@Pc(82) Entity dynamic = Static468.dynamicEntities[ground]; dynamic != null; dynamic = dynamic.nextEntity) {
                if (dynamic == entity) {
                    if (other == null) {
                        Static468.dynamicEntities[ground] = dynamic.nextEntity;
                    } else {
                        other.nextEntity = dynamic.nextEntity;
                    }

                    Static75.hasOpaqueStationaryEntities = true;
                    return;
                }

                other = dynamic;
            }
        }
    }

}
