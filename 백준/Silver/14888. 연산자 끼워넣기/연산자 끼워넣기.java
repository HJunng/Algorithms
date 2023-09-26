import java.io.*;
public class Main {
	public static int num[];
	public static int sign[] = new int[4];//연산자 몇개인지 넣기.
	public static int min = Integer.MAX_VALUE;//일단 int형에서 제일 큰 값 넣어두기.
	public static int max = Integer.MIN_VALUE;
	public static int order[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		num = new int[N];
		order = new int[N];
		
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++)//숫자 입력받기
			num[i] = Integer.parseInt(str[i]);
		
		str = br.readLine().split(" ");
		for(int i=0;i<4;i++)//연산자 입력받기.
			sign[i] = Integer.parseInt(str[i]);
		
		dfs(num[0],1);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int temp, int depth) {
		if(depth==num.length) {//끝까지 탐색 완료하면 최대값, 최솟값인지 확인.
			if(temp<min) min = temp;
			if(temp>max) max = temp;
			return;
		}
		for (int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if (sign[i] > 0) {
 
				// 해당 연산자를 1 감소시킨다.
				sign[i]--;
 
				switch (i) {
 
				case 0:	dfs(temp + num[depth], depth + 1);	break;
				case 1:	dfs(temp - num[depth], depth + 1);	break;
				case 2:	dfs(temp * num[depth], depth + 1);	break;
				case 3:	dfs(temp / num[depth], depth + 1);	break;
 
				}
				// 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
				sign[i]++;
			}
		}
	}
}