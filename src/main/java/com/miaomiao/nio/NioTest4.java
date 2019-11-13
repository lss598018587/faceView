package com.miaomiao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

public class NioTest4 {

    private static Map<String,SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] ports = new int[5];

        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();

        for (int i = 0; i < ports.length ; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket socket = serverSocketChannel.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            socket.bind(address);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口："+ports[i]);

        }

        while (true){
            int numers = selector.select();
            System.out.println("numbers:"+numers);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            System.out.println("selectedKeys:"+selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                     socketChannel.configureBlocking(false);

                    socketChannel.register(selector,SelectionKey.OP_READ);
                    clientMap.put(UUID.randomUUID().toString(),socketChannel);
                    //事件用完一定要删掉，不删掉，下次循环还会咋偶进来
                    iterator.remove();
                    System.out.println("获得客户端连接："+socketChannel);
                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int bytesRead = 0;
                    while(true){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        int read = socketChannel.read(byteBuffer);

                        if (read <= 0) {
                            break;
                        }

                        byteBuffer.flip();
                        Charset charset = Charset.forName("utf-8");
                        String recive = String.valueOf(charset.decode(byteBuffer).array());
                        System.out.println("socketChannel:"+socketChannel+", msg:"+recive);

                        String sendKey = null;

                        for (Map.Entry<String,SocketChannel> entry : clientMap.entrySet()){
                            if(socketChannel == entry.getValue()){
                                sendKey = entry.getKey();
                            }
                        }

                        for (Map.Entry<String,SocketChannel> entry : clientMap.entrySet()){
                            SocketChannel value = entry.getValue();
                            ByteBuffer writeBuffer = ByteBuffer.allocate(512);
                            writeBuffer.put((sendKey+recive).getBytes());
                            writeBuffer.flip();
                            value.write(writeBuffer);
                        }

                        bytesRead +=read;
                    }

                    System.out.println("读取："+bytesRead+", 来自于："+socketChannel);

                    iterator.remove();
                }
            }
        }

    }
}
