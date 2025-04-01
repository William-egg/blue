//package _2023_14;
//
//import java.util.Scanner;
//
//
//
//public class G_stragenum {
//    static int[] nums;
//    static int n,m;
//    static int count;
//    public static void dfs(int index){
//        int i = (int) 1e9;
//        if(index > n) {
//            for(int i = 1;i+4<=n;i++){
//                int sum = 0;
//                for(int j = 0;j<5;j++){
//                    sum += nums[i+j];
//                    if(sum > m) {
//                        return;
//                    }
//                }
//            }
//            count = (count+1)%998244353;
//            return;
//        }
//        while(nums[index]<=9){
//            dfs(index+1);
//            nums[index] += 2;
//        }
//        nums[index] = index%2;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        nums = new int[n+1];
//        for(int i = 1;i<=n;i++){
//            nums[i] = i%2;
//        }
//        dfs(1);
//        System.out.println(count);
//    }
//}