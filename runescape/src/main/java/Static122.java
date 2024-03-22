import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static122 {

    @OriginalMember(owner = "client!dq", name = "b", descriptor = "(B)Lclient!fu;")
    public static MapElementListEntry method2207() {
        if (WorldMap.elements == null || Static444.aClass191_1 == null) {
            return null;
        }
        Static444.aClass191_1.setDeque(WorldMap.elements);
        @Pc(23) MapElementListEntry local23 = (MapElementListEntry) Static444.aClass191_1.first();
        if (local23 == null) {
            return null;
        } else {
            @Pc(42) MapElementType local42 = WorldMap.mapElementTypeList.list(local23.id);
            return local42 != null && local42.aBoolean217 && local42.method2425(WorldMap.varDomain) ? local23 : Static364.method5248();
        }
    }

}
