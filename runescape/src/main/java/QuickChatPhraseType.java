import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.QuickChatDynamicCommand;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ih")
public final class QuickChatPhraseType extends Node2 {

    @OriginalMember(owner = "client!ih", name = "A", descriptor = "[[I")
    public int[][] dynamicCommandParams;

    @OriginalMember(owner = "client!ih", name = "v", descriptor = "Lclient!gba;")
    public QuickChatPhraseTypeList typeList;

    @OriginalMember(owner = "client!ih", name = "F", descriptor = "[I")
    public int[] dynamicCommands;

    @OriginalMember(owner = "client!ih", name = "G", descriptor = "[I")
    public int[] autoResponses;

    @OriginalMember(owner = "client!ih", name = "E", descriptor = "[Ljava/lang/String;")
    public String[] lines;

    @OriginalMember(owner = "client!ih", name = "I", descriptor = "Z")
    public boolean searchable = true;

    @OriginalMember(owner = "client!ih", name = "b", descriptor = "(II)Lclient!it;")
    public QuickChatDynamicCommand getDynamicCommand(@OriginalArg(1) int index) {
        if (this.dynamicCommands != null && index >= 0 && index <= this.dynamicCommands.length) {
            return QuickChatDynamicCommand.fromId(this.dynamicCommands[index]);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(5) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(packet, code);
        }
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(IZI)I")
    public int getDynamicCommandParam(@OriginalArg(0) int type, @OriginalArg(2) int index) {
        if (this.dynamicCommands == null || type < 0 || type > this.dynamicCommands.length) {
            return -1;
        } else if (this.dynamicCommandParams[type] == null || index < 0 || index > this.dynamicCommandParams[type].length) {
            return -1;
        } else {
            return this.dynamicCommandParams[type][index];
        }
    }

    @OriginalMember(owner = "client!ih", name = "c", descriptor = "(B)I")
    public int getDynamicCommandCount() {
        return this.dynamicCommands == null ? 0 : this.dynamicCommands.length;
    }

    @OriginalMember(owner = "client!ih", name = "d", descriptor = "(I)V")
    public void method3902() {
        if (this.autoResponses != null) {
            for (@Pc(8) int i = 0; i < this.autoResponses.length; i++) {
                this.autoResponses[i] |= 0x8000;
            }
        }
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(BLclient!ge;)Ljava/lang/String;")
    public String decodeText(@OriginalArg(1) Packet packet) {
        @Pc(10) StringBuffer buffer = new StringBuffer(80);
        if (this.dynamicCommands != null) {
            for (@Pc(15) int i = 0; i < this.dynamicCommands.length; i++) {
                buffer.append(this.lines[i]);
                buffer.append(this.typeList.getFillter(this.getDynamicCommand(i), packet.gVarLong(QuickChatDynamicCommand.fromId(this.dynamicCommands[i]).readSize), this.dynamicCommandParams[i]));
            }
        }
        buffer.append(this.lines[this.lines.length - 1]);
        return buffer.toString();
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(Lclient!ge;[II)V")
    public void encode(@OriginalArg(0) Packet packet, @OriginalArg(1) int[] data) {
        if (this.dynamicCommands == null) {
            return;
        }

        for (@Pc(15) int i = 0; i < this.dynamicCommands.length; i++) {
            if (data.length <= i) {
                return;
            }

            @Pc(22) int writeSize = this.getDynamicCommand(i).writeSize;
            if (writeSize > 0) {
                packet.pVarLong(writeSize, data[i]);
            }
        }
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(I)Ljava/lang/String;")
    public String getText() {
        @Pc(8) StringBuffer buffer = new StringBuffer(80);
        if (this.lines == null) {
            return "";
        }
        buffer.append(this.lines[0]);
        for (@Pc(30) int i = 1; i < this.lines.length; i++) {
            buffer.append("...");
            buffer.append(this.lines[i]);
        }
        return buffer.toString();
    }

    @OriginalMember(owner = "client!ih", name = "a", descriptor = "(Lclient!ge;II)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.lines = StringTools.split(packet.gjstr(), '<');
            return;
        } else if (code == 2) {
            @Pc(21) int count = packet.g1();
            this.autoResponses = new int[count];

            for (@Pc(27) int i = 0; i < count; i++) {
                this.autoResponses[i] = packet.g2();
            }
        } else if (code == 3) {
            @Pc(21) int count = packet.g1();

            this.dynamicCommandParams = new int[count][];
            this.dynamicCommands = new int[count];

            for (@Pc(27) int i = 0; i < count; i++) {
                @Pc(71) int id = packet.g2();
                @Pc(75) QuickChatDynamicCommand command = QuickChatDynamicCommand.fromId(id);

                if (command != null) {
                    this.dynamicCommands[i] = id;
                    this.dynamicCommandParams[i] = new int[command.varCount];

                    for (@Pc(91) int j = 0; j < command.varCount; j++) {
                        this.dynamicCommandParams[i][j] = packet.g2();
                    }
                }
            }
        } else if (code == 4) {
            this.searchable = false;
        }
    }
}
