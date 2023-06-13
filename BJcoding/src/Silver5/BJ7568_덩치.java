package Silver5;

import java.io.*;
public class BJ7568_덩치 {	//40min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[];
		int A[][] = new int[N][2];
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			A[i][0] = Integer.parseInt(str[0]);
			A[i][1] = Integer.parseInt(str[1]);
		}
		for(int i=0;i<N;i++) {
			int rank=1;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(A[i][0]<A[j][0] && A[i][1]<A[j][1])
					//이중for문으로 비교하면서 덩치가 더 큰 사람이 있으면 rank++;
					rank++;
			}
			System.out.print(rank+" ");
		}
	}
}