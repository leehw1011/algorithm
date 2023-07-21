// 10807
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class sample {
    static int n, v, num;
    static int[] count = new int[100];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            num = Integer.parseInt(st.nextToken());
            count[num]++;
        }
        v = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(count[v]));

        bw.flush();
        bw.close();
    }
    
}
