import java.util.*;
import java.io.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class mycode {
    static int n,m;
    static int[] appleNums,preSum;
    public static int check(long x){
//        System.out.println(~1);
        long total = 0;
        int ans = 0;
        int last = 0;
        for(int i =1;i<n;i++){
            if(total + (long) appleNums[i] *(preSum[i]-preSum[last]) > x){
                ans++;
                total = 0;
                last = i+1;
            }else{
                total += (long) appleNums[i] *(preSum[i]-preSum[last]);
            }
        }
        return ans+1;
    }
    public static void main(String[] args) throws IOException {//一开始没有考虑非零的
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = br.readLine().split("\\s+");
        String[] line2 = br.readLine().split("\\s+");
        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line2[1]);
        appleNums = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();
        preSum = new int[n+1];
        preSum[1] = appleNums[0];
        for(int i = 2;i<=n;i++) preSum[i] = appleNums[i-1]+preSum[i-1];//前缀和前面要空一个位置出来

        long l = 1,r = Long.MAX_VALUE-1;
        while(l < r){
            long mid = (l+r)>>1;
            if(check(mid) > m) l = mid+1;
            else r = mid;
        }//什么时候要相等 什么时候不相等
        bw.write(String.valueOf(l));
        bw.flush();
        bw.close();
        br.close();
    }
}