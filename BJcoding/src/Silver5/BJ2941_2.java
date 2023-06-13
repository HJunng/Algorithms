package Silver5;

import java.io.*;

public class BJ2941_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int now = 0;	//str 몇번째문자인지 charAt
		int result=0;	//알파벳 개수
		while(now<str.length()) {
			result++;
			if(now==str.length()-1)	break;
			else if(now<=str.length()-3 && (str.substring(now, now+3)).equals("dz=")) {	//뒤에 문자 2개이상 더 있으면서 dz=인지 확인
				now+=3;continue;			//맞다면 다음에 확인하는 문자는 dz= 뒤에 있는 문자이도록 함.
			}else if(now<=str.length()-2){
				String str2 = str.substring(now, now+2);	//뒤에 문자 1개 이상 있으면서 다음 문자들인지 검사
				if(str2.equals("c=") || str2.equals("c-")|| str2.equals("d-")|| str2.equals("lj")|| str2.equals("nj")|| str2.equals("s=")|| str2.equals("z="))
					now+=2;
				else now++;		//뒤에 한자리는 남지만 위의 문자열에 해당하지 않으면 now++만 함.
				
			}else {
				now++;
			}
		}
		System.out.println(result);
	}

}
