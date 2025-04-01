package _2022_13;//这个东西不要加老弟

import java.util.Arrays;
import java.util.Scanner;

public class E_K_becameZero {
    public static int getLastZero(int[] a,int i,int j){
        int last = -1;
        for (int k = i; k <= j; k++){
            if(a[k] == 0) {
                last = k;
            }
        }
        return last;//最后一个为0的位置
    }
    public static int getMin(int[] a,int i,int j){
        int min = i;
        for (int k = i; k <= j; k++) {
            if(a[min] > a[k]) {
                min = k;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long res = 0;
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int i = 0;
        while(i<=n-k){
            int last = getLastZero(a, i, i + k - 1);
            if (last == -1) {
                int min = a[getMin(a, i, i + k - 1)];
                for(int l = i;l<i+k;l++){
                    a[l] -= min;
                }
                res += min;
                i++;
            }else{
                i = last+1;
            }
        }
        for(int l = 0;l < n;l++){
            res+=a[l];
        }

        scanner.close();
        System.out.println(res);
    }
}
