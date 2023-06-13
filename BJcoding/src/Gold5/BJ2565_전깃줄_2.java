package Gold5;

import java.io.*;
import java.util.*;
public class BJ2565_전깃줄_2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][3];
		String str[];
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0]-b[0];
			}
		});
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i][1]>arr[j][1])
					arr[i][2] = Math.max(arr[i][2], arr[j][2]+1);
			}
			System.out.print(arr[i][2]+" ");
		}
		System.out.println();
		System.out.println(n - arr[n-1][2]-1);
		//n에서 최대로 연결할 수 있는 전깃줄의 개수를 빼면 됨.
	}
}