package Silver5;

import java.util.*;

public class BJ2581 {	//26min

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();
		
		boolean b[] = new boolean [N+1];
		Arrays.fill(b, true);
		b[0]=false;
		b[1] = false;
		
		for(int i=M;i<=N;i++) {
			for(int j=2;j<=i/2;j++) {	//소수 찾기
				if(i%j==0) {
					b[i]=false;			//소수이면 boolean값 false로 바꾸기
					break;
				}
			}
		}
		int sum = 0;
		int min = 10001;	//N은 10000이하 자연수 이므로 10001을 넣음.
		for(int i=M;i<=N;i++) {
			if(b[i]==true) {
				sum += i;
				if(i<min) min=i;
			}
		}
		if(sum==0) System.out.println(-1);	//소수가 없으면 -1 출력.
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
