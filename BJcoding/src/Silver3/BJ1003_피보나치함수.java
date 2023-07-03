package Silver3;

import java.io.*;

public class BJ1003_피보나치함수 {
	static int[][] fiboCnt;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		fiboCnt = new int[41][2];
		fiboCnt[0][0]=1;//피보나치(0)에서 0을 몇번 호출하는지
		fiboCnt[0][1]=0;//피보나치(0)에서 1을 몇번 호출하는지
		fiboCnt[1][0]=0;
		fiboCnt[1][1]=1;
		
		for(int i=0;i<tc;i++) {
			int n = Integer.parseInt(br.readLine());
			if(fiboCnt[n][0]==0) fibonacciCnt(n);
			sb.append(fiboCnt[n][0]+" "+fiboCnt[n][1]+"\n");
		}
		System.out.println(sb);
		
	}
	static void fibonacciCnt(int n) {

		if(fiboCnt[n][0]>0 || n==0 || n==1) return;
		
		fibonacciCnt(n-1);
		fibonacciCnt(n-2);
		
		fiboCnt[n][0]=fiboCnt[n-1][0]+fiboCnt[n-2][0];
		fiboCnt[n][1]=fiboCnt[n-1][1]+fiboCnt[n-2][1];
	}
}
