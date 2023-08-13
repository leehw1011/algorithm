// 치킨 배달
import java.io.*;
import java.util.*;

public class boj15686 {

    static class Pos{
        int x; int y;
        Pos(int x, int y){this.x = x; this.y = y;}
    }
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] map;
    static List<Pos> house = new ArrayList<>();
    static List<Pos> chickens = new ArrayList<>();
    static List<Pos> sChickens = new ArrayList<>();     // 선택된 m 개의 치킨집
    static boolean[] selected;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){house.add(new Pos(i,j));}     // 집들의 위치
                if(map[i][j] == 2){chickens.add(new Pos(i,j));}     // 치킨집들의 위치
            }
        }

        selected = new boolean[chickens.size()];

        // selectChickens -> M개의 치킨집을 선택
        selectChickens(0,0);

        bw.write(String.valueOf(ans));
        bw.close();
    }

    // M개의 치킨집을 선택 (N과 M문제처럼)
    static void selectChickens(int idx, int cnt){
        if(cnt == m){ 
            int dist = getDist();
            ans = Math.min(dist, ans);
            return;
        }

        for (int i=idx; i<chickens.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                sChickens.add(chickens.get(i));
                selectChickens(i, cnt + 1);
                selected[i] = false;
                sChickens.remove(cnt);
            }
        }
        
    }

    // 치킨 거리를 구함
    static int getDist(){
        int totalDist = 0;  // 각 집에서 각 치킨 거리까지의 최소값의 합
        for(Pos H : house){
            int minDist = Integer.MAX_VALUE;    // 집 - 치킨집 최소거리
            for(Pos C : sChickens){
                int dist = Math.abs(C.x-H.x) + Math.abs(C.y-H.y);
                if(dist < minDist){ minDist = dist;}
            }
            totalDist += minDist;
        }
        return totalDist;
    }
    
}
