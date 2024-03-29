package com.jagex.game;

import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.defaults.WearposDefaults;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.graphics.Matrix;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ju")
public final class PlayerModel {

    @OriginalMember(owner = "client!wba", name = "f", descriptor = "[I")
    public static final int[] PRIMARY_BODY_PARTS = {0, 1, 2, 3, 4, 5, 6, 14};

    @OriginalMember(owner = "client!r", name = "t", descriptor = "[I")
    public static final int[] SECONDARY_BODY_PARTS = {7, 8, 9, 10, 11, 12, 13, 15};

    @OriginalMember(owner = "client!ie", name = "g", descriptor = "[I")
    private static final int[] BASE_PART_MAP = {8, 11, 4, 6, 9, 7, 10, 0};

    @OriginalMember(owner = "client!bq", name = "t", descriptor = "Lclient!dla;")
    private static final ReferenceCache modelCache = new ReferenceCache(5);

    @OriginalMember(owner = "client!sea", name = "y", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(260);

    @OriginalMember(owner = "client!kma", name = "n", descriptor = "[[[S")
    public static short[][][] recol_d;

    @OriginalMember(owner = "client!cha", name = "e", descriptor = "[[S")
    public static short[][] recol_s;

    @OriginalMember(owner = "client!jg", name = "k", descriptor = "I")
    public static int featureMask;

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "(II)V")
    public static void setFeatureMask(@OriginalArg(1) int featureMask) {
        PlayerModel.featureMask = featureMask;
        @Pc(7) ReferenceCache local7 = modelCache;
        synchronized (modelCache) {
            modelCache.reset();
        }
        local7 = recentUse;
        synchronized (recentUse) {
            recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!rka", name = "b", descriptor = "(ZI)V")
    public static void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(5) ReferenceCache local5 = recentUse;
        synchronized (recentUse) {
            recentUse.clean(maxAge);
        }
        local5 = modelCache;
        synchronized (modelCache) {
            modelCache.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!nga", name = "a", descriptor = "(I)V")
    public static void cacheRemoveSoftReferences() {
        @Pc(1) ReferenceCache local1 = recentUse;
        synchronized (recentUse) {
            recentUse.removeSoftReferences();
        }
        local1 = modelCache;
        synchronized (modelCache) {
            modelCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!jw", name = "c", descriptor = "(B)V")
    public static void cacheReset() {
        @Pc(5) ReferenceCache local5 = recentUse;
        synchronized (recentUse) {
            recentUse.reset();
        }
        local5 = modelCache;
        synchronized (modelCache) {
            modelCache.reset();
        }
    }

    @OriginalMember(owner = "client!jka", name = "g", descriptor = "(I)I")
    public static int cacheHardReferenceCount() {
        @Pc(13) ReferenceCache local13 = recentUse;
        synchronized (recentUse) {
            return recentUse.hardCount();
        }
    }

    @OriginalMember(owner = "client!ju", name = "h", descriptor = "I")
    public int basId;

    @OriginalMember(owner = "client!ju", name = "e", descriptor = "[I")
    public int[] clientpalette;

    @OriginalMember(owner = "client!ju", name = "c", descriptor = "[Lclient!bs;")
    public ObjTypeCustomisation[] customisations;

    @OriginalMember(owner = "client!ju", name = "m", descriptor = "Z")
    public boolean female;

    @OriginalMember(owner = "client!ju", name = "o", descriptor = "[I")
    public int[] identikit;

    @OriginalMember(owner = "client!ju", name = "q", descriptor = "J")
    public long aLong159;

    @OriginalMember(owner = "client!ju", name = "r", descriptor = "J")
    public long hash;

    @OriginalMember(owner = "client!ju", name = "n", descriptor = "I")
    public int npcId = -1;

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(I)V")
    public void computeHash() {
        @Pc(5) long[] crc = Packet.crc64table;

        this.hash = -1L;
        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.basId >> 8)) & 0xFFL)];
        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.basId)) & 0xFFL)];

        for (@Pc(56) int part = 0; part < this.identikit.length; part++) {
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 24)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 16)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part] >> 8)) & 0xFFL)];
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.identikit[part])) & 0xFFL)];
        }

        @Pc(156) int i;
        if (this.customisations != null) {
            for (i = 0; i < this.customisations.length; i++) {
                if (this.customisations[i] != null) {
                    @Pc(179) int[] wearModels;
                    @Pc(173) int[] headModels;
                    if (this.female) {
                        headModels = this.customisations[i].womanhead;
                        wearModels = this.customisations[i].womanwear;
                    } else {
                        headModels = this.customisations[i].manhead;
                        wearModels = this.customisations[i].manwear;
                    }

                    @Pc(196) int j;
                    if (wearModels != null) {
                        for (j = 0; j < wearModels.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) (((long) (wearModels[j] >> 8) ^ this.hash) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) (((long) wearModels[j] ^ this.hash) & 0xFFL)];
                        }
                    }

                    if (headModels != null) {
                        for (j = 0; j < headModels.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (headModels[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (headModels[j])) & 0xFFL)];
                        }
                    }

                    if (this.customisations[i].recol_d != null) {
                        for (j = 0; j < this.customisations[i].recol_d.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].recol_d[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].recol_d[j])) & 0xFFL)];
                        }
                    }

                    if (this.customisations[i].retex_d != null) {
                        for (j = 0; j < this.customisations[i].retex_d.length; j++) {
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].retex_d[j] >> 8)) & 0xFFL)];
                            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.customisations[i].retex_d[j])) & 0xFFL)];
                        }
                    }
                }
            }
        }

        for (i = 0; i < 10; i++) {
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) this.clientpalette[i]) & 0xFFL)];
        }

        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.female ? 1 : 0)) & 0xFFL)];
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "([I[I[Lclient!bs;IIZB)V")
    public void update(@OriginalArg(0) int[] clientpalette, @OriginalArg(1) int[] identikit, @OriginalArg(2) ObjTypeCustomisation[] customisations, @OriginalArg(3) int npcId, @OriginalArg(4) int basId, @OriginalArg(5) boolean female) {
        this.customisations = customisations;
        this.clientpalette = clientpalette;
        this.female = female;
        if (this.basId != basId) {
            this.basId = basId;
        }
        this.identikit = identikit;
        this.npcId = npcId;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!es;Lclient!gu;IZLclient!qp;Lclient!bp;I[ILclient!vl;Lclient!kr;Lclient!ha;Lclient!ql;[Lclient!gu;ILclient!gu;Lclient!uk;)Lclient!ka;")
    public Model bodyModel(@OriginalArg(0) ObjTypeList objTypeList, @OriginalArg(1) Animator actionAnimator, @OriginalArg(4) BASTypeList basTypeList, @OriginalArg(5) SeqTypeList seqTypeList, @OriginalArg(6) int functionMask, @OriginalArg(7) int[] wornRotation, @OriginalArg(8) WearposDefaults wearposDefaults, @OriginalArg(9) IDKTypeList idkTypeList, @OriginalArg(10) Toolkit toolkit, @OriginalArg(11) NPCTypeList npcTypeList, @OriginalArg(12) Animator[] animators, @OriginalArg(13) int yaw, @OriginalArg(14) Animator animator, @OriginalArg(15) VarDomain varDomain) {
        if (this.npcId != -1) {
            return npcTypeList.list(this.npcId).getModel(varDomain, toolkit, basTypeList, actionAnimator, yaw, wornRotation, null, animator, functionMask, animators);
        }

        @Pc(28) int newFunctionMask = functionMask;
        @Pc(31) long hash = this.hash;
        @Pc(34) int[] identikit = this.identikit;
        @Pc(36) boolean leftHand = false;
        @Pc(44) boolean rightHand = false;

        if (actionAnimator != null) {
            @Pc(50) SeqType animation = actionAnimator.getAnimation();

            if (animation != null && (animation.playerLeftHand >= 0 || animation.playerRightHand >= 0)) {
                identikit = new int[this.identikit.length];

                for (@Pc(72) int i = 0; i < identikit.length; i++) {
                    identikit[i] = this.identikit[i];
                }

                if (animation.playerLeftHand >= 0 && wearposDefaults.leftHandSlot != -1) {
                    if (animation.playerLeftHand == 0xffff) {
                        identikit[wearposDefaults.leftHandSlot] = 0;

                        for (@Pc(116) int i = 0; i < wearposDefaults.animationHiddenLeftHandSlots.length; i++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[i]] = 0;
                        }

                        hash ^= 0xFFFFFFFF00000000L;
                    } else {
                        identikit[wearposDefaults.leftHandSlot] = animation.playerLeftHand | 0x40000000;

                        for (@Pc(116) int i = 0; i < wearposDefaults.animationHiddenLeftHandSlots.length; i++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[i]] = 0;
                        }

                        hash ^= (long) identikit[wearposDefaults.leftHandSlot] << 32;
                    }

                    leftHand = true;
                }

                if (animation.playerRightHand >= 0 && wearposDefaults.rightHandSlot != -1) {
                    rightHand = true;

                    if (animation.playerRightHand == 65535) {
                        identikit[wearposDefaults.rightHandSlot] = 0;

                        for (@Pc(116) int i = 0; i < wearposDefaults.animationHiddenRightHandSlots.length; i++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[i]] = 0;
                        }

                        hash ^= 0xFFFFFFFFL;
                    } else {
                        identikit[wearposDefaults.rightHandSlot] = animation.playerRightHand | 0x40000000;

                        for (@Pc(116) int i = 0; i < wearposDefaults.animationHiddenRightHandSlots.length; i++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[i]] = 0;
                        }

                        hash ^= identikit[wearposDefaults.rightHandSlot];
                    }
                }
            }
        }

        @Pc(257) boolean animated = false;
        @Pc(72) int animatorCount = animators == null ? 0 : animators.length;
        for (@Pc(116) int i = 0; i < animatorCount; i++) {
            if (animators[i] != null) {
                newFunctionMask |= animators[i].functionMask();
                animated = true;
            }
        }

        if (actionAnimator != null) {
            newFunctionMask |= actionAnimator.functionMask();
            animated = true;
        }

        if (animator != null) {
            animated = true;
            newFunctionMask |= animator.functionMask();
        }

        @Pc(310) boolean rotated = false;
        if (wornRotation != null) {
            for (@Pc(314) int i = 0; i < wornRotation.length; i++) {
                if (wornRotation[i] != -1) {
                    rotated = true;
                    newFunctionMask |= 0x20;
                }
            }
        }

        @Pc(334) ReferenceCache local334 = recentUse;
        @Pc(342) Model model;
        synchronized (recentUse) {
            model = (Model) recentUse.get(hash);
        }

        @Pc(350) BASType basType = null;
        if (this.basId != -1) {
            basType = basTypeList.list(this.basId);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
            if (model != null) {
                newFunctionMask = toolkit.combineFunctionMasks(newFunctionMask, model.ua());
            }

            @Pc(388) boolean loadModels = false;

            for (@Pc(390) int identikitIndex = 0; identikitIndex < identikit.length; identikitIndex++) {
                @Pc(395) int kit = identikit[identikitIndex];
                @Pc(397) ObjTypeCustomisation customisation = null;
                @Pc(399) boolean found = false;

                if (leftHand) {
                    if (wearposDefaults.leftHandSlot == identikitIndex) {
                        found = true;
                    } else {
                        for (@Pc(409) int i = 0; i < wearposDefaults.animationHiddenLeftHandSlots.length; i++) {
                            if (identikitIndex == wearposDefaults.animationHiddenLeftHandSlots[i]) {
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if (rightHand) {
                    if (wearposDefaults.rightHandSlot == identikitIndex) {
                        found = true;
                    } else {
                        for (@Pc(409) int i = 0; i < wearposDefaults.animationHiddenRightHandSlots.length; i++) {
                            if (wearposDefaults.animationHiddenRightHandSlots[i] == identikitIndex) {
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if ((kit & 0x40000000) != 0) {
                    if (!found && this.customisations != null && this.customisations[identikitIndex] != null) {
                        customisation = this.customisations[identikitIndex];
                    }

                    if (!objTypeList.list(kit & 0x3FFFFFFF).loadedModels(this.female, customisation)) {
                        loadModels = true;
                    }
                } else if ((Integer.MIN_VALUE & kit) != 0 && !idkTypeList.list(kit & 0x3FFFFFFF).isModelLoaded()) {
                    loadModels = true;
                }
            }

            if (loadModels) {
                if (this.aLong159 != -1L) {
                    @Pc(552) ReferenceCache local552 = recentUse;
                    synchronized (recentUse) {
                        model = (Model) recentUse.get(this.aLong159);
                    }
                }

                if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
                    return null;
                }
            } else {
                @Pc(584) Mesh[] meshes = new Mesh[identikit.length];

                for (@Pc(586) int i = 0; i < identikit.length; i++) {
                    @Pc(591) int kit = identikit[i];
                    @Pc(593) ObjTypeCustomisation customisation = null;
                    @Pc(614) boolean inHand = i == 5 && leftHand || i == 3 && rightHand;

                    @Pc(633) Mesh mesh;
                    if ((kit & 0x40000000) != 0) {
                        if (!inHand && this.customisations != null && this.customisations[i] != null) {
                            customisation = this.customisations[i];
                        }

                        mesh = objTypeList.list(kit & 0x3FFFFFFF).playerModel(customisation, this.female);

                        if (mesh != null) {
                            meshes[i] = mesh;
                        }
                    } else if ((Integer.MIN_VALUE & kit) != 0) {
                        mesh = idkTypeList.list(kit & 0x3FFFFFFF).model();

                        if (mesh != null) {
                            meshes[i] = mesh;
                        }
                    }
                }

                if (basType != null && basType.wornTransformations != null) {
                    for (@Pc(591) int i = 0; i < basType.wornTransformations.length; i++) {
                        if (meshes[i] != null) {
                            @Pc(409) int translateX = 0;
                            @Pc(709) int translateY = 0;
                            @Pc(711) int translateZ = 0;
                            @Pc(713) int rotateX = 0;
                            @Pc(715) int rotateY = 0;
                            @Pc(717) int rotateZ = 0;

                            if (basType.wornTransformations[i] != null) {
                                translateX = basType.wornTransformations[i][0];
                                translateY = basType.wornTransformations[i][1];
                                translateZ = basType.wornTransformations[i][2];
                                rotateX = basType.wornTransformations[i][3] << 3;
                                rotateY = basType.wornTransformations[i][4] << 3;
                                rotateZ = basType.wornTransformations[i][5] << 3;
                            }

                            if (rotateX != 0 || rotateY != 0 || rotateZ != 0) {
                                meshes[i].rotate(rotateZ, rotateX, rotateY);
                            }

                            if (translateX != 0 || translateY != 0 || translateZ != 0) {
                                meshes[i].translate(translateX, translateY, translateZ);
                            }
                        }
                    }
                }

                @Pc(826) int recolFunctionMask = newFunctionMask | 0x4000;
                @Pc(833) Mesh mesh = new Mesh(meshes, meshes.length);
                model = toolkit.createModel(mesh, recolFunctionMask, featureMask, 64, 850);

                for (@Pc(409) int i = 0; i < 10; i++) {
                    for (@Pc(709) int j = 0; j < recol_s[i].length; j++) {
                        if (recol_d[i][j].length > this.clientpalette[i]) {
                            model.ia(recol_s[i][j], recol_d[i][j][this.clientpalette[i]]);
                        }
                    }
                }

                model.s(newFunctionMask);

                @Pc(903) ReferenceCache local903 = recentUse;
                synchronized (recentUse) {
                    recentUse.put(model, hash);
                }

                this.aLong159 = hash;
            }
        }

        @Pc(925) Model bodyModel = model.copy((byte) 4, newFunctionMask, true);
        if (!animated && !rotated) {
            return bodyModel;
        }

        @Pc(936) Matrix[] matrices = null;
        if (basType != null) {
            matrices = basType.transformMatrices(toolkit);
        }

        if (rotated && matrices != null) {
            for (@Pc(390) int i = 0; i < wornRotation.length; i++) {
                if (matrices[i] != null) {
                    bodyModel.transform(matrices[i], 0x1 << i, true);
                }
            }
        }

        @Pc(390) int local390 = 0;
        @Pc(395) int local395 = 1;
        while (local390 < animatorCount) {
            if (animators[local390] != null) {
                animators[local390].animatePartial(local395, bodyModel);
            }
            local390++;
            local395 <<= 0x1;
        }

        if (rotated) {
            for (@Pc(586) int local586 = 0; local586 < wornRotation.length; local586++) {
                if (wornRotation[local586] != -1) {
                    @Pc(591) int local591 = wornRotation[local586] - yaw;
                    local591 &= 0x3FFF;
                    @Pc(1034) Matrix matrix = toolkit.createMatrix();
                    matrix.rotate(local591);
                    bodyModel.transform(matrix, 0x1 << local586, false);
                }
            }
        }

        if (rotated && matrices != null) {
            for (@Pc(586) int local586 = 0; local586 < wornRotation.length; local586++) {
                if (matrices[local586] != null) {
                    bodyModel.transform(matrices[local586], 0x1 << local586, false);
                }
            }
        }

        if (actionAnimator != null && animator != null) {
            Animator.blend(actionAnimator, bodyModel, animator);
        } else if (actionAnimator != null) {
            actionAnimator.animate(bodyModel, 0);
        } else if (animator != null) {
            animator.animate(bodyModel, 0);
        }

        return bodyModel;
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IZ)V")
    public void setFemale(@OriginalArg(1) boolean female) {
        this.female = female;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IBLclient!kr;I)V")
    public void setIDKPart(@OriginalArg(0) int idkType, @OriginalArg(2) IDKTypeList idkTypeList, @OriginalArg(3) int part) {
        @Pc(7) int basePart = BASE_PART_MAP[part];
        if (idkTypeList.list(idkType) != null) {
            this.identikit[basePart] = Integer.MIN_VALUE | idkType;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IIB)V")
    public void setBaseColour(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.clientpalette[arg0] = arg1;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!gu;IILclient!bp;Lclient!ha;BLclient!kr;II)Lclient!ka;")
    public Model headModel(@OriginalArg(0) Animator animator, @OriginalArg(1) int kit1, @OriginalArg(2) int kit3, @OriginalArg(3) SeqTypeList seqTypeList, @OriginalArg(4) Toolkit toolkit, @OriginalArg(6) IDKTypeList idkTypeList, @OriginalArg(7) int kit2) {
        @Pc(16) int functionMask = animator == null ? 2048 : animator.functionMask() | 0x800;
        @Pc(29) long key = (long) kit3 << 32 | (long) (kit2 << 16) | (long) kit1;

        @Pc(31) ReferenceCache local31 = modelCache;
        @Pc(39) Model model;
        synchronized (modelCache) {
            model = (Model) modelCache.get(key);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
            if (model != null) {
                functionMask = toolkit.combineFunctionMasks(functionMask, model.ua());
            }

            @Pc(70) Mesh[] meshes = new Mesh[3];
            @Pc(72) int local72 = 0;
            if (!idkTypeList.list(kit1).isHeadLoaded() || !idkTypeList.list(kit2).isHeadLoaded() || !idkTypeList.list(kit3).isHeadLoaded()) {
                return null;
            }

            @Pc(107) Mesh mesh = idkTypeList.list(kit1).headModel();
            if (mesh != null) {
                local72++;
                meshes[0] = mesh;
            }

            mesh = idkTypeList.list(kit2).headModel();
            if (mesh != null) {
                meshes[local72++] = mesh;
            }

            mesh = idkTypeList.list(kit3).headModel();
            if (mesh != null) {
                meshes[local72++] = mesh;
            }

            @Pc(152) int local152 = functionMask | 0x4000;
            mesh = new Mesh(meshes, local72);
            model = toolkit.createModel(mesh, local152, featureMask, 64, 768);
            for (@Pc(168) int i = 0; i < 10; i++) {
                for (@Pc(172) int j = 0; j < recol_s[i].length; j++) {
                    if (this.clientpalette[i] < recol_d[i][j].length) {
                        model.ia(recol_s[i][j], recol_d[i][j][this.clientpalette[i]]);
                    }
                }
            }

            model.s(functionMask);
            @Pc(228) ReferenceCache local228 = modelCache;
            synchronized (modelCache) {
                modelCache.put(model, key);
            }
        }

        if (animator != null) {
            model = model.copy((byte) 4, functionMask, true);
            animator.animate(model, 0);
        }

        return model;
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(BIILclient!es;)V")
    public void setObj(@OriginalArg(3) ObjTypeList objTypeList, @OriginalArg(2) int part, @OriginalArg(1) int objId) {
        if (objId == -1) {
            this.identikit[part] = 0;
        } else if (objTypeList.list(objId) != null) {
            this.identikit[part] = objId | 0x40000000;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!kr;BLclient!bp;Lclient!uk;Lclient!gu;Lclient!es;Lclient!ql;Lclient!ha;I)Lclient!ka;")
    public Model wornHeadModel(@OriginalArg(0) IDKTypeList idkTypeList, @OriginalArg(2) SeqTypeList seqTypeList, @OriginalArg(3) VarDomain varDomain, @OriginalArg(4) Animator animator, @OriginalArg(5) ObjTypeList objTypeList, @OriginalArg(6) NPCTypeList npcTypeList, @OriginalArg(7) Toolkit toolkit, @OriginalArg(8) int functionMask) {
        if (this.npcId != -1) {
            return npcTypeList.list(this.npcId).headModel(functionMask, animator, null, toolkit, varDomain);
        }

        @Pc(35) int newFunctionMask = animator == null ? functionMask : animator.functionMask() | 0x800;
        @Pc(37) ReferenceCache local37 = modelCache;

        @Pc(48) Model model;
        synchronized (modelCache) {
            model = (Model) modelCache.get(this.hash);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), newFunctionMask) != 0) {
            if (model != null) {
                newFunctionMask = toolkit.combineFunctionMasks(newFunctionMask, model.ua());
            }

            @Pc(81) boolean loading = false;
            for (@Pc(83) int part = 0; part < this.identikit.length; part++) {
                @Pc(92) int kit = this.identikit[part];
                @Pc(94) ObjTypeCustomisation customisation = null;

                if ((kit & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[part] != null) {
                        customisation = this.customisations[part];
                    }

                    if (!objTypeList.list(kit & 0x3FFFFFFF).loadedHeadModels(customisation, this.female)) {
                        loading = true;
                    }
                } else if ((kit & Integer.MIN_VALUE) != 0 && !idkTypeList.list(kit & 0x3FFFFFFF).isHeadLoaded()) {
                    loading = true;
                }
            }

            if (loading) {
                return null;
            }

            @Pc(172) Mesh[] meshes = new Mesh[this.identikit.length];
            @Pc(174) int local174 = 0;
            for (@Pc(176) int part = 0; part < this.identikit.length; part++) {
                @Pc(185) int kit = this.identikit[part];
                @Pc(187) ObjTypeCustomisation customisation = null;
                @Pc(220) Mesh mesh;

                if ((kit & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[part] != null) {
                        customisation = this.customisations[part];
                    }
                    mesh = objTypeList.list(kit & 0x3FFFFFFF).headModel(this.female, customisation);
                    if (mesh != null) {
                        meshes[local174++] = mesh;
                    }
                } else if ((kit & Integer.MIN_VALUE) != 0) {
                    mesh = idkTypeList.list(kit & 0x3FFFFFFF).headModel();
                    if (mesh != null) {
                        meshes[local174++] = mesh;
                    }
                }
            }

            @Pc(266) Mesh mesh = new Mesh(meshes, local174);
            @Pc(270) int local270 = newFunctionMask | 0x4000;
            model = toolkit.createModel(mesh, local270, featureMask, 64, 768);
            for (@Pc(282) int local282 = 0; local282 < 10; local282++) {
                for (@Pc(286) int local286 = 0; local286 < recol_s[local282].length; local286++) {
                    if (this.clientpalette[local282] < recol_d[local282][local286].length) {
                        model.ia(recol_s[local282][local286], recol_d[local282][local286][this.clientpalette[local282]]);
                    }
                }
            }

            model.s(newFunctionMask);

            @Pc(340) ReferenceCache local340 = modelCache;
            synchronized (modelCache) {
                modelCache.put(model, this.hash);
            }
        }

        if (animator == null) {
            return model;
        } else {
            @Pc(375) Model animatedModel = model.copy((byte) 4, newFunctionMask, true);
            animator.animate(animatedModel, 0);
            return animatedModel;
        }
    }
}
