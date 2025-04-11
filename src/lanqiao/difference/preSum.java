package lanqiao.difference;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class preSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int[] nums = new int[n+1];
        int[] pre = new int[n+1];
        for(int i = 1;i<=n;i++){
            nums[i] = scan.nextInt();
            pre[i] = pre[i-1]+nums[i];
        }
        long count = 0;
        for(int i = 1;i<n;i++){
            count +=(long)nums[i]*(pre[n]-pre[i]);
        }
        System.out.print(count);
        scan.close();
    }
}