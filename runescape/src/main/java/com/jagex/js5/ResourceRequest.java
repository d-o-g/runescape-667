package com.jagex.js5;

import com.jagex.collect.DoublyLinkedList;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tw")
public abstract class ResourceRequest extends DoublyLinkedList.Node {

    @OriginalMember(owner = "client!tw", name = "y", descriptor = "Z")
    public boolean orphan;

    @OriginalMember(owner = "client!tw", name = "u", descriptor = "Z")
    public boolean urgent;

    @OriginalMember(owner = "client!tw", name = "v", descriptor = "Z")
    public volatile boolean incomplete = true;

    @OriginalMember(owner = "client!tw", name = "a", descriptor = "(I)[B")
    public abstract byte[] getData();

    @OriginalMember(owner = "client!tw", name = "c", descriptor = "(B)I")
    public abstract int completePercentage();
}
