// 1753 최단 경로
import java.io.*;
import java.util.*;

public class boj1753 {
    static class Edge implements Comparable<Edge> {
        int end;
        int weight;
        Edge(int end, int weight){
            this.end = end; this.weight = weight;
        }
        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    static int INF = Integer.MAX_VALUE;

    static int V, E, K;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        Arrays.fill(dist,INF);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>()); // 각 정점별 리스트 만들기
        }
        for(int i=0;i<E;i++){   // 간선 정보 입력받으며 인접리스트에 저장
            st = new StringTokenizer(br.readLine());
            adj.get(Integer.parseInt(st.nextToken())-1).add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        // 각 정점으로의 최단 경로 구하기
        Dijkstra(K);

        // 출력
        for(int i=1;i<=V;i++){
            if(dist[i] == INF){bw.write("INF\n");}
            else{
                bw.write(String.valueOf(dist[i]) + "\n");
            }
        }

        bw.close();

    }

    static void Dijkstra(int start){
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()){
            Edge curr = pq.poll();  // 처음 : (1,0)

            for(Edge e : adj.get(curr.end-1)){    // 처음 : 1번 노드에서 갈 수 있는 애들이 불러와짐 (2,2), (3,3)
                if(dist[curr.end] + e.weight < dist[e.end]){
                    dist[e.end] = dist[curr.end] + e.weight;
                    pq.add(new Edge(e.end, dist[e.end]));                  // 거리가 갱신되는 경우 우선순위 큐에 넣는다
                }
            }
        }
    }
    
}
