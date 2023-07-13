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
            for(int i=0;i<4;i++){
                nx = curr.x + dx[i]; ny = curr.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n){ continue; }
                // 적록색약이 아닌 경우의 동작
                if(rgb){
                    if(map[nx][ny] == map[curr.x][curr.y] && count[nx][ny] == 0){ 
                        count[nx][ny] = cnt;
                        next = new A(nx,ny);
                        queue.add(next);
                    }
                }
                // 적록색약인 경우의 동작
                else{
                    if(map[curr.x][curr.y] == 'B'){
                        if(map[nx][ny] == 'B' && count[nx][ny] == 0){ 
                        count[nx][ny] = cnt;
                        next = new A(nx,ny);
                        queue.add(next);
                        }
                    }
                    else{
                        if(map[nx][ny] != 'B' && count[nx][ny] == 0){ 
                        count[nx][ny] = cnt;
                        next = new A(nx,ny);
                        queue.add(next);
                        }
                    }
                }

            }
        }    

    }
    
}
