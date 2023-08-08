// 4153 직각삼각형
import java.io.*;
import java.util.*; 

public class boj4153 {
    static int[] x = new int[3];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<3;i++){
                x[i] = Integer.parseInt(st.nextToken());
            }
            if(x[0] == 0 && x[1] == 0 && x[2] == 0) break;
            Arrays.sort(x);
            if(x[0] * x[0] + x[1] * x[1] == x[2] * x[2]){bw.write("right\n");}
            else{bw.write("wrong\n");}
        }
        bw.close();
    }
}
