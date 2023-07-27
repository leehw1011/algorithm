// 1600 말이 되고픈 원숭이
import java.io.*;
import java.util.*;

public class boj1600 {
    static int k, w, h, ans;
    static int[][] map;
    static int[][][] dist;

    static Queue<Monkey> queue = new LinkedList<>();

    static class Monkey{
        int x;
        int y;
        int k;      // 말처럼 이동한 횟수
        Monkey(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][w+1];
        dist = new int[h+1][w+1][k+1];            // dist[x][y][k] -> (x,y)까지 k번 말처럼 이동해서 가는 최단거리
        
        for(int i=1;i<=h;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=w;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
    }

    static void bfs(){

        dist[1][1][0] = 1;          // 시작위치 방문처리

        queue.add(new Monkey(1,1,0));

        int[] dx = {-1,1,0,0};          // 원숭이 이동
        int[] dy = {0,0,-1,1};

        int[] hx = {-1,-2,-2,-1,1,2,2,1};   // 말처럼 이동
        int[] hy = {-2,-1,1,2,2,1,-1,-2};

        Monkey curr, next;
        int nx, ny, nk;

        while(!queue.isEmpty()){
            curr = queue.poll();
            
            if(curr.x == h && curr.y == w){     // 목적지 도착 시 종료
                // 이렇게 최솟값을 찾아서 출력할 필요가 없다! 가장 먼저 도착하는게 최단거리를 보장
                // int min = Integer.MAX_VALUE;
                // for(int i=0;i<=k;i++){
                //     if(dist[h][w][i] < min && dist[h][w][i] != 0) min = dist[h][w][i];
                // }
                // ans = min - 1;
                ans = dist[h][w][curr.k]-1;
                return;
            }

            for(int i=0;i<4;i++){       // 원숭이처럼 이동
                nx = curr.x + dx[i]; ny = curr.y + dy[i];
                if(nx <= 0 || ny <= 0 || nx > h || ny > w){ continue; }

                if(map[nx][ny] == 0 && dist[nx][ny][curr.k] == 0){  // 해당 위치가 장애물이 아니고, 아직 방문하지 않은 경우
                    next = new Monkey(nx, ny, curr.k);
                    queue.add(next);
                    dist[nx][ny][curr.k] = dist[curr.x][curr.y][curr.k] + 1;
                }
            }

            if(curr.k < k){         // 말처럼 이동할 수 있는 횟수가 남았다면
                for(int i=0;i<8;i++){       // 원숭이처럼 이동
                nx = curr.x + hx[i]; ny = curr.y + hy[i]; nk = curr.k + 1;
                if(nx <= 0 || ny <= 0 || nx > h || ny > w){ continue; }

                if(map[nx][ny] == 0 && dist[nx][ny][nk] == 0){  // 해당 위치를 아직 방문하지 않은 경우
                    next = new Monkey(nx, ny, nk);
                    queue.add(next);
                    dist[nx][ny][nk] = dist[curr.x][curr.y][curr.k] + 1;
                }
            }

            }
        }
        // (n,m)에 도달하지 못한 경우
        ans = -1;
        return;
    }
}
