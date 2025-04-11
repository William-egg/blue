package lanqiao.doubleBian;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 *https://www.lanqiao.cn/problems/17106/learning/
 *
 * 像
 *
 * */
public class hebing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] numsn = new int[n];
        int[] numsm = new int[m];
        for(int i = 0;i<n;i++){
            numsn[i] = scan.nextInt();
        }
        for(int i = 0;i<m;i++){
            numsm[i] = scan.nextInt();
        }
        scan.close();
        int i = 0,j = 0,count = 0;
        while(i<n && j<m){
            if(numsn[i] < numsm[j]){
                numsn[i+1] = numsn[i]+numsn[i+1];
                i++;
                count++;
            }else if(numsn[i] > numsm[j]){
                numsm[j+1] = numsm[j]+numsm[j+1];
                j++;
                count++;
            }else{
                i++;
                j++;
            }
        }
        System.out.print(count);
    }

}