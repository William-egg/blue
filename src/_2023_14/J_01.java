package _2023_14;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class J_01  {
    static int sum = 0;
    public static String fillc(String s){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            sb.append('#');
            sb.append(s.charAt(i));
            if(s.charAt(i) == '1') sum++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] sc = fillc(s).toCharArray();
        int n = sc.length;
        scan.close();
        int l = 1,r = 1,i = 2;
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        while(i < n){
            if(i <= r) d[i] = Math.min(d[l+r-i],r-i+1);
            while(i+d[i]<n && i - d[i] >= 0 && sc[i+d[i]] == sc[i-d[i]]) d[i]++;
            if(i+d[i]-1>r) {
                l = i-d[i]+1;
                r = i+d[i]-1;
            }
            i++;
        }
        int max = -1,maxIndex = -1,maxValue = -1;
        for(int k = 1;k<n-1;k++){
            if(sc[k] == '1') continue;
            int cur = 0;
            if(sc[k] == '#'){
                cur = d[k]-d[k]%2;//1#1#1#1#1#1
            }else{
                cur = d[k]-(d[k]+1)%2;//1#1#1
            }//这里要记住这个事情
            maxValue = Math.max(maxValue,d[k]);
            if(cur > max){
                max = cur;
                maxIndex = k;
            }
        }
        int huiwen = 0;
        for(int k = maxIndex-max+1;k<=maxIndex+max-1;k++){
            if(sc[k] == '1') huiwen++;
        }
//        System.out.println(sum-huiwen/2);
        System.out.println(sum - maxValue/2);

    }
}