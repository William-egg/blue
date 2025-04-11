package lanqiao.bagQuestion;

import java.util.Scanner;
import java.io.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class bag2 {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] bag = new int[m+1];
        for(int i = 1;i<=n;i++)
        {
            String[] next = br.readLine().split("\\s+");
            int vi = Integer.parseInt(next[0]);
            int wi = Integer.parseInt(next[1]);
            int ci = Integer.parseInt(next[2]);
            for(int j = m;j>=1;j--){
                int tmp = 0;
                for(int k = 0;k<=j/vi;k++)
                {
                    if(j - vi*k>=0 && k <= ci)
                        tmp = Math.max(tmp,wi*k+bag[j-vi*k]);
                    else break;
                }
                bag[j] = tmp;
            }
        }
        bw.write(bag[m]);
        bw.flush();
        br.close();
        bw.close();
        scan.close();
    }
}
