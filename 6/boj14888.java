// 14888 연산자 끼워넣기
import java.io.*;
import java.util.*;

public class boj14888 {
    static int n, value;
    static int[] A = new int[11]; // 입력 수열
    static int[] operator = new int[4]; // 각 연산자 개수 ( + , - , * , / 순서)

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        calc(A[0],1);

        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(min));
        bw.close();
    }

    // 재귀 호출로 모든 경우를 탐색
    static void calc(int num, int idx){
        // n번째 수까지 연산을 마쳤다면, 최대, 최소값 비교하여 저장
        if(idx == n){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }
        // 그렇지 않다면 다음 연산을 진행
        for(int i=0;i<4;i++){
            if(operator[i] > 0){
                operator[i]--;
                
                switch(i){
                    case 0 : calc(num + A[idx],idx+1); break; 
                    case 1 : calc(num - A[idx],idx+1); break; 
                    case 2 : calc(num * A[idx],idx+1); break; 
                    case 3 : calc(num / A[idx],idx+1); break; 
                }

                operator[i]++;
            }
        }

    }

    
}
