// boj 4673 - 셀프 넘버
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class boj4673{
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] a = new boolean[10001];

        for(int i=1;i<10000;i++){
            a[check(i)] = true;
        }

        for(int i=1;i<10000;i++){
            if(!a[i]){
                bw.write(String.valueOf(i));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int check(int n){
        int sum = n;
        while(n!=0){
 			sum += n%10;
 			n /= 10;
  		}
        if(sum<10000){
            return sum;
        }
        return 0;
    }
}