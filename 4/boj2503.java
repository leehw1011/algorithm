// 2503 숫자 야구
import java.io.*;
import java.util.*;

public class boj2503 {
    static int n, ans;
    static int[] num, s, b;
    static int stemp, btemp;
    static boolean[] check = new boolean[1000];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        num = new int[n];
        s = new int[n];
        b = new int[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        // check 배열에서 답이 될 가능성이 있는 수는 true, 아니면 false
        for(int i=123;i<1000;i++){
            String str1 = Integer.toString(i);
            // 중복된 숫자가 존재하면 false
            if(str1.charAt(0) == str1.charAt(1) || str1.charAt(0) == str1.charAt(2) || str1.charAt(1) == str1.charAt(2)) continue;

            // 0 이 포함되면 false
            if(str1.charAt(0) == '0' || str1.charAt(1) == '0' || str1.charAt(2) == '0') continue;

            check[i] = true;
            // 입력된 값과의 비교
            for(int j=0;j<n;j++){

                if(check[i] == false) break;     // 이미 이전 조건을 만족하지 못한 숫자는 뒤의 조건들을 검사하지 않음
                
                stemp = 0; btemp = 0;

                String str2 = Integer.toString(num[j]);

                // 스트라이크 카운트
                if(str1.charAt(0) == str2.charAt(0)) stemp++;
                if(str1.charAt(1) == str2.charAt(1)) stemp++;
                if(str1.charAt(2) == str2.charAt(2)) stemp++;

                // 볼 카운트
                if(str1.charAt(0) == str2.charAt(1)) btemp++;
                if(str1.charAt(0) == str2.charAt(2)) btemp++;
                if(str1.charAt(1) == str2.charAt(0)) btemp++;
                if(str1.charAt(1) == str2.charAt(2)) btemp++;
                if(str1.charAt(2) == str2.charAt(0)) btemp++;
                if(str1.charAt(2) == str2.charAt(1)) btemp++;

                // 입력된 s, b 값과 일치하지 않으면 false
                if(s[j] != stemp || b[j] != btemp) check[i] = false;

            }
        }

        for(int i = 123;i<=987;i++){
            if(check[i] == true) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.close();

    }
    
}
