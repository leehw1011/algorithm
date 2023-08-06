// 1715 카드 정렬하기
import java.io.*;
import java.util.*; 

public class boj1715 {
    static int n;
    static long a, b, sum;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        // 가장 작은 두 수를 더하고, 더한 값을 다시 우선순위 큐에 넣어줌
        while(pq.size() > 1){
            a = pq.poll();
            b = pq.poll();
            sum += (a+b);
            pq.add(a + b);
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }
}
