package com.jagex.core.constants;

public final class ClientScriptOpCode {

    public static final int CC_CREATE = 150;

    public static final int CC_DELETE = 151;

    public static final int CC_DELETEALL = 152;

    public static final int CC_FIND = 200;

    public static final int IF_FIND = 201;

    public static final int IF_SENDTOFRONT = 202;

    public static final int CC_SENDTOFRONT = 204;

    public static final int IF_SENDTOBACK = 203;

    public static final int CC_SENDTOBACK = 205;

    public static final int BASEIDKIT = 403;

    public static final int BASECOLOUR = 404;

    public static final int SETGENDER = 410;

    public static final int SETOBJ = 411;

    public static final int CC_IF_SETPOSITION = 1000;

    public static final int CC_IF_SETSIZE = 1001;

    public static final int CC_IF_SETHIDE = 1003;

    public static final int CC_IF_SETASPECT = 1004;

    public static final int CC_IF_SETNOCLICKTHROUGH = 1005;

    public static final int CC_IF_SETSCROLLPOS = 1100;

    public static final int CC_IF_SETCOLOUR = 1101;

    public static final int CC_IF_SETFILL = 1102;

    public static final int CC_IF_SETTTRANS = 1103;

    public static final int CC_IF_SETLINEWID = 1104;

    public static final int CC_IF_SETGRAPHIC = 1105;

    public static final int CC_IF_SET2DANGLE = 1106;

    public static final int CC_IF_SETTILING = 1107;

    public static final int CC_IF_SETMODEL = 1108;

    public static final int CC_IF_SETMODELANGLE = 1109;

    public static final int CC_IF_SETMODELANIM = 1110;

    public static final int CC_IF_SETMODELORTHOG = 1111;

    public static final int CC_IF_SETTEXT = 1112;

    public static final int CC_IF_SETTEXTFONT = 1113;

    public static final int CC_IF_SETTEXTALIGN = 1114;

    public static final int CC_IF_SETTEXTSHADOW = 1115;

    public static final int CC_IF_SETOUTLINE = 1116;

    public static final int CC_IF_SETGRAPHICSHADOW = 1117;

    public static final int CC_IF_SETHFLIP = 1118;

    public static final int CC_IF_SETVFLIP = 1119;

    public static final int CC_IF_SETSCROLLSIZE = 1120;

    public static final int CC_IF_SETALPHA = 1122;

    public static final int CC_IF_SETMODELZOOM = 1123;

    public static final int CC_IF_SETLINEDIRECTION = 1124;

    public static final int CC_IF_SETMODELORIGIN = 1125;

    public static final int CC_IF_SETMAXLINES = 1126;

    public static final int CC_IF_SETPARAM_INT = 1127;

    public static final int CC_IF_SETPARAM_STRING = 1128;

    public static final int CC_IF_SETRECOL = 1131;

    public static final int CC_IF_SETRETEX = 1132;

    public static final int CC_IF_SETFONTMONO = 1133;

    public static final int CC_IF_SETPARAM = 1134;

    public static final int CC_IF_SETCLICKMASK = 1135;

    public static final int CC_IF_SETOBJECT = 1200;

    public static final int CC_IF_SETOBJECT_NONUM = 1205;

    public static final int CC_IF_SETOBJECT_WEARCOL = 1208;

    public static final int CC_IF_SETOBJECT_WEARCOL_NONUM = 1209;

    public static final int CC_IF_SETOBJECT_ALWAYSNUM = 1212;

    public static final int CC_IF_SETOBJECT_WEARCOL_ALWAYSNUM = 1213;

    public static final int CC_IF_SETNPCHEAD = 1201;

    public static final int CC_IF_SETPLAYERHEAD_SELF = 1202;

    public static final int CC_IF_SETNPCMODEL = 1203;

    public static final int CC_IF_SETPLAYERMODEL = 1204;

    public static final int CC_IF_SETOBJECT_DATA = 1210;

    public static final int CC_IF_SETPLAYERMODEL_SELF = 1211;

    public static final int CC_IF_SETOP = 1300;

    public static final int CC_IF_SETDRAGGABLE = 1301;

