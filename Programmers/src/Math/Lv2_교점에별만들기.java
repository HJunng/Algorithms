package Math;

import java.util.*;
public class Lv2_교점에별만들기 {
	static long minX=Long.MAX_VALUE;
    static long maxX=Long.MIN_VALUE;
    static long minY=Long.MAX_VALUE;
    static long maxY=Long.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String[] solution(int[][] line) {
        String[] answer = {};
        
        ArrayList<long[]> meetPoint = new ArrayList<>();
        
        for(int i=0;i<line.length;i++){
            // ax+by+e=0
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            
            for(int j=0;j<i;j++){ //i번째 직선과 이전 직선들의 교차점 구하기
                // cx+dy+f=0
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                // AD-BC=0이면 두직선은 평행.
                if(a*d-b*c==0l) continue;
                
                // x, y가 정수일 때만 저장.
                if((b*f-e*d)%(a*d-b*c)!=0) continue;
                if((e*c-a*f)%(a*d-b*c)!=0) continue;
                
                //교점
                long x = (b*f-e*d)/(a*d-b*c);
                long y = (e*c-a*f)/(a*d-b*c);
                
                if(x<minX) minX=x;
                if(x>maxX) maxX=x;
                if(y<minY) minY=y;
                if(y>maxY) maxY=y;
                
                meetPoint.add(new long[]{x,y});
                
            }
        }
        
        char[][] arr = new char[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]='.';
            }
        }
        
        for(long[] point : meetPoint){
            arr[(int)(maxY-point[1])][(int)(point[0]-minX)]='*';
        }
        
        answer = new String[arr.length];
        for(int i=0;i<answer.length;i++){
            answer[i]=String.valueOf(arr[i]);
        }
        
        return answer;
    }
}
