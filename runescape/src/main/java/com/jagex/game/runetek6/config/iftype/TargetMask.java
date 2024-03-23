package com.jagex.game.runetek6.config.iftype;

public final class TargetMask {
     public static final int TGT_OBJ = 0x01;
     public static final int TGT_NPC = 0x02;
     public static final int TGT_LOC = 0x04;
     public static final int TGT_PLAYER = 0x08;
     public static final int TGT_SELF = 0x10;
     public static final int TGT_BUTTON = 0x20;
     public static final int TGT_GROUND = 0x40;

     private TargetMask() {
         /* empty */
     }
}
