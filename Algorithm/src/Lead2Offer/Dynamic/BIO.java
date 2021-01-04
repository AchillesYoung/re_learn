package Lead2Offer.Dynamic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class BIO {

    public static void main(String[] args) throws IOException {
        //建立socket，作为客户端和服务器通讯的桥梁
//        ServerSocket server = new ServerSocket(9090,20);
//
//        while(true){
//            //线程会阻塞在这行代码
//            Socket accept = server.accept();
//            new Thread(() ->{
//                //client读写处理逻辑
//            }).start();
//        }
        //用于存储客户端的集合
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        //设置成非阻塞
        ss.configureBlocking(false);

        while (true){
            //非阻塞，没有就返回null
            SocketChannel client = ss.accept();
            if(client == null){
                System.out.println("null");
            }else {
                //客户端的操作也变成非阻塞
                client.configureBlocking(false);
                clients.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel socketChannel : clients) {
                //去循环看看里面没有readNum，有就操作
                int readNum = socketChannel.read(buffer);
                if(readNum > 0){
                    //其他操作
                }
            }
        }




    }
}
