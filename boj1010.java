// 1010 다리놓기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1010 {

    static int t, n, m;
    static int[][] dp = new int[30][30];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        // nCn = 1, nC1 = 1
        for(int i=0;i<30;i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        // (n+1)C(r+1) = nCr + nC(r+1)
        for(int i=1;i<30;i++){
            for(int j=1;j<30;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            bw.write(String.valueOf(dp[m][n]) + '\n');

        }
        bw.flush();
        bw.close();
        
    }
    
}
