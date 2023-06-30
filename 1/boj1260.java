// 1260 DFS와 BFS
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] node;
    static int[][] edge;
    static boolean[] visit;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n_node = Integer.parseInt(st.nextToken());
        int n_edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        node = new int[n_node+1];
        visit = new boolean[n_node+1];
        edge = new int[n_node+1][n_node+1];
        int a,b;
        for(int i=1;i<=n_node;i++){
            node[i] = i;
            visit[i] = false;
        }
        for(int i=1;i<=n_edge;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            edge[a][b] = 1;
            edge[b][a] = 1;
        }

        dfs(start);
        for(int i=1;i<=n_node;i++){
            visit[i] = false;
        }
        bw.write("\n");
        bfs(start);
        
        bw.flush();
        bw.close();

    }
    
    static void dfs(int start) throws IOException{
        visit[start] = true;
        bw.write(String.valueOf(start) + " ");

        for(int i=1;i<node.length;i++){
            if(edge[start][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        int curr = 0;

        visit[start] = true;

        q.add(start);

        while(!q.isEmpty()){
            curr = q.poll();
            bw.write(String.valueOf(curr) + " ");
            for(int i=1;i<node.length;i++){
                if(edge[curr][i] == 1 && visit[i] == false){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }

    }
}
