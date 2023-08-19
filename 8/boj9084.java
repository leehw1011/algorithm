// 9084 동전
import java.io.*;
import java.util.*;

public class boj9084 {

    static int t, n, m;
    static int[] coin;
    static int[] dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            coin = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                coin[i] = Integer.parseInt(st.nextToken());  // ex ) 1 5 10
            }
            m = Integer.parseInt(br.readLine());             // ex ) 100

            dp = new int[m+1];
            solution();
            bw.write(String.valueOf(dp[m]) + "\n");
        }
        bw.close();
    }

    public static void solution(){      // 입력된 값에 대하여 dp 배열을 채우는 함수
        dp[0] = 1;      // 주어진 동전들로 0원을 만드는 방법의 수 -> 1가지
        

        for (int i = 0; i < n; i++){
            for (int j = coin[i]; j <= m; j++){ // coin = {5, 7}
                dp[j] += dp[j - coin[i]];       // 주어진 동전이 5, 7 원이라 할 때, 22원을 만드는 방법의 수는 dp[17] + dp[15]
                
            }
        }
    }
}
