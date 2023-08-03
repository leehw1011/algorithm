// 10809 알파벳 찾기
import java.io.*;
import java.util.*;

public class boj10809 {
    static String str;
    static char[] input = new char[100];
    static int[] alpha = new int[26];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Arrays.fill(alpha,-1);

        str = br.readLine();
        input = str.toCharArray();

        for(int i=0;i<str.length();i++){
            if(alpha[input[i]-'a'] == -1){
                alpha[input[i]-'a'] = i;
            }
        }
        
        for(int i=0;i<26;i++){
            bw.write(String.valueOf(alpha[i]) + " ");
        }
        bw.close();
    }
    
}
