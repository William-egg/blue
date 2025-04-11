package utilts;

import java.io.*;
import java.util.StringTokenizer;

public class FastIO {
    private BufferedReader br;
    private BufferedWriter bw;
    private StringTokenizer st;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        br.readLine()
    }

    // 输入部分
    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    // 输出部分
    public void print(Object obj) {
        try {
            bw.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(Object obj) {
        try {
            bw.write(obj.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 关闭资源
    public void close() {
        try {
            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}