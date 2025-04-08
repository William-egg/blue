package lanqiao.bisection;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class futureFindInteger {
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
        if(nums[r] < x) {
            System.out.println(-1);
            return;
        }
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid]>=x) r = mid;
            else l = mid+1;
        }
        System.out.println(l);
    }
    public static void op4(int l,int r,int x){
        if(nums[r] < x) {
            System.out.println(-1);
            return;
        }
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid]>x) r = mid;
            else l = mid+1;
        }
//        while(nums[l]<=x) l++;
        System.out.println(l);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        n = scan.nextInt();
        int q = scan.nextInt();
        nums = new int[n+1];
        for(int i = 1;i<=n;i++){
            nums[i] = scan.nextInt();
        }
        while(q-->0){
            int opNum = scan.nextInt();
            if(opNum == 1) op1(scan.nextInt(),scan.nextInt(),scan.nextInt());
            else if(opNum == 2) op2(scan.nextInt(),scan.nextInt(),scan.nextInt());
            else if(opNum == 3) op3(scan.nextInt(),scan.nextInt(),scan.nextInt());
            if(opNum == 4) op4(scan.nextInt(),scan.nextInt(),scan.nextInt());
        }
        scan.close();
    }
}