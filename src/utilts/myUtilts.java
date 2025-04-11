package utilts;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class myUtilts {
    public static long quickPowMod(long a, long b, long mod) {//快速幂取模
        long res = 1;
        while(a != 0){
            if((b & 1) == 1) res = res*a%mod;
            a = a*a%mod;
            b >>= 1;
        }
        return res;
    }//费马小定理

    public static long gcd(long a, long b) {//最大公约数
        return b == 0 ? a : gcd(b, a%b);
    }
    public static long lcm(long a, long b) {//最小公倍数
        return a*b/gcd(a, b);
    }
    public static void quickInOut() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] lines = line.split("\\s+");
        String tmp = "123456";
        String[] tmps = tmp.split("");
        bw.write(Arrays.toString(tmps));
        bw.flush();
        br.close();
        bw.close();
    }
    public static void jinZhi(){
        int a = Integer.parseInt("1010", 2);//转成十进制
        String b = Integer.toString(10,2);//转成其他进制
    }

    public static long calc(long n){
        long res = 0;
        while(n!=0){
            res = res+n/5;
            n = n/5;
        }
        return res;
    }
    public static void arrayToNums(){

    }
    public static void tryFun(int x){
        x = 3;
    }
    public static void main(String[] args) throws IOException {
        int[] nums = new int[5];
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));
    }
}
