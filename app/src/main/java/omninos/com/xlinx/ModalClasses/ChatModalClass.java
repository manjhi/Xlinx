package omninos.com.xlinx.ModalClasses;

public class ChatModalClass {
    public final static String MSG_TYPE_SENT = "MSG_TYPE_SENT";

    public final static String MSG_TYPE_RECEIVED = "MSG_TYPE_RECEIVED";

    private String msgContent;

    // Message type.
    private String msgType;

    public ChatModalClass(String msgContent, String msgType) {
        this.msgContent = msgContent;
        this.msgType = msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
