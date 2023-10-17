import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		long S = scanner.nextLong();
		
		int num=1;
		int cnt=0;
		while(S>0) {
			if(S>num*2) {
				S-=num;
				cnt+=1;
				num+=1;
			}else {
				cnt+=1;
				break;
			}
		}
		
		System.out.println(cnt);
		
	}
}