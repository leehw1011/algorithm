// 2565 전깃줄
import java.io.*;
import java.util.*;

public class boj2565 {
    
    static int n, max;
    static int[][] input;
    static int[] dp;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        input = new int[n][2];
        dp = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input, new Comparator<int[]>() {        // A에 대해 정렬
            @Override
            public int compare(int[] line1, int[] line2) {
                return line1[0]-line2[0];
            }
        });

        // B에 대해 증가하는 가장 긴 부분 수열 구하기
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(input[i][1]>input[j][1] && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        // dp 배열의 값 중 가장 큰 값이 남아있는 전깃줄의 개수
        max = 0;
        for(int i=0;i<n;i++){
            if(dp[i] > max) max = dp[i];
        }

        bw.write(String.valueOf(n-max));
        bw.close();

    }
    
}
