package com.miaomiao.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("input.txt");

        FileChannel inputChannel = inputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        int read = inputChannel.read(byteBuffer);
    }
}
