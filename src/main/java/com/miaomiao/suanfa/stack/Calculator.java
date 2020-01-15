package com.miaomiao.suanfa.stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "3+200*6*2-3";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //用于扫描字符的位置
        int index = 0;

        boolean flag = false;

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int opers = 0;
        while (true) {
            char c = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(c)) {
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中pop出两个数
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    /**
                     * 比如 1+3*3+8
                     *
                     * 当+号要入栈的时候
                     * 会把3*3这个拿出来计算
                     *
                     * 比如 1+3*3*6+8
                     *
                     * 当*号要入栈的时候
                     * 会把3*3这个拿出来计算
                     */
                    if (operStack.priority(c) <= operStack.priority(operStack.peak())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opers = operStack.pop();
                        result = numStack.cal(num1, num2, opers);
                        //把结果压入数栈
                        numStack.push(result);
                        //把当前的操作符压入符号栈
                        operStack.push(c);
                    } else {
                        operStack.push(c);
                    }
                } else {
                    //为空直接入栈
                    operStack.push(c);
                }
                flag = false;
            } else {
                //保证数字是多位的
                if(flag){
                    int a = numStack.pop();
                    int cur = c - 48;
                    String num =  a+""+cur;

                    numStack.push(Integer.parseInt(num));
                }else{
                    numStack.push(c - 48);

                }
                flag = true;
            }
            index++;
            if (expression.length() == index) {
                break;
            }
        }

        System.out.println("开始计算结果了~~~~");
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();

            opers = operStack.pop();

            result = numStack.cal(num1, num2, opers);
            numStack.push(result);

        }

        System.out.println("计算结果为：" + result);

    }

}


class ArrayStack2 {
    //栈的大小
    private int maxSize;
    //数组，数组模拟栈，数据就放在该数组
    private int[] stack;
    // top标识栈顶，初始化为-1
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        //先判断栈是否满了
        if (isFull()) {
            System.out.println("满了");
            return;
        }
        top++;
        stack[top] = value;


    }

    //出栈-peak,将栈顶的数据返回,但不弹出栈
    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    //出栈-pop,将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，遍历时需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("statck[%d]\n = %d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是人来定的，优先级使用数字表示
    //数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '/':
                result = num2 + num1;
                break;
        }
        return result;
    }


}