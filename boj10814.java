// 10814 나이순 정렬
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


class member implements Comparable<member> {
    private int age;
    private String name;

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }

    public member(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(member m) {
        return getAge() - m.getAge();
    }
}

public class boj10814 {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;
        member[] a;

        n = Integer.parseInt(br.readLine());
        a = new member[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            a[i] = new member(Integer.parseInt(st.nextToken()),st.nextToken());
        }
        Arrays.sort(a);

        for(int i=0;i<n;i++){
            bw.write(String.valueOf(a[i].getAge()));
            bw.write(" ");
            bw.write(a[i].getName());
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }
    
}
