// N과 M(4)
import java.io.*;
import java.util.*;

public class boj15652 {
    static int n, m;
    static int[] ans;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = new int[m];   // m 자리수 수열

        for(int i=1;i<=n;i++){
            dfs(i,0);
        }
        bw.close();

    }

    static void dfs(int num, int cnt) throws IOException {
        ans[cnt] = num;

        // m개의 수를 모두 뽑았으면 출력
        if(cnt == m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(ans[i])+" ");
            }
            bw.write("\n");
            return;
        }

        // 그렇지 않은 경우, 자신과 같거나 큰 수 중에서 다음 수를 뽑기
        for(int i=num;i<=n;i++){
            dfs(i,cnt+1);
        }
    }
    
}
