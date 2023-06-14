package Math;

public class Lv2_N개의최소공배수 {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {2,6,8,14}));
		
	}
	static public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=0;i<arr.length;i++){
            answer=lcm(answer,arr[i]);
        }
        
        return answer;
    }
    //최소공배수 Least Common Multiple
    static int lcm(int a, int b){
        return a*b /gcd(a,b);
    }
    //최대공약수 Greatest Common Divisor
    static int gcd(int a, int b){
        //유클리드 호제법
        if(a%b==0)
            return b;
        
        return gcd(b,a%b);
    }
}
