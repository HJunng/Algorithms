package Bronze3;

import java.util.Scanner;

public class BJ2522_별찍기12 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i=1;i<2*n;i++) {
			for(int j=1;j<=n;j++) {
				if(i<=n) {
					if(j>n-i)
						System.out.print("*");
					else
						System.out.print(" ");
				}else {
					if(i-n>=j)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}