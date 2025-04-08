package lanqiao.bisection;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 * https://www.lanqiao.cn/problems/18492/learning/
 * 四个二分算法
 * **/
public class FindInteger {
    public static int[] nums;
    static int n;
    public static void op1(int l,int r,int x){
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid]>=x) r = mid;//如果相等要让右边界往中心走
            else l = mid+1;
        }
        if(nums[l] == x) System.out.println(l);
        else System.out.println(-1);
    }
    public static void op2(int l,int r,int x){
        while(l < r){
            int mid = (l+r+1)>>1;
            if(nums[mid]>x) r = mid-1;
            else l = mid;//如果相等要让左边界往中间走
        }
        if(nums[l] == x) System.out.println(l);
        else System.out.println(-1);
    }
    public static void op3(int l,int r,int x){
//        if(nums[r] < x) System.out.println(-1);
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid]>=x) r = mid;
            else l = mid+1;
        }
        System.out.println(nums[l]>=x?l:-1);
    }
    public static void op4(int l,int r,int x){
//        if(nums[r] < x) System.out.println(-1);
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid]>x) r = mid;
            else l = mid+1;
        }
//        while(nums[l]<=x) l++;
        System.out.println(nums[l] > x ? l : -1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
//        n = scan.nextInt();
//        int q = scan.nextInt();
        nums = new int[]{0,1, 2, 2, 2, 4, 5};
        op4(1,5,2);
        scan.close();
    }
}