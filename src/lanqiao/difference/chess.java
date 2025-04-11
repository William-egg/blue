package lanqiao.difference;

import java.util.Scanner;

/**
 * https://www.lanqiao.cn/problems/3533/learning/
 *
 * 你要明白，求差分数组的前缀和才是原数组
 * 一般方法可以用0直接insert变化的值，最后再求与原数组的差距数组，再相加
 * 或者由原数组直接构造差分数组，最后直接求前缀和就可以。
 *
 * */


public class chess {
    static int[][] pan;
    public static void insert(int x1,int y1,int x2,int y2,int c){
        pan[x1][y1] += c;
        pan[x1][y2+1] -= c;
        pan[x2+1][y1] -= c;
        pan[x2+1][y2+1] += c;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        pan = new int[n+2][n+2];
        while(m-->0){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            insert(x1,y1,x2,y2,1);
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                pan[i][j] = pan[i-1][j]+pan[i][j-1]-pan[i-1][j-1]+pan[i][j];
                System.out.print(pan[i][j] % 2);
            }
            System.out.println();
        }
        scan.close();
    }
}