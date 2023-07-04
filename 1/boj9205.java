// 9205 맥주 마시면서 걸어가기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

class Map{
    int x;
    int y;

    Map(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class boj9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t, n, x, y;
        boolean check;
        Map[] map;
        boolean[] visit;
        boolean[][] move;
        Queue<Integer> queue;
        

        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            check = false;
            n = Integer.parseInt(br.readLine());        // 편의점 개수
            map = new Map[n+2];
            visit  = new boolean[n+2];
            move = new boolean[n+2][n+2];
            queue = new LinkedList<>();

            for(int i=0;i<n+2;i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[i] = new Map(x,y);
            }

            // 이동할 수 있는 거리인지 확인
            for(int i=0;i<n+2;i++){
                for(int j=1;j<n+2;j++){
                    
                    if(Math.abs(map[i].x-map[j].x)+Math.abs(map[i].y-map[j].y)<=1000){
                        move[i][j] = true;
                        move[j][i] = true;
                    }
                }
            }

            queue.add(0);  // 집에서 출발
            visit[0] = true;
            int curr;
            while(!queue.isEmpty()){
                curr = queue.poll();
                if (curr == n + 1) { check = true; break;}

                for(int i=0;i<n+2;i++){
                    if(move[curr][i] && !visit[i]){
                        queue.add(i);
                        visit[i] = true;
                    }
                }
            }

            bw.write(check?"happy\n":"sad\n");

        }
        bw.flush();
        bw.close();

    }
}