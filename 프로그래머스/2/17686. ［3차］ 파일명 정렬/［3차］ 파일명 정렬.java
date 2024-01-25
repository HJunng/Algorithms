import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        String[][] fileSplit = new String[files.length][3];
        
        for(int i=0;i<files.length;i++){
            
            String file = files[i];
            
            int idx=0;
            String head="",number="",tail = "";
            
            while(idx<file.length() && (file.charAt(idx)<'0' || file.charAt(idx)>'9')){
                head+=""+file.charAt(idx++);
            }
            
            while(idx<file.length() && (file.charAt(idx)>='0' && file.charAt(idx)<='9')){
                number+=file.charAt(idx++);
            }
            
            tail = file.substring(idx);
            
            //System.out.println(head+" "+number+" "+tail);
            
            fileSplit[i][0]=head;
            fileSplit[i][1]=number;
            fileSplit[i][2]=tail;
        }
        
        Arrays.sort(fileSplit, new Comparator<String[]>(){
            @Override
            public int compare(String[] a, String[] b){
                
                String upA = a[0].toUpperCase();
                String upB = b[0].toUpperCase();
                
                if(!upA.equals(upB)) return upA.compareTo(upB);
                return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            }
        });
        
        for(int i=0;i<files.length;i++){
            answer[i] = fileSplit[i][0]+fileSplit[i][1]+fileSplit[i][2];
        }
        
        return answer;
    }
}