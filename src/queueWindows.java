import java.util.*;
import java.util.stream.Collectors;

public class queueWindows {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int k = 3;
        Deque<Integer> numsQueue = new LinkedList<>();
        int[] maxResult = new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            if(!numsQueue.isEmpty()&&numsQueue.peekFirst() < i-k+1){
                numsQueue.poll();
            }//这一步就能实现窗口的滑动
            while(!numsQueue.isEmpty()&&nums[numsQueue.peekLast()]<nums[i]){
                numsQueue.pollLast();
            }
            numsQueue.offer(i);
            if(i>=k-1){
                maxResult[i-k+1] = nums[numsQueue.peekFirst()];
            }
        }
//        System.out.println();
        System.out.println(Arrays.stream(maxResult).boxed().collect(Collectors.toList()));
    }
}