    public static final int CC_IF_SETDRAGRENDERBEHAVIOUR = 1302;

    public static final int CC_IF_SETDRAGDEADZONE = 1303;

    public static final int CC_IF_SETDRAGDEADTIME = 1304;

    public static final int CC_IF_SETOPBASE = 1305;

    public static final int CC_IF_SETTARGETVERB = 1306;

    public static final int CC_IF_CLEAROPS = 1307;

    public static final int CC_IF_SETTARGETCURSORS = 1308;

    public static final int CC_IF_SETOPCURSOR = 1309;

    public static final int CC_IF_SETPAUSETEXT = 1310;

    public static final int CC_IF_SETTARGETOPCURSOR = 1311;

    public static final int CC_IF_SETOPCHAR = 1312;

    public static final int CC_IF_SETOPKEY = 1313;

    public static final int CC_IF_SETMOUSEOVERCURSOR = 1314;

    public static final int CC_IF_CLEARSCRIPTHOOKS = 1499;

    public static final int CC_IF_SETONCLICK = 1400;

    public static final int CC_IF_SETONHOLD = 1401;

    public static final int CC_IF_SETONRELEASE = 1402;

    public static final int CC_IF_SETONMOUSEOVER = 1403;

    public static final int CC_IF_SETONMOUSELEAVE = 1404;

    public static final int CC_IF_SETONDRAG = 1405;

    public static final int CC_IF_SETONTARGETLEAVE = 1406;

    public static final int CC_IF_SETONVARTRANSMIT = 1407;

    public static final int CC_IF_SETONTIMER = 1408;

    public static final int CC_IF_SETONOP = 1409;

    public static final int CC_IF_SETONDRAGCOMPLETE = 1410;

    public static final int CC_IF_SETONCLICKREPEAT = 1411;

    public static final int CC_IF_SETONMOUSEREPEAT = 1412;

    public static final int CC_IF_SETONINVTRANSMIT = 1414;

    public static final int CC_IF_SETONSTATTRANSMIT = 1415;

    public static final int CC_IF_SETONTARGETENTER = 1416;

    public static final int CC_IF_SETONSCROLLWHEEL = 1417;

    public static final int CC_IF_SETONCHATTRANSMIT = 1418;

    public static final int CC_IF_SETONKEY = 1419;

    public static final int CC_IF_SETONFRIENDTRANSMIT = 1420;

    public static final int CC_IF_SETONCLANTRANSMIT = 1421;

    public static final int CC_IF_SETONMISCTRANSMIT = 1422;

    public static final int CC_IF_SETONDIALOGABORT = 1423;

    public static final int CC_IF_SETONSUBCHANGE = 1424;

    public static final int CC_IF_SETONSTOCKTRANSMIT = 1425;

    public static final int CC_IF_SETONCAMFINISHED = 1426;

    public static final int CC_IF_SETONRESIZE = 1427;

    public static final int CC_IF_SETONVARCTRANSMIT = 1428;

    public static final int CC_IF_SETONVARCSTRTRANSMIT = 1429;

    public static final int CC_IF_SETONOPT = 1430;

    public static final int CC_IF_SETONCLANSETTINGSTRANSMIT = 1431;

    public static final int CC_IF_SETONCLANCHANNELTRANSMIT = 1432;

    public static final int CC_IF_SETONVARCLANTRANSMIT = 1433;

    public static final int CC_GETX = 1500;

    public static final int CC_GETY = 1501;

    public static final int CC_GETWIDTH = 1502;

    public static final int CC_GETHEIGHT = 1503;

    public static final int CC_GETHIDE = 1504;

    public static final int CC_GETLAYER = 1505;

    public static final int CC_GETPARENTLAYER = 1506;

    public static final int CC_GETCOLOUR = 1507;

    public static final int CC_GETSCROLLX = 1600;

    public static final int CC_GETSCROLLY = 1601;

    public static final int CC_GETTEXT = 1602;

    public static final int CC_GETSCROLLWIDTH = 1603;

    public static final int CC_GETSCROLLHEIGHT = 1604;

