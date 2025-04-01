package utilts;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class myUtilts {
    public static long quickPowMod(long a, long b, long mod) {
        long res = 1;
        while(a != 0){
            if((b & 1) == 1) res = res*a%mod;
            a = a*a%mod;
            b >>= 1;
        }
        return res;
    }//费马小定理

    public static void main(String[] args) {
        PriorityQueue<Integer> list = new PriorityQueue<>((a, b)->b-a);
        list.offer(1);
        System.out.println(list.peek());
        System.out.println(list.size());
        System.out.println(list.poll());
        System.out.println(list.size());
        int[] arr = {1,2,3,4,5};
        int[] sorted = Arrays.stream(arr).boxed().sorted((a, b)->a-b).limit(3).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(sorted));
    }
}
