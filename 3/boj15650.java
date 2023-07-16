// 15650 N과 M(2)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj15650 {

    static int n, m;
    static int[] num;
    static int[] ans;
    static boolean[] selected;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n+1];     // 1부터 n까지의 수를 저장
        ans = new int[m];       // 출력할 수열을 담을 배열
        selected = new boolean[n+1];

        for(int i=1;i<=n;i++){
            num[i] = i;
        }
        // dfs
        for(int i=1;i<=n;i++){
            dfs(i,0);   // i로 시작하는 수열
            selected[i] = false;
        }

        bw.close();
    }

    static void dfs(int num, int cnt) throws IOException{
        ans[cnt] = num;
        selected[num] = true;

        // m개의 수를 모두 뽑았으면
        if(cnt==m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        // 다음 자리 수 뽑기
        for(int i=num+1;i<=n;i++){
            if(selected[i] == false) {
                dfs(i,cnt+1);
                selected[i] = false;
            }
        }
    }
    
}
