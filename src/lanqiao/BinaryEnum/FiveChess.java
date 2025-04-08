package lanqiao.BinaryEnum;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class FiveChess {
    public static boolean check(int n){
        int a = 0,b = 0;
        for(int i = 0;i<25;i++){
            if(((n>>i)&1) == 1) a++;
            else b++;
        }
        if(a - b != 1) return false;
        for(int i = 0;i<5;i++){//lie
            int tmp = (n>>i)&1;
            boolean flag = false;
            for(int j = 1;j<5;j++){
                if(tmp != ((n>>(i+j*5))&1)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        for(int i = 0;i<5;i++){//hang
            int tmp = (n>>(i*5))&1;
            boolean flag = false;
            for(int j = 1;j<5;j++){
                if(tmp != ((n>>(i*5+j))&1)){
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        int k = (n>>0) &1;
        boolean f = false;
        for(int i = 0;i<5;i++){
            if(k != ((n>>(i*6))&1)){
                f = true;
                break;
            }
        }
        if(!f) return false;
        k = (n>>4) &1;
        f = false;
        for(int i = 0;i<5;i++){
            if(k != ((n>>(i*4))&1)){
                f = true;
                break;
            }
        }
        if(!f) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        long count = 0;
        for(int i = 0;i<(1<<25);i++){
            if(check(i)) count++;
        }
        System.out.print(count);
        scan.close();
    }
}