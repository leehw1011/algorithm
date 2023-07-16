// 1463 1로 만들기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1463 {
    static int n, ans;
    static int[] dp;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        // 초기 값 저장
        dp[1] = 0;
        
        // f(n) = min( f(n/3) + 1 , f(n/2) + 1, f(n-1)+1 )
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1]+1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();

    }
}
