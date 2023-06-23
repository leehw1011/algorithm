// boj 1065 - 한수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1065{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=1;i<=num;i++){
            if(check(i)){
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static boolean check(int n){
       
        if(n < 100){
            return true;
        }
        int a,b,c;
        a = n/100;
        b = (n%100)/10;
        c = n%10;
        
        if((a-b)==(b-c)){
            return true;
        }
        return false;
    }
}