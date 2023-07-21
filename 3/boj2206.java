// 벽 부수고 이동하기 -> 방문체크에 3차원 배열 사용 / 벽을 부수고 간 경우와 부수지 않고 간 경우
import java.io.*;
import java.util.*;

public class boj2206 {
    static int n,m,ans;
    static char[][] map;
    static int[][][] dist;      // 최단경로 저장 겸 방문체크

    static Queue<A> queue = new LinkedList<>();

    static class A{
        int x;
        int y;
        int breakWall;
        A(int x, int y, int breakWall){
            this.x = x;
            this.y = y;
            this.breakWall = breakWall;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        dist = new int[n+1][m+1][2];        // (x,y)까지의 최단 경로를 저장 - [x좌표][y좌표][0,1(벽을 부순 경우, 부수지 않은 경우)]
        
        for(int i=1;i<=n;i++){
            map[i] = ("0"+ br.readLine()).toCharArray();    // 입력받기
        }
        
        bfs();
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
    }

    static void bfs(){

        dist[1][1][0] = 1;          // 시작위치 방문처리

        queue.add(new A(1,1,0));

        int[] dx = {-1,1,0,0}; 
        int[] dy = {0,0,-1,1};
        A curr, next;
        int nx, ny, nb;

        while(!queue.isEmpty()){
            curr = queue.poll();
            
            if(curr.x == n && curr.y == m){ 
                if(dist[n][m][0] == 0) ans = dist[n][m][1];        // 벽을 부숴야만 도달 가능한 경우
                else if(dist[n][m][1] == 0) ans = dist[n][m][0];   // 벽을 부수지 않고만 도달 가능한 경우
                else ans = (dist[n][m][0] < dist[n][m][1]) ? dist[n][m][0] : dist[n][m][1];     // 두 가지 모두 가능한 경우
                return;
            }
            
            for(int i=0;i<4;i++){
                nx = curr.x + dx[i]; ny = curr.y + dy[i]; nb = curr.breakWall;
                if(nx <= 0 || ny <= 0 || nx > n || ny > m){ continue; }

                if(map[nx][ny]=='0'){ // 벽이 아니면
                    if(nb == 0 && dist[nx][ny][0] == 0) { // 아직 벽을 부수지 않았고 && 해당 위치 방문x
                        next = new A(nx,ny,0);
                        queue.add(next);
                        dist[nx][ny][0] = dist[curr.x][curr.y][0] + 1;
                    }else if(nb == 1 && dist[nx][ny][1] == 0){ // 이미 벽을 부순 적이 있으면
                        next = new A(nx,ny,1);
                        queue.add(next);
                        dist[nx][ny][1] = dist[curr.x][curr.y][1] + 1;
                    }

                }else if(map[nx][ny]=='1'){ // 벽이면

                    if(nb == 0){ // 아직 벽을 부수지 않았으면 부순다
                        next = new A(nx, ny, 1);
                        queue.add(next);
                        dist[nx][ny][1] = dist[curr.x][curr.y][0] + 1;
                    }
                }
            }
        }
        // (n,m)에 도달하지 못한 경우
        ans = -1;
        return;
    }
}
