// 10986 나머지 합
import java.io.*;
import java.util.*;

public class boj10986 {
    static int n, m, input;
    static long ans;
    static int[] cnt;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cnt = new int[m+1];

        st = new StringTokenizer(br.readLine());

        // input : 1 2 3 1 2
        // sum :   1 3 6 7 9
        // mod :   1 0 0 1 0
        for(int i=1;i<=n;i++){
            input = (input + Integer.parseInt(st.nextToken())) % m;
            cnt[input]++;  // 나머지가 같은 것을 활용할 것 -> 어떤 수가 몇 번 나오는지 저장
        }

        // cnt[0] = 3, cnt[1] = 2
        ans = cnt[0];       // 구간합의 나머지가 0인 경우를 먼저 저장
        for(int i=0;i<m;i++){
            ans += (long)cnt[i] * (cnt[i]-1) / 2;
        }

        bw.write(String.valueOf(ans));
        bw.close();


    }
}
