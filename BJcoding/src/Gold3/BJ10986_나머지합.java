package Gold3;

import java.io.*;
public class BJ10986_나머지합 {	//60m.답.
	public static long result=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		int arr[] = new int[n+1];
		str = br.readLine().split(" ");
		int modCount[] = new int[m];
		for(int i=1;i<=n;i++) {
			arr[i] = (arr[i-1]+Integer.parseInt(str[i-1])) % m;	//누적 나머지 합.
			modCount[arr[i]]++;
		}
		result+=modCount[0];
		for(int i=0;i<modCount.length;i++) {
			result+=(long) modCount[i]*(modCount[i]-1)/2;
		}
		System.out.println(result);
	}
}