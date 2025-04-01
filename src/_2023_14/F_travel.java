package _2023_14;

import java.util.Scanner;
import java.util.TreeSet;

public class F_travel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeSet<int[]> set = new TreeSet<>((a, b)->{
            if(a[1]!=b[1]) return a[1] - b[1];
            else if(a[2]!=b[2]) return b[2] - a[2];
            else return a[0] - b[0];
        });
        int leftyou = m;
        int[][] position = new int[n+1][3];
        long cost = 0;
        for(int i = 1;i<=n;i++){
            position[i][0] = scanner.nextInt();//消耗
            position[i][1] = scanner.nextInt();//加油价格
            position[i][2] = scanner.nextInt();//最多加油量
            if(leftyou > position[i][0]) {
                leftyou -= position[i][0];
            }else{
                while(leftyou<position[i][0]){
                    if(set.isEmpty()) {
                        System.out.print(-1);
                        return;
                    }
                    int[] tmp = set.first();
                    set.remove(tmp);
                    int minOne = Math.min((position[i][0]-leftyou),tmp[2]);
                    cost += (long) minOne*tmp[1];
                    leftyou += minOne;
                    if(tmp[2] > minOne) set.add(new int[]{tmp[0],tmp[1],tmp[2]-minOne});
                }
                leftyou -= position[i][0];
            }
            set.add(new int[]{i,position[i][1],position[i][2]});

        }
        System.out.print(cost);
    }
}