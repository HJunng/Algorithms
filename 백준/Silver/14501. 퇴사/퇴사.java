import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		int[][] consults = new int[N][2];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			
			int T = Integer.parseInt(s[0]);
			int P = Integer.parseInt(s[1]);
			
			consults[i][0] = T;
			consults[i][1] = P;
		}
		
		int[] max = new int[N];
		for(int i=N-1;i>=0;i--) {
			// 현재 상담을 받을 수 있다면, 상담비 추가.
			if(i+consults[i][0]<=N) {
				max[i] = i+consults[i][0]<N? max[i+consults[i][0]] : 0;
				max[i] += consults[i][1];
			}
			
			// 현재 상담을 받지 않고, 이전까지의 최대 상담비 선택
			if(i!=N-1) max[i] = Math.max(max[i], max[i+1]);
		}
		
		System.out.println(max[0]);
	}
}