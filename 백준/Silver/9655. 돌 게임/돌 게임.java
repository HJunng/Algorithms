import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		
		int turn=0;
		while(N>0) {
			if(N>3) N-=3;
			else N-=1;
			
			turn++;
		}
		
		if(turn%2==1) System.out.println("SK");
		else System.out.println("CY");
	}
}