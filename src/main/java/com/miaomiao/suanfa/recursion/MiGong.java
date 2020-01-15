package com.miaomiao.suanfa.recursion;

/**
 * ■ ■ ■ ■ ■ ■ ■
 * ■ □ □ □ □ □ ■
 * ■ □ □ □ □ □ ■
 * ■ ■ ■ □ □ □ ■
 * ■ □ □ □ □ □ ■
 * ■ □ □ □ □ □ ■
 * ■ □ □ □ □ □ ■
 * ■ ■ ■ ■ ■ ■ ■
 *
 */
public class MiGong {

    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫地图
        int [] [] map = new int[8][7];
        //使用1标识墙
        //上下全部置为 1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }

        //左右全部置为 1
        for (int i = 0; i <8 ; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;


        System.out.println("地图的情况");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(map,1,1);

        System.out.println("小球找路的情况");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     *
     * 使用递归回溯来给小球找路
     * 说明
     * 1.map 标识地图
     * 2.i,j标识从地图的那个位置开始出发
     * 如果小球能到map[6][5]位置，则说明通路找到
     * 约定：当map[i][j]为0标识该点没有走过，当为1表示墙，2表示通路可以走，3表示该点已经走过，但是走不通
     * 在走迷宫时需要确定一个策略  下 -> 右 -> 上 -> 左 如果该点走不通，再回溯
     *
     * @param map 表示地图
     * @param i  从哪个位置开始找
     * @param j
     * @return  如果找到桐庐，就返回true，否则返回false
     */
    public static boolean setWay(int[][]map,int i,int j){
        //通路已经找到了
        if(map[6][5]==2){
            return true;
        }else {
            //如果该点没有走过
            if(map[i][j] == 0){
                 //按照 下 -> 右 -> 上 -> 左  走
                //假定该点是可以走通的
                map[i][j] = 2;

                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if(setWay(map, i , j+1)){//向右走
                    return true;
                }else if(setWay(map, i-1 , j)){//向上走
                    return true;
                }else if(setWay(map, i , j-1)){//向左走
                    return true;
                }else{
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }

            }else{ //如果 map[i][j] !=0 ,可能是1，2，3
                return false;
            }
        }



    }

}
