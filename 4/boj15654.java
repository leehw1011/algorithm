// 15654 N과 M(5)
import java.io.*;
import java.util.*;

public class boj15654 {
    static int n, m;
    static int[] num;
    static int[] ans;
    static boolean[] check;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        ans = new int[m];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i=0;i<n;i++){
            dfs(i,0);
            check[i] = false;
        }

        bw.close();
    }

    // _num은 넘겨받은 인덱스. num[_num]이 실제 숫자!
    static void dfs(int _num, int cnt) throws IOException{
        ans[cnt] = num[_num];
        check[_num] = true;

        if(cnt == m-1){
            for(int i=0;i<m;i++){
                bw.write(String.valueOf(ans[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(check[i] == true) continue;
            dfs(i,cnt+1);
            check[i] = false;
        }
    }
    
}
