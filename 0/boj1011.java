// 1011 Fly me to the Alpha Centauri
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1011 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t;
        int x, y;
        int d;
        int a;

        t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            d = y-x;
            a = (int)Math.sqrt(d);
            bw.write("a = " + String.valueOf(a)+ " ");
            if(d == a*a){ bw.write(String.valueOf((2 * a) - 1) + "\n");}
            else if(d <= a * (a + 1)) {bw.write(String.valueOf(2 * a) + "\n");}
            else{bw.write(String.valueOf((2 * a) + 1) + "\n");}
        }
        bw.flush();
        bw.close();

    }
    
}
