import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class mycode  {
    // public static pan;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int t = scan.nextInt();
//        int biggest = (int)1e9;
        int biggest = 100;
        int[][] pan = new int[2][biggest];
        pan[0][0] = 0;
        pan[0][1] = 1;
        pan[1][0] = 1;
        pan[1][1] = 2;
        for(int j = 2;j<biggest;j++){
            for(int i = 0;i<2;i++){
                if(i == 0) pan[i][j] = (pan[i][j-1]+pan[1][j-1])% 1000000007;
                else pan[i][j] = (pan[0][j]+pan[i][j-1])% 1000000007;
            }
        }
        while(t-->0){
            int n = scan.nextInt();
            System.out.println(pan[1][n-1]);
        }
        scan.close();
    }
}