package sweaAlgorithm;

import java.io.*;
import java.util.*;

public class No2 {		//2초안에 풀어야 해서 이건 절대 안됨.
	static int x;
	static int y;
	static int result;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int T = Integer.parseInt(str[0]);
		
		for(int k=1;k<=T;k++) {
			str = br.readLine().split(" ");
			
			int N = Integer.parseInt(str[0]);
			x = Integer.parseInt(str[1]);
			y = Integer.parseInt(str[2]);
			
			//1. x가 N보다 클 경우 ( x가 0일 경우도 생각해야 함.)
			result=-1;
			if(x!=0 && x>N) {
				System.out.println("#"+k+" "+result);
				continue;
			}else if(x==0 && y>N) {
				System.out.println("#"+k+" "+result);
				continue;
			}else {
				stack = new Stack<>();
				int n = N;
				while(n>0) { //stack에 거꾸로 저장하기
					stack.push(n%10);
					n/=10;
				}
				B(x,y);
				System.out.println("#"+k+" "+result);
			}
		}
	}
	private static void B(int a, int b) {
		result=0;
		boolean big=false;	//앞의 자리 수가 1이상 있으면 다음 수부터 일의자리까지는 모두 y 사용하면 됨.
		while(!stack.isEmpty()) {
			if(big) {	//10이상이면 무조건 큰 수 b 넣어서 숫자 만듦.
				result=result*10 + b;	
			}else {
				int temp = stack.pop();
				if(temp<x) {
					big=true;
				}else if(temp>=y) {
					result=result*10 + b;
					if(temp-y >0) big=true;
				}else {
					result=result*10 + a;
					if(temp-x>0) big=true;
				}
			}
		}
	}
	private static void A(int a, int b) {
		int temp=0;
		result=0;
		while(!stack.empty()) {
			temp = temp*10 + stack.pop();
			if((temp/b)>=1) {
				result = result*10 + b;
				temp-=b;
			}else if((temp/a)>=1) {
				result = result*10 + a;
				temp-=a;
			}
		}
	}

}
