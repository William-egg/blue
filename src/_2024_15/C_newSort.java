package _2024_15;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class C_newSort  {
    static Map<Integer,Integer> map = new HashMap<>();
    public static long fengbiNum(int num){
        if(num == 0) return 1;
        long count = 0;
        while(num != 0){
            count += map.get(num%10);
            num /= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);
        map.put(4,1);
        map.put(5,0);
        map.put(6,1);
        map.put(7,0);
        map.put(8,2);
        map.put(9,1);
        map.put(0,1);

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->{
            if(a == b) return 0;
            long a1 = fengbiNum(a);
            long b1 = fengbiNum(b);
            if(a1 != b1) return Long.compare(a1,b1);
            return a - b;
        });
        for(int i = 1;i<=n;i++){
            queue.add(scan.nextInt());
        }
        scan.close();
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
}