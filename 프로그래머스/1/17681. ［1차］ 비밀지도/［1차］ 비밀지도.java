class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String [n];
        
        for(int i=0;i<n;i++){
            
            String str="";
            int num1 = arr1[i];
            int num2 = arr2[i];
            
            for(int j=0;j<n;j++){
                if(num1%2==1 || num2%2==1) str = "#"+str;
                else str = " "+str;
                
                num1 /= 2;
                num2 /= 2;
            }
            answer[i] = str;
            System.out.println(str);
        }
        
        return answer;
    }
}