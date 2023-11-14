import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 객차의 수
		
		int[] pas = new int[N]; // 객차에 타고 있는 손님의 수 
		int[] total = new int[N]; // i번째 까지의 합 
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			pas[i] = Integer.parseInt(s[i]);
			total[i] = i>0? total[i-1]+pas[i] : pas[i];
		}
		
		int canPull = Integer.parseInt(br.readLine()); // 소형기관차가 끌 수 있는 객차의 수
		
		// 35 40 50 10 30 45 60
		//    75 90 60 40 75 105
		
		//    75 90 90  90  90  105
		//    0  0  135 130 165 195
		//    
		int[] sumUnit = new int[N-canPull+1]; // canPull만큼 묶었을 때 합 
		
		int move = canPull-1;
		for(int i=0;i<sumUnit.length;i++) {
			sumUnit[i] = i==0? total[i+move] : total[i+move]-total[i+move-canPull];
		}
		//System.out.println(Arrays.toString(sumUnit));
		
		// sumUnit에서 i번째 수를 1,2,3번째 객차로 고르는 경우 
		int[][] dp = new int[sumUnit.length][3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<dp.length;j++) {
				
				if(i==0) { // 1번째 객차를 고르는 방법은 i까지의 객차 중에 가장 많은 사람을 태운 객차.
					dp[j][0] = j==0? sumUnit[j] : Math.max(dp[j-1][0], sumUnit[j]);
				}else {
					int befIdx = j-canPull;
					if(befIdx>=0) dp[j][i] = Math.max(dp[befIdx][i-1] + sumUnit[j],dp[j-1][i]);
				}
			}
		}
		
		int max=0;
		for(int i=0;i<dp.length;i++) {
			max = Math.max(dp[i][2], max);
		}
		
		System.out.println(max);
	}
}