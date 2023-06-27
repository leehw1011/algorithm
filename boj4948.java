// 4948 베르트랑 공준
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj4948 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int cnt;
        int[] num;
        n = Integer.parseInt(br.readLine());
        while(n != 0){
            cnt = 0;
            // 체크 로직
            num = new int[2*n+1];
            for(int i=1;i<=2*n;i++){
                num[i] = i;
            }

            for(int i=2;i<=2*n;i++){
                if(num[i] == 0) continue;
                for(int j=i+i;j<=2*n;j+=i){
                    num[j] = 0;
                }
            }

            // 출력
            for(int i=n+1;i<=2*n;i++){
                if(num[i] != 0) cnt++;
            }
            bw.write(String.valueOf(cnt));
            bw.write("\n");

            // 다음 n 입력받기
            n = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
    }

}
