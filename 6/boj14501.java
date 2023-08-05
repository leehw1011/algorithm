// 14501 퇴사

import java.io.*;
import java.util.*;

public class boj14501 {
    static int n, curr, next, ans;
    static int[] T = new int[16];
    static int[] P = new int[16];
    static int[] dp = new int[20];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = n;i>0;i--){
            next = i + T[i];    // 다음 상담을 할 수 있는 날
            if(next > n + 1){dp[i] = dp[i+1];}
            else{
                dp[i] = Math.max(dp[i+1],dp[next] + P[i]);
            }
        }

        bw.write(String.valueOf(dp[1]));
        bw.close();

    }
    
}
