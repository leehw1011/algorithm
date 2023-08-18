// 1916 최소비용 구하기
import java.io.*;
import java.util.*;

public class boj1916 {
    static class Edge implements Comparable<Edge> {
        int end;
        int weight;
        Edge(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.weight, e.weight);
        }
    }
    static int INF = Integer.MAX_VALUE;
    static int n, m, a, b;

    static int s, e, w;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        Arrays.fill(dist,INF);      // 초기 비용을 모두 무한으로 설정

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());     // 각 정점별로 리스트
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            adj.get(Integer.parseInt(st.nextToken())-1).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Dijkstra(a);    // a 도시에서 출발하는 모든 경로를 탐색

        bw.write(String.valueOf(dist[b]));
        bw.close();
    }

    static void Dijkstra(int start){
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(curr.weight > dist[curr.end]) continue;      // 우선순위 큐에 최소비용이 아닌 값이 들어있을 수 있다. 이 경우를 skip!

            for(Edge e : adj.get(curr.end-1)){  // 현재 도시에서 연결된 도시들을 탐색
                if(dist[curr.end] + e.weight < dist[e.end]){
                    dist[e.end] = dist[curr.end] + e.weight;
                    pq.add(new Edge(e.end, dist[e.end]));
                }
            }

        }
    }
}
