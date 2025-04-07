package lanqiao;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 * https://www.lanqiao.cn/problems/18441/learning/
 * 以下做法会超时
 * **/
public class opForBits {
    public static void op1(int n,int bits){
        System.out.println((n>>bits)&1);
    }
    public static void op2(int n,int l,int r){
        for(int i = l;i<=r;i++){
            if(((n>>i)&1) == 0){
                n = n|(1<<i);
            }else n = n&(~(1<<i));
        }
        System.out.println(n);
    }
    public static void op3(int n,int l,int r){
        for(int i = l;i<=r;i++){
            n = n | (1<<i);
        }
        System.out.println(n);
    }
    public static void op4(int n,int l,int r){
        for(int i = l;i<=r;i++){
            n = n & ~(1<<i);
        }
        System.out.println(n);
    }
    public static void op5(int n){
        int i = 0;
        while((n&1) == 0){
            i++;
            n = n >> 1;
        }
        System.out.println(1<<i);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        while(m-->0){
            int opNum = scan.nextInt();
            if(opNum == 1){
                op1(n,scan.nextInt());
            }else if(opNum == 2){
                op2(n,scan.nextInt(),scan.nextInt());
            }else if(opNum == 3) op3(n,scan.nextInt(),scan.nextInt());
            else if(opNum == 4) op4(n,scan.nextInt(),scan.nextInt());
            else op5(n);
        }
        scan.close();
    }
}