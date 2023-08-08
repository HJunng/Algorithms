package Silver2;

import java.io.*;
import java.util.*;
public class BJ11501_주식 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int[] stock = new int[n];
			for(int i=0;i<s.length;i++) stock[i]=Integer.parseInt(s[i]);
			
			int max=0;
			long sum=0;
			for(int i=stock.length-1;i>=0;i--) {
				if(stock[i]>max) {
					max=stock[i];
				}else {
					sum+=max-stock[i];
				}
			}
				
			sb.append(sum+"\n");
			
		}
		System.out.println(sb);
	}

}
