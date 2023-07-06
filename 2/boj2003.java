// 2003 수들의 합 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2003 {
    static int n, m, start, end, cnt;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] A = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            A[i] = A[i-1] + Integer.parseInt(st.nextToken());
        }

        while(start <= end && end <=n){
            if(A[end]-A[start] == m ) {cnt++; start++;}
            else if(A[end]-A[start] < m) end++;
            else if(A[end]-A[start] > m) start++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }
    
}
