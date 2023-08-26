package Math;

public class Lv2_두원사이의정수쌍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long solution(int r1, int r2) {
        long answer = 0;
        
        //1사분면에 있는 점들을 세서 *4
        //하지만 y=0일 때의 점들만 제외하고
        for(int y=1;y<=r2;y++){
            int plus = (int)Math.sqrt((long)r2*r2-(long)y*y)+1;
            
            int minus=0;
            if(r1-y>=0){
                minus=(int)Math.sqrt((long)r1*r1-(long)y*y)+1;
                if(Math.sqrt((long)r1*r1-(long)y*y)%1==0.0) minus-=1;
            }
            
            answer+=plus-minus;
        }
        
        return answer*4;
    }
}
