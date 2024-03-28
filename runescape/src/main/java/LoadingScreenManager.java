import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.core.util.Arrays;
import com.jagex.graphics.texture.Node_Sub1_Sub27;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

import java.util.Random;

@OriginalClass("client!oka")
public final class LoadingScreenManager {

    @OriginalMember(owner = "client!kj", name = "b", descriptor = "Lclient!oka;")
    public static LoadingScreenManager instance;

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!oka", name = "i", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!oka", name = "d", descriptor = "I")
    public final int defaultScreen;

    @OriginalMember(owner = "client!oka", name = "f", descriptor = "[[I")
    public final int[][] anIntArrayArray171;

    @OriginalMember(owner = "client!oka", name = "k", descriptor = "[Z")
    public final boolean[] aBooleanArray22;

    @OriginalMember(owner = "client!oka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public LoadingScreenManager(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(1);

        @Pc(22) Packet local22 = new Packet(this.configClient.getfile(0, 0));
        @Pc(26) int local26 = local22.g1();
        if (local26 > 3) {
            this.aBooleanArray22 = new boolean[0];
            this.defaultScreen = -1;
            this.anIntArrayArray171 = new int[0][];
        } else {
            @Pc(33) int local33 = local22.g1();
            @Pc(36) LoadingScreenOpType[] local36 = LoadingScreenOpType.values();
            @Pc(38) boolean local38 = true;
            @Pc(44) int local44;
            @Pc(50) int local50;
            if (local33 == local36.length) {
                for (local44 = 0; local44 < local36.length; local44++) {
                    local50 = local22.g1();
                    if (local50 != local36[local44].version) {
                        local38 = false;
                        break;
                    }
                }
            } else {
                local38 = false;
            }
            if (local38) {
                local44 = local22.g1();
                local50 = local22.g1();
                if (local26 > 2) {
                    this.defaultScreen = local22.g2s();
                } else {
                    this.defaultScreen = -1;
                }
                this.anIntArrayArray171 = new int[local50 + 1][];
                this.aBooleanArray22 = new boolean[local50 + 1];
                @Pc(128) int local128;
                for (@Pc(122) int local122 = 0; local122 < local44; local122++) {
                    local128 = local22.g1();
                    this.aBooleanArray22[local128] = local22.g1() == 1;
                    @Pc(147) int local147 = local22.g2();
                    @Pc(169) int local169;
                    if (this.defaultScreen == -1) {
                        this.anIntArrayArray171[local128] = new int[local147];
                        for (local169 = 0; local169 < local147; local169++) {
                            this.anIntArrayArray171[local128][local169] = local22.g2();
                        }
                    } else {
                        this.anIntArrayArray171[local128] = new int[local147 + 1];
                        this.anIntArrayArray171[local128][0] = this.defaultScreen;
                        for (local169 = 0; local169 < local147; local169++) {
                            this.anIntArrayArray171[local128][local169 + 1] = local22.g2();
                        }
                    }
                }
                for (local128 = 0; local128 < local50 + 1; local128++) {
                    if (this.anIntArrayArray171[local128] == null) {
                        if (this.defaultScreen == -1) {
                            this.anIntArrayArray171[local128] = new int[0];
                        } else {
                            this.anIntArrayArray171[local128] = new int[]{this.defaultScreen};
                        }
                    }
                }
            } else {
                this.aBooleanArray22 = new boolean[0];
                this.anIntArrayArray171 = new int[0][];
                this.defaultScreen = -1;
            }
        }
    }

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "(IB)[I")
    public int[] getSequence(@OriginalArg(0) int arg0) {
        if (arg0 < 0 || this.anIntArrayArray171.length <= arg0) {
            return this.defaultScreen == -1 ? new int[0] : new int[]{this.defaultScreen};
        } else if (this.aBooleanArray22[arg0] && this.anIntArrayArray171[arg0].length > 1) {
            @Pc(66) int local66 = this.defaultScreen == -1 ? 0 : 1;
            @Pc(70) Random local70 = new Random();
            @Pc(77) int[] local77 = new int[this.anIntArrayArray171[arg0].length];
            Arrays.copy(this.anIntArrayArray171[arg0], 0, local77, 0, local77.length);
            for (@Pc(99) int local99 = local66; local99 < local77.length; local99++) {
                @Pc(112) int local112 = local66 + Node_Sub1_Sub27.method8326(-5208, local77.length - local66, local70);
                @Pc(116) int local116 = local77[local99];
                local77[local99] = local77[local112];
                local77[local112] = local116;
            }
            return local77;
        } else {
            return this.anIntArrayArray171[arg0];
        }
    }

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "(Z)Z")
    public boolean hasDefault() {
        return this.defaultScreen != -1;
    }

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "(IZ)Lclient!de;")
    public LoadingScreenType get(@OriginalArg(0) int id) {
        @Pc(10) byte[] data = this.configClient.getfile(id, 1);
        @Pc(14) LoadingScreenType type = new LoadingScreenType();
        type.decode(new Packet(data));
        return type;
    }
}
