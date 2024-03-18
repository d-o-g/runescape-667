import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ju")
public final class PlayerModel {

    @OriginalMember(owner = "client!kma", name = "n", descriptor = "[[[S")
    public static short[][][] bodycol_d;
    @OriginalMember(owner = "client!cha", name = "e", descriptor = "[[S")
    public static short[][] bodycol_s;
    @OriginalMember(owner = "client!ju", name = "h", descriptor = "I")
    public int basId;

    @OriginalMember(owner = "client!ju", name = "e", descriptor = "[I")
    public int[] bodycol_d_palette;

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
            this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) this.bodycol_d_palette[i]) & 0xFFL)];
        }

        this.hash = (this.hash >>> 8) ^ crc[(int) ((this.hash ^ (long) (this.female ? 1 : 0)) & 0xFFL)];
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "([I[I[Lclient!bs;IIZB)V")
    public void update(@OriginalArg(0) int[] bodycol_d_palette, @OriginalArg(1) int[] identikit, @OriginalArg(2) ObjTypeCustomisation[] customisations, @OriginalArg(3) int npcId, @OriginalArg(4) int basId, @OriginalArg(5) boolean female) {
        this.customisations = customisations;
        this.bodycol_d_palette = bodycol_d_palette;
        this.female = female;
        if (this.basId != basId) {
            this.basId = basId;
        }
        this.identikit = identikit;
        this.npcId = npcId;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!es;Lclient!gu;IZLclient!qp;Lclient!bp;I[ILclient!vl;Lclient!kr;Lclient!ha;Lclient!ql;[Lclient!gu;ILclient!gu;Lclient!uk;)Lclient!ka;")
    public Model getBodyModel(@OriginalArg(0) ObjTypeList objTypeList, @OriginalArg(1) Animator animator, @OriginalArg(4) BASTypeList basTypeList, @OriginalArg(5) Class50 arg3, @OriginalArg(6) int initialFunctionMask, @OriginalArg(7) int[] arg5, @OriginalArg(8) WearposDefaults wearposDefaults, @OriginalArg(9) IDKTypeList idkTypeList, @OriginalArg(10) Toolkit toolkit, @OriginalArg(11) NPCTypeList npcTypeList, @OriginalArg(12) Animator[] animators, @OriginalArg(13) int arg11, @OriginalArg(14) Animator arg12, @OriginalArg(15) VarDomain varDomain) {
        if (this.npcId != -1) {
            return npcTypeList.list(this.npcId).getModel(varDomain, toolkit, basTypeList, animator, arg11, arg5, (Class386) null, arg12, initialFunctionMask, animators);
        }
        @Pc(28) int functionMask = initialFunctionMask;
        @Pc(31) long hash = this.hash;
        @Pc(34) int[] identikit = this.identikit;
        @Pc(36) boolean leftHand = false;
        @Pc(44) boolean rightHand = false;
        @Pc(72) int local72;
        @Pc(116) int local116;
        if (animator != null) {
            @Pc(50) SeqType animation = animator.getAnimation();
            if (animation != null && (animation.playerLeftHand >= 0 || animation.playerRightHand >= 0)) {
                identikit = new int[this.identikit.length];
                for (local72 = 0; local72 < identikit.length; local72++) {
                    identikit[local72] = this.identikit[local72];
                }

                if (animation.playerLeftHand >= 0 && wearposDefaults.leftHandSlot != -1) {
                    if (animation.playerLeftHand == 65535) {
                        identikit[wearposDefaults.leftHandSlot] = 0;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenLeftHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[local116]] = 0;
                        }
                        hash ^= 0xFFFFFFFF00000000L;
                    } else {
                        identikit[wearposDefaults.leftHandSlot] = animation.playerLeftHand | 0x40000000;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenLeftHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenLeftHandSlots[local116]] = 0;
                        }
                        hash ^= (long) identikit[wearposDefaults.leftHandSlot] << 32;
                    }

                    leftHand = true;
                }

                if (animation.playerRightHand >= 0 && wearposDefaults.rightHandSlot != -1) {
                    rightHand = true;

                    if (animation.playerRightHand == 65535) {
                        identikit[wearposDefaults.rightHandSlot] = 0;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenRightHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[local116]] = 0;
                        }
                        hash ^= 0xFFFFFFFFL;
                    } else {
                        identikit[wearposDefaults.rightHandSlot] = animation.playerRightHand | 0x40000000;
                        for (local116 = 0; local116 < wearposDefaults.animationHiddenRightHandSlots.length; local116++) {
                            identikit[wearposDefaults.animationHiddenRightHandSlots[local116]] = 0;
                        }
                        hash ^= (long) identikit[wearposDefaults.rightHandSlot];
                    }
                }
            }
        }

        @Pc(257) boolean animated = false;
        local72 = animators == null ? 0 : animators.length;
        for (local116 = 0; local116 < local72; local116++) {
            if (animators[local116] != null) {
                functionMask |= animators[local116].functionMask();
                animated = true;
            }
        }

        if (animator != null) {
            functionMask |= animator.functionMask();
            animated = true;
        }

        if (arg12 != null) {
            animated = true;
            functionMask |= arg12.functionMask();
        }

        @Pc(310) boolean local310 = false;
        if (arg5 != null) {
            for (@Pc(314) int local314 = 0; local314 < arg5.length; local314++) {
                if (arg5[local314] != -1) {
                    local310 = true;
                    functionMask |= 0x20;
                }
            }
        }

        @Pc(334) Class82 local334 = Static580.aClass82_186;
        @Pc(342) Model model;
        synchronized (Static580.aClass82_186) {
            model = (Model) Static580.aClass82_186.method2156(hash);
        }

        @Pc(350) BASType basType = null;
        if (this.basId != -1) {
            basType = basTypeList.list(this.basId);
        }

        @Pc(390) int local390;
        @Pc(395) int local395;
        @Pc(586) int local586;
        @Pc(591) int local591;
        if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
            if (model != null) {
                functionMask = toolkit.combineFunctionMasks(functionMask, model.ua());
            }

            @Pc(388) boolean local388 = false;
            local390 = 0;
            while (true) {
                @Pc(409) int i;
                if (local390 >= identikit.length) {
                    if (local388) {
                        if (this.aLong159 != -1L) {
                            @Pc(552) Class82 local552 = Static580.aClass82_186;
                            synchronized (Static580.aClass82_186) {
                                model = (Model) Static580.aClass82_186.method2156(this.aLong159);
                            }
                        }
                        if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
                            return null;
                        }
                    } else {
                        @Pc(584) Mesh[] meshes = new Mesh[identikit.length];
                        for (local586 = 0; local586 < identikit.length; local586++) {
                            local591 = identikit[local586];
                            @Pc(593) ObjTypeCustomisation customisation = null;
                            @Pc(614) boolean local614 = local586 == 5 && leftHand || local586 == 3 && rightHand;
                            @Pc(633) Mesh local633;
                            if ((local591 & 0x40000000) != 0) {
                                if (!local614 && this.customisations != null && this.customisations[local586] != null) {
                                    customisation = this.customisations[local586];
                                }
                                local633 = objTypeList.list(local591 & 0x3FFFFFFF).model(customisation, this.female);
                                if (local633 != null) {
                                    meshes[local586] = local633;
                                }
                            } else if ((Integer.MIN_VALUE & local591) != 0) {
                                local633 = idkTypeList.list(local591 & 0x3FFFFFFF).model();
                                if (local633 != null) {
                                    meshes[local586] = local633;
                                }
                            }
                        }

                        @Pc(709) int j;
                        if (basType != null && basType.equipmentTransformations != null) {
                            for (local591 = 0; local591 < basType.equipmentTransformations.length; local591++) {
                                if (meshes[local591] != null) {
                                    i = 0;
                                    j = 0;
                                    @Pc(711) int tz = 0;
                                    @Pc(713) int rx = 0;
                                    @Pc(715) int ry = 0;
                                    @Pc(717) int rz = 0;
                                    if (basType.equipmentTransformations[local591] != null) {
                                        i = basType.equipmentTransformations[local591][0];
                                        j = basType.equipmentTransformations[local591][1];
                                        tz = basType.equipmentTransformations[local591][2];
                                        rx = basType.equipmentTransformations[local591][3] << 3;
                                        ry = basType.equipmentTransformations[local591][4] << 3;
                                        rz = basType.equipmentTransformations[local591][5] << 3;
                                    }
                                    if (rx != 0 || ry != 0 || rz != 0) {
                                        meshes[local591].rotate(rz, rx, ry);
                                    }
                                    if (i != 0 || j != 0 || tz != 0) {
                                        meshes[local591].translate(i, j, tz);
                                    }
                                }
                            }
                        }

                        @Pc(826) int local826 = functionMask | 0x4000;
                        @Pc(833) Mesh mesh = new Mesh(meshes, meshes.length);
                        model = toolkit.createModel(mesh, local826, Static294.anInt4766, 64, 850);

                        for (i = 0; i < 10; i++) {
                            for (j = 0; j < bodycol_s[i].length; j++) {
                                if (bodycol_d[i][j].length > this.bodycol_d_palette[i]) {
                                    model.ia(bodycol_s[i][j], bodycol_d[i][j][this.bodycol_d_palette[i]]);
                                }
                            }
                        }

                        model.s(functionMask);

                        @Pc(903) Class82 local903 = Static580.aClass82_186;
                        synchronized (Static580.aClass82_186) {
                            Static580.aClass82_186.method2150(model, hash);
                        }

                        this.aLong159 = hash;
                    }
                    break;
                }

                local395 = identikit[local390];
                @Pc(397) ObjTypeCustomisation customisation = null;

                @Pc(399) boolean local399 = false;
                if (leftHand) {
                    if (wearposDefaults.leftHandSlot == local390) {
                        local399 = true;
                    } else {
                        for (i = 0; i < wearposDefaults.animationHiddenLeftHandSlots.length; i++) {
                            if (local390 == wearposDefaults.animationHiddenLeftHandSlots[i]) {
                                local399 = true;
                                break;
                            }
                        }
                    }
                }
                if (rightHand) {
                    if (wearposDefaults.rightHandSlot == local390) {
                        local399 = true;
                    } else {
                        for (i = 0; i < wearposDefaults.animationHiddenRightHandSlots.length; i++) {
                            if (wearposDefaults.animationHiddenRightHandSlots[i] == local390) {
                                local399 = true;
                                break;
                            }
                        }
                    }
                }

                if ((local395 & 0x40000000) != 0) {
                    if (!local399 && this.customisations != null && this.customisations[local390] != null) {
                        customisation = this.customisations[local390];
                    }

                    if (!objTypeList.list(local395 & 0x3FFFFFFF).loadedModels(this.female, customisation)) {
                        local388 = true;
                    }
                } else if ((Integer.MIN_VALUE & local395) != 0 && !idkTypeList.list(local395 & 0x3FFFFFFF).isModelLoaded()) {
                    local388 = true;
                }

                local390++;
            }
        }

        @Pc(925) Model bodyModel = model.copy((byte) 4, functionMask, true);
        if (!animated && !local310) {
            return bodyModel;
        }

        @Pc(936) Matrix[] matrices = null;
        if (basType != null) {
            matrices = basType.transformMatrices(toolkit);
        }

        if (local310 && matrices != null) {
            for (local390 = 0; local390 < arg5.length; local390++) {
                if (matrices[local390] != null) {
                    bodyModel.transform(matrices[local390], 0x1 << local390, true);
                }
            }
        }

        local390 = 0;
        local395 = 1;
        while (local390 < local72) {
            if (animators[local390] != null) {
                animators[local390].animatePartial(local395, bodyModel);
            }
            local390++;
            local395 <<= 0x1;
        }

        if (local310) {
            for (local586 = 0; local586 < arg5.length; local586++) {
                if (arg5[local586] != -1) {
                    local591 = arg5[local586] - arg11;
                    local591 &= 0x3FFF;
                    @Pc(1034) Matrix matrix = toolkit.createMatrix();
                    matrix.method7131(local591);
                    bodyModel.transform(matrix, 0x1 << local586, false);
                }
            }
        }

        if (local310 && matrices != null) {
            for (local586 = 0; local586 < arg5.length; local586++) {
                if (matrices[local586] != null) {
                    bodyModel.transform(matrices[local586], 0x1 << local586, false);
                }
            }
        }

        if (animator != null && arg12 != null) {
            Animator.blend(animator, bodyModel, arg12);
        } else if (animator != null) {
            animator.animate(bodyModel, 0);
        } else if (arg12 != null) {
            arg12.animate(bodyModel, 0);
        }

        return bodyModel;
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IZ)V")
    public void method4547(@OriginalArg(1) boolean arg0) {
        this.female = arg0;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IBLclient!kr;I)V")
    public void method4548(@OriginalArg(0) int arg0, @OriginalArg(2) IDKTypeList arg1, @OriginalArg(3) int arg2) {
        @Pc(7) int local7 = Static264.anIntArray891[arg2];
        if (arg1.list(arg0) != null) {
            this.identikit[local7] = Integer.MIN_VALUE | arg0;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(IIB)V")
    public void method4549(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.bodycol_d_palette[arg0] = arg1;
        this.computeHash();
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!gu;IILclient!bp;Lclient!ha;BLclient!kr;II)Lclient!ka;")
    public Model method4550(@OriginalArg(0) Animator arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class50 arg3, @OriginalArg(4) Toolkit arg4, @OriginalArg(6) IDKTypeList arg5, @OriginalArg(7) int arg6) {
        @Pc(16) int local16 = arg0 == null ? 2048 : arg0.functionMask() | 0x800;
        @Pc(29) long local29 = (long) arg1 | (long) arg2 << 32 | (long) (arg6 << 16);
        @Pc(31) Class82 local31 = Static54.aClass82_25;
        @Pc(39) Model local39;
        synchronized (Static54.aClass82_25) {
            local39 = (Model) Static54.aClass82_25.method2156(local29);
        }
        if (local39 == null || arg4.compareFunctionMasks(local39.ua(), local16) != 0) {
            if (local39 != null) {
                local16 = arg4.combineFunctionMasks(local16, local39.ua());
            }
            @Pc(70) Mesh[] local70 = new Mesh[3];
            @Pc(72) int local72 = 0;
            if (!arg5.list(arg1).method6615() || !arg5.list(arg6).method6615() || !arg5.list(arg2).method6615()) {
                return null;
            }
            @Pc(107) Mesh local107 = arg5.list(arg1).method6614();
            if (local107 != null) {
                local72++;
                local70[0] = local107;
            }
            local107 = arg5.list(arg6).method6614();
            if (local107 != null) {
                local70[local72++] = local107;
            }
            local107 = arg5.list(arg2).method6614();
            if (local107 != null) {
                local70[local72++] = local107;
            }
            @Pc(152) int local152 = local16 | 0x4000;
            local107 = new Mesh(local70, local72);
            local39 = arg4.createModel(local107, local152, Static294.anInt4766, 64, 768);
            for (@Pc(168) int local168 = 0; local168 < 10; local168++) {
                for (@Pc(172) int local172 = 0; local172 < bodycol_s[local168].length; local172++) {
                    if (this.bodycol_d_palette[local168] < bodycol_d[local168][local172].length) {
                        local39.ia(bodycol_s[local168][local172], bodycol_d[local168][local172][this.bodycol_d_palette[local168]]);
                    }
                }
            }
            local39.s(local16);
            @Pc(228) Class82 local228 = Static54.aClass82_25;
            synchronized (Static54.aClass82_25) {
                Static54.aClass82_25.method2150(local39, local29);
            }
        }
        if (arg0 == null) {
            return local39;
        } else {
            local39 = local39.copy((byte) 4, local16, true);
            arg0.animate(local39, 0);
            return local39;
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(BIILclient!es;)V")
    public void setObj(@OriginalArg(1) int objId, @OriginalArg(2) int part, @OriginalArg(3) ObjTypeList objTypeList) {
        if (objId == -1) {
            this.identikit[part] = 0;
        } else if (objTypeList.list(objId) != null) {
            this.identikit[part] = objId | 0x40000000;
            this.computeHash();
        }
    }

    @OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!kr;BLclient!bp;Lclient!uk;Lclient!gu;Lclient!es;Lclient!ql;Lclient!ha;I)Lclient!ka;")
    public Model method4552(@OriginalArg(0) IDKTypeList arg0, @OriginalArg(2) Class50 arg1, @OriginalArg(3) VarDomain arg2, @OriginalArg(4) Animator arg3, @OriginalArg(5) ObjTypeList arg4, @OriginalArg(6) NPCTypeList arg5, @OriginalArg(7) Toolkit arg6) {
        if (this.npcId != -1) {
            return arg5.list(this.npcId).method5992(arg3, (Class386) null, arg6, arg2);
        }
        @Pc(35) int local35 = arg3 == null ? 2048 : arg3.functionMask() | 0x800;
        @Pc(37) Class82 local37 = Static54.aClass82_25;
        @Pc(48) Model local48;
        synchronized (Static54.aClass82_25) {
            local48 = (Model) Static54.aClass82_25.method2156(this.hash);
        }
        if (local48 == null || arg6.compareFunctionMasks(local48.ua(), local35) != 0) {
            if (local48 != null) {
                local35 = arg6.combineFunctionMasks(local35, local48.ua());
            }
            @Pc(81) boolean local81 = false;
            for (@Pc(83) int local83 = 0; local83 < this.identikit.length; local83++) {
                @Pc(92) int local92 = this.identikit[local83];
                @Pc(94) ObjTypeCustomisation local94 = null;
                if ((local92 & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[local83] != null) {
                        local94 = this.customisations[local83];
                    }
                    if (!arg4.list(local92 & 0x3FFFFFFF).method8808(local94, this.female)) {
                        local81 = true;
                    }
                } else if ((Integer.MIN_VALUE & local92) != 0 && !arg0.list(local92 & 0x3FFFFFFF).method6615()) {
                    local81 = true;
                }
            }
            if (local81) {
                return null;
            }
            @Pc(172) Mesh[] local172 = new Mesh[this.identikit.length];
            @Pc(174) int local174 = 0;
            for (@Pc(176) int local176 = 0; local176 < this.identikit.length; local176++) {
                @Pc(185) int local185 = this.identikit[local176];
                @Pc(187) ObjTypeCustomisation local187 = null;
                @Pc(220) Mesh local220;
                if ((local185 & 0x40000000) != 0) {
                    if (this.customisations != null && this.customisations[local176] != null) {
                        local187 = this.customisations[local176];
                    }
                    local220 = arg4.list(local185 & 0x3FFFFFFF).method8801(this.female, local187);
                    if (local220 != null) {
                        local172[local174++] = local220;
                    }
                } else if ((Integer.MIN_VALUE & local185) != 0) {
                    local220 = arg0.list(local185 & 0x3FFFFFFF).method6614();
                    if (local220 != null) {
                        local172[local174++] = local220;
                    }
                }
            }
            @Pc(266) Mesh local266 = new Mesh(local172, local174);
            @Pc(270) int local270 = local35 | 0x4000;
            local48 = arg6.createModel(local266, local270, Static294.anInt4766, 64, 768);
            for (@Pc(282) int local282 = 0; local282 < 10; local282++) {
                for (@Pc(286) int local286 = 0; local286 < bodycol_s[local282].length; local286++) {
                    if (this.bodycol_d_palette[local282] < bodycol_d[local282][local286].length) {
                        local48.ia(bodycol_s[local282][local286], bodycol_d[local282][local286][this.bodycol_d_palette[local282]]);
                    }
                }
            }
            local48.s(local35);
            @Pc(340) Class82 local340 = Static54.aClass82_25;
            synchronized (Static54.aClass82_25) {
                Static54.aClass82_25.method2150(local48, this.hash);
            }
        }
        if (arg3 == null) {
            return local48;
        } else {
            @Pc(375) Model local375 = local48.copy((byte) 4, local35, true);
            arg3.animate(local375, 0);
            return local375;
        }
    }
}
