package utilts;

import java.util.*;

public class CollectionLearn {
    static class myQueue{
        Deque<Integer> LinkedList = new LinkedList<>();
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        public void operation() {
//            priorityQueue.offer()
//            priorityQueue.
        }

    }
    static class mySet{
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>((a,b)->a-b);

        public void operation() {
//            treeSet.
        }
    }
    static class myList{
        //这俩个操作完全一模一样，区别就只有一个使用双向链表实现
        //另外一个用数组实现。
        //他们的基本操作都是add remove reverse sort 这几个都可以有First以及Last之分
        // 还有个removeif的方法，里面传进去一个comparator，如果值等于0那么就会被删掉，所有
        List<Integer> LinkedList ;
        List<Integer> arrayList ;
        public myList(){
            LinkedList = new LinkedList<>();
            arrayList = new ArrayList<>();
        }
        public void operation() {
//            LinkedList.add(1);
//            this.LinkedList.add(1);
//            this.LinkedList.addLast(1);
//            this.LinkedList.addFirst(3);
////            this.LinkedList.addAll()
//            this.LinkedList.remove(1);
//            this.LinkedList.sort((a,b)->a-b);
//            this.LinkedList.reversed();
////            this.LinkedList.get
//            this.arrayList.re
        }
    }
    static class myCollection{
        static myList myList = new myList();
    }
    static int[][] steps = {
            {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}
    };
    public static void main(String[] args) {
        /**
         * 1. collection 下面有List、Set以及Queue
         *
         * 2. List下有LinkedList、ArrayList，一般来说双端队列也可以用这里的LinkedList来实现
         *
         * 3. Queue下面有Deque以及PriorityList，Deque下面有LinkedList一般不用这个
         *
         * 4， Set下面有treeSet以及HashSet，TreeSet可以传入对比器进行比较
         *
         * 5. PriorityList可以传入对比器，是用堆实现的，
         *    一般操作有： add poll peek sort reverse get首位俩个都有First以及Last之分，
         *
         * */
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.pollLast()
//        PriorityQueue<String> res =  new PriorityQueue<>((a,b)->a.compareTo(b));
//        res.add("b");
//        res.add("a");
//        System.out.println(res.toString());
        StringBuffer sb = new StringBuffer("hello");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
