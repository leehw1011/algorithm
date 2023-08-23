// 2042 구간 합 구하기

import java.io.*;
import java.util.*;

public class boj2042 {
    static int n, m, k, a, b;
    static long c;
    static long input[];
    static long tree[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        input = new long[n+1];
        tree = new long[4 * n];

        for(int i=1;i<=n;i++){
            input[i] = Long.parseLong(br.readLine());
        }

        tree[0] = init(1,n,1);

        m += k;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if(a == 1){
                change(1,n,1,b,c);
            }
            else if(a == 2){
                bw.write(String.valueOf(sum(1,n,1,b,c))+ "\n");
            }
        }
        bw.close();
    }
    
    // 초기 setting
    public static long init(int start, int end, int node){
        if(start==end) return tree[node] = input[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, 2 * node) + init(mid+1 ,end, 2 * node + 1);
    }

    // 구간 합 구하기
    public static long sum(int start, int end, int node, int left, long right){
        if(end < left || right < start){ return 0; }
        if(left <= start && end <= right){ return tree[node]; }
        
        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid+1, end, node * 2 + 1, left, right);
    }

    // 값 변경하기
    public static void change(int start, int end, int node, int index, long value){
        if(index < start || index > end) return;
        if(start == index && end==index){
			tree[node] = value;
            return;
        }

        int mid = ( start + end ) / 2;
        change(start, mid, node * 2, index, value);
        change(mid+1, end, node * 2 + 1, index, value);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
