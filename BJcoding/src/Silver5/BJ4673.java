package Silver5;

import java.util.Arrays;

public class BJ4673 {	//17분

	public static int d(int n) {
		int sum=0;
		sum+=n;
		while(n>0) {
			sum += n%10;
			n /=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		
		boolean result[] = new boolean[10001];
		Arrays.fill(result,true);				//배열 값 초기화
		
		for(int i=1;i<result.length;i++) {		//1부터 함수d를 사용해 생성자가 있는 수 출력
			int temp = d(i);
			if(temp<=10000) result[temp]=false;		//생성자가 있는 숫자 제거
		}
		for(int i=1;i<result.length;i++)
			if(result[i]==true)	System.out.println(i);
	}
}
