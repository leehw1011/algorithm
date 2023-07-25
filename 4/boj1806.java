// 1806 부분합
import java.io.*;
import java.util.*;

public class boj1806 {

    static int n, s;
    static int[] sum;
    static int min = 100000;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int a=0; int b=0;   // 두 포인터

        while(a <= n && b <= n){
            if(sum[b] - sum[a] < s) b++;
            else if(sum[b] - sum[a] >= s){
                if(b-a < min) min = b-a;
                a++;
            }
        }

        if(min == 100000) min=0;
        bw.write(String.valueOf(min));
        bw.close();

    }
    
}
