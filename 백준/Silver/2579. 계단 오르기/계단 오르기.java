import java.io.*;
import java.util.*;
public class Main {
	static int[] stairs;
	static int[] sum;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stairs = new int[n];
		sum = new int[n];
		
		for(int i=0;i<n;i++) 
			stairs[i]=Integer.parseInt(br.readLine());
		
		dp(n);
		
		System.out.print(sum[n-1]);
	}
	static private void dp(int num) {
		
		sum[0]=stairs[0];
		if(num>=2) sum[1]=stairs[0]+stairs[1];
		if(num>=3) sum[2]=Math.max(stairs[0], stairs[1])+stairs[2];
		
		for(int i=3;i<num;i++)
			sum[i]=Math.max(sum[i-3]+stairs[i-1], sum[i-2])+stairs[i];
	}
}
