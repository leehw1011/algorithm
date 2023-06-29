// 2108 통계학
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;

public class boj2108 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int[] num;
        int avg, mid, mode, range;

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        // 산술평균
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += num[i];
        }
        
        avg = (int)Math.round((double)sum/n);

        // 중앙값
        mid = num[n/2];
        
        // 최빈값
		int[] a = new int[4001];    // 음수
		int[] b = new int[4001];    // 양수
        ArrayList<Integer> mode_list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(num[i] <0) {
				a[Math.abs(num[i])]++;
			}
			else {
				b[num[i]]++;
			}
		}
		
		int max = 0;
		for(int i=0; i<a.length;i++) {
			max = Math.max(max, a[i]);	
		}
		for(int i=0; i<b.length;i++) {
			max = Math.max(max, b[i]);
		}
		
		for(int i : num) {
			if(i<0) {
				if(a[Math.abs(i)] == max && !(mode_list.contains(i))) {
					mode_list.add(i);
				}
			}
			else {
				if(b[i] == max && !(mode_list.contains(i))) {
					mode_list.add(i);
				}
			}
		}
		
		if(mode_list.size()>=2) {
			mode = mode_list.get(1);
		}
		else {
			mode = mode_list.get(0);
		}

		// // 최빈값
        // int curr, next;
        // mode = 0;
        // int count = 0;
        // int max_count = 0;
        // ArrayList<Integer> mode_list = new ArrayList<>();
        // if(n==1) {
        //     mode = num[0];
        // }
        // else{
        //     for(int i=0;i<n-1;i++){
        //     curr = num[i];
        //     next = num[i+1];
        //     if(curr == next){ 
        //         count++;
        //         if(max_count<=count){
        //             if(max_count!=count) {mode_list.clear();}
        //             max_count = count;
        //             mode = num[i];
        //             mode_list.add(mode);
        //         }
        //     }
        //     else{ count = 0; }
        //     }

        //     if(mode_list.size() > 1){
        //         mode = mode_list.get(1);
        //     }
        // }

        // 범위
        range = num[n-1]-num[0];
        
        bw.write(String.valueOf(avg) + '\n');
        bw.write(String.valueOf(mid) + '\n');
        bw.write(String.valueOf(mode) + '\n');
        bw.write(String.valueOf(range) + '\n');

        bw.flush();
        bw.close();

        
    }
    
}
