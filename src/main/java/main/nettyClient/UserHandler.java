package main.nettyClient;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class UserHandler extends ChannelInboundHandlerAdapter {
    private String login;
    private char[] password;


    public UserHandler(String login, char[] password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserData user = new UserData();
        user.setLogin(login);
        user.setPassword(password);
        ChannelFuture future = ctx.writeAndFlush(user);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((ResponseData)msg);
        ctx.close();
    }
}
