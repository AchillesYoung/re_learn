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
        //����socket����Ϊ�ͻ��˺ͷ�����ͨѶ������
//        ServerSocket server = new ServerSocket(9090,20);
//
//        while(true){
//            //�̻߳����������д���
//            Socket accept = server.accept();
//            new Thread(() ->{
//                //client��д�����߼�
//            }).start();
//        }
        //���ڴ洢�ͻ��˵ļ���
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        //���óɷ�����
        ss.configureBlocking(false);

        while (true){
            //��������û�оͷ���null
            SocketChannel client = ss.accept();
            if(client == null){
                System.out.println("null");
            }else {
                //�ͻ��˵Ĳ���Ҳ��ɷ�����
                client.configureBlocking(false);
                clients.add(client);
            }
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel socketChannel : clients) {
                //ȥѭ����������û��readNum���оͲ���
                int readNum = socketChannel.read(buffer);
                if(readNum > 0){
                    //��������
                }
            }
        }




    }
}
