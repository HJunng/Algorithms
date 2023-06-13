package Bronze3;

import java.util.Scanner;

public class BJ2445_별찍기8 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i=1;i<2*n;i++) {
			for(int j=1;j<=2*n;j++) {
				if(i<=n) {
					if(j<=i || j>2*n-i)
						System.out.print("*");
					else
						System.out.print(" ");
				}else {
					if(j<=2*n-i || j>i)
						System.out.print("*");
					else
						System.out.print(" ");
				}
				
				
			}
			System.out.println();
		}
	}
}