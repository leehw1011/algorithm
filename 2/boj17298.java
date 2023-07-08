// 17298 오큰수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class boj17298 {

    static int n;
    static int[] n_list;
    static int[] answer;
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        n_list = new int[n];
        answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            n_list[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=n_list[i]){
                stack.pop();
            }
            if(stack.empty()){answer[i] = -1;}
            else{answer[i] = stack.peek();}

            stack.push(n_list[i]);

        }
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(answer[i])+ " ");
        }

        bw.flush();
        bw.close();

    }    
}
