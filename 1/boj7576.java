// 7576 토마토
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class A{
    int x;
    int y;

    A(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj7576 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m, n, max;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean check = false;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        Queue<A> queue = new LinkedList<>();

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.add(new A(i,j));      // 시작 위치
                }
            }
        }

        // bfs
        A curr, next;
        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int i=0;i<4;i++){       // 상하좌우 체크

                if(curr.x + dx[i] < 1 || curr.y + dy[i] < 1 || curr.x + dx[i] > n || curr.y + dy[i] > m) continue;
                if(map[curr.x + dx[i]][curr.y + dy[i]] == 0){

                    map[curr.x+dx[i]][curr.y+dy[i]] = map[curr.x][curr.y] + 1;
                    next = new A(curr.x + dx[i], curr.y + dy[i]);
       
                    queue.add(next);
                }
            }
        }

        max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(map[i][j] == 0) {check = true; break;}
                if(map[i][j] > max) max = map[i][j];
            }
        }

        if(check) bw.write(String.valueOf(-1));
        else bw.write(String.valueOf(max-1));

        bw.flush();
        bw.close();

    }

}
