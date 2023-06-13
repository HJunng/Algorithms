package Gold4;

import java.io.*;
public class BJ10830_행렬제곱 { //60min. 참고.
	static int mod = 1000;
	static int N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		long B = Long.parseLong(s[1]);
		
		int[][] A = new int[N][N];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(s[j])%mod;
			}
		}
		int[][] result = pow(A,B);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	// 행렬 제곱 분할정복 메소드
	private static int[][] pow(int[][] a, long b) {
		
		if(b==1L)
			return a;
		
		int[][] temp = pow(a,b/2); //재귀호출
		temp = MatrixMultiply(temp,temp); // 행렬 제곱.
		
		if(b%2==1L)
			temp = MatrixMultiply(temp,a);
			
		return temp;
	}
	//행렬곱.
	private static int[][] MatrixMultiply(int[][] a, int[][] b){
		int[][] temp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int sum=0;
				for(int k=0;k<N;k++) {
					sum += a[i][k]*b[k][j];
				}
				temp[i][j]=sum%mod;
			}
		}
		return temp;
	}
}