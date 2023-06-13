package Silver5;

import java.io.*;
public class BJ1010_다리놓기 {		//43min.답 봄.
	static int[][] A = new int [30][30];
	//static으로 선언하면 알아서 0으로 초기화 되나?
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int N, M;
		String str[];
		
		for(int i=0;i<T;i++) {
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			sb.append(combi(M,N)).append("\n");
		}
		System.out.println(sb);
	}
	private static int combi(int m, int n) {

		//이미 계산된 경우.
		if(A[m][n]>0) {
			return A[m][n];
		}
		//nCn이거나 nC0일 경우.
		if(m==n || n==0) {
			return A[m][n]=1;
		}
		//아니면 mCn = m-1Cn-1 + m-1Cn
		return A[m][n] = combi(m-1,n-1) + combi(m-1,n);
	}
}