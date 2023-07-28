// 9461 파도반 수열
import java.io.*;

public class boj9461 {
    static int t;
    static int n;
    static long[] dp = new long[100];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        dp[0] = 1; dp[1] = 1; dp[2] = 1; dp[3] = 2; dp[4] = 2;

        for(int i=5;i<100;i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[n-1]) + "\n");
        }
        bw.close();
    }
    
}