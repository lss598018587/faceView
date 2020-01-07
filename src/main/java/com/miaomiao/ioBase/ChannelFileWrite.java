package com.miaomiao.ioBase;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ChannelFileWrite {
    public static void main(String[] args) {
        String filename = "/Users/miaomiao/Desktop/miao.txt";
        method2(filename,"淼淼");

    }


    public static void method2(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            for (int i = 0; i <150000000 ; i++) {
                out.write(i+"--"+conent+"\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
