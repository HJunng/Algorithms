package Silver3;

import java.io.*;

public class BJ11659_구간합구하기4_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		
		int sum[] = new int[n+1];//i번째까지의 합
		for(int i=1;i<=n;i++) {
			sum[i]=sum[i-1]+Integer.parseInt(s[i-1]);
		}
		
		for(int i=0;i<m;i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]); //시작
			int b = Integer.parseInt(s[1]); //끝
			
			System.out.println(sum[b]-sum[a-1]);
		}	
	}
}
