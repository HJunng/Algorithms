package Bronze2;

import java.io.*;

public class BJ2587_대표값2 {		//6min.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a[] = new int[5];
		int sum=0;
		for(int i=0;i<5;i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum+=a[i];
		}
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(sum/5);	//평균
		System.out.println(a[2]); 	//중앙값
	}

}