    public static final int CC_GETMODELZOOM = 1605;

    public static final int CC_GETMODELANGLE_X = 1606;

    public static final int CC_GETMODELANGLE_Z = 1607;

    public static final int CC_GETMODELANGLE_Y = 1608;

    public static final int CC_GETTRANS = 1609;

    public static final int CC_GETMODELXOF = 1610;

    public static final int CC_GETMODELYOF = 1611;

    public static final int CC_GETGRAPHIC = 1612;

    public static final int CC_PARAM = 1613;

    public static final int CC_GET2DANGLE = 1614;

    public static final int CC_GETMODEL = 2614;

    public static final int CC_GETFONTGRAPHIC = 1618;

    public static final int CC_GETINVOBJECT = 1700;

    public static final int CC_GETINVCOUNT = 1701;

    public static final int CC_GETID = 1702;

    public static final int CC_GETTARGETMASK = 1800;

    public static final int CC_GETOP = 1801;

    public static final int CC_GETOPBASE = 1802;

    public static final int CC_IF_CALLONRESIZE = 1927;

    public static final int IF_GETX = 2500;

    public static final int IF_GETY = 2501;

    public static final int IF_GETWIDTH = 2502;

    public static final int IF_GETHEIGHT = 2503;

    public static final int IF_GETHIDE = 2504;

    public static final int IF_GETLAYER = 2505;

    public static final int IF_GETPARENTLAYER = 2506;

    public static final int IF_GETCOLOUR = 2507;

    public static final int IF_GETSCROLLX = 2600;

    public static final int IF_GETSCROLLY = 2601;

    public static final int IF_GETTEXT = 2602;

    public static final int IF_GETSCROLLWIDTH = 2603;

    public static final int IF_GETSCROLLHEIGHT = 2604;

    public static final int IF_GETMODELZOOM = 2605;

    public static final int IF_GETMODELANGLE_X = 2606;

    public static final int IF_GETMODELANGLE_Z = 2607;

    public static final int IF_GETMODELANGLE_Y = 2608;

    public static final int IF_GETTRANS = 2609;

    public static final int IF_GETMODELXOF = 2610;

    public static final int IF_GETMODELYOF = 2611;

    public static final int IF_GETGRAPHIC = 2612;

    public static final int IF_GET2DANGLE = 2613;

    public static final int IF_GETMODEL = 2614;

    public static final int IF_GETFONTGRAPHIC = 2617;

    public static final int IF_GETINVOBJECT = 2700;

    public static final int IF_GETINVCOUNT = 2701;

    public static final int IF_HASSUB = 2702;

    public static final int IF_GETNEXTSUBID = 2703;

    public static final int IF_HASSUBMODAL = 2704;

    public static final int IF_HASSUBOVERLAY = 2705;

    public static final int IF_GETTARGETMASK = 2800;

    public static final int IF_GETOP = 2801;

    public static final int IF_GETOPBASE = 2802;

    public static final int MES = 3100;

    public static final int IF_CLOSE = 3103;

    public static final int RESUME_COUNTDIALOG = 3104;

    public static final int RESUME_STRINGDIALOG = 3105;

    public static final int RESUME_NAMEDIALOG = 3106;

    public static final int OPPLAYER = 3107;

    public static final int IF_DRAGPICKUP = 3108;

    public static final int CC_DRAGPICKUP = 3109;

    public static final int RESUME_OBJDIALOG = 3110;

    public static final int IF_OPENSUBCLIENT = 3111;

    public static final int IF_CLOSESUBCLIENT = 3112;

    public static final int OPPLAYERT = 3113;

    public static final int MES_TYPED = 3114;

    public static final int SETUP_MESSAGEBOX = 3115;

    public static final int RESUME_HSLDIALOG = 3116;

    public static final int RESUME_CLANFORUMQFCDIALOG = 3117;

    public static final int SOUND_SYNTH = 3200;

    public static final int SOUND_SONG = 3201;

    public static final int SOUND_JINGLE = 3202;

    public static final int SOUND_SYTHN_VOLUME = 3203;

    public static final int SOUND_SONG_VOLUME = 3204;

