package Bronze3;

import java.io.*;
import java.util.Arrays;

public class BJ10818_최소최대 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		String s[] = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		
		System.out.println(arr[0]+" "+arr[n-1]);
	}
}