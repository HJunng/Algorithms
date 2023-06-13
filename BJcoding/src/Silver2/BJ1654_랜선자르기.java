package Silver2;

import java.io.*;
import java.util.Arrays;
public class BJ1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[] arr = new int[K];
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long max = arr[K-1];
		long min = 1; // 랜선의 길이는 자연수이므로 1부터 시작.
		long count,half;
		
		while(min<=max) { // 이분탐색
			count=0;
			half=(min+max)/2;
			
			for(int i=0;i<K;i++)
				count+= arr[i]/half;
			
			if(count<N) // N개 보다 랜선이 적게 나오면 min~half까지 범위중에서 다시 선택
				max=half-1;
			else // N개보다 많이 나오면 half~max 범위 중에 다시 선택
				min=half+1;
		}
		System.out.println(max);
	}
}