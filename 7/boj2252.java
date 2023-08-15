// 2252 줄 세우기
import java.io.*;
import java.util.*;

public class boj2252 {
    static int n, m, a, b, curr;
    static String ans;
    static ArrayList<Integer>[] adj;  // 인접 리스트 : 그래프의 연결 정보를 저장
    static int[] indegree;  // 각 노드의 진입 차수를 저장
    static boolean[] visited;   // 방문처리
    static Queue<Integer> queue = new LinkedList<>();   // 큐에 들어오는 순서가 곧 위상 정렬의 순서가 됨

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        visited = new boolean[n+1];
        adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++){adj[i] = new ArrayList<>();}
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());

            adj[a].add(b);  // 연결 정보 저장
            indegree[b]++;      // 진입차수 기록
        }

        for(int i=1;i<=n;i++){
            if(indegree[i]==0 && !visited[i]){queue.add(i); visited[i] = true;}   // 진입차수가 0인 노드를 큐에 넣기
        }

        while(!queue.isEmpty()){
            curr = queue.poll();

            for(int edge : adj[curr]){
                indegree[edge]--;           // 현재 노드에서 연결된 간선 정보를 제거(진입차수 감소)
                if(indegree[edge]==0 && !visited[edge] ){queue.add(edge); visited[edge] = true;}   // 진입차수가 0이 된 노드를 큐에 넣기
            }
            bw.write(String.valueOf(curr) + " ");
        }
        bw.close();
    }
}
