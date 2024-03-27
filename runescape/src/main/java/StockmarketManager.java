import com.jagex.StockmarketOffer;
import org.openrs2.deob.annotation.OriginalMember;

public final class StockmarketManager {

    @OriginalMember(owner = "client!df", name = "u", descriptor = "[Lclient!ho;")
    public static final StockmarketOffer[] offers = new StockmarketOffer[6];

    @OriginalMember(owner = "client!qk", name = "e", descriptor = "I")
    public static int lastTransmit = 0;
}
