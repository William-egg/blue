import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G_biggestOne2 {
    static int n,numsIndex = 0;
    static int[] nums,nodeNums;
    static int[][] son;
    static List<Integer>[] link;
    public static void insert(int index){
        int o = 0;
        for(int i = 30;i>=0;i--){
            nodeNums[o]++;
            int y = (nums[index]>>i)&1;
            if(son[o][y] == 0){
                son[o][y] = ++numsIndex;
            }
            o = son[o][y];
        }
    }
    public static int query(int index){
        int o = 0;
        int res = 0;
        for(int i = 30;i>=0;i--){
            int y = (nums[index]>>i)&1;
            if(nodeNums[son[o][y^1]] > 0&&son[o][y^1] != 0){
                res += 1<<i;
                o = son[o][y^1];
            }else{
                o = son[o][y];
            }
        }
        return res;
    }
    public static void remove(int index){
        int o = 0;
        for(int i = 30;i>=0;i--){
            nodeNums[o]--;
            int y = (nums[index]>>i)&1;
            o = son[o][y];
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //这里等下看一下printWrite跟他的区别
        n = scan.nextInt();
        son = new int[n*30][2];
        nums = new int[n];
        nodeNums = new int[n*30];
        link = new ArrayList[n];
        for(int i = 0;i<n;i++){
            nums[i] = scan.nextInt();
            insert(i);
            link[i] = new ArrayList<>();
        }
        for(int i = 0;i<n;i++){
            int fa = scan.nextInt();
            if(fa != -1){
                link[fa].add(i);
                link[i].add(fa);
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for(int tmpIndex:link[i]){
                remove(tmpIndex);
            }
            res = Math.max(res,query(i));
            for(int tmpIndex:link[i]){
                insert(tmpIndex);
            }
        }
        System.out.println(res);
        scan.close();
    }
}
