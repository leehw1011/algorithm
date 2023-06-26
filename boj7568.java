// 7568 덩치

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class dungchi{
    public int x;
    public int y;

    public dungchi(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj7568 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;
        int cnt;

        n = Integer.parseInt(br.readLine());
        dungchi[] a = new dungchi[n];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            a[i] = new dungchi(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<n;i++){
            cnt = 0;
            for(int j=0;j<n;j++){
                if(a[j].x > a[i].x && a[j].y > a[i].y){
                    cnt++;
                }
            }
            cnt++;
            bw.write(String.valueOf(cnt));
            bw.write(' ');
        }
        bw.flush();
        bw.close();

    }
    
}
