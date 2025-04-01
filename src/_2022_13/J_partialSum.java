package _2022_13;

import java.util.Scanner;


public class J_partialSum {
    static int[] p;
    static long[] dis;
    public static int find(int x){
        if(p[x] == x) return x;
        int root = find(p[x]);
        dis[x]+=dis[p[x]];
        p[x] = root;
        return root;
    }
    public static void union(int x,int y,long d){
        int rootX = find(x-1),rootY = find(y);
        if (rootX != rootY) {
            p[rootX] = rootY;
            dis[rootX] = d + dis[y] - dis[x-1];//因为是前缀和
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        dis = new long[n + 1];
        p = new int[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            long d = scanner.nextLong();
            union(x, y, d);
        }
        for(int i = 0;i<q;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (find(x-1) == find(y)) {
                System.out.println(dis[x-1] - dis[y]);//还是太粗心了。。。。
            }else System.out.println("UNKNOWN");
        }
        scanner.close();
    }
}
