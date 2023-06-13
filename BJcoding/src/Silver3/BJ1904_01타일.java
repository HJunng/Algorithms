package Silver3;

import java.util.*;
public class BJ1904_01타일 {	//30min.답.
	public static int N;
	public static int arr[];
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		arr = new int[N+10];//N=1이면 arr[2]에 걸림.
		arr[0]=0;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<arr.length;i++)
			arr[i]=-1;
		
		System.out.println(dp(N));
	}
	private static int dp(int N) {
		
		if(arr[N]==-1) {
			arr[N] = (dp(N-1) + dp(N-2)) %15746;
		}
		return arr[N];
	}
}