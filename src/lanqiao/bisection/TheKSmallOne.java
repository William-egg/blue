package lanqiao.bisection;

import java.util.Arrays;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class TheKSmallOne {
    public static int n,m;
    public static long k;
    public static int[] a,b;
    public static long getMany(int i,long midNum){
        int l = 0,r = m-1;
        while(l<r){
            int mid = l+((r-l+1)>>1);
            if(a[i]+b[mid] > midNum) r = mid - 1;
            else l = mid;
        }
        return a[i]+b[l] == midNum?(long)l+1:(long)l;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextLong();
        a = new int[n];
        b = new int[m];
        int[] c = new int[n*m];
        for(int i = 0;i<n;i++) a[i] = scan.nextInt();
        for(int i = 0;i<m;i++) b[i] = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i * m + j] = a[i] + b[j];
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long l = a[0]+b[0],r =a[n-1]+b[m-1];
        while(l<r){
            long mid = l+((r-l)>>1);
            long sumSmaller = 0;
            for(int i = 0;i<n;i++){
                if(a[i] > mid) break;
                sumSmaller += getMany(i,mid);//得到b数组中跟a[i]相加小于mid的个数
            }
            if(sumSmaller >= k) r = mid;
            else l = mid + 1;
        }
        System.out.println(l);
        scan.close();
    }
}