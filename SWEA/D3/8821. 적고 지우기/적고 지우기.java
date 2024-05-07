import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++) {
			int[] a = new int[10];
			String s = sc.next();
			for(int i = 0; i < s.length(); i++) {
				int tmp = s.charAt(i) - '0';
				if(a[tmp] == 0)
					a[tmp] = 1;
				else
					a[tmp] = 0;
			}
			int cnt = 0;
			for(int i = 0; i < a.length; i++) {
				if(a[i] == 1)
					cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}