import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ida")
public final class VarcstrTypeList {

    @OriginalMember(owner = "client!wo", name = "A", descriptor = "Lclient!ida;")
    public static VarcstrTypeList instance;

    private final ReferenceCache recentUse = new ReferenceCache(64);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!ida", name = "a", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!ida", name = "d", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!ida", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarcstrTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(15);
    }
}
