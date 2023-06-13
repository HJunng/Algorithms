package Bronze2;

import java.io.*;

public class BJ2750_수정렬하기 {	//22min

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(a[i]>a[j]) {
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		for(int i=0;i<N;i++)
			System.out.println(a[i]);
	}
}
