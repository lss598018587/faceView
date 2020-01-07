package com.miaomiao.ioBase;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 对文件建立 java.io.BufferedInputStream ，每次调用 read() 方法时会接连取出文件中长度为 arraySize 的数据到 array 中。这种方法可行但是效率不高。
 */

public class StreamFileReader {
    private BufferedInputStream fileIn;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public StreamFileReader(String fileName, int arraySize) throws IOException {
        this.fileIn = new BufferedInputStream(new FileInputStream(fileName), arraySize);
        this.fileLength = fileIn.available();
        this.arraySize = arraySize;
    }

    /**
     * 1、自己定义一个数组长度
     * 2、通过read方法，把文件读到数组里，返回一个int bytes，表示数组使用了多少长度
     * 3、根据bytes字段，重新定义一个数组
     * 4、把老数组里的数据拷贝到新数组里
     *
     * 例如，int a = new int[10]
     * read之后，a我就用了8个长度
     * int b = new int [8]
     * 把a里的8个长度赋值给b。
     *
     * @return
     * @throws IOException
     */
    public int read() throws IOException {
        byte[] tmpArray = new byte[arraySize];
        int bytes = fileIn.read(tmpArray);// 暂存到字节数组中
        if (bytes != -1) {
            array = new byte[bytes];// 字节数组长度为已读取长度
            System.arraycopy(tmpArray, 0, array, 0, bytes);// 复制已读取数据
            return bytes;
        }
        return -1;
    }

    public void close() throws IOException {
        fileIn.close();
        array = null;
    }

    public byte[] getArray() {
        return array;
    }

    public long getFileLength() {
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        StreamFileReader reader = new StreamFileReader("/Users/miaomiao/Downloads/mos-interview/src/main/resources/data/skus.xls", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1) ;
        long end = System.nanoTime();
        reader.close();
        System.out.println("StreamFileReader: " + (end - start));
    }
}
