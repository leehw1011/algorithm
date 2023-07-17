// 2470 두 용액
import java.io.*;
import java.util.*;

public class boj2470 {
    static int n;
    static int[] num;       // -99 -2 -1 4 98
    
    static int min = 2000000001;
    static int sum, ans1, ans2;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int i = 0; int j = n-1;
        while(i<j){
            sum = num[i] + num[j];
            
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                ans1 = num[i];
                ans2 = num[j];
            }
            
            if(sum==0) break;
            
            if(sum < 0) i++;
            else j--;

        }

        bw.write(String.valueOf(ans1) + " ");
        bw.write(String.valueOf(ans2));

        bw.close();
    
        
    }
}