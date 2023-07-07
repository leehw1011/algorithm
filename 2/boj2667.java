// 2667 단지번호붙이기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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

public class boj2667 {
    static int n;
    static char[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> answer = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        map = new char[n+1][n+1];
        visit = new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            map[i] = ('0' + br.readLine()).toCharArray();
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j] == '1' && !visit[i][j]){bfs(i,j);}
            }
        }

        Collections.sort(answer);
        bw.write(String.valueOf(answer.size())+"\n");
        for(int i : answer){
            bw.write(String.valueOf(i) + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static void bfs(int i, int j){
        Queue<Map> queue = new LinkedList<>();

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int nx,ny;
        int cnt = 0;

        visit[i][j] = true;
        queue.add(new Map(i,j));
        Map curr, next;
        while(!queue.isEmpty()){
            curr = queue.poll();
            cnt++;
            nx = curr.x; ny = curr.y;
            for(int k=0;k<4;k++){
                if(nx+dx[k]<1 || ny+dy[k]<1 || nx+dx[k]>n || ny+dy[k]>n) continue;
                if(map[nx+dx[k]][ny+dy[k]]=='1' && !visit[nx+dx[k]][ny+dy[k]]){
                    next = new Map(nx+dx[k], ny+dy[k]);
                    queue.add(next);
                    visit[nx+dx[k]][ny+dy[k]] = true;
                }
            }
        }
        answer.add(cnt);
    }
}
