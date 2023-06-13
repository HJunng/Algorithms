package Silver3;

import java.io.*;
public class BJ2559_수열 {	//15m.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int arr[] = new int[n+1];	//주어진 수들의 연속 합.
		
		str = br.readLine().split(" ");
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			arr[i] = arr[i-1] + Integer.parseInt(str[i-1]);	//연속합.
			
			if(i>=k) {	//k번째 연속합부터
				if(arr[i]-arr[i-k]>max)	//max인지 확인하기.
					max = arr[i]-arr[i-k];
			}
		}
		System.out.println(max);
	}
}