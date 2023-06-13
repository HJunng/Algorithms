package Platinum5;

import java.io.*;
public class BJ6549_히스토그램에서가장큰직사각형 {
	static long[] arr;
	static int n;
	static long min;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str[] = br.readLine().split(" ");
		while(!str[0].equals("0")) {
			n = Integer.parseInt(str[0]);
			
			arr = new long[n];
			
			min = Long.MAX_VALUE;
			for(int i=0;i<n;i++) {
				arr[i] = Long.parseLong(str[i+1]);
				if(arr[i]<min) min = arr[i];
			}
			if(biggest()>min*n)
				sb.append(biggest()).append("\n");
			else
				sb.append(min*n).append("\n");
			
			str = br.readLine().split(" ");
		}
		System.out.println(sb);
	}

	private static long biggest() {

		long max=0;
		
		for(int i=0;i<n;i++) { //i가 시작으로 뒤로는 작아질 수 없음.
			if(arr[i]==min) continue;
			
			int start = i;
			long temp = arr[i];
			
			while(++start<n) {
				if(arr[start]<arr[i]) break;
				temp += arr[i];
			}
			if(temp>max) max=temp;
		}
		for(int i=n-1;i>=0;i--) {//i가 시작으로 앞으로 가는데 작아질 수 없음.
			if(arr[i]==min) continue;
			
			int end=i;
			long temp = arr[i];
			
			while(--end>=0) {
				if(arr[end]<arr[i]) break;
				temp += arr[i];
			}
			if(temp>max) max = temp;
		}	
		return max;
	}
}