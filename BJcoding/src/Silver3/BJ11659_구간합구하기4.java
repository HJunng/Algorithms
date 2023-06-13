package Silver3;

import java.io.*;
public class BJ11659_구간합구하기4 {	//17m.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);	//수의 개수
		int m = Integer.parseInt(str[1]);	//result 횟수
		
		str = br.readLine().split(" ");
		int sum[] = new int[n+1];	//주어진 수들을 i번째까지 더한 값 저장.
		
		sum[1] = Integer.parseInt(str[0]);	//첫번째 수.
		for(int i=2;i<=n;i++)
			sum[i] = Integer.parseInt(str[i-1]) + sum[i-1];
		
		for(int i=0;i<m;i++) {
			str = br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			System.out.println(sum[b]-sum[a-1]);	// ex)3번째까지 더한 값에서 0번째까지 더한 값 빼면 됨.
		}
	}
}