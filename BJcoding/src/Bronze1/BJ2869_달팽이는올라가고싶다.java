package Bronze1;

import java.io.*;
public class BJ2869_달팽이는올라가고싶다 {		//55min
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		//Scanner 사용하면 무조건 100ms 넘길 수 밖에 없음. 최적화할 때는 BufferedReader 이용하기.
		String str[] = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int V =Integer.parseInt(str[2]);
		
		int temp = V-A;		//전체 막대 길이에서 A를 빼 무조건 마지막 1번은 A만큼 가고 도착하는 걸로 생각함.
		
		int result = temp/ (A-B);
		int remain = temp % (A-B);
		if(remain==0) System.out.println(result+1);	//V-A를 한 것이기 때문에 마지막 하루동안 A만큼 올라가서 도착함. 
		else System.out.println(result+2);		//나눠떨어지지 않으면 (A-B)만큼 한 번 더 올라가고 A만큼 올라가서 2일 더 걸림.
	}
}
