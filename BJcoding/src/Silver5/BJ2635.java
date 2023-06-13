package Silver5;

import java.util.*;

public class BJ2635 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//int a[] = new int[N/2];
		int num;
		int max=0;
		int max_num=0;
		for(int i=(int)N/2;i<=N;i++) {
			num=1;
			int a = N;
			int b = i;
			while(b>=0) {
				num++;
				int tmp = a-b;
				a=b;
				b=tmp;
			}
			if(num>max) {
				max=num;
				max_num=i;
			}
		}
		System.out.println(max);
		System.out.print(N+" ");
		int a=N;
		int b=max_num;
		while(b>=0) {
			System.out.print(b+" ");
			int tmp = a-b;
			a=b;
			b=tmp;
		}
	}

}
