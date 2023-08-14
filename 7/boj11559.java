// 11559 Puyo Puyo
import java.util.*;
import java.io.*;

public class boj11559 {
	static class Puyo{
		int x, y;
		char color;
		
		Puyo(int x, int y, char color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	static char[][] map = new char[12][6];
	
	static int combo = 0; // 연쇄 카운트
	static boolean isCombo = false; // 연쇄 발생 여부

	static Queue<Puyo> queue = new LinkedList<>();
	static boolean[][] visited = new boolean[12][6];
	static ArrayList<int[]> list;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int nx, ny;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<12; i++) {
			String input = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		while(true) {
			isCombo = false;
			
			bfs(); // 터질 수 있는 뿌요들 다 터지고
			drop(); // 중력에 의해 남아있는 뿌요들이 맨 아래로 떨어짐
			
			// 더 이상 연쇄가 발생할 수 없으면 종료
			if(isCombo == false) {
				break;
			}
			combo++; // 연쇄 횟수 카운트
		}
		
		bw.write(String.valueOf(combo));
		bw.close();
	}
	
	static void bfs(){

		for(int i=0;i<12;i++){
			Arrays.fill(visited[i],false);
		}
		// puyo를 만나면 큐에 넣고 탐색 시작
		for(int i=0;i<12;i++){
			for(int j=0;j<6;j++){
				if(map[i][j] != '.' && !visited[i][j]){	// 빈 칸이 아니고, 탐색하지 않은 칸이면
					list = new ArrayList<>();	// 같은 색의 puyo면 list에 저장
					
					queue.add(new Puyo(i,j,map[i][j]));
					list.add(new int[]{i,j});
					visited[i][j] = true;

					while(!queue.isEmpty()){
						Puyo curr = queue.poll();
						for(int k = 0;k<4;k++){
							nx = curr.x + dx[k];
							ny = curr.y + dy[k];
							if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;

							if(!visited[nx][ny] && map[nx][ny] == curr.color){
								queue.add(new Puyo(nx, ny, map[nx][ny]));
								list.add(new int[]{nx,ny});
								visited[nx][ny] = true;
							}
						}
					}

					if(list.size() >= 4){	// 같은 색의 뿌요가 4개 이상 붙어있는 경우
						for(int k=0;k<list.size();k++){
							map[list.get(k)[0]][list.get(k)[1]] = '.';	// 리스트에 포함된 뿌요 터트리고 빈칸으로
							isCombo = true;	// 연쇄가 발생했음을 표시
						}
					}
				}
			}
		}

	}

	static void drop(){
		for(int i=0;i<6;i++){
			int idx = 11;
			queue.clear();
			for(int j=11;j>=0;j--){	// 가장 아랫줄부터 탐색, 뿌요를 만나면 큐에 넣음
				if(map[j][i] != '.'){
					queue.add(new Puyo(j, i, map[j][i]));
					map[j][i] = '.';	// 전체를 빈 칸으로 만들어 둔 후
				}
			}
			while(!queue.isEmpty()){	// 큐에 담아둔 뿌요를 아래서부터 다시 채움
				Puyo p = queue.poll();
				map[idx][i] = p.color;
				idx--;
			}

		}
	}
}