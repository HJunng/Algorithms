package Bronze3;

import java.util.Scanner;

public class BJ10992_별찍기17 {
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2*n-1;j++) {
				if(i==n-1) {
					System.out.print("*");
				}
				else if(j+1-n==i) {
					System.out.print("*"); break;
					//Math.abs로 묶어서 출력했다가 각 줄마다 맨 뒤에 " "오면 출력오류라고 떠서 나눠서 계산함.
				}
				else if(n-j-1==i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}