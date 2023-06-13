package Bronze2;

import java.io.*;

public class BJ25305_커트라인 {	//8min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int a[] = new int[N];
		str = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(a[i]<a[j]) {		//내림차순 정렬
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(a[k-1]);	//k번째 사람의 점수를 구해야하는데 배열은 0번부터 세므로 k-1해야한다.
	}

}
