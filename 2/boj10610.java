// 10610 30
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj10610 {
    static int[] i_num;
    static char[] c_num;
    static int len, total;
    static boolean check;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        c_num = br.readLine().toCharArray();
        
        len = c_num.length;
        i_num = new int[len];
        for(int i=0;i<len;i++){
            i_num[i] = c_num[i] -'0';
            total += i_num[i];
            if(i_num[i] == 0) check = true;
        }

        if(check && total%3 == 0){
            Arrays.sort(c_num);
            StringBuilder tmp = new StringBuilder(new String(c_num));       // 문자열 내림차순 정렬 -> StringBuilder의 reverse() 이용
            bw.write(tmp.reverse().toString());
        }
        else bw.write("-1");

        bw.flush();
        bw.close();

    }
    
}
