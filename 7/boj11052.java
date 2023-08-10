// 11052 카드 구매하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj11052 {
    static int n;
    static int[] input;
    static int[] dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        input = new int[n+1];
        dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = input[i];
            if(i == 1) { continue;}
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i-j] + input[j], dp[i]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.close();
    }
}
