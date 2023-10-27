import java.util.*;
public class Main {
	static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for(int i=0;i<tc;i++) {
			answer=0;
			dfs(s.nextInt());
			System.out.println(answer);
		}
		
	}
	//깊이 우선 탐색
	private static void dfs(int n) {
		// TODO Auto-generated method stub
		
		if(n==0) {
			answer++;return;
		}
		if(n-3>=0) dfs(n-3);
		if(n-2>=0) dfs(n-2);
		if(n-1>=0) dfs(n-1);
	}
}