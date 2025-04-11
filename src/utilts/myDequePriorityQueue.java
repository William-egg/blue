package utilts;

import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class myDequePriorityQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Queue<Integer> queue = new PriorityQueue<>((a,b)->a-b);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = scan.nextInt();
        while(n-->0){
            String op = scan.next();
            if(op.equals("push")){
                queue.add(scan.nextInt());
            }else if(op.equals("remove")){
                if(queue.isEmpty()) System.out.println("empty");
                else queue.poll();
            }else if(op.equals("min")){
                if(queue.isEmpty()) System.out.println("empty");
                else System.out.println(queue.peek());
            }else{
                int x = scan.nextInt();
                while(!op.isEmpty()&&x-->0){
                    System.out.print(queue.poll()+" ");
                }
                System.out.println();
            }
        }
        scan.close();
    }
}