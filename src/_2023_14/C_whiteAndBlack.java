package _2023_14;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class C_whiteAndBlack {
    public static void baoli() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[][] pan = new boolean[n+1][n+1];//false == white
        while(m-->0){
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for(int i = x1;i<=x2;i++){
                for(int j = y1;j<=y2;j++) pan[i][j] = !pan[i][j];
            }
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(pan[i][j]) bw.write('1');
                else bw.write('0');//改成bw就可以全部通过了...以后遇到这种可能要大量输出的直接用这个...
//                bw.write((pan[i][j] ? 1 : 0));
            }
            bw.newLine();
        }
        bw.flush();
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        baoli();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        long[][] pan = new long[2002][2002];
//        while(m-->0){
//            int x1 = scanner.nextInt();
//            int y1 = scanner.nextInt();
//            int x2 = scanner.nextInt();
//            int y2 = scanner.nextInt();
//            pan[x1][y1]+=1;
//            pan[x1][y2+1] -= 1;
//            pan[x2+1][y1] -= 1;
//            pan[x2+1][y2+1] += 1;
//        }
//        for(int i = 1;i<=n;i++){
//            for(int j = 1;j<=n;j++){
//                pan[i][j] = pan[i-1][j]+pan[i][j-1]-pan[i-1][j-1]+pan[i][j];
//                System.out.print(pan[i][j]&1);
//            }
//            System.out.println();
//        }
    }
}
