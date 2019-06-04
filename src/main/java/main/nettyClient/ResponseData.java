package main.nettyClient;

public class ResponseData {
    private int codeResponseMessage;

    public int getCodeResponseMessage() {
        return codeResponseMessage;
    }

    public void setCodeResponseMessage(int codeResponseMessage) {
        this.codeResponseMessage = codeResponseMessage;
    }

    @Override
    public String toString() {
        return String.valueOf(codeResponseMessage);
    }
}