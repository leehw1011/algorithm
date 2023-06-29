// 1920 수 찾기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {
    private static int n,m;
    private static int[] A;
    private static int[] numList;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        m = Integer.parseInt(br.readLine());
        numList = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            if(check(numList[i])){
                bw.write("1");
            }
            else{
                bw.write("0");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static boolean check(int num){

        int st = 0;
        int en = n-1;
        int mid;
        
        while(st <= en){
            mid = (st+en)/2;
            if(A[mid]==num){return true;}
            else if(A[mid] > num){ en = mid-1;}
            else{ st = mid+1;}
        }
        return false;
    }
}