    public static final int SOUND_JINGLE_VOLUME = 3205;

    public static final int SOUND_VORBIS_VOLUME = 3206;

    public static final int SOUND_SPEECH_VOLUME = 3207;

    public static final int SOUND_SYNTH_RATE = 3208;

    public static final int SOUND_VORBIS_RATE = 3209;

    public static final int CLIENTCLOCK = 3300;

    public static final int INV_GETOBJ = 3301;

    public static final int INV_GETNUM = 3302;

    public static final int INV_TOTAL = 3303;

    public static final int INV_SIZE = 3304;

    public static final int STAT = 3305;

    public static final int STAT_BASE = 3306;

    public static final int STAT_VISIBLE_XP = 3307;

    public static final int FACING_FINE = 3308;

    public static final int COORDX = 3309;

    public static final int COORDY = 3310;

    public static final int COORDZ = 3311;

    public static final int MAP_MEMBERS = 3312;

    public static final int INVOTHER_GETOBJ = 3313;

    public static final int INVOTHER_GETNUM = 3314;

    public static final int INVOTHER_TOTAL = 3315;

    public static final int STAFFMODLEVEL = 3316;

    public static final int REBOOTTIMER = 3317;

    public static final int MAP_WORLD = 3318;

    public static final int RUNENERGY_VISIBLE = 3321;

    public static final int RUNWEIGHT_VISIBLE = 3322;

    public static final int PLAYERMOD = 3323;

    public static final int PLAYERMODLEVEL = 3324;

    public static final int PLAYERMEMBER = 3325;

    public static final int COMLEVEL_ACTIVE = 3326;

    public static final int GENDER = 3327;

    public static final int MAP_QUICKCHAT = 3329;

    public static final int INV_FREESPACE = 3330;

    public static final int INV_TOTALPARAM = 3331;

    public static final int INV_TOTALPARAM_STACK = 3332;

    public static final int MAP_LANG = 3335;

    public static final int MOVE_COORD = 3336;

    public static final int AFFILIATE = 3337;

    public static final int PROFILE_CPU = 3338;

    public static final int PLAYERDEMO = 3339;

    public static final int APPLET_HASFOCUS = 3340;

    public static final int FROMBILLING = 3341;

    public static final int GET_MOUSEX = 3342;

    public static final int GET_MOUSEY = 3343;

    public static final int GET_ACTIVE_MINIMENU_ENTRY = 3344;

    public static final int GET_SECOND_MINIMENU_ENTRY = 3345;

    public static final int GET_MINIMENU_LENGTH = 3346;

    public static final int GET_CURRENTCURSOR = 3347;

    public static final int GET_SELFYANGLE = 3349;

    public static final int MAP_ISOWNER = 3350;

    public static final int GET_MOUSEBUTTONS = 3351;

    public static final int ENUM_STRING = 3400;

    public static final int ENUM = 3408;

    public static final int ENUM_HASOUTPUT = 3409;

    public static final int ENUM_HASOUTPUT_STRING = 3410;

    public static final int ENUM_GETOUTPUT_COUNT = 3411;

    public static final int ENUM_GETREVERSECOUNT = 3412;

    public static final int ENUM_GETREVERSECOUNT_STRING = 3413;

    public static final int ENUM_GETREVERSEINDEX = 3414;

    public static final int ENUM_GETREVERSEINDEX_STRING = 3415;

    public static final int FRIEND_COUNT = 3600;

    public static final int FRIEND_GETNAME = 3601;

    public static final int FRIEND_GETWORLD = 3602;

    public static final int FRIEND_GETRANK = 3603;

    public static final int FRIEND_SETRANK = 3604;

    public static final int FRIEND_ADD = 3605;

    public static final int FRIEND_DEL = 3606;

    public static final int IGNORE_ADD = 3607;

    public static final int IGNORE_DEL = 3608;

    public static final int FRIEND_TEST = 3609;

    public static final int FRIEND_GETWORLDNAME = 3610;

    public static final int CLAN_GETCHATDISPLAYNAME = 3611;

    public static final int CLAN_GETCHATCOUNT = 3612;

