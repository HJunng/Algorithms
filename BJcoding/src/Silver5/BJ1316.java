package Silver5;

import java.io.*;

public class BJ1316 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		
		int result=0;
		for(int k=0;k<N;k++) {
			str = br.readLine();
			boolean b = true;
			for(int i=0;i<str.length();i++) {
				if(i==str.length()-1) {
					result++;break;
				}
				char c = str.charAt(i);		//a
				int lo = i;			//0
				for(int j=i+1;j<str.length();j++) {		//뒤에 나오는 알파벳 중에 i번째 알파벳과 같은 알파벳이 있을 때 위치 차이가 2이상이면 break;
					if(str.charAt(j)==c) {
						if(j-lo==1) lo=k;
						else b=false;break;
					}
				}
				if(b==false) break;		//한 문자라도 떨어져서 나타나면 뒤에 문자를 검사할 필요 없으므로 반복문 종료.
			}
		}
		System.out.println(result);
	}
}
