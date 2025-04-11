package lanqiao.bisection;

import java.io.*;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 * https://www.lanqiao.cn/problems/2145/learning/
 *这个题的重点是，要怎么求出有多少个五
 * */
public class howManyZero {
    public static long calc(long n){
        long res = 0;
        while(n!=0){
            res += n/5;
            n /= 5;
        }
        return res;
//        Arrays.sor
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long k = Long.parseLong(br.readLine());
        long l = 1,r = Long.MAX_VALUE-1;
        long minOne = -1;
        while(l<=r){
            long mid = (l+r)>>1;
            long res = calc(mid);
            if(res >= k) {
                if(res == k) minOne = mid;
                r = mid -1;
            }
            else l = mid +1;
        }
        if(minOne!=-1){
            bw.write(String.valueOf(minOne));
        }else{
            bw.write(String.valueOf(-1));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}