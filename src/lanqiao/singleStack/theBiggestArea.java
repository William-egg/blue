package lanqiao.singleStack;

import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改
/**
 * 单调栈问题。
 * https://www.lanqiao.cn/problems/17152/learning/
 *单调
 *
 *
 * */
public class theBiggestArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++) nums[i] = scan.nextInt();
        LinkedList<Integer> stack = new LinkedList<>();
        scan.close();
        long count = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.getLast()] >= nums[i]) stack.removeLast();//要找到比你小的数
            if(!stack.isEmpty()) left[i] = stack.getLast();
            else left[i] = -1;
            stack.addLast(i);
        }
        stack.clear();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.getLast()] >= nums[i]) stack.removeLast();
            if(!stack.isEmpty()) right[i] = stack.getLast();
            else right[i] = n;
            stack.addLast(i);
        }
        for(int i = 0;i<n;i++){
            count = Math.max(count,((long)right[i]-1-left[i])*nums[i]);
        }
        System.out.print(count);
    }
}