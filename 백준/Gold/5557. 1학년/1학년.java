import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static long[] dp;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int[] nums = new int[N];
		String[] s = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) nums[i] = Integer.parseInt(s[i]);
		
		dp = new long[21]; // 0~20까지만 안다.
		
		findDP(nums);
		
		System.out.println(dp[nums[N-1]]);
	}
	static void findDP(int[] nums) {
		
		dp[nums[0]]=1; // 처음 숫자는 무조건 더하기.
		
		ArrayList<long[]> save = new ArrayList<>();
		ArrayList<long[]> notsave = new ArrayList<>();
		for(int i=1;i<nums.length-1;i++) {
			save.clear();
			notsave.clear();
			for(int j=0;j<dp.length;j++) {
				if(dp[j]>0) {
					int up = j+nums[i]; 	// 주어진 숫자 더하기.
					int down = j-nums[i]; 	// 주어진 숫자 빼기. 
					
					if(up>=0 && up<=20) save.add(new long[] {up,dp[j]});
					if(down>=0 && down<=20) save.add(new long[] {down,dp[j]});
					
					notsave.add(new long[] {j,dp[j]});
				}
			}
			// 저장해놨던 숫자들 더함.
			for(long[] n : save) dp[(int)n[0]]+=n[1];
			// 이전에 계산되는 과정에 있던 값들은 제거.
			for(long[] n : notsave) dp[(int)n[0]]-=n[1];
			
			//System.out.println(Arrays.toString(dp));
		}
	}
}