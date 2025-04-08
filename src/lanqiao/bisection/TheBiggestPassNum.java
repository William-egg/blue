package lanqiao.bisection;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 * https://www.lanqiao.cn/problems/3346/learning/
 *
 * */
public class TheBiggestPassNum {
    public static long[] prea,preb;
    public static int n,m;
    public static long getSmallk(int mid){
        int i = Math.min(n,mid);
        int j = mid - i;
        long minK = prea[i]+preb[j];
        while(i>=1&&j<=m){
            minK = Math.min(minK,prea[i--]+preb[j++]);
        }
        return minK;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        n = scan.nextInt();
        m = scan.nextInt();
        long k = scan.nextLong();
        prea = new long[n+1];
        preb = new long[m+1];
        for(int i =1;i<=n;i++){
            prea[i] = prea[i-1]+scan.nextLong();
        }
        for(int i = 1;i<=m;i++){
            preb[i] = preb[i-1]+scan.nextLong();
        }
        int l = 1,r = n+m;
        while(l<r){
            int mid = (l+r+1)>>1;
            if(getSmallk(mid) > k) r = mid-1;
            else l = mid;
        }
        System.out.println(l);
        scan.close();
    }
}