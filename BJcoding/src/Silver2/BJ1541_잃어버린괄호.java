package Silver2;

import java.io.*;
public class BJ1541_잃어버린괄호 {	//30m. 답.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String subtract[] = br.readLine().split("-");	//빼기로 String나눔.
		int sum=Integer.MAX_VALUE; //초기상태 확인.
		
		for(int i=0;i<subtract.length;i++) {
			int temp=0;
			
			//뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			String[] addition = subtract[i].split("\\+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다.
			for(int j=0;j<addition.length;j++) {
				temp+= Integer.parseInt(addition[j]);
			}
			
			if(sum==Integer.MAX_VALUE) //첫번째 값이면 temp넣음.
				sum = temp;
			else
				sum -=temp; //그 다음부터는 temp값을 모두 뺌.
		}
		System.out.println(sum);	
	}
}