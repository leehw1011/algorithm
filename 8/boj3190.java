// 3190 뱀
import java.io.*;
import java.util.*;

public class boj3190 {

    static class loc{
        int x;
        int y;
        loc(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int[][] map;
    static int n, k, l;
    static int col, low;
    static int x;
    static String c;
    static HashMap<Integer, String> lotation = new HashMap<>();  // 회전 정보 저장
    //static Deque<loc> snake = new ArrayDeque<>();
    static List<loc> snake = new ArrayList<>();
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static int time, d;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 맵의 크기 입력
        k = Integer.parseInt(br.readLine());    // 사과의 개수 입력

        map = new int[n][n];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken())-1;
            low = Integer.parseInt(st.nextToken())-1;
            map[col][low] = 1;  // 사과가 있는 위치를 1로 표시
        }

        l = Integer.parseInt(br.readLine());    // 방향 전환 횟수 입력
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            c = st.nextToken();
            lotation.put(x, c);     // 회전 정보 저장
        }

        solution();

        bw.write(String.valueOf(time));
        bw.close();

    }   
    
    public static void solution(){
        int cx = 0, cy = 0;     // 현재 뱀 머리의 위치
        int nx, ny;             // 뱀 머리가 이동할 위치
        snake.add(new loc(cx,cy));

        while(true){
            time++;     // 게임 진행 시간

            nx = cx + dx[d];
            ny = cy + dy[d];

            // 게임 종료 조건 체크(벽이나 자기 자신의 몸에 부딪히는 경우)
            if(nx < 0 || nx >= n || ny < 0 || ny >= n){ return; }
            for(int i=0;i<snake.size();i++){
                loc s = snake.get(i);
                if(nx == s.x && ny == s.y){ return;}
            }

            // 뱀 이동
            if(map[nx][ny] == 1){           // 사과가 있을 때
                map[nx][ny] = 0;            // 사과 먹고
                snake.add(new loc(nx,ny));  // 머리 이동, 꼬리 그대로
            }
            else{                           // 사과 없을 때
                snake.add(new loc(nx,ny));  // 머리 이동
                snake.remove(0);      // 꼬리 이동
            }

            // 방향전환
            if(lotation.containsKey(time)){
                if(lotation.get(time).equals("D")){ // 오른쪽 회전
                    d += 1;
                    if(d==4){ d = 0; }
                }
                else{   // 왼쪽 회전
                    d -= 1;
                    if(d==-1){ d = 3; }
                }
            }

            cx = nx; cy = ny;

        }

    }
}
