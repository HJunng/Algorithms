package Silver2;

import java.io.*;
public class BJ9184_신나는함수실행_2 {
	public static int dp[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp = new int[21][21][21];
		
		String str [] = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		while(a!=-1 || b!=-1 || c!=-1) {
			sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)).append("\n");
			
			str = br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]);
		}
		System.out.println(sb);
	}
	private static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return w(20,20,20);
		
		if(dp[a][b][c]==0) {	//아직 계산 안했을 경우.
			if(a<b && b<c) {
				dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1) - w(a,b-1,c);
			}else {
				dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
			}
		}
		return dp[a][b][c];
	}
}