// 2609 최대공약수와 최소공배수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2609 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int x,y, b;
        int a = 1;

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        for(int i=1;i<=x;i++){
            if(x % i == 0 && y % i == 0){
                a = i;
            }
        }
        b = x * y / a;

        bw.write(String.valueOf(a) + "\n");
        bw.write(String.valueOf(b));

        bw.flush();
        bw.close();
    }
    
}
