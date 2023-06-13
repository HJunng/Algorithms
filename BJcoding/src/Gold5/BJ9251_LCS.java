package Gold5;

import java.io.*;
public class BJ9251_LCS {	//30m. 답.
	public static String str1[];
	public static String str2[];
	public static Integer dp[][];	//초기화를 null로 하려고 Integer형.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split("");
		str2 = br.readLine().split("");
		
		dp = new Integer [str1.length][str2.length];
		
		System.out.println(lcs(str1.length-1,str2.length-1));
	}
	private static int lcs(int i, int j) {	//최장 공통 부분 수열 : LCS
		if(i<0 || j<0)//길이가 0보다 작으면 바로 return;
			return 0;
		
		//int형으로 선언해서 0일때 실행하는 걸로 하면 시간 초과남.
		if(dp[i][j]==null) {
			dp[i][j]=0;
			if(str1[i].equals(str2[j])) {
				dp[i][j] = lcs(i-1,j-1)+1;
			}else {
				dp[i][j] = Math.max(lcs(i-1,j), lcs(i,j-1));
			}
		}
		return dp[i][j];
	}
}