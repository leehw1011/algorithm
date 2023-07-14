// 11726 2 x n 타일링
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj11726 {

    static int n;
    static int[] dp = new int[1001];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dp[1] = 1; dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
