// 15649 N과 M(1)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj15649 {
    static int n,m;
    static int[] num;
    static Integer[] answer;
    static boolean[] selected;
    
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        answer = new Integer[m];
        selected = new boolean[n+1];

        for(int i=1;i<=n;i++){
            num[i] = i;
        }

        for(int i=1;i<=n;i++){
            selected[i] = true;
            dfs(i,0);
            selected[i] = false;
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int cnt) throws IOException{
        answer[cnt] = num;
        // m 개의 숫자를 모두 선택한 경우
        if(cnt==m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(answer[i])+" ");
            }
            bw.write("\n");
            return;
        }
        // m 개 미만의 숫자를 선택한 경우, 다음 숫자를 선택
        for(int i=1;i<=n;i++){
            if(!selected[i]){
                selected[i] = true;
                dfs(i,cnt+1);
                selected[i] = false;
            }
        }

    }
    
}
