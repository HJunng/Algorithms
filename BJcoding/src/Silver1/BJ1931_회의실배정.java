package Silver1;

import java.io.*;
import java.util.*;
public class BJ1931_회의실배정 {	//40m. 답.
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int time[][] = new int[n][2];	//주어진 회의 시간
		
		String str[];
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			
			time[i][0] = Integer.parseInt(str[0]);
			time[i][1] = Integer.parseInt(str[1]);
		}
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[1]==b[1]) {
					return a[0]-b[0];
				}else {
					return a[1]-b[1];
				}
			}
		});
		int count=0;
		int end_time=0;
		for(int i=0;i<n;i++) {
			if(time[i][0]>= end_time) {
				count++;
				end_time = time[i][1];
			}
		}
		System.out.println(count);
		System.out.println();
	}
}