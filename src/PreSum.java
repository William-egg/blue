import java.io.*;
import java.util.*;

public class PreSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = br.readLine().split("\\s+");
        int[] sortedNums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int n = Integer.parseInt(line1[0]),k = Integer.parseInt(line1[1]);
        int l = 0,r = n-1;
        long preSum = 0;//1 2 4 6 8
        for(int i = 0;i< n; i++) {
            preSum += sortedNums[i];
            if(preSum +k <= sortedNums[i] * (i+1)) {
                if(i == 0) bw.write(sortedNums[0]);
                else{
                    bw.write(String.valueOf( (sortedNums[i - 1]+(k-(sortedNums[i-1]*i-(preSum-sortedNums[i])))/(i))));
                }// 4 +(10-(4*3-(13-6))/(2))
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}