// 11053 가장 긴 증가하는 부분 수열
import java.io.*;
import java.util.*;

public class boj11053 {

    static int n, max;
    static int[] A; // 수열 A
    static int[] dp;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        A = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                // 이전 값들 중 자신보다 작은 수에 대해 저장된 길이 + 1
                if(A[i] > A[j] && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        // dp 배열의 값 중 가장 큰 값이 답이 됨
        max = 0;
        for(int i=0;i<n;i++){
            if(dp[i] > max) max = dp[i];
        }

        bw.write(String.valueOf(max));
        bw.close();

    }
    
}
