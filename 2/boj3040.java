// 3040 백설공주와 일곱 난쟁이

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj3040 {
    static int total, a, b;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int[] x = new int[9];

        for(int i=0;i<9;i++){
            x[i] = Integer.parseInt(br.readLine());
            total += x[i];
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(x[i]+x[j] == total-100){
                    a = i; 
                    b = j;
                    break;
                }
            }
        }

        for(int i=0;i<9;i++){
            if(i != a && i != b){
                bw.write(String.valueOf(x[i])+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    
}
