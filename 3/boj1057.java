// 1057 토너먼트
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.Math;

public class boj1057 {
    static int n, a, b, round = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(a!=b){
            a = (int)Math.ceil((a+1) / 2);
            b = (int)Math.ceil((b+1) / 2);

            round++;
        }
        bw.write(String.valueOf(round));
        bw.flush();
        bw.close();

    }    
}
