// 10026 적록색약
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;

class A{
    int x; int y;
    A(int x, int y){ this.x = x; this.y = y;}
}

public class boj10026 {
    static int n;
    static char[][] map;
    static int[][] count;
    static Queue<A> queue;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        count = new int[n][n];
        for(int i=0;i<n;i++){
            map[i] = br.readLine().toCharArray();
        }

        // 적록색약이 아닌 경우
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(count[i][j] == 0){
                    bfs(new A(i,j),++cnt,true);
                }
            }
        }
        bw.write(String.valueOf(cnt) + " ");

        // 적록색약인 경우
        cnt = 0;
        count = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(count[i][j] == 0){
                    bfs(new A(i,j),++cnt,false);
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static void bfs(A start, int cnt, boolean rgb){
        queue = new LinkedList<>();

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int nx,ny;

        A curr, next;

        count[start.x][start.y] = cnt;
        queue.add(start);
        while(!queue.isEmpty()){
            curr = queue.poll();
            nx = curr.x; ny = curr.y;
            for(int i=0;i<4;i++){
                if(nx+dx[i] < 0 || ny+dy[i] < 0 || nx+dx[i] >= n || ny+dy[i] >= n){ continue; }
                // 적록색약이 아닌 경우의 동작
                if(rgb){
                    if(map[nx+dx[i]][ny+dy[i]] == map[nx][ny] && count[nx+dx[i]][ny+dy[i]] == 0){ 
                        count[nx+dx[i]][ny+dy[i]] = cnt;
                        next = new A(nx+dx[i],ny+dy[i]);
                        queue.add(next);
                    }
                }
                // 적록색약인 경우의 동작
                else{
                    if(map[nx][ny] == 'B'){
                        if(map[nx+dx[i]][ny+dy[i]] == 'B' && count[nx+dx[i]][ny+dy[i]] == 0){ 
                        count[nx+dx[i]][ny+dy[i]] = cnt;
                        next = new A(nx+dx[i],ny+dy[i]);
                        queue.add(next);
                        }
                    }
                    else{
                        if(map[nx+dx[i]][ny+dy[i]] != 'B' && count[nx+dx[i]][ny+dy[i]] == 0){ 
                        count[nx+dx[i]][ny+dy[i]] = cnt;
                        next = new A(nx+dx[i],ny+dy[i]);
                        queue.add(next);
                        }
                    }
                }

            }
        }    

    }
    
}
