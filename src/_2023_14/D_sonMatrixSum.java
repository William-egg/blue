package _2023_14;
import java.util.Arrays;
import java.util.Scanner;

public class D_sonMatrixSum {
    static int mod =998244353;
    static int n,m,a,b;
    static int[][] nums;
    public static void getMinAndMax(int x1,int y1,int x2,int y2,long[] mm){
        for(int i = x1;i<=x2;i++){
            for(int j = y1;j<=y2;j++){
                if(mm[0] > nums[i][j]) mm[0] = nums[i][j];
                if(mm[1] < nums[i][j]) mm[1] = nums[i][j];
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        nums = new int[n][m];
        long sum = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++) nums[i][j] = scanner.nextInt();
        }
        for(int i = 0;i+a-1<n;i++){
            for(int j = 0;j+b-1<m;j++){
                long[] mm = {(long) (1e9+10), 0};
                getMinAndMax(i,j,i+a-1,j+b-1,mm);
                sum +=  mm[1]*mm[0] ;
                sum = sum%mod;//不可以模后再加，而是应该先加，再取模
            }
        }

        System.out.print(sum);
    }
}