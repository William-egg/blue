package _2023_14;

public class B_01door {
    static int[][] a = new int[5][5];
    static int count = 0;
    public static int afterop(int a1,int a2,int op){//与 或 异或
        if(op == 1){
            return a1 & a2;
        }else if(op == 2){
            return a1 | a2;
        }else {
            return a1 ^ a2;
        }
    }
    public static  void  dfs(int floor,int lie){
        if (floor == 4) {
            for(int i = 1;i<=3;i++) count += afterop(a[floor-1][lie],a[floor-1][lie+1],i);
            return;
        }
        for(int i = 1;i<=3;i++){
            a[floor][lie] = afterop(a[floor - 1][lie], a[floor - 1][lie + 1], i);
            if(lie == 5-floor-1) dfs(floor+1,0);
            else dfs(floor,lie+1);
        }
    }
    public static void main(String[] args) {
        for(int i = 0;i< 5; i++) {
            a[0][i] = (i+1)%2;
        }
        dfs(1,0);
        System.out.println(count);
    }
}
