package Math;

public class Lv2_점찍기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public long solution(int k, int d) {
        long answer = 0;
        
        
        int maxCoor=0;// a,b가 나올 수 있는 최대 좌표
        for(int i=d;i>=1;i--){
            if(i%k==0){
                maxCoor=i;break;
            }
        }
        
        int b=maxCoor;
        for(long a=0;a<=maxCoor;a+=k){
            // Math.sqrt((a*k)^2 +(b*k)^2* <= d가 될 때까지 b를 찾음
            //제곱근 처리해주지 않으면 long형 범위를 벗어날 수 있어서 조심.
            while(Math.sqrt(Math.pow(a,2)+Math.pow(b,2)) > d){
                b-=k;
                //System.out.println(b);
            }
            answer+=b/k+1;// +1은 (b=0일 때까지 셈.)
            //System.out.println(a+" "+b+" : "+answer);
        }
        
        return answer;
    }
}
