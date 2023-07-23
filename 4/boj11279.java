// 11279 최대 힙
import java.io.*;
import java.util.*;

public class boj11279 {

    static int n, x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }
                else{
                    bw.write(String.valueOf(pq.poll()+ "\n"));
                }
            }
            else{
                pq.add(x);
            }
        }
        bw.close();
    }
}
