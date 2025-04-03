package utilts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = br.readLine().split("\\s+");
        int[] sortedNums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        bw.write(Arrays.toString(sortedNums));
        bw.flush();
        bw.close();
        br.close();
    }
}
