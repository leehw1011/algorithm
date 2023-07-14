// 2748 피보나치 수 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2748 {

    static int n;
    static long[] fibo;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        fibo = new long[n+1];

        fibo[0] = 0; fibo[1] = 1;

        for(int i=2;i<=n;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        bw.write(String.valueOf(fibo[n]));

        bw.flush();
        bw.close();
    }
    
}
