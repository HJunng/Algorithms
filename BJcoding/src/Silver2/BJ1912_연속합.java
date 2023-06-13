package Silver2;

import java.io.*;
public class BJ1912_연속합 {	//55min. 답.
	public static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] sum = new int[n];	//이전까지의 합 or 현재값 중 더 큰 값.
		
		String str[] = br.readLine().split(" ");
		arr[0] = Integer.parseInt(str[0]);
		sum[0] = max = arr[0];//배열 첫번째값으로 초기화.
		for(int i=1;i<n;i++) {
			arr[i] = Integer.parseInt(str[i]);
			sum[i] = sum[i-1] + arr[i];
			
			//이전까지의 합보다 현재값이 더 크면 sum에 현재값 넣음.
			if(arr[i]>sum[i]) sum[i]=arr[i];
			
			if(sum[i]>max) max = sum[i];//가장 큰 수열의 합 구하기.
		}
		System.out.println(max);
	}
}