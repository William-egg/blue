package lanqiao.bisection;

import java.util.*;

public class ans{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] nums = new int[n+1];
        int[] pre = new int[n+1];
        for(int i = 1;i<=n;i++){
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        for(int i = 1;i<=n;i++){
            pre[i] = nums[i]+pre[i-1];
        }
        int l = 1,r = n;
        while(l<r){
            int mid = (l+r)>>1;
            if(nums[mid]*mid - pre[mid] >= k) r = mid;
            else l = mid+1;
        }
        System.out.print(((k-nums[l-1]*(l-1)+pre[l-1])/(l-1)) + nums[l-1]);
    }// 1  2  4  6  8
}