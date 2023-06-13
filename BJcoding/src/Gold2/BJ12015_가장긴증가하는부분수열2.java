package Gold2;

import java.io.*;
public class BJ12015_가장긴증가하는부분수열2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		String[] s = br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
			arr[i][0] = Integer.parseInt(s[i]);
		
		int max=0;
		for(int i=0;i<N;i++) {
			arr[i][1]=1;
			for(int j=0;j<i;j++) {
				if(arr[j][0]<arr[i][0] && arr[j][1]>=arr[i][1])
					arr[i][1] = arr[j][1]+1;
			}
			if(arr[i][1]>max) max = arr[i][1];
		}
		System.out.println(max);
	}
}