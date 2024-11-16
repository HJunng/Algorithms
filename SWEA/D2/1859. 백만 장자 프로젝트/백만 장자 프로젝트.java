import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			
			int max = 0;
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(s[i]);
				max = Math.max(max, arr[i]);
			}
			
			long sum = 0;
			for(int i=0;i<n;i++) {
				if(arr[i]<max) {
					sum += max-arr[i];
				} else if(arr[i] == max) {
					// 다음 max 값 찾기
					max = 0;
					for(int j=i+1;j<n;j++) {
						max = Math.max(max, arr[j]);
					}
				}
			}
			
			
			System.out.println("#"+t+" "+sum);
		}
	}
}
