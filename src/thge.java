import java.io.*;
import java.util.*

public class thge{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = br.readLine().split("\\s+");
        int[] sortedNums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int n = Integer.parseInt(line1[0]),k = Integer.parseInt(line1[1]);
        int l = 0,r = n-1;
        while(l<r){

        }
    }
}