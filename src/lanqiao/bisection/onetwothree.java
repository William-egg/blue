package lanqiao.bisection;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class onetwothree {
    static int N =(int)1e6;
    static long[] pre;
    public static long getPos(long mid){
        return (mid+1)*mid/2;
    }
    public static long getPre(long n){
        if(n == 0) return 0;
        long l = 1,r=N;
        while(l<r){
            long mid = (l+r+1)/2;
            if(getPos(mid) > n) r = mid-1;
            else l = mid;
        }
        return pre[(int)l]+getPos(n-getPos(l));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int t = scan.nextInt();
        pre = new long[N+1];
        long j = 0;
        for(int i = 1;i<N+1;i++){
            j = j+i;
            pre[i] = pre[i-1]+j;
        }
        while(t-->0){
            long l = scan.nextLong();
            long r = scan.nextLong();
            System.out.println(getPre(r)-getPre(l-1));
        }
        scan.close();
    }
}