package com.jagex.game.runetek6.config.bastype;

import com.jagex.core.io.Packet;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pda")
public final class BASType {

    @OriginalMember(owner = "client!pda", name = "x", descriptor = "[[I")
    public int[][] graphicOffsets;

    @OriginalMember(owner = "client!pda", name = "fb", descriptor = "[I")
    public int[] maxWornRotation;

    @OriginalMember(owner = "client!pda", name = "eb", descriptor = "Lclient!qp;")
    public BASTypeList typeList;

    @OriginalMember(owner = "client!pda", name = "M", descriptor = "[[I")
    public int[][] wornTransformations;

    @OriginalMember(owner = "client!pda", name = "D", descriptor = "[I")
    public int[] invObjSlots;

    @OriginalMember(owner = "client!pda", name = "O", descriptor = "[Lclient!tt;")
    public Matrix[] transformMatrices;

    @OriginalMember(owner = "client!pda", name = "t", descriptor = "I")
    public int yawAcceleration = 0;

    @OriginalMember(owner = "client!pda", name = "g", descriptor = "I")
    public int runFollowTurn180 = -1;

    @OriginalMember(owner = "client!pda", name = "N", descriptor = "I")
    public int rollAcceleration = 0;

    @OriginalMember(owner = "client!pda", name = "q", descriptor = "I")
    public int hillWidth = 0;

