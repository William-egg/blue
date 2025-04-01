package _2024_15;

import java.util.Scanner;

public class D_shop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] op = new int[m+1][2];
        int[] nums = new int[n+2];
        int[] afterNUm = new int[n+1];

        for(int i = 1;i<=m;i++) {
            op[i][0] = scan.nextInt();
            op[i][1] = scan.nextInt();
            nums[op[i][0]] += 1;
            nums[op[i][1]+1] -= 1;
        }
        scan.close();
        for(int i = 1;i<=n;i++){
            afterNUm[i] = afterNUm[i-1]+nums[i];
        }
        int count = 0;
        for(int i = 1;i<=n;i++){
            if(afterNUm[i] == 0) count++;
        }
        for(int i = 1;i<=m;i++){
            int tmpCount = count;
            for(int j = op[i][0];j<=op[i][1];j++){
                if(afterNUm[j] == 1) tmpCount++;
            }
            System.out.println(tmpCount);
        }
    }
}
