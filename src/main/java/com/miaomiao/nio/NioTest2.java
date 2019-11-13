package com.miaomiao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioTest2 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        int messageLength =2+3+4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true){
            int bytesRead = 0;

            while(bytesRead<messageLength){
                long r = socketChannel.read(buffers);
                bytesRead +=r;
                System.out.println("bytesRead："+bytesRead);

                for (ByteBuffer buffer : buffers) {
                    System.out.println("position:"+buffer.position()+",limit:"+buffer.limit());
                }
            }

            System.out.println("读入已经结束");

            for (ByteBuffer buffer : buffers) {
                buffer.flip();
            }

            long bytesWritten =0;
            while(bytesWritten<messageLength){
                long r = socketChannel.write(buffers);
                bytesWritten +=r;
            }
            for (ByteBuffer buffer : buffers) {
                buffer.clear();
            }

            System.out.println("bytesRead:"+bytesRead+"，bytesWritten："+bytesWritten+"，messageLength："+messageLength);
        }
    }
}
