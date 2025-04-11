package _2023_14;

import java.util.*;
import utilts.myUtilts;
public class H_sun {

//    public static void solve_1(){
//        Scanner scanner = new Scanner(System.in);
//        boolean[] visited = new boolean[(int) (1e7+1)];
//        int n = scanner.nextInt();
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        Queue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
//        while(n-->0){
//            queue.offer(new int[]{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()});
//        }
//        int res = 0;
//        while(!queue.isEmpty()){
//            int[] tmp = queue.poll();
//            boolean flag = true;
//            for(int i = 1;i<=tmp[2];i++) {
//                if(!visited[i+tmp[0]]){
//                    if(flag) {
//                        res++;
//                        flag = !flag;
//                    }
//                    visited[i+tmp[0]] = true;
//                }
//            }
//        }
//        System.out.println(res);
//    }//未考虑斜率

    static boolean[] visited;
    public static void solve2(){
//        String s = "";
//        s.length()
//        myUtilts.quickPowMod()
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int xsun = scanner.nextInt();
        int ysun = scanner.nextInt();
        List<int[]> mubanList = new ArrayList<>();

        for(int i = 1;i<=n;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int l = scanner.nextInt();
            mubanList.add(new int[]{x-xsun,ysun-y,i});
            mubanList.add(new int[]{x-xsun+l,ysun-y,-i});

        }
        Collections.sort(mubanList,(a,b)->{
            long cross1 = (long) b[1] * a[0];
            long cross2 = (long) b[0] * a[1];
            if(cross1 == cross2) return b[2] - a[2];
            return Long.compare(cross1, cross2);
        });

        TreeSet<int[]> set = new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });

        visited = new boolean[n+1];

        int[] last = {-1,0,0};
        for(int[] tmp:mubanList){
            if((long)tmp[0]*last[1]!=(long)tmp[1]*last[0]){
                if(!set.isEmpty()) visited[set.first()[1]] = true;
                last = tmp;
            }
            if (tmp[2] > 0) set.add(new int[]{tmp[1], tmp[2]});
            else set.remove(new int[]{tmp[1], -tmp[2]});

        }

        if (!set.isEmpty()) {
            visited[set.first()[1]] = true;
        }
        int count = 0;
        for(boolean tmp:visited){
            if (tmp) count++;
        }
        System.out.print(count);
        scanner.close();
    }
    public static void solve3(){
//        utilts.myUtilts.quickPowMod();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int xsun = scanner.nextInt();
        int ysun = scanner.nextInt();

        List<int[]> mubanList = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int l = scanner.nextInt();
            mubanList.add(new int[]{x-xsun,ysun-y,i});
            mubanList.add(new int[]{x-xsun+l,ysun-y,-i});
        }




        Collections.sort(mubanList,(a,b)->{
            long cross1 =  (long)a[0]*b[1];
            long cross2 =(long) a[1]*b[0];
            return Long.compare(cross1,cross2);
        });
//
//
//        Collections.sort(mubanList,(a,b)->{
//            long cross1 = (long) b[1] * a[0];
//            long cross2 = (long) b[0] * a[1];
//            if(cross1 == cross2) return b[2] - a[2];
//            return Long.compare(cross1, cross2);
//        });









        TreeSet<int[]> set =new TreeSet<>((a,b)->{
            int dif = a[0]-b[0];
            if(dif == 0) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        visited = new boolean[n+1];
        int[] last = new int[]{-1,0,0};
        for(int[] tmp : mubanList){
            if((long)tmp[0]*last[1]!=(long)tmp[1]*last[0]){
                if(!set.isEmpty()) visited[set.first()[1]] = true;
                last = tmp;
            }
            if(tmp[2] > 0) set.add(new int[]{tmp[1],tmp[2]});
            else set.remove(new int[]{tmp[1], -tmp[2]});
        }
        if (!set.isEmpty()) {
            visited[set.first()[1]] = true;
        }
        int count = 0;
        for(boolean tmp:visited){
            if (tmp) count++;
        }
        System.out.print(count);
        scanner.close();
    }
    public static void solve4(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int xsun = scan.nextInt();
        int ysun = scan.nextInt();
        PriorityQueue<int[]> sq = new PriorityQueue<>((a,b)->{
            long cross1 = (long) a[0]*b[1];
            long cross2 = (long) a[1]*b[0];
            if(cross2 != cross1) return Long.compare(cross1 , cross2);
            else return  b[2] - a[2];
        });

        for(int i = 1;i<=n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int l = scan.nextInt();
            sq.add(new int[]{x-xsun,ysun - y,i});
            sq.add(new int[]{x-xsun+l,ysun - y,-i});
        }
        TreeSet<int[]> ts = new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        long count = 0;
        boolean[] visited = new boolean[n+1];
        int[] last = new int[]{-1,0,0};
        while(!sq.isEmpty()){
            int[] tmp = sq.poll();
            if((long)last[1]*tmp[0]!=(long)last[0]*tmp[1]){
                if(!ts.isEmpty()) visited[(ts.first()[1])] = true;
                last = tmp;
            }
            if(tmp[2] > 0) ts.add(new int[]{tmp[1],tmp[2]});
            else ts.remove(new int[]{tmp[1],-tmp[2]});
        }
        if (!ts.isEmpty()) {
            visited[ts.first()[1]] = true;
        }
        for(boolean v:visited){
            if(v) count++;
        }
        System.out.println(count);
        scan.close();
    }
    public static void main(String[] args) {
//        solve3();

    }
}