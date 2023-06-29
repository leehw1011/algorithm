// 4344 평균은 넘겠지
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj4344 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int c;      // 테스트케이스의 개수
        int n;
        int[] score;
        int sum, cnt;
        double avg, per;

        c = Integer.parseInt(br.readLine());

        
        for(int i=0;i<c;i++){
            sum = 0;
            cnt = 0;
            // 각 테스트케이스 점수 입력받기
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            score = new int[n];
            for(int j=0;j<n;j++){
                score[j] = Integer.parseInt(st.nextToken());
            }

            for(int j : score){
                sum += j;
            }
            avg = sum / n;
            for(int j : score){
                if(j>avg) cnt++;
            }
            per = (double)cnt / n * 100;
            bw.write(String.format("%.3f",per));
            bw.write("%\n");

        }
        bw.flush();
        bw.close();


    }
    
}
