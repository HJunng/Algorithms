package Silver4;

import java.io.*;
import java.util.Arrays;
public class BJ11399_ATM {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str[] = br.readLine().split(" ");
		int time[] = new int[n];
		for(int i=0;i<n;i++)
			time[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(time);
		
		int sum=0;
		int cumul_sum=0;
		for(int i=0;i<n;i++) {
			cumul_sum+= time[i];
			sum += cumul_sum;
		}
		System.out.println(sum);
	}
}