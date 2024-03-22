package rs2.client.loading;

import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!gca")
public final class LoadState {

    @OriginalMember(owner = "client!gca", name = "D", descriptor = "Lclient!gca;")
    public static final LoadState WAIT_FOR_MEMORY = new LoadState(0, LocalisedText.CHECKING_FOR_UPDATES, LocalisedText.CHECKING_FOR_UPDATES, 0, 1);

    @OriginalMember(owner = "client!gca", name = "q", descriptor = "Lclient!gca;")
    public static final LoadState INIT_LOADING_SCREEN_ARCHIVES = new LoadState(1, LocalisedText.CHECKING_FOR_UPDATES, 2);

    @OriginalMember(owner = "client!gca", name = "H", descriptor = "Lclient!gca;")
    public static final LoadState FETCH_LOADING_SCREEN_RESOURCES = new LoadState(2, LocalisedText.CHECKING_FOR_UPDATES, LocalisedText.CHECKING_FOR_UPDATES, 2, 3);

    @OriginalMember(owner = "client!gca", name = "B", descriptor = "Lclient!gca;")
    public static final LoadState INIT_FONT_INFO = new LoadState(3, LocalisedText.CHECKING_FOR_UPDATES, 3);

    @OriginalMember(owner = "client!gca", name = "t", descriptor = "Lclient!gca;")
    public static final LoadState LOAD_FONTS = new LoadState(4, LocalisedText.CHECKING_FOR_UPDATES, LocalisedText.CHECKING_FOR_UPDATES, 3, 4);

    @OriginalMember(owner = "client!gca", name = "f", descriptor = "Lclient!gca;")
    public static final LoadState FETCH_FONTS = new LoadState(5, LocalisedText.CHECKING_FOR_UPDATES, 4);

    @OriginalMember(owner = "client!gca", name = "b", descriptor = "Lclient!gca;")
    public static final LoadState CREATE_COLLISION_MAPS = new LoadState(6, LocalisedText.CHECKING_FOR_UPDATES, 4);

    @OriginalMember(owner = "client!gca", name = "F", descriptor = "Lclient!gca;")
    public static final LoadState OPEN_JS5_ARCHIVES = new LoadState(7, LocalisedText.CHECKING_FOR_UPDATES, LocalisedText.CHECKING_FOR_UPDATES, 4, 5);

