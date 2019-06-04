package main.nettyClient;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MessageHandler extends ChannelInboundHandlerAdapter {
    private String loginSender ;
    private String message;
    int codeMessage;

    public MessageHandler(int codeMessage,String loginSender, String message) {
        this.codeMessage = codeMessage;
        this.loginSender = loginSender;
        this.message = message;

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        UserData msg = new UserData();
        msg.setLogin("123");
        ChannelFuture future = ctx.writeAndFlush(msg);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((ResponseData)msg);
        ctx.close();
    }
}