    public static final int CLAN_GETCHATUSERNAME = 3613;

    public static final int CLAN_GETCHATUSERWORLD = 3614;

    public static final int CLAN_GETCHATUSERRANK = 3615;

    public static final int CLAN_GETCHATMINKICK = 3616;

    public static final int CLAN_KICKUSER = 3617;

    public static final int CLAN_GETCHATRANK = 3618;

    public static final int CLAN_JOINCHAT = 3619;

    public static final int CLAN_LEAVECHAT = 3620;

    public static final int IGNORE_COUNT = 3621;

    public static final int IGNORE_GETNAME = 3622;

    public static final int IGNORE_TEXT = 3623;

    public static final int CLAN_ISSELF = 3624;

    public static final int CLAN_GETCHATOWNERNAME = 3625;

    public static final int CLAN_GETCHATUSERWORLDNAME = 3626;

    public static final int FRIEND_SAME_GAME = 3627;

    public static final int FRIEND_GETSLOTFROMNAME = 3628;

    public static final int PLAYERCOUNTRY = 3629;

    public static final int IGNORE_ADD_TEMP = 3630;

    public static final int IGNORE_IS_TEMP = 3631;

    public static final int CLAN_GETCHATUSERNAME_UNFILTERED = 3632;

    public static final int IGNORE_GETNAME_UNFILTERED = 3633;

    public static final int FRIEND_IS_REFERRED = 3634;

    public static final int ACTIVELCANSETTINGS_FIND_LISTENED = 3700;

    public static final int ACTIVECLANSETTINGS_FIND_AFFINED = 3701;

    public static final int ACTIVECLANSETTINGS_GETCLANNAME = 3702;

    public static final int ACTIVECLANSETTINGS_GETALLOWUNAFFINED = 3703;

    public static final int ACTIVECLANSETTINGS_GETRANKTALK = 3704;

    public static final int ACTIVECLANSETTINGS_GETRANKKICK = 3705;

    public static final int ACTIVECLANSETTINGS_GETRANKLOOTSHARE = 3706;

    public static final int ACTIVECLANSETTINGS_GETCOINSHARE = 3707;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDCOUNT = 3709;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDDISPLAYNAME = 3710;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDRANK = 3711;

    public static final int ACTIVECLANSETTINGS_GETBANNEDCOUNT = 3712;

    public static final int ACTIVECLANSETTINGS_GETBANNEDDISPLAYNAME = 3713;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDEXTRAINFO = 3714;

    public static final int ACTIVECLANSETTINGS_GETCURRENTOWNER_SLOT = 3715;

    public static final int ACTIVECLANSETTINGS_GETREPLACEMENTOWNER_SLOT = 3716;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDSLOT = 3717;

    public static final int ACTIVECLANSETTINGS_GETSORTEDAFFINEDSLOT = 3718;

    public static final int AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL = 3719;

    public static final int ACTIVECLANSETTINGS_GETAFFINEDJOINRUNEDAY = 3720;

    public static final int ACTIVECLANCHANNEL_FIND_LISTENED = 3750;

    public static final int ACTIVECLANCHANNEL_FIND_AFFINED = 3751;

    public static final int ACTIVECLANCHANNEL_GETCLANNAME = 3752;

    public static final int ACTIVECLANCHANNEL_GETRANKKICK = 3753;

    public static final int ACTIVECLANCHANNEL_GETRANKTALK = 3754;

    public static final int ACTIVECLANCHANNEL_GETUSERCOUNT = 3755;

    public static final int ACTIVECLANCHANNEL_GETUSERDISPLAYNAME = 3756;

    public static final int ACTIVECLANCHANNEL_GETUSERRANK = 3757;

    public static final int ACTIVECLANCHANNEL_GETUSERWORLD = 3758;

    public static final int ACTIVECLANCHANNEL_KICKUSER = 3759;

    public static final int ACTIVECLANCHANNEL_GETUSERSLOT = 3760;

    public static final int ACTIVECLANCHANNEL_GETSORTEDUSERSLOT = 3761;

    public static final int CLANPROFILE_FIND = 3790;

