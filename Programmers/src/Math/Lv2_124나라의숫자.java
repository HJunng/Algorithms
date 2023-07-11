package Math;

public class Lv2_124나라의숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public String solution(int n) {
        String answer = "";
        
        int digit=1;//자릿수
        int cnt=0;//digit 자릿수에서 몇번째 숫자인지
        
        while(true){
            if(n<=Math.pow(3,digit)){
                cnt=n-cnt;break;
            }else{
                n-=Math.pow(3,digit);
                digit++;
            }
        }
        System.out.println(digit+" "+cnt);
        
        String base3=Integer.toString(cnt-1,3);//몇번째 숫자인지 구했다면 -1을 해서 3진법으로 나눠줌.
        while(base3.length()!=digit) base3="0"+base3;//자릿수를 채우기 위해 0 더해줌.
        
        System.out.println(base3);
        
        for(int i=0;i<base3.length();i++){// 0:1, 1:2, 2:4 대입
            if(base3.charAt(i)=='0') answer+="1";
            else if(base3.charAt(i)=='1') answer+="2";
            else answer+="4";
        }
        
        return answer;
    }
}
