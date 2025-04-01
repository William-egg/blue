package _2023_14;

import java.util.Scanner;

public class E_huzhi {
    static int mod = 998244353;
    public static long fp(long a,long b){
        long res = 1;
        a %= mod;
        while(b>0){
            if((b&1) == 1) res=(res*a)%mod;
            a=(a*a)%mod;
            b>>=1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long res = fp(a,b);
        long n = res;
        for(int i = 2;i*i<n;i++){
            if(n%i == 0){
                res = res/i*(i-1);
                while(n%i == 0) n/=i;
            }
        }
        if(n>1) res = res/n*(n-1);
        System.out.println(res);
        scanner.close();
    }
}
