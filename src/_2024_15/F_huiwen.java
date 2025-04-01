package _2024_15;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class F_huiwen  {
    public static boolean ishuiwen(String s){
        int l = 0,r = s.length()-1;
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        while(n-->0){
            String s = scan.next();
            int l = 0,r = s.length()-1;
            char[] sc = s.toCharArray();
            while(l < sc.length && (sc[l] == 'l'||sc[l] == 'q'||sc[l] == 'b')) l++;
            while(r>=0 && (sc[r] == 'l'||sc[r] == 'q'||sc[r] == 'b')) r--;//这个逻辑判断不要失误！！！
             int ltmp = l,rtmp = r;
            if(l>=sc.length||r<0) {
                System.out.println("Yes");
                continue;
            }
            while(--l >= 0 && ++r < sc.length && sc[l] == sc[r]);
            if(l >= 0) System.out.println("No");
            else{
                if(ishuiwen(s.substring(ltmp,rtmp+1))) System.out.println("Yes");
                else System.out.println("No");
            }
        }
        scan.close();
    }
}