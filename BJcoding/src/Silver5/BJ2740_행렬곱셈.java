package Silver5;

import java.io.*;
public class BJ2740_행렬곱셈 { //30min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		int[][] A = new int [N][M];
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				A[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		str = br.readLine().split(" ");
		int K = Integer.parseInt(str[1]);
		
		int[][] B = new int[M][K];
		for(int i=0;i<M;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<K;j++) {
				B[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int[][] result = new int[N][K];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				int sum=0;
				for(int m=0;m<M;m++) {
					sum += A[i][m]*B[m][j];
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}