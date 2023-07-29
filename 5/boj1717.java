// 1717 집합의 표현
import java.io.*;
import java.util.*;

public class boj1717 {
    static int n, m;
    static int[] parent;
    static int o, a, b;     // 연산 입력

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;      // 초기 집합의 상태 저장
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            o = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(o == 0) { union(a,b);}
            if(o == 1) { check(a,b);}
        }
        bw.close();
    }

    // 두 집합을 병합
    static void union(int a, int b){
        int nx = find(a);
        int ny = find(b);
        if(nx != ny){ parent[nx] = ny;}
    }

    // 트리의 루트 노드를 찾는 연산
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // a와 b가 같은 집합에 포함되어 있는지(같은 루트 노드를 갖는지) 확인하는 연산
    static void check(int a, int b) throws IOException{
        int nx = find(a);
        int ny = find(b);
        if(nx == ny) bw.write("YES\n");
        else bw.write("NO\n");
    }
    
}
