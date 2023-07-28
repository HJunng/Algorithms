package Math;

import java.util.*;
public class Lv2_시소짝꿍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long solution(int[] weights) {
        long answer = 0;
        Set<Long> set = new HashSet<>();
        
        Arrays.sort(weights);
        //2:2 2:4 2:3 3:4
        //1:1 1:2 1:1.5 1:4/3
        for(int i=weights.length-1;i>=0;i--){
            
            long w=weights[i];
            
            if(set.contains(w)) answer++;
            if(set.contains(w*2)) answer++;
            if(set.contains(w*3/2)) answer++;
            if(set.contains(w*4/3)) answer++;
            
            //System.out.println(weights[i]+" "+set+" : "+answer);
            
            set.add(w);
        }
        
        // for(int i=0;i<weights.length;i++){
        //     for(int j=i+1;j<weights.length;j++){
        //         if(checkWeight(weights[i],weights[j])) answer++;
        //     }
        // }
        
        return answer;
    }
    //시소 평형을 만들 수 있는지 확인
    boolean checkWeight(int a, int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        
        if(a==b || a==b*2 || a*2==b*3 || a*3==b*4) return true;
        else return false;
    }
}
