import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.DisplayProperties;
import com.jagex.PrivateChatMode;
import com.jagex.core.constants.MainLogicStep;
import com.jagex.core.constants.MiniMenuAction;
import com.jagex.core.constants.ModeWhat;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.JagException;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.compression.huffman.WordPack;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.defaults.AudioDefaults;
import com.jagex.game.runetek6.config.enumtype.EnumMapping;
import com.jagex.game.runetek6.config.enumtype.EnumStringMapping;
import com.jagex.game.runetek6.config.enumtype.EnumType;
import com.jagex.game.runetek6.config.enumtype.EnumTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.iftype.DragRenderBehaviour;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjNumMode;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.structtype.StructTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingType;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.game.runetek6.config.vartype.clan.VarClanType;
import com.jagex.game.runetek6.config.vartype.clan.VarClanTypeList;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.graphics.VerticalAlignment;
import com.jagex.js5.js5;
import com.jagex.math.ColourUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.settings.ClanSettings;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.mouse.MouseMonitor;
import rs2.client.loading.library.LibraryManager;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_FIND_AFFINED;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_FIND_LISTENED;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETCLANNAME;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETRANKKICK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETRANKTALK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETSORTEDUSERSLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETUSERCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETUSERDISPLAYNAME;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETUSERRANK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETUSERSLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_GETUSERWORLD;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANCHANNEL_KICKUSER;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_FIND_AFFINED;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDDISPLAYNAME;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDEXTRAINFO;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDJOINRUNEDAY;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDRANK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETAFFINEDSLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETALLOWUNAFFINED;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETBANNEDCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETBANNEDDISPLAYNAME;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETCLANNAME;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETCOINSHARE;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETCURRENTOWNER_SLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETRANKKICK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETRANKLOOTSHARE;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETRANKTALK;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETREPLACEMENTOWNER_SLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVECLANSETTINGS_GETSORTEDAFFINEDSLOT;
import static com.jagex.core.constants.ClientScriptOpCode.ACTIVELCANSETTINGS_FIND_LISTENED;
import static com.jagex.core.constants.ClientScriptOpCode.ADD;
import static com.jagex.core.constants.ClientScriptOpCode.ADDPERCENT;
import static com.jagex.core.constants.ClientScriptOpCode.AFFILIATE;
import static com.jagex.core.constants.ClientScriptOpCode.AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL;
import static com.jagex.core.constants.ClientScriptOpCode.AND;
import static com.jagex.core.constants.ClientScriptOpCode.APPEND;
import static com.jagex.core.constants.ClientScriptOpCode.APPEND_CHAR;
import static com.jagex.core.constants.ClientScriptOpCode.APPEND_NUM;
import static com.jagex.core.constants.ClientScriptOpCode.APPEND_SIGNNUM;
import static com.jagex.core.constants.ClientScriptOpCode.APPLET_HASFOCUS;
import static com.jagex.core.constants.ClientScriptOpCode.BASECOLOUR;
import static com.jagex.core.constants.ClientScriptOpCode.BASEIDKIT;
import static com.jagex.core.constants.ClientScriptOpCode.BAS_GETANIM_READY;
import static com.jagex.core.constants.ClientScriptOpCode.CC_CREATE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_DELETE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_DELETEALL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_DRAGPICKUP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_FIND;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GET2DANGLE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETCOLOUR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETFONTGRAPHIC;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETGRAPHIC;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETHEIGHT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETHIDE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETID;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETINVCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETINVOBJECT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETLAYER;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODEL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELANGLE_X;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELANGLE_Y;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELANGLE_Z;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELXOF;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELYOF;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETMODELZOOM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETOP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETOPBASE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETPARENTLAYER;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETSCROLLHEIGHT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETSCROLLWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETSCROLLX;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETSCROLLY;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETTARGETMASK;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETTEXT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETTRANS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETX;
import static com.jagex.core.constants.ClientScriptOpCode.CC_GETY;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_CALLONRESIZE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_CLEAROPS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_CLEARSCRIPTHOOKS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SET2DANGLE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETALPHA;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETASPECT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETCLICKMASK;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETCOLOUR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETDRAGDEADTIME;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETDRAGDEADZONE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETDRAGGABLE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETDRAGRENDERBEHAVIOUR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETFILL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETFONTMONO;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETGRAPHIC;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETGRAPHICSHADOW;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETHFLIP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETHIDE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETLINEDIRECTION;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETLINEWID;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMAXLINES;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODEL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODELANGLE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODELANIM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODELORIGIN;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODELORTHOG;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMODELZOOM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETMOUSEOVERCURSOR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETNOCLICKTHROUGH;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETNPCHEAD;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETNPCMODEL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_ALWAYSNUM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_DATA;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_NONUM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_WEARCOL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_WEARCOL_ALWAYSNUM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOBJECT_WEARCOL_NONUM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCAMFINISHED;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCHATTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCLANCHANNELTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCLANSETTINGSTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCLANTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCLICK;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONCLICKREPEAT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONDIALOGABORT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONDRAG;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONDRAGCOMPLETE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONFRIENDTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONHOLD;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONINVTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONKEY;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONMISCTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONMOUSELEAVE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONMOUSEOVER;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONMOUSEREPEAT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONOP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONOPT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONRELEASE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONRESIZE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONSCROLLWHEEL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONSTATTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONSTOCKTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONSUBCHANGE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONTARGETENTER;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONTARGETLEAVE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONTIMER;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONVARCLANTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONVARCSTRTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONVARCTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETONVARTRANSMIT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOPBASE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOPCHAR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOPCURSOR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOPKEY;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETOUTLINE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPARAM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPARAM_INT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPARAM_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPAUSETEXT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPLAYERHEAD_SELF;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPLAYERMODEL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPLAYERMODEL_SELF;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETPOSITION;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETRECOL;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETRETEX;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETSCROLLPOS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETSCROLLSIZE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETSIZE;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTARGETCURSORS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTARGETOPCURSOR;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTARGETVERB;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTEXT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTEXTALIGN;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTEXTFONT;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTEXTSHADOW;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTILING;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETTTRANS;
import static com.jagex.core.constants.ClientScriptOpCode.CC_IF_SETVFLIP;
import static com.jagex.core.constants.ClientScriptOpCode.CC_PARAM;
import static com.jagex.core.constants.ClientScriptOpCode.CC_SENDTOBACK;
import static com.jagex.core.constants.ClientScriptOpCode.CC_SENDTOFRONT;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_ISALPHA;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_ISALPHANUMERIC;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_ISNUMERIC;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_ISPRINTABLE;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_TOLOWERCASE;
import static com.jagex.core.constants.ClientScriptOpCode.CHAR_TOUPPERCASE;
import static com.jagex.core.constants.ClientScriptOpCode.CLANFORUMQFC_TOSTRING;
import static com.jagex.core.constants.ClientScriptOpCode.CLANPROFILE_FIND;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATDISPLAYNAME;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATMINKICK;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATOWNERNAME;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATRANK;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATUSERNAME;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATUSERNAME_UNFILTERED;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATUSERRANK;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATUSERWORLD;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_GETCHATUSERWORLDNAME;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_ISSELF;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_JOINCHAT;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_KICKUSER;
import static com.jagex.core.constants.ClientScriptOpCode.CLAN_LEAVECHAT;
import static com.jagex.core.constants.ClientScriptOpCode.CLEARBIT;
import static com.jagex.core.constants.ClientScriptOpCode.CLIENTCLOCK;
import static com.jagex.core.constants.ClientScriptOpCode.COMLEVEL_ACTIVE;
import static com.jagex.core.constants.ClientScriptOpCode.COMPARE;
import static com.jagex.core.constants.ClientScriptOpCode.COORDX;
import static com.jagex.core.constants.ClientScriptOpCode.COORDY;
import static com.jagex.core.constants.ClientScriptOpCode.COORDZ;
import static com.jagex.core.constants.ClientScriptOpCode.DIVIDE;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_GETOUTPUT_COUNT;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_GETREVERSECOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_GETREVERSECOUNT_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_GETREVERSEINDEX;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_GETREVERSEINDEX_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_HASOUTPUT;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_HASOUTPUT_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.ENUM_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.ESCAPE;
import static com.jagex.core.constants.ClientScriptOpCode.COORD;
import static com.jagex.core.constants.ClientScriptOpCode.FORMAT_DATETIME_FROM_MINUTES;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_ADD;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_COUNT;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_DEL;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_GETNAME;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_GETRANK;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_GETSLOTFROMNAME;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_GETWORLD;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_GETWORLDNAME;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_IS_REFERRED;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_SAME_GAME;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_SETRANK;
import static com.jagex.core.constants.ClientScriptOpCode.FRIEND_TEST;
import static com.jagex.core.constants.ClientScriptOpCode.FROMBILLING;
import static com.jagex.core.constants.ClientScriptOpCode.FROMDATE;
import static com.jagex.core.constants.ClientScriptOpCode.GENDER;
import static com.jagex.core.constants.ClientScriptOpCode.GET_ACTIVE_MINIMENU_ENTRY;
import static com.jagex.core.constants.ClientScriptOpCode.GET_CURRENTCURSOR;
import static com.jagex.core.constants.ClientScriptOpCode.GET_MINIMENU_LENGTH;
import static com.jagex.core.constants.ClientScriptOpCode.GET_MOUSEBUTTONS;
import static com.jagex.core.constants.ClientScriptOpCode.GET_MOUSEX;
import static com.jagex.core.constants.ClientScriptOpCode.GET_MOUSEY;
import static com.jagex.core.constants.ClientScriptOpCode.GET_SECOND_MINIMENU_ENTRY;
import static com.jagex.core.constants.ClientScriptOpCode.GET_SELFYANGLE;
import static com.jagex.core.constants.ClientScriptOpCode.HSVTORGB;
import static com.jagex.core.constants.ClientScriptOpCode.IF_CLOSE;
import static com.jagex.core.constants.ClientScriptOpCode.IF_CLOSESUBCLIENT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_DRAGPICKUP;
import static com.jagex.core.constants.ClientScriptOpCode.IF_FIND;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GET2DANGLE;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETCOLOUR;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETFONTGRAPHIC;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETGRAPHIC;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETHEIGHT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETHIDE;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETINVCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETINVOBJECT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETLAYER;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODEL;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELANGLE_X;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELANGLE_Y;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELANGLE_Z;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELXOF;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELYOF;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETMODELZOOM;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETNEXTSUBID;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETOP;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETOPBASE;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETPARENTLAYER;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETSCROLLHEIGHT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETSCROLLWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETSCROLLX;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETSCROLLY;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETTARGETMASK;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETTEXT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETTRANS;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETX;
import static com.jagex.core.constants.ClientScriptOpCode.IF_GETY;
import static com.jagex.core.constants.ClientScriptOpCode.IF_HASSUB;
import static com.jagex.core.constants.ClientScriptOpCode.IF_HASSUBMODAL;
import static com.jagex.core.constants.ClientScriptOpCode.IF_HASSUBOVERLAY;
import static com.jagex.core.constants.ClientScriptOpCode.IF_OPENSUBCLIENT;
import static com.jagex.core.constants.ClientScriptOpCode.IF_SENDTOBACK;
import static com.jagex.core.constants.ClientScriptOpCode.IF_SENDTOFRONT;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_ADD;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_ADD_TEMP;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_COUNT;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_DEL;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_GETNAME;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_GETNAME_UNFILTERED;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_IS_TEMP;
import static com.jagex.core.constants.ClientScriptOpCode.IGNORE_TEXT;
import static com.jagex.core.constants.ClientScriptOpCode.INTERPOLATE;
import static com.jagex.core.constants.ClientScriptOpCode.INVOTHER_GETNUM;
import static com.jagex.core.constants.ClientScriptOpCode.INVOTHER_GETOBJ;
import static com.jagex.core.constants.ClientScriptOpCode.INVOTHER_TOTAL;
import static com.jagex.core.constants.ClientScriptOpCode.INVPOW;
import static com.jagex.core.constants.ClientScriptOpCode.INV_FREESPACE;
import static com.jagex.core.constants.ClientScriptOpCode.INV_GETNUM;
import static com.jagex.core.constants.ClientScriptOpCode.INV_GETOBJ;
import static com.jagex.core.constants.ClientScriptOpCode.INV_SIZE;
import static com.jagex.core.constants.ClientScriptOpCode.INV_TOTAL;
import static com.jagex.core.constants.ClientScriptOpCode.INV_TOTALPARAM;
import static com.jagex.core.constants.ClientScriptOpCode.INV_TOTALPARAM_STACK;
import static com.jagex.core.constants.ClientScriptOpCode.LC_PARAM;
import static com.jagex.core.constants.ClientScriptOpCode.LOWERCASE;
import static com.jagex.core.constants.ClientScriptOpCode.MAP_ISOWNER;
import static com.jagex.core.constants.ClientScriptOpCode.MAP_LANG;
import static com.jagex.core.constants.ClientScriptOpCode.MAP_MEMBERS;
import static com.jagex.core.constants.ClientScriptOpCode.MAP_QUICKCHAT;
import static com.jagex.core.constants.ClientScriptOpCode.MAP_WORLD;
import static com.jagex.core.constants.ClientScriptOpCode.MAX;
import static com.jagex.core.constants.ClientScriptOpCode.MES;
import static com.jagex.core.constants.ClientScriptOpCode.MES_TYPED;
import static com.jagex.core.constants.ClientScriptOpCode.MIN;
import static com.jagex.core.constants.ClientScriptOpCode.MODULO;
import static com.jagex.core.constants.ClientScriptOpCode.MOVE_COORD;
import static com.jagex.core.constants.ClientScriptOpCode.MULTIPLY;
import static com.jagex.core.constants.ClientScriptOpCode.NC_PARAM;
import static com.jagex.core.constants.ClientScriptOpCode.OC_CERT;
import static com.jagex.core.constants.ClientScriptOpCode.OC_COST;
import static com.jagex.core.constants.ClientScriptOpCode.OC_FIND;
import static com.jagex.core.constants.ClientScriptOpCode.OC_FINDNEXT;
import static com.jagex.core.constants.ClientScriptOpCode.OC_FINDRESTART;
import static com.jagex.core.constants.ClientScriptOpCode.OC_ICURSOR;
import static com.jagex.core.constants.ClientScriptOpCode.OC_IOP;
import static com.jagex.core.constants.ClientScriptOpCode.OC_MEMBERS;
import static com.jagex.core.constants.ClientScriptOpCode.OC_MULTISTACKSIZE;
import static com.jagex.core.constants.ClientScriptOpCode.OC_NAME;
import static com.jagex.core.constants.ClientScriptOpCode.OC_OP;
import static com.jagex.core.constants.ClientScriptOpCode.OC_PARAM;
import static com.jagex.core.constants.ClientScriptOpCode.OC_STACKABLE;
import static com.jagex.core.constants.ClientScriptOpCode.OC_UNCERT;
import static com.jagex.core.constants.ClientScriptOpCode.OPPLAYER;
import static com.jagex.core.constants.ClientScriptOpCode.OPPLAYERT;
import static com.jagex.core.constants.ClientScriptOpCode.OR;
import static com.jagex.core.constants.ClientScriptOpCode.PARAHEIGHT;
import static com.jagex.core.constants.ClientScriptOpCode.PARAWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.PLAYERCOUNTRY;
import static com.jagex.core.constants.ClientScriptOpCode.PLAYERDEMO;
import static com.jagex.core.constants.ClientScriptOpCode.PLAYERMEMBER;
import static com.jagex.core.constants.ClientScriptOpCode.PLAYERMOD;
import static com.jagex.core.constants.ClientScriptOpCode.PLAYERMODLEVEL;
import static com.jagex.core.constants.ClientScriptOpCode.POW;
import static com.jagex.core.constants.ClientScriptOpCode.PROFILE_CPU;
import static com.jagex.core.constants.ClientScriptOpCode.RANDOM;
import static com.jagex.core.constants.ClientScriptOpCode.RANDOMINC;
import static com.jagex.core.constants.ClientScriptOpCode.RANDOM_SOUND_PITCH;
import static com.jagex.core.constants.ClientScriptOpCode.REBOOTTIMER;
import static com.jagex.core.constants.ClientScriptOpCode.REMOVETAGS;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_CLANFORUMQFCDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_COUNTDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_HSLDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_NAMEDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_OBJDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RESUME_STRINGDIALOG;
import static com.jagex.core.constants.ClientScriptOpCode.RUNENERGY_VISIBLE;
import static com.jagex.core.constants.ClientScriptOpCode.RUNWEIGHT_VISIBLE;
import static com.jagex.core.constants.ClientScriptOpCode.SCALE;
import static com.jagex.core.constants.ClientScriptOpCode.SETBIT;
import static com.jagex.core.constants.ClientScriptOpCode.SETGENDER;
import static com.jagex.core.constants.ClientScriptOpCode.SETOBJ;
import static com.jagex.core.constants.ClientScriptOpCode.SETUP_MESSAGEBOX;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_JINGLE;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_JINGLE_VOLUME;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SONG;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SONG_VOLUME;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SPEECH_VOLUME;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SYNTH;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SYNTH_RATE;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_SYTHN_VOLUME;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_VORBIS_RATE;
import static com.jagex.core.constants.ClientScriptOpCode.SOUND_VORBIS_VOLUME;
import static com.jagex.core.constants.ClientScriptOpCode.STAFFMODLEVEL;
import static com.jagex.core.constants.ClientScriptOpCode.STAT;
import static com.jagex.core.constants.ClientScriptOpCode.STAT_BASE;
import static com.jagex.core.constants.ClientScriptOpCode.STAT_VISIBLE_XP;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERCOMPLETEDCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERCOMPLETEDGOLD;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERCOUNT;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERITEM;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERPRICE;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_GETOFFERTYPE;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_ISOFFERADDING;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_ISOFFEREMPTY;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_ISOFFERFINISHED;
import static com.jagex.core.constants.ClientScriptOpCode.STOCKMARKET_ISOFFERSTABLE;
import static com.jagex.core.constants.ClientScriptOpCode.STRINGWIDTH;
import static com.jagex.core.constants.ClientScriptOpCode.STRING_INDEXOF_CHAR;
import static com.jagex.core.constants.ClientScriptOpCode.STRING_INDEXOF_STRING;
import static com.jagex.core.constants.ClientScriptOpCode.STRING_LENGTH;
import static com.jagex.core.constants.ClientScriptOpCode.STRUCT_PARAM;
import static com.jagex.core.constants.ClientScriptOpCode.SUB;
import static com.jagex.core.constants.ClientScriptOpCode.SUBSTRING;
import static com.jagex.core.constants.ClientScriptOpCode.TESTBIT;
import static com.jagex.core.constants.ClientScriptOpCode.TEXT_GENDER;
import static com.jagex.core.constants.ClientScriptOpCode.TEXT_SWITCH;
import static com.jagex.core.constants.ClientScriptOpCode.TOSTRING;
import static com.jagex.core.constants.ClientScriptOpCode.TOSTRING_LOCALISED;

@OriginalClass("client!ou")
public final class ScriptRunner {

    public static final int PUSH_CONSTANT_INT = 0;

    public static final int PUSH_VAR = 1;

    public static final int POP_VAR = 2;

    public static final int PUSH_CONSTANT_STRING = 3;

    public static final int BRANCH = 6;

    public static final int BRANCH_NOT = 7;

    public static final int BRANCH_EQUALS = 8;

    public static final int BRANCH_LESS_THAN = 9;

    public static final int BRANCH_GREATER_THAN = 10;

    public static final int RETURN = 21;

    public static final int POP_VARBIT = 25;

    public static final int PUSH_VARBIT = 27;

    public static final int BRANCH_LESS_THAN_OR_EQUALS = 31;

    public static final int BRANCH_GREATER_THAN_OR_EQUALS = 32;

    public static final int PUSH_INT_LOCAL = 33;

    public static final int POP_INT_LOCAL = 34;

    public static final int PUSH_STRING_LOCAL = 35;

    public static final int POP_STRING_LOCAL = 36;

    public static final int JOIN_STRING = 37;

    public static final int POP_INT_DISCARD = 38;

    public static final int POP_STRING_DISCARD = 39;

    public static final int GOSUB_WITH_PARAMS = 40;

    public static final int PUSH_VARC = 42;

    public static final int POP_VARC = 43;

    public static final int DEFINE_ARRAY = 44;

    public static final int PUSH_ARRAY_INT = 45;

    public static final int POP_ARRAY_INT = 46;

    public static final int PUSH_VARCSTR = 47;

    public static final int POP_VARCSTR = 48;

    public static final int SWITCH = 51;

    public static final int PUSH_LONG_CONSTANT = 54;

    public static final int POP_LONG_DISCARD = 55;

    public static final int PUSH_LONG_LOCAL = 66;

    public static final int POP_LONG_LOCAL = 67;

    public static final int LONG_BRANCH_NOT = 68;

    public static final int LONG_BRANCH_EQUALS = 69;

    public static final int LONG_BRANCH_LESS_THAN = 70;

    public static final int LONG_BRANCH_GREATER_THAN = 71;

    public static final int LONG_BRANCH_LESS_THAN_OR_EQUALS = 72;

    public static final int LONG_BRANCH_GREATER_THAN_OR_EQUALS = 73;

    public static final int BRANCH_IF_TRUE = 86;

    public static final int BRANCH_IF_FALSE = 87;

    @OriginalMember(owner = "client!ou", name = "y", descriptor = "[Ljava/lang/String;")
    public static String[] stringVars;

    @OriginalMember(owner = "client!ou", name = "v", descriptor = "[I")
    public static int[] intVars;

    @OriginalMember(owner = "client!ou", name = "m", descriptor = "Lclient!hda;")
    public static Component focusedComponent;

    @OriginalMember(owner = "client!ou", name = "i", descriptor = "[J")
    public static long[] longVars;

    @OriginalMember(owner = "client!ou", name = "H", descriptor = "Lclient!an;")
    public static QuickChatPhrase aQuickChatPhrase_1;

    @OriginalMember(owner = "client!ou", name = "z", descriptor = "Lclient!rfa;")
    public static ClanChannel clanChannel;

    @OriginalMember(owner = "client!ou", name = "G", descriptor = "Lclient!hi;")
    public static ClanSettings clanSettings;

    @OriginalMember(owner = "client!ou", name = "k", descriptor = "Lclient!hda;")
    public static Component unfocusedComponent;

    @OriginalMember(owner = "client!ou", name = "B", descriptor = "[J")
    public static final long[] longStack = new long[1000];

    @OriginalMember(owner = "client!ou", name = "e", descriptor = "[I")
    public static final int[] intStack = new int[1000];

    @OriginalMember(owner = "client!ou", name = "D", descriptor = "I")
    public static int stringStackPointer = 0;

    @OriginalMember(owner = "client!ou", name = "t", descriptor = "[Lclient!gf;")
    public static final StackFrame[] frames = new StackFrame[50];

    @OriginalMember(owner = "client!ou", name = "r", descriptor = "I")
    public static int framePointer = 0;

    @OriginalMember(owner = "client!ou", name = "f", descriptor = "[I")
    public static final int[] areaCoords = new int[3];

