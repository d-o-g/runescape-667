import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class WorldComparator {
    public static final int COMPARE_BY_POPULATION = 1;

    public static final int COMPARE_BY_LANGUAGE = 2;

    public static final int COMPARE_BY_ACTIVITY = 3;

    public static final int COMPARE_BY_LOOTSHARE = 4;

    public static final int COMPARE_BY_QUICKCHAT = 5;

    public static final int COMPARE_BY_PVP = 6;

    public static final int COMPARE_BY_MEMBERS = 7;

    public static final int COMPARE_BY_PING = 8;

    @OriginalMember(owner = "client!vd", name = "a", descriptor = "(Lclient!pq;ZLclient!pq;II)I")
    public static int compare(@OriginalArg(0) GameWorld b, @OriginalArg(1) boolean descending, @OriginalArg(2) GameWorld a, @OriginalArg(3) int comparison) {
        if (comparison == COMPARE_BY_POPULATION) {
            @Pc(11) int populationA = a.population;
            @Pc(14) int populationB = b.population;

            if (!descending) {
                if (populationA == -1) {
                    populationA = 2001;
                }
                if (populationB == -1) {
                    populationB = 2001;
                }
            }

            return populationA - populationB;
        } else if (comparison == COMPARE_BY_LANGUAGE) {
            return Static540.compare(b.method6717().name, client.language, a.method6717().name);
        } else if (comparison == COMPARE_BY_ACTIVITY) {
            if (a.activity.equals("-")) {
                if (b.activity.equals("-")) {
                    return 0;
                } else if (descending) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (b.activity.equals("-")) {
                return descending ? 1 : -1;
            } else {
                return Static540.compare(b.activity, client.language, a.activity);
            }
        } else if (comparison == COMPARE_BY_LOOTSHARE) {
            if (a.isLootShare()) {
                return b.isLootShare() ? 0 : 1;
            } else if (b.isLootShare()) {
                return -1;
            } else {
                return 0;
            }
        } else if (comparison == COMPARE_BY_QUICKCHAT) {
            if (a.isQuickChat()) {
                return b.isQuickChat() ? 0 : 1;
            } else if (b.isQuickChat()) {
                return -1;
            } else {
                return 0;
            }
        } else if (comparison == COMPARE_BY_PVP) {
            if (a.isPvp()) {
                return b.isPvp() ? 0 : 1;
            } else if (b.isPvp()) {
                return -1;
            } else {
                return 0;
            }
        } else if (comparison == COMPARE_BY_MEMBERS) {
            if (a.isMembers()) {
                return b.isMembers() ? 0 : 1;
            } else if (b.isMembers()) {
                return -1;
            } else {
                return 0;
            }
        } else if (comparison == COMPARE_BY_PING) {
            @Pc(11) int pingA = a.ping;
            @Pc(14) int pingB = b.ping;

            if (descending) {
                if (pingA == 1000) {
                    pingA = -1;
                }
                if (pingB == 1000) {
                    pingB = -1;
                }
            } else {
                if (pingA == -1) {
                    pingA = 1000;
                }
                if (pingB == -1) {
                    pingB = 1000;
                }
            }
            return pingA - pingB;
        } else {
            return a.id - b.id;
        }
    }

    @OriginalMember(owner = "client!ud", name = "a", descriptor = "(Lclient!pq;IIZILclient!pq;Z)I")
    public static int compare(@OriginalArg(0) GameWorld b, @OriginalArg(1) int primaryComparison, @OriginalArg(2) int secondaryComparison, @OriginalArg(3) boolean secondaryDescending, @OriginalArg(5) GameWorld a, @OriginalArg(6) boolean primaryDescending) {
        @Pc(24) int comparison1 = compare(b, primaryDescending, a, primaryComparison);
        if (comparison1 != 0) {
            return primaryDescending ? -comparison1 : comparison1;
        }

        if (secondaryComparison != -1) {
            @Pc(52) int comparison2 = compare(b, secondaryDescending, a, secondaryComparison);
            return secondaryDescending ? -comparison2 : comparison2;
        }

        return 0;
    }
}
