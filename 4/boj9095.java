// 9095 1,2,3 더하기
import java.io.*;

public class boj9095 {
    
    static int t, n;
    static int[] ans = new int[11];
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기 값 세팅
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 4;
        for(int i=4;i<11;i++){
            ans[i] = ans[i-1]+ans[i-2]+ans[i-3];
        }

        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(ans[n] + "\n"));
        }

        bw.close();
    }
}