    @OriginalMember(owner = "client!ou", name = "n", descriptor = "I")
    public static int intStackPointer = 0;

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "[Ljava/lang/String;")
    public static final String[] stringStack = new String[1000];

    @OriginalMember(owner = "client!ou", name = "w", descriptor = "[[I")
    public static final int[][] arrayVars = new int[5][5000];

    @OriginalMember(owner = "client!ou", name = "C", descriptor = "I")
    public static int longStackPointer = 0;

    @OriginalMember(owner = "client!ou", name = "g", descriptor = "[I")
    public static final int[] arrayLengths = new int[5];

    @OriginalMember(owner = "client!ou", name = "E", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___156 = new ReferenceCache(4);

    @OriginalMember(owner = "client!ou", name = "q", descriptor = "Z")
    public static boolean debug = false;

    @OriginalMember(owner = "client!ou", name = "o", descriptor = "I")
    public static int lastHookId = 0;

    @OriginalMember(owner = "client!ou", name = "s", descriptor = "Ljava/lang/String;")
    public static String debugName = null;

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(I)I")
    public static int getClanSettingVarbit(@OriginalArg(0) int id) {
        @Pc(4) VarClanType type = VarClanTypeList.instance.list(id);
        if (type == null) {
            throw new RuntimeException("sr-c113");
        }

        @Pc(29) Integer setting = clanSettings.getExtraSettingVarbit((Client.modeGame.id << 16) | type.baseVar, type.endBit, type.startBit);
        if (setting == null) {
            return 0;
        } else {
            return setting;
        }
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(I)I")
    public static int getClanSettingInt(@OriginalArg(0) int id) {
        @Pc(4) VarClanType type = VarClanTypeList.instance.list(id);
        if (type == null) {
            throw new RuntimeException("sr-c112");
        }

        @Pc(24) Integer setting = clanSettings.getExtraSettingInt((Client.modeGame.id << 16) | id);
        if (setting == null) {
            return (type.dataType == 'i' || type.dataType == '1') ? 0 : -1;
        } else {
            return setting;
        }
    }

    @OriginalMember(owner = "client!ou", name = "c", descriptor = "(I)J")
    public static long getClanSettingLong(@OriginalArg(0) int id) {
        @Pc(9) Long setting = clanSettings.getExtraSettingLong(Client.modeGame.id << 16 | id);
        if (setting == null) {
            return -1L;
        } else {
            return setting;
        }
    }

    @OriginalMember(owner = "client!ou", name = "d", descriptor = "(I)V")
    public static void executeOnLoad(@OriginalArg(0) int id) {
        if (id == -1 || !InterfaceList.load(id)) {
            return;
        }

        @Pc(14) Component[] components = InterfaceList.interfaces[id];
        for (@Pc(16) int i = 0; i < components.length; i++) {
            @Pc(21) Component component = components[i];

            if (component.onLoad != null) {
                @Pc(28) HookRequest hook = new HookRequest();
                hook.source = component;
                hook.arguments = component.onLoad;
                executeHookInner(hook, 2000000);
            }
        }
    }

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(Lclient!hda;)V")
    public static void sendToFront(@OriginalArg(0) Component component) {
        if (component == null) {
            return;
        }

        if (component.id == -1) {
            @Pc(119) int parent = component.slot >>> 16;
            @Pc(123) Component[] children = InterfaceList.cache[parent];

            if (children == null) {
                @Pc(71) Component[] newChildren = InterfaceList.interfaces[parent];
                @Pc(132) int length = newChildren.length;
                children = InterfaceList.cache[parent] = new Component[length];
                Arrays.copy(newChildren, 0, children, 0, newChildren.length);
            }

            @Pc(148) int i;
            for (i = 0; i < children.length; i++) {
                if (component == children[i]) {
                    break;
                }
            }

            if (i >= children.length) {
                return;
            }

            Arrays.copy(children, i + 1, children, i, children.length - i - 1);
            children[children.length - 1] = component;
            return;
        } else {
            @Pc(12) Component layer = InterfaceList.list(component.layer);
            if (layer == null) {
                return;
            }

            if (layer.dynamicComponents == layer.staticComponents) {
                layer.dynamicComponents = new Component[layer.staticComponents.length];
                layer.dynamicComponents[layer.dynamicComponents.length - 1] = component;
                Arrays.copy(layer.staticComponents, 0, layer.dynamicComponents, 0, component.id);
                Arrays.copy(layer.staticComponents, component.id + 1, layer.dynamicComponents, component.id, layer.staticComponents.length - component.id - 1);
                return;
            }

            @Pc(68) int i = 0;
            @Pc(71) Component[] dynamicComponents = layer.dynamicComponents;
            while (i < dynamicComponents.length && component != dynamicComponents[i]) {
                i++;
            }
            if (i >= dynamicComponents.length) {
                return;
            }

            Arrays.copy(dynamicComponents, i + 1, dynamicComponents, i, dynamicComponents.length - i - 1);
            dynamicComponents[layer.dynamicComponents.length - 1] = component;
        }
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(IZ)V")
    public static void handleSmallOp(@OriginalArg(0) int op, @OriginalArg(1) boolean unfocused) {
        if (op < 300) {
            if (op == CC_CREATE) {
                intStackPointer -= 3;

                @Pc(15) int parentId = intStack[intStackPointer];
                @Pc(21) int componentType = intStack[intStackPointer + 1];
                @Pc(27) int componentId = intStack[intStackPointer + 2];

                if (componentType == Component.TYPE_LAYER) {
                    throw new RuntimeException();
                }

                @Pc(38) Component parent = InterfaceList.list(parentId);
                if (parent.staticComponents == null) {
                    parent.staticComponents = new Component[componentId + 1];
                    parent.dynamicComponents = parent.staticComponents;
                }

                if (parent.staticComponents.length <= componentId) {
                    if (parent.staticComponents == parent.dynamicComponents) {
                        @Pc(70) Component[] staticComponents = new Component[componentId + 1];
                        for (@Pc(72) int i = 0; i < parent.staticComponents.length; i++) {
                            staticComponents[i] = parent.staticComponents[i];
                        }
                        parent.staticComponents = parent.dynamicComponents = staticComponents;
                    } else {
                        @Pc(70) Component[] staticComponents = new Component[componentId + 1];
                        @Pc(104) Component[] dynamicComponents = new Component[componentId + 1];
                        for (@Pc(106) int i = 0; i < parent.staticComponents.length; i++) {
                            staticComponents[i] = parent.staticComponents[i];
                            dynamicComponents[i] = parent.dynamicComponents[i];
                        }
                        parent.staticComponents = staticComponents;
                        parent.dynamicComponents = dynamicComponents;
                    }
                }

                if (componentId > 0 && parent.staticComponents[componentId - 1] == null) {
                    throw new RuntimeException("Gap at:" + (componentId - 1));
                }

                @Pc(166) Component createdComponent = new Component();
                createdComponent.type = componentType;
                createdComponent.layer = createdComponent.slot = parent.slot;
                createdComponent.id = componentId;

                parent.staticComponents[componentId] = createdComponent;

                if (parent.dynamicComponents != parent.staticComponents) {
                    parent.dynamicComponents[componentId] = createdComponent;
                }

                if (unfocused) {
                    unfocusedComponent = createdComponent;
                } else {
                    focusedComponent = createdComponent;
                }

                InterfaceManager.redraw(parent);
                return;
            }

            if (op == CC_DELETE) {
                @Pc(220) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;
                if (createdComponent.id == -1) {
                    if (unfocused) {
                        throw new RuntimeException("Tried to .cc_delete static .active-component!");
                    }

                    throw new RuntimeException("Tried to cc_delete static active-component!");
                }

                @Pc(248) Component component = InterfaceList.list(createdComponent.slot);
                component.staticComponents[createdComponent.id] = null;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_DELETEALL) {
                @Pc(220) Component createdComponent = InterfaceList.list(intStack[--intStackPointer]);
                createdComponent.staticComponents = null;
                createdComponent.dynamicComponents = null;
                InterfaceManager.redraw(createdComponent);
                return;
            }

            if (op == CC_FIND) {
                intStackPointer -= 2;
                @Pc(15) int idAndSlot = intStack[intStackPointer];
                @Pc(21) int component = intStack[intStackPointer + 1];
                @Pc(303) Component createdComponent = InterfaceList.getComponent(idAndSlot, component);

                if (createdComponent != null && component != -1) {
                    intStack[intStackPointer++] = 1;

                    if (unfocused) {
                        unfocusedComponent = createdComponent;
                        return;
                    } else {
                        focusedComponent = createdComponent;
                        return;
                    }
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == IF_FIND) {
                @Pc(15) int idAndSlot = intStack[--intStackPointer];
                @Pc(248) Component component = InterfaceList.list(idAndSlot);

                if (component != null) {
                    intStack[intStackPointer++] = 1;

                    if (unfocused) {
                        unfocusedComponent = component;
                        return;
                    }

                    focusedComponent = component;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == IF_SENDTOFRONT || op == CC_SENDTOFRONT) {
                @Pc(220) Component component;

                if (op == IF_SENDTOFRONT) {
                    @Pc(21) int idAndSlot = intStack[--intStackPointer];
                    component = InterfaceList.list(idAndSlot);
                } else {
                    component = unfocused ? unfocusedComponent : focusedComponent;
                }

                sendToFront(component);
                return;
            }

            if (op == IF_SENDTOBACK || op == CC_SENDTOBACK) {
                @Pc(220) Component component;

                if (op == IF_SENDTOBACK) {
                    @Pc(21) int idAndSlot = intStack[--intStackPointer];
                    component = InterfaceList.list(idAndSlot);
                } else {
                    component = unfocused ? unfocusedComponent : focusedComponent;
                }

                sendToBack(component);
                return;
            }
        } else if (op < 500) {
            if (op == BASEIDKIT) {
                intStackPointer -= 2;

                @Pc(15) int value = intStack[intStackPointer];
                @Pc(21) int idkType = intStack[intStackPointer + 1];

                if (PlayerEntity.self.playerModel == null) {
                    return;
                }

                for (@Pc(27) int part = 0; part < PlayerModel.PRIMARY_BODY_PARTS.length; part++) {
                    if (PlayerModel.PRIMARY_BODY_PARTS[part] == value) {
                        PlayerEntity.self.playerModel.setIDKPart(idkType, IDKTypeList.instance, part);
                        return;
                    }
                }

                for (@Pc(506) int part = 0; part < PlayerModel.SECONDARY_BODY_PARTS.length; part++) {
                    if (PlayerModel.SECONDARY_BODY_PARTS[part] == value) {
                        PlayerEntity.self.playerModel.setIDKPart(idkType, IDKTypeList.instance, part);
                        return;
                    }
                }

                return;
            }

            if (op == BASECOLOUR) {
                intStackPointer -= 2;

                @Pc(15) int local15 = intStack[intStackPointer];
                @Pc(21) int local21 = intStack[intStackPointer + 1];

                if (PlayerEntity.self.playerModel == null) {
                    return;
                }

                PlayerEntity.self.playerModel.setBaseColour(local15, local21);
                return;
            }

            if (op == SETGENDER) {
                @Pc(575) boolean female = intStack[--intStackPointer] != 0;

                if (PlayerEntity.self.playerModel == null) {
                    return;
                }

                PlayerEntity.self.playerModel.setFemale(female);
                return;
            }

            if (op == SETOBJ) {
                intStackPointer -= 2;

                @Pc(15) int part = intStack[intStackPointer];
                @Pc(21) int objId = intStack[intStackPointer + 1];

                if (PlayerEntity.self.playerModel == null) {
                    return;
                }

                PlayerEntity.self.playerModel.setObj(ObjTypeList.instance, part, objId);
                return;
            }
        } else if ((op >= 1000 && op < 1100) || (op >= 2000 && op < 2100)) {
            @Pc(220) Component component;
            if (op >= 2000) {
                op -= 1000;
                component = InterfaceList.list(intStack[--intStackPointer]);
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            if (op == CC_IF_SETPOSITION) {
                intStackPointer -= 4;

                component.originalX = intStack[intStackPointer];
                component.originalY = intStack[intStackPointer + 1];

                @Pc(21) int reposModeX = intStack[intStackPointer + 2];
                if (reposModeX < 0) {
                    reposModeX = 0;
                } else if (reposModeX > 5) {
                    reposModeX = 5;
                }

                @Pc(27) int reposModeY = intStack[intStackPointer + 3];
                if (reposModeY < 0) {
                    reposModeY = 0;
                } else if (reposModeY > 5) {
                    reposModeY = 5;
                }

                component.reposModeX = (byte) reposModeX;
                component.reposModeY = (byte) reposModeY;

                InterfaceManager.redraw(component);
                InterfaceManager.resizeAndReposition(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetPosition(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETSIZE) {
                intStackPointer -= 4;

                component.originalWidth = intStack[intStackPointer];
                component.originalHeight = intStack[intStackPointer + 1];

                component.modelAspectRatioX = 0;
                component.modelAspectRatioY = 0;

                @Pc(21) int resizeModeX = intStack[intStackPointer + 2];
                if (resizeModeX < 0) {
                    resizeModeX = 0;
                } else if (resizeModeX > 4) {
                    resizeModeX = 4;
                }

                @Pc(27) int resizeModeY = intStack[intStackPointer + 3];
                if (resizeModeY < 0) {
                    resizeModeY = 0;
                } else if (resizeModeY > 4) {
                    resizeModeY = 4;
                }

                component.resizeModeX = (byte) resizeModeX;
                component.resizeModeY = (byte) resizeModeY;

                InterfaceManager.redraw(component);
                InterfaceManager.resizeAndReposition(component);

                if (component.type == 0) {
                    InterfaceManager.calculateLayerDimensions(component, false);
                }
                return;
            }

            if (op == CC_IF_SETHIDE) {
                @Pc(834) boolean hidden = intStack[--intStackPointer] == 1;

                if (component.hidden != hidden) {
                    component.hidden = hidden;
                    InterfaceManager.redraw(component);
                }

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetHide(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETASPECT) {
                intStackPointer -= 2;

                component.resizeAspectRatioY = intStack[intStackPointer];
                component.resizeAspectRatioX = intStack[intStackPointer + 1];

                InterfaceManager.redraw(component);
                InterfaceManager.resizeAndReposition(component);

                if (component.type == Component.TYPE_LAYER) {
                    InterfaceManager.calculateLayerDimensions(component, false);
                }
                return;
            }

            if (op == CC_IF_SETNOCLICKTHROUGH) {
                component.noClickThrough = intStack[--intStackPointer] == 1;
                return;
            }
        } else if (op >= 1100 && op < 1200 || !(op < 2100 || op >= 2200)) {
            @Pc(220) Component component;
            if (op >= 2000) {
                op -= 1000;
                component = InterfaceList.list(intStack[--intStackPointer]);
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            if (op == CC_IF_SETSCROLLPOS) {
                intStackPointer -= 2;

                component.scrollX = intStack[intStackPointer];
                if (component.scrollX > component.scrollWidth - component.width) {
                    component.scrollX = component.scrollWidth - component.width;
                }
                if (component.scrollX < 0) {
                    component.scrollX = 0;
                }

                component.scrollY = intStack[intStackPointer + 1];
                if (component.scrollY > component.scrollHeight - component.height) {
                    component.scrollY = component.scrollHeight - component.height;
                }
                if (component.scrollY < 0) {
                    component.scrollY = 0;
                }

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetScrollPosition(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETCOLOUR) {
                component.colour = intStack[--intStackPointer];

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetColour(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETFILL) {
                component.filled = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETTTRANS) {
                component.transparency = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETLINEWID) {
                component.lineWidth = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETGRAPHIC) {
                @Pc(21) int graphic = intStack[--intStackPointer];

                if (component.graphic != graphic) {
                    component.graphic = graphic;
                    InterfaceManager.redraw(component);
                }

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetGraphic(component.slot);
                }
                return;
            }

            if (op == CC_IF_SET2DANGLE) {
                component.angle2d = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETTILING) {
                component.tiling = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETMODEL) {
                component.objType = 1;
                component.obj = intStack[--intStackPointer];

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETMODELANGLE) {
                intStackPointer -= 6;
                component.xof2d = intStack[intStackPointer];
                component.yof2d = intStack[intStackPointer + 1];
                component.xan2d = intStack[intStackPointer + 2];
                component.yan2d = intStack[intStackPointer + 3];
                component.zan2d = intStack[intStackPointer + 4];
                component.zoom2d = intStack[intStackPointer + 5];

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModelAngle(component.slot);
                    DelayedStateChange.interfaceResetModelOffset(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETMODELANIM) {
                @Pc(21) int animation = intStack[--intStackPointer];

                if (animation != component.modelAnimation) {
                    if (animation != -1) {
                        if (component.animator == null) {
                            component.animator = new ComponentAnimator();
                        }

                        component.animator.update(true, animation);
                    } else {
                        component.animator = null;
                    }

                    component.modelAnimation = animation;
                    InterfaceManager.redraw(component);
                }

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModelAnim(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETMODELORTHOG) {
                component.modelOrthog = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETTEXT) {
                @Pc(1394) String text = stringStack[--stringStackPointer];

                if (!text.equals(component.text)) {
                    component.text = text;
                    InterfaceManager.redraw(component);
                }

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetText(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETTEXTFONT) {
                component.fontGraphic = intStack[--intStackPointer];

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetTextFont(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETTEXTALIGN) {
                intStackPointer -= 3;

                component.textAlignX = intStack[intStackPointer];
                component.textAlignY = intStack[intStackPointer + 1];
                component.textHeight = intStack[intStackPointer + 2];

                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETTEXTSHADOW) {
                component.textShadow = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETOUTLINE) {
                component.outline = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETGRAPHICSHADOW) {
                component.graphicShadow = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETHFLIP) {
                component.horizontalFlip = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETVFLIP) {
                component.verticalFlip = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETSCROLLSIZE) {
                intStackPointer -= 2;

                component.scrollWidth = intStack[intStackPointer];
                component.scrollHeight = intStack[intStackPointer + 1];

                InterfaceManager.redraw(component);

                if (component.type == 0) {
                    InterfaceManager.calculateLayerDimensions(component, false);
                }
                return;
            }

            if (op == CC_IF_SETALPHA) {
                component.alpha = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETMODELZOOM) {
                component.zoom2d = intStack[--intStackPointer];

                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModelAngle(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETLINEDIRECTION) {
                @Pc(21) int local21 = intStack[--intStackPointer];
                component.lineDirection = local21 == 1;
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETMODELORIGIN) {
                intStackPointer -= 2;
                component.modelOriginX = intStack[intStackPointer];
                component.modelOriginY = intStack[intStackPointer + 1];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETMAXLINES) {
                component.maxLines = intStack[--intStackPointer];
                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETPARAM_INT) {
                intStackPointer -= 2;

                @Pc(21) int id = intStack[intStackPointer];
                @Pc(27) int value = intStack[intStackPointer + 1];
                @Pc(1756) ParamType paramType = ParamTypeList.instance.list(id);

                if (value != paramType.defaultint) {
                    component.setParam(id, value);
                    return;
                }

                component.removeParam(id);
                return;
            }

            if (op == CC_IF_SETPARAM_STRING) {
                @Pc(21) int id = intStack[--intStackPointer];
                @Pc(1791) String value = stringStack[--stringStackPointer];
                @Pc(1756) ParamType paramType = ParamTypeList.instance.list(id);

                if (!paramType.defaultstr.equals(value)) {
                    component.setParam(value, id);
                    return;
                }

                component.removeParam(id);
                return;
            }

            if (op == 1129 || op == 1130) { // TODO: 1129=video graphic, 1130=video text?
                @Pc(21) int video = intStack[--intStackPointer];
                if ((component.type == Component.TYPE_GRAPHIC || op != 1129) && (component.type == Component.TYPE_TEXT || op != 1130)) {
                    if (component.video != video) {
                        component.video = video;
                        InterfaceManager.redraw(component);
                    }

                    if (component.id == -1) {
                        DelayedStateChange.interfaceResetVideo(component.slot);
                    }
                    return;
                }
                return;
            }

            if (op == CC_IF_SETRECOL) {
                intStackPointer -= 3;

                @Pc(21) int index = intStack[intStackPointer];
                @Pc(1892) short source = (short) intStack[intStackPointer + 1];
                @Pc(1899) short destination = (short) intStack[intStackPointer + 2];

                if (index >= 0 && index < 5) {
                    component.setRecol(destination, index, source);
                    InterfaceManager.redraw(component);

                    if (component.id == -1) {
                        DelayedStateChange.interfaceResetRecol(component.slot, index);
                    }
                    return;
                }

                return;
            }

            if (op == CC_IF_SETRETEX) {
                intStackPointer -= 3;

                @Pc(21) int index = intStack[intStackPointer];
                @Pc(1892) short source = (short) intStack[intStackPointer + 1];
                @Pc(1899) short destination = (short) intStack[intStackPointer + 2];

                if (index >= 0 && index < 5) {
                    component.setRetex(source, index, destination);
                    InterfaceManager.redraw(component);

                    if (component.id == -1) {
                        DelayedStateChange.interfaceResetRetex(component.slot, index);
                    }
                    return;
                }
                return;
            }

            if (op == CC_IF_SETFONTMONO) {
                component.fontMonospaced = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetFontMono(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETPARAM) {
                intStackPointer -= 2;

                @Pc(21) int id = intStack[intStackPointer];
                @Pc(27) int value = intStack[intStackPointer + 1];
                @Pc(1756) ParamType paramType = ParamTypeList.instance.list(id);

                if (value != paramType.defaultint) {
                    component.setParam(id, value);
                    return;
                }

                component.removeParam(id);
                return;
            }

            if (op == CC_IF_SETCLICKMASK) {
                component.clickMask = intStack[--intStackPointer] == 1;
                InterfaceManager.redraw(component);

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetClickmask(component.slot);
                }
                return;
            }
        } else if (op >= 1200 && op < 1300 || op >= 2200 && op < 2300) {
            @Pc(220) Component component;
            if (op >= 2000) {
                op -= 1000;
                component = InterfaceList.list(intStack[--intStackPointer]);
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            InterfaceManager.redraw(component);

            if (op == CC_IF_SETOBJECT || op == CC_IF_SETOBJECT_NONUM || op == CC_IF_SETOBJECT_WEARCOL || op == CC_IF_SETOBJECT_WEARCOL_NONUM || op == CC_IF_SETOBJECT_ALWAYSNUM || op == CC_IF_SETOBJECT_WEARCOL_ALWAYSNUM) {
                intStackPointer -= 2;

                @Pc(21) int invObject = intStack[intStackPointer];
                @Pc(27) int count = intStack[intStackPointer + 1];

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetObject(component.slot);
                    DelayedStateChange.interfaceResetModelAngle(component.slot);
                    DelayedStateChange.interfaceResetModelOffset(component.slot);
                }

                if (invObject == -1) {
                    component.objType = 1;
                    component.obj = -1;
                    component.invObject = -1;
                    return;
                }

                component.invObject = invObject;
                component.invCount = count;

                if (op == CC_IF_SETOBJECT_WEARCOL || op == CC_IF_SETOBJECT_WEARCOL_NONUM) {
                    component.objWearCol = true;
                } else {
                    component.objWearCol = false;
                }

                @Pc(2236) ObjType objType = ObjTypeList.instance.list(invObject);
                component.xan2d = objType.xan2d;
                component.yan2d = objType.yan2d;
                component.zan2d = objType.zan2d;
                component.xof2d = objType.xof2d;
                component.yof2d = objType.yof2d;
                component.zoom2d = objType.zoom2d;

                if (op == CC_IF_SETOBJECT_NONUM || op == CC_IF_SETOBJECT_WEARCOL_NONUM) {
                    component.objNumMode = ObjNumMode.SHOWCOUNT_NEVER;
                } else if (op == CC_IF_SETOBJECT_ALWAYSNUM || op == CC_IF_SETOBJECT_WEARCOL_ALWAYSNUM) {
                    component.objNumMode = ObjNumMode.SHOWCOUNT_ALWAYS;
                } else {
                    component.objNumMode = ObjNumMode.SHOWCOUNT_IFNOT1;
                }

                if (component.modelAspectRatioX > 0) {
                    component.zoom2d = component.zoom2d * 32 / component.modelAspectRatioX;
                    return;
                }
                if (component.originalWidth > 0) {
                    component.zoom2d = component.zoom2d * 32 / component.originalWidth;
                }
                return;
            }

            if (op == CC_IF_SETNPCHEAD) {
                component.objType = Component.OBJ_TYPE_NPCHEAD;
                component.obj = intStack[--intStackPointer];

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETPLAYERHEAD_SELF) {
                component.objType = Component.OBJ_TYPE_PLAYERHEAD;
                component.obj = -1;

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETNPCMODEL) {
                component.objType = Component.OBJ_TYPE_NPCMODEL;
                component.obj = intStack[--intStackPointer];

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETPLAYERMODEL) {
                component.objType = Component.OBJ_TYPE_PLAYERMODEL;
                component.obj = intStack[--intStackPointer];

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == 1206) {
                intStackPointer -= 4;

                component.skyBox = intStack[intStackPointer];
                component.skyBoxSphereOffsetX = intStack[intStackPointer + 1];
                component.skyBoxSphereOffsetY = intStack[intStackPointer + 2];
                component.skyBoxSphereOffsetZ = intStack[intStackPointer + 3];

                InterfaceManager.redraw(component);
                return;
            }

            if (op == 1207) {
                intStackPointer -= 2;

                component.skyboxRenderPitch = intStack[intStackPointer];
                component.skyboxRenderYaw = intStack[intStackPointer + 1];

                InterfaceManager.redraw(component);
                return;
            }

            if (op == CC_IF_SETOBJECT_DATA) {
                intStackPointer -= 4;

                component.obj = intStack[intStackPointer];
                component.objData = intStack[intStackPointer + 1];

                if (intStack[intStackPointer + 2] == 1) {
                    component.objType = Component.OBJ_TYPE_INVENTORY_FEMALE;
                } else {
                    component.objType = Component.OBJ_TYPE_INVENTORY_MALE;
                }

                if (intStack[intStackPointer + 3] == 1) {
                    component.objWearCol = true;
                } else {
                    component.objWearCol = false;
                }

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }

            if (op == CC_IF_SETPLAYERMODEL_SELF) {
                component.objType = Component.OBJ_TYPE_PLAYERMODEL;
                component.obj = PlayerList.activePlayerSlot;
                component.objData = 0;

                if (component.id == -1) {
                    DelayedStateChange.interfaceResetModel(component.slot);
                }
                return;
            }
        } else if (op >= 1300 && op < 1400 || op >= 2300 && op < 2400) {
            @Pc(220) Component component;
            if (op >= 2000) {
                op -= 1000;
                component = InterfaceList.list(intStack[--intStackPointer]);
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            if (op == CC_IF_SETOP) {
                @Pc(21) int opNum = intStack[--intStackPointer] - 1;

                if (opNum >= 0 && opNum <= 9) {
                    component.setOp(opNum, stringStack[--stringStackPointer]);
                    return;
                }

                stringStackPointer--;
                return;
            }

            if (op == CC_IF_SETDRAGGABLE) {
                intStackPointer -= 2;

                @Pc(21) int idAndSlot = intStack[intStackPointer];
                @Pc(27) int id = intStack[intStackPointer + 1];

                if (idAndSlot == -1 && id == -1) {
                    component.dragLayer = null;
                    return;
                }

                component.dragLayer = InterfaceList.getComponent(idAndSlot, id);
                return;
            }

            if (op == CC_IF_SETDRAGRENDERBEHAVIOUR) {
                @Pc(21) int behaviour = intStack[--intStackPointer];
                if (behaviour != DragRenderBehaviour.OFFSET_TRANSPARENT && behaviour != DragRenderBehaviour.FIXED && behaviour != DragRenderBehaviour.OFFSET) {
                    return;
                }

                component.dragRenderBehaviour = behaviour;
                return;
            }

            if (op == CC_IF_SETDRAGDEADZONE) {
                component.dragDeadZone = intStack[--intStackPointer];
                return;
            }

            if (op == CC_IF_SETDRAGDEADTIME) {
                component.dragDeadTime = intStack[--intStackPointer];
                return;
            }

            if (op == CC_IF_SETOPBASE) {
                component.opBase = stringStack[--stringStackPointer];
                return;
            }

            if (op == CC_IF_SETTARGETVERB) {
                component.targetVerb = stringStack[--stringStackPointer];
                return;
            }

            if (op == CC_IF_CLEAROPS) {
                component.ops = null;
                return;
            }

            if (op == CC_IF_SETTARGETCURSORS) {
                component.targetEndCursor = intStack[--intStackPointer];
                component.targetEnterCursor = intStack[--intStackPointer];
                return;
            }

            if (op == CC_IF_SETOPCURSOR) {
                @Pc(21) int cursor = intStack[--intStackPointer];
                @Pc(27) int opNum = intStack[--intStackPointer];

                if (opNum >= 1 && opNum <= 10) {
                    component.setOpCursor(opNum - 1, cursor);
                }
                return;
            }

            if (op == CC_IF_SETPAUSETEXT) {
                component.pauseText = stringStack[--stringStackPointer];
                return;
            }

            if (op == CC_IF_SETTARGETOPCURSOR) {
                component.targetOpCursor = intStack[--intStackPointer];
                return;
            }

            if (op == CC_IF_SETOPCHAR || op == CC_IF_SETOPKEY) {
                @Pc(21) int index;
                @Pc(27) int opKey;
                @Pc(506) int opChar;

                if (op == CC_IF_SETOPCHAR) {
                    intStackPointer -= 3;

                    index = intStack[intStackPointer] - 1;
                    opKey = intStack[intStackPointer + 1];
                    opChar = intStack[intStackPointer + 2];

                    if (index < 0 || index > 9) {
                        throw new RuntimeException("IOR13121313");
                    }
                } else {
                    intStackPointer -= 2;

                    index = 10;
                    opKey = intStack[intStackPointer];
                    opChar = intStack[intStackPointer + 1];
                }

                if (component.opKeys == null) {
                    if (opKey == 0) {
                        return;
                    }

                    component.opKeys = new byte[11];
                    component.opChars = new byte[11];
                    component.opKeyRates = new int[11];
                }

                component.opKeys[index] = (byte) opKey;

                if (opKey == 0) {
                    component.hasOpKey = false;

                    for (@Pc(2978) int i = 0; i < component.opKeys.length; i++) {
                        if (component.opKeys[i] != 0) {
                            component.hasOpKey = true;
                            break;
                        }
                    }
                } else {
                    component.hasOpKey = true;
                }

                component.opChars[index] = (byte) opChar;
                return;
            }

            if (op == CC_IF_SETMOUSEOVERCURSOR) {
                component.mouseOverCursor = intStack[--intStackPointer];
                return;
            }
        } else if (op >= 1400 && op < 1500 || op >= 2400 && op < 2500) {
            @Pc(220) Component component;
            if (op >= 2000) {
                op -= 1000;
                component = InterfaceList.list(intStack[--intStackPointer]);
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            if (op == CC_IF_CLEARSCRIPTHOOKS) {
                component.clearScriptHooks();
                return;
            }

            @Pc(1394) String argTypes = stringStack[--stringStackPointer];
            @Pc(3077) int[] triggers = null;
            if (argTypes.length() > 0 && argTypes.charAt(argTypes.length() - 1) == 'Y') {
                @Pc(506) int length = intStack[--intStackPointer];

                if (length > 0) {
                    triggers = new int[length];

                    while (length-- > 0) {
                        triggers[length] = intStack[--intStackPointer];
                    }
                }

                argTypes = argTypes.substring(0, argTypes.length() - 1);
            }

            @Pc(3131) Object[] args = new Object[argTypes.length() + 1];
            for (@Pc(2978) int i = args.length - 1; i >= 1; i--) {
                if (argTypes.charAt(i - 1) == 's') {
                    args[i] = stringStack[--stringStackPointer];
                } else if (argTypes.charAt(i - 1) == '§') {
                    args[i] = Long.valueOf(longStack[--longStackPointer]);
                } else {
                    args[i] = Integer.valueOf(intStack[--intStackPointer]);
                }
            }

            @Pc(72) int scriptId = intStack[--intStackPointer];
            if (scriptId == -1) {
                args = null;
            } else {
                args[0] = Integer.valueOf(scriptId);
            }

            if (op == CC_IF_SETONCLICK) {
                component.onClick = args;
            } else if (op == CC_IF_SETONHOLD) {
                component.onHold = args;
            } else if (op == CC_IF_SETONRELEASE) {
                component.onRelease = args;
            } else if (op == CC_IF_SETONMOUSEOVER) {
                component.onMouseOver = args;
            } else if (op == CC_IF_SETONMOUSELEAVE) {
                component.onMouseLeave = args;
            } else if (op == CC_IF_SETONDRAG) {
                component.onDrag = args;
            } else if (op == CC_IF_SETONTARGETLEAVE) {
                component.onTargetLeave = args;
            } else if (op == CC_IF_SETONVARTRANSMIT) {
                component.onVarTransmit = args;
                component.varpTriggers = triggers;
            } else if (op == CC_IF_SETONTIMER) {
                component.onTimer = args;
            } else if (op == CC_IF_SETONOP) {
                component.onOp = args;
            } else if (op == CC_IF_SETONDRAGCOMPLETE) {
                component.onDragComplete = args;
            } else if (op == CC_IF_SETONCLICKREPEAT) {
                component.onClickRepeat = args;
            } else if (op == CC_IF_SETONMOUSEREPEAT) {
                component.onMouseRepeat = args;
            } else if (op == CC_IF_SETONINVTRANSMIT) {
                component.onInvTransmit = args;
                component.inventoryTriggers = triggers;
            } else if (op == CC_IF_SETONSTATTRANSMIT) {
                component.onStatTransmit = args;
                component.statTriggers = triggers;
            } else if (op == CC_IF_SETONTARGETENTER) {
                component.onTargetEnter = args;
            } else if (op == CC_IF_SETONSCROLLWHEEL) {
                component.onScrollWheel = args;
            } else if (op == CC_IF_SETONCHATTRANSMIT) {
                component.onChatTransmit = args;
            } else if (op == CC_IF_SETONKEY) {
                component.onKey = args;
            } else if (op == CC_IF_SETONFRIENDTRANSMIT) {
                component.onFriendTransmit = args;
            } else if (op == CC_IF_SETONCLANTRANSMIT) {
                component.onClanTransmit = args;
            } else if (op == CC_IF_SETONMISCTRANSMIT) {
                component.onMiscTransmit = args;
            } else if (op == CC_IF_SETONDIALOGABORT) {
                component.onDialogAbort = args;
            } else if (op == CC_IF_SETONSUBCHANGE) {
                component.onSubChange = args;
            } else if (op == CC_IF_SETONSTOCKTRANSMIT) {
                component.onStockTransmit = args;
            } else if (op == CC_IF_SETONCAMFINISHED) {
                component.onCamFinished = args;
            } else if (op == CC_IF_SETONRESIZE) {
                component.onResize = args;
            } else if (op == CC_IF_SETONVARCTRANSMIT) {
                component.onVarcTransmit = args;
                component.varcTriggers = triggers;
            } else if (op == CC_IF_SETONVARCSTRTRANSMIT) {
                component.onVarcstrTransmit = args;
                component.varcstrTriggers = triggers;
            } else if (op == CC_IF_SETONOPT) {
                component.onOpT = args;
            } else if (op == CC_IF_SETONCLANSETTINGSTRANSMIT) {
                component.onClanSettingsTransmit = args;
            } else if (op == CC_IF_SETONCLANCHANNELTRANSMIT) {
                component.onClanChannelTransmit = args;
            } else if (op == CC_IF_SETONVARCLANTRANSMIT) {
                component.onVarclanTransmit = args;
            }

            component.hasHook = true;
            return;
        } else if (op < 1600) {
            @Pc(220) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;

            if (op == CC_GETX) {
                intStack[intStackPointer++] = createdComponent.x;
                return;
            }
            if (op == CC_GETY) {
                intStack[intStackPointer++] = createdComponent.y;
                return;
            }
            if (op == CC_GETWIDTH) {
                intStack[intStackPointer++] = createdComponent.width;
                return;
            }
            if (op == CC_GETHEIGHT) {
                intStack[intStackPointer++] = createdComponent.height;
                return;
            }
            if (op == CC_GETHIDE) {
                intStack[intStackPointer++] = createdComponent.hidden ? 1 : 0;
                return;
            }
            if (op == CC_GETLAYER) {
                intStack[intStackPointer++] = createdComponent.layer;
                return;
            }
            if (op == CC_GETPARENTLAYER) {
                @Pc(248) Component parent = InterfaceManager.getParentLayer(createdComponent);
                intStack[intStackPointer++] = parent == null ? -1 : parent.slot;
                return;
            }
            if (op == CC_GETCOLOUR) {
                intStack[intStackPointer++] = createdComponent.colour;
                return;
            }
        } else if (op < 1700) {
            @Pc(220) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;

            if (op == CC_GETSCROLLX) {
                intStack[intStackPointer++] = createdComponent.scrollX;
                return;
            }
            if (op == CC_GETSCROLLY) {
                intStack[intStackPointer++] = createdComponent.scrollY;
                return;
            }
            if (op == CC_GETTEXT) {
                stringStack[stringStackPointer++] = createdComponent.text;
                return;
            }
            if (op == CC_GETSCROLLWIDTH) {
                intStack[intStackPointer++] = createdComponent.scrollWidth;
                return;
            }
            if (op == CC_GETSCROLLHEIGHT) {
                intStack[intStackPointer++] = createdComponent.scrollHeight;
                return;
            }
            if (op == CC_GETMODELZOOM) {
                intStack[intStackPointer++] = createdComponent.zoom2d;
                return;
            }
            if (op == CC_GETMODELANGLE_X) {
                intStack[intStackPointer++] = createdComponent.xan2d;
                return;
            }
            if (op == CC_GETMODELANGLE_Z) {
                intStack[intStackPointer++] = createdComponent.zan2d;
                return;
            }
            if (op == CC_GETMODELANGLE_Y) {
                intStack[intStackPointer++] = createdComponent.yan2d;
                return;
            }
            if (op == CC_GETTRANS) {
                intStack[intStackPointer++] = createdComponent.transparency;
                return;
            }
            if (op == CC_GETMODELXOF) {
                intStack[intStackPointer++] = createdComponent.xof2d;
                return;
            }
            if (op == CC_GETMODELYOF) {
                intStack[intStackPointer++] = createdComponent.yof2d;
                return;
            }
            if (op == CC_GETGRAPHIC) {
                intStack[intStackPointer++] = createdComponent.graphic;
                return;
            }
            if (op == CC_PARAM) {
                @Pc(21) int id = intStack[--intStackPointer];
                @Pc(3848) ParamType paramType = ParamTypeList.instance.list(id);

                if (paramType.isString()) {
                    stringStack[stringStackPointer++] = createdComponent.param(paramType.defaultstr, id);
                    return;
                }

                intStack[intStackPointer++] = createdComponent.param(paramType.defaultint, id);
                return;
            }
            if (op == CC_GET2DANGLE) {
                intStack[intStackPointer++] = createdComponent.angle2d;
                return;
            }
            if (op == CC_GETMODEL) {
                intStack[intStackPointer++] = createdComponent.objType == Component.OBJ_TYPE_MODEL ? createdComponent.obj : -1;
                return;
            }
            if (op == CC_GETFONTGRAPHIC) {
                intStack[intStackPointer++] = createdComponent.fontGraphic;
                return;
            }
        } else if (op < 1800) {
            @Pc(220) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;

            if (op == CC_GETINVOBJECT) {
                intStack[intStackPointer++] = createdComponent.invObject;
                return;
            }
            if (op == CC_GETINVCOUNT) {
                if (createdComponent.invObject != -1) {
                    intStack[intStackPointer++] = createdComponent.invCount;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }
            if (op == CC_GETID) {
                intStack[intStackPointer++] = createdComponent.id;
                return;
            }
        } else if (op < 1900) {
            @Pc(220) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;

            if (op == CC_GETTARGETMASK) {
                intStack[intStackPointer++] = InterfaceManager.serverActiveProperties(createdComponent).getTargetMask();
                return;
            }

            if (op == CC_GETOP) {
                @Pc(21) int opNum = intStack[--intStackPointer];
                opNum--;

                if (createdComponent.ops != null && opNum < createdComponent.ops.length && createdComponent.ops[opNum] != null) {
                    stringStack[stringStackPointer++] = createdComponent.ops[opNum];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == CC_GETOPBASE) {
                if (createdComponent.opBase == null) {
                    stringStack[stringStackPointer++] = "";
                    return;
                }

                stringStack[stringStackPointer++] = createdComponent.opBase;
                return;
            }
        } else if (op < 2000 || op >= 2900 && op < 3000) {
            @Pc(220) Component component;
            if (op >= 2000) {
                component = InterfaceList.list(intStack[--intStackPointer]);
                op -= 1000;
            } else {
                component = unfocused ? unfocusedComponent : focusedComponent;
            }

            if (lastHookId >= 10) {
                throw new RuntimeException("C29xx-1");
            }

            if (op == CC_IF_CALLONRESIZE) {
                if (component.onResize == null) {
                    return;
                }

                @Pc(4169) HookRequest hook = new HookRequest();
                hook.source = component;
                hook.arguments = component.onResize;
                hook.id = lastHookId + 1;
                InterfaceManager.hookRequests.addLast(hook);
                return;
            }
        } else if (op < 2600) {
            @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);

            if (op == IF_GETX) {
                intStack[intStackPointer++] = component.x;
                return;
            }
            if (op == IF_GETY) {
                intStack[intStackPointer++] = component.y;
                return;
            }
            if (op == IF_GETWIDTH) {
                intStack[intStackPointer++] = component.width;
                return;
            }
            if (op == IF_GETHEIGHT) {
                intStack[intStackPointer++] = component.height;
                return;
            }
            if (op == IF_GETHIDE) {
                intStack[intStackPointer++] = component.hidden ? 1 : 0;
                return;
            }
            if (op == IF_GETLAYER) {
                intStack[intStackPointer++] = component.layer;
                return;
            }
            if (op == IF_GETPARENTLAYER) {
                @Pc(248) Component parent = InterfaceManager.getParentLayer(component);
                intStack[intStackPointer++] = parent == null ? -1 : parent.slot;
                return;
            }
            if (op == IF_GETCOLOUR) {
                intStack[intStackPointer++] = component.colour;
                return;
            }
        } else if (op < 2700) {
            @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);

            if (op == IF_GETSCROLLX) {
                intStack[intStackPointer++] = component.scrollX;
                return;
            }
            if (op == IF_GETSCROLLY) {
                intStack[intStackPointer++] = component.scrollY;
                return;
            }
            if (op == IF_GETTEXT) {
                stringStack[stringStackPointer++] = component.text;
                return;
            }
            if (op == IF_GETSCROLLWIDTH) {
                intStack[intStackPointer++] = component.scrollWidth;
                return;
            }
            if (op == IF_GETSCROLLHEIGHT) {
                intStack[intStackPointer++] = component.scrollHeight;
                return;
            }
            if (op == IF_GETMODELZOOM) {
                intStack[intStackPointer++] = component.zoom2d;
                return;
            }
            if (op == IF_GETMODELANGLE_X) {
                intStack[intStackPointer++] = component.xan2d;
                return;
            }
            if (op == IF_GETMODELANGLE_Z) {
                intStack[intStackPointer++] = component.zan2d;
                return;
            }
            if (op == IF_GETMODELANGLE_Y) {
                intStack[intStackPointer++] = component.yan2d;
                return;
            }
            if (op == IF_GETTRANS) {
                intStack[intStackPointer++] = component.transparency;
                return;
            }
            if (op == IF_GETMODELXOF) {
                intStack[intStackPointer++] = component.xof2d;
                return;
            }
            if (op == IF_GETMODELYOF) {
                intStack[intStackPointer++] = component.yof2d;
                return;
            }
            if (op == IF_GETGRAPHIC) {
                intStack[intStackPointer++] = component.graphic;
                return;
            }
            if (op == IF_GET2DANGLE) {
                intStack[intStackPointer++] = component.angle2d;
                return;
            }
            if (op == IF_GETMODEL) {
                intStack[intStackPointer++] = component.objType == Component.OBJ_TYPE_MODEL ? component.obj : -1;
                return;
            }
            if (op == IF_GETFONTGRAPHIC) {
                intStack[intStackPointer++] = component.fontGraphic;
                return;
            }
        } else if (op < 2800) {
            if (op == IF_GETINVOBJECT) {
                @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);
                intStack[intStackPointer++] = component.invObject;
                return;
            }

            if (op == IF_GETINVCOUNT) {
                @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);

                if (component.invObject != -1) {
                    intStack[intStackPointer++] = component.invCount;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == IF_HASSUB) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(4653) SubInterface sub = (SubInterface) InterfaceManager.subInterfaces.get(id);

                if (sub != null) {
                    intStack[intStackPointer++] = 1;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == IF_GETNEXTSUBID) {
                @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);
                if (component.staticComponents == null) {
                    intStack[intStackPointer++] = 0;
                    return;
                }

                @Pc(21) int next = component.staticComponents.length;
                for (@Pc(27) int i = 0; i < component.staticComponents.length; i++) {
                    if (component.staticComponents[i] == null) {
                        next = i;
                        break;
                    }
                }

                intStack[intStackPointer++] = next;
                return;
            }

            if (op == IF_HASSUBMODAL || op == IF_HASSUBOVERLAY) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int subId = intStack[intStackPointer + 1];
                @Pc(4760) SubInterface sub = (SubInterface) InterfaceManager.subInterfaces.get(id);

                if (sub != null && sub.id == subId) {
                    intStack[intStackPointer++] = 1;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }
        } else if (op < 2900) {
            @Pc(220) Component component = InterfaceList.list(intStack[--intStackPointer]);

            if (op == IF_GETTARGETMASK) {
                intStack[intStackPointer++] = InterfaceManager.serverActiveProperties(component).getTargetMask();
                return;
            }

            if (op == IF_GETOP) {
                @Pc(21) int opNum = intStack[--intStackPointer];
                opNum--;

                if (component.ops != null && opNum < component.ops.length && component.ops[opNum] != null) {
                    stringStack[stringStackPointer++] = component.ops[opNum];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == IF_GETOPBASE) {
                if (component.opBase == null) {
                    stringStack[stringStackPointer++] = "";
                    return;
                }
                stringStack[stringStackPointer++] = component.opBase;
                return;
            }
        } else if (op < 3200) {
            if (op == MES) {
                @Pc(4911) String message = stringStack[--stringStackPointer];
                ChatHistory.addScript(message);
                return;
            }

            if (op == 3101) {
                intStackPointer -= 2;
                PlayerEntity.animate(PlayerEntity.self, intStack[intStackPointer + 1], intStack[intStackPointer]);
                return;
            }

            if (op == IF_CLOSE) {
                InterfaceManager.close();
                return;
            }

            if (op == RESUME_COUNTDIALOG) {
                @Pc(4911) String input = stringStack[--stringStackPointer];

                @Pc(21) int count = 0;
                if (StringTools.isDecimal(input)) {
                    count = StringTools.parseDecimal(input);
                }

                @Pc(4974) ClientMessage message = ClientMessage.create(ClientProt.RESUME_P_COUNTDIALOG, ServerConnection.GAME.cipher);
                message.bitPacket.p4(count);
                ServerConnection.GAME.send(message);
                return;
            }

            if (op == RESUME_STRINGDIALOG) {
                @Pc(4911) String input = stringStack[--stringStackPointer];
                @Pc(5005) ClientMessage message = ClientMessage.create(ClientProt.RESUME_P_STRINGDIALOG, ServerConnection.GAME.cipher);
                message.bitPacket.p1(input.length() + 1);
                message.bitPacket.pjstr(input);
                ServerConnection.GAME.send(message);
                return;
            }

            if (op == RESUME_NAMEDIALOG) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                @Pc(5005) ClientMessage message = ClientMessage.create(ClientProt.RESUME_P_NAMEDIALOG, ServerConnection.GAME.cipher);
                message.bitPacket.p1(name.length() + 1);
                message.bitPacket.pjstr(name);
                ServerConnection.GAME.send(message);
                return;
            }

            if (op == OPPLAYER) {
                @Pc(15) int local15 = intStack[--intStackPointer];
                @Pc(1394) String local1394 = stringStack[--stringStackPointer];
                ThreeDView.doOpPlayer(local1394, local15);
                return;
            }

            if (op == IF_DRAGPICKUP) {
                intStackPointer -= 3;

                @Pc(15) int x = intStack[intStackPointer];
                @Pc(21) int y = intStack[intStackPointer + 1];
                @Pc(27) int id = intStack[intStackPointer + 2];
                @Pc(38) Component component = InterfaceList.list(id);

                InterfaceManager.dragTryPickup(component, x, y);
                return;
            }

            if (op == CC_DRAGPICKUP) {
                intStackPointer -= 2;

                @Pc(15) int x = intStack[intStackPointer];
                @Pc(21) int y = intStack[intStackPointer + 1];
                @Pc(303) Component createdComponent = unfocused ? unfocusedComponent : focusedComponent;

                InterfaceManager.dragTryPickup(createdComponent, x, y);
                return;
            }

            if (op == RESUME_OBJDIALOG) {
                @Pc(15) int objId = intStack[--intStackPointer];
                @Pc(5005) ClientMessage message = ClientMessage.create(ClientProt.RESUME_P_OBJDIALOG, ServerConnection.GAME.cipher);
                message.bitPacket.p2(objId);
                ServerConnection.GAME.send(message);
                return;
            }

            if (op == IF_OPENSUBCLIENT) {
                intStackPointer -= 2;

                @Pc(15) int idAndSlot = intStack[intStackPointer];
                @Pc(21) int subId = intStack[intStackPointer + 1];
                @Pc(4760) SubInterface sub = (SubInterface) InterfaceManager.subInterfaces.get(idAndSlot);

                if (sub != null) {
                    InterfaceManager.closeSubInterface(sub, sub.id != subId, true);
                }

                InterfaceManager.openSubInterface(3, subId, idAndSlot, true);
                return;
            }

            if (op == IF_CLOSESUBCLIENT) {
                intStackPointer--;

                @Pc(15) int idAndSlot = intStack[intStackPointer];
                @Pc(4653) SubInterface sub = (SubInterface) InterfaceManager.subInterfaces.get(idAndSlot);

                if (sub != null && sub.type == 3) {
                    InterfaceManager.closeSubInterface(sub, true, true);
                }
                return;
            }

            if (op == OPPLAYERT) {
                ThreeDView.doTargetPlayer(stringStack[--stringStackPointer]);
                return;
            }

            if (op == MES_TYPED) {
                intStackPointer -= 2;

                @Pc(15) int type = intStack[intStackPointer];
                @Pc(21) int flags = intStack[intStackPointer + 1];
                @Pc(1791) String message = stringStack[--stringStackPointer];

                ChatHistory.add(type, flags, "", "", "", message);
                return;
            }

            if (op == SETUP_MESSAGEBOX) {
                intStackPointer -= 11;

                @Pc(5320) HorizontalAlignment[] horizontalAlignments = HorizontalAlignment.values();
                @Pc(5323) VerticalAlignment[] verticalAlignments = VerticalAlignment.values();
                MessageBox.setup(horizontalAlignments[intStack[intStackPointer]], verticalAlignments[intStack[intStackPointer + 1]], intStack[intStackPointer + 2], intStack[intStackPointer + 3], intStack[intStackPointer + 4], intStack[intStackPointer + 5], intStack[intStackPointer + 6], intStack[intStackPointer + 7], intStack[intStackPointer + 8], intStack[intStackPointer + 9], intStack[intStackPointer + 10]);
                return;
            }

            if (op == RESUME_HSLDIALOG) {
                @Pc(15) int hsl = intStack[--intStackPointer];
                @Pc(5005) ClientMessage message = ClientMessage.create(ClientProt.RESUME_P_HSLDIALOG, ServerConnection.GAME.cipher);
                message.bitPacket.p2(hsl);
                ServerConnection.GAME.send(message);
                return;
            }

            if (op == RESUME_CLANFORUMQFCDIALOG) {
                @Pc(4911) String clanForumQfc = stringStack[--stringStackPointer];
                @Pc(5005) ClientMessage message = ClientMessage.create(ClientProt.A_CLIENT_PROT___82, ServerConnection.GAME.cipher);
                message.bitPacket.p1(clanForumQfc.length() + 1);
                message.bitPacket.pjstr(clanForumQfc);
                ServerConnection.GAME.send(message);
                return;
            }
        } else if (op < 3300) {
            if (op == SOUND_SYNTH) {
                intStackPointer -= 3;
                SoundManager.playSynthSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], 255, 256);
                return;
            }
            if (op == SOUND_SONG) {
                SoundManager.playMidiSong(intStack[--intStackPointer], 255, 50);
                return;
            }
            if (op == SOUND_JINGLE) {
                intStackPointer -= 2;
                SoundManager.playMidiJingle(intStack[intStackPointer], intStack[intStackPointer + 1], 255);
                return;
            }
            if (op == SOUND_SYTHN_VOLUME) {
                intStackPointer -= 4;
                SoundManager.playSynthSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], intStack[intStackPointer + 3], 256);
                return;
            }
            if (op == SOUND_SONG_VOLUME) {
                intStackPointer -= 3;
                SoundManager.playMidiSong(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2]);
                return;
            }
            if (op == SOUND_JINGLE_VOLUME) {
                intStackPointer -= 3;
                SoundManager.playMidiJingle(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2]);
                return;
            }
            if (op == SOUND_VORBIS_VOLUME) {
                intStackPointer -= 4;
                SoundManager.playVorbisSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], intStack[intStackPointer + 3], 256, false);
                return;
            }
            if (op == SOUND_SPEECH_VOLUME) {
                intStackPointer -= 4;
                SoundManager.playVorbisSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], intStack[intStackPointer + 3], 256, true);
                return;
            }
            if (op == SOUND_SYNTH_RATE) {
                intStackPointer -= 5;
                SoundManager.playSynthSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], intStack[intStackPointer + 3], intStack[intStackPointer + 4]);
                return;
            }
            if (op == SOUND_VORBIS_RATE) {
                intStackPointer -= 5;
                SoundManager.playVorbisSound(intStack[intStackPointer], intStack[intStackPointer + 1], intStack[intStackPointer + 2], intStack[intStackPointer + 3], intStack[intStackPointer + 4], false);
                return;
            }
        } else if (op < 3400) {
            if (op == CLIENTCLOCK) {
                intStack[intStackPointer++] = TimeUtils.clock;
                return;
            }

            if (op == INV_GETOBJ) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.get(id, slot, false);
                return;
            }

            if (op == INV_GETNUM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.count(id, slot, false);
                return;
            }

            if (op == INV_TOTAL) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.total(id, slot, false);
                return;
            }

            if (op == INV_SIZE) {
                @Pc(15) int id = intStack[--intStackPointer];
                intStack[intStackPointer++] = InvTypeList.instance.list(id).size;
                return;
            }

            if (op == STAT) {
                @Pc(15) int skill = intStack[--intStackPointer];
                intStack[intStackPointer++] = Static581.statLevels[skill];
                return;
            }

            if (op == STAT_BASE) {
                @Pc(15) int skill = intStack[--intStackPointer];
                intStack[intStackPointer++] = Static498.statBaseLevels[skill];
                return;
            }

            if (op == STAT_VISIBLE_XP) {
                @Pc(15) int skill = intStack[--intStackPointer];
                intStack[intStackPointer++] = Static237.statXps[skill];
                return;
            }

            if (op == COORD) {
                @Pc(5929) byte level = PlayerEntity.self.level;
                @Pc(21) int x = (PlayerEntity.self.x >> 9) + WorldMap.areaBaseX;
                @Pc(27) int z = (PlayerEntity.self.z >> 9) + WorldMap.areaBaseZ;
                intStack[intStackPointer++] = (level << 28) + (x << 14) + z;
                return;
            }

            if (op == COORDX) {
                @Pc(15) int x = intStack[--intStackPointer];
                intStack[intStackPointer++] = (x >> 14) & 0x3FFF;
                return;
            }

            if (op == COORDY) {
                @Pc(15) int y = intStack[--intStackPointer];
                intStack[intStackPointer++] = y >> 28;
                return;
            }

            if (op == COORDZ) {
                @Pc(15) int z = intStack[--intStackPointer];
                intStack[intStackPointer++] = z & 0x3FFF;
                return;
            }

            if (op == MAP_MEMBERS) {
                intStack[intStackPointer++] = Static174.mapMembers ? 1 : 0;
                return;
            }

            if (op == INVOTHER_GETOBJ) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.get(id, slot, true);
                return;
            }

            if (op == INVOTHER_GETNUM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.count(id, slot, true);
                return;
            }

            if (op == INVOTHER_TOTAL) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int slot = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.total(id, slot, true);
                return;
            }

            if (op == STAFFMODLEVEL) {
                if (Client.staffModLevel >= 2) {
                    intStack[intStackPointer++] = Client.staffModLevel;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == REBOOTTIMER) {
                intStack[intStackPointer++] = Static249.rebootTimer;
                return;
            }

            if (op == MAP_WORLD) {
                intStack[intStackPointer++] = ConnectionInfo.login.world;
                return;
            }

            if (op == RUNENERGY_VISIBLE) {
                intStack[intStackPointer++] = Static703.runEnergy;
                return;
            }

            if (op == RUNWEIGHT_VISIBLE) {
                intStack[intStackPointer++] = Static494.runWeight;
                return;
            }

            if (op == PLAYERMOD) {
                if (Static38.playerModLevel >= 5 && Static38.playerModLevel <= 9) {
                    intStack[intStackPointer++] = 1;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == PLAYERMODLEVEL) {
                if (Static38.playerModLevel >= 5 && Static38.playerModLevel <= 9) {
                    intStack[intStackPointer++] = Static38.playerModLevel;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == PLAYERMEMBER) {
                intStack[intStackPointer++] = Client.isMember ? 1 : 0;
                return;
            }

            if (op == COMLEVEL_ACTIVE) {
                intStack[intStackPointer++] = PlayerEntity.self.combatLevel;
                return;
            }

            if (op == GENDER) {
                intStack[intStackPointer++] = PlayerEntity.self.playerModel != null && PlayerEntity.self.playerModel.female ? 1 : 0;
                return;
            }

            if (op == MAP_QUICKCHAT) {
                intStack[intStackPointer++] = Static617.quickChatWorld ? 1 : 0;
                return;
            }

            if (op == INV_FREESPACE) {
                @Pc(15) int local15 = intStack[--intStackPointer];
                intStack[intStackPointer++] = ClientInventory.freeSpace(local15);
                return;
            }

            if (op == INV_TOTALPARAM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.totalParam(id, param, false);
                return;
            }

            if (op == INV_TOTALPARAM_STACK) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = ClientInventory.totalParam(id, param, true);
                return;
            }

            if (op == 3333) {
                intStack[intStackPointer++] = Static696.method9034();
                return;
            }

            if (op == MAP_LANG) {
                intStack[intStackPointer++] = Client.language;
                return;
            }

            if (op == MOVE_COORD) {
                intStackPointer -= 4;

                @Pc(15) int coord = intStack[intStackPointer];
                @Pc(21) int x = intStack[intStackPointer + 1];
                @Pc(27) int y = intStack[intStackPointer + 2];
                @Pc(506) int z = intStack[intStackPointer + 3];

                coord += x << 14;
                coord += y << 28;
                coord += z;

                intStack[intStackPointer++] = coord;
                return;
            }

            if (op == AFFILIATE) {
                intStack[intStackPointer++] = Client.affid;
                return;
            }

            if (op == PROFILE_CPU) {
                intStack[intStackPointer++] = Static65.profileCpu();
                return;
            }

            if (op == PLAYERDEMO) {
                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == APPLET_HASFOCUS) {
                intStack[intStackPointer++] = GameShell.focus ? 1 : 0;
                return;
            }

            if (op == FROMBILLING) {
                intStack[intStackPointer++] = Client.fromBilling ? 1 : 0;
                return;
            }

            if (op == GET_MOUSEX) {
                intStack[intStackPointer++] = MouseMonitor.instance.getRecordedX();
                return;
            }

            if (op == GET_MOUSEY) {
                intStack[intStackPointer++] = MouseMonitor.instance.getRecordedY();
                return;
            }

            if (op == GET_ACTIVE_MINIMENU_ENTRY) {
                stringStack[stringStackPointer++] = MiniMenu.activeEntry();
                return;
            }

            if (op == GET_SECOND_MINIMENU_ENTRY) {
                stringStack[stringStackPointer++] = MiniMenu.secondEntry();
                return;
            }

            if (op == GET_MINIMENU_LENGTH) {
                intStack[intStackPointer++] = MiniMenu.length();
                return;
            }

            if (op == GET_CURRENTCURSOR) {
                intStack[intStackPointer++] = Static470.currentCursor;
                return;
            }

            if (op == GET_SELFYANGLE) {
                intStack[intStackPointer++] = PlayerEntity.self.yaw.getValue(16383) >> 3;
                return;
            }

            if (op == MAP_ISOWNER) {
                @Pc(4911) String name = stringStack[--stringStackPointer];

                if (Static416.mapOwner != null && Static416.mapOwner.equalsIgnoreCase(name)) {
                    intStack[intStackPointer++] = 1;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == GET_MOUSEBUTTONS) {
                intStack[intStackPointer++] = MouseMonitor.instance.isLeftDown() ? 1 : 0;
                intStack[intStackPointer++] = MouseMonitor.instance.isMiddleDown() ? 1 : 0;
                intStack[intStackPointer++] = MouseMonitor.instance.isRightDown() ? 1 : 0;
                return;
            }
        } else if (op < 3500) {
            if (op == ENUM_STRING) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int key = intStack[intStackPointer + 1];
                @Pc(6822) EnumType enumType = EnumTypeList.instance.list(id);

                stringStack[stringStackPointer++] = enumType.getString(key);
                return;
            }

            if (op == ENUM) {
                intStackPointer -= 4;

                @Pc(15) int keyType = intStack[intStackPointer];
                @Pc(21) int valType = intStack[intStackPointer + 1];
                @Pc(27) int id = intStack[intStackPointer + 2];
                @Pc(506) int key = intStack[intStackPointer + 3];
                @Pc(6868) EnumType enumType = EnumTypeList.instance.list(id);

                if (enumType.keyType == keyType && enumType.valType == valType) {
                    if (valType == 's') {
                        stringStack[stringStackPointer++] = enumType.getString(key);
                        return;
                    }

                    intStack[intStackPointer++] = enumType.getInt(key);
                    return;
                }

                throw new RuntimeException("C3408-1 " + id + "-" + key);
            }

            if (op == ENUM_HASOUTPUT) {
                intStackPointer -= 3;

                @Pc(15) int valType = intStack[intStackPointer];
                @Pc(21) int id = intStack[intStackPointer + 1];
                @Pc(27) int key = intStack[intStackPointer + 2];
                if (id == -1) {
                    throw new RuntimeException("C3409-2");
                }

                @Pc(6963) EnumType enumType = EnumTypeList.instance.list(id);
                if (enumType.valType != valType) {
                    throw new RuntimeException("C3409-1");
                }

                intStack[intStackPointer++] = enumType.hasOutput(key) ? 1 : 0;
                return;
            }

            if (op == ENUM_HASOUTPUT_STRING) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(1394) String key = stringStack[--stringStackPointer];
                if (id == -1) {
                    throw new RuntimeException("C3410-2");
                }

                @Pc(6822) EnumType enumType = EnumTypeList.instance.list(id);
                if (enumType.valType != 's') {
                    throw new RuntimeException("C3410-1");
                }

                intStack[intStackPointer++] = enumType.hasOutputString(key) ? 1 : 0;
                return;
            }

            if (op == ENUM_GETOUTPUT_COUNT) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(7072) EnumType enumType = EnumTypeList.instance.list(id);
                intStack[intStackPointer++] = enumType.getOutputCount();
                return;
            }

            if (op == ENUM_GETREVERSECOUNT) {
                intStackPointer -= 3;

                @Pc(15) int valType = intStack[intStackPointer];
                @Pc(21) int id = intStack[intStackPointer + 1];
                @Pc(27) int key = intStack[intStackPointer + 2];
                if (id == -1) {
                    throw new RuntimeException();
                }

                @Pc(6963) EnumType enumMapping = EnumTypeList.instance.list(id);
                if (enumMapping.valType != valType) {
                    throw new RuntimeException();
                }

                @Pc(7133) EnumMapping mapping = enumMapping.getReversed(key);
                @Pc(72) int count = 0;
                if (mapping != null) {
                    count = mapping.index.length;
                }

                intStack[intStackPointer++] = count;
                return;
            }

            if (op == ENUM_GETREVERSECOUNT_STRING) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(1394) String key = stringStack[--stringStackPointer];
                if (id == -1) {
                    throw new RuntimeException();
                }

                @Pc(6822) EnumType enumType = EnumTypeList.instance.list(id);
                if (enumType.valType != 's') {
                    throw new RuntimeException();
                }

                @Pc(7196) EnumStringMapping mapping = enumType.getReversed(key);
                @Pc(2978) int count = 0;
                if (mapping != null) {
                    count = mapping.index.length;
                }

                intStack[intStackPointer++] = count;
                return;
            }

            if (op == ENUM_GETREVERSEINDEX) {
                intStackPointer -= 5;

                @Pc(15) int valType = intStack[intStackPointer];
                @Pc(21) int keyType = intStack[intStackPointer + 1];
                @Pc(27) int id = intStack[intStackPointer + 2];
                @Pc(506) int key = intStack[intStackPointer + 3];
                @Pc(2978) int index = intStack[intStackPointer + 4];
                if (id == -1) {
                    throw new RuntimeException();
                }

                @Pc(7261) EnumType enumType = EnumTypeList.instance.list(id);
                if (enumType.keyType != keyType) {
                    throw new RuntimeException();
                }
                if (enumType.valType != valType) {
                    throw new RuntimeException();
                }

                @Pc(7284) EnumMapping mapping = enumType.getReversed(key);
                if (index >= 0 && mapping != null && mapping.index.length > index) {
                    intStack[intStackPointer++] = mapping.index[index];
                    return;
                }

                throw new RuntimeException();
            }

            if (op == ENUM_GETREVERSEINDEX_STRING) {
                intStackPointer -= 3;

                @Pc(15) int keyType = intStack[intStackPointer];
                @Pc(21) int id = intStack[intStackPointer + 1];
                @Pc(27) int local27 = intStack[intStackPointer + 2];
                @Pc(7345) String key = stringStack[--stringStackPointer];
                if (id == -1) {
                    throw new RuntimeException();
                }

                @Pc(6868) EnumType enumType = EnumTypeList.instance.list(id);
                if (enumType.keyType != keyType) {
                    throw new RuntimeException();
                }
                if (enumType.valType != 's') {
                    throw new RuntimeException();
                }

                @Pc(7381) EnumStringMapping mapping = enumType.getReversed(key);
                if (local27 >= 0 && mapping != null && mapping.index.length > local27) {
                    intStack[intStackPointer++] = mapping.index[local27];
                    return;
                }

                throw new RuntimeException();
            }
        } else if (op < 3700) {
            if (op == FRIEND_COUNT) {
                if (FriendsList.status == 0) {
                    intStack[intStackPointer++] = -2;
                    return;
                }

                if (FriendsList.status == 1) {
                    intStack[intStackPointer++] = -1;
                    return;
                }

                intStack[intStackPointer++] = FriendsList.count;
                return;
            }

            if (op == FRIEND_GETNAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status == 2 && index < FriendsList.count) {
                    stringStack[stringStackPointer++] = FriendsList.names[index];

                    if (FriendsList.formerNames[index] != null) {
                        stringStack[stringStackPointer++] = FriendsList.formerNames[index];
                        return;
                    }

                    stringStack[stringStackPointer++] = "";
                    return;
                }

                stringStack[stringStackPointer++] = "";
                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == FRIEND_GETWORLD) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status == 2 && index < FriendsList.count) {
                    intStack[intStackPointer++] = FriendsList.worlds[index];
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == FRIEND_GETRANK) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status == 2 && index < FriendsList.count) {
                    intStack[intStackPointer++] = FriendsList.ranks[index];
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == FRIEND_SETRANK) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                @Pc(21) int rank = intStack[--intStackPointer];
                FriendsList.setRank(name, rank);
                return;
            }

            if (op == FRIEND_ADD) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                FriendsList.add(name);
                return;
            }

            if (op == FRIEND_DEL) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                FriendsList.delete(name);
                return;
            }

            if (op == IGNORE_ADD) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                IgnoreList.add(name, false);
                return;
            }

            if (op == IGNORE_DEL) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                IgnoreList.delete(name);
                return;
            }

            if (op == FRIEND_TEST) {
                @Pc(4911) String name = stringStack[--stringStackPointer];

                if (name.startsWith("<img=0>") || name.startsWith("<img=1>")) {
                    name = name.substring(7);
                }

                intStack[intStackPointer++] = FriendsList.contains(0, name) ? 1 : 0;
                return;
            }

            if (op == FRIEND_GETWORLDNAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status == 2 && index < FriendsList.count) {
                    stringStack[stringStackPointer++] = FriendsList.worldNames[index];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == CLAN_GETCHATDISPLAYNAME) {
                if (FriendChat.name != null) {
                    stringStack[stringStackPointer++] = NameTools.normalise(FriendChat.name);
                    return;
                }
                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == CLAN_GETCHATCOUNT) {
                if (FriendChat.name != null) {
                    intStack[intStackPointer++] = FriendChat.count;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == CLAN_GETCHATUSERNAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendChat.name != null && index < FriendChat.count) {
                    stringStack[stringStackPointer++] = FriendChat.users[index].name;
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == CLAN_GETCHATUSERWORLD) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendChat.name != null && index < FriendChat.count) {
                    intStack[intStackPointer++] = FriendChat.users[index].world;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == CLAN_GETCHATUSERRANK) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendChat.name != null && index < FriendChat.count) {
                    intStack[intStackPointer++] = FriendChat.users[index].rank;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == CLAN_GETCHATMINKICK) {
                intStack[intStackPointer++] = FriendChat.kickRank;
                return;
            }

            if (op == CLAN_KICKUSER) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                FriendChat.kick(name);
                return;
            }

            if (op == CLAN_GETCHATRANK) {
                intStack[intStackPointer++] = FriendChat.rank;
                return;
            }

            if (op == CLAN_JOINCHAT) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                FriendChat.join(name);
                return;
            }

            if (op == CLAN_LEAVECHAT) {
                FriendChat.leave();
                return;
            }

            if (op == IGNORE_COUNT) {
                if (FriendsList.status == 0) {
                    intStack[intStackPointer++] = -1;
                    return;
                }

                intStack[intStackPointer++] = IgnoreList.count;
                return;
            }

            if (op == IGNORE_GETNAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status != 0 && index < IgnoreList.count) {
                    stringStack[stringStackPointer++] = IgnoreList.names[index];

                    if (IgnoreList.formerNames[index] != null) {
                        stringStack[stringStackPointer++] = IgnoreList.formerNames[index];
                        return;
                    }

                    stringStack[stringStackPointer++] = "";
                    return;
                }

                stringStack[stringStackPointer++] = "";
                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == IGNORE_TEXT) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                if (name.startsWith("<img=0>") || name.startsWith("<img=1>")) {
                    name = name.substring(7);
                }

                intStack[intStackPointer++] = IgnoreList.contains(name) ? 1 : 0;
                return;
            }

            if (op == CLAN_ISSELF) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendChat.users != null && index < FriendChat.count && FriendChat.users[index].accountName.equalsIgnoreCase(PlayerEntity.self.accountName)) {
                    intStack[intStackPointer++] = 1;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == CLAN_GETCHATOWNERNAME) {
                if (FriendChat.owner != null) {
                    stringStack[stringStackPointer++] = FriendChat.owner;
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == CLAN_GETCHATUSERWORLDNAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendChat.name != null && index < FriendChat.count) {
                    stringStack[stringStackPointer++] = FriendChat.users[index].worldName;
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == FRIEND_SAME_GAME) {
                @Pc(15) int index = intStack[--intStackPointer];

                if (FriendsList.status == 2 && index >= 0 && index < FriendsList.count) {
                    intStack[intStackPointer++] = FriendsList.sameGameFlags[index] ? 1 : 0;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == FRIEND_GETSLOTFROMNAME) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                if (name.startsWith("<img=0>") || name.startsWith("<img=1>")) {
                    name = name.substring(7);
                }

                intStack[intStackPointer++] = Static664.method8658(name);
                return;
            }

            if (op == PLAYERCOUNTRY) {
                intStack[intStackPointer++] = Client.country;
                return;
            }

            if (op == IGNORE_ADD_TEMP) {
                @Pc(4911) String name = stringStack[--stringStackPointer];
                IgnoreList.add(name, true);
                return;
            }

            if (op == IGNORE_IS_TEMP) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = IgnoreList.temporary[index] ? 1 : 0;
                return;
            }

            if (op == CLAN_GETCHATUSERNAME_UNFILTERED) {
                @Pc(15) int index = intStack[--intStackPointer];
                if (FriendChat.name != null && index < FriendChat.count) {
                    stringStack[stringStackPointer++] = FriendChat.users[index].accountName;
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == IGNORE_GETNAME_UNFILTERED) {
                @Pc(15) int index = intStack[--intStackPointer];
                if (FriendsList.status != 0 && index < IgnoreList.count) {
                    stringStack[stringStackPointer++] = IgnoreList.accountNames[index];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == FRIEND_IS_REFERRED) {
                @Pc(15) int index = intStack[--intStackPointer];
                if (FriendsList.status == 2 && index < FriendsList.count) {
                    intStack[intStackPointer++] = FriendsList.referredFlags[index] ? 1 : 0;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }
        } else if (op < 3800) {
            if (op == ACTIVELCANSETTINGS_FIND_LISTENED) {
                if (ClanSettings.listened != null) {
                    intStack[intStackPointer++] = 1;
                    clanSettings = ClanSettings.listened;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == ACTIVECLANSETTINGS_FIND_AFFINED) {
                if (ClanSettings.affined != null) {
                    intStack[intStackPointer++] = 1;
                    clanSettings = ClanSettings.affined;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETCLANNAME) {
                stringStack[stringStackPointer++] = clanSettings.name;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETALLOWUNAFFINED) {
                intStack[intStackPointer++] = clanSettings.allowNonMembers ? 1 : 0;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETRANKTALK) {
                intStack[intStackPointer++] = clanSettings.rankTalk;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETRANKKICK) {
                intStack[intStackPointer++] = clanSettings.rankKick;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETRANKLOOTSHARE) {
                intStack[intStackPointer++] = clanSettings.rankLootShare;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETCOINSHARE) {
                intStack[intStackPointer++] = clanSettings.coinshare;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDCOUNT) {
                intStack[intStackPointer++] = clanSettings.affinedCount;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDDISPLAYNAME) {
                @Pc(15) int index = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = clanSettings.affinedDisplayNames[index];
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDRANK) {
                @Pc(15) int local15 = intStack[--intStackPointer];
                intStack[intStackPointer++] = clanSettings.affinedRanks[local15];
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETBANNEDCOUNT) {
                intStack[intStackPointer++] = clanSettings.bannedCount;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETBANNEDDISPLAYNAME) {
                @Pc(15) int index = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = clanSettings.bannedDisplayNames[index];
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDEXTRAINFO) {
                intStackPointer -= 3;
                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int startBit = intStack[intStackPointer + 1];
                @Pc(27) int endBit = intStack[intStackPointer + 2];
                intStack[intStackPointer++] = clanSettings.getAffinedExtraInfo(id, startBit, endBit);
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETCURRENTOWNER_SLOT) {
                intStack[intStackPointer++] = clanSettings.currentOwnerSlot;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETREPLACEMENTOWNER_SLOT) {
                intStack[intStackPointer++] = clanSettings.replacementOwnerSlot;
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDSLOT) {
                intStack[intStackPointer++] = clanSettings.affinedSlot(stringStack[--stringStackPointer]);
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETSORTEDAFFINEDSLOT) {
                intStack[intStackPointer - 1] = clanSettings.sortedAffinedSlots()[intStack[intStackPointer - 1]];
                return;
            }

            if (op == AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL) {
                Static180.ban(intStack[--intStackPointer]);
                return;
            }

            if (op == ACTIVECLANSETTINGS_GETAFFINEDJOINRUNEDAY) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = clanSettings.affinedJoinRuneday[index];
                return;
            }

            if (op == ACTIVECLANCHANNEL_FIND_LISTENED) {
                if (ClanChannel.listened != null) {
                    intStack[intStackPointer++] = 1;
                    clanChannel = ClanChannel.listened;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == ACTIVECLANCHANNEL_FIND_AFFINED) {
                if (ClanChannel.affined != null) {
                    intStack[intStackPointer++] = 1;
                    clanChannel = ClanChannel.affined;
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETCLANNAME) {
                stringStack[stringStackPointer++] = clanChannel.clanName;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETRANKKICK) {
                intStack[intStackPointer++] = clanChannel.kickRank;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETRANKTALK) {
                intStack[intStackPointer++] = clanChannel.talkRank;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETUSERCOUNT) {
                intStack[intStackPointer++] = clanChannel.userCount;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETUSERDISPLAYNAME) {
                @Pc(15) int index = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = clanChannel.users[index].displayName;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETUSERRANK) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = clanChannel.users[index].rank;
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETUSERWORLD) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = clanChannel.users[index].world;
                return;
            }

            if (op == ACTIVECLANCHANNEL_KICKUSER) {
                @Pc(15) int index = intStack[--intStackPointer];
                Static525.kick(index, clanChannel == ClanChannel.affined);
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETUSERSLOT) {
                intStack[intStackPointer++] = clanChannel.userSlot(stringStack[--stringStackPointer]);
                return;
            }

            if (op == ACTIVECLANCHANNEL_GETSORTEDUSERSLOT) {
                intStack[intStackPointer - 1] = clanChannel.sortedUserSlots()[intStack[intStackPointer - 1]];
                return;
            }

            if (op == CLANPROFILE_FIND) {
                intStack[intStackPointer++] = Static279.clanVars == null ? 0 : 1;
                return;
            }
        } else if (op < 4000) {
            if (op == STOCKMARKET_GETOFFERTYPE) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].getOfferType();
                return;
            }

            if (op == STOCKMARKET_GETOFFERITEM) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].objId;
                return;
            }

            if (op == STOCKMARKET_GETOFFERPRICE) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].price;
                return;
            }

            if (op == STOCKMARKET_GETOFFERCOUNT) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].count;
                return;
            }

            if (op == STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].completedCount;
                return;
            }

            if (op == STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
                @Pc(15) int index = intStack[--intStackPointer];
                intStack[intStackPointer++] = StockmarketManager.offers[index].completedGold;
                return;
            }

            if (op == STOCKMARKET_ISOFFEREMPTY) {
                @Pc(15) int index = intStack[--intStackPointer];
                @Pc(21) int status = StockmarketManager.offers[index].getStatus();
                intStack[intStackPointer++] = status == 0 ? 1 : 0;
                return;
            }

            if (op == STOCKMARKET_ISOFFERSTABLE) {
                @Pc(15) int index = intStack[--intStackPointer];
                @Pc(21) int status = StockmarketManager.offers[index].getStatus();
                intStack[intStackPointer++] = status == 2 ? 1 : 0;
                return;
            }

            if (op == STOCKMARKET_ISOFFERFINISHED) {
                @Pc(15) int index = intStack[--intStackPointer];
                @Pc(21) int status = StockmarketManager.offers[index].getStatus();
                intStack[intStackPointer++] = status == 5 ? 1 : 0;
                return;
            }

            if (op == STOCKMARKET_ISOFFERADDING) {
                @Pc(15) int index = intStack[--intStackPointer];
                @Pc(21) int status = StockmarketManager.offers[index].getStatus();
                intStack[intStackPointer++] = status == 1 ? 1 : 0;
                return;
            }
        } else if (op < 4100) {
            if (op == ADD) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a + b;
                return;
            }

            if (op == SUB) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a - b;
                return;
            }

            if (op == MULTIPLY) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a * b;
                return;
            }

            if (op == DIVIDE) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a / b;
                return;
            }

            if (op == RANDOM) {
                @Pc(15) int v = intStack[--intStackPointer];
                intStack[intStackPointer++] = (int) (Math.random() * (double) v);
                return;
            }

            if (op == RANDOMINC) {
                @Pc(15) int v = intStack[--intStackPointer];
                intStack[intStackPointer++] = (int) (Math.random() * (double) (v + 1));
                return;
            }

            if (op == INTERPOLATE) {
                intStackPointer -= 5;

                @Pc(15) int y0 = intStack[intStackPointer];
                @Pc(21) int y1 = intStack[intStackPointer + 1];
                @Pc(27) int x0 = intStack[intStackPointer + 2];
                @Pc(506) int x1 = intStack[intStackPointer + 3];
                @Pc(2978) int x2 = intStack[intStackPointer + 4];

                intStack[intStackPointer++] = y0 + (y1 - y0) * (x2 - x0) / (x1 - x0);
                return;
            }

            if (op == ADDPERCENT) {
                intStackPointer -= 2;

                @Pc(9705) long a = intStack[intStackPointer];
                @Pc(9712) long b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = (int) (a + ((a * b) / 100L));
                return;
            }

            if (op == SETBIT) {
                intStackPointer -= 2;

                @Pc(15) int v = intStack[intStackPointer];
                @Pc(21) int bit = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = v | (0x1 << bit);
                return;
            }

            if (op == CLEARBIT) {
                intStackPointer -= 2;

                @Pc(15) int v = intStack[intStackPointer];
                @Pc(21) int bit = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = v & -(0x1 << bit) - 1;
                return;
            }

            if (op == TESTBIT) {
                intStackPointer -= 2;

                @Pc(15) int v = intStack[intStackPointer];
                @Pc(21) int bit = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = (v & 0x1 << bit) == 0 ? 0 : 1;
                return;
            }

            if (op == MODULO) {
                intStackPointer -= 2;

                @Pc(15) int local15 = intStack[intStackPointer];
                @Pc(21) int local21 = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = local15 % local21;
                return;
            }

            if (op == POW) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                if (a == 0) {
                    intStack[intStackPointer++] = 0;
                    return;
                }

                intStack[intStackPointer++] = (int) Math.pow(a, b);
                return;
            }

            if (op == INVPOW) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                if (a == 0) {
                    intStack[intStackPointer++] = 0;
                    return;
                }

                if (b == 0) {
                    intStack[intStackPointer++] = Integer.MAX_VALUE;
                    return;
                }

                intStack[intStackPointer++] = (int) Math.pow(a, 1.0D / (double) b);
                return;
            }

            if (op == AND) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a & b;
                return;
            }

            if (op == OR) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a | b;
                return;
            }

            if (op == MIN) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a < b ? a : b;
                return;
            }

            if (op == MAX) {
                intStackPointer -= 2;

                @Pc(15) int a = intStack[intStackPointer];
                @Pc(21) int b = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = a > b ? a : b;
                return;
            }

            if (op == SCALE) {
                intStackPointer -= 3;

                @Pc(9705) long a = intStack[intStackPointer];
                @Pc(9712) long denominator = intStack[intStackPointer + 1];
                @Pc(10099) long numerator = intStack[intStackPointer + 2];

                intStack[intStackPointer++] = (int) ((a * numerator) / denominator);
                return;
            }

            if (op == RANDOM_SOUND_PITCH) {
                intStackPointer -= 2;

                @Pc(15) int min = intStack[intStackPointer];
                @Pc(21) int max = intStack[intStackPointer + 1];
                if (min > 700 || max > 700) {
                    intStack[intStackPointer++] = 256;
                }

                @Pc(10162) double local10162 = (Math.random() * (double) (max + min) + 800.0D - (double) min) / 100.0D;
                intStack[intStackPointer++] = (int) (Math.pow(2.0D, local10162) + 0.5D);
                return;
            }

            if (op == HSVTORGB) {
                @Pc(15) int local15 = intStack[--intStackPointer];
                intStack[intStackPointer++] = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(local15) & 0xFFFF];
                return;
            }
        } else if (op < 4200) {
            if (op == APPEND_NUM) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                @Pc(21) int number = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = text + number;
                return;
            }

            if (op == APPEND) {
                stringStackPointer -= 2;
                @Pc(4911) String a = stringStack[stringStackPointer];
                @Pc(1394) String b = stringStack[stringStackPointer + 1];
                stringStack[stringStackPointer++] = a + b;
                return;
            }

            if (op == APPEND_SIGNNUM) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                @Pc(21) int num = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = text + StringTools.decimalWithSign(true, num);
                return;
            }

            if (op == LOWERCASE) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                stringStack[stringStackPointer++] = text.toLowerCase();
                return;
            }

            if (op == FROMDATE) {
                stringStack[stringStackPointer++] = TimeUtils.dateFromTime(TimeUtils.timeFromRunedays(intStack[--intStackPointer]), Client.language);
                return;
            }

            if (op == TEXT_GENDER) {
                stringStackPointer -= 2;

                @Pc(4911) String male = stringStack[stringStackPointer];
                @Pc(1394) String female = stringStack[stringStackPointer + 1];
                if (PlayerEntity.self.playerModel != null && PlayerEntity.self.playerModel.female) {
                    stringStack[stringStackPointer++] = female;
                    return;
                }

                stringStack[stringStackPointer++] = male;
                return;
            }

            if (op == TOSTRING) {
                @Pc(15) int i = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = Integer.toString(i);
                return;
            }

            if (op == COMPARE) {
                stringStackPointer -= 2;
                intStack[intStackPointer++] = Static540.compare(stringStack[stringStackPointer + 1], Client.language, stringStack[stringStackPointer]);
                return;
            }

            if (op == PARAHEIGHT) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                intStackPointer -= 2;

                @Pc(21) int lineWidth = intStack[intStackPointer];
                @Pc(27) int font = intStack[intStackPointer + 1];
                @Pc(10482) FontMetrics metrics = FontMetrics.loadGroup(js5.FONTMETRICS, font);

                intStack[intStackPointer++] = metrics.paraHeight(text, Sprites.nameIcons, lineWidth);
                return;
            }

            if (op == PARAWIDTH) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                intStackPointer -= 2;

                @Pc(21) int lineWidth = intStack[intStackPointer];
                @Pc(27) int font = intStack[intStackPointer + 1];
                @Pc(10482) FontMetrics metrics = FontMetrics.loadGroup(js5.FONTMETRICS, font);

                intStack[intStackPointer++] = metrics.paraWidth(Sprites.nameIcons, text, lineWidth);
                return;
            }

            if (op == TEXT_SWITCH) {
                stringStackPointer -= 2;

                @Pc(4911) String a = stringStack[stringStackPointer];
                @Pc(1394) String b = stringStack[stringStackPointer + 1];
                if (intStack[--intStackPointer] == 1) {
                    stringStack[stringStackPointer++] = a;
                    return;
                }

                stringStack[stringStackPointer++] = b;
                return;
            }

            if (op == ESCAPE) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                stringStack[stringStackPointer++] = StringTools.escapeBrackets(text);
                return;
            }

            if (op == APPEND_CHAR) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                @Pc(21) int c = intStack[--intStackPointer];
                if (c == -1) {
                    throw new RuntimeException("null char");
                }

                stringStack[stringStackPointer++] = text + (char) c;
                return;
            }

            if (op == CHAR_ISPRINTABLE) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = charIsPrintable((char) c);
                return;
            }

            if (op == CHAR_ISALPHANUMERIC) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = StringTools.isAlphanumeric((char) c) ? 1 : 0;
                return;
            }

            if (op == CHAR_ISALPHA) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = StringTools.isAlphabetical((char) c) ? 1 : 0;
                return;
            }

            if (op == CHAR_ISNUMERIC) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = StringTools.isNumeric((char) c) ? 1 : 0;
                return;
            }

            if (op == STRING_LENGTH) {
                @Pc(4911) String text = stringStack[--stringStackPointer];

                if (text != null) {
                    intStack[intStackPointer++] = text.length();
                    return;
                }

                intStack[intStackPointer++] = 0;
                return;
            }

            if (op == SUBSTRING) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                intStackPointer -= 2;

                @Pc(21) int beginIndex = intStack[intStackPointer];
                @Pc(27) int endIndex = intStack[intStackPointer + 1];

                stringStack[stringStackPointer++] = text.substring(beginIndex, endIndex);
                return;
            }

            if (op == REMOVETAGS) {
                @Pc(4911) String text = stringStack[--stringStackPointer];

                @Pc(10848) StringBuffer buffer = new StringBuffer(text.length());
                @Pc(10850) boolean escaped = false;

                for (@Pc(506) int i = 0; i < text.length(); i++) {
                    @Pc(10857) char c = text.charAt(i);

                    if (c == '<') {
                        escaped = true;
                    } else if (c == '>') {
                        escaped = false;
                    } else if (!escaped) {
                        buffer.append(c);
                    }
                }

                stringStack[stringStackPointer++] = buffer.toString();
                return;
            }

            if (op == STRING_INDEXOF_CHAR) {
                @Pc(4911) String string = stringStack[--stringStackPointer];
                intStackPointer -= 2;

                @Pc(21) int c = intStack[intStackPointer];
                @Pc(27) int fromIndex = intStack[intStackPointer + 1];

                intStack[intStackPointer++] = string.indexOf(c, fromIndex);
                return;
            }

            if (op == STRING_INDEXOF_STRING) {
                stringStackPointer -= 2;

                @Pc(4911) String string = stringStack[stringStackPointer];
                @Pc(1394) String str = stringStack[stringStackPointer + 1];
                @Pc(27) int fromIndex = intStack[--intStackPointer];

                intStack[intStackPointer++] = string.indexOf(str, fromIndex);
                return;
            }

            if (op == CHAR_TOLOWERCASE) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = Character.toLowerCase((char) c);
                return;
            }

            if (op == CHAR_TOUPPERCASE) {
                @Pc(15) int c = intStack[--intStackPointer];
                intStack[intStackPointer++] = Character.toUpperCase((char) c);
                return;
            }

            if (op == TOSTRING_LOCALISED) {
                @Pc(575) boolean delimit = intStack[--intStackPointer] != 0;
                @Pc(21) int value = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = StringTools.formatNumber(Client.language, delimit, value, 0);
                return;
            }

            if (op == STRINGWIDTH) {
                @Pc(4911) String string = stringStack[--stringStackPointer];
                @Pc(21) int font = intStack[--intStackPointer];
                @Pc(11077) FontMetrics metrics = FontMetrics.loadGroup(js5.FONTMETRICS, font);

                intStack[intStackPointer++] = metrics.stringWidth(Sprites.nameIcons, string);
                return;
            }

            if (op == FORMAT_DATETIME_FROM_MINUTES) {
                stringStack[stringStackPointer++] = TimeUtils.datetimeFromTime((long) intStack[--intStackPointer] * TimeUtils.MILLISECONDS_PER_MINUTE, Client.language) + " UTC";
                return;
            }

            if (op == CLANFORUMQFC_TOSTRING) {
                @Pc(9705) long local9705 = longStack[--longStackPointer];
                stringStack[stringStackPointer++] = local9705 == -1L ? "" : Long.toString(local9705, 36).toUpperCase();
                return;
            }
        } else if (op < 4300) {
            if (op == OC_NAME) {
                @Pc(15) int id = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = ObjTypeList.instance.list(id).name;
                return;
            }

            if (op == OC_OP) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int opNum = intStack[intStackPointer + 1];
                @Pc(11206) ObjType objType = ObjTypeList.instance.list(id);

                if (opNum >= 1 && opNum <= 5 && objType.op[opNum - 1] != null) {
                    stringStack[stringStackPointer++] = objType.op[opNum - 1];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == OC_IOP) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int opNum = intStack[intStackPointer + 1];
                @Pc(11206) ObjType local11206 = ObjTypeList.instance.list(id);

                if (opNum >= 1 && opNum <= 5 && local11206.iop[opNum - 1] != null) {
                    stringStack[stringStackPointer++] = local11206.iop[opNum - 1];
                    return;
                }

                stringStack[stringStackPointer++] = "";
                return;
            }

            if (op == OC_COST) {
                @Pc(15) int id = intStack[--intStackPointer];
                intStack[intStackPointer++] = ObjTypeList.instance.list(id).cost;
                return;
            }

            if (op == OC_STACKABLE) {
                @Pc(15) int id = intStack[--intStackPointer];
                intStack[intStackPointer++] = ObjTypeList.instance.list(id).stackable == 1 ? 1 : 0;
                return;
            }

            if (op == OC_CERT) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(11380) ObjType objType = ObjTypeList.instance.list(id);

                if (objType.certtemplate == -1 && objType.certlink >= 0) {
                    intStack[intStackPointer++] = objType.certlink;
                    return;
                }

                intStack[intStackPointer++] = id;
                return;
            }

            if (op == OC_UNCERT) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(11380) ObjType objType = ObjTypeList.instance.list(id);

                if (objType.certtemplate >= 0 && objType.certlink >= 0) {
                    intStack[intStackPointer++] = objType.certlink;
                    return;
                }

                intStack[intStackPointer++] = id;
                return;
            }

            if (op == OC_MEMBERS) {
                @Pc(15) int id = intStack[--intStackPointer];
                intStack[intStackPointer++] = ObjTypeList.instance.list(id).members ? 1 : 0;
                return;
            }

            if (op == OC_PARAM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];
                @Pc(3848) ParamType paramType = ParamTypeList.instance.list(param);

                if (paramType.isString()) {
                    stringStack[stringStackPointer++] = ObjTypeList.instance.list(id).param(paramType.defaultstr, param);
                    return;
                }

                intStack[intStackPointer++] = ObjTypeList.instance.list(id).param(param, paramType.defaultint);
                return;
            }

            if (op == OC_ICURSOR) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int opNum = intStack[intStackPointer + 1] - 1;
                @Pc(11206) ObjType objType = ObjTypeList.instance.list(id);

                if (objType.cursor1iop == opNum) {
                    intStack[intStackPointer++] = objType.icursor1;
                    return;
                }
                if (objType.cursor2iop == opNum) {
                    intStack[intStackPointer++] = objType.icursor2;
                    return;
                }

                intStack[intStackPointer++] = -1;
                return;
            }

            if (op == OC_FIND) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                @Pc(21) int restrict = intStack[--intStackPointer];
                ObjFinder.find(restrict == 1, text);
                intStack[intStackPointer++] = ObjFinder.resultCount;
                return;
            }

            if (op == OC_FINDNEXT) {
                if (ObjFinder.results != null && ObjFinder.pointer < ObjFinder.resultCount) {
                    intStack[intStackPointer++] = ObjFinder.results[ObjFinder.pointer++] & 0xFFFF;
                    return;
                }

                intStack[intStackPointer++] = -1;
                return;
            }

            if (op == OC_FINDRESTART) {
                ObjFinder.pointer = 0;
                return;
            }

            if (op == OC_MULTISTACKSIZE) {
                @Pc(15) int id = intStack[--intStackPointer];
                intStack[intStackPointer++] = ObjTypeList.instance.list(id).multistacksize;
                return;
            }

            if (op == 4214) {
                @Pc(4911) String text = stringStack[--stringStackPointer];
                intStackPointer -= 3;

                @Pc(21) int restrict = intStack[intStackPointer];
                @Pc(27) int param = intStack[intStackPointer + 1];
                @Pc(506) int expected = intStack[intStackPointer + 2];

                ObjFinder.findIntParam(restrict == 1, expected, param, text);
                intStack[intStackPointer++] = ObjFinder.resultCount;
                return;
            }

            if (op == 4215) {
                stringStackPointer -= 2;
                intStackPointer -= 2;

                @Pc(4911) String text = stringStack[stringStackPointer];
                @Pc(21) int restrict = intStack[intStackPointer];
                @Pc(27) int param = intStack[intStackPointer + 1];
                @Pc(7345) String expected = stringStack[stringStackPointer + 1];

                ObjFinder.findStringParam(text, param, expected, 8, restrict == 1);
                intStack[intStackPointer++] = ObjFinder.resultCount;
                return;
            }
        } else if (op < 4400) {
            if (op == NC_PARAM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];
                @Pc(3848) ParamType paramType = ParamTypeList.instance.list(param);

                if (paramType.isString()) {
                    stringStack[stringStackPointer++] = NPCTypeList.instance.list(id).param(paramType.defaultstr, param);
                    return;
                }

                intStack[intStackPointer++] = NPCTypeList.instance.list(id).param(param, paramType.defaultint);
                return;
            }
        } else if (op < 4500) {
            if (op == LC_PARAM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];
                @Pc(3848) ParamType paramType = ParamTypeList.instance.list(param);

                if (paramType.isString()) {
                    stringStack[stringStackPointer++] = LocTypeList.instance.list(id).param(paramType.defaultstr, param);
                    return;
                }

                intStack[intStackPointer++] = LocTypeList.instance.list(id).param(paramType.defaultint, param);
                return;
            }
        } else if (op < 4600) {
            if (op == STRUCT_PARAM) {
                intStackPointer -= 2;

                @Pc(15) int id = intStack[intStackPointer];
                @Pc(21) int param = intStack[intStackPointer + 1];
                @Pc(3848) ParamType paramType = ParamTypeList.instance.list(param);

                if (paramType.isString()) {
                    stringStack[stringStackPointer++] = StructTypeList.instance.list(id).param(param, paramType.defaultstr);
                    return;
                }

                intStack[intStackPointer++] = StructTypeList.instance.list(id).param(paramType.defaultint, param);
                return;
            }
        } else if (op < 4700) {
            if (op == BAS_GETANIM_READY) {
                @Pc(15) int id = intStack[--intStackPointer];
                @Pc(12037) BASType basType = BASTypeList.instance.list(id);

                if (basType.readyAnimations != null && basType.readyAnimations.length > 0) {
                    @Pc(27) int bestIndex = 0;
                    @Pc(506) int bestWeight = basType.readyAnimationWeights[0];

                    for (@Pc(2978) int index = 1; index < basType.readyAnimations.length; index++) {
                        if (basType.readyAnimationWeights[index] > bestWeight) {
                            bestIndex = index;
                            bestWeight = basType.readyAnimationWeights[index];
                        }
                    }

                    intStack[intStackPointer++] = basType.readyAnimations[bestIndex];
                    return;
                }

                intStack[intStackPointer++] = basType.ready;
                return;
            }
        } else if (op < 4800) {
            if (op == 4700) {
                intStack[intStackPointer++] = Static587.aBoolean663 ? 1 : 0;
                return;
            }

            if (op == 4701) {
                @Pc(4911) String local4911 = stringStack[--stringStackPointer];

                if (MainLogicManager.step == MainLogicStep.STEP_LOBBY_SCREEN && !LoginManager.inProgress()) {
                    if (local4911.length() > 20) {
                        Static486.aByte115 = -4;
                        return;
                    }

                    Static486.aByte115 = -1;
                    @Pc(5005) ClientMessage local5005 = ClientMessage.create(ClientProt.CLIENT_PROT_90, ServerConnection.LOBBY.cipher);
                    local5005.bitPacket.p1(0);
                    @Pc(27) int local27 = local5005.bitPacket.pos;
                    local5005.bitPacket.pjstr(local4911);
                    local5005.bitPacket.psize1(local5005.bitPacket.pos - local27);
                    ServerConnection.LOBBY.send(local5005);
                    return;
                }

                Static486.aByte115 = -5;
                return;
            }

            if (op == 4702) {
                intStack[intStackPointer++] = Static486.aByte115;
                if (Static486.aByte115 != -1) {
                    Static486.aByte115 = -6;
                }
                return;
            }
        }

        throw new IllegalStateException(String.valueOf(op));
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!hda;)V")
    public static void sendToBack(@OriginalArg(0) Component arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(69) Component[] local69;
        if (arg0.id == -1) {
            @Pc(106) int local106 = arg0.slot >>> 16;
            @Pc(110) Component[] local110 = InterfaceList.cache[local106];
            if (local110 == null) {
                local69 = InterfaceList.interfaces[local106];
                @Pc(119) int local119 = local69.length;
                local110 = InterfaceList.cache[local106] = new Component[local119];
                Arrays.copy(local69, 0, local110, 0, local69.length);
            }
            @Pc(135) int local135;
            for (local135 = 0; local135 < local110.length && local110[local135] != arg0; local135++) {
            }
            if (local135 >= local110.length) {
                return;
            }
            Arrays.copy(local110, 0, local110, 1, local135);
            local110[0] = arg0;
            return;
        }
        @Pc(12) Component local12 = InterfaceList.list(arg0.layer);
        if (local12 == null) {
            return;
        }
        if (local12.dynamicComponents == local12.staticComponents) {
            local12.dynamicComponents = new Component[local12.staticComponents.length];
            local12.dynamicComponents[0] = arg0;
            Arrays.copy(local12.staticComponents, 0, local12.dynamicComponents, 1, arg0.id);
            Arrays.copy(local12.staticComponents, arg0.id + 1, local12.dynamicComponents, arg0.id + 1, local12.staticComponents.length - arg0.id - 1);
            return;
        }
        @Pc(66) int local66 = 0;
        local69 = local12.dynamicComponents;
        while (local66 < local69.length && local69[local66] != arg0) {
            local66++;
        }
        if (local66 >= local69.length) {
            return;
        }
        Arrays.copy(local69, 0, local69, 1, local66);
        local69[0] = arg0;
        return;
    }

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(IZ)V")
    public static void profileOutput() {
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!fj;I)V")
    public static void executeScript(@OriginalArg(0) ClientScript script, @OriginalArg(1) int maxOps) {
        intStackPointer = 0;
        stringStackPointer = 0;

        @Pc(5) int pc = -1;
        @Pc(8) int[] opcodes = script.opcodes;
        @Pc(11) int[] operands = script.intOperands;
        @Pc(34) int op = -1;

        framePointer = 0;

        try {
            @Pc(17) int opCount = 0;

            while (true) {
                opCount++;
                if (opCount > maxOps) {
                    throw new RuntimeException("slow");
                }

                pc++;
                op = opcodes[pc];

                if (debug && (debugName == null || script.name != null && script.name.indexOf(debugName) != -1)) {
                    System.out.println(script.name + ": " + op);
                }

                if (op >= 150) {
                    @Pc(1436) boolean unfocused;
                    if (operands[pc] == 1) {
                        unfocused = true;
                    } else {
                        unfocused = false;
                    }

                    if (op >= 150 && op < 5000) {
                        handleSmallOp(op, unfocused);
                    } else if (op >= 5000 && op < 10000) {
                        handleLargeOp(op, unfocused);
                    } else {
                        break;
                    }
                } else if (op == PUSH_CONSTANT_INT) {
                    intStack[intStackPointer++] = operands[pc];
                } else if (op == PUSH_VAR) {
                    @Pc(96) int id = operands[pc];
                    intStack[intStackPointer++] = TimedVarDomain.instance.varValues[id];
                } else if (op == POP_VAR) {
                    @Pc(96) int id = operands[pc];
                    TimedVarDomain.instance.setVarValueInt(id, intStack[--intStackPointer]);
                } else if (op == PUSH_CONSTANT_STRING) {
                    stringStack[stringStackPointer++] = script.stringOperands[pc];
                } else if (op == BRANCH) {
                    pc += operands[pc];
                } else if (op == BRANCH_NOT) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] != intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_EQUALS) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] == intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_LESS_THAN) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] < intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_GREATER_THAN) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] > intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == RETURN) {
                    if (framePointer == 0) {
                        return;
                    }
                    @Pc(270) StackFrame frame = frames[--framePointer];
                    script = frame.script;
                    opcodes = script.opcodes;
                    operands = script.intOperands;
                    pc = frame.pc;
                    intVars = frame.intVars;
                    stringVars = frame.stringVars;
                    longVars = frame.longVars;
                } else if (op == POP_VARBIT) {
                    @Pc(96) int id = operands[pc];
                    intStack[intStackPointer++] = TimedVarDomain.instance.getVarBitValue(id);
                } else if (op == PUSH_VARBIT) {
                    @Pc(96) int id = operands[pc];
                    TimedVarDomain.instance.setVarBitValue(intStack[--intStackPointer], id);
                } else if (op == BRANCH_LESS_THAN_OR_EQUALS) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] <= intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_GREATER_THAN_OR_EQUALS) {
                    intStackPointer -= 2;
                    if (intStack[intStackPointer] >= intStack[intStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == PUSH_INT_LOCAL) {
                    intStack[intStackPointer++] = intVars[operands[pc]];
                } else if (op == POP_INT_LOCAL) {
                    intVars[operands[pc]] = intStack[--intStackPointer];
                } else if (op == PUSH_STRING_LOCAL) {
                    stringStack[stringStackPointer++] = stringVars[operands[pc]];
                } else if (op == POP_STRING_LOCAL) {
                    stringVars[operands[pc]] = stringStack[--stringStackPointer];
                } else if (op == JOIN_STRING) {
                    @Pc(96) int count = operands[pc];
                    stringStackPointer -= count;
                    @Pc(465) String string = StringTools.concat(count, stringStackPointer, stringStack);
                    stringStack[stringStackPointer++] = string;
                } else if (op == POP_INT_DISCARD) {
                    intStackPointer--;
                } else if (op == POP_STRING_DISCARD) {
                    stringStackPointer--;
                } else if (op == GOSUB_WITH_PARAMS) {
                    @Pc(96) int id = operands[pc];
                    @Pc(503) ClientScript callee = ClientScriptList.list(id);
                    if (callee == null) {
                        throw new RuntimeException();
                    }

                    @Pc(514) int[] intArgs = new int[callee.intVarCount];
                    @Pc(518) String[] stringArgs = new String[callee.stringVarCount];
                    @Pc(522) long[] longArgs = new long[callee.longVarCount];
                    for (@Pc(524) int i = 0; i < callee.intArgCount; i++) {
                        intArgs[i] = intStack[intStackPointer + i - callee.intArgCount];
                    }
                    for (@Pc(543) int i = 0; i < callee.stringArgCount; i++) {
                        stringArgs[i] = stringStack[stringStackPointer + i - callee.stringArgCount];
                    }
                    for (@Pc(562) int i = 0; i < callee.longArgCount; i++) {
                        longArgs[i] = longStack[longStackPointer + i - callee.longArgCount];
                    }

                    intStackPointer -= callee.intArgCount;
                    stringStackPointer -= callee.stringArgCount;
                    longStackPointer -= callee.longArgCount;

                    @Pc(598) StackFrame frame = new StackFrame();
                    frame.script = script;
                    frame.pc = pc;
                    frame.intVars = intVars;
                    frame.stringVars = stringVars;
                    frame.longVars = longVars;

                    if (framePointer >= frames.length) {
                        throw new RuntimeException();
                    }

                    frames[framePointer++] = frame;
                    script = callee;
                    opcodes = callee.opcodes;
                    operands = callee.intOperands;
                    pc = -1;
                    intVars = intArgs;
                    stringVars = stringArgs;
                    longVars = longArgs;
                } else if (op == PUSH_VARC) {
                    intStack[intStackPointer++] = Static511.varcs[operands[pc]];
                } else if (op == POP_VARC) {
                    @Pc(96) int id = operands[pc];
                    Static511.varcs[id] = intStack[--intStackPointer];
                    DelayedStateChange.resetVarc(id);
                    Static624.varcSaveRecommended |= Static118.permVarcs[id];
                } else if (op == DEFINE_ARRAY) {
                    @Pc(96) int id = operands[pc] >> 16;
                    @Pc(706) int type = operands[pc] & 0xFFFF;
                    @Pc(714) int length = intStack[--intStackPointer];
                    if (length < 0 || length > 5000) {
                        throw new RuntimeException();
                    }

                    arrayLengths[id] = length;

                    @Pc(732) byte v = -1;
                    if (type == 'i') {
                        v = 0;
                    }

                    for (@Pc(739) int i = 0; i < length; i++) {
                        arrayVars[id][i] = v;
                    }
                } else if (op == PUSH_ARRAY_INT) {
                    @Pc(96) int id = operands[pc];
                    @Pc(706) int index = intStack[--intStackPointer];
                    if (index < 0 || index >= arrayLengths[id]) {
                        throw new RuntimeException();
                    }
                    intStack[intStackPointer++] = arrayVars[id][index];
                } else if (op == POP_ARRAY_INT) {
                    @Pc(96) int id = operands[pc];
                    intStackPointer -= 2;
                    @Pc(706) int index = intStack[intStackPointer];
                    if (index < 0 || index >= arrayLengths[id]) {
                        throw new RuntimeException();
                    }
                    arrayVars[id][index] = intStack[intStackPointer + 1];
                } else if (op == PUSH_VARCSTR) {
                    @Pc(843) String varcstr = Static37.varcstrs[operands[pc]];
                    if (varcstr == null) {
                        varcstr = "null";
                    }
                    stringStack[stringStackPointer++] = varcstr;
                } else if (op == POP_VARCSTR) {
                    @Pc(96) int id = operands[pc];
                    Static37.varcstrs[id] = stringStack[--stringStackPointer];
                    DelayedStateChange.resetVarcstr(id);
                } else if (op == SWITCH) {
                    @Pc(889) IterableHashTable table = script.switchTables[operands[pc]];
                    @Pc(902) IntNode jump = (IntNode) table.get(intStack[--intStackPointer]);
                    if (jump != null) {
                        pc += jump.value;
                    }
                } else if (op == PUSH_LONG_CONSTANT) {
                    longStack[longStackPointer++] = script.longOperands[pc];
                } else if (op == POP_LONG_DISCARD) {
                    longStackPointer--;
                } else if (op == PUSH_LONG_LOCAL) {
                    longStack[longStackPointer++] = longVars[operands[pc]];
                } else if (op == POP_LONG_LOCAL) {
                    longVars[operands[pc]] = longStack[--longStackPointer];
                } else if (op == LONG_BRANCH_NOT) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] != longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == LONG_BRANCH_EQUALS) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] == longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == LONG_BRANCH_LESS_THAN) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] < longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == LONG_BRANCH_GREATER_THAN) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] > longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == LONG_BRANCH_LESS_THAN_OR_EQUALS) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] <= longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == LONG_BRANCH_GREATER_THAN_OR_EQUALS) {
                    longStackPointer -= 2;
                    if (longStack[longStackPointer] >= longStack[longStackPointer + 1]) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_IF_TRUE) {
                    if (intStack[--intStackPointer] == 1) {
                        pc += operands[pc];
                    }
                } else if (op == BRANCH_IF_FALSE) {
                    if (intStack[--intStackPointer] == 0) {
                        pc += operands[pc];
                    }
                } else if (op == 106) {
                    @Pc(96) int id = operands[pc];
                    @Pc(1178) Integer varclan = (Integer) Static279.clanVars[id];
                    if (varclan == null) {
                        @Pc(1185) VarClanSettingType type = VarClanSettingTypeList.instance.list(id);
                        if (type.dataType == 'i' || type.dataType == '1') {
                            intStack[intStackPointer++] = 0;
                        } else {
                            intStack[intStackPointer++] = -1;
                        }
                    } else {
                        intStack[intStackPointer++] = varclan;
                    }
                } else if (op == 107) {
                    @Pc(96) int id = operands[pc];
                    @Pc(1236) VarClanSettingType type = VarClanSettingTypeList.instance.list(id);
                    if (type.dataType != '\u0001') {
                        intStack[intStackPointer++] = 0;
                    }
                    @Pc(1256) Integer varclan = (Integer) Static279.clanVars[type.id];
                    if (varclan == null) {
                        intStack[intStackPointer++] = 0;
                    } else {
                        @Pc(1284) int local1284 = type.end == 31 ? -1 : (0x1 << type.end + 1) - 1;
                        intStack[intStackPointer++] = (varclan & local1284) >>> type.start;
                    }
                } else if (op == 108) {
                    @Pc(96) int id = operands[pc];
                    @Pc(1311) Long varclan = (Long) Static279.clanVars[id];
                    if (varclan == null) {
                        longStack[longStackPointer++] = -1L;
                    } else {
                        longStack[longStackPointer++] = varclan;
                    }
                } else if (op == 109) {
                    @Pc(96) int id = operands[pc];
                    @Pc(465) String varclan = (String) Static279.clanVars[id];
                    if (varclan == null) {
                        stringStack[stringStackPointer++] = "";
                    } else {
                        stringStack[stringStackPointer++] = varclan;
                    }
                } else if (op == 112) {
                    intStack[intStackPointer++] = getClanSettingInt(operands[pc]);
                } else if (op == 113) {
                    intStack[intStackPointer++] = getClanSettingVarbit(operands[pc]);
                } else if (op == 114) {
                    longStack[longStackPointer++] = getClanSettingLong(operands[pc]);
                } else if (op == 115) {
                    stringStack[stringStackPointer++] = getClanSettingString(operands[pc]);
                }
            }

            throw new IllegalStateException("Command: " + op);
        } catch (@Pc(1479) Exception exception) {
            @Pc(1484) StringBuffer buffer = new StringBuffer(30);
            buffer.append("CS2: ").append(script.key).append(" ");
            for (@Pc(706) int i = framePointer - 1; i >= 0; i--) {
                buffer.append("v: ").append(frames[i].script.key).append(" ");
            }
            buffer.append("op: ").append(op);
            JagException.sendTrace(exception, buffer.toString());
        }
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!pd;)V")
    public static void executeHookInner(@OriginalArg(0) HookRequest arg0) {
        executeHookInner(arg0, 200000);
    }

    @OriginalMember(owner = "client!ou", name = "c", descriptor = "(IZ)V")
    public static void handleLargeOp(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        @Pc(109) int local109;
        @Pc(375) int local375;
        @Pc(95) String local95;
        @Pc(192) int local192;
        @Pc(1578) boolean local1578;
        @Pc(834) int local834;
        @Pc(115) int local115;
        @Pc(198) String local198;
        @Pc(101) String local101;
        if (arg0 < 5100) {
            if (arg0 == 5000) {
                intStack[intStackPointer++] = Static133.publicChatFilter;
                return;
            }
            @Pc(57) ServerConnection local57;
            @Pc(63) ClientMessage local63;
            if (arg0 == 5001) {
                intStackPointer -= 3;
                Static133.publicChatFilter = intStack[intStackPointer];
                Static726.privateChatMode = PrivateChatMode.fromId(intStack[intStackPointer + 1]);
                if (Static726.privateChatMode == null) {
                    Static726.privateChatMode = PrivateChatMode.FRIENDS;
                }
                Static87.tradeChatFilter = intStack[intStackPointer + 2];
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(ClientProt.SET_CHATFILTERSETTINGS, local57.cipher);
                local63.bitPacket.p1(Static133.publicChatFilter);
                local63.bitPacket.p1(Static726.privateChatMode.id);
                local63.bitPacket.p1(Static87.tradeChatFilter);
                local57.send(local63);
                return;
            }
            if (arg0 == 5002) {
                stringStackPointer -= 2;
                local95 = stringStack[stringStackPointer];
                local101 = stringStack[stringStackPointer + 1];
                intStackPointer -= 2;
                local109 = intStack[intStackPointer];
                local115 = intStack[intStackPointer + 1];
                if (local101 == null) {
                    local101 = "";
                }
                if (local101.length() > 80) {
                    local101 = local101.substring(0, 80);
                }
                @Pc(135) ServerConnection local135 = ConnectionManager.active();
                @Pc(141) ClientMessage local141 = ClientMessage.create(ClientProt.SEND_SNAPSHOT, local135.cipher);
                local141.bitPacket.p1(Packet.pjstrlen(local95) + Packet.pjstrlen(local101) + 2);
                local141.bitPacket.pjstr(local95);
                local141.bitPacket.p1(local109 - 1);
                local141.bitPacket.p1(local115);
                local141.bitPacket.pjstr(local101);
                local135.send(local141);
                return;
            }
            @Pc(196) ChatLine local196;
            if (arg0 == 5003) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.message != null) {
                    local198 = local196.message;
                }
                stringStack[stringStackPointer++] = local198;
                return;
            }
            if (arg0 == 5004) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.type;
                }
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5005) {
                if (Static726.privateChatMode == null) {
                    intStack[intStackPointer++] = -1;
                    return;
                }
                intStack[intStackPointer++] = Static726.privateChatMode.id;
                return;
            }
            @Pc(295) ClientMessage local295;
            @Pc(289) ServerConnection local289;
            if (arg0 == 5006) {
                local192 = intStack[--intStackPointer];
                local289 = ConnectionManager.active();
                local295 = ClientMessage.create(ClientProt.CHAT_SETMODE, local289.cipher);
                local295.bitPacket.p1(local192);
                local289.send(local295);
                return;
            }
            if (arg0 == 5008) {
                local95 = stringStack[--stringStackPointer];
                method6426(local95, arg0);
                return;
            }
            if (arg0 == 5009) {
                stringStackPointer -= 2;
                local95 = stringStack[stringStackPointer];
                local101 = stringStack[stringStackPointer + 1];
                if (Client.staffModLevel != 0 || (!Static389.underage || Static34.parentalChatConsent) && !Static617.quickChatWorld) {
                    @Pc(360) ServerConnection local360 = ConnectionManager.active();
                    @Pc(366) ClientMessage local366 = ClientMessage.create(ClientProt.MESSAGE_PRIVATE, local360.cipher);
                    local366.bitPacket.p2(0);
                    local375 = local366.bitPacket.pos;
                    local366.bitPacket.pjstr(local95);
                    WordPack.encode(local366.bitPacket, local101);
                    local366.bitPacket.psize2(local366.bitPacket.pos - local375);
                    local360.send(local366);
                    return;
                }
                return;
            }
            if (arg0 == 5010) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.name != null) {
                    local198 = local196.name;
                }
                stringStack[stringStackPointer++] = local198;
                return;
            }
            if (arg0 == 5011) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.channel != null) {
                    local198 = local196.channel;
                }
                stringStack[stringStackPointer++] = local198;
                return;
            }
            if (arg0 == 5012) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.quickChatId;
                }
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5015) {
                if (PlayerEntity.self == null || PlayerEntity.self.displayName == null) {
                    local95 = "";
                } else {
                    local95 = PlayerEntity.self.getDisplayName(false, true);
                }
                stringStack[stringStackPointer++] = local95;
                return;
            }
            if (arg0 == 5016) {
                intStack[intStackPointer++] = Static87.tradeChatFilter;
                return;
            }
            if (arg0 == 5017) {
                intStack[intStackPointer++] = Static402.method5578();
                return;
            }
            if (arg0 == 5018) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local109 = 0;
                if (local196 != null) {
                    local109 = local196.flags;
                }
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5019) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.accountName != null) {
                    local198 = local196.accountName;
                }
                stringStack[stringStackPointer++] = local198;
                return;
            }
            if (arg0 == 5020) {
                if (PlayerEntity.self == null || PlayerEntity.self.displayName == null) {
                    local95 = "";
                } else {
                    local95 = PlayerEntity.self.getAccountName();
                }
                stringStack[stringStackPointer++] = local95;
                return;
            }
            if (arg0 == 5023) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.uid;
                }
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5024) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.clock;
                }
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5025) {
                local192 = intStack[--intStackPointer];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.displayName != null) {
                    local198 = local196.displayName;
                }
                stringStack[stringStackPointer++] = local198;
                return;
            }
            if (arg0 == 5050) {
                local192 = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).aString4;
                return;
            }
            @Pc(793) DoublyLinkedNode_Sub2_Sub3 local793;
            if (arg0 == 5051) {
                local192 = intStack[--intStackPointer];
                local793 = QuickChatCatTypeList.instance.method3234(local192);
                if (local793.anIntArray93 == null) {
                    intStack[intStackPointer++] = 0;
                    return;
                }
                intStack[intStackPointer++] = local793.anIntArray93.length;
                return;
            }
            if (arg0 == 5052) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                @Pc(839) DoublyLinkedNode_Sub2_Sub3 local839 = QuickChatCatTypeList.instance.method3234(local192);
                local115 = local839.anIntArray93[local834];
                intStack[intStackPointer++] = local115;
                return;
            }
            if (arg0 == 5053) {
                local192 = intStack[--intStackPointer];
                local793 = QuickChatCatTypeList.instance.method3234(local192);
                if (local793.anIntArray94 == null) {
                    intStack[intStackPointer++] = 0;
                    return;
                }
                intStack[intStackPointer++] = local793.anIntArray94.length;
                return;
            }
            if (arg0 == 5054) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                intStack[intStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).anIntArray94[local834];
                return;
            }
            if (arg0 == 5055) {
                local192 = intStack[--intStackPointer];
                stringStack[stringStackPointer++] = QuickChatPhraseTypeList.instance.get(local192).getText();
                return;
            }
            if (arg0 == 5056) {
                local192 = intStack[--intStackPointer];
                @Pc(966) QuickChatPhraseType local966 = QuickChatPhraseTypeList.instance.get(local192);
                if (local966.autoResponses == null) {
                    intStack[intStackPointer++] = 0;
                    return;
                }
                intStack[intStackPointer++] = local966.autoResponses.length;
                return;
            }
            if (arg0 == 5057) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                intStack[intStackPointer++] = QuickChatPhraseTypeList.instance.get(local192).autoResponses[local834];
                return;
            }
            if (arg0 == 5058) {
                aQuickChatPhrase_1 = new QuickChatPhrase();
                aQuickChatPhrase_1.id = intStack[--intStackPointer];
                aQuickChatPhrase_1.type = QuickChatPhraseTypeList.instance.get(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.fillerValues = new int[aQuickChatPhrase_1.type.getDynamicCommandCount()];
                return;
            }
            if (arg0 == 5059) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(ClientProt.MESSAGE_QUICKCHAT_PUBLIC, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(0);
                local63.bitPacket.p2(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.type.encode(local63.bitPacket, aQuickChatPhrase_1.fillerValues);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5060) {
                local95 = stringStack[--stringStackPointer];
                local289 = ConnectionManager.active();
                local295 = ClientMessage.create(ClientProt.MESSAGE_QUICKCHAT_PRIVATE, local289.cipher);
                local295.bitPacket.p1(0);
                local115 = local295.bitPacket.pos;
                local295.bitPacket.pjstr(local95);
                local295.bitPacket.p2(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.type.encode(local295.bitPacket, aQuickChatPhrase_1.fillerValues);
                local295.bitPacket.psize1(local295.bitPacket.pos - local115);
                local289.send(local295);
                return;
            }
            if (arg0 == 5061) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(ClientProt.MESSAGE_QUICKCHAT_PUBLIC, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(1);
                local63.bitPacket.p2(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.type.encode(local63.bitPacket, aQuickChatPhrase_1.fillerValues);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5062) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                intStack[intStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).aCharArray2[local834];
                return;
            }
            if (arg0 == 5063) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                intStack[intStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).aCharArray3[local834];
                return;
            }
            if (arg0 == 5064) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                if (local834 == -1) {
                    intStack[intStackPointer++] = -1;
                    return;
                }
                intStack[intStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).method1185((char) local834);
                return;
            }
            if (arg0 == 5065) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                if (local834 == -1) {
                    intStack[intStackPointer++] = -1;
                    return;
                }
                intStack[intStackPointer++] = QuickChatCatTypeList.instance.method3234(local192).method1184((char) local834);
                return;
            }
            if (arg0 == 5066) {
                local192 = intStack[--intStackPointer];
                intStack[intStackPointer++] = QuickChatPhraseTypeList.instance.get(local192).getDynamicCommandCount();
                return;
            }
            if (arg0 == 5067) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                local109 = QuickChatPhraseTypeList.instance.get(local192).getDynamicCommand(local834).id;
                intStack[intStackPointer++] = local109;
                return;
            }
            if (arg0 == 5068) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                aQuickChatPhrase_1.fillerValues[local192] = local834;
                return;
            }
            if (arg0 == 5069) {
                intStackPointer -= 2;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                aQuickChatPhrase_1.fillerValues[local192] = local834;
                return;
            }
            if (arg0 == 5070) {
                intStackPointer -= 3;
                local192 = intStack[intStackPointer];
                local834 = intStack[intStackPointer + 1];
                local109 = intStack[intStackPointer + 2];
                @Pc(1526) QuickChatPhraseType local1526 = QuickChatPhraseTypeList.instance.get(local192);
                if (local1526.getDynamicCommand(local834).id != 0) {
                    throw new RuntimeException("bad command");
                }
                intStack[intStackPointer++] = local1526.getDynamicCommandParam(local834, local109);
                return;
            }
            if (arg0 == 5071) {
                local95 = stringStack[--stringStackPointer];
                local1578 = intStack[--intStackPointer] == 1;
                Static494.method6599(local95, local1578);
                intStack[intStackPointer++] = ObjFinder.resultCount;
                return;
            }
            if (arg0 == 5072) {
                if (ObjFinder.results != null && ObjFinder.pointer < ObjFinder.resultCount) {
                    intStack[intStackPointer++] = ObjFinder.results[ObjFinder.pointer++] & 0xFFFF;
                    return;
                }
                intStack[intStackPointer++] = -1;
                return;
            }
            if (arg0 == 5073) {
                ObjFinder.pointer = 0;
                return;
            }
            if (arg0 == 5074) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(ClientProt.MESSAGE_QUICKCHAT_PUBLIC, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(2);
                local63.bitPacket.p2(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.type.encode(local63.bitPacket, aQuickChatPhrase_1.fillerValues);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5075) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(ClientProt.MESSAGE_QUICKCHAT_PUBLIC, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(3);
                local63.bitPacket.p2(aQuickChatPhrase_1.id);
                aQuickChatPhrase_1.type.encode(local63.bitPacket, aQuickChatPhrase_1.fillerValues);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
        } else if (arg0 < 5200) {
            if (arg0 == 5100) {
                if (KeyboardMonitor.instance.isPressed(86)) {
                    intStack[intStackPointer++] = 1;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }
            if (arg0 == 5101) {
                if (KeyboardMonitor.instance.isPressed(82)) {
                    intStack[intStackPointer++] = 1;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }
            if (arg0 == 5102) {
                if (KeyboardMonitor.instance.isPressed(81)) {
                    intStack[intStackPointer++] = 1;
                    return;
                }
                intStack[intStackPointer++] = 0;
                return;
            }
        } else {
            @Pc(2331) boolean local2331;
            if (arg0 < 5300) {
                if (arg0 == 5200) {
                    WorldMap.setZoomPercentage(intStack[--intStackPointer]);
                    return;
                }
                if (arg0 == 5201) {
                    intStack[intStackPointer++] = WorldMap.getZoom();
                    return;
                }
                if (arg0 == 5205) {
                    WorldMap.method1293(intStack[--intStackPointer], false, -1, -1, -11493);
                    return;
                }
                @Pc(1908) WorldMapArea local1908;
                if (arg0 == 5206) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.method5078(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    if (local1908 == null) {
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = local1908.id;
                    return;
                }
                @Pc(1942) WorldMapArea local1942;
                if (arg0 == 5207) {
                    local1942 = WorldMap.getArea(intStack[--intStackPointer]);
                    if (local1942 != null && local1942.aString49 != null) {
                        stringStack[stringStackPointer++] = local1942.aString49;
                        return;
                    }
                    stringStack[stringStackPointer++] = "";
                    return;
                }
                if (arg0 == 5208) {
                    intStack[intStackPointer++] = WorldMap.width;
                    intStack[intStackPointer++] = WorldMap.height;
                    return;
                }
                if (arg0 == 5209) {
                    intStack[intStackPointer++] = WorldMap.anInt2809 + WorldMap.areaX;
                    intStack[intStackPointer++] = WorldMap.anInt9389 + WorldMap.areaY;
                    return;
                }
                if (arg0 == 5210) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        intStack[intStackPointer++] = 0;
                        intStack[intStackPointer++] = 0;
                        return;
                    }
                    intStack[intStackPointer++] = local1908.origin >> 14 & 0x3FFF;
                    intStack[intStackPointer++] = local1908.origin & 0x3FFF;
                    return;
                }
                if (arg0 == 5211) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        intStack[intStackPointer++] = 0;
                        intStack[intStackPointer++] = 0;
                        return;
                    }
                    intStack[intStackPointer++] = local1908.maxX - local1908.minX;
                    intStack[intStackPointer++] = local1908.maxY - local1908.minY;
                    return;
                }
                @Pc(2139) MapElementListEntry local2139;
                if (arg0 == 5212) {
                    local2139 = Static122.method2207();
                    if (local2139 == null) {
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = local2139.id;
                    local834 = local2139.level << 28 | local2139.x + WorldMap.areaX << 14 | local2139.y + WorldMap.areaY;
                    intStack[intStackPointer++] = local834;
                    return;
                }
                if (arg0 == 5213) {
                    local2139 = Static364.method5248();
                    if (local2139 == null) {
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = local2139.id;
                    local834 = local2139.level << 28 | local2139.x + WorldMap.areaX << 14 | local2139.y + WorldMap.areaY;
                    intStack[intStackPointer++] = local834;
                    return;
                }
                @Pc(2289) boolean local2289;
                if (arg0 == 5214) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4088(areaCoords, local192 & 0x3FFF, local192 >> 28 & 0x3, local192 >> 14 & 0x3FFF);
                        if (local2289) {
                            Static106.method2048(areaCoords[1], areaCoords[2]);
                        }
                    }
                    return;
                }
                if (arg0 == 5215) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local834 = intStack[intStackPointer + 1];
                    @Pc(2329) Queue local2329 = WorldMap.method5076(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    local2331 = false;
                    for (@Pc(2336) WorldMapArea local2336 = (WorldMapArea) local2329.first(); local2336 != null; local2336 = (WorldMapArea) local2329.next()) {
                        if (local2336.id == local834) {
                            local2331 = true;
                            break;
                        }
                    }
                    if (local2331) {
                        intStack[intStackPointer++] = 1;
                        return;
                    }
                    intStack[intStackPointer++] = 0;
                    return;
                }
                if (arg0 == 5218) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = local1908.zoom;
                    return;
                }
                if (arg0 == 5220) {
                    intStack[intStackPointer++] = WorldMap.loadingPercent == 100 ? 1 : 0;
                    return;
                }
                if (arg0 == 5221) {
                    local192 = intStack[--intStackPointer];
                    Static106.method2048(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    return;
                }
                if (arg0 == 5222) {
                    local1942 = WorldMap.getArea();
                    if (local1942 != null) {
                        local1578 = local1942.method4091(WorldMap.anInt9389 + WorldMap.areaY, WorldMap.anInt2809 + WorldMap.areaX, areaCoords);
                        if (local1578) {
                            intStack[intStackPointer++] = areaCoords[1];
                            intStack[intStackPointer++] = areaCoords[2];
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = -1;
                    intStack[intStackPointer++] = -1;
                    return;
                }
                if (arg0 == 5223) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local834 = intStack[intStackPointer + 1];
                    WorldMap.method1293(local192, false, local834 & 0x3FFF, local834 >> 14 & 0x3FFF, -11493);
                    return;
                }
                if (arg0 == 5224) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4088(areaCoords, local192 & 0x3FFF, local192 >> 28 & 0x3, local192 >> 14 & 0x3FFF);
                        if (local2289) {
                            intStack[intStackPointer++] = areaCoords[1];
                            intStack[intStackPointer++] = areaCoords[2];
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = -1;
                    intStack[intStackPointer++] = -1;
                    return;
                }
                if (arg0 == 5225) {
                    local192 = intStack[--intStackPointer];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4091(local192 & 0x3FFF, local192 >> 14 & 0x3FFF, areaCoords);
                        if (local2289) {
                            intStack[intStackPointer++] = areaCoords[1];
                            intStack[intStackPointer++] = areaCoords[2];
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = -1;
                    intStack[intStackPointer++] = -1;
                    return;
                }
                if (arg0 == 5226) {
                    Static688.method8975(intStack[--intStackPointer]);
                    return;
                }
                if (arg0 == 5227) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local834 = intStack[intStackPointer + 1];
                    WorldMap.method1293(local192, true, local834 & 0x3FFF, local834 >> 14 & 0x3FFF, -11493);
                    return;
                }
                if (arg0 == 5228) {
                    Static178.aBoolean251 = intStack[--intStackPointer] == 1;
                    return;
                }
                if (arg0 == 5229) {
                    intStack[intStackPointer++] = Static178.aBoolean251 ? 1 : 0;
                    return;
                }
                if (arg0 == 5230) {
                    local192 = intStack[--intStackPointer];
                    Static170.method2653(local192);
                    return;
                }
                @Pc(2867) Node local2867;
                if (arg0 == 5231) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local1578 = intStack[intStackPointer + 1] == 1;
                    if (Static232.A_HASH_TABLE___18 != null) {
                        local2867 = Static232.A_HASH_TABLE___18.get(local192);
                        if (local2867 != null && !local1578) {
                            local2867.unlink();
                            return;
                        }
                        if (local2867 == null && local1578) {
                            local2867 = new Node();
                            Static232.A_HASH_TABLE___18.put(local192, local2867);
                        }
                    }
                    return;
                }
                @Pc(2914) Node local2914;
                if (arg0 == 5232) {
                    local192 = intStack[--intStackPointer];
                    if (Static232.A_HASH_TABLE___18 != null) {
                        local2914 = Static232.A_HASH_TABLE___18.get(local192);
                        intStack[intStackPointer++] = local2914 == null ? 0 : 1;
                        return;
                    }
                    intStack[intStackPointer++] = 0;
                    return;
                }
                if (arg0 == 5233) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local1578 = intStack[intStackPointer + 1] == 1;
                    if (Static268.A_HASH_TABLE___22 != null) {
                        local2867 = Static268.A_HASH_TABLE___22.get(local192);
                        if (local2867 != null && !local1578) {
                            local2867.unlink();
                            return;
                        }
                        if (local2867 == null && local1578) {
                            local2867 = new Node();
                            Static268.A_HASH_TABLE___22.put(local192, local2867);
                        }
                    }
                    return;
                }
                if (arg0 == 5234) {
                    local192 = intStack[--intStackPointer];
                    if (Static268.A_HASH_TABLE___22 != null) {
                        local2914 = Static268.A_HASH_TABLE___22.get(local192);
                        intStack[intStackPointer++] = local2914 == null ? 0 : 1;
                        return;
                    }
                    intStack[intStackPointer++] = 0;
                    return;
                }
                if (arg0 == 5235) {
                    intStack[intStackPointer++] = WorldMap.area == null ? -1 : WorldMap.area.id;
                    return;
                }
                if (arg0 == 5236) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local834 = intStack[intStackPointer + 1];
                    local109 = local834 >> 14 & 0x3FFF;
                    local115 = local834 & 0x3FFF;
                    local375 = Static687.method8957(local192, local115, local109);
                    if (local375 < 0) {
                        intStack[intStackPointer++] = -1;
                        return;
                    }
                    intStack[intStackPointer++] = local375;
                    return;
                }
                if (arg0 == 5237) {
                    MainLogicManager.forceMapRebuild();
                    return;
                }
            } else if (arg0 < 5400) {
                if (arg0 == 5300) {
                    intStackPointer -= 2;
                    local192 = intStack[intStackPointer];
                    local834 = intStack[intStackPointer + 1];
                    InterfaceManager.changeWindowMode(3, local192, false, local834);
                    intStack[intStackPointer++] = GameShell.fsframe == null ? 0 : 1;
                    return;
                }
                if (arg0 == 5301) {
                    if (GameShell.fsframe != null) {
                        InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                    }
                    return;
                }
                if (arg0 == 5302) {
                    @Pc(3186) DisplayProperties[] local3186 = Static587.method7710();
                    intStack[intStackPointer++] = local3186.length;
                    return;
                }
                if (arg0 == 5303) {
                    local192 = intStack[--intStackPointer];
                    @Pc(3210) DisplayProperties[] local3210 = Static587.method7710();
                    intStack[intStackPointer++] = local3210[local192].width;
                    intStack[intStackPointer++] = local3210[local192].height;
                    return;
                }
                if (arg0 == 5305) {
                    local192 = GameShell.fullscreenWidth;
                    local834 = GameShell.fullscreenHeight;
                    local109 = -1;
                    @Pc(3245) DisplayProperties[] local3245 = Static587.method7710();
                    for (local375 = 0; local375 < local3245.length; local375++) {
                        @Pc(3252) DisplayProperties local3252 = local3245[local375];
                        if (local3252.width == local192 && local3252.height == local834) {
                            local109 = local375;
                            break;
                        }
                    }
                    intStack[intStackPointer++] = local109;
                    return;
                }
                if (arg0 == 5306) {
                    intStack[intStackPointer++] = InterfaceManager.getWindowMode();
                    return;
                }
                if (arg0 == 5307) {
                    local192 = intStack[--intStackPointer];
                    if (local192 >= 1 && local192 <= 2) {
                        InterfaceManager.changeWindowMode(local192, -1, false, -1);
                        return;
                    }
                    return;
                }
                if (arg0 == 5308) {
                    intStack[intStackPointer++] = ClientOptions.instance.screenSizeDefault.getValue();
                    return;
                }
                if (arg0 == 5309) {
                    local192 = intStack[--intStackPointer];
                    if (local192 >= 1 && local192 <= 2) {
                        ClientOptions.instance.update(local192, ClientOptions.instance.screenSizeDefault);
                        ClientOptions.instance.update(local192, ClientOptions.instance.screenSize);
                        ClientOptions.save();
                        return;
                    }
                    return;
                }
            } else {
                @Pc(3561) int local3561;
                if (arg0 < 5500) {
                    if (arg0 == 5400) {
                        stringStackPointer -= 2;
                        local95 = stringStack[stringStackPointer];
                        local101 = stringStack[stringStackPointer + 1];
                        local109 = intStack[--intStackPointer];
                        @Pc(3411) ServerConnection local3411 = ConnectionManager.active();
                        @Pc(3417) ClientMessage local3417 = ClientMessage.create(ClientProt.URL_REQUEST, local3411.cipher);
                        local3417.bitPacket.p1(Packet.pjstrlen(local95) + Packet.pjstrlen(local101) + 1);
                        local3417.bitPacket.pjstr(local95);
                        local3417.bitPacket.pjstr(local101);
                        local3417.bitPacket.p1(local109);
                        local3411.send(local3417);
                        return;
                    }
                    if (arg0 == 5401) {
                        intStackPointer -= 2;
                        Client.clientpalette[intStack[intStackPointer]] = (short) ColourUtils.rgbToHsl(intStack[intStackPointer + 1]);
                        ObjTypeList.instance.modelCacheReset();
                        ObjTypeList.instance.spriteCacheReset();
                        NPCTypeList.instance.modelCacheReset();
                        InterfaceManager.redrawAll();
                        return;
                    }
                    if (arg0 == 5405) {
                        intStackPointer -= 2;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        if (local192 >= 0 && local192 < 2) {
                            Camera.spline[local192] = new int[local834 << 1][4];
                        }
                        return;
                    }
                    if (arg0 == 5406) {
                        intStackPointer -= 7;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1] << 1;
                        local109 = intStack[intStackPointer + 2];
                        local115 = intStack[intStackPointer + 3];
                        local375 = intStack[intStackPointer + 4];
                        local3561 = intStack[intStackPointer + 5];
                        @Pc(3567) int local3567 = intStack[intStackPointer + 6];
                        if (local192 >= 0 && local192 < 2 && Camera.spline[local192] != null && local834 >= 0 && local834 < Camera.spline[local192].length) {
                            Camera.spline[local192][local834] = new int[]{(local109 >> 14 & 0x3FFF) << 9, local115 << 2, (local109 & 0x3FFF) << 9, local3567};
                            Camera.spline[local192][local834 + 1] = new int[]{(local375 >> 14 & 0x3FFF) << 9, local3561 << 2, (local375 & 0x3FFF) << 9};
                        }
                        return;
                    }
                    if (arg0 == 5407) {
                        local192 = Camera.spline[intStack[--intStackPointer]].length >> 1;
                        intStack[intStackPointer++] = local192;
                        return;
                    }
                    if (arg0 == 5411) {
                        if (GameShell.fsframe != null) {
                            InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                        }
                        if (GameShell.frame != null) {
                            Static266.saveVarcs();
                            System.exit(0);
                            return;
                        }
                        local95 = Client.quitUrl == null ? Static659.method8605() : Client.quitUrl;
                        Static664.openjs(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local95, false, GameShell.signLink);
                        return;
                    }
                    if (arg0 == 5419) {
                        local95 = "";
                        if (Static439.hostnameResource != null) {
                            if (Static439.hostnameResource.result == null) {
                                local95 = Static419.method5756(Static439.hostnameResource.intData1);
                            } else {
                                local95 = (String) Static439.hostnameResource.result;
                            }
                        }
                        stringStack[stringStackPointer++] = local95;
                        return;
                    }
                    if (arg0 == 5420) {
                        intStack[intStackPointer++] = GameShell.signLink.signed ? 0 : 1;
                        return;
                    }
                    if (arg0 == 5421) {
                        if (GameShell.fsframe != null) {
                            InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                        }
                        local95 = stringStack[--stringStackPointer];
                        local1578 = intStack[--intStackPointer] == 1;
                        local198 = Static659.method8605() + local95;
                        Static664.openjs(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local198, local1578, GameShell.signLink);
                        return;
                    }
                    if (arg0 == 5422) {
                        stringStackPointer -= 2;
                        local95 = stringStack[stringStackPointer];
                        local101 = stringStack[stringStackPointer + 1];
                        local109 = intStack[--intStackPointer];
                        if (local95.length() > 0) {
                            if (Static685.prefixTitles == null) {
                                Static685.prefixTitles = new String[Static390.anIntArray476[Client.modeGame.id]];
                            }
                            Static685.prefixTitles[local109] = local95;
                        }
                        if (local101.length() > 0) {
                            if (Static377.suffixTitles == null) {
                                Static377.suffixTitles = new String[Static390.anIntArray476[Client.modeGame.id]];
                            }
                            Static377.suffixTitles[local109] = local101;
                        }
                        return;
                    }
                    if (arg0 == 5423) {
                        System.out.println(stringStack[--stringStackPointer]);
                        return;
                    }
                    if (arg0 == 5424) {
                        intStackPointer -= 11;
                        MiniMenu.topColour = intStack[intStackPointer];
                        MiniMenu.topOpacity = intStack[intStackPointer + 1];
                        MiniMenu.spriteBodyColour = intStack[intStackPointer + 2];
                        MiniMenu.spriteBodyOpacity = intStack[intStackPointer + 3];
                        MiniMenu.separatorSpriteId = intStack[intStackPointer + 4];
                        MiniMenu.topCornerSpriteId = intStack[intStackPointer + 5];
                        MiniMenu.horizontalBorderSpriteId = intStack[intStackPointer + 6];
                        MiniMenu.verticalBorderSpriteId = intStack[intStackPointer + 7];
                        MiniMenu.bottomCornerSpriteId = intStack[intStackPointer + 8];
                        MiniMenu.textColour = intStack[intStackPointer + 9];
                        MiniMenu.spriteHighlightColour = intStack[intStackPointer + 10];
                        js5.SPRITES.fileready(MiniMenu.separatorSpriteId);
                        js5.SPRITES.fileready(MiniMenu.topCornerSpriteId);
                        js5.SPRITES.fileready(MiniMenu.horizontalBorderSpriteId);
                        js5.SPRITES.fileready(MiniMenu.verticalBorderSpriteId);
                        js5.SPRITES.fileready(MiniMenu.bottomCornerSpriteId);
                        MiniMenu.bottomBorderSprite = null;
                        MiniMenu.bottomRightCornerSprite = null;
                        MiniMenu.bottomLeftCornerSprite = null;
                        MiniMenu.topRightCornerSprite = null;
                        MiniMenu.topLeftCornerSprite = null;
                        MiniMenu.separatorSprite = null;
                        MiniMenu.rightBorderSprite = null;
                        MiniMenu.leftBorderSprite = null;
                        MiniMenu.useSprites = true;
                        return;
                    }
                    if (arg0 == 5425) {
                        MiniMenu.resetSprites();
                        MiniMenu.useSprites = false;
                        return;
                    }
                    if (arg0 == 5426) {
                        intStackPointer -= 2;
                        Cursor.dflt = intStack[intStackPointer];
                        Cursor.interaction = intStack[intStackPointer + 1];
                        return;
                    }
                    if (arg0 == 5427) {
                        intStackPointer -= 2;
                        return;
                    }
                    if (arg0 == 5428) {
                        intStackPointer -= 2;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        intStack[intStackPointer++] = Static251.method3549(local192, local834) ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5429) {
                        debugconsole.executeComand(false, false, stringStack[--stringStackPointer]);
                        return;
                    }
                    if (arg0 == 5430) {
                        try {
                            JavaScript.call("accountcreated", GameShell.loaderApplet);
                            return;
                        } catch (@Pc(4148) Throwable local4148) {
                            return;
                        }
                    }
                    if (arg0 == 5431) {
                        try {
                            JavaScript.call("accountcreatestarted", GameShell.loaderApplet);
                            return;
                        } catch (@Pc(4161) Throwable local4161) {
                            return;
                        }
                    }
                    if (arg0 == 5432) {
                        local95 = "";
                        if (client.clipboard != null) {
                            @Pc(4173) Transferable local4173 = client.clipboard.getContents(null);
                            if (local4173 != null) {
                                try {
                                    local95 = (String) local4173.getTransferData(DataFlavor.stringFlavor);
                                    if (local95 == null) {
                                        local95 = "";
                                    }
                                } catch (@Pc(4186) Exception local4186) {
                                }
                            }
                        }
                        stringStack[stringStackPointer++] = local95;
                        return;
                    }
                    if (arg0 == 5433) {
                        MiniMenu.collapseAtCount = intStack[--intStackPointer];
                        return;
                    }
                    if (arg0 == 5435) {
                        intStack[intStackPointer++] = Client.js ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5436) {
                        if (SystemInfo.instance.javaRelease < 6) {
                            intStack[intStackPointer++] = 0;
                            return;
                        }
                        if (SystemInfo.instance.javaRelease == 6 && SystemInfo.instance.javaUpdate < 10) {
                            intStack[intStackPointer++] = 0;
                            return;
                        }
                        intStack[intStackPointer++] = 1;
                        return;
                    }
                } else if (arg0 < 5600) {
                    if (arg0 == 5500) {
                        intStackPointer -= 4;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        local109 = intStack[intStackPointer + 2];
                        local115 = intStack[intStackPointer + 3];
                        Camera.moveTo((local192 >> 14 & 0x3FFF) - WorldMap.areaBaseX, local834 << 2, (local192 & 0x3FFF) - WorldMap.areaBaseZ, local109, local115, false);
                        return;
                    }
                    if (arg0 == 5501) {
                        intStackPointer -= 4;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        local109 = intStack[intStackPointer + 2];
                        local115 = intStack[intStackPointer + 3];
                        Camera.lookAt((local192 >> 14 & 0x3FFF) - WorldMap.areaBaseX, local834 << 2, (local192 & 0x3FFF) - WorldMap.areaBaseZ, local109, local115);
                        return;
                    }
                    if (arg0 == 5502) {
                        intStackPointer -= 6;
                        local192 = intStack[intStackPointer];
                        if (local192 >= 2) {
                            throw new RuntimeException();
                        }
                        Camera.posSpline = local192;
                        local834 = intStack[intStackPointer + 1];
                        if (local834 + 1 >= Camera.spline[Camera.posSpline].length >> 1) {
                            throw new RuntimeException();
                        }
                        Camera.splinePosOffset = local834;
                        Camera.splineRate = 0;
                        Camera.splineStart = intStack[intStackPointer + 2];
                        Camera.splineEnd = intStack[intStackPointer + 3];
                        local109 = intStack[intStackPointer + 4];
                        if (local109 >= 2) {
                            throw new RuntimeException();
                        }
                        Camera.lookSpline = local109;
                        local115 = intStack[intStackPointer + 5];
                        if (local115 + 1 >= Camera.spline[Camera.lookSpline].length >> 1) {
                            throw new RuntimeException();
                        }
                        Camera.splineLookOffset = local115;
                        Camera.mode = CameraMode.MODE_SPLINE;
                        Camera.anInt10383 = -1;
                        Camera.anInt10376 = -1;
                        return;
                    }
                    if (arg0 == 5503) {
                        Camera.reset();
                        return;
                    }
                    if (arg0 == 5504) {
                        intStackPointer -= 2;
                        Camera.forceAngle(intStack[intStackPointer], intStack[intStackPointer + 1], 0);
                        return;
                    }
                    if (arg0 == 5505) {
                        intStack[intStackPointer++] = (int) Camera.playerCameraPitch >> 3;
                        return;
                    }
                    if (arg0 == 5506) {
                        intStack[intStackPointer++] = (int) Camera.playerCameraYaw >> 3;
                        return;
                    }
                    if (arg0 == 5507) {
                        Static599.method7835();
                        return;
                    }
                    if (arg0 == 5508) {
                        Camera.method6596();
                        return;
                    }
                    if (arg0 == 5509) {
                        Static254.method3606();
                        return;
                    }
                    if (arg0 == 5510) {
                        Static470.method6386();
                        return;
                    }
                    if (arg0 == 5511) {
                        local192 = intStack[--intStackPointer];
                        local834 = local192 >> 14 & 0x3FFF;
                        local109 = local192 & 0x3FFF;
                        local834 -= WorldMap.areaBaseX;
                        if (local834 < 0) {
                            local834 = 0;
                        } else if (local834 >= Static720.mapWidth) {
                            local834 = Static720.mapWidth;
                        }
                        local109 -= WorldMap.areaBaseZ;
                        if (local109 < 0) {
                            local109 = 0;
                        } else if (local109 >= Static501.mapLength) {
                            local109 = Static501.mapLength;
                        }
                        Camera.anInt6262 = (local834 << 9) + 256;
                        Camera.anInt4018 = (local109 << 9) + 256;
                        Camera.mode = CameraMode.MODE_FOUR;
                        Camera.anInt10383 = -1;
                        Camera.anInt10376 = -1;
                        return;
                    }
                    if (arg0 == 5512) {
                        Camera.smoothReset();
                        return;
                    }
                    if (arg0 == 5514) {
                        OrthoMode.zoom = intStack[--intStackPointer];
                        return;
                    }
                    if (arg0 == 5516) {
                        intStack[intStackPointer++] = OrthoMode.zoom;
                        return;
                    }
                    if (arg0 == 5517) {
                        local192 = intStack[--intStackPointer];
                        if (local192 == -1) {
                            local834 = local192 >> 14 & 0x3FFF;
                            local109 = local192 & 0x3FFF;
                            local834 -= WorldMap.areaBaseX;
                            if (local834 < 0) {
                                local834 = 0;
                            } else if (local834 >= Static720.mapWidth) {
                                local834 = Static720.mapWidth;
                            }
                            local109 -= WorldMap.areaBaseZ;
                            if (local109 < 0) {
                                local109 = 0;
                            } else if (local109 >= Static501.mapLength) {
                                local109 = Static501.mapLength;
                            }
                            Camera.anInt10376 = (local834 << 9) + 256;
                            Camera.anInt10383 = (local109 << 9) + 256;
                            return;
                        }
                        Camera.anInt10376 = -1;
                        Camera.anInt10383 = -1;
                        return;
                    }
                    if (arg0 == 5547) {
                        intStack[intStackPointer++] = Camera.mode == CameraMode.MODE_DEFAULT ? 1 : 0;
                        return;
                    }
                } else if (arg0 < 5700) {
                    if (arg0 == 5600) {
                        stringStackPointer -= 2;
                        local95 = stringStack[stringStackPointer];
                        local101 = stringStack[stringStackPointer + 1];
                        local109 = intStack[--intStackPointer];
                        LoginManager.requestLoginWithUsername(local109, local101, local95);
                        return;
                    }
                    if (arg0 == 5601) {
                        LoginManager.videoAdvertisementFinished();
                        return;
                    }
                    if (arg0 == 5602) {
                        if (!LoginManager.inProgress()) {
                            LoginManager.reset();
                        }
                        return;
                    }
                    if (arg0 == 5604) {
                        stringStackPointer--;
                        if (MainLogicManager.step != 3) {
                            return;
                        }
                        if (!LoginManager.inProgress() && LobbyManager.step == 0) {
                            LobbyManager.checkEmail(stringStack[stringStackPointer]);
                            return;
                        }
                        return;
                    }
                    if (arg0 == 5605) {
                        stringStackPointer -= 2;
                        intStackPointer -= 2;
                        if (MainLogicManager.step != 3) {
                            return;
                        }
                        if (!LoginManager.inProgress() && LobbyManager.step == 0) {
                            LobbyManager.createAccount(stringStack[stringStackPointer], intStack[intStackPointer], stringStack[stringStackPointer + 1], intStack[intStackPointer + 1] == 1);
                            return;
                        }
                        return;
                    }
                    if (arg0 == 5606) {
                        if (LobbyManager.step == 0) {
                            LobbyManager.response = LobbyManager.LOBBY_RESPONSE_DEFAULT;
                        }
                        return;
                    }
                    if (arg0 == 5607) {
                        intStack[intStackPointer++] = LoginManager.gameLoginResponse;
                        return;
                    }
                    if (arg0 == 5608) {
                        intStack[intStackPointer++] = LoginManager.profileTransferTicks;
                        return;
                    }
                    if (arg0 == 5609) {
                        intStack[intStackPointer++] = LobbyManager.response;
                        return;
                    }
                    if (arg0 == 5611) {
                        intStack[intStackPointer++] = LoginManager.disallowResult;
                        return;
                    }
                    if (arg0 == 5612) {
                        local192 = intStack[--intStackPointer];
                        LoginManager.loginToGame(local192);
                        return;
                    }
                    if (arg0 == 5613) {
                        intStack[intStackPointer++] = LoginManager.gameLoginResponse;
                        return;
                    }
                    if (arg0 == 5615) {
                        stringStackPointer -= 2;
                        local95 = stringStack[stringStackPointer];
                        local101 = stringStack[stringStackPointer + 1];
                        Static218.method3188(local101, local95);
                        return;
                    }
                    if (arg0 == 5616) {
                        LoginManager.logout(false);
                        return;
                    }
                    if (arg0 == 5617) {
                        intStack[intStackPointer++] = LoginManager.lobbyLoginResponse;
                        return;
                    }
                    if (arg0 == 5618) {
                        intStackPointer--;
                        return;
                    }
                    if (arg0 == 5619) {
                        intStackPointer--;
                        return;
                    }
                    if (arg0 == 5620) {
                        intStack[intStackPointer++] = 0;
                        return;
                    }
                    if (arg0 == 5621) {
                        stringStackPointer -= 2;
                        intStackPointer -= 2;
                        return;
                    }
                    if (arg0 == 5622) {
                        return;
                    }
                    if (arg0 == 5623) {
                        if (Client.ssKey != null) {
                            intStack[intStackPointer++] = 1;
                            return;
                        }
                        intStack[intStackPointer++] = 0;
                        return;
                    }
                    if (arg0 == 5624) {
                        intStack[intStackPointer++] = (int) (Client.userFlow >> 32);
                        intStack[intStackPointer++] = (int) (Client.userFlow & 0xFFFFFFFFFFFFFFFFL);
                        return;
                    }
                    if (arg0 == 5625) {
                        intStack[intStackPointer++] = Client.under13 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5626) {
                        Client.under13 = true;
                        Static358.setUnderageCookie();
                        return;
                    }
                    if (arg0 == 5627) {
                        intStack[intStackPointer++] = LoginManager.lastGameLoginResponse;
                        intStack[intStackPointer++] = LoginManager.lastDisallowResult;
                        intStack[intStackPointer++] = LoginManager.lastDisallowTrigger;
                        LoginManager.lastGameLoginResponse = -2;
                        LoginManager.lastDisallowResult = -1;
                        LoginManager.lastDisallowTrigger = -1;
                        return;
                    }
                    if (arg0 == 5628) {
                        intStack[intStackPointer++] = LoginManager.inProgress() ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5629) {
                        intStack[intStackPointer++] = Static660.anInt9837;
                        return;
                    }
                    if (arg0 == 5630) {
                        LoginManager.method1220();
                        return;
                    }
                    if (arg0 == 5631) {
                        intStackPointer -= 2;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        LoginManager.requestLoginFromSocialNetwork(local192, local834);
                        return;
                    }
                    if (arg0 == 5632) {
                        local192 = intStack[--intStackPointer];
                        Static303.method4428(local192);
                        return;
                    }
                    if (arg0 == 5633) {
                        intStack[intStackPointer++] = LoginManager.disallowTrigger;
                        return;
                    }
                } else if (arg0 < 6100) {
                    if (arg0 == 6001) {
                        local192 = intStack[--intStackPointer];
                        ClientOptions.instance.update(local192, ClientOptions.instance.brightness);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    @Pc(5337) boolean local5337;
                    if (arg0 == 6002) {
                        local5337 = intStack[--intStackPointer] == 1;
                        ClientOptions.instance.update(local5337 ? 1 : 0, ClientOptions.instance.animateBackgroundDefault);
                        ClientOptions.instance.update(local5337 ? 1 : 0, ClientOptions.instance.animateBackground);
                        MainLogicManager.mapBuild();
                        Static77.method1561();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6003) {
                        local5337 = intStack[--intStackPointer] == 1;
                        ClientOptions.instance.update(local5337 ? 2 : 1, ClientOptions.instance.removeRoofs);
                        ClientOptions.instance.update(local5337 ? 2 : 1, ClientOptions.instance.removeRoofsOverride);
                        Static77.method1561();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6005) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.groundDecor);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6007) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.idleAnimations);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6008) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.flickeringEffects);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6010) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.spotShadows);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6011) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.hardShadows);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6012) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.lightDetail);
                        Static296.updateFeatureMask();
                        InterfaceManager.loginOpened();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6014) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 2 : 0, ClientOptions.instance.waterDetail);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6015) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.fog);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6016) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.antialiasingQuality);
                        Static32.setToolkit(ClientOptions.instance.toolkit.getValue(), false);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6017) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.stereoSound);
                        Static150.method2455();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6018) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.soundVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6019) {
                        local192 = intStack[--intStackPointer];
                        local834 = ClientOptions.instance.musicVolume.getValue();
                        if (local192 != local834) {
                            if (MainLogicStep.isAtGameScreen(MainLogicManager.step)) {
                                if (local834 == 0 && SongManager.playing != -1) {
                                    SongManager.method8229(SongManager.playing, local192, js5.MIDI_SONGS);
                                    AudioRenderer.mixBussReset();
                                    Static501.aBoolean575 = false;
                                } else if (local192 == 0) {
                                    Static100.method1988();
                                    Static501.aBoolean575 = false;
                                } else {
                                    Static126.method2226(local192);
                                }
                            }
                            ClientOptions.instance.update(local192, ClientOptions.instance.musicVolume);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6020) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.backgroundSoundVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6021) {
                        local192 = ClientOptions.instance.removeRoofs.getValue();
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 0 : local192, ClientOptions.instance.removeRoofsOverride);
                        Static77.method1561();
                        return;
                    }
                    if (arg0 == 6023) {
                        local192 = intStack[--intStackPointer];
                        ClientOptions.instance.update(local192, ClientOptions.instance.particles);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6024) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.antialiasingMode);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6025) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.buildArea);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6027) {
                        local192 = intStack[--intStackPointer];
                        if (local192 < 0 || local192 > 1) {
                            local192 = 0;
                        }
                        Static249.setBloom(local192 == 1);
                        return;
                    }
                    if (arg0 == 6028) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 0 ? 0 : 1, ClientOptions.instance.customCursors);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6029) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.idleAnimations);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6030) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 0 ? 0 : 1, ClientOptions.instance.groundBlending);
                        ClientOptions.save();
                        MainLogicManager.mapBuild();
                        return;
                    }
                    if (arg0 == 6031) {
                        local192 = intStack[--intStackPointer];
                        if (local192 < 0 || local192 > 5) {
                            local192 = 2;
                        }
                        Static32.setToolkit(local192, false);
                        return;
                    }
                    if (arg0 == 6032) {
                        intStackPointer -= 2;
                        local192 = intStack[intStackPointer];
                        local1578 = intStack[intStackPointer + 1] == 1;
                        ClientOptions.instance.update(local192, ClientOptions.instance.toolkitDefault);
                        if (!local1578) {
                            ClientOptions.instance.update(0, ClientOptions.instance.graphicsQuality);
                        }
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6033) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.cpuUsage);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6034) {
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : 0, ClientOptions.instance.textures);
                        ClientOptions.save();
                        Static296.updateFeatureMask();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6035) {
                        local192 = ClientOptions.instance.animateBackgroundDefault.getValue();
                        ClientOptions.instance.update(intStack[--intStackPointer] == 1 ? 1 : local192, ClientOptions.instance.animateBackground);
                        MainLogicManager.mapBuild();
                        Static77.method1561();
                        return;
                    }
                    if (arg0 == 6036) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.maxScreenSize);
                        ClientOptions.save();
                        Static284.aBoolean355 = true;
                        return;
                    }
                    if (arg0 == 6037) {
                        ClientOptions.instance.update(intStack[--intStackPointer], ClientOptions.instance.speechVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6038) {
                        local192 = intStack[--intStackPointer];
                        local834 = ClientOptions.instance.loginVolume.getValue();
                        if (local192 != local834 && SongManager.playing == AudioDefaults.themeMusic) {
                            if (!MainLogicStep.isAtGameScreen(MainLogicManager.step)) {
                                if (local834 == 0) {
                                    SongManager.method8229(SongManager.playing, local192, js5.MIDI_SONGS);
                                    AudioRenderer.mixBussReset();
                                    Static501.aBoolean575 = false;
                                } else if (local192 == 0) {
                                    Static100.method1988();
                                    Static501.aBoolean575 = false;
                                } else {
                                    Static126.method2226(local192);
                                }
                            }
                            ClientOptions.instance.update(local192, ClientOptions.instance.loginVolume);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6039) {
                        local192 = intStack[--intStackPointer];
                        if (local192 > 255 || local192 < 0) {
                            local192 = 0;
                        }
                        if (local192 != ClientOptions.instance.loadingSequence.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.loadingSequence);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6040) {
                        local192 = intStack[--intStackPointer];
                        if (local192 != ClientOptions.instance.orthographic.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.orthographic);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            OrthoMode.enter();
                        }
                        return;
                    }
                    if (arg0 == 6041) {
                        local192 = intStack[--intStackPointer];
                        if (local192 != ClientOptions.instance.skydetail.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.skydetail);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                } else if (arg0 < 6200) {
                    if (arg0 == 6101) {
                        intStack[intStackPointer++] = ClientOptions.instance.brightness.getValue();
                        return;
                    }
                    if (arg0 == 6102) {
                        intStack[intStackPointer++] = ClientOptions.instance.animateBackgroundDefault.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6103) {
                        intStack[intStackPointer++] = ClientOptions.instance.removeRoofs.getValue() == 2 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6105) {
                        intStack[intStackPointer++] = ClientOptions.instance.groundDecor.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6107) {
                        intStack[intStackPointer++] = ClientOptions.instance.idleAnimations.getValue();
                        return;
                    }
                    if (arg0 == 6108) {
                        intStack[intStackPointer++] = ClientOptions.instance.flickeringEffects.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6110) {
                        intStack[intStackPointer++] = ClientOptions.instance.spotShadows.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6111) {
                        intStack[intStackPointer++] = ClientOptions.instance.hardShadows.getValue();
                        return;
                    }
                    if (arg0 == 6112) {
                        intStack[intStackPointer++] = ClientOptions.instance.lightDetail.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6114) {
                        intStack[intStackPointer++] = ClientOptions.instance.waterDetail.getValue() == 2 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6115) {
                        intStack[intStackPointer++] = ClientOptions.instance.fog.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6116) {
                        intStack[intStackPointer++] = ClientOptions.instance.antialiasingQuality.getValue();
                        return;
                    }
                    if (arg0 == 6117) {
                        intStack[intStackPointer++] = ClientOptions.instance.stereoSound.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6118) {
                        intStack[intStackPointer++] = ClientOptions.instance.soundVolume.getValue();
                        return;
                    }
                    if (arg0 == 6119) {
                        intStack[intStackPointer++] = ClientOptions.instance.musicVolume.getValue();
                        return;
                    }
                    if (arg0 == 6120) {
                        intStack[intStackPointer++] = ClientOptions.instance.backgroundSoundVolume.getValue();
                        return;
                    }
                    if (arg0 == 6123) {
                        intStack[intStackPointer++] = ParticleManager.getOption();
                        return;
                    }
                    if (arg0 == 6124) {
                        intStack[intStackPointer++] = ClientOptions.instance.antialiasingMode.getValue();
                        return;
                    }
                    if (arg0 == 6125) {
                        intStack[intStackPointer++] = ClientOptions.instance.buildArea.getValue();
                        return;
                    }
                    if (arg0 == 6127) {
                        intStack[intStackPointer++] = ClientOptions.instance.bloom.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6128) {
                        intStack[intStackPointer++] = ClientOptions.instance.customCursors.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6129) {
                        intStack[intStackPointer++] = ClientOptions.instance.idleAnimations.getValue();
                        return;
                    }
                    if (arg0 == 6130) {
                        intStack[intStackPointer++] = ClientOptions.instance.groundBlending.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6131) {
                        intStack[intStackPointer++] = ClientOptions.instance.toolkit.getValue();
                        return;
                    }
                    if (arg0 == 6132) {
                        intStack[intStackPointer++] = ClientOptions.instance.toolkitDefault.getValue();
                        return;
                    }
                    if (arg0 == 6133) {
                        intStack[intStackPointer++] = GameShell.signLink.signed && !GameShell.signLink.microsoftjava ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6135) {
                        intStack[intStackPointer++] = ClientOptions.instance.cpuUsage.value();
                        return;
                    }
                    if (arg0 == 6136) {
                        intStack[intStackPointer++] = ClientOptions.instance.textures.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6138) {
                        intStack[intStackPointer++] = Static363.profileToolkit(200, ClientOptions.instance.toolkit.getValue());
                        return;
                    }
                    if (arg0 == 6139) {
                        intStack[intStackPointer++] = ClientOptions.instance.maxScreenSize.getValue();
                        return;
                    }
                    if (arg0 == 6142) {
                        intStack[intStackPointer++] = ClientOptions.instance.speechVolume.getValue();
                        return;
                    }
                    if (arg0 == 6143) {
                        intStack[intStackPointer++] = ClientOptions.instance.loginVolume.getValue();
                        return;
                    }
                    if (arg0 == 6144) {
                        intStack[intStackPointer++] = Static3.chooseSafeMode ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6145) {
                        intStack[intStackPointer++] = ClientOptions.instance.loadingSequence.getValue();
                        return;
                    }
                    if (arg0 == 6146) {
                        intStack[intStackPointer++] = ClientOptions.instance.orthographic.getValue();
                        return;
                    }
                    if (arg0 == 6147) {
                        intStack[intStackPointer++] = SystemInfo.instance.totalMemory < 512 || Static3.chooseSafeMode || Static171.graphicsError ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6148) {
                        intStack[intStackPointer++] = Static416.aBoolean472 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6149) {
                        intStack[intStackPointer++] = ClientOptions.instance.skydetail.getValue();
                        return;
                    }
                } else if (arg0 < 6300) {
                    if (arg0 == 6200) {
                        intStackPointer -= 2;
                        Static640.aShort122 = (short) intStack[intStackPointer];
                        if (Static640.aShort122 <= 0) {
                            Static640.aShort122 = 256;
                        }
                        Static640.aShort121 = (short) intStack[intStackPointer + 1];
                        if (Static640.aShort121 <= 0) {
                            Static640.aShort121 = 205;
                        }
                        return;
                    }
                    if (arg0 == 6201) {
                        intStackPointer -= 2;
                        Static228.aShort45 = (short) intStack[intStackPointer];
                        if (Static228.aShort45 <= 0) {
                            Static228.aShort45 = 256;
                        }
                        Camera.zoom = (short) intStack[intStackPointer + 1];
                        if (Camera.zoom <= 0) {
                            Camera.zoom = 320;
                        }
                        return;
                    }
                    if (arg0 == 6202) {
                        intStackPointer -= 4;
                        Static25.aShort1 = (short) intStack[intStackPointer];
                        if (Static25.aShort1 <= 0) {
                            Static25.aShort1 = 1;
                        }
                        Static598.aShort120 = (short) intStack[intStackPointer + 1];
                        if (Static598.aShort120 <= 0) {
                            Static598.aShort120 = 32767;
                        } else if (Static598.aShort120 < Static25.aShort1) {
                            Static598.aShort120 = Static25.aShort1;
                        }
                        Static552.aShort123 = (short) intStack[intStackPointer + 2];
                        if (Static552.aShort123 <= 0) {
                            Static552.aShort123 = 1;
                        }
                        Static306.aShort59 = (short) intStack[intStackPointer + 3];
                        if (Static306.aShort59 <= 0) {
                            Static306.aShort59 = 32767;
                            return;
                        }
                        if (Static306.aShort59 < Static552.aShort123) {
                            Static306.aShort59 = Static552.aShort123;
                        }
                        return;
                    }
                    if (arg0 == 6203) {
                        Static498.method6643(0, false, 0, InterfaceManager.scene.height, InterfaceManager.scene.width);
                        intStack[intStackPointer++] = Static242.anInt3971;
                        intStack[intStackPointer++] = Static200.anInt3305;
                        return;
                    }
                    if (arg0 == 6204) {
                        intStack[intStackPointer++] = Static228.aShort45;
                        intStack[intStackPointer++] = Camera.zoom;
                        return;
                    }
                    if (arg0 == 6205) {
                        intStack[intStackPointer++] = Static640.aShort122;
                        intStack[intStackPointer++] = Static640.aShort121;
                        return;
                    }
                } else if (arg0 < 6400) {
                    if (arg0 == 6300) {
                        intStack[intStackPointer++] = (int) (SystemTimer.safetime() / TimeUtils.MILLISECONDS_PER_MINUTE);
                        return;
                    }
                    if (arg0 == 6301) {
                        intStack[intStackPointer++] = (int) (SystemTimer.safetime() / TimeUtils.MILLISECONDS_PER_DAY) - TimeUtils.RUNEDAYS_SINCE_UNIX_EPOCH;
                        return;
                    }
                    if (arg0 == 6302) {
                        intStackPointer -= 3;
                        local192 = intStack[intStackPointer];
                        local834 = intStack[intStackPointer + 1];
                        local109 = intStack[intStackPointer + 2];
                        @Pc(7384) long local7384 = TimeUtils.timeFromDate(local192, local834, local109);
                        local3561 = TimeUtils.runedaysFromTime(local7384);
                        if (local109 < 1970) {
                            local3561--;
                        }
                        intStack[intStackPointer++] = local3561;
                        return;
                    }
                    if (arg0 == 6303) {
                        intStack[intStackPointer++] = TimeUtils.yearFromTime(SystemTimer.safetime());
                        return;
                    }
                    if (arg0 == 6304) {
                        local192 = intStack[--intStackPointer];
                        local1578 = true;
                        if (local192 < 0) {
                            local1578 = (local192 + 1) % 4 == 0;
                        } else if (local192 < 1582) {
                            local1578 = local192 % 4 == 0;
                        } else if (local192 % 4 != 0) {
                            local1578 = false;
                        } else if (local192 % 100 != 0) {
                            local1578 = true;
                        } else if (local192 % 400 != 0) {
                            local1578 = false;
                        }
                        intStack[intStackPointer++] = local1578 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6305) {
                        local192 = intStack[--intStackPointer];
                        @Pc(7512) int[] local7512 = TimeUtils.dateFromRunedays(local192);
                        Arrays.copy(local7512, 0, intStack, intStackPointer, 3);
                        intStackPointer += 3;
                        return;
                    }
                    if (arg0 == 6306) {
                        local192 = intStack[--intStackPointer];
                        intStack[intStackPointer++] = (int) (TimeUtils.timeFromRunedays(local192) / TimeUtils.MILLISECONDS_PER_MINUTE);
                        return;
                    }
                } else if (arg0 < 6500) {
                    if (arg0 == 6405) {
                        intStack[intStackPointer++] = Static21.method8119() ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6406) {
                        intStack[intStackPointer++] = Static385.method5421() ? 1 : 0;
                        return;
                    }
                } else if (arg0 < 6600) {
                    if (arg0 == 6500) {
                        if (MainLogicManager.step == 7 && !LoginManager.inProgress() && LobbyManager.step == 0) {
                            if (WorldList.fetching) {
                                intStack[intStackPointer++] = 0;
                                return;
                            }
                            if (WorldList.lastReply > SystemTimer.safetime() - 1000L) {
                                intStack[intStackPointer++] = 1;
                                return;
                            }
                            WorldList.fetching = true;
                            @Pc(7662) ClientMessage local7662 = ClientMessage.create(ClientProt.WORLDLIST_FETCH, ServerConnection.LOBBY.cipher);
                            local7662.bitPacket.p4(WorldList.checksum);
                            ServerConnection.LOBBY.send(local7662);
                            intStack[intStackPointer++] = 0;
                            return;
                        }
                        intStack[intStackPointer++] = 1;
                        return;
                    }
                    @Pc(7719) Country local7719;
                    @Pc(7686) GameWorld local7686;
                    if (arg0 == 6501) {
                        local7686 = WorldList.first();
                        if (local7686 != null) {
                            intStack[intStackPointer++] = local7686.id;
                            intStack[intStackPointer++] = local7686.flags;
                            stringStack[stringStackPointer++] = local7686.activity;
                            local7719 = local7686.method6717();
                            intStack[intStackPointer++] = local7719.flag;
                            stringStack[stringStackPointer++] = local7719.name;
                            intStack[intStackPointer++] = local7686.population;
                            intStack[intStackPointer++] = local7686.ping;
                            stringStack[stringStackPointer++] = local7686.address;
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        return;
                    }
                    if (arg0 == 6502) {
                        local7686 = WorldList.next();
                        if (local7686 != null) {
                            intStack[intStackPointer++] = local7686.id;
                            intStack[intStackPointer++] = local7686.flags;
                            stringStack[stringStackPointer++] = local7686.activity;
                            local7719 = local7686.method6717();
                            intStack[intStackPointer++] = local7719.flag;
                            stringStack[stringStackPointer++] = local7719.name;
                            intStack[intStackPointer++] = local7686.population;
                            intStack[intStackPointer++] = local7686.ping;
                            stringStack[stringStackPointer++] = local7686.address;
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        return;
                    }
                    if (arg0 == 6503) {
                        local192 = intStack[--intStackPointer];
                        local101 = stringStack[--stringStackPointer];
                        if (MainLogicManager.step == 7 && !LoginManager.inProgress() && LobbyManager.step == 0) {
                            intStack[intStackPointer++] = client.connectTo(local192, local101) ? 1 : 0;
                            return;
                        }
                        intStack[intStackPointer++] = 0;
                        return;
                    }
                    if (arg0 == 6506) {
                        local192 = intStack[--intStackPointer];
                        @Pc(8053) GameWorld local8053 = WorldList.list(local192);
                        if (local8053 != null) {
                            intStack[intStackPointer++] = local8053.flags;
                            stringStack[stringStackPointer++] = local8053.activity;
                            @Pc(8077) Country local8077 = local8053.method6717();
                            intStack[intStackPointer++] = local8077.flag;
                            stringStack[stringStackPointer++] = local8077.name;
                            intStack[intStackPointer++] = local8053.population;
                            intStack[intStackPointer++] = local8053.ping;
                            stringStack[stringStackPointer++] = local8053.address;
                            return;
                        }
                        intStack[intStackPointer++] = -1;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        intStack[intStackPointer++] = 0;
                        intStack[intStackPointer++] = 0;
                        stringStack[stringStackPointer++] = "";
                        return;
                    }
                    if (arg0 == 6507) {
                        intStackPointer -= 4;
                        local192 = intStack[intStackPointer];
                        local1578 = intStack[intStackPointer + 1] == 1;
                        local109 = intStack[intStackPointer + 2];
                        local2331 = intStack[intStackPointer + 3] == 1;
                        Static210.quicksortWorldList(local1578, local109, local192, local2331);
                        return;
                    }
                    if (arg0 == 6508) {
                        Static152.selectAutoWorld();
                        return;
                    }
                    if (arg0 == 6509) {
                        if (MainLogicManager.step != 7) {
                            return;
                        }
                        Static60.aBoolean86 = intStack[--intStackPointer] == 1;
                        return;
                    }
                    if (arg0 == 6510) {
                        intStack[intStackPointer++] = Client.worldFlags;
                        return;
                    }
                } else if (arg0 >= 6700) {
                    if (arg0 < 6800 && Client.modeWhat == ModeWhat.WIP) {
                        if (arg0 == 6700) {
                            local192 = InterfaceManager.subInterfaces.size();
                            if (InterfaceManager.topLevelInterface != -1) {
                                local192++;
                            }
                            intStack[intStackPointer++] = local192;
                            return;
                        }
                        if (arg0 == 6701) {
                            local192 = intStack[--intStackPointer];
                            if (InterfaceManager.topLevelInterface != -1) {
                                if (local192 == 0) {
                                    intStack[intStackPointer++] = InterfaceManager.topLevelInterface;
                                    return;
                                }
                                local192--;
                            }
                            @Pc(8344) SubInterface local8344 = (SubInterface) InterfaceManager.subInterfaces.first();
                            while (local192-- > 0) {
                                local8344 = (SubInterface) InterfaceManager.subInterfaces.next();
                            }
                            intStack[intStackPointer++] = local8344.id;
                            return;
                        }
                        if (arg0 == 6702) {
                            local192 = intStack[--intStackPointer];
                            if (InterfaceList.interfaces[local192] == null) {
                                stringStack[stringStackPointer++] = "";
                                return;
                            }
                            local101 = InterfaceList.interfaces[local192][0].name;
                            if (local101 == null) {
                                stringStack[stringStackPointer++] = "";
                                return;
                            }
                            stringStack[stringStackPointer++] = local101.substring(0, local101.indexOf(58));
                            return;
                        }
                        if (arg0 == 6703) {
                            local192 = intStack[--intStackPointer];
                            if (InterfaceList.interfaces[local192] == null) {
                                intStack[intStackPointer++] = 0;
                                return;
                            }
                            intStack[intStackPointer++] = InterfaceList.interfaces[local192].length;
                            return;
                        }
                        if (arg0 == 6704) {
                            intStackPointer -= 2;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            if (InterfaceList.interfaces[local192] == null) {
                                stringStack[stringStackPointer++] = "";
                                return;
                            }
                            local198 = InterfaceList.interfaces[local192][local834].name;
                            if (local198 == null) {
                                stringStack[stringStackPointer++] = "";
                                return;
                            }
                            stringStack[stringStackPointer++] = local198;
                            return;
                        }
                        if (arg0 == 6705) {
                            intStackPointer -= 2;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            if (InterfaceList.interfaces[local192] == null) {
                                intStack[intStackPointer++] = 0;
                                return;
                            }
                            intStack[intStackPointer++] = InterfaceList.interfaces[local192][local834].serverTriggers;
                            return;
                        }
                        if (arg0 == 6706) {
                            return;
                        }
                        if (arg0 == 6707) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 1);
                            return;
                        }
                        if (arg0 == 6708) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 2);
                            return;
                        }
                        if (arg0 == 6709) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 3);
                            return;
                        }
                        if (arg0 == 6710) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 4);
                            return;
                        }
                        if (arg0 == 6711) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 5);
                            return;
                        }
                        if (arg0 == 6712) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 6);
                            return;
                        }
                        if (arg0 == 6713) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 7);
                            return;
                        }
                        if (arg0 == 6714) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 8);
                            return;
                        }
                        if (arg0 == 6715) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 9);
                            return;
                        }
                        if (arg0 == 6716) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 10);
                            return;
                        }
                        if (arg0 == 6717) {
                            intStackPointer -= 3;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            local109 = intStack[intStackPointer + 2];
                            @Pc(8940) Component local8940 = InterfaceList.getComponent(local192 << 16 | local834, local109);
                            InterfaceManager.endTargetMode();
                            @Pc(8945) ServerActiveProperties local8945 = InterfaceManager.serverActiveProperties(local8940);
                            InterfaceManager.enterTargetMode(local8945.getTargetMask(), local8940, local8945.targetParam);
                            return;
                        }
                    } else if (arg0 < 6900) {
                        @Pc(8975) MapElementType local8975;
                        if (arg0 == 6800) {
                            local192 = intStack[--intStackPointer];
                            local8975 = MapElementTypeList.instance.list(local192);
                            if (local8975.text == null) {
                                stringStack[stringStackPointer++] = "";
                                return;
                            }
                            stringStack[stringStackPointer++] = local8975.text;
                            return;
                        }
                        if (arg0 == 6801) {
                            local192 = intStack[--intStackPointer];
                            local8975 = MapElementTypeList.instance.list(local192);
                            intStack[intStackPointer++] = local8975.sprite;
                            return;
                        }
                        if (arg0 == 6802) {
                            local192 = intStack[--intStackPointer];
                            local8975 = MapElementTypeList.instance.list(local192);
                            intStack[intStackPointer++] = local8975.font;
                            return;
                        }
                        if (arg0 == 6803) {
                            local192 = intStack[--intStackPointer];
                            local8975 = MapElementTypeList.instance.list(local192);
                            intStack[intStackPointer++] = local8975.category;
                            return;
                        }
                        if (arg0 == 6804) {
                            intStackPointer -= 2;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            @Pc(9098) ParamType local9098 = ParamTypeList.instance.list(local834);
                            if (local9098.isString()) {
                                stringStack[stringStackPointer++] = MapElementTypeList.instance.list(local192).param(local834, local9098.defaultstr);
                                return;
                            }
                            intStack[intStackPointer++] = MapElementTypeList.instance.list(local192).param(local9098.defaultint, local834);
                            return;
                        }
                    } else if (arg0 < 7000) {
                        if (arg0 == 6900) {
                            intStack[intStackPointer++] = Static389.underage && !Static34.parentalChatConsent ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6901) {
                            intStack[intStackPointer++] = (int) (Static416.subscriptionExpiration / TimeUtils.MILLISECONDS_PER_MINUTE);
                            intStack[intStackPointer++] = (int) ((Static416.subscriptionExpiration - SystemTimer.safetime() - Static94.remainingSubscription) / TimeUtils.MILLISECONDS_PER_MINUTE);
                            intStack[intStackPointer++] = Static425.activeSubscription ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6902) {
                            intStack[intStackPointer++] = Static677.recoverySetDate;
                            return;
                        }
                        if (arg0 == 6903) {
                            intStack[intStackPointer++] = Static476.unreadMessages;
                            return;
                        }
                        if (arg0 == 6904) {
                            intStack[intStackPointer++] = Static323.lastLoginDate;
                            return;
                        }
                        if (arg0 == 6905) {
                            local95 = "";
                            if (Static439.hostnameResource != null) {
                                if (Static439.hostnameResource.result == null) {
                                    local95 = Static419.method5756(Static439.hostnameResource.intData1);
                                } else {
                                    local95 = (String) Static439.hostnameResource.result;
                                }
                            }
                            stringStack[stringStackPointer++] = local95;
                            return;
                        }
                        if (arg0 == 6906) {
                            intStack[intStackPointer++] = Static335.emailStatus;
                            return;
                        }
                        if (arg0 == 6907) {
                            intStack[intStackPointer++] = Static626.creditCardExpiry;
                            return;
                        }
                        if (arg0 == 6908) {
                            intStack[intStackPointer++] = Static636.loyaltyRateExpiry;
                            return;
                        }
                        if (arg0 == 6909) {
                            intStack[intStackPointer++] = Static420.lobbyDobRequested ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6910) {
                            intStack[intStackPointer++] = Static106.lobbyMembersStats;
                            return;
                        }
                        if (arg0 == 6911) {
                            intStack[intStackPointer++] = Static639.lobbyPlayAge;
                            return;
                        }
                        if (arg0 == 6912) {
                            intStack[intStackPointer++] = Static438.lobbyLoyaltyBalance;
                            return;
                        }
                        if (arg0 == 6913) {
                            intStack[intStackPointer++] = Static435.lobbyJcoinsBalance;
                            return;
                        }
                        if (arg0 == 6914) {
                            intStack[intStackPointer++] = Static684.autosetupDosetup ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6915) {
                            intStack[intStackPointer++] = Static134.autosetupLevel;
                            return;
                        }
                    } else if (arg0 < 7100) {
                        if (arg0 == 7000) {
                            local192 = Static519.autosetup();
                            intStack[intStackPointer++] = Static165.anInt2810 = ClientOptions.instance.toolkit.getValue();
                            intStack[intStackPointer++] = local192;
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7001) {
                            Static395.method9162();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7002) {
                            Static133.method2316();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7003) {
                            Static75.method6239();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7004) {
                            Static468.method7643();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7005) {
                            ClientOptions.instance.update(0, ClientOptions.instance.graphicsQuality);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7006) {
                            if (Static165.anInt2810 == 2) {
                                Static449.aBoolean511 = true;
                                return;
                            }
                            if (Static165.anInt2810 == 1) {
                                Static698.aBoolean792 = true;
                                return;
                            }
                            if (Static165.anInt2810 == 3) {
                                Static78.aBoolean139 = true;
                            }
                            return;
                        }
                        if (arg0 == 7007) {
                            intStack[intStackPointer++] = ClientOptions.instance.graphicsQuality.getValue();
                            return;
                        }
                    } else if (arg0 < 7200) {
                        if (arg0 == 7100) {
                            intStackPointer -= 2;
                            local192 = intStack[intStackPointer];
                            local834 = intStack[intStackPointer + 1];
                            if (local192 != -1) {
                                if (local834 > 255) {
                                    local834 = 255;
                                } else if (local834 < 0) {
                                    local834 = 0;
                                }
                                VideoTypeList.method6802(false, local192, local834);
                            }
                            return;
                        }
                        if (arg0 == 7101) {
                            local192 = intStack[--intStackPointer];
                            if (local192 != -1) {
                                VideoManager.stop(local192);
                            }
                            return;
                        }
                        if (arg0 == 7102) {
                            local192 = intStack[--intStackPointer];
                            if (local192 != -1) {
                                VideoTypeList.method9267(local192);
                            }
                            return;
                        }
                        if (arg0 == 7103) {
                            intStack[intStackPointer++] = LibraryManager.isNativeLoaded("jagtheora") ? 1 : 0;
                            return;
                        }
                    } else if (arg0 < 7300) {
                        if (arg0 == 7201) {
                            intStack[intStackPointer++] = ClientOptions.instance.groundDecor.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7202) {
                            intStack[intStackPointer++] = ClientOptions.instance.spotShadows.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7203) {
                            intStack[intStackPointer++] = ClientOptions.instance.hardShadows.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7204) {
                            intStack[intStackPointer++] = ClientOptions.instance.waterDetail.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7205) {
                            intStack[intStackPointer++] = ClientOptions.instance.antialiasingMode.isCompatible() && Toolkit.active.method8015() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7206) {
                            intStack[intStackPointer++] = ClientOptions.instance.particles.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7207) {
                            intStack[intStackPointer++] = ClientOptions.instance.buildArea.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7208) {
                            intStack[intStackPointer++] = ClientOptions.instance.bloom.isCompatible() && Toolkit.active.method7936() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7209) {
                            intStack[intStackPointer++] = ClientOptions.instance.groundBlending.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7210) {
                            intStack[intStackPointer++] = ClientOptions.instance.textures.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7211) {
                            intStack[intStackPointer++] = ClientOptions.instance.maxScreenSize.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7212) {
                            intStack[intStackPointer++] = ClientOptions.instance.fog.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7213) {
                            intStack[intStackPointer++] = ClientOptions.instance.orthographic.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7214) {
                            intStack[intStackPointer++] = ClientOptions.instance.toolkitDefault.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7215) {
                            intStack[intStackPointer++] = ClientOptions.instance.skydetail.isCompatible() ? 1 : 0;
                            return;
                        }
                    } else if (arg0 < 7400) {
                        if (arg0 == 7301) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.groundDecor.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7302) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.spotShadows.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7303) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.hardShadows.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7304) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.waterDetail.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7305) {
                            local192 = intStack[--intStackPointer];
                            if (!Toolkit.active.method8015()) {
                                intStack[intStackPointer++] = 3;
                                return;
                            }
                            intStack[intStackPointer++] = ClientOptions.instance.antialiasingMode.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7306) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.particles.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7307) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.buildArea.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7308) {
                            local192 = intStack[--intStackPointer];
                            if (!Toolkit.active.method7936()) {
                                intStack[intStackPointer++] = 3;
                                return;
                            }
                            intStack[intStackPointer++] = ClientOptions.instance.bloom.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7309) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.groundBlending.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7310) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.textures.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7311) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.maxScreenSize.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7312) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.fog.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7313) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.orthographic.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7314) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.toolkitDefault.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7315) {
                            local192 = intStack[--intStackPointer];
                            intStack[intStackPointer++] = ClientOptions.instance.skydetail.getCompatibility(local192);
                            return;
                        }
                    }
                }
            }
        }
        throw new IllegalStateException(String.valueOf(arg0));
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!pd;I)V")
    public static void executeHookInner(@OriginalArg(0) HookRequest hook, @OriginalArg(1) int maxOps) {
        @Pc(2) Object[] arguments = hook.arguments;
        @Pc(8) int id = (Integer) arguments[0];
        @Pc(12) ClientScript script = ClientScriptList.list(id);
        if (script == null) {
            return;
        }

        intVars = new int[script.intVarCount];
        @Pc(22) int intCount = 0;

        stringVars = new String[script.stringVarCount];
        @Pc(28) int stringCount = 0;

        longVars = new long[script.longVarCount];
        @Pc(34) int longCount = 0;

        for (@Pc(36) int i = 1; i < arguments.length; i++) {
            if (arguments[i] instanceof Integer) {
                @Pc(48) int v = (Integer) arguments[i];
                if (v == Integer.MIN_VALUE + 1) {
                    v = hook.mouseX;
                }
                if (v == Integer.MIN_VALUE + 2) {
                    v = hook.mouseY;
                }
                if (v == Integer.MIN_VALUE + 3) {
                    v = hook.source == null ? -1 : hook.source.slot;
                }
                if (v == Integer.MIN_VALUE + 4) {
                    v = hook.op;
                }
                if (v == Integer.MIN_VALUE + 5) {
                    v = hook.source == null ? -1 : hook.source.id;
                }
                if (v == Integer.MIN_VALUE + 6) {
                    v = hook.target == null ? -1 : hook.target.slot;
                }
                if (v == Integer.MIN_VALUE + 7) {
                    v = hook.target == null ? -1 : hook.target.id;
                }
                if (v == Integer.MIN_VALUE + 8) {
                    v = hook.keyCode;
                }
                if (v == Integer.MIN_VALUE + 9) {
                    v = hook.keyChar;
                }

                intVars[intCount++] = v;
            } else if (arguments[i] instanceof String) {
                @Pc(154) String s = (String) arguments[i];
                if (s.equals("event_opbase")) {
                    s = hook.opBase;
                }

                stringVars[stringCount++] = s;
            } else if (arguments[i] instanceof Long) {
                @Pc(180) long l = (Long) arguments[i];
                longVars[longCount++] = l;
            }
        }

        lastHookId = hook.id;
        executeScript(script, maxOps);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(C)I")
    public static int charIsPrintable(@OriginalArg(0) char c) {
        return StringTools.isPrintable(c) ? 1 : 0;
    }

    @OriginalMember(owner = "client!ou", name = "e", descriptor = "(I)Ljava/lang/String;")
    public static String getClanSettingString(@OriginalArg(0) int arg0) {
        @Pc(9) String local9 = clanSettings.getExtraSettingString(Client.modeGame.id << 16 | arg0);
        return local9 == null ? "" : local9;
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public static void method6426(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
        if (Client.staffModLevel == 0 && (Static389.underage && !Static34.parentalChatConsent || Static617.quickChatWorld)) {
            return;
        }
        @Pc(18) String local18 = arg0.toLowerCase();
        @Pc(20) byte local20 = 0;
        if (local18.startsWith(LocalisedText.CHATCOL0.localise(0))) {
            local20 = 0;
            arg0 = arg0.substring(LocalisedText.CHATCOL0.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL1.localise(0))) {
            local20 = 1;
            arg0 = arg0.substring(LocalisedText.CHATCOL1.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL2.localise(0))) {
            local20 = 2;
            arg0 = arg0.substring(LocalisedText.CHATCOL2.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL3.localise(0))) {
            local20 = 3;
            arg0 = arg0.substring(LocalisedText.CHATCOL3.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL4.localise(0))) {
            local20 = 4;
            arg0 = arg0.substring(LocalisedText.CHATCOL4.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL5.localise(0))) {
            local20 = 5;
            arg0 = arg0.substring(LocalisedText.CHATCOL5.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL6.localise(0))) {
            local20 = 6;
            arg0 = arg0.substring(LocalisedText.CHATCOL6.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL7.localise(0))) {
            local20 = 7;
            arg0 = arg0.substring(LocalisedText.CHATCOL7.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL8.localise(0))) {
            local20 = 8;
            arg0 = arg0.substring(LocalisedText.CHATCOL8.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL9.localise(0))) {
            local20 = 9;
            arg0 = arg0.substring(LocalisedText.CHATCOL9.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL10.localise(0))) {
            local20 = 10;
            arg0 = arg0.substring(LocalisedText.CHATCOL10.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL11.localise(0))) {
            local20 = 11;
            arg0 = arg0.substring(LocalisedText.CHATCOL11.localise(0).length());
        } else if (Client.language != 0) {
            if (local18.startsWith(LocalisedText.CHATCOL0.localise(Client.language))) {
                local20 = 0;
                arg0 = arg0.substring(LocalisedText.CHATCOL0.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL1.localise(Client.language))) {
                local20 = 1;
                arg0 = arg0.substring(LocalisedText.CHATCOL1.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL2.localise(Client.language))) {
                local20 = 2;
                arg0 = arg0.substring(LocalisedText.CHATCOL2.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL3.localise(Client.language))) {
                local20 = 3;
                arg0 = arg0.substring(LocalisedText.CHATCOL3.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL4.localise(Client.language))) {
                local20 = 4;
                arg0 = arg0.substring(LocalisedText.CHATCOL4.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL5.localise(Client.language))) {
                local20 = 5;
                arg0 = arg0.substring(LocalisedText.CHATCOL5.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL6.localise(Client.language))) {
                local20 = 6;
                arg0 = arg0.substring(LocalisedText.CHATCOL6.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL7.localise(Client.language))) {
                local20 = 7;
                arg0 = arg0.substring(LocalisedText.CHATCOL7.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL8.localise(Client.language))) {
                local20 = 8;
                arg0 = arg0.substring(LocalisedText.CHATCOL8.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL9.localise(Client.language))) {
                local20 = 9;
                arg0 = arg0.substring(LocalisedText.CHATCOL9.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL10.localise(Client.language))) {
                local20 = 10;
                arg0 = arg0.substring(LocalisedText.CHATCOL10.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL11.localise(Client.language))) {
                local20 = 11;
                arg0 = arg0.substring(LocalisedText.CHATCOL11.localise(Client.language).length());
            }
        }
        local18 = arg0.toLowerCase();
        @Pc(460) byte local460 = 0;
        if (local18.startsWith(LocalisedText.CHATEFFECT1.localise(0))) {
            local460 = 1;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT1.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT2.localise(0))) {
            local460 = 2;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT2.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT3.localise(0))) {
            local460 = 3;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT3.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT4.localise(0))) {
            local460 = 4;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT4.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT5.localise(0))) {
            local460 = 5;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT5.localise(0).length());
        } else if (Client.language != 0) {
            if (local18.startsWith(LocalisedText.CHATEFFECT1.localise(Client.language))) {
                local460 = 1;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT1.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT2.localise(Client.language))) {
                local460 = 2;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT2.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT3.localise(Client.language))) {
                local460 = 3;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT3.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT4.localise(Client.language))) {
                local460 = 4;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT4.localise(Client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT5.localise(Client.language))) {
                local460 = 5;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT5.localise(Client.language).length());
            }
        }
        @Pc(650) ServerConnection local650 = ConnectionManager.active();
        @Pc(656) ClientMessage local656 = ClientMessage.create(ClientProt.MESSAGE_PUBLIC, local650.cipher);
        local656.bitPacket.p1(0);
        @Pc(665) int local665 = local656.bitPacket.pos;
        local656.bitPacket.p1(local20);
        local656.bitPacket.p1(local460);
        WordPack.encode(local656.bitPacket, arg0);
        local656.bitPacket.psize1(local656.bitPacket.pos - local665);
        local650.send(local656);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void executeCutsceneSubtitleTrigger(@OriginalArg(0) int id, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
        @Pc(5) ClientScript script = ClientScriptList.trigger(Static42.CUTSCENE_SUBTITLE, id, -1);
        if (script == null) {
            return;
        }
        intVars = new int[script.intVarCount];
        stringVars = new String[script.stringVarCount];
        stringVars[0] = arg1;
        intVars[0] = arg2;
        executeScript(script, 200000);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "()V")
    public static void profileClear() {
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!mia;II)V")
    public static void executeTrigger(@OriginalArg(0) ClientTriggerType triggerType, @OriginalArg(1) int v1, @OriginalArg(2) int v2) {
        @Pc(5) ClientScript local5 = ClientScriptList.trigger(triggerType, v1, v2);
        if (local5 == null) {
            return;
        }
        intVars = new int[local5.intVarCount];
        stringVars = new String[local5.stringVarCount];
        if (local5.triggerType == Static5.A_CLIENT_TRIGGER_TYPE___1 || local5.triggerType == Static639.A_CLIENT_TRIGGER_TYPE___13 || local5.triggerType == Static280.A_CLIENT_TRIGGER_TYPE___7) {
            @Pc(35) int local35 = 0;
            @Pc(37) int local37 = 0;
            if (WorldMap.component != null) {
                local35 = WorldMap.component.x;
                local37 = WorldMap.component.y;
            }
            intVars[0] = MouseMonitor.instance.getRecordedX() - local35;
            intVars[1] = MouseMonitor.instance.getRecordedY() - local37;
        }
        executeScript(local5, 200000);
    }

    @OriginalMember(owner = "client!sda", name = "a", descriptor = "(BIII)V")
    public static void executeMapElementTrigger(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (arg2 == MiniMenuAction.OP_MAPELEMENT1) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT1, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT2) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT2, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT3) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT3, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT4) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT4, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT5) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT5, arg1, arg0);
        }
    }
}
