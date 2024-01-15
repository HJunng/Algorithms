class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = baseConversion(n,k);
        System.out.println(num);
        
        String[] sp = num.split("0");
        
        for(int i=0;i<sp.length;i++){
            if(sp[i].length()==0) continue;
            if(isPrime(Long.parseLong(sp[i]))) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n==1) return false; // 1은 소수아님.
        
        for(long i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true; 
    }
    
    public String baseConversion(int n, int k){
        String num="";
        
        while(n>0){
            num = n%k + num;
            n/=k;
        }
        
        return num;
    }
}