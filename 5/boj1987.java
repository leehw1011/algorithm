// 1987 알파벳
import java.io.*;
import java.util.*;

public class boj1987 {
    static int r, c, max = 0;
    static char[][] map;
    static boolean[] alpha = new boolean[26];   // 알파벳별 방문체크

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int nx,ny;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i=0;i<r;i++){
            map[i] = br.readLine().toCharArray();
        }

        dfs(0,0,0);     // x,y 좌표, 이동한 칸 수

        bw.write(String.valueOf(max));
        bw.close();
        
    }

    static void dfs(int x, int y, int cnt){
        
        // 해당 칸에 적힌 알파벳이 이미 등장한 적 있으면 더이상 이동할 수 없음
        // 지금까지 지나온 칸 수를 최대값을 갱신해가며 저장, 리턴하여 이전 칸으로 돌아가서 탐색을 계속함
        if(alpha[map[x][y]-'A'] == true){
            if(cnt > max) max = cnt;
            return;
        }

        alpha[map[x][y] - 'A'] = true; // 방문체크
        for(int i=0;i<4;i++){
            nx = x + dx[i]; ny = y + dy[i]; 
            if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;  // 이동하려는 방향이 map의 범위를 벗어나면 탐색 x

            dfs(nx,ny,cnt+1);
        }

        alpha[map[x][y] - 'A'] = false; // 해당 칸에서의 dfs탐색을 끝내고 이전 칸으로 돌아갈 때, 다음 탐색을 위해 방문체크 해제

    }
    
}
