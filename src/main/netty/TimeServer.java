package main.netty;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;

/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class TimeServer {
    private static int port = 8125;

    private static Charset charset = Charset.forName("US-ASCII");
    private static CharsetEncoder encoder = charset.newEncoder();

    private static ByteBuffer buf = ByteBuffer.allocateDirect(1024);

    private static ServerSocketChannel steup() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        String host = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Listen at Host:" + host + ",port:" + port);
        SocketAddress isa = new InetSocketAddress(host, port);
        serverSocketChannel.socket().bind(isa);

        return serverSocketChannel;
    }

    private static void serve(ServerSocketChannel ssc) throws IOException {
        SocketChannel sc = ssc.accept();
        String now = new Date().toString();
        sc.write(encoder.encode(CharBuffer.wrap(now + "\r\n")));
        System.out.println(sc.socket().getInetAddress() + ": " + now);
        sc.close();
    }

    public static void main(String[] args) throws IOException{
        if (args.length > 1) {
            System.out.println("error");
            return;
        }

        ServerSocketChannel ssc = steup();
        for (;;){
            serve(ssc);
        }
    }
}
