package Math;

public class Lv2_숫자카드나누기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        //A가 가진 숫자들을 모두 나눌 수 있는 수
        int a=arrayGCD(arrayA);//arrayA의 최대공약수
        
        if(a!=1 && !canDivide(a,arrayB)) answer=a; // a로 B의 모든 숫자를 나눌 수 없는지 확인
        
        //B가 가진 숫자들을 모두 나눌 수 있는 수
        int b = arrayGCD(arrayB);//arrayB의 최대 공약수
        
        if(b!=1 && !canDivide(b,arrayA)) answer=Math.max(answer,b);
        
        return answer;
    }
    //배열의 최대공약수 구하기
    int arrayGCD(int[] arr){
        if(arr.length==1) return arr[0];
        
        int g=gcd(arr[0],arr[1]);
        
        for(int i=2;i<arr.length;i++){
            g=gcd(g,arr[i]);
        }
        return g;
    }
    //최대공약수 구하기
    int gcd(int a, int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    //arr의 숫자 하나라도 d로 나눠지는지 확인
    boolean canDivide(int d, int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%d==0) return true;
        }
        return false;
    }
}
