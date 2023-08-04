// 2193 이친수
import java.io.*;

public class boj2193 {
    static int n;
    static long[] dp = new long[91];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        bw.write(String.valueOf(dp[n]));
        bw.close();

    }
    
}
