package Silver2;

import java.io.*;
import java.util.Arrays;

public class BJ2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[] arr = new int[N];
		s = br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(arr);
		
		long min=1;
		long max=arr[N-1];
		long half,sum;
		while(min<=max) {
			half = (min+max)/2;
			sum=0;
			
			for(int i=0;i<N;i++) {
				if(arr[i]-half>0)
					sum+=arr[i]-half;
			}
			
			if(sum>=K)
				min = half+1;
			else
				max = half-1;
		}
		System.out.println(max);
	}
}