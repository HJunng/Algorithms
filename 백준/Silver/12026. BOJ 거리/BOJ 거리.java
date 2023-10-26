import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String str = s.next();
		
		Map<Character,ArrayList<Integer>> loc = new HashMap<>() {{
			put('B',new ArrayList<>());
			put('O',new ArrayList<>());
			put('J',new ArrayList<>());
		}};
		
		for(int i=0;i<N;i++) {
			loc.get(str.charAt(i)).add(i); // B O J 문자의 위치 저장.
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		
		//bfs(str,dp,loc,N);
		
		for(int i=1;i<N;i++) {
			char now = str.charAt(i);
			for(int j=0;j<i;j++) {
				char bef = str.charAt(j);
				if(now=='O' && bef=='B' && dp[j]!=Integer.MAX_VALUE) {
					dp[i] = (int) Math.min(dp[i], dp[j]+Math.pow(i-j, 2));
				}
				if(now=='J' && bef=='O' && dp[j]!=Integer.MAX_VALUE) {
					dp[i] = (int) Math.min(dp[i], dp[j]+Math.pow(i-j, 2));
				}
				if(now=='B' && bef=='J' && dp[j]!=Integer.MAX_VALUE) {
					dp[i] = (int) Math.min(dp[i], dp[j]+Math.pow(i-j, 2));
				}
			}
		}
		
		if(dp[N-1]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dp[N-1]);
		
	}
}