package Silver4;

import java.io.*;
import java.util.Arrays;

public class BJ2217_로프 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//로프 개수
		
		//로프가 버틸 수 있는 최대 중량.
		int[] rope = new int[n];
		for(int i=0;i<n;i++) rope[i]=Integer.parseInt(br.readLine());

		Arrays.sort(rope);
		
		int max=0;//로프들을 사용해 들 수 있는 최대 중량
		//로프가 버틸 수 있는 최대 중량이 작은 로프부터 하나씩 빼면서, 최대 중량 찾기.
		for(int i=0;i<rope.length;i++) {
			int weight=rope[i]*(n-i);
			if(weight>max) max=weight;
		}
		
		System.out.println(max);
	}
}
