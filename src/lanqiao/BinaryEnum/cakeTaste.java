package lanqiao.BinaryEnum;

import java.util.Scanner;

public class cakeTaste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n];
//        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        long count = 0;
        for(int i = 0;i<(1<<n);i++){
            long tmpCount = 0;
            for(int j = 0; j < n; j++) {
                if(((i>>j)&1) == 1){
                    tmpCount += a[j];
                    if(tmpCount >= k) break;
                }
            }
            count  = tmpCount >= k? count :Math.max(count, tmpCount);
        }
        System.out.println(count);
    }
}
