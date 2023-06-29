// 10773 제로
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10773 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k;
        int sum = 0;
        int input;
        Stack<Integer> stack = new Stack<>();
        k = Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            input = Integer.parseInt(br.readLine());
            if(input != 0){
                stack.push(input);
            }
            else{
                stack.pop();
            }
        }
        for(int i=0;i<stack.size();i++){
            sum += stack.get(i);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        
    }
    
}
