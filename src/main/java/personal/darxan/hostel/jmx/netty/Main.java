package personal.darxan.hostel.jmx.netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by darxan on 2017/3/7.
 */
public class Main {

    static void server() {
        //服务器自启动
        ServerBootstrap serverBootstrap
                = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()
                )
        );
        //设置一个处理客户端消息，和各种消息事件的类
        serverBootstrap.setPipelineFactory(
                new ChannelPipelineFactory() {

                    public ChannelPipeline getPipeline() throws Exception {
                        return Channels.pipeline(new HelloServerHandler());
                    }
                }
        );
        serverBootstrap.bind(new InetSocketAddress(8000));
    }

    public static void main(String[] args) {
        client();
        ChannelEvent channelEvent;
    }

    static void client() {
        ClientBootstrap clientBootstrap
                = new ClientBootstrap(
                        new NioClientSocketChannelFactory(
                                Executors.newCachedThreadPool(),
                                Executors.newCachedThreadPool()
                        )
        );

        clientBootstrap.setPipelineFactory(
                new ChannelPipelineFactory() {
                    public ChannelPipeline getPipeline() throws Exception {
                        return Channels.pipeline(new HelloServerHandler("client!!"));
                    }
                }
        );

        clientBootstrap.connect(new InetSocketAddress("127.0.0.1",8000));
    }
}
