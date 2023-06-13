package Bronze1;

import java.io.*;
public class BJ2775_부녀회장_2 {	//12m.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int apart[][] = new int[15][15]; //n은 최대 14이기 때문에.
		for(int i=0;i<=14;i++) {
			for(int j=1;j<=14;j++) {
				if(i==0) apart[i][j]=j;
				else {
					apart[i][j] = apart[i][j-1]+apart[i-1][j];
				}
			}
		}
		for(int i=0;i<t;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(apart[k][n]);
		}
	}
}