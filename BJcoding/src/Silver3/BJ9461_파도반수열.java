package Silver3;

import java.io.*;
public class BJ9461_파도반수열 {	//20min.
	public static long arr[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N<=3) { //3번째까지는 변의 길이 1임.
				System.out.println(1);
				continue;
			}else {// n>3
				arr = new long[N+1];
				arr[1] = arr[2] = arr[3] = 1;
				
				System.out.println(P(N));
			}
		}
	}
	private static long P(int n) {
		for(int i=4;i<=n;i++) {
			if(arr[i]==0) {	//이미 채워져 있으면 반복할 필요 없음.
				arr[i] = arr[i-3] + arr[i-2];
			}
		}
		return arr[n];
	}
}