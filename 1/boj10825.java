// 10825 국영수

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Score implements Comparable<Score>{
    String name;
    int k;
    int e;
    int m;

    public Score(String name, int k, int e, int m){
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;

    }

    @Override
    public int compareTo(Score s){

        if(this.k != s.k) return s.k - this.k;

        if(this.e != s.e) return this.e - s.e;

        if(this.m != s.m) return s.m - this.m;

        return this.name.compareTo(s.name);

    }
}

public class boj10825 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Score[] list = new Score[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            
            list[i] = new Score(st.nextToken(),Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(list);

        for(int i=0;i<n;i++){
            bw.write(list[i].name + '\n');
        }
        bw.flush();
        bw.close();

    }
    
}
