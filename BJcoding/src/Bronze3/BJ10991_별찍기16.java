package Bronze3;

import java.util.Scanner;

public class BJ10991_별찍기16 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int y;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<2*n;j++) {
				y = n - Math.abs(n-j);
				
				if(n%2==1) {
					if(j<=n) {
						if(n-i>=y || i%2!=y%2)
							System.out.print(" ");
						else
							System.out.print("*");
					}else {
						if(n-i<y && i%2==y%2)
							System.out.print("*");
						else if(n-i<y && i%2!=y%2)
							System.out.print(" ");
						else
							break;
					}
				}else {
					if(j<=n) {
						if(n-i>=y || i%2==y%2)
							System.out.print(" ");
						else
							System.out.print("*");
					}else {
						if(n-i<y && i%2!=y%2)
							System.out.print("*");
						else if(n-i<y && i%2==y%2)
							System.out.print(" ");
						else
							break;
					}
				}
				
			}
			System.out.println();
		}
	}
}