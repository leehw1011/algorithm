// 28298 더 흔한 타일 색칠 문제
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj28298 {

    static int n,m,k,index,cnt;
    static char color;
    static char[][] input;      // 입력
    static char[][] part;       // 정답 타일(ABBB)
    static int[][] count;       // count[k*k][26]   -> 위치별 A~Z

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = m * n;

        input = new char[n][m];
        count = new int[k*k][26];
        part = new char[k][k];
        // 입력받기
        for(int i=0;i<n;i++){
            input[i] = br.readLine().toCharArray();
        }

        // 위치별로 어떤 색이 몇 번 나왔는지 count
        for(int a=0;a<n;a+=k){          // 0 2 4
            for(int b=0;b<m;b+=k){      // 0 2
                index = 0;
                for(int c=a;c<a+k;c++){         // 0 1
                    for(int d=b;d<b+k;d++){     // 0 1
                        color = input[c][d];
                        count[index][color-65]++;
                        index++;
                    }
                }
                
            }
        }

        // 가장 많이 나온 색 찾기
        for (int i = 0; i < k*k; i++) {
            int max = 0;
            char maxColor = 'a';
            for (int x = 0; x < 26; x++) {
                if (count[i][x] > max) {
                    max = count[i][x];
                    maxColor = (char) (x + 65);
                }
            }

            int x = i / k;
            int y = i % k;
            part[x][y] = maxColor;
            cnt -= max;
        }
        
        bw.write(String.valueOf(cnt) + "\n");

        for(int a = 0;a<n/k;a++){
            for(int b = 0;b<k;b++){
                for(int c = 0;c<m/k;c++){
                    for(int d = 0;d<k;d++){
                        bw.write(part[b][d]);
                    }
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();

    }

}