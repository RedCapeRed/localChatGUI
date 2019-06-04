package main.nettyClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf inBuf, List<Object> listOut) throws Exception {
        ResponseData data = new ResponseData();
        data.setCodeResponseMessage(inBuf.readInt());
        listOut.add(data);
    }
}