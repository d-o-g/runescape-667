package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lga")
public final class ServerProt {

    @OriginalMember(owner = "client!dc", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___43 = new ServerProt(37, -2);

    @OriginalMember(owner = "client!dh", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___45 = new ServerProt(33, -2);

    @OriginalMember(owner = "client!dma", name = "k", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___47 = new ServerProt(137, 8);

    @OriginalMember(owner = "client!ah", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___147 = new ServerProt(51, 0);

    @OriginalMember(owner = "client!dp", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___49 = new ServerProt(5, 7);

    @OriginalMember(owner = "client!dt", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___52 = new ServerProt(60, 7);

    @OriginalMember(owner = "client!dt", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___53 = new ServerProt(75, 3);

    @OriginalMember(owner = "client!ec", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___54 = new ServerProt(91, -1);

    @OriginalMember(owner = "client!gg", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_LARGE = new ServerProt(84, 6);

    @OriginalMember(owner = "client!fi", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt VARBIT_SMALL = new ServerProt(14, 3);

    @OriginalMember(owner = "client!bfa", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___16 = new ServerProt(74, 11);

    @OriginalMember(owner = "client!bfa", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_LARGE = new ServerProt(39, 6);

    @OriginalMember(owner = "client!bfa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt CUTSCENE = new ServerProt(132, -2);

    @OriginalMember(owner = "client!bfa", name = "o", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___19 = new ServerProt(15, 0);

    @OriginalMember(owner = "client!bja", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt VARP_SMALL = new ServerProt(101, 3);

//  by default the client incorrectly allocates 6 bytes here, the decoder attempts to read 8
//    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
//    public static final ServerProt SOUND_AREA = new ServerProt(65,  6);

    @OriginalMember(owner = "client!iu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt SOUND_AREA = new ServerProt(65, 8);

    @OriginalMember(owner = "client!uu", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___239 = new ServerProt(117, 5);

    @OriginalMember(owner = "client!gla", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___85 = new ServerProt(144, 5);

    @OriginalMember(owner = "client!jha", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___125 = new ServerProt(66, 10);

    @OriginalMember(owner = "client!jm", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___129 = new ServerProt(134, 1);

    @OriginalMember(owner = "client!cm", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___257 = new ServerProt(76, 9);

    @OriginalMember(owner = "client!vt", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___251 = new ServerProt(139, -2);

    @OriginalMember(owner = "client!as", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___11 = new ServerProt(52, 6);

    @OriginalMember(owner = "client!ss", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___219 = new ServerProt(119, 6);

    @OriginalMember(owner = "client!op", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt MESSAGE_PRIVATE_ECHO = new ServerProt(77, -2);

    @OriginalMember(owner = "client!oia", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___175 = new ServerProt(110, -1);

    @OriginalMember(owner = "client!wc", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___252 = new ServerProt(0, 6);

    @OriginalMember(owner = "client!cn", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___37 = new ServerProt(97, -1);

    @OriginalMember(owner = "client!vda", name = "Q", descriptor = "Lclient!lga;")
    public static final ServerProt CAM_MOVETO = new ServerProt(29, 6);

    @OriginalMember(owner = "client!fca", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___63 = new ServerProt(41, 7);

    @OriginalMember(owner = "client!rq", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___76 = new ServerProt(100, 1);

    @OriginalMember(owner = "client!un", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___237 = new ServerProt(18, 4);

    @OriginalMember(owner = "client!ph", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___185 = new ServerProt(8, 6);

    @OriginalMember(owner = "client!bda", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___15 = new ServerProt(70, -2);

    @OriginalMember(owner = "client!rv", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___208 = new ServerProt(99, -1);

    @OriginalMember(owner = "client!le", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___149 = new ServerProt(2, 6);

    @OriginalMember(owner = "client!qp", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___196 = new ServerProt(114, 4);

    @OriginalMember(owner = "client!tba", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___220 = new ServerProt(108, 12);

    @OriginalMember(owner = "client!ik", name = "u", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___113 = new ServerProt(1, -1);

    @OriginalMember(owner = "client!es", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___60 = new ServerProt(3, 12);

    @OriginalMember(owner = "client!lm", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___152 = new ServerProt(4, 0);

    @OriginalMember(owner = "client!iha", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___111 = new ServerProt(6, -2);

    @OriginalMember(owner = "client!maa", name = "u", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___156 = new ServerProt(7, -2);

    @OriginalMember(owner = "client!fw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___74 = new ServerProt(10, 0);

    @OriginalMember(owner = "client!jka", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___126 = new ServerProt(9, 10);

    @OriginalMember(owner = "client!ef", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___56 = new ServerProt(11, 3);

    @OriginalMember(owner = "client!ef", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___57 = new ServerProt(24, -1);

    @OriginalMember(owner = "client!ve", name = "r", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___246 = new ServerProt(13, 1);

    @OriginalMember(owner = "client!pt", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___188 = new ServerProt(16, 3);

    @OriginalMember(owner = "client!pd", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___178 = new ServerProt(17, 0);

    @OriginalMember(owner = "client!jaa", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___119 = new ServerProt(19, 8);

    @OriginalMember(owner = "client!nu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___168 = new ServerProt(20, -1);

    @OriginalMember(owner = "client!ue", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___234 = new ServerProt(21, -1);

    @OriginalMember(owner = "client!fa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___62 = new ServerProt(22, 10);

    @OriginalMember(owner = "client!gh", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___127 = new ServerProt(23, 6);

    @OriginalMember(owner = "client!gh", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___128 = new ServerProt(35, 2);

    @OriginalMember(owner = "client!ska", name = "P", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___217 = new ServerProt(25, 0);

    @OriginalMember(owner = "client!bb", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___14 = new ServerProt(26, 3);

    @OriginalMember(owner = "client!jw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___132 = new ServerProt(27, 0);

    @OriginalMember(owner = "client!client", name = "tb", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___36 = new ServerProt(28, 4);

    @OriginalMember(owner = "client!lca", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___233 = new ServerProt(30, -2);

    @OriginalMember(owner = "client!tc", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___221 = new ServerProt(31, 4);

    @OriginalMember(owner = "client!iw", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___117 = new ServerProt(32, -1);

    @OriginalMember(owner = "client!iw", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___118 = new ServerProt(95, 6);

    @OriginalMember(owner = "client!hd", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt CAMERA_SHAKE = new ServerProt(34, 6);

    @OriginalMember(owner = "client!ki", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___138 = new ServerProt(36, 4);

    @OriginalMember(owner = "client!hda", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___103 = new ServerProt(38, 0);

    @OriginalMember(owner = "client!tia", name = "L", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___223 = new ServerProt(40, -1);

    @OriginalMember(owner = "client!o", name = "O", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___169 = new ServerProt(42, -1);

    @OriginalMember(owner = "client!uja", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___235 = new ServerProt(43, -2);

    @OriginalMember(owner = "client!oea", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___173 = new ServerProt(44, 10);

    @OriginalMember(owner = "client!ol", name = "J", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___176 = new ServerProt(45, 2);

    @OriginalMember(owner = "client!eu", name = "bb", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___61 = new ServerProt(46, 3);

    @OriginalMember(owner = "client!ku", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___146 = new ServerProt(47, 4);

    @OriginalMember(owner = "client!aka", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___7 = new ServerProt(48, 5);

    @OriginalMember(owner = "client!pc", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___177 = new ServerProt(49, 1);

    @OriginalMember(owner = "client!ma", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___155 = new ServerProt(50, -2);

    @OriginalMember(owner = "client!mda", name = "z", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___158 = new ServerProt(53, -1);

    @OriginalMember(owner = "client!bma", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___30 = new ServerProt(54, -1);

    @OriginalMember(owner = "client!gm", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___86 = new ServerProt(55, 2);

    @OriginalMember(owner = "client!jq", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___130 = new ServerProt(56, 28);

    @OriginalMember(owner = "client!gw", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___90 = new ServerProt(57, -2);

    @OriginalMember(owner = "client!nca", name = "s", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___165 = new ServerProt(58, 6);

    @OriginalMember(owner = "client!nka", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___10 = new ServerProt(59, 0);

    @OriginalMember(owner = "client!rja", name = "G", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___205 = new ServerProt(61, 20);

    @OriginalMember(owner = "client!wt", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___260 = new ServerProt(62, 16);

    @OriginalMember(owner = "client!vj", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___247 = new ServerProt(63, 5);

    @OriginalMember(owner = "client!ai", name = "K", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___5 = new ServerProt(64, 3);

    @OriginalMember(owner = "client!td", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___222 = new ServerProt(67, 3);

    @OriginalMember(owner = "client!tk", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___34 = new ServerProt(68, 1);

    @OriginalMember(owner = "client!cr", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___236 = new ServerProt(69, -2);

    @OriginalMember(owner = "client!kja", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___140 = new ServerProt(71, 2);

    @OriginalMember(owner = "client!hn", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___105 = new ServerProt(72, 2);

    @OriginalMember(owner = "client!sha", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___215 = new ServerProt(73, 4);

    @OriginalMember(owner = "client!qk", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___194 = new ServerProt(78, 8);

    @OriginalMember(owner = "client!qk", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___195 = new ServerProt(80, -2);

    @OriginalMember(owner = "client!hc", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___101 = new ServerProt(79, -2);

    @OriginalMember(owner = "client!tja", name = "z", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___227 = new ServerProt(81, 12);

    @OriginalMember(owner = "client!tja", name = "I", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___226 = new ServerProt(141, 2);

    @OriginalMember(owner = "client!sia", name = "w", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___216 = new ServerProt(82, 6);

    @OriginalMember(owner = "client!gj", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___143 = new ServerProt(83, 7);

    @OriginalMember(owner = "client!kc", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___135 = new ServerProt(85, -2);

    @OriginalMember(owner = "client!it", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___115 = new ServerProt(86, 0);

    @OriginalMember(owner = "client!oaa", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___170 = new ServerProt(87, -2);

    @OriginalMember(owner = "client!vp", name = "B", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___250 = new ServerProt(88, -2);

    @OriginalMember(owner = "client!u", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___229 = new ServerProt(89, -1);

    @OriginalMember(owner = "client!ed", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___55 = new ServerProt(90, 17);

    @OriginalMember(owner = "client!kr", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___144 = new ServerProt(92, 4);

    @OriginalMember(owner = "client!uba", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___230 = new ServerProt(93, 6);

    @OriginalMember(owner = "client!tu", name = "j", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___228 = new ServerProt(94, -1);

    @OriginalMember(owner = "client!bg", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___20 = new ServerProt(96, 7);

    @OriginalMember(owner = "client!af", name = "n", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___3 = new ServerProt(98, 6);

    @OriginalMember(owner = "client!ms", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___162 = new ServerProt(102, -1);

    @OriginalMember(owner = "client!pi", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___254 = new ServerProt(103, 2);

    @OriginalMember(owner = "client!pi", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___253 = new ServerProt(142, 0);

    @OriginalMember(owner = "client!rb", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___199 = new ServerProt(104, 8);

    @OriginalMember(owner = "client!wfa", name = "Q", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___255 = new ServerProt(105, -1);

    @OriginalMember(owner = "client!al", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___8 = new ServerProt(106, 8);

    @OriginalMember(owner = "client!wg", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___256 = new ServerProt(107, 4);

    @OriginalMember(owner = "client!ifa", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___192 = new ServerProt(109, 10);

    @OriginalMember(owner = "client!ifa", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___191 = new ServerProt(138, -1);

    @OriginalMember(owner = "client!tj", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___224 = new ServerProt(111, 3);

    @OriginalMember(owner = "client!jt", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___131 = new ServerProt(112, 6);

    @OriginalMember(owner = "client!gha", name = "w", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___83 = new ServerProt(113, 3);

    @OriginalMember(owner = "client!he", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___104 = new ServerProt(115, 8);

    @OriginalMember(owner = "client!rf", name = "t", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___200 = new ServerProt(116, -1);

    @OriginalMember(owner = "client!ki", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___139 = new ServerProt(118, -2);

    @OriginalMember(owner = "client!va", name = "A", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___241 = new ServerProt(120, -2);

    @OriginalMember(owner = "client!va", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___240 = new ServerProt(129, 4);

    @OriginalMember(owner = "client!ws", name = "J", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___259 = new ServerProt(122, 10);

    @OriginalMember(owner = "client!nia", name = "o", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___167 = new ServerProt(123, 1);

    @OriginalMember(owner = "client!kt", name = "S", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___145 = new ServerProt(124, 1);

    @OriginalMember(owner = "client!cf", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___35 = new ServerProt(125, 2);

    @OriginalMember(owner = "client!mm", name = "a", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___161 = new ServerProt(126, 4);

    @OriginalMember(owner = "client!ro", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___207 = new ServerProt(127, 6);

    @OriginalMember(owner = "client!je", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___123 = new ServerProt(128, -2);

    @OriginalMember(owner = "client!mu", name = "b", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___163 = new ServerProt(130, 9);

    @OriginalMember(owner = "client!gv", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___89 = new ServerProt(131, -1);

    @OriginalMember(owner = "client!wo", name = "E", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___258 = new ServerProt(133, -1);

    @OriginalMember(owner = "client!mv", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___164 = new ServerProt(135, 0);

    @OriginalMember(owner = "client!ge", name = "Ab", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___206 = new ServerProt(136, 6);

    @OriginalMember(owner = "client!ofa", name = "s", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___174 = new ServerProt(140, -2);

    @OriginalMember(owner = "client!ija", name = "i", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___112 = new ServerProt(143, -2);

    @OriginalMember(owner = "client!oe", name = "ib", descriptor = "Lclient!lga;")
    public static ServerProt aServerProt_171 = new ServerProt(12, -2);

    @OriginalMember(owner = "client!md", name = "F", descriptor = "Lclient!lga;")
    public static ServerProt aServerProt_157 = new ServerProt(121, 6);

    @OriginalMember(owner = "client!sh", name = "b", descriptor = "(B)[Lclient!lga;")
    public static ServerProt[] values() {
        return new ServerProt[]{
            A_SERVER_PROT___252,
            A_SERVER_PROT___113,
            A_SERVER_PROT___149,
            A_SERVER_PROT___60,
            A_SERVER_PROT___152,
            A_SERVER_PROT___49,
            A_SERVER_PROT___111,
            A_SERVER_PROT___156,
            A_SERVER_PROT___185,
            A_SERVER_PROT___126,
            A_SERVER_PROT___74,
            A_SERVER_PROT___56,
            aServerProt_171,
            A_SERVER_PROT___246,
            VARBIT_SMALL,
            A_SERVER_PROT___19,
            A_SERVER_PROT___188,
            A_SERVER_PROT___178,
            A_SERVER_PROT___237,
            A_SERVER_PROT___119,
            A_SERVER_PROT___168,
            A_SERVER_PROT___234,
            A_SERVER_PROT___62,
            A_SERVER_PROT___127,
            A_SERVER_PROT___57,
            A_SERVER_PROT___217,
            A_SERVER_PROT___14,
            A_SERVER_PROT___132,
            A_SERVER_PROT___36,
            CAM_MOVETO,
            A_SERVER_PROT___233,
            A_SERVER_PROT___221,
            A_SERVER_PROT___117,
            A_SERVER_PROT___45,
            CAMERA_SHAKE,
            A_SERVER_PROT___128,
            A_SERVER_PROT___138,
            A_SERVER_PROT___43,
            A_SERVER_PROT___103,
            VARP_LARGE,
            A_SERVER_PROT___223,
            A_SERVER_PROT___63,
            A_SERVER_PROT___169,
            A_SERVER_PROT___235,
            A_SERVER_PROT___173,
            A_SERVER_PROT___176,
            A_SERVER_PROT___61,
            A_SERVER_PROT___146,
            A_SERVER_PROT___7,
            A_SERVER_PROT___177,
            A_SERVER_PROT___155,
            A_SERVER_PROT___147,
            A_SERVER_PROT___11,
            A_SERVER_PROT___158,
            A_SERVER_PROT___30,
            A_SERVER_PROT___86,
            A_SERVER_PROT___130,
            A_SERVER_PROT___90,
            A_SERVER_PROT___165,
            A_SERVER_PROT___10,
            A_SERVER_PROT___52,
            A_SERVER_PROT___205,
            A_SERVER_PROT___260,
            A_SERVER_PROT___247,
            A_SERVER_PROT___5,
            SOUND_AREA,
            A_SERVER_PROT___125,
            A_SERVER_PROT___222,
            A_SERVER_PROT___34,
            A_SERVER_PROT___236,
            A_SERVER_PROT___15,
            A_SERVER_PROT___140,
            A_SERVER_PROT___105,
            A_SERVER_PROT___215,
            A_SERVER_PROT___16,
            A_SERVER_PROT___53,
            A_SERVER_PROT___257,
            MESSAGE_PRIVATE_ECHO,
            A_SERVER_PROT___194,
            A_SERVER_PROT___101,
            A_SERVER_PROT___195,
            A_SERVER_PROT___227,
            A_SERVER_PROT___216,
            A_SERVER_PROT___143,
            VARBIT_LARGE,
            A_SERVER_PROT___135,
            A_SERVER_PROT___115,
            A_SERVER_PROT___170,
            A_SERVER_PROT___250,
            A_SERVER_PROT___229,
            A_SERVER_PROT___55,
            A_SERVER_PROT___54,
            A_SERVER_PROT___144,
            A_SERVER_PROT___230,
            A_SERVER_PROT___228,
            A_SERVER_PROT___118,
            A_SERVER_PROT___20,
            A_SERVER_PROT___37,
            A_SERVER_PROT___3,
            A_SERVER_PROT___208,
            A_SERVER_PROT___76,
            VARP_SMALL,
            A_SERVER_PROT___162,
            A_SERVER_PROT___254,
            A_SERVER_PROT___199,
            A_SERVER_PROT___255,
            A_SERVER_PROT___8,
            A_SERVER_PROT___256,
            A_SERVER_PROT___220,
            A_SERVER_PROT___192,
            A_SERVER_PROT___175,
            A_SERVER_PROT___224,
            A_SERVER_PROT___131,
            A_SERVER_PROT___83,
            A_SERVER_PROT___196,
            A_SERVER_PROT___104,
            A_SERVER_PROT___200,
            A_SERVER_PROT___239,
            A_SERVER_PROT___139,
            A_SERVER_PROT___219,
            A_SERVER_PROT___241,
            aServerProt_157,
            A_SERVER_PROT___259,
            A_SERVER_PROT___167,
            A_SERVER_PROT___145,
            A_SERVER_PROT___35,
            A_SERVER_PROT___161,
            A_SERVER_PROT___207,
            A_SERVER_PROT___123,
            A_SERVER_PROT___240,
            A_SERVER_PROT___163,
            A_SERVER_PROT___89,
            CUTSCENE,
            A_SERVER_PROT___258,
            A_SERVER_PROT___129,
            A_SERVER_PROT___164,
            A_SERVER_PROT___206,
            A_SERVER_PROT___47,
            A_SERVER_PROT___191,
            A_SERVER_PROT___251,
            A_SERVER_PROT___174,
            A_SERVER_PROT___226,
            A_SERVER_PROT___253,
            A_SERVER_PROT___112,
            A_SERVER_PROT___85
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
