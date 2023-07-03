// 2178 미로탐색
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Miro{
    int x;
    int y;

    Miro(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj2178 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n, m;
        int[] dx = {-1,1,0,0};      // 상하좌우 방향
        int[] dy = {0,0,-1,1};

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[n+1][m+1];
        int[][] cnt = new int[n+1][m+1];            // 방문체크 겸 거리 카운트

        for(int i=1;i<=n;i++){
            map[i] = ('0' + br.readLine()).toCharArray();       // 문자 하나씩 입력받기
            for(int j=1;j<=m;j++){
                cnt[i][j] = -1;     // 초기 거리 설정
            }
        }

        // bfs
        Queue<Miro> queue = new LinkedList<>();
        Miro start = new Miro(1,1);
        Miro now, next;
        queue.add(start);
        cnt[start.x][start.y] = 1;

        while(!queue.isEmpty()){
            now = queue.poll();
            for(int i=0;i<4;i++){       // 상하좌우 체크

                if(now.x + dx[i] < 1 || now.y + dy[i] < 1 || now.x + dx[i] > n || now.y + dy[i] > m) continue;
                if(map[now.x + dx[i]][now.y + dy[i]] == '1' && cnt[now.x + dx[i]][now.y + dy[i]] == -1){
                    
                    cnt[now.x+dx[i]][now.y+dy[i]] = cnt[now.x][now.y] + 1;
                    next = new Miro(now.x + dx[i], now.y + dy[i]);
                    
                    queue.add(next);
                }
            }
        }
        bw.write(String.valueOf(cnt[n][m]));
        bw.flush();
        bw.close();
    }    
}
