import java.io.*;

public class CT03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int jump_n = Integer.parseInt(input[1]);
		int jump[] = new int[N];
		for(int i=0;i<N;i++) {
			jump[i] = -1;
		}
		for(int i=0;i<jump_n;i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if(a>b) {	//떨어지는건 0으로 저장해서 밟지 않기
				jump[a]=0;
			}
			else {
				jump[a]=b;
			}
		}
		int now=0;
		int result=0;
		while(now<N-1) {
			System.out.println("ㄱ");
			int max=0;
			int maxI = 0;
			for(int i=6;i>=1;i++) {
				if(now+i>=N-1) {
					System.out.println("ㄴ");
					result++;
					now+=i;
					break;
				}
				else if(jump[now+i]>max) {
					max=jump[now+i];
					maxI = i;
				}
			}
			if(now>=N-1) break;
			
			if(maxI+max>6) {
				result++;
				now=now+maxI+max;
			}else {
				for(int i=6;i>=0;i--) {
					if(i==0) {
						System.out.println(-1);
						return;
					}
					else if(jump[now+i]==0)	continue;
					else {
						result++;
						now +=i;
						break;
					}
				}
			}
		}
		System.out.println(result);
		
		
	}

}
