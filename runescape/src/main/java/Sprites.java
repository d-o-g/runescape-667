import com.jagex.IndexedImage;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Sprites {

    @OriginalMember(owner = "client!ew", name = "c", descriptor = "I")
    public static int hitbarDefaultGroup;

    @OriginalMember(owner = "client!nla", name = "V", descriptor = "I")
    public static int timerbarDefaultGroup;

    @OriginalMember(owner = "client!cca", name = "f", descriptor = "I")
    public static int headiconsPkGroup;

    @OriginalMember(owner = "client!jla", name = "b", descriptor = "I")
    public static int headiconsPrayerGroup;

    @OriginalMember(owner = "client!ufa", name = "a", descriptor = "I")
    public static int hintHeadiconsGroup;

    @OriginalMember(owner = "client!wc", name = "F", descriptor = "I")
    public static int hintMapmarkersGroup;

    @OriginalMember(owner = "client!ec", name = "F", descriptor = "I")
    public static int mapflagGroup;

    @OriginalMember(owner = "client!iia", name = "n", descriptor = "I")
    public static int crossGroup;

    @OriginalMember(owner = "client!ss", name = "d", descriptor = "I")
    public static int mapdotsGroup;

    @OriginalMember(owner = "client!jm", name = "c", descriptor = "I")
    public static int scrollbarGroup;

    @OriginalMember(owner = "client!re", name = "l", descriptor = "I")
    public static int nameIconsGroup;

    @OriginalMember(owner = "client!dja", name = "d", descriptor = "I")
    public static int floorshadowsGroup;

    @OriginalMember(owner = "client!vda", name = "O", descriptor = "I")
    public static int compassGroup;

    @OriginalMember(owner = "client!iw", name = "b", descriptor = "I")
    public static int otherlevelGroup;

    @OriginalMember(owner = "client!vb", name = "x", descriptor = "I")
    public static int hintMapedgeGroup;

    @OriginalMember(owner = "client!dma", name = "m", descriptor = "[Lclient!st;")
    public static Sprite[] hitbarDefault;

    @OriginalMember(owner = "client!bca", name = "f", descriptor = "[Lclient!st;")
    public static Sprite[] timerbarDefault;

    @OriginalMember(owner = "client!nu", name = "d", descriptor = "[Lclient!st;")
    public static Sprite[] headiconsPk;

    @OriginalMember(owner = "client!pj", name = "a", descriptor = "[Lclient!st;")
    public static Sprite[] headiconsPrayer;

    @OriginalMember(owner = "client!aw", name = "a", descriptor = "[Lclient!st;")
    public static Sprite[] hintHeadicons;

    @OriginalMember(owner = "client!fh", name = "h", descriptor = "[Lclient!st;")
    public static Sprite[] hintMapmarkers;

    @OriginalMember(owner = "client!vs", name = "p", descriptor = "[Lclient!st;")
    public static Sprite[] mapflag;

    @OriginalMember(owner = "client!lda", name = "q", descriptor = "[Lclient!st;")
    public static Sprite[] cross;

    @OriginalMember(owner = "client!ot", name = "O", descriptor = "[Lclient!st;")
    public static Sprite[] mapdots;

    @OriginalMember(owner = "client!je", name = "g", descriptor = "[Lclient!st;")
    public static Sprite[] scrollbar;

    @OriginalMember(owner = "client!vj", name = "n", descriptor = "[Lclient!st;")
    public static Sprite[] nameIcons;

    @OriginalMember(owner = "client!ah", name = "e", descriptor = "Lclient!st;")
    public static Sprite compass;

    @OriginalMember(owner = "client!qea", name = "h", descriptor = "Lclient!st;")
    public static Sprite otherlevel;

    @OriginalMember(owner = "client!rk", name = "v", descriptor = "[Lclient!st;")
    public static Sprite[] hintMapedge;

    @OriginalMember(owner = "client!hha", name = "a", descriptor = "(BLclient!sb;Lclient!ha;)V")
    public static void init(@OriginalArg(1) js5 sprites, @OriginalArg(2) Toolkit toolkit) {
        @Pc(8) IndexedImage[] image = IndexedImage.load(sprites, hitbarDefaultGroup, 0);
        hitbarDefault = new Sprite[image.length];
        for (@Pc(14) int i = 0; i < image.length; i++) {
            hitbarDefault[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, timerbarDefaultGroup, 0);
        timerbarDefault = new Sprite[image.length];
        for (@Pc(44) int i = 0; i < image.length; i++) {
            timerbarDefault[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, headiconsPkGroup, 0);
        headiconsPk = new Sprite[image.length];
        for (@Pc(74) int i = 0; i < image.length; i++) {
            headiconsPk[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, headiconsPrayerGroup, 0);
        headiconsPrayer = new Sprite[image.length];
        for (@Pc(112) int i = 0; i < image.length; i++) {
            headiconsPrayer[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, hintHeadiconsGroup, 0);
        hintHeadicons = new Sprite[image.length];
        for (@Pc(138) int i = 0; i < image.length; i++) {
            hintHeadicons[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, hintMapmarkersGroup, 0);
        hintMapmarkers = new Sprite[image.length];
        for (@Pc(168) int i = 0; i < image.length; i++) {
            hintMapmarkers[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, mapflagGroup, 0);
        mapflag = new Sprite[image.length];
        for (@Pc(198) int i = 0; i < image.length; i++) {
            mapflag[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, crossGroup, 0);
        cross = new Sprite[image.length];
        for (@Pc(228) int i = 0; i < image.length; i++) {
            cross[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, mapdotsGroup, 0);
        mapdots = new Sprite[image.length];
        for (@Pc(258) int i = 0; i < image.length; i++) {
            mapdots[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, scrollbarGroup, 0);
        scrollbar = new Sprite[image.length];
        for (@Pc(284) int i = 0; i < image.length; i++) {
            scrollbar[i] = toolkit.createSprite(image[i], true);
        }

        image = IndexedImage.load(sprites, nameIconsGroup, 0);
        nameIcons = new Sprite[image.length];
        for (@Pc(310) int i = 0; i < image.length; i++) {
            nameIcons[i] = toolkit.createSprite(image[i], true);
        }

        compass = toolkit.createSprite(IndexedImage.loadFirst(sprites, compassGroup, 0), true);
        otherlevel = toolkit.createSprite(IndexedImage.loadFirst(sprites, otherlevelGroup, 0), true);

        image = IndexedImage.load(sprites, hintMapedgeGroup, 0);
        hintMapedge = new Sprite[image.length];
        for (@Pc(352) int i = 0; i < image.length; i++) {
            hintMapedge[i] = toolkit.createSprite(image[i], true);
        }
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void getJs5Indexes(@OriginalArg(0) js5 sprites) {
        hitbarDefaultGroup = sprites.getgroupid("hitbar_default");
        timerbarDefaultGroup = sprites.getgroupid("timerbar_default");
        headiconsPkGroup = sprites.getgroupid("headicons_pk");
        headiconsPrayerGroup = sprites.getgroupid("headicons_prayer");
        hintHeadiconsGroup = sprites.getgroupid("hint_headicons");
        hintMapmarkersGroup = sprites.getgroupid("hint_mapmarkers");
        mapflagGroup = sprites.getgroupid("mapflag");
        crossGroup = sprites.getgroupid("cross");
        mapdotsGroup = sprites.getgroupid("mapdots");
        scrollbarGroup = sprites.getgroupid("scrollbar");
        nameIconsGroup = sprites.getgroupid("name_icons");
        floorshadowsGroup = sprites.getgroupid("floorshadows");
        compassGroup = sprites.getgroupid("compass");
        otherlevelGroup = sprites.getgroupid("otherlevel");
        hintMapedgeGroup = sprites.getgroupid("hint_mapedge");
    }

    @OriginalMember(owner = "client!fq", name = "a", descriptor = "(ILclient!sb;)I")
    public static int readyCount(@OriginalArg(1) js5 sprites) {
        @Pc(5) int count = 0;
        if (sprites.fileready(hitbarDefaultGroup)) {
            count++;
        }
        if (sprites.fileready(timerbarDefaultGroup)) {
            count++;
        }
        if (sprites.fileready(headiconsPkGroup)) {
            count++;
        }
        if (sprites.fileready(headiconsPrayerGroup)) {
            count++;
        }
        if (sprites.fileready(hintHeadiconsGroup)) {
            count++;
        }
        if (sprites.fileready(hintMapmarkersGroup)) {
            count++;
        }
        if (sprites.fileready(mapflagGroup)) {
            count++;
        }
        if (sprites.fileready(crossGroup)) {
            count++;
        }
        if (sprites.fileready(mapdotsGroup)) {
            count++;
        }
        if (sprites.fileready(scrollbarGroup)) {
            count++;
        }
        if (sprites.fileready(nameIconsGroup)) {
            count++;
        }
        if (sprites.fileready(floorshadowsGroup)) {
            count++;
        }
        if (sprites.fileready(compassGroup)) {
            count++;
        }
        if (sprites.fileready(otherlevelGroup)) {
            count++;
        }
        if (sprites.fileready(hintMapedgeGroup)) {
            count++;
        }
        return count;
    }

    @OriginalMember(owner = "client!vp", name = "e", descriptor = "(B)I")
    public static int totalCount() {
        return 15;
    }
}
