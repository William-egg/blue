package _2022_13;

import java.util.*;

public class G_sortedAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        long[] visited = new long[n];
        long sumBefore = 0,sumAfter = 0;
        for(int i = 0;i<n;i++) a[i] = scanner.nextInt();
        int m = scanner.nextInt();
        while(m-->0){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            for(int i = l -1;i<r;i++) {
                sumBefore += a[i];
                visited[i]++;
            }
        }
        Arrays.sort(visited);
        Arrays.sort(a);
        for(int i = n-1;i>=0&&visited[i]>0;i--){
            sumAfter += visited[i]*a[i];
        }
        System.out.println(sumAfter - sumBefore);
        scanner.close();
    }
}