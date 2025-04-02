package _2024_15;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.math.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class A_k_times {
    public static void main(String[] args) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("src/_2024_15/log.txt"))) {
            String line;

            line = br.readLine();
            if(line == null) {
                System.out.println(0);
                return;
            }
            int maxCount = 0;
            String[] last = line.split("\\s+");
            int count = (last[0].equals(last[1])) ? 1 : 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+");
                if(data[0].equals(data[1])&&Long.parseLong(data[2])-Long.parseLong(last[2])<=1000){
                    count++;
                }else{
                    maxCount = Math.max(maxCount, count);
                    count = (data[0].equals(data[1])) ? 1 : 0;
                }
                last = data;
            }
            maxCount = Math.max(maxCount, count);
            System.out.println(maxCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

}
}