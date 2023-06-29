// boj 2751 - 수 정렬하기 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class boj2751 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];

        for(int i=0;i<n;i++){
            numList[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numList);

        for(int i=0;i<n;i++){
            bw.write(String.valueOf(numList[i]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    
}
