package Lv_2;

public class Lv2_점프와순간이동 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int n) {
        int ans = 0;

        while(n>0){
            //2로 나눌 수 있는 한 끝까지 나누기.
            if(n%2==0)
                n/=2;
            else{
                n--;
                ans++;
            }
        }
        return ans;
    }
}
