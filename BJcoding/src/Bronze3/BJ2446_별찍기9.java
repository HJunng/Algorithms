package Bronze3;

import java.util.Scanner;

public class BJ2446_별찍기9 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int x,y;
		for(int i=1;i<2*n;i++) {
			for(int j=1;j<2*n;j++) {
				
				x = n - Math.abs(n-i);
				y = n  - Math.abs(n-j);
				
				if(j<=n) {
					if(y>=x)
						System.out.print("*");
					else
						System.out.print(" ");
				}else {
					if(y>=x)
						System.out.print("*");
					else
						break;
				}
				
			}
			System.out.println();
		}
	}
}