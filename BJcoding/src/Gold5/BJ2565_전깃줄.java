package Gold5;

import java.io.*;
import java.util.*;
public class BJ2565_전깃줄 {	//90min. 답.
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int dp[] = new int[n];
		
		String str[];
		for(int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		//A전봇대 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>(){
			public int compare(int[] s1, int[] s2) {
				return s1[0]-s2[0];
			}
		});
		
		int max=0;
		for(int i=0;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				//이전에 했던 것처럼 자기 앞에 연속된 수열 중 가장 개수 많은 것 구하기.
				if(arr[j][1]<arr[i][1] && dp[i]<=dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
			if(dp[i]>max) max=dp[i];
		}
		System.out.println(n-max);
	}
}