// 4811 알약
import java.io.*;
import java.util.*;

public class boj4811 {
    static long[][] dp = new long[31][31];     // dp[i][j] : h i개, w j개를 가지고 만들 수 있는 문자열의 개수
    static int n;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<31;i++){
            for(int j=i;j<31;j++){      // h의 개수는 w의 개수보다 클 수 없음
                if(i==0) dp[i][j] = 1;  // w만 연속해서 j개를 뽑는 경우
                if(i>0 && j>0){
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            bw.write(String.valueOf(dp[n][n])+'\n');
        }

        bw.close();
    }
    
}