    @OriginalMember(owner = "client!pda", name = "E", descriptor = "I")
    public int crawlTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "bb", descriptor = "I")
    public int runTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "C", descriptor = "I")
    public int run = -1;

    @OriginalMember(owner = "client!pda", name = "J", descriptor = "I")
    public int rollTargetAngle = 0;

    @OriginalMember(owner = "client!pda", name = "F", descriptor = "I")
    public int pitchAcceleration = 0;

    @OriginalMember(owner = "client!pda", name = "r", descriptor = "I")
    public int runTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "gb", descriptor = "I")
    public int hillMaxAngleX = 0;

    @OriginalMember(owner = "client!pda", name = "Q", descriptor = "I")
    public int walkFollowTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "m", descriptor = "I")
    public int idleAnimationTotalWeight = 0;

    @OriginalMember(owner = "client!pda", name = "H", descriptor = "I")
    public int rollMaxSpeed = 0;

    @OriginalMember(owner = "client!pda", name = "c", descriptor = "I")
    public int walk = -1;

    @OriginalMember(owner = "client!pda", name = "o", descriptor = "I")
    public int crawlTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "d", descriptor = "I")
    public int walkFollowTurn180 = -1;

    @OriginalMember(owner = "client!pda", name = "Y", descriptor = "Z")
    public boolean animateShadow = true;

    @OriginalMember(owner = "client!pda", name = "W", descriptor = "I")
    public int hitbarSprite = -1;

    @OriginalMember(owner = "client!pda", name = "f", descriptor = "I")
    public int movementAcceleration = -1;

    @OriginalMember(owner = "client!pda", name = "U", descriptor = "[I")
    public int[] readyAnimations = null;

    @OriginalMember(owner = "client!pda", name = "i", descriptor = "I")
    public final int toolkitIndex = -1;

    @OriginalMember(owner = "client!pda", name = "y", descriptor = "I")
    public int timerbarSprite = -1;

    @OriginalMember(owner = "client!pda", name = "G", descriptor = "I")
    public int crawlFollowTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "v", descriptor = "I")
    public int ready = -1;

    @OriginalMember(owner = "client!pda", name = "l", descriptor = "I")
    public int readyTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "k", descriptor = "I")
    public int pitchMaxSpeed = 0;

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "I")
    public int walkTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "I", descriptor = "I")
    public int hillMaxAngleY = 0;

    @OriginalMember(owner = "client!pda", name = "ab", descriptor = "I")
    public int hillHeight = 0;

    @OriginalMember(owner = "client!pda", name = "j", descriptor = "I")
    public int pitchTargetAngle = 0;

    @OriginalMember(owner = "client!pda", name = "K", descriptor = "I")
    public int runFollowTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "e", descriptor = "I")
    public int yawMaxSpeed = 0;

    @OriginalMember(owner = "client!pda", name = "B", descriptor = "I")
    public int readyTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "u", descriptor = "I")
    public int crawlFollowTurn180 = -1;

    @OriginalMember(owner = "client!pda", name = "cb", descriptor = "I")
    public int crawl = -1;

    @OriginalMember(owner = "client!pda", name = "db", descriptor = "I")
    public int walkFollowTurnCcw = -1;

    @OriginalMember(owner = "client!pda", name = "z", descriptor = "[I")
    public int[] readyAnimationWeights = null;

    @OriginalMember(owner = "client!pda", name = "X", descriptor = "I")
    public int runFollowTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "P", descriptor = "I")
    public int walkTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "h", descriptor = "I")
    public int characterHeight = -1;

    @OriginalMember(owner = "client!pda", name = "S", descriptor = "I")
    public int crawlFollowTurnCw = -1;

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(Z)I")
    public int ready() {
        if (this.ready != -1) {
            return this.ready;
        } else if (this.readyAnimations == null) {
            return -1;
        } else {
            @Pc(33) int weight = (int) ((double) this.idleAnimationTotalWeight * Math.random());
            @Pc(35) int i;
            for (i = 0; weight >= this.readyAnimationWeights[i]; i++) {
                weight -= this.readyAnimationWeights[i];
            }
            return this.readyAnimations[i];
        }
    }

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(IB)Z")
    public boolean isReady(@OriginalArg(0) int id) {
        if (id == -1) {
            return false;
        } else if (id == this.ready) {
            return true;
        } else {
            if (this.readyAnimations != null) {
                for (@Pc(29) int i = 0; i < this.readyAnimations.length; i++) {
                    if (this.readyAnimations[i] == id) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(ILclient!ha;)[Lclient!tt;")
    public Matrix[] transformMatrices(@OriginalArg(1) Toolkit toolkit) {
        if (this.transformMatrices != null && this.toolkitIndex == toolkit.index) {
            return this.transformMatrices;
        } else if (this.wornTransformations == null) {
            return null;
        } else {
            this.transformMatrices = new Matrix[this.wornTransformations.length];

            for (@Pc(35) int i = 0; i < this.wornTransformations.length; i++) {
                @Pc(38) int translateX = 0;
                @Pc(40) int translateY = 0;
                @Pc(42) int translateZ = 0;
                @Pc(44) int rotateX = 0;
                @Pc(46) int rotateY = 0;
                @Pc(48) int rotateZ = 0;

                if (this.wornTransformations[i] != null) {
                    translateX = this.wornTransformations[i][0];
                    translateY = this.wornTransformations[i][1];
                    translateZ = this.wornTransformations[i][2];
                    rotateX = this.wornTransformations[i][3] << 3;
                    rotateY = this.wornTransformations[i][4] << 3;
                    rotateZ = this.wornTransformations[i][5] << 3;
                }

                if (translateX != 0 || translateY != 0 || translateZ != 0 || rotateX != 0 || rotateY != 0 || rotateZ != 0) {
                    @Pc(137) Matrix matrix = this.transformMatrices[i] = toolkit.createMatrix();
                    if (rotateZ != 0) {
                        matrix.rotateAxisZ(rotateZ);
                    }
                    if (rotateX != 0) {
                        matrix.rotateAxisX(rotateX);
                    }
                    if (rotateY != 0) {
                        matrix.rotateAxisY(rotateY);
                    }
                    matrix.translate(translateX, translateY, translateZ);
                }
            }

            return this.transformMatrices;
        }
    }

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(ILclient!ge;I)V")
    public void decode(@OriginalArg(1) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.ready = packet.g2();
            this.walk = packet.g2();
            if (this.ready == 65535) {
                this.ready = -1;
            }
            if (this.walk == 65535) {
                this.walk = -1;
            }
        } else if (code == 2) {
            this.crawl = packet.g2();
        } else if (code == 3) {
            this.crawlFollowTurn180 = packet.g2();
        } else if (code == 4) {
            this.crawlFollowTurnCcw = packet.g2();
        } else if (code == 5) {
            this.crawlFollowTurnCw = packet.g2();
        } else if (code == 6) {
            this.run = packet.g2();
        } else if (code == 7) {
            this.runFollowTurn180 = packet.g2();
        } else if (code == 8) {
            this.runFollowTurnCcw = packet.g2();
        } else if (code == 9) {
            this.runFollowTurnCw = packet.g2();
        } else if (code == 26) {
            this.hillWidth = (short) (packet.g1() * 4);
            this.hillHeight = (short) (packet.g1() * 4);
        } else if (code == 27) {
            if (this.wornTransformations == null) {
                this.wornTransformations = new int[this.typeList.wearposDefaults.hidden.length][];
            }

            @Pc(128) int slot = packet.g1();
            this.wornTransformations[slot] = new int[6];
            for (@Pc(136) int i = 0; i < 6; i++) {
                this.wornTransformations[slot][i] = packet.g2s();
            }
        } else if (code == 28) {
            @Pc(128) int count = packet.g1();
            this.invObjSlots = new int[count];

            for (@Pc(136) int i = 0; i < count; i++) {
                this.invObjSlots[i] = packet.g1();

                if (this.invObjSlots[i] == 255) {
                    this.invObjSlots[i] = -1;
                }
            }
        } else if (code == 29) {
            this.yawAcceleration = packet.g1();
        } else if (code == 30) {
            this.yawMaxSpeed = packet.g2();
        } else if (code == 31) {
            this.rollAcceleration = packet.g1();
        } else if (code == 32) {
            this.rollMaxSpeed = packet.g2();
        } else if (code == 33) {
            this.rollTargetAngle = packet.g2s();
        } else if (code == 34) {
            this.pitchAcceleration = packet.g1();
        } else if (code == 35) {
            this.pitchMaxSpeed = packet.g2();
        } else if (code == 36) {
            this.pitchTargetAngle = packet.g2s();
        } else if (code == 37) {
            this.movementAcceleration = packet.g1();
        } else if (code == 38) {
            this.readyTurnCcw = packet.g2();
        } else if (code == 39) {
            this.readyTurnCw = packet.g2();
        } else if (code == 40) {
            this.walkFollowTurn180 = packet.g2();
        } else if (code == 41) {
            this.walkFollowTurnCcw = packet.g2();
        } else if (code == 42) {
            this.walkFollowTurnCw = packet.g2();
        } else if (code == 43) {
            this.hitbarSprite = packet.g2();
        } else if (code == 44) {
            this.timerbarSprite = packet.g2();
        } else if (code == 45) {
            this.characterHeight = packet.g2();
        } else if (code == 46) {
            this.crawlTurnCcw = packet.g2();
        } else if (code == 47) {
            this.crawlTurnCw = packet.g2();
        } else if (code == 48) {
            this.runTurnCcw = packet.g2();
        } else if (code == 49) {
            this.runTurnCw = packet.g2();
        } else if (code == 50) {
            this.walkTurnCcw = packet.g2();
        } else if (code == 51) {
            this.walkTurnCw = packet.g2();
        } else if (code == 52) {
            @Pc(128) int count = packet.g1();
            this.readyAnimations = new int[count];
            this.readyAnimationWeights = new int[count];
            for (@Pc(136) int i = 0; i < count; i++) {
                this.readyAnimations[i] = packet.g2();
                @Pc(395) int weight = packet.g1();
                this.readyAnimationWeights[i] = weight;
                this.idleAnimationTotalWeight += weight;
            }
        } else if (code == 53) {
            this.animateShadow = false;
        } else if (code == 54) {
            this.hillMaxAngleX = packet.g1() << 6;
            this.hillMaxAngleY = packet.g1() << 6;
        } else if (code == 55) {
            if (this.maxWornRotation == null) {
                this.maxWornRotation = new int[this.typeList.wearposDefaults.hidden.length];
            }

            @Pc(128) int slot = packet.g1();
            this.maxWornRotation[slot] = packet.g2();
        } else if (code == 56) {
            if (this.graphicOffsets == null) {
                this.graphicOffsets = new int[this.typeList.wearposDefaults.hidden.length][];
            }

            @Pc(128) int slot = packet.g1();
            this.graphicOffsets[slot] = new int[3];
            for (@Pc(136) int i = 0; i < 3; i++) {
                this.graphicOffsets[slot][i] = packet.g2s();
            }
        }
    }

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(5) int code = packet.g1();
            if (code == 0) {
                return;
            }
            this.decode(packet, code);
        }
    }
}
