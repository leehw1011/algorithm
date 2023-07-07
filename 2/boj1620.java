// 1620 나는야 포켓몬 마스터 이다솜
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj1620 {
    static int n,m;
    static String name, input;
    static HashMap<Integer, String> ItoS = new HashMap<>();
    static HashMap<String, Integer> StoI = new HashMap<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            name = br.readLine();
            ItoS.put(i,name);
            StoI.put(name,i);
        }
        for(int i=1;i<=m;i++){
            input = br.readLine();
            if(input.matches("\\d+")){  // 입력값이 숫자면
                bw.write(ItoS.get(Integer.parseInt(input))+"\n");
            }
            else{
                bw.write(String.valueOf(StoI.get(input))+"\n");
            }
        }
        bw.flush();
        bw.close();

    }
    
}
