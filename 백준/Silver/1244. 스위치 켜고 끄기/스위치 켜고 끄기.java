import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] switches = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) switches[i] = Integer.parseInt(s[i]);
		
		int peopleCnt = Integer.parseInt(br.readLine());
		for(int i=0;i<peopleCnt;i++) {
			s = br.readLine().split(" ");
			
			int gender = Integer.parseInt(s[0]);
			int num = Integer.parseInt(s[1]);
			
			if(gender==1) { // 남 
				for(int j=num-1;j<N;j+=num) {
					switches[j] = switches[j]==0? 1:0; 
				}
			}else { // 여 
				//	num-1번을 기준으로 대칭되는 지점까지 모두 바꾸기.
				switches[num-1]=switches[num-1]==0? 1:0;
				for(int j=1;num-1+j<N && num-1-j>=0;j++) {
					int left = num-1-j;
					int right = num-1+j;
					
					if(switches[left]==switches[right]) {
						switches[left] = switches[left]==0? 1:0;
						switches[right] = switches[right]==0? 1:0;
					}else break;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(switches[i]+" ");
			if(i%20==19) System.out.println();
		}
	}
}