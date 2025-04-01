package _2024_15;

import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class G_theBiggestOne  {
    static int res = -1;
    static node[] nodes;
    public static class node{
        public int value;
        public int fa;
        public  Set<Integer> son = new HashSet<>();
        public node(int value){
            this.value = value;
        }

    }
    public static void getMax(int index,int n){
        if(index >= n){
            return;
        }
        for(int i = 0;i<n;i++){
            if(i == index||i == nodes[index].fa||nodes[index].son.contains(i)) continue;
            res = Math.max(res,nodes[i].value ^ nodes[index].value);
        }
        getMax(index+1,n);
    }
    public static void solve1(){
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        nodes = new node[n];
        for(int i = 0;i<n;i++){
            nodes[i] = new node(scan.nextInt());
        }
        for(int i = 0;i<n;i++){
            nodes[i].fa = scan.nextInt();
            if(nodes[i].fa != -1) nodes[nodes[i].fa].son.add(i);
        }
        getMax(0,n);
        System.out.println(res);
        scan.close();
    }



    static int n,numsIndex = 0;
    static Set<Integer>[] link;
    static int[] values;
    static class node2{
        int value;
        Set<Integer> nodeIndex = new HashSet<>();
    }
    static node2[][] node2s;
    public static void insert(int index){
        int  o = 0;
        for(int  i = 30;i>=0;i--){
            int y  = (values[index]>>i)&1;
            if(node2s[o][y] == null){
                node2s[o][y] = new node2();
                node2s[o][y].value = ++numsIndex;
                node2s[o][y].nodeIndex.add(index);
            }
            node2s[o][y].nodeIndex.add(index);
            o = node2s[o][y].value;
        }

    }
    public static boolean noLinked(Set<Integer> set,int index){
        for(int i : set){
            if(!link[index].contains(i)) return true;
        }
        return false;
    }
    public static int query(int index){
        int o = 0,res = 0;
        for(int i = 30;i>=0;i--){
            int y = (values[index]>>i)&1;
            if(node2s[o][y^1] != null&&noLinked(node2s[o][y^1].nodeIndex,index)){
                res += 1<<i;
                o = node2s[o][y^1].value;
            }else{
                o = node2s[o][y].value;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //这里等下看一下printWrite跟他的区别
        n = scan.nextInt();
        values = new int[n];
        link = new HashSet[n];
        node2s = new node2[n*30][2];
        for(int i = 0;i<n;i++){
            values[i] = scan.nextInt();
            insert(i);
            link[i] = new HashSet<>();
        }
        for(int i = 0;i<n;i++){
            int fa = scan.nextInt();
            if(fa != -1) {
                link[fa].add(i);
                link[i].add(fa);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,query(i));
        }
        System.out.println(res);
        scan.close();
    }
}