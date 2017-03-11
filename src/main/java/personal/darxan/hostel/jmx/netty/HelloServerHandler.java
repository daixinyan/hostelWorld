package personal.darxan.hostel.jmx.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import personal.darxan.hostel.tool.MyLogger;

/**
 * Created by darxan on 2017/3/7.
 */
public class HelloServerHandler extends SimpleChannelHandler{

    String type;

    public HelloServerHandler(String string) {
        type = string;
    }
    public HelloServerHandler() {
    }

    @Override
    public void channelConnected(ChannelHandlerContext context, ChannelStateEvent event) {
        MyLogger.log("hello, world!");
        MyLogger.log(type);
    }
}
