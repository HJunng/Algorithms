package Array;

import java.util.*;
public class Lv2_파일명정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String[] solution(String[] files) {
        String[] answer = {};
        
        /* files를 HEAD, NUMBER, TAIL 부분으로 나눈다 */
        String[][] files_split = new String[files.length][3];// HEAD, NUMBER, TAIL   
        for(int i=0;i<files.length;i++){
            
            int numIdx=-1;
            int tailIdx=-1;
            for(int j=0;j<files[i].length();j++){
                //숫자가 처음 나타나는 인덱스 찾기
                if(files[i].charAt(j)>='0' && files[i].charAt(j)<='9' && numIdx==-1){
                    numIdx=j;
                }
                //숫자 인덱스를 찾은 후, tail 처음 시작 인덱스 찾기
                if(numIdx>-1 && (files[i].charAt(j)<'0' || files[i].charAt(j)>'9')){
                    tailIdx=j;break;
                }
            }
            
            // HEAD, NUMBER, TAIL로 나눈다
            files_split[i][0]=files[i].substring(0,numIdx);// HEAD
            
            if(tailIdx==-1) files_split[i][1]=files[i].substring(numIdx,files[i].length()); //NUMBER
            else files_split[i][1]=files[i].substring(numIdx,tailIdx);
            
            if(tailIdx!=-1) files_split[i][2]=files[i].substring(tailIdx,files[i].length());
            
            //System.out.println(files_split[i][0]+" "+files_split[i][1]+" "+files_split[i][2]);
        }
        //배열 정렬
        Arrays.sort(files_split, new Comparator<String[]>(){
            public int compare(String[] a, String[] b){
                if(!a[0].equalsIgnoreCase(b[0])){//대소문자 상관없이 비교
                    return a[0].compareToIgnoreCase(b[0]);
                    
                }else
                    return Integer.parseInt(a[1])-Integer.parseInt(b[1]);     
            }
        });
        
        answer = new String[files.length];
        for(int i=0;i<files.length;i++){
            if(files_split[i][2]==null)
                answer[i]=files_split[i][0] + files_split[i][1];
            else
                answer[i]= files_split[i][0] + files_split[i][1] + files_split[i][2];
        }
        
        return answer;
    }
}
