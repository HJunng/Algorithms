package Math;

public class Lv2_k진수에서소수개수구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int n, int k) {
        int answer = 0;
        
        String num = changeNum(n,k);
        //String num = Integer.toString(n,k);
        System.out.println(num);
        
        String[] getNum = num.split("0");//0을 기준으로 자르기
        
        for(String s:getNum)
            if(!s.equals("") && isPrime(Long.parseLong(s))) answer++;

        return answer;
    }
    //소수인지 확인.
    static private boolean isPrime(Long n){
        
        if(n==1) return false; //1은 소수 아님.
        
        boolean b = true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                b=false; break;
            }
        }
        return b;
    }
    //진수 변환 (10진수 -> k진수)
    static private String changeNum(int n, int k){
        
        String num="";
        while(n>0){
            num = n%k+num;
            n/=k;
        }
        return num;
    }
}