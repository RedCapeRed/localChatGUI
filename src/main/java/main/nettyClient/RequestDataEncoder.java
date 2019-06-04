package main.nettyClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class RequestDataEncoder extends MessageToByteEncoder<UserData> {
    int messageCode;

    public RequestDataEncoder(int messageCode){
        this.messageCode = messageCode;
    }

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void encode(ChannelHandlerContext ctx, UserData userData, ByteBuf outBuf) throws Exception {
        outBuf.writeInt(messageCode);
        outBuf.writeInt(userData.getLogin().length());
        outBuf.writeCharSequence(userData.getLogin(), charset);
        outBuf.writeInt(userData.getPassword().length);
        for(char i : userData.getPassword())
            outBuf.writeChar(i);

    }
}