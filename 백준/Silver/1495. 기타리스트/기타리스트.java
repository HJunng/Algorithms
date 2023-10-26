import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int startVolume = Integer.parseInt(s[1]);
		int maxVolume = Integer.parseInt(s[2]);
		
		s = br.readLine().split(" ");
		int[] moveVol = new int[N];
		for(int i=0;i<N;i++) moveVol[i] = Integer.parseInt(s[i]);
		
		int[] dp = new int[maxVolume+1];
		Arrays.fill(dp, -1);
		dp[startVolume]=0;
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<moveVol.length;i++) {
			list.clear();
			for(int j=0;j<=maxVolume;j++) {
				if(dp[j]==i) {
					if(0<=j+moveVol[i] && j+moveVol[i]<=maxVolume)
						list.add(j+moveVol[i]);
					if(0<=j-moveVol[i] && j-moveVol[i]<=maxVolume)
						list.add(j-moveVol[i]);
				}
			}
			for(int vol : list) dp[vol]=i+1;
		}
		
		
		for(int i=maxVolume;i>=0;i--) {
			if(dp[i]==N) {
				System.out.println(i); return;
			}
		}
		System.out.println(-1);
	}
}