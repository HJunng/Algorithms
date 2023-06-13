package Silver3;

import java.io.*;

public class BJ1004_어린왕자 {		//30min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int start[] = new int[2];
		int end[] = new int[2];
		String str[];
		
		for(int i=0;i<T;i++) {
			str = br.readLine().split(" ");
			start[0]=Integer.parseInt(str[0]);//출발점
			start[1]=Integer.parseInt(str[1]);
			end[0]=Integer.parseInt(str[2]);//도착점
			end[1]=Integer.parseInt(str[3]);
			
			int n = Integer.parseInt(br.readLine());//행성계 개수
			int result=0;
			for(int j=0;j<n;j++) {
				str = br.readLine().split(" ");
				int cx = Integer.parseInt(str[0]);//행성계 좌표
				int cy = Integer.parseInt(str[1]);
				int cr = Integer.parseInt(str[2]);//행성계 반지름
				
				
				if(Math.sqrt(Math.pow(cx-start[0], 2)+Math.pow(cy-start[1], 2)) <= cr) {
					//start점이 행성계 안에 포함되어 있으면
					if(Math.sqrt(Math.pow(cx-end[0], 2)+Math.pow(cy-end[1], 2)) <= cr) {
						//행성계 안에 start, end 둘다 있는 건 제외시킴.(test_case 확인)
						continue;
					}
					result++;
				}else if(Math.sqrt(Math.pow(cx-end[0], 2)+Math.pow(cy-end[1], 2)) <= cr) {
					//end점이 행성계 안에 포함되어 있으면 /elseif로 출발점이 행성계안에 있는 건 제외시킴.
					result++;
				}//행성계 안에 start, end 둘다 있는 건 제외시킴.(test_case 확인)
			}
			System.out.println(result);//test_case마다 결과 출력.
		}	
	}
}
