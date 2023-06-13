package Bronze1;

import java.util.Scanner;
public class BJ1924_2007년 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		
		int sum=y;
		x--;
		
		while(x > 0) {
			switch(x) {
			case 2: sum+=28;break;
			
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: sum+=31;break;
			
			case 4:
			case 6:
			case 9:
			case 11: sum+=30;break;
			default: break;
			}
			x--;
		}
		
		switch(sum%7) {
		case 0: System.out.println("SUN");break;
		case 1: System.out.println("MON");break;
		case 2: System.out.println("TUE");break;
		case 3: System.out.println("WED");break;
		case 4: System.out.println("THU");break;
		case 5: System.out.println("FRI");break;
		case 6: System.out.println("SAT");break;
		}
	}
}