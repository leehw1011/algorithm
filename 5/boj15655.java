//  15655 N과 M(6)
import java.io.*;
import java.util.*;

public class boj15655 {
    static int n, m;
    static int[] input;
    static int[] ans;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        ans = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 입력된 N개의 자연수 정렬
        Arrays.sort(input);

        for(int i=0;i<n;i++){
            bfs(i,0);
        }
        bw.close();
    }

    static void bfs(int idx, int cnt) throws IOException{
        ans[cnt] = input[idx];
        // m자리 수까지 모두 뽑은 경우, 뽑은 수열을 출력
        if(cnt == m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        // 그렇지 않은 경우 다음 수 뽑기
        for(int i=idx+1;i<n;i++){
            bfs(i,cnt+1);
        }

    }
    
}
