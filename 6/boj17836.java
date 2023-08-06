// 17836 공주님을 구해라!
import java.io.*;
import java.util.*;

public class boj17836 {
    static class A{
        int x; int y; int gram;
        A(int x, int y, int gram){
            this.x = x;
            this.y = y;
            this.gram = gram;
        }
    }
    static int n, m, t, ans;     // (n x m) size map / 제한시간 t
    static int[][] map;
    static int[][][] dist;

    static Queue<A> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};    // 상하좌우 탐색
    static int[] dy = {-1, 1, 0, 0};
    static A curr;
    static int nx, ny;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        dist = new int[n+1][m+1][2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = bfs(new A(1,1,0));
        if(ans == -1 || ans > t){bw.write("Fail");}
        else{ bw.write(String.valueOf(ans));}
        bw.close();

    }

    static int bfs(A start){
        
        dist[start.x][start.y][0] = 1;
        queue.add(start);

        while(!queue.isEmpty()){
            curr = queue.poll();    // 현 위치
            if(curr.x == n && curr.y == m){ return dist[curr.x][curr.y][curr.gram]-1;}

            for(int i = 0;i<4;i++){
                nx = curr.x + dx[i]; ny = curr.y + dy[i];       // 이동하고자 하는 위치
                if(nx < 1 || nx > n || ny < 1 || ny > m){ continue; }   // 탐색 범위를 벗어나면 continue
                
                if(curr.gram == 1){      // 그람을 갖고 있다면
                    if(dist[nx][ny][1] == 0){
                        queue.add(new A(nx,ny,1));
                        dist[nx][ny][1] = dist[curr.x][curr.y][1] + 1;
                    }
                }

                else{               // 그람을 갖고 있지 않다면
                    if(map[nx][ny] == 1){ continue; }   // 벽 뚫기 불가
                    if(map[nx][ny] == 0 && dist[nx][ny][0] == 0){
                        queue.add(new A(nx,ny,0));
                        dist[nx][ny][0] = dist[curr.x][curr.y][0] + 1;
                    }
                    if(map[nx][ny] == 2){               // 그람 획득!
                        queue.add(new A(nx,ny,1));
                        dist[nx][ny][1] = dist[curr.x][curr.y][0] + 1;
                    }

                }

            }
        }

        return -1;  // 공주의 위치에 도달하지 못하는 경우

    }
    
}
