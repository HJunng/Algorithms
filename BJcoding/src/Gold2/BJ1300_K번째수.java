package Gold2;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1300_K번째수 { //30min.답.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int k = s.nextInt();
		
		int left=1;
		int right=k; //원래 n*n인데 해당범위를 줄일 수 없을까 해서 알아보니 k이하이다.
		
		// lower-bound
		while(left<right) {
			int half = (left+right)/2;  // 임의의 x(mid)를 중간 값으로 잡는다.
			int count=0;
			
			for(int i=1;i<=N;i++) {
				if(half/i==0) break;

				if(half/i>N)
					count+=N;
				else
					count+=half/i;
			}
			
			//count 가 적다는 것은 임의의 x보다 half를 더 키워야 한다는 뜻.
			if(count<k)
				left=half+1;
			else
				right=half;
		}
		System.out.println(left);
	}
}