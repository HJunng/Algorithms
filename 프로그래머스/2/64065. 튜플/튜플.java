import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.substring(2,s.length()-2);
        
        String[] temp = s.split("\\},\\{"); // },{
        String[][] tuple = new String[temp.length][];
        for(int i=0;i<temp.length;i++){
            tuple[i] = temp[i].split(",");
        }
        
        Arrays.sort(tuple, new Comparator<String[]>(){
            public int compare(String[] a, String[] b){
                return Integer.compare(a.length,b.length);
            }
        });
        
        // Comparator<String> comparator = Comparator.comparingInt(String::length);
        // Arrays.sort(array, comparator);
        
        answer = new int[tuple.length];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<tuple.length;i++){
            for(int j=0;j<tuple[i].length;j++){
                int num = Integer.parseInt(tuple[i][j]);
                if(!set.contains(num)){
                    answer[i] = num;
                    set.add(num);
                }
            }
        }
        
        
        // System.out.println(Arrays.toString(tuple));
        // System.out.println(tuple[0]);
        
        return answer;
    }
}