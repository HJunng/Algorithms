package Silver2;

import java.io.*;
public class BJ9184_신나는함수실행 {		//60min. 답.
	public static int result=0;
	public static int dp[][][] = new int[21][21][21];	//다이나믹 프로그램.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		int arr[] = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		while(arr[0]!=-1 || arr[1]!=-1 || arr[2]!=-1 ) {
			result = w2(arr[0],arr[1],arr[2]);
			
			System.out.println("w("+arr[0]+", "+arr[1]+", "+arr[2]+") = "+result);
			
			str = br.readLine().split(" ");
			for(int i=0;i<3;i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
		}
	}
	private static int w(int a, int b, int c) {//재귀함수.
		
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return w(20,20,20);
		if(a<b && b<c) return w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
		else return w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
	}
	private static int w2(int a, int b, int c) {//다이나믹 프로그램.
		if(a<=0 || b<=0 || c<=0) {//순서중요* 20보다 큰지를 먼저 조사하면 21 0 0일 때 이상한 값 나옴.
			return 1;
		}
		if(a>20 || b>20 || c>20) {//범위가 20초과이면 w(20,20,20)하도록 a,b,c 바꿈.
			a=b=c=20;
		}
		if(0 <= a && 0 <= b && 0 <= c && dp[a][b][c] != 0) { 
			return dp[a][b][c];
		}
		if(a<b && b<c) {
			return dp[a][b][c] = w2(a,b,c-1)+w2(a,b-1,c-1) - w2(a,b-1,c);
		}
		return dp[a][b][c] = w2(a-1,b,c) + w2(a-1,b-1,c) + w2(a-1,b,c-1) - w2(a-1,b-1,c-1);
	}
}