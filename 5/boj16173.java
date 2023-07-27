// 16173 점프왕 쩰리
import java.io.*;
import java.util.*;

public class boj16173 {

    static int n;
    static int[][] map;
    static int[] dx = {1,0};    // 오른쪽과 아래로만 이동 가능
    static int[] dy = {0,1};
    static String ans;

    static Queue<A> queue = new LinkedList<>();

    static class A{
        int x;
        int y;
        A(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력받기
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new A(0,0));

        bw.write(ans);
        bw.close();

    }

    static void bfs(A start){

        queue.add(start);
        A curr;
        int move, nx, ny;
        
        while(!queue.isEmpty()){
            curr = queue.poll();
            move = map[curr.x][curr.y];    // 점프할 수 있는 칸 수

            if(move == -1) {ans = "HaruHaru"; return;}    // 도착점에 도달한 경우
            if(move == 0) {ans = "Hing"; return;}

            for(int i=0;i<2;i++){
                nx = curr.x + move * dx[i]; ny = curr.y + move * dy[i];
                if(nx < n && ny < n){
                    queue.add(new A(nx,ny));
                }       
            }
        }
        ans = "Hing";
    }
    
}
