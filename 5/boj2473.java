// 2473 세 용액
import java.io.*;
import java.util.*;

public class boj2473 {
    static int n, a, b, c;
    static long sum, ans1, ans2, ans3;
    static long min = Long.MAX_VALUE;
    static long[] num;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        num = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(num);

        // a = 0; b = n-1;
        // while(a<b){
        //     for(c = a+1;c<b;c++){
        //         sum = num[a]+num[b]+num[c];
        //         if(Math.abs(sum) < min){
        //             tmp = sum;
        //             min = Math.abs(sum);
        //             ans1 = num[a]; ans2 = num[c]; ans3 = num[b];
        //         }
        //         if(sum == 0){
        //             bw.write(String.valueOf(ans1) + " " + String.valueOf(ans2) + " " + String.valueOf(ans3));
        //             bw.close();
        //             return;
        //         }
        //         if(sum > 0) break;
        //     }
        //     if(tmp < 0) a++;
        //     if(tmp > 0) b--;
        // }

        // -4 -2 -1 2 3
        
        for(a = 0;a<n-2;a++){
            b = a+1; c = n-1;
            while(b<c){
                sum = num[a] + num[b] + num[c];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    ans1 = num[a]; ans2 = num[b]; ans3 = num[c];
                }
                if(sum == 0){
                    bw.write(String.valueOf(ans1) + " " + String.valueOf(ans2) + " " + String.valueOf(ans3));
                    bw.close();
                    return;
                }
                if(sum < 0) b++;
                if(sum > 0) c--;
            }
        }

        bw.write(String.valueOf(ans1) + " " + String.valueOf(ans2) + " " + String.valueOf(ans3));
        bw.close();

    }
    
}