    @OriginalMember(owner = "client!gca", name = "z", descriptor = "Lclient!gca;")
    public static final LoadState GET_JS5_INDEXES = new LoadState(8, LocalisedText.CHECKING_FOR_UPDATES, LocalisedText.CHECKING_FOR_UPDATES, 5, 98, true, true);

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "Lclient!gca;")
    public static final LoadState PLAY_THEME_MUSIC = new LoadState(9, LocalisedText.CHECKING_FOR_UPDATES, 99);

    @OriginalMember(owner = "client!gca", name = "u", descriptor = "Lclient!gca;")
    public static final LoadState SETUP_LIB_PATH = new LoadState(10, LocalisedText.CHECKING_FOR_UPDATES, 100);

    @OriginalMember(owner = "client!gca", name = "K", descriptor = "Lclient!gca;")
    public static final LoadState DOWNLOAD_STUFF = new LoadState(11, LocalisedText.DOWNLOADING_UPDATES, LocalisedText.DOWNLOADING_UPDATES, 0, 92, true, true);

    @OriginalMember(owner = "client!gca", name = "o", descriptor = "Lclient!gca;")
    public static final LoadState SETUP_CONFIG_DECODERS = new LoadState(12, LocalisedText.DOWNLOADING_UPDATES, LocalisedText.DOWNLOADING_UPDATES, 92, 92);

    @OriginalMember(owner = "client!gca", name = "c", descriptor = "Lclient!gca;")
    public static final LoadState A_LOAD_STATE___14 = new LoadState(13, LocalisedText.DOWNLOADING_UPDATES, LocalisedText.DOWNLOADING_UPDATES, 92, 93);

    @OriginalMember(owner = "client!gca", name = "k", descriptor = "Lclient!gca;")
    public static final LoadState SETUP_STATIC_SPRITES = new LoadState(14, LocalisedText.DOWNLOADING_UPDATES, LocalisedText.DOWNLOADING_UPDATES, 94, 95);

    @OriginalMember(owner = "client!gca", name = "x", descriptor = "Lclient!gca;")
    public static final LoadState SETUP_WORLD_MAP = new LoadState(15, LocalisedText.DOWNLOADING_UPDATES, LocalisedText.DOWNLOADING_UPDATES, 96, 97);

    @OriginalMember(owner = "client!gca", name = "j", descriptor = "Lclient!gca;")
    public static final LoadState SETUP_VARC_SYSTEM = new LoadState(16, LocalisedText.DOWNLOADING_UPDATES, 97);

    @OriginalMember(owner = "client!gca", name = "n", descriptor = "Lclient!gca;")
    public static final LoadState LOAD_LOGIN_WINDOW = new LoadState(17, LocalisedText.DOWNLOADING_UPDATES, 97);

    @OriginalMember(owner = "client!gca", name = "m", descriptor = "Lclient!gca;")
    public static final LoadState SHOW_LOGIN_WINDOW = new LoadState(18, LocalisedText.DOWNLOADING_UPDATES, 100);

    @OriginalMember(owner = "client!gca", name = "I", descriptor = "Lclient!gca;")
    public static final LoadState CLEANUP = new LoadState(19, LocalisedText.DOWNLOADING_UPDATES, 100);

    @OriginalMember(owner = "client!gca", name = "C", descriptor = "Lclient!gca;")
    public static final LoadState COMPLETE = new LoadState(20, LocalisedText.DOWNLOADING_UPDATES, 100);

    @OriginalMember(owner = "client!gca", name = "r", descriptor = "I")
    public final int step;

    @OriginalMember(owner = "client!gca", name = "d", descriptor = "Lclient!bba;")
    public final LocalisedText stalledText;

    @OriginalMember(owner = "client!gca", name = "G", descriptor = "I")
    public final int endPercentage;

    @OriginalMember(owner = "client!gca", name = "h", descriptor = "I")
    public final int startPercentage;

    @OriginalMember(owner = "client!gca", name = "y", descriptor = "Z")
    public final boolean displayPercentage;

    @OriginalMember(owner = "client!gca", name = "w", descriptor = "Lclient!bba;")
    public final LocalisedText changedText;

    @OriginalMember(owner = "client!gca", name = "J", descriptor = "Z")
    public final boolean updatePercentage;

    @OriginalMember(owner = "client!gca", name = "<init>", descriptor = "(ILclient!bba;I)V")
    public LoadState(@OriginalArg(0) int step, @OriginalArg(1) LocalisedText text, @OriginalArg(2) int percentage) {
        this(step, text, text, percentage, percentage, true, false);
    }

    @OriginalMember(owner = "client!gca", name = "<init>", descriptor = "(ILclient!bba;Lclient!bba;II)V")
    public LoadState(@OriginalArg(0) int step, @OriginalArg(1) LocalisedText stalledText, @OriginalArg(2) LocalisedText changedText, @OriginalArg(3) int startPercentage, @OriginalArg(4) int endPercentage) {
        this(step, stalledText, changedText, startPercentage, endPercentage, true, false);
    }

    @OriginalMember(owner = "client!gca", name = "<init>", descriptor = "(ILclient!bba;Lclient!bba;IIZZ)V")
    public LoadState(@OriginalArg(0) int step, @OriginalArg(1) LocalisedText stalledText, @OriginalArg(2) LocalisedText changedText, @OriginalArg(3) int startPercentage, @OriginalArg(4) int endPercentage, @OriginalArg(5) boolean displayPercentage, @OriginalArg(6) boolean updatePercentage) {
        this.startPercentage = startPercentage;
        this.displayPercentage = displayPercentage;
        this.endPercentage = endPercentage;
        this.updatePercentage = updatePercentage;
        this.changedText = changedText;
        this.stalledText = stalledText;
        this.step = step;
    }

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "(B)[Lclient!gca;")
    public static LoadState[] method2955() {
        return new LoadState[]{WAIT_FOR_MEMORY, INIT_LOADING_SCREEN_ARCHIVES, FETCH_LOADING_SCREEN_RESOURCES, INIT_FONT_INFO, LOAD_FONTS, FETCH_FONTS, CREATE_COLLISION_MAPS, OPEN_JS5_ARCHIVES, GET_JS5_INDEXES, PLAY_THEME_MUSIC, SETUP_LIB_PATH, DOWNLOAD_STUFF, SETUP_CONFIG_DECODERS, A_LOAD_STATE___14, SETUP_STATIC_SPRITES, SETUP_WORLD_MAP, SETUP_VARC_SYSTEM, LOAD_LOGIN_WINDOW, SHOW_LOGIN_WINDOW, CLEANUP, COMPLETE};
    }

    @OriginalMember(owner = "client!gca", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!gca", name = "b", descriptor = "(I)I")
    public int step() {
        return this.step;
    }
}
