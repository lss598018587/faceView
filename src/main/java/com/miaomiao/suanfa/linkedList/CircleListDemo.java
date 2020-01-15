package com.miaomiao.suanfa.linkedList;


/**
 * 原题是：
 * 设编号为，1,2,3,4 ....n的n个人围坐在一圈，约定编号为k(1<=k<=n)的人
 * 从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列
 * 依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 */

public class CircleListDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.showBoy();


        System.out.println("测试一下");
        linkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList {
    //创建一个first节点，当前没有变化
    private Boy first = null;

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        //辅助指针，帮助构建环形链表
        Boy curBoy = null;

        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                //构成环形
                first.setNext(first);
                //让curBoy指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                //因为是尾部，最后一个，所以要指向第一个
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }

        //辅助指针，帮助遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", curBoy.getNo());
            //说明已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }



    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表述数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建一个辅助指针，帮助小孩出圈
        Boy helper = first;
        while (true) {
            //说明已经指向最后一个小孩了
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        while (true){
            //说明圈中只有一个人
            if(helper == first){
                break;
            }
            //让first和helper 指针同事的移动countNum 次
            for (int j=1;j<countNum;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",first.getNo());

    }


}

//表示一个节点
class Boy {
    private int no;//编号
    private Boy next; // 指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}