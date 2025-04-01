package _2024_15;

public class B_AB {
    public static void main(String[] args) {
        //在此输入您的代码...
        int mod = 100;
        long n = 2024041331404202L;
//        long n = 200L;
        long a = 0;
        long b = -1;
        long count = 0;
        for(int i = 1;i<=n;i++){
            a = (a+i)%mod;
            b = (b*i)%mod;
            if((a + b)%100 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
