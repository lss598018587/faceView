package com.miaomiao.suanfa.linkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HerNode herNode1 = new HerNode(1,"宋江","及时雨");
        HerNode herNode2 = new HerNode(2,"吴用","玉麒麟");
        HerNode herNode3 = new HerNode(3,"卢俊义","智多星");
        HerNode herNode4 = new HerNode(4,"林冲","豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(herNode1);
        singleLinkedList.add(herNode2);
        singleLinkedList.add(herNode3);
        singleLinkedList.add(herNode4);
        singleLinkedList.list();

        //测试一下单链表的反转功能
        System.out.println("测试一下单链表的反转功能~~~");
        singleLinkedList.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();
    }


}
//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //先初始化一个投节点，头节点不要动,不存放具体的数据
    private HerNode head = new HerNode(0,"","");

    public HerNode getHead() {
        return head;
    }

    //添加节点到单向链表
    public void add(HerNode node){
        HerNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = node;

    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HerNode temp = head.next;
        while (true){
            //判断是否链表到最后
            if(temp ==null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }

    }

    //将单链表反转
    public void reversetList(HerNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next ==null || head.next.next==null){
            return;
        }
        //定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HerNode cur = head.next;
        //指向当前节点[cur]的下一个节点
        HerNode next =null;

        //新链表
        HerNode reverseHead = new HerNode(0,"","");

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while(cur !=null){
            //先展示保存当前节点的下一个节点，后面需要用到
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端(相当于插入到新链表的第一个位置，这里不包括head)
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            //把之前保存的next赋值
            cur = next;
        }

        //将head.next 指向reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }


}


class HerNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HerNode next;

    public HerNode(int no, String name, String nickName ) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
