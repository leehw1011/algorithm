// 14442 벽 부수고 이동하기 2
import java.io.*;
import java.util.*;

public class boj14442 {

    static int n, m, k, ans;
    static char[][] map;
    static int[][][] dist;

    static Queue<A> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int nx,ny;

    static class A{
        int x;
        int y;
        int k;
        A(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m][k+1];

        for(int i=0;i<n;i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs(0,0);

        bw.write(String.valueOf(ans));
        bw.close();

    }

    static void bfs(int x, int y){

        queue.add(new A(x,y,0));  // 시작 위치(0,0) 큐에 넣기
        dist[x][y][0] = 1;      // 시작 위치 방문처리

        A curr;

        while(!queue.isEmpty()){
            curr = queue.poll();
            if(curr.x == n-1 && curr.y == m-1){
                ans = dist[curr.x][curr.y][curr.k];
                return;
            }
            for(int i=0;i<4;i++){
                nx = curr.x + dx[i]; ny = curr.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;    // 탐색 범위를 벗어나는 경우
                // 이동하려는 방향이 0 인 경우
                if(map[nx][ny] == '0' && dist[nx][ny][curr.k] == 0){
                    dist[nx][ny][curr.k] = dist[curr.x][curr.y][curr.k] + 1;
                    queue.add(new A(nx, ny, curr.k));
                }

                // 이동하려는 방향이 1(벽)인 경우
                if(map[nx][ny] == '1' && curr.k < k  && dist[nx][ny][curr.k+1] == 0){
                    dist[nx][ny][curr.k+1] = dist[curr.x][curr.y][curr.k] + 1;
                    queue.add(new A(nx, ny, curr.k + 1));
                }
            }
        }
        ans = -1;
        
    }
    
}
