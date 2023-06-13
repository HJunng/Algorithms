package Silver1;

import java.io.*;
public class BJ1149_RGB거리 {		//18min.
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cost[][] = new int[N][3];
		
		String str[] = br.readLine().split(" ");
		cost[0][0] = Integer.parseInt(str[0]);
		cost[0][1] = Integer.parseInt(str[1]);
		cost[0][2] = Integer.parseInt(str[2]);
		
		for(int i=1;i<N;i++) {
			str = br.readLine().split(" ");

			//이전 집에서 같은 색이 아닌 값 중에 더 작은 값 + 이번집"빨강"
			if(cost[i-1][1]<cost[i-1][2])
				cost[i][0] = Integer.parseInt(str[0]) + cost[i-1][1];
			else
				cost[i][0] = Integer.parseInt(str[0]) + cost[i-1][2];

			//이전 집에서 같은 색이 아닌 값 중에 더 작은 값 + 이번집"초록"
			if(cost[i-1][0]<cost[i-1][2])
				cost[i][1] = Integer.parseInt(str[1]) + cost[i-1][0];
			else
				cost[i][1] = Integer.parseInt(str[1]) + cost[i-1][2];

			//이전 집에서 같은 색이 아닌 값 중에 더 작은 값 + 이번집"파랑"
			if(cost[i-1][0]<cost[i-1][1])
				cost[i][2] = Integer.parseInt(str[2]) + cost[i-1][0];
			else
				cost[i][2] = Integer.parseInt(str[2]) + cost[i-1][1];

		}
		int min=cost[N-1][0];
		for(int i=1;i<3;i++)//최솟값 구함.
			if(cost[N-1][i]<min) min = cost[N-1][i];
		System.out.println(min);
	}

}
