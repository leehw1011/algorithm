// 1157 단어 공부
import java.io.*;
import java.util.*;

public class boj1157 {
    static char[] input = new char[1000000];
    static int[] alpha = new int[26];
    static int max = 0, max_cnt = 0;
    static char ans;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine().toUpperCase().toCharArray();


        for(int i=0;i<input.length;i++){
            alpha[input[i] - 'A']++;
        }
        for(int i=0;i<26;i++){
            if(alpha[i] == max) {
                max_cnt++;
                ans = '?';
            }
            if(alpha[i] > max){
                max = alpha[i];
                max_cnt = 0;
                ans = (char)('A' + i);
            }
        }
        bw.write(ans);
        bw.close();
    }
}
