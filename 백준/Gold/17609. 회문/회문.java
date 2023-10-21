import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int i=0;i<T;i++) {
			String str = s.next();
			
			System.out.println(palindrome(str,0,str.length()-1,0));
			
		}
	}
	static int palindrome(String str, int left, int right,int diff) {
		if(diff==2) return diff;
		
		while(left<=right) {
			if(str.charAt(left)!=str.charAt(right)) { // left, right 문자가 다르면 
				diff = Math.min(palindrome(str,left+1,right,diff+1), palindrome(str,left,right-1,diff+1));
				break;
			}
			left++; right--;
		}
		
		return diff;
	}
}