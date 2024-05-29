import java.io.*;
public class Main {
	public static String str1[];
	public static String str2[];
	public static Integer dp[][];	//초기화를 null로 하려고 Integer형.
	static int max=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split("");
		str2 = br.readLine().split("");
		
		dp = new Integer [str1.length][str2.length];
		
		System.out.println(lcs(str1.length-1,str2.length-1));
	}
	private static int lcs(int i, int j) {
		if(i<0 || j<0)
			return 0;
		
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