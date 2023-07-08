// 2493 탑
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

class Tower{
    int index;
    int h;

    Tower(int index, int h){
        this.index = index;
        this.h = h;
    }
}

public class boj2493 {
    static int n;
    static int[] h;
    static Stack<Tower> stack = new Stack<Tower>();

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        h = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=n;i++){
            while(!stack.empty() && stack.peek().h<h[i]){
                stack.pop();
            }
            if(stack.empty()){ bw.write("0 ");}
            else{ bw.write(String.valueOf(stack.peek().index) + " ");}

            stack.push(new Tower(i,h[i]));
            
        }
        bw.flush();
        bw.close();
    }
    
}