    public static final int STOCKMARKET_GETOFFERTYPE = 3903;

    public static final int STOCKMARKET_GETOFFERITEM = 3904;

    public static final int STOCKMARKET_GETOFFERPRICE = 3905;

    public static final int STOCKMARKET_GETOFFERCOUNT = 3906;

    public static final int STOCKMARKET_GETOFFERCOMPLETEDCOUNT = 3907;

    public static final int STOCKMARKET_GETOFFERCOMPLETEDGOLD = 3908;

    public static final int STOCKMARKET_ISOFFEREMPTY = 3910;

    public static final int STOCKMARKET_ISOFFERSTABLE = 3911;

    public static final int STOCKMARKET_ISOFFERFINISHED = 3912;

    public static final int STOCKMARKET_ISOFFERADDING = 3913;

    public static final int ADD = 4000;

    public static final int SUB = 4001;

    public static final int MULTIPLY = 4002;

    public static final int DIVIDE = 4003;

    public static final int RANDOM = 4004;

    public static final int RANDOMINC = 4005;

    public static final int INTERPOLATE = 4006;

    public static final int ADDPERCENT = 4007;

    public static final int SETBIT = 4008;

    public static final int CLEARBIT = 4009;

    public static final int TESTBIT = 4010;

    public static final int MODULO = 4011;

    public static final int POW = 4012;

    public static final int INVPOW = 4013;

    public static final int AND = 4014;

    public static final int OR = 4015;

    public static final int MIN = 4016;

    public static final int MAX = 4017;

    public static final int SCALE = 4018;

    public static final int RANDOM_SOUND_PITCH = 4019;

    public static final int HSVTORGB = 4020;

    public static final int APPEND_NUM = 4100;

    public static final int APPEND = 4101;

    public static final int APPEND_SIGNNUM = 4102;

    public static final int LOWERCASE = 4103;

    public static final int FROMDATE = 4104;

    public static final int TEXT_GENDER = 4105;

    public static final int TOSTRING = 4106;

    public static final int COMPARE = 4107;

    public static final int PARAHEIGHT = 4108;

    public static final int PARAWIDTH = 4109;

    public static final int TEXT_SWITCH = 4110;

    public static final int ESCAPE = 4111;

    public static final int APPEND_CHAR = 4112;

    public static final int CHAR_ISPRINTABLE = 4113;

    public static final int CHAR_ISALPHANUMERIC = 4114;

    public static final int CHAR_ISALPHA = 4115;

    public static final int CHAR_ISNUMERIC = 4116;

    public static final int STRING_LENGTH = 4117;

    public static final int SUBSTRING = 4118;

    public static final int REMOVETAGS = 4119;

    public static final int STRING_INDEXOF_CHAR = 4120;

    public static final int STRING_INDEXOF_STRING = 4121;

    public static final int CHAR_TOLOWERCASE = 4122;

    public static final int CHAR_TOUPPERCASE = 4123;

    public static final int TOSTRING_LOCALISED = 4124;

    public static final int STRINGWIDTH = 4125;

    public static final int FORMAT_DATETIME_FROM_MINUTES = 4126;

    public static final int CLANFORUMQFC_TOSTRING = 4127;

    public static final int OC_NAME = 4200;

    public static final int OC_OP = 4201;

    public static final int OC_IOP = 4202;

    public static final int OC_COST = 4203;

    public static final int OC_STACKABLE = 4204;

    public static final int OC_CERT = 4205;

    public static final int OC_UNCERT = 4206;

    public static final int OC_MEMBERS = 4207;

    public static final int OC_PARAM = 4208;

    public static final int OC_ICURSOR = 4209;

    public static final int OC_FIND = 4210;

    public static final int OC_FINDNEXT = 4211;

    public static final int OC_FINDRESTART = 4212;

    public static final int OC_MULTISTACKSIZE = 4213;

    public static final int NC_PARAM = 4300;

    public static final int LC_PARAM = 4400;

    public static final int STRUCT_PARAM = 4500;

    public static final int BAS_GETANIM_READY = 4600;

    private ClientScriptOpCode() {
        /* empty */
    }
}
