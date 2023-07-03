// 10816 숫자 카드 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class boj10816 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n,m, value;
        int cnt = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        n = Integer.parseInt(br.readLine());

        int[] n_list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){      
            n_list[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        int[] m_list = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){      
            m_list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(n_list);
        for(int i=0;i<n-1;i++){
            if(n_list[i] == n_list[i+1]){
                cnt++;
            }
            else{
                map.put(n_list[i],cnt);
                cnt = 1;
            }
        }
        map.put(n_list[n-1],cnt);

        for(int i : m_list){
            if(map.get(i) == null) { value = 0; }
            else value = map.get(i);
            bw.write(String.valueOf(value) + " ");
        }
        bw.flush();
        bw.close();
    }
}
