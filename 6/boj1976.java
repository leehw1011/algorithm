// 1976 여행가자
import java.io.*;
import java.util.*; 

public class boj1976 {
    static int n, m;
    static int[][] conn;        // 도시들 연결 정보
    static int[] parent;        // 분리집합.. 각 집합의 루트를 저장
    static int[] route;         // 여행 경로
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        conn = new int[n+1][n+1];
        route = new int[m];
        parent = new int[n+1];

        for(int i=1;i<=n;i++){ parent[i] = i;}

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                conn[i][j] = Integer.parseInt(st.nextToken());
                if(conn[i][j] == 1){
                    union(i,j);     // 두 도시가 연결되어있다면 합집합 연산
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            route[i] = Integer.parseInt(st.nextToken());
            if(i >= 1){
                if(find(route[i-1]) != find(route[i])){
                    bw.write("NO");
                    bw.close();
                    return;
                }
            }
        }
        bw.write("YES");
        bw.close();
    }

    static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);
        if(p_a != p_b){ parent[p_b] = p_a;}

    }

    static int find(int a){
        if(a == parent[a]){ return a;}
        else{ return parent[a] = find(parent[a]);}
    }
    
}
