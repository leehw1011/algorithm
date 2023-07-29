// 1932 정수삼각형
import java.io.*;
import java.util.*;

public class boj1932 {
    static int n, input, ans;
    static int[][] dp;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                input = Integer.parseInt(st.nextToken());
                if(i == 0) {dp[i][j] = input;}                          // 맨 위층
                else if(j == 0){dp[i][j] = dp[i-1][j] + input;}         // 가장 왼쪽의 수들
                else if(j == n-1){dp[i][j] = dp[i-1][j-1] + input;}     // 가장 오른쪽 수들
                else{
                    // 위 층의 왼쪽, 오른쪽 수 중 큰 것에 현재 값을 더하여 저장
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + input;
                }
            }
        }

        // 마지막 line의 최대값이 답이 됨
        ans = Arrays.stream(dp[n-1]).max().getAsInt();
        bw.write(String.valueOf(ans));
        bw.close();
    }
    
}
