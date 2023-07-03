// 6198 옥상 정원 꾸미기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int h;
        long count = 0;

        for(int i=0;i<n;i++){
            h = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek()<=h){
                stack.pop();
            }
            count += stack.size();
            stack.push(h);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }
}