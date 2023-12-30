import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		int[] cols = new int[1001]; 
		int[] max = new int[2]; 	// 가장 높은 기둥의 시작 위치, 높이
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			
			int L = Integer.parseInt(s[0]);
			int H = Integer.parseInt(s[1]);
			
			cols[L] = H; // 높이
			
			if(H > max[1]) { // 가장 높은 기둥 갱신.
				max[0] = L;
				max[1] = H;
			}
		}
		
		int sum=0;
		int height=0;
		for(int i=0;i<=max[0];i++) { // 가장 높은 기둥까지 계산.
			
			height = Math.max(height, cols[i]);
			sum += height;
		}
		
		height=0;
		for(int i=1000;i>max[0];i--) {
			height = Math.max(height, cols[i]);
			sum += height;
		}
		
		System.out.println(sum);
	}
}