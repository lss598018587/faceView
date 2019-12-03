package com.miaomiao.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest0 {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i <10 ; i++) {
            byteBuf.writeByte(i);
        }
        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 10, cap: 10)
        System.out.println(byteBuf);

        for (int i = 0; i <byteBuf.capacity() ; i++) {
            System.out.println(byteBuf.getByte(i));
        }
        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 10, cap: 10)
        System.out.println(byteBuf);

        for (int i = 0; i <byteBuf.capacity() ; i++) {
            System.out.println(byteBuf.readByte());
        }
        //UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 10, widx: 10, cap: 10)
        System.out.println(byteBuf);

    }

}
