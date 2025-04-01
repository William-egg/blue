package _2022_13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
class node{
    int value;
    int lessTime;
}
public class H_Skill_upgrade {
    static int[] ai;
    static int[] bi;
    static int n,m;
    public static long mysum(int first,int howmuch,int d){
        int last = first-(howmuch-1)*d;
        return (long)(first+last)*howmuch/2;
    }
    public static boolean check(int mid){
        long res = 0;
        for(int i = 0;i<n;i++){
            if(ai[i]>mid) res += Math.ceil((double)(ai[i]-mid)/bi[i]);
        }
        return res<=m;
    }
    public static void fistTryUseTreeSet(){//这种方法会超时
        Scanner scanner = new Scanner(System.in);
        TreeSet<node> set = new TreeSet<>((a,b)->{
            if (a.value == b.value) {
                return a.lessTime - b.lessTime;
            }else return a.value - b.value;
        });
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i = 0;i<n;i++){
            node node = new node();
            node.value = scanner.nextInt();
            node.lessTime = scanner.nextInt();
            set.add(node);
        }
        long maxSum = 0;
        while(m-->0){
            node node = set.pollLast();
            maxSum+=node.value;
            node.value = (node.value - node.lessTime)>0?(node.value- node.lessTime) : 0;
            set.add(node);
        }
        System.out.println(maxSum);
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ai = new int[n];
        bi = new int[n];
        for(int i = 0;i<n;i++) {
            ai[i] = scanner.nextInt();
            bi[i] = scanner.nextInt();
        }
        int l = 0,r = (int) 1e6;
        while(l<r){//二分查找，自定义条件
            int mid = (l+r)>>1;
            if(check(mid)) r = mid;
            else l = mid+1;
        }
        long res = 0,times = 0;
        for(int i = 0;i<n;i++){
            if(ai[i]>l) {
                int now = (int) Math.ceil((double)(ai[i]-l)/bi[i]);
                times+=now;
                res += mysum(ai[i],now,bi[i]);
            }

        }
        System.out.print(res+(long)l*(m-times));
        scanner.close();
    }
}