package Silver1;

import java.io.*;
public class BJ11660_구간합구하기5 {	//60m.답.
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int arr[][] = new int[n+1][n+1];	//주어진 수
		int sum[][] = new int[n+1][n+1]; 
		for(int i=1;i<=n;i++) {
			str = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {	//누적합
				arr[i][j] = arr[i][j-1] + Integer.parseInt(str[j-1]);
				sum[i][j] = sum[i-1][j] + arr[i][j];
			}
		}
		for(int i=0;i<m;i++) {
			str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			
			sb.append(sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}
}