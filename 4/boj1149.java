// 1149 RGB 거리
import java.io.*;
import java.util.*;

public class boj1149 {
    static int n, ans;
    static int[][] input = new int[1001][3];
    static int[][] dp = new int[1001][3];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++){
                input[i][j] = Integer.parseInt(st.nextToken());     // 각 집의 RGB 비용 저장
                if(i==0){ dp[i][j] = input[i][j]; }                 // dp 배열 초기값 저장
            }
        }

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + input[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + input[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + input[i][2];
        }

        ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));

        bw.write(String.valueOf(ans));
        bw.close();

    }
    
}
