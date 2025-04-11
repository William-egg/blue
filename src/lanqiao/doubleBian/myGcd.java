package lanqiao.doubleBian;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class myGcd {
    public static int[] nums;
    public static int n,g;
    public static int gcd(int a,int b){
        return b == 0?a:gcd(b,a%b);
    }
    public static int gcdNums(int l,int r,int except){
        int tmp = (l == except?nums[l+1]:nums[l]);
        for(int i = l;i<=r;i++){
            if(i == except) continue;
            tmp = gcd(nums[i],tmp);
            if(tmp == 1) return 1;
        }
        return tmp;
    }
    public static void  solve1(){//这种解决方法会超时
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int g = scan.nextInt();
        for(int i = 0;i<n;i++) nums[i] = scan.nextInt();
        scan.close();
        long count = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                for(int k = i-1;k<=j;k++){
                    if(gcdNums(i,j,k)%g == 0){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int g = scan.nextInt();
        nums = new int[n];
        for(int i = 0;i<n;i++) nums[i] = scan.nextInt();
        scan.close();
        long count = 0;
        int l = 0,last = -1,r = 0;
        while(r<n){
            if(nums[r]%g!=0){
                l = last+1;
                last = r;
            }
            if(r - l +1>=2){
                count +=  r-l;
            }
            r++;
        }
        System.out.print(count);//要用这种不回头的方法。
    }
}
