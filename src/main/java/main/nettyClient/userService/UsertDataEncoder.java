package main.nettyClient.userService;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class UsertDataEncoder extends MessageToByteEncoder<UserData> {
    int messageCode;

    public UsertDataEncoder(int messageCode){
        this.messageCode = messageCode;
    }

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void encode(ChannelHandlerContext ctx, UserData userData, ByteBuf outBuf) throws Exception {
        outBuf.writeInt(messageCode);
        outBuf.writeInt(userData.getLogin().length());
        outBuf.writeCharSequence(userData.getLogin(), charset);
        outBuf.writeInt(userData.getPassword().length());
        outBuf.writeCharSequence(userData.getPassword(), charset);
        outBuf.writeBoolean(userData.isRegistered());
    }
}