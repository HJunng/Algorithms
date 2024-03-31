class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int max,maxIdx;
        int outLength=number.length()-k;
       while(k>0 && answer.length()!=outLength){
            max=0;
            maxIdx=0;
            
           int n = number.length()-outLength+answer.length();
            for(int i=0;i<=n;i++){
                if(number.charAt(i)-'0'>max){
                    max=number.charAt(i)-'0';
                    maxIdx=i;
                }
            }
            answer+=number.charAt(maxIdx);
            number=number.substring(maxIdx+1);
            k-=maxIdx;
           
            //System.out.println(n+" "+answer+" "+number+" "+k);
        }
        
        //끝까지 검사하면 남는 문자열 answer에 합치기
            if(k==0)
            	answer+=number;
        return answer;
    }
}