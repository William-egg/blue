package lanqiao.bingchaji;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
//带权并查集
public class NumsOfNode {
    public static int N = (int)1e5+10;
    public static int[] bingcha;
    public static int[] numsNode;
    public static void union(int x,int y){
        int fax = find(x),fay = find(y);
        if(fax != fay){
            bingcha[fay] = fax;
            numsNode[fax] = numsNode[fax]+numsNode[fay];
        }
    }
    public static int find(int x){
        int fa = bingcha[x];
        if(fa != x){
            fa = find(fa);
            bingcha[x] = fa;
            numsNode[x] = numsNode[fa];
        }
        return fa;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        (find(scan.nextInt()) == find(scan.nextInt()))?System.out.println("Yes"):System.out.println("No");
        //在此输入您的代码...
        int n = scan.nextInt();
        int m = scan.nextInt();
        bingcha = new int[n+1];
        numsNode = new int[n+1];
        for(int i = 0;i<=n;i++) {
            bingcha[i] = i;
            numsNode[i] = 1;
        }
        while(m-->0){
            String op = scan.next();
            if(op.equals("C")){
                union(scan.nextInt(),scan.nextInt());
            }else if(op.equals("Q1")){
                if(find(scan.nextInt()) == find(scan.nextInt())) System.out.println("Yes");
                else System.out.println("No");
            }else {
                System.out.println(numsNode[find(scan.nextInt())]);
            }
        }
        scan.close();
    }
}