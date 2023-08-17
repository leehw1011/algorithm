// 12865 평범한 배낭
import java.io.*;
import java.util.*;

public class boj12865 {

    static int n, k;
    static int[] w, v;
    static int[][] dp;      // dp[i][j] : i번째 물건까지 고려했을 때, 무게 j에서의 최대 가치

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n+1]; v = new int[n+1];
        dp = new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(w[i] > j){dp[i][j] = dp[i-1][j];}    // i번째 물건의 무게 w[i] 가 j보다 큰 경우, 담을 수 없다 -> i-1번째 물건까지 고려했을 때의 값 그대로
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-w[i]] + v[i]);
                }
            }
        }

        bw.write(String.valueOf(dp[n][k]));     // 최종 n개의 물건을 모두 고려했을 때, k만큼의 무게에 대한 최대 가치를 출력
        bw.close();
    }
}
