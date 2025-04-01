import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
class node{
    int value;
    int lessTime;
}
public class addString {
    public static void main(String[] args) {
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
}