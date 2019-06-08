package main.nettyClient.userService;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import main.nettyClient.ResponseData;

public class UserHandler extends ChannelInboundHandlerAdapter {
    private String login;
    private String password;
    private boolean isRegistered;


    public UserHandler(String login, String password,boolean isRegistered) {
        this.login = login;
        this.password = password;
        this.isRegistered = isRegistered;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserData user = new UserData();
        user.setLogin(login);
        user.setPassword(password);
        user.setRegistered(isRegistered);
        ChannelFuture future = ctx.writeAndFlush(user);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println((ResponseData)msg);
        ctx.close();
    }
}
