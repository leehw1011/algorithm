// 15651 N과 M(3)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj15651 {

    static int n, m;
    static int[] num;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        ans = new int[m];

        for(int i=1;i<=n;i++){
            dfs(i,0);
        }

        bw.close();
    }

    static void dfs(int num, int cnt) throws IOException{
        ans[cnt] = num;

        if(cnt==m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            dfs(i,cnt+1);
        }
    }
    
}
