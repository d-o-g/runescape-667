package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lga")
public final class ServerProt {

    @OriginalMember(owner = "client!wc", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt MIDI_JINGLE = new ServerProt(0, 6);

    @OriginalMember(owner = "client!ik", name = "u", descriptor = "Lclient!lga;")
    public static final ServerProt SET_PLAYER_OP = new ServerProt(1, -1);

    @OriginalMember(owner = "client!le", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETGRAPHIC = new ServerProt(2, 6);

    @OriginalMember(owner = "client!es", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETEVENTS = new ServerProt(3, 12);

    @OriginalMember(owner = "client!lm", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt TRIGGER_ONDIALOGABORT = new ServerProt(4, 0);

    @OriginalMember(owner = "client!dp", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt IF_OPENSUB = new ServerProt(5, 7);

    @OriginalMember(owner = "client!iha", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt NPC_INFO = new ServerProt(6, -2);

    @OriginalMember(owner = "client!maa", name = "u", descriptor = "Lclient!lga;")
    public static final ServerProt CLANCHANNEL_FULL = new ServerProt(7, -2);

    @OriginalMember(owner = "client!ph", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETSCROLLPOS = new ServerProt(8, 6);

    @OriginalMember(owner = "client!jka", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETOBJECT = new ServerProt(9, 10);

    @OriginalMember(owner = "client!fw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_RESET = new ServerProt(10, 0);

    @OriginalMember(owner = "client!ef", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_PREFETCH = new ServerProt(11, 3);

    @OriginalMember(owner = "client!oe", name = "ib", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_FRIENDCHAT_CHANNEL_FULL = new ServerProt(12, -2);

    @OriginalMember(owner = "client!ve", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_RUNENERGY = new ServerProt(13, 1);

    @OriginalMember(owner = "client!fi", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_SMALL = new ServerProt(14, 3);

    @OriginalMember(owner = "client!bfa", name = "o", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_SMOOTH_RESET = new ServerProt(15, 0);

    @OriginalMember(owner = "client!pt", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt OBJ_DEL = new ServerProt(16, 3);

    @OriginalMember(owner = "client!pd", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_CLEAR = new ServerProt(17, 0);

    @OriginalMember(owner = "client!un", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETPLAYERMODEL_SELF = new ServerProt(18, 4);

    @OriginalMember(owner = "client!jaa", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt SEND_PING = new ServerProt(19, 8);

    @OriginalMember(owner = "client!nu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_QUICKCHAT_FRIENDCHAT = new ServerProt(20, -1);

    @OriginalMember(owner = "client!ue", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_SITESETTINGS = new ServerProt(21, -1);

    @OriginalMember(owner = "client!fa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETTARGETPARAM = new ServerProt(22, 10);

    @OriginalMember(owner = "client!gh", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETANIM = new ServerProt(23, 6);

    @OriginalMember(owner = "client!ef", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER = new ServerProt(24, -1);

    @OriginalMember(owner = "client!ska", name = "P", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_TICK_END = new ServerProt(25, 0);

    @OriginalMember(owner = "client!bb", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_ZONE_FULL_FOLLOWS = new ServerProt(26, 3);

    @OriginalMember(owner = "client!jw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt RESET_ANIMS = new ServerProt(27, 0);

    @OriginalMember(owner = "client!client", name = "tb", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_ADD_CHANGE = new ServerProt(28, 4);

    @OriginalMember(owner = "client!vda", name = "Q", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_MOVETO = new ServerProt(29, 6);

    @OriginalMember(owner = "client!lca", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt CLANSETTINGS_DELTA = new ServerProt(30, -2);

    @OriginalMember(owner = "client!tc", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt MIDI_SONG = new ServerProt(31, 4);

    @OriginalMember(owner = "client!iw", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt TEXT_COORD = new ServerProt(32, -1);

    @OriginalMember(owner = "client!dh", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETTEXT = new ServerProt(33, -2);

    @OriginalMember(owner = "client!hd", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_SHAKE = new ServerProt(34, 6);

    @OriginalMember(owner = "client!gh", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt SOUND_MIXBUSS_SETLEVEL = new ServerProt(35, 2);

    @OriginalMember(owner = "client!ki", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt JCOINS_UPDATE = new ServerProt(36, 4);

    @OriginalMember(owner = "client!dc", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_INV_FULL = new ServerProt(37, -2);

    @OriginalMember(owner = "client!hda", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_INIT = new ServerProt(38, 0);

    @OriginalMember(owner = "client!bfa", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_LARGE = new ServerProt(39, 6);

    @OriginalMember(owner = "client!tia", name = "L", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_FRIENDCHANNEL = new ServerProt(40, -1);

    @OriginalMember(owner = "client!fca", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt MAP_ANIM = new ServerProt(41, 7);

    @OriginalMember(owner = "client!o", name = "O", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_QUICKCHAT_PRIVATE = new ServerProt(42, -1);

    @OriginalMember(owner = "client!uja", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt REBUILD_NORMAL = new ServerProt(43, -2);

    @OriginalMember(owner = "client!oea", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETPLAYERHEAD_IGNOREWORN = new ServerProt(44, 10);

    @OriginalMember(owner = "client!ol", name = "J", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_DEL = new ServerProt(45, 2);

    @OriginalMember(owner = "client!eu", name = "bb", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_ZONE_PARTIAL_FOLLOWS = new ServerProt(46, 3);

    @OriginalMember(owner = "client!ku", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_ANIM = new ServerProt(47, 4);

    @OriginalMember(owner = "client!aka", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt OBJ_ADD = new ServerProt(48, 5);

    @OriginalMember(owner = "client!pc", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt SHOW_FACE_HERE = new ServerProt(49, 1);

    @OriginalMember(owner = "client!ma", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt RUNCLIENTSCRIPT = new ServerProt(50, -2);

    @OriginalMember(owner = "client!ah", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt LOGOUT_FULL = new ServerProt(51, 0);

    @OriginalMember(owner = "client!as", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_INT = new ServerProt(52, 6);

    @OriginalMember(owner = "client!mda", name = "z", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_STRING = new ServerProt(53, -1);

    @OriginalMember(owner = "client!bma", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt CLIENT_SETVARCSTR_SMALL = new ServerProt(54, -1);

    @OriginalMember(owner = "client!gm", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt SET_MAP_FLAG = new ServerProt(55, 2);

    @OriginalMember(owner = "client!jq", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_UID192 = new ServerProt(56, 28);

    @OriginalMember(owner = "client!gw", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_IGNORELIST = new ServerProt(57, -2);

    @OriginalMember(owner = "client!nca", name = "s", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETMODEL = new ServerProt(58, 6);

    @OriginalMember(owner = "client!nka", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt LOGOUT = new ServerProt(59, 0);

    @OriginalMember(owner = "client!dt", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt OBJ_REVEAL = new ServerProt(60, 7);

    @OriginalMember(owner = "client!rja", name = "G", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_STOCKMARKET_SLOT = new ServerProt(61, 20);

    @OriginalMember(owner = "client!wt", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt MAP_PROJANIM = new ServerProt(62, 16);

    @OriginalMember(owner = "client!vj", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETCLICKMASK = new ServerProt(63, 5);

    @OriginalMember(owner = "client!ai", name = "K", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_BYTE = new ServerProt(64, 3);

//  by default the client incorrectly allocates 6 bytes here, the decoder attempts to read 8
//    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
//    public static final ServerProt SOUND_AREA = new ServerProt(65,  6);

    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt SOUND_AREA = new ServerProt(65, 8);

    @OriginalMember(owner = "client!jha", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt VARCLAN_LONG = new ServerProt(66, 10);

    @OriginalMember(owner = "client!td", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt IF_OPENTOP = new ServerProt(67, 3);

    @OriginalMember(owner = "client!tk", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt MINIMAP_TOGGLE = new ServerProt(68, 1);

    @OriginalMember(owner = "client!cr", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt PLAYER_INFO = new ServerProt(69, -2);

    @OriginalMember(owner = "client!bda", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt REFLECTION_CHECKER = new ServerProt(70, -2);

    @OriginalMember(owner = "client!kja", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt VIDEO_STOP = new ServerProt(71, 2);

    @OriginalMember(owner = "client!hn", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt CHAT_FILTER_SETTINGS = new ServerProt(72, 2);

    @OriginalMember(owner = "client!sha", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt IF_CLOSESUB = new ServerProt(73, 4);

    @OriginalMember(owner = "client!bfa", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt NPC_ANIM_SPECIFIC = new ServerProt(74, 11);

    @OriginalMember(owner = "client!dt", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_INV_STOP_TRANSMIT = new ServerProt(75, 3);

    @OriginalMember(owner = "client!cm", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETRETEX = new ServerProt(76, 9);

    @OriginalMember(owner = "client!op", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_PRIVATE_ECHO = new ServerProt(77, -2);

    @OriginalMember(owner = "client!qk", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt VORBIS_SOUND = new ServerProt(78, 8);

    @OriginalMember(owner = "client!hc", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt CLANCHANNEL_DELTA = new ServerProt(79, -2);

    @OriginalMember(owner = "client!qk", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_INV_PARTIAL = new ServerProt(80, -2);

    @OriginalMember(owner = "client!tja", name = "z", descriptor = "Lclient!lga;")
    public static final ServerProt HINT_ARROW = new ServerProt(81, 12);

    @OriginalMember(owner = "client!sia", name = "w", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETCOLOUR = new ServerProt(82, 6);

    @OriginalMember(owner = "client!gj", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt OBJ_COUNT = new ServerProt(83, 7);

    @OriginalMember(owner = "client!gg", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_LARGE = new ServerProt(84, 6);

    @OriginalMember(owner = "client!kc", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_FRIENDLIST = new ServerProt(85, -2);

    @OriginalMember(owner = "client!it", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt RESET_CLIENT_VARCACHE = new ServerProt(86, 0);

    @OriginalMember(owner = "client!oaa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_ZONE_PARTIAL_ENCLOSED = new ServerProt(87, -2);

    @OriginalMember(owner = "client!vp", name = "B", descriptor = "Lclient!lga;")
    public static final ServerProt WORLDLIST_FETCH_REPLY = new ServerProt(88, -2);

    @OriginalMember(owner = "client!u", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt SET_MOVEACTION = new ServerProt(89, -1);

    @OriginalMember(owner = "client!ed", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt MAP_PROJANIM_HALFSQ = new ServerProt(90, 17);

    @OriginalMember(owner = "client!ec", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_PUBLIC = new ServerProt(91, -1);

    @OriginalMember(owner = "client!kr", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_PROT_92 = new ServerProt(92, 4);

    @OriginalMember(owner = "client!uba", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_STAT = new ServerProt(93, 6);

    @OriginalMember(owner = "client!tu", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt LOGOUT_TRANSFER = new ServerProt(94, -1);

    @OriginalMember(owner = "client!iw", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETTEXTFONT = new ServerProt(95, 6);

    @OriginalMember(owner = "client!bg", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_ANIM_SPECIFIC = new ServerProt(96, 7);

    @OriginalMember(owner = "client!cn", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_QUICKCHAT_PRIVATE_ECHO = new ServerProt(97, -1);

    @OriginalMember(owner = "client!af", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETNPCHEAD = new ServerProt(98, 6);

    @OriginalMember(owner = "client!rv", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt LOC_CUSTOMISE = new ServerProt(99, -1);

    @OriginalMember(owner = "client!rq", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_PROT_100 = new ServerProt(100, 1);

    @OriginalMember(owner = "client!bja", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_SMALL = new ServerProt(101, 3);

    @OriginalMember(owner = "client!ms", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_GAME = new ServerProt(102, -1);

    @OriginalMember(owner = "client!pi", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_RUNWEIGHT = new ServerProt(103, 2);

    @OriginalMember(owner = "client!rb", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETPOSITION = new ServerProt(104, 8);

    @OriginalMember(owner = "client!wfa", name = "Q", descriptor = "Lclient!lga;")
    public static final ServerProt IGNORELIST_ADD = new ServerProt(105, -1);

    @OriginalMember(owner = "client!al", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt SYNTH_SOUND = new ServerProt(106, 8);

    @OriginalMember(owner = "client!wg", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_FORCEANGLE = new ServerProt(107, 4);

    @OriginalMember(owner = "client!tba", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt SPOTANIM_SPECIFIC = new ServerProt(108, 12);

    @OriginalMember(owner = "client!ifa", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETPLAYERMODEL_OTHER = new ServerProt(109, 10);

    @OriginalMember(owner = "client!oia", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt DEBUG_SERVER_TRIGGERS = new ServerProt(110, -1);

    @OriginalMember(owner = "client!tj", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt CLIENT_SETVARC_SMALL = new ServerProt(111, 3);

    @OriginalMember(owner = "client!jt", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt CLIENT_SETVARC_LARGE = new ServerProt(112, 6);

    @OriginalMember(owner = "client!gha", name = "w", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_PROT_113 = new ServerProt(113, 3);

    @OriginalMember(owner = "client!qp", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETPLAYERHEAD = new ServerProt(114, 4);

    @OriginalMember(owner = "client!he", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_PROT_115 = new ServerProt(115, 8);

    @OriginalMember(owner = "client!rf", name = "t", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_QUICKCHAT_PLAYER_GROUP = new ServerProt(116, -1);

    @OriginalMember(owner = "client!uu", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETHIDE = new ServerProt(117, 5);

    @OriginalMember(owner = "client!ki", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt CLANSETTINGS_FULL = new ServerProt(118, -2);

    @OriginalMember(owner = "client!ss", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt SOUND_VORBIS_AREA = new ServerProt(119, 6);

    @OriginalMember(owner = "client!va", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_PRIVATE = new ServerProt(120, -2);

    @OriginalMember(owner = "client!md", name = "F", descriptor = "Lclient!lga;")
    public static final ServerProt VORBIS_SPEECH_SOUND = new ServerProt(121, 6);

    @OriginalMember(owner = "client!ws", name = "J", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETANGLE = new ServerProt(122, 10);

    @OriginalMember(owner = "client!nia", name = "o", descriptor = "Lclient!lga;")
    public static final ServerProt SETDRAWORDER = new ServerProt(123, 1);

    @OriginalMember(owner = "client!kt", name = "S", descriptor = "Lclient!lga;")
    public static final ServerProt REDUCE_ATTACK_PRIORITY = new ServerProt(124, 1);

    @OriginalMember(owner = "client!cf", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_REBOOT_TIMER = new ServerProt(125, 2);

    @OriginalMember(owner = "client!mm", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt UPDATE_DOB = new ServerProt(126, 4);

    @OriginalMember(owner = "client!ro", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_LOOKAT = new ServerProt(127, 6);

    @OriginalMember(owner = "client!je", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt REBUILD_REGION = new ServerProt(128, -2);

    @OriginalMember(owner = "client!va", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt CHANGE_LOBBY = new ServerProt(129, 4);

    @OriginalMember(owner = "client!mu", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETRECOL = new ServerProt(130, 9);

    @OriginalMember(owner = "client!gv", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_QUICKCHAT_CLANCHANNEL = new ServerProt(131, -1);

    @OriginalMember(owner = "client!bfa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt CUTSCENE = new ServerProt(132, -2);

    @OriginalMember(owner = "client!wo", name = "E", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_PLAYER_GROUP = new ServerProt(133, -1);

    @OriginalMember(owner = "client!jm", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt CHAT_FILTER_SETTINGS_PRIVATECHAT = new ServerProt(134, 1);

    @OriginalMember(owner = "client!mv", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt FRIENDLIST_LOADED = new ServerProt(135, 0);

    @OriginalMember(owner = "client!ge", name = "Ab", descriptor = "Lclient!lga;")
    public static final ServerProt IF_SETVIDEO = new ServerProt(136, 6);

    @OriginalMember(owner = "client!dma", name = "k", descriptor = "Lclient!lga;")
    public static final ServerProt IF_MOVESUB = new ServerProt(137, 8);

    @OriginalMember(owner = "client!ifa", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_CLANCHANNEL = new ServerProt(138, -1);

    @OriginalMember(owner = "client!vt", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt URL_OPEN = new ServerProt(139, -2);

    @OriginalMember(owner = "client!ofa", name = "s", descriptor = "Lclient!lga;")
    public static final ServerProt CLIENT_SETVARCSTR_LARGE = new ServerProt(140, -2);

    @OriginalMember(owner = "client!tja", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt SERVER_PROT_141 = new ServerProt(141, 2);

    @OriginalMember(owner = "client!pi", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt VORBIS_SPEECH_STOP = new ServerProt(142, 0);

    @OriginalMember(owner = "client!ija", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt JAVASCRIPT_RUN = new ServerProt(143, -2);

    @OriginalMember(owner = "client!gla", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt LOYALTY_UPDATE = new ServerProt(144, 5);


    @OriginalMember(owner = "client!sh", name = "b", descriptor = "(B)[Lclient!lga;")
    public static ServerProt[] values() {
        return new ServerProt[]{
            MIDI_JINGLE,
            SET_PLAYER_OP,
            IF_SETGRAPHIC,
            IF_SETEVENTS,
            TRIGGER_ONDIALOGABORT,
            IF_OPENSUB,
            NPC_INFO,
            CLANCHANNEL_FULL,
            IF_SETSCROLLPOS,
            IF_SETOBJECT,
            CAM_RESET,
            LOC_PREFETCH,
            UPDATE_FRIENDCHAT_CHANNEL_FULL,
            UPDATE_RUNENERGY,
            VARBIT_SMALL,
            CAM_SMOOTH_RESET,
            OBJ_DEL,
            VARCLAN_CLEAR,
            IF_SETPLAYERMODEL_SELF,
            SEND_PING,
            MESSAGE_QUICKCHAT_FRIENDCHAT,
            UPDATE_SITESETTINGS,
            IF_SETTARGETPARAM,
            IF_SETANIM,
            UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER,
            SERVER_TICK_END,
            UPDATE_ZONE_FULL_FOLLOWS,
            RESET_ANIMS,
            LOC_ADD_CHANGE,
            CAM_MOVETO,
            CLANSETTINGS_DELTA,
            MIDI_SONG,
            TEXT_COORD,
            IF_SETTEXT,
            CAM_SHAKE,
            SOUND_MIXBUSS_SETLEVEL,
            JCOINS_UPDATE,
            UPDATE_INV_FULL,
            VARCLAN_INIT,
            VARP_LARGE,
            MESSAGE_FRIENDCHANNEL,
            MAP_ANIM,
            MESSAGE_QUICKCHAT_PRIVATE,
            REBUILD_NORMAL,
            IF_SETPLAYERHEAD_IGNOREWORN,
            LOC_DEL,
            UPDATE_ZONE_PARTIAL_FOLLOWS,
            LOC_ANIM,
            OBJ_ADD,
            SHOW_FACE_HERE,
            RUNCLIENTSCRIPT,
            LOGOUT_FULL,
            VARCLAN_INT,
            VARCLAN_STRING,
            CLIENT_SETVARCSTR_SMALL,
            SET_MAP_FLAG,
            UPDATE_UID192,
            UPDATE_IGNORELIST,
            IF_SETMODEL,
            LOGOUT,
            OBJ_REVEAL,
            UPDATE_STOCKMARKET_SLOT,
            MAP_PROJANIM,
            IF_SETCLICKMASK,
            VARCLAN_BYTE,
            SOUND_AREA,
            VARCLAN_LONG,
            IF_OPENTOP,
            MINIMAP_TOGGLE,
            PLAYER_INFO,
            REFLECTION_CHECKER,
            VIDEO_STOP,
            CHAT_FILTER_SETTINGS,
            IF_CLOSESUB,
            NPC_ANIM_SPECIFIC,
            UPDATE_INV_STOP_TRANSMIT,
            IF_SETRETEX,
            MESSAGE_PRIVATE_ECHO,
            VORBIS_SOUND,
            CLANCHANNEL_DELTA,
            UPDATE_INV_PARTIAL,
            HINT_ARROW,
            IF_SETCOLOUR,
            OBJ_COUNT,
            VARBIT_LARGE,
            UPDATE_FRIENDLIST,
            RESET_CLIENT_VARCACHE,
            UPDATE_ZONE_PARTIAL_ENCLOSED,
            WORLDLIST_FETCH_REPLY,
            SET_MOVEACTION,
            MAP_PROJANIM_HALFSQ,
            MESSAGE_PUBLIC,
            SERVER_PROT_92,
            UPDATE_STAT,
            LOGOUT_TRANSFER,
            IF_SETTEXTFONT,
            LOC_ANIM_SPECIFIC,
            MESSAGE_QUICKCHAT_PRIVATE_ECHO,
            IF_SETNPCHEAD,
            LOC_CUSTOMISE,
            SERVER_PROT_100,
            VARP_SMALL,
            MESSAGE_GAME,
            UPDATE_RUNWEIGHT,
            IF_SETPOSITION,
            IGNORELIST_ADD,
            SYNTH_SOUND,
            CAM_FORCEANGLE,
            SPOTANIM_SPECIFIC,
            IF_SETPLAYERMODEL_OTHER,
            DEBUG_SERVER_TRIGGERS,
            CLIENT_SETVARC_SMALL,
            CLIENT_SETVARC_LARGE,
            SERVER_PROT_113,
            IF_SETPLAYERHEAD,
            SERVER_PROT_115,
            MESSAGE_QUICKCHAT_PLAYER_GROUP,
            IF_SETHIDE,
            CLANSETTINGS_FULL,
            SOUND_VORBIS_AREA,
            MESSAGE_PRIVATE,
            VORBIS_SPEECH_SOUND,
            IF_SETANGLE,
            SETDRAWORDER,
            REDUCE_ATTACK_PRIORITY,
            UPDATE_REBOOT_TIMER,
            UPDATE_DOB,
            CAM_LOOKAT,
            REBUILD_REGION,
            CHANGE_LOBBY,
            IF_SETRECOL,
            MESSAGE_QUICKCHAT_CLANCHANNEL,
            CUTSCENE,
            MESSAGE_PLAYER_GROUP,
            CHAT_FILTER_SETTINGS_PRIVATECHAT,
            FRIENDLIST_LOADED,
            IF_SETVIDEO,
            IF_MOVESUB,
            MESSAGE_CLANCHANNEL,
            URL_OPEN,
            CLIENT_SETVARCSTR_LARGE,
            SERVER_PROT_141,
            VORBIS_SPEECH_STOP,
            JAVASCRIPT_RUN,
            LOYALTY_UPDATE
        };
    }

    @OriginalMember(owner = "client!lga", name = "e", descriptor = "I")
    public final int opcode;

    @OriginalMember(owner = "client!lga", name = "b", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!lga", name = "<init>", descriptor = "(II)V")
    public ServerProt(@OriginalArg(0) int opcode, @OriginalArg(1) int size) {
        this.opcode = opcode;
        this.size = size;
    }

    @OriginalMember(owner = "client!lga", name = "b", descriptor = "(I)I")
    public int getOpcode() {
        return this.opcode;
    }

    @OriginalMember(owner = "client!lga", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
