package lanqiao;

import java.util.Scanner;
import java.io.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class qiuZuHe {
    public static long[] fact = new long[(int)1e7+1];
    public static long[] inv_fact = new long[(int)1e7+1];
    public static int mod = (int)1e9+7,n = (int)1e7;
    public static long quickPow(long a,long b){
        long res = 1;
        while(b != 0){
            if((b&1) == 1) res = res*a%mod;
            a = a*a%mod;
            b >>= 1;
        }
        return res;
    }
    public static void preProceed(){
        fact[0] = 1;
        for(int i = 1;i<=n;i++){
            fact[i] = fact[i-1]*i%mod;
        }
        inv_fact[n] = quickPow(fact[n],mod-2);
        for(int i = n-1;i>=0;i--){
            inv_fact[i] = inv_fact[i+1]*(i+1)%mod;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int q = scan.nextInt();
        preProceed();
        while(q-->0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            long res = fact[a] * inv_fact[b]%mod;
            res = res*inv_fact[a-b]%mod;
            System.out.println(res);
        }
        scan.close();
    }
}