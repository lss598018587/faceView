package com.miaomiao.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioClient {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1",5000));

        while (true) {
            int num = selector.select();
            System.out.println("有"+num+"个channel上有事件");

            Set<SelectionKey> keySet = selector.selectedKeys();

            for(SelectionKey selectionKey : keySet){
                if (selectionKey.isConnectable()) {

                    final SocketChannel client = (SocketChannel)selectionKey.channel();
                    if(client.isConnectionPending()){
                        client.finishConnect();
                        final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        writeBuffer.put((System.currentTimeMillis() + " ；链接成功").getBytes());
                        writeBuffer.flip();
                        client.write(writeBuffer);

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while(true){
                                    try {
                                        writeBuffer.clear();
                                        InputStreamReader input = new InputStreamReader(System.in);
                                        BufferedReader br = new BufferedReader(input);

                                        String sendMessage = br.readLine();
                                        writeBuffer.put(sendMessage.getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }).start();
                        client.register(selector,SelectionKey.OP_READ);

                    }

                }else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel)selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    while (true){
                        int count = client.read(readBuffer);
                        if (count > 0) {
                            String rece = new String(readBuffer.array(),0,count);
                            System.out.println(rece);
                        }else{
                            break;
                        }
                    }
                }
            }
            keySet.clear();
        }

    }

}
