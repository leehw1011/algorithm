// 2156 포도주 시식
import java.io.*;

public class boj2156 {
    static int n, ans;
    static int[] input;
    static int[][] dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        input = new int[n];
        dp = new int[n][3];

        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        dp[0][1] = input[0];    // dp 배열 초기값 저장

        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));    // 현재 잔을 마시지 않는 경우
            dp[i][1] = dp[i-1][0] + input[i];                                   // 현재 잔이 연속된 한 잔 째인 경우
            dp[i][2] = dp[i-1][1] + input[i];                                   // 현재 잔이 연속된 두 잔 째인 경우
        }

        ans = Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));
        bw.write(String.valueOf(ans));
        bw.close();

    }
    
}
