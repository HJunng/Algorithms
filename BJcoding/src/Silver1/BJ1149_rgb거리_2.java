package Silver1;

import java.io.*;

public class BJ1149_rgb거리_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] house = new int[n][3];
		
		String[] s;
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			
			house[i][0]=Integer.parseInt(s[0]);
			house[i][1]=Integer.parseInt(s[1]);
			house[i][2]=Integer.parseInt(s[2]);
			
			if(i!=0) {
				house[i][0]+=Math.min(house[i-1][1], house[i-1][2]);
				house[i][1]+=Math.min(house[i-1][0], house[i-1][2]);
				house[i][2]+=Math.min(house[i-1][0], house[i-1][1]);
			}
		}
		
		System.out.println(Math.min(house[n-1][0], Math.min(house[n-1][1], house[n-1][2])));
	}

}
