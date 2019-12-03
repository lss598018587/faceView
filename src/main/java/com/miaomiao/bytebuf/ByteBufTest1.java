package com.miaomiao.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.channels.SelectionKey;

public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(50);

        for (int i = 11; i <20 ; i++) {
            byteBuf.writeInt(i);
        }
        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 10, cap: 10)
        System.out.println(byteBuf);
        System.out.println(byteBuf.readInt());
        System.out.println(byteBuf.readBytes(4));

//        for (int i = 0; i <byteBuf.capacity() ; i++) {
//            System.out.println(byteBuf.getByte(i));
//        }
//        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 10, cap: 10)
//        System.out.println(byteBuf);
//
//        for (int i = 0; i <byteBuf.capacity() ; i++) {
//            System.out.println(byteBuf.readByte());
//        }
//        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 10, widx: 10, cap: 10)
//        System.out.println(byteBuf);

        for (int i = 1; i < 10; i++) {
            System.out.println(i & 7);
        }

        System.out.println(SelectionKey.OP_CONNECT+","+SelectionKey.OP_ACCEPT+","+ SelectionKey.OP_READ+","+SelectionKey.OP_WRITE);




    }

